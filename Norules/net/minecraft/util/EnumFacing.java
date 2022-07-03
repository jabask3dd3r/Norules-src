package net.minecraft.util;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.collect.*;

public enum EnumFacing implements IStringSerializable
{
    SOUTH("SOUTH", 3, 3, 2, 0, "south", AxisDirection.POSITIVE, Axis.Z, new Vec3i(0, 0, 1));
    
    private final /* synthetic */ int index;
    private final /* synthetic */ String name;
    
    WEST("WEST", 4, 4, 5, 1, "west", AxisDirection.NEGATIVE, Axis.X, new Vec3i(-1, 0, 0)), 
    DOWN("DOWN", 0, 0, 1, -1, "down", AxisDirection.NEGATIVE, Axis.Y, new Vec3i(0, -1, 0)), 
    UP("UP", 1, 1, 0, -1, "up", AxisDirection.POSITIVE, Axis.Y, new Vec3i(0, 1, 0)), 
    NORTH("NORTH", 2, 2, 3, 2, "north", AxisDirection.NEGATIVE, Axis.Z, new Vec3i(0, 0, -1));
    
    private static final /* synthetic */ EnumFacing[] HORIZONTALS;
    private final /* synthetic */ int horizontalIndex;
    
    EAST("EAST", 5, 5, 4, 3, "east", AxisDirection.POSITIVE, Axis.X, new Vec3i(1, 0, 0));
    
    private final /* synthetic */ Axis axis;
    private final /* synthetic */ AxisDirection axisDirection;
    private final /* synthetic */ int opposite;
    public static final /* synthetic */ EnumFacing[] VALUES;
    private static final /* synthetic */ Map<String, EnumFacing> NAME_LOOKUP;
    private final /* synthetic */ Vec3i directionVec;
    
    public int getFrontOffsetX() {
        return (this.axis == Axis.X) ? this.axisDirection.getOffset() : 0;
    }
    
    public EnumFacing getOpposite() {
        return EnumFacing.VALUES[this.opposite];
    }
    
    public static EnumFacing func_190914_a(final BlockPos llllllllllllIllllllIIllIlIIIIIll, final EntityLivingBase llllllllllllIllllllIIllIlIIIIIlI) {
        if (Math.abs(llllllllllllIllllllIIllIlIIIIIlI.posX - (llllllllllllIllllllIIllIlIIIIIll.getX() + 0.5f)) < 2.0 && Math.abs(llllllllllllIllllllIIllIlIIIIIlI.posZ - (llllllllllllIllllllIIllIlIIIIIll.getZ() + 0.5f)) < 2.0) {
            final double llllllllllllIllllllIIllIlIIIIlII = llllllllllllIllllllIIllIlIIIIIlI.posY + llllllllllllIllllllIIllIlIIIIIlI.getEyeHeight();
            if (llllllllllllIllllllIIllIlIIIIlII - llllllllllllIllllllIIllIlIIIIIll.getY() > 2.0) {
                return EnumFacing.UP;
            }
            if (llllllllllllIllllllIIllIlIIIIIll.getY() - llllllllllllIllllllIIllIlIIIIlII > 0.0) {
                return EnumFacing.DOWN;
            }
        }
        return llllllllllllIllllllIIllIlIIIIIlI.getHorizontalFacing().getOpposite();
    }
    
