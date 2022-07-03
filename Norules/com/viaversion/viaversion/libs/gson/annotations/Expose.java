package com.viaversion.viaversion.libs.gson.annotations;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Expose {
    boolean serialize() default true;
    
    boolean deserialize() default true;
}
