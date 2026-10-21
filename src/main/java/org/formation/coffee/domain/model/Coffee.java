package org.formation.coffee.domain.model;

import jakarta.annotation.Nullable;

import java.util.List;
import java.util.Objects;

public final class Coffee {
    public static final int MAX_NAME_LENGTH = 255;

    private final @Nullable CoffeeId id;
    private String name;
    private Price price;

    private final List<Review> reviews;

    private Coffee(@Nullable CoffeeId id, String name, Price price, List<Review> reviews) {
        this.id = id;
        this.name = requireValidName(name);
        this.price = Objects.requireNonNull(price);
        this.reviews = List.copyOf(reviews);
    }

    public static Coffee create(String name, Price price) {
        return new Coffee(null, name, price, List.of());
    }

    public static Coffee reconstitute(CoffeeId id, String name, Price price, List<Review> reviews) {
        return new Coffee(id, name, price, reviews);
    }

    public void rename(String newName) {
        this.name = requireValidName(newName);
    }

    public void changePrice(Price newPrice) {
        this.price = Objects.requireNonNull(newPrice);
    }

    public boolean isNew() {
        return id == null;
    }

    public @Nullable CoffeeId getId() {
        return id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    private static String requireValidName(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name cannot be longer than %d characters".formatted(MAX_NAME_LENGTH));
        }
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Coffee && id.equals(((Coffee) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Coffee[id=%s, name=%s, price=%s]".formatted(id, name, price);
    }
}

