package org.melody.gson.pojo;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/12/29
 */
class ReceiveContentModelTest {

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
    public void gsonDeserializeTest() {
        ReceiveContentModel receiveContentModel = new Gson().fromJson(receiveContent, ReceiveContentModel.class);
        System.out.println(receiveContentModel.toString());
    }
}