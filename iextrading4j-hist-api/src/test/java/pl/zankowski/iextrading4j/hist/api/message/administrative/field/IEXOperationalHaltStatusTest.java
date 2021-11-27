package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXOperationalHaltStatusTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXOperationalHaltStatus value = IEXOperationalHaltStatus.NOT_OPERATIONAL_HALTED;

        final IEXOperationalHaltStatus result = IEXOperationalHaltStatus.getOperationalHaltStatus(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class,
                () -> IEXOperationalHaltStatus.getOperationalHaltStatus((byte) 0x11));
    }

}
