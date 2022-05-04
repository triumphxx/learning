package org.triumphxx.maildelivery.tools;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;
import org.triumphxx.maildelivery.constant.ConstantEnum;

import java.io.IOException;

/**
 * @author:wangyupeng
 * @Date:2019-12-08
 * @Time:14:19
 * @desc: 发送邮件的及返回的封装类
 **/
@Component
public class Transmitter {

    public String transmitter(HttpPost httpPost) {
        //创建HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = null;
        String returnDescription = "";
        try {
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                returnDescription = ConstantEnum.OK.getDescription();
            } else {
                returnDescription = ConstantEnum.FAIL.getDescription();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpPost.releaseConnection();
        }
        return returnDescription;
    }

}
