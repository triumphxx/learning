package org.triumphxx.maildelivery.maildelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.triumphxx.maildelivery.maildelivery.send.SendCommonService;
/**
 * @author:wangyupeng
 * @Date:2019-12-08
 * @Time:11:58
 * @desc:
 **/
@RestController
@RequestMapping("/send")
public class SendCommonController {

    @Autowired
    SendCommonService sendCommonService;

    @RequestMapping(value = "/common/email", method = RequestMethod.POST)
    public String SendCommomApi() {

        return sendCommonService.sendCommon();
    }
}
