package emailexample;

import com.integpg.system.JANOS;
import com.integpg.system.MailComposer;

public class EmailExample {

    public static MailComposer mail = new MailComposer();
    
    public static void main(String[] args) {
        
        JANOS.sendMail("Tony", "EmailExample", "This was built and sent from the JANOS class.");
        
        mail.setToAddress("apavia@integpg.com");
        mail.setSubject("MailComposer Test");
        mail.setMessage("This was built and sent using the MailComposer Class.");
        mail.send();
        
    }
    
}
