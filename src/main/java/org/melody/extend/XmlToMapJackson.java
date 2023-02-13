package org.melody.extend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author lizhaohui
 * @since 2023/2/5
 */
public class XmlToMapJackson {



    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("target1.xml")){
            XmlMapper mapper = new XmlMapper();
            Map<String, Object> map = mapper.readValue(inputStream, new TypeReference<Map<String, Object>>() {


                @Override
                public boolean equals(Object obj) {
                    return super.equals(obj);
                }
            });

            System.out.println(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
