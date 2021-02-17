package com.ranx.chowder.json;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranx
 */
public class FastJsonUtil {

    static class Users {
        private List<User> users = new ArrayList<>();

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }
    }

    public static void main(String[] args) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("result json");
        User user = new User();
        user.setId(1L);
        user.setName("Dell");
        result.setData(user);

        Users users = new Users();
        users.users.add(user);
        users.users.add(user);
        users.users.add(user);

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(users);
        System.out.println("Java对象转化为JSON对象\n" + jsonObject);

        JavaOBjtoJsonObj(result);
//        JavaOBjtoJsonChar(result);
//        JsonOBjtoJsonChar(result);
//        JsonOBjtoJsonObj(result);

        String resultChar = "{\"code\":1,\"data\":{\"name\":\"Dell\",\"id\":1},\"message\":\"result json\"}";
        JsonChartoJsonObj(resultChar);
        JsonChartoJavaObj(resultChar);
    }


    /**
     * Java对象-->JSON对象
     * (JSONObject)JSONObject.toJSON(Java对象实例)
     *
     * @param result
     */
    public static void JavaOBjtoJsonObj(Result result) {
        //Java对象转化为JSON对象
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(result);
        System.out.println("Java对象转化为JSON对象\n" + jsonObject);
        Object data = jsonObject.get("data");
        System.out.println("获取数据域：" + jsonObject.get("data"));

        System.out.println("获取用户姓名：" + jsonObject.get("data"));
    }


    /**
     * Java对象-->JSON字符串
     * JSONObject.toJSONString(Java对象实例)
     */
    public static void JavaOBjtoJsonChar(Result result) {
        //Java对象转换成JSON字符串
        String stuString = JSONObject.toJSONString(result);
        System.out.println("Java对象转换成JSON字符串\n" + stuString);
    }

    /**
     * JSON对象-->JSON字符串
     * JSONObject.toJSONString();
     */
    public static void JsonOBjtoJsonChar(Result result) {
        //先转成JSON对象
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(result);
        //JSON对象转换为JSON字符串
        String jsonString = jsonObject.toJSONString();
        System.out.println("JSON对象转换为JSON字符串\n" + jsonString);
    }

    /**
     * JSON对象-->Java对象
     * JSONObject.toJavaObject(JSON对象实例, Java对象.class);
     */
    public static void JsonOBjtoJsonObj(Result result) {
        //先转成JSON对象
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(result);

        //JSON对象转换成Java对象
        Result res = JSONObject.toJavaObject(jsonObject, Result.class);
        System.out.println("JSON对象转换成Java对象\n" + res);
    }

    /**
     * JSON字符串-->JSON对象
     * JSONObject.parseObject(JSON字符串)
     */
    public static void JsonChartoJsonObj(String resultChar) {

        //JSON字符串转换成JSON对象
        JSONObject jsonObject1 = JSONObject.parseObject(resultChar);
        System.out.println("JSON字符串转换成JSON对象\n" + jsonObject1);
    }

    /**
     * JSON字符串-->Java对象
     * JSONObject.parseObject(JSON字符串, Java对象.class);
     */
    public static void JsonChartoJavaObj(String resultChar) {
        //JSON字符串转换成Java对象
        Result res = JSONObject.parseObject(resultChar, Result.class);
        System.out.println("JSON字符串转换成Java对象\n" + res);//Student{name='公众号编程大道', sex='m', age=2}
    }
}
