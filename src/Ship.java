class Ship {
    private double maxSpeed;
    private int maxContainerCount;
    private double maxWeight;
    private java.util.List<Container> containers;

    public Ship(double maxSpeed, int maxContainerCount, double maxWeight) {
        this.maxSpeed = maxSpeed;
        this.maxContainerCount = maxContainerCount;
        this.maxWeight = maxWeight;
        this.containers = new java.util.ArrayList<>();
    }

    public void loadContainer(Container container) throws IllegalStateException {
        if (containers.size() >= maxContainerCount) {
            throw new IllegalStateException("Ship at maximum container capacity");
        }

        double totalWeight = containers.stream().mapToDouble(Container::getTotalWeight).sum() + container.getTotalWeight();
        if (totalWeight > maxWeight * 1000) {
            throw new IllegalStateException("Ship would exceed maximum weight");
        }

        containers.add(container);
    }

    public void loadContainers(java.util.List<Container> containers) {
        for (Container container : containers) {
            loadContainer(container);
        }
    }

    public void removeContainer(String serialNumber) {
        containers.removeIf(c -> c.getSerialNumber().equals(serialNumber));
    }

    public void replaceContainer(String serialNumber, Container newContainer) {
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).getSerialNumber().equals(serialNumber)) {
                containers.set(i, newContainer);
                break;
            }
        }
    }

    public void transferContainer(Ship otherShip, String serialNumber) {
        Container container = containers.stream()
                .filter(c -> c.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElse(null);

        if (container != null) {
            removeContainer(serialNumber);
            otherShip.loadContainer(container);
        }
    }

    public void printShipInfo() {
        System.out.println("Ship Info:");
        System.out.println("Max Speed: " + maxSpeed + " knots");
        System.out.println("Max Containers: " + maxContainerCount);
        System.out.println("Max Weight: " + maxWeight + " tons");
        System.out.println("Current Containers: " + containers.size());
        System.out.printf("Current Weight: %.2f tons%n",
                containers.stream().mapToDouble(Container::getTotalWeight).sum() / 1000);
        System.out.println("Containers:");
        for (Container container : containers) {
            System.out.println("  " + container);
        }
    }
}