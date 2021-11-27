package pl.zankowski.iextrading4j.hist.api.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXByteConverterTest {

    @Test
    void shouldSuccessfullyConvertBytesToShort() {
        final short value = 24;
        byte[] bytes = IEXByteTestUtil.convert(value);

        assertThat(IEXByteConverter.convertBytesToShort(bytes)).isEqualTo(value);
    }

    @Test
    void shouldSuccessfullyConvertBytesToUnsignedShort() {
        final int value = 32817;
        byte[] bytes = IEXByteTestUtil.convertUnsignedShort(value);

        assertThat(IEXByteConverter.convertBytesToUnsignedShort(bytes)).isEqualTo(value);
    }

    @Test
    void shouldSuccessfullyConvertBytesToInt() {
        final int value = 123456;
        byte[] bytes = IEXByteTestUtil.convert(value);

        assertThat(IEXByteConverter.convertBytesToInt(bytes)).isEqualTo(value);
    }

    @Test
    void shouldSuccessfullyConvertIntegerToBytes() {
        final byte[] bytes = IEXByteConverter.toByteArray(4);
        byte[] bytes2 = IEXByteTestUtil.convert(4);
        assertThat(bytes).containsExactly(bytes2);
    }

    @Test
    void shouldSuccessfullyConvertBytesToLong() {
        final long value = 1234567891L;
        byte[] bytes = IEXByteTestUtil.convert(value);

        assertThat(IEXByteConverter.convertBytesToLong(bytes)).isEqualTo(value);
    }

    @Test
    void shouldSuccessfullyConvertBytesToIEXPrice() {
        final IEXPrice iexPrice = new IEXPrice(123456789L);
        byte[] bytes = IEXByteTestUtil.convert(iexPrice.getNumber());

        assertThat(IEXByteConverter.convertBytesToIEXPrice(bytes)).isEqualTo(iexPrice);
    }

    @Test
    void shouldSuccessfullyConvertBytesToString() {
        final String symbol = "AAPL";
        byte[] bytes = IEXByteTestUtil.convert(symbol);

        assertThat(IEXByteConverter.convertBytesToString(bytes)).isEqualTo(symbol);
    }

    @ValueSource(strings = {"user:password", "useruseruseruseruser:passwordpassword123"})
    @ParameterizedTest
    void shouldSuccessfullyConvertRightPaddedValues(final String value) {
        final byte[] bytes = IEXByteConverter.convertToRightPaddedString(value, 40);

        assertThat(bytes).hasSize(40).startsWith(value.getBytes());
    }

    @Test
    void shouldThrowAnExceptionIsValueIsExceedingArraySize() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> IEXByteConverter.convertToRightPaddedString(
                "useruseruseruseruser:passwordpassword1234", 40));
    }

}
