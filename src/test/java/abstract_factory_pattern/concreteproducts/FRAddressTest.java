package abstract_factory_pattern.concreteproducts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FRAddressTest {
    @Test
    void validate_returnsTrue_whenAllFieldsCorrect() {
        FRAddress address = new FRAddress("10 Rue de Rivoli", "Paris", "75004");
        assertTrue(address.validate());
    }

    @Test
    void validate_returnsFalse_whenPostalCodeNotFiveDigits() {
        FRAddress address1 = new FRAddress("Rue de Lyon", "Lyon", "6900");
        FRAddress address2 = new FRAddress("Rue de Lyon", "Lyon", "ABCDE");
        FRAddress address3 = new FRAddress("Rue de Lyon", "Lyon", null);
        assertFalse(address1.validate());
        assertFalse(address2.validate());
        assertFalse(address3.validate());
    }

    @Test
    void validate_returnsFalse_whenStreetOrCityBlank() {
        FRAddress blankStreet = new FRAddress("   ", "Paris", "75004");
        FRAddress blankCity = new FRAddress("10 Rue", "   ", "75004");
        assertFalse(blankStreet.validate());
        assertFalse(blankCity.validate());
    }


    @Test
    void format_convertsCityToUppercase() {
        FRAddress address = new FRAddress("Rue de Lyon", "Lyon", "69000");
        assertTrue(address.format().contains("69000 LYON"));
    }

    @Test
    void format_containsCountryNameFranceAtEnd() {
        FRAddress address = new FRAddress("Rue Victor Hugo", "Marseille", "13001");
        assertTrue(address.format().endsWith("FRANCE"));
    }


    @Test
    void getters_returnValuesPassedInConstructor() {
        FRAddress a = new FRAddress("Rue de la Paix", "Nice", "06000");
        assertEquals("Rue de la Paix", a.getStreet());
        assertEquals("Nice", a.getCity());
        assertEquals("06000", a.getPostalCode());
    }


    @Test
    void toString_returnsSameAsFormat() {
        FRAddress a = new FRAddress("10 Rue de Rivoli", "Paris", "75004");
        assertEquals(a.format(), a.toString());
    }


    @Test
    void validate_handlesNullValuesGracefully() {
        FRAddress a = new FRAddress(null, null, null);
        assertFalse(a.validate());
    }

    @Test
    void format_handlesLowercaseCityAndExtraSpaces() {
        FRAddress a = new FRAddress("  10  Rue  de  Rivoli ", "  paris ", "75004");
        String formatted = a.format();
        assertTrue(formatted.contains("PARIS"));
        assertTrue(formatted.startsWith("  10"));
    }

}