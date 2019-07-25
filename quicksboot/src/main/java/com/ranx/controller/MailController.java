package com.ranx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author ranx
 * @create 2018-08-10 10:41
 **/
@RestController
public class MailController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${mail.fromMail.sender}")
    private String sender;
    @Value("${mail.fromMail.receiver}")
    private String receiver;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送文本邮件
     * @return
     */
    @RequestMapping("/sendTxtMail")
    public String sendTxtMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject("Dear,");
        message.setText("Nice to meet you!");
        try {
            javaMailSender.send(message);
            log.info("简单邮件已发送。");
        } catch (MailException e) {
            log.error("发送简单邮件时发生异常！", e);
            return "error";
        }
        return "success";
    }

    /**
     * 发送html邮件
     * @return
     */
    @RequestMapping("/sendHtmlMail")
    public String sendHtmlMail() {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("html mail");
            helper.setText(content, true);

            javaMailSender.send(message);
            log.info("html邮件已发送。");
        } catch (MessagingException e) {
            log.error("发送html邮件时发生异常！", e);
            return "error";
        }
        return "success";
    }

    /**
     * 发送附件邮件
     * @return
     */
    @RequestMapping("sendFilesMail")
    public String sendFilesMail() {
        String filePath = "E:\\file\\file.txt";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, null);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("附件 mail");
            helper.setText("这是一封带附件的邮件", true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            javaMailSender.send(message);
            log.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送带附件邮件时发生异常！", e);
            return "error";
        }
        return "success";
    }


    public String sendInlineResourceMail() {
        String Id = "1234567890";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + Id + "\' ></body></html>";
        String imgPath = "E:\\file\\file.png";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("这是有图片的邮件");
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(imgPath));
            helper.addInline(Id, res);

            javaMailSender.send(message);
            log.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            log.error("发送嵌入静态资源的邮件时发生异常！", e);
            return "error";
        }
        return "success";
    }
}
