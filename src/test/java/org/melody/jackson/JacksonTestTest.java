package org.melody.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.melody.jackson.pojo.ReceiveContentModel;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2024/1/2
 */
class JacksonTestTest {

    private final String receiveContent = "{\n" +
            "  \"head\":{\n" +
            "    \"JIAOYIMA\":\"MENZHENYJS\",\n" +
            "    \"FANHUIMA\":\"000000\",\n" +
            "    \"FANHUIXX\":\"交易成功\",\n" +
            "    \"FANHUISJ\":\"2018-04-25\"\n" +
            "  },\n" +
            "  \"body\":{\n" +
            "    \"ZONGJINE\":\"80\",\n" +
            "    \"YIBAOZF\":\"0\",\n" +
            "    \"XIANJINZF\":\"80\",\n" +
            "    \"BEIZHU\":\"请到医技科室刷卡化验检查\",\n" +
            "    \"source\":[\n" +
            "      {\n" +
            "        \"seq_no\":\"1\",\n" +
            "        \"visit_time\":\"08:00-08:30\",\n" +
            "        \"shift\":\"1\",\n" +
            "        \"visit_date\":\"2023-12-27T00:00:00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"seq_no\":\"5\",\n" +
            "        \"visit_time\":\"08:00-08:30\",\n" +
            "        \"shift\":\"1\",\n" +
            "        \"visit_date\":\"2023-12-27T00:00:00\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"seq_no\":\"6\",\n" +
            "        \"visit_time\":\"08:00-08:30\",\n" +
            "        \"shift\":\"1\",\n" +
            "        \"visit_date\":\"2023-12-27T00:00:00\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"tail\":{\n" +
            "    \"MAC\":\"MAC\"\n" +
            "  }\n" +
            "}";

    @Test
    void parse() {
    //     jackson返序列化
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ReceiveContentModel receiveContentModel = objectMapper.readValue(receiveContent, ReceiveContentModel.class);
            System.out.println(receiveContentModel.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}