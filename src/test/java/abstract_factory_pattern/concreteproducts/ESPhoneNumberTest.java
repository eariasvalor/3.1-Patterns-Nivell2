package abstract_factory_pattern.concreteproducts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ESPhoneNumberTest {

    @Test
    void validate_acceptsNumbersStartingWith6_7_8_9_andNineDigits() {
        assertTrue(new ESPhoneNumber("612345678").validate());
        assertTrue(new ESPhoneNumber("712345678").validate());
        assertTrue(new ESPhoneNumber("812345678").validate());
        assertTrue(new ESPhoneNumber("912345678").validate());
    }

    @Test
    void validate_rejectsShortOrInvalidNumbers() {
        assertFalse(new ESPhoneNumber("12345").validate());
        assertFalse(new ESPhoneNumber("512345678").validate());
        assertFalse(new ESPhoneNumber("").validate());
    }


    @Test
    void constructor_removesSpacesAndSymbolsAndPrefix0034() {
        ESPhoneNumber p = new ESPhoneNumber("0034 612-345-678");
        assertEquals("612345678", p.getNationalNumber());
    }

    @Test
    void constructor_removesPrefixPlus34() {
        ESPhoneNumber p = new ESPhoneNumber("+34 (612) 345-678");
        assertEquals("612345678", p.getNationalNumber());
    }

    @Test
    void constructor_acceptsPlainNationalNumber() {
        ESPhoneNumber p = new ESPhoneNumber("612345678");
        assertEquals("612345678", p.getNationalNumber());
    }



    @Test
    void formatNational_splitsIntoGroupsOfThreeDigits() {
        ESPhoneNumber p = new ESPhoneNumber("612345678");
        assertEquals("612 345 678", p.formatNational());
    }

    @Test
    void formatNational_returnsRawIfInvalid() {
        ESPhoneNumber p = new ESPhoneNumber("12345");
        assertEquals("12345", p.formatNational());
    }



    @Test
    void formatInternational_addsCountryCodePrefix() {
        ESPhoneNumber p = new ESPhoneNumber("612345678");
        assertEquals("+34 612 345 678", p.formatInternational());
    }

    @Test
    void formatInternational_handlesPrefixAlreadyPresent() {
        ESPhoneNumber p = new ESPhoneNumber("+34 612 345 678");
        assertEquals("+34 612 345 678", p.formatInternational());
    }



    @Test
    void toE164_returnsPlus34FollowedByDigits() {
        ESPhoneNumber p = new ESPhoneNumber("612 345 678");
        assertEquals("+34612345678", p.toE164());
    }



    @Test
    void nullInput_becomesEmptyString_andFailsValidation() {
        ESPhoneNumber p = new ESPhoneNumber(null);
        assertEquals("", p.getNationalNumber());
        assertFalse(p.validate());
    }

    @Test
    void emptyStringInput_becomesEmpty_andFailsValidation() {
        ESPhoneNumber p = new ESPhoneNumber("");
        assertEquals("", p.getNationalNumber());
        assertFalse(p.validate());
    }

    @Test
    void formattedOutputs_areConsistentAcrossEquivalentInputs() {
        ESPhoneNumber p1 = new ESPhoneNumber("612345678");
        ESPhoneNumber p2 = new ESPhoneNumber("+34 612 345 678");
        ESPhoneNumber p3 = new ESPhoneNumber("0034 612345678");

        assertEquals(p1.getNationalNumber(), p2.getNationalNumber());
        assertEquals(p1.getNationalNumber(), p3.getNationalNumber());
        assertEquals(p1.formatInternational(), p2.formatInternational());
        assertEquals(p1.toE164(), p3.toE164());
    }

}