package net.minecraft.world.gen.structure;

import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;

public abstract class StructureComponent
{
    protected /* synthetic */ StructureBoundingBox boundingBox;
    @Nullable
    private /* synthetic */ EnumFacing coordBaseMode;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected /* synthetic */ int componentType;
    private /* synthetic */ Mirror mirror;
    private /* synthetic */ Rotation rotation;
    
    protected IBlockState getBlockStateFromPos(final World lllllllllllllIIIllIIlIIIIllIIIIl, final int lllllllllllllIIIllIIlIIIIlIlIllI, final int lllllllllllllIIIllIIlIIIIlIlIlIl, final int lllllllllllllIIIllIIlIIIIlIlIlII, final StructureBoundingBox lllllllllllllIIIllIIlIIIIlIlIIll) {
        final int lllllllllllllIIIllIIlIIIIlIlllII = this.getXWithOffset(lllllllllllllIIIllIIlIIIIlIlIllI, lllllllllllllIIIllIIlIIIIlIlIlII);
        final int lllllllllllllIIIllIIlIIIIlIllIll = this.getYWithOffset(lllllllllllllIIIllIIlIIIIlIlIlIl);
        final int lllllllllllllIIIllIIlIIIIlIllIlI = this.getZWithOffset(lllllllllllllIIIllIIlIIIIlIlIllI, lllllllllllllIIIllIIlIIIIlIlIlII);
        final BlockPos lllllllllllllIIIllIIlIIIIlIllIIl = new BlockPos(lllllllllllllIIIllIIlIIIIlIlllII, lllllllllllllIIIllIIlIIIIlIllIll, lllllllllllllIIIllIIlIIIIlIllIlI);
        return lllllllllllllIIIllIIlIIIIlIlIIll.isVecInside(lllllllllllllIIIllIIlIIIIlIllIIl) ? lllllllllllllIIIllIIlIIIIllIIIIl.getBlockState(lllllllllllllIIIllIIlIIIIlIllIIl) : Blocks.AIR.getDefaultState();
    }
    
