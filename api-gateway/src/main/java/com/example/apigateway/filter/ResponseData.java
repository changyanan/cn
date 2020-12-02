package com.example.apigateway.filter;

import java.io.Serializable;

/**
 * @author changyanan1
 */
public class ResponseData implements Serializable {
    private static final long serialVersionUID = 2704005666420628221L;
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
