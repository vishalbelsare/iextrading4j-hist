package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXOperationalHaltStatus;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.builder.IEXOperationalHaltStatusMessageDataBuilder.defaultHaltStatusMessage;

class IEXOperationalHaltStatusMessageTest {

    @Test
    void constructor() {
        final IEXOperationalHaltStatus haltStatus = IEXOperationalHaltStatus.NOT_OPERATIONAL_HALTED;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXOperationalHaltStatusMessage.LENGTH,
                IEXMessageType.OPERATIONAL_HALT_STATUS, haltStatus, timestamp, symbol);
        final IEXOperationalHaltStatusMessage message = IEXOperationalHaltStatusMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.OPERATIONAL_HALT_STATUS);
        assertThat(message.getOperationalHaltStatus()).isEqualTo(haltStatus);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(IEXOperationalHaltStatusMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(defaultHaltStatusMessage())
                .verify();
    }

}
