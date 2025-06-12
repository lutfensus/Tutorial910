class LiquidContainer extends Container implements IHazardNotifier {
    private boolean hazardous;

    public LiquidContainer(double height, double tareWeight, double depth, double maxPayload, boolean hazardous) {
        super(height, tareWeight, depth, maxPayload, "L");
        this.hazardous = hazardous;
    }

    public void loadCargo(double mass) throws OverfillException {
        double maxAllowed = hazardous ? maxPayload * 0.5 : maxPayload * 0.9;
        if (mass > maxAllowed) {
            if (hazardous) {
                notifyHazard("Attempted to overfill hazardous liquid container", serialNumber);
            }
            throw new OverfillException("Cannot load " + mass + "kg. Maximum allowed: " + maxAllowed + "kg");
        }
        this.cargoMass = mass;
    }

    public void emptyCargo() {
        this.cargoMass = 0;
    }

    public void notifyHazard(String message, String containerNumber) {
        System.out.println("HAZARD ALERT - Container " + containerNumber + ": " + message);
    }

    public String toString() {
        return super.toString() + " [Liquid" + (hazardous ? " - HAZARDOUS" : "") + "]";
    }
}