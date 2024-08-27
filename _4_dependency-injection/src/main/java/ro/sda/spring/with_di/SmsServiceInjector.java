package ro.sda.spring.with_di;

public class SmsServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer(){
        return new MessageValidatorAndSender(new SmsServiceImpl());
    }
}
