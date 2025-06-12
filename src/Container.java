abstract class Container {
    protected static int nextNumber = 1;
    protected String serialNumber;
    protected double cargoMass;
    protected double height;
    protected double tareWeight;
    protected double depth;
    protected double maxPayload;

    public Container(double height, double tareWeight, double depth, double maxPayload, String type) {
        this.serialNumber = "KON-" + type + "-" + nextNumber++;
        this.height = height;
        this.tareWeight = tareWeight;
        this.depth = depth;
        this.maxPayload = maxPayload;
        this.cargoMass = 0;
    }

    public abstract void loadCargo(double mass) throws OverfillException;
    public abstract void emptyCargo();

    public double getTotalWeight() {
        return tareWeight + cargoMass;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getCargoMass() {
        return cargoMass;
    }

    public double getMaxPayload() {
        return maxPayload;
    }

    public String toString() {
        return "Container " + serialNumber + " (Mass: " + cargoMass + "kg, Total Weight: " + getTotalWeight() + "kg)";
    }
}