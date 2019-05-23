库建立：
    activiti: 5.22
        activiti流程引擎库
    表格建立：
        act_evt_log, 
        act_ge_bytearray, 
        act_ge_property, 
        act_hi_actinst, 
        act_hi_attachment, 
        act_hi_comment, 
        act_hi_detail, 
        act_hi_identitylink, 
        act_hi_procinst, 
        act_hi_taskinst, 
        act_hi_varinst, 
        act_id_group, 
        act_id_info, 
        act_id_membership, 
        act_id_user, 
        act_procdef_info, 
        act_re_deployment, 
        act_re_model, 
        act_re_procdef, 
        act_ru_event_subscr, 
        act_ru_execution, 
        act_ru_identitylink, 
        act_ru_job, 
        act_ru_task, 
        act_ru_variable
    ty：
        业务和shiro库
        act_yw：流程引擎关联业务表，用与记录流程model，调用service、action、任务功能
        bu_html：业务关联页面表，用于流程引擎页面回显，保存的是整个页面
        business_title：功能菜单页面，记录功能模块 
        business_url：功能菜单页面，记录具体功能信息
        cm_sequence：序列表，获取业务id
        incident：事件表，记录业务办理情况用业务id和流程关联
        leaver_h：请假记录表，用于经办
        leaver_r：请假结果表，最后结果信息
        log：日志表，记录日志 
        menu：功能菜单表，记录菜单信息 
        permission：权限表，记录所有权限，与business_url关联，判断权限 
        role：角色表，记录所有角色信息 
        role_menu：角色菜单表，记录角色拥有的菜单信息 
        role_permission：角色权限表，记录角色拥有的权限 
        sessions：用户登录信息保存表（废弃），已经使用redis进行记录 
        user：使用者记录表，记录使用者的登录信息 
        user_attrs：
        user_information：使用者信息记录表，记录使用者相关信息 
        user_question：使用者安全问题记录表，用于使用者找回账户 
        user_role：使用者角色记录表，使用者角色信息
        PROVINCES:省级名称  AAA003
        CITIES:市级名称     AAA004
        AREAS:区县名称      AAA005

    业务表创建(结果表，临时表多一个业务日志id字段 AAA00A)： 字段 描述 是否必录（未说明未必录。1未不必须） 其它说明
        AA10:数据表
              AA10A:数据表
                    AA10A  自增长
                    AAA001 字段名称
                    AAA002 字段值
            
        AB11:个人
              AB11A:个人基本信息表 
                    ABA001 个人编号  50
                    ABA002 姓名  20
                    ABA003 性别     10
                    ABA004 身份证    18
                    ABA005 籍贯      20
                    ABA006 政治面貌   20
                    ABA007 出生年月   20
                    ABA008 参加工作时间  20
                    ABA009 电话  15
                    ABA010 民族  20
                    ABA011 离退休状态  20
                    ABA012 电子邮箱    50
                    ABA013 邮政编码    6
                    ABA014 通信地址    50
                    ACA001 单位编号    50
                    ACA002 单位名称    50
                     
              AB11B:个人参保信息
                    ABB001 个人参保编号  50
                    ABB002 参保时间   20
                    ABB003 征收方式   20
                    ABA001 个人编号   50
                    ABA002 姓名    20
                    ABB131 医疗情况   20
                    ABB132 生育情况   20
                    ABB133 失业情况   20
                    ABB134 养老情况   20
                    ABB135 工伤情况   20
                    ABC001 账户编号   50

              AB11C:银行账户
                    ABC001 账户编号   50
                    ABC002 银行账号   19
                    ABC003 银行户名   50
                    ABC004 银行名称   50
                    ABC005 银行类别   50
                    ABC006 银行行号   50
                    ABA001 个人id    50
                    ABA002 姓名      20
                    ACA001 单位编号  50
                    ACA002 单位名称  50
                                        
              AB11D:个人缴费
                    ABD001 缴费编号  50
                    ABD002 缴费时间  20
                    ABA131 医疗应缴  20
                    ABA141 医疗实缴  20
                    ABA133 失业应缴  20
                    ABA143 失业实缴  20
                    ABA134 养老应缴  20
                    ABA144 养老实缴  20
                    ABA001 个人id   50
                    ABA002 姓名     20
                    
                    
        AC12:单位
              AC12A:单位基本信息表
                    ACA001 单位编号  50
                    ACA002 单位名称  50
                    ACA003 证照类型  20
                    ACA004 证照代码  50
                    ACA005 单位类型 默认普通单位 20
                    ACA006 单位电话 15
                    ACA007 单位地址  50
                    ABA002 法人姓名  20
                    ABA004 身份证   18
                    ABA009 电话  15
                    
              AC12B:单位参保信息
                    ACB001 单位参保信息编号 50
                    ACB002 征收方式  20
                    ACB003 参保时间  20
                    ACB131 医疗情况  20
                    ACB132 生育情况  20
                    ACB133 失业情况  20
                    ACB134 养老情况  20
                    ACB135 工伤情况  20
                    ABC001 账户编号  50
                    ACA001 单位编号  50
        
        AD13:基数
              (五险：医疗保险(1)、生育保险(2)、失业保险(3)、养老保险(4)、工伤保险(5))
              AD00A:险种表
                    ADA00A 险种编号  50
                    ADA00B 险种类型  10(A 医疗 B 生育 C 失业 D 养老 E 工伤)
                    ADA00J 险种名称  10
                    ADA00C 缴费基数上限 20
                    ADA00D 缴费基数下限 20
                    ADA00E 基数开始时间 20
                    ADA00F 基数终止时间 20
                    ADA00G 单位应缴比例 20
                    ADA00H 个人应缴比例 20
                    ADA00I 创建时间  20
                    
              AD13A:医疗
                    ADA001 医疗保险编号  50
                    ADA002 缴费基数  20
                    ADA003 缴费时间  20
                    ADA004 单位应缴  20
                    ADA005 单位实缴  20
                    ADA006 个人应缴  20
                    ADA007 个人实缴  20
                    ADA008 工资      20
                    ADA009 上年平均工资 20
                    ADA010 补退标识：1 补交 2 退费 10
                    ACA001 单位编号  50
                    ACA002 单位名称  50
                    ABA001 个人id    50
                    ABA002 姓名      20
                    
              AD13B:生育
                    ADB001 生育保险编号  50
                    ADB002 缴费基数  20
                    ADB003 缴费时间  20
                    ADB004 单位应缴  20
                    ADB005 单位实缴  20
                    ADB006 个人应缴  20
                    ADB007 个人实缴  20
                    ADB008 工资  20
                    ADB009 上年平均工资 20
                    ADB010 补退标识：1 补交 2 退费 10
                    ACA001 单位编号  50
                    ACA002 单位名称  50
                    ABA001 个人id    50
                    ABA002 姓名      20
                    
              AD13C:失业
                    ADC001 失业保险编号  50
                    ADC002 缴费基数  20
                    ADC003 缴费时间  20
                    ADC004 单位应缴  20
                    ADC005 单位实缴  20
                    ADC006 个人应缴  20
                    ADC007 个人实缴  20
                    ADC008 工资  20
                    ADC009 上年平均工资 20
                    ADC010 补退标识：1 补交 2 退费 10
                    ACA001 单位编号  50
                    ACA002 单位名称  50
                    ABA001 个人id    50
                    ABA002 姓名      20
                    
              AD13D:养老
                    ADD001 养老保险编号  50 
                    ADD002 缴费基数  20 
                    ADD003 缴费时间  20 
                    ADD004 单位应缴  20
                    ADD005 单位实缴  20
                    ADD006 个人应缴  20
                    ADD007 个人实缴  20
                    ADD008 工资  20
                    ADD009 上年平均工资 20
                    ADD010 补退标识：1 补交 2 退费 10
                    ACA001 单位编号  50
                    ACA002 单位名称  50
                    ABA001 个人id    50
                    ABA002 姓名      20
                    
              AD13E:工伤
                    ADE001 工伤保险编号  50
                    ADE002 缴费基数  20
                    ADE003 缴费时间  20
                    ADE004 单位应缴  20
                    ADE005 单位实缴  20
                    ADE006 个人应缴  20
                    ADE007 个人实缴  20
                    ADE008 工资  20
                    ADE009 上年平均工资 20
                    ADE010 补退标识：1 补交 2 退费 10
                    ACA001 单位编号  50
                    ACA002 单位名称  50
                    ABA001 个人id    50
                    ABA002 姓名      20
                    
        AE14:卡务                    
              AE14A:个人注册卡（卡功能：1记录信息 
                    AEA001 办理卡编号  50
                    AEA002 办理时间  20
                    AEA003 有限年限  20
                    AEA004 一卡通状态  20
                    AEA005 一卡通编号  50
                    ABA001 个人编号  50
                    ABA002 姓名   20
                    ACA001 单位编号  50
                    ACA002 单位名称  50
                    ABC001 账户编号   50
    
    
    
    