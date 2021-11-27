package pl.zankowski.iextrading4j.hist.api.util;

import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class IEXByteConverter {

    private IEXByteConverter() {
    }

    public static long convertBytesToLong(final byte[] bytes) {
        return (long) (0xff & bytes[7]) << 56 |
                (long) (0xff & bytes[6]) << 48 |
                (long) (0xff & bytes[5]) << 40 |
                (long) (0xff & bytes[4]) << 32 |
                (long) (0xff & bytes[3]) << 24 |
                (long) (0xff & bytes[2]) << 16 |
                (long) (0xff & bytes[1]) << 8 |
                (long) (0xff & bytes[0]) << 0;
    }

    public static int convertBytesToInt(final byte[] bytes) {
        return ((0xff & bytes[3]) << 24 |
                (0xff & bytes[2]) << 16 |
                (0xff & bytes[1]) << 8 |
                (0xff & bytes[0]) << 0
        );
    }

    public static byte[] toByteArray(int value) {
        return new byte[]{
                (byte) value,
                (byte) (value >> 8 & 0xFF),
                (byte) (value >> 16 & 0xFF),
                (byte) (value >> 24 & 0xFF)};
    }

    public static int convertBytesToUnsignedShort(final byte[] bytes) {
        return convertBytesToShort(bytes) & 0xffff;
    }

    public static short convertBytesToShort(final byte[] bytes) {
        return (short) (
                (0xff & bytes[1]) << 8 |
                        (0xff & bytes[0]) << 0);
    }

    public static String convertBytesToString(final byte[] bytes) {
        return new String(bytes).trim();
    }

    public static IEXPrice convertBytesToIEXPrice(final byte[] bytes) {
        return new IEXPrice(convertBytesToLong(bytes));
    }

    public static byte[] convertToRightPaddedString(final String value, final int size) {
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
