package lab1.models;

public class Person {
    private String name;
    private String surname;
    private String address;

    public Person(String name, String surname, String address) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name should be not empty.");
        }

        if (surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Surname should be not empty.");
        }

        if (address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address should be not empty.");
        }

        if (address.matches(".st")) {
            throw new IllegalArgumentException("Address should consist information about street.");
        }

        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }
}
