package ro.sda.spring.with_di;

public class Main {

    public static void main(String[] args) {

        MessageServiceInjector injector = null;
        Consumer validator = null;


        // email
        // this injector is the class RESPONSIBLE for the creation (initialization) of a service that sends emails
        // as well as the INJECTION of that class into a consumer (validator of the email message) which uses
        // the service and sends the message
        injector = new EmailServiceInjector();
        validator = injector.getConsumer();
        validator.processMessage("ALERT", "Catalin@abc.com");

        injector = new SmsServiceInjector();
        validator = injector.getConsumer();
        validator.processMessage("ALERT", "Catalin@abc.com");

    }
}
