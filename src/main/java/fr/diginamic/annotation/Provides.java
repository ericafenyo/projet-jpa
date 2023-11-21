package fr.diginamic.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Specifies that the class should be provided through a service loader for the given "type()".
 */
@Documented
@Target(TYPE)
@Retention(SOURCE)

public @interface Provides {
    Class<?> type();
}
