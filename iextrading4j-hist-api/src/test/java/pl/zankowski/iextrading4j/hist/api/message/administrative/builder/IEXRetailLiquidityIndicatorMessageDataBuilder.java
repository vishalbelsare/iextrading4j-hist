package pl.zankowski.iextrading4j.hist.api.message.administrative.builder;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXRetailLiquidityIndicatorMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXRetailLiquidityIndicator;
import pl.zankowski.iextrading4j.hist.api.message.builder.TestDataBuilder;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteTestUtil;

public class IEXRetailLiquidityIndicatorMessageDataBuilder implements TestDataBuilder {

    private IEXRetailLiquidityIndicator retailLiquidityIndicator = IEXRetailLiquidityIndicator.BUY_INTEREST;
    private long timestamp = 1494855059287436131L;
    private String symbol = "SNAP";

    public static IEXRetailLiquidityIndicatorMessage defaultRetailLiquidityIndicator() {
        return retailLiquidityIndicator().build();
    }

    public static IEXRetailLiquidityIndicatorMessageDataBuilder retailLiquidityIndicator() {
        return new IEXRetailLiquidityIndicatorMessageDataBuilder();
    }

    public IEXRetailLiquidityIndicatorMessageDataBuilder withRetailLiquidityIndicator(
            final IEXRetailLiquidityIndicator retailLiquidityIndicator) {
        this.retailLiquidityIndicator = retailLiquidityIndicator;
        return this;
    }

    public IEXRetailLiquidityIndicatorMessageDataBuilder withTimestamp(final long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IEXRetailLiquidityIndicatorMessageDataBuilder withSymbol(final String symbol) {
        this.symbol = symbol;
        return this;
    }

    @Override
    public byte[] getBytes() {
        return IEXByteTestUtil.prepareBytes(IEXRetailLiquidityIndicatorMessage.LENGTH,
                IEXMessageType.RETAIL_LIQUIDITY_INDICATOR, retailLiquidityIndicator, timestamp, symbol);
    }

    public IEXRetailLiquidityIndicatorMessage build() {
        return IEXRetailLiquidityIndicatorMessage.createIEXMessage(getBytes());
    }
}
