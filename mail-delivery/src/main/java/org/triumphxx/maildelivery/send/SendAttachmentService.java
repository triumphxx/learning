package org.triumphxx.maildelivery.send;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.triumphxx.maildelivery.tools.Transmitter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author:wangyupeng
 * @Date:2019-12-08
 * @Time:11:01
 * @desc:
 **/
public class SendAttachmentService {

    @Autowired
    Transmitter transmitter;


    public static void send_common_with_attachment() throws IOException {

        final String url = "http://api.sendcloud.net/apiv2/mail/send";

        final String apiUser = "***";
        final String apiKey = "***";
        final String rcpt_to = "***";

        String subject = "...";
        String html = "...";

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 涉及到附件上传, 需要使用 MultipartEntityBuilder
        MultipartEntityBuilder entity = MultipartEntityBuilder.create();
        entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        entity.setCharset(Charset.forName("UTF-8"));
        ContentType TEXT_PLAIN = ContentType.create("text/plain", Charset.forName("UTF-8"));
        entity.addTextBody("apiUser", apiUser, TEXT_PLAIN);
        entity.addTextBody("apiKey", apiKey, TEXT_PLAIN);
        entity.addTextBody("to", rcpt_to, TEXT_PLAIN);
        entity.addTextBody("from", "sendcloud@sendcloud.org", TEXT_PLAIN);
        entity.addTextBody("fromName", "SendCloud", TEXT_PLAIN);
        entity.addTextBody("subject", subject, TEXT_PLAIN);
        entity.addTextBody("html", html, TEXT_PLAIN);

        // 添加附件
        ContentType OCTEC_STREAM = ContentType.create("application/octet-stream", Charset.forName("UTF-8"));

        File file = new File("D:\\测试.txt");
        String attachName = "附件名称.txt";
        entity.addBinaryBody("attachments", file, OCTEC_STREAM, attachName);

        //多附件
        File file1 = new File("D:\\测试1.txt");
        String attachName1 = "附件名称1.txt";
        entity.addBinaryBody("attachments", file1, OCTEC_STREAM, attachName1);

        //添加附件, 文件流形式
        //File file = new File("D:\\测试.txt");
        //String attachName = "附件名称.txt";
        //entity.addBinaryBody("attachments", new FileInputStream(file), OCTEC_STREAM, attachName);
        //多附件
        //File file1 = new File("D:\\测试1.txt");
        //String attachName1 = "附件名称1.txt";
        //entity.addBinaryBody("attachments", new FileInputStream(file1), OCTEC_STREAM, attachName1);

        httpPost.setEntity(entity.build());


//        String transmitter = transmitter.transmitter(httpPost);
    }
}
