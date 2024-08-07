import java.util.Date;

public class Booking {
    private String bookingId;
    private Customer customer;
    private Vehicle vehicle;
    private Date startDate;
    private Date endDate;
    private double totalAmount;

    public Booking(String bookingId, Customer customer, Vehicle vehicle, Date startDate, Date endDate, double totalAmount) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = totalAmount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
