package org;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

public class Main {
    public static void main(String[] args) {
        String callerId = "1";
        String callerDid = "2";
        String callStart = "3";
        String apiSecret = "4";
        String signatureTest = Base64
                .encodeBase64String(
                        new HmacUtils(HmacAlgorithms.HMAC_SHA_1, apiSecret)
                        .hmacHex(callerId + callerDid + callStart)
                        .getBytes()
                );
        System.out.println(signatureTest);
    }
}
