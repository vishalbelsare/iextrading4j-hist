package pl.zankowski.iextrading4j.hist.api.message.administrative.field;

import pl.zankowski.iextrading4j.hist.api.IEXByteEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.iextrading4j.hist.api.util.IEXByteEnumLookupUtil.lookup;

public enum IEXRetailLiquidityIndicator implements IEXByteEnum {

    NOT_APPLICABLE((byte) 0x20),
    BUY_INTEREST((byte) 0x41),
    SELL_INTEREST((byte) 0x42),
    BUY_AND_SELL_INTEREST((byte) 0x43);

    private static final Map<Byte, IEXRetailLiquidityIndicator> LOOKUP = new HashMap<>();

    static {
        for (final IEXRetailLiquidityIndicator value : EnumSet.allOf(IEXRetailLiquidityIndicator.class))
            LOOKUP.put(value.getCode(), value);
    }

    private final byte code;

    IEXRetailLiquidityIndicator(final byte code) {
        this.code = code;
    }

    public static IEXRetailLiquidityIndicator getRetailLiquidityIndicator(final byte code) {
        return lookup(IEXRetailLiquidityIndicator.class, LOOKUP, code);
    }

    @Override
    public byte getCode() {
        return code;
    }

}
