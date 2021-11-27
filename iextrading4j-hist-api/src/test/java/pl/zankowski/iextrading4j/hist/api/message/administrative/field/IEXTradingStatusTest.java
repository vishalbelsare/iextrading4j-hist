package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXTradingStatusTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXTradingStatus value = IEXTradingStatus.ORDER_ACCEPTANCE_PERIOD_ON_IEX;

        final IEXTradingStatus result = IEXTradingStatus.getTradingStatus(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXTradingStatus.getTradingStatus((byte) 0x11));
    }

}
