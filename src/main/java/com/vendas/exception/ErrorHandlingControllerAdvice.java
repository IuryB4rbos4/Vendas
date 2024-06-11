package com.vendas.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {
    /**
     * Define o formato padrão de definição do Erro que será
     * retornado pela API nesta Aplicação Web
     * @param message - Mensagem de erro
     * @return CustomErrorType - Tipo de erro personalizado
     */
    private CustomErrorType defaultCustomErrorTypeConstruct(String message) {
        return CustomErrorType.builder()
                .timestamp(LocalDateTime.now())
                .errors(new ArrayList<>())
                .message(message)
                .build();
    }

    /**
     * Define o "manuseador" para quando, de qualquer parte da
     * Aplicação Web, uma exceção do tipo VendasException
     * for lançada
     * @param VendasException - Exceção Global do projeto Commerce
     * @return CustomErrorType - Tipo de Erro Personalizado
     */
    @ExceptionHandler(VendasException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorType onVendasException(VendasException vendasException){
        return defaultCustomErrorTypeConstruct(
            vendasException.getMessage()
        );
    }

    @ExceptionHandler(VendasException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomErrorType onVendasNotFoundException(VendasException vendasException){
        return defaultCustomErrorTypeConstruct(
            vendasException.getMessage()
        );
    }



    /*
    Daqui, abaixo, seguem os tratamentos dos erros oriundos das
    validações nos controladores: @Valid (jakarta.validation)
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorType onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        CustomErrorType customErrorType = defaultCustomErrorTypeConstruct(
                "Erros de validacao encontrados"
        );
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            customErrorType.getErrors().add(fieldError.getDefaultMessage());
        }
        return customErrorType;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorType onConstraintViolation(ConstraintViolationException e) {
        CustomErrorType customErrorType = defaultCustomErrorTypeConstruct(
                "Erros de validacao encontrados"
        );
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            customErrorType.getErrors().add(violation.getMessage());
        }
        return customErrorType;
    }
}
