package ro.sda.spring.with_di;

public class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String receiver) {
        // logic to send email
        System.out.println("Email sent to: " + receiver + " with message: " + msg);
    }
}
