package com.viaversion.viaversion.libs.javassist.tools.web;

public class BadHttpRequest extends Exception
{
    private /* synthetic */ Exception e;
    
    @Override
    public String toString() {
        if (this.e == null) {
            return super.toString();
        }
        return this.e.toString();
    }
    
    public BadHttpRequest() {
        this.e = null;
    }
    
    public BadHttpRequest(final Exception lllllllllllllIIIIIlIIlIllIIllIll) {
        this.e = lllllllllllllIIIIIlIIlIllIIllIll;
    }
}
