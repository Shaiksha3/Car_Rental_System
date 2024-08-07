public class Vehicle {
    private String registrationNumber;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean isAvailable;

    public Vehicle(String registrationNumber, String brand, String model, double pricePerDay) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int rentalDays) {
        return pricePerDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnVehicle() {
        isAvailable = true;
    }
}
