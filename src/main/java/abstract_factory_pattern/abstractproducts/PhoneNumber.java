package abstract_factory_pattern.abstractproducts;

public interface PhoneNumber {
    boolean validate();
    String formatNational();
    String formatInternational();
    String toE164();
}
