package org.melody.extend;

import cn.hutool.core.lang.Console;
import cn.hutool.http.webservice.SoapClient;

/**
 * 使用Hutool调用webservice交易
 * @author lizhaohui
 * @since 2023/4/23
 */
public class WebServiceUtil {


    public static void main(String[] args) {
        String tradeUrl = "http://10.106.3.27:8090/Public_ZhongWei.asmx";
        String tradeCode = "MOP_OutpBillstoPayQuery";
        String tradeXml = "<request>\n" +
                "    <QueryCode>123</QueryCode>\n" +
                "    <QueryType>111</QueryType>\n" +
                "</request>\n";
        SoapClient client = SoapClient.create(tradeUrl)
                .setMethod("card:" + tradeCode, "http://www.sxhealth.gov.cn/card")
                .setParam("request", "<![CDATA[" + tradeXml + "]]>");

        // 发送内容
        String content = client.send(true);
        Console.log(content);

//        // 新建客户端
//        SoapClient client = SoapClient.create("http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx")
//                // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
//                .setMethod("web:getCountryCityByIp", "http://WebXml.com.cn/")
//                // 设置参数，此处自动添加方法的前缀：web
//                .setParam("theIpAddress", "218.21.240.106");
//
//        // 发送请求，参数true表示返回一个格式化后的XML内容
//        // 返回内容为XML字符串，可以配合XmlUtil解析这个响应
//        Console.log(client.send(true));
    }
}
