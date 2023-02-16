package com.kotkar.BiodataFinder.controller;


import com.kotkar.BiodataFinder.exception.ResourceNotFoundException;
import com.kotkar.BiodataFinder.model.Profile;
import com.kotkar.BiodataFinder.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    // GET all persons
    @GetMapping("")
    public List<Profile> getAllPersons() {
        return profileRepository.findAll();
    }

    // GET a profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getPersonById(@PathVariable(value = "id") String personId) throws ResourceNotFoundException {
        Profile profile = profileRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + personId));
        return ResponseEntity.ok().body(profile);
    }

    // CREATE a new profile
    @PostMapping("")
    public Profile createPerson(@Valid @RequestBody Profile profile) {
        profile.setId(UUID.randomUUID().toString());
        final Optional<Profile> createdProfile = profileRepository.save(profile);
        return createdProfile.get();
    }

    // UPDATE a profile by ID
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updatePerson(@PathVariable(value = "id") String personId, @Valid @RequestBody Profile personDetails) throws ResourceNotFoundException {
        Profile profile = profileRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + personId));

        profile.setFirstName(personDetails.getFirstName());
        profile.setMiddleName(personDetails.getMiddleName());
        profile.setLastName(personDetails.getLastName());
        profile.setBirthDate(personDetails.getBirthDate());

        final Optional<Profile> updatedPerson = profileRepository.save(profile);
        return ResponseEntity.ok(updatedPerson.get());
    }

    // DELETE a profile by ID
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable(value = "id") String personId) throws ResourceNotFoundException {
        Profile profile = profileRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + personId));

        profileRepository.delete(profile);
    }
}
