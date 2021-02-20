package com.example.itookdemodesign.link;

/**
 * @author changyanan1
 */
public class AuthInfo {
    private String code;
    private String info = "";

    public AuthInfo(String code, String... infos) {
        this.code = code;
        for (String info : infos) {
            this.info = this.info.concat(info);
        }
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
