package com.xjtuse.drug_management.controller;

import com.apistd.uni.Uni;
import com.apistd.uni.UniException;
import com.apistd.uni.UniResponse;
import com.apistd.uni.sms.UniMessage;
import com.apistd.uni.sms.UniSMS;
import com.xjtuse.drug_management.domain.pojo.Controller;
import com.xjtuse.drug_management.domain.pojo.Inspector;
import com.xjtuse.drug_management.domain.pojo.Researcher;
import com.xjtuse.drug_management.domain.vo.RegisterVO;
import com.xjtuse.drug_management.service.ControllerService;
import com.xjtuse.drug_management.service.InspectorService;
import com.xjtuse.drug_management.service.ResearcherService;
import com.xjtuse.drug_management.utils.RandomUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Resource
    private ResearcherService researcherService;
    @Resource
    private InspectorService inspectorService;
    @Resource
    private ControllerService controllerService;

    private int verificationCode;
    private static final String ACCESS_KEY_ID = "n1Zds8vmKzaEq9uKhJ6LswPr5HFjJ6EvA6zCExriifpU6HVNJ";
    private static final String ACCESS_KEY_SECRET = "Nd2XGQeTdJ8fky5eVw9gJbKKrXLtoW";

    //手机验证码
    @PostMapping("/phone/verificationCode")
    public int getPhoneVerificationCode(@RequestParam String phone) {
        Uni.init(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        Map<String, String> data = new HashMap<>();
        String code = RandomUtil.getSixRandom();
        verificationCode = Integer.parseInt(code);
        data.put("code", code);
        data.put("ttl", "5");
        UniMessage message = UniSMS.buildMessage()
                .setTo(phone)
                .setSignature("李少龙测试")
                .setTemplateId("pub_verif_ttl3")
                .setTemplateData(data);
        try {
            UniResponse response = message.send();
            System.out.println(response);
        } catch (UniException exception) {
            System.out.println("Error: " + exception);
            System.out.println("RequestId: " + exception.requestId);
        }
        return verificationCode;
    }

    //邮箱验证码
    @PostMapping("/mail/verificationCode")
    public String getMailVerificationCode(@RequestParam String mail) {
        String from_email = "671342610@qq.com";
        String authorizationCode = "gfkjuwihnfvhbbbf";
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");     //使用SMTP的邮件传输协议
        properties.setProperty("mail.smtp.host", "smtp.qq.com");       //主机地址
        properties.setProperty("mail.smtp.auth", "true");      //授权通过
        Session session = Session.getInstance(properties);     //通过我们的这些配置，得到一个会话程序
        String code = RandomUtil.getVerificationCode();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from_email)); //设置发件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mail, "用户", "utf-8"));      //设置收件人
            message.setSubject("智能药物管理系统注册验证码", "utf-8");      //设置主题
            message.setSentDate(new Date());
            Multipart multipart = new MimeMultipart();  //新建一个MimeMultipart对象来存放多个BodyPart对象
            BodyPart bodyPart = new MimeBodyPart();  //新建一个存放信件内容的BodyPart对象
            bodyPart.setContent(code, "text/html;charset=utf-8");
            multipart.addBodyPart(bodyPart);  //将含有信件内容的BodyPart加入到MimeMultipart对象中
            message.setContent(multipart); //把mul作为消息内容
            message.saveChanges();
            //创建一个传输对象
            Transport transport = session.getTransport("smtp");
            //建立与服务器的链接  465 端口是 SSL传输
            transport.connect("smtp.qq.com", 587, from_email, authorizationCode);
            //发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            //关闭邮件传输
            transport.close();
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return code;
    }

    @PostMapping("/register")
    public String register(RegisterVO registerVo) {
        String result = "注册成功！";
        String code = registerVo.getVerificationCode();
        int identity = registerVo.getIdentity();
        if (Integer.parseInt(code) != verificationCode) {
            result = "验证码错误！";
        } else {
            if (identity == 1) {// 研究员
                if (!registerVo.getPhone().equals("")) { // 通过手机号注册
                    String phone = registerVo.getPhone();
                    if (researcherService.getResearcherByPhone(phone) == null) {
                        String name = registerVo.getName();
                        String password = registerVo.getPassword();
                        Researcher researcher = new Researcher(1, name, password, phone, "");
                        researcherService.insert(researcher);
                    } else {
                        result = "您已注册，请登录！";
                    }
                }
                if (!registerVo.getMail().equals("")) { // 通过邮箱注册
                    String mail = registerVo.getMail();
                    if (researcherService.getResearcherByMail(mail) == null) {
                        String name = registerVo.getName();
                        String password = registerVo.getPassword();
                        Researcher researcher = new Researcher(1, name, password, "", mail);
                        researcherService.insert(researcher);
                    } else {
                        result = "您已注册，请登录！";
                    }
                }
            } else if (identity == 2) {// 监察员
                if (!registerVo.getPhone().equals("")) { // 通过手机号注册
                    String phone = registerVo.getPhone();
                    if (inspectorService.getInspectorByPhone(phone) == null) {
                        String name = registerVo.getName();
                        String password = registerVo.getPassword();
                        Inspector inspector = new Inspector(1, name, password, phone, "");
                        inspectorService.insert(inspector);
                    } else {
                        result = "您已注册，请登录！";
                    }
                }
                if (!registerVo.getMail().equals("")) { // 通过邮箱注册
                    String mail = registerVo.getMail();
                    if (inspectorService.getInspectorByMail(mail) == null) {
                        String name = registerVo.getName();
                        String password = registerVo.getPassword();
                        Inspector inspector = new Inspector(1, name, password, "", mail);
                        inspectorService.insert(inspector);
                    } else {
                        result = "您已注册，请登录！";
                    }
                }
            } else if (identity == 3) {// 质控员
                if (!registerVo.getPhone().equals("")) { // 通过手机号注册
                    String phone = registerVo.getPhone();
                    if (controllerService.getControllerByPhone(phone) == null) {
                        String name = registerVo.getName();
                        String password = registerVo.getPassword();
                        Controller controller = new Controller(1, name, password, phone, "");
                        controllerService.insert(controller);
                    } else {
                        result = "您已注册，请登录！";
                    }
                }
                if (!registerVo.getMail().equals("")) { // 通过邮箱注册
                    String mail = registerVo.getMail();
                    if (controllerService.getControllerByMail(mail) == null) {
                        String name = registerVo.getName();
                        String password = registerVo.getPassword();
                        Controller controller = new Controller(1, name, password, "", mail);
                        controllerService.insert(controller);
                    } else {
                        result = "您已注册，请登录！";
                    }
                }
            }
        }
        return result;
    }
}
