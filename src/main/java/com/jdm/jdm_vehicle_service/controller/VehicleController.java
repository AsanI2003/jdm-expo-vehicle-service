package com.jdm.jdm_vehicle_service.controller;

import com.jdm.jdm_vehicle_service.client.MediaServiceClient;
import com.jdm.jdm_vehicle_service.dto.VehicleDTO;
import com.jdm.jdm_vehicle_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    private final MediaServiceClient mediaServiceClient;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VehicleDTO> createVehicle(@RequestPart("vehicle") VehicleDTO vehicleDTO,
    @RequestPart("image") MultipartFile image
    ) {
        ResponseEntity<Map<String, String>> imageResponse = mediaServiceClient.uploadImage(image);
        String savedFilename = imageResponse.getBody().get("filename");
        vehicleDTO.setImageFileName(savedFilename);
        VehicleDTO response = vehicleService.createVehicle(vehicleDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<VehicleDTO>> getAllVehicles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<VehicleDTO> vehicles = vehicleService.getAllVehicles(page, size);
        return ResponseEntity.ok(vehicles);
    }
}