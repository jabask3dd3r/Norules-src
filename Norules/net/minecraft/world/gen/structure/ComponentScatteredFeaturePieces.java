package net.minecraft.world.gen.structure;

import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.nbt.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.server.*;
import net.minecraft.tileentity.*;

public class ComponentScatteredFeaturePieces
{
    public static void registerScatteredFeaturePieces() {
        MapGenStructureIO.registerStructureComponent(DesertPyramid.class, "TeDP");
        MapGenStructureIO.registerStructureComponent(JunglePyramid.class, "TeJP");
        MapGenStructureIO.registerStructureComponent(SwampHut.class, "TeSH");
        MapGenStructureIO.registerStructureComponent(Igloo.class, "Iglu");
    }
    
    public static class SwampHut extends Feature
    {
        private /* synthetic */ boolean hasWitch;
        
        @Override
        public boolean addComponentParts(final World llllllllllllIlllllllIlIIIlllIlIl, final Random llllllllllllIlllllllIlIIlIIIIIlI, final StructureBoundingBox llllllllllllIlllllllIlIIIlllIlII) {
            if (!this.offsetToAverageGroundLevel(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 0)) {
                return false;
            }
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 1, 1, 1, 5, 1, 7, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 1, 4, 2, 5, 4, 7, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 2, 1, 0, 4, 1, 0, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 2, 2, 2, 3, 3, 2, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 1, 2, 3, 1, 3, 6, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 5, 2, 3, 5, 3, 6, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 2, 2, 7, 4, 3, 7, Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.PLANKS.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 1, 0, 2, 1, 3, 2, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 5, 0, 2, 5, 3, 2, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 1, 0, 7, 1, 3, 7, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 5, 0, 7, 5, 3, 7, Blocks.LOG.getDefaultState(), Blocks.LOG.getDefaultState(), false);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.OAK_FENCE.getDefaultState(), 2, 3, 2, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.OAK_FENCE.getDefaultState(), 3, 3, 7, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.AIR.getDefaultState(), 1, 3, 4, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.AIR.getDefaultState(), 5, 3, 4, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.AIR.getDefaultState(), 5, 3, 5, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.FLOWER_POT.getDefaultState().withProperty(BlockFlowerPot.CONTENTS, BlockFlowerPot.EnumFlowerType.MUSHROOM_RED), 1, 3, 5, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.CRAFTING_TABLE.getDefaultState(), 3, 2, 6, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.CAULDRON.getDefaultState(), 4, 2, 6, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.OAK_FENCE.getDefaultState(), 1, 2, 1, llllllllllllIlllllllIlIIIlllIlII);
            this.setBlockState(llllllllllllIlllllllIlIIIlllIlIl, Blocks.OAK_FENCE.getDefaultState(), 5, 2, 1, llllllllllllIlllllllIlIIIlllIlII);
            final IBlockState llllllllllllIlllllllIlIIlIIIIIII = Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            final IBlockState llllllllllllIlllllllIlIIIlllllll = Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST);
            final IBlockState llllllllllllIlllllllIlIIIllllllI = Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST);
            final IBlockState llllllllllllIlllllllIlIIIlllllIl = Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 0, 4, 1, 6, 4, 1, llllllllllllIlllllllIlIIlIIIIIII, llllllllllllIlllllllIlIIlIIIIIII, false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 0, 4, 2, 0, 4, 7, llllllllllllIlllllllIlIIIlllllll, llllllllllllIlllllllIlIIIlllllll, false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 6, 4, 2, 6, 4, 7, llllllllllllIlllllllIlIIIllllllI, llllllllllllIlllllllIlIIIllllllI, false);
            this.fillWithBlocks(llllllllllllIlllllllIlIIIlllIlIl, llllllllllllIlllllllIlIIIlllIlII, 0, 4, 8, 6, 4, 8, llllllllllllIlllllllIlIIIlllllIl, llllllllllllIlllllllIlIIIlllllIl, false);
            for (int llllllllllllIlllllllIlIIIlllllII = 2; llllllllllllIlllllllIlIIIlllllII <= 7; llllllllllllIlllllllIlIIIlllllII += 5) {
                for (int llllllllllllIlllllllIlIIIllllIll = 1; llllllllllllIlllllllIlIIIllllIll <= 5; llllllllllllIlllllllIlIIIllllIll += 4) {
                    this.replaceAirAndLiquidDownwards(llllllllllllIlllllllIlIIIlllIlIl, Blocks.LOG.getDefaultState(), llllllllllllIlllllllIlIIIllllIll, -1, llllllllllllIlllllllIlIIIlllllII, llllllllllllIlllllllIlIIIlllIlII);
                }
            }
            if (!this.hasWitch) {
                final int llllllllllllIlllllllIlIIIllllIlI = this.getXWithOffset(2, 5);
                final int llllllllllllIlllllllIlIIIllllIIl = this.getYWithOffset(2);
                final int llllllllllllIlllllllIlIIIllllIII = this.getZWithOffset(2, 5);
                if (llllllllllllIlllllllIlIIIlllIlII.isVecInside(new BlockPos(llllllllllllIlllllllIlIIIllllIlI, llllllllllllIlllllllIlIIIllllIIl, llllllllllllIlllllllIlIIIllllIII))) {
                    this.hasWitch = true;
                    final EntityWitch llllllllllllIlllllllIlIIIlllIlll = new EntityWitch(llllllllllllIlllllllIlIIIlllIlIl);
                    llllllllllllIlllllllIlIIIlllIlll.enablePersistence();
                    llllllllllllIlllllllIlIIIlllIlll.setLocationAndAngles(llllllllllllIlllllllIlIIIllllIlI + 0.5, llllllllllllIlllllllIlIIIllllIIl, llllllllllllIlllllllIlIIIllllIII + 0.5, 0.0f, 0.0f);
                    llllllllllllIlllllllIlIIIlllIlll.onInitialSpawn(llllllllllllIlllllllIlIIIlllIlIl.getDifficultyForLocation(new BlockPos(llllllllllllIlllllllIlIIIllllIlI, llllllllllllIlllllllIlIIIllllIIl, llllllllllllIlllllllIlIIIllllIII)), null);
                    llllllllllllIlllllllIlIIIlllIlIl.spawnEntityInWorld(llllllllllllIlllllllIlIIIlllIlll);
                }
            }
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllIlllllllIlIIlIIllIll) {
            super.writeStructureToNBT(llllllllllllIlllllllIlIIlIIllIll);
            llllllllllllIlllllllIlIIlIIllIll.setBoolean("Witch", this.hasWitch);
        }
        
        public SwampHut(final Random llllllllllllIlllllllIlIIlIlIIIIl, final int llllllllllllIlllllllIlIIlIlIIlII, final int llllllllllllIlllllllIlIIlIIlllll) {
            super(llllllllllllIlllllllIlIIlIlIIIIl, llllllllllllIlllllllIlIIlIlIIlII, 64, llllllllllllIlllllllIlIIlIIlllll, 7, 7, 9);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllIlllllllIlIIlIIlIIIl, final TemplateManager llllllllllllIlllllllIlIIlIIlIIll) {
            super.readStructureFromNBT(llllllllllllIlllllllIlIIlIIlIIIl, llllllllllllIlllllllIlIIlIIlIIll);
            this.hasWitch = llllllllllllIlllllllIlIIlIIlIIIl.getBoolean("Witch");
        }
        
        public SwampHut() {
        }
    }
    
    abstract static class Feature extends StructureComponent
    {
        protected /* synthetic */ int scatteredFeatureSizeX;
        protected /* synthetic */ int horizontalPos;
        protected /* synthetic */ int scatteredFeatureSizeY;
        protected /* synthetic */ int scatteredFeatureSizeZ;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllllIIIllllIlIllIlll) {
            llllllllllllllllIIIllllIlIllIlll.setInteger("Width", this.scatteredFeatureSizeX);
            llllllllllllllllIIIllllIlIllIlll.setInteger("Height", this.scatteredFeatureSizeY);
            llllllllllllllllIIIllllIlIllIlll.setInteger("Depth", this.scatteredFeatureSizeZ);
            llllllllllllllllIIIllllIlIllIlll.setInteger("HPos", this.horizontalPos);
        }
        
        protected Feature(final Random llllllllllllllllIIIllllIllIIIIll, final int llllllllllllllllIIIllllIllIIIIlI, final int llllllllllllllllIIIllllIllIIlIIl, final int llllllllllllllllIIIllllIllIIIIII, final int llllllllllllllllIIIllllIllIIIlll, final int llllllllllllllllIIIllllIlIlllllI, final int llllllllllllllllIIIllllIlIllllIl) {
            super(0);
            this.horizontalPos = -1;
            this.scatteredFeatureSizeX = llllllllllllllllIIIllllIllIIIlll;
            this.scatteredFeatureSizeY = llllllllllllllllIIIllllIlIlllllI;
            this.scatteredFeatureSizeZ = llllllllllllllllIIIllllIlIllllIl;
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(llllllllllllllllIIIllllIllIIIIll));
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(llllllllllllllllIIIllllIllIIIIlI, llllllllllllllllIIIllllIllIIlIIl, llllllllllllllllIIIllllIllIIIIII, llllllllllllllllIIIllllIllIIIIlI + llllllllllllllllIIIllllIllIIIlll - 1, llllllllllllllllIIIllllIllIIlIIl + llllllllllllllllIIIllllIlIlllllI - 1, llllllllllllllllIIIllllIllIIIIII + llllllllllllllllIIIllllIlIllllIl - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(llllllllllllllllIIIllllIllIIIIlI, llllllllllllllllIIIllllIllIIlIIl, llllllllllllllllIIIllllIllIIIIII, llllllllllllllllIIIllllIllIIIIlI + llllllllllllllllIIIllllIlIllllIl - 1, llllllllllllllllIIIllllIllIIlIIl + llllllllllllllllIIIllllIlIlllllI - 1, llllllllllllllllIIIllllIllIIIIII + llllllllllllllllIIIllllIllIIIlll - 1);
            }
        }
        
        public Feature() {
            this.horizontalPos = -1;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllllIIIllllIlIllIIll, final TemplateManager llllllllllllllllIIIllllIlIllIIlI) {
            this.scatteredFeatureSizeX = llllllllllllllllIIIllllIlIllIIll.getInteger("Width");
            this.scatteredFeatureSizeY = llllllllllllllllIIIllllIlIllIIll.getInteger("Height");
            this.scatteredFeatureSizeZ = llllllllllllllllIIIllllIlIllIIll.getInteger("Depth");
            this.horizontalPos = llllllllllllllllIIIllllIlIllIIll.getInteger("HPos");
        }
        
        protected boolean offsetToAverageGroundLevel(final World llllllllllllllllIIIllllIlIIlIllI, final StructureBoundingBox llllllllllllllllIIIllllIlIIlIlII, final int llllllllllllllllIIIllllIlIlIIIIl) {
            if (this.horizontalPos >= 0) {
                return true;
            }
            int llllllllllllllllIIIllllIlIlIIIII = 0;
            int llllllllllllllllIIIllllIlIIllllI = 0;
            final BlockPos.MutableBlockPos llllllllllllllllIIIllllIlIIlllIl = new BlockPos.MutableBlockPos();
            for (int llllllllllllllllIIIllllIlIIlllII = this.boundingBox.minZ; llllllllllllllllIIIllllIlIIlllII <= this.boundingBox.maxZ; ++llllllllllllllllIIIllllIlIIlllII) {
                for (int llllllllllllllllIIIllllIlIIllIlI = this.boundingBox.minX; llllllllllllllllIIIllllIlIIllIlI <= this.boundingBox.maxX; ++llllllllllllllllIIIllllIlIIllIlI) {
                    llllllllllllllllIIIllllIlIIlllIl.setPos(llllllllllllllllIIIllllIlIIllIlI, 64, llllllllllllllllIIIllllIlIIlllII);
                    if (llllllllllllllllIIIllllIlIIlIlII.isVecInside(llllllllllllllllIIIllllIlIIlllIl)) {
                        llllllllllllllllIIIllllIlIlIIIII += Math.max(llllllllllllllllIIIllllIlIIlIllI.getTopSolidOrLiquidBlock(llllllllllllllllIIIllllIlIIlllIl).getY(), llllllllllllllllIIIllllIlIIlIllI.provider.getAverageGroundLevel());
                        ++llllllllllllllllIIIllllIlIIllllI;
                    }
                }
            }
            if (llllllllllllllllIIIllllIlIIllllI == 0) {
                return false;
            }
            this.horizontalPos = llllllllllllllllIIIllllIlIlIIIII / llllllllllllllllIIIllllIlIIllllI;
            this.boundingBox.offset(0, this.horizontalPos - this.boundingBox.minY + llllllllllllllllIIIllllIlIlIIIIl, 0);
            return true;
        }
    }
    
    public static class JunglePyramid extends Feature
    {
        private /* synthetic */ boolean placedMainChest;
        private /* synthetic */ boolean placedHiddenChest;
        private /* synthetic */ boolean placedTrap1;
        private /* synthetic */ boolean placedTrap2;
        private static final /* synthetic */ Stones junglePyramidsRandomScatteredStones;
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIlIIIlIIllIlIlIl, final Random lllllllllllllIIlIlIIIlIIlllIIIll, final StructureBoundingBox lllllllllllllIIlIlIIIlIIllIlIIll) {
            if (!this.offsetToAverageGroundLevel(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 0)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 1, 2, 9, 2, 2, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 1, 12, 9, 2, 12, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 1, 3, 2, 2, 11, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 9, 1, 3, 9, 2, 11, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 1, 3, 1, 10, 6, 1, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 1, 3, 13, 10, 6, 13, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 1, 3, 2, 1, 6, 12, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 10, 3, 2, 10, 6, 12, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 3, 2, 9, 3, 12, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 6, 2, 9, 6, 12, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 3, 7, 3, 8, 7, 11, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 4, 8, 4, 7, 8, 10, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 3, 1, 3, 8, 2, 11);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 4, 3, 6, 7, 3, 9);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 4, 2, 9, 5, 12);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 4, 6, 5, 7, 6, 9);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 7, 6, 6, 7, 8);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 1, 2, 6, 2, 2);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 2, 12, 6, 2, 12);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 5, 1, 6, 5, 1);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 5, 13, 6, 5, 13);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.AIR.getDefaultState(), 1, 5, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.AIR.getDefaultState(), 10, 5, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.AIR.getDefaultState(), 1, 5, 9, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.AIR.getDefaultState(), 10, 5, 9, lllllllllllllIIlIlIIIlIIllIlIIll);
            for (int lllllllllllllIIlIlIIIlIIlllIIIIl = 0; lllllllllllllIIlIlIIIlIIlllIIIIl <= 14; lllllllllllllIIlIlIIIlIIlllIIIIl += 14) {
                this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 4, lllllllllllllIIlIlIIIlIIlllIIIIl, 2, 5, lllllllllllllIIlIlIIIlIIlllIIIIl, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 4, 4, lllllllllllllIIlIlIIIlIIlllIIIIl, 4, 5, lllllllllllllIIlIlIIIlIIlllIIIIl, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 7, 4, lllllllllllllIIlIlIIIlIIlllIIIIl, 7, 5, lllllllllllllIIlIlIIIlIIlllIIIIl, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 9, 4, lllllllllllllIIlIlIIIlIIlllIIIIl, 9, 5, lllllllllllllIIlIlIIIlIIlllIIIIl, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 6, 0, 6, 6, 0, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            for (int lllllllllllllIIlIlIIIlIIlllIIIII = 0; lllllllllllllIIlIlIIIlIIlllIIIII <= 11; lllllllllllllIIlIlIIIlIIlllIIIII += 11) {
                for (int lllllllllllllIIlIlIIIlIIllIlllll = 2; lllllllllllllIIlIlIIIlIIllIlllll <= 12; lllllllllllllIIlIlIIIlIIllIlllll += 2) {
                    this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, lllllllllllllIIlIlIIIlIIlllIIIII, 4, lllllllllllllIIlIlIIIlIIllIlllll, lllllllllllllIIlIlIIIlIIlllIIIII, 5, lllllllllllllIIlIlIIIlIIllIlllll, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
                }
                this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, lllllllllllllIIlIlIIIlIIlllIIIII, 6, 5, lllllllllllllIIlIlIIIlIIlllIIIII, 6, 5, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, lllllllllllllIIlIlIIIlIIlllIIIII, 6, 9, lllllllllllllIIlIlIIIlIIlllIIIII, 6, 9, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 7, 2, 2, 9, 2, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 9, 7, 2, 9, 9, 2, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, 7, 12, 2, 9, 12, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 9, 7, 12, 9, 9, 12, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 4, 9, 4, 4, 9, 4, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 7, 9, 4, 7, 9, 4, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 4, 9, 10, 4, 9, 10, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 7, 9, 10, 7, 9, 10, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 9, 7, 6, 9, 7, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            final IBlockState lllllllllllllIIlIlIIIlIIllIllllI = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllllIIlIlIIIlIIllIlllIl = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST);
            final IBlockState lllllllllllllIIlIlIIIlIIllIlllII = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            final IBlockState lllllllllllllIIlIlIIIlIIllIllIll = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 5, 9, 6, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 6, 9, 6, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlllII, 5, 9, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlllII, 6, 9, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 4, 0, 0, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 5, 0, 0, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 6, 0, 0, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 7, 0, 0, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 4, 1, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 4, 2, 9, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 4, 3, 10, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 7, 1, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 7, 2, 9, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllIll, 7, 3, 10, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 4, 1, 9, 4, 1, 9, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 7, 1, 9, 7, 1, 9, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 4, 1, 10, 7, 2, 10, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 4, 5, 6, 4, 5, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIllllI, 4, 4, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlllIl, 7, 4, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            for (int lllllllllllllIIlIlIIIlIIllIllIlI = 0; lllllllllllllIIlIlIIIlIIllIllIlI < 4; ++lllllllllllllIIlIlIIIlIIllIllIlI) {
                this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlllII, 5, 0 - lllllllllllllIIlIlIIIlIIllIllIlI, 6 + lllllllllllllIIlIlIIIlIIllIllIlI, lllllllllllllIIlIlIIIlIIllIlIIll);
                this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlllII, 6, 0 - lllllllllllllIIlIlIIIlIIllIllIlI, 6 + lllllllllllllIIlIlIIIlIIllIllIlI, lllllllllllllIIlIlIIIlIIllIlIIll);
                this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 5, 0 - lllllllllllllIIlIlIIIlIIllIllIlI, 7 + lllllllllllllIIlIlIIIlIIllIllIlI, 6, 0 - lllllllllllllIIlIlIIIlIIllIllIlI, 9 + lllllllllllllIIlIlIIIlIIllIllIlI);
            }
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 1, -3, 12, 10, -1, 13);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 1, -3, 1, 3, -1, 13);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 1, -3, 1, 9, -1, 5);
            for (int lllllllllllllIIlIlIIIlIIllIllIIl = 1; lllllllllllllIIlIlIIIlIIllIllIIl <= 13; lllllllllllllIIlIlIIIlIIllIllIIl += 2) {
                this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 1, -3, lllllllllllllIIlIlIIIlIIllIllIIl, 1, -2, lllllllllllllIIlIlIIIlIIllIllIIl, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            for (int lllllllllllllIIlIlIIIlIIllIllIII = 2; lllllllllllllIIlIlIIIlIIllIllIII <= 12; lllllllllllllIIlIlIIIlIIllIllIII += 2) {
                this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 1, -1, lllllllllllllIIlIlIIIlIIllIllIII, 3, -1, lllllllllllllIIlIlIIIlIIllIllIII, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 2, -2, 1, 5, -2, 1, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 7, -2, 1, 9, -2, 1, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 6, -3, 1, 6, -3, 1, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 6, -1, 1, 6, -1, 1, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE_HOOK.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.EAST).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, true), 1, -3, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE_HOOK.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.WEST).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, true), 4, -3, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 2, -3, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 3, -3, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 7, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 6, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 4, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 3, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 2, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 5, -3, 1, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 4, -3, 1, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 3, -3, 1, lllllllllllllIIlIlIIIlIIllIlIIll);
            if (!this.placedTrap1) {
                this.placedTrap1 = this.createDispenser(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, lllllllllllllIIlIlIIIlIIlllIIIll, 3, -2, 1, EnumFacing.NORTH, LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER);
            }
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.SOUTH, true), 3, -2, 2, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE_HOOK.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, true), 7, -3, 1, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE_HOOK.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWireHook.FACING, EnumFacing.SOUTH).withProperty((IProperty<Comparable>)BlockTripWireHook.ATTACHED, true), 7, -3, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 7, -3, 2, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 7, -3, 3, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.TRIPWIRE.getDefaultState().withProperty((IProperty<Comparable>)BlockTripWire.ATTACHED, true), 7, -3, 4, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 8, -3, 6, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 9, -3, 6, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 9, -3, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 9, -3, 4, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 9, -2, 4, lllllllllllllIIlIlIIIlIIllIlIIll);
            if (!this.placedTrap2) {
                this.placedTrap2 = this.createDispenser(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, lllllllllllllIIlIlIIIlIIlllIIIll, 9, -2, 3, EnumFacing.WEST, LootTableList.CHESTS_JUNGLE_TEMPLE_DISPENSER);
            }
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.EAST, true), 8, -1, 3, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.EAST, true), 8, -2, 3, lllllllllllllIIlIlIIIlIIllIlIIll);
            if (!this.placedMainChest) {
                this.placedMainChest = this.generateChest(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, lllllllllllllIIlIlIIIlIIlllIIIll, 8, -3, 3, LootTableList.CHESTS_JUNGLE_TEMPLE);
            }
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 9, -3, 2, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 8, -3, 1, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 4, -3, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 5, -2, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 5, -1, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 6, -3, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 7, -2, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 7, -1, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 8, -3, 5, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 9, -1, 1, 9, -1, 5, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithAir(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 8, -3, 8, 10, -1, 10);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CHISELED_META), 8, -2, 11, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CHISELED_META), 9, -2, 11, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CHISELED_META), 10, -2, 11, lllllllllllllIIlIlIIIlIIllIlIIll);
            final IBlockState lllllllllllllIIlIlIIIlIIllIlIlll = Blocks.LEVER.getDefaultState().withProperty(BlockLever.FACING, BlockLever.EnumOrientation.NORTH);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIlll, 8, -2, 12, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIlll, 9, -2, 12, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIlll, 10, -2, 12, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 8, -3, 8, 8, -3, 10, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, 10, -3, 8, 10, -3, 10, false, lllllllllllllIIlIlIIIlIIlllIIIll, JunglePyramid.junglePyramidsRandomScatteredStones);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 10, -2, 9, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 8, -2, 9, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 8, -2, 10, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.REDSTONE_WIRE.getDefaultState(), 10, -1, 9, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.STICKY_PISTON.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.UP), 9, -2, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.STICKY_PISTON.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.WEST), 10, -2, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.STICKY_PISTON.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonBase.FACING, EnumFacing.WEST), 10, -1, 8, lllllllllllllIIlIlIIIlIIllIlIIll);
            this.setBlockState(lllllllllllllIIlIlIIIlIIllIlIlIl, Blocks.UNPOWERED_REPEATER.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, EnumFacing.NORTH), 10, -2, 10, lllllllllllllIIlIlIIIlIIllIlIIll);
            if (!this.placedHiddenChest) {
                this.placedHiddenChest = this.generateChest(lllllllllllllIIlIlIIIlIIllIlIlIl, lllllllllllllIIlIlIIIlIIllIlIIll, lllllllllllllIIlIlIIIlIIlllIIIll, 9, -3, 10, LootTableList.CHESTS_JUNGLE_TEMPLE);
            }
            return true;
        }
        
        public JunglePyramid() {
        }
        
        static {
            junglePyramidsRandomScatteredStones = new Stones(null);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIlIlIIIlIIlllllIII) {
            super.writeStructureToNBT(lllllllllllllIIlIlIIIlIIlllllIII);
            lllllllllllllIIlIlIIIlIIlllllIII.setBoolean("placedMainChest", this.placedMainChest);
            lllllllllllllIIlIlIIIlIIlllllIII.setBoolean("placedHiddenChest", this.placedHiddenChest);
            lllllllllllllIIlIlIIIlIIlllllIII.setBoolean("placedTrap1", this.placedTrap1);
            lllllllllllllIIlIlIIIlIIlllllIII.setBoolean("placedTrap2", this.placedTrap2);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIlIlIIIlIIllllIIll, final TemplateManager lllllllllllllIIlIlIIIlIIlllIllll) {
            super.readStructureFromNBT(lllllllllllllIIlIlIIIlIIllllIIll, lllllllllllllIIlIlIIIlIIlllIllll);
            this.placedMainChest = lllllllllllllIIlIlIIIlIIllllIIll.getBoolean("placedMainChest");
            this.placedHiddenChest = lllllllllllllIIlIlIIIlIIllllIIll.getBoolean("placedHiddenChest");
            this.placedTrap1 = lllllllllllllIIlIlIIIlIIllllIIll.getBoolean("placedTrap1");
            this.placedTrap2 = lllllllllllllIIlIlIIIlIIllllIIll.getBoolean("placedTrap2");
        }
        
        public JunglePyramid(final Random lllllllllllllIIlIlIIIlIlIIIIIIII, final int lllllllllllllIIlIlIIIlIlIIIIIIll, final int lllllllllllllIIlIlIIIlIlIIIIIIlI) {
            super(lllllllllllllIIlIlIIIlIlIIIIIIII, lllllllllllllIIlIlIIIlIlIIIIIIll, 64, lllllllllllllIIlIlIIIlIlIIIIIIlI, 12, 10, 15);
        }
        
        static class Stones extends BlockSelector
        {
            private Stones() {
            }
            
            @Override
            public void selectBlocks(final Random lllllllllllllIIlllIlIlIIlIlllllI, final int lllllllllllllIIlllIlIlIIlIllllIl, final int lllllllllllllIIlllIlIlIIlIllllII, final int lllllllllllllIIlllIlIlIIlIlllIll, final boolean lllllllllllllIIlllIlIlIIlIlllIlI) {
                if (lllllllllllllIIlllIlIlIIlIlllllI.nextFloat() < 0.4f) {
                    this.blockstate = Blocks.COBBLESTONE.getDefaultState();
                }
                else {
                    this.blockstate = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                }
            }
        }
    }
    
    public static class DesertPyramid extends Feature
    {
        private final /* synthetic */ boolean[] hasPlacedChest;
        
        public DesertPyramid(final Random lllllllllllllIIIIlIIIIIlllIIllII, final int lllllllllllllIIIIlIIIIIlllIIlIll, final int lllllllllllllIIIIlIIIIIlllIIIllI) {
            super(lllllllllllllIIIIlIIIIIlllIIllII, lllllllllllllIIIIlIIIIIlllIIlIll, 64, lllllllllllllIIIIlIIIIIlllIIIllI, 21, 15, 21);
            this.hasPlacedChest = new boolean[4];
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIIIlIIIIIllIlllIll, final TemplateManager lllllllllllllIIIIlIIIIIllIlllIlI) {
            super.readStructureFromNBT(lllllllllllllIIIIlIIIIIllIlllIll, lllllllllllllIIIIlIIIIIllIlllIlI);
            this.hasPlacedChest[0] = lllllllllllllIIIIlIIIIIllIlllIll.getBoolean("hasPlacedChest0");
            this.hasPlacedChest[1] = lllllllllllllIIIIlIIIIIllIlllIll.getBoolean("hasPlacedChest1");
            this.hasPlacedChest[2] = lllllllllllllIIIIlIIIIIllIlllIll.getBoolean("hasPlacedChest2");
            this.hasPlacedChest[3] = lllllllllllllIIIIlIIIIIllIlllIll.getBoolean("hasPlacedChest3");
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIIlIIIIIllIlIIlll, final Random lllllllllllllIIIIlIIIIIllIlIIllI, final StructureBoundingBox lllllllllllllIIIIlIIIIIllIIlIIIl) {
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            for (int lllllllllllllIIIIlIIIIIllIlIIlII = 1; lllllllllllllIIIIlIIIIIllIlIIlII <= 9; ++lllllllllllllIIIIlIIIIIllIlIIlII) {
                this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, lllllllllllllIIIIlIIIIIllIlIIlII, lllllllllllllIIIIlIIIIIllIlIIlII, lllllllllllllIIIIlIIIIIllIlIIlII, this.scatteredFeatureSizeX - 1 - lllllllllllllIIIIlIIIIIllIlIIlII, lllllllllllllIIIIlIIIIIllIlIIlII, this.scatteredFeatureSizeZ - 1 - lllllllllllllIIIIlIIIIIllIlIIlII, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, lllllllllllllIIIIlIIIIIllIlIIlII + 1, lllllllllllllIIIIlIIIIIllIlIIlII, lllllllllllllIIIIlIIIIIllIlIIlII + 1, this.scatteredFeatureSizeX - 2 - lllllllllllllIIIIlIIIIIllIlIIlII, lllllllllllllIIIIlIIIIIllIlIIlII, this.scatteredFeatureSizeZ - 2 - lllllllllllllIIIIlIIIIIllIlIIlII, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            for (int lllllllllllllIIIIlIIIIIllIlIIIll = 0; lllllllllllllIIIIlIIIIIllIlIIIll < this.scatteredFeatureSizeX; ++lllllllllllllIIIIlIIIIIllIlIIIll) {
                for (int lllllllllllllIIIIlIIIIIllIlIIIlI = 0; lllllllllllllIIIIlIIIIIllIlIIIlI < this.scatteredFeatureSizeZ; ++lllllllllllllIIIIlIIIIIllIlIIIlI) {
                    final int lllllllllllllIIIIlIIIIIllIlIIIIl = -5;
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getDefaultState(), lllllllllllllIIIIlIIIIIllIlIIIll, -5, lllllllllllllIIIIlIIIIIllIlIIIlI, lllllllllllllIIIIlIIIIIllIIlIIIl);
                }
            }
            final IBlockState lllllllllllllIIIIlIIIIIllIlIIIII = Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            final IBlockState lllllllllllllIIIIlIIIIIllIIlllll = Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            final IBlockState lllllllllllllIIIIlIIIIIllIIllllI = Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllllIIIIlIIIIIllIIlllIl = Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST);
            final int lllllllllllllIIIIlIIIIIllIIlllII = ~EnumDyeColor.ORANGE.getDyeDamage() & 0xF;
            final int lllllllllllllIIIIlIIIIIllIIllIll = ~EnumDyeColor.BLUE.getDyeDamage() & 0xF;
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 0, 0, 0, 4, 9, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 1, 10, 1, 3, 10, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIlIIIII, 2, 10, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlllll, 2, 10, 4, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIllllI, 0, 10, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlllIl, 4, 10, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 5, 0, 0, this.scatteredFeatureSizeX - 1, 9, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 4, 10, 1, this.scatteredFeatureSizeX - 2, 10, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIlIIIII, this.scatteredFeatureSizeX - 3, 10, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlllll, this.scatteredFeatureSizeX - 3, 10, 4, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIllllI, this.scatteredFeatureSizeX - 5, 10, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlllIl, this.scatteredFeatureSizeX - 1, 10, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 8, 0, 0, 12, 4, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 9, 1, 0, 11, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 1, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 2, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 3, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, 3, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 3, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 2, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 1, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 4, 1, 1, 8, 3, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 4, 1, 2, 8, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 12, 1, 1, 16, 3, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 12, 1, 2, 16, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 5, 4, 5, this.scatteredFeatureSizeX - 6, 4, this.scatteredFeatureSizeZ - 6, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 9, 4, 9, 11, 4, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 8, 1, 8, 8, 3, 8, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 12, 1, 8, 12, 3, 8, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 8, 1, 12, 8, 3, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 12, 1, 12, 12, 3, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 1, 1, 5, 4, 4, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 5, 1, 5, this.scatteredFeatureSizeX - 2, 4, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 6, 7, 9, 6, 7, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 7, 7, 9, this.scatteredFeatureSizeX - 7, 7, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 5, 5, 9, 5, 7, 11, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 6, 5, 9, this.scatteredFeatureSizeX - 6, 7, 11, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 5, 5, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 5, 6, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 6, 6, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), this.scatteredFeatureSizeX - 6, 5, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), this.scatteredFeatureSizeX - 6, 6, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), this.scatteredFeatureSizeX - 7, 6, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 2, 4, 4, 2, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 3, 4, 4, this.scatteredFeatureSizeX - 3, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIlIIIII, 2, 4, 5, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIlIIIII, 2, 3, 4, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIlIIIII, this.scatteredFeatureSizeX - 3, 4, 5, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIlIIIII, this.scatteredFeatureSizeX - 3, 3, 4, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 1, 1, 3, 2, 2, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 3, 1, 3, this.scatteredFeatureSizeX - 2, 2, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getDefaultState(), 1, 1, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getDefaultState(), this.scatteredFeatureSizeX - 2, 1, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SAND.getMetadata()), 1, 2, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SAND.getMetadata()), this.scatteredFeatureSizeX - 2, 2, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlllIl, 2, 1, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIllllI, this.scatteredFeatureSizeX - 3, 1, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 4, 3, 5, 4, 3, 18, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 5, 3, 5, this.scatteredFeatureSizeX - 5, 3, 17, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 3, 1, 5, 4, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, this.scatteredFeatureSizeX - 6, 1, 5, this.scatteredFeatureSizeX - 5, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            for (int lllllllllllllIIIIlIIIIIllIIllIlI = 5; lllllllllllllIIIIlIIIIIllIIllIlI <= 17; lllllllllllllIIIIlIIIIIllIIllIlI += 2) {
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 4, 1, lllllllllllllIIIIlIIIIIllIIllIlI, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 4, 2, lllllllllllllIIIIlIIIIIllIIllIlI, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), this.scatteredFeatureSizeX - 5, 1, lllllllllllllIIIIlIIIIIllIIllIlI, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), this.scatteredFeatureSizeX - 5, 2, lllllllllllllIIIIlIIIIIllIIllIlI, lllllllllllllIIIIlIIIIIllIIlIIIl);
            }
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 10, 0, 7, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 10, 0, 8, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 9, 0, 9, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 11, 0, 9, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 8, 0, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 12, 0, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 7, 0, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 13, 0, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 9, 0, 11, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 11, 0, 11, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 10, 0, 12, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 10, 0, 13, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIllIll), 10, 0, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            for (int lllllllllllllIIIIlIIIIIllIIllIIl = 0; lllllllllllllIIIIlIIIIIllIIllIIl <= this.scatteredFeatureSizeX - 1; lllllllllllllIIIIlIIIIIllIIllIIl += this.scatteredFeatureSizeX - 1) {
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 2, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 2, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 2, 3, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 3, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 3, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 3, 3, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 4, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 4, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 4, 3, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 5, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 5, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 5, 3, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 6, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 6, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 6, 3, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 7, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 7, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIIl, 7, 3, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 8, 1, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 8, 2, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIIl, 8, 3, lllllllllllllIIIIlIIIIIllIIlIIIl);
            }
            for (int lllllllllllllIIIIlIIIIIllIIllIII = 2; lllllllllllllIIIIlIIIIIllIIllIII <= this.scatteredFeatureSizeX - 3; lllllllllllllIIIIlIIIIIllIIllIII += this.scatteredFeatureSizeX - 3 - 2) {
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII - 1, 2, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII, 2, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII + 1, 2, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII - 1, 3, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII, 3, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII + 1, 3, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII - 1, 4, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII, 4, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII + 1, 4, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII - 1, 5, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII, 5, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII + 1, 5, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII - 1, 6, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII, 6, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII + 1, 6, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII - 1, 7, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII, 7, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), lllllllllllllIIIIlIIIIIllIIllIII + 1, 7, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII - 1, 8, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII, 8, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
                this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), lllllllllllllIIIIlIIIIIllIIllIII + 1, 8, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
            }
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 8, 4, 0, 12, 6, 0, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 8, 6, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 12, 6, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 9, 5, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, 5, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(lllllllllllllIIIIlIIIIIllIIlllII), 11, 5, 0, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 8, -14, 8, 12, -11, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 8, -10, 8, 12, -10, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 8, -9, 8, 12, -9, 12, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 8, -8, 8, 12, -1, 12, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 9, -11, 9, 11, -1, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.STONE_PRESSURE_PLATE.getDefaultState(), 10, -11, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.fillWithBlocks(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, 9, -13, 9, 11, -13, 11, Blocks.TNT.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 8, -11, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 8, -10, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 7, -10, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 7, -11, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 12, -11, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 12, -10, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 13, -10, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 13, -11, 10, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 10, -11, 8, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 10, -10, 8, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, -10, 7, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, -11, 7, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 10, -11, 12, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.AIR.getDefaultState(), 10, -10, 12, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, -10, 13, lllllllllllllIIIIlIIIIIllIIlIIIl);
            this.setBlockState(lllllllllllllIIIIlIIIIIllIlIIlll, Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, -11, 13, lllllllllllllIIIIlIIIIIllIIlIIIl);
            for (final EnumFacing lllllllllllllIIIIlIIIIIllIIlIlll : EnumFacing.Plane.HORIZONTAL) {
                if (!this.hasPlacedChest[lllllllllllllIIIIlIIIIIllIIlIlll.getHorizontalIndex()]) {
                    final int lllllllllllllIIIIlIIIIIllIIlIllI = lllllllllllllIIIIlIIIIIllIIlIlll.getFrontOffsetX() * 2;
                    final int lllllllllllllIIIIlIIIIIllIIlIlIl = lllllllllllllIIIIlIIIIIllIIlIlll.getFrontOffsetZ() * 2;
                    this.hasPlacedChest[lllllllllllllIIIIlIIIIIllIIlIlll.getHorizontalIndex()] = this.generateChest(lllllllllllllIIIIlIIIIIllIlIIlll, lllllllllllllIIIIlIIIIIllIIlIIIl, lllllllllllllIIIIlIIIIIllIlIIllI, 10 + lllllllllllllIIIIlIIIIIllIIlIllI, -11, 10 + lllllllllllllIIIIlIIIIIllIIlIlIl, LootTableList.CHESTS_DESERT_PYRAMID);
                }
            }
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIIIlIIIIIlllIIIIlI) {
            super.writeStructureToNBT(lllllllllllllIIIIlIIIIIlllIIIIlI);
            lllllllllllllIIIIlIIIIIlllIIIIlI.setBoolean("hasPlacedChest0", this.hasPlacedChest[0]);
            lllllllllllllIIIIlIIIIIlllIIIIlI.setBoolean("hasPlacedChest1", this.hasPlacedChest[1]);
            lllllllllllllIIIIlIIIIIlllIIIIlI.setBoolean("hasPlacedChest2", this.hasPlacedChest[2]);
            lllllllllllllIIIIlIIIIIlllIIIIlI.setBoolean("hasPlacedChest3", this.hasPlacedChest[3]);
        }
        
        public DesertPyramid() {
            this.hasPlacedChest = new boolean[4];
        }
    }
    
    public static class Igloo extends Feature
    {
        private static final /* synthetic */ ResourceLocation IGLOO_BOTTOM_ID;
        private static final /* synthetic */ ResourceLocation IGLOO_MIDDLE_ID;
        private static final /* synthetic */ ResourceLocation IGLOO_TOP_ID;
        
        public Igloo() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIIlIlllIlIlllIIIl, final Random lllllllllllllIIIIlIlllIlIlllIIII, final StructureBoundingBox lllllllllllllIIIIlIlllIlIlIllIIl) {
            if (!this.offsetToAverageGroundLevel(lllllllllllllIIIIlIlllIlIlllIIIl, lllllllllllllIIIIlIlllIlIlIllIIl, -1)) {
                return false;
            }
            final StructureBoundingBox lllllllllllllIIIIlIlllIlIllIlllI = this.getBoundingBox();
            final BlockPos lllllllllllllIIIIlIlllIlIllIllIl = new BlockPos(lllllllllllllIIIIlIlllIlIllIlllI.minX, lllllllllllllIIIIlIlllIlIllIlllI.minY, lllllllllllllIIIIlIlllIlIllIlllI.minZ);
            final Rotation[] lllllllllllllIIIIlIlllIlIllIllII = Rotation.values();
            final MinecraftServer lllllllllllllIIIIlIlllIlIllIlIll = lllllllllllllIIIIlIlllIlIlllIIIl.getMinecraftServer();
            final TemplateManager lllllllllllllIIIIlIlllIlIllIlIlI = lllllllllllllIIIIlIlllIlIlllIIIl.getSaveHandler().getStructureTemplateManager();
            final PlacementSettings lllllllllllllIIIIlIlllIlIllIlIIl = new PlacementSettings().setRotation(lllllllllllllIIIIlIlllIlIllIllII[lllllllllllllIIIIlIlllIlIlllIIII.nextInt(lllllllllllllIIIIlIlllIlIllIllII.length)]).setReplacedBlock(Blocks.STRUCTURE_VOID).setBoundingBox(lllllllllllllIIIIlIlllIlIllIlllI);
            final Template lllllllllllllIIIIlIlllIlIllIlIII = lllllllllllllIIIIlIlllIlIllIlIlI.getTemplate(lllllllllllllIIIIlIlllIlIllIlIll, Igloo.IGLOO_TOP_ID);
            lllllllllllllIIIIlIlllIlIllIlIII.addBlocksToWorldChunk(lllllllllllllIIIIlIlllIlIlllIIIl, lllllllllllllIIIIlIlllIlIllIllIl, lllllllllllllIIIIlIlllIlIllIlIIl);
            if (lllllllllllllIIIIlIlllIlIlllIIII.nextDouble() < 0.5) {
                final Template lllllllllllllIIIIlIlllIlIllIIlll = lllllllllllllIIIIlIlllIlIllIlIlI.getTemplate(lllllllllllllIIIIlIlllIlIllIlIll, Igloo.IGLOO_MIDDLE_ID);
                final Template lllllllllllllIIIIlIlllIlIllIIllI = lllllllllllllIIIIlIlllIlIllIlIlI.getTemplate(lllllllllllllIIIIlIlllIlIllIlIll, Igloo.IGLOO_BOTTOM_ID);
                final int lllllllllllllIIIIlIlllIlIllIIlIl = lllllllllllllIIIIlIlllIlIlllIIII.nextInt(8) + 4;
                for (int lllllllllllllIIIIlIlllIlIllIIlII = 0; lllllllllllllIIIIlIlllIlIllIIlII < lllllllllllllIIIIlIlllIlIllIIlIl; ++lllllllllllllIIIIlIlllIlIllIIlII) {
                    final BlockPos lllllllllllllIIIIlIlllIlIllIIIll = lllllllllllllIIIIlIlllIlIllIlIII.calculateConnectedPos(lllllllllllllIIIIlIlllIlIllIlIIl, new BlockPos(3, -1 - lllllllllllllIIIIlIlllIlIllIIlII * 3, 5), lllllllllllllIIIIlIlllIlIllIlIIl, new BlockPos(1, 2, 1));
                    lllllllllllllIIIIlIlllIlIllIIlll.addBlocksToWorldChunk(lllllllllllllIIIIlIlllIlIlllIIIl, lllllllllllllIIIIlIlllIlIllIllIl.add(lllllllllllllIIIIlIlllIlIllIIIll), lllllllllllllIIIIlIlllIlIllIlIIl);
                }
                final BlockPos lllllllllllllIIIIlIlllIlIllIIIlI = lllllllllllllIIIIlIlllIlIllIllIl.add(lllllllllllllIIIIlIlllIlIllIlIII.calculateConnectedPos(lllllllllllllIIIIlIlllIlIllIlIIl, new BlockPos(3, -1 - lllllllllllllIIIIlIlllIlIllIIlIl * 3, 5), lllllllllllllIIIIlIlllIlIllIlIIl, new BlockPos(3, 5, 7)));
                lllllllllllllIIIIlIlllIlIllIIllI.addBlocksToWorldChunk(lllllllllllllIIIIlIlllIlIlllIIIl, lllllllllllllIIIIlIlllIlIllIIIlI, lllllllllllllIIIIlIlllIlIllIlIIl);
                final Map<BlockPos, String> lllllllllllllIIIIlIlllIlIllIIIIl = lllllllllllllIIIIlIlllIlIllIIllI.getDataBlocks(lllllllllllllIIIIlIlllIlIllIIIlI, lllllllllllllIIIIlIlllIlIllIlIIl);
                for (final Map.Entry<BlockPos, String> lllllllllllllIIIIlIlllIlIllIIIII : lllllllllllllIIIIlIlllIlIllIIIIl.entrySet()) {
                    if ("chest".equals(lllllllllllllIIIIlIlllIlIllIIIII.getValue())) {
                        final BlockPos lllllllllllllIIIIlIlllIlIlIlllll = lllllllllllllIIIIlIlllIlIllIIIII.getKey();
                        lllllllllllllIIIIlIlllIlIlllIIIl.setBlockState(lllllllllllllIIIIlIlllIlIlIlllll, Blocks.AIR.getDefaultState(), 3);
                        final TileEntity lllllllllllllIIIIlIlllIlIlIllllI = lllllllllllllIIIIlIlllIlIlllIIIl.getTileEntity(lllllllllllllIIIIlIlllIlIlIlllll.down());
                        if (!(lllllllllllllIIIIlIlllIlIlIllllI instanceof TileEntityChest)) {
                            continue;
                        }
                        ((TileEntityChest)lllllllllllllIIIIlIlllIlIlIllllI).setLootTable(LootTableList.CHESTS_IGLOO_CHEST, lllllllllllllIIIIlIlllIlIlllIIII.nextLong());
                    }
                }
            }
            else {
                final BlockPos lllllllllllllIIIIlIlllIlIlIlllIl = Template.transformedBlockPos(lllllllllllllIIIIlIlllIlIllIlIIl, new BlockPos(3, 0, 5));
                lllllllllllllIIIIlIlllIlIlllIIIl.setBlockState(lllllllllllllIIIIlIlllIlIllIllIl.add(lllllllllllllIIIIlIlllIlIlIlllIl), Blocks.SNOW.getDefaultState(), 3);
            }
            return true;
        }
        
        static {
            IGLOO_TOP_ID = new ResourceLocation("igloo/igloo_top");
            IGLOO_MIDDLE_ID = new ResourceLocation("igloo/igloo_middle");
            IGLOO_BOTTOM_ID = new ResourceLocation("igloo/igloo_bottom");
        }
        
        public Igloo(final Random lllllllllllllIIIIlIlllIllIIIllIl, final int lllllllllllllIIIIlIlllIllIIIlIII, final int lllllllllllllIIIIlIlllIllIIIIlll) {
            super(lllllllllllllIIIIlIlllIllIIIllIl, lllllllllllllIIIIlIlllIllIIIlIII, 64, lllllllllllllIIIIlIlllIllIIIIlll, 7, 5, 8);
        }
    }
}
