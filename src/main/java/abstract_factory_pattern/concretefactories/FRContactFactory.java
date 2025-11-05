package abstract_factory_pattern.concretefactories;

import abstract_factory_pattern.abstractproducts.Address;
import abstract_factory_pattern.abstractproducts.PhoneNumber;
import abstract_factory_pattern.abstractfactoy.ContactsFactory;
import abstract_factory_pattern.concreteproducts.FRAddress;
import abstract_factory_pattern.concreteproducts.FRPhoneNumber;

public class FRContactFactory implements ContactsFactory {


    @Override
    public Address addAddress(String street, String city, String regionOrProvince, String postalCode) {
        return new FRAddress(street, city, postalCode);
    }

    @Override
    public PhoneNumber addPhoneNumber(String rawNumber) {
        return new FRPhoneNumber(rawNumber);
    }
}
