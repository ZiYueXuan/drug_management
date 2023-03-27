package com.xjtuse.drug_management.controller;

import com.xjtuse.drug_management.domain.pojo.Controller;
import com.xjtuse.drug_management.domain.pojo.Inspector;
import com.xjtuse.drug_management.domain.pojo.Manager;
import com.xjtuse.drug_management.domain.pojo.Researcher;
import com.xjtuse.drug_management.domain.vo.LoginVo;
import com.xjtuse.drug_management.domain.vo.MessageVo;
import com.xjtuse.drug_management.service.ControllerService;
import com.xjtuse.drug_management.service.InspectorService;
import com.xjtuse.drug_management.service.ManagerService;
import com.xjtuse.drug_management.service.ResearcherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class LoginController {
    private MessageVo messageVo;

    @Resource
    private ManagerService managerService;
    @Resource
    private ResearcherService researcherService;
    @Resource
    private InspectorService inspectorService;
    @Resource
    private ControllerService controllerService;

    @PostMapping("/login")
    public MessageVo login(@RequestBody LoginVo loginVo) {
        int identity = loginVo.getIdentity();
        int way = loginVo.getWay();
        String password = loginVo.getPassword();
        if (identity == 0) {//管理员
            if (way == 1) {//手机号登录
                String phone = loginVo.getPhone();
                Manager manager = managerService.getManagerByPhone(phone);
                if (manager != null) {
                    checkManager(password, manager);
                } else {
                    messageVo = new MessageVo(-1, "", "请先注册！！！");
                }
            } else if (way == 2) {//邮箱登录
                String mail = loginVo.getMail();
                Manager manager = managerService.getManagerByMail(mail);
                if (manager != null) {
                    checkManager(password, manager);
                } else {
                    messageVo = new MessageVo(-1, "", "请先注册！！！");
                }
            }
        } else if (identity == 1) {//研究员
            if (way == 1) {//手机号登录
                String phone = loginVo.getPhone();
                Researcher researcher = researcherService.getResearcherByPhone(phone);
                if (researcher != null) {
                    checkResearcher(password, researcher);
                } else {
                    messageVo = new MessageVo(-1, "", "请先注册！！！");
                }
            } else if (way == 2) {//邮箱登录
                String mail = loginVo.getMail();
                Researcher researcher = researcherService.getResearcherByMail(mail);
                if (researcher != null) {
                    checkResearcher(password, researcher);
                } else {
                    messageVo = new MessageVo(-1, "", "请先注册！！！");
                }
            }
        } else if (identity == 2) {//监察员
            if (way == 1) {//手机号登录
                String phone = loginVo.getPhone();
                Inspector inspector = inspectorService.getInspectorByPhone(phone);
                if (inspector != null) {
                    checkInspector(password, inspector);
                } else {
                    messageVo = new MessageVo(-1, "", "请先注册！！！");
                }
            } else if (way == 2) {//邮箱登录
                String mail = loginVo.getMail();
                Inspector inspector = inspectorService.getInspectorByMail(mail);
                if (inspector != null) {
                    checkInspector(password, inspector);
                } else {
                    messageVo = new MessageVo(-1, "", "请先注册！！！");
                }
            }
        } else if (identity == 3) {//质控员
            if (way == 1) {//手机号登录
                String phone = loginVo.getPhone();
                Controller controller = controllerService.getControllerByPhone(phone);
                if (controller != null) {
                    checkController(password, controller);
                } else {
                    messageVo = new MessageVo(-1, "", "请先注册！！！");
                }
            } else if (way == 2) {//邮箱登录
                String mail = loginVo.getMail();
                Controller controller = controllerService.getControllerByMail(mail);
                if (controller != null) {
                    checkController(password, controller);
                } else {
                    messageVo = new MessageVo(-1, "", "请先注册！！！");
                }
            }
        } else {
            messageVo = new MessageVo(0, "", "未知错误");
        }
        return messageVo;
    }

    private void checkManager(String password, Manager manager) {
        if (manager.getPassword().equals(password)) {
            messageVo = new MessageVo(manager.getId(), manager.getName(), "登录成功！");
        } else {
            messageVo = new MessageVo(0, "", "用户名或密码错误");
        }
    }

    private void checkResearcher(String password, Researcher researcher) {
        if (researcher.getPassword().equals(password)) {
            messageVo = new MessageVo(researcher.getId(), researcher.getName(), "登录成功！");
        } else {
            messageVo = new MessageVo(0, "", "用户名或密码错误!!!");
        }
    }

    private void checkInspector(String password, Inspector inspector) {
        if (inspector.getPassword().equals(password)) {
            messageVo = new MessageVo(inspector.getId(), inspector.getName(), "登录成功！");
        } else {
            messageVo = new MessageVo(0, "", "用户名或密码错误!!!");
        }
    }

    private void checkController(String password, Controller controller) {
        if (controller.getPassword().equals(password)) {
            messageVo = new MessageVo(controller.getId(), controller.getName(), "登录成功！");
        } else {
            messageVo = new MessageVo(0, "", "用户名或密码错误!!!");
        }
    }
}
