package pl.zankowski.iextrading4j.hist.deep.trading.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXEventFlagTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXEventFlag value = IEXEventFlag.ORDER_BOOK_IS_PROCESSING_EVENT;

        final IEXEventFlag result = IEXEventFlag.getEventFlag(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXEventFlag.getEventFlag((byte) 0x11));
    }

}
