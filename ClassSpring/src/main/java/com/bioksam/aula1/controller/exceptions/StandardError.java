package com.bioksam.aula1.controller.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer Status;
    private String sms;
    private Long timeStamp;

    public StandardError() {
    }

    public StandardError(Integer status, String sms, Long timeStamp) {
        Status = status;
        this.sms = sms;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    
    
}
