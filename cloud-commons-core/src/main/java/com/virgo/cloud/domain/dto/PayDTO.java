package com.virgo.cloud.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;


@SuppressWarnings({"unused"})
public class PayDTO implements Serializable {

    private Long id;
    private String payNo;
    @NotBlank(message = "订单号为必填项")
    private String orderNo;
    private BigDecimal amount;

    public PayDTO() {
    }

    public PayDTO(Long id, String payNo, String orderNo, BigDecimal amount) {
        this.id = id;
        this.payNo = payNo;
        this.orderNo = orderNo;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayDTO{" + "id=" + id + ", payNo='" + payNo + '\'' + ", orderNo='" + orderNo + '\'' + ", amount=" + amount + '}';
    }
}
