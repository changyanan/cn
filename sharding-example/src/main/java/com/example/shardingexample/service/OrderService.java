package com.example.shardingexample.service;

import com.example.shardingexample.entity.OrderInfo;

import java.util.List;

/**
 * @author changyanan1
 */
public interface OrderService {
    /**
     * 查询列表
     *
     * @param orderInfo
     * @return
     */
    public List<OrderInfo> queryOrderInfoList(OrderInfo orderInfo);


    /**
     * 根据id查询
     *
     * @param orderInfo
     * @return
     */
    public OrderInfo queryOrderInfoByOrderId(OrderInfo orderInfo);


    /**
     * 新增数据
     *
     * @param orderInfo
     * @return
     */
    public int addOrder(OrderInfo orderInfo);
}
