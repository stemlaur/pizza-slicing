package com.stemlaur.pizzaslicing.domain.shared.spec;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * AND specification, used to create a new specification that is the AND of two other specifications.
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public final class AndSpecification<T> extends AbstractSpecification<T> {

    private final Specification<T> spec1;
    private final Specification<T> spec2;

    /**
     * Create a new AND specification based on two other spec.
     *
     * @param spec1 Specification one.
     * @param spec2 Specification two.
     */
    AndSpecification(final Specification<T> spec1, final Specification<T> spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isSatisfiedBy(final T t) {
        return this.spec1.isSatisfiedBy(t) && this.spec2.isSatisfiedBy(t);
    }
}
