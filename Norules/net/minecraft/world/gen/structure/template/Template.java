package net.minecraft.world.gen.structure.template;

import net.minecraft.world.*;
import net.minecraft.world.gen.structure.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import com.google.common.base.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.datafix.*;
import net.minecraft.init.*;
import net.minecraft.inventory.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;
import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.util.*;

public class Template
{
    private final /* synthetic */ List<BlockInfo> blocks;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private final /* synthetic */ List<EntityInfo> entities;
    private /* synthetic */ String author;
    private /* synthetic */ BlockPos size;
    
    private void addEntitiesToWorld(final World llllllllllllllIIllllIlIlIlIllIll, final BlockPos llllllllllllllIIllllIlIlIlIllIlI, final Mirror llllllllllllllIIllllIlIlIlIllIIl, final Rotation llllllllllllllIIllllIlIlIlIllIII, @Nullable final StructureBoundingBox llllllllllllllIIllllIlIlIlIIIlll) {
        for (final EntityInfo llllllllllllllIIllllIlIlIlIlIllI : this.entities) {
            final BlockPos llllllllllllllIIllllIlIlIlIlIlIl = transformedBlockPos(llllllllllllllIIllllIlIlIlIlIllI.blockPos, llllllllllllllIIllllIlIlIlIllIIl, llllllllllllllIIllllIlIlIlIllIII).add(llllllllllllllIIllllIlIlIlIllIlI);
            if (llllllllllllllIIllllIlIlIlIIIlll == null || llllllllllllllIIllllIlIlIlIIIlll.isVecInside(llllllllllllllIIllllIlIlIlIlIlIl)) {
                final NBTTagCompound llllllllllllllIIllllIlIlIlIlIlII = llllllllllllllIIllllIlIlIlIlIllI.entityData;
                final Vec3d llllllllllllllIIllllIlIlIlIlIIll = transformedVec3d(llllllllllllllIIllllIlIlIlIlIllI.pos, llllllllllllllIIllllIlIlIlIllIIl, llllllllllllllIIllllIlIlIlIllIII);
                final Vec3d llllllllllllllIIllllIlIlIlIlIIlI = llllllllllllllIIllllIlIlIlIlIIll.addVector(llllllllllllllIIllllIlIlIlIllIlI.getX(), llllllllllllllIIllllIlIlIlIllIlI.getY(), llllllllllllllIIllllIlIlIlIllIlI.getZ());
                final NBTTagList llllllllllllllIIllllIlIlIlIlIIIl = new NBTTagList();
                llllllllllllllIIllllIlIlIlIlIIIl.appendTag(new NBTTagDouble(llllllllllllllIIllllIlIlIlIlIIlI.xCoord));
                llllllllllllllIIllllIlIlIlIlIIIl.appendTag(new NBTTagDouble(llllllllllllllIIllllIlIlIlIlIIlI.yCoord));
                llllllllllllllIIllllIlIlIlIlIIIl.appendTag(new NBTTagDouble(llllllllllllllIIllllIlIlIlIlIIlI.zCoord));
                llllllllllllllIIllllIlIlIlIlIlII.setTag("Pos", llllllllllllllIIllllIlIlIlIlIIIl);
                llllllllllllllIIllllIlIlIlIlIlII.setUniqueId("UUID", UUID.randomUUID());
                Entity llllllllllllllIIllllIlIlIlIIllll = null;
                try {
                    final Entity llllllllllllllIIllllIlIlIlIlIIII = EntityList.createEntityFromNBT(llllllllllllllIIllllIlIlIlIlIlII, llllllllllllllIIllllIlIlIlIllIll);
                }
                catch (Exception llllllllllllllIIllllIlIlIlIIlllI) {
                    llllllllllllllIIllllIlIlIlIIllll = null;
                }
                if (llllllllllllllIIllllIlIlIlIIllll == null) {
                    continue;
                }
                float llllllllllllllIIllllIlIlIlIIllIl = llllllllllllllIIllllIlIlIlIIllll.getMirroredYaw(llllllllllllllIIllllIlIlIlIllIIl);
                llllllllllllllIIllllIlIlIlIIllIl += llllllllllllllIIllllIlIlIlIIllll.rotationYaw - llllllllllllllIIllllIlIlIlIIllll.getRotatedYaw(llllllllllllllIIllllIlIlIlIllIII);
                llllllllllllllIIllllIlIlIlIIllll.setLocationAndAngles(llllllllllllllIIllllIlIlIlIlIIlI.xCoord, llllllllllllllIIllllIlIlIlIlIIlI.yCoord, llllllllllllllIIllllIlIlIlIlIIlI.zCoord, llllllllllllllIIllllIlIlIlIIllIl, llllllllllllllIIllllIlIlIlIIllll.rotationPitch);
                llllllllllllllIIllllIlIlIlIllIll.spawnEntityInWorld(llllllllllllllIIllllIlIlIlIIllll);
            }
        }
    }
    
