package abstract_factory_pattern.concreteproducts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FRPhoneNumberTest {
    @Test
    void validate_accepts9DigitsStarting1to9() {
        assertTrue(new FRPhoneNumber("612345678").validate());
        assertTrue(new FRPhoneNumber("112345678").validate());
        assertTrue(new FRPhoneNumber("912345678").validate());
    }

    @Test
    void validate_rejectsInvalidPatterns() {
        assertFalse(new FRPhoneNumber("012345678").validate());
        assertFalse(new FRPhoneNumber("12345").validate());
        assertFalse(new FRPhoneNumber("ABCDEFGHI").validate());
        assertFalse(new FRPhoneNumber("").validate());
    }


    @Test
    void constructor_removesSpacesSymbolsAndPrefix00() {
        FRPhoneNumber p = new FRPhoneNumber("0033 6 12-34-56-78");
        assertEquals("612345678", p.getNationalNumber());
    }

    @Test
    void constructor_removesPlus33AndLeadingZero() {
        FRPhoneNumber p = new FRPhoneNumber("+33 06 12 34 56 78");
        assertEquals("612345678", p.getNationalNumber());
    }

    @Test
    void constructor_removesOnlyLeadingZeroIfNational() {
        FRPhoneNumber p = new FRPhoneNumber("06 12 34 56 78");
        assertEquals("612345678", p.getNationalNumber());
    }

    @Test
    void constructor_handlesNullAsEmptyString() {
        FRPhoneNumber p = new FRPhoneNumber(null);
        assertEquals("", p.getNationalNumber());
    }


    @Test
    void formatNational_returns0X_XX_XX_XX_XX() {
        FRPhoneNumber p = new FRPhoneNumber("06 12 34 56 78");
        assertEquals("06 12 34 56 78", p.formatNational());
    }

    @Test
    void formatInternational_returnsPlus33_X_XX_XX_XX_XX() {
        FRPhoneNumber p = new FRPhoneNumber("06 12 34 56 78");
        assertEquals("+33 6 12 34 56 78", p.formatInternational());
    }

    @Test
    void formatNational_returnsRawIfInvalid() {
        FRPhoneNumber p = new FRPhoneNumber("12345");
        assertEquals("12345", p.formatNational());
    }

    @Test
    void formatInternational_returnsRawIfInvalid() {
        FRPhoneNumber p = new FRPhoneNumber("12345");
        assertEquals("+33 12345", p.formatInternational());
    }


    @Test
    void toE164_returnsPlus33FollowedByDigits() {
        FRPhoneNumber p = new FRPhoneNumber("06 12 34 56 78");
        assertEquals("+33612345678", p.toE164());
    }


    @Test
    void equivalentInputsYieldSameNationalNumber() {
        FRPhoneNumber p1 = new FRPhoneNumber("06 12 34 56 78");
        FRPhoneNumber p2 = new FRPhoneNumber("+33 6 12 34 56 78");
        FRPhoneNumber p3 = new FRPhoneNumber("0033 6 12 34 56 78");

        assertEquals(p1.getNationalNumber(), p2.getNationalNumber());
        assertEquals(p1.getNationalNumber(), p3.getNationalNumber());
        assertEquals(p1.formatInternational(), p2.formatInternational());
        assertEquals(p1.toE164(), p3.toE164());
    }


    @Test
    void validate_handlesEmptyNationalNumberGracefully() {
        FRPhoneNumber p = new FRPhoneNumber("");
        assertFalse(p.validate());
    }

    @Test
    void formatMethods_handleNullOrInvalidWithoutExceptions() {
        FRPhoneNumber p = new FRPhoneNumber(null);
        assertDoesNotThrow(() -> p.formatNational());
        assertDoesNotThrow(() -> p.formatInternational());
    }

    @Test
    void formatInternational_containsCountryCodeAlways() {
        FRPhoneNumber p = new FRPhoneNumber("06 12 34 56 78");
        assertTrue(p.formatInternational().startsWith("+33"));
    }

}