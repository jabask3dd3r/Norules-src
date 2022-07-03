package com.viaversion.viaversion.api.minecraft.entities;

public interface EntityType
{
    default boolean is(final EntityType lllllllllllllIlIlIlllllIlIlIIIll) {
        return this == lllllllllllllIlIlIlllllIlIlIIIll;
    }
    
    EntityType getParent();
    
    String name();
    
    default boolean is(final EntityType... lllllllllllllIlIlIlllllIlIlIllIl) {
        final double lllllllllllllIlIlIlllllIlIlIlIlI = (Object)lllllllllllllIlIlIlllllIlIlIllIl;
        final short lllllllllllllIlIlIlllllIlIlIlIIl = (short)lllllllllllllIlIlIlllllIlIlIlIlI.length;
        for (float lllllllllllllIlIlIlllllIlIlIlIII = 0; lllllllllllllIlIlIlllllIlIlIlIII < lllllllllllllIlIlIlllllIlIlIlIIl; ++lllllllllllllIlIlIlllllIlIlIlIII) {
            final EntityType lllllllllllllIlIlIlllllIlIlIllll = lllllllllllllIlIlIlllllIlIlIlIlI[lllllllllllllIlIlIlllllIlIlIlIII];
            if (this == lllllllllllllIlIlIlllllIlIlIllll) {
                return true;
            }
        }
        return false;
    }
    
    int getId();
    
    default boolean isOrHasParent(final EntityType lllllllllllllIlIlIlllllIlIIlllII) {
        EntityType lllllllllllllIlIlIlllllIlIIllIll = this;
        while (lllllllllllllIlIlIlllllIlIIllIll != lllllllllllllIlIlIlllllIlIIlllII) {
            lllllllllllllIlIlIlllllIlIIllIll = lllllllllllllIlIlIlllllIlIIllIll.getParent();
            if (lllllllllllllIlIlIlllllIlIIllIll == null) {
                return false;
            }
        }
        return true;
    }
}
