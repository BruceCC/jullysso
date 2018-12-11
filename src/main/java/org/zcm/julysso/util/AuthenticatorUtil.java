package org.zcm.julysso.util;

import org.zcm.julysso.auth.bean.AccountType;

/**
 * @author Bruce Zhong
 */
public class AuthenticatorUtil {
    public static AccountType getAccountType(String accountNo){
        if (AccountValidatorUtil.isUserId(accountNo)){
            return AccountType.ACC_TYPE_USER_ID;
        }

        if (AccountValidatorUtil.isLoginName(accountNo)){
            return AccountType.ACC_TYPE_LOGIN_NAME;
        }

        if (AccountValidatorUtil.isEmail(accountNo)){
            return AccountType.ACC_TYPE_EMAIL;
        }

        if (AccountValidatorUtil.isMobile(accountNo)){
            return AccountType.ACC_TYPE_MOBILE;
        }

        return AccountType.ACC_TYPE_UNKNOWN;
    }



}
