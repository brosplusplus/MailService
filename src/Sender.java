import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Sender {

	public void SendMail(String dest, String subj, String body) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		Session session = Session.getDefaultInstance(prop, null);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("borja@brosplusplus.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(dest));
		msg.setSubject(subj);
		msg.setText(body);
		Transport trans = session.getTransport("smtp");
		trans.connect();
		trans.send(msg);
		trans.close();
		System.out.println("Sended");
	}

	public static void main(String args[])
	{
		Sender s = new Sender();
		try {
			s.SendMail("borja.arias.upc@gmail.com", "prueba", "body de la prueba");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
