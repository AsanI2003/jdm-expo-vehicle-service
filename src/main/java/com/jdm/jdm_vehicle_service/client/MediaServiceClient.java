package com.jdm.jdm_vehicle_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient(name = "jdm-expo-media-service")
public interface MediaServiceClient {

    @PostMapping(value = "/api/v1/media/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Map<String, String>> uploadImage(@RequestPart("image") MultipartFile file);

}
