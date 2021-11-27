package pl.zankowski.iextrading4j.hist.deep.administrative.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXSecurityEventTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXSecurityEvent value = IEXSecurityEvent.CLOSING_PROCESS_COMPLETE;

        final IEXSecurityEvent result = IEXSecurityEvent.getSecurityEvent(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXSecurityEvent.getSecurityEvent((byte) 0x11));
    }

}
