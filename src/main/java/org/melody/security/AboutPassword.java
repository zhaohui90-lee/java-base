package org.melody.security;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.io.CharArrayReader;
import java.text.ParseException;
import java.util.Arrays;

/**
 * 在使用密码的情景下，建议使用<code>char[]</code>而不是<code>String</code><br/>
 * 在Java中，String对象是不可变的，这意味着一旦一个String对象被创建，它的值就不能被修改。因此，当使用String对象存储密码时，
 * 密码可能会在内存中保留，即使程序已经完成了密码的使用，而这可能会让密码暴露给潜在的攻击者。
 * 相比之下，char[]数组是可变的，可以手动清除存储的数据，这使得它更适合用于存储敏感信息，例如密码。在使用完密码后，
 * 可以通过将数组的元素设置为随机值来立即清除密码。在Java中，可以使用Arrays.fill(char[], char)方法来清空数组。
 * 另外，由于String对象是不可变的，当使用字符串连接操作符（例如+）将字符串连接起来时，会创建新的String对象，
 * 而旧的String对象则可能仍然留在内存中，从而增加了暴露密码的风险。而使用char[]数组，可以避免创建新的对象，从而降低了暴露密码的风险。
 * 总之，使用char[]数组来存储密码可以提高密码的安全性，因为它可以手动清除存储的数据，并且可以避免不必要的内存操作。
 * @author lizhaohui
 * @since 2023/2/16
 */
public class AboutPassword {

    public static void main(String[] args) throws ParseException {
        String password = "123456";
        char[] psw = {'1','2','3','4','5','6'};
        System.out.println(passwordAddSalt(password));
        System.out.println(passwordAddSalt(psw));
        Arrays.fill(psw, '0');
        System.out.println(psw);
    }

    public static String passwordAddSalt(String rawPassword) {
        // 生成随机秘钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        // 构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        // 加密为16进制表示
        return aes.encryptHex(rawPassword);
    }

    public static String passwordAddSalt(char[] rawPassword) {
        // 生成随机秘钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        // 构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        // 加密为16进制表示
        return aes.encryptHex(new CharArrayReader(rawPassword).toString());
    }

}
