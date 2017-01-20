/**
 * Copyright (c) 2010-present Abixen Systems. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.abixen.platform.core.form.search;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchField {

    Operator operator() default Operator.LIKE;

    String domainField() default "";

    enum Operator {
        EQUALS(Values.EQUALS),
        LIKE(Values.LIKE);

        private final String name;

        public String getName() {
            return name;
        }

        Operator(String name) {
            this.name = name;
        }

        public static Operator getByName(String name) {
            for (Operator prop : values()) {
                if (prop.getName().equals(name)) {
                    return prop;
                }
            }

            throw new IllegalArgumentException(name + " is not a valid Operator");
        }

        public static class Values {
            public static final String EQUALS = "=";
            public static final String LIKE = "LIKE";
        }
    }
}