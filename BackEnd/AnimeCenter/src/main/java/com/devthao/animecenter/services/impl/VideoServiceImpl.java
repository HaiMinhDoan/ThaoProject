package com.devthao.animecenter.services.impl;

import com.devthao.animecenter.exception.FailureActionException;
import com.devthao.animecenter.services.VideoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class VideoServiceImpl implements VideoService {

    @Value("${video.storage.path}")
    private String VIDEO_FOLDER;
    @Override
    public ResponseEntity<InputStreamResource> getBytesVideo(Long id,String rangeHeader) throws FailureActionException, IOException {
        String filename = "/video_"+id+".mp4";
        File videoFile = new File(VIDEO_FOLDER + filename);

        // Nếu không có Range header, trả về toàn bộ file
        if (rangeHeader == null) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + filename)
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .contentLength(videoFile.length())
                    .body(new InputStreamResource(new FileInputStream(videoFile)));
        }

        // Xử lý Range Requests
        long fileLength = videoFile.length();
        HttpRange range = HttpRange.parseRanges(rangeHeader).get(0);

        long start = range.getRangeStart(fileLength);
        long end = range.getRangeEnd(fileLength);

        long contentLength = end - start + 1;
        InputStream inputStream = new FileInputStream(videoFile);
        inputStream.skip(start);

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(contentLength))
                .header(HttpHeaders.CONTENT_RANGE, "bytes " + start + "-" + end + "/" + fileLength)
                .body(new InputStreamResource(inputStream));
    }
}
