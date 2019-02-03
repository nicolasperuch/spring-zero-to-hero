package com.github.nicolasperuch.api.car;

import com.github.nicolasperuch.api.car.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/cars")
public class CarApi {

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchCar(@PathVariable("id") Long id){
        return ok("Car: " + id);
    }

    @PostMapping("/")
    public ResponseEntity<?> insertCar(@RequestBody CarDto carDto){
        return ok(carDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id") Long id,
                                       @RequestBody CarDto carDto){
        return ok(carDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCar(@PathVariable("id") Long id){
        return ok("Car with id " + id + " was removed");
    }
}
