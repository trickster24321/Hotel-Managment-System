package javaapplication;

class PayPalPayment implements PaymentMethod {
    public String processPayment() {
        return "Paid using PayPal";
    }
}