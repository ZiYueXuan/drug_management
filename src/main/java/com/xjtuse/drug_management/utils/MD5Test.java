package com.xjtuse.drug_management.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Test {
    public static String encryptToMD5(String str) {
        return DigestUtils.md5Hex(str);
    }
}
