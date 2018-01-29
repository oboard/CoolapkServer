package com.coolapk.market.util;

public class AuthUtils {
    static {
        System.loadLibrary("a");
    }

    /**
     * @param paramString 一個UUID
     * @return 用於請求的Token
     */
    @SuppressWarnings("JniMissingFunction")
    public static native String getAS(String paramString);
}
