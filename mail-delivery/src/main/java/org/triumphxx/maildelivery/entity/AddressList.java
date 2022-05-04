package org.triumphxx.maildelivery.entity;

import lombok.Data;

/**
 * @author:wangyupeng
 * @Date:2019-12-08
 * @Time:11:12
 * @desc:
 **/
@Data
public class AddressList {

    public String address;
    public String name;
    public String money;

    public AddressList(String address, String name, String money) {
        this.address = address;
        this.name = name;
        this.money = money;
    }
}


