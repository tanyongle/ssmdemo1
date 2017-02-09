package com.ssm.boot;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2017/2/8.
 */
public class AVOSCloudMain {
    public static void initCloud() {
        System.out.println("initCloud run!!");
        // 参数依次为 AppId、AppKey、MasterKey
        AVOSCloud.initialize("0LEwEk1rbMJDzSu5ggK0tS1w-gzGzoHsz",
                "MFowL1en3IXUNoinlJOwXPcA", "6BWEmysMtVqRg4kL6Kl6ufhN");
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        //AVOSCloud.setDebugLogEnabled(true);
        AVObject testObject = new AVObject("TestObject");
        testObject.put("words", "Hello World!");
        try {
            testObject.save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }
}
