package net.minecraft.util;

public enum Mirror
{
    NONE("NONE", 0, "no_mirror");
    
    private final /* synthetic */ String name;
    
    FRONT_BACK("FRONT_BACK", 2, "mirror_front_back");
    
    private static final /* synthetic */ String[] mirrorNames;
    
    LEFT_RIGHT("LEFT_RIGHT", 1, "mirror_left_right");
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = Mirror.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final String lllllllllllllIIllIIllIIIlllIIIIl = (Object)new int[values().length];
        try {
            lllllllllllllIIllIIllIIIlllIIIIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIllIIllIIIlllIIIIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIllIIllIIIlllIIIIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return Mirror.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIIllIIllIIIlllIIIIl;
    }
    
    public EnumFacing mirror(final EnumFacing lllllllllllllIIllIIllIIIlllIlIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[this.ordinal()]) {
            case 3: {
                if (lllllllllllllIIllIIllIIIlllIlIll == EnumFacing.WEST) {
                    return EnumFacing.EAST;
                }
                if (lllllllllllllIIllIIllIIIlllIlIll == EnumFacing.EAST) {
                    return EnumFacing.WEST;
                }
                return lllllllllllllIIllIIllIIIlllIlIll;
            }
            case 2: {
                if (lllllllllllllIIllIIllIIIlllIlIll == EnumFacing.NORTH) {
                    return EnumFacing.SOUTH;
                }
                if (lllllllllllllIIllIIllIIIlllIlIll == EnumFacing.SOUTH) {
                    return EnumFacing.NORTH;
                }
                return lllllllllllllIIllIIllIIIlllIlIll;
            }
            default: {
                return lllllllllllllIIllIIllIIIlllIlIll;
            }
        }
    }
    
    public Rotation toRotation(final EnumFacing lllllllllllllIIllIIllIIIllllIIlI) {
        final EnumFacing.Axis lllllllllllllIIllIIllIIIllllIlII = lllllllllllllIIllIIllIIIllllIIlI.getAxis();
        return ((this != Mirror.LEFT_RIGHT || lllllllllllllIIllIIllIIIllllIlII != EnumFacing.Axis.Z) && (this != Mirror.FRONT_BACK || lllllllllllllIIllIIllIIIllllIlII != EnumFacing.Axis.X)) ? Rotation.NONE : Rotation.CLOCKWISE_180;
    }
    
    private Mirror(final String lllllllllllllIIllIIllIIlIIIIlIll, final int lllllllllllllIIllIIllIIlIIIIlIlI, final String lllllllllllllIIllIIllIIlIIIIllIl) {
        this.name = lllllllllllllIIllIIllIIlIIIIllIl;
    }
    
    static {
        mirrorNames = new String[values().length];
        int lllllllllllllIIllIIllIIlIIIllIIl = 0;
        final int lllllllllllllIIllIIllIIlIIIlIIll;
        final float lllllllllllllIIllIIllIIlIIIlIlII = ((Mirror[])(Object)(lllllllllllllIIllIIllIIlIIIlIIll = (int)(Object)values())).length;
        for (long lllllllllllllIIllIIllIIlIIIlIlIl = 0; lllllllllllllIIllIIllIIlIIIlIlIl < lllllllllllllIIllIIllIIlIIIlIlII; ++lllllllllllllIIllIIllIIlIIIlIlIl) {
            final Mirror lllllllllllllIIllIIllIIlIIIllIII = lllllllllllllIIllIIllIIlIIIlIIll[lllllllllllllIIllIIllIIlIIIlIlIl];
            Mirror.mirrorNames[lllllllllllllIIllIIllIIlIIIllIIl++] = lllllllllllllIIllIIllIIlIIIllIII.name;
        }
    }
    
    public int mirrorRotation(final int lllllllllllllIIllIIllIIlIIIIIIlI, final int lllllllllllllIIllIIllIIIllllllII) {
        final int lllllllllllllIIllIIllIIlIIIIIIII = lllllllllllllIIllIIllIIIllllllII / 2;
        final int lllllllllllllIIllIIllIIIllllllll = (lllllllllllllIIllIIllIIlIIIIIIlI > lllllllllllllIIllIIllIIlIIIIIIII) ? (lllllllllllllIIllIIllIIlIIIIIIlI - lllllllllllllIIllIIllIIIllllllII) : lllllllllllllIIllIIllIIlIIIIIIlI;
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[this.ordinal()]) {
            case 3: {
                return (lllllllllllllIIllIIllIIIllllllII - lllllllllllllIIllIIllIIIllllllll) % lllllllllllllIIllIIllIIIllllllII;
            }
            case 2: {
                return (lllllllllllllIIllIIllIIlIIIIIIII - lllllllllllllIIllIIllIIIllllllll + lllllllllllllIIllIIllIIIllllllII) % lllllllllllllIIllIIllIIIllllllII;
            }
            default: {
                return lllllllllllllIIllIIllIIlIIIIIIlI;
            }
        }
    }
}
