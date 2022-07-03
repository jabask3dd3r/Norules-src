package me.nrules.event.events;

import net.minecraft.block.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;

public class LPosition
{
    private /* synthetic */ boolean ground;
    private /* synthetic */ double x;
    private /* synthetic */ double y;
    private /* synthetic */ double z;
    
    public LPosition setOnGround(final boolean lllllllllllllIlIlIlIlIIlIIIIlIII) {
        this.ground = lllllllllllllIlIlIlIlIIlIIIIlIII;
        return this;
    }
    
    public Block getBlock() {
        return Minecraft.getMinecraft().world.getBlockState(this.toBlockPos()).getBlock();
    }
    
    public double getX() {
        return this.x;
    }
    
    public static LPosition fromBlockPos(final BlockPos lllllllllllllIlIlIlIlIIlIlIIIlII) {
        return new LPosition(lllllllllllllIlIlIlIlIIlIlIIIlII.getX(), lllllllllllllIlIlIlIlIIlIlIIIlII.getY(), lllllllllllllIlIlIlIlIIlIlIIIlII.getZ());
    }
    
    public LPosition(final int lllllllllllllIlIlIlIlIIlIlIIllIl, final int lllllllllllllIlIlIlIlIIlIlIIllII, final int lllllllllllllIlIlIlIlIIlIlIIlIll) {
        this.x = lllllllllllllIlIlIlIlIIlIlIIllIl;
        this.y = lllllllllllllIlIlIlIlIIlIlIIllII;
        this.z = lllllllllllllIlIlIlIlIIlIlIIlIll;
        this.ground = true;
    }
    
    public LPosition subtract(final double lllllllllllllIlIlIlIlIIlIIIlIllI, final double lllllllllllllIlIlIlIlIIlIIIlIlIl, final double lllllllllllllIlIlIlIlIIlIIIllIII) {
        this.x -= lllllllllllllIlIlIlIlIIlIIIlIllI;
        this.y -= lllllllllllllIlIlIlIlIIlIIIlIlIl;
        this.z -= lllllllllllllIlIlIlIlIIlIIIllIII;
        return this;
    }
    
    public LPosition setZ(final double lllllllllllllIlIlIlIlIIIlllIllIl) {
        this.z = lllllllllllllIlIlIlIlIIIlllIllIl;
        return this;
    }
    
    public LPosition(final double lllllllllllllIlIlIlIlIIlIlIllIIl, final double lllllllllllllIlIlIlIlIIlIlIlIlII, final double lllllllllllllIlIlIlIlIIlIlIlIlll) {
        this.x = lllllllllllllIlIlIlIlIIlIlIllIIl;
        this.y = lllllllllllllIlIlIlIlIIlIlIlIlII;
        this.z = lllllllllllllIlIlIlIlIIlIlIlIlll;
        this.ground = true;
    }
    
    public LPosition setX(final double lllllllllllllIlIlIlIlIIlIIIIIIIl) {
        this.x = lllllllllllllIlIlIlIlIIlIIIIIIIl;
        return this;
    }
    
    public LPosition subtract(final int lllllllllllllIlIlIlIlIIlIIlIIllI, final int lllllllllllllIlIlIlIlIIlIIlIIlIl, final int lllllllllllllIlIlIlIlIIlIIlIIIII) {
        this.x -= lllllllllllllIlIlIlIlIIlIIlIIllI;
        this.y -= lllllllllllllIlIlIlIlIIlIIlIIlIl;
        this.z -= lllllllllllllIlIlIlIlIIlIIlIIIII;
        return this;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public LPosition setY(final double lllllllllllllIlIlIlIlIIIlllllIII) {
        this.y = lllllllllllllIlIlIlIlIIIlllllIII;
        return this;
    }
    
    public BlockPos toBlockPos() {
        return new BlockPos(this.getX(), this.getY(), this.getZ());
    }
    
    public LPosition add(final int lllllllllllllIlIlIlIlIIlIIlllIlI, final int lllllllllllllIlIlIlIlIIlIIlllIIl, final int lllllllllllllIlIlIlIlIIlIIllllII) {
        this.x += lllllllllllllIlIlIlIlIIlIIlllIlI;
        this.y += lllllllllllllIlIlIlIlIIlIIlllIIl;
        this.z += lllllllllllllIlIlIlIlIIlIIllllII;
        return this;
    }
    
    public LPosition(final double lllllllllllllIlIlIlIlIIlIllIIIlI, final double lllllllllllllIlIlIlIlIIlIllIIIIl, final double lllllllllllllIlIlIlIlIIlIllIIIII, final boolean lllllllllllllIlIlIlIlIIlIllIIlII) {
        this.x = lllllllllllllIlIlIlIlIIlIllIIIlI;
        this.y = lllllllllllllIlIlIlIlIIlIllIIIIl;
        this.z = lllllllllllllIlIlIlIlIIlIllIIIII;
        this.ground = lllllllllllllIlIlIlIlIIlIllIIlII;
    }
    
    public boolean isOnGround() {
        return this.ground;
    }
    
    public LPosition add(final double lllllllllllllIlIlIlIlIIlIIllIIlI, final double lllllllllllllIlIlIlIlIIlIIlIllIl, final double lllllllllllllIlIlIlIlIIlIIllIIII) {
        this.x += lllllllllllllIlIlIlIlIIlIIllIIlI;
        this.y += lllllllllllllIlIlIlIlIIlIIlIllIl;
        this.z += lllllllllllllIlIlIlIlIIlIIllIIII;
        return this;
    }
}
