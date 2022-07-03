package net.minecraft.client.audio;

import java.util.*;
import javax.annotation.*;

public class SoundList
{
    private final /* synthetic */ String subtitle;
    private final /* synthetic */ boolean replaceExisting;
    private final /* synthetic */ List<Sound> sounds;
    
    public SoundList(final List<Sound> lllllllllllllIIIllllIllIIlIIIIll, final boolean lllllllllllllIIIllllIllIIlIIIIlI, final String lllllllllllllIIIllllIllIIIllllIl) {
        this.sounds = lllllllllllllIIIllllIllIIlIIIIll;
        this.replaceExisting = lllllllllllllIIIllllIllIIlIIIIlI;
        this.subtitle = lllllllllllllIIIllllIllIIIllllIl;
    }
    
    public List<Sound> getSounds() {
        return this.sounds;
    }
    
    public boolean canReplaceExisting() {
        return this.replaceExisting;
    }
    
    @Nullable
    public String getSubtitle() {
        return this.subtitle;
    }
}
