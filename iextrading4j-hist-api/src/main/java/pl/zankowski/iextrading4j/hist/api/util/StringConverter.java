package pl.zankowski.iextrading4j.hist.api.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringConverter {

    private StringConverter() {
    }

    /**
     * Right padded string with given size
     *
     * @param value
     * @param size array size
     * @return
     */
    public static byte[] toString(final String value, final int size) {
        byte[] outputArray = new byte[size];
        Arrays.fill(outputArray, (byte) ' ');
        final byte[] valueArray = value.getBytes(StandardCharsets.UTF_8);
        if (valueArray.length > outputArray.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(valueArray, 0, outputArray, 0, valueArray.length);
        return outputArray;
    }

}
