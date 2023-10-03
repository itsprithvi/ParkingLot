package dto;

import models.VehicleType;

public class GenerateTicketRequestDto {
    private Long gateId;
    private String vehicleNumber;
    private VehicleType vehicleType;

    public GenerateTicketRequestDto(Long gateId, String vehicleNumber, VehicleType vehicleType) {
        this.gateId = gateId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
