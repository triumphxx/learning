package com.triumphxx.producer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * order_base
 *
 * @author
 */
@Data
public class OrderBase implements Serializable {
    private Integer id;

    private String orderNo;

    private static final long serialVersionUID = 1L;
}