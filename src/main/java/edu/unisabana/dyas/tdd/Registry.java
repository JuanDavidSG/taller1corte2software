package edu.unisabana.dyas.tdd;

import java.util.ArrayList;
import java.util.List;

import edu.unisabana.dyas.tdd.registry.Person;
import edu.unisabana.dyas.tdd.registry.RegisterResult;

public class Registry {
    private List<Person> registeredVoters = new ArrayList<>();

    public RegisterResult registerVoter(Person p) {
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        if (p.getAge() >= 120) {
            return RegisterResult.INVALID_AGE;
        }
        for (Person registeredPerson : registeredVoters) {
            if (registeredPerson.getId() == p.getId()) {
                return RegisterResult.DUPLICATED;
            }
        }
        registeredVoters.add(p);
        return RegisterResult.VALID;
    }
}
