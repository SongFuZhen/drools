package com.sfz.droolsExample.entity;

import java.math.BigDecimal;

/**
 * @author sfz
 * @date Created at 2018/10/14 17:55
 * @Description
 */
public class Order {
    private Long id;
    private String nr;
    private Integer score;
    private BigDecimal amount;

    public Order() {
    }

    public Order(Long id, String nr, BigDecimal amount) {
        this.id = id;
        this.nr = nr;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", nr='" + nr + '\'' +
                ", score=" + score +
                ", amount=" + amount +
                '}';
    }
}
