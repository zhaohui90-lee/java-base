package org.melody.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author lizhaohui
 * @since 2023/2/5
 */
public class XmlToMapJackson {



    public static void main(String[] args) throws JsonProcessingException {
        String string = "<root><element1>value1</element1><element2>value2</element2></root>";
        System.out.println(string);
        XmlMapper xmlMapper = new XmlMapper();

        Map<String, Object> map = xmlMapper.readValue(string, new TypeReference<Map<String, Object>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        System.out.println(map);
    }
}
