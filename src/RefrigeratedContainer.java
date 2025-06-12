class RefrigeratedContainer extends Container {
    private Product product;
    private double temperature;

    public RefrigeratedContainer(double height, double tareWeight, double depth, double maxPayload,
                                 Product product, double temperature) throws IllegalArgumentException {
        super(height, tareWeight, depth, maxPayload, "C");
        if (temperature > product.getRequiredTemp()) {
            throw new IllegalArgumentException("Temperature too high for " + product.getName());
        }
        this.product = product;
        this.temperature = temperature;
    }

    public void loadCargo(double mass) throws OverfillException {
        double maxAllowed = maxPayload * 0.9;
        if (mass > maxAllowed) {
            throw new OverfillException("Cannot load " + mass + "kg. Maximum allowed: " + maxAllowed + "kg");
        }
        this.cargoMass = mass;
    }

    public void emptyCargo() {
        this.cargoMass = 0;
    }

    public String toString() {
        return super.toString() + " [Refrigerated - " + product.getName() + " at " + temperature + "°C]";
    }
}