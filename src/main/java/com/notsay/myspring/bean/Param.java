package com.notsay.myspring.bean;

import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 * @description:
 * @author: dsy
 * @date: 2020/8/21 16:54
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param() {
    }

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public boolean isEmpty(){
        return MapUtils.isEmpty(paramMap);
    }
}
