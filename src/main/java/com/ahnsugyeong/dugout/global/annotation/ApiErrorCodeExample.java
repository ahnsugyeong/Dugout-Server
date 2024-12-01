package com.ahnsugyeong.dugout.global.annotation;

import com.ahnsugyeong.dugout.global.response.status.ErrorStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiErrorCodeExample {

    ErrorStatus[] value();

}