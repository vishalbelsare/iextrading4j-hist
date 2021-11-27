package pl.zankowski.iextrading4j.hist.api.message.trading.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXPriceTypeTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXPriceType value = IEXPriceType.IEX_OFFICIAL_CLOSING_PRICE;

        final IEXPriceType result = IEXPriceType.getPriceType(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXPriceType.getPriceType((byte) 0x11));
    }

}