    public int getFrontOffsetZ() {
        return (this.axis == Axis.Z) ? this.axisDirection.getOffset() : 0;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    static {
        VALUES = new EnumFacing[6];
        HORIZONTALS = new EnumFacing[4];
        NAME_LOOKUP = Maps.newHashMap();
        final long llllllllllllIllllllIIlllIIIlIlIl;
        final Exception llllllllllllIllllllIIlllIIIlIllI = (Exception)((EnumFacing[])(Object)(llllllllllllIllllllIIlllIIIlIlIl = (long)(Object)values())).length;
        for (long llllllllllllIllllllIIlllIIIlIlll = 0; llllllllllllIllllllIIlllIIIlIlll < llllllllllllIllllllIIlllIIIlIllI; ++llllllllllllIllllllIIlllIIIlIlll) {
            final EnumFacing llllllllllllIllllllIIlllIIIllIIl = llllllllllllIllllllIIlllIIIlIlIl[llllllllllllIllllllIIlllIIIlIlll];
            EnumFacing.VALUES[llllllllllllIllllllIIlllIIIllIIl.index] = llllllllllllIllllllIIlllIIIllIIl;
            if (llllllllllllIllllllIIlllIIIllIIl.getAxis().isHorizontal()) {
                EnumFacing.HORIZONTALS[llllllllllllIllllllIIlllIIIllIIl.horizontalIndex] = llllllllllllIllllllIIlllIIIllIIl;
            }
            EnumFacing.NAME_LOOKUP.put(llllllllllllIllllllIIlllIIIllIIl.getName2().toLowerCase(Locale.ROOT), llllllllllllIllllllIIlllIIIllIIl);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = EnumFacing.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final Exception llllllllllllIllllllIIllIIlllIlII = (Object)new int[Axis.values().length];
        try {
            llllllllllllIllllllIIllIIlllIlII[Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllllllIIllIIlllIlII[Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllllllIIllIIlllIlII[Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return EnumFacing.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)llllllllllllIllllllIIllIIlllIlII;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = EnumFacing.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final Exception llllllllllllIllllllIIllIIlllIIlI = (Object)new int[values().length];
        try {
            llllllllllllIllllllIIllIIlllIIlI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllllllIIllIIlllIIlI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllllllIIllIIlllIIlI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIllllllIIllIIlllIIlI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIllllllIIllIIlllIIlI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIllllllIIllIIlllIIlI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return EnumFacing.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIllllllIIllIIlllIIlI;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public EnumFacing rotateY() {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.ordinal()]) {
            case 3: {
                return EnumFacing.EAST;
            }
            case 6: {
                return EnumFacing.SOUTH;
            }
            case 4: {
                return EnumFacing.WEST;
            }
            case 5: {
                return EnumFacing.NORTH;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get Y-rotated facing of ").append(this)));
            }
        }
    }
    
    private EnumFacing(final String llllllllllllIllllllIIlllIIIIIIIl, final int llllllllllllIllllllIIlllIIIIIIII, final int llllllllllllIllllllIIlllIIIIlIIl, final int llllllllllllIllllllIIlllIIIIlIII, final int llllllllllllIllllllIIllIllllllIl, final String llllllllllllIllllllIIllIllllllII, final AxisDirection llllllllllllIllllllIIlllIIIIIlIl, final Axis llllllllllllIllllllIIlllIIIIIlII, final Vec3i llllllllllllIllllllIIllIlllllIIl) {
        this.index = llllllllllllIllllllIIlllIIIIlIIl;
        this.horizontalIndex = llllllllllllIllllllIIllIllllllIl;
        this.opposite = llllllllllllIllllllIIlllIIIIlIII;
        this.name = llllllllllllIllllllIIllIllllllII;
        this.axis = llllllllllllIllllllIIlllIIIIIlII;
        this.axisDirection = llllllllllllIllllllIIlllIIIIIlIl;
        this.directionVec = llllllllllllIllllllIIllIlllllIIl;
    }
    
    public EnumFacing rotateAround(final Axis llllllllllllIllllllIIllIlllIIlll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[llllllllllllIllllllIIllIlllIIlll.ordinal()]) {
            case 1: {
                if (this != EnumFacing.WEST && this != EnumFacing.EAST) {
                    return this.rotateX();
                }
                return this;
            }
            case 2: {
                if (this != EnumFacing.UP && this != EnumFacing.DOWN) {
                    return this.rotateY();
                }
                return this;
            }
            case 3: {
                if (this != EnumFacing.NORTH && this != EnumFacing.SOUTH) {
                    return this.rotateZ();
                }
                return this;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get CW facing for axis ").append(llllllllllllIllllllIIllIlllIIlll)));
            }
        }
    }
    
    public float getHorizontalAngle() {
        return (float)((this.horizontalIndex & 0x3) * 90);
    }
    
    public int getHorizontalIndex() {
        return this.horizontalIndex;
    }
    
    private EnumFacing rotateX() {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.ordinal()]) {
            case 3: {
                return EnumFacing.DOWN;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get X-rotated facing of ").append(this)));
            }
            case 4: {
                return EnumFacing.UP;
            }
            case 2: {
                return EnumFacing.NORTH;
            }
            case 1: {
                return EnumFacing.SOUTH;
            }
        }
    }
    
    public AxisDirection getAxisDirection() {
        return this.axisDirection;
    }
    
    public static EnumFacing getFacingFromVector(final float llllllllllllIllllllIIllIlIlIlIII, final float llllllllllllIllllllIIllIlIlIlllI, final float llllllllllllIllllllIIllIlIlIIllI) {
        EnumFacing llllllllllllIllllllIIllIlIlIllII = EnumFacing.NORTH;
        float llllllllllllIllllllIIllIlIlIlIll = Float.MIN_VALUE;
        final int llllllllllllIllllllIIllIlIlIIIII;
        final byte llllllllllllIllllllIIllIlIlIIIIl = (byte)((EnumFacing[])(Object)(llllllllllllIllllllIIllIlIlIIIII = (int)(Object)values())).length;
        for (char llllllllllllIllllllIIllIlIlIIIlI = '\0'; llllllllllllIllllllIIllIlIlIIIlI < llllllllllllIllllllIIllIlIlIIIIl; ++llllllllllllIllllllIIllIlIlIIIlI) {
            final EnumFacing llllllllllllIllllllIIllIlIlIlIlI = llllllllllllIllllllIIllIlIlIIIII[llllllllllllIllllllIIllIlIlIIIlI];
            final float llllllllllllIllllllIIllIlIlIlIIl = llllllllllllIllllllIIllIlIlIlIII * llllllllllllIllllllIIllIlIlIlIlI.directionVec.getX() + llllllllllllIllllllIIllIlIlIlllI * llllllllllllIllllllIIllIlIlIlIlI.directionVec.getY() + llllllllllllIllllllIIllIlIlIIllI * llllllllllllIllllllIIllIlIlIlIlI.directionVec.getZ();
            if (llllllllllllIllllllIIllIlIlIlIIl > llllllllllllIllllllIIllIlIlIlIll) {
                llllllllllllIllllllIIllIlIlIlIll = llllllllllllIllllllIIllIlIlIlIIl;
                llllllllllllIllllllIIllIlIlIllII = llllllllllllIllllllIIllIlIlIlIlI;
            }
        }
        return llllllllllllIllllllIIllIlIlIllII;
    }
    
    public static EnumFacing fromAngle(final double llllllllllllIllllllIIllIllIIIIII) {
        return getHorizontal(MathHelper.floor(llllllllllllIllllllIIllIllIIIIII / 90.0 + 0.5) & 0x3);
    }
    
    public String getName2() {
        return this.name;
    }
    
    public Vec3i getDirectionVec() {
        return this.directionVec;
    }
    
    public static EnumFacing getHorizontal(final int llllllllllllIllllllIIllIllIIIlII) {
        return EnumFacing.HORIZONTALS[MathHelper.abs(llllllllllllIllllllIIllIllIIIlII % EnumFacing.HORIZONTALS.length)];
    }
    
    public static EnumFacing getFront(final int llllllllllllIllllllIIllIllIIIlll) {
        return EnumFacing.VALUES[MathHelper.abs(llllllllllllIllllllIIllIllIIIlll % EnumFacing.VALUES.length)];
    }
    
    public EnumFacing rotateYCCW() {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.ordinal()]) {
            case 3: {
                return EnumFacing.WEST;
            }
            case 6: {
                return EnumFacing.NORTH;
            }
            case 4: {
                return EnumFacing.EAST;
            }
            case 5: {
                return EnumFacing.SOUTH;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get CCW facing of ").append(this)));
            }
        }
    }
    
