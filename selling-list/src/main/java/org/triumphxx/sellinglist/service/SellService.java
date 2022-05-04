package org.triumphxx.sellinglist.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.triumphxx.sellinglist.entity.Sell;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-15
 */
public interface SellService extends IService<Sell> {

    void initGoodsSellTop();
}
