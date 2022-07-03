package net.minecraft.block.state;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import java.util.*;

public class BlockPistonStructureHelper
{
    private final /* synthetic */ World world;
    private final /* synthetic */ BlockPos blockToMove;
    private final /* synthetic */ List<BlockPos> toDestroy;
    private final /* synthetic */ BlockPos pistonPos;
    private final /* synthetic */ List<BlockPos> toMove;
    private final /* synthetic */ EnumFacing moveDirection;
    
    private boolean addBranchingBlocks(final BlockPos lllllllllllllllIlIlIlIlIlIIlllII) {
        final short lllllllllllllllIlIlIlIlIlIIlIlIl;
        final byte lllllllllllllllIlIlIlIlIlIIlIllI = (byte)((EnumFacing[])(Object)(lllllllllllllllIlIlIlIlIlIIlIlIl = (short)(Object)EnumFacing.values())).length;
        for (long lllllllllllllllIlIlIlIlIlIIllIII = 0; lllllllllllllllIlIlIlIlIlIIllIII < lllllllllllllllIlIlIlIlIlIIlIllI; ++lllllllllllllllIlIlIlIlIlIIllIII) {
            final EnumFacing lllllllllllllllIlIlIlIlIlIIlllll = lllllllllllllllIlIlIlIlIlIIlIlIl[lllllllllllllllIlIlIlIlIlIIllIII];
            if (lllllllllllllllIlIlIlIlIlIIlllll.getAxis() != this.moveDirection.getAxis() && !this.addBlockLine(lllllllllllllllIlIlIlIlIlIIlllII.offset(lllllllllllllllIlIlIlIlIlIIlllll), lllllllllllllllIlIlIlIlIlIIlllll)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean canMove() {
        this.toMove.clear();
        this.toDestroy.clear();
        final IBlockState lllllllllllllllIlIlIlIllIIllllll = this.world.getBlockState(this.blockToMove);
        if (!BlockPistonBase.canPush(lllllllllllllllIlIlIlIllIIllllll, this.world, this.blockToMove, this.moveDirection, false, this.moveDirection)) {
            if (lllllllllllllllIlIlIlIllIIllllll.getMobilityFlag() == EnumPushReaction.DESTROY) {
                this.toDestroy.add(this.blockToMove);
                return true;
            }
            return false;
        }
        else {
            if (!this.addBlockLine(this.blockToMove, this.moveDirection)) {
                return false;
            }
            for (int lllllllllllllllIlIlIlIllIIllllIl = 0; lllllllllllllllIlIlIlIllIIllllIl < this.toMove.size(); ++lllllllllllllllIlIlIlIllIIllllIl) {
                final BlockPos lllllllllllllllIlIlIlIllIIlllIll = this.toMove.get(lllllllllllllllIlIlIlIllIIllllIl);
                if (this.world.getBlockState(lllllllllllllllIlIlIlIllIIlllIll).getBlock() == Blocks.SLIME_BLOCK && !this.addBranchingBlocks(lllllllllllllllIlIlIlIllIIlllIll)) {
                    return false;
                }
            }
            return true;
        }
    }
    
    private boolean addBlockLine(final BlockPos lllllllllllllllIlIlIlIlIlllIIlll, final EnumFacing lllllllllllllllIlIlIlIlIlllllIII) {
        IBlockState lllllllllllllllIlIlIlIlIllllIlll = this.world.getBlockState(lllllllllllllllIlIlIlIlIlllIIlll);
        Block lllllllllllllllIlIlIlIlIllllIllI = lllllllllllllllIlIlIlIlIllllIlll.getBlock();
        if (lllllllllllllllIlIlIlIlIllllIlll.getMaterial() == Material.AIR) {
            return true;
        }
        if (!BlockPistonBase.canPush(lllllllllllllllIlIlIlIlIllllIlll, this.world, lllllllllllllllIlIlIlIlIlllIIlll, this.moveDirection, false, lllllllllllllllIlIlIlIlIlllllIII)) {
            return true;
        }
        if (lllllllllllllllIlIlIlIlIlllIIlll.equals(this.pistonPos)) {
            return true;
        }
        if (this.toMove.contains(lllllllllllllllIlIlIlIlIlllIIlll)) {
            return true;
        }
        int lllllllllllllllIlIlIlIlIllllIlIl = 1;
        if (lllllllllllllllIlIlIlIlIllllIlIl + this.toMove.size() > 12) {
            return false;
        }
        while (lllllllllllllllIlIlIlIlIllllIllI == Blocks.SLIME_BLOCK) {
            final BlockPos lllllllllllllllIlIlIlIlIllllIlII = lllllllllllllllIlIlIlIlIlllIIlll.offset(this.moveDirection.getOpposite(), lllllllllllllllIlIlIlIlIllllIlIl);
            lllllllllllllllIlIlIlIlIllllIlll = this.world.getBlockState(lllllllllllllllIlIlIlIlIllllIlII);
            lllllllllllllllIlIlIlIlIllllIllI = lllllllllllllllIlIlIlIlIllllIlll.getBlock();
            if (lllllllllllllllIlIlIlIlIllllIlll.getMaterial() == Material.AIR || !BlockPistonBase.canPush(lllllllllllllllIlIlIlIlIllllIlll, this.world, lllllllllllllllIlIlIlIlIllllIlII, this.moveDirection, false, this.moveDirection.getOpposite())) {
                break;
            }
            if (lllllllllllllllIlIlIlIlIllllIlII.equals(this.pistonPos)) {
                break;
            }
            if (++lllllllllllllllIlIlIlIlIllllIlIl + this.toMove.size() > 12) {
                return false;
            }
        }
        int lllllllllllllllIlIlIlIlIllllIIll = 0;
        for (int lllllllllllllllIlIlIlIlIllllIIlI = lllllllllllllllIlIlIlIlIllllIlIl - 1; lllllllllllllllIlIlIlIlIllllIIlI >= 0; --lllllllllllllllIlIlIlIlIllllIIlI) {
            this.toMove.add(lllllllllllllllIlIlIlIlIlllIIlll.offset(this.moveDirection.getOpposite(), lllllllllllllllIlIlIlIlIllllIIlI));
            ++lllllllllllllllIlIlIlIlIllllIIll;
        }
        int lllllllllllllllIlIlIlIlIllllIIIl = 1;
        while (true) {
            final BlockPos lllllllllllllllIlIlIlIlIllllIIII = lllllllllllllllIlIlIlIlIlllIIlll.offset(this.moveDirection, lllllllllllllllIlIlIlIlIllllIIIl);
            final int lllllllllllllllIlIlIlIlIlllIllll = this.toMove.indexOf(lllllllllllllllIlIlIlIlIllllIIII);
            if (lllllllllllllllIlIlIlIlIlllIllll > -1) {
                this.reorderListAtCollision(lllllllllllllllIlIlIlIlIllllIIll, lllllllllllllllIlIlIlIlIlllIllll);
                for (int lllllllllllllllIlIlIlIlIlllIllIl = 0; lllllllllllllllIlIlIlIlIlllIllIl <= lllllllllllllllIlIlIlIlIlllIllll + lllllllllllllllIlIlIlIlIllllIIll; ++lllllllllllllllIlIlIlIlIlllIllIl) {
                    final BlockPos lllllllllllllllIlIlIlIlIlllIlIll = this.toMove.get(lllllllllllllllIlIlIlIlIlllIllIl);
                    if (this.world.getBlockState(lllllllllllllllIlIlIlIlIlllIlIll).getBlock() == Blocks.SLIME_BLOCK && !this.addBranchingBlocks(lllllllllllllllIlIlIlIlIlllIlIll)) {
                        return false;
                    }
                }
                return true;
            }
            lllllllllllllllIlIlIlIlIllllIlll = this.world.getBlockState(lllllllllllllllIlIlIlIlIllllIIII);
            if (lllllllllllllllIlIlIlIlIllllIlll.getMaterial() == Material.AIR) {
                return true;
            }
            if (!BlockPistonBase.canPush(lllllllllllllllIlIlIlIlIllllIlll, this.world, lllllllllllllllIlIlIlIlIllllIIII, this.moveDirection, true, this.moveDirection) || lllllllllllllllIlIlIlIlIllllIIII.equals(this.pistonPos)) {
                return false;
            }
            if (lllllllllllllllIlIlIlIlIllllIlll.getMobilityFlag() == EnumPushReaction.DESTROY) {
                this.toDestroy.add(lllllllllllllllIlIlIlIlIllllIIII);
                return true;
            }
            if (this.toMove.size() >= 12) {
                return false;
            }
            this.toMove.add(lllllllllllllllIlIlIlIlIllllIIII);
            ++lllllllllllllllIlIlIlIlIllllIIll;
            ++lllllllllllllllIlIlIlIlIllllIIIl;
        }
    }
    
    public List<BlockPos> getBlocksToDestroy() {
        return this.toDestroy;
    }
    
    private void reorderListAtCollision(final int lllllllllllllllIlIlIlIlIlIllllII, final int lllllllllllllllIlIlIlIlIlIlllIlI) {
        final List<BlockPos> lllllllllllllllIlIlIlIlIllIIIIII = (List<BlockPos>)Lists.newArrayList();
        final List<BlockPos> lllllllllllllllIlIlIlIlIlIllllll = (List<BlockPos>)Lists.newArrayList();
        final List<BlockPos> lllllllllllllllIlIlIlIlIlIlllllI = (List<BlockPos>)Lists.newArrayList();
        lllllllllllllllIlIlIlIlIllIIIIII.addAll(this.toMove.subList(0, lllllllllllllllIlIlIlIlIlIlllIlI));
        lllllllllllllllIlIlIlIlIlIllllll.addAll(this.toMove.subList(this.toMove.size() - lllllllllllllllIlIlIlIlIlIllllII, this.toMove.size()));
        lllllllllllllllIlIlIlIlIlIlllllI.addAll(this.toMove.subList(lllllllllllllllIlIlIlIlIlIlllIlI, this.toMove.size() - lllllllllllllllIlIlIlIlIlIllllII));
        this.toMove.clear();
        this.toMove.addAll(lllllllllllllllIlIlIlIlIllIIIIII);
        this.toMove.addAll(lllllllllllllllIlIlIlIlIlIllllll);
        this.toMove.addAll(lllllllllllllllIlIlIlIlIlIlllllI);
    }
    
    public BlockPistonStructureHelper(final World lllllllllllllllIlIlIlIllIllIIIlI, final BlockPos lllllllllllllllIlIlIlIllIlIlIllI, final EnumFacing lllllllllllllllIlIlIlIllIlIllllI, final boolean lllllllllllllllIlIlIlIllIlIlIIlI) {
        this.toMove = (List<BlockPos>)Lists.newArrayList();
        this.toDestroy = (List<BlockPos>)Lists.newArrayList();
        this.world = lllllllllllllllIlIlIlIllIllIIIlI;
        this.pistonPos = lllllllllllllllIlIlIlIllIlIlIllI;
        if (lllllllllllllllIlIlIlIllIlIlIIlI) {
            this.moveDirection = lllllllllllllllIlIlIlIllIlIllllI;
            this.blockToMove = lllllllllllllllIlIlIlIllIlIlIllI.offset(lllllllllllllllIlIlIlIllIlIllllI);
        }
        else {
            this.moveDirection = lllllllllllllllIlIlIlIllIlIllllI.getOpposite();
            this.blockToMove = lllllllllllllllIlIlIlIllIlIlIllI.offset(lllllllllllllllIlIlIlIllIlIllllI, 2);
        }
    }
    
    public List<BlockPos> getBlocksToMove() {
        return this.toMove;
    }
}
