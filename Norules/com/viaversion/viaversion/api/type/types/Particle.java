package com.viaversion.viaversion.api.type.types;

import java.util.*;
import com.viaversion.viaversion.api.type.*;

public class Particle
{
    private /* synthetic */ List<ParticleData> arguments;
    private /* synthetic */ int id;
    
    public void setId(final int lllllllllllllIlllllIllllIIlIIIlI) {
        this.id = lllllllllllllIlllllIllllIIlIIIlI;
    }
    
    public void setArguments(final List<ParticleData> lllllllllllllIlllllIllllIIIlIlll) {
        this.arguments = lllllllllllllIlllllIllllIIIlIlll;
    }
    
    public int getId() {
        return this.id;
    }
    
    public Particle(final int lllllllllllllIlllllIllllIIlIlIll) {
        this.arguments = new LinkedList<ParticleData>();
        this.id = lllllllllllllIlllllIllllIIlIlIll;
    }
    
    public List<ParticleData> getArguments() {
        return this.arguments;
    }
    
    public static class ParticleData
    {
        private /* synthetic */ Object value;
        private /* synthetic */ Type type;
        
        public void setType(final Type lllllllllllllllIIIlllIlllIIIIIll) {
            this.type = lllllllllllllllIIIlllIlllIIIIIll;
        }
        
        public Type getType() {
            return this.type;
        }
        
        public void setValue(final Object lllllllllllllllIIIlllIllIlllIlIl) {
            this.value = lllllllllllllllIIIlllIllIlllIlIl;
        }
        
        public ParticleData(final Type lllllllllllllllIIIlllIlllIIIlllI, final Object lllllllllllllllIIIlllIlllIIIllIl) {
            this.type = lllllllllllllllIIIlllIlllIIIlllI;
            this.value = lllllllllllllllIIIlllIlllIIIllIl;
        }
        
        public Object getValue() {
            return this.value;
        }
        
        public <T> T get() {
            return (T)this.value;
        }
    }
}
