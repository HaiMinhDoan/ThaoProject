package com.devthao.animecenter.services;

import com.devthao.animecenter.models.entities.AuthenEntity;
import com.devthao.animecenter.models.entities.User;
import com.devthao.animecenter.models.request.LoginRequest;
import com.devthao.animecenter.models.request.RegisterRequest;

public interface UserService {
    void registerUser(RegisterRequest registerRequest);
    AuthenEntity loginUser(LoginRequest loginRequest);
    boolean checkValidAthenEntity(AuthenEntity authenEntity);
    User getUserById(Long id);
}
