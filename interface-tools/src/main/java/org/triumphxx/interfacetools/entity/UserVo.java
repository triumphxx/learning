package org.triumphxx.interfacetools.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.triumphxx.interfacetools.annotation.Desensitized;
import org.triumphxx.interfacetools.enums.DesensitizedTypeEnum;

/**
 * @author:triumphxx
 * @Date:2022/6/8
 * @Time:11:59
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@Data
public class UserVo {
    private int id;
    /**按照名字数据进行脱敏*/
    @Desensitized(type = DesensitizedTypeEnum.CHINESE_NAME)
    private String name;

    private String description;

    /**按照手机号数据进行脱敏  type指明脱敏类别*/
    @Desensitized(type = DesensitizedTypeEnum.MOBILE_PHONE)
    private String phone;

}
