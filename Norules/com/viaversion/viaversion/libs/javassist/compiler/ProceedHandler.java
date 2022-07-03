package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public interface ProceedHandler
{
    void setReturnType(final JvstTypeChecker p0, final ASTList p1) throws CompileError;
    
    void doit(final JvstCodeGen p0, final Bytecode p1, final ASTList p2) throws CompileError;
}
