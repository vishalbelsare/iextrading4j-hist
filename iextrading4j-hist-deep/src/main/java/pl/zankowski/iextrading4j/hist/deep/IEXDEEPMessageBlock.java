package pl.zankowski.iextrading4j.hist.deep;

import pl.zankowski.iextrading4j.hist.api.IEXMessageType;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessage;
import pl.zankowski.iextrading4j.hist.api.message.IEXMessageHeader;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXOperationalHaltStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXRetailLiquidityIndicatorMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSecurityDirectoryMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXShortSalePriceTestStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXSystemEventMessage;
import pl.zankowski.iextrading4j.hist.api.message.administrative.IEXTradingStatusMessage;
import pl.zankowski.iextrading4j.hist.api.message.auction.IEXAuctionInformationMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXOfficialPriceMessage;
import pl.zankowski.iextrading4j.hist.api.message.trading.IEXTradeMessage;
import pl.zankowski.iextrading4j.hist.api.util.IEXByteConverter;
import pl.zankowski.iextrading4j.hist.deep.administrative.IEXSecurityEventMessage;
import pl.zankowski.iextrading4j.hist.deep.trading.IEXPriceLevelUpdateMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IEXDEEPMessageBlock extends IEXSegment {

    private IEXDEEPMessageBlock(
            final IEXMessageHeader messageHeader,
            final List<IEXMessage> messages) {
        super(messageHeader, messages);
    }

    public static IEXDEEPMessageBlock createIEXSegment(final byte[] packet) {
        final List<IEXMessage> iexMessages = new ArrayList<>();
        int offset = IEXMessageHeader.LENGTH;

        final IEXMessageHeader iexMessageHeader = IEXMessageHeader.createIEXMessageHeader(Arrays.copyOfRange(packet, 0, offset));

        for (int i = 0; i < iexMessageHeader.getMessageCount(); i++) {
            final short messageLength = IEXByteConverter.convertBytesToShort(Arrays.copyOfRange(packet, offset, offset = offset + 2));
            iexMessages.add(resolveMessage(Arrays.copyOfRange(packet, offset, offset = offset + messageLength)));
        }

        return new IEXDEEPMessageBlock(iexMessageHeader, iexMessages);
    }


    private static IEXMessage resolveMessage(final byte[] bytes) {
        final IEXMessageType messageType = IEXMessageType.getMessageType(bytes[0]);

        switch (messageType) {
            case TRADE_REPORT:
                return IEXTradeMessage.createIEXMessage(messageType, bytes);
            case TRADE_BREAK:
                return IEXTradeMessage.createIEXMessage(messageType, bytes);
            case SYSTEM_EVENT:
                return IEXSystemEventMessage.createIEXMessage(bytes);
            case SECURITY_DIRECTORY:
                return IEXSecurityDirectoryMessage.createIEXMessage(bytes);
            case TRADING_STATUS:
                return IEXTradingStatusMessage.createIEXMessage(bytes);
            case OPERATIONAL_HALT_STATUS:
                return IEXOperationalHaltStatusMessage.createIEXMessage(bytes);
            case SHORT_SALE_PRICE_TEST_STATUS:
                return IEXShortSalePriceTestStatusMessage.createIEXMessage(bytes);
            case OFFICIAL_PRICE_MESSAGE:
                return IEXOfficialPriceMessage.createIEXMessage(bytes);
            case SECURITY_EVENT:
                return IEXSecurityEventMessage.createIEXMessage(bytes);
            case PRICE_LEVEL_UPDATE_BUY:
                return IEXPriceLevelUpdateMessage.createIEXMessage(messageType, bytes);
            case PRICE_LEVEL_UPDATE_SELL:
                return IEXPriceLevelUpdateMessage.createIEXMessage(messageType, bytes);
            case AUCTION_INFORMATION:
                return IEXAuctionInformationMessage.createIEXMessage(bytes);
            case RETAIL_LIQUIDITY_INDICATOR:
                return IEXRetailLiquidityIndicatorMessage.createIEXMessage(bytes);
            default:
                throw new IllegalArgumentException("Failed to create IEX Message. Message type not supported: " + messageType);
        }
    }

}
