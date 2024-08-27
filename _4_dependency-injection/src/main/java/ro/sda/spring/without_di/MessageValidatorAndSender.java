package ro.sda.spring.without_di;

public class MessageValidatorAndSender {

    private EmailService emailService = new EmailService();

    public void processMessage(String msg, String receiver){
        String msgToSend = msg.toUpperCase();
        // do some msg validation, manipulation logic
        this.emailService.sendEmail(msgToSend, receiver);
    }

}
