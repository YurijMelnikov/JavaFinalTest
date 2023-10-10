package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PhoneBook {
    public static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void addContactPhoneNumber(String contactName, String phoneNumber) {
        if (!phoneBook.containsKey(contactName)) {
            phoneBook.put(contactName, new ArrayList<>());
            phoneBook.get(contactName).add(phoneNumber);
        } else {
            phoneBook.get(contactName).add(phoneNumber);
        }

    }

    @Override
    public String toString() {
        //Как сортировать сам словарь, по size() списку телефонов я что-то не разобрался,
        //сделал как то топорно, список списков, где первое значение вложенного списка - ключ(фио), остальные телефоны
        ArrayList<ArrayList<String>> values = new ArrayList<>();
        int counter = 0;
        for (String key : phoneBook.keySet()) {
            values.add(new ArrayList<>());
            values.get(counter).add(key);
            for (int i = 0; i < phoneBook.get(key).size(); i++) {
                values.get(counter).add(phoneBook.get(key).get(i));
            }
            counter++;
        }
        //Сортировка списка списков по size() и переворот, что бы вывод был в порядке убывания количества телефонов
        values.sort(Comparator.comparingInt(ArrayList::size));
        Collections.reverse(values);
        //Собираем красивый вывод всех телефонов
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            print.append(values.get(i).get(0)).append("\n");
            for (int j = 1; j < values.get(i).size(); j++) {
                print.append("\t")
                     .append("тел.");
                if (values.get(i).size() > 2) {
                    print.append(j);
                }
                print.append(" - ")
                     .append(values.get(i).get(j))
                     .append("\n");
            }
        }
        return print.toString();
    }
}
