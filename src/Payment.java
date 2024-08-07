import java.util.Date;

public class Payment {
    private String paymentId;
    private Booking booking;
    private double amount;
    private Date paymentDate;
    private String paymentMethod;

    public Payment(String paymentId, Booking booking, double amount, Date paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.booking = booking;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