    public static BlockPos func_191157_a(final BlockPos llllllllllllllIIllllIlIIlllllIIl, final Mirror llllllllllllllIIllllIlIIlllllIII, final Rotation llllllllllllllIIllllIlIIllllIlll, int llllllllllllllIIllllIlIIlllIlllI, int llllllllllllllIIllllIlIIlllIllIl) {
        --llllllllllllllIIllllIlIIlllIlllI;
        --llllllllllllllIIllllIlIIlllIllIl;
        final int llllllllllllllIIllllIlIIllllIlII = (llllllllllllllIIllllIlIIlllllIII == Mirror.FRONT_BACK) ? llllllllllllllIIllllIlIIlllIlllI : 0;
        final int llllllllllllllIIllllIlIIllllIIll = (llllllllllllllIIllllIlIIlllllIII == Mirror.LEFT_RIGHT) ? llllllllllllllIIllllIlIIlllIllIl : 0;
        BlockPos llllllllllllllIIllllIlIIllllIIlI = llllllllllllllIIllllIlIIlllllIIl;
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllIIllllIlIIllllIlll.ordinal()]) {
            case 4: {
                llllllllllllllIIllllIlIIllllIIlI = llllllllllllllIIllllIlIIlllllIIl.add(llllllllllllllIIllllIlIIllllIIll, 0, llllllllllllllIIllllIlIIlllIlllI - llllllllllllllIIllllIlIIllllIlII);
                break;
            }
            case 2: {
                llllllllllllllIIllllIlIIllllIIlI = llllllllllllllIIllllIlIIlllllIIl.add(llllllllllllllIIllllIlIIlllIllIl - llllllllllllllIIllllIlIIllllIIll, 0, llllllllllllllIIllllIlIIllllIlII);
                break;
            }
            case 3: {
                llllllllllllllIIllllIlIIllllIIlI = llllllllllllllIIllllIlIIlllllIIl.add(llllllllllllllIIllllIlIIlllIlllI - llllllllllllllIIllllIlIIllllIlII, 0, llllllllllllllIIllllIlIIlllIllIl - llllllllllllllIIllllIlIIllllIIll);
                break;
            }
            case 1: {
                llllllllllllllIIllllIlIIllllIIlI = llllllllllllllIIllllIlIIlllllIIl.add(llllllllllllllIIllllIlIIllllIlII, 0, llllllllllllllIIllllIlIIllllIIll);
                break;
            }
        }
        return llllllllllllllIIllllIlIIllllIIlI;
    }
    
    private NBTTagList writeInts(final int... llllllllllllllIIllllIlIIlIIlIIlI) {
        final NBTTagList llllllllllllllIIllllIlIIlIIlIIIl = new NBTTagList();
        final double llllllllllllllIIllllIlIIlIIIlIlI = (Object)llllllllllllllIIllllIlIIlIIlIIlI;
        for (byte llllllllllllllIIllllIlIIlIIIlIll = (byte)llllllllllllllIIllllIlIIlIIlIIlI.length, llllllllllllllIIllllIlIIlIIIllII = 0; llllllllllllllIIllllIlIIlIIIllII < llllllllllllllIIllllIlIIlIIIlIll; ++llllllllllllllIIllllIlIIlIIIllII) {
            final int llllllllllllllIIllllIlIIlIIlIIII = llllllllllllllIIllllIlIIlIIIlIlI[llllllllllllllIIllllIlIIlIIIllII];
            llllllllllllllIIllllIlIIlIIlIIIl.appendTag(new NBTTagInt(llllllllllllllIIllllIlIIlIIlIIII));
        }
        return llllllllllllllIIllllIlIIlIIlIIIl;
    }
    
    private void takeEntitiesFromWorld(final World llllllllllllllIIllllIllIIIIIIlII, final BlockPos llllllllllllllIIllllIllIIIIIIIll, final BlockPos llllllllllllllIIllllIllIIIIIllII) {
        final List<Entity> llllllllllllllIIllllIllIIIIIlIll = llllllllllllllIIllllIllIIIIIIlII.getEntitiesWithinAABB((Class<? extends Entity>)Entity.class, new AxisAlignedBB(llllllllllllllIIllllIllIIIIIIIll, llllllllllllllIIllllIllIIIIIllII), (com.google.common.base.Predicate<? super Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIIlIIlIllIllllllIll) {
                return !(lllllllllllllIIlIIlIllIllllllIll instanceof EntityPlayer);
            }
        });
        this.entities.clear();
        for (final Entity llllllllllllllIIllllIllIIIIIlIlI : llllllllllllllIIllllIllIIIIIlIll) {
            final Vec3d llllllllllllllIIllllIllIIIIIlIIl = new Vec3d(llllllllllllllIIllllIllIIIIIlIlI.posX - llllllllllllllIIllllIllIIIIIIIll.getX(), llllllllllllllIIllllIllIIIIIlIlI.posY - llllllllllllllIIllllIllIIIIIIIll.getY(), llllllllllllllIIllllIllIIIIIlIlI.posZ - llllllllllllllIIllllIllIIIIIIIll.getZ());
            final NBTTagCompound llllllllllllllIIllllIllIIIIIlIII = new NBTTagCompound();
            llllllllllllllIIllllIllIIIIIlIlI.writeToNBTOptional(llllllllllllllIIllllIllIIIIIlIII);
            BlockPos llllllllllllllIIllllIllIIIIIIllI = null;
            if (llllllllllllllIIllllIllIIIIIlIlI instanceof EntityPainting) {
                final BlockPos llllllllllllllIIllllIllIIIIIIlll = ((EntityPainting)llllllllllllllIIllllIllIIIIIlIlI).getHangingPosition().subtract(llllllllllllllIIllllIllIIIIIIIll);
            }
            else {
                llllllllllllllIIllllIllIIIIIIllI = new BlockPos(llllllllllllllIIllllIllIIIIIlIIl);
            }
            this.entities.add(new EntityInfo(llllllllllllllIIllllIllIIIIIlIIl, llllllllllllllIIllllIllIIIIIIllI, llllllllllllllIIllllIllIIIIIlIII));
        }
    }
    
    public static void func_191158_a(final DataFixer llllllllllllllIIllllIlIIlllIIlll) {
        llllllllllllllIIllllIlIIlllIIlll.registerWalker(FixTypes.STRUCTURE, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer lllllllllllllllllIIIIIIIllIlIIll, final NBTTagCompound lllllllllllllllllIIIIIIIllIIlIIl, final int lllllllllllllllllIIIIIIIllIIlIII) {
                if (lllllllllllllllllIIIIIIIllIIlIIl.hasKey("entities", 9)) {
                    final NBTTagList lllllllllllllllllIIIIIIIllIlIIII = lllllllllllllllllIIIIIIIllIIlIIl.getTagList("entities", 10);
                    for (int lllllllllllllllllIIIIIIIllIIllll = 0; lllllllllllllllllIIIIIIIllIIllll < lllllllllllllllllIIIIIIIllIlIIII.tagCount(); ++lllllllllllllllllIIIIIIIllIIllll) {
                        final NBTTagCompound lllllllllllllllllIIIIIIIllIIlllI = (NBTTagCompound)lllllllllllllllllIIIIIIIllIlIIII.get(lllllllllllllllllIIIIIIIllIIllll);
                        if (lllllllllllllllllIIIIIIIllIIlllI.hasKey("nbt", 10)) {
                            lllllllllllllllllIIIIIIIllIIlllI.setTag("nbt", lllllllllllllllllIIIIIIIllIlIIll.process(FixTypes.ENTITY, lllllllllllllllllIIIIIIIllIIlllI.getCompoundTag("nbt"), lllllllllllllllllIIIIIIIllIIlIII));
                        }
                    }
                }
                if (lllllllllllllllllIIIIIIIllIIlIIl.hasKey("blocks", 9)) {
                    final NBTTagList lllllllllllllllllIIIIIIIllIIllIl = lllllllllllllllllIIIIIIIllIIlIIl.getTagList("blocks", 10);
                    for (int lllllllllllllllllIIIIIIIllIIllII = 0; lllllllllllllllllIIIIIIIllIIllII < lllllllllllllllllIIIIIIIllIIllIl.tagCount(); ++lllllllllllllllllIIIIIIIllIIllII) {
                        final NBTTagCompound lllllllllllllllllIIIIIIIllIIlIll = (NBTTagCompound)lllllllllllllllllIIIIIIIllIIllIl.get(lllllllllllllllllIIIIIIIllIIllII);
                        if (lllllllllllllllllIIIIIIIllIIlIll.hasKey("nbt", 10)) {
                            lllllllllllllllllIIIIIIIllIIlIll.setTag("nbt", lllllllllllllllllIIIIIIIllIlIIll.process(FixTypes.BLOCK_ENTITY, lllllllllllllllllIIIIIIIllIIlIll.getCompoundTag("nbt"), lllllllllllllllllIIIIIIIllIIlIII));
                        }
                    }
                }
                return lllllllllllllllllIIIIIIIllIIlIIl;
            }
        });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = Template.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final Exception llllllllllllllIIllllIlIIIllllIII = (Object)new int[Rotation.values().length];
        try {
            llllllllllllllIIllllIlIIIllllIII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIllllIlIIIllllIII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIllllIlIIIllllIII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIllllIlIIIllllIII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return Template.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllIIllllIlIIIllllIII;
    }
    
    public void addBlocksToWorld(final World llllllllllllllIIllllIlIlIllllIlI, final BlockPos llllllllllllllIIllllIlIllIIIllII, @Nullable final ITemplateProcessor llllllllllllllIIllllIlIlIllllIII, final PlacementSettings llllllllllllllIIllllIlIlIlllIlll, final int llllllllllllllIIllllIlIllIIIlIIl) {
        if ((!this.blocks.isEmpty() || (!llllllllllllllIIllllIlIlIlllIlll.getIgnoreEntities() && !this.entities.isEmpty())) && this.size.getX() >= 1 && this.size.getY() >= 1 && this.size.getZ() >= 1) {
            final Block llllllllllllllIIllllIlIllIIIlIII = llllllllllllllIIllllIlIlIlllIlll.getReplacedBlock();
            final StructureBoundingBox llllllllllllllIIllllIlIllIIIIlll = llllllllllllllIIllllIlIlIlllIlll.getBoundingBox();
            for (final BlockInfo llllllllllllllIIllllIlIllIIIIllI : this.blocks) {
                final BlockPos llllllllllllllIIllllIlIllIIIIlIl = transformedBlockPos(llllllllllllllIIllllIlIlIlllIlll, llllllllllllllIIllllIlIllIIIIllI.pos).add(llllllllllllllIIllllIlIllIIIllII);
                final BlockInfo llllllllllllllIIllllIlIllIIIIlII = (llllllllllllllIIllllIlIlIllllIII != null) ? llllllllllllllIIllllIlIlIllllIII.processBlock(llllllllllllllIIllllIlIlIllllIlI, llllllllllllllIIllllIlIllIIIIlIl, llllllllllllllIIllllIlIllIIIIllI) : llllllllllllllIIllllIlIllIIIIllI;
                if (llllllllllllllIIllllIlIllIIIIlII != null) {
                    final Block llllllllllllllIIllllIlIllIIIIIll = llllllllllllllIIllllIlIllIIIIlII.blockState.getBlock();
                    if ((llllllllllllllIIllllIlIllIIIlIII != null && llllllllllllllIIllllIlIllIIIlIII == llllllllllllllIIllllIlIllIIIIIll) || (llllllllllllllIIllllIlIlIlllIlll.getIgnoreStructureBlock() && llllllllllllllIIllllIlIllIIIIIll == Blocks.STRUCTURE_BLOCK) || (llllllllllllllIIllllIlIllIIIIlll != null && !llllllllllllllIIllllIlIllIIIIlll.isVecInside(llllllllllllllIIllllIlIllIIIIlIl))) {
                        continue;
                    }
                    final IBlockState llllllllllllllIIllllIlIllIIIIIlI = llllllllllllllIIllllIlIllIIIIlII.blockState.withMirror(llllllllllllllIIllllIlIlIlllIlll.getMirror());
                    final IBlockState llllllllllllllIIllllIlIllIIIIIIl = llllllllllllllIIllllIlIllIIIIIlI.withRotation(llllllllllllllIIllllIlIlIlllIlll.getRotation());
                    if (llllllllllllllIIllllIlIllIIIIlII.tileentityData != null) {
                        final TileEntity llllllllllllllIIllllIlIllIIIIIII = llllllllllllllIIllllIlIlIllllIlI.getTileEntity(llllllllllllllIIllllIlIllIIIIlIl);
                        if (llllllllllllllIIllllIlIllIIIIIII != null) {
                            if (llllllllllllllIIllllIlIllIIIIIII instanceof IInventory) {
                                ((IInventory)llllllllllllllIIllllIlIllIIIIIII).clear();
                            }
                            llllllllllllllIIllllIlIlIllllIlI.setBlockState(llllllllllllllIIllllIlIllIIIIlIl, Blocks.BARRIER.getDefaultState(), 4);
                        }
                    }
                    if (!llllllllllllllIIllllIlIlIllllIlI.setBlockState(llllllllllllllIIllllIlIllIIIIlIl, llllllllllllllIIllllIlIllIIIIIIl, llllllllllllllIIllllIlIllIIIlIIl) || llllllllllllllIIllllIlIllIIIIlII.tileentityData == null) {
                        continue;
                    }
                    final TileEntity llllllllllllllIIllllIlIlIlllllll = llllllllllllllIIllllIlIlIllllIlI.getTileEntity(llllllllllllllIIllllIlIllIIIIlIl);
                    if (llllllllllllllIIllllIlIlIlllllll == null) {
                        continue;
                    }
                    llllllllllllllIIllllIlIllIIIIlII.tileentityData.setInteger("x", llllllllllllllIIllllIlIllIIIIlIl.getX());
                    llllllllllllllIIllllIlIllIIIIlII.tileentityData.setInteger("y", llllllllllllllIIllllIlIllIIIIlIl.getY());
                    llllllllllllllIIllllIlIllIIIIlII.tileentityData.setInteger("z", llllllllllllllIIllllIlIllIIIIlIl.getZ());
                    llllllllllllllIIllllIlIlIlllllll.readFromNBT(llllllllllllllIIllllIlIllIIIIlII.tileentityData);
                    llllllllllllllIIllllIlIlIlllllll.mirror(llllllllllllllIIllllIlIlIlllIlll.getMirror());
                    llllllllllllllIIllllIlIlIlllllll.rotate(llllllllllllllIIllllIlIlIlllIlll.getRotation());
                }
            }
            for (final BlockInfo llllllllllllllIIllllIlIlIllllllI : this.blocks) {
                if (llllllllllllllIIllllIlIllIIIlIII == null || llllllllllllllIIllllIlIllIIIlIII != llllllllllllllIIllllIlIlIllllllI.blockState.getBlock()) {
                    final BlockPos llllllllllllllIIllllIlIlIlllllIl = transformedBlockPos(llllllllllllllIIllllIlIlIlllIlll, llllllllllllllIIllllIlIlIllllllI.pos).add(llllllllllllllIIllllIlIllIIIllII);
                    if (llllllllllllllIIllllIlIllIIIIlll != null && !llllllllllllllIIllllIlIllIIIIlll.isVecInside(llllllllllllllIIllllIlIlIlllllIl)) {
                        continue;
                    }
                    llllllllllllllIIllllIlIlIllllIlI.notifyNeighborsRespectDebug(llllllllllllllIIllllIlIlIlllllIl, llllllllllllllIIllllIlIlIllllllI.blockState.getBlock(), false);
                    if (llllllllllllllIIllllIlIlIllllllI.tileentityData == null) {
                        continue;
                    }
                    final TileEntity llllllllllllllIIllllIlIlIlllllII = llllllllllllllIIllllIlIlIllllIlI.getTileEntity(llllllllllllllIIllllIlIlIlllllIl);
                    if (llllllllllllllIIllllIlIlIlllllII == null) {
                        continue;
                    }
                    llllllllllllllIIllllIlIlIlllllII.markDirty();
                }
            }
            if (!llllllllllllllIIllllIlIlIlllIlll.getIgnoreEntities()) {
                this.addEntitiesToWorld(llllllllllllllIIllllIlIlIllllIlI, llllllllllllllIIllllIlIllIIIllII, llllllllllllllIIllllIlIlIlllIlll.getMirror(), llllllllllllllIIllllIlIlIlllIlll.getRotation(), llllllllllllllIIllllIlIllIIIIlll);
            }
        }
    }
    
    public Template() {
        this.blocks = (List<BlockInfo>)Lists.newArrayList();
        this.entities = (List<EntityInfo>)Lists.newArrayList();
        this.size = BlockPos.ORIGIN;
        this.author = "?";
    }
    
    public BlockPos getSize() {
        return this.size;
    }
    
    private NBTTagList writeDoubles(final double... llllllllllllllIIllllIlIIlIIIIIlI) {
        final NBTTagList llllllllllllllIIllllIlIIlIIIIIIl = new NBTTagList();
        final char llllllllllllllIIllllIlIIIllllIlI = (Object)llllllllllllllIIllllIlIIlIIIIIlI;
        final long llllllllllllllIIllllIlIIIllllIll = llllllllllllllIIllllIlIIlIIIIIlI.length;
        for (final double llllllllllllllIIllllIlIIlIIIIIII : llllllllllllllIIllllIlIIIllllIlI) {
            llllllllllllllIIllllIlIIlIIIIIIl.appendTag(new NBTTagDouble(llllllllllllllIIllllIlIIlIIIIIII));
        }
        return llllllllllllllIIllllIlIIlIIIIIIl;
    }
    
    public Map<BlockPos, String> getDataBlocks(final BlockPos llllllllllllllIIllllIlIlllllIIII, final PlacementSettings llllllllllllllIIllllIlIllllIIllI) {
        final Map<BlockPos, String> llllllllllllllIIllllIlIllllIlllI = (Map<BlockPos, String>)Maps.newHashMap();
        final StructureBoundingBox llllllllllllllIIllllIlIllllIllIl = llllllllllllllIIllllIlIllllIIllI.getBoundingBox();
        for (final BlockInfo llllllllllllllIIllllIlIllllIllII : this.blocks) {
            final BlockPos llllllllllllllIIllllIlIllllIlIll = transformedBlockPos(llllllllllllllIIllllIlIllllIIllI, llllllllllllllIIllllIlIllllIllII.pos).add(llllllllllllllIIllllIlIlllllIIII);
            if (llllllllllllllIIllllIlIllllIllIl == null || llllllllllllllIIllllIlIllllIllIl.isVecInside(llllllllllllllIIllllIlIllllIlIll)) {
                final IBlockState llllllllllllllIIllllIlIllllIlIlI = llllllllllllllIIllllIlIllllIllII.blockState;
                if (llllllllllllllIIllllIlIllllIlIlI.getBlock() != Blocks.STRUCTURE_BLOCK || llllllllllllllIIllllIlIllllIllII.tileentityData == null) {
                    continue;
                }
                final TileEntityStructure.Mode llllllllllllllIIllllIlIllllIlIIl = TileEntityStructure.Mode.valueOf(llllllllllllllIIllllIlIllllIllII.tileentityData.getString("mode"));
                if (llllllllllllllIIllllIlIllllIlIIl != TileEntityStructure.Mode.DATA) {
                    continue;
                }
                llllllllllllllIIllllIlIllllIlllI.put(llllllllllllllIIllllIlIllllIlIll, llllllllllllllIIllllIlIllllIllII.tileentityData.getString("metadata"));
            }
        }
        return llllllllllllllIIllllIlIllllIlllI;
    }
    
    public BlockPos calculateConnectedPos(final PlacementSettings llllllllllllllIIllllIlIlllIlIlll, final BlockPos llllllllllllllIIllllIlIlllIlIllI, final PlacementSettings llllllllllllllIIllllIlIlllIIllll, final BlockPos llllllllllllllIIllllIlIlllIIlllI) {
        final BlockPos llllllllllllllIIllllIlIlllIlIIll = transformedBlockPos(llllllllllllllIIllllIlIlllIlIlll, llllllllllllllIIllllIlIlllIlIllI);
        final BlockPos llllllllllllllIIllllIlIlllIlIIlI = transformedBlockPos(llllllllllllllIIllllIlIlllIIllll, llllllllllllllIIllllIlIlllIIlllI);
        return llllllllllllllIIllllIlIlllIlIIll.subtract(llllllllllllllIIllllIlIlllIlIIlI);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = Template.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final short llllllllllllllIIllllIlIIIlllIllI = (Object)new int[Mirror.values().length];
        try {
            llllllllllllllIIllllIlIIIlllIllI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIllllIlIIIlllIllI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIllllIlIIIlllIllI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return Template.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllllIIllllIlIIIlllIllI;
    }
    
    private static Vec3d transformedVec3d(final Vec3d llllllllllllllIIllllIlIlIIIllIll, final Mirror llllllllllllllIIllllIlIlIIIllIlI, final Rotation llllllllllllllIIllllIlIlIIIllIIl) {
        double llllllllllllllIIllllIlIlIIIllIII = llllllllllllllIIllllIlIlIIIllIll.xCoord;
        final double llllllllllllllIIllllIlIlIIIlIlll = llllllllllllllIIllllIlIlIIIllIll.yCoord;
        double llllllllllllllIIllllIlIlIIIlIllI = llllllllllllllIIllllIlIlIIIllIll.zCoord;
        boolean llllllllllllllIIllllIlIlIIIlIlIl = true;
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllllIIllllIlIlIIIllIlI.ordinal()]) {
            case 2: {
                llllllllllllllIIllllIlIlIIIlIllI = 1.0 - llllllllllllllIIllllIlIlIIIlIllI;
                break;
            }
            case 3: {
                llllllllllllllIIllllIlIlIIIllIII = 1.0 - llllllllllllllIIllllIlIlIIIllIII;
                break;
            }
            default: {
                llllllllllllllIIllllIlIlIIIlIlIl = false;
                break;
            }
        }
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllIIllllIlIlIIIllIIl.ordinal()]) {
            case 4: {
                return new Vec3d(llllllllllllllIIllllIlIlIIIlIllI, llllllllllllllIIllllIlIlIIIlIlll, 1.0 - llllllllllllllIIllllIlIlIIIllIII);
            }
            case 2: {
                return new Vec3d(1.0 - llllllllllllllIIllllIlIlIIIlIllI, llllllllllllllIIllllIlIlIIIlIlll, llllllllllllllIIllllIlIlIIIllIII);
            }
            case 3: {
                return new Vec3d(1.0 - llllllllllllllIIllllIlIlIIIllIII, llllllllllllllIIllllIlIlIIIlIlll, 1.0 - llllllllllllllIIllllIlIlIIIlIllI);
            }
            default: {
                return llllllllllllllIIllllIlIlIIIlIlIl ? new Vec3d(llllllllllllllIIllllIlIlIIIllIII, llllllllllllllIIllllIlIlIIIlIlll, llllllllllllllIIllllIlIlIIIlIllI) : llllllllllllllIIllllIlIlIIIllIll;
            }
        }
    }
    
    public void addBlocksToWorld(final World llllllllllllllIIllllIlIllIllIIII, final BlockPos llllllllllllllIIllllIlIllIlIllll, final PlacementSettings llllllllllllllIIllllIlIllIllIIlI) {
        this.addBlocksToWorld(llllllllllllllIIllllIlIllIllIIII, llllllllllllllIIllllIlIllIlIllll, new BlockRotationProcessor(llllllllllllllIIllllIlIllIlIllll, llllllllllllllIIllllIlIllIllIIlI), llllllllllllllIIllllIlIllIllIIlI, 2);
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllIIllllIlIIllIlIIlI) {
        final BasicPalette llllllllllllllIIllllIlIIllIlllII = new BasicPalette(null);
        final NBTTagList llllllllllllllIIllllIlIIllIllIll = new NBTTagList();
        for (final BlockInfo llllllllllllllIIllllIlIIllIllIlI : this.blocks) {
            final NBTTagCompound llllllllllllllIIllllIlIIllIllIIl = new NBTTagCompound();
            llllllllllllllIIllllIlIIllIllIIl.setTag("pos", this.writeInts(llllllllllllllIIllllIlIIllIllIlI.pos.getX(), llllllllllllllIIllllIlIIllIllIlI.pos.getY(), llllllllllllllIIllllIlIIllIllIlI.pos.getZ()));
            llllllllllllllIIllllIlIIllIllIIl.setInteger("state", llllllllllllllIIllllIlIIllIlllII.idFor(llllllllllllllIIllllIlIIllIllIlI.blockState));
            if (llllllllllllllIIllllIlIIllIllIlI.tileentityData != null) {
                llllllllllllllIIllllIlIIllIllIIl.setTag("nbt", llllllllllllllIIllllIlIIllIllIlI.tileentityData);
            }
            llllllllllllllIIllllIlIIllIllIll.appendTag(llllllllllllllIIllllIlIIllIllIIl);
        }
        final NBTTagList llllllllllllllIIllllIlIIllIllIII = new NBTTagList();
        for (final EntityInfo llllllllllllllIIllllIlIIllIlIlll : this.entities) {
            final NBTTagCompound llllllllllllllIIllllIlIIllIlIllI = new NBTTagCompound();
            llllllllllllllIIllllIlIIllIlIllI.setTag("pos", this.writeDoubles(llllllllllllllIIllllIlIIllIlIlll.pos.xCoord, llllllllllllllIIllllIlIIllIlIlll.pos.yCoord, llllllllllllllIIllllIlIIllIlIlll.pos.zCoord));
            llllllllllllllIIllllIlIIllIlIllI.setTag("blockPos", this.writeInts(llllllllllllllIIllllIlIIllIlIlll.blockPos.getX(), llllllllllllllIIllllIlIIllIlIlll.blockPos.getY(), llllllllllllllIIllllIlIIllIlIlll.blockPos.getZ()));
            if (llllllllllllllIIllllIlIIllIlIlll.entityData != null) {
                llllllllllllllIIllllIlIIllIlIllI.setTag("nbt", llllllllllllllIIllllIlIIllIlIlll.entityData);
            }
            llllllllllllllIIllllIlIIllIllIII.appendTag(llllllllllllllIIllllIlIIllIlIllI);
        }
        final NBTTagList llllllllllllllIIllllIlIIllIlIlIl = new NBTTagList();
        for (final IBlockState llllllllllllllIIllllIlIIllIlIlII : llllllllllllllIIllllIlIIllIlllII) {
            llllllllllllllIIllllIlIIllIlIlIl.appendTag(NBTUtil.writeBlockState(new NBTTagCompound(), llllllllllllllIIllllIlIIllIlIlII));
        }
        llllllllllllllIIllllIlIIllIlIIlI.setTag("palette", llllllllllllllIIllllIlIIllIlIlIl);
        llllllllllllllIIllllIlIIllIlIIlI.setTag("blocks", llllllllllllllIIllllIlIIllIllIll);
        llllllllllllllIIllllIlIIllIlIIlI.setTag("entities", llllllllllllllIIllllIlIIllIllIII);
        llllllllllllllIIllllIlIIllIlIIlI.setTag("size", this.writeInts(this.size.getX(), this.size.getY(), this.size.getZ()));
        llllllllllllllIIllllIlIIllIlIIlI.setString("author", this.author);
        llllllllllllllIIllllIlIIllIlIIlI.setInteger("DataVersion", 1343);
        return llllllllllllllIIllllIlIIllIlIIlI;
    }
    
    public void setAuthor(final String llllllllllllllIIllllIllIIlIlIIlI) {
        this.author = llllllllllllllIIllllIllIIlIlIIlI;
    }
    
    public void addBlocksToWorldChunk(final World llllllllllllllIIllllIlIllIllllII, final BlockPos llllllllllllllIIllllIlIllIlllIll, final PlacementSettings llllllllllllllIIllllIlIllIlllllI) {
        llllllllllllllIIllllIlIllIlllllI.setBoundingBoxFromChunk();
        this.addBlocksToWorld(llllllllllllllIIllllIlIllIllllII, llllllllllllllIIllllIlIllIlllIll, llllllllllllllIIllllIlIllIlllllI);
    }
    
    public void addBlocksToWorld(final World llllllllllllllIIllllIlIllIlIIIlI, final BlockPos llllllllllllllIIllllIlIllIlIIllI, final PlacementSettings llllllllllllllIIllllIlIllIlIIlIl, final int llllllllllllllIIllllIlIllIlIIlII) {
        this.addBlocksToWorld(llllllllllllllIIllllIlIllIlIIIlI, llllllllllllllIIllllIlIllIlIIllI, new BlockRotationProcessor(llllllllllllllIIllllIlIllIlIIllI, llllllllllllllIIllllIlIllIlIIlIl), llllllllllllllIIllllIlIllIlIIlIl, llllllllllllllIIllllIlIllIlIIlII);
    }
    
    private static BlockPos transformedBlockPos(final BlockPos llllllllllllllIIllllIlIlIIlIlIIl, final Mirror llllllllllllllIIllllIlIlIIlIllll, final Rotation llllllllllllllIIllllIlIlIIlIlllI) {
        int llllllllllllllIIllllIlIlIIlIllIl = llllllllllllllIIllllIlIlIIlIlIIl.getX();
        final int llllllllllllllIIllllIlIlIIlIllII = llllllllllllllIIllllIlIlIIlIlIIl.getY();
        int llllllllllllllIIllllIlIlIIlIlIll = llllllllllllllIIllllIlIlIIlIlIIl.getZ();
        boolean llllllllllllllIIllllIlIlIIlIlIlI = true;
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllllIIllllIlIlIIlIllll.ordinal()]) {
            case 2: {
                llllllllllllllIIllllIlIlIIlIlIll = -llllllllllllllIIllllIlIlIIlIlIll;
                break;
            }
            case 3: {
                llllllllllllllIIllllIlIlIIlIllIl = -llllllllllllllIIllllIlIlIIlIllIl;
                break;
            }
            default: {
                llllllllllllllIIllllIlIlIIlIlIlI = false;
                break;
            }
        }
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllIIllllIlIlIIlIlllI.ordinal()]) {
            case 4: {
                return new BlockPos(llllllllllllllIIllllIlIlIIlIlIll, llllllllllllllIIllllIlIlIIlIllII, -llllllllllllllIIllllIlIlIIlIllIl);
            }
            case 2: {
                return new BlockPos(-llllllllllllllIIllllIlIlIIlIlIll, llllllllllllllIIllllIlIlIIlIllII, llllllllllllllIIllllIlIlIIlIllIl);
            }
            case 3: {
                return new BlockPos(-llllllllllllllIIllllIlIlIIlIllIl, llllllllllllllIIllllIlIlIIlIllII, -llllllllllllllIIllllIlIlIIlIlIll);
            }
            default: {
                return llllllllllllllIIllllIlIlIIlIlIlI ? new BlockPos(llllllllllllllIIllllIlIlIIlIllIl, llllllllllllllIIllllIlIlIIlIllII, llllllllllllllIIllllIlIlIIlIlIll) : llllllllllllllIIllllIlIlIIlIlIIl;
            }
        }
    }
    
    public void read(final NBTTagCompound llllllllllllllIIllllIlIIlIllllII) {
        this.blocks.clear();
        this.entities.clear();
        final NBTTagList llllllllllllllIIllllIlIIlIlllIll = llllllllllllllIIllllIlIIlIllllII.getTagList("size", 3);
        this.size = new BlockPos(llllllllllllllIIllllIlIIlIlllIll.getIntAt(0), llllllllllllllIIllllIlIIlIlllIll.getIntAt(1), llllllllllllllIIllllIlIIlIlllIll.getIntAt(2));
        this.author = llllllllllllllIIllllIlIIlIllllII.getString("author");
        final BasicPalette llllllllllllllIIllllIlIIlIlllIlI = new BasicPalette(null);
        final NBTTagList llllllllllllllIIllllIlIIlIlllIIl = llllllllllllllIIllllIlIIlIllllII.getTagList("palette", 10);
        for (int llllllllllllllIIllllIlIIlIlllIII = 0; llllllllllllllIIllllIlIIlIlllIII < llllllllllllllIIllllIlIIlIlllIIl.tagCount(); ++llllllllllllllIIllllIlIIlIlllIII) {
            llllllllllllllIIllllIlIIlIlllIlI.addMapping(NBTUtil.readBlockState(llllllllllllllIIllllIlIIlIlllIIl.getCompoundTagAt(llllllllllllllIIllllIlIIlIlllIII)), llllllllllllllIIllllIlIIlIlllIII);
        }
        final NBTTagList llllllllllllllIIllllIlIIlIllIlll = llllllllllllllIIllllIlIIlIllllII.getTagList("blocks", 10);
        for (int llllllllllllllIIllllIlIIlIllIllI = 0; llllllllllllllIIllllIlIIlIllIllI < llllllllllllllIIllllIlIIlIllIlll.tagCount(); ++llllllllllllllIIllllIlIIlIllIllI) {
            final NBTTagCompound llllllllllllllIIllllIlIIlIllIlIl = llllllllllllllIIllllIlIIlIllIlll.getCompoundTagAt(llllllllllllllIIllllIlIIlIllIllI);
            final NBTTagList llllllllllllllIIllllIlIIlIllIlII = llllllllllllllIIllllIlIIlIllIlIl.getTagList("pos", 3);
            final BlockPos llllllllllllllIIllllIlIIlIllIIll = new BlockPos(llllllllllllllIIllllIlIIlIllIlII.getIntAt(0), llllllllllllllIIllllIlIIlIllIlII.getIntAt(1), llllllllllllllIIllllIlIIlIllIlII.getIntAt(2));
            final IBlockState llllllllllllllIIllllIlIIlIllIIlI = llllllllllllllIIllllIlIIlIlllIlI.stateFor(llllllllllllllIIllllIlIIlIllIlIl.getInteger("state"));
            NBTTagCompound llllllllllllllIIllllIlIIlIllIIII = null;
            if (llllllllllllllIIllllIlIIlIllIlIl.hasKey("nbt")) {
                final NBTTagCompound llllllllllllllIIllllIlIIlIllIIIl = llllllllllllllIIllllIlIIlIllIlIl.getCompoundTag("nbt");
            }
            else {
                llllllllllllllIIllllIlIIlIllIIII = null;
            }
            this.blocks.add(new BlockInfo(llllllllllllllIIllllIlIIlIllIIll, llllllllllllllIIllllIlIIlIllIIlI, llllllllllllllIIllllIlIIlIllIIII));
        }
        final NBTTagList llllllllllllllIIllllIlIIlIlIllll = llllllllllllllIIllllIlIIlIllllII.getTagList("entities", 10);
        for (int llllllllllllllIIllllIlIIlIlIlllI = 0; llllllllllllllIIllllIlIIlIlIlllI < llllllllllllllIIllllIlIIlIlIllll.tagCount(); ++llllllllllllllIIllllIlIIlIlIlllI) {
            final NBTTagCompound llllllllllllllIIllllIlIIlIlIllIl = llllllllllllllIIllllIlIIlIlIllll.getCompoundTagAt(llllllllllllllIIllllIlIIlIlIlllI);
            final NBTTagList llllllllllllllIIllllIlIIlIlIllII = llllllllllllllIIllllIlIIlIlIllIl.getTagList("pos", 6);
            final Vec3d llllllllllllllIIllllIlIIlIlIlIll = new Vec3d(llllllllllllllIIllllIlIIlIlIllII.getDoubleAt(0), llllllllllllllIIllllIlIIlIlIllII.getDoubleAt(1), llllllllllllllIIllllIlIIlIlIllII.getDoubleAt(2));
            final NBTTagList llllllllllllllIIllllIlIIlIlIlIlI = llllllllllllllIIllllIlIIlIlIllIl.getTagList("blockPos", 3);
            final BlockPos llllllllllllllIIllllIlIIlIlIlIIl = new BlockPos(llllllllllllllIIllllIlIIlIlIlIlI.getIntAt(0), llllllllllllllIIllllIlIIlIlIlIlI.getIntAt(1), llllllllllllllIIllllIlIIlIlIlIlI.getIntAt(2));
            if (llllllllllllllIIllllIlIIlIlIllIl.hasKey("nbt")) {
                final NBTTagCompound llllllllllllllIIllllIlIIlIlIlIII = llllllllllllllIIllllIlIIlIlIllIl.getCompoundTag("nbt");
                this.entities.add(new EntityInfo(llllllllllllllIIllllIlIIlIlIlIll, llllllllllllllIIllllIlIIlIlIlIIl, llllllllllllllIIllllIlIIlIlIlIII));
            }
        }
    }
    
    public BlockPos transformedSize(final Rotation llllllllllllllIIllllIlIlIIlllIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllIIllllIlIlIIlllIlI.ordinal()]) {
            case 2:
            case 4: {
                return new BlockPos(this.size.getZ(), this.size.getY(), this.size.getX());
            }
            default: {
                return this.size;
            }
        }
    }
    
    public BlockPos getZeroPositionWithTransform(final BlockPos llllllllllllllIIllllIlIlIIIIlIII, final Mirror llllllllllllllIIllllIlIlIIIIIlll, final Rotation llllllllllllllIIllllIlIlIIIIIIlI) {
        return func_191157_a(llllllllllllllIIllllIlIlIIIIlIII, llllllllllllllIIllllIlIlIIIIIlll, llllllllllllllIIllllIlIlIIIIIIlI, this.getSize().getX(), this.getSize().getZ());
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public void takeBlocksFromWorld(final World llllllllllllllIIllllIllIIIlIlIlI, final BlockPos llllllllllllllIIllllIllIIIlIlIIl, final BlockPos llllllllllllllIIllllIllIIIlllIIl, final boolean llllllllllllllIIllllIllIIIlllIII, @Nullable final Block llllllllllllllIIllllIllIIIlIIllI) {
        if (llllllllllllllIIllllIllIIIlllIIl.getX() >= 1 && llllllllllllllIIllllIllIIIlllIIl.getY() >= 1 && llllllllllllllIIllllIllIIIlllIIl.getZ() >= 1) {
            final BlockPos llllllllllllllIIllllIllIIIllIllI = llllllllllllllIIllllIllIIIlIlIIl.add(llllllllllllllIIllllIllIIIlllIIl).add(-1, -1, -1);
            final List<BlockInfo> llllllllllllllIIllllIllIIIllIlIl = (List<BlockInfo>)Lists.newArrayList();
            final List<BlockInfo> llllllllllllllIIllllIllIIIllIlII = (List<BlockInfo>)Lists.newArrayList();
            final List<BlockInfo> llllllllllllllIIllllIllIIIllIIll = (List<BlockInfo>)Lists.newArrayList();
            final BlockPos llllllllllllllIIllllIllIIIllIIlI = new BlockPos(Math.min(llllllllllllllIIllllIllIIIlIlIIl.getX(), llllllllllllllIIllllIllIIIllIllI.getX()), Math.min(llllllllllllllIIllllIllIIIlIlIIl.getY(), llllllllllllllIIllllIllIIIllIllI.getY()), Math.min(llllllllllllllIIllllIllIIIlIlIIl.getZ(), llllllllllllllIIllllIllIIIllIllI.getZ()));
            final BlockPos llllllllllllllIIllllIllIIIllIIIl = new BlockPos(Math.max(llllllllllllllIIllllIllIIIlIlIIl.getX(), llllllllllllllIIllllIllIIIllIllI.getX()), Math.max(llllllllllllllIIllllIllIIIlIlIIl.getY(), llllllllllllllIIllllIllIIIllIllI.getY()), Math.max(llllllllllllllIIllllIllIIIlIlIIl.getZ(), llllllllllllllIIllllIllIIIllIllI.getZ()));
            this.size = llllllllllllllIIllllIllIIIlllIIl;
            for (final BlockPos.MutableBlockPos llllllllllllllIIllllIllIIIllIIII : BlockPos.getAllInBoxMutable(llllllllllllllIIllllIllIIIllIIlI, llllllllllllllIIllllIllIIIllIIIl)) {
                final BlockPos llllllllllllllIIllllIllIIIlIllll = llllllllllllllIIllllIllIIIllIIII.subtract(llllllllllllllIIllllIllIIIllIIlI);
                final IBlockState llllllllllllllIIllllIllIIIlIlllI = llllllllllllllIIllllIllIIIlIlIlI.getBlockState(llllllllllllllIIllllIllIIIllIIII);
                if (llllllllllllllIIllllIllIIIlIIllI == null || llllllllllllllIIllllIllIIIlIIllI != llllllllllllllIIllllIllIIIlIlllI.getBlock()) {
                    final TileEntity llllllllllllllIIllllIllIIIlIllIl = llllllllllllllIIllllIllIIIlIlIlI.getTileEntity(llllllllllllllIIllllIllIIIllIIII);
                    if (llllllllllllllIIllllIllIIIlIllIl != null) {
                        final NBTTagCompound llllllllllllllIIllllIllIIIlIllII = llllllllllllllIIllllIllIIIlIllIl.writeToNBT(new NBTTagCompound());
                        llllllllllllllIIllllIllIIIlIllII.removeTag("x");
                        llllllllllllllIIllllIllIIIlIllII.removeTag("y");
                        llllllllllllllIIllllIllIIIlIllII.removeTag("z");
                        llllllllllllllIIllllIllIIIllIlII.add(new BlockInfo(llllllllllllllIIllllIllIIIlIllll, llllllllllllllIIllllIllIIIlIlllI, llllllllllllllIIllllIllIIIlIllII));
                    }
                    else if (!llllllllllllllIIllllIllIIIlIlllI.isFullBlock() && !llllllllllllllIIllllIllIIIlIlllI.isFullCube()) {
                        llllllllllllllIIllllIllIIIllIIll.add(new BlockInfo(llllllllllllllIIllllIllIIIlIllll, llllllllllllllIIllllIllIIIlIlllI, null));
                    }
                    else {
                        llllllllllllllIIllllIllIIIllIlIl.add(new BlockInfo(llllllllllllllIIllllIllIIIlIllll, llllllllllllllIIllllIllIIIlIlllI, null));
                    }
                }
            }
            this.blocks.clear();
            this.blocks.addAll(llllllllllllllIIllllIllIIIllIlIl);
            this.blocks.addAll(llllllllllllllIIllllIllIIIllIlII);
            this.blocks.addAll(llllllllllllllIIllllIllIIIllIIll);
            if (llllllllllllllIIllllIllIIIlllIII) {
                this.takeEntitiesFromWorld(llllllllllllllIIllllIllIIIlIlIlI, llllllllllllllIIllllIllIIIllIIlI, llllllllllllllIIllllIllIIIllIIIl.add(1, 1, 1));
            }
            else {
                this.entities.clear();
            }
        }
    }
    
    public static BlockPos transformedBlockPos(final PlacementSettings llllllllllllllIIllllIlIlllIIIlll, final BlockPos llllllllllllllIIllllIlIlllIIIllI) {
        return transformedBlockPos(llllllllllllllIIllllIlIlllIIIllI, llllllllllllllIIllllIlIlllIIIlll.getMirror(), llllllllllllllIIllllIlIlllIIIlll.getRotation());
    }
    
    static class BasicPalette implements Iterable<IBlockState>
    {
        final /* synthetic */ ObjectIntIdentityMap<IBlockState> ids;
        private /* synthetic */ int lastId;
        public static final /* synthetic */ IBlockState DEFAULT_BLOCK_STATE;
        
        static {
            DEFAULT_BLOCK_STATE = Blocks.AIR.getDefaultState();
        }
        
        @Nullable
        public IBlockState stateFor(final int lIlllIIIllIIllI) {
            final IBlockState lIlllIIIllIIlIl = this.ids.getByValue(lIlllIIIllIIllI);
            return (lIlllIIIllIIlIl == null) ? BasicPalette.DEFAULT_BLOCK_STATE : lIlllIIIllIIlIl;
        }
        
        public int idFor(final IBlockState lIlllIIIllIllll) {
            int lIlllIIIllIlllI = this.ids.get(lIlllIIIllIllll);
            if (lIlllIIIllIlllI == -1) {
                lIlllIIIllIlllI = this.lastId++;
                this.ids.put(lIlllIIIllIllll, lIlllIIIllIlllI);
            }
            return lIlllIIIllIlllI;
        }
        
        public void addMapping(final IBlockState lIlllIIIlIllIlI, final int lIlllIIIlIllIIl) {
            this.ids.put(lIlllIIIlIllIlI, lIlllIIIlIllIIl);
        }
        
        private BasicPalette() {
            this.ids = new ObjectIntIdentityMap<IBlockState>(16);
        }
        
        @Override
        public Iterator<IBlockState> iterator() {
            return this.ids.iterator();
        }
    }
    
    public static class BlockInfo
    {
        public final /* synthetic */ NBTTagCompound tileentityData;
        public final /* synthetic */ IBlockState blockState;
        public final /* synthetic */ BlockPos pos;
        
        public BlockInfo(final BlockPos llllllllllllllIIIIlIlIllllllIIIl, final IBlockState llllllllllllllIIIIlIlIllllllIIII, @Nullable final NBTTagCompound llllllllllllllIIIIlIlIlllllIllll) {
            this.pos = llllllllllllllIIIIlIlIllllllIIIl;
            this.blockState = llllllllllllllIIIIlIlIllllllIIII;
            this.tileentityData = llllllllllllllIIIIlIlIlllllIllll;
        }
    }
    
    public static class EntityInfo
    {
        public final /* synthetic */ NBTTagCompound entityData;
        public final /* synthetic */ BlockPos blockPos;
        public final /* synthetic */ Vec3d pos;
        
        public EntityInfo(final Vec3d lllllllllllllllllIIIIlllllIIIlII, final BlockPos lllllllllllllllllIIIIllllIllllll, final NBTTagCompound lllllllllllllllllIIIIllllIlllllI) {
            this.pos = lllllllllllllllllIIIIlllllIIIlII;
            this.blockPos = lllllllllllllllllIIIIllllIllllll;
            this.entityData = lllllllllllllllllIIIIllllIlllllI;
        }
    }
}
