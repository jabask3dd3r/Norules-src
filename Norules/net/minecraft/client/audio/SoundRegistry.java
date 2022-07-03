package net.minecraft.client.audio;

import net.minecraft.util.registry.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;

public class SoundRegistry extends RegistrySimple<ResourceLocation, SoundEventAccessor>
{
    private /* synthetic */ Map<ResourceLocation, SoundEventAccessor> soundRegistry;
    
    public void clearMap() {
        this.soundRegistry.clear();
    }
    
    public void add(final SoundEventAccessor llllllllllllllIIllIlIlIIlIllIlIl) {
        this.putObject(llllllllllllllIIllIlIlIIlIllIlIl.getLocation(), llllllllllllllIIllIlIlIIlIllIlIl);
    }
    
    @Override
    protected Map<ResourceLocation, SoundEventAccessor> createUnderlyingMap() {
        this.soundRegistry = (Map<ResourceLocation, SoundEventAccessor>)Maps.newHashMap();
        return this.soundRegistry;
    }
}
