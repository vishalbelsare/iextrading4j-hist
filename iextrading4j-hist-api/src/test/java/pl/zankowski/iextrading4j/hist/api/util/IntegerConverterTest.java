package pl.zankowski.iextrading4j.hist.api.util;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerConverterTest {

    @Test
    void shouldSuccessfullyConvertLittleEndianBytesToInt() {
        final int value = 123456;
        byte[] bytes = IEXByteTestUtil.convert(value);

        assertThat(IntegerConverter.toInteger(bytes)).isEqualTo(value);
    }

    @Test
    void shouldSuccessfullyConvertIntegerToLittleEndianBytes() {
        final int testValue = 10;
        final byte[] bytes = IntegerConverter.toByteArray(testValue);
        final byte[] expectedBytes = IEXByteTestUtil.convert(testValue);

        assertThat(bytes).containsExactly(expectedBytes);
    }

}
