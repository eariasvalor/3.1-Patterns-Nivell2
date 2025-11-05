package abstract_factory_pattern.abstractfactoy;

import abstract_factory_pattern.abstractproducts.Address;
import abstract_factory_pattern.abstractproducts.PhoneNumber;

public interface ContactsFactory {
    Address addAddress(String street, String city, String regionOrProvince, String postalCode);

    PhoneNumber addPhoneNumber(String rawNumber);
}
