package org.triumphxx.maildelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.triumphxx.maildelivery.send.SendTemplateService;

/**
 * @author:wangyupeng
 * @Date:2019-12-10
 * @Time:22:36
 * @desc:
 **/
@RestController
@RequestMapping("/send")
public class SendTemplateController {

    @Autowired
    SendTemplateService sendTemplateService;

    @RequestMapping(value = "/template/email", method = RequestMethod.POST)
    public String sendTemplateApi() {

        return sendTemplateService.sendTemplate();
    }
}
