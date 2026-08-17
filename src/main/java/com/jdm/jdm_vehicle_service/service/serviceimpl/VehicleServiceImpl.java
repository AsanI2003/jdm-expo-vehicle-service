package com.jdm.jdm_vehicle_service.service.serviceimpl;

import com.jdm.jdm_vehicle_service.dto.VehicleDTO;
import com.jdm.jdm_vehicle_service.model.Vehicle;
import com.jdm.jdm_vehicle_service.repository.VehicleRepository;
import com.jdm.jdm_vehicle_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = Vehicle.builder()
                .name(vehicleDTO.getName())
                .imageFileName(vehicleDTO.getImageFileName())
                .status(vehicleDTO.getStatus())
                .build();

        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return mapToDTO(savedVehicle);
    }

    @Override
    public Page<VehicleDTO> getAllVehicles(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Vehicle> vehiclePage = vehicleRepository.findAll(pageable);
        return vehiclePage.map(this::mapToDTO);
    }

    private VehicleDTO mapToDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setName(vehicle.getName());
        dto.setImageFileName(vehicle.getImageFileName());
        dto.setStatus(vehicle.getStatus());
        return dto;
    }
}