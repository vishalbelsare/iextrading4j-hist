package pl.zankowski.iextrading4j.hist.api.util;

public class LongConverter {

    private LongConverter() {
    }

    public static long toLong(final byte[] bytes) {
        return (long) (0xff & bytes[7]) << 56 |
                (long) (0xff & bytes[6]) << 48 |
                (long) (0xff & bytes[5]) << 40 |
                (long) (0xff & bytes[4]) << 32 |
                (long) (0xff & bytes[3]) << 24 |
                (long) (0xff & bytes[2]) << 16 |
                (long) (0xff & bytes[1]) << 8 |
                (long) (0xff & bytes[0]);
    }

    public static byte[] toByteArray(final long value) {
        return new byte[]{
                (byte) value,
                (byte) (value >> 8 & 0xff),
                (byte) (value >> 16 & 0xff),
                (byte) (value >> 24 & 0xff),
                (byte) (value >> 32 & 0xff),
                (byte) (value >> 40 & 0xff),
                (byte) (value >> 48 & 0xff),
                (byte) (value >> 56 & 0xff)};
    }

}
