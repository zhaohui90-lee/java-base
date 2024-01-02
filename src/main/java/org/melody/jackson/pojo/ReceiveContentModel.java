package org.melody.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * 交易结果 通用返回报文
 * @author lizhaohui
 * @since 2023/12/29
 */
public class ReceiveContentModel implements Serializable {

    private static final long serialVersionUID = 779507696166140870L;

    private Head head;

    private Map<String, Object> body;

    private Tail tail;

    static class Head {

        @JsonProperty("JIAOYIMA")
        private String tradeCode;

        @JsonProperty("FANHUIMA")
        private String receiveCode;

        @JsonProperty("FANHUIXX")
        private String receiveMessage;

        @JsonProperty("FANHUISJ")
        private String receiveTime;

        public String getTradeCode() {
            return tradeCode;
        }

        public void setTradeCode(String tradeCode) {
            this.tradeCode = tradeCode;
        }

        public String getReceiveCode() {
            return receiveCode;
        }

        public void setReceiveCode(String receiveCode) {
            this.receiveCode = receiveCode;
        }

        public String getReceiveMessage() {
            return receiveMessage;
        }

        public void setReceiveMessage(String receiveMessage) {
            this.receiveMessage = receiveMessage;
        }

        public String getReceiveTime() {
            return receiveTime;
        }

        public void setReceiveTime(String receiveTime) {
            this.receiveTime = receiveTime;
        }

        @Override
        public String toString() {
            return "Head{" +
                    "tradeCode='" + tradeCode + '\'' +
                    ", receiveCode='" + receiveCode + '\'' +
                    ", receiveMessage='" + receiveMessage + '\'' +
                    ", receiveTime='" + receiveTime + '\'' +
                    '}';
        }
    }

    static class Tail {

        @JsonProperty("MAC")
        private String tailCode;

        public String getTailCode() {
            return tailCode;
        }

        public void setTailCode(String tailCode) {
            this.tailCode = tailCode;
        }

        @Override
        public String toString() {
            return "Tail{" +
                    "tailCode='" + tailCode + '\'' +
                    '}';
        }
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public Tail getTail() {
        return tail;
    }

    public void setTail(Tail tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "ReceiveContentModel{" +
                "head=" + head.toString() +
                ", body=" + body +
                ", tail=" + tail.toString() +
                '}';
    }
}