    protected int getXWithOffset(final int lllllllllllllIIIllIIlIIIlIIlllIl, final int lllllllllllllIIIllIIlIIIlIIlllII) {
        final EnumFacing lllllllllllllIIIllIIlIIIlIIllIll = this.getCoordBaseMode();
        if (lllllllllllllIIIllIIlIIIlIIllIll == null) {
            return lllllllllllllIIIllIIlIIIlIIlllIl;
        }
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIIllIIlIIIlIIllIll.ordinal()]) {
            case 3:
            case 4: {
                return this.boundingBox.minX + lllllllllllllIIIllIIlIIIlIIlllIl;
            }
            case 5: {
                return this.boundingBox.maxX - lllllllllllllIIIllIIlIIIlIIlllII;
            }
            case 6: {
                return this.boundingBox.minX + lllllllllllllIIIllIIlIIIlIIlllII;
            }
            default: {
                return lllllllllllllIIIllIIlIIIlIIlllIl;
            }
        }
    }
    
    protected boolean isLiquidInStructureBoundingBox(final World lllllllllllllIIIllIIlIIIlIllllIl, final StructureBoundingBox lllllllllllllIIIllIIlIIIlIllllII) {
        final int lllllllllllllIIIllIIlIIIlIlllIll = Math.max(this.boundingBox.minX - 1, lllllllllllllIIIllIIlIIIlIllllII.minX);
        final int lllllllllllllIIIllIIlIIIlIlllIlI = Math.max(this.boundingBox.minY - 1, lllllllllllllIIIllIIlIIIlIllllII.minY);
        final int lllllllllllllIIIllIIlIIIlIlllIIl = Math.max(this.boundingBox.minZ - 1, lllllllllllllIIIllIIlIIIlIllllII.minZ);
        final int lllllllllllllIIIllIIlIIIlIlllIII = Math.min(this.boundingBox.maxX + 1, lllllllllllllIIIllIIlIIIlIllllII.maxX);
        final int lllllllllllllIIIllIIlIIIlIllIlll = Math.min(this.boundingBox.maxY + 1, lllllllllllllIIIllIIlIIIlIllllII.maxY);
        final int lllllllllllllIIIllIIlIIIlIllIllI = Math.min(this.boundingBox.maxZ + 1, lllllllllllllIIIllIIlIIIlIllllII.maxZ);
        final BlockPos.MutableBlockPos lllllllllllllIIIllIIlIIIlIllIlIl = new BlockPos.MutableBlockPos();
        for (int lllllllllllllIIIllIIlIIIlIllIlII = lllllllllllllIIIllIIlIIIlIlllIll; lllllllllllllIIIllIIlIIIlIllIlII <= lllllllllllllIIIllIIlIIIlIlllIII; ++lllllllllllllIIIllIIlIIIlIllIlII) {
            for (int lllllllllllllIIIllIIlIIIlIllIIll = lllllllllllllIIIllIIlIIIlIlllIIl; lllllllllllllIIIllIIlIIIlIllIIll <= lllllllllllllIIIllIIlIIIlIllIllI; ++lllllllllllllIIIllIIlIIIlIllIIll) {
                if (lllllllllllllIIIllIIlIIIlIllllIl.getBlockState(lllllllllllllIIIllIIlIIIlIllIlIl.setPos(lllllllllllllIIIllIIlIIIlIllIlII, lllllllllllllIIIllIIlIIIlIlllIlI, lllllllllllllIIIllIIlIIIlIllIIll)).getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllllIIIllIIlIIIlIllllIl.getBlockState(lllllllllllllIIIllIIlIIIlIllIlIl.setPos(lllllllllllllIIIllIIlIIIlIllIlII, lllllllllllllIIIllIIlIIIlIllIlll, lllllllllllllIIIllIIlIIIlIllIIll)).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int lllllllllllllIIIllIIlIIIlIllIIlI = lllllllllllllIIIllIIlIIIlIlllIll; lllllllllllllIIIllIIlIIIlIllIIlI <= lllllllllllllIIIllIIlIIIlIlllIII; ++lllllllllllllIIIllIIlIIIlIllIIlI) {
            for (int lllllllllllllIIIllIIlIIIlIllIIIl = lllllllllllllIIIllIIlIIIlIlllIlI; lllllllllllllIIIllIIlIIIlIllIIIl <= lllllllllllllIIIllIIlIIIlIllIlll; ++lllllllllllllIIIllIIlIIIlIllIIIl) {
                if (lllllllllllllIIIllIIlIIIlIllllIl.getBlockState(lllllllllllllIIIllIIlIIIlIllIlIl.setPos(lllllllllllllIIIllIIlIIIlIllIIlI, lllllllllllllIIIllIIlIIIlIllIIIl, lllllllllllllIIIllIIlIIIlIlllIIl)).getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllllIIIllIIlIIIlIllllIl.getBlockState(lllllllllllllIIIllIIlIIIlIllIlIl.setPos(lllllllllllllIIIllIIlIIIlIllIIlI, lllllllllllllIIIllIIlIIIlIllIIIl, lllllllllllllIIIllIIlIIIlIllIllI)).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int lllllllllllllIIIllIIlIIIlIllIIII = lllllllllllllIIIllIIlIIIlIlllIIl; lllllllllllllIIIllIIlIIIlIllIIII <= lllllllllllllIIIllIIlIIIlIllIllI; ++lllllllllllllIIIllIIlIIIlIllIIII) {
            for (int lllllllllllllIIIllIIlIIIlIlIllll = lllllllllllllIIIllIIlIIIlIlllIlI; lllllllllllllIIIllIIlIIIlIlIllll <= lllllllllllllIIIllIIlIIIlIllIlll; ++lllllllllllllIIIllIIlIIIlIlIllll) {
                if (lllllllllllllIIIllIIlIIIlIllllIl.getBlockState(lllllllllllllIIIllIIlIIIlIllIlIl.setPos(lllllllllllllIIIllIIlIIIlIlllIll, lllllllllllllIIIllIIlIIIlIlIllll, lllllllllllllIIIllIIlIIIlIllIIII)).getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllllIIIllIIlIIIlIllllIl.getBlockState(lllllllllllllIIIllIIlIIIlIllIlIl.setPos(lllllllllllllIIIllIIlIIIlIlllIII, lllllllllllllIIIllIIlIIIlIlIllll, lllllllllllllIIIllIIlIIIlIllIIII)).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void setCoordBaseMode(@Nullable final EnumFacing lllllllllllllIIIllIIIllIIllIlIlI) {
        this.coordBaseMode = lllllllllllllIIIllIIIllIIllIlIlI;
        if (lllllllllllllIIIllIIIllIIllIlIlI == null) {
            this.rotation = Rotation.NONE;
            this.mirror = Mirror.NONE;
        }
        else {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIIllIIIllIIllIlIlI.ordinal()]) {
                case 4: {
                    this.mirror = Mirror.LEFT_RIGHT;
                    this.rotation = Rotation.NONE;
                    break;
                }
                case 5: {
                    this.mirror = Mirror.LEFT_RIGHT;
                    this.rotation = Rotation.CLOCKWISE_90;
                    break;
                }
                case 6: {
                    this.mirror = Mirror.NONE;
                    this.rotation = Rotation.CLOCKWISE_90;
                    break;
                }
                default: {
                    this.mirror = Mirror.NONE;
                    this.rotation = Rotation.NONE;
                    break;
                }
            }
        }
    }
    
    public StructureComponent() {
    }
    
    protected StructureComponent(final int lllllllllllllIIIllIIlIIIllllIlll) {
        this.componentType = lllllllllllllIIIllIIlIIIllllIlll;
    }
    
    protected void fillWithRandomizedBlocks(final World lllllllllllllIIIllIIIlllllIIIIII, final StructureBoundingBox lllllllllllllIIIllIIIllllIllllll, final int lllllllllllllIIIllIIIlllllIIllIl, final int lllllllllllllIIIllIIIlllllIIllII, final int lllllllllllllIIIllIIIllllIllllII, final int lllllllllllllIIIllIIIlllllIIlIlI, final int lllllllllllllIIIllIIIlllllIIlIIl, final int lllllllllllllIIIllIIIlllllIIlIII, final boolean lllllllllllllIIIllIIIllllIlllIII, final Random lllllllllllllIIIllIIIllllIllIlll, final BlockSelector lllllllllllllIIIllIIIllllIllIllI) {
        for (int lllllllllllllIIIllIIIlllllIIIlII = lllllllllllllIIIllIIIlllllIIllII; lllllllllllllIIIllIIIlllllIIIlII <= lllllllllllllIIIllIIIlllllIIlIIl; ++lllllllllllllIIIllIIIlllllIIIlII) {
            for (int lllllllllllllIIIllIIIlllllIIIIll = lllllllllllllIIIllIIIlllllIIllIl; lllllllllllllIIIllIIIlllllIIIIll <= lllllllllllllIIIllIIIlllllIIlIlI; ++lllllllllllllIIIllIIIlllllIIIIll) {
                for (int lllllllllllllIIIllIIIlllllIIIIlI = lllllllllllllIIIllIIIllllIllllII; lllllllllllllIIIllIIIlllllIIIIlI <= lllllllllllllIIIllIIIlllllIIlIII; ++lllllllllllllIIIllIIIlllllIIIIlI) {
                    if (!lllllllllllllIIIllIIIllllIlllIII || this.getBlockStateFromPos(lllllllllllllIIIllIIIlllllIIIIII, lllllllllllllIIIllIIIlllllIIIIll, lllllllllllllIIIllIIIlllllIIIlII, lllllllllllllIIIllIIIlllllIIIIlI, lllllllllllllIIIllIIIllllIllllll).getMaterial() != Material.AIR) {
                        lllllllllllllIIIllIIIllllIllIllI.selectBlocks(lllllllllllllIIIllIIIllllIllIlll, lllllllllllllIIIllIIIlllllIIIIll, lllllllllllllIIIllIIIlllllIIIlII, lllllllllllllIIIllIIIlllllIIIIlI, lllllllllllllIIIllIIIlllllIIIlII == lllllllllllllIIIllIIIlllllIIllII || lllllllllllllIIIllIIIlllllIIIlII == lllllllllllllIIIllIIIlllllIIlIIl || lllllllllllllIIIllIIIlllllIIIIll == lllllllllllllIIIllIIIlllllIIllIl || lllllllllllllIIIllIIIlllllIIIIll == lllllllllllllIIIllIIIlllllIIlIlI || lllllllllllllIIIllIIIlllllIIIIlI == lllllllllllllIIIllIIIllllIllllII || lllllllllllllIIIllIIIlllllIIIIlI == lllllllllllllIIIllIIIlllllIIlIII);
                        this.setBlockState(lllllllllllllIIIllIIIlllllIIIIII, lllllllllllllIIIllIIIllllIllIllI.getBlockState(), lllllllllllllIIIllIIIlllllIIIIll, lllllllllllllIIIllIIIlllllIIIlII, lllllllllllllIIIllIIIlllllIIIIlI, lllllllllllllIIIllIIIllllIllllll);
                    }
                }
            }
        }
    }
    
    protected void fillWithAir(final World lllllllllllllIIIllIIlIIIIIIlIlll, final StructureBoundingBox lllllllllllllIIIllIIlIIIIIlIIIlI, final int lllllllllllllIIIllIIlIIIIIlIIIIl, final int lllllllllllllIIIllIIlIIIIIIlIlII, final int lllllllllllllIIIllIIlIIIIIIlIIll, final int lllllllllllllIIIllIIlIIIIIIlIIlI, final int lllllllllllllIIIllIIlIIIIIIlIIIl, final int lllllllllllllIIIllIIlIIIIIIlIIII) {
        for (int lllllllllllllIIIllIIlIIIIIIllIll = lllllllllllllIIIllIIlIIIIIIlIlII; lllllllllllllIIIllIIlIIIIIIllIll <= lllllllllllllIIIllIIlIIIIIIlIIIl; ++lllllllllllllIIIllIIlIIIIIIllIll) {
            for (int lllllllllllllIIIllIIlIIIIIIllIlI = lllllllllllllIIIllIIlIIIIIlIIIIl; lllllllllllllIIIllIIlIIIIIIllIlI <= lllllllllllllIIIllIIlIIIIIIlIIlI; ++lllllllllllllIIIllIIlIIIIIIllIlI) {
                for (int lllllllllllllIIIllIIlIIIIIIllIIl = lllllllllllllIIIllIIlIIIIIIlIIll; lllllllllllllIIIllIIlIIIIIIllIIl <= lllllllllllllIIIllIIlIIIIIIlIIII; ++lllllllllllllIIIllIIlIIIIIIllIIl) {
                    this.setBlockState(lllllllllllllIIIllIIlIIIIIIlIlll, Blocks.AIR.getDefaultState(), lllllllllllllIIIllIIlIIIIIIllIlI, lllllllllllllIIIllIIlIIIIIIllIll, lllllllllllllIIIllIIlIIIIIIllIIl, lllllllllllllIIIllIIlIIIIIlIIIlI);
                }
            }
        }
    }
    
    protected void randomlyRareFillWithBlocks(final World lllllllllllllIIIllIIIlllIIllIIlI, final StructureBoundingBox lllllllllllllIIIllIIIlllIIllIIIl, final int lllllllllllllIIIllIIIlllIlIIIlll, final int lllllllllllllIIIllIIIlllIlIIIllI, final int lllllllllllllIIIllIIIlllIlIIIlIl, final int lllllllllllllIIIllIIIlllIlIIIlII, final int lllllllllllllIIIllIIIlllIIlIllII, final int lllllllllllllIIIllIIIlllIIlIlIll, final IBlockState lllllllllllllIIIllIIIlllIlIIIIIl, final boolean lllllllllllllIIIllIIIlllIlIIIIII) {
        final float lllllllllllllIIIllIIIlllIIllllll = (float)(lllllllllllllIIIllIIIlllIlIIIlII - lllllllllllllIIIllIIIlllIlIIIlll + 1);
        final float lllllllllllllIIIllIIIlllIIlllllI = (float)(lllllllllllllIIIllIIIlllIIlIllII - lllllllllllllIIIllIIIlllIlIIIllI + 1);
        final float lllllllllllllIIIllIIIlllIIllllIl = (float)(lllllllllllllIIIllIIIlllIIlIlIll - lllllllllllllIIIllIIIlllIlIIIlIl + 1);
        final float lllllllllllllIIIllIIIlllIIllllII = lllllllllllllIIIllIIIlllIlIIIlll + lllllllllllllIIIllIIIlllIIllllll / 2.0f;
        final float lllllllllllllIIIllIIIlllIIlllIll = lllllllllllllIIIllIIIlllIlIIIlIl + lllllllllllllIIIllIIIlllIIllllIl / 2.0f;
        for (int lllllllllllllIIIllIIIlllIIlllIlI = lllllllllllllIIIllIIIlllIlIIIllI; lllllllllllllIIIllIIIlllIIlllIlI <= lllllllllllllIIIllIIIlllIIlIllII; ++lllllllllllllIIIllIIIlllIIlllIlI) {
            final float lllllllllllllIIIllIIIlllIIlllIIl = (lllllllllllllIIIllIIIlllIIlllIlI - lllllllllllllIIIllIIIlllIlIIIllI) / lllllllllllllIIIllIIIlllIIlllllI;
            for (int lllllllllllllIIIllIIIlllIIlllIII = lllllllllllllIIIllIIIlllIlIIIlll; lllllllllllllIIIllIIIlllIIlllIII <= lllllllllllllIIIllIIIlllIlIIIlII; ++lllllllllllllIIIllIIIlllIIlllIII) {
                final float lllllllllllllIIIllIIIlllIIllIlll = (lllllllllllllIIIllIIIlllIIlllIII - lllllllllllllIIIllIIIlllIIllllII) / (lllllllllllllIIIllIIIlllIIllllll * 0.5f);
                for (int lllllllllllllIIIllIIIlllIIllIllI = lllllllllllllIIIllIIIlllIlIIIlIl; lllllllllllllIIIllIIIlllIIllIllI <= lllllllllllllIIIllIIIlllIIlIlIll; ++lllllllllllllIIIllIIIlllIIllIllI) {
                    final float lllllllllllllIIIllIIIlllIIllIlIl = (lllllllllllllIIIllIIIlllIIllIllI - lllllllllllllIIIllIIIlllIIlllIll) / (lllllllllllllIIIllIIIlllIIllllIl * 0.5f);
                    if (!lllllllllllllIIIllIIIlllIlIIIIII || this.getBlockStateFromPos(lllllllllllllIIIllIIIlllIIllIIlI, lllllllllllllIIIllIIIlllIIlllIII, lllllllllllllIIIllIIIlllIIlllIlI, lllllllllllllIIIllIIIlllIIllIllI, lllllllllllllIIIllIIIlllIIllIIIl).getMaterial() != Material.AIR) {
                        final float lllllllllllllIIIllIIIlllIIllIlII = lllllllllllllIIIllIIIlllIIllIlll * lllllllllllllIIIllIIIlllIIllIlll + lllllllllllllIIIllIIIlllIIlllIIl * lllllllllllllIIIllIIIlllIIlllIIl + lllllllllllllIIIllIIIlllIIllIlIl * lllllllllllllIIIllIIIlllIIllIlIl;
                        if (lllllllllllllIIIllIIIlllIIllIlII <= 1.05f) {
                            this.setBlockState(lllllllllllllIIIllIIIlllIIllIIlI, lllllllllllllIIIllIIIlllIlIIIIIl, lllllllllllllIIIllIIIlllIIlllIII, lllllllllllllIIIllIIIlllIIlllIlI, lllllllllllllIIIllIIIlllIIllIllI, lllllllllllllIIIllIIIlllIIllIIIl);
                        }
                    }
                }
            }
        }
    }
    
    public final NBTTagCompound createStructureBaseNBT() {
        final NBTTagCompound lllllllllllllIIIllIIlIIIllllIIII = new NBTTagCompound();
        lllllllllllllIIIllIIlIIIllllIIII.setString("id", MapGenStructureIO.getStructureComponentName(this));
        lllllllllllllIIIllIIlIIIllllIIII.setTag("BB", this.boundingBox.toNBTTagIntArray());
        final EnumFacing lllllllllllllIIIllIIlIIIlllIllll = this.getCoordBaseMode();
        lllllllllllllIIIllIIlIIIllllIIII.setInteger("O", (lllllllllllllIIIllIIlIIIlllIllll == null) ? -1 : lllllllllllllIIIllIIlIIIlllIllll.getHorizontalIndex());
        lllllllllllllIIIllIIlIIIllllIIII.setInteger("GD", this.componentType);
        this.writeStructureToNBT(lllllllllllllIIIllIIlIIIllllIIII);
        return lllllllllllllIIIllIIlIIIllllIIII;
    }
    
    protected void randomlyPlaceBlock(final World lllllllllllllIIIllIIIlllIlllIIlI, final StructureBoundingBox lllllllllllllIIIllIIIlllIlllIIIl, final Random lllllllllllllIIIllIIIlllIllIIlll, final float lllllllllllllIIIllIIIlllIllIIllI, final int lllllllllllllIIIllIIIlllIllIIlIl, final int lllllllllllllIIIllIIIlllIllIIlII, final int lllllllllllllIIIllIIIlllIllIIIll, final IBlockState lllllllllllllIIIllIIIlllIllIlIll) {
        if (lllllllllllllIIIllIIIlllIllIIlll.nextFloat() < lllllllllllllIIIllIIIlllIllIIllI) {
            this.setBlockState(lllllllllllllIIIllIIIlllIlllIIlI, lllllllllllllIIIllIIIlllIllIlIll, lllllllllllllIIIllIIIlllIllIIlIl, lllllllllllllIIIllIIIlllIllIIlII, lllllllllllllIIIllIIIlllIllIIIll, lllllllllllllIIIllIIIlllIlllIIIl);
        }
    }
    
    protected boolean createDispenser(final World lllllllllllllIIIllIIIllIlIlIIIIl, final StructureBoundingBox lllllllllllllIIIllIIIllIlIlIlIll, final Random lllllllllllllIIIllIIIllIlIIlllll, final int lllllllllllllIIIllIIIllIlIlIlIIl, final int lllllllllllllIIIllIIIllIlIlIlIII, final int lllllllllllllIIIllIIIllIlIIlllII, final EnumFacing lllllllllllllIIIllIIIllIlIlIIllI, final ResourceLocation lllllllllllllIIIllIIIllIlIIllIlI) {
        final BlockPos lllllllllllllIIIllIIIllIlIlIIlII = new BlockPos(this.getXWithOffset(lllllllllllllIIIllIIIllIlIlIlIIl, lllllllllllllIIIllIIIllIlIIlllII), this.getYWithOffset(lllllllllllllIIIllIIIllIlIlIlIII), this.getZWithOffset(lllllllllllllIIIllIIIllIlIlIlIIl, lllllllllllllIIIllIIIllIlIIlllII));
        if (lllllllllllllIIIllIIIllIlIlIlIll.isVecInside(lllllllllllllIIIllIIIllIlIlIIlII) && lllllllllllllIIIllIIIllIlIlIIIIl.getBlockState(lllllllllllllIIIllIIIllIlIlIIlII).getBlock() != Blocks.DISPENSER) {
            this.setBlockState(lllllllllllllIIIllIIIllIlIlIIIIl, Blocks.DISPENSER.getDefaultState().withProperty((IProperty<Comparable>)BlockDispenser.FACING, lllllllllllllIIIllIIIllIlIlIIllI), lllllllllllllIIIllIIIllIlIlIlIIl, lllllllllllllIIIllIIIllIlIlIlIII, lllllllllllllIIIllIIIllIlIIlllII, lllllllllllllIIIllIIIllIlIlIlIll);
            final TileEntity lllllllllllllIIIllIIIllIlIlIIIll = lllllllllllllIIIllIIIllIlIlIIIIl.getTileEntity(lllllllllllllIIIllIIIllIlIlIIlII);
            if (lllllllllllllIIIllIIIllIlIlIIIll instanceof TileEntityDispenser) {
                ((TileEntityDispenser)lllllllllllllIIIllIIIllIlIlIIIll).setLootTable(lllllllllllllIIIllIIIllIlIIllIlI, lllllllllllllIIIllIIIllIlIIlllll.nextLong());
            }
            return true;
        }
        return false;
    }
    
    protected boolean func_191080_a(final World lllllllllllllIIIllIIIllIlIllllll, final StructureBoundingBox lllllllllllllIIIllIIIllIllIIIlIl, final Random lllllllllllllIIIllIIIllIllIIIlII, final BlockPos lllllllllllllIIIllIIIllIlIllllII, final ResourceLocation lllllllllllllIIIllIIIllIlIlllIll, @Nullable IBlockState lllllllllllllIIIllIIIllIlIlllIlI) {
        if (lllllllllllllIIIllIIIllIllIIIlIl.isVecInside(lllllllllllllIIIllIIIllIlIllllII) && lllllllllllllIIIllIIIllIlIllllll.getBlockState(lllllllllllllIIIllIIIllIlIllllII).getBlock() != Blocks.CHEST) {
            if (lllllllllllllIIIllIIIllIlIlllIlI == null) {
                lllllllllllllIIIllIIIllIlIlllIlI = Blocks.CHEST.correctFacing(lllllllllllllIIIllIIIllIlIllllll, lllllllllllllIIIllIIIllIlIllllII, Blocks.CHEST.getDefaultState());
            }
            lllllllllllllIIIllIIIllIlIllllll.setBlockState(lllllllllllllIIIllIIIllIlIllllII, (IBlockState)lllllllllllllIIIllIIIllIlIlllIlI, 2);
            final TileEntity lllllllllllllIIIllIIIllIllIIIIII = lllllllllllllIIIllIIIllIlIllllll.getTileEntity(lllllllllllllIIIllIIIllIlIllllII);
            if (lllllllllllllIIIllIIIllIllIIIIII instanceof TileEntityChest) {
                ((TileEntityChest)lllllllllllllIIIllIIIllIllIIIIII).setLootTable(lllllllllllllIIIllIIIllIlIlllIll, lllllllllllllIIIllIIIllIllIIIlII.nextLong());
            }
            return true;
        }
        return false;
    }
    
    protected boolean generateChest(final World lllllllllllllIIIllIIIllIllIlIllI, final StructureBoundingBox lllllllllllllIIIllIIIllIllIlIlIl, final Random lllllllllllllIIIllIIIllIllIlIlII, final int lllllllllllllIIIllIIIllIllIlllII, final int lllllllllllllIIIllIIIllIllIllIll, final int lllllllllllllIIIllIIIllIllIllIlI, final ResourceLocation lllllllllllllIIIllIIIllIllIllIIl) {
        final BlockPos lllllllllllllIIIllIIIllIllIllIII = new BlockPos(this.getXWithOffset(lllllllllllllIIIllIIIllIllIlllII, lllllllllllllIIIllIIIllIllIllIlI), this.getYWithOffset(lllllllllllllIIIllIIIllIllIllIll), this.getZWithOffset(lllllllllllllIIIllIIIllIllIlllII, lllllllllllllIIIllIIIllIllIllIlI));
        return this.func_191080_a(lllllllllllllIIIllIIIllIllIlIllI, lllllllllllllIIIllIIIllIllIlIlIl, lllllllllllllIIIllIIIllIllIlIlII, lllllllllllllIIIllIIIllIllIllIII, lllllllllllllIIIllIIIllIllIllIIl, null);
    }
    
    protected void func_189914_a(final World lllllllllllllIIIllIIIllllIIIllIl, final StructureBoundingBox lllllllllllllIIIllIIIllllIIllllI, final Random lllllllllllllIIIllIIIllllIIlllIl, final float lllllllllllllIIIllIIIllllIIlllII, final int lllllllllllllIIIllIIIllllIIIlIIl, final int lllllllllllllIIIllIIIllllIIIlIII, final int lllllllllllllIIIllIIIllllIIllIIl, final int lllllllllllllIIIllIIIllllIIIIllI, final int lllllllllllllIIIllIIIllllIIIIlIl, final int lllllllllllllIIIllIIIllllIIIIlII, final IBlockState lllllllllllllIIIllIIIllllIIIIIll, final IBlockState lllllllllllllIIIllIIIllllIIIIIlI, final boolean lllllllllllllIIIllIIIllllIIlIIll, final int lllllllllllllIIIllIIIllllIIIIIII) {
        for (int lllllllllllllIIIllIIIllllIIlIIIl = lllllllllllllIIIllIIIllllIIIlIII; lllllllllllllIIIllIIIllllIIlIIIl <= lllllllllllllIIIllIIIllllIIIIlIl; ++lllllllllllllIIIllIIIllllIIlIIIl) {
            for (int lllllllllllllIIIllIIIllllIIlIIII = lllllllllllllIIIllIIIllllIIIlIIl; lllllllllllllIIIllIIIllllIIlIIII <= lllllllllllllIIIllIIIllllIIIIllI; ++lllllllllllllIIIllIIIllllIIlIIII) {
                for (int lllllllllllllIIIllIIIllllIIIllll = lllllllllllllIIIllIIIllllIIllIIl; lllllllllllllIIIllIIIllllIIIllll <= lllllllllllllIIIllIIIllllIIIIlII; ++lllllllllllllIIIllIIIllllIIIllll) {
                    if (lllllllllllllIIIllIIIllllIIlllIl.nextFloat() <= lllllllllllllIIIllIIIllllIIlllII && (!lllllllllllllIIIllIIIllllIIlIIll || this.getBlockStateFromPos(lllllllllllllIIIllIIIllllIIIllIl, lllllllllllllIIIllIIIllllIIlIIII, lllllllllllllIIIllIIIllllIIlIIIl, lllllllllllllIIIllIIIllllIIIllll, lllllllllllllIIIllIIIllllIIllllI).getMaterial() != Material.AIR) && (lllllllllllllIIIllIIIllllIIIIIII <= 0 || this.func_189916_b(lllllllllllllIIIllIIIllllIIIllIl, lllllllllllllIIIllIIIllllIIlIIII, lllllllllllllIIIllIIIllllIIlIIIl, lllllllllllllIIIllIIIllllIIIllll, lllllllllllllIIIllIIIllllIIllllI) < lllllllllllllIIIllIIIllllIIIIIII)) {
                        if (lllllllllllllIIIllIIIllllIIlIIIl != lllllllllllllIIIllIIIllllIIIlIII && lllllllllllllIIIllIIIllllIIlIIIl != lllllllllllllIIIllIIIllllIIIIlIl && lllllllllllllIIIllIIIllllIIlIIII != lllllllllllllIIIllIIIllllIIIlIIl && lllllllllllllIIIllIIIllllIIlIIII != lllllllllllllIIIllIIIllllIIIIllI && lllllllllllllIIIllIIIllllIIIllll != lllllllllllllIIIllIIIllllIIllIIl && lllllllllllllIIIllIIIllllIIIllll != lllllllllllllIIIllIIIllllIIIIlII) {
                            this.setBlockState(lllllllllllllIIIllIIIllllIIIllIl, lllllllllllllIIIllIIIllllIIIIIlI, lllllllllllllIIIllIIIllllIIlIIII, lllllllllllllIIIllIIIllllIIlIIIl, lllllllllllllIIIllIIIllllIIIllll, lllllllllllllIIIllIIIllllIIllllI);
                        }
                        else {
                            this.setBlockState(lllllllllllllIIIllIIIllllIIIllIl, lllllllllllllIIIllIIIllllIIIIIll, lllllllllllllIIIllIIIllllIIlIIII, lllllllllllllIIIllIIIllllIIlIIIl, lllllllllllllIIIllIIIllllIIIllll, lllllllllllllIIIllIIIllllIIllllI);
                        }
                    }
                }
            }
        }
    }
    
    protected int func_189916_b(final World lllllllllllllIIIllIIlIIIIIlllIIl, final int lllllllllllllIIIllIIlIIIIlIIIIlI, final int lllllllllllllIIIllIIlIIIIlIIIIIl, final int lllllllllllllIIIllIIlIIIIlIIIIII, final StructureBoundingBox lllllllllllllIIIllIIlIIIIIllIlIl) {
        final int lllllllllllllIIIllIIlIIIIIlllllI = this.getXWithOffset(lllllllllllllIIIllIIlIIIIlIIIIlI, lllllllllllllIIIllIIlIIIIlIIIIII);
        final int lllllllllllllIIIllIIlIIIIIllllIl = this.getYWithOffset(lllllllllllllIIIllIIlIIIIlIIIIIl + 1);
        final int lllllllllllllIIIllIIlIIIIIllllII = this.getZWithOffset(lllllllllllllIIIllIIlIIIIlIIIIlI, lllllllllllllIIIllIIlIIIIlIIIIII);
        final BlockPos lllllllllllllIIIllIIlIIIIIlllIll = new BlockPos(lllllllllllllIIIllIIlIIIIIlllllI, lllllllllllllIIIllIIlIIIIIllllIl, lllllllllllllIIIllIIlIIIIIllllII);
        return lllllllllllllIIIllIIlIIIIIllIlIl.isVecInside(lllllllllllllIIIllIIlIIIIIlllIll) ? lllllllllllllIIIllIIlIIIIIlllIIl.getLightFor(EnumSkyBlock.SKY, lllllllllllllIIIllIIlIIIIIlllIll) : EnumSkyBlock.SKY.defaultLightValue;
    }
    
    public StructureBoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    public void readStructureBaseNBT(final World lllllllllllllIIIllIIlIIIlllIIllI, final NBTTagCompound lllllllllllllIIIllIIlIIIlllIIIIl) {
        if (lllllllllllllIIIllIIlIIIlllIIIIl.hasKey("BB")) {
            this.boundingBox = new StructureBoundingBox(lllllllllllllIIIllIIlIIIlllIIIIl.getIntArray("BB"));
        }
        final int lllllllllllllIIIllIIlIIIlllIIlII = lllllllllllllIIIllIIlIIIlllIIIIl.getInteger("O");
        this.setCoordBaseMode((lllllllllllllIIIllIIlIIIlllIIlII == -1) ? null : EnumFacing.getHorizontal(lllllllllllllIIIllIIlIIIlllIIlII));
        this.componentType = lllllllllllllIIIllIIlIIIlllIIIIl.getInteger("GD");
        this.readStructureFromNBT(lllllllllllllIIIllIIlIIIlllIIIIl, lllllllllllllIIIllIIlIIIlllIIllI.getSaveHandler().getStructureTemplateManager());
    }
    
    protected void clearCurrentPositionBlocksUpwards(final World lllllllllllllIIIllIIIlllIIIIllIl, final int lllllllllllllIIIllIIIlllIIIIllII, final int lllllllllllllIIIllIIIlllIIIlIIlI, final int lllllllllllllIIIllIIIlllIIIlIIIl, final StructureBoundingBox lllllllllllllIIIllIIIlllIIIIlIIl) {
        BlockPos lllllllllllllIIIllIIIlllIIIIllll = new BlockPos(this.getXWithOffset(lllllllllllllIIIllIIIlllIIIIllII, lllllllllllllIIIllIIIlllIIIlIIIl), this.getYWithOffset(lllllllllllllIIIllIIIlllIIIlIIlI), this.getZWithOffset(lllllllllllllIIIllIIIlllIIIIllII, lllllllllllllIIIllIIIlllIIIlIIIl));
        if (lllllllllllllIIIllIIIlllIIIIlIIl.isVecInside(lllllllllllllIIIllIIIlllIIIIllll)) {
            while (!lllllllllllllIIIllIIIlllIIIIllIl.isAirBlock(lllllllllllllIIIllIIIlllIIIIllll) && lllllllllllllIIIllIIIlllIIIIllll.getY() < 255) {
                lllllllllllllIIIllIIIlllIIIIllIl.setBlockState(lllllllllllllIIIllIIIlllIIIIllll, Blocks.AIR.getDefaultState(), 2);
                lllllllllllllIIIllIIIlllIIIIllll = lllllllllllllIIIllIIIlllIIIIllll.up();
            }
        }
    }
    
    public void buildComponent(final StructureComponent lllllllllllllIIIllIIlIIIllIllllI, final List<StructureComponent> lllllllllllllIIIllIIlIIIllIlllIl, final Random lllllllllllllIIIllIIlIIIllIlllII) {
    }
    
    public static StructureComponent findIntersecting(final List<StructureComponent> lllllllllllllIIIllIIlIIIllIIlllI, final StructureBoundingBox lllllllllllllIIIllIIlIIIllIIllIl) {
        for (final StructureComponent lllllllllllllIIIllIIlIIIllIIllll : lllllllllllllIIIllIIlIIIllIIlllI) {
            if (lllllllllllllIIIllIIlIIIllIIllll.getBoundingBox() != null && lllllllllllllIIIllIIlIIIllIIllll.getBoundingBox().intersectsWith(lllllllllllllIIIllIIlIIIllIIllIl)) {
                return lllllllllllllIIIllIIlIIIllIIllll;
            }
        }
        return null;
    }
    
    protected abstract void readStructureFromNBT(final NBTTagCompound p0, final TemplateManager p1);
    
    protected void replaceAirAndLiquidDownwards(final World lllllllllllllIIIllIIIllIllllllII, final IBlockState lllllllllllllIIIllIIIllIllllIIIl, final int lllllllllllllIIIllIIIllIllllIIII, final int lllllllllllllIIIllIIIllIlllIllll, final int lllllllllllllIIIllIIIllIlllIlllI, final StructureBoundingBox lllllllllllllIIIllIIIllIlllIllIl) {
        final int lllllllllllllIIIllIIIllIllllIllI = this.getXWithOffset(lllllllllllllIIIllIIIllIllllIIII, lllllllllllllIIIllIIIllIlllIlllI);
        int lllllllllllllIIIllIIIllIllllIlIl = this.getYWithOffset(lllllllllllllIIIllIIIllIlllIllll);
        final int lllllllllllllIIIllIIIllIllllIlII = this.getZWithOffset(lllllllllllllIIIllIIIllIllllIIII, lllllllllllllIIIllIIIllIlllIlllI);
        if (lllllllllllllIIIllIIIllIlllIllIl.isVecInside(new BlockPos(lllllllllllllIIIllIIIllIllllIllI, lllllllllllllIIIllIIIllIllllIlIl, lllllllllllllIIIllIIIllIllllIlII))) {
            while ((lllllllllllllIIIllIIIllIllllllII.isAirBlock(new BlockPos(lllllllllllllIIIllIIIllIllllIllI, lllllllllllllIIIllIIIllIllllIlIl, lllllllllllllIIIllIIIllIllllIlII)) || lllllllllllllIIIllIIIllIllllllII.getBlockState(new BlockPos(lllllllllllllIIIllIIIllIllllIllI, lllllllllllllIIIllIIIllIllllIlIl, lllllllllllllIIIllIIIllIllllIlII)).getMaterial().isLiquid()) && lllllllllllllIIIllIIIllIllllIlIl > 1) {
                lllllllllllllIIIllIIIllIllllllII.setBlockState(new BlockPos(lllllllllllllIIIllIIIllIllllIllI, lllllllllllllIIIllIIIllIllllIlIl, lllllllllllllIIIllIIIllIllllIlII), lllllllllllllIIIllIIIllIllllIIIl, 2);
                --lllllllllllllIIIllIIIllIllllIlIl;
            }
        }
    }
    
    public abstract boolean addComponentParts(final World p0, final Random p1, final StructureBoundingBox p2);
    
    public int getComponentType() {
        return this.componentType;
    }
    
    protected int getZWithOffset(final int lllllllllllllIIIllIIlIIIlIIIIlll, final int lllllllllllllIIIllIIlIIIlIIIIllI) {
        final EnumFacing lllllllllllllIIIllIIlIIIlIIIlIIl = this.getCoordBaseMode();
        if (lllllllllllllIIIllIIlIIIlIIIlIIl == null) {
            return lllllllllllllIIIllIIlIIIlIIIIllI;
        }
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIIllIIlIIIlIIIlIIl.ordinal()]) {
            case 3: {
                return this.boundingBox.maxZ - lllllllllllllIIIllIIlIIIlIIIIllI;
            }
            case 4: {
                return this.boundingBox.minZ + lllllllllllllIIIllIIlIIIlIIIIllI;
            }
            case 5:
            case 6: {
                return this.boundingBox.minZ + lllllllllllllIIIllIIlIIIlIIIIlll;
            }
            default: {
                return lllllllllllllIIIllIIlIIIlIIIIllI;
            }
        }
    }
    
    protected void setBlockState(final World lllllllllllllIIIllIIlIIIIlllIIll, IBlockState lllllllllllllIIIllIIlIIIIlllIIlI, final int lllllllllllllIIIllIIlIIIIllllIIl, final int lllllllllllllIIIllIIlIIIIlllIIII, final int lllllllllllllIIIllIIlIIIIllIllll, final StructureBoundingBox lllllllllllllIIIllIIlIIIIllIlllI) {
        final BlockPos lllllllllllllIIIllIIlIIIIlllIlIl = new BlockPos(this.getXWithOffset(lllllllllllllIIIllIIlIIIIllllIIl, lllllllllllllIIIllIIlIIIIllIllll), this.getYWithOffset(lllllllllllllIIIllIIlIIIIlllIIII), this.getZWithOffset(lllllllllllllIIIllIIlIIIIllllIIl, lllllllllllllIIIllIIlIIIIllIllll));
        if (lllllllllllllIIIllIIlIIIIllIlllI.isVecInside(lllllllllllllIIIllIIlIIIIlllIlIl)) {
            if (this.mirror != Mirror.NONE) {
                lllllllllllllIIIllIIlIIIIlllIIlI = ((IBlockProperties)lllllllllllllIIIllIIlIIIIlllIIlI).withMirror(this.mirror);
            }
            if (this.rotation != Rotation.NONE) {
                lllllllllllllIIIllIIlIIIIlllIIlI = ((IBlockProperties)lllllllllllllIIIllIIlIIIIlllIIlI).withRotation(this.rotation);
            }
            lllllllllllllIIIllIIlIIIIlllIIll.setBlockState(lllllllllllllIIIllIIlIIIIlllIlIl, (IBlockState)lllllllllllllIIIllIIlIIIIlllIIlI, 2);
        }
    }
    
    protected abstract void writeStructureToNBT(final NBTTagCompound p0);
    
    protected int getYWithOffset(final int lllllllllllllIIIllIIlIIIlIIlIIll) {
        return (this.getCoordBaseMode() == null) ? lllllllllllllIIIllIIlIIIlIIlIIll : (lllllllllllllIIIllIIlIIIlIIlIIll + this.boundingBox.minY);
    }
    
    public void offset(final int lllllllllllllIIIllIIIllIIlllIlIl, final int lllllllllllllIIIllIIIllIIllllIII, final int lllllllllllllIIIllIIIllIIlllIIll) {
        this.boundingBox.offset(lllllllllllllIIIllIIIllIIlllIlIl, lllllllllllllIIIllIIIllIIllllIII, lllllllllllllIIIllIIIllIIlllIIll);
    }
    
    @Nullable
    public EnumFacing getCoordBaseMode() {
        return this.coordBaseMode;
    }
    
    protected void fillWithBlocks(final World lllllllllllllIIIllIIIllllllIllIl, final StructureBoundingBox lllllllllllllIIIllIIIllllllIllII, final int lllllllllllllIIIllIIIllllllIlIll, final int lllllllllllllIIIllIIIllllllIlIlI, final int lllllllllllllIIIllIIIllllllIlIIl, final int lllllllllllllIIIllIIIllllllIlIII, final int lllllllllllllIIIllIIIllllllIIlll, final int lllllllllllllIIIllIIIlllllllIlIl, final IBlockState lllllllllllllIIIllIIIlllllllIlII, final IBlockState lllllllllllllIIIllIIIllllllIIlII, final boolean lllllllllllllIIIllIIIllllllIIIll) {
        for (int lllllllllllllIIIllIIIlllllllIIIl = lllllllllllllIIIllIIIllllllIlIlI; lllllllllllllIIIllIIIlllllllIIIl <= lllllllllllllIIIllIIIllllllIIlll; ++lllllllllllllIIIllIIIlllllllIIIl) {
            for (int lllllllllllllIIIllIIIlllllllIIII = lllllllllllllIIIllIIIllllllIlIll; lllllllllllllIIIllIIIlllllllIIII <= lllllllllllllIIIllIIIllllllIlIII; ++lllllllllllllIIIllIIIlllllllIIII) {
                for (int lllllllllllllIIIllIIIllllllIllll = lllllllllllllIIIllIIIllllllIlIIl; lllllllllllllIIIllIIIllllllIllll <= lllllllllllllIIIllIIIlllllllIlIl; ++lllllllllllllIIIllIIIllllllIllll) {
                    if (!lllllllllllllIIIllIIIllllllIIIll || this.getBlockStateFromPos(lllllllllllllIIIllIIIllllllIllIl, lllllllllllllIIIllIIIlllllllIIII, lllllllllllllIIIllIIIlllllllIIIl, lllllllllllllIIIllIIIllllllIllll, lllllllllllllIIIllIIIllllllIllII).getMaterial() != Material.AIR) {
                        if (lllllllllllllIIIllIIIlllllllIIIl != lllllllllllllIIIllIIIllllllIlIlI && lllllllllllllIIIllIIIlllllllIIIl != lllllllllllllIIIllIIIllllllIIlll && lllllllllllllIIIllIIIlllllllIIII != lllllllllllllIIIllIIIllllllIlIll && lllllllllllllIIIllIIIlllllllIIII != lllllllllllllIIIllIIIllllllIlIII && lllllllllllllIIIllIIIllllllIllll != lllllllllllllIIIllIIIllllllIlIIl && lllllllllllllIIIllIIIllllllIllll != lllllllllllllIIIllIIIlllllllIlIl) {
                            this.setBlockState(lllllllllllllIIIllIIIllllllIllIl, lllllllllllllIIIllIIIllllllIIlII, lllllllllllllIIIllIIIlllllllIIII, lllllllllllllIIIllIIIlllllllIIIl, lllllllllllllIIIllIIIllllllIllll, lllllllllllllIIIllIIIllllllIllII);
                        }
                        else {
                            this.setBlockState(lllllllllllllIIIllIIIllllllIllIl, lllllllllllllIIIllIIIlllllllIlII, lllllllllllllIIIllIIIlllllllIIII, lllllllllllllIIIllIIIlllllllIIIl, lllllllllllllIIIllIIIllllllIllll, lllllllllllllIIIllIIIllllllIllII);
                        }
                    }
                }
            }
        }
    }
    
    protected void func_189915_a(final World lllllllllllllIIIllIIIllIlIIIlllI, final StructureBoundingBox lllllllllllllIIIllIIIllIlIIIIlII, final Random lllllllllllllIIIllIIIllIlIIIllII, final int lllllllllllllIIIllIIIllIlIIIIIll, final int lllllllllllllIIIllIIIllIlIIIIIlI, final int lllllllllllllIIIllIIIllIlIIIlIIl, final EnumFacing lllllllllllllIIIllIIIllIlIIIlIII, final BlockDoor lllllllllllllIIIllIIIllIIlllllll) {
        this.setBlockState(lllllllllllllIIIllIIIllIlIIIlllI, lllllllllllllIIIllIIIllIIlllllll.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, lllllllllllllIIIllIIIllIlIIIlIII), lllllllllllllIIIllIIIllIlIIIIIll, lllllllllllllIIIllIIIllIlIIIIIlI, lllllllllllllIIIllIIIllIlIIIlIIl, lllllllllllllIIIllIIIllIlIIIIlII);
        this.setBlockState(lllllllllllllIIIllIIIllIlIIIlllI, lllllllllllllIIIllIIIllIIlllllll.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, lllllllllllllIIIllIIIllIlIIIlIII).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), lllllllllllllIIIllIIIllIlIIIIIll, lllllllllllllIIIllIIIllIlIIIIIlI + 1, lllllllllllllIIIllIIIllIlIIIlIIl, lllllllllllllIIIllIIIllIlIIIIlII);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = StructureComponent.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final int lllllllllllllIIIllIIIllIIllIlIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIIIllIIIllIIllIlIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIllIIIllIIllIlIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIllIIIllIIllIlIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIllIIIllIIllIlIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIllIIIllIIllIlIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIIllIIIllIIllIlIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return StructureComponent.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIIllIIIllIIllIlIII;
    }
    
    public abstract static class BlockSelector
    {
        protected /* synthetic */ IBlockState blockstate;
        
        public IBlockState getBlockState() {
            return this.blockstate;
        }
        
        public BlockSelector() {
            this.blockstate = Blocks.AIR.getDefaultState();
        }
        
        public abstract void selectBlocks(final Random p0, final int p1, final int p2, final int p3, final boolean p4);
    }
}
