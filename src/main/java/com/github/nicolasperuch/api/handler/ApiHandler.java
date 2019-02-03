package com.github.nicolasperuch.api.handler;

import com.github.nicolasperuch.api.car.dto.CarDto;
import com.github.nicolasperuch.api.handler.dto.ErrorResponseDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public abstract class ApiHandler {

    @Autowired
    private Gson gson;

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex) throws NoSuchMethodException, NoSuchFieldException {

        CarDto carDto = new CarDto();
        Class targetClass = carDto.getClass();
        Field targetField = targetClass.getDeclaredField(ex.getBindingResult().getFieldError().getField());
        NotNull notNullAnnotation = targetField.getAnnotation(NotNull.class);
        return buildErrorResponseAsJson(notNullAnnotation.message());
    }

    public String buildErrorResponseAsJson(String message){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(message);
        return gson.toJson(errorResponseDto);
    }
}
