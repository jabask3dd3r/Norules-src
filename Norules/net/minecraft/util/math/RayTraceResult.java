package net.minecraft.util.math;

import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RayTraceResult
{
    public /* synthetic */ EnumFacing sideHit;
    public /* synthetic */ Type typeOfHit;
    public /* synthetic */ Vec3d hitVec;
    private /* synthetic */ BlockPos blockPos;
    public /* synthetic */ Entity entityHit;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("HitResult{type=").append(this.typeOfHit).append(", blockpos=").append(this.blockPos).append(", f=").append(this.sideHit).append(", pos=").append(this.hitVec).append(", entity=").append(this.entityHit).append('}'));
    }
    
    public RayTraceResult(final Entity lIIlIIllIIIIIII) {
        this(lIIlIIllIIIIIII, new Vec3d(lIIlIIllIIIIIII.posX, lIIlIIllIIIIIII.posY, lIIlIIllIIIIIII.posZ));
    }
    
    public RayTraceResult(final Entity lIIlIIlIllIllII, final Vec3d lIIlIIlIllIlIll) {
        this.typeOfHit = Type.ENTITY;
        this.entityHit = lIIlIIlIllIllII;
        this.hitVec = lIIlIIlIllIlIll;
    }
    
    public BlockPos getBlockPos() {
        return this.blockPos;
    }
    
    public RayTraceResult(final Vec3d lIIlIIllIIIlIlI, final EnumFacing lIIlIIllIIIlIIl) {
        this(Type.BLOCK, lIIlIIllIIIlIlI, lIIlIIllIIIlIIl, BlockPos.ORIGIN);
    }
    
    public RayTraceResult(final Vec3d lIIlIIllIIlIlIl, final EnumFacing lIIlIIllIIlIIII, final BlockPos lIIlIIllIIlIIll) {
        this(Type.BLOCK, lIIlIIllIIlIlIl, lIIlIIllIIlIIII, lIIlIIllIIlIIll);
    }
    
    public RayTraceResult(final Type lIIlIIlIlllIlII, final Vec3d lIIlIIlIllllIII, final EnumFacing lIIlIIlIlllIIlI, final BlockPos lIIlIIlIlllIllI) {
        this.typeOfHit = lIIlIIlIlllIlII;
        this.blockPos = lIIlIIlIlllIllI;
        this.sideHit = lIIlIIlIlllIIlI;
        this.hitVec = new Vec3d(lIIlIIlIllllIII.xCoord, lIIlIIlIllllIII.yCoord, lIIlIIlIllllIII.zCoord);
    }
    
    public enum Type
    {
        ENTITY("ENTITY", 2), 
        MISS("MISS", 0), 
        BLOCK("BLOCK", 1);
        
        private Type(final String lllllllllllllllIIllllIllIllllIII, final int lllllllllllllllIIllllIllIlllIlll) {
        }
    }
}