    public int getFrontOffsetY() {
        return (this.axis == Axis.Y) ? this.axisDirection.getOffset() : 0;
    }
    
    @Nullable
    public static EnumFacing byName(final String llllllllllllIllllllIIllIllIIlIlI) {
        return (llllllllllllIllllllIIllIllIIlIlI == null) ? null : EnumFacing.NAME_LOOKUP.get(llllllllllllIllllllIIllIllIIlIlI.toLowerCase(Locale.ROOT));
    }
    
    private EnumFacing rotateZ() {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.ordinal()]) {
            case 6: {
                return EnumFacing.DOWN;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Unable to get Z-rotated facing of ").append(this)));
            }
            case 5: {
                return EnumFacing.UP;
            }
            case 2: {
                return EnumFacing.EAST;
            }
            case 1: {
                return EnumFacing.WEST;
            }
        }
    }
    
    public static EnumFacing getFacingFromAxis(final AxisDirection llllllllllllIllllllIIllIlIIIllll, final Axis llllllllllllIllllllIIllIlIIlIIIl) {
        final String llllllllllllIllllllIIllIlIIIlIlI;
        final float llllllllllllIllllllIIllIlIIIlIll = ((EnumFacing[])(Object)(llllllllllllIllllllIIllIlIIIlIlI = (String)(Object)values())).length;
        for (byte llllllllllllIllllllIIllIlIIIllII = 0; llllllllllllIllllllIIllIlIIIllII < llllllllllllIllllllIIllIlIIIlIll; ++llllllllllllIllllllIIllIlIIIllII) {
            final EnumFacing llllllllllllIllllllIIllIlIIlIIII = llllllllllllIllllllIIllIlIIIlIlI[llllllllllllIllllllIIllIlIIIllII];
            if (llllllllllllIllllllIIllIlIIlIIII.getAxisDirection() == llllllllllllIllllllIIllIlIIIllll && llllllllllllIllllllIIllIlIIlIIII.getAxis() == llllllllllllIllllllIIllIlIIlIIIl) {
                return llllllllllllIllllllIIllIlIIlIIII;
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("No such direction: ").append(llllllllllllIllllllIIllIlIIIllll).append(" ").append(llllllllllllIllllllIIllIlIIlIIIl)));
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    public Axis getAxis() {
        return this.axis;
    }
    
    public static EnumFacing random(final Random llllllllllllIllllllIIllIlIlllIll) {
        return values()[llllllllllllIllllllIIllIlIlllIll.nextInt(values().length)];
    }
    
    public enum AxisDirection
    {
        NEGATIVE("NEGATIVE", 1, -1, "Towards negative"), 
        POSITIVE("POSITIVE", 0, 1, "Towards positive");
        
        private final /* synthetic */ int offset;
        private final /* synthetic */ String description;
        
        public int getOffset() {
            return this.offset;
        }
        
        @Override
        public String toString() {
            return this.description;
        }
        
        private AxisDirection(final String llllllllllllllIlIlIlIlIIllllllll, final int llllllllllllllIlIlIlIlIIlllllllI, final int llllllllllllllIlIlIlIlIIllllllIl, final String llllllllllllllIlIlIlIlIIllllllII) {
            this.offset = llllllllllllllIlIlIlIlIIllllllIl;
            this.description = llllllllllllllIlIlIlIlIIllllllII;
        }
    }
    
    public enum Plane implements Predicate<EnumFacing>, Iterable<EnumFacing>
    {
        VERTICAL("VERTICAL", 1), 
        HORIZONTAL("HORIZONTAL", 0);
        
        public boolean apply(@Nullable final EnumFacing llllllllllllllIllIIIlIIIIIllIIII) {
            return llllllllllllllIllIIIlIIIIIllIIII != null && llllllllllllllIllIIIlIIIIIllIIII.getAxis().getPlane() == this;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Plane = Plane.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane;
            if ($switch_TABLE$net$minecraft$util$EnumFacing$Plane != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing$Plane;
            }
            final boolean llllllllllllllIllIIIlIIIIIIlIlll = (Object)new int[values().length];
            try {
                llllllllllllllIllIIIlIIIIIIlIlll[Plane.HORIZONTAL.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllIllIIIlIIIIIIlIlll[Plane.VERTICAL.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            return Plane.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane = (int[])(Object)llllllllllllllIllIIIlIIIIIIlIlll;
        }
        
        private Plane(final String llllllllllllllIllIIIlIIIIlIIIlll, final int llllllllllllllIllIIIlIIIIlIIIllI) {
        }
        
        public EnumFacing[] facings() {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane()[this.ordinal()]) {
                case 1: {
                    return new EnumFacing[] { EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST };
                }
                case 2: {
                    return new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN };
                }
                default: {
                    throw new Error("Someone's been tampering with the universe!");
                }
            }
        }
        
        public EnumFacing random(final Random llllllllllllllIllIIIlIIIIIllIlll) {
            final EnumFacing[] llllllllllllllIllIIIlIIIIIlllIll = this.facings();
            return llllllllllllllIllIIIlIIIIIlllIll[llllllllllllllIllIIIlIIIIIllIlll.nextInt(llllllllllllllIllIIIlIIIIIlllIll.length)];
        }
        
        public Iterator<EnumFacing> iterator() {
            return (Iterator<EnumFacing>)Iterators.forArray((Object[])this.facings());
        }
    }
    
    public enum Axis implements Predicate<EnumFacing>, IStringSerializable
    {
        private static final /* synthetic */ Map<String, Axis> NAME_LOOKUP;
        
        Z("Z", 2, "z", Plane.HORIZONTAL);
        
        private final /* synthetic */ String name;
        
        Y("Y", 1, "y", Plane.VERTICAL), 
        X("X", 0, "x", Plane.HORIZONTAL);
        
        private final /* synthetic */ Plane plane;
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public boolean isVertical() {
            return this.plane == Plane.VERTICAL;
        }
        
        public Plane getPlane() {
            return this.plane;
        }
        
        public boolean apply(@Nullable final EnumFacing llllllllllllllIlIllIlIIIIlIIlIlI) {
            return llllllllllllllIlIllIlIIIIlIIlIlI != null && llllllllllllllIlIllIlIIIIlIIlIlI.getAxis() == this;
        }
        
        @Nullable
        public static Axis byName(final String llllllllllllllIlIllIlIIIIlIlllIl) {
            return (llllllllllllllIlIllIlIIIIlIlllIl == null) ? null : Axis.NAME_LOOKUP.get(llllllllllllllIlIllIlIIIIlIlllIl.toLowerCase(Locale.ROOT));
        }
        
        public String getName2() {
            return this.name;
        }
        
        public boolean isHorizontal() {
            return this.plane == Plane.HORIZONTAL;
        }
        
        public String getName() {
            return this.name;
        }
        
        static {
            NAME_LOOKUP = Maps.newHashMap();
            short llllllllllllllIlIllIlIIIIllIllII;
            for (short llllllllllllllIlIllIlIIIIllIllIl = (short)((Axis[])(Object)(llllllllllllllIlIllIlIIIIllIllII = (short)(Object)values())).length, llllllllllllllIlIllIlIIIIllIlllI = 0; llllllllllllllIlIllIlIIIIllIlllI < llllllllllllllIlIllIlIIIIllIllIl; ++llllllllllllllIlIllIlIIIIllIlllI) {
                final Axis llllllllllllllIlIllIlIIIIlllIIIl = llllllllllllllIlIllIlIIIIllIllII[llllllllllllllIlIllIlIIIIllIlllI];
                Axis.NAME_LOOKUP.put(llllllllllllllIlIllIlIIIIlllIIIl.getName2().toLowerCase(Locale.ROOT), llllllllllllllIlIllIlIIIIlllIIIl);
            }
        }
        
        private Axis(final String llllllllllllllIlIllIlIIIIllIIIlI, final int llllllllllllllIlIllIlIIIIllIIIIl, final String llllllllllllllIlIllIlIIIIllIIlIl, final Plane llllllllllllllIlIllIlIIIIllIIlII) {
            this.name = llllllllllllllIlIllIlIIIIllIIlIl;
            this.plane = llllllllllllllIlIllIlIIIIllIIlII;
        }
    }
}
