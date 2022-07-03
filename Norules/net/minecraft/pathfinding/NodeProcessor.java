package net.minecraft.pathfinding;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public abstract class NodeProcessor
{
    protected /* synthetic */ int entitySizeX;
    protected /* synthetic */ boolean canEnterDoors;
    protected /* synthetic */ EntityLiving entity;
    protected /* synthetic */ IBlockAccess blockaccess;
    protected /* synthetic */ int entitySizeY;
    protected /* synthetic */ boolean canSwim;
    protected /* synthetic */ int entitySizeZ;
    protected final /* synthetic */ IntHashMap<PathPoint> pointMap;
    protected /* synthetic */ boolean canBreakDoors;
    
    public boolean getCanEnterDoors() {
        return this.canEnterDoors;
    }
    
    public abstract PathPoint getPathPointToCoords(final double p0, final double p1, final double p2);
    
    public void setCanSwim(final boolean llllllllllllllIlIllllllIIIIlIIlI) {
        this.canSwim = llllllllllllllIlIllllllIIIIlIIlI;
    }
    
    public abstract PathNodeType getPathNodeType(final IBlockAccess p0, final int p1, final int p2, final int p3, final EntityLiving p4, final int p5, final int p6, final int p7, final boolean p8, final boolean p9);
    
    public abstract PathPoint getStart();
    
    public boolean getCanBreakDoors() {
        return this.canBreakDoors;
    }
    
    public abstract int findPathOptions(final PathPoint[] p0, final PathPoint p1, final PathPoint p2, final float p3);
    
    public void initProcessor(final IBlockAccess llllllllllllllIlIllllllIIIlllIII, final EntityLiving llllllllllllllIlIllllllIIIlllIlI) {
        this.blockaccess = llllllllllllllIlIllllllIIIlllIII;
        this.entity = llllllllllllllIlIllllllIIIlllIlI;
        this.pointMap.clearMap();
        this.entitySizeX = MathHelper.floor(llllllllllllllIlIllllllIIIlllIlI.width + 1.0f);
        this.entitySizeY = MathHelper.floor(llllllllllllllIlIllllllIIIlllIlI.height + 1.0f);
        this.entitySizeZ = MathHelper.floor(llllllllllllllIlIllllllIIIlllIlI.width + 1.0f);
    }
    
    protected PathPoint openPoint(final int llllllllllllllIlIllllllIIIlIIllI, final int llllllllllllllIlIllllllIIIlIlIll, final int llllllllllllllIlIllllllIIIlIlIlI) {
        final int llllllllllllllIlIllllllIIIlIlIIl = PathPoint.makeHash(llllllllllllllIlIllllllIIIlIIllI, llllllllllllllIlIllllllIIIlIlIll, llllllllllllllIlIllllllIIIlIlIlI);
        PathPoint llllllllllllllIlIllllllIIIlIlIII = this.pointMap.lookup(llllllllllllllIlIllllllIIIlIlIIl);
        if (llllllllllllllIlIllllllIIIlIlIII == null) {
            llllllllllllllIlIllllllIIIlIlIII = new PathPoint(llllllllllllllIlIllllllIIIlIIllI, llllllllllllllIlIllllllIIIlIlIll, llllllllllllllIlIllllllIIIlIlIlI);
            this.pointMap.addKey(llllllllllllllIlIllllllIIIlIlIIl, llllllllllllllIlIllllllIIIlIlIII);
        }
        return llllllllllllllIlIllllllIIIlIlIII;
    }
    
    public void setCanBreakDoors(final boolean llllllllllllllIlIllllllIIIIllIII) {
        this.canBreakDoors = llllllllllllllIlIllllllIIIIllIII;
    }
    
    public void postProcess() {
        this.blockaccess = null;
        this.entity = null;
    }
    
    public NodeProcessor() {
        this.pointMap = new IntHashMap<PathPoint>();
    }
    
    public void setCanEnterDoors(final boolean llllllllllllllIlIllllllIIIIlllII) {
        this.canEnterDoors = llllllllllllllIlIllllllIIIIlllII;
    }
    
    public abstract PathNodeType getPathNodeType(final IBlockAccess p0, final int p1, final int p2, final int p3);
    
    public boolean getCanSwim() {
        return this.canSwim;
    }
}
