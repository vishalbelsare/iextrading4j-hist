package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXShortSalePriceTestStatusTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXShortSalePriceTestStatus value = IEXShortSalePriceTestStatus.PRICE_TEST_NOT_IN_EFFECT;

        final IEXShortSalePriceTestStatus result =
                IEXShortSalePriceTestStatus.getShortSalePriceTestStatus(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class,
                () -> IEXShortSalePriceTestStatus.getShortSalePriceTestStatus((byte) 0x11));
    }

}
