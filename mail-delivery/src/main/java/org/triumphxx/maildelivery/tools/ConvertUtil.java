package org.triumphxx.maildelivery.tools;

import org.json.JSONArray;
import org.json.JSONObject;
import org.triumphxx.maildelivery.entity.AddressList;

import java.util.List;


/**
 * @author:wangyupeng
 * @Date:2019-12-08
 * @Time:10:52
 * @desc:
 **/
public class ConvertUtil {

    public static String convert(List<AddressList> dataList) {

        JSONObject ret = new JSONObject();
        JSONArray to = new JSONArray();
        JSONArray names = new JSONArray();
        JSONArray moneys = new JSONArray();
        for (AddressList a : dataList) {
            to.put(a.address);
            names.put(a.name);
            moneys.put(a.money);
        }
        JSONObject sub = new JSONObject();
        sub.put("%Name%", names);
        sub.put("%name%", moneys);
        ret.put("to", to);
        ret.put("sub", sub);
        return ret.toString();
    }
}
