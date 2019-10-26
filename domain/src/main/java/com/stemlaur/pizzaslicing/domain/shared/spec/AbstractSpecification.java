package com.stemlaur.pizzaslicing.domain.shared.spec;

import lombok.EqualsAndHashCode;

/**
 * Abstract base implementation of composite {@link Specification} with default
 * implementations for {@code and}, {@code or} and {@code not}.
 */
@EqualsAndHashCode
public abstract class AbstractSpecification<T> implements Specification<T> {

    public abstract boolean isSatisfiedBy(T t);

    public Specification<T> and(final Specification<T> specification) {
        return new AndSpecification<>(this, specification);
    }
}

