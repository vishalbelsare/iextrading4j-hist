package pl.zankowski.iextrading4j.hist.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXMessageTypeTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXMessageType value = IEXMessageType.OFFICIAL_PRICE_MESSAGE;

        final IEXMessageType result = IEXMessageType.getMessageType(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXMessageType.getMessageType((byte) 0x11));
    }

}
