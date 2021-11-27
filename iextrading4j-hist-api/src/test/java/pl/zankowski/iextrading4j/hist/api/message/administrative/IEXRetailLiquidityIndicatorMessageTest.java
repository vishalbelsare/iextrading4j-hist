package pl.zankowski.iextrading4j.hist.api.message.administrative;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;
import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXRetailLiquidityIndicator;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zankowski.iextrading4j.hist.api.message.administrative.builder.IEXRetailLiquidityIndicatorMessageDataBuilder.defaultRetailLiquidityIndicator;

class IEXRetailLiquidityIndicatorMessageTest {

    @Test
    void constructor() {
        final IEXRetailLiquidityIndicator retailLiquidityIndicator = IEXRetailLiquidityIndicator.BUY_AND_SELL_INTEREST;
        final long timestamp = 1494855059287436131L;
        final String symbol = "SNAP";

        final byte[] bytes = IEXByteTestUtil.prepareBytes(IEXRetailLiquidityIndicatorMessage.LENGTH,
                IEXMessageType.RETAIL_LIQUIDITY_INDICATOR, retailLiquidityIndicator, timestamp, symbol);
        final IEXRetailLiquidityIndicatorMessage message = IEXRetailLiquidityIndicatorMessage.createIEXMessage(bytes);

        assertThat(message.getMessageType()).isEqualTo(IEXMessageType.RETAIL_LIQUIDITY_INDICATOR);
        assertThat(message.getRetailLiquidityIndicator()).isEqualTo(retailLiquidityIndicator);
        assertThat(message.getTimestamp()).isEqualTo(timestamp);
        assertThat(message.getSymbol()).isEqualTo(symbol);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(IEXRetailLiquidityIndicatorMessage.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(defaultRetailLiquidityIndicator())
                .verify();
    }

}
