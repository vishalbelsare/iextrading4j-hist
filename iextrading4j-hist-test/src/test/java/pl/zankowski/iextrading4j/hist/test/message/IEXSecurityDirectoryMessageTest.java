package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSecurityDirectoryMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXLULDTier;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSecurityDirectoryMessage.createIEXMessage;

class IEXSecurityDirectoryMessageTest extends ExtendedUnitTestBase {

    @Test
    void testIEXSecurityDirectoryMessage() throws IOException {
        final byte[] packet = loadPacket("IEXSecurityDirectoryMessage.dump");

        final IEXSecurityDirectoryMessage message = createIEXMessage(packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.SECURITY_DIRECTORY);
        assertThat(message.getTimestamp()).isEqualTo(1509795046090464161L);
        assertThat(message.getSymbol()).isEqualTo("ZEXIT");
        assertThat(message.getRoundLotSize()).isEqualTo(100);
        assertThat(message.getAdjustedPOCPrice()).isEqualTo(new IEXPrice(100000));
        assertThat(message.getLuldTier()).isEqualTo(IEXLULDTier.TIER_1_NMS);
    }

}
