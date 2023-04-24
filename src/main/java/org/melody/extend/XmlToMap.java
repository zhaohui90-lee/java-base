package org.melody.extend;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;

public class XmlToMap {


    /**
     * 使用dom4j解析xml
     * @param xmlString xml字符串
     * @return Map
     * @throws DocumentException DocumentException
     */
    public static Map<String, String> xmlToMap(String xmlString) throws DocumentException {
        Map<String, String> resultMap = new HashMap<>();

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new StringReader(xmlString));
        Element rootElement = document.getRootElement();

        for (Iterator<Element> iterator = rootElement.elementIterator(); iterator.hasNext();) {
            Element element = iterator.next();
            resultMap.put(element.getName(), element.getText());
        }

        return resultMap;
    }

    /**
     * 输入一个Xml类型的字符串，转化为Map类型
     */
    public static Map<String, Object> convertXml2Map(String xmlString) {
        // 1. 创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 2. 创建一个DocumentBuilder对象
        DocumentBuilder builder = null;
        // 3. 创建一个Document对象
        org.w3c.dom.Document document = null;
        // 4. 创建一个Map对象
        Map<String, Object> map = new HashMap<>();
        // 5. 将xml字符串转换为Document对象
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(xmlString);
            // 6. 获取根节点
            org.w3c.dom.Element root = document.getDocumentElement();
            // 7. 获取根节点下的所有子节点
            org.w3c.dom.NodeList childNodes = root.getChildNodes();
            // 8. 遍历所有子节点
            IntStream.range(0, childNodes.getLength()).forEach(i -> {
                // 9. 获取每个子节点
                org.w3c.dom.Element childNode = (org.w3c.dom.Element) childNodes.item(i);
                // 10. 获取子节点的名字
                String nodeName = childNode.getNodeName();
                // 11. 获取子节点的值
                String nodeValue = childNode.getFirstChild().getNodeValue();
                // 12. 将子节点的名字和值放入map中
                map.put(nodeName, nodeValue);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
