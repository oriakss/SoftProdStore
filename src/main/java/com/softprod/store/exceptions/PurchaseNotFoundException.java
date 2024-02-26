package com.softprod.store.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PurchaseNotFoundException extends EntityNotFoundException {

    public PurchaseNotFoundException(String message) {
        super(message);
    }
}