package com.example.exam4_apilifecard.request;

public class Header {

    public static RestHeader requestHeader = new RestHeader();
    public static Location location = new Location();
    public static String clientRequestId;

    static void setHeader() {

        if (requestHeader == null) {
            requestHeader = new RestHeader();
        }
        requestHeader.setChannelCode("VIVIET_APP");
        requestHeader.setClientAddress("127.0.0.1");
        requestHeader.setClientRequestId(clientRequestId);

        requestHeader.setClientSessionId("");
        requestHeader.setDeviceId("abc-123-def-456");
        requestHeader.setExchangeIV("");
        requestHeader.setSystemCode("VIVIET");
        requestHeader.setLanguage("vi");
        requestHeader.setLocation(location);
        requestHeader.setPlatform("android");
        requestHeader.setPlatformVersion("");
        requestHeader.setSdkId("123");
        requestHeader.setSecretKey("");
        requestHeader.setSignature("");

    }


    public static void setClientRequestId(String clientRequestId) {
        Header.clientRequestId = clientRequestId;
        location.setLatitude("0");
        location.setLongitude("0");
        setHeader();

    }

    public static RestHeader getHeader() {
        return requestHeader;
    }
}
