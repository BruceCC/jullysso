package org.zcm.julysso.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zcm.julysso.auth.bean.AccountState;
import org.zcm.julysso.bean.UserLoginInfoBean;
import org.zcm.julysso.service.UserLoginInfoService;

import java.util.ArrayList;
import java.util.List;
/**
 * Custom UserDetails Service, for suporting Custom JDBC datasource
 * @author Bruce Zhong
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserLoginInfoService userLoginInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLoginInfoBean userLoginInfoBean = userLoginInfoService.findUserByAccountNo(username);
        CustomUserDetails userDetails = createCustomUserDetails(userLoginInfoBean);
        if (null == userDetails){
            throw new UsernameNotFoundException("no user found");
        } else{
            //List<UserRole> roles = userRoleService.getRoleByUser(user);
            //userDetails.setSimpleGrantedAuthorities(createAuthorities(roles));
            return userDetails;
        }
    }

    /**
     * Authorities string conversion
     * @param roleStr
     * @return
     */
    private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }

    /**
     * Authorities string conversion
     * @param userLoginInfoBean
     * @return
     */
    private  CustomUserDetails createCustomUserDetails(UserLoginInfoBean userLoginInfoBean, List<SimpleGrantedAuthority> simpleGrantedAuthorities){
        CustomUserDetails userDetails = null;
        if (null != userLoginInfoBean){
            userDetails = new CustomUserDetails();
            userDetails.setUserId(userLoginInfoBean.getUserId());
            userDetails.setEmail(userLoginInfoBean.getEmail());
            userDetails.setLoginName(userLoginInfoBean.getLoginName());
            userDetails.setMobile(userLoginInfoBean.getMobile());
            userDetails.setPassword(userLoginInfoBean.getPassword());
            userDetails.setState(AccountState.valueOf(userLoginInfoBean.getState()));
            userDetails.setSimpleGrantedAuthorities(simpleGrantedAuthorities);
        }
        return userDetails;
    }

    /**
     * Authorities string conversion
     * @param userLoginInfoBean
     * @return
     */
    private  CustomUserDetails createCustomUserDetails(UserLoginInfoBean userLoginInfoBean){
        return createCustomUserDetails(userLoginInfoBean, null);
    }
}
