package org.melody.extend;

import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/3/28
 */
class XmlToMapTest {

    @Test
    void convertXml2Map() throws FileNotFoundException, DocumentException {
        // 单元测试
        try (FileInputStream fileInputStream = new FileInputStream("target1.xml");){
            // 创建字节数组输出流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            // 定义一个字节数组
            byte[] bytes = new byte[1024];
            // 定义一个长度
            int len = 0;
            // 循环读取
            while ((len = fileInputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            String xml = byteArrayOutputStream.toString();
            Map<String, String> map = XmlToMap.xmlToMap(xml);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(xml);

//        String xmlString = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";
//        Map<String, Object> map = XmlToMap.convertXml2Map(xml);
//        System.out.println(map);

    }


    @Test
    void xmlToMap() throws DocumentException {
        // 单元测试
        String xmlString = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";
        Map<String, String> map = XmlToMap.xmlToMap(xmlString);
        System.out.println(map);
    }
}