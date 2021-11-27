package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXLULDTierTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXLULDTier value = IEXLULDTier.NOT_APPLICABLE;

        final IEXLULDTier result = IEXLULDTier.getLULDTier(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXLULDTier.getLULDTier((byte) 0x11));
    }

}
