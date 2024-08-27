package ro.sda.spring.with_di;

public class EmailServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        MessageService emailService = new EmailServiceImpl();
        return new MessageValidatorAndSender(emailService);
    }
}
