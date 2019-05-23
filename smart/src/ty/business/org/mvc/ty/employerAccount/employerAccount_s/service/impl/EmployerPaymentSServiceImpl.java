package org.mvc.ty.employerAccount.employerAccount_s.service.impl;

import org.mvc.ty.employerAccount.employerAccount_s.service.EmployerPaymentSService;
import org.mvc.ty.mybatis.employerAccount.EmployerAccount;
import org.plugin.mybatis.MybatisInject;
import org.plugin.mybatis.MybatisSession;
import org.smart.framework.tx.annotation.Service;
import org.smart.framework.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployerPaymentSServiceImpl implements EmployerPaymentSService {

    @MybatisInject
    EmployerAccount employerAccount;

    @Override
    public List<Map<String, String>> getBaseNumber(Map paramMap) {
        List<Map<String, String>> list = employerAccount.getBaseNumber(paramMap);
        Double salaryLast = Double.parseDouble(paramMap.get("009").toString());
        Double salary = Double.parseDouble(paramMap.get("008").toString());
        /**
         * 1 小于平均工资60% 按60%算
         * 2 大于平均工资300% 按300%算
         */
        double bl = salary / salaryLast;//下限为40%
        double base = bl;
        double base6 = bl;
        double bl6 = bl;//下限为60%
        if (bl > 3) {
            bl6 = bl = 3 * salaryLast;
            base6 = base = 3.0;
        }
        if (bl < 0.4) {
            bl = 0.4 * salaryLast;
            base = 0.4;
        } else {
            bl = salary;
        }
        if (bl6 < 0.6) {
            bl6 = 0.6 * salaryLast;
            base6 = 0.6;
        } else {
            bl6 = salary;
        }
        List<Map<String, String>> valList = new ArrayList<>();
        for (Map map : list) {
            Map valMap = new HashMap();
            double up = Double.parseDouble((String) map.get("ADA00C")) / 100;
            double down = Double.parseDouble((String) map.get("ADA00D")) / 100;
            double employee = Double.parseDouble((String) map.get("ADA00G")) / 100;
            double employer = Double.parseDouble((String) map.get("ADA00H")) / 100;
            switch (map.get("ADA00B").toString()) {
                case "A":
                    if (down == 0.4) {//缴费下限
                        employee = employee * bl;
                        employer = employer * bl;
                        valMap.put("ADA002", String.valueOf(base));
                    } else {
                        employee = employee * bl6;
                        employer = employer * bl6;
                        valMap.put("ADA002", String.valueOf(base6));
                    }
                    valMap.put("ADA004", String.valueOf(employee));
                    valMap.put("ADA006", String.valueOf(employer));
                    valList.add(valMap);
                    break;
                case "B":
                    if (down == 0.4) {//缴费下限
                        employee = employee * bl;
                        employer = employer * bl;
                        valMap.put("ADB002", String.valueOf(base));
                    } else {
                        employee = employee * bl6;
                        employer = employer * bl6;
                        valMap.put("ADB002", String.valueOf(base6));
                    }

                    valMap.put("ADB004", String.valueOf(employee));
                    valMap.put("ADB006", String.valueOf(employer));
                    valList.add(valMap);
                    break;
                case "C":
                    if (down == 0.4) {//缴费下限
                        employee = employee * bl;
                        employer = employer * bl;
                        valMap.put("ADC002", String.valueOf(base));
                    } else {
                        employee = employee * bl6;
                        employer = employer * bl6;
                        valMap.put("ADC002", String.valueOf(base6));
                    }

                    valMap.put("ADC004", String.valueOf(employee));
                    valMap.put("ADC006", String.valueOf(employer));
                    valList.add(valMap);
                    break;
                case "D":
                    if (down == 0.4) {//缴费下限
                        employee = employee * bl;
                        employer = employer * bl;
                        valMap.put("ADD002", String.valueOf(base));
                    } else {
                        employee = employee * bl6;
                        employer = employer * bl6;
                        valMap.put("ADD002", String.valueOf(base6));
                    }

                    valMap.put("ADD004", String.valueOf(employee));
                    valMap.put("ADD006", String.valueOf(employer));
                    valList.add(valMap);
                    break;
                case "E":
                    if (down == 0.4) {//缴费下限
                        employee = employee * bl;
                        employer = employer * bl;
                        valMap.put("ADE002", String.valueOf(base));
                    } else {
                        employee = employee * bl6;
                        employer = employer * bl6;
                        valMap.put("ADE002", String.valueOf(base6));
                    }

                    valMap.put("ADE004", StringUtil.getFixLength(String.valueOf(employee), 3));
                    valMap.put("ADE006", String.valueOf(employer));
                    valList.add(valMap);
                    break;
            }
        }
        return valList;
    }

    @Override
    public void saveAd13A(Map paramMap)throws Exception {
        employerAccount.saveAd13A(paramMap);
    }

    @Override
    public void saveAd13B(Map paramMap)throws Exception {
        employerAccount.saveAd13B(paramMap);
    }

    @Override
    public void saveAd13C(Map paramMap) throws Exception{
        employerAccount.saveAd13C(paramMap);
    }

    @Override
    public void saveAd13D(Map paramMap)throws Exception {
        employerAccount.saveAd13D(paramMap);
    }

    @Override
    public void saveAd13E(Map paramMap)throws Exception {
        employerAccount.saveAd13E(paramMap);
    }

    @MybatisSession
    @Override
    public void fuheYw(String buId) throws Exception {
        employerAccount.fuheAd13A(buId);
        employerAccount.fuheAd13B(buId);
        employerAccount.fuheAd13E(buId);
        employerAccount.fuheAd13C(buId);
        employerAccount.fuheAd13D(buId);

    }


}
