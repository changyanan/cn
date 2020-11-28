package cn.itook.demo.springboot.model;

import java.io.Serializable;

/**
 * @author changyanan1
 */
public class ResponseData implements Serializable {
    private static final long serialVersionUID = -9003769800212878529L;
    private Boolean status = true;
    private int code = 200;
    private String message;
    private Object data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
