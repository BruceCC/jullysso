package org.zcm.julysso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zcm.julysso.bean.UserLoginInfoBean;
import org.zcm.julysso.dao.UserLoginInfoDAO;
import org.zcm.julysso.util.AuthenticatorUtil;

/**
 * @author Bruce Zhong
 */
@Service
public class UserLoginInfoService {
    @Autowired
    UserLoginInfoDAO userLoginInfoDAO;

    public UserLoginInfoBean findUserByAccountNo(String accountNo){
        UserLoginInfoBean bean = null;
        try {
            switch (AuthenticatorUtil.getAccountType(accountNo)){
                case ACC_TYPE_EMAIL:
                    bean = userLoginInfoDAO.getUserLoginInfoByEmail(accountNo);
                    break;
                case ACC_TYPE_MOBILE:
                    bean = userLoginInfoDAO.getUserLoginInfoByMobile(accountNo);
                    break;
                case ACC_TYPE_LOGIN_NAME:
                    bean = userLoginInfoDAO.getUserLoginInfoLoginName(accountNo);
                    break;
                case ACC_TYPE_USER_ID:
                    bean = userLoginInfoDAO.getUserLoginInfoByPK(accountNo);
                    break;
                case ACC_TYPE_UNKNOWN:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return bean;

    }
}
