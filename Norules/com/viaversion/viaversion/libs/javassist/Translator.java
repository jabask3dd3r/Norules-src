package com.viaversion.viaversion.libs.javassist;

public interface Translator
{
    void onLoad(final ClassPool p0, final String p1) throws NotFoundException, CannotCompileException;
    
    void start(final ClassPool p0) throws NotFoundException, CannotCompileException;
}
