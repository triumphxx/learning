package com.triumphxx.lcnorder.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * t_order
 *
 * @author
 */
@Data
public class TOrder implements Serializable {
    private Integer tId;

    private String tName;

    private static final long serialVersionUID = 1L;

}