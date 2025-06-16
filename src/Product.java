class Product {
    private final String name;
    private final double requiredTemp;

    public Product(String name, double requiredTemp) {
        this.name = name;
        this.requiredTemp = requiredTemp;
    }

    public String getName() {
        return name;
    }

    public double getRequiredTemp() {
        return requiredTemp;
    }
}