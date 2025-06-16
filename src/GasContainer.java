class GasContainer extends Container implements IHazardNotifier {
    private double pressure;

    public GasContainer(double height, double tareWeight, double depth, double maxPayload, double pressure) {
        super(height, tareWeight, depth, maxPayload, "G");
        this.pressure = pressure;
    }

    public void loadCargo(double mass) throws OverfillException {
        double maxAllowed = maxPayload * 0.5;
        if (mass > maxAllowed) {
            notifyHazard("Attempted to overfill gas container", serialNumber);
            throw new OverfillException("Cannot load " + mass + "kg. Maximum allowed: " + maxAllowed + "kg");
        }
        this.cargoMass = mass;
    }

    public void emptyCargo() {
        this.cargoMass = this.cargoMass * 0.05;
    }

    public void notifyHazard(String message, String containerNumber) {
        System.out.println("HAZARD ALERT - Container " + containerNumber + ": " + message);
    }

    public String toString() {
        return super.toString() + " [Gas - Pressure: " + pressure + " atm]";
    }
}
