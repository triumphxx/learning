package org.triumphxx.maildelivery.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author:wangyupeng
 * @Date:2019-12-08
 * @Time:10:55
 * @desc:
 **/
@Component
public class EmailElement {
    @Value("${wangyp.email.urlCommon}")
    public String urlCommon;
    @Value("${wangyp.email.urlTemplate}")
    public String urlTemplate;
    @Value("${wangyp.email.apiUser}")
    public String apiUser;
    @Value("${wangyp.email.apiKey}")
    public String apiKey;
    @Value("${wangyp.email.rcpt_to}")
    public String rcpt_to;
    @Value("${wangyp.email.subject}")
    public String subject;
    @Value("${wangyp.email.html}")
    public String html;
    @Value("${wangyp.email.encodedType}")
    public String encodedType;
    @Value("${wangyp.email.fromAddress}")
    public String fromAddress;
    @Value("${wangyp.email.fromName}")
    public String fromName;
    @Value("${wangyp.email.templateInvokeName}")
    public String templateInvokeName;

    public String getTemplateInvokeName() {
        return templateInvokeName;
    }

    public String getFromName() {
        return fromName;
    }

    public String getEncodedType() {
        return encodedType;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public String getUrlCommon() {
        return urlCommon;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public String getApiUser() {
        return apiUser;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getRcpt_to() {
        return rcpt_to;
    }

    public String getSubject() {
        return subject;
    }

    public String getHtml() {
        return html;
    }


}
