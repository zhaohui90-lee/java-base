package org.melody.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author lizhaohui
 * @since 2023/2/5
 */
public class XmlToMapJackson {



    public static void main(String[] args) throws JsonProcessingException, JAXBException {
        String xml = "<root><Name>John</Name><age>30</age><dd>a</dd></root>";
        XmlMapper mapper = new XmlMapper();
        Map<String, Object> map = mapper.readValue(xml, new TypeReference<Map<String, Object>>() {
        });

        System.out.println(map);
    }

}
