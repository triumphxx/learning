package org.triumphxx.interfacetools.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.triumphxx.interfacetools.annotation.Desensitized;
import org.triumphxx.interfacetools.enums.DesensitizedTypeEnum;

import java.io.IOException;
import java.util.Objects;

/**
 * @author:triumphxx
 * @Date:2022/6/8
 * @Time:11:45
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 脱敏序列化类
 **/
@NoArgsConstructor
@AllArgsConstructor
public class DesensitizedSerialize extends JsonSerializer<String> implements ContextualSerializer {

    /**
     * 脱敏的数据类型
     */
    private DesensitizedTypeEnum type;
    /**
     * 脱敏前缀不需要打码长度
     */
    private Integer prefixNoMaskLen;

    /**
     * 脱敏的后缀不需要打码长度
     */
    private Integer suffixNoMaskLen;

    /**
     * 脱敏的字符
     */
    private String maskStr;

    @Override
    public void serialize(final String origin, final JsonGenerator jsonGenerator,
                          final SerializerProvider serializerProvider) throws IOException {
        switch (type) {
            case CHINESE_NAME:
                jsonGenerator.writeString(DesensitizedUtils.chineseName(origin));
                break;
            case ID_CARD:
                jsonGenerator.writeString(DesensitizedUtils.idCardNum(origin));
                break;
            case FIXED_PHONE:
                jsonGenerator.writeString(DesensitizedUtils.fixedPhone(origin));
                break;
            case MOBILE_PHONE:
                jsonGenerator.writeString(DesensitizedUtils.mobilePhone(origin));
                break;
            case ADDRESS:
                jsonGenerator.writeString(DesensitizedUtils.address(origin));
                break;
            case EMAIL:
                jsonGenerator.writeString(DesensitizedUtils.email(origin));
                break;
            case BANK_CARD:
                jsonGenerator.writeString(DesensitizedUtils.bankCard(origin));
                break;
            case PASSWORD:
                jsonGenerator.writeString(DesensitizedUtils.password(origin));
                break;
            case KEY:
                jsonGenerator.writeString(DesensitizedUtils.key(origin));
                break;
            case CUSTOMER:
                jsonGenerator.writeString(DesensitizedUtils.desValue(origin, prefixNoMaskLen, suffixNoMaskLen, maskStr));
                break;
            default:
                throw new IllegalArgumentException("Unknow sensitive type enum " + type);
        }
    }

    @Override
    public JsonSerializer<?> createContextual(final SerializerProvider serializerProvider,
                                              final BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
                Desensitized sensitive = beanProperty.getAnnotation(Desensitized.class);
                if (sensitive == null) {
                    sensitive = beanProperty.getContextAnnotation(Desensitized.class);
                }
                if (sensitive != null) {
                    return new DesensitizedSerialize(sensitive.type(), sensitive.prefixNoMaskLen(),
                            sensitive.suffixNoMaskLen(), sensitive.maskStr());
                }
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(null);
    }

}
