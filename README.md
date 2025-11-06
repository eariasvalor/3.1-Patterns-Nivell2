# Task S3.01 – Design Patterns (Level 2)

## Description
In this exercise, I applied the **Abstract Factory** design pattern to create a small **international contact manager**.  
The application allows adding and displaying **addresses** and **phone numbers** from different countries, considering their specific formatting rules.  
The use of this pattern makes the program **extensible**, **consistent**, and **easy to maintain** when adding new countries or formats.

---

## Project Structure
```
3.1-Patterns-Nivell2/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── abstract_factory_pattern/
│   │   │       ├── abstractfactory/
│   │   │       │   └── ContactsFactory.java
│   │   │       ├── abstractproducts/
│   │   │       │   ├── Address.java
│   │   │       │   └── PhoneNumber.java
│   │   │       ├── concretefactories/
│   │   │       │   ├── ESContactFactory.java
│   │   │       │   └── FRContactFactory.java
│   │   │       ├── concreteproducts/
│   │   │       │   ├── ESAddress.java
│   │   │       │   ├── ESPhoneNumber.java
│   │   │       │   ├── FRAddress.java
│   │   │       │   └── FRPhoneNumber.java
│   │   │       ├── providers/
│   │   │       │   ├── ContactManager.java
│   │   │       │   └── FactoryProvider.java
│   │   │       └── Main.java
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── abstract_factory_pattern/
│       │       │   ├── concreteproducts/
│       │       │   │   ├── ESAddressTest.java
│       │       │   │   ├── ESPhoneNumberTest.java
│       │       │   │   ├── FRAddressTest.java
│       │       │   │   └── FRPhoneNumberTest.java
│       │       │   └── providers/
│       │       │       └── ContactManagerTest.java
│       └── resources/
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## Functionality
The program allows users to **add and display contacts** with country-specific address and phone number formats.  
Each country has its own **factory**, which produces the appropriate versions of these objects.

### Example of console interaction
```
Enter country code (ES/FR):
> ES
Enter contact name:
> Anna López
Enter street:
> Carrer Major 5
Enter city:
> Barcelona
Enter phone number:
> 654321987

Contact created successfully!

Formatted contact card:
Anna López
Carrer Major 5, Barcelona, Spain
+34 654 321 987
```

---

## Design Pattern Used: Abstract Factory

The **Abstract Factory** pattern provides an interface for creating families of related objects (addresses and phone numbers) without specifying their concrete classes.  
This enables a clean separation between **object creation** and **application logic**.

### Key components
| Component | Description |
|------------|--------------|
| `ContactsFactory` | Abstract factory defining methods to create addresses and phone numbers. |
| `ESContactFactory`, `FRContactFactory` | Concrete factories for Spain and France. |
| `Address`, `PhoneNumber` | Abstract product classes. |
| `ESAddress`, `FRAddress`, `ESPhoneNumber`, `FRPhoneNumber` | Concrete products with specific formatting. |
| `FactoryProvider` | Returns the proper factory based on user input. |
| `ContactManager` | Handles contact creation and formatting logic. |
| `Main` | Entry point of the program, manages user interaction. |

---

## Technical Requirements
- **Java 17** or higher  
- **Maven** project  
- Dependencies defined in `pom.xml` (JUnit for testing, Maven Compiler Plugin)  
- Recommended IDE: **IntelliJ IDEA** or **Eclipse**

---

## Execution
Run from the command line:
```bash
cd 3.1-Patterns-Nivell2
mvn compile
mvn exec:java -Dexec.mainClass="abstract_factory_pattern.Main"
```

---

## Tests
JUnit tests are provided to ensure the correct functionality of:
- **Concrete product formatting** (`ESAddressTest`, `FRAddressTest`, etc.)  
- **Contact creation and formatting** in `ContactManagerTest`
