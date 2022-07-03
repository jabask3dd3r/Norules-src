package net.minecraft.util;

public enum Rotation
{
    CLOCKWISE_90("CLOCKWISE_90", 1, "rotate_90");
    
    private static final /* synthetic */ String[] rotationNames;
    
    NONE("NONE", 0, "rotate_0"), 
    CLOCKWISE_180("CLOCKWISE_180", 2, "rotate_180");
    
    private final /* synthetic */ String name;
    
    COUNTERCLOCKWISE_90("COUNTERCLOCKWISE_90", 3, "rotate_270");
    
    private Rotation(final String llllllllllllllIIIIIlIIlllllIlIlI, final int llllllllllllllIIIIIlIIlllllIlIII, final String llllllllllllllIIIIIlIIlllllIIllI) {
        this.name = llllllllllllllIIIIIlIIlllllIIllI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = Rotation.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final double llllllllllllllIIIIIlIIlllIlIlIlI = (Object)new int[values().length];
        try {
            llllllllllllllIIIIIlIIlllIlIlIlI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIIIlIIlllIlIlIlI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIIIlIIlllIlIlIlI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIIIlIIlllIlIlIlI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return Rotation.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllIIIIIlIIlllIlIlIlI;
    }
    
    public EnumFacing rotate(final EnumFacing llllllllllllllIIIIIlIIllllIlIlII) {
        if (llllllllllllllIIIIIlIIllllIlIlII.getAxis() == EnumFacing.Axis.Y) {
            return llllllllllllllIIIIIlIIllllIlIlII;
        }
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[this.ordinal()]) {
            case 2: {
                return llllllllllllllIIIIIlIIllllIlIlII.rotateY();
            }
            case 3: {
                return llllllllllllllIIIIIlIIllllIlIlII.getOpposite();
            }
            case 4: {
                return llllllllllllllIIIIIlIIllllIlIlII.rotateYCCW();
            }
            default: {
                return llllllllllllllIIIIIlIIllllIlIlII;
            }
        }
    }
    
    public Rotation add(final Rotation llllllllllllllIIIIIlIIlllllIIIII) {
        Label_0148: {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllIIIIIlIIlllllIIIII.ordinal()]) {
                case 3: {
                    switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[this.ordinal()]) {
                        case 1: {
                            return Rotation.CLOCKWISE_180;
                        }
                        case 2: {
                            return Rotation.COUNTERCLOCKWISE_90;
                        }
                        case 3: {
                            return Rotation.NONE;
                        }
                        case 4: {
                            return Rotation.CLOCKWISE_90;
                        }
                        default: {
                            break Label_0148;
                        }
                    }
                    break;
                }
                case 4: {
                    switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[this.ordinal()]) {
                        case 1: {
                            return Rotation.COUNTERCLOCKWISE_90;
                        }
                        case 2: {
                            return Rotation.NONE;
                        }
                        case 3: {
                            return Rotation.CLOCKWISE_90;
                        }
                        case 4: {
                            return Rotation.CLOCKWISE_180;
                        }
                        default: {
                            break Label_0148;
                        }
                    }
                    break;
                }
                case 2: {
                    switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[this.ordinal()]) {
                        case 1: {
                            return Rotation.CLOCKWISE_90;
                        }
                        case 2: {
                            return Rotation.CLOCKWISE_180;
                        }
                        case 3: {
                            return Rotation.COUNTERCLOCKWISE_90;
                        }
                        case 4: {
                            return Rotation.NONE;
                        }
                        default: {
                            break Label_0148;
                        }
                    }
                    break;
                }
            }
        }
        return this;
    }
    
    public int rotate(final int llllllllllllllIIIIIlIIlllIlllIlI, final int llllllllllllllIIIIIlIIlllIllllIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[this.ordinal()]) {
            case 2: {
                return (llllllllllllllIIIIIlIIlllIlllIlI + llllllllllllllIIIIIlIIlllIllllIl / 4) % llllllllllllllIIIIIlIIlllIllllIl;
            }
            case 3: {
                return (llllllllllllllIIIIIlIIlllIlllIlI + llllllllllllllIIIIIlIIlllIllllIl / 2) % llllllllllllllIIIIIlIIlllIllllIl;
            }
            case 4: {
                return (llllllllllllllIIIIIlIIlllIlllIlI + llllllllllllllIIIIIlIIlllIllllIl * 3 / 4) % llllllllllllllIIIIIlIIlllIllllIl;
            }
            default: {
                return llllllllllllllIIIIIlIIlllIlllIlI;
            }
        }
    }
    
    static {
        rotationNames = new String[values().length];
        int llllllllllllllIIIIIlIlIIIIIIIlII = 0;
        final long llllllllllllllIIIIIlIIllllllllII;
        final long llllllllllllllIIIIIlIIllllllllIl = ((Rotation[])(Object)(llllllllllllllIIIIIlIIllllllllII = (long)(Object)values())).length;
        for (String llllllllllllllIIIIIlIIllllllllll = (String)0; llllllllllllllIIIIIlIIllllllllll < llllllllllllllIIIIIlIIllllllllIl; ++llllllllllllllIIIIIlIIllllllllll) {
            final Rotation llllllllllllllIIIIIlIlIIIIIIIIll = llllllllllllllIIIIIlIIllllllllII[llllllllllllllIIIIIlIIllllllllll];
            Rotation.rotationNames[llllllllllllllIIIIIlIlIIIIIIIlII++] = llllllllllllllIIIIIlIlIIIIIIIIll.name;
        }
    }
}
