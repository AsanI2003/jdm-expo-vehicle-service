package com.jdm.jdm_vehicle_service.service;

import com.jdm.jdm_vehicle_service.dto.VehicleDTO;
import org.springframework.data.domain.Page;

public interface VehicleService {
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);
    Page<VehicleDTO> getAllVehicles(int page, int size);
}