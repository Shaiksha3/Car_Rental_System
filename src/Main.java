public class Main {
        public static void main(String[] args) {
            CarRentalSystem rentalSystem = new CarRentalSystem();

            Vehicle vehicle1 = new Vehicle("V001", "Toyota", "Camry", 60.0);
            Vehicle vehicle2 = new Vehicle("V002", "Honda", "Accord", 70.0);
            Vehicle vehicle3 = new Vehicle("V003", "Mahindra", "Thar", 150.0);
            rentalSystem.addVehicle(vehicle1);
            rentalSystem.addVehicle(vehicle2);
            rentalSystem.addVehicle(vehicle3);

            rentalSystem.menu();
        }
}

