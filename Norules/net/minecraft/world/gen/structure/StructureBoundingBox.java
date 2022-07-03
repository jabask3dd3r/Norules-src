package net.minecraft.world.gen.structure;

import net.minecraft.util.math.*;
import com.google.common.base.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class StructureBoundingBox
{
    public /* synthetic */ int minZ;
    public /* synthetic */ int maxZ;
    public /* synthetic */ int minX;
    public /* synthetic */ int maxY;
    public /* synthetic */ int maxX;
    public /* synthetic */ int minY;
    
    public void offset(final int lllllllllllllIIllllllIIIlIIIlIII, final int lllllllllllllIIllllllIIIlIIIIlll, final int lllllllllllllIIllllllIIIlIIIlIlI) {
        this.minX += lllllllllllllIIllllllIIIlIIIlIII;
        this.minY += lllllllllllllIIllllllIIIlIIIIlll;
        this.minZ += lllllllllllllIIllllllIIIlIIIlIlI;
        this.maxX += lllllllllllllIIllllllIIIlIIIlIII;
        this.maxY += lllllllllllllIIllllllIIIlIIIIlll;
        this.maxZ += lllllllllllllIIllllllIIIlIIIlIlI;
    }
    
    public int getXSize() {
        return this.maxX - this.minX + 1;
    }
    
    public StructureBoundingBox(final Vec3i lllllllllllllIIllllllIIIlIllllIl, final Vec3i lllllllllllllIIllllllIIIlIllllII) {
        this.minX = Math.min(lllllllllllllIIllllllIIIlIllllIl.getX(), lllllllllllllIIllllllIIIlIllllII.getX());
        this.minY = Math.min(lllllllllllllIIllllllIIIlIllllIl.getY(), lllllllllllllIIllllllIIIlIllllII.getY());
        this.minZ = Math.min(lllllllllllllIIllllllIIIlIllllIl.getZ(), lllllllllllllIIllllllIIIlIllllII.getZ());
        this.maxX = Math.max(lllllllllllllIIllllllIIIlIllllIl.getX(), lllllllllllllIIllllllIIIlIllllII.getX());
        this.maxY = Math.max(lllllllllllllIIllllllIIIlIllllIl.getY(), lllllllllllllIIllllllIIIlIllllII.getY());
        this.maxZ = Math.max(lllllllllllllIIllllllIIIlIllllIl.getZ(), lllllllllllllIIllllllIIIlIllllII.getZ());
    }
    
    public int getYSize() {
        return this.maxY - this.minY + 1;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("x0", this.minX).add("y0", this.minY).add("z0", this.minZ).add("x1", this.maxX).add("y1", this.maxY).add("z1", this.maxZ).toString();
    }
    
    public static StructureBoundingBox getNewBoundingBox() {
        return new StructureBoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    public NBTTagIntArray toNBTTagIntArray() {
        return new NBTTagIntArray(new int[] { this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ });
    }
    
    public boolean isVecInside(final Vec3i lllllllllllllIIllllllIIIlIIIIIII) {
        return lllllllllllllIIllllllIIIlIIIIIII.getX() >= this.minX && lllllllllllllIIllllllIIIlIIIIIII.getX() <= this.maxX && lllllllllllllIIllllllIIIlIIIIIII.getZ() >= this.minZ && lllllllllllllIIllllllIIIlIIIIIII.getZ() <= this.maxZ && lllllllllllllIIllllllIIIlIIIIIII.getY() >= this.minY && lllllllllllllIIllllllIIIlIIIIIII.getY() <= this.maxY;
    }
    
    public int getZSize() {
        return this.maxZ - this.minZ + 1;
    }
    
    public Vec3i getLength() {
        return new Vec3i(this.maxX - this.minX, this.maxY - this.minY, this.maxZ - this.minZ);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = StructureBoundingBox.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final boolean lllllllllllllIIllllllIIIIllIllII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIIllllllIIIIllIllII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIllllllIIIIllIllII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIllllllIIIIllIllII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIllllllIIIIllIllII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIllllllIIIIllIllII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIllllllIIIIllIllII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return StructureBoundingBox.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIllllllIIIIllIllII;
    }
    
    public static StructureBoundingBox getComponentToAddBoundingBox(final int lllllllllllllIIllllllIIlIIIIIlIl, final int lllllllllllllIIllllllIIlIIIIIlII, final int lllllllllllllIIllllllIIIlllllIIl, final int lllllllllllllIIllllllIIIlllllIII, final int lllllllllllllIIllllllIIIllllIlll, final int lllllllllllllIIllllllIIlIIIIIIII, final int lllllllllllllIIllllllIIIllllIlIl, final int lllllllllllllIIllllllIIIllllIlII, final int lllllllllllllIIllllllIIIllllIIll, final EnumFacing lllllllllllllIIllllllIIIllllIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIllllllIIIllllIIlI.ordinal()]) {
            case 3: {
                return new StructureBoundingBox(lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIIlllllIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl - lllllllllllllIIllllllIIIllllIIll + 1 + lllllllllllllIIllllllIIlIIIIIIII, lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIIllllIlIl - 1 + lllllllllllllIIllllllIIIlllllIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlII - 1 + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIlIIIIIIII);
            }
            case 4: {
                return new StructureBoundingBox(lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIIlllllIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIlIIIIIIII, lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIIllllIlIl - 1 + lllllllllllllIIllllllIIIlllllIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlII - 1 + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIIllllIIll - 1 + lllllllllllllIIllllllIIlIIIIIIII);
            }
            case 5: {
                return new StructureBoundingBox(lllllllllllllIIllllllIIlIIIIIlIl - lllllllllllllIIllllllIIIllllIIll + 1 + lllllllllllllIIllllllIIlIIIIIIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIIlllllIII, lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIlIIIIIIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlII - 1 + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIIllllIlIl - 1 + lllllllllllllIIllllllIIIlllllIII);
            }
            case 6: {
                return new StructureBoundingBox(lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIlIIIIIIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIIlllllIII, lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIIllllIIll - 1 + lllllllllllllIIllllllIIlIIIIIIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlII - 1 + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIIllllIlIl - 1 + lllllllllllllIIllllllIIIlllllIII);
            }
            default: {
                return new StructureBoundingBox(lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIIlllllIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIlIIIIIIII, lllllllllllllIIllllllIIlIIIIIlIl + lllllllllllllIIllllllIIIllllIlIl - 1 + lllllllllllllIIllllllIIIlllllIII, lllllllllllllIIllllllIIlIIIIIlII + lllllllllllllIIllllllIIIllllIlII - 1 + lllllllllllllIIllllllIIIllllIlll, lllllllllllllIIllllllIIIlllllIIl + lllllllllllllIIllllllIIIllllIIll - 1 + lllllllllllllIIllllllIIlIIIIIIII);
            }
        }
    }
    
    public boolean intersectsWith(final int lllllllllllllIIllllllIIIlIIllIll, final int lllllllllllllIIllllllIIIlIIlllll, final int lllllllllllllIIllllllIIIlIIllllI, final int lllllllllllllIIllllllIIIlIIllIII) {
        return this.maxX >= lllllllllllllIIllllllIIIlIIllIll && this.minX <= lllllllllllllIIllllllIIIlIIllllI && this.maxZ >= lllllllllllllIIllllllIIIlIIlllll && this.minZ <= lllllllllllllIIllllllIIIlIIllIII;
    }
    
    public StructureBoundingBox(final int lllllllllllllIIllllllIIIllIlIIIl, final int lllllllllllllIIllllllIIIllIlIIII, final int lllllllllllllIIllllllIIIllIIlIII, final int lllllllllllllIIllllllIIIllIIlllI, final int lllllllllllllIIllllllIIIllIIllIl, final int lllllllllllllIIllllllIIIllIIllII) {
        this.minX = lllllllllllllIIllllllIIIllIlIIIl;
        this.minY = lllllllllllllIIllllllIIIllIlIIII;
        this.minZ = lllllllllllllIIllllllIIIllIIlIII;
        this.maxX = lllllllllllllIIllllllIIIllIIlllI;
        this.maxY = lllllllllllllIIllllllIIIllIIllIl;
        this.maxZ = lllllllllllllIIllllllIIIllIIllII;
    }
    
    public StructureBoundingBox(final StructureBoundingBox lllllllllllllIIllllllIIIllIllIlI) {
        this.minX = lllllllllllllIIllllllIIIllIllIlI.minX;
        this.minY = lllllllllllllIIllllllIIIllIllIlI.minY;
        this.minZ = lllllllllllllIIllllllIIIllIllIlI.minZ;
        this.maxX = lllllllllllllIIllllllIIIllIllIlI.maxX;
        this.maxY = lllllllllllllIIllllllIIIllIllIlI.maxY;
        this.maxZ = lllllllllllllIIllllllIIIllIllIlI.maxZ;
    }
    
    public static StructureBoundingBox createProper(final int lllllllllllllIIllllllIIIlllIlIll, final int lllllllllllllIIllllllIIIlllIlIlI, final int lllllllllllllIIllllllIIIlllIlIIl, final int lllllllllllllIIllllllIIIlllIIIlI, final int lllllllllllllIIllllllIIIlllIIIIl, final int lllllllllllllIIllllllIIIlllIIIII) {
        return new StructureBoundingBox(Math.min(lllllllllllllIIllllllIIIlllIlIll, lllllllllllllIIllllllIIIlllIIIlI), Math.min(lllllllllllllIIllllllIIIlllIlIlI, lllllllllllllIIllllllIIIlllIIIIl), Math.min(lllllllllllllIIllllllIIIlllIlIIl, lllllllllllllIIllllllIIIlllIIIII), Math.max(lllllllllllllIIllllllIIIlllIlIll, lllllllllllllIIllllllIIIlllIIIlI), Math.max(lllllllllllllIIllllllIIIlllIlIlI, lllllllllllllIIllllllIIIlllIIIIl), Math.max(lllllllllllllIIllllllIIIlllIlIIl, lllllllllllllIIllllllIIIlllIIIII));
    }
    
    public StructureBoundingBox() {
    }
    
    public StructureBoundingBox(final int lllllllllllllIIllllllIIIlIllIlIl, final int lllllllllllllIIllllllIIIlIllIlII, final int lllllllllllllIIllllllIIIlIllIIll, final int lllllllllllllIIllllllIIIlIlIllIl) {
        this.minX = lllllllllllllIIllllllIIIlIllIlIl;
        this.minZ = lllllllllllllIIllllllIIIlIllIlII;
        this.maxX = lllllllllllllIIllllllIIIlIllIIll;
        this.maxZ = lllllllllllllIIllllllIIIlIlIllIl;
        this.minY = 1;
        this.maxY = 512;
    }
    
    public StructureBoundingBox(final int[] lllllllllllllIIllllllIIlIIIlIIII) {
        if (lllllllllllllIIllllllIIlIIIlIIII.length == 6) {
            this.minX = lllllllllllllIIllllllIIlIIIlIIII[0];
            this.minY = lllllllllllllIIllllllIIlIIIlIIII[1];
            this.minZ = lllllllllllllIIllllllIIlIIIlIIII[2];
            this.maxX = lllllllllllllIIllllllIIlIIIlIIII[3];
            this.maxY = lllllllllllllIIllllllIIlIIIlIIII[4];
            this.maxZ = lllllllllllllIIllllllIIlIIIlIIII[5];
        }
    }
    
    public void expandTo(final StructureBoundingBox lllllllllllllIIllllllIIIlIIlIlII) {
        this.minX = Math.min(this.minX, lllllllllllllIIllllllIIIlIIlIlII.minX);
        this.minY = Math.min(this.minY, lllllllllllllIIllllllIIIlIIlIlII.minY);
        this.minZ = Math.min(this.minZ, lllllllllllllIIllllllIIIlIIlIlII.minZ);
        this.maxX = Math.max(this.maxX, lllllllllllllIIllllllIIIlIIlIlII.maxX);
        this.maxY = Math.max(this.maxY, lllllllllllllIIllllllIIIlIIlIlII.maxY);
        this.maxZ = Math.max(this.maxZ, lllllllllllllIIllllllIIIlIIlIlII.maxZ);
    }
    
    public boolean intersectsWith(final StructureBoundingBox lllllllllllllIIllllllIIIlIlIlIIl) {
        return this.maxX >= lllllllllllllIIllllllIIIlIlIlIIl.minX && this.minX <= lllllllllllllIIllllllIIIlIlIlIIl.maxX && this.maxZ >= lllllllllllllIIllllllIIIlIlIlIIl.minZ && this.minZ <= lllllllllllllIIllllllIIIlIlIlIIl.maxZ && this.maxY >= lllllllllllllIIllllllIIIlIlIlIIl.minY && this.minY <= lllllllllllllIIllllllIIIlIlIlIIl.maxY;
    }
}
