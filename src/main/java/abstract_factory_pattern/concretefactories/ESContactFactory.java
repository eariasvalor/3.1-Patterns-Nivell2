package abstract_factory_pattern.concretefactories;

import abstract_factory_pattern.abstractproducts.Address;
import abstract_factory_pattern.abstractproducts.PhoneNumber;
import abstract_factory_pattern.abstractfactoy.ContactsFactory;
import abstract_factory_pattern.concreteproducts.ESAddress;
import abstract_factory_pattern.concreteproducts.FRPhoneNumber;

public class ESContactFactory implements ContactsFactory {

    @Override
    public Address addAddress(String street, String city, String regionOrProvince, String postalCode) {
        return new ESAddress(street, city, regionOrProvince, postalCode);
    }

    @Override
    public PhoneNumber addPhoneNumber(String rawNumber) {
        return new FRPhoneNumber(rawNumber);
    }
}
