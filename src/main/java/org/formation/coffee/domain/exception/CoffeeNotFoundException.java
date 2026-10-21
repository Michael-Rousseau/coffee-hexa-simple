package org.formation.coffee.domain.exception;

import org.formation.coffee.domain.model.CoffeeId;

public class CoffeeNotFoundException extends DomainException {

    public CoffeeNotFoundException(CoffeeId id) {
        super("Coffee not found: " + id.value());
    }
}
