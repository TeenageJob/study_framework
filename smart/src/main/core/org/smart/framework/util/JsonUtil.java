package org.smart.framework.util;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import org.activiti.engine.task.Task;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * JSON 操作工具类
 *
 * @author TY
 * @Time 2017年9月20日 下午9:44:44
 * @since 1.0.0
 */
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将 Java 对象转为 JSON 字符串
     */
    public static <T> String toJSON(T obj) {
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("Java 转 JSON 出错！", e);
            throw new RuntimeException(e);
        }
        return jsonStr;
    }

    /**
     * 将 JSON 字符串转为 Java 对象
     */
    public static <T> T fromJSON(String json, Class<T> type) {
        T obj;
        try {
            obj = objectMapper.readValue(json, type);
        } catch (Exception e) {
            logger.error("JSON 转 Java 出错！", e);
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * 将Map类型数据转换为JSON格式
     * <p>
     * <br>create by on TY
     * <br>2017年12月11日 下午2:44:30
     *
     * @param map
     * @return
     */
    public static String mapToJson(Map<?, ?> map) {
        return JSON.toJSONString(map);
    }

    /**
     * 将List<map>转换为Json
     * <p>
     * <br>create by on TY
     * <br>2018年1月3日 下午2:13:34
     *
     * @param list
     * @return JSON
     */
    public static String ListToJson(List<?> list) {
        StringBuffer str = new StringBuffer();
        str.append("[");
        if (list.get(0) instanceof Map) {
            List<Map<?, ?>> mlist = (List<Map<?, ?>>) list;
            for (Map<?, ?> map : mlist) {
                str.append(mapToJson(map));
                str.append(",");
            }
        } else {
            Iterator<?> iterator = list.iterator();
            while (iterator.hasNext()) {
                str.append(toJSON(iterator.next()));
                str.append(",");
            }
        }
        str.substring(0, str.length() - 2);
        str.append("]");
        return str.toString().replaceAll("\"", "'");
    }

    /**
     * 将JSON格式数据转换为Map格式
     * <p>
     * <br>create by on TY
     * <br>2017年12月11日 下午2:46:58
     *
     * @param json
     * @return
     */
    public static Map<?, ?> jsonToMap(String json) {
        return JSON.parseObject(json);
    }

    /**
     * 将字符串转换为JSONArray
     *
     * @param obj
     * @return
     */
    public static JSONArray stringToJson(String obj) {
        return JSON.parseArray(obj);
    }

    /**
     * 将字符串转换为list
     *
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> parseArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

}
