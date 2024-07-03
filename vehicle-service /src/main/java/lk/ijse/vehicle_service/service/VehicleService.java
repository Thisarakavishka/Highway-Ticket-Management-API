package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.dto.VehicleDTO;

public interface VehicleService {
    boolean addVehicle(VehicleDTO vehicleDTO);

    boolean updateVehicle(VehicleDTO vehicleDTO);

    VehicleDTO getVehicle(String id);

}
