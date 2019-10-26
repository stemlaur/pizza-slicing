package com.stemlaur.pizzaslicing.application;

import com.stemlaur.pizzaslicing.domain.model.Pizza;
import com.stemlaur.pizzaslicing.domain.model.Slice;
import com.stemlaur.pizzaslicing.domain.shared.spec.Specification;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
final class Input {
    private final Pizza pizza;
    private final Specification<Slice> specification;
}
