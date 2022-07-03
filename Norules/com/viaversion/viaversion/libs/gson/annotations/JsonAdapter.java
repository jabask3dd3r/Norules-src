package com.viaversion.viaversion.libs.gson.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD })
public @interface JsonAdapter {
    boolean nullSafe() default true;
    
    Class<?> value();
}
