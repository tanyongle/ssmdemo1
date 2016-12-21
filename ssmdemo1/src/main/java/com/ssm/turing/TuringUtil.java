package com.ssm.turing;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.turing.util.Aes;
import com.ssm.turing.util.Md5;
import com.ssm.turing.util.PostServer;

/**
 *
 */
public class TuringUtil {

    public static JSONObject AskRobot(String cmd) {

        //图灵网站上的secret
        String secret = "d6ca315564ef0ac4";
        //图灵网站上的apiKey
        String apiKey = "6c3edd1142074eed9c9ab9c4cf0638ee";
        //String cmd = "广州天气";//测试用例
        //待加密的json数据
        String data = "{\"key\":\"" + apiKey + "\",\"info\":\"" + cmd + "\"}";
        //获取时间戳
        String timestamp = String.valueOf(System.currentTimeMillis());

        //生成密钥
        String keyParam = secret + timestamp + apiKey;
        String key = Md5.MD5(keyParam);

        //加密
        Aes mc = new Aes(key);
        data = mc.encrypt(data);

        //封装请求参数
        JSONObject json = new JSONObject();
        json.put("key", apiKey);
        json.put("timestamp", timestamp);
        json.put("data", data);
        //请求图灵api
        String result = PostServer.SendPost(json.toString(), "http://www.tuling123.com/openapi/api");
        System.out.println(result);
        return JSON.parseObject(result);
    }

}
