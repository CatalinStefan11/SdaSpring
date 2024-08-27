package ro.sda.spring.without_di;

public class Main {


    public static void main(String[] args) {

        MessageValidatorAndSender app = new MessageValidatorAndSender();
        app.processMessage("ALERT", "catalin@abc.com");

    }
}
