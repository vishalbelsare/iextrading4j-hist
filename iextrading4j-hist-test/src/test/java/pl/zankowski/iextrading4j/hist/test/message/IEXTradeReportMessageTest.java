package pl.zankowski.iextrading4j.hist.test.message;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.field.IEXPrice;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.test.ExtendedUnitTestBase;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage.createIEXMessage;

class IEXTradeReportMessageTest extends ExtendedUnitTestBase {

    @Test
    void testIEXTradeReportMessage() throws IOException {
        final byte[] packet = loadPacket("IEXTradeReportMessage.dump");

        final IEXTradeMessage message = createIEXMessage(IEXMessageType.TRADE_REPORT, packet);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.TRADE_REPORT);
        assertThat(message.getTimestamp()).isEqualTo(1509799811101738406L);
        assertThat(message.getSymbol()).isEqualTo("ZXIET");
        assertThat(message.getSize()).isEqualTo(471);
        assertThat(message.getPrice()).isEqualTo(new IEXPrice(999500));
        assertThat(message.getTradeID()).isEqualTo(3914566);
    }

}
