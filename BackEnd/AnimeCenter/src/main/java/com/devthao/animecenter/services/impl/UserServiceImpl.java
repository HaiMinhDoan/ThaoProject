package com.devthao.animecenter.services.impl;

import com.devthao.animecenter.exception.FailureActionException;
import com.devthao.animecenter.models.entities.AuthenEntity;
import com.devthao.animecenter.models.entities.Token;
import com.devthao.animecenter.models.entities.User;
import com.devthao.animecenter.models.request.LoginRequest;
import com.devthao.animecenter.models.request.RegisterRequest;
import com.devthao.animecenter.repository.TokenRepository;
import com.devthao.animecenter.repository.UserRepository;
import com.devthao.animecenter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public void registerUser(RegisterRequest registerRequest) {
        // xử lý đăng kí người dùng
        User user = new User();
        boolean exist = userRepository.existsByEmail(registerRequest.getEmail());
        if (exist) {
            FailureActionException failureActionException = new FailureActionException("Email đã được sử dụng");
            failureActionException.setData(registerRequest.getEmail());
            throw failureActionException;
        }
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setUsername(registerRequest.getUsername());
        user.setAdmin(false);
        userRepository.save(user);
    }

    @Override
    public AuthenEntity loginUser(LoginRequest loginRequest) {
        //xử lý đăng nhập người dùng
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        if (user.isEmpty()) {
            FailureActionException failureActionException = new FailureActionException("Tài khoản không tồn tại");
            failureActionException.setData(loginRequest);
            throw failureActionException;
        }
        if (!user.get().getPassword().equals(loginRequest.getPassword())) {
            FailureActionException failureActionException = new FailureActionException("Mật khẩu sai");
            failureActionException.setData(loginRequest);
            throw failureActionException;
        }
        Optional<Token> optionalToken = tokenRepository.findByUserEmail(user.get().getEmail());
        Token token = new Token();
        // Khởi tạo ngày hiện tại
        Date now = new Date();
        token.setIssuedAt(now);
        token.setDeviceInfo(loginRequest.getDeviceInfo());
        if (optionalToken.isEmpty()) {
            token.setUser(user.get());
            token.setActive(true);
            // Tính toán ngày hết hạn là 30 ngày sau ngày hiện tại
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            calendar.add(Calendar.DATE, 30);
            Date expiresAt = calendar.getTime();
            token.setExpiresAt(expiresAt);

            token = tokenRepository.save(token);
        } else {
            token = optionalToken.get();
            if (!token.isActive()) {
                FailureActionException failureActionException = new FailureActionException("Tài khoản đã bị khóa");
                failureActionException.setData(loginRequest);
                throw failureActionException;
            }
            // Tính toán ngày hết hạn là 30 ngày sau ngày hiện tại
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            calendar.add(Calendar.DATE, 30);
            Date expiresAt = calendar.getTime();
            token.setExpiresAt(expiresAt);
            token = tokenRepository.save(token);
        }
        return AuthenEntity.builder()
                .userId(token.getUser().getId())
                .deviceInfo(token.getDeviceInfo())
                .isActive(token.isActive())
                .issuedAt(token.getIssuedAt())
                .expiresAt(token.getExpiresAt())
                .build();
    }

    @Override
    public boolean checkValidAthenEntity(AuthenEntity authenEntity) {
        if (authenEntity == null) return false;
        Optional<Token> optionalToken = tokenRepository.findByUserId(authenEntity.getUserId());
        if (optionalToken.isEmpty()) {
            System.err.println("ERROR:1");
            return false;
        }
        Token token = optionalToken.get();
        if (!token.isActive()) {
            System.err.println("ERROR:2");
            return false;
        }
        if (!token.getDeviceInfo().equals(authenEntity.getDeviceInfo())) {
            System.err.println("ERROR:3");
            return false;
        }
        if (token.getExpiresAt().before(new Date())) {
            System.err.println("ERROR:6");
            return false;
        }
        return true;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            FailureActionException failureActionException = new FailureActionException("Tài khoản đã bị xóa");
            failureActionException.setData(id);
            throw failureActionException;
        }
        return optionalUser.get();
    }
}
