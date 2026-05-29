package com.mamezou.sample.domain.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Value;

@Value
public class Order {

    private String orderNo;
    private String customerName;
    private int productId;
    private int amount;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
