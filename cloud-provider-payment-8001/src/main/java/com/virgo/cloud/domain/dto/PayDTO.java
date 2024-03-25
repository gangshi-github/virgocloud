package com.virgo.cloud.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;

@Schema(title = "支付流水DTO")
@SuppressWarnings({"unused"})
public class PayDTO implements Serializable {
    @Schema(title = "主键ID")
    private Long id;
    @Schema(title = "支付流水号")
    private String payNo;
    @Schema(title = "订单号")
    @NotBlank(message = "订单号为必填项")
    private String orderNo;
    @Schema(title = "金额")
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
