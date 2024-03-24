package com.virgo.cloud.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "T_PAY")
public class Pay implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 19, nullable = false)
    private Long id;
    @Column(name = "payno", length = 64, nullable = false)
    private String payNo;
    @Column(name = "orderno", length = 64, nullable = false)
    private String orderNo;
    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    private BigDecimal amount;
    @Column(name = "deleted", length = 4, nullable = false)
    private int deleted;

    public Pay() {
    }

    public Pay(Long id, String payNo, String orderNo, BigDecimal amount, int deleted) {
        this.id = id;
        this.payNo = payNo;
        this.orderNo = orderNo;
        this.amount = amount;
        this.deleted = deleted;
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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pay pay = (Pay) o;
        return deleted == pay.deleted && Objects.equals(id, pay.id) && Objects.equals(payNo, pay.payNo) && Objects.equals(orderNo, pay.orderNo) && Objects.equals(amount, pay.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payNo, orderNo, amount, deleted);
    }

    @Override
    public String toString() {
        return "Pay{" + "id=" + id + ", payNo='" + payNo + '\'' + ", orderNo='" + orderNo + '\'' + ", amount=" + amount + ", deleted=" + deleted + '}';
    }
}
