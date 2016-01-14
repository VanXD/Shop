package com.vanxd.cas.jdbc;

import entity.bo.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;


/**
 *
 */
public class PasswordHelper {

    private final RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private final String algorithmName = "md5";
    private final int hashIterations = 2;

    /**
     *
     * @param user
     */
    public final void encryptPassword(final User user) {
        if(user.getSalt() == null) {
            user.setSalt(randomNumberGenerator.nextBytes().toHex());
        }
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
}
