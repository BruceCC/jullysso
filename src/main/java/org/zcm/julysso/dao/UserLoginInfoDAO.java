package org.zcm.julysso.dao;

import org.zcm.julysso.bean.UserLoginInfoBean;

/**
 * @author Bruce Zhong
 */
public interface UserLoginInfoDAO {
    UserLoginInfoBean getUserLoginInfoByPK(String userId);

    UserLoginInfoBean getUserLoginInfoByMobile(String mobile);

    UserLoginInfoBean getUserLoginInfoByEmail(String email);

    UserLoginInfoBean getUserLoginInfoLoginName(String loginName);
}
