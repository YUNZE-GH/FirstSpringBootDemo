package com.gh.firstdemo.utils.token;

import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/11 16:17
 */
public class Main {

    public static void main(String[] args) {
        // 生成token
        Encrypt encrypt = new Encrypt();
        String token = encrypt.getToken(true, "zhangchao", "张超");
        // 打印token
        System.out.println("token:" + token);
        // 解密token
        Decrypt decrypt = new Decrypt();
        DecodedJWT jwt = decrypt.deToken(token);
        System.out.println("issuer:" + jwt.getIssuer());
        System.out.println("isVip:" + jwt.getClaim("isVip").asBoolean());
        System.out.println("username:" + jwt.getClaim("username").asString());
        System.out.println("name:" + jwt.getClaim("name").asString());
        System.out.println("过期时间:" + jwt.getExpiresAt());
    }

}
