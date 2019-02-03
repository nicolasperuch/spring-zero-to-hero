package com.github.nicolasperuch.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/cars")
public class CarApi {

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchCar(@PathVariable("id") Long id){
        return ok("Car: " + id);
    }
}
