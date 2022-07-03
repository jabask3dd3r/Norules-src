package net.minecraft.pathfinding;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import java.util.*;
import javax.annotation.*;

public class FlyingNodeProcessor extends WalkNodeProcessor
{
    @Override
    public PathPoint getPathPointToCoords(final double lllllllllllllIIlllIIIlllIIllIlll, final double lllllllllllllIIlllIIIlllIIllIllI, final double lllllllllllllIIlllIIIlllIIlllIIl) {
        return super.openPoint(MathHelper.floor(lllllllllllllIIlllIIIlllIIllIlll), MathHelper.floor(lllllllllllllIIlllIIIlllIIllIllI), MathHelper.floor(lllllllllllllIIlllIIIlllIIlllIIl));
    }
    
    @Override
    public int findPathOptions(final PathPoint[] lllllllllllllIIlllIIIlllIIlIIIII, final PathPoint lllllllllllllIIlllIIIlllIIIlllll, final PathPoint lllllllllllllIIlllIIIlllIIIIIIII, final float lllllllllllllIIlllIIIlllIIIlllIl) {
        int lllllllllllllIIlllIIIlllIIIlllII = 0;
        final PathPoint lllllllllllllIIlllIIIlllIIIllIll = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord, lllllllllllllIIlllIIIlllIIIlllll.yCoord, lllllllllllllIIlllIIIlllIIIlllll.zCoord + 1);
        final PathPoint lllllllllllllIIlllIIIlllIIIllIlI = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord, lllllllllllllIIlllIIIlllIIIlllll.zCoord);
        final PathPoint lllllllllllllIIlllIIIlllIIIllIIl = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord, lllllllllllllIIlllIIIlllIIIlllll.zCoord);
        final PathPoint lllllllllllllIIlllIIIlllIIIllIII = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord, lllllllllllllIIlllIIIlllIIIlllll.yCoord, lllllllllllllIIlllIIIlllIIIlllll.zCoord - 1);
        final PathPoint lllllllllllllIIlllIIIlllIIIlIlll = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord, lllllllllllllIIlllIIIlllIIIlllll.yCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord);
        final PathPoint lllllllllllllIIlllIIIlllIIIlIllI = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord, lllllllllllllIIlllIIIlllIIIlllll.yCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord);
        if (lllllllllllllIIlllIIIlllIIIllIll != null && !lllllllllllllIIlllIIIlllIIIllIll.visited && lllllllllllllIIlllIIIlllIIIllIll.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
            lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIllIll;
        }
        if (lllllllllllllIIlllIIIlllIIIllIlI != null && !lllllllllllllIIlllIIIlllIIIllIlI.visited && lllllllllllllIIlllIIIlllIIIllIlI.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
            lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIllIlI;
        }
        if (lllllllllllllIIlllIIIlllIIIllIIl != null && !lllllllllllllIIlllIIIlllIIIllIIl.visited && lllllllllllllIIlllIIIlllIIIllIIl.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
            lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIllIIl;
        }
        if (lllllllllllllIIlllIIIlllIIIllIII != null && !lllllllllllllIIlllIIIlllIIIllIII.visited && lllllllllllllIIlllIIIlllIIIllIII.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
            lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIllIII;
        }
        if (lllllllllllllIIlllIIIlllIIIlIlll != null && !lllllllllllllIIlllIIIlllIIIlIlll.visited && lllllllllllllIIlllIIIlllIIIlIlll.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
            lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIlIlll;
        }
        if (lllllllllllllIIlllIIIlllIIIlIllI != null && !lllllllllllllIIlllIIIlllIIIlIllI.visited && lllllllllllllIIlllIIIlllIIIlIllI.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
            lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIlIllI;
        }
        final boolean lllllllllllllIIlllIIIlllIIIlIlIl = lllllllllllllIIlllIIIlllIIIllIII == null || lllllllllllllIIlllIIIlllIIIllIII.costMalus != 0.0f;
        final boolean lllllllllllllIIlllIIIlllIIIlIlII = lllllllllllllIIlllIIIlllIIIllIll == null || lllllllllllllIIlllIIIlllIIIllIll.costMalus != 0.0f;
        final boolean lllllllllllllIIlllIIIlllIIIlIIll = lllllllllllllIIlllIIIlllIIIllIIl == null || lllllllllllllIIlllIIIlllIIIllIIl.costMalus != 0.0f;
        final boolean lllllllllllllIIlllIIIlllIIIlIIlI = lllllllllllllIIlllIIIlllIIIllIlI == null || lllllllllllllIIlllIIIlllIIIllIlI.costMalus != 0.0f;
        final boolean lllllllllllllIIlllIIIlllIIIlIIIl = lllllllllllllIIlllIIIlllIIIlIlll == null || lllllllllllllIIlllIIIlllIIIlIlll.costMalus != 0.0f;
        final boolean lllllllllllllIIlllIIIlllIIIlIIII = lllllllllllllIIlllIIIlllIIIlIllI == null || lllllllllllllIIlllIIIlllIIIlIllI.costMalus != 0.0f;
        if (lllllllllllllIIlllIIIlllIIIlIlIl && lllllllllllllIIlllIIIlllIIIlIIlI) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIllll = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord, lllllllllllllIIlllIIIlllIIIlllll.zCoord - 1);
            if (lllllllllllllIIlllIIIlllIIIIllll != null && !lllllllllllllIIlllIIIlllIIIIllll.visited && lllllllllllllIIlllIIIlllIIIIllll.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIllll;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIlIl && lllllllllllllIIlllIIIlllIIIlIIll) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIlllI = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord, lllllllllllllIIlllIIIlllIIIlllll.zCoord - 1);
            if (lllllllllllllIIlllIIIlllIIIIlllI != null && !lllllllllllllIIlllIIIlllIIIIlllI.visited && lllllllllllllIIlllIIIlllIIIIlllI.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIlllI;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIlII && lllllllllllllIIlllIIIlllIIIlIIlI) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIllIl = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord, lllllllllllllIIlllIIIlllIIIlllll.zCoord + 1);
            if (lllllllllllllIIlllIIIlllIIIIllIl != null && !lllllllllllllIIlllIIIlllIIIIllIl.visited && lllllllllllllIIlllIIIlllIIIIllIl.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIllIl;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIlII && lllllllllllllIIlllIIIlllIIIlIIll) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIllII = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord, lllllllllllllIIlllIIIlllIIIlllll.zCoord + 1);
            if (lllllllllllllIIlllIIIlllIIIIllII != null && !lllllllllllllIIlllIIIlllIIIIllII.visited && lllllllllllllIIlllIIIlllIIIIllII.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIllII;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIlIl && lllllllllllllIIlllIIIlllIIIlIIIl) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIlIll = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord, lllllllllllllIIlllIIIlllIIIlllll.yCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord - 1);
            if (lllllllllllllIIlllIIIlllIIIIlIll != null && !lllllllllllllIIlllIIIlllIIIIlIll.visited && lllllllllllllIIlllIIIlllIIIIlIll.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIlIll;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIlII && lllllllllllllIIlllIIIlllIIIlIIIl) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIlIlI = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord, lllllllllllllIIlllIIIlllIIIlllll.yCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord + 1);
            if (lllllllllllllIIlllIIIlllIIIIlIlI != null && !lllllllllllllIIlllIIIlllIIIIlIlI.visited && lllllllllllllIIlllIIIlllIIIIlIlI.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIlIlI;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIIll && lllllllllllllIIlllIIIlllIIIlIIIl) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIlIIl = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord);
            if (lllllllllllllIIlllIIIlllIIIIlIIl != null && !lllllllllllllIIlllIIIlllIIIIlIIl.visited && lllllllllllllIIlllIIIlllIIIIlIIl.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIlIIl;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIIlI && lllllllllllllIIlllIIIlllIIIlIIIl) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIlIII = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord);
            if (lllllllllllllIIlllIIIlllIIIIlIII != null && !lllllllllllllIIlllIIIlllIIIIlIII.visited && lllllllllllllIIlllIIIlllIIIIlIII.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIlIII;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIlIl && lllllllllllllIIlllIIIlllIIIlIIII) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIIlll = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord, lllllllllllllIIlllIIIlllIIIlllll.yCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord - 1);
            if (lllllllllllllIIlllIIIlllIIIIIlll != null && !lllllllllllllIIlllIIIlllIIIIIlll.visited && lllllllllllllIIlllIIIlllIIIIIlll.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIIlll;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIlII && lllllllllllllIIlllIIIlllIIIlIIII) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIIllI = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord, lllllllllllllIIlllIIIlllIIIlllll.yCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord + 1);
            if (lllllllllllllIIlllIIIlllIIIIIllI != null && !lllllllllllllIIlllIIIlllIIIIIllI.visited && lllllllllllllIIlllIIIlllIIIIIllI.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIIllI;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIIll && lllllllllllllIIlllIIIlllIIIlIIII) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIIlIl = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord + 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord);
            if (lllllllllllllIIlllIIIlllIIIIIlIl != null && !lllllllllllllIIlllIIIlllIIIIIlIl.visited && lllllllllllllIIlllIIIlllIIIIIlIl.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIIlIl;
            }
        }
        if (lllllllllllllIIlllIIIlllIIIlIIlI && lllllllllllllIIlllIIIlllIIIlIIII) {
            final PathPoint lllllllllllllIIlllIIIlllIIIIIlII = this.openPoint(lllllllllllllIIlllIIIlllIIIlllll.xCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.yCoord - 1, lllllllllllllIIlllIIIlllIIIlllll.zCoord);
            if (lllllllllllllIIlllIIIlllIIIIIlII != null && !lllllllllllllIIlllIIIlllIIIIIlII.visited && lllllllllllllIIlllIIIlllIIIIIlII.distanceTo(lllllllllllllIIlllIIIlllIIIIIIII) < lllllllllllllIIlllIIIlllIIIlllIl) {
                lllllllllllllIIlllIIIlllIIlIIIII[lllllllllllllIIlllIIIlllIIIlllII++] = lllllllllllllIIlllIIIlllIIIIIlII;
            }
        }
        return lllllllllllllIIlllIIIlllIIIlllII;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess lllllllllllllIIlllIIIllIllIIlIIl, final int lllllllllllllIIlllIIIllIlIlllIII, final int lllllllllllllIIlllIIIllIlIllIlll, final int lllllllllllllIIlllIIIllIllIIIllI, final EntityLiving lllllllllllllIIlllIIIllIlIllIlIl, final int lllllllllllllIIlllIIIllIllIIIlII, final int lllllllllllllIIlllIIIllIlIllIIll, final int lllllllllllllIIlllIIIllIlIllIIlI, final boolean lllllllllllllIIlllIIIllIlIllIIIl, final boolean lllllllllllllIIlllIIIllIllIIIIII) {
        final EnumSet<PathNodeType> lllllllllllllIIlllIIIllIlIllllll = EnumSet.noneOf(PathNodeType.class);
        PathNodeType lllllllllllllIIlllIIIllIlIlllllI = PathNodeType.BLOCKED;
        final BlockPos lllllllllllllIIlllIIIllIlIllllIl = new BlockPos(lllllllllllllIIlllIIIllIlIllIlIl);
        lllllllllllllIIlllIIIllIlIlllllI = this.func_193577_a(lllllllllllllIIlllIIIllIllIIlIIl, lllllllllllllIIlllIIIllIlIlllIII, lllllllllllllIIlllIIIllIlIllIlll, lllllllllllllIIlllIIIllIllIIIllI, lllllllllllllIIlllIIIllIllIIIlII, lllllllllllllIIlllIIIllIlIllIIll, lllllllllllllIIlllIIIllIlIllIIlI, lllllllllllllIIlllIIIllIlIllIIIl, lllllllllllllIIlllIIIllIllIIIIII, lllllllllllllIIlllIIIllIlIllllll, lllllllllllllIIlllIIIllIlIlllllI, lllllllllllllIIlllIIIllIlIllllIl);
        if (lllllllllllllIIlllIIIllIlIllllll.contains(PathNodeType.FENCE)) {
            return PathNodeType.FENCE;
        }
        PathNodeType lllllllllllllIIlllIIIllIlIllllII = PathNodeType.BLOCKED;
        for (final PathNodeType lllllllllllllIIlllIIIllIlIlllIll : lllllllllllllIIlllIIIllIlIllllll) {
            if (lllllllllllllIIlllIIIllIlIllIlIl.getPathPriority(lllllllllllllIIlllIIIllIlIlllIll) < 0.0f) {
                return lllllllllllllIIlllIIIllIlIlllIll;
            }
            if (lllllllllllllIIlllIIIllIlIllIlIl.getPathPriority(lllllllllllllIIlllIIIllIlIlllIll) < lllllllllllllIIlllIIIllIlIllIlIl.getPathPriority(lllllllllllllIIlllIIIllIlIllllII)) {
                continue;
            }
            lllllllllllllIIlllIIIllIlIllllII = lllllllllllllIIlllIIIllIlIlllIll;
        }
        if (lllllllllllllIIlllIIIllIlIlllllI == PathNodeType.OPEN && lllllllllllllIIlllIIIllIlIllIlIl.getPathPriority(lllllllllllllIIlllIIIllIlIllllII) == 0.0f) {
            return PathNodeType.OPEN;
        }
        return lllllllllllllIIlllIIIllIlIllllII;
    }
    
    @Override
    public void postProcess() {
        this.entity.setPathPriority(PathNodeType.WATER, this.avoidsWater);
        super.postProcess();
    }
    
    private PathNodeType func_192558_a(final EntityLiving lllllllllllllIIlllIIIllIlIIIIIlI, final int lllllllllllllIIlllIIIllIlIIIIIIl, final int lllllllllllllIIlllIIIllIIllllIll, final int lllllllllllllIIlllIIIllIIlllllll) {
        return this.getPathNodeType(this.blockaccess, lllllllllllllIIlllIIIllIlIIIIIIl, lllllllllllllIIlllIIIllIIllllIll, lllllllllllllIIlllIIIllIIlllllll, lllllllllllllIIlllIIIllIlIIIIIlI, this.entitySizeX, this.entitySizeY, this.entitySizeZ, this.getCanBreakDoors(), this.getCanEnterDoors());
    }
    
    @Override
    public void initProcessor(final IBlockAccess lllllllllllllIIlllIIIlllIlIlllll, final EntityLiving lllllllllllllIIlllIIIlllIlIllllI) {
        super.initProcessor(lllllllllllllIIlllIIIlllIlIlllll, lllllllllllllIIlllIIIlllIlIllllI);
        this.avoidsWater = lllllllllllllIIlllIIIlllIlIllllI.getPathPriority(PathNodeType.WATER);
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess lllllllllllllIIlllIIIllIlIIllIII, final int lllllllllllllIIlllIIIllIlIIlIlll, final int lllllllllllllIIlllIIIllIlIIlIllI, final int lllllllllllllIIlllIIIllIlIIlIlIl) {
        PathNodeType lllllllllllllIIlllIIIllIlIIlllII = this.getPathNodeTypeRaw(lllllllllllllIIlllIIIllIlIIllIII, lllllllllllllIIlllIIIllIlIIlIlll, lllllllllllllIIlllIIIllIlIIlIllI, lllllllllllllIIlllIIIllIlIIlIlIl);
        if (lllllllllllllIIlllIIIllIlIIlllII == PathNodeType.OPEN && lllllllllllllIIlllIIIllIlIIlIllI >= 1) {
            final Block lllllllllllllIIlllIIIllIlIIllIll = lllllllllllllIIlllIIIllIlIIllIII.getBlockState(new BlockPos(lllllllllllllIIlllIIIllIlIIlIlll, lllllllllllllIIlllIIIllIlIIlIllI - 1, lllllllllllllIIlllIIIllIlIIlIlIl)).getBlock();
            final PathNodeType lllllllllllllIIlllIIIllIlIIllIlI = this.getPathNodeTypeRaw(lllllllllllllIIlllIIIllIlIIllIII, lllllllllllllIIlllIIIllIlIIlIlll, lllllllllllllIIlllIIIllIlIIlIllI - 1, lllllllllllllIIlllIIIllIlIIlIlIl);
            if (lllllllllllllIIlllIIIllIlIIllIlI != PathNodeType.DAMAGE_FIRE && lllllllllllllIIlllIIIllIlIIllIll != Blocks.MAGMA && lllllllllllllIIlllIIIllIlIIllIlI != PathNodeType.LAVA) {
                if (lllllllllllllIIlllIIIllIlIIllIlI == PathNodeType.DAMAGE_CACTUS) {
                    lllllllllllllIIlllIIIllIlIIlllII = PathNodeType.DAMAGE_CACTUS;
                }
                else {
                    lllllllllllllIIlllIIIllIlIIlllII = ((lllllllllllllIIlllIIIllIlIIllIlI != PathNodeType.WALKABLE && lllllllllllllIIlllIIIllIlIIllIlI != PathNodeType.OPEN && lllllllllllllIIlllIIIllIlIIllIlI != PathNodeType.WATER) ? PathNodeType.WALKABLE : PathNodeType.OPEN);
                }
            }
            else {
                lllllllllllllIIlllIIIllIlIIlllII = PathNodeType.DAMAGE_FIRE;
            }
        }
        lllllllllllllIIlllIIIllIlIIlllII = this.func_193578_a(lllllllllllllIIlllIIIllIlIIllIII, lllllllllllllIIlllIIIllIlIIlIlll, lllllllllllllIIlllIIIllIlIIlIllI, lllllllllllllIIlllIIIllIlIIlIlIl, lllllllllllllIIlllIIIllIlIIlllII);
        return lllllllllllllIIlllIIIllIlIIlllII;
    }
    
    private PathNodeType func_192559_a(final EntityLiving lllllllllllllIIlllIIIllIlIIIlIlI, final BlockPos lllllllllllllIIlllIIIllIlIIIllII) {
        return this.func_192558_a(lllllllllllllIIlllIIIllIlIIIlIlI, lllllllllllllIIlllIIIllIlIIIllII.getX(), lllllllllllllIIlllIIIllIlIIIllII.getY(), lllllllllllllIIlllIIIllIlIIIllII.getZ());
    }
    
    @Override
    public PathPoint getStart() {
        int lllllllllllllIIlllIIIlllIlIlIIII;
        if (this.getCanSwim() && this.entity.isInWater()) {
            int lllllllllllllIIlllIIIlllIlIlIIIl = (int)this.entity.getEntityBoundingBox().minY;
            final BlockPos.MutableBlockPos lllllllllllllIIlllIIIlllIlIIllll = new BlockPos.MutableBlockPos(MathHelper.floor(this.entity.posX), lllllllllllllIIlllIIIlllIlIlIIIl, MathHelper.floor(this.entity.posZ));
            for (Block lllllllllllllIIlllIIIlllIlIIlllI = this.blockaccess.getBlockState(lllllllllllllIIlllIIIlllIlIIllll).getBlock(); lllllllllllllIIlllIIIlllIlIIlllI == Blocks.FLOWING_WATER || lllllllllllllIIlllIIIlllIlIIlllI == Blocks.WATER; lllllllllllllIIlllIIIlllIlIIlllI = this.blockaccess.getBlockState(lllllllllllllIIlllIIIlllIlIIllll).getBlock()) {
                ++lllllllllllllIIlllIIIlllIlIlIIIl;
                lllllllllllllIIlllIIIlllIlIIllll.setPos(MathHelper.floor(this.entity.posX), lllllllllllllIIlllIIIlllIlIlIIIl, MathHelper.floor(this.entity.posZ));
            }
        }
        else {
            lllllllllllllIIlllIIIlllIlIlIIII = MathHelper.floor(this.entity.getEntityBoundingBox().minY + 0.5);
        }
        final BlockPos lllllllllllllIIlllIIIlllIlIIllIl = new BlockPos(this.entity);
        final PathNodeType lllllllllllllIIlllIIIlllIlIIllII = this.func_192558_a(this.entity, lllllllllllllIIlllIIIlllIlIIllIl.getX(), lllllllllllllIIlllIIIlllIlIlIIII, lllllllllllllIIlllIIIlllIlIIllIl.getZ());
        if (this.entity.getPathPriority(lllllllllllllIIlllIIIlllIlIIllII) < 0.0f) {
            final Set<BlockPos> lllllllllllllIIlllIIIlllIlIIlIll = (Set<BlockPos>)Sets.newHashSet();
            lllllllllllllIIlllIIIlllIlIIlIll.add(new BlockPos(this.entity.getEntityBoundingBox().minX, lllllllllllllIIlllIIIlllIlIlIIII, this.entity.getEntityBoundingBox().minZ));
            lllllllllllllIIlllIIIlllIlIIlIll.add(new BlockPos(this.entity.getEntityBoundingBox().minX, lllllllllllllIIlllIIIlllIlIlIIII, this.entity.getEntityBoundingBox().maxZ));
            lllllllllllllIIlllIIIlllIlIIlIll.add(new BlockPos(this.entity.getEntityBoundingBox().maxX, lllllllllllllIIlllIIIlllIlIlIIII, this.entity.getEntityBoundingBox().minZ));
            lllllllllllllIIlllIIIlllIlIIlIll.add(new BlockPos(this.entity.getEntityBoundingBox().maxX, lllllllllllllIIlllIIIlllIlIlIIII, this.entity.getEntityBoundingBox().maxZ));
            for (final BlockPos lllllllllllllIIlllIIIlllIlIIlIlI : lllllllllllllIIlllIIIlllIlIIlIll) {
                final PathNodeType lllllllllllllIIlllIIIlllIlIIlIIl = this.func_192559_a(this.entity, lllllllllllllIIlllIIIlllIlIIlIlI);
                if (this.entity.getPathPriority(lllllllllllllIIlllIIIlllIlIIlIIl) >= 0.0f) {
                    return super.openPoint(lllllllllllllIIlllIIIlllIlIIlIlI.getX(), lllllllllllllIIlllIIIlllIlIIlIlI.getY(), lllllllllllllIIlllIIIlllIlIIlIlI.getZ());
                }
            }
        }
        return super.openPoint(lllllllllllllIIlllIIIlllIlIIllIl.getX(), lllllllllllllIIlllIIIlllIlIlIIII, lllllllllllllIIlllIIIlllIlIIllIl.getZ());
    }
    
    @Nullable
    @Override
    protected PathPoint openPoint(final int lllllllllllllIIlllIIIllIlllIlIII, final int lllllllllllllIIlllIIIllIlllIIlll, final int lllllllllllllIIlllIIIllIllIlllll) {
        PathPoint lllllllllllllIIlllIIIllIlllIIlIl = null;
        final PathNodeType lllllllllllllIIlllIIIllIlllIIlII = this.func_192558_a(this.entity, lllllllllllllIIlllIIIllIlllIlIII, lllllllllllllIIlllIIIllIlllIIlll, lllllllllllllIIlllIIIllIllIlllll);
        final float lllllllllllllIIlllIIIllIlllIIIll = this.entity.getPathPriority(lllllllllllllIIlllIIIllIlllIIlII);
        if (lllllllllllllIIlllIIIllIlllIIIll >= 0.0f) {
            lllllllllllllIIlllIIIllIlllIIlIl = super.openPoint(lllllllllllllIIlllIIIllIlllIlIII, lllllllllllllIIlllIIIllIlllIIlll, lllllllllllllIIlllIIIllIllIlllll);
            lllllllllllllIIlllIIIllIlllIIlIl.nodeType = lllllllllllllIIlllIIIllIlllIIlII;
            lllllllllllllIIlllIIIllIlllIIlIl.costMalus = Math.max(lllllllllllllIIlllIIIllIlllIIlIl.costMalus, lllllllllllllIIlllIIIllIlllIIIll);
            if (lllllllllllllIIlllIIIllIlllIIlII == PathNodeType.WALKABLE) {
                final PathPoint pathPoint = lllllllllllllIIlllIIIllIlllIIlIl;
                ++pathPoint.costMalus;
            }
        }
        return (lllllllllllllIIlllIIIllIlllIIlII != PathNodeType.OPEN && lllllllllllllIIlllIIIllIlllIIlII != PathNodeType.WALKABLE) ? lllllllllllllIIlllIIIllIlllIIlIl : lllllllllllllIIlllIIIllIlllIIlIl;
    }
}
