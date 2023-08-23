package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class KoalaController {
    private final Map<String, Koala> koalas = new HashMap<>();

    @GetMapping("/koalas")
    public ResponseEntity<Map<String, Koala>> getAllKoalas() {
        return new ResponseEntity<>(koalas, HttpStatus.OK);
    }

    @GetMapping("/koalas/{id}")
    public ResponseEntity<Koala> getKoalaById(@PathVariable String id) {
        if (koalas.containsKey(id)) {
            return new ResponseEntity<>(koalas.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/koalas")
    public ResponseEntity<Void> addKoala(@RequestBody Koala koala) {
        koalas.put(String.valueOf(koala.getId()), koala);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/koalas/{id}")
    public ResponseEntity<Void> updateKoala(@PathVariable String id, @RequestBody Koala updatedKoala) {
        if (koalas.containsKey(id)) {
            koalas.put(id, updatedKoala);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/koalas/{id}")
    public ResponseEntity<Void> deleteKoala(@PathVariable String id) {
        if (koalas.containsKey(id)) {
            koalas.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}