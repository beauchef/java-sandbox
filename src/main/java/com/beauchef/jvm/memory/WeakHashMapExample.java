package com.beauchef.jvm.memory;

import java.time.LocalDate;
import java.util.WeakHashMap;

/**
 * @author beauchef on 2016-09-11.
 */
public class WeakHashMapExample {

    static final class Person { }

    static class PersonMetaData {
        LocalDate date;
        PersonMetaData(int year, int month, int day) {
            this.date = LocalDate.of(year, month, day);
        }
        @Override public String toString() {
            return "PersonMetaData{" +
                    "date=" + date +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        WeakHashMap<Person, PersonMetaData> weakHashMap = new WeakHashMap<>();
        Person jf = new Person();
        weakHashMap.put(jf, new PersonMetaData(1973, 5, 2));
        PersonMetaData p = weakHashMap.get(jf);
        System.out.println(p);

        jf = null;
        System.gc();
        Thread.sleep(1000); // For the garbage collect to occur

        if (weakHashMap.containsValue(p)) {
            System.out.println("Still contains key!");
        } else {
            System.out.println("Key is gone!");
        }
    }
}
