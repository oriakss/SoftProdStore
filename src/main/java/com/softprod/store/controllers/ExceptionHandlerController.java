package com.softprod.store.controllers;

import com.softprod.store.dto.responses.ErrorResponse;
import com.softprod.store.exceptions.CustomerNotFoundException;
import com.softprod.store.exceptions.ProductNotFoundException;
import com.softprod.store.exceptions.PurchaseNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.softprod.store.utils.Constants.*;
import static java.time.LocalDateTime.now;
import static org.springframework.context.i18n.LocaleContextHolder.getLocale;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(CustomerNotFoundException.class)
    public ErrorResponse handleCustomerNotFoundException(CustomerNotFoundException exception) {
        log.warn(LOG_EXCEPTION_PATTERN, exception.getMessage());
        return ErrorResponse.builder()
                .message(messageSource.getMessage(CUSTOMER_NOT_FOUND_MESSAGE_KEY,
                        new Object[]{exception.getMessage()}, getLocale()))
                .time(now())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException(ProductNotFoundException exception) {
        log.warn(LOG_EXCEPTION_PATTERN, exception.getMessage());
        return ErrorResponse.builder()
                .message(messageSource.getMessage(PRODUCT_NOT_FOUND_MESSAGE_KEY,
                        new Object[]{exception.getMessage()}, getLocale()))
                .time(now())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(PurchaseNotFoundException.class)
    public ErrorResponse handlePurchaseNotFoundException(PurchaseNotFoundException exception) {
        log.warn(LOG_EXCEPTION_PATTERN, exception.getMessage());
        return ErrorResponse.builder()
                .message(messageSource.getMessage(PURCHASE_NOT_FOUND_MESSAGE_KEY,
                        new Object[]{exception.getMessage()}, getLocale()))
                .time(now())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        log.warn(LOG_EXCEPTION_PATTERN, exception.getMessage());
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .time(now())
                .build();
    }
}