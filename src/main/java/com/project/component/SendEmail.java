package com.project.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {
	@Autowired
	private JavaMailSender mailSender;
	
	private String from;
	private String to;
	private String subject;
	private String content;
	
	public SendEmail() {}
	
	public SendEmail(String from, String to, String subject, String content) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}
	
	public void sendEmail(String from, String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);
	}
	
	public void sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(this.from);
		message.setTo(this.to);
		message.setSubject(this.subject);
		message.setText(this.content);
		mailSender.send(message);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
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
}
