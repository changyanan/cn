package com.example.shardingexample.sequence;

import com.example.shardingexample.consts.DbAndTableEnum;
import com.example.shardingexample.consts.ShardingConstant;
import com.example.shardingexample.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author changyanan1
 */
@Component(value = "redisSequenceGenerator")
public class RedisSequenceGenerator implements SequenceGenerator {
    /**
     * 序列生成器key前缀
     */
    public static String LOGIC_TABLE_NAME = "sequence:redis:";
    /**
     * 序列长度=5，不足5位的用0填充
     */
    public static int SEQUENCE_LENGTH = 5;
    /**
     * 序列最大值=90000
     */
    public static int sequence_max = 90000;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String getNextVal(DbAndTableEnum targetEnum, int dbIndex, int tbIndex) {
        //拼接key前缀
        String redisKeySuffix = new StringBuilder(targetEnum.getTableName())
                .append("_")
                .append("dbIndex")
                .append(StringUtil.fillZero(String.valueOf(dbIndex), ShardingConstant.DB_SUFFIX_LENGTH))
                .append("_tbIndex")
                .append(StringUtil.fillZero(String.valueOf(tbIndex), ShardingConstant.TABLE_SUFFIX_LENGTH))
                .append("_")
                .append(targetEnum.getShardingKey()).toString();
        String increKey = new StringBuilder(LOGIC_TABLE_NAME).append(redisKeySuffix).toString();
        long sequenceId = stringRedisTemplate.opsForValue().increment(increKey);
        //达到指定值重置序列号，预留后10000个id以便并发时缓冲
        if (sequenceId == sequence_max) {
            stringRedisTemplate.delete(increKey);
        }
        // 返回序列值，位数不够前补零
        return StringUtil.fillZero(String.valueOf(sequenceId), SEQUENCE_LENGTH);
    }
}
