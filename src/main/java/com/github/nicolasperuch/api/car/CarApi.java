package com.github.nicolasperuch.api.car;

import com.github.nicolasperuch.api.car.dto.CarDto;
import com.github.nicolasperuch.api.handler.ApiHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.lang.reflect.Field;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/cars")
public class CarApi extends ApiHandler{

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchCar(@PathVariable("id") Long id){
        return ok("Car: " + id);
    }

    @PostMapping("/")
    public ResponseEntity<?> insertCar(@Valid @RequestBody CarDto carDto){
        return ok(carDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id") Long id,
                                       @Valid @RequestBody CarDto carDto){
        return ok(carDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCar(@PathVariable("id") Long id){
        return ok("Car with id " + id + " was removed");
    }

}
