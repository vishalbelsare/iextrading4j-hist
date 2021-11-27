package pl.zankowski.iextrading4j.hist.api.util;

public class IntegerConverter {

    private IntegerConverter() {
    }

    /**
     * Little Endian conversion
     */
    public static int toInteger(final byte[] bytes) {
        return ((0xff & bytes[3]) << 24 |
                (0xff & bytes[2]) << 16 |
                (0xff & bytes[1]) << 8 |
                (0xff & bytes[0])
        );
    }

    /**
     * Little Endian conversion
     */
    public static byte[] toByteArray(int value) {
        return new byte[]{
                (byte) value,
                (byte) (value >> 8 & 0xff),
                (byte) (value >> 16 & 0xff),
                (byte) (value >> 24 & 0xff)};
    }

}
