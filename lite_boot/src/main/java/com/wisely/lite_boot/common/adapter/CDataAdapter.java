package com.wisely.lite_boot.common.adapter;


import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @Author YC
 * @create 2020/3/7 修复消息接收失败问题
 */
public class CDataAdapter extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return new StringBuilder("<![CDATA[").append(v).append("]]>").toString();

    }

}