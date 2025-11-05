package abstract_factory_pattern.concreteproducts;

import abstract_factory_pattern.abstractproducts.PhoneNumber;

public class FRPhoneNumber implements PhoneNumber {
    private final String nationalNumber;
    private static final String CC = "+33";

    public FRPhoneNumber(String raw) {
        String s = raw == null ? "" : raw.replaceAll("[^+\\d]", "");
        s = s.replaceFirst("^00", "+");
        if (s.startsWith(CC)) {

            s = s.substring(CC.length()).replaceAll("\\D", "");
            if (s.startsWith("0")) s = s.substring(1);
        } else {
            s = s.replaceAll("\\D", "");
            if (s.startsWith("0")) s = s.substring(1);
        }

        this.nationalNumber = s;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    @Override
    public boolean validate() {
        return nationalNumber != null && nationalNumber.matches("[1-9]\\d{8}");
    }

    @Override
    public String formatNational() {
        if (!validate()) return (nationalNumber == null ? "" : nationalNumber);
        String withZero = "0" + nationalNumber;
        return withZero.replaceAll("(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})", "$1 $2 $3 $4 $5");
    }

    @Override
    public String formatInternational() {
        if (!validate()) return CC + " " + (nationalNumber == null ? "" : nationalNumber);
        return CC + " " + nationalNumber.replaceAll("(\\d)(\\d{2})(\\d{2})(\\d{2})(\\d{2})", "$1 $2 $3 $4 $5");
    }

    @Override
    public String toE164() {
        return CC + nationalNumber;
    }


}
