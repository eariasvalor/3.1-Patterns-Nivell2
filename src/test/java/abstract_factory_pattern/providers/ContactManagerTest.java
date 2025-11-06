package abstract_factory_pattern.providers;

import abstract_factory_pattern.abstractfactoy.ContactsFactory;
import abstract_factory_pattern.abstractproducts.Address;
import abstract_factory_pattern.abstractproducts.PhoneNumber;
import abstract_factory_pattern.concretefactories.ESContactFactory;
import abstract_factory_pattern.concretefactories.FRContactFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ContactManagerTest {
    protected ContactsFactory factory;

    @BeforeEach
    void setUp() {
        factory = FactoryProvider.getFactory("ES");
    }

    @Test
    void createAddress_and_Phone_returnNonNull() {
        Address a = factory.addAddress("Street", "City", "Region", "12345");
        PhoneNumber p = factory.addPhoneNumber("+000");
        assertNotNull(a);
        assertNotNull(p);
    }

    @Test
    void address_validate_formatnotNull() {
        Address a = factory.addAddress("Main", "City", "Region", "00000");
        a.validate();
        assertNotNull(a.format());
    }

    @Test
    void phone_validate_formats_e164_notNull() {
        PhoneNumber p = factory.addPhoneNumber("+000 000");
        p.validate();
        assertNotNull(p.formatNational());
        assertNotNull(p.formatInternational());
        assertNotNull(p.toE164());
    }

    @Test
    void invalid_postalCode_not5digits() {
        Address a = new ESContactFactory().addAddress("Calle", "City", "Prov", "2801"); // 4 dígitos
        assertFalse(a.validate());
    }


    @Test
    void invalid_codePostal_not5digits() {
        Address a = new FRContactFactory().addAddress("Rue", "Lyon", null, "6900");
        assertFalse(a.validate());
    }
}