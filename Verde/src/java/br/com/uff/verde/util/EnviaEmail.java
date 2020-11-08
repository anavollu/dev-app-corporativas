package br.com.uff.verde.util;

import br.com.uff.verde.enumerate.StatusDenuncia;
import br.com.uff.verde.model.Denuncia;
import br.com.uff.verde.model.Doacoes;
import java.security.Security;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Felipe Vila Chã
 */
public class EnviaEmail {
    @Resource(lookup = "mail/Session")
    private Session session;
    
    private Denuncia denuncia = new Denuncia();
    private Doacoes doacoes = new Doacoes();
    
    public EnviaEmail(Denuncia denuncia){
        this.denuncia = denuncia;
    }
    
    public EnviaEmail(Doacoes doacoes){
        this.doacoes = doacoes;
    }
    
    public void denunciaCriada () {
        
        MimeMessage message = new MimeMessage(session);
        try {    
            message.setFrom(new InternetAddress(session.getProperty("mail.from")));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(denuncia.getUsuario().getEmail()));  
            message.setSubject("Denúncia - Fagulha");
            message.setText("Sua denúncia de código " + denuncia.getId() + 
                " foi realizada com sucesso. Daremos início a investigação e iremos lhe manter informado");
            Transport.send(message);
            } catch (Exception ex) {
                Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /*
    public void denunciaAtualizada () {
        
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "465");
        Session email = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
           }});
        String status = "";
        
        try {
            MimeMessage message = new MimeMessage(email);

            message.setFrom(new InternetAddress(remetente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(denuncia.getUsuario().getEmail()));

            message.setSubject("Denúncia - Fagulha");
            
            if (denuncia.getStatus().equals(StatusDenuncia.EM_ANALISE.getCodigo())){
                status = StatusDenuncia.EM_ANALISE.toString().replace("_", "");
            } else if (denuncia.getStatus().equals(StatusDenuncia.ENCAMINHADO.getCodigo())){
                status = StatusDenuncia.ENCAMINHADO.toString().concat(" AS AUTORIDADES");
            } else {
                status = StatusDenuncia.REJEITADO.toString();
            }
            message.setText("Sua denúncia de código " + denuncia.getId() + 
                " foi atualizada com sucesso, agora ela se encontra com status " + status + ". Enviaremos mais informações em breve.");

                Transport.send(message);
            } catch (MessagingException ex) {
                Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void doacaoRealizada () {
        
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.port", "8088");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "8088");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.quitwait", "false");
        Session email = Session.getInstance(properties, new javax.mail.Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(remetente, senha);
           }});

        try {
            MimeMessage message = new MimeMessage(email);

            message.setFrom(new InternetAddress(remetente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(doacoes.getUsuario().getEmail()));

            message.setSubject("Doação - Fagulha");
                message.setText("Sua doação de valor " + doacoes.getValor()
                   + " foi realizada com sucesso. Obrigado por contribuir com esperança pra muitos!");

            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}