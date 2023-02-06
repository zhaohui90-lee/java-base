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
        String string = "<schedule-common>\n" +
                "    <department>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksdz>详见挂号单</ksdz>\n" +
                "        <ksjj>普内科目前有副主任医师两名，主治医师五名。主要开展常见病，多发病的诊断和治疗。在肝胆，呼吸，血液，肾炎等疾病诊治方面有一定特色。</ksjj>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <zjbs>0</zjbs>\n" +
                "    </department>\n" +
                "    <page>\n" +
                "        <currentpage>1</currentpage>\n" +
                "        <pages>1</pages>\n" +
                "        <pagesize>20</pagesize>\n" +
                "        <records>17</records>\n" +
                "    </page>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA78642C636DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-14</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA786411A36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-15</yyrq>\n" +
                "        <yysd>上午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA786416A36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-15</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>12</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863BA036DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-16</yyrq>\n" +
                "        <yysd>上午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>12</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863BE636DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-16</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>12</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863F1536DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-17</yyrq>\n" +
                "        <yysd>上午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>12</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863F5B36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-17</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863DAF36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-18</yyrq>\n" +
                "        <yysd>上午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863DFF36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-18</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863C4936DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-19</yyrq>\n" +
                "        <yysd>上午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863C9936DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-19</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863CFC36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-20</yyrq>\n" +
                "        <yysd>上午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863D4C36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-20</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863FBE36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-21</yyrq>\n" +
                "        <yysd>上午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA786400E36DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-21</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863E6236DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-22</yyrq>\n" +
                "        <yysd>上午</yysd>\n" +
                "    </schedule>\n" +
                "    <schedule>\n" +
                "        <ghf>10</ghf>\n" +
                "        <ksdm>1120100</ksdm>\n" +
                "        <ksmc>普内科</ksmc>\n" +
                "        <pbbh>CE3FA7863EB236DDE0533CA0A8C07825</pbbh>\n" +
                "        <yydm>47151074433068211A1001</yydm>\n" +
                "        <yyrq>2021-10-22</yyrq>\n" +
                "        <yysd>下午</yysd>\n" +
                "    </schedule>\n" +
                "</schedule-common>";
        System.out.println(string);
        XmlMapper xmlMapper = new XmlMapper();

        Map<String, Object> map1 = xmlMapper.readValue(string, Map.class);
        Map<String, Object> map = xmlMapper.readValue(string, new TypeReference<Map<String, Object>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        System.out.println(map);
    }
}
