package com.example.springelasticsearch.common.api;

/**
 * @author changyanan1
 */
public interface IErrorCode {
    /**
     * 编码
     *
     * @return
     */
    long getCode();

    /**
     * 信息
     *
     * @return
     */
    String getMessage();
}
