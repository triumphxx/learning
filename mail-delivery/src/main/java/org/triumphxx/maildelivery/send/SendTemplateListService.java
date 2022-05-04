package org.triumphxx.maildelivery.send;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.triumphxx.maildelivery.entity.AddressList;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.triumphxx.maildelivery.tools.ConvertUtil.convert;

/**
 * @author:wangyupeng
 * @Date:2019-12-08
 * @Time:11:02
 * @desc:
 **/
public class SendTemplateListService {

    public static void send_template_with_attachment() throws ClientProtocolException, IOException {

        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";

        final String apiUser = "***";
        final String apiKey = "***";

        String subject = "...";

        List<AddressList> dataList = new ArrayList<>();
        dataList.add(new AddressList("to1@domain.com", "user1", "1000"));
        dataList.add(new AddressList("to2@domain.com", "user2", "2000"));

        final String xsmtpapi = convert(dataList);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpost = new HttpPost(url);

        // 涉及到附件上传, 需要使用 MultipartEntityBuilder
        MultipartEntityBuilder entity = MultipartEntityBuilder.create();
        entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        entity.setCharset(Charset.forName("UTF-8"));
        ContentType TEXT_PLAIN = ContentType.create("text/plain", Charset.forName("UTF-8"));
        entity.addTextBody("apiUser", apiUser, TEXT_PLAIN);
        entity.addTextBody("apiKey", apiKey, TEXT_PLAIN);
        entity.addTextBody("xsmtpapi", xsmtpapi, TEXT_PLAIN);
        entity.addTextBody("templateInvokeName", "test_template", TEXT_PLAIN);
        entity.addTextBody("from", "sendcloud@sendcloud.org", TEXT_PLAIN);
        entity.addTextBody("fromName", "SendCloud", TEXT_PLAIN);
        entity.addTextBody("subject", subject, TEXT_PLAIN);

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

        httpost.setEntity(entity.build());

        HttpResponse response = httpClient.execute(httpost);
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            System.out.println(EntityUtils.toString(response.getEntity()));
        } else {
            System.err.println("error");
        }
        httpost.releaseConnection();
    }


    public static void send_template_maillist() throws ClientProtocolException, IOException {

        final String url = "http://api.sendcloud.net/apiv2/mail/sendtemplate";

        final String apiUser = "***";
        final String apiKey = "***";
        // to is addressList
        final String to = "***";

        String subject = "...";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("to", to));
        params.add(new BasicNameValuePair("templateInvokeName", "test_template"));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "SendCloud"));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("useAddressList", "true"));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
            System.out.println(EntityUtils.toString(response.getEntity()));
        } else {
            System.err.println("error");
        }
        httpPost.releaseConnection();
    }
}
