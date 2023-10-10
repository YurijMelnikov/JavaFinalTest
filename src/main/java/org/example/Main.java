package org.example;

import static org.example.PhoneBook.addContactPhoneNumber;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        addContactPhoneNumber("Юрий", "9647887646");
        addContactPhoneNumber("Юрий", "96478876546");
        addContactPhoneNumber("Юрий", "9647887656546");
        addContactPhoneNumber("Василий Иванович", "968645884");
        addContactPhoneNumber("Ирина Анатольевна", "96765584584");
        addContactPhoneNumber("Даниил", "9680700530");
        addContactPhoneNumber("Даниил", "96875876546");
        System.out.println(phoneBook);
    }
}