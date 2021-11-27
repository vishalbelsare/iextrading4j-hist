package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXDetailTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXDetail value = IEXDetail.NO_PRICE_TEST;

        final IEXDetail result = IEXDetail.getDetail(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXDetail.getDetail((byte) 0x11));
    }

}
