# 基于药物重定位的智能药物管理系统

## 项目简介

药物重定位是传统药物发现的辅助过程,已引起学术界和制药公司的广泛关注。药物重定位,也称为“药物再利用或药物再循环”,是通过鉴定已知药物的新治疗应用来克服发现和开发新药的障碍，是药物研发过程中的重要环节。

药物重定位发展与管理正日趋走向规范化，相应的管理软件系统也在不断发展和更新。多数国家已经将信息化管理系统应用到临床试验的实施过程中，这类系统解决了药物临床试验数据的收集、录入、核查、整理等需要耗费大量人力、物力和时间的问题，同时，保证了试验数据的真实性、准确性和完整性。

智能药物管理系统能够实现试验药物的建库、入库、药物发放与回收、盘点与查询、有效期管理、退回与资料归档的基本管理，以及研究记录、研究流程管理、药物蛋白跟踪、药物重定位检测、药物再利用统计、药物重定位次数等智能化管理，并且保证临床试验药物管理的规范化和数据的安全性。

智能药物管理系统系统针对不同用户（药物管理员、质控员、研究者、监查员）的使用需求，划分不同的角色，配置相应的使模块和功能，授予不同的访问权限，根据试验药物管理流程规划系统的流程，使其满足设计的目的和任务，配置各类试验研究，并且要符合医院药事相关管理法规和制度的要求。

## 项目栈

### 前端部分

### 后端部分

- SpringBoot
- MyBatis
- MySQL

## 需求分析

### 业务流程分析

1. 研究员提出查看药物信息的申请

2. 管理员向研究员发放药物

3. 研究员进行药物重定位的相关研究，提交研究报告

4. 监察员对进行的研究进行审核

5. 质控员对重定位药物做最终检测，决定重定位药物是否合格，进行资料补档

### 用例分析

1. 管理员：

<div style="text-align: center;">
<img src="https://gitee.com/ziyuexuan/image/raw/master/https://gitee.com/ziyuexuan/image/manager.png" alt="image-20230327141426467" style="width:750px" />
</div>

2. 研究员：

<div style="text-align: center;">
<img src="https://gitee.com/ziyuexuan/image/raw/master/https://gitee.com/ziyuexuan/image/researcher.png" alt="image-20230327142234547" style="width:750px" />
</div>

3. 监察员：

<div style="text-align: center;">
<img src="https://gitee.com/ziyuexuan/image/raw/master/https://gitee.com/ziyuexuan/image/inspector.png" alt="image-20230327142804282" style="width:750px" />
</div>

4. 质控员：

<div style="text-align: center;">
<img src="https://gitee.com/ziyuexuan/image/raw/master/https://gitee.com/ziyuexuan/image/controller.png" alt="image-20230327143253272" style="width:750px" />
</div>

## 数据库设计

## 接口设计

### 注册界面

1. 发送手机验证码：/api/phone/verificationCode

    - 数据接收：String phone
    - 数据返回：String verificationCode

2. 发送邮件验证码：/api/mail/verificationCode

    - 数据接收：String mail
    - 数据返回：String verificationCode

3. 主界面：/api/register

    - 数据接收：

```json
{
  "name": "",
  "phone": "",
  "mail": "",
  "identity": "",
  "verificationCode": "",
  "password": ""
}
```

- 数据返回：String result

- 要求：

    - 注册成功：跳转进用户主界面
    - 验证码错误：清空验证码
    - 已注册：跳转登录界面

### 登录界面

1. 登录：/api/login

    - 数据接收：

```json
{
  "identity": "",
  "way": "",
  "phone": "",
  "mail": "",
  "verificationCode": "",
  "password": ""
}
```

- 数据返回：

```json
{
  "id": "-1",
  "name": "null",
  "result": "登录失败"
}
```

- 要求：
    - 验证码为图形验证码（在前端实现）

### 管理员界面

