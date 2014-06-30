/**
 * Created by IntelliJ IDEA.
 * User: xxx
 * Date: Jun 15, 2003
 * Time: 2:20:48 PM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb.util;

import javax.servlet.jsp.*;
import javax.naming.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Email {
    public Email(String from, String to, String subject) throws Exception {
        this.to = to;
        this.from = from;
        this.subject = subject;

        if(this.sessionLocation != null) {
          try{
            InitialContext context = new InitialContext();
            //get the mail session
            session = (Session)context.lookup(sessionLocation);
          }catch(NamingException ne){
            throw new JspException(ne.getMessage());
          }
        }
        else session = Session.getDefaultInstance(new Properties(), null);

        message  = new MimeMessage(session);
    }

    public Email() throws Exception {
        this("","","");
    }

    public void SendMail() throws Exception {
        try{
          message.setFrom(new InternetAddress(from));
          message.setSubject(subject);
          message.setContent(getContent(),mimeType);
          StringTokenizer st  =  new java.util.StringTokenizer(to,",");
          while (st.hasMoreTokens()) {
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(st.nextToken()));
          }
          if(cc != null){
            st  =  new java.util.StringTokenizer(cc,",");
            while (st.hasMoreTokens()) {
              message.addRecipient(Message.RecipientType.CC,new InternetAddress(st.nextToken()));
            }
          }

          if(bcc != null){
            st  =  new java.util.StringTokenizer(bcc,",");
            while (st.hasMoreTokens()) {
              message.addRecipient(Message.RecipientType.BCC,new InternetAddress(st.nextToken()));
            }
          }
          Transport.send(message);
        }catch(AddressException ae){
          throw new JspException(ae.getMessage());
        }catch(MessagingException me){
          throw new JspException(me.getMessage());
        }
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getSessionLocation() {
        return sessionLocation;
    }

    public void setSessionLocation(String sessionLocation) {
        this.sessionLocation = sessionLocation;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String mimeType = "text/plain";
    private String sessionLocation;
    private Session session = null;
    private Message message = null;
    private String to = null;
    private String cc = null;
    private String bcc = null;
    private String from = null;
    private String subject = null;
    private String content = null;
}
