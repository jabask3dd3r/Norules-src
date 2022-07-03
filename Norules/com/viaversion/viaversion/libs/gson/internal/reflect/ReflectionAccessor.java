package com.viaversion.viaversion.libs.gson.internal.reflect;

import com.viaversion.viaversion.libs.gson.internal.*;
import java.lang.reflect.*;

public abstract class ReflectionAccessor
{
    private static final /* synthetic */ ReflectionAccessor instance;
    
    static {
        instance = ((JavaVersion.getMajorJavaVersion() < 9) ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor());
    }
    
    public static ReflectionAccessor getInstance() {
        return ReflectionAccessor.instance;
    }
    
    public abstract void makeAccessible(final AccessibleObject p0);
}
