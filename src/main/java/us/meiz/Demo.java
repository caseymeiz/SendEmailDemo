package us.meiz;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


/**
 * Created by casey on 6/9/17.
 */
public class Demo {
    public static void main(String[] args) throws EmailException{
        String fromEmail = "from@gmail.com";
        String fromPassword = "fromPassword";

        String toEmail = "to@gmail.com";
        String subject = "The Subject";
        String message = "The message";


        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail,fromPassword);
            }
        };

        email.setAuthenticator(auth);
        email.setSSLOnConnect(true);
        email.setFrom(fromEmail);
        email.setSubject(subject);
        email.setMsg(message);
        email.addTo(toEmail);
        email.send();
    }
}
