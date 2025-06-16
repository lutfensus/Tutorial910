public class Main {
    public static void main(String[] args) {
        try {
            Ship ship = new Ship(25.0, 100, 50000.0);

            LiquidContainer liquidContainer = new LiquidContainer(200, 2000, 300, 10000, false);
            GasContainer gasContainer = new GasContainer(250, 1500, 250, 8000, 15.0);
            RefrigeratedContainer refrigContainer = new RefrigeratedContainer(220, 2500, 280, 12000,
                    new Product("Bananas", -10), -5);

            liquidContainer.loadCargo(8000);
            gasContainer.loadCargo(3000);
            refrigContainer.loadCargo(9000);

            ship.loadContainer(liquidContainer);
            ship.loadContainer(gasContainer);
            ship.loadContainer(refrigContainer);

            ship.printShipInfo();

            gasContainer.emptyCargo();
            System.out.println("After emptying gas container: " + gasContainer.getCargoMass() + " kg remaining");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}