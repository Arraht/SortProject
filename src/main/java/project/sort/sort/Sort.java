package project.sort.sort;

import project.sort.person.Person;

import java.util.List;

public interface Sort {

    List<Person> sort(List<Person> people);

    List<Person> createBySize(int size);
}