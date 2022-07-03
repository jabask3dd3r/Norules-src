package net.minecraft.tileentity;

import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.util.datafix.*;

public class TileEntityPiston extends TileEntity implements ITickable
{
    private /* synthetic */ boolean extending;
    private /* synthetic */ float lastProgress;
    private /* synthetic */ float progress;
    private /* synthetic */ EnumFacing pistonFacing;
    private static final /* synthetic */ ThreadLocal<EnumFacing> field_190613_i;
    private /* synthetic */ IBlockState pistonState;
    private /* synthetic */ boolean shouldHeadBeRendered;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = TileEntityPiston.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final char llllllllllllllllIllIIIIIIllllIlI = (Object)new int[EnumFacing.Axis.values().length];
        try {
            llllllllllllllllIllIIIIIIllllIlI[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIllIIIIIIllllIlI[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIllIIIIIIllllIlI[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return TileEntityPiston.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)llllllllllllllllIllIIIIIIllllIlI;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllllIllIIIIIlIlIIlll) {
        super.writeToNBT(llllllllllllllllIllIIIIIlIlIIlll);
        llllllllllllllllIllIIIIIlIlIIlll.setInteger("blockId", Block.getIdFromBlock(this.pistonState.getBlock()));
        llllllllllllllllIllIIIIIlIlIIlll.setInteger("blockData", this.pistonState.getBlock().getMetaFromState(this.pistonState));
        llllllllllllllllIllIIIIIlIlIIlll.setInteger("facing", this.pistonFacing.getIndex());
        llllllllllllllllIllIIIIIlIlIIlll.setFloat("progress", this.lastProgress);
        llllllllllllllllIllIIIIIlIlIIlll.setBoolean("extending", this.extending);
        llllllllllllllllIllIIIIIlIlIIlll.setBoolean("source", this.shouldHeadBeRendered);
        return llllllllllllllllIllIIIIIlIlIIlll;
    }
    
    static {
        field_190613_i = new ThreadLocal<EnumFacing>() {
            @Override
            protected EnumFacing initialValue() {
                return null;
            }
        };
    }
    
    public EnumFacing getFacing() {
        return this.pistonFacing;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllllIllIIIIIlIlIllIl) {
        super.readFromNBT(llllllllllllllllIllIIIIIlIlIllIl);
        this.pistonState = Block.getBlockById(llllllllllllllllIllIIIIIlIlIllIl.getInteger("blockId")).getStateFromMeta(llllllllllllllllIllIIIIIlIlIllIl.getInteger("blockData"));
        this.pistonFacing = EnumFacing.getFront(llllllllllllllllIllIIIIIlIlIllIl.getInteger("facing"));
        this.progress = llllllllllllllllIllIIIIIlIlIllIl.getFloat("progress");
        this.lastProgress = this.progress;
        this.extending = llllllllllllllllIllIIIIIlIlIllIl.getBoolean("extending");
        this.shouldHeadBeRendered = llllllllllllllllIllIIIIIlIlIllIl.getBoolean("source");
    }
    
    public AxisAlignedBB getAABB(final IBlockAccess llllllllllllllllIllIIIIlIlllIlII, final BlockPos llllllllllllllllIllIIIIlIlllIIII) {
        return this.getAABB(llllllllllllllllIllIIIIlIlllIlII, llllllllllllllllIllIIIIlIlllIIII, this.progress).union(this.getAABB(llllllllllllllllIllIIIIlIlllIlII, llllllllllllllllIllIIIIlIlllIIII, this.lastProgress));
    }
    
    public float getOffsetX(final float llllllllllllllllIllIIIIllIIIlIll) {
        return this.pistonFacing.getFrontOffsetX() * this.getExtendedProgress(this.getProgress(llllllllllllllllIllIIIIllIIIlIll));
    }
    
    private void moveCollidedEntities(final float llllllllllllllllIllIIIIlIlIIlllI) {
        final EnumFacing llllllllllllllllIllIIIIlIlIIllIl = this.extending ? this.pistonFacing : this.pistonFacing.getOpposite();
        final double llllllllllllllllIllIIIIlIlIIllII = llllllllllllllllIllIIIIlIlIIlllI - this.progress;
        final List<AxisAlignedBB> llllllllllllllllIllIIIIlIlIIlIll = (List<AxisAlignedBB>)Lists.newArrayList();
        this.func_190606_j().addCollisionBoxToList(this.world, BlockPos.ORIGIN, new AxisAlignedBB(BlockPos.ORIGIN), llllllllllllllllIllIIIIlIlIIlIll, null, true);
        if (!llllllllllllllllIllIIIIlIlIIlIll.isEmpty()) {
            final AxisAlignedBB llllllllllllllllIllIIIIlIlIIlIlI = this.func_190607_a(this.func_191515_a(llllllllllllllllIllIIIIlIlIIlIll));
            final List<Entity> llllllllllllllllIllIIIIlIlIIlIIl = this.world.getEntitiesWithinAABBExcludingEntity(null, this.func_190610_a(llllllllllllllllIllIIIIlIlIIlIlI, llllllllllllllllIllIIIIlIlIIllIl, llllllllllllllllIllIIIIlIlIIllII).union(llllllllllllllllIllIIIIlIlIIlIlI));
            if (!llllllllllllllllIllIIIIlIlIIlIIl.isEmpty()) {
                final boolean llllllllllllllllIllIIIIlIlIIlIII = this.pistonState.getBlock() == Blocks.SLIME_BLOCK;
                for (int llllllllllllllllIllIIIIlIlIIIlll = 0; llllllllllllllllIllIIIIlIlIIIlll < llllllllllllllllIllIIIIlIlIIlIIl.size(); ++llllllllllllllllIllIIIIlIlIIIlll) {
                    final Entity llllllllllllllllIllIIIIlIlIIIllI = llllllllllllllllIllIIIIlIlIIlIIl.get(llllllllllllllllIllIIIIlIlIIIlll);
                    if (llllllllllllllllIllIIIIlIlIIIllI.getPushReaction() != EnumPushReaction.IGNORE) {
                        if (llllllllllllllllIllIIIIlIlIIlIII) {
                            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[llllllllllllllllIllIIIIlIlIIllIl.getAxis().ordinal()]) {
                                case 1: {
                                    llllllllllllllllIllIIIIlIlIIIllI.motionX = llllllllllllllllIllIIIIlIlIIllIl.getFrontOffsetX();
                                    break;
                                }
                                case 2: {
                                    llllllllllllllllIllIIIIlIlIIIllI.motionY = llllllllllllllllIllIIIIlIlIIllIl.getFrontOffsetY();
                                    break;
                                }
                                case 3: {
                                    llllllllllllllllIllIIIIlIlIIIllI.motionZ = llllllllllllllllIllIIIIlIlIIllIl.getFrontOffsetZ();
                                    break;
                                }
                            }
                        }
                        double llllllllllllllllIllIIIIlIlIIIlIl = 0.0;
                        for (int llllllllllllllllIllIIIIlIlIIIlII = 0; llllllllllllllllIllIIIIlIlIIIlII < llllllllllllllllIllIIIIlIlIIlIll.size(); ++llllllllllllllllIllIIIIlIlIIIlII) {
                            final AxisAlignedBB llllllllllllllllIllIIIIlIlIIIIll = this.func_190610_a(this.func_190607_a(llllllllllllllllIllIIIIlIlIIlIll.get(llllllllllllllllIllIIIIlIlIIIlII)), llllllllllllllllIllIIIIlIlIIllIl, llllllllllllllllIllIIIIlIlIIllII);
                            final AxisAlignedBB llllllllllllllllIllIIIIlIlIIIIlI = llllllllllllllllIllIIIIlIlIIIllI.getEntityBoundingBox();
                            if (llllllllllllllllIllIIIIlIlIIIIll.intersectsWith(llllllllllllllllIllIIIIlIlIIIIlI)) {
                                llllllllllllllllIllIIIIlIlIIIlIl = Math.max(llllllllllllllllIllIIIIlIlIIIlIl, this.func_190612_a(llllllllllllllllIllIIIIlIlIIIIll, llllllllllllllllIllIIIIlIlIIllIl, llllllllllllllllIllIIIIlIlIIIIlI));
                                if (llllllllllllllllIllIIIIlIlIIIlIl >= llllllllllllllllIllIIIIlIlIIllII) {
                                    break;
                                }
                            }
                        }
                        if (llllllllllllllllIllIIIIlIlIIIlIl > 0.0) {
                            llllllllllllllllIllIIIIlIlIIIlIl = Math.min(llllllllllllllllIllIIIIlIlIIIlIl, llllllllllllllllIllIIIIlIlIIllII) + 0.01;
                            TileEntityPiston.field_190613_i.set(llllllllllllllllIllIIIIlIlIIllIl);
                            llllllllllllllllIllIIIIlIlIIIllI.moveEntity(MoverType.PISTON, llllllllllllllllIllIIIIlIlIIIlIl * llllllllllllllllIllIIIIlIlIIllIl.getFrontOffsetX(), llllllllllllllllIllIIIIlIlIIIlIl * llllllllllllllllIllIIIIlIlIIllIl.getFrontOffsetY(), llllllllllllllllIllIIIIlIlIIIlIl * llllllllllllllllIllIIIIlIlIIllIl.getFrontOffsetZ());
                            TileEntityPiston.field_190613_i.set(null);
                            if (!this.extending && this.shouldHeadBeRendered) {
                                this.func_190605_a(llllllllllllllllIllIIIIlIlIIIllI, llllllllllllllllIllIIIIlIlIIllIl, llllllllllllllllIllIIIIlIlIIllII);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public TileEntityPiston() {
    }
    
    private void func_190605_a(final Entity llllllllllllllllIllIIIIIllIlllll, final EnumFacing llllllllllllllllIllIIIIIlllIIlll, final double llllllllllllllllIllIIIIIllIlllIl) {
        final AxisAlignedBB llllllllllllllllIllIIIIIlllIIlIl = llllllllllllllllIllIIIIIllIlllll.getEntityBoundingBox();
        final AxisAlignedBB llllllllllllllllIllIIIIIlllIIlII = Block.FULL_BLOCK_AABB.offset(this.pos);
        if (llllllllllllllllIllIIIIIlllIIlIl.intersectsWith(llllllllllllllllIllIIIIIlllIIlII)) {
            final EnumFacing llllllllllllllllIllIIIIIlllIIIll = llllllllllllllllIllIIIIIlllIIlll.getOpposite();
            double llllllllllllllllIllIIIIIlllIIIlI = this.func_190612_a(llllllllllllllllIllIIIIIlllIIlII, llllllllllllllllIllIIIIIlllIIIll, llllllllllllllllIllIIIIIlllIIlIl) + 0.01;
            final double llllllllllllllllIllIIIIIlllIIIIl = this.func_190612_a(llllllllllllllllIllIIIIIlllIIlII, llllllllllllllllIllIIIIIlllIIIll, llllllllllllllllIllIIIIIlllIIlIl.func_191500_a(llllllllllllllllIllIIIIIlllIIlII)) + 0.01;
            if (Math.abs(llllllllllllllllIllIIIIIlllIIIlI - llllllllllllllllIllIIIIIlllIIIIl) < 0.01) {
                llllllllllllllllIllIIIIIlllIIIlI = Math.min(llllllllllllllllIllIIIIIlllIIIlI, llllllllllllllllIllIIIIIllIlllIl) + 0.01;
                TileEntityPiston.field_190613_i.set(llllllllllllllllIllIIIIIlllIIlll);
                llllllllllllllllIllIIIIIllIlllll.moveEntity(MoverType.PISTON, llllllllllllllllIllIIIIIlllIIIlI * llllllllllllllllIllIIIIIlllIIIll.getFrontOffsetX(), llllllllllllllllIllIIIIIlllIIIlI * llllllllllllllllIllIIIIIlllIIIll.getFrontOffsetY(), llllllllllllllllIllIIIIIlllIIIlI * llllllllllllllllIllIIIIIlllIIIll.getFrontOffsetZ());
                TileEntityPiston.field_190613_i.set(null);
            }
        }
    }
    
    private AxisAlignedBB func_190610_a(final AxisAlignedBB llllllllllllllllIllIIIIIlllllllI, final EnumFacing llllllllllllllllIllIIIIIllllllIl, final double llllllllllllllllIllIIIIIllllllII) {
        final double llllllllllllllllIllIIIIIlllllIll = llllllllllllllllIllIIIIIllllllII * llllllllllllllllIllIIIIIllllllIl.getAxisDirection().getOffset();
        final double llllllllllllllllIllIIIIIlllllIlI = Math.min(llllllllllllllllIllIIIIIlllllIll, 0.0);
        final double llllllllllllllllIllIIIIIlllllIIl = Math.max(llllllllllllllllIllIIIIIlllllIll, 0.0);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllllIllIIIIIllllllIl.ordinal()]) {
            case 5: {
                return new AxisAlignedBB(llllllllllllllllIllIIIIIlllllllI.minX + llllllllllllllllIllIIIIIlllllIlI, llllllllllllllllIllIIIIIlllllllI.minY, llllllllllllllllIllIIIIIlllllllI.minZ, llllllllllllllllIllIIIIIlllllllI.minX + llllllllllllllllIllIIIIIlllllIIl, llllllllllllllllIllIIIIIlllllllI.maxY, llllllllllllllllIllIIIIIlllllllI.maxZ);
            }
            case 6: {
                return new AxisAlignedBB(llllllllllllllllIllIIIIIlllllllI.maxX + llllllllllllllllIllIIIIIlllllIlI, llllllllllllllllIllIIIIIlllllllI.minY, llllllllllllllllIllIIIIIlllllllI.minZ, llllllllllllllllIllIIIIIlllllllI.maxX + llllllllllllllllIllIIIIIlllllIIl, llllllllllllllllIllIIIIIlllllllI.maxY, llllllllllllllllIllIIIIIlllllllI.maxZ);
            }
            case 1: {
                return new AxisAlignedBB(llllllllllllllllIllIIIIIlllllllI.minX, llllllllllllllllIllIIIIIlllllllI.minY + llllllllllllllllIllIIIIIlllllIlI, llllllllllllllllIllIIIIIlllllllI.minZ, llllllllllllllllIllIIIIIlllllllI.maxX, llllllllllllllllIllIIIIIlllllllI.minY + llllllllllllllllIllIIIIIlllllIIl, llllllllllllllllIllIIIIIlllllllI.maxZ);
            }
            default: {
                return new AxisAlignedBB(llllllllllllllllIllIIIIIlllllllI.minX, llllllllllllllllIllIIIIIlllllllI.maxY + llllllllllllllllIllIIIIIlllllIlI, llllllllllllllllIllIIIIIlllllllI.minZ, llllllllllllllllIllIIIIIlllllllI.maxX, llllllllllllllllIllIIIIIlllllllI.maxY + llllllllllllllllIllIIIIIlllllIIl, llllllllllllllllIllIIIIIlllllllI.maxZ);
            }
            case 3: {
                return new AxisAlignedBB(llllllllllllllllIllIIIIIlllllllI.minX, llllllllllllllllIllIIIIIlllllllI.minY, llllllllllllllllIllIIIIIlllllllI.minZ + llllllllllllllllIllIIIIIlllllIlI, llllllllllllllllIllIIIIIlllllllI.maxX, llllllllllllllllIllIIIIIlllllllI.maxY, llllllllllllllllIllIIIIIlllllllI.minZ + llllllllllllllllIllIIIIIlllllIIl);
            }
            case 4: {
                return new AxisAlignedBB(llllllllllllllllIllIIIIIlllllllI.minX, llllllllllllllllIllIIIIIlllllllI.minY, llllllllllllllllIllIIIIIlllllllI.maxZ + llllllllllllllllIllIIIIIlllllIlI, llllllllllllllllIllIIIIIlllllllI.maxX, llllllllllllllllIllIIIIIlllllllI.maxY, llllllllllllllllIllIIIIIlllllllI.maxZ + llllllllllllllllIllIIIIIlllllIIl);
            }
        }
    }
    
    private AxisAlignedBB func_191515_a(final List<AxisAlignedBB> llllllllllllllllIllIIIIlIIlIlIIl) {
        double llllllllllllllllIllIIIIlIIlIlIII = 0.0;
        double llllllllllllllllIllIIIIlIIlIIlll = 0.0;
        double llllllllllllllllIllIIIIlIIlIIllI = 0.0;
        double llllllllllllllllIllIIIIlIIlIIlIl = 1.0;
        double llllllllllllllllIllIIIIlIIlIIlII = 1.0;
        double llllllllllllllllIllIIIIlIIlIIIll = 1.0;
        for (final AxisAlignedBB llllllllllllllllIllIIIIlIIlIIIlI : llllllllllllllllIllIIIIlIIlIlIIl) {
            llllllllllllllllIllIIIIlIIlIlIII = Math.min(llllllllllllllllIllIIIIlIIlIIIlI.minX, llllllllllllllllIllIIIIlIIlIlIII);
            llllllllllllllllIllIIIIlIIlIIlll = Math.min(llllllllllllllllIllIIIIlIIlIIIlI.minY, llllllllllllllllIllIIIIlIIlIIlll);
            llllllllllllllllIllIIIIlIIlIIllI = Math.min(llllllllllllllllIllIIIIlIIlIIIlI.minZ, llllllllllllllllIllIIIIlIIlIIllI);
            llllllllllllllllIllIIIIlIIlIIlIl = Math.max(llllllllllllllllIllIIIIlIIlIIIlI.maxX, llllllllllllllllIllIIIIlIIlIIlIl);
            llllllllllllllllIllIIIIlIIlIIlII = Math.max(llllllllllllllllIllIIIIlIIlIIIlI.maxY, llllllllllllllllIllIIIIlIIlIIlII);
            llllllllllllllllIllIIIIlIIlIIIll = Math.max(llllllllllllllllIllIIIIlIIlIIIlI.maxZ, llllllllllllllllIllIIIIlIIlIIIll);
        }
        return new AxisAlignedBB(llllllllllllllllIllIIIIlIIlIlIII, llllllllllllllllIllIIIIlIIlIIlll, llllllllllllllllIllIIIIlIIlIIllI, llllllllllllllllIllIIIIlIIlIIlIl, llllllllllllllllIllIIIIlIIlIIlII, llllllllllllllllIllIIIIlIIlIIIll);
    }
    
    private static double func_190608_c(final AxisAlignedBB llllllllllllllllIllIIIIIllIIlIII, final EnumFacing llllllllllllllllIllIIIIIllIIIlll, final AxisAlignedBB llllllllllllllllIllIIIIIllIIIllI) {
        return (llllllllllllllllIllIIIIIllIIIlll.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? (llllllllllllllllIllIIIIIllIIlIII.maxY - llllllllllllllllIllIIIIIllIIIllI.minY) : (llllllllllllllllIllIIIIIllIIIllI.maxY - llllllllllllllllIllIIIIIllIIlIII.minY);
    }
    
    public void func_190609_a(final World llllllllllllllllIllIIIIIlIIIlIII, final BlockPos llllllllllllllllIllIIIIIlIIIIlll, final AxisAlignedBB llllllllllllllllIllIIIIIlIIIIllI, final List<AxisAlignedBB> llllllllllllllllIllIIIIIlIIIIlIl, @Nullable final Entity llllllllllllllllIllIIIIIlIIIIlII) {
        if (!this.extending && this.shouldHeadBeRendered) {
            this.pistonState.withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, true).addCollisionBoxToList(llllllllllllllllIllIIIIIlIIIlIII, llllllllllllllllIllIIIIIlIIIIlll, llllllllllllllllIllIIIIIlIIIIllI, llllllllllllllllIllIIIIIlIIIIlIl, llllllllllllllllIllIIIIIlIIIIlII, false);
        }
        final EnumFacing llllllllllllllllIllIIIIIlIIlIIlI = TileEntityPiston.field_190613_i.get();
        if (this.progress >= 1.0 || llllllllllllllllIllIIIIIlIIlIIlI != (this.extending ? this.pistonFacing : this.pistonFacing.getOpposite())) {
            final int llllllllllllllllIllIIIIIlIIlIIIl = llllllllllllllllIllIIIIIlIIIIlIl.size();
            IBlockState llllllllllllllllIllIIIIIlIIIllll = null;
            if (this.shouldPistonHeadBeRendered()) {
                final IBlockState llllllllllllllllIllIIIIIlIIlIIII = Blocks.PISTON_HEAD.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, this.pistonFacing).withProperty((IProperty<Comparable>)BlockPistonExtension.SHORT, this.extending ^ 1.0f - this.progress < 0.25f);
            }
            else {
                llllllllllllllllIllIIIIIlIIIllll = this.pistonState;
            }
            final float llllllllllllllllIllIIIIIlIIIlllI = this.getExtendedProgress(this.progress);
            final double llllllllllllllllIllIIIIIlIIIllIl = this.pistonFacing.getFrontOffsetX() * llllllllllllllllIllIIIIIlIIIlllI;
            final double llllllllllllllllIllIIIIIlIIIllII = this.pistonFacing.getFrontOffsetY() * llllllllllllllllIllIIIIIlIIIlllI;
            final double llllllllllllllllIllIIIIIlIIIlIll = this.pistonFacing.getFrontOffsetZ() * llllllllllllllllIllIIIIIlIIIlllI;
            llllllllllllllllIllIIIIIlIIIllll.addCollisionBoxToList(llllllllllllllllIllIIIIIlIIIlIII, llllllllllllllllIllIIIIIlIIIIlll, llllllllllllllllIllIIIIIlIIIIllI.offset(-llllllllllllllllIllIIIIIlIIIllIl, -llllllllllllllllIllIIIIIlIIIllII, -llllllllllllllllIllIIIIIlIIIlIll), llllllllllllllllIllIIIIIlIIIIlIl, llllllllllllllllIllIIIIIlIIIIlII, true);
            for (int llllllllllllllllIllIIIIIlIIIlIlI = llllllllllllllllIllIIIIIlIIlIIIl; llllllllllllllllIllIIIIIlIIIlIlI < llllllllllllllllIllIIIIIlIIIIlIl.size(); ++llllllllllllllllIllIIIIIlIIIlIlI) {
                llllllllllllllllIllIIIIIlIIIIlIl.set(llllllllllllllllIllIIIIIlIIIlIlI, llllllllllllllllIllIIIIIlIIIIlIl.get(llllllllllllllllIllIIIIIlIIIlIlI).offset(llllllllllllllllIllIIIIIlIIIllIl, llllllllllllllllIllIIIIIlIIIllII, llllllllllllllllIllIIIIIlIIIlIll));
            }
        }
    }
    
    public float getOffsetY(final float llllllllllllllllIllIIIIllIIIIlll) {
        return this.pistonFacing.getFrontOffsetY() * this.getExtendedProgress(this.getProgress(llllllllllllllllIllIIIIllIIIIlll));
    }
    
    public float getProgress(float llllllllllllllllIllIIIIllIIlIIIl) {
        if (llllllllllllllllIllIIIIllIIlIIIl > 1.0f) {
            llllllllllllllllIllIIIIllIIlIIIl = 1.0f;
        }
        return this.lastProgress + (this.progress - this.lastProgress) * llllllllllllllllIllIIIIllIIlIIIl;
    }
    
    @Override
    public void update() {
        this.lastProgress = this.progress;
        if (this.lastProgress >= 1.0f) {
            this.world.removeTileEntity(this.pos);
            this.invalidate();
            if (this.world.getBlockState(this.pos).getBlock() == Blocks.PISTON_EXTENSION) {
                this.world.setBlockState(this.pos, this.pistonState, 3);
                this.world.func_190524_a(this.pos, this.pistonState.getBlock(), this.pos);
            }
        }
        else {
            final float llllllllllllllllIllIIIIIlIllIllI = this.progress + 0.5f;
            this.moveCollidedEntities(llllllllllllllllIllIIIIIlIllIllI);
            this.progress = llllllllllllllllIllIIIIIlIllIllI;
            if (this.progress >= 1.0f) {
                this.progress = 1.0f;
            }
        }
    }
    
    public TileEntityPiston(final IBlockState llllllllllllllllIllIIIIllIlIllll, final EnumFacing llllllllllllllllIllIIIIllIlIlllI, final boolean llllllllllllllllIllIIIIllIlIllIl, final boolean llllllllllllllllIllIIIIllIlIIlll) {
        this.pistonState = llllllllllllllllIllIIIIllIlIllll;
        this.pistonFacing = llllllllllllllllIllIIIIllIlIlllI;
        this.extending = llllllllllllllllIllIIIIllIlIllIl;
        this.shouldHeadBeRendered = llllllllllllllllIllIIIIllIlIIlll;
    }
    
    public float getOffsetZ(final float llllllllllllllllIllIIIIlIlllllll) {
        return this.pistonFacing.getFrontOffsetZ() * this.getExtendedProgress(this.getProgress(llllllllllllllllIllIIIIlIlllllll));
    }
    
    private static double func_190611_b(final AxisAlignedBB llllllllllllllllIllIIIIIllIlIlII, final EnumFacing llllllllllllllllIllIIIIIllIlIIII, final AxisAlignedBB llllllllllllllllIllIIIIIllIIllll) {
        return (llllllllllllllllIllIIIIIllIlIIII.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? (llllllllllllllllIllIIIIIllIlIlII.maxX - llllllllllllllllIllIIIIIllIIllll.minX) : (llllllllllllllllIllIIIIIllIIllll.maxX - llllllllllllllllIllIIIIIllIlIlII.minX);
    }
    
    public IBlockState getPistonState() {
        return this.pistonState;
    }
    
    @Override
    public int getBlockMetadata() {
        return 0;
    }
    
    private float getExtendedProgress(final float llllllllllllllllIllIIIIlIllllIll) {
        return this.extending ? (llllllllllllllllIllIIIIlIllllIll - 1.0f) : (1.0f - llllllllllllllllIllIIIIlIllllIll);
    }
    
    private static double func_190604_d(final AxisAlignedBB llllllllllllllllIllIIIIIlIllllll, final EnumFacing llllllllllllllllIllIIIIIllIIIIIl, final AxisAlignedBB llllllllllllllllIllIIIIIlIllllIl) {
        return (llllllllllllllllIllIIIIIllIIIIIl.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? (llllllllllllllllIllIIIIIlIllllll.maxZ - llllllllllllllllIllIIIIIlIllllIl.minZ) : (llllllllllllllllIllIIIIIlIllllIl.maxZ - llllllllllllllllIllIIIIIlIllllll.minZ);
    }
    
    private AxisAlignedBB func_190607_a(final AxisAlignedBB llllllllllllllllIllIIIIlIIIIIlll) {
        final double llllllllllllllllIllIIIIlIIIIlIIl = this.getExtendedProgress(this.progress);
        return llllllllllllllllIllIIIIlIIIIIlll.offset(this.pos.getX() + llllllllllllllllIllIIIIlIIIIlIIl * this.pistonFacing.getFrontOffsetX(), this.pos.getY() + llllllllllllllllIllIIIIlIIIIlIIl * this.pistonFacing.getFrontOffsetY(), this.pos.getZ() + llllllllllllllllIllIIIIlIIIIlIIl * this.pistonFacing.getFrontOffsetZ());
    }
    
    private double func_190612_a(final AxisAlignedBB llllllllllllllllIllIIIIlIIIlIlII, final EnumFacing llllllllllllllllIllIIIIlIIIlIIll, final AxisAlignedBB llllllllllllllllIllIIIIlIIIIllll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[llllllllllllllllIllIIIIlIIIlIIll.getAxis().ordinal()]) {
            case 1: {
                return func_190611_b(llllllllllllllllIllIIIIlIIIlIlII, llllllllllllllllIllIIIIlIIIlIIll, llllllllllllllllIllIIIIlIIIIllll);
            }
            default: {
                return func_190608_c(llllllllllllllllIllIIIIlIIIlIlII, llllllllllllllllIllIIIIlIIIlIIll, llllllllllllllllIllIIIIlIIIIllll);
            }
            case 3: {
                return func_190604_d(llllllllllllllllIllIIIIlIIIlIlII, llllllllllllllllIllIIIIlIIIlIIll, llllllllllllllllIllIIIIlIIIIllll);
            }
        }
    }
    
    public boolean shouldPistonHeadBeRendered() {
        return this.shouldHeadBeRendered;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = TileEntityPiston.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final byte llllllllllllllllIllIIIIIIllllIII = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllllIllIIIIIIllllIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIllIIIIIIllllIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIllIIIIIIllllIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIllIIIIIIllllIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllllIllIIIIIIllllIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllllIllIIIIIIllllIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return TileEntityPiston.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllllIllIIIIIIllllIII;
    }
    
    public boolean isExtending() {
        return this.extending;
    }
    
    public AxisAlignedBB getAABB(final IBlockAccess llllllllllllllllIllIIIIlIllIIlII, final BlockPos llllllllllllllllIllIIIIlIllIIIll, float llllllllllllllllIllIIIIlIllIIIlI) {
        llllllllllllllllIllIIIIlIllIIIlI = (long)this.getExtendedProgress((float)llllllllllllllllIllIIIIlIllIIIlI);
        final IBlockState llllllllllllllllIllIIIIlIllIIllI = this.func_190606_j();
        return llllllllllllllllIllIIIIlIllIIllI.getBoundingBox(llllllllllllllllIllIIIIlIllIIlII, llllllllllllllllIllIIIIlIllIIIll).offset(llllllllllllllllIllIIIIlIllIIIlI * (float)this.pistonFacing.getFrontOffsetX(), llllllllllllllllIllIIIIlIllIIIlI * (float)this.pistonFacing.getFrontOffsetY(), llllllllllllllllIllIIIIlIllIIIlI * (float)this.pistonFacing.getFrontOffsetZ());
    }
    
    public static void registerFixesPiston(final DataFixer llllllllllllllllIllIIIIIlIllIIll) {
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    private IBlockState func_190606_j() {
        return (!this.isExtending() && this.shouldPistonHeadBeRendered()) ? Blocks.PISTON_HEAD.getDefaultState().withProperty(BlockPistonExtension.TYPE, (this.pistonState.getBlock() == Blocks.STICKY_PISTON) ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT).withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, (EnumFacing)this.pistonState.getValue((IProperty<V>)BlockPistonBase.FACING)) : this.pistonState;
    }
    
    public void clearPistonTileEntity() {
        if (this.lastProgress < 1.0f && this.world != null) {
            this.progress = 1.0f;
            this.lastProgress = this.progress;
            this.world.removeTileEntity(this.pos);
            this.invalidate();
            if (this.world.getBlockState(this.pos).getBlock() == Blocks.PISTON_EXTENSION) {
                this.world.setBlockState(this.pos, this.pistonState, 3);
                this.world.func_190524_a(this.pos, this.pistonState.getBlock(), this.pos);
            }
        }
    }
}
