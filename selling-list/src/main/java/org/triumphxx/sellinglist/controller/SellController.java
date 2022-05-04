package org.triumphxx.sellinglist.controller;

import cn.hutool.core.date.DateUtil;
import org.triumphxx.sellinglist.entity.Sell;
import org.triumphxx.sellinglist.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-15
 */
@RestController
@RequestMapping("/sell")
public class SellController extends BaseController {
    @Autowired
    SellService sellService;


    @RequestMapping("/addsells")
    public Boolean addSells() {
        //销售的信息如果是今天下单则在今天的销售记录上加上今天的销售量
        List<Sell> sells = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            //产生随机正整数
            int num = (int) (Math.random() * 101);
            Sell sell = new Sell();
            sell.setGoodsId(i + "");
            sell.setSellId(i + "");
            sell.setSellNum(num);
            sell.setSellDate(DateUtil.formatDate(new Date()));
            sells.add(sell);
        }
        sellService.saveBatch(sells);
        return true;
    }
}
