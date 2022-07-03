package net.minecraft.world.gen.structure;

import java.util.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import net.minecraft.block.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;

public class StructureMineshaftPieces
{
    private static Peice func_189938_b(final StructureComponent lllllllllllllIlllIIIIIllIlllIlII, final List<StructureComponent> lllllllllllllIlllIIIIIllIlllllIl, final Random lllllllllllllIlllIIIIIllIlllIIlI, final int lllllllllllllIlllIIIIIllIlllIIIl, final int lllllllllllllIlllIIIIIllIllllIlI, final int lllllllllllllIlllIIIIIllIllIllll, final EnumFacing lllllllllllllIlllIIIIIllIllIlllI, final int lllllllllllllIlllIIIIIllIlllIlll) {
        if (lllllllllllllIlllIIIIIllIlllIlll > 8) {
            return null;
        }
        if (Math.abs(lllllllllllllIlllIIIIIllIlllIIIl - lllllllllllllIlllIIIIIllIlllIlII.getBoundingBox().minX) <= 80 && Math.abs(lllllllllllllIlllIIIIIllIllIllll - lllllllllllllIlllIIIIIllIlllIlII.getBoundingBox().minZ) <= 80) {
            final MapGenMineshaft.Type lllllllllllllIlllIIIIIllIlllIllI = ((Peice)lllllllllllllIlllIIIIIllIlllIlII).mineShaftType;
            final Peice lllllllllllllIlllIIIIIllIlllIlIl = func_189940_a(lllllllllllllIlllIIIIIllIlllllIl, lllllllllllllIlllIIIIIllIlllIIlI, lllllllllllllIlllIIIIIllIlllIIIl, lllllllllllllIlllIIIIIllIllllIlI, lllllllllllllIlllIIIIIllIllIllll, lllllllllllllIlllIIIIIllIllIlllI, lllllllllllllIlllIIIIIllIlllIlll + 1, lllllllllllllIlllIIIIIllIlllIllI);
            if (lllllllllllllIlllIIIIIllIlllIlIl != null) {
                lllllllllllllIlllIIIIIllIlllllIl.add(lllllllllllllIlllIIIIIllIlllIlIl);
                lllllllllllllIlllIIIIIllIlllIlIl.buildComponent(lllllllllllllIlllIIIIIllIlllIlII, lllllllllllllIlllIIIIIllIlllllIl, lllllllllllllIlllIIIIIllIlllIIlI);
            }
            return lllllllllllllIlllIIIIIllIlllIlIl;
        }
        return null;
    }
    
