package com.viaversion.viaversion.libs.javassist.compiler;

public class SyntaxError extends CompileError
{
    public SyntaxError(final Lex llllllllllllllIlIlIIlIlllllIlIII) {
        super(String.valueOf(new StringBuilder().append("syntax error near \"").append(llllllllllllllIlIlIIlIlllllIlIII.getTextAround()).append("\"")), llllllllllllllIlIlIIlIlllllIlIII);
    }
}
