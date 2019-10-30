package fun.hijklmn.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JSONUtil {

    public static String toJson(Object object) {
        return JSONObject.toJSONString(object);
    }

    public static <T> T toBean(String content, Class<T> tClass) {
        JSON json = JSON.parseObject(content);
        return JSONObject.toJavaObject(json, tClass);
    }

    public static <T> List<T> toList(String content, Class<T> tClass) {
        return JSON.parseArray(content, tClass);
    }

}
