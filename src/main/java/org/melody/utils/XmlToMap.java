package org.melody.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class XmlToMap {
    public static void main(String[] args) throws Exception {
        String xml = "<root><name>John Doe</name><age>25</age></root>";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xml);
        Map<String, String> map = new HashMap<>();
        convertToMap(document.getDocumentElement(), map);
        System.out.println(map);
    }

    private static void convertToMap(Element element, Map<String, String> map) {
        NodeList childNodes = element.getChildNodes();
        IntStream.range(0, childNodes.getLength())
                .mapToObj(childNodes::item)
                .filter(node -> node instanceof Element)
                .map(node -> (Element) node)
                .forEach(childElement -> {
                    map.put(childElement.getTagName(), childElement.getTextContent());
                    convertToMap(childElement, map);
                });
    }
}
