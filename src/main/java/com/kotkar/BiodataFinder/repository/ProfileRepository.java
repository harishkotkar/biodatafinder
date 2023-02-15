package com.kotkar.BiodataFinder.repository;

import com.kotkar.BiodataFinder.model.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProfileRepository {
    Map<String, Profile> personMap = new HashMap<>();

    public List<Profile> findAll() {
        print();
        return new ArrayList<>(personMap.values());
    }

    public Optional<Profile> findById(String id) {
        if (Objects.isNull(personMap.get(id))) {
            return Optional.empty();
        }
        print();
        return Optional.of(personMap.get(id));
    }

    public Optional<Profile> save(Profile person) {
        personMap.put(person.getId(), person);
        print();
        return Optional.of(person);
    }

    public void delete(Profile person) {
        personMap.remove(person.getId());
        print();
    }

    public void print() {
        personMap.entrySet().forEach(stringProfileEntry -> {
            System.out.println("key : " + stringProfileEntry.getKey() + " value : "+ stringProfileEntry.getValue());
        });
    }

}
