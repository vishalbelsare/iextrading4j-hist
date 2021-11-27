package pl.zankowski.iextrading4j.hist.api.message.auction.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXSideTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXSide value = IEXSide.SELL_IMBALANCE;

        final IEXSide result = IEXSide.getSide(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXSide.getSide((byte) 0x11));
    }

}
