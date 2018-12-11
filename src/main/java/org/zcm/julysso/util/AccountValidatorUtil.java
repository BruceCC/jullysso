package org.zcm.julysso.util;

import java.util.regex.Pattern;

/**
 * @author Bruce Zhong
 */
public class AccountValidatorUtil {
    /**
     * regex for user id
     */
    public static final String REGEX_USER_ID = "^\\d{12}$";

    /**
     * regex for login name
     */
    public static final String REGEX_LOGIN_NAME = "^[a-zA-Z]\\w{1,20}$";

    /**
     * regex for password
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

    /**
     * regex for Chinese mobile
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * regex for email
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * regex for Chinese character
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * regex for Chines ID Card
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * regex for url
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * regex for ip
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     * validate user id
     * @param userId
     * @return
     */
    public static boolean isUserId(String userId) {
        return Pattern.matches(REGEX_USER_ID, userId);
    }

    /**
     * validate login name
     * @param loginName
     * @return
     */
    public static boolean isLoginName(String loginName) {
        return Pattern.matches(REGEX_LOGIN_NAME, loginName);
    }

    /**
     * validate passworrd
     * @param password
     * @return
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * validate mobile
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * validate email
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * validate Chinese character
     * @param chinese
     * @return
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * validate Chinese ID card
     * @param idCard
     * @return
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     *validate URL
     * @param url
     * @return
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * validate url
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }
}
