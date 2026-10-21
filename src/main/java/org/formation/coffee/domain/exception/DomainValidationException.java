package org.formation.coffee.domain.exception;

public abstract class DomainValidationException extends RuntimeException {

    public DomainValidationException(String message) {
        super(message);
    }
}
