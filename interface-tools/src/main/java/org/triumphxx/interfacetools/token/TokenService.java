package org.triumphxx.interfacetools.token;

import org.triumphxx.interfacetools.exception.IdempotentException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:triumphxx
 * @Date:2020/8/29
 * @Time:10:53 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: Token操作服务类
 **/
public interface TokenService {
    /**
     * 创建token
     * @return
     */
    String createToken() throws IdempotentException;

    /**
     * 检验token
     * @param request
     * @return
     */
    boolean checkToken(HttpServletRequest request) throws IdempotentException;
}
