package config;

import java.util.*;

public abstract class Manager<T>
{
    private /* synthetic */ List<T> contents;
    
    public void setContents(final ArrayList<T> lllllllllllllIIIIIlIIlIIlIIllllI) {
        this.contents = lllllllllllllIIIIIlIIlIIlIIllllI;
    }
    
    public List<T> getContents() {
        return this.contents;
    }
    
    public Manager() {
        this.contents = new ArrayList<T>();
    }
}
