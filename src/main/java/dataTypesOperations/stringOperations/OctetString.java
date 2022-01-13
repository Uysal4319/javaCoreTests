package dataTypesOperations.stringOperations;

import java.io.UnsupportedEncodingException;

public class OctetString {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(fromHex("6465736372697074696f6e2020537472696e67696e2020757a756c7567756e756e207465737469206963696e206275206465736372697074696f6e20757a756e2079617a696c6d69737469722e2e"));
    }

    public static String fromHex(String s) throws UnsupportedEncodingException {
        byte bs[] = new byte[s.length() / 2];
        for (int i=0; i<s.length(); i+=2) {
            bs[i/2] = (byte) Integer.parseInt(s.substring(i, i+2), 16);
        }
        return new String(bs, "UTF8");
    }
}
