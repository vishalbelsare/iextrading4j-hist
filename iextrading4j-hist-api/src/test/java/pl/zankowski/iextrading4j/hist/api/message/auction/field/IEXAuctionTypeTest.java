package pl.zankowski.iextrading4j.hist.api.message.auction.field;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IEXAuctionTypeTest {

    @Test
    void shouldSuccessfullyFindEnumBasedOnCode() {
        final IEXAuctionType value = IEXAuctionType.OPENING_AUCTION;

        final IEXAuctionType result = IEXAuctionType.getAuctionType(value.getCode());

        assertThat(result).isEqualTo(value);
    }

    @Test
    void shouldThrowAnExceptionForUnknownCode() {
        assertThrows(IllegalArgumentException.class, () -> IEXAuctionType.getAuctionType((byte) 0x11));
    }

}
