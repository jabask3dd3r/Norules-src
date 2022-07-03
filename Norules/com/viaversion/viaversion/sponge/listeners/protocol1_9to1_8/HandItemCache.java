package com.viaversion.viaversion.sponge.listeners.protocol1_9to1_8;

import org.spongepowered.api.item.inventory.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.lang.reflect.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.sponge.listeners.protocol1_9to1_8.sponge4.*;
import com.viaversion.viaversion.sponge.listeners.protocol1_9to1_8.sponge5.*;
import org.spongepowered.api.*;
import org.spongepowered.api.entity.living.player.*;
import java.util.*;

public class HandItemCache implements Runnable
{
    private static /* synthetic */ Map<UUID, Item> handCache;
    private static /* synthetic */ Method GET_ID;
    public static /* synthetic */ boolean CACHE;
    private static /* synthetic */ ItemGrabber grabber;
    private static /* synthetic */ Field GET_DAMAGE;
    
    public static Item getHandItem(final UUID lllllllllllllIIlIIIllllllIllllIl) {
        return HandItemCache.handCache.get(lllllllllllllIIlIIIllllllIllllIl);
    }
    
    public static Item convert(final ItemStack lllllllllllllIIlIIIllllllIlIlIII) {
        if (lllllllllllllIIlIIIllllllIlIlIII == null) {
            return new DataItem(0, (byte)0, (short)0, null);
        }
        if (HandItemCache.GET_DAMAGE == null) {
            try {
                (HandItemCache.GET_DAMAGE = lllllllllllllIIlIIIllllllIlIlIII.getClass().getDeclaredField("field_77991_e")).setAccessible(true);
            }
            catch (NoSuchFieldException lllllllllllllIIlIIIllllllIlIlllI) {
                lllllllllllllIIlIIIllllllIlIlllI.printStackTrace();
            }
        }
        if (HandItemCache.GET_ID == null) {
            try {
                HandItemCache.GET_ID = Class.forName("net.minecraft.item.Item").getDeclaredMethod("func_150891_b", Class.forName("net.minecraft.item.Item"));
            }
            catch (NoSuchMethodException lllllllllllllIIlIIIllllllIlIllIl) {
                lllllllllllllIIlIIIllllllIlIllIl.printStackTrace();
            }
            catch (ClassNotFoundException lllllllllllllIIlIIIllllllIlIllII) {
                lllllllllllllIIlIIIllllllIlIllII.printStackTrace();
            }
        }
        int lllllllllllllIIlIIIllllllIlIIlll = 0;
        if (HandItemCache.GET_ID != null) {
            try {
                lllllllllllllIIlIIIllllllIlIIlll = (int)HandItemCache.GET_ID.invoke(null, lllllllllllllIIlIIIllllllIlIlIII.getItem());
            }
            catch (IllegalAccessException lllllllllllllIIlIIIllllllIlIlIll) {
                lllllllllllllIIlIIIllllllIlIlIll.printStackTrace();
            }
            catch (InvocationTargetException lllllllllllllIIlIIIllllllIlIlIlI) {
                lllllllllllllIIlIIIllllllIlIlIlI.printStackTrace();
            }
        }
        int lllllllllllllIIlIIIllllllIlIIllI = 0;
        if (HandItemCache.GET_DAMAGE != null) {
            try {
                lllllllllllllIIlIIIllllllIlIIllI = (int)HandItemCache.GET_DAMAGE.get(lllllllllllllIIlIIIllllllIlIlIII);
            }
            catch (IllegalAccessException lllllllllllllIIlIIIllllllIlIlIIl) {
                lllllllllllllIIlIIIllllllIlIlIIl.printStackTrace();
            }
        }
        return new DataItem(lllllllllllllIIlIIIllllllIlIIlll, (byte)lllllllllllllIIlIIIllllllIlIlIII.getQuantity(), (short)lllllllllllllIIlIIIllllllIlIIllI, null);
    }
    
    static {
        HandItemCache.CACHE = false;
        HandItemCache.handCache = new ConcurrentHashMap<UUID, Item>();
        try {
            Class.forName("org.spongepowered.api.event.entity.DisplaceEntityEvent");
            HandItemCache.grabber = new Sponge4ItemGrabber();
        }
        catch (ClassNotFoundException lllllllllllllIIlIIIllllllIlIIIII) {
            HandItemCache.grabber = new Sponge5ItemGrabber();
        }
    }
    
    @Override
    public void run() {
        final List<UUID> lllllllllllllIIlIIIllllllIllIllI = new ArrayList<UUID>(HandItemCache.handCache.keySet());
        for (final Player lllllllllllllIIlIIIllllllIlllIIl : Sponge.getServer().getOnlinePlayers()) {
            HandItemCache.handCache.put(lllllllllllllIIlIIIllllllIlllIIl.getUniqueId(), convert(HandItemCache.grabber.getItem(lllllllllllllIIlIIIllllllIlllIIl)));
            lllllllllllllIIlIIIllllllIllIllI.remove(lllllllllllllIIlIIIllllllIlllIIl.getUniqueId());
        }
        for (final UUID lllllllllllllIIlIIIllllllIlllIII : lllllllllllllIIlIIIllllllIllIllI) {
            HandItemCache.handCache.remove(lllllllllllllIIlIIIllllllIlllIII);
        }
    }
}
