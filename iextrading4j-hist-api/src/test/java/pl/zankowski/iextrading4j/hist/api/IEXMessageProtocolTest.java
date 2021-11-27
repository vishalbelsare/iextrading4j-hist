package pl.zankowski.iextrading4j.hist.api;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessageProtocol;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXMessageProtocolTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXMessageProtocol value = IEXMessageProtocol.TOPS_1_6;

        final IEXMessageProtocol result = IEXMessageProtocol.getMessageProtocol(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXMessageProtocol.getMessageProtocol((byte) 0x11));
    }

}
