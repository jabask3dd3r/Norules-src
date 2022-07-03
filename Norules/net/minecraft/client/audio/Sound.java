package net.minecraft.client.audio;

import net.minecraft.util.*;

public class Sound implements ISoundEventAccessor<Sound>
{
    private final /* synthetic */ float pitch;
    private final /* synthetic */ boolean streaming;
    private final /* synthetic */ float volume;
    private final /* synthetic */ ResourceLocation name;
    private final /* synthetic */ int weight;
    private final /* synthetic */ Type type;
    
    public Sound(final String lllllllllllllIIIIIlIllIIlIllIIII, final float lllllllllllllIIIIIlIllIIlIllIllI, final float lllllllllllllIIIIIlIllIIlIllIlIl, final int lllllllllllllIIIIIlIllIIlIlIllIl, final Type lllllllllllllIIIIIlIllIIlIllIIll, final boolean lllllllllllllIIIIIlIllIIlIllIIlI) {
        this.name = new ResourceLocation(lllllllllllllIIIIIlIllIIlIllIIII);
        this.volume = lllllllllllllIIIIIlIllIIlIllIllI;
        this.pitch = lllllllllllllIIIIIlIllIIlIllIlIl;
        this.weight = lllllllllllllIIIIIlIllIIlIlIllIl;
        this.type = lllllllllllllIIIIIlIllIIlIllIIll;
        this.streaming = lllllllllllllIIIIIlIllIIlIllIIlI;
    }
    
    public ResourceLocation getSoundLocation() {
        return this.name;
    }
    
    public float getVolume() {
        return this.volume;
    }
    
    public Type getType() {
        return this.type;
    }
    
    @Override
    public Sound cloneEntry() {
        return this;
    }
    
    @Override
    public int getWeight() {
        return this.weight;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public boolean isStreaming() {
        return this.streaming;
    }
    
    public ResourceLocation getSoundAsOggLocation() {
        return new ResourceLocation(this.name.getResourceDomain(), String.valueOf(new StringBuilder("sounds/").append(this.name.getResourcePath()).append(".ogg")));
    }
    
    public enum Type
    {
        private final /* synthetic */ String name;
        
        FILE("FILE", 0, "file"), 
        SOUND_EVENT("SOUND_EVENT", 1, "event");
        
        public static Type getByName(final String lllllllllllllIIlllIIIIlIIlIllIII) {
            final String lllllllllllllIIlllIIIIlIIlIlIlII;
            final double lllllllllllllIIlllIIIIlIIlIlIlIl = ((Type[])(Object)(lllllllllllllIIlllIIIIlIIlIlIlII = (String)(Object)values())).length;
            for (boolean lllllllllllllIIlllIIIIlIIlIlIllI = false; (lllllllllllllIIlllIIIIlIIlIlIllI ? 1 : 0) < lllllllllllllIIlllIIIIlIIlIlIlIl; ++lllllllllllllIIlllIIIIlIIlIlIllI) {
                final Type lllllllllllllIIlllIIIIlIIlIllIIl = lllllllllllllIIlllIIIIlIIlIlIlII[lllllllllllllIIlllIIIIlIIlIlIllI];
                if (lllllllllllllIIlllIIIIlIIlIllIIl.name.equals(lllllllllllllIIlllIIIIlIIlIllIII)) {
                    return lllllllllllllIIlllIIIIlIIlIllIIl;
                }
            }
            return null;
        }
        
        private Type(final String lllllllllllllIIlllIIIIlIIllIIIlI, final int lllllllllllllIIlllIIIIlIIllIIIIl, final String lllllllllllllIIlllIIIIlIIllIIIII) {
            this.name = lllllllllllllIIlllIIIIlIIllIIIII;
        }
    }
}
