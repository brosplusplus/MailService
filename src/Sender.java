import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Sender {

	public void SendMail(String[] dest, String subj, String body) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "localhost");
		Session session = Session.getDefaultInstance(prop, null);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("borja@mongamonga.es"));
		for (String to : dest) {
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		}
		msg.setHeader("MIME-Version", "1.0");
		msg.setHeader("Content-type", "text/html; charset=iso-8859-1");
		msg.setHeader("From", "Bros++ <borja@mongamonga.es>");
		msg.setHeader("Reply-To:", "borja.arias.upc@gmail.com");
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
			String dests[] = {"alaxmo13@gmail.com","borja.arias.upc@gmail.com"};
			s.SendMail(dests, "WASAAAABI", "Hola puta, que tal et sembla això?");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
