package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class KangarooController {
   private Map<String, Kangaroo> kangaroos;

   @PostConstruct
    public void init() {
       kangaroos = new HashMap<>();
   }

   public ResponseEntity <Map<String, Kangaroo>> getAllKangaroos() {
       return new ResponseEntity<>(kangaroos, HttpStatus.OK);
   }

    @GetMapping("/kangaroos/{id}")
    public ResponseEntity<Kangaroo> getKangarooById(@PathVariable String id) {
        if (kangaroos.containsKey(id)) {
            return new ResponseEntity<>(kangaroos.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/kangaroos")
    public ResponseEntity<Void> addKangaroo(@RequestBody Kangaroo kangaroo) {
        kangaroos.put(String.valueOf(kangaroo.getId()), kangaroo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/kangaroos/{id}")
    public ResponseEntity<Void> updateKangaroo(@PathVariable String id, @RequestBody Kangaroo updatedKangaroo) {
        if (kangaroos.containsKey(id)) {
            kangaroos.put(id, updatedKangaroo);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/kangaroos/{id}")
    public ResponseEntity<Void> deleteKangaroo(@PathVariable String id) {
        if (kangaroos.containsKey(id)) {
            kangaroos.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

