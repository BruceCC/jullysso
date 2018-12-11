package org.zcm.julysso.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zcm.julysso.auth.bean.AccountState;
import java.util.Collection;
import java.util.List;

/**
 * Custom UserDetails, for suporting Custom JDBC datasource
 * @author Bruce Zhong
 */

public class CustomUserDetails implements UserDetails {
    private String userId;
    private String mobile;
    private String loginName;
    private String email;
    private String password;
    private AccountState state;
    private List<SimpleGrantedAuthority> simpleGrantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !state.equals(AccountState.STATE_DELETE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !state.equals(AccountState.STATE_LOCKED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void setSimpleGrantedAuthorities(List<SimpleGrantedAuthority> simpleGrantedAuthorities) {
        this.simpleGrantedAuthorities = simpleGrantedAuthorities;
    }
}
