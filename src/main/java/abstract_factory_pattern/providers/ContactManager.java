package abstract_factory_pattern.providers;

import abstract_factory_pattern.Contact;
import abstract_factory_pattern.abstractfactoy.ContactsFactory;
import abstract_factory_pattern.abstractproducts.Address;
import abstract_factory_pattern.abstractproducts.PhoneNumber;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContactManager {
    private final Map<String, Contact> contacts = new LinkedHashMap<>();

    public Contact addContact(String id, String name, String countryCode, String street,
                              String city, String regionOrProvince, String postalCode,
                              String rawPhone){
        ContactsFactory factory = FactoryProvider.getFactory(countryCode);

        Address address = factory.addAddress(street, city, regionOrProvince, postalCode);
        PhoneNumber phoneNumber = factory.addPhoneNumber(rawPhone);
        Contact contact = new Contact(id, name, address, phoneNumber);
        contacts.put(id, contact);
        return contact;
    }

    public String formatCard(String id) {
        Contact c = contacts.get(id);
        if (c == null) return "(no existe)";
        return """
               %s
               %s

               %s
               """.formatted(
                c.getName(),
                c.getAddress(),
                c.getPhoneNumber()
        );
    }
}
