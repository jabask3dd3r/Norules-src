package com.viaversion.viaversion.sponge.listeners;

import com.viaversion.viaversion.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.api.protocol.*;
import org.spongepowered.api.*;
import org.spongepowered.api.entity.living.player.*;
import com.viaversion.viaversion.api.*;

public class ViaSpongeListener extends ViaListener
{
    private final /* synthetic */ SpongePlugin plugin;
    private static /* synthetic */ Field entityIdField;
    
    public ViaSpongeListener(final SpongePlugin llllllllllllllIllIIIIIlIllllIIII, final Class<? extends Protocol> llllllllllllllIllIIIIIlIlllIllll) {
        super(llllllllllllllIllIIIIIlIlllIllll);
        this.plugin = llllllllllllllIllIIIIIlIllllIIII;
    }
    
    public SpongePlugin getPlugin() {
        return this.plugin;
    }
    
    @Override
    public void register() {
        if (this.isRegistered()) {
            return;
        }
        Sponge.getEventManager().registerListeners((Object)this.plugin, (Object)this);
        this.setRegistered(true);
    }
    
    protected int getEntityId(final Player llllllllllllllIllIIIIIlIlllIIlII) {
        try {
            if (ViaSpongeListener.entityIdField == null) {
                (ViaSpongeListener.entityIdField = llllllllllllllIllIIIIIlIlllIIlII.getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("field_145783_c")).setAccessible(true);
            }
            return ViaSpongeListener.entityIdField.getInt(llllllllllllllIllIIIIIlIlllIIlII);
        }
        catch (Exception llllllllllllllIllIIIIIlIlllIIllI) {
            Via.getPlatform().getLogger().severe("Could not get the entity id, please report this on our Github");
            llllllllllllllIllIIIIIlIlllIIllI.printStackTrace();
            Via.getPlatform().getLogger().severe("Could not get the entity id, please report this on our Github");
            return -1;
        }
    }
}
