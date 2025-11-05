package abstract_factory_pattern;

import abstract_factory_pattern.abstractproducts.Address;
import abstract_factory_pattern.abstractproducts.PhoneNumber;

import java.util.Objects;

public class Contact {
    private final String id;
    private final String name;
    private final Address address;
    private final PhoneNumber phoneNumber;

    public Contact(String id, String name, Address address, PhoneNumber phoneNumber){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("The id cannot be null or blank.");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("The name cannot be null or blank.");
        }
        if(address == null){
            throw new IllegalArgumentException("The address cannot be null.");
        }
        if(phoneNumber == null){
            throw new IllegalArgumentException("The phone number cannot be null.");
        }

        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address.toString();
    }

    public String getPhoneNumber() {
        return phoneNumber.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact that)) return false;
        return id.equals(that.id);
    }

    @Override
    public String toString(){
        return "%s (%s)".formatted(name, phoneNumber.toE164());
    }


}
