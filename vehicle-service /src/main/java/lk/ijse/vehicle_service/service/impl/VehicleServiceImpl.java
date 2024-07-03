package lk.ijse.vehicle_service.service.impl;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.exception.DuplicateException;
import lk.ijse.vehicle_service.exception.NotFoundException;
import lk.ijse.vehicle_service.repository.VehicleRepository;
import lk.ijse.vehicle_service.service.VehicleService;
import lk.ijse.vehicle_service.util.Convertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final Convertor convertor;

    @Override
    public boolean addVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepository.existsById(vehicleDTO.getVehicleId())) {
            vehicleRepository.save(convertor.toVehicle(vehicleDTO));
            return true;
        }
        throw new DuplicateException("Vehicle already exists");
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepository.existsById(vehicleDTO.getVehicleId())) {
            vehicleRepository.save(convertor.toVehicle(vehicleDTO));
            return true;
        }
        throw new NotFoundException("Vehicle does not exist");
    }

    @Override
    public VehicleDTO getVehicle(String id) {
        if (vehicleRepository.existsById(id)) {
            return convertor.toVehicleDTO(vehicleRepository.getReferenceById(id));
        }
        throw new NotFoundException("Vehicle does not exist");
    }
}
