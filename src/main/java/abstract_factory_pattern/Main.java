package abstract_factory_pattern;

public class Main {
    public static void main(String[] args){
        ContactManager contactManager = new ContactManager();

        Contact frenchContact = contactManager.addContact("c1", "Marie Curie", "FR",
                "10 Rue de Rivoli", "Paris", null, "75004",
                "06 12 34 56 78");

        Contact spanishContact = contactManager.addContact("c2", "Antonio López", "ES",
                "Calle Mayor 10", "Madrid", "Madrid", "28013",
                "+34 912 345 678");

        System.out.println(contactManager.formatCard("c1"));
        System.out.println(contactManager.formatCard("c2"));
    }
}
