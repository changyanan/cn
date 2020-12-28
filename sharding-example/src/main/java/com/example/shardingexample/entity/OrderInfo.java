package com.example.shardingexample.entity;

/**
 * @author changyanan1
 */
public class OrderInfo {
    private String id;
    private Long userId;
    private Long orderId;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", orderId=" + orderId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
