package models;

public enum VehicleType {
    LARGE(1),
    SMALL(2),
    MEDIUM(3),
    ELECTRIC(4),
    ;

    private int vehicleType;

    VehicleType(int i) {
        this.vehicleType = i;
    }
}
