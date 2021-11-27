package pl.zankowski.iextrading4j.hist.api.message.administrative;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.field.IEXRetailLiquidityIndicator;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class IEXRetailLiquidityIndicatorMessage extends IEXMessage {

    public static final int LENGTH = 18;

    private final IEXRetailLiquidityIndicator retailLiquidityIndicator;
    private final long timestamp;
    private final String symbol;

    public IEXRetailLiquidityIndicatorMessage(
            final IEXRetailLiquidityIndicator retailLiquidityIndicator,
            final long timestamp,
            final String symbol) {
        super(IEXMessageType.RETAIL_LIQUIDITY_INDICATOR);
        this.retailLiquidityIndicator = retailLiquidityIndicator;
        this.timestamp = timestamp;
        this.symbol = symbol;
    }

    public static IEXRetailLiquidityIndicatorMessage createIEXMessage(final byte[] bytes) {
        final IEXRetailLiquidityIndicator operationalHaltStatus =
                IEXRetailLiquidityIndicator.getRetailLiquidityIndicator(bytes[1]);
        final long timestamp = IEXByteConverter.convertBytesToLong(Arrays.copyOfRange(bytes, 2, 10));
        final String symbol = IEXByteConverter.convertBytesToString(Arrays.copyOfRange(bytes, 10, 18));

        return new IEXRetailLiquidityIndicatorMessage(operationalHaltStatus, timestamp, symbol);
    }

    public IEXRetailLiquidityIndicator getRetailLiquidityIndicator() {
        return retailLiquidityIndicator;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final IEXRetailLiquidityIndicatorMessage that = (IEXRetailLiquidityIndicatorMessage) o;
        return timestamp == that.timestamp
                && retailLiquidityIndicator == that.retailLiquidityIndicator
                && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), retailLiquidityIndicator, timestamp, symbol);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IEXRetailLiquidityIndicatorMessage.class.getSimpleName() + "[", "]")
                .add("retailLiquidityIndicator=" + retailLiquidityIndicator)
                .add("timestamp=" + timestamp)
                .add("symbol='" + symbol + "'")
                .toString();
    }
}
