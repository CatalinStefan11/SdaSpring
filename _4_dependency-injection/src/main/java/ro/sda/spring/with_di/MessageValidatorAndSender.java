package ro.sda.spring.with_di;

public class MessageValidatorAndSender implements Consumer {

    private MessageService service;

    public MessageValidatorAndSender(MessageService service) {
        this.service = service;
    }

    @Override
    public void processMessage(String msg, String receiver) {
        String msgToSend = msg.toUpperCase();
        // do some msg validation, manipulation logic
        this.service.sendMessage(msgToSend, receiver);
    }
}