    public static void registerStructurePieces() {
        MapGenStructureIO.registerStructureComponent(Corridor.class, "MSCorridor");
        MapGenStructureIO.registerStructureComponent(Cross.class, "MSCrossing");
        MapGenStructureIO.registerStructureComponent(Room.class, "MSRoom");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "MSStairs");
    }
    
    private static Peice func_189940_a(final List<StructureComponent> lllllllllllllIlllIIIIIlllIIllllI, final Random lllllllllllllIlllIIIIIlllIIlIIIl, final int lllllllllllllIlllIIIIIlllIIlllII, final int lllllllllllllIlllIIIIIlllIIllIll, final int lllllllllllllIlllIIIIIlllIIllIlI, @Nullable final EnumFacing lllllllllllllIlllIIIIIlllIIllIIl, final int lllllllllllllIlllIIIIIlllIIllIII, final MapGenMineshaft.Type lllllllllllllIlllIIIIIlllIIlIlll) {
        final int lllllllllllllIlllIIIIIlllIIlIllI = lllllllllllllIlllIIIIIlllIIlIIIl.nextInt(100);
        if (lllllllllllllIlllIIIIIlllIIlIllI >= 80) {
            final StructureBoundingBox lllllllllllllIlllIIIIIlllIIlIlIl = Cross.findCrossing(lllllllllllllIlllIIIIIlllIIllllI, lllllllllllllIlllIIIIIlllIIlIIIl, lllllllllllllIlllIIIIIlllIIlllII, lllllllllllllIlllIIIIIlllIIllIll, lllllllllllllIlllIIIIIlllIIllIlI, lllllllllllllIlllIIIIIlllIIllIIl);
            if (lllllllllllllIlllIIIIIlllIIlIlIl != null) {
                return new Cross(lllllllllllllIlllIIIIIlllIIllIII, lllllllllllllIlllIIIIIlllIIlIIIl, lllllllllllllIlllIIIIIlllIIlIlIl, lllllllllllllIlllIIIIIlllIIllIIl, lllllllllllllIlllIIIIIlllIIlIlll);
            }
        }
        else if (lllllllllllllIlllIIIIIlllIIlIllI >= 70) {
            final StructureBoundingBox lllllllllllllIlllIIIIIlllIIlIlII = Stairs.findStairs(lllllllllllllIlllIIIIIlllIIllllI, lllllllllllllIlllIIIIIlllIIlIIIl, lllllllllllllIlllIIIIIlllIIlllII, lllllllllllllIlllIIIIIlllIIllIll, lllllllllllllIlllIIIIIlllIIllIlI, lllllllllllllIlllIIIIIlllIIllIIl);
            if (lllllllllllllIlllIIIIIlllIIlIlII != null) {
                return new Stairs(lllllllllllllIlllIIIIIlllIIllIII, lllllllllllllIlllIIIIIlllIIlIIIl, lllllllllllllIlllIIIIIlllIIlIlII, lllllllllllllIlllIIIIIlllIIllIIl, lllllllllllllIlllIIIIIlllIIlIlll);
            }
        }
        else {
            final StructureBoundingBox lllllllllllllIlllIIIIIlllIIlIIll = Corridor.findCorridorSize(lllllllllllllIlllIIIIIlllIIllllI, lllllllllllllIlllIIIIIlllIIlIIIl, lllllllllllllIlllIIIIIlllIIlllII, lllllllllllllIlllIIIIIlllIIllIll, lllllllllllllIlllIIIIIlllIIllIlI, lllllllllllllIlllIIIIIlllIIllIIl);
            if (lllllllllllllIlllIIIIIlllIIlIIll != null) {
                return new Corridor(lllllllllllllIlllIIIIIlllIIllIII, lllllllllllllIlllIIIIIlllIIlIIIl, lllllllllllllIlllIIIIIlllIIlIIll, lllllllllllllIlllIIIIIlllIIllIIl, lllllllllllllIlllIIIIIlllIIlIlll);
            }
        }
        return null;
    }
    
    public static class Cross extends Peice
    {
        private /* synthetic */ boolean isMultipleFloors;
        private /* synthetic */ EnumFacing corridorDirection;
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIIIIIllllIlIlIlI, final Random llllllllllllllIlIIIIIllllIlIlIIl, final StructureBoundingBox llllllllllllllIlIIIIIllllIlIIIlI) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI)) {
                return false;
            }
            final IBlockState llllllllllllllIlIIIIIllllIlIIlll = this.func_189917_F_();
            if (this.isMultipleFloors) {
                this.fillWithBlocks(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ - 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX + 1, this.boundingBox.maxY - 2, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX, this.boundingBox.maxY - 2, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY + 3, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.minY + 3, this.boundingBox.maxZ - 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            else {
                this.fillWithBlocks(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            this.func_189923_b(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxY);
            this.func_189923_b(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxY);
            this.func_189923_b(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxY);
            this.func_189923_b(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIIlI, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxY);
            for (int llllllllllllllIlIIIIIllllIlIIllI = this.boundingBox.minX; llllllllllllllIlIIIIIllllIlIIllI <= this.boundingBox.maxX; ++llllllllllllllIlIIIIIllllIlIIllI) {
                for (int llllllllllllllIlIIIIIllllIlIIlIl = this.boundingBox.minZ; llllllllllllllIlIIIIIllllIlIIlIl <= this.boundingBox.maxZ; ++llllllllllllllIlIIIIIllllIlIIlIl) {
                    if (this.getBlockStateFromPos(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIllI, this.boundingBox.minY - 1, llllllllllllllIlIIIIIllllIlIIlIl, llllllllllllllIlIIIIIllllIlIIIlI).getMaterial() == Material.AIR && this.func_189916_b(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIllI, this.boundingBox.minY - 1, llllllllllllllIlIIIIIllllIlIIlIl, llllllllllllllIlIIIIIllllIlIIIlI) < 8) {
                        this.setBlockState(llllllllllllllIlIIIIIllllIlIlIlI, llllllllllllllIlIIIIIllllIlIIlll, llllllllllllllIlIIIIIllllIlIIllI, this.boundingBox.minY - 1, llllllllllllllIlIIIIIllllIlIIlIl, llllllllllllllIlIIIIIllllIlIIIlI);
                    }
                }
            }
            return true;
        }
        
        private void func_189923_b(final World llllllllllllllIlIIIIIllllIIIllll, final StructureBoundingBox llllllllllllllIlIIIIIllllIIIlllI, final int llllllllllllllIlIIIIIllllIIlIlII, final int llllllllllllllIlIIIIIllllIIlIIll, final int llllllllllllllIlIIIIIllllIIlIIlI, final int llllllllllllllIlIIIIIllllIIIlIlI) {
            if (this.getBlockStateFromPos(llllllllllllllIlIIIIIllllIIIllll, llllllllllllllIlIIIIIllllIIlIlII, llllllllllllllIlIIIIIllllIIIlIlI + 1, llllllllllllllIlIIIIIllllIIlIIlI, llllllllllllllIlIIIIIllllIIIlllI).getMaterial() != Material.AIR) {
                this.fillWithBlocks(llllllllllllllIlIIIIIllllIIIllll, llllllllllllllIlIIIIIllllIIIlllI, llllllllllllllIlIIIIIllllIIlIlII, llllllllllllllIlIIIIIllllIIlIIll, llllllllllllllIlIIIIIllllIIlIIlI, llllllllllllllIlIIIIIllllIIlIlII, llllllllllllllIlIIIIIllllIIIlIlI, llllllllllllllIlIIIIIllllIIlIIlI, this.func_189917_F_(), Blocks.AIR.getDefaultState(), false);
            }
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Cross.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final long llllllllllllllIlIIIIIllllIIIlIII = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllllllIlIIIIIllllIIIlIII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllIlIIIIIllllIIIlIII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllllIlIIIIIllllIIIlIII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllllIlIIIIIllllIIIlIII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllllllIlIIIIIllllIIIlIII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllllllIlIIIIIllllIIIlIII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Cross.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIlIIIIIllllIIIlIII;
        }
        
        public Cross() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIIIIIllllIllIlIl, final List<StructureComponent> llllllllllllllIlIIIIIllllIllIlII, final Random llllllllllllllIlIIIIIllllIllIIll) {
            final int llllllllllllllIlIIIIIllllIllIlll = this.getComponentType();
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.corridorDirection.ordinal()]) {
                default: {
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllllIlIIIIIllllIllIlll);
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, llllllllllllllIlIIIIIllllIllIlll);
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, llllllllllllllIlIIIIIllllIllIlll);
                    break;
                }
                case 4: {
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllllIlIIIIIllllIllIlll);
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, llllllllllllllIlIIIIIllllIllIlll);
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, llllllllllllllIlIIIIIllllIllIlll);
                    break;
                }
                case 5: {
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllllIlIIIIIllllIllIlll);
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllllIlIIIIIllllIllIlll);
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, llllllllllllllIlIIIIIllllIllIlll);
                    break;
                }
                case 6: {
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllllIlIIIIIllllIllIlll);
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllllIlIIIIIllllIllIlll);
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, llllllllllllllIlIIIIIllllIllIlll);
                    break;
                }
            }
            if (this.isMultipleFloors) {
                if (llllllllllllllIlIIIIIllllIllIIll.nextBoolean()) {
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllllIlIIIIIllllIllIlll);
                }
                if (llllllllllllllIlIIIIIllllIllIIll.nextBoolean()) {
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX - 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, EnumFacing.WEST, llllllllllllllIlIIIIIllllIllIlll);
                }
                if (llllllllllllllIlIIIIIllllIllIIll.nextBoolean()) {
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.maxX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, EnumFacing.EAST, llllllllllllllIlIIIIIllllIllIlll);
                }
                if (llllllllllllllIlIIIIIllllIllIIll.nextBoolean()) {
                    func_189938_b(llllllllllllllIlIIIIIllllIllIlIl, llllllllllllllIlIIIIIllllIllIlII, llllllllllllllIlIIIIIllllIllIIll, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllllIlIIIIIllllIllIlll);
                }
            }
        }
        
        public Cross(final int llllllllllllllIlIIIIIlllllIllIIl, final Random llllllllllllllIlIIIIIlllllIllllI, final StructureBoundingBox llllllllllllllIlIIIIIlllllIlllIl, @Nullable final EnumFacing llllllllllllllIlIIIIIlllllIlllII, final MapGenMineshaft.Type llllllllllllllIlIIIIIlllllIlIllI) {
            super(llllllllllllllIlIIIIIlllllIllIIl, llllllllllllllIlIIIIIlllllIlIllI);
            this.corridorDirection = llllllllllllllIlIIIIIlllllIlllII;
            this.boundingBox = llllllllllllllIlIIIIIlllllIlllIl;
            this.isMultipleFloors = (llllllllllllllIlIIIIIlllllIlllIl.getYSize() > 3);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlIIIIIllllllIllll) {
            super.writeStructureToNBT(llllllllllllllIlIIIIIllllllIllll);
            llllllllllllllIlIIIIIllllllIllll.setBoolean("tf", this.isMultipleFloors);
            llllllllllllllIlIIIIIllllllIllll.setInteger("D", this.corridorDirection.getHorizontalIndex());
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlIIIIIllllllIlIlI, final TemplateManager llllllllllllllIlIIIIIllllllIIllI) {
            super.readStructureFromNBT(llllllllllllllIlIIIIIllllllIlIlI, llllllllllllllIlIIIIIllllllIIllI);
            this.isMultipleFloors = llllllllllllllIlIIIIIllllllIlIlI.getBoolean("tf");
            this.corridorDirection = EnumFacing.getHorizontal(llllllllllllllIlIIIIIllllllIlIlI.getInteger("D"));
        }
        
        public static StructureBoundingBox findCrossing(final List<StructureComponent> llllllllllllllIlIIIIIlllllIIlllI, final Random llllllllllllllIlIIIIIlllllIIllIl, final int llllllllllllllIlIIIIIlllllIIllII, final int llllllllllllllIlIIIIIlllllIIIlII, final int llllllllllllllIlIIIIIlllllIIlIlI, final EnumFacing llllllllllllllIlIIIIIlllllIIIIlI) {
            final StructureBoundingBox llllllllllllllIlIIIIIlllllIIlIII = new StructureBoundingBox(llllllllllllllIlIIIIIlllllIIllII, llllllllllllllIlIIIIIlllllIIIlII, llllllllllllllIlIIIIIlllllIIlIlI, llllllllllllllIlIIIIIlllllIIllII, llllllllllllllIlIIIIIlllllIIIlII + 2, llllllllllllllIlIIIIIlllllIIlIlI);
            if (llllllllllllllIlIIIIIlllllIIllIl.nextInt(4) == 0) {
                final StructureBoundingBox structureBoundingBox = llllllllllllllIlIIIIIlllllIIlIII;
                structureBoundingBox.maxY += 4;
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIlIIIIIlllllIIIIlI.ordinal()]) {
                default: {
                    llllllllllllllIlIIIIIlllllIIlIII.minX = llllllllllllllIlIIIIIlllllIIllII - 1;
                    llllllllllllllIlIIIIIlllllIIlIII.maxX = llllllllllllllIlIIIIIlllllIIllII + 3;
                    llllllllllllllIlIIIIIlllllIIlIII.minZ = llllllllllllllIlIIIIIlllllIIlIlI - 4;
                    break;
                }
                case 4: {
                    llllllllllllllIlIIIIIlllllIIlIII.minX = llllllllllllllIlIIIIIlllllIIllII - 1;
                    llllllllllllllIlIIIIIlllllIIlIII.maxX = llllllllllllllIlIIIIIlllllIIllII + 3;
                    llllllllllllllIlIIIIIlllllIIlIII.maxZ = llllllllllllllIlIIIIIlllllIIlIlI + 3 + 1;
                    break;
                }
                case 5: {
                    llllllllllllllIlIIIIIlllllIIlIII.minX = llllllllllllllIlIIIIIlllllIIllII - 4;
                    llllllllllllllIlIIIIIlllllIIlIII.minZ = llllllllllllllIlIIIIIlllllIIlIlI - 1;
                    llllllllllllllIlIIIIIlllllIIlIII.maxZ = llllllllllllllIlIIIIIlllllIIlIlI + 3;
                    break;
                }
                case 6: {
                    llllllllllllllIlIIIIIlllllIIlIII.maxX = llllllllllllllIlIIIIIlllllIIllII + 3 + 1;
                    llllllllllllllIlIIIIIlllllIIlIII.minZ = llllllllllllllIlIIIIIlllllIIlIlI - 1;
                    llllllllllllllIlIIIIIlllllIIlIII.maxZ = llllllllllllllIlIIIIIlllllIIlIlI + 3;
                    break;
                }
            }
            return (StructureComponent.findIntersecting(llllllllllllllIlIIIIIlllllIIlllI, llllllllllllllIlIIIIIlllllIIlIII) != null) ? null : llllllllllllllIlIIIIIlllllIIlIII;
        }
    }
    
    abstract static class Peice extends StructureComponent
    {
        protected /* synthetic */ MapGenMineshaft.Type mineShaftType;
        
        protected boolean func_189918_a(final World llllllllllllllIllIIIllIIIlIIllII, final StructureBoundingBox llllllllllllllIllIIIllIIIlIIIIll, final int llllllllllllllIllIIIllIIIlIIIIlI, final int llllllllllllllIllIIIllIIIlIIlIIl, final int llllllllllllllIllIIIllIIIlIIlIII, final int llllllllllllllIllIIIllIIIIllllll) {
            for (int llllllllllllllIllIIIllIIIlIIIllI = llllllllllllllIllIIIllIIIlIIIIlI; llllllllllllllIllIIIllIIIlIIIllI <= llllllllllllllIllIIIllIIIlIIlIIl; ++llllllllllllllIllIIIllIIIlIIIllI) {
                if (this.getBlockStateFromPos(llllllllllllllIllIIIllIIIlIIllII, llllllllllllllIllIIIllIIIlIIIllI, llllllllllllllIllIIIllIIIlIIlIII + 1, llllllllllllllIllIIIllIIIIllllll, llllllllllllllIllIIIllIIIlIIIIll).getMaterial() == Material.AIR) {
                    return false;
                }
            }
            return true;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type() {
            final int[] $switch_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type = Peice.$SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type;
            if ($switch_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type != null) {
                return $switch_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type;
            }
            final boolean llllllllllllllIllIIIllIIIIllllII = (Object)new int[MapGenMineshaft.Type.values().length];
            try {
                llllllllllllllIllIIIllIIIIllllII[MapGenMineshaft.Type.MESA.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllIllIIIllIIIIllllII[MapGenMineshaft.Type.NORMAL.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            return Peice.$SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type = (int[])(Object)llllllllllllllIllIIIllIIIIllllII;
        }
        
        public Peice(final int llllllllllllllIllIIIllIIIllIllIl, final MapGenMineshaft.Type llllllllllllllIllIIIllIIIllIlIIl) {
            super(llllllllllllllIllIIIllIIIllIllIl);
            this.mineShaftType = llllllllllllllIllIIIllIIIllIlIIl;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIllIIIllIIIlIlllII, final TemplateManager llllllllllllllIllIIIllIIIlIllllI) {
            this.mineShaftType = MapGenMineshaft.Type.byId(llllllllllllllIllIIIllIIIlIlllII.getInteger("MST"));
        }
        
        protected IBlockState func_189917_F_() {
            switch ($SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type()[this.mineShaftType.ordinal()]) {
                default: {
                    return Blocks.PLANKS.getDefaultState();
                }
                case 2: {
                    return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK);
                }
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIllIIIllIIIllIIlIl) {
            llllllllllllllIllIIIllIIIllIIlIl.setInteger("MST", this.mineShaftType.ordinal());
        }
        
        public Peice() {
        }
        
        protected IBlockState func_189919_b() {
            switch ($SWITCH_TABLE$net$minecraft$world$gen$structure$MapGenMineshaft$Type()[this.mineShaftType.ordinal()]) {
                default: {
                    return Blocks.OAK_FENCE.getDefaultState();
                }
                case 2: {
                    return Blocks.DARK_OAK_FENCE.getDefaultState();
                }
            }
        }
    }
    
    public static class Corridor extends Peice
    {
        private /* synthetic */ int sectionCount;
        private /* synthetic */ boolean spawnerPlaced;
        private /* synthetic */ boolean hasRails;
        private /* synthetic */ boolean hasSpiders;
        
        public Corridor() {
        }
        
        @Override
        protected boolean generateChest(final World lllllllllllllIlIlllllIIlIIIlIlIl, final StructureBoundingBox lllllllllllllIlIlllllIIlIIIIlIIl, final Random lllllllllllllIlIlllllIIlIIIIlIII, final int lllllllllllllIlIlllllIIlIIIIIlll, final int lllllllllllllIlIlllllIIlIIIIIllI, final int lllllllllllllIlIlllllIIlIIIIIlIl, final ResourceLocation lllllllllllllIlIlllllIIlIIIIIlII) {
            final BlockPos lllllllllllllIlIlllllIIlIIIIlllI = new BlockPos(this.getXWithOffset(lllllllllllllIlIlllllIIlIIIIIlll, lllllllllllllIlIlllllIIlIIIIIlIl), this.getYWithOffset(lllllllllllllIlIlllllIIlIIIIIllI), this.getZWithOffset(lllllllllllllIlIlllllIIlIIIIIlll, lllllllllllllIlIlllllIIlIIIIIlIl));
            if (lllllllllllllIlIlllllIIlIIIIlIIl.isVecInside(lllllllllllllIlIlllllIIlIIIIlllI) && lllllllllllllIlIlllllIIlIIIlIlIl.getBlockState(lllllllllllllIlIlllllIIlIIIIlllI).getMaterial() == Material.AIR && lllllllllllllIlIlllllIIlIIIlIlIl.getBlockState(lllllllllllllIlIlllllIIlIIIIlllI.down()).getMaterial() != Material.AIR) {
                final IBlockState lllllllllllllIlIlllllIIlIIIIllIl = Blocks.RAIL.getDefaultState().withProperty(BlockRail.SHAPE, lllllllllllllIlIlllllIIlIIIIlIII.nextBoolean() ? BlockRailBase.EnumRailDirection.NORTH_SOUTH : BlockRailBase.EnumRailDirection.EAST_WEST);
                this.setBlockState(lllllllllllllIlIlllllIIlIIIlIlIl, lllllllllllllIlIlllllIIlIIIIllIl, lllllllllllllIlIlllllIIlIIIIIlll, lllllllllllllIlIlllllIIlIIIIIllI, lllllllllllllIlIlllllIIlIIIIIlIl, lllllllllllllIlIlllllIIlIIIIlIIl);
                final EntityMinecartChest lllllllllllllIlIlllllIIlIIIIllII = new EntityMinecartChest(lllllllllllllIlIlllllIIlIIIlIlIl, lllllllllllllIlIlllllIIlIIIIlllI.getX() + 0.5f, lllllllllllllIlIlllllIIlIIIIlllI.getY() + 0.5f, lllllllllllllIlIlllllIIlIIIIlllI.getZ() + 0.5f);
                lllllllllllllIlIlllllIIlIIIIllII.setLootTable(lllllllllllllIlIlllllIIlIIIIIlII, lllllllllllllIlIlllllIIlIIIIlIII.nextLong());
                lllllllllllllIlIlllllIIlIIIlIlIl.spawnEntityInWorld(lllllllllllllIlIlllllIIlIIIIllII);
                return true;
            }
            return false;
        }
        
        private void func_189921_a(final World lllllllllllllIlIlllllIIIlIllIlII, final StructureBoundingBox lllllllllllllIlIlllllIIIlIlIIlll, final int lllllllllllllIlIlllllIIIlIlIIllI, final int lllllllllllllIlIlllllIIIlIlIIlIl, final int lllllllllllllIlIlllllIIIlIlIIlII, final int lllllllllllllIlIlllllIIIlIlIIIll, final int lllllllllllllIlIlllllIIIlIlIIIlI, final Random lllllllllllllIlIlllllIIIlIlIllIl) {
            if (this.func_189918_a(lllllllllllllIlIlllllIIIlIllIlII, lllllllllllllIlIlllllIIIlIlIIlll, lllllllllllllIlIlllllIIIlIlIIllI, lllllllllllllIlIlllllIIIlIlIIIlI, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII)) {
                final IBlockState lllllllllllllIlIlllllIIIlIlIllII = this.func_189917_F_();
                final IBlockState lllllllllllllIlIlllllIIIlIlIlIll = this.func_189919_b();
                final IBlockState lllllllllllllIlIlllllIIIlIlIlIlI = Blocks.AIR.getDefaultState();
                this.fillWithBlocks(lllllllllllllIlIlllllIIIlIllIlII, lllllllllllllIlIlllllIIIlIlIIlll, lllllllllllllIlIlllllIIIlIlIIllI, lllllllllllllIlIlllllIIIlIlIIlIl, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIIllI, lllllllllllllIlIlllllIIIlIlIIIll - 1, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIlIll, lllllllllllllIlIlllllIIIlIlIlIlI, false);
                this.fillWithBlocks(lllllllllllllIlIlllllIIIlIllIlII, lllllllllllllIlIlllllIIIlIlIIlll, lllllllllllllIlIlllllIIIlIlIIIlI, lllllllllllllIlIlllllIIIlIlIIlIl, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIIIlI, lllllllllllllIlIlllllIIIlIlIIIll - 1, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIlIll, lllllllllllllIlIlllllIIIlIlIlIlI, false);
                if (lllllllllllllIlIlllllIIIlIlIllIl.nextInt(4) == 0) {
                    this.fillWithBlocks(lllllllllllllIlIlllllIIIlIllIlII, lllllllllllllIlIlllllIIIlIlIIlll, lllllllllllllIlIlllllIIIlIlIIllI, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIIllI, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIllII, lllllllllllllIlIlllllIIIlIlIlIlI, false);
                    this.fillWithBlocks(lllllllllllllIlIlllllIIIlIllIlII, lllllllllllllIlIlllllIIIlIlIIlll, lllllllllllllIlIlllllIIIlIlIIIlI, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIIIlI, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIllII, lllllllllllllIlIlllllIIIlIlIlIlI, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllllIlIlllllIIIlIllIlII, lllllllllllllIlIlllllIIIlIlIIlll, lllllllllllllIlIlllllIIIlIlIIllI, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIIIlI, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII, lllllllllllllIlIlllllIIIlIlIllII, lllllllllllllIlIlllllIIIlIlIlIlI, false);
                    this.randomlyPlaceBlock(lllllllllllllIlIlllllIIIlIllIlII, lllllllllllllIlIlllllIIIlIlIIlll, lllllllllllllIlIlllllIIIlIlIllIl, 0.05f, lllllllllllllIlIlllllIIIlIlIIllI + 1, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII - 1, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.NORTH));
                    this.randomlyPlaceBlock(lllllllllllllIlIlllllIIIlIllIlII, lllllllllllllIlIlllllIIIlIlIIlll, lllllllllllllIlIlllllIIIlIlIllIl, 0.05f, lllllllllllllIlIlllllIIIlIlIIllI + 1, lllllllllllllIlIlllllIIIlIlIIIll, lllllllllllllIlIlllllIIIlIlIIlII + 1, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.SOUTH));
                }
            }
        }
        
        public Corridor(final int lllllllllllllIlIlllllIIlIllIIlII, final Random lllllllllllllIlIlllllIIlIllIIIll, final StructureBoundingBox lllllllllllllIlIlllllIIlIlIlllII, final EnumFacing lllllllllllllIlIlllllIIlIlIllIll, final MapGenMineshaft.Type lllllllllllllIlIlllllIIlIlIllIlI) {
            super(lllllllllllllIlIlllllIIlIllIIlII, lllllllllllllIlIlllllIIlIlIllIlI);
            this.setCoordBaseMode(lllllllllllllIlIlllllIIlIlIllIll);
            this.boundingBox = lllllllllllllIlIlllllIIlIlIlllII;
            this.hasRails = (lllllllllllllIlIlllllIIlIllIIIll.nextInt(3) == 0);
            this.hasSpiders = (!this.hasRails && lllllllllllllIlIlllllIIlIllIIIll.nextInt(23) == 0);
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.sectionCount = lllllllllllllIlIlllllIIlIlIlllII.getZSize() / 5;
            }
            else {
                this.sectionCount = lllllllllllllIlIlllllIIlIlIlllII.getXSize() / 5;
            }
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Corridor.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final Exception lllllllllllllIlIlllllIIIlIIIIlII = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllllIlIlllllIIIlIIIIlII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIlIlllllIIIlIIIIlII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIlIlllllIIIlIIIIlII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIlIlllllIIIlIIIIlII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIlIlllllIIIlIIIIlII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIlIlllllIIIlIIIIlII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Corridor.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlIlllllIIIlIIIIlII;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIlIlllllIIlIIlIlIIl, final List<StructureComponent> lllllllllllllIlIlllllIIlIIllIIll, final Random lllllllllllllIlIlllllIIlIIllIIlI) {
            final int lllllllllllllIlIlllllIIlIIllIIIl = this.getComponentType();
            final int lllllllllllllIlIlllllIIlIIllIIII = lllllllllllllIlIlllllIIlIIllIIlI.nextInt(4);
            final EnumFacing lllllllllllllIlIlllllIIlIIlIllll = this.getCoordBaseMode();
            if (lllllllllllllIlIlllllIIlIIlIllll != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIlllllIIlIIlIllll.ordinal()]) {
                    default: {
                        if (lllllllllllllIlIlllllIIlIIllIIII <= 1) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.minZ - 1, lllllllllllllIlIlllllIIlIIlIllll, lllllllllllllIlIlllllIIlIIllIIIl);
                            break;
                        }
                        if (lllllllllllllIlIlllllIIlIIllIIII == 2) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.minZ, EnumFacing.WEST, lllllllllllllIlIlllllIIlIIllIIIl);
                            break;
                        }
                        func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.minZ, EnumFacing.EAST, lllllllllllllIlIlllllIIlIIllIIIl);
                        break;
                    }
                    case 4: {
                        if (lllllllllllllIlIlllllIIlIIllIIII <= 1) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.maxZ + 1, lllllllllllllIlIlllllIIlIIlIllll, lllllllllllllIlIlllllIIlIIllIIIl);
                            break;
                        }
                        if (lllllllllllllIlIlllllIIlIIllIIII == 2) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.maxZ - 3, EnumFacing.WEST, lllllllllllllIlIlllllIIlIIllIIIl);
                            break;
                        }
                        func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.maxZ - 3, EnumFacing.EAST, lllllllllllllIlIlllllIIlIIllIIIl);
                        break;
                    }
                    case 5: {
                        if (lllllllllllllIlIlllllIIlIIllIIII <= 1) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.minZ, lllllllllllllIlIlllllIIlIIlIllll, lllllllllllllIlIlllllIIlIIllIIIl);
                            break;
                        }
                        if (lllllllllllllIlIlllllIIlIIllIIII == 2) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllIlIlllllIIlIIllIIIl);
                            break;
                        }
                        func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.minX, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllIlIlllllIIlIIllIIIl);
                        break;
                    }
                    case 6: {
                        if (lllllllllllllIlIlllllIIlIIllIIII <= 1) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.minZ, lllllllllllllIlIlllllIIlIIlIllll, lllllllllllllIlIlllllIIlIIllIIIl);
                            break;
                        }
                        if (lllllllllllllIlIlllllIIlIIllIIII == 2) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllIlIlllllIIlIIllIIIl);
                            break;
                        }
                        func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + lllllllllllllIlIlllllIIlIIllIIlI.nextInt(3), this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllIlIlllllIIlIIllIIIl);
                        break;
                    }
                }
            }
            if (lllllllllllllIlIlllllIIlIIllIIIl < 8) {
                if (lllllllllllllIlIlllllIIlIIlIllll != EnumFacing.NORTH && lllllllllllllIlIlllllIIlIIlIllll != EnumFacing.SOUTH) {
                    for (int lllllllllllllIlIlllllIIlIIlIlllI = this.boundingBox.minX + 3; lllllllllllllIlIlllllIIlIIlIlllI + 3 <= this.boundingBox.maxX; lllllllllllllIlIlllllIIlIIlIlllI += 5) {
                        final int lllllllllllllIlIlllllIIlIIlIllIl = lllllllllllllIlIlllllIIlIIllIIlI.nextInt(5);
                        if (lllllllllllllIlIlllllIIlIIlIllIl == 0) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, lllllllllllllIlIlllllIIlIIlIlllI, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, lllllllllllllIlIlllllIIlIIllIIIl + 1);
                        }
                        else if (lllllllllllllIlIlllllIIlIIlIllIl == 1) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, lllllllllllllIlIlllllIIlIIlIlllI, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, lllllllllllllIlIlllllIIlIIllIIIl + 1);
                        }
                    }
                }
                else {
                    for (int lllllllllllllIlIlllllIIlIIlIllII = this.boundingBox.minZ + 3; lllllllllllllIlIlllllIIlIIlIllII + 3 <= this.boundingBox.maxZ; lllllllllllllIlIlllllIIlIIlIllII += 5) {
                        final int lllllllllllllIlIlllllIIlIIlIlIll = lllllllllllllIlIlllllIIlIIllIIlI.nextInt(5);
                        if (lllllllllllllIlIlllllIIlIIlIlIll == 0) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.minX - 1, this.boundingBox.minY, lllllllllllllIlIlllllIIlIIlIllII, EnumFacing.WEST, lllllllllllllIlIlllllIIlIIllIIIl + 1);
                        }
                        else if (lllllllllllllIlIlllllIIlIIlIlIll == 1) {
                            func_189938_b(lllllllllllllIlIlllllIIlIIlIlIIl, lllllllllllllIlIlllllIIlIIllIIll, lllllllllllllIlIlllllIIlIIllIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY, lllllllllllllIlIlllllIIlIIlIllII, EnumFacing.EAST, lllllllllllllIlIlllllIIlIIllIIIl + 1);
                        }
                    }
                }
            }
        }
        
        public static StructureBoundingBox findCorridorSize(final List<StructureComponent> lllllllllllllIlIlllllIIlIlIlIIII, final Random lllllllllllllIlIlllllIIlIlIIllll, final int lllllllllllllIlIlllllIIlIlIIIlIl, final int lllllllllllllIlIlllllIIlIlIIIlII, final int lllllllllllllIlIlllllIIlIlIIllII, final EnumFacing lllllllllllllIlIlllllIIlIlIIIIlI) {
            final StructureBoundingBox lllllllllllllIlIlllllIIlIlIIlIlI = new StructureBoundingBox(lllllllllllllIlIlllllIIlIlIIIlIl, lllllllllllllIlIlllllIIlIlIIIlII, lllllllllllllIlIlllllIIlIlIIllII, lllllllllllllIlIlllllIIlIlIIIlIl, lllllllllllllIlIlllllIIlIlIIIlII + 2, lllllllllllllIlIlllllIIlIlIIllII);
            int lllllllllllllIlIlllllIIlIlIIlIIl;
            for (lllllllllllllIlIlllllIIlIlIIlIIl = lllllllllllllIlIlllllIIlIlIIllll.nextInt(3) + 2; lllllllllllllIlIlllllIIlIlIIlIIl > 0; --lllllllllllllIlIlllllIIlIlIIlIIl) {
                final int lllllllllllllIlIlllllIIlIlIIlIII = lllllllllllllIlIlllllIIlIlIIlIIl * 5;
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIlllllIIlIlIIIIlI.ordinal()]) {
                    default: {
                        lllllllllllllIlIlllllIIlIlIIlIlI.maxX = lllllllllllllIlIlllllIIlIlIIIlIl + 2;
                        lllllllllllllIlIlllllIIlIlIIlIlI.minZ = lllllllllllllIlIlllllIIlIlIIllII - (lllllllllllllIlIlllllIIlIlIIlIII - 1);
                        break;
                    }
                    case 4: {
                        lllllllllllllIlIlllllIIlIlIIlIlI.maxX = lllllllllllllIlIlllllIIlIlIIIlIl + 2;
                        lllllllllllllIlIlllllIIlIlIIlIlI.maxZ = lllllllllllllIlIlllllIIlIlIIllII + (lllllllllllllIlIlllllIIlIlIIlIII - 1);
                        break;
                    }
                    case 5: {
                        lllllllllllllIlIlllllIIlIlIIlIlI.minX = lllllllllllllIlIlllllIIlIlIIIlIl - (lllllllllllllIlIlllllIIlIlIIlIII - 1);
                        lllllllllllllIlIlllllIIlIlIIlIlI.maxZ = lllllllllllllIlIlllllIIlIlIIllII + 2;
                        break;
                    }
                    case 6: {
                        lllllllllllllIlIlllllIIlIlIIlIlI.maxX = lllllllllllllIlIlllllIIlIlIIIlIl + (lllllllllllllIlIlllllIIlIlIIlIII - 1);
                        lllllllllllllIlIlllllIIlIlIIlIlI.maxZ = lllllllllllllIlIlllllIIlIlIIllII + 2;
                        break;
                    }
                }
                if (StructureComponent.findIntersecting(lllllllllllllIlIlllllIIlIlIlIIII, lllllllllllllIlIlllllIIlIlIIlIlI) == null) {
                    break;
                }
            }
            return (lllllllllllllIlIlllllIIlIlIIlIIl > 0) ? lllllllllllllIlIlllllIIlIlIIlIlI : null;
        }
        
        private void func_189922_a(final World lllllllllllllIlIlllllIIIlIIlIlII, final StructureBoundingBox lllllllllllllIlIlllllIIIlIIIlIll, final Random lllllllllllllIlIlllllIIIlIIIlIlI, final float lllllllllllllIlIlllllIIIlIIlIIIl, final int lllllllllllllIlIlllllIIIlIIlIIII, final int lllllllllllllIlIlllllIIIlIIIllll, final int lllllllllllllIlIlllllIIIlIIIIllI) {
            if (this.func_189916_b(lllllllllllllIlIlllllIIIlIIlIlII, lllllllllllllIlIlllllIIIlIIlIIII, lllllllllllllIlIlllllIIIlIIIllll, lllllllllllllIlIlllllIIIlIIIIllI, lllllllllllllIlIlllllIIIlIIIlIll) < 8) {
                this.randomlyPlaceBlock(lllllllllllllIlIlllllIIIlIIlIlII, lllllllllllllIlIlllllIIIlIIIlIll, lllllllllllllIlIlllllIIIlIIIlIlI, lllllllllllllIlIlllllIIIlIIlIIIl, lllllllllllllIlIlllllIIIlIIlIIII, lllllllllllllIlIlllllIIIlIIIllll, lllllllllllllIlIlllllIIIlIIIIllI, Blocks.WEB.getDefaultState());
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIlIlllllIIIllIlIIlI, final Random lllllllllllllIlIlllllIIIlllIllII, final StructureBoundingBox lllllllllllllIlIlllllIIIlllIlIll) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll)) {
                return false;
            }
            final int lllllllllllllIlIlllllIIIlllIlIlI = 0;
            final int lllllllllllllIlIlllllIIIlllIlIIl = 2;
            final int lllllllllllllIlIlllllIIIlllIlIII = 0;
            final int lllllllllllllIlIlllllIIIlllIIlll = 2;
            final int lllllllllllllIlIlllllIIIlllIIllI = this.sectionCount * 5 - 1;
            final IBlockState lllllllllllllIlIlllllIIIlllIIlIl = this.func_189917_F_();
            this.fillWithBlocks(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, 0, 0, 0, 2, 1, lllllllllllllIlIlllllIIIlllIIllI, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.func_189914_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.8f, 0, 2, 0, 2, 2, lllllllllllllIlIlllllIIIlllIIllI, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false, 0);
            if (this.hasSpiders) {
                this.func_189914_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.6f, 0, 0, 0, 2, 1, lllllllllllllIlIlllllIIIlllIIllI, Blocks.WEB.getDefaultState(), Blocks.AIR.getDefaultState(), false, 8);
            }
            for (int lllllllllllllIlIlllllIIIlllIIlII = 0; lllllllllllllIlIlllllIIIlllIIlII < this.sectionCount; ++lllllllllllllIlIlllllIIIlllIIlII) {
                final int lllllllllllllIlIlllllIIIlllIIIll = 2 + lllllllllllllIlIlllllIIIlllIIlII * 5;
                this.func_189921_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, 0, 0, lllllllllllllIlIlllllIIIlllIIIll, 2, 2, lllllllllllllIlIlllllIIIlllIllII);
                this.func_189922_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.1f, 0, 2, lllllllllllllIlIlllllIIIlllIIIll - 1);
                this.func_189922_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.1f, 2, 2, lllllllllllllIlIlllllIIIlllIIIll - 1);
                this.func_189922_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.1f, 0, 2, lllllllllllllIlIlllllIIIlllIIIll + 1);
                this.func_189922_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.1f, 2, 2, lllllllllllllIlIlllllIIIlllIIIll + 1);
                this.func_189922_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.05f, 0, 2, lllllllllllllIlIlllllIIIlllIIIll - 2);
                this.func_189922_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.05f, 2, 2, lllllllllllllIlIlllllIIIlllIIIll - 2);
                this.func_189922_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.05f, 0, 2, lllllllllllllIlIlllllIIIlllIIIll + 2);
                this.func_189922_a(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0.05f, 2, 2, lllllllllllllIlIlllllIIIlllIIIll + 2);
                if (lllllllllllllIlIlllllIIIlllIllII.nextInt(100) == 0) {
                    this.generateChest(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 2, 0, lllllllllllllIlIlllllIIIlllIIIll - 1, LootTableList.CHESTS_ABANDONED_MINESHAFT);
                }
                if (lllllllllllllIlIlllllIIIlllIllII.nextInt(100) == 0) {
                    this.generateChest(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, 0, 0, lllllllllllllIlIlllllIIIlllIIIll + 1, LootTableList.CHESTS_ABANDONED_MINESHAFT);
                }
                if (this.hasSpiders && !this.spawnerPlaced) {
                    final int lllllllllllllIlIlllllIIIlllIIIlI = this.getYWithOffset(0);
                    final int lllllllllllllIlIlllllIIIlllIIIIl = lllllllllllllIlIlllllIIIlllIIIll - 1 + lllllllllllllIlIlllllIIIlllIllII.nextInt(3);
                    final int lllllllllllllIlIlllllIIIlllIIIII = this.getXWithOffset(1, lllllllllllllIlIlllllIIIlllIIIIl);
                    final int lllllllllllllIlIlllllIIIllIlllll = this.getZWithOffset(1, lllllllllllllIlIlllllIIIlllIIIIl);
                    final BlockPos lllllllllllllIlIlllllIIIllIllllI = new BlockPos(lllllllllllllIlIlllllIIIlllIIIII, lllllllllllllIlIlllllIIIlllIIIlI, lllllllllllllIlIlllllIIIllIlllll);
                    if (lllllllllllllIlIlllllIIIlllIlIll.isVecInside(lllllllllllllIlIlllllIIIllIllllI) && this.func_189916_b(lllllllllllllIlIlllllIIIllIlIIlI, 1, 0, lllllllllllllIlIlllllIIIlllIIIIl, lllllllllllllIlIlllllIIIlllIlIll) < 8) {
                        this.spawnerPlaced = true;
                        lllllllllllllIlIlllllIIIllIlIIlI.setBlockState(lllllllllllllIlIlllllIIIllIllllI, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                        final TileEntity lllllllllllllIlIlllllIIIllIlllIl = lllllllllllllIlIlllllIIIllIlIIlI.getTileEntity(lllllllllllllIlIlllllIIIllIllllI);
                        if (lllllllllllllIlIlllllIIIllIlllIl instanceof TileEntityMobSpawner) {
                            ((TileEntityMobSpawner)lllllllllllllIlIlllllIIIllIlllIl).getSpawnerBaseLogic().func_190894_a(EntityList.func_191306_a(EntityCaveSpider.class));
                        }
                    }
                }
            }
            for (int lllllllllllllIlIlllllIIIllIlllII = 0; lllllllllllllIlIlllllIIIllIlllII <= 2; ++lllllllllllllIlIlllllIIIllIlllII) {
                for (int lllllllllllllIlIlllllIIIllIllIll = 0; lllllllllllllIlIlllllIIIllIllIll <= lllllllllllllIlIlllllIIIlllIIllI; ++lllllllllllllIlIlllllIIIllIllIll) {
                    final int lllllllllllllIlIlllllIIIllIllIlI = -1;
                    final IBlockState lllllllllllllIlIlllllIIIllIllIIl = this.getBlockStateFromPos(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIllIlllII, -1, lllllllllllllIlIlllllIIIllIllIll, lllllllllllllIlIlllllIIIlllIlIll);
                    if (lllllllllllllIlIlllllIIIllIllIIl.getMaterial() == Material.AIR && this.func_189916_b(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIllIlllII, -1, lllllllllllllIlIlllllIIIllIllIll, lllllllllllllIlIlllllIIIlllIlIll) < 8) {
                        final int lllllllllllllIlIlllllIIIllIllIII = -1;
                        this.setBlockState(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIIlIl, lllllllllllllIlIlllllIIIllIlllII, -1, lllllllllllllIlIlllllIIIllIllIll, lllllllllllllIlIlllllIIIlllIlIll);
                    }
                }
            }
            if (this.hasRails) {
                final IBlockState lllllllllllllIlIlllllIIIllIlIlll = Blocks.RAIL.getDefaultState().withProperty(BlockRail.SHAPE, BlockRailBase.EnumRailDirection.NORTH_SOUTH);
                for (int lllllllllllllIlIlllllIIIllIlIllI = 0; lllllllllllllIlIlllllIIIllIlIllI <= lllllllllllllIlIlllllIIIlllIIllI; ++lllllllllllllIlIlllllIIIllIlIllI) {
                    final IBlockState lllllllllllllIlIlllllIIIllIlIlIl = this.getBlockStateFromPos(lllllllllllllIlIlllllIIIllIlIIlI, 1, -1, lllllllllllllIlIlllllIIIllIlIllI, lllllllllllllIlIlllllIIIlllIlIll);
                    if (lllllllllllllIlIlllllIIIllIlIlIl.getMaterial() != Material.AIR && lllllllllllllIlIlllllIIIllIlIlIl.isFullBlock()) {
                        final float lllllllllllllIlIlllllIIIllIlIlII = (this.func_189916_b(lllllllllllllIlIlllllIIIllIlIIlI, 1, 0, lllllllllllllIlIlllllIIIllIlIllI, lllllllllllllIlIlllllIIIlllIlIll) > 8) ? 0.9f : 0.7f;
                        this.randomlyPlaceBlock(lllllllllllllIlIlllllIIIllIlIIlI, lllllllllllllIlIlllllIIIlllIlIll, lllllllllllllIlIlllllIIIlllIllII, lllllllllllllIlIlllllIIIllIlIlII, 1, 0, lllllllllllllIlIlllllIIIllIlIllI, lllllllllllllIlIlllllIIIllIlIlll);
                    }
                }
            }
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIlIlllllIIlIlllIlIl) {
            super.writeStructureToNBT(lllllllllllllIlIlllllIIlIlllIlIl);
            lllllllllllllIlIlllllIIlIlllIlIl.setBoolean("hr", this.hasRails);
            lllllllllllllIlIlllllIIlIlllIlIl.setBoolean("sc", this.hasSpiders);
            lllllllllllllIlIlllllIIlIlllIlIl.setBoolean("hps", this.spawnerPlaced);
            lllllllllllllIlIlllllIIlIlllIlIl.setInteger("Num", this.sectionCount);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIlIlllllIIlIllIllIl, final TemplateManager lllllllllllllIlIlllllIIlIllIllll) {
            super.readStructureFromNBT(lllllllllllllIlIlllllIIlIllIllIl, lllllllllllllIlIlllllIIlIllIllll);
            this.hasRails = lllllllllllllIlIlllllIIlIllIllIl.getBoolean("hr");
            this.hasSpiders = lllllllllllllIlIlllllIIlIllIllIl.getBoolean("sc");
            this.spawnerPlaced = lllllllllllllIlIlllllIIlIllIllIl.getBoolean("hps");
            this.sectionCount = lllllllllllllIlIlllllIIlIllIllIl.getInteger("Num");
        }
    }
    
    public static class Stairs extends Peice
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        
        public static StructureBoundingBox findStairs(final List<StructureComponent> llllllllllllllIlIIIIIIIIIIllIlIl, final Random llllllllllllllIlIIIIIIIIIIlllIll, final int llllllllllllllIlIIIIIIIIIIllIlII, final int llllllllllllllIlIIIIIIIIIIllIIll, final int llllllllllllllIlIIIIIIIIIIlllIII, final EnumFacing llllllllllllllIlIIIIIIIIIIllIlll) {
            final StructureBoundingBox llllllllllllllIlIIIIIIIIIIllIllI = new StructureBoundingBox(llllllllllllllIlIIIIIIIIIIllIlII, llllllllllllllIlIIIIIIIIIIllIIll - 5, llllllllllllllIlIIIIIIIIIIlllIII, llllllllllllllIlIIIIIIIIIIllIlII, llllllllllllllIlIIIIIIIIIIllIIll + 2, llllllllllllllIlIIIIIIIIIIlllIII);
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIlIIIIIIIIIIllIlll.ordinal()]) {
                default: {
                    llllllllllllllIlIIIIIIIIIIllIllI.maxX = llllllllllllllIlIIIIIIIIIIllIlII + 2;
                    llllllllllllllIlIIIIIIIIIIllIllI.minZ = llllllllllllllIlIIIIIIIIIIlllIII - 8;
                    break;
                }
                case 4: {
                    llllllllllllllIlIIIIIIIIIIllIllI.maxX = llllllllllllllIlIIIIIIIIIIllIlII + 2;
                    llllllllllllllIlIIIIIIIIIIllIllI.maxZ = llllllllllllllIlIIIIIIIIIIlllIII + 8;
                    break;
                }
                case 5: {
                    llllllllllllllIlIIIIIIIIIIllIllI.minX = llllllllllllllIlIIIIIIIIIIllIlII - 8;
                    llllllllllllllIlIIIIIIIIIIllIllI.maxZ = llllllllllllllIlIIIIIIIIIIlllIII + 2;
                    break;
                }
                case 6: {
                    llllllllllllllIlIIIIIIIIIIllIllI.maxX = llllllllllllllIlIIIIIIIIIIllIlII + 8;
                    llllllllllllllIlIIIIIIIIIIllIllI.maxZ = llllllllllllllIlIIIIIIIIIIlllIII + 2;
                    break;
                }
            }
            return (StructureComponent.findIntersecting(llllllllllllllIlIIIIIIIIIIllIlIl, llllllllllllllIlIIIIIIIIIIllIllI) != null) ? null : llllllllllllllIlIIIIIIIIIIllIllI;
        }
        
        public Stairs() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIIIIIIIIIIIlIIll, final Random llllllllllllllIlIIIIIIIIIIIlIlll, final StructureBoundingBox llllllllllllllIlIIIIIIIIIIIlIllI) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllIlIIIIIIIIIIIlIIll, llllllllllllllIlIIIIIIIIIIIlIllI)) {
                return false;
            }
            this.fillWithBlocks(llllllllllllllIlIIIIIIIIIIIlIIll, llllllllllllllIlIIIIIIIIIIIlIllI, 0, 5, 0, 2, 7, 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIIIIIIIIIIIlIIll, llllllllllllllIlIIIIIIIIIIIlIllI, 0, 0, 7, 2, 2, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            for (int llllllllllllllIlIIIIIIIIIIIlIlIl = 0; llllllllllllllIlIIIIIIIIIIIlIlIl < 5; ++llllllllllllllIlIIIIIIIIIIIlIlIl) {
                this.fillWithBlocks(llllllllllllllIlIIIIIIIIIIIlIIll, llllllllllllllIlIIIIIIIIIIIlIllI, 0, 5 - llllllllllllllIlIIIIIIIIIIIlIlIl - ((llllllllllllllIlIIIIIIIIIIIlIlIl < 4) ? 1 : 0), 2 + llllllllllllllIlIIIIIIIIIIIlIlIl, 2, 7 - llllllllllllllIlIIIIIIIIIIIlIlIl, 2 + llllllllllllllIlIIIIIIIIIIIlIlIl, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            return true;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Stairs.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final Exception llllllllllllllIlIIIIIIIIIIIIllll = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllllllIlIIIIIIIIIIIIllll[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllIlIIIIIIIIIIIIllll[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllllIlIIIIIIIIIIIIllll[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllllIlIIIIIIIIIIIIllll[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllllllIlIIIIIIIIIIIIllll[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllllllIlIIIIIIIIIIIIllll[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Stairs.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIlIIIIIIIIIIIIllll;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIIIIIIIIIIlIlIII, final List<StructureComponent> llllllllllllllIlIIIIIIIIIIlIIIIl, final Random llllllllllllllIlIIIIIIIIIIlIIIII) {
            final int llllllllllllllIlIIIIIIIIIIlIIlIl = this.getComponentType();
            final EnumFacing llllllllllllllIlIIIIIIIIIIlIIlII = this.getCoordBaseMode();
            if (llllllllllllllIlIIIIIIIIIIlIIlII != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIlIIIIIIIIIIlIIlII.ordinal()]) {
                    default: {
                        func_189938_b(llllllllllllllIlIIIIIIIIIIlIlIII, llllllllllllllIlIIIIIIIIIIlIIIIl, llllllllllllllIlIIIIIIIIIIlIIIII, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, llllllllllllllIlIIIIIIIIIIlIIlIl);
                        break;
                    }
                    case 4: {
                        func_189938_b(llllllllllllllIlIIIIIIIIIIlIlIII, llllllllllllllIlIIIIIIIIIIlIIIIl, llllllllllllllIlIIIIIIIIIIlIIIII, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llllllllllllllIlIIIIIIIIIIlIIlIl);
                        break;
                    }
                    case 5: {
                        func_189938_b(llllllllllllllIlIIIIIIIIIIlIlIII, llllllllllllllIlIIIIIIIIIIlIIIIl, llllllllllllllIlIIIIIIIIIIlIIIII, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, llllllllllllllIlIIIIIIIIIIlIIlIl);
                        break;
                    }
                    case 6: {
                        func_189938_b(llllllllllllllIlIIIIIIIIIIlIlIII, llllllllllllllIlIIIIIIIIIIlIIIIl, llllllllllllllIlIIIIIIIIIIlIIIII, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, llllllllllllllIlIIIIIIIIIIlIIlIl);
                        break;
                    }
                }
            }
        }
        
        public Stairs(final int llllllllllllllIlIIIIIIIIIlIIllII, final Random llllllllllllllIlIIIIIIIIIlIIlIll, final StructureBoundingBox llllllllllllllIlIIIIIIIIIlIIlIlI, final EnumFacing llllllllllllllIlIIIIIIIIIlIIlIIl, final MapGenMineshaft.Type llllllllllllllIlIIIIIIIIIlIIlIII) {
            super(llllllllllllllIlIIIIIIIIIlIIllII, llllllllllllllIlIIIIIIIIIlIIlIII);
            this.setCoordBaseMode(llllllllllllllIlIIIIIIIIIlIIlIIl);
            this.boundingBox = llllllllllllllIlIIIIIIIIIlIIlIlI;
        }
    }
    
    public static class Room extends Peice
    {
        private final /* synthetic */ List<StructureBoundingBox> roomsLinkedToTheRoom;
        
        public Room() {
            this.roomsLinkedToTheRoom = (List<StructureBoundingBox>)Lists.newLinkedList();
        }
        
        @Override
        public void buildComponent(final StructureComponent llIlllllllIl, final List<StructureComponent> llIlllllllII, final Random llIllllllIll) {
            final int llIllllllIlI = this.getComponentType();
            int llIllllllIIl = this.boundingBox.getYSize() - 3 - 1;
            if (llIllllllIIl <= 0) {
                llIllllllIIl = 1;
            }
            for (int llIllllllIII = 0; llIllllllIII < this.boundingBox.getXSize(); llIllllllIII += 4) {
                llIllllllIII += llIllllllIll.nextInt(this.boundingBox.getXSize());
                if (llIllllllIII + 3 > this.boundingBox.getXSize()) {
                    break;
                }
                final Peice llIlllllIlll = func_189938_b(llIlllllllIl, llIlllllllII, llIllllllIll, this.boundingBox.minX + llIllllllIII, this.boundingBox.minY + llIllllllIll.nextInt(llIllllllIIl) + 1, this.boundingBox.minZ - 1, EnumFacing.NORTH, llIllllllIlI);
                if (llIlllllIlll != null) {
                    final StructureBoundingBox llIlllllIllI = llIlllllIlll.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(llIlllllIllI.minX, llIlllllIllI.minY, this.boundingBox.minZ, llIlllllIllI.maxX, llIlllllIllI.maxY, this.boundingBox.minZ + 1));
                }
            }
            for (int llIllllllIII = 0; llIllllllIII < this.boundingBox.getXSize(); llIllllllIII += 4) {
                llIllllllIII += llIllllllIll.nextInt(this.boundingBox.getXSize());
                if (llIllllllIII + 3 > this.boundingBox.getXSize()) {
                    break;
                }
                final Peice llIlllllIlIl = func_189938_b(llIlllllllIl, llIlllllllII, llIllllllIll, this.boundingBox.minX + llIllllllIII, this.boundingBox.minY + llIllllllIll.nextInt(llIllllllIIl) + 1, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, llIllllllIlI);
                if (llIlllllIlIl != null) {
                    final StructureBoundingBox llIlllllIlII = llIlllllIlIl.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(llIlllllIlII.minX, llIlllllIlII.minY, this.boundingBox.maxZ - 1, llIlllllIlII.maxX, llIlllllIlII.maxY, this.boundingBox.maxZ));
                }
            }
            for (int llIllllllIII = 0; llIllllllIII < this.boundingBox.getZSize(); llIllllllIII += 4) {
                llIllllllIII += llIllllllIll.nextInt(this.boundingBox.getZSize());
                if (llIllllllIII + 3 > this.boundingBox.getZSize()) {
                    break;
                }
                final Peice llIlllllIIll = func_189938_b(llIlllllllIl, llIlllllllII, llIllllllIll, this.boundingBox.minX - 1, this.boundingBox.minY + llIllllllIll.nextInt(llIllllllIIl) + 1, this.boundingBox.minZ + llIllllllIII, EnumFacing.WEST, llIllllllIlI);
                if (llIlllllIIll != null) {
                    final StructureBoundingBox llIlllllIIlI = llIlllllIIll.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.minX, llIlllllIIlI.minY, llIlllllIIlI.minZ, this.boundingBox.minX + 1, llIlllllIIlI.maxY, llIlllllIIlI.maxZ));
                }
            }
            for (int llIllllllIII = 0; llIllllllIII < this.boundingBox.getZSize(); llIllllllIII += 4) {
                llIllllllIII += llIllllllIll.nextInt(this.boundingBox.getZSize());
                if (llIllllllIII + 3 > this.boundingBox.getZSize()) {
                    break;
                }
                final StructureComponent llIlllllIIIl = func_189938_b(llIlllllllIl, llIlllllllII, llIllllllIll, this.boundingBox.maxX + 1, this.boundingBox.minY + llIllllllIll.nextInt(llIllllllIIl) + 1, this.boundingBox.minZ + llIllllllIII, EnumFacing.EAST, llIllllllIlI);
                if (llIlllllIIIl != null) {
                    final StructureBoundingBox llIlllllIIII = llIlllllIIIl.getBoundingBox();
                    this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.maxX - 1, llIlllllIIII.minY, llIlllllIIII.minZ, this.boundingBox.maxX, llIlllllIIII.maxY, llIlllllIIII.maxZ));
                }
            }
        }
        
        public Room(final int lllIIIIlIIlI, final Random lllIIIIIlIll, final int lllIIIIlIIII, final int lllIIIIIlIIl, final MapGenMineshaft.Type lllIIIIIlllI) {
            super(lllIIIIlIIlI, lllIIIIIlllI);
            this.roomsLinkedToTheRoom = (List<StructureBoundingBox>)Lists.newLinkedList();
            this.mineShaftType = lllIIIIIlllI;
            this.boundingBox = new StructureBoundingBox(lllIIIIlIIII, 50, lllIIIIIlIIl, lllIIIIlIIII + 7 + lllIIIIIlIll.nextInt(6), 54 + lllIIIIIlIll.nextInt(6), lllIIIIIlIIl + 7 + lllIIIIIlIll.nextInt(6));
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llIllIlIllIl, final TemplateManager llIllIlIllII) {
            super.readStructureFromNBT(llIllIlIllIl, llIllIlIllII);
            final NBTTagList llIllIllIIII = llIllIlIllIl.getTagList("Entrances", 11);
            for (int llIllIlIllll = 0; llIllIlIllll < llIllIllIIII.tagCount(); ++llIllIlIllll) {
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(llIllIllIIII.getIntArrayAt(llIllIlIllll)));
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llIlllIIIIII) {
            super.writeStructureToNBT(llIlllIIIIII);
            final NBTTagList llIllIllllll = new NBTTagList();
            for (final StructureBoundingBox llIllIlllllI : this.roomsLinkedToTheRoom) {
                llIllIllllll.appendTag(llIllIlllllI.toNBTTagIntArray());
            }
            llIlllIIIIII.setTag("Entrances", llIllIllllll);
        }
        
        @Override
        public boolean addComponentParts(final World llIllllIIIII, final Random llIlllIlllll, final StructureBoundingBox llIlllIllIlI) {
            if (this.isLiquidInStructureBoundingBox(llIllllIIIII, llIlllIllIlI)) {
                return false;
            }
            this.fillWithBlocks(llIllllIIIII, llIlllIllIlI, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.minY, this.boundingBox.maxZ, Blocks.DIRT.getDefaultState(), Blocks.AIR.getDefaultState(), true);
            this.fillWithBlocks(llIllllIIIII, llIlllIllIlI, this.boundingBox.minX, this.boundingBox.minY + 1, this.boundingBox.minZ, this.boundingBox.maxX, Math.min(this.boundingBox.minY + 3, this.boundingBox.maxY), this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            for (final StructureBoundingBox llIlllIlllIl : this.roomsLinkedToTheRoom) {
                this.fillWithBlocks(llIllllIIIII, llIlllIllIlI, llIlllIlllIl.minX, llIlllIlllIl.maxY - 2, llIlllIlllIl.minZ, llIlllIlllIl.maxX, llIlllIlllIl.maxY, llIlllIlllIl.maxZ, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            this.randomlyRareFillWithBlocks(llIllllIIIII, llIlllIllIlI, this.boundingBox.minX, this.boundingBox.minY + 4, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.AIR.getDefaultState(), false);
            return true;
        }
        
        @Override
        public void offset(final int llIlllIlIIII, final int llIlllIIllll, final int llIlllIIlllI) {
            super.offset(llIlllIlIIII, llIlllIIllll, llIlllIIlllI);
            for (final StructureBoundingBox llIlllIIllIl : this.roomsLinkedToTheRoom) {
                llIlllIIllIl.offset(llIlllIlIIII, llIlllIIllll, llIlllIIlllI);
            }
        }
    }
}
