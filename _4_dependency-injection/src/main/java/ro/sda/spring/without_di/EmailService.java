package ro.sda.spring.without_di;

public class EmailService {

    public void sendEmail(String message, String receiverAddress) {
        // logic to send email
        System.out.println("Email sent to: " + receiverAddress + " with message: " + message);
    }
}
