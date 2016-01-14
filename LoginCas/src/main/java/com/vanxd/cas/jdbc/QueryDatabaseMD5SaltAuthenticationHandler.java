package com.vanxd.cas.jdbc;

import entity.bo.User;
import org.jasig.cas.adaptors.jdbc.AbstractJdbcUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;

/**
 * 参考：QueryDatabaseAuthenticationHandler.java
 * 完成对密码MD5+SALT的验证
 * Created by wyd on 2016/1/14.
 */
public class QueryDatabaseMD5SaltAuthenticationHandler extends AbstractJdbcUsernamePasswordAuthenticationHandler {
    private final String sql = "select password, salt from sys_users where username=?";
    private PasswordHelper passwordHelper;

    public final void setPasswordHelper(final PasswordHelper passwordHelper) {
        this.passwordHelper = passwordHelper;
    }

    @Override
    protected final Principal authenticateUsernamePasswordInternal(final String username, final String password)
            throws GeneralSecurityException, PreventedException {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        try{
            User user = jdbcTemplate.queryForObject(sql, new Object[]{username}, BeanPropertyRowMapper.newInstance(User.class));
            String correctPwd = user.getPassword();
            user.setUsername(username);
            user.setPassword(password);
            passwordHelper.encryptPassword(user);
            if(!correctPwd.equals(user.getPassword())) {
                throw new FailedLoginException("Password does not match value on record.");
            }
        } catch (final IncorrectResultSizeDataAccessException var5) {
            if(var5.getActualSize() == 0) {
                throw new AccountNotFoundException(username + " not found with SQL query");
            }

            throw new FailedLoginException("Multiple records found for " + username);
        } catch (final DataAccessException var6) {
            throw new PreventedException("SQL exception while executing query for " + username, var6);
        }

        return new SimplePrincipal(username);
    }
}
