package com.jess.arms.di.scope;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 不是单例的注解
 */
//@Scope
@Documented
@Retention(RUNTIME)
public @interface NoSington {
}
