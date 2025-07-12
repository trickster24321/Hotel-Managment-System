package javaapplication;

/**
*
* @author lahiru
*/
class CreditCardPayment implements PaymentMethod {
   public String processPayment() {
       return "Paid using Credit Card";
   }
}