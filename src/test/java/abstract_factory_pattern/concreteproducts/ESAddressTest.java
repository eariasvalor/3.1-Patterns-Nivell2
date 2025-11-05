package abstract_factory_pattern.concreteproducts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ESAddressTest {

    @Test
    void valid_postalCode_5digits_shouldValidateTrue() {
        ESAddress address = new ESAddress("Calle Mayor 1", "Madrid", "Madrid", "28013");
        assertTrue(address.validate());
    }

    @Test
    void invalid_postalCode_not5digits_shouldValidateFalse() {
        ESAddress address = new ESAddress("Calle", "Madrid", "Madrid", "2801");
        assertFalse(address.validate());
    }


}