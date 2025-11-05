package abstract_factory_pattern.concreteproducts;

import abstract_factory_pattern.abstractproducts.PhoneNumber;

public class ESPhoneNumber implements PhoneNumber {
    private final String nationalNumber;
    private static final String CC = "+34";

    public ESPhoneNumber(String raw){
        var digits = raw == null ? "" : raw.replaceAll("[^+\\d]", "");
        digits = digits.replaceFirst("^00", "+"); // 0034 -> +34

        if (digits.startsWith("+34")) {
            this.nationalNumber = digits.substring(3).replaceAll("\\D", "");
        } else {
            this.nationalNumber = digits.replaceAll("\\D", "");
        }
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    @Override
    public boolean validate(){
        return nationalNumber.matches("[6789]\\d{8}");
    }

    @Override
    public String formatNational(){
        if (!validate()) return nationalNumber;
        return nationalNumber.replaceAll("(\\d{3})(\\d{3})(\\d{3})", "$1 $2 $3");
    }

    @Override
    public String formatInternational(){
        return CC + " " + formatNational();
    }

    @Override
    public String toE164(){
        return CC + nationalNumber;
    }
}
