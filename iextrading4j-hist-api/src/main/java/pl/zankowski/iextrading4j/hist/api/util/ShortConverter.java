package pl.zankowski.iextrading4j.hist.api.util;

public class ShortConverter {

    public static int convertBytesToUnsignedShort(final byte[] bytes) {
        return convertBytesToShort(bytes) & 0xffff;
    }

    public static short convertBytesToShort(final byte[] bytes) {
        return (short) ((0xff & bytes[1]) << 8 |
                        (0xff & bytes[0]));
    }

}
