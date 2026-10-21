package org.formation.coffee.domain.exception;

public abstract class CoffeeNotFoundException extends DomainException {

    public CoffeeNotFoundException(String message) {
        super(message);
    }
}
