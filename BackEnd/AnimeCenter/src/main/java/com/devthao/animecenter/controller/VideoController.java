package com.devthao.animecenter.controller;

import com.devthao.animecenter.exception.FailureActionException;
import com.devthao.animecenter.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping("/stream/{id}")
    public ResponseEntity<?> stream(@PathVariable Long id,
                                    @RequestHeader(value = "Range", required = false) String rangeHeader) {
        try {
            return videoService.getBytesVideo(id,rangeHeader);
        } catch (Exception e) {
            FailureActionException failureActionException = new FailureActionException("Lỗi phát video");
            failureActionException.setData("video_"+id+"_"+rangeHeader);
            throw failureActionException;
        }
    }
}
