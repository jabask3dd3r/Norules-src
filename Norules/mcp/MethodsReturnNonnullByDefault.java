package mcp;

import javax.annotation.meta.*;
import java.lang.annotation.*;
import javax.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifierDefault({ ElementType.METHOD })
@Nonnull
public @interface MethodsReturnNonnullByDefault {
}
