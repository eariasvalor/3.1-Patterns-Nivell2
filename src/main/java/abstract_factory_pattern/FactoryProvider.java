package abstract_factory_pattern;

import abstract_factory_pattern.abstractfactoy.ContactsFactory;
import abstract_factory_pattern.concretefactories.ESContactFactory;
import abstract_factory_pattern.concretefactories.FRContactFactory;

public class FactoryProvider {
    private FactoryProvider() {}

    public static ContactsFactory getFactory(String countryCode) {
        if (countryCode == null) {
            throw new IllegalArgumentException("countryCode is null");
        }
        switch (countryCode.toUpperCase()) {
            case "ES": return new ESContactFactory();
            case "FR": return new FRContactFactory();
            default:
                throw new IllegalArgumentException("Country not supported: " + countryCode);
        }
    }

}
