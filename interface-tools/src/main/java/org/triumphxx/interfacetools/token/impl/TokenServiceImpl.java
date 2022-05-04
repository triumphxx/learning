package org.triumphxx.interfacetools.token.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.triumphxx.interfacetools.constant.Constant;
import org.triumphxx.interfacetools.exception.IdempotentException;
import org.triumphxx.interfacetools.redis.RedisService;
import org.triumphxx.interfacetools.token.TokenService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author:triumphxx
 * @Date:2020/8/29
 * @Time:10:54 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: Token生成服务实现类
 **/
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;

    @Value("${key.expire.time}")
    String expireTime;

    /**
     * 创建token
     *
     * @return
     */
    @Override
    public String createToken() {
        String str = UUID.randomUUID().toString();
        StringBuilder token = new StringBuilder();
        try {
            //token拼接一个前缀
            token.append(Constant.Redis.TOKEN_PREFIX).append(str);
            long expire = Long.valueOf(expireTime);
            redisService.setEx(token.toString(), token.toString(),expire);
            boolean notEmpty = StringUtils.isEmpty(token.toString());
            if (!notEmpty) {
                return token.toString();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * 检验token
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkToken(HttpServletRequest request) throws IdempotentException {
        //获取Header中的token
        String token = request.getHeader(Constant.TOKEN_NAME);
        // header中不存在token
        if (StringUtils.isEmpty(token)) {
            //获取参数中的Token
            token = request.getParameter(Constant.TOKEN_NAME);
            // parameter中也不存在token
            if (StringUtils.isEmpty(token)) {
                throw new IdempotentException(Constant.ExceptionMessage.EXCEPTION_TOKEN_MESSAGE, Constant.ExceptionCode.EXCEPTION_CODE);
            }
        }
        //检查token是否存在于redis中
        if (!redisService.exists(token)) {
            throw new IdempotentException(Constant.ExceptionMessage.EXCEPTION_REDIS_TOKEN_MESSAGE, Constant.ExceptionCode.EXCEPTION_CODE);
        }
        //如果存在就将Token移除掉，防止其他的请求继续使用
//        boolean remove = redisService.remove(token);
//        if (!remove) {
//            throw new IdempotentException(Constant.ExceptionMessage.EXCEPTION_REDIS_TOKEN_EXPIRE_MESSAGE, Constant.ExceptionCode.EXCEPTION_CODE);
//        }
        return true;
    }
}
