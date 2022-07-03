package net.minecraft.world;

import java.lang.reflect.*;

public enum DimensionType
{
    private final /* synthetic */ String suffix;
    private final /* synthetic */ int id;
    private final /* synthetic */ String name;
    
    OVERWORLD(0, "overworld", "", (Class<? extends WorldProvider>)WorldProviderSurface.class);
    
    private final /* synthetic */ Class<? extends WorldProvider> clazz;
    
    THE_END(1, "the_end", "_end", (Class<? extends WorldProvider>)WorldProviderEnd.class), 
    NETHER(-1, "the_nether", "_nether", (Class<? extends WorldProvider>)WorldProviderHell.class);
    
    public WorldProvider createDimension() {
        try {
            final Constructor<? extends WorldProvider> lllllllllllllllllllllIllllllIlII = this.clazz.getConstructor((Class<?>[])new Class[0]);
            return (WorldProvider)lllllllllllllllllllllIllllllIlII.newInstance(new Object[0]);
        }
        catch (NoSuchMethodException lllllllllllllllllllllIllllllIIll) {
            throw new Error("Could not create new dimension", lllllllllllllllllllllIllllllIIll);
        }
        catch (InvocationTargetException lllllllllllllllllllllIllllllIIlI) {
            throw new Error("Could not create new dimension", lllllllllllllllllllllIllllllIIlI);
        }
        catch (InstantiationException lllllllllllllllllllllIllllllIIIl) {
            throw new Error("Could not create new dimension", lllllllllllllllllllllIllllllIIIl);
        }
        catch (IllegalAccessException lllllllllllllllllllllIllllllIIII) {
            throw new Error("Could not create new dimension", lllllllllllllllllllllIllllllIIII);
        }
    }
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public static DimensionType getById(final int lllllllllllllllllllllIlllllIlIII) {
        final Exception lllllllllllllllllllllIlllllIIIlI;
        final char lllllllllllllllllllllIlllllIIIll = (char)((DimensionType[])(Object)(lllllllllllllllllllllIlllllIIIlI = (Exception)(Object)values())).length;
        for (long lllllllllllllllllllllIlllllIIlII = 0; lllllllllllllllllllllIlllllIIlII < lllllllllllllllllllllIlllllIIIll; ++lllllllllllllllllllllIlllllIIlII) {
            final DimensionType lllllllllllllllllllllIlllllIIlll = lllllllllllllllllllllIlllllIIIlI[lllllllllllllllllllllIlllllIIlII];
            if (lllllllllllllllllllllIlllllIIlll.getId() == lllllllllllllllllllllIlllllIlIII) {
                return lllllllllllllllllllllIlllllIIlll;
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid dimension id ").append(lllllllllllllllllllllIlllllIlIII)));
    }
    
    public static DimensionType func_193417_a(final String lllllllllllllllllllllIllllIllIlI) {
        final byte lllllllllllllllllllllIllllIlIllI;
        final float lllllllllllllllllllllIllllIlIlll = ((DimensionType[])(Object)(lllllllllllllllllllllIllllIlIllI = (byte)(Object)values())).length;
        for (String lllllllllllllllllllllIllllIllIII = (String)0; lllllllllllllllllllllIllllIllIII < lllllllllllllllllllllIllllIlIlll; ++lllllllllllllllllllllIllllIllIII) {
            final DimensionType lllllllllllllllllllllIllllIllIll = lllllllllllllllllllllIllllIlIllI[lllllllllllllllllllllIllllIllIII];
            if (lllllllllllllllllllllIllllIllIll.getName().equals(lllllllllllllllllllllIllllIllIlI)) {
                return lllllllllllllllllllllIllllIllIll;
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid dimension ").append(lllllllllllllllllllllIllllIllIlI)));
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    private DimensionType(final int llllllllllllllllllllllIIIIIIlIll, final String llllllllllllllllllllllIIIIIIlIlI, final String llllllllllllllllllllllIIIIIIlIIl, final Class<? extends WorldProvider> llllllllllllllllllllllIIIIIIlIII) {
        this.id = llllllllllllllllllllllIIIIIIlIll;
        this.name = llllllllllllllllllllllIIIIIIlIlI;
        this.suffix = llllllllllllllllllllllIIIIIIlIIl;
        this.clazz = llllllllllllllllllllllIIIIIIlIII;
    }
}
