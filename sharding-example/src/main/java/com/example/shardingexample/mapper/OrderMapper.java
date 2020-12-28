package com.example.shardingexample.mapper;

import com.example.shardingexample.entity.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author changyanan1
 */
@Repository
public interface OrderMapper {
    /**
     * 查询某个用户订单列表
     *
     * @param orderInfo
     * @return
     */
    List<OrderInfo> queryOrderInfoList(OrderInfo orderInfo);

    /**
     * 通过订单号查询订单信息
     *
     * @param orderInfo
     * @return
     */
    OrderInfo queryOrderInfoByOrderId(OrderInfo orderInfo);

    /**
     * 插入订单信息
     *
     * @param orderInfo
     * @return
     */
    int addOrder(OrderInfo orderInfo);
}
