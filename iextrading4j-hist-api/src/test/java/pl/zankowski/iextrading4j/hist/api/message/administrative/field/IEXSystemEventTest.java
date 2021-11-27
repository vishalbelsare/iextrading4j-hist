package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXSystemEventTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXSystemEvent value = IEXSystemEvent.REGULAR_MARKET_HOURS_END;

        final IEXSystemEvent result = IEXSystemEvent.getSystemEvent(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXSystemEvent.getSystemEvent((byte) 0x11));
    }

}
