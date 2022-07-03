package com.viaversion.viaversion.libs.gson.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface Since {
    double value();
}
