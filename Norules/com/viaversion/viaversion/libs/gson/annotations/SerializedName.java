package com.viaversion.viaversion.libs.gson.annotations;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SerializedName {
    String[] alternate() default {};
    
    String value();
}
