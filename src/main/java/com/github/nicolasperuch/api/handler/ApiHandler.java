package com.github.nicolasperuch.api.handler;

import com.github.nicolasperuch.api.car.dto.CarDto;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public abstract class ApiHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex) throws NoSuchMethodException, NoSuchFieldException {

        CarDto carDto = new CarDto();
        Class targetClass = carDto.getClass();
        Field targetField = targetClass.getDeclaredField(ex.getBindingResult().getFieldError().getField());
        NotNull notNullAnnotation = targetField.getAnnotation(NotNull.class);

        return notNullAnnotation.message();
    }
}
