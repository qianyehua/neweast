package com.skyjoo.neweast.biz.common.mail;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * �ʼ�������
 */
public class VelocityTemplateMailMessage {

    protected final Log    logger = LogFactory.getLog(getClass());

    private JavaMailSender javaMailSender;
    private VelocityEngine velocityEngine;
    private String         from;
    private String         title;
    private String         encoding;
    private String         templateLocation;
    private String[]       toEmails;
    private Map<String, Object>            model;

    public boolean send() {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);

        try {
            helper.setFrom(from);
            helper.setSubject(title);
            helper.setTo(toEmails);
            helper.setText(getMessage(), true); //������Ĳ���html����ȥ��true����
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            logger.error("�ʼ���Ϣ����! �ʼ�����Ϊ: " + title, e);
            return false;
            //e.printStackTrace();
        } catch (MailException me) {
            logger.error("�����ʼ�ʧ��! �ʼ�����Ϊ: " + title, me);
            return false;
        }
        return true;
    }

    /**
     * �ʼ�ģ���еõ���Ϣ
     * @return �����ط��͵�����
     */
    private String getMessage() {
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation,
            encoding, model);
    }

    private String[] createToEmail(String to) {
        return new String[] { to };
    }

    public void setToEmail(String to) {
        setToEmails(createToEmail(to));
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public void setTemplateLocation(String templateLocation) {
        this.templateLocation = templateLocation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setToEmails(String[] toEmails) {
        this.toEmails = toEmails;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTemplateLocation() {
        return templateLocation;
    }
}