package pl.zankowski.iextrading4j.hist.api.field;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IEXPriceTest {

    @Test
    void shouldSuccessfullyCreateInstanceThroughConstructor() {
        final long number = 12345678L;
        final IEXPrice iexPrice = new IEXPrice(number);

        assertThat(iexPrice.getNumber()).isEqualTo(number);
    }

    @Test
    void shouldProperlyFormatPrice() {
        final long number = 1234567;
        final IEXPrice iexPrice = new IEXPrice(number);

        assertThat(iexPrice.toString()).isEqualTo("123.4567");
    }

    @Test
    void twoObjectsShouldBeEqualWithTheSameNumberInside() {
        final long number = 43215678L;
        final IEXPrice iexPrice_1 = new IEXPrice(number);
        final IEXPrice iexPrice_2 = new IEXPrice(number);

        assertThat(iexPrice_1).isEqualTo(iexPrice_2);
        assertThat(iexPrice_1.hashCode()).isEqualTo(iexPrice_2.hashCode());
    }

    @Test
    void compareShouldReturnOneForBiggerNumber() {
        final long biggerNumber = 12345678L;
        final long smallerNumber = 1234567L;

        final IEXPrice iexPrice_1 = new IEXPrice(biggerNumber);
        final IEXPrice iexPrice_2 = new IEXPrice(smallerNumber);

        assertThat(iexPrice_1.compareTo(iexPrice_2)).isEqualTo(1);
    }

    @Test
    void compareShouldReturnMinusOneForSmallerNumber() {
        final long biggerNumber = 12345678L;
        final long smallerNumber = 1234567L;

        final IEXPrice iexPrice_1 = new IEXPrice(smallerNumber);
        final IEXPrice iexPrice_2 = new IEXPrice(biggerNumber);

        assertThat(iexPrice_1.compareTo(iexPrice_2)).isEqualTo(-1);
    }

    @Test
    void compareShouldReturnZeroForEqualsNumbers() {
        final long number = 12345L;

        final IEXPrice iexPrice_1 = new IEXPrice(number);
        final IEXPrice iexPrice_2 = new IEXPrice(number);

        assertThat(iexPrice_1.compareTo(iexPrice_2)).isEqualTo(0);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(IEXPrice.class)
                .usingGetClass()
                .verify();
    }

}
