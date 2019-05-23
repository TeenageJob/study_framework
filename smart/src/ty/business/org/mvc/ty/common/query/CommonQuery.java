package org.mvc.ty.common.query;

import org.smart.framework.dao.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonQuery {

    public static List<String> queryCollection(String AAA001) {
        List<String> list = new ArrayList<>();
        if (AAA001.equals("AAA003")) {
            String sql = "select concat(aid,',',AAA003) from provinces";
            return DatabaseHelper.queryColumnList(sql);
        } else if (AAA001.equals("AAA004")) {
            String sql = "select concat(aid,',',AAA004) from cities";
            return DatabaseHelper.queryColumnList(sql);
        }
        String sql = "select concat(AA10A,',', AAA002) from AA10A WHERE AAA001=?";
        return DatabaseHelper.queryColumnList(sql, AAA001);
    }

    public static List<String> queryCollectionAAA004(String AAA001, String AAA002) {
        String sql = null;
        if (AAA001.equals("AAA004")) {
            sql = "select concat(aid,',',AAA004) from cities where AAA003=?";
        } else if (AAA001.equals("AAA005")) {
            sql = "select concat(aid,',',AAA005) from areas where AAA004=?";
        }
        return DatabaseHelper.queryColumnList(sql, AAA002);
    }

    public static Map queryemployeeInfo(String value) {
        value=value+"%";
        String sql = "select ACA001,ACA002,ACA003,ACA004,ACA006,ACA005,ACA007 from AC12A where ACA002 like ?";
        return DatabaseHelper.queryMap(sql, value);
    }

    public static Map queryemployerInfo(String value) {
        value=value+"%";
        String sql = "select a.ABA001,a.ABA002,a.ABA003,a.ABA004,a.ABA005,a.ABA006,a.ABA007,a.ABA008,a.ABA009,a.ABA010,a.ABA011,a.ABA012,a.ABA013,a.ABA014,a.ACA001,a.ACA002," +
                "b.ABC001,b.ABC002,b.ABC003,b.ABC004,b.ABC005,b.ABC006,b.ABA001 from AB11A a,AB11C b where a.ABA001=b.ABA001 and a.ABA002 like ?";
        return DatabaseHelper.queryMap(sql, value);
    }


}
