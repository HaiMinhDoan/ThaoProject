package com.devthao.animecenter.services;

import com.devthao.animecenter.exception.FailureActionException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface VideoService {
    ResponseEntity<InputStreamResource> getBytesVideo(Long id,String rangeHeader) throws FailureActionException, IOException;
}
