package com.xlsz.xfspeech.bean;

/**
 * Created by wuxiaotie on 2017/10/10.
 * 消息实体
 */
public class Msg {

    public static final int SEND_MSG = 1;
    public static final int RECEIVE_MSG = 2;
    private int type;
    private String start_content;
    private String end_content;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStart_content() {
        return start_content;
    }

    public void setStart_content(String start_content) {
        this.start_content = start_content;
    }

    public String getEnd_content() {
        return end_content;
    }

    public void setEnd_content(String end_content) {
        this.end_content = end_content;
    }
}
