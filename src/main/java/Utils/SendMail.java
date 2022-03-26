///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Utils;
//
//import com.mysql.cj.Session;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
///**
// *
// * @author XuanQuy
// */
//public class SendMail {
//public static void send(String to, String sub,
//            String msg, final String user, final String pass) {
//        //create an instance of Properties Class   
//        Properties props = new Properties();
//
//        /* Specifies the IP address of your default mail server
//     	   for e.g if you are using gmail server as an email sever
//           you will pass smtp.gmail.com as value of mail.smtp host. 
//           As shown here in the code. 
//           Change accordingly, if your email id is not a gmail id
//         */
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        //below mentioned mail.smtp.port is optional
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//
//        /* Pass Properties object(props) and Authenticator object   
//           for authentication to Session instance 
//         */
//     Session session = Session.getInstance(props,
//          new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(user, pass);
//            }
//          });
//        
//        
//
//        try {
//
//            /* Create an instance of MimeMessage, 
// 	      it accept MIME types and headers 
//             */
//            MimeMessage message = new MimeMessage((MimeMessage) session);
//            message.setFrom(new InternetAddress(user));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject(sub);
//            message.setContent(msg, "text/html");
//
//            /* Transport class is used to deliver the message to the recipients */
//            Transport.send(message);
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//   
//}