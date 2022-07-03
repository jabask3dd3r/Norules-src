package me.nrules.event;

import java.lang.reflect.*;
import java.util.*;
import java.lang.annotation.*;

public class EventManager
{
    private static final /* synthetic */ Map<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP;
    
    public static void shutdown() {
        EventManager.REGISTRY_MAP.clear();
    }
    
    public static void removeEnty(final Class<? extends Event> lllllllllllllIllIlIlIIIlIIIlIlII) {
        final Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> lllllllllllllIllIlIlIIIlIIIlIIll = EventManager.REGISTRY_MAP.entrySet().iterator();
        while (lllllllllllllIllIlIlIIIlIIIlIIll.hasNext()) {
            if (lllllllllllllIllIlIlIIIlIIIlIIll.next().getKey().equals(lllllllllllllIllIlIlIIIlIIIlIlII)) {
                lllllllllllllIllIlIlIIIlIIIlIIll.remove();
                break;
            }
        }
    }
    
    public static void unregister(final Object lllllllllllllIllIlIlIIIlIIlIllll) {
        for (final ArrayHelper<Data> lllllllllllllIllIlIlIIIlIIlIlllI : EventManager.REGISTRY_MAP.values()) {
            for (final Data lllllllllllllIllIlIlIIIlIIlIllIl : lllllllllllllIllIlIlIIIlIIlIlllI) {
                if (lllllllllllllIllIlIlIIIlIIlIllIl.source.equals(lllllllllllllIllIlIlIIIlIIlIllll)) {
                    lllllllllllllIllIlIlIIIlIIlIlllI.remove(lllllllllllllIllIlIlIIIlIIlIllIl);
                }
            }
        }
        cleanMap(true);
    }
    
    private static boolean isMethodBad(final Method lllllllllllllIllIlIlIIIIllllIlll, final Class<? extends Event> lllllllllllllIllIlIlIIIIllllIllI) {
        return isMethodBad(lllllllllllllIllIlIlIIIIllllIlll) || lllllllllllllIllIlIlIIIIllllIlll.getParameterTypes()[0].equals(lllllllllllllIllIlIlIIIIllllIllI);
    }
    
    static {
        REGISTRY_MAP = new HashMap<Class<? extends Event>, ArrayHelper<Data>>();
    }
    
    private static void sortListValue(final Class<? extends Event> lllllllllllllIllIlIlIIIlIIIIlIII) {
        final ArrayHelper<Data> lllllllllllllIllIlIlIIIlIIIIIlll = new ArrayHelper<Data>();
        final long lllllllllllllIllIlIlIIIIllllllll;
        final long lllllllllllllIllIlIlIIIlIIIIIIII = ((byte[])(Object)(lllllllllllllIllIlIlIIIIllllllll = (long)(Object)Priority.VALUE_ARRAY)).length;
        for (String lllllllllllllIllIlIlIIIlIIIIIIIl = (String)0; lllllllllllllIllIlIlIIIlIIIIIIIl < lllllllllllllIllIlIlIIIlIIIIIIII; ++lllllllllllllIllIlIlIIIlIIIIIIIl) {
            final byte lllllllllllllIllIlIlIIIlIIIIIllI = lllllllllllllIllIlIlIIIIllllllll[lllllllllllllIllIlIlIIIlIIIIIIIl];
            for (final Data lllllllllllllIllIlIlIIIlIIIIIlIl : EventManager.REGISTRY_MAP.get(lllllllllllllIllIlIlIIIlIIIIlIII)) {
                if (lllllllllllllIllIlIlIIIlIIIIIlIl.priority == lllllllllllllIllIlIlIIIlIIIIIllI) {
                    lllllllllllllIllIlIlIIIlIIIIIlll.add(lllllllllllllIllIlIlIIIlIIIIIlIl);
                }
            }
        }
        EventManager.REGISTRY_MAP.put(lllllllllllllIllIlIlIIIlIIIIlIII, lllllllllllllIllIlIlIIIlIIIIIlll);
    }
    
    public static void unregister(final Object lllllllllllllIllIlIlIIIlIIlIIIll, final Class<? extends Event> lllllllllllllIllIlIlIIIlIIlIIIlI) {
        if (EventManager.REGISTRY_MAP.containsKey(lllllllllllllIllIlIlIIIlIIlIIIlI)) {
            for (final Data lllllllllllllIllIlIlIIIlIIlIIIIl : EventManager.REGISTRY_MAP.get(lllllllllllllIllIlIlIIIlIIlIIIlI)) {
                if (lllllllllllllIllIlIlIIIlIIlIIIIl.source.equals(lllllllllllllIllIlIlIIIlIIlIIIll)) {
                    EventManager.REGISTRY_MAP.get(lllllllllllllIllIlIlIIIlIIlIIIlI).remove(lllllllllllllIllIlIlIIIlIIlIIIIl);
                }
            }
            cleanMap(true);
        }
    }
    
    private static void register(final Method lllllllllllllIllIlIlIIIlIIlllIII, final Object lllllllllllllIllIlIlIIIlIIlllIll) {
        final Class<?> lllllllllllllIllIlIlIIIlIIlllIlI = lllllllllllllIllIlIlIIIlIIlllIII.getParameterTypes()[0];
        final Data lllllllllllllIllIlIlIIIlIIlllIIl = new Data(lllllllllllllIllIlIlIIIlIIlllIll, lllllllllllllIllIlIlIIIlIIlllIII, lllllllllllllIllIlIlIIIlIIlllIII.getAnnotation(EventTarget.class).value());
        if (!lllllllllllllIllIlIlIIIlIIlllIIl.target.isAccessible()) {
            lllllllllllllIllIlIlIIIlIIlllIIl.target.setAccessible(true);
        }
        if (EventManager.REGISTRY_MAP.containsKey(lllllllllllllIllIlIlIIIlIIlllIlI)) {
            if (!EventManager.REGISTRY_MAP.get(lllllllllllllIllIlIlIIIlIIlllIlI).contains(lllllllllllllIllIlIlIIIlIIlllIIl)) {
                EventManager.REGISTRY_MAP.get(lllllllllllllIllIlIlIIIlIIlllIlI).add(lllllllllllllIllIlIlIIIlIIlllIIl);
                sortListValue((Class<? extends Event>)lllllllllllllIllIlIlIIIlIIlllIlI);
            }
        }
        else {
            EventManager.REGISTRY_MAP.put((Class<? extends Event>)lllllllllllllIllIlIlIIIlIIlllIlI, new ArrayHelper<Data>(lllllllllllllIllIlIlIIIlIIlllIIl) {
                {
                    this.add(lllllllllllllIllllllIllIlIIIlllI);
                }
            });
        }
    }
    
    public static void cleanMap(final boolean lllllllllllllIllIlIlIIIlIIIllIlI) {
        final Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> lllllllllllllIllIlIlIIIlIIIllIIl = EventManager.REGISTRY_MAP.entrySet().iterator();
        while (lllllllllllllIllIlIlIIIlIIIllIIl.hasNext()) {
            if (!lllllllllllllIllIlIlIIIlIIIllIlI || lllllllllllllIllIlIlIIIlIIIllIIl.next().getValue().isEmpty()) {
                lllllllllllllIllIlIlIIIlIIIllIIl.remove();
            }
        }
    }
    
    public static void register(final Object lllllllllllllIllIlIlIIIlIlIlIlII) {
        final int lllllllllllllIllIlIlIIIlIlIlIIII;
        final float lllllllllllllIllIlIlIIIlIlIlIIIl = ((Method[])(Object)(lllllllllllllIllIlIlIIIlIlIlIIII = (int)(Object)lllllllllllllIllIlIlIIIlIlIlIlII.getClass().getDeclaredMethods())).length;
        for (Exception lllllllllllllIllIlIlIIIlIlIlIIlI = (Exception)0; lllllllllllllIllIlIlIIIlIlIlIIlI < lllllllllllllIllIlIlIIIlIlIlIIIl; ++lllllllllllllIllIlIlIIIlIlIlIIlI) {
            final Method lllllllllllllIllIlIlIIIlIlIlIlIl = lllllllllllllIllIlIlIIIlIlIlIIII[lllllllllllllIllIlIlIIIlIlIlIIlI];
            if (!isMethodBad(lllllllllllllIllIlIlIIIlIlIlIlIl)) {
                register(lllllllllllllIllIlIlIIIlIlIlIlIl, lllllllllllllIllIlIlIIIlIlIlIlII);
            }
        }
    }
    
    public static void register(final Object lllllllllllllIllIlIlIIIlIlIIlIIl, final Class<? extends Event> lllllllllllllIllIlIlIIIlIlIIIlIl) {
        final short lllllllllllllIllIlIlIIIlIlIIIIIl;
        final float lllllllllllllIllIlIlIIIlIlIIIIlI = ((Method[])(Object)(lllllllllllllIllIlIlIIIlIlIIIIIl = (short)(Object)lllllllllllllIllIlIlIIIlIlIIlIIl.getClass().getDeclaredMethods())).length;
        for (byte lllllllllllllIllIlIlIIIlIlIIIIll = 0; lllllllllllllIllIlIlIIIlIlIIIIll < lllllllllllllIllIlIlIIIlIlIIIIlI; ++lllllllllllllIllIlIlIIIlIlIIIIll) {
            final Method lllllllllllllIllIlIlIIIlIlIIIlll = lllllllllllllIllIlIlIIIlIlIIIIIl[lllllllllllllIllIlIlIIIlIlIIIIll];
            if (!isMethodBad(lllllllllllllIllIlIlIIIlIlIIIlll, lllllllllllllIllIlIlIIIlIlIIIlIl)) {
                register(lllllllllllllIllIlIlIIIlIlIIIlll, lllllllllllllIllIlIlIIIlIlIIlIIl);
            }
        }
    }
    
    public static ArrayHelper<Data> get(final Class<? extends Event> lllllllllllllIllIlIlIIIIllllIIIl) {
        return EventManager.REGISTRY_MAP.get(lllllllllllllIllIlIlIIIIllllIIIl);
    }
    
    private static boolean isMethodBad(final Method lllllllllllllIllIlIlIIIIlllllIll) {
        return lllllllllllllIllIlIlIIIIlllllIll.getParameterTypes().length != 1 || !lllllllllllllIllIlIlIIIIlllllIll.isAnnotationPresent(EventTarget.class);
    }
}
