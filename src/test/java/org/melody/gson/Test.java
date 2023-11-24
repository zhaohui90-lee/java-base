package org.melody.gson;

import cn.hutool.core.codec.Base64Encoder;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhaohui
 * @since 2023/7/30
 */
public class Test {

    public static void main(String[] args) {
                String jsons = "{\n" +
                "\"url\": \"http://10.106.3.102:7001/medical-web/\",\n" +
                "\"appkey\": \"4bcb4a72f5b0c8725d9d3c930d\",\n" +
                "\"type\": \"medical\",\n" +
                "\"testValue\": \"测试连接\",\n" +
                "\"printPreview\": \"0\",\n" +
                "\"printImg\": {\n" +
                "\"Printer\": \"\",\n" +
                "\"Paper\": \"A5\",\n" +
                "\"Direction\": \"横向\",\n" +
                "\"MarginUp\": \"\",\n" +
                "\"MarginDown\": \"\",\n" +
                "\"MarginLeft\": \"\",\n" +
                "\"MarginRight\": \"\",\n" +
                "\"OffsetX\": \"\",\n" +
                "\"OffsetY\": \"\",\n" +
                "\"WaitTime\": \"60\"\n" +
                "},\n" +
                "\"printListImg\": {\n" +
                "\"Printer\": \"\",\n" +
                "\"Paper\": \"A5\",\n" +
                "\"Direction\": \"横向\",\n" +
                "\"MarginUp\": \"\",\n" +
                "\"MarginDown\": \"\",\n" +
                "\"MarginLeft\": \"\",\n" +
                "\"MarginRight\": \"\",\n" +
                "\"OffsetX\": \"\",\n" +
                "\"OffsetY\": \"\",\n" +
                "\"WaitTime\": \"60\"\n" +
                "}\n" +
                "}";



        String encode = Base64Encoder.encode(jsons);
        System.out.println(encode);

        Map m = new HashMap();
        m.put("key", encode);

        System.out.println(m);

        Gson gson = new Gson();
        String json = gson.toJson(m);

        System.out.println(json);


    }
}
