package com.example.shardingexample.sequence;

import com.example.shardingexample.consts.DbAndTableEnum;

/**
 * @author changyanan1
 */
public interface SequenceGenerator {
    /**
     * 生成序列id
     *
     * @param targetEnum
     * @param dbIndex
     * @param tbIndex
     * @return
     */
    String getNextVal(DbAndTableEnum targetEnum, int dbIndex, int tbIndex);
}
