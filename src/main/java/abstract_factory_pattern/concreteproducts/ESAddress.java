package abstract_factory_pattern.concreteproducts;

import abstract_factory_pattern.abstractproducts.Address;

public class ESAddress implements Address {
    private final String street;
    private final String city;
    private final String province;
    private final String postalCode;
    private static final String COUNTRY_CODE = "ES";

    public ESAddress(String street, String city, String province, String postalCode) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }



    @Override
    public boolean validate() {
        if (postalCode == null || !postalCode.matches("\\d{5}")) {
            return false;
        }
        if(street.isBlank() || city.isBlank()) {
            return false;
        }
        return true;
    }

    @Override
    public String format(){
        return "%s%n%s (%s) %s%nEspaña".formatted(street, postalCode, province, city);
    }

    @Override
    public String toString(){
        return format();
    }
}

