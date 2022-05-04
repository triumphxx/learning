package com.triumphxx.consumer.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * tbl_points
 *
 * @author
 */
@Data
public class TblPoints implements Serializable {
    private Integer id;

    private String userId;

    private String orderNo;

    private String points;

    private String remarks;

    private static final long serialVersionUID = 1L;
}