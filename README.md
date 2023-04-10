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

### E-R图

### 具体设计

1. 管理员Manager：

   | 列名                            | 类型        | 描述   |
            | ------------------------------- | ----------- | ------ |
   | <font color="red">**id**</font> | INT         | 编号   |
   | name                            | VARCHAR(45) | 姓名   |
   | password                        | VARCHAR(45) | 密码   |
   | phone                           | VARCHAR(45) | 手机号 |
   | mail                            | VARCHAR(45) | 邮箱   |

2. 研究员Researcher：

   | 列名                            | 类型        | 描述   |
                  | ------------------------------- | ----------- | ------ |
   | <font color="red">**id**</font> | INT         | 编号   |
   | name                            | VARCHAR(45) | 姓名   |
   | password                        | VARCHAR(45) | 密码   |
   | phone                           | VARCHAR(45) | 手机号 |
   | mail                            | VARCHAR(45) | 邮箱   |

3. 监察员Inspector：

   | 列名                            | 类型        | 描述   |
                  | ------------------------------- | ----------- | ------ |
   | <font color="red">**id**</font> | INT         | 编号   |
   | name                            | VARCHAR(45) | 姓名   |
   | password                        | VARCHAR(45) | 密码   |
   | phone                           | VARCHAR(45) | 手机号 |
   | mail                            | VARCHAR(45) | 邮箱   |

4. 质控员Controller：

   | 列名                            | 类型        | 描述   |
                     | ------------------------------- | ----------- | ------ |
   | <font color="red">**id**</font> | INT         | 编号   |
   | name                            | VARCHAR(45) | 姓名   |
   | password                        | VARCHAR(45) | 密码   |
   | phone                           | VARCHAR(45) | 手机号 |
   | mail                            | VARCHAR(45) | 邮箱   |

5. 药物分类Class：

   | 列名                            | 类型        | 描述     |
                     | ------------------------------- | ----------- | -------- |
   | <font color="red">**id**</font> | INT         | 分类编号 |
   | name                            | VARCHAR(45) | 分类名称 |

6. 药物小类Classify:

   | 列名                                    | 类型         | 描述     |
                     | --------------------------------------- | ------------ | -------- |
   | <font color="red">**id**</font>         | INT          | 小类编号 |
   | name                                    | VARCHAR(45)  | 小类名称 |
   | classify_id                             | VARCHAR(100) | 查询用id |
   | <font color="green">**class_id**</font> | INT          | 分类编号 |

7. 药物信息Drug：

   | 列名                                   | 类型          | 描述         |
                  | -------------------------------------- | ------------- | ------------ |
   | <font color="red">**id**</font>        | INT           | 药物编号     |
   | name                                   | VARCHAR(450)  | 药物名称     |
   | <font color="green">**classId**</font> | INT           | 大类编号     |
   | drugId                                 | VARCHAR(800)  | 药物ID       |
   | specification                          | VARCHAR(1000) | 规格         |
   | form                                   | VARCHAR(450)  | 剂型         |
   | approvalNumber                         | VARCHAR(1000) | 批准编号     |
   | executiveStandard                      | VARCHAR(1000) | 执行标准     |
   | producer                               | VARCHAR(1000) | 生产厂家     |
   | indication                             | VARCHAR(1000) | 适应症       |
   | component                              | VARCHAR(1000) | 主要成分     |
   | interact                               | VARCHAR(1000) | 药物相互作用 |
   | properties                             | VARCHAR(1000) | 性状         |
   | number                                 | INT           | 数量         |
   | price                                  | FLOAT         | 价格         |
   | validityTime                           | VARCHAR(100)  | 有效期       |
   | usageConsumption                       | VARCHAR(1000) | 用法用量     |
   | taboo                                  | VARCHAR(1000) | 禁忌         |
   | adverseReaction                        | BLOB          | 不良反应     |
   | storeUp                                | VARCHAR(1000) | 贮藏         |
   | matters                                | VARCHAR(1000) | 注意事项     |

8. 申请Apply：

   | 列名                                         | 类型 | 描述         |
   | -------------------------------------------- | ---- | ------------ |
   | <font color="red">**id**</font>              | INT  | 申请编号     |
   | <font color="green">**researcher_id**</font> | INT  | 研究员编号   |
   | <font color="green">**drug_id**</font>       | INT  | 药物编号     |
   | time                                         | DATE | 申请日期     |
   | number                                       | INT  | 实验药物数量 |
   | status                                       | INT  | 申请状态     |

9. 研究报告Report：

   | 列名                                         | 类型         | 描述       |
      | -------------------------------------------- | ------------ | ---------- |
   | <font color="red">**id**</font>              | INT          | 报告编号   |
   | <font color="green">**researcher_id**</font> | INT          | 研究员编号 |
   | title                                        | VARCHAR(45)  | 报告题目   |
   | content                                      | BLOB         | 报告内容   |
   | time                                         | DATETIME     | 提交时间   |
   | appendix                                     | VARCHAR(200) | 附件       |
   | <font color="green">**inspector_id**</font>  | INT          | 监察员编号 |

10. 研究报告初审Inspector_examine：

    | 列名                                         | 类型         | 描述       |
        | -------------------------------------------- | ------------ | ---------- |
    | <font color="red">**id**</font>              | INT          | 初审编号   |
    | <font color="green">**report_id**</font>     | INT          | 报告编号   |
    | status                                       | VARCHAR(20)  | 状态       |
    | opinion                                      | VARCHAR(500) | 审核意见   |
    | time                                         | DATE         | 审核时间   |
    | <font color="green">**controller_id**</font> | INT          | 质检员编号 |

11.

## 接口设计

<font color="blue">数据接收：前端 ---> 后端 </font>
<font color="blue">数据返回：后端 ---> 前端</font>

### 注册界面

1. 发送手机验证码：/api/phone/verificationCode

- 数据接收：

| 参数名 | 参数值 | 类型   |
| ------ | ------ | ------ |
| phone  |        | string |

- 数据返回：

| 参数名           | 参数值 | 类型   |
| ---------------- | ------ | ------ |
| verificationCode |        | string |

2. 发送邮件验证码：/api/mail/verificationCode

- 数据接收：

| 参数名 | 参数值 | 类型   |
| ------ | ------ | ------ |
| mail   |        | string |

- 数据返回：

| 参数名           | 参数值 | 类型   |
| ---------------- | ------ | ------ |
| verificationCode |        | string |

3. 注册：/api/register

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

- 数据返回：

| 参数名 | 参数值 | 类型   |
| ------ | ------ | ------ |
| result |        | string |

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

1. 药物信息库获取：/api/manager/getRepositories

- 数据接收：无

- 数据返回：

```json
{
  "classes": [
    {
      "id": "",
      "name": ""
    }
  ]
}
```

2. 药物信息库建立：/api/manager/addRepository

- 数据接收：

| 参数名    | 参数值 | 类型   |
| --------- | ------ | ------ |
| className |        | string |

- 数据返回：

| 参数名 | 参数值 | 类型   |
| ------ | ------ | ------ |
| result |        | string |

3. 药物数据获取：/api/manager/getDrugs

- 数据接收：

| 参数名    | 参数值 | 类型   |
| --------- | ------ | ------ |
| className |        | string |

- 数据返回：

```json
{
  "drugs": [
    {
      "id": "",
      "name": "",
      "drugId": "",
      "specification": "",
      "form": "",
      "executiveStandard": "",
      "approvalNumber": "",
      "producer": "",
      "indication": "",
      "component": "",
      "interact": "",
      "properties": "",
      "number": "",
      "price": "",
      "validityTime": "",
      "useConsumption": "",
      "taboo": "",
      "adverseReaction": "",
      "storeUp": "",
      "matters": ""
    }
  ]
}
```

- 要求：
    - 空值不必展示

4. 查看研究员药物申请：/api/manager/getApplies

- 数据接收：

| 参数名      | 参数值 | 类型   |
| ----------- | ------ | ------ |
| status      | 1      | number |
| <font color="blue">researcherId</font> ||<font color="blue">number</font>|

- 数据返回：

```json
{
    "applyList": [
        {
            "id": "",
            "researcher": "",
            "drug": "",
            "time","",
            "number": "",
            "status": ""
        }
    ]
}
```

4. 审核申请：/api/manager/exeApply

- 数据接收：Apply 对象

- 数据返回：

| 参数名 | 参数值 | 类型   |
| ------ | ------ | ------ |
| result |        | string |

### 研究员界面

1. 研究药物申请：/api/researcher/drugApply

- 数据接收：

```json
{
    "researcher_id": "",
    "drug_id": "",
    "time":"",
    "number": "",
    "status": ""
}
```

- 数据返回：String result

2. 历史申请记录：/api/researcher/getApplies

- 数据接收：

| 参数名                           | 参数值       | 类型                             |
| -------------------------------- | ------------ | -------------------------------- |
| researcherId                     | 当前研究者id | number                           |
| <font color="blue">status</font> |              | <font color="blue">number</font> |

- 数据返回：

```json
{
    "applies": [
        {
            "id": "",
            "researcher": "",
            "drug": "",
            "time":"",
            "number": "",
            "status": ""
        }
    ]
}
```

- 每个申请有一个【查看详情】，顶端展示申请进度，下面展示申请详情。初步效果如下：

<div style="text-align: center;">
    <img src="https://gitee.com/ziyuexuan/image/raw/master/https://gitee.com/ziyuexuan/image/apply.png" alt="image-20230409154967521" style="width:750px">
</div>

3. 药物重定位：
4. 获取监察员：/api/researcher/getInspectors

- 数据接收：无
- 数据返回：

```json
{
    "inspectors": [
        {
            "id": "",
            "name": "",
            "password": "",
            "phone": "",
            "mail": ""
        }
    ]
}
```

- 要求：前端将监察员姓名以下拉列表形式展示

5. 附件上传：/api/researcher/addAppendix

- 数据接收：

```json
{
  "file": ""
}
```

- 数据返回：

| 参数名 | 参数值 | 类型   |
| ------ | ------ | ------ |
| result |        | string |

- 要求：上传的附件最大不超过20MB

6. 撰写研究报告：/api/researcher/report

- 数据接收：

```json
{
  "researcher_id": "",
  "inspetor_id": "",
  "title": "",
  "content": "",
  "time": "",
  "appendix": ""
}
```

- 数据返回：

| 参数名 | 参数值 | 类型   |
| ------ | ------ | ------ |
| result |        | string |

### 监察员界面

1. 获取研究报告：/api/inspector/getReportys

- 数据接收：

| 参数名      | 参数值       | 类型   |
| ----------- | ------------ | ------ |
| inspectorId | 当前监察员id | number |

- 数据返回：

```json
{
    "reports":[
        {
            "researcher_id": "",
            "inspetor_id": "",
            "title": "",
            "content": "",
            "time": "",
            "appendix": ""
        }
    ]
}
```

2. 研究报告初审：/api/inspector/examineReport

- 数据接收：

```json
{
    "report_id":"",
    "status":"",
    "opinion":"",
    "time":"",
    "controller_id"
}
```

- 数据返回：无

3. 药物重定位检测：

### 质控员界面

1. 研究报告终审：
2. 药物有效期管理：
3. 资料补档：

