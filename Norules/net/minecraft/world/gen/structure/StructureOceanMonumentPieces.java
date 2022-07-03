package net.minecraft.world.gen.structure;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.world.gen.structure.template.*;
import com.google.common.collect.*;
import java.util.*;

public class StructureOceanMonumentPieces
{
    public static void registerOceanMonumentPieces() {
        MapGenStructureIO.registerStructureComponent(MonumentBuilding.class, "OMB");
        MapGenStructureIO.registerStructureComponent(MonumentCoreRoom.class, "OMCR");
        MapGenStructureIO.registerStructureComponent(DoubleXRoom.class, "OMDXR");
        MapGenStructureIO.registerStructureComponent(DoubleXYRoom.class, "OMDXYR");
        MapGenStructureIO.registerStructureComponent(DoubleYRoom.class, "OMDYR");
        MapGenStructureIO.registerStructureComponent(DoubleYZRoom.class, "OMDYZR");
        MapGenStructureIO.registerStructureComponent(DoubleZRoom.class, "OMDZR");
        MapGenStructureIO.registerStructureComponent(EntryRoom.class, "OMEntry");
        MapGenStructureIO.registerStructureComponent(Penthouse.class, "OMPenthouse");
        MapGenStructureIO.registerStructureComponent(SimpleRoom.class, "OMSimple");
        MapGenStructureIO.registerStructureComponent(SimpleTopRoom.class, "OMSimpleT");
    }
    
    public static class DoubleXYRoom extends Piece
    {
        public DoubleXYRoom() {
        }
        
        public DoubleXYRoom(final EnumFacing lllllllllllllIIIlIlllIIlIlIlIlll, final RoomDefinition lllllllllllllIIIlIlllIIlIlIllIlI, final Random lllllllllllllIIIlIlllIIlIlIllIIl) {
            super(1, lllllllllllllIIIlIlllIIlIlIlIlll, lllllllllllllIIIlIlllIIlIlIllIlI, 2, 2, 1);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIlIlllIIlIlIIIIIl, final Random lllllllllllllIIIlIlllIIlIlIIlIlI, final StructureBoundingBox lllllllllllllIIIlIlllIIlIlIIIIII) {
            final RoomDefinition lllllllllllllIIIlIlllIIlIlIIlIII = this.roomDefinition.connections[EnumFacing.EAST.getIndex()];
            final RoomDefinition lllllllllllllIIIlIlllIIlIlIIIlll = this.roomDefinition;
            final RoomDefinition lllllllllllllIIIlIlllIIlIlIIIllI = lllllllllllllIIIlIlllIIlIlIIIlll.connections[EnumFacing.UP.getIndex()];
            final RoomDefinition lllllllllllllIIIlIlllIIlIlIIIlIl = lllllllllllllIIIlIlllIIlIlIIlIII.connections[EnumFacing.UP.getIndex()];
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 8, 0, lllllllllllllIIIlIlllIIlIlIIlIII.hasOpening[EnumFacing.DOWN.getIndex()]);
                this.generateDefaultFloor(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 0, 0, lllllllllllllIIIlIlllIIlIlIIIlll.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIllI.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 1, 8, 1, 7, 8, 6, DoubleXYRoom.ROUGH_PRISMARINE);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIlIl.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 8, 8, 1, 14, 8, 6, DoubleXYRoom.ROUGH_PRISMARINE);
            }
            for (int lllllllllllllIIIlIlllIIlIlIIIlII = 1; lllllllllllllIIIlIlllIIlIlIIIlII <= 7; ++lllllllllllllIIIlIlllIIlIlIIIlII) {
                IBlockState lllllllllllllIIIlIlllIIlIlIIIIll = DoubleXYRoom.BRICKS_PRISMARINE;
                if (lllllllllllllIIIlIlllIIlIlIIIlII == 2 || lllllllllllllIIIlIlllIIlIlIIIlII == 6) {
                    lllllllllllllIIIlIlllIIlIlIIIIll = DoubleXYRoom.ROUGH_PRISMARINE;
                }
                this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 0, lllllllllllllIIIlIlllIIlIlIIIlII, 0, 0, lllllllllllllIIIlIlllIIlIlIIIlII, 7, lllllllllllllIIIlIlllIIlIlIIIIll, lllllllllllllIIIlIlllIIlIlIIIIll, false);
                this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 15, lllllllllllllIIIlIlllIIlIlIIIlII, 0, 15, lllllllllllllIIIlIlllIIlIlIIIlII, 7, lllllllllllllIIIlIlllIIlIlIIIIll, lllllllllllllIIIlIlllIIlIlIIIIll, false);
                this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 1, lllllllllllllIIIlIlllIIlIlIIIlII, 0, 15, lllllllllllllIIIlIlllIIlIlIIIlII, 0, lllllllllllllIIIlIlllIIlIlIIIIll, lllllllllllllIIIlIlllIIlIlIIIIll, false);
                this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 1, lllllllllllllIIIlIlllIIlIlIIIlII, 7, 14, lllllllllllllIIIlIlllIIlIlIIIlII, 7, lllllllllllllIIIlIlllIIlIlIIIIll, lllllllllllllIIIlIlllIIlIlIIIIll, false);
            }
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 2, 1, 3, 2, 7, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 3, 1, 2, 4, 7, 2, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 3, 1, 5, 4, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 13, 1, 3, 13, 7, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 11, 1, 2, 12, 7, 2, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 11, 1, 5, 12, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 5, 1, 3, 5, 3, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 10, 1, 3, 10, 3, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 5, 7, 2, 10, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 5, 5, 2, 5, 7, 2, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 10, 5, 2, 10, 7, 2, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 5, 5, 5, 5, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 10, 5, 5, 10, 7, 5, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.setBlockState(lllllllllllllIIIlIlllIIlIlIIIIIl, DoubleXYRoom.BRICKS_PRISMARINE, 6, 6, 2, lllllllllllllIIIlIlllIIlIlIIIIII);
            this.setBlockState(lllllllllllllIIIlIlllIIlIlIIIIIl, DoubleXYRoom.BRICKS_PRISMARINE, 9, 6, 2, lllllllllllllIIIlIlllIIlIlIIIIII);
            this.setBlockState(lllllllllllllIIIlIlllIIlIlIIIIIl, DoubleXYRoom.BRICKS_PRISMARINE, 6, 6, 5, lllllllllllllIIIlIlllIIlIlIIIIII);
            this.setBlockState(lllllllllllllIIIlIlllIIlIlIIIIIl, DoubleXYRoom.BRICKS_PRISMARINE, 9, 6, 5, lllllllllllllIIIlIlllIIlIlIIIIII);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 5, 4, 3, 6, 4, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 9, 4, 3, 10, 4, 4, DoubleXYRoom.BRICKS_PRISMARINE, DoubleXYRoom.BRICKS_PRISMARINE, false);
            this.setBlockState(lllllllllllllIIIlIlllIIlIlIIIIIl, DoubleXYRoom.SEA_LANTERN, 5, 4, 2, lllllllllllllIIIlIlllIIlIlIIIIII);
            this.setBlockState(lllllllllllllIIIlIlllIIlIlIIIIIl, DoubleXYRoom.SEA_LANTERN, 5, 4, 5, lllllllllllllIIIlIlllIIlIlIIIIII);
            this.setBlockState(lllllllllllllIIIlIlllIIlIlIIIIIl, DoubleXYRoom.SEA_LANTERN, 10, 4, 2, lllllllllllllIIIlIlllIIlIlIIIIII);
            this.setBlockState(lllllllllllllIIIlIlllIIlIlIIIIIl, DoubleXYRoom.SEA_LANTERN, 10, 4, 5, lllllllllllllIIIlIlllIIlIlIIIIII);
            if (lllllllllllllIIIlIlllIIlIlIIIlll.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 3, 1, 0, 4, 2, 0, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIlll.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 3, 1, 7, 4, 2, 7, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIlll.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 0, 1, 3, 0, 2, 4, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIlIII.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 11, 1, 0, 12, 2, 0, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIlIII.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 11, 1, 7, 12, 2, 7, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIlIII.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 15, 1, 3, 15, 2, 4, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIllI.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 3, 5, 0, 4, 6, 0, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIllI.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 3, 5, 7, 4, 6, 7, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIllI.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 0, 5, 3, 0, 6, 4, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIlIl.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 11, 5, 0, 12, 6, 0, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIlIl.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 11, 5, 7, 12, 6, 7, false);
            }
            if (lllllllllllllIIIlIlllIIlIlIIIlIl.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlllIIlIlIIIIIl, lllllllllllllIIIlIlllIIlIlIIIIII, 15, 5, 3, 15, 6, 4, false);
            }
            return true;
        }
    }
    
    static class RoomDefinition
    {
        /* synthetic */ boolean[] hasOpening;
        /* synthetic */ int scanIndex;
        /* synthetic */ RoomDefinition[] connections;
        /* synthetic */ boolean claimed;
        /* synthetic */ int index;
        /* synthetic */ boolean isSource;
        
        public RoomDefinition(final int lllllllllllllllIllIIlllIlllIIllI) {
            this.connections = new RoomDefinition[6];
            this.hasOpening = new boolean[6];
            this.index = lllllllllllllllIllIIlllIlllIIllI;
        }
        
        public boolean findSource(final int lllllllllllllllIllIIlllIllIIllIl) {
            if (this.isSource) {
                return true;
            }
            this.scanIndex = lllllllllllllllIllIIlllIllIIllIl;
            for (int lllllllllllllllIllIIlllIllIIllll = 0; lllllllllllllllIllIIlllIllIIllll < 6; ++lllllllllllllllIllIIlllIllIIllll) {
                if (this.connections[lllllllllllllllIllIIlllIllIIllll] != null && this.hasOpening[lllllllllllllllIllIIlllIllIIllll] && this.connections[lllllllllllllllIllIIlllIllIIllll].scanIndex != lllllllllllllllIllIIlllIllIIllIl && this.connections[lllllllllllllllIllIIlllIllIIllll].findSource(lllllllllllllllIllIIlllIllIIllIl)) {
                    return true;
                }
            }
            return false;
        }
        
        public int countOpenings() {
            int lllllllllllllllIllIIlllIllIIIlII = 0;
            for (int lllllllllllllllIllIIlllIllIIIIll = 0; lllllllllllllllIllIIlllIllIIIIll < 6; ++lllllllllllllllIllIIlllIllIIIIll) {
                if (this.hasOpening[lllllllllllllllIllIIlllIllIIIIll]) {
                    ++lllllllllllllllIllIIlllIllIIIlII;
                }
            }
            return lllllllllllllllIllIIlllIllIIIlII;
        }
        
        public void setConnection(final EnumFacing lllllllllllllllIllIIlllIllIlllII, final RoomDefinition lllllllllllllllIllIIlllIllIllIll) {
            this.connections[lllllllllllllllIllIIlllIllIlllII.getIndex()] = lllllllllllllllIllIIlllIllIllIll;
            lllllllllllllllIllIIlllIllIllIll.connections[lllllllllllllllIllIIlllIllIlllII.getOpposite().getIndex()] = this;
        }
        
        public boolean isSpecial() {
            return this.index >= 75;
        }
        
        public void updateOpenings() {
            for (int lllllllllllllllIllIIlllIllIlIlll = 0; lllllllllllllllIllIIlllIllIlIlll < 6; ++lllllllllllllllIllIIlllIllIlIlll) {
                this.hasOpening[lllllllllllllllIllIIlllIllIlIlll] = (this.connections[lllllllllllllllIllIIlllIllIlIlll] != null);
            }
        }
    }
    
    public abstract static class Piece extends StructureComponent
    {
        protected static final /* synthetic */ int GRIDROOM_LEFTWING_CONNECT_INDEX;
        protected static final /* synthetic */ int GRIDROOM_SOURCE_INDEX;
        protected /* synthetic */ RoomDefinition roomDefinition;
        protected static final /* synthetic */ IBlockState ROUGH_PRISMARINE;
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        protected static final /* synthetic */ IBlockState DOT_DECO_DATA;
        protected static final /* synthetic */ IBlockState DARK_PRISMARINE;
        protected static final /* synthetic */ int GRIDROOM_RIGHTWING_CONNECT_INDEX;
        protected static final /* synthetic */ IBlockState SEA_LANTERN;
        protected static final /* synthetic */ IBlockState WATER;
        protected static final /* synthetic */ IBlockState BRICKS_PRISMARINE;
        protected static final /* synthetic */ int GRIDROOM_TOP_CONNECT_INDEX;
        
        protected void generateWaterBox(final World llllllllllllllIIlIllIIllIIIIllIl, final StructureBoundingBox llllllllllllllIIlIllIIllIIIIllII, final int llllllllllllllIIlIllIIlIlllllllI, final int llllllllllllllIIlIllIIlIllllllIl, final int llllllllllllllIIlIllIIllIIIIlIIl, final int llllllllllllllIIlIllIIllIIIIlIII, final int llllllllllllllIIlIllIIlIlllllIlI, final int llllllllllllllIIlIllIIlIlllllIIl, final boolean llllllllllllllIIlIllIIllIIIIIlIl) {
            for (int llllllllllllllIIlIllIIllIIIIIlII = llllllllllllllIIlIllIIlIllllllIl; llllllllllllllIIlIllIIllIIIIIlII <= llllllllllllllIIlIllIIlIlllllIlI; ++llllllllllllllIIlIllIIllIIIIIlII) {
                for (int llllllllllllllIIlIllIIllIIIIIIll = llllllllllllllIIlIllIIlIlllllllI; llllllllllllllIIlIllIIllIIIIIIll <= llllllllllllllIIlIllIIllIIIIlIII; ++llllllllllllllIIlIllIIllIIIIIIll) {
                    for (int llllllllllllllIIlIllIIllIIIIIIlI = llllllllllllllIIlIllIIllIIIIlIIl; llllllllllllllIIlIllIIllIIIIIIlI <= llllllllllllllIIlIllIIlIlllllIIl; ++llllllllllllllIIlIllIIllIIIIIIlI) {
                        if (!llllllllllllllIIlIllIIllIIIIIlIl || this.getBlockStateFromPos(llllllllllllllIIlIllIIllIIIIllIl, llllllllllllllIIlIllIIllIIIIIIll, llllllllllllllIIlIllIIllIIIIIlII, llllllllllllllIIlIllIIllIIIIIIlI, llllllllllllllIIlIllIIllIIIIllII).getMaterial() != Material.AIR) {
                            if (this.getYWithOffset(llllllllllllllIIlIllIIllIIIIIlII) >= llllllllllllllIIlIllIIllIIIIllIl.getSeaLevel()) {
                                this.setBlockState(llllllllllllllIIlIllIIllIIIIllIl, Blocks.AIR.getDefaultState(), llllllllllllllIIlIllIIllIIIIIIll, llllllllllllllIIlIllIIllIIIIIlII, llllllllllllllIIlIllIIllIIIIIIlI, llllllllllllllIIlIllIIllIIIIllII);
                            }
                            else {
                                this.setBlockState(llllllllllllllIIlIllIIllIIIIllIl, Piece.WATER, llllllllllllllIIlIllIIllIIIIIIll, llllllllllllllIIlIllIIllIIIIIlII, llllllllllllllIIlIllIIllIIIIIIlI, llllllllllllllIIlIllIIllIIIIllII);
                            }
                        }
                    }
                }
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIIlIllIIllIIIlllll) {
        }
        
        protected static final int getRoomIndex(final int llllllllllllllIIlIllIIllIlIlIllI, final int llllllllllllllIIlIllIIllIlIllIII, final int llllllllllllllIIlIllIIllIlIlIlll) {
            return llllllllllllllIIlIllIIllIlIllIII * 25 + llllllllllllllIIlIllIIllIlIlIlll * 5 + llllllllllllllIIlIllIIllIlIlIllI;
        }
        
        static {
            ROUGH_PRISMARINE = Blocks.PRISMARINE.getStateFromMeta(BlockPrismarine.ROUGH_META);
            BRICKS_PRISMARINE = Blocks.PRISMARINE.getStateFromMeta(BlockPrismarine.BRICKS_META);
            DARK_PRISMARINE = Blocks.PRISMARINE.getStateFromMeta(BlockPrismarine.DARK_META);
            DOT_DECO_DATA = Piece.BRICKS_PRISMARINE;
            SEA_LANTERN = Blocks.SEA_LANTERN.getDefaultState();
            WATER = Blocks.WATER.getDefaultState();
            GRIDROOM_SOURCE_INDEX = getRoomIndex(2, 0, 0);
            GRIDROOM_TOP_CONNECT_INDEX = getRoomIndex(2, 2, 0);
            GRIDROOM_LEFTWING_CONNECT_INDEX = getRoomIndex(0, 1, 0);
            GRIDROOM_RIGHTWING_CONNECT_INDEX = getRoomIndex(4, 1, 0);
        }
        
        public Piece(final int llllllllllllllIIlIllIIllIlIIlIll) {
            super(llllllllllllllIIlIllIIllIlIIlIll);
        }
        
        protected boolean spawnElder(final World llllllllllllllIIlIllIIlIlIIIlIII, final StructureBoundingBox llllllllllllllIIlIllIIlIlIIIIlll, final int llllllllllllllIIlIllIIlIlIIIIllI, final int llllllllllllllIIlIllIIlIlIIIIlIl, final int llllllllllllllIIlIllIIlIlIIIIlII) {
            final int llllllllllllllIIlIllIIlIlIIIllIl = this.getXWithOffset(llllllllllllllIIlIllIIlIlIIIIllI, llllllllllllllIIlIllIIlIlIIIIlII);
            final int llllllllllllllIIlIllIIlIlIIIllII = this.getYWithOffset(llllllllllllllIIlIllIIlIlIIIIlIl);
            final int llllllllllllllIIlIllIIlIlIIIlIll = this.getZWithOffset(llllllllllllllIIlIllIIlIlIIIIllI, llllllllllllllIIlIllIIlIlIIIIlII);
            if (llllllllllllllIIlIllIIlIlIIIIlll.isVecInside(new BlockPos(llllllllllllllIIlIllIIlIlIIIllIl, llllllllllllllIIlIllIIlIlIIIllII, llllllllllllllIIlIllIIlIlIIIlIll))) {
                final EntityElderGuardian llllllllllllllIIlIllIIlIlIIIlIlI = new EntityElderGuardian(llllllllllllllIIlIllIIlIlIIIlIII);
                llllllllllllllIIlIllIIlIlIIIlIlI.heal(llllllllllllllIIlIllIIlIlIIIlIlI.getMaxHealth());
                llllllllllllllIIlIllIIlIlIIIlIlI.setLocationAndAngles(llllllllllllllIIlIllIIlIlIIIllIl + 0.5, llllllllllllllIIlIllIIlIlIIIllII, llllllllllllllIIlIllIIlIlIIIlIll + 0.5, 0.0f, 0.0f);
                llllllllllllllIIlIllIIlIlIIIlIlI.onInitialSpawn(llllllllllllllIIlIllIIlIlIIIlIII.getDifficultyForLocation(new BlockPos(llllllllllllllIIlIllIIlIlIIIlIlI)), null);
                llllllllllllllIIlIllIIlIlIIIlIII.spawnEntityInWorld(llllllllllllllIIlIllIIlIlIIIlIlI);
                return true;
            }
            return false;
        }
        
        protected void generateDefaultFloor(final World llllllllllllllIIlIllIIlIlllIllIl, final StructureBoundingBox llllllllllllllIIlIllIIlIlllIllII, final int llllllllllllllIIlIllIIlIlllIIlIl, final int llllllllllllllIIlIllIIlIlllIIlII, final boolean llllllllllllllIIlIllIIlIlllIlIIl) {
            if (llllllllllllllIIlIllIIlIlllIlIIl) {
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 0, 0, llllllllllllllIIlIllIIlIlllIIlII + 0, llllllllllllllIIlIllIIlIlllIIlIl + 2, 0, llllllllllllllIIlIllIIlIlllIIlII + 8 - 1, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 5, 0, llllllllllllllIIlIllIIlIlllIIlII + 0, llllllllllllllIIlIllIIlIlllIIlIl + 8 - 1, 0, llllllllllllllIIlIllIIlIlllIIlII + 8 - 1, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 3, 0, llllllllllllllIIlIllIIlIlllIIlII + 0, llllllllllllllIIlIllIIlIlllIIlIl + 4, 0, llllllllllllllIIlIllIIlIlllIIlII + 2, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 3, 0, llllllllllllllIIlIllIIlIlllIIlII + 5, llllllllllllllIIlIllIIlIlllIIlIl + 4, 0, llllllllllllllIIlIllIIlIlllIIlII + 8 - 1, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 3, 0, llllllllllllllIIlIllIIlIlllIIlII + 2, llllllllllllllIIlIllIIlIlllIIlIl + 4, 0, llllllllllllllIIlIllIIlIlllIIlII + 2, Piece.BRICKS_PRISMARINE, Piece.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 3, 0, llllllllllllllIIlIllIIlIlllIIlII + 5, llllllllllllllIIlIllIIlIlllIIlIl + 4, 0, llllllllllllllIIlIllIIlIlllIIlII + 5, Piece.BRICKS_PRISMARINE, Piece.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 2, 0, llllllllllllllIIlIllIIlIlllIIlII + 3, llllllllllllllIIlIllIIlIlllIIlIl + 2, 0, llllllllllllllIIlIllIIlIlllIIlII + 4, Piece.BRICKS_PRISMARINE, Piece.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 5, 0, llllllllllllllIIlIllIIlIlllIIlII + 3, llllllllllllllIIlIllIIlIlllIIlIl + 5, 0, llllllllllllllIIlIllIIlIlllIIlII + 4, Piece.BRICKS_PRISMARINE, Piece.BRICKS_PRISMARINE, false);
            }
            else {
                this.fillWithBlocks(llllllllllllllIIlIllIIlIlllIllIl, llllllllllllllIIlIllIIlIlllIllII, llllllllllllllIIlIllIIlIlllIIlIl + 0, 0, llllllllllllllIIlIllIIlIlllIIlII + 0, llllllllllllllIIlIllIIlIlllIIlIl + 8 - 1, 0, llllllllllllllIIlIllIIlIlllIIlII + 8 - 1, Piece.ROUGH_PRISMARINE, Piece.ROUGH_PRISMARINE, false);
            }
        }
        
        public Piece() {
            super(0);
        }
        
        protected void generateBoxOnFillOnly(final World llllllllllllllIIlIllIIlIllIIIlll, final StructureBoundingBox llllllllllllllIIlIllIIlIllIlIIll, final int llllllllllllllIIlIllIIlIllIlIIlI, final int llllllllllllllIIlIllIIlIllIlIIIl, final int llllllllllllllIIlIllIIlIllIlIIII, final int llllllllllllllIIlIllIIlIllIIIIlI, final int llllllllllllllIIlIllIIlIllIIIIIl, final int llllllllllllllIIlIllIIlIllIIIIII, final IBlockState llllllllllllllIIlIllIIlIlIllllll) {
            for (int llllllllllllllIIlIllIIlIllIIlIll = llllllllllllllIIlIllIIlIllIlIIIl; llllllllllllllIIlIllIIlIllIIlIll <= llllllllllllllIIlIllIIlIllIIIIIl; ++llllllllllllllIIlIllIIlIllIIlIll) {
                for (int llllllllllllllIIlIllIIlIllIIlIlI = llllllllllllllIIlIllIIlIllIlIIlI; llllllllllllllIIlIllIIlIllIIlIlI <= llllllllllllllIIlIllIIlIllIIIIlI; ++llllllllllllllIIlIllIIlIllIIlIlI) {
                    for (int llllllllllllllIIlIllIIlIllIIlIIl = llllllllllllllIIlIllIIlIllIlIIII; llllllllllllllIIlIllIIlIllIIlIIl <= llllllllllllllIIlIllIIlIllIIIIII; ++llllllllllllllIIlIllIIlIllIIlIIl) {
                        if (this.getBlockStateFromPos(llllllllllllllIIlIllIIlIllIIIlll, llllllllllllllIIlIllIIlIllIIlIlI, llllllllllllllIIlIllIIlIllIIlIll, llllllllllllllIIlIllIIlIllIIlIIl, llllllllllllllIIlIllIIlIllIlIIll) == Piece.WATER) {
                            this.setBlockState(llllllllllllllIIlIllIIlIllIIIlll, llllllllllllllIIlIllIIlIlIllllll, llllllllllllllIIlIllIIlIllIIlIlI, llllllllllllllIIlIllIIlIllIIlIll, llllllllllllllIIlIllIIlIllIIlIIl, llllllllllllllIIlIllIIlIllIlIIll);
                        }
                    }
                }
            }
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIIlIllIIllIIIlllIl, final TemplateManager llllllllllllllIIlIllIIllIIIlllII) {
        }
        
        protected Piece(final int llllllllllllllIIlIllIIllIIlIlIlI, final EnumFacing llllllllllllllIIlIllIIllIIllIlII, final RoomDefinition llllllllllllllIIlIllIIllIIllIIll, final int llllllllllllllIIlIllIIllIIllIIlI, final int llllllllllllllIIlIllIIllIIllIIIl, final int llllllllllllllIIlIllIIllIIllIIII) {
            super(llllllllllllllIIlIllIIllIIlIlIlI);
            this.setCoordBaseMode(llllllllllllllIIlIllIIllIIllIlII);
            this.roomDefinition = llllllllllllllIIlIllIIllIIllIIll;
            final int llllllllllllllIIlIllIIllIIlIllll = llllllllllllllIIlIllIIllIIllIIll.index;
            final int llllllllllllllIIlIllIIllIIlIlllI = llllllllllllllIIlIllIIllIIlIllll % 5;
            final int llllllllllllllIIlIllIIllIIlIllIl = llllllllllllllIIlIllIIllIIlIllll / 5 % 5;
            final int llllllllllllllIIlIllIIllIIlIllII = llllllllllllllIIlIllIIllIIlIllll / 25;
            if (llllllllllllllIIlIllIIllIIllIlII != EnumFacing.NORTH && llllllllllllllIIlIllIIllIIllIlII != EnumFacing.SOUTH) {
                this.boundingBox = new StructureBoundingBox(0, 0, 0, llllllllllllllIIlIllIIllIIllIIII * 8 - 1, llllllllllllllIIlIllIIllIIllIIIl * 4 - 1, llllllllllllllIIlIllIIllIIllIIlI * 8 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(0, 0, 0, llllllllllllllIIlIllIIllIIllIIlI * 8 - 1, llllllllllllllIIlIllIIllIIllIIIl * 4 - 1, llllllllllllllIIlIllIIllIIllIIII * 8 - 1);
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIIlIllIIllIIllIlII.ordinal()]) {
                case 3: {
                    this.boundingBox.offset(llllllllllllllIIlIllIIllIIlIlllI * 8, llllllllllllllIIlIllIIllIIlIllII * 4, -(llllllllllllllIIlIllIIllIIlIllIl + llllllllllllllIIlIllIIllIIllIIII) * 8 + 1);
                    break;
                }
                case 4: {
                    this.boundingBox.offset(llllllllllllllIIlIllIIllIIlIlllI * 8, llllllllllllllIIlIllIIllIIlIllII * 4, llllllllllllllIIlIllIIllIIlIllIl * 8);
                    break;
                }
                case 5: {
                    this.boundingBox.offset(-(llllllllllllllIIlIllIIllIIlIllIl + llllllllllllllIIlIllIIllIIllIIII) * 8 + 1, llllllllllllllIIlIllIIllIIlIllII * 4, llllllllllllllIIlIllIIllIIlIlllI * 8);
                    break;
                }
                default: {
                    this.boundingBox.offset(llllllllllllllIIlIllIIllIIlIllIl * 8, llllllllllllllIIlIllIIllIIlIllII * 4, llllllllllllllIIlIllIIllIIlIlllI * 8);
                    break;
                }
            }
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Piece.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final String llllllllllllllIIlIllIIlIIlllIlII = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllllllIIlIllIIlIIlllIlII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllIIlIllIIlIIlllIlII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllllIIlIllIIlIIlllIlII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllllIIlIllIIlIIlllIlII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllllllIIlIllIIlIIlllIlII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllllllIIlIllIIlIIlllIlII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Piece.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIIlIllIIlIIlllIlII;
        }
        
        protected boolean doesChunkIntersect(final StructureBoundingBox llllllllllllllIIlIllIIlIlIlIIllI, final int llllllllllllllIIlIllIIlIlIlIIlIl, final int llllllllllllllIIlIllIIlIlIlIIlII, final int llllllllllllllIIlIllIIlIlIlIllIl, final int llllllllllllllIIlIllIIlIlIlIIIlI) {
            final int llllllllllllllIIlIllIIlIlIlIlIll = this.getXWithOffset(llllllllllllllIIlIllIIlIlIlIIlIl, llllllllllllllIIlIllIIlIlIlIIlII);
            final int llllllllllllllIIlIllIIlIlIlIlIlI = this.getZWithOffset(llllllllllllllIIlIllIIlIlIlIIlIl, llllllllllllllIIlIllIIlIlIlIIlII);
            final int llllllllllllllIIlIllIIlIlIlIlIIl = this.getXWithOffset(llllllllllllllIIlIllIIlIlIlIllIl, llllllllllllllIIlIllIIlIlIlIIIlI);
            final int llllllllllllllIIlIllIIlIlIlIlIII = this.getZWithOffset(llllllllllllllIIlIllIIlIlIlIllIl, llllllllllllllIIlIllIIlIlIlIIIlI);
            return llllllllllllllIIlIllIIlIlIlIIllI.intersectsWith(Math.min(llllllllllllllIIlIllIIlIlIlIlIll, llllllllllllllIIlIllIIlIlIlIlIIl), Math.min(llllllllllllllIIlIllIIlIlIlIlIlI, llllllllllllllIIlIllIIlIlIlIlIII), Math.max(llllllllllllllIIlIllIIlIlIlIlIll, llllllllllllllIIlIllIIlIlIlIlIIl), Math.max(llllllllllllllIIlIllIIlIlIlIlIlI, llllllllllllllIIlIllIIlIlIlIlIII));
        }
        
        public Piece(final EnumFacing llllllllllllllIIlIllIIllIlIIIllI, final StructureBoundingBox llllllllllllllIIlIllIIllIlIIIIlI) {
            super(1);
            this.setCoordBaseMode(llllllllllllllIIlIllIIllIlIIIllI);
            this.boundingBox = llllllllllllllIIlIllIIllIlIIIIlI;
        }
    }
    
    static class YZDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public Piece create(final EnumFacing lIIIIllIIIllll, final RoomDefinition lIIIIllIIIlIll, final Random lIIIIllIIIllIl) {
            lIIIIllIIIlIll.claimed = true;
            lIIIIllIIIlIll.connections[EnumFacing.NORTH.getIndex()].claimed = true;
            lIIIIllIIIlIll.connections[EnumFacing.UP.getIndex()].claimed = true;
            lIIIIllIIIlIll.connections[EnumFacing.NORTH.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            return new DoubleYZRoom(lIIIIllIIIllll, lIIIIllIIIlIll, lIIIIllIIIllIl);
        }
        
        private YZDoubleRoomFitHelper() {
        }
        
        @Override
        public boolean fits(final RoomDefinition lIIIIllIIlIlll) {
            if (lIIIIllIIlIlll.hasOpening[EnumFacing.NORTH.getIndex()] && !lIIIIllIIlIlll.connections[EnumFacing.NORTH.getIndex()].claimed && lIIIIllIIlIlll.hasOpening[EnumFacing.UP.getIndex()] && !lIIIIllIIlIlll.connections[EnumFacing.UP.getIndex()].claimed) {
                final RoomDefinition lIIIIllIIlIllI = lIIIIllIIlIlll.connections[EnumFacing.NORTH.getIndex()];
                return lIIIIllIIlIllI.hasOpening[EnumFacing.UP.getIndex()] && !lIIIIllIIlIllI.connections[EnumFacing.UP.getIndex()].claimed;
            }
            return false;
        }
    }
    
    public static class DoubleYZRoom extends Piece
    {
        public DoubleYZRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlIllIIIIllIIIlII, final Random lllllllllllllllIlIllIIIIllIIllll, final StructureBoundingBox lllllllllllllllIlIllIIIIllIIIIll) {
            final RoomDefinition lllllllllllllllIlIllIIIIllIIllIl = this.roomDefinition.connections[EnumFacing.NORTH.getIndex()];
            final RoomDefinition lllllllllllllllIlIllIIIIllIIllII = this.roomDefinition;
            final RoomDefinition lllllllllllllllIlIllIIIIllIIlIll = lllllllllllllllIlIllIIIIllIIllIl.connections[EnumFacing.UP.getIndex()];
            final RoomDefinition lllllllllllllllIlIllIIIIllIIlIlI = lllllllllllllllIlIllIIIIllIIllII.connections[EnumFacing.UP.getIndex()];
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 0, 8, lllllllllllllllIlIllIIIIllIIllIl.hasOpening[EnumFacing.DOWN.getIndex()]);
                this.generateDefaultFloor(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 0, 0, lllllllllllllllIlIllIIIIllIIllII.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (lllllllllllllllIlIllIIIIllIIlIlI.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, 8, 1, 6, 8, 7, DoubleYZRoom.ROUGH_PRISMARINE);
            }
            if (lllllllllllllllIlIllIIIIllIIlIll.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, 8, 8, 6, 8, 14, DoubleYZRoom.ROUGH_PRISMARINE);
            }
            for (int lllllllllllllllIlIllIIIIllIIlIIl = 1; lllllllllllllllIlIllIIIIllIIlIIl <= 7; ++lllllllllllllllIlIllIIIIllIIlIIl) {
                IBlockState lllllllllllllllIlIllIIIIllIIlIII = DoubleYZRoom.BRICKS_PRISMARINE;
                if (lllllllllllllllIlIllIIIIllIIlIIl == 2 || lllllllllllllllIlIllIIIIllIIlIIl == 6) {
                    lllllllllllllllIlIllIIIIllIIlIII = DoubleYZRoom.ROUGH_PRISMARINE;
                }
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 0, lllllllllllllllIlIllIIIIllIIlIIl, 0, 0, lllllllllllllllIlIllIIIIllIIlIIl, 15, lllllllllllllllIlIllIIIIllIIlIII, lllllllllllllllIlIllIIIIllIIlIII, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 7, lllllllllllllllIlIllIIIIllIIlIIl, 0, 7, lllllllllllllllIlIllIIIIllIIlIIl, 15, lllllllllllllllIlIllIIIIllIIlIII, lllllllllllllllIlIllIIIIllIIlIII, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, lllllllllllllllIlIllIIIIllIIlIIl, 0, 6, lllllllllllllllIlIllIIIIllIIlIIl, 0, lllllllllllllllIlIllIIIIllIIlIII, lllllllllllllllIlIllIIIIllIIlIII, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, lllllllllllllllIlIllIIIIllIIlIIl, 15, 6, lllllllllllllllIlIllIIIIllIIlIIl, 15, lllllllllllllllIlIllIIIIllIIlIII, lllllllllllllllIlIllIIIIllIIlIII, false);
            }
            for (int lllllllllllllllIlIllIIIIllIIIlll = 1; lllllllllllllllIlIllIIIIllIIIlll <= 7; ++lllllllllllllllIlIllIIIIllIIIlll) {
                IBlockState lllllllllllllllIlIllIIIIllIIIllI = DoubleYZRoom.DARK_PRISMARINE;
                if (lllllllllllllllIlIllIIIIllIIIlll == 2 || lllllllllllllllIlIllIIIIllIIIlll == 6) {
                    lllllllllllllllIlIllIIIIllIIIllI = DoubleYZRoom.SEA_LANTERN;
                }
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 3, lllllllllllllllIlIllIIIIllIIIlll, 7, 4, lllllllllllllllIlIllIIIIllIIIlll, 8, lllllllllllllllIlIllIIIIllIIIllI, lllllllllllllllIlIllIIIIllIIIllI, false);
            }
            if (lllllllllllllllIlIllIIIIllIIllII.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 3, 1, 0, 4, 2, 0, false);
            }
            if (lllllllllllllllIlIllIIIIllIIllII.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 7, 1, 3, 7, 2, 4, false);
            }
            if (lllllllllllllllIlIllIIIIllIIllII.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 0, 1, 3, 0, 2, 4, false);
            }
            if (lllllllllllllllIlIllIIIIllIIllIl.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 3, 1, 15, 4, 2, 15, false);
            }
            if (lllllllllllllllIlIllIIIIllIIllIl.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 0, 1, 11, 0, 2, 12, false);
            }
            if (lllllllllllllllIlIllIIIIllIIllIl.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 7, 1, 11, 7, 2, 12, false);
            }
            if (lllllllllllllllIlIllIIIIllIIlIlI.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 3, 5, 0, 4, 6, 0, false);
            }
            if (lllllllllllllllIlIllIIIIllIIlIlI.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 7, 5, 3, 7, 6, 4, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 5, 4, 2, 6, 4, 5, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 6, 1, 2, 6, 3, 2, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 6, 1, 5, 6, 3, 5, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
            }
            if (lllllllllllllllIlIllIIIIllIIlIlI.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 0, 5, 3, 0, 6, 4, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, 4, 2, 2, 4, 5, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, 1, 2, 1, 3, 2, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, 1, 5, 1, 3, 5, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
            }
            if (lllllllllllllllIlIllIIIIllIIlIll.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 3, 5, 15, 4, 6, 15, false);
            }
            if (lllllllllllllllIlIllIIIIllIIlIll.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 0, 5, 11, 0, 6, 12, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, 4, 10, 2, 4, 13, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, 1, 10, 1, 3, 10, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 1, 1, 13, 1, 3, 13, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
            }
            if (lllllllllllllllIlIllIIIIllIIlIll.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 7, 5, 11, 7, 6, 12, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 5, 4, 10, 6, 4, 13, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 6, 1, 10, 6, 3, 10, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllllIlIllIIIIllIIIlII, lllllllllllllllIlIllIIIIllIIIIll, 6, 1, 13, 6, 3, 13, DoubleYZRoom.BRICKS_PRISMARINE, DoubleYZRoom.BRICKS_PRISMARINE, false);
            }
            return true;
        }
        
        public DoubleYZRoom(final EnumFacing lllllllllllllllIlIllIIIIlllIIIII, final RoomDefinition lllllllllllllllIlIllIIIIllIllIll, final Random lllllllllllllllIlIllIIIIllIllllI) {
            super(1, lllllllllllllllIlIllIIIIlllIIIII, lllllllllllllllIlIllIIIIllIllIll, 1, 2, 2);
        }
    }
    
    interface MonumentRoomFitHelper
    {
        Piece create(final EnumFacing p0, final RoomDefinition p1, final Random p2);
        
        boolean fits(final RoomDefinition p0);
    }
    
    public static class WingRoom extends Piece
    {
        private /* synthetic */ int mainDesign;
        
        public WingRoom() {
        }
        
        public WingRoom(final EnumFacing lllllllllllllIlIIIIIIllIIIllIllI, final StructureBoundingBox lllllllllllllIlIIIIIIllIIIllIIIl, final int lllllllllllllIlIIIIIIllIIIllIlII) {
            super(lllllllllllllIlIIIIIIllIIIllIllI, lllllllllllllIlIIIIIIllIIIllIIIl);
            this.mainDesign = (lllllllllllllIlIIIIIIllIIIllIlII & 0x1);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIlIIIIIIllIIIIIllll, final Random lllllllllllllIlIIIIIIllIIIIIlllI, final StructureBoundingBox lllllllllllllIlIIIIIIllIIIIIllIl) {
            if (this.mainDesign == 0) {
                for (int lllllllllllllIlIIIIIIllIIIIIllII = 0; lllllllllllllIlIIIIIIllIIIIIllII < 4; ++lllllllllllllIlIIIIIIllIIIIIllII) {
                    this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 10 - lllllllllllllIlIIIIIIllIIIIIllII, 3 - lllllllllllllIlIIIIIIllIIIIIllII, 20 - lllllllllllllIlIIIIIIllIIIIIllII, 12 + lllllllllllllIlIIIIIIllIIIIIllII, 3 - lllllllllllllIlIIIIIIllIIIIIllII, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                }
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 7, 0, 6, 15, 0, 16, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 6, 0, 6, 6, 3, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 16, 0, 6, 16, 3, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 7, 1, 7, 7, 1, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 15, 1, 7, 15, 1, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 7, 1, 6, 9, 3, 6, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 13, 1, 6, 15, 3, 6, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 8, 1, 7, 9, 1, 7, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 13, 1, 7, 14, 1, 7, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 9, 0, 5, 13, 0, 5, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 10, 0, 7, 12, 0, 7, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 8, 0, 10, 8, 0, 12, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 14, 0, 10, 14, 0, 12, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                for (int lllllllllllllIlIIIIIIllIIIIIlIll = 18; lllllllllllllIlIIIIIIllIIIIIlIll >= 7; lllllllllllllIlIIIIIIllIIIIIlIll -= 3) {
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 6, 3, lllllllllllllIlIIIIIIllIIIIIlIll, lllllllllllllIlIIIIIIllIIIIIllIl);
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 16, 3, lllllllllllllIlIIIIIIllIIIIIlIll, lllllllllllllIlIIIIIIllIIIIIllIl);
                }
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 10, 0, 10, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 12, 0, 10, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 10, 0, 12, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 12, 0, 12, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 8, 3, 6, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 14, 3, 6, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 4, 2, 4, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 4, 1, 4, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 4, 0, 4, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 18, 2, 4, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 18, 1, 4, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 18, 0, 4, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 4, 2, 18, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 4, 1, 18, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 4, 0, 18, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 18, 2, 18, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, 18, 1, 18, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 18, 0, 18, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 9, 7, 20, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, 13, 7, 20, lllllllllllllIlIIIIIIllIIIIIllIl);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 6, 0, 21, 7, 4, 21, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 15, 0, 21, 16, 4, 21, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.spawnElder(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 11, 2, 16);
            }
            else if (this.mainDesign == 1) {
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 9, 3, 18, 13, 3, 20, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 9, 0, 18, 9, 2, 18, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 13, 0, 18, 13, 2, 18, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                int lllllllllllllIlIIIIIIllIIIIIlIIl = 9;
                final int lllllllllllllIlIIIIIIllIIIIIlIII = 20;
                final int lllllllllllllIlIIIIIIllIIIIIIlll = 5;
                for (int lllllllllllllIlIIIIIIllIIIIIIlII = 0; lllllllllllllIlIIIIIIllIIIIIIlII < 2; ++lllllllllllllIlIIIIIIllIIIIIIlII) {
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, lllllllllllllIlIIIIIIllIIIIIlIIl, 6, 20, lllllllllllllIlIIIIIIllIIIIIllIl);
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, lllllllllllllIlIIIIIIllIIIIIlIIl, 5, 20, lllllllllllllIlIIIIIIllIIIIIllIl);
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.BRICKS_PRISMARINE, lllllllllllllIlIIIIIIllIIIIIlIIl, 4, 20, lllllllllllllIlIIIIIIllIIIIIllIl);
                    lllllllllllllIlIIIIIIllIIIIIlIIl = 13;
                }
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 7, 3, 7, 15, 3, 14, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                lllllllllllllIlIIIIIIllIIIIIlIIl = 10;
                for (int lllllllllllllIlIIIIIIllIIIIIIIll = 0; lllllllllllllIlIIIIIIllIIIIIIIll < 2; ++lllllllllllllIlIIIIIIllIIIIIIIll) {
                    this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, lllllllllllllIlIIIIIIllIIIIIlIIl, 0, 10, lllllllllllllIlIIIIIIllIIIIIlIIl, 6, 10, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, lllllllllllllIlIIIIIIllIIIIIlIIl, 0, 12, lllllllllllllIlIIIIIIllIIIIIlIIl, 6, 12, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, lllllllllllllIlIIIIIIllIIIIIlIIl, 0, 10, lllllllllllllIlIIIIIIllIIIIIllIl);
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, lllllllllllllIlIIIIIIllIIIIIlIIl, 0, 12, lllllllllllllIlIIIIIIllIIIIIllIl);
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, lllllllllllllIlIIIIIIllIIIIIlIIl, 4, 10, lllllllllllllIlIIIIIIllIIIIIllIl);
                    this.setBlockState(lllllllllllllIlIIIIIIllIIIIIllll, WingRoom.SEA_LANTERN, lllllllllllllIlIIIIIIllIIIIIlIIl, 4, 12, lllllllllllllIlIIIIIIllIIIIIllIl);
                    lllllllllllllIlIIIIIIllIIIIIlIIl = 12;
                }
                lllllllllllllIlIIIIIIllIIIIIlIIl = 8;
                for (int lllllllllllllIlIIIIIIllIIIIIIIlI = 0; lllllllllllllIlIIIIIIllIIIIIIIlI < 2; ++lllllllllllllIlIIIIIIllIIIIIIIlI) {
                    this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, lllllllllllllIlIIIIIIllIIIIIlIIl, 0, 7, lllllllllllllIlIIIIIIllIIIIIlIIl, 2, 7, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, lllllllllllllIlIIIIIIllIIIIIlIIl, 0, 14, lllllllllllllIlIIIIIIllIIIIIlIIl, 2, 14, WingRoom.BRICKS_PRISMARINE, WingRoom.BRICKS_PRISMARINE, false);
                    lllllllllllllIlIIIIIIllIIIIIlIIl = 14;
                }
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 8, 3, 8, 8, 3, 13, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 14, 3, 8, 14, 3, 13, WingRoom.DARK_PRISMARINE, WingRoom.DARK_PRISMARINE, false);
                this.spawnElder(lllllllllllllIlIIIIIIllIIIIIllll, lllllllllllllIlIIIIIIllIIIIIllIl, 11, 5, 13);
            }
            return true;
        }
    }
    
    public static class Penthouse extends Piece
    {
        @Override
        public boolean addComponentParts(final World lllllllllllllIllIIlllIlllIlllIlI, final Random lllllllllllllIllIIlllIllllIIIllI, final StructureBoundingBox lllllllllllllIllIIlllIllllIIIlII) {
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 2, -1, 2, 11, -1, 11, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 0, -1, 0, 1, -1, 11, Penthouse.ROUGH_PRISMARINE, Penthouse.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 12, -1, 0, 13, -1, 11, Penthouse.ROUGH_PRISMARINE, Penthouse.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 2, -1, 0, 11, -1, 1, Penthouse.ROUGH_PRISMARINE, Penthouse.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 2, -1, 12, 11, -1, 13, Penthouse.ROUGH_PRISMARINE, Penthouse.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 0, 0, 0, 0, 0, 13, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 13, 0, 0, 13, 0, 13, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 1, 0, 0, 12, 0, 0, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 1, 0, 13, 12, 0, 13, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            for (int lllllllllllllIllIIlllIllllIIIIlI = 2; lllllllllllllIllIIlllIllllIIIIlI <= 11; lllllllllllllIllIIlllIllllIIIIlI += 3) {
                this.setBlockState(lllllllllllllIllIIlllIlllIlllIlI, Penthouse.SEA_LANTERN, 0, 0, lllllllllllllIllIIlllIllllIIIIlI, lllllllllllllIllIIlllIllllIIIlII);
                this.setBlockState(lllllllllllllIllIIlllIlllIlllIlI, Penthouse.SEA_LANTERN, 13, 0, lllllllllllllIllIIlllIllllIIIIlI, lllllllllllllIllIIlllIllllIIIlII);
                this.setBlockState(lllllllllllllIllIIlllIlllIlllIlI, Penthouse.SEA_LANTERN, lllllllllllllIllIIlllIllllIIIIlI, 0, 0, lllllllllllllIllIIlllIllllIIIlII);
            }
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 2, 0, 3, 4, 0, 9, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 9, 0, 3, 11, 0, 9, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 4, 0, 9, 9, 0, 11, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.setBlockState(lllllllllllllIllIIlllIlllIlllIlI, Penthouse.BRICKS_PRISMARINE, 5, 0, 8, lllllllllllllIllIIlllIllllIIIlII);
            this.setBlockState(lllllllllllllIllIIlllIlllIlllIlI, Penthouse.BRICKS_PRISMARINE, 8, 0, 8, lllllllllllllIllIIlllIllllIIIlII);
            this.setBlockState(lllllllllllllIllIIlllIlllIlllIlI, Penthouse.BRICKS_PRISMARINE, 10, 0, 10, lllllllllllllIllIIlllIllllIIIlII);
            this.setBlockState(lllllllllllllIllIIlllIlllIlllIlI, Penthouse.BRICKS_PRISMARINE, 3, 0, 10, lllllllllllllIllIIlllIllllIIIlII);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 3, 0, 3, 3, 0, 7, Penthouse.DARK_PRISMARINE, Penthouse.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 10, 0, 3, 10, 0, 7, Penthouse.DARK_PRISMARINE, Penthouse.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 6, 0, 10, 7, 0, 10, Penthouse.DARK_PRISMARINE, Penthouse.DARK_PRISMARINE, false);
            int lllllllllllllIllIIlllIllllIIIIII = 3;
            for (int lllllllllllllIllIIlllIlllIllllll = 0; lllllllllllllIllIIlllIlllIllllll < 2; ++lllllllllllllIllIIlllIlllIllllll) {
                for (int lllllllllllllIllIIlllIlllIllllIl = 2; lllllllllllllIllIIlllIlllIllllIl <= 8; lllllllllllllIllIIlllIlllIllllIl += 3) {
                    this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, lllllllllllllIllIIlllIllllIIIIII, 0, lllllllllllllIllIIlllIlllIllllIl, lllllllllllllIllIIlllIllllIIIIII, 2, lllllllllllllIllIIlllIlllIllllIl, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
                }
                lllllllllllllIllIIlllIllllIIIIII = 10;
            }
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 5, 0, 10, 5, 2, 10, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 8, 0, 10, 8, 2, 10, Penthouse.BRICKS_PRISMARINE, Penthouse.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 6, -1, 7, 7, -1, 8, Penthouse.DARK_PRISMARINE, Penthouse.DARK_PRISMARINE, false);
            this.generateWaterBox(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 6, -1, 3, 7, -1, 4, false);
            this.spawnElder(lllllllllllllIllIIlllIlllIlllIlI, lllllllllllllIllIIlllIllllIIIlII, 6, 1, 6);
            return true;
        }
        
        public Penthouse() {
        }
        
        public Penthouse(final EnumFacing lllllllllllllIllIIlllIllllIllIll, final StructureBoundingBox lllllllllllllIllIIlllIllllIllIlI) {
            super(lllllllllllllIllIIlllIllllIllIll, lllllllllllllIllIIlllIllllIllIlI);
        }
    }
    
    public static class MonumentCoreRoom extends Piece
    {
        public MonumentCoreRoom(final EnumFacing lllllllllllllIIIIIllllIlIlIlIllI, final RoomDefinition lllllllllllllIIIIIllllIlIlIlIlIl, final Random lllllllllllllIIIIIllllIlIlIlIlII) {
            super(1, lllllllllllllIIIIIllllIlIlIlIllI, lllllllllllllIIIIIllllIlIlIlIlIl, 2, 2, 2);
        }
        
        public MonumentCoreRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIIIllllIlIIlllllI, final Random lllllllllllllIIIIIllllIlIlIIIlll, final StructureBoundingBox lllllllllllllIIIIIllllIlIIllllIl) {
            this.generateBoxOnFillOnly(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 1, 8, 0, 14, 8, 14, MonumentCoreRoom.ROUGH_PRISMARINE);
            final int lllllllllllllIIIIIllllIlIlIIIlIl = 7;
            IBlockState lllllllllllllIIIIIllllIlIlIIIlII = MonumentCoreRoom.BRICKS_PRISMARINE;
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 0, 7, 0, 0, 7, 15, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 15, 7, 0, 15, 7, 15, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 1, 7, 0, 15, 7, 0, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 1, 7, 15, 14, 7, 15, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
            for (int lllllllllllllIIIIIllllIlIlIIIIll = 1; lllllllllllllIIIIIllllIlIlIIIIll <= 6; ++lllllllllllllIIIIIllllIlIlIIIIll) {
                lllllllllllllIIIIIllllIlIlIIIlII = MonumentCoreRoom.BRICKS_PRISMARINE;
                if (lllllllllllllIIIIIllllIlIlIIIIll == 2 || lllllllllllllIIIIIllllIlIlIIIIll == 6) {
                    lllllllllllllIIIIIllllIlIlIIIlII = MonumentCoreRoom.ROUGH_PRISMARINE;
                }
                for (int lllllllllllllIIIIIllllIlIlIIIIlI = 0; lllllllllllllIIIIIllllIlIlIIIIlI <= 15; lllllllllllllIIIIIllllIlIlIIIIlI += 15) {
                    this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, lllllllllllllIIIIIllllIlIlIIIIlI, lllllllllllllIIIIIllllIlIlIIIIll, 0, lllllllllllllIIIIIllllIlIlIIIIlI, lllllllllllllIIIIIllllIlIlIIIIll, 1, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
                    this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, lllllllllllllIIIIIllllIlIlIIIIlI, lllllllllllllIIIIIllllIlIlIIIIll, 6, lllllllllllllIIIIIllllIlIlIIIIlI, lllllllllllllIIIIIllllIlIlIIIIll, 9, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
                    this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, lllllllllllllIIIIIllllIlIlIIIIlI, lllllllllllllIIIIIllllIlIlIIIIll, 14, lllllllllllllIIIIIllllIlIlIIIIlI, lllllllllllllIIIIIllllIlIlIIIIll, 15, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
                }
                this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 1, lllllllllllllIIIIIllllIlIlIIIIll, 0, 1, lllllllllllllIIIIIllllIlIlIIIIll, 0, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
                this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 6, lllllllllllllIIIIIllllIlIlIIIIll, 0, 9, lllllllllllllIIIIIllllIlIlIIIIll, 0, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
                this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 14, lllllllllllllIIIIIllllIlIlIIIIll, 0, 14, lllllllllllllIIIIIllllIlIlIIIIll, 0, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
                this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 1, lllllllllllllIIIIIllllIlIlIIIIll, 15, 14, lllllllllllllIIIIIllllIlIlIIIIll, 15, lllllllllllllIIIIIllllIlIlIIIlII, lllllllllllllIIIIIllllIlIlIIIlII, false);
            }
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 6, 3, 6, 9, 6, 9, MonumentCoreRoom.DARK_PRISMARINE, MonumentCoreRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 7, 4, 7, 8, 5, 8, Blocks.GOLD_BLOCK.getDefaultState(), Blocks.GOLD_BLOCK.getDefaultState(), false);
            for (int lllllllllllllIIIIIllllIlIlIIIIIl = 3; lllllllllllllIIIIIllllIlIlIIIIIl <= 6; lllllllllllllIIIIIllllIlIlIIIIIl += 3) {
                for (int lllllllllllllIIIIIllllIlIlIIIIII = 6; lllllllllllllIIIIIllllIlIlIIIIII <= 9; lllllllllllllIIIIIllllIlIlIIIIII += 3) {
                    this.setBlockState(lllllllllllllIIIIIllllIlIIlllllI, MonumentCoreRoom.SEA_LANTERN, lllllllllllllIIIIIllllIlIlIIIIII, lllllllllllllIIIIIllllIlIlIIIIIl, 6, lllllllllllllIIIIIllllIlIIllllIl);
                    this.setBlockState(lllllllllllllIIIIIllllIlIIlllllI, MonumentCoreRoom.SEA_LANTERN, lllllllllllllIIIIIllllIlIlIIIIII, lllllllllllllIIIIIllllIlIlIIIIIl, 9, lllllllllllllIIIIIllllIlIIllllIl);
                }
            }
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 5, 1, 6, 5, 2, 6, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 5, 1, 9, 5, 2, 9, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 10, 1, 6, 10, 2, 6, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 10, 1, 9, 10, 2, 9, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 6, 1, 5, 6, 2, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 9, 1, 5, 9, 2, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 6, 1, 10, 6, 2, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 9, 1, 10, 9, 2, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 5, 2, 5, 5, 6, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 5, 2, 10, 5, 6, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 10, 2, 5, 10, 6, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 10, 2, 10, 10, 6, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 5, 7, 1, 5, 7, 6, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 10, 7, 1, 10, 7, 6, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 5, 7, 9, 5, 7, 14, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 10, 7, 9, 10, 7, 14, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 1, 7, 5, 6, 7, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 1, 7, 10, 6, 7, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 9, 7, 5, 14, 7, 5, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 9, 7, 10, 14, 7, 10, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 2, 1, 2, 2, 1, 3, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 3, 1, 2, 3, 1, 2, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 13, 1, 2, 13, 1, 3, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 12, 1, 2, 12, 1, 2, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 2, 1, 12, 2, 1, 13, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 3, 1, 13, 3, 1, 13, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 13, 1, 12, 13, 1, 13, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIIIllllIlIIlllllI, lllllllllllllIIIIIllllIlIIllllIl, 12, 1, 13, 12, 1, 13, MonumentCoreRoom.BRICKS_PRISMARINE, MonumentCoreRoom.BRICKS_PRISMARINE, false);
            return true;
        }
    }
    
    public static class DoubleZRoom extends Piece
    {
        @Override
        public boolean addComponentParts(final World lllllllllllllllllIlIIlIlIIllllIl, final Random lllllllllllllllllIlIIlIlIlIIIIlI, final StructureBoundingBox lllllllllllllllllIlIIlIlIlIIIIIl) {
            final RoomDefinition lllllllllllllllllIlIIlIlIlIIIIII = this.roomDefinition.connections[EnumFacing.NORTH.getIndex()];
            final RoomDefinition lllllllllllllllllIlIIlIlIIllllll = this.roomDefinition;
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 0, 8, lllllllllllllllllIlIIlIlIlIIIIII.hasOpening[EnumFacing.DOWN.getIndex()]);
                this.generateDefaultFloor(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 0, 0, lllllllllllllllllIlIIlIlIIllllll.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (lllllllllllllllllIlIIlIlIIllllll.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 4, 1, 6, 4, 7, DoubleZRoom.ROUGH_PRISMARINE);
            }
            if (lllllllllllllllllIlIIlIlIlIIIIII.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 4, 8, 6, 4, 14, DoubleZRoom.ROUGH_PRISMARINE);
            }
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 0, 3, 0, 0, 3, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 7, 3, 0, 7, 3, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 3, 0, 7, 3, 0, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 3, 15, 6, 3, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 0, 2, 0, 0, 2, 15, DoubleZRoom.ROUGH_PRISMARINE, DoubleZRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 7, 2, 0, 7, 2, 15, DoubleZRoom.ROUGH_PRISMARINE, DoubleZRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 2, 0, 7, 2, 0, DoubleZRoom.ROUGH_PRISMARINE, DoubleZRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 2, 15, 6, 2, 15, DoubleZRoom.ROUGH_PRISMARINE, DoubleZRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 0, 1, 0, 0, 1, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 7, 1, 0, 7, 1, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 1, 0, 7, 1, 0, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 1, 15, 6, 1, 15, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 1, 1, 1, 1, 2, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 6, 1, 1, 6, 1, 2, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 3, 1, 1, 3, 2, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 6, 3, 1, 6, 3, 2, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 1, 13, 1, 1, 14, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 6, 1, 13, 6, 1, 14, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 1, 3, 13, 1, 3, 14, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 6, 3, 13, 6, 3, 14, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 2, 1, 6, 2, 3, 6, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 5, 1, 6, 5, 3, 6, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 2, 1, 9, 2, 3, 9, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 5, 1, 9, 5, 3, 9, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 3, 2, 6, 4, 2, 6, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 3, 2, 9, 4, 2, 9, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 2, 2, 7, 2, 2, 8, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 5, 2, 7, 5, 2, 8, DoubleZRoom.BRICKS_PRISMARINE, DoubleZRoom.BRICKS_PRISMARINE, false);
            this.setBlockState(lllllllllllllllllIlIIlIlIIllllIl, DoubleZRoom.SEA_LANTERN, 2, 2, 5, lllllllllllllllllIlIIlIlIlIIIIIl);
            this.setBlockState(lllllllllllllllllIlIIlIlIIllllIl, DoubleZRoom.SEA_LANTERN, 5, 2, 5, lllllllllllllllllIlIIlIlIlIIIIIl);
            this.setBlockState(lllllllllllllllllIlIIlIlIIllllIl, DoubleZRoom.SEA_LANTERN, 2, 2, 10, lllllllllllllllllIlIIlIlIlIIIIIl);
            this.setBlockState(lllllllllllllllllIlIIlIlIIllllIl, DoubleZRoom.SEA_LANTERN, 5, 2, 10, lllllllllllllllllIlIIlIlIlIIIIIl);
            this.setBlockState(lllllllllllllllllIlIIlIlIIllllIl, DoubleZRoom.BRICKS_PRISMARINE, 2, 3, 5, lllllllllllllllllIlIIlIlIlIIIIIl);
            this.setBlockState(lllllllllllllllllIlIIlIlIIllllIl, DoubleZRoom.BRICKS_PRISMARINE, 5, 3, 5, lllllllllllllllllIlIIlIlIlIIIIIl);
            this.setBlockState(lllllllllllllllllIlIIlIlIIllllIl, DoubleZRoom.BRICKS_PRISMARINE, 2, 3, 10, lllllllllllllllllIlIIlIlIlIIIIIl);
            this.setBlockState(lllllllllllllllllIlIIlIlIIllllIl, DoubleZRoom.BRICKS_PRISMARINE, 5, 3, 10, lllllllllllllllllIlIIlIlIlIIIIIl);
            if (lllllllllllllllllIlIIlIlIIllllll.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 3, 1, 0, 4, 2, 0, false);
            }
            if (lllllllllllllllllIlIIlIlIIllllll.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 7, 1, 3, 7, 2, 4, false);
            }
            if (lllllllllllllllllIlIIlIlIIllllll.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 0, 1, 3, 0, 2, 4, false);
            }
            if (lllllllllllllllllIlIIlIlIlIIIIII.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 3, 1, 15, 4, 2, 15, false);
            }
            if (lllllllllllllllllIlIIlIlIlIIIIII.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 0, 1, 11, 0, 2, 12, false);
            }
            if (lllllllllllllllllIlIIlIlIlIIIIII.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllllllIlIIlIlIIllllIl, lllllllllllllllllIlIIlIlIlIIIIIl, 7, 1, 11, 7, 2, 12, false);
            }
            return true;
        }
        
        public DoubleZRoom() {
        }
        
        public DoubleZRoom(final EnumFacing lllllllllllllllllIlIIlIlIlIIllll, final RoomDefinition lllllllllllllllllIlIIlIlIlIIlIlI, final Random lllllllllllllllllIlIIlIlIlIIllIl) {
            super(1, lllllllllllllllllIlIIlIlIlIIllll, lllllllllllllllllIlIIlIlIlIIlIlI, 1, 1, 2);
        }
    }
    
    public static class DoubleYRoom extends Piece
    {
        public DoubleYRoom(final EnumFacing lllllllllllllIlIlIIIllIllIIlIllI, final RoomDefinition lllllllllllllIlIlIIIllIllIIlIlIl, final Random lllllllllllllIlIlIIIllIllIIlIlII) {
            super(1, lllllllllllllIlIlIIIllIllIIlIllI, lllllllllllllIlIlIIIllIllIIlIlIl, 1, 2, 1);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIlIlIIIllIllIIIIlll, final Random lllllllllllllIlIlIIIllIllIIIIllI, final StructureBoundingBox lllllllllllllIlIlIIIllIllIIIIlIl) {
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 0, 0, this.roomDefinition.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            final RoomDefinition lllllllllllllIlIlIIIllIllIIIIlII = this.roomDefinition.connections[EnumFacing.UP.getIndex()];
            if (lllllllllllllIlIlIIIllIllIIIIlII.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 1, 8, 1, 6, 8, 6, DoubleYRoom.ROUGH_PRISMARINE);
            }
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 0, 4, 0, 0, 4, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 7, 4, 0, 7, 4, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 1, 4, 0, 6, 4, 0, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 1, 4, 7, 6, 4, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 2, 4, 1, 2, 4, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 1, 4, 2, 1, 4, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 5, 4, 1, 5, 4, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 6, 4, 2, 6, 4, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 2, 4, 5, 2, 4, 6, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 1, 4, 5, 1, 4, 5, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 5, 4, 5, 5, 4, 6, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 6, 4, 5, 6, 4, 5, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
            RoomDefinition lllllllllllllIlIlIIIllIllIIIIIll = this.roomDefinition;
            for (int lllllllllllllIlIlIIIllIllIIIIIlI = 1; lllllllllllllIlIlIIIllIllIIIIIlI <= 5; lllllllllllllIlIlIIIllIllIIIIIlI += 4) {
                int lllllllllllllIlIlIIIllIllIIIIIIl = 0;
                if (lllllllllllllIlIlIIIllIllIIIIIll.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 2, lllllllllllllIlIlIIIllIllIIIIIlI, lllllllllllllIlIlIIIllIllIIIIIIl, 2, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 5, lllllllllllllIlIlIIIllIllIIIIIlI, lllllllllllllIlIlIIIllIllIIIIIIl, 5, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 3, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, 4, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 0, lllllllllllllIlIlIIIllIllIIIIIlI, lllllllllllllIlIlIIIllIllIIIIIIl, 7, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 0, lllllllllllllIlIlIIIllIllIIIIIlI + 1, lllllllllllllIlIlIIIllIllIIIIIIl, 7, lllllllllllllIlIlIIIllIllIIIIIlI + 1, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.ROUGH_PRISMARINE, DoubleYRoom.ROUGH_PRISMARINE, false);
                }
                lllllllllllllIlIlIIIllIllIIIIIIl = 7;
                if (lllllllllllllIlIlIIIllIllIIIIIll.hasOpening[EnumFacing.NORTH.getIndex()]) {
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 2, lllllllllllllIlIlIIIllIllIIIIIlI, lllllllllllllIlIlIIIllIllIIIIIIl, 2, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 5, lllllllllllllIlIlIIIllIllIIIIIlI, lllllllllllllIlIlIIIllIllIIIIIIl, 5, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 3, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, 4, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 0, lllllllllllllIlIlIIIllIllIIIIIlI, lllllllllllllIlIlIIIllIllIIIIIIl, 7, lllllllllllllIlIlIIIllIllIIIIIlI + 2, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, 0, lllllllllllllIlIlIIIllIllIIIIIlI + 1, lllllllllllllIlIlIIIllIllIIIIIIl, 7, lllllllllllllIlIlIIIllIllIIIIIlI + 1, lllllllllllllIlIlIIIllIllIIIIIIl, DoubleYRoom.ROUGH_PRISMARINE, DoubleYRoom.ROUGH_PRISMARINE, false);
                }
                int lllllllllllllIlIlIIIllIllIIIIIII = 0;
                if (lllllllllllllIlIlIIIllIllIIIIIll.hasOpening[EnumFacing.WEST.getIndex()]) {
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI, 2, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI, 5, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 5, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 3, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 4, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI, 0, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 1, 0, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 1, 7, DoubleYRoom.ROUGH_PRISMARINE, DoubleYRoom.ROUGH_PRISMARINE, false);
                }
                lllllllllllllIlIlIIIllIllIIIIIII = 7;
                if (lllllllllllllIlIlIIIllIllIIIIIll.hasOpening[EnumFacing.EAST.getIndex()]) {
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI, 2, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 2, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI, 5, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 5, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 3, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 4, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI, 0, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 2, 7, DoubleYRoom.BRICKS_PRISMARINE, DoubleYRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIlIlIIIllIllIIIIlll, lllllllllllllIlIlIIIllIllIIIIlIl, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 1, 0, lllllllllllllIlIlIIIllIllIIIIIII, lllllllllllllIlIlIIIllIllIIIIIlI + 1, 7, DoubleYRoom.ROUGH_PRISMARINE, DoubleYRoom.ROUGH_PRISMARINE, false);
                }
                lllllllllllllIlIlIIIllIllIIIIIll = lllllllllllllIlIlIIIllIllIIIIlII;
            }
            return true;
        }
        
        public DoubleYRoom() {
        }
    }
    
    public static class SimpleTopRoom extends Piece
    {
        @Override
        public boolean addComponentParts(final World lllllllllllllllllIIllIlIIIlllIIl, final Random lllllllllllllllllIIllIlIIIlllIII, final StructureBoundingBox lllllllllllllllllIIllIlIIIllIlll) {
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 0, 0, this.roomDefinition.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (this.roomDefinition.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 1, 4, 1, 6, 4, 6, SimpleTopRoom.ROUGH_PRISMARINE);
            }
            for (int lllllllllllllllllIIllIlIIIllIllI = 1; lllllllllllllllllIIllIlIIIllIllI <= 6; ++lllllllllllllllllIIllIlIIIllIllI) {
                for (int lllllllllllllllllIIllIlIIIllIlIl = 1; lllllllllllllllllIIllIlIIIllIlIl <= 6; ++lllllllllllllllllIIllIlIIIllIlIl) {
                    if (lllllllllllllllllIIllIlIIIlllIII.nextInt(3) != 0) {
                        final int lllllllllllllllllIIllIlIIIllIlII = 2 + ((lllllllllllllllllIIllIlIIIlllIII.nextInt(4) != 0) ? 1 : 0);
                        this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, lllllllllllllllllIIllIlIIIllIllI, lllllllllllllllllIIllIlIIIllIlII, lllllllllllllllllIIllIlIIIllIlIl, lllllllllllllllllIIllIlIIIllIllI, 3, lllllllllllllllllIIllIlIIIllIlIl, Blocks.SPONGE.getStateFromMeta(1), Blocks.SPONGE.getStateFromMeta(1), false);
                    }
                }
            }
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 0, 1, 0, 0, 1, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 7, 1, 0, 7, 1, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 1, 1, 0, 6, 1, 0, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 1, 1, 7, 6, 1, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 0, 2, 0, 0, 2, 7, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 7, 2, 0, 7, 2, 7, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 1, 2, 0, 6, 2, 0, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 1, 2, 7, 6, 2, 7, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 0, 3, 0, 0, 3, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 7, 3, 0, 7, 3, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 1, 3, 0, 6, 3, 0, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 1, 3, 7, 6, 3, 7, SimpleTopRoom.BRICKS_PRISMARINE, SimpleTopRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 0, 1, 3, 0, 2, 4, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 7, 1, 3, 7, 2, 4, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 3, 1, 0, 4, 2, 0, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 3, 1, 7, 4, 2, 7, SimpleTopRoom.DARK_PRISMARINE, SimpleTopRoom.DARK_PRISMARINE, false);
            if (this.roomDefinition.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllllllIIllIlIIIlllIIl, lllllllllllllllllIIllIlIIIllIlll, 3, 1, 0, 4, 2, 0, false);
            }
            return true;
        }
        
        public SimpleTopRoom() {
        }
        
        public SimpleTopRoom(final EnumFacing lllllllllllllllllIIllIlIIlIIIlll, final RoomDefinition lllllllllllllllllIIllIlIIlIIIllI, final Random lllllllllllllllllIIllIlIIlIIIlIl) {
            super(1, lllllllllllllllllIIllIlIIlIIIlll, lllllllllllllllllIIllIlIIlIIIllI, 1, 1, 1);
        }
    }
    
    static class XDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public boolean fits(final RoomDefinition llllllllllllllIIIllIIIllIIIlIlII) {
            return llllllllllllllIIIllIIIllIIIlIlII.hasOpening[EnumFacing.EAST.getIndex()] && !llllllllllllllIIIllIIIllIIIlIlII.connections[EnumFacing.EAST.getIndex()].claimed;
        }
        
        @Override
        public Piece create(final EnumFacing llllllllllllllIIIllIIIllIIIIlIll, final RoomDefinition llllllllllllllIIIllIIIllIIIIllIl, final Random llllllllllllllIIIllIIIllIIIIlIIl) {
            llllllllllllllIIIllIIIllIIIIllIl.claimed = true;
            llllllllllllllIIIllIIIllIIIIllIl.connections[EnumFacing.EAST.getIndex()].claimed = true;
            return new DoubleXRoom(llllllllllllllIIIllIIIllIIIIlIll, llllllllllllllIIIllIIIllIIIIllIl, llllllllllllllIIIllIIIllIIIIlIIl);
        }
        
        private XDoubleRoomFitHelper() {
        }
    }
    
    public static class DoubleXRoom extends Piece
    {
        public DoubleXRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIIlllIlIIlIIIllI, final Random llllllllllllllllIIlllIlIIlIIIlIl, final StructureBoundingBox llllllllllllllllIIlllIlIIlIIIlII) {
            final RoomDefinition llllllllllllllllIIlllIlIIlIIIIll = this.roomDefinition.connections[EnumFacing.EAST.getIndex()];
            final RoomDefinition llllllllllllllllIIlllIlIIlIIIIlI = this.roomDefinition;
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 8, 0, llllllllllllllllIIlllIlIIlIIIIll.hasOpening[EnumFacing.DOWN.getIndex()]);
                this.generateDefaultFloor(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 0, 0, llllllllllllllllIIlllIlIIlIIIIlI.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (llllllllllllllllIIlllIlIIlIIIIlI.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 1, 4, 1, 7, 4, 6, DoubleXRoom.ROUGH_PRISMARINE);
            }
            if (llllllllllllllllIIlllIlIIlIIIIll.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 8, 4, 1, 14, 4, 6, DoubleXRoom.ROUGH_PRISMARINE);
            }
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 0, 3, 0, 0, 3, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 15, 3, 0, 15, 3, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 1, 3, 0, 15, 3, 0, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 1, 3, 7, 14, 3, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 0, 2, 0, 0, 2, 7, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 15, 2, 0, 15, 2, 7, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 1, 2, 0, 15, 2, 0, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 1, 2, 7, 14, 2, 7, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 0, 1, 0, 0, 1, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 15, 1, 0, 15, 1, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 1, 1, 0, 15, 1, 0, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 1, 1, 7, 14, 1, 7, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 5, 1, 0, 10, 1, 4, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 6, 2, 0, 9, 2, 3, DoubleXRoom.ROUGH_PRISMARINE, DoubleXRoom.ROUGH_PRISMARINE, false);
            this.fillWithBlocks(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 5, 3, 0, 10, 3, 4, DoubleXRoom.BRICKS_PRISMARINE, DoubleXRoom.BRICKS_PRISMARINE, false);
            this.setBlockState(llllllllllllllllIIlllIlIIlIIIllI, DoubleXRoom.SEA_LANTERN, 6, 2, 3, llllllllllllllllIIlllIlIIlIIIlII);
            this.setBlockState(llllllllllllllllIIlllIlIIlIIIllI, DoubleXRoom.SEA_LANTERN, 9, 2, 3, llllllllllllllllIIlllIlIIlIIIlII);
            if (llllllllllllllllIIlllIlIIlIIIIlI.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 3, 1, 0, 4, 2, 0, false);
            }
            if (llllllllllllllllIIlllIlIIlIIIIlI.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 3, 1, 7, 4, 2, 7, false);
            }
            if (llllllllllllllllIIlllIlIIlIIIIlI.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 0, 1, 3, 0, 2, 4, false);
            }
            if (llllllllllllllllIIlllIlIIlIIIIll.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                this.generateWaterBox(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 11, 1, 0, 12, 2, 0, false);
            }
            if (llllllllllllllllIIlllIlIIlIIIIll.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 11, 1, 7, 12, 2, 7, false);
            }
            if (llllllllllllllllIIlllIlIIlIIIIll.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(llllllllllllllllIIlllIlIIlIIIllI, llllllllllllllllIIlllIlIIlIIIlII, 15, 1, 3, 15, 2, 4, false);
            }
            return true;
        }
        
        public DoubleXRoom(final EnumFacing llllllllllllllllIIlllIlIIllIIIII, final RoomDefinition llllllllllllllllIIlllIlIIlIllllI, final Random llllllllllllllllIIlllIlIIllIIlII) {
            super(1, llllllllllllllllIIlllIlIIllIIIII, llllllllllllllllIIlllIlIIlIllllI, 2, 1, 1);
        }
    }
    
    public static class MonumentBuilding extends Piece
    {
        private final /* synthetic */ List<Piece> childPieces;
        private /* synthetic */ RoomDefinition sourceRoom;
        private /* synthetic */ RoomDefinition coreRoom;
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIIIlIIIlllllIlII, final Random lllllllllllllIIlIIIlIIIllllIIllI, final StructureBoundingBox lllllllllllllIIlIIIlIIIlllllIIlI) {
            final int lllllllllllllIIlIIIlIIIlllllIIIl = Math.max(lllllllllllllIIlIIIlIIIlllllIlII.getSeaLevel(), 64) - this.boundingBox.minY;
            this.generateWaterBox(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIlllllIIlI, 0, 0, 0, 58, lllllllllllllIIlIIIlIIIlllllIIIl, 58, false);
            this.generateWing(false, 0, lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
            this.generateWing(true, 33, lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
            this.generateEntranceArchs(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
            this.generateEntranceWall(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
            this.generateRoofPiece(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
            this.generateLowerWall(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
            this.generateMiddleWall(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
            this.generateUpperWall(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
            for (int lllllllllllllIIlIIIlIIIlllllIIII = 0; lllllllllllllIIlIIIlIIIlllllIIII < 7; ++lllllllllllllIIlIIIlIIIlllllIIII) {
                int lllllllllllllIIlIIIlIIIllllIllll = 0;
                while (lllllllllllllIIlIIIlIIIllllIllll < 7) {
                    if (lllllllllllllIIlIIIlIIIllllIllll == 0 && lllllllllllllIIlIIIlIIIlllllIIII == 3) {
                        lllllllllllllIIlIIIlIIIllllIllll = 6;
                    }
                    final int lllllllllllllIIlIIIlIIIllllIlllI = lllllllllllllIIlIIIlIIIlllllIIII * 9;
                    final int lllllllllllllIIlIIIlIIIllllIllIl = lllllllllllllIIlIIIlIIIllllIllll * 9;
                    for (int lllllllllllllIIlIIIlIIIllllIllII = 0; lllllllllllllIIlIIIlIIIllllIllII < 4; ++lllllllllllllIIlIIIlIIIllllIllII) {
                        for (int lllllllllllllIIlIIIlIIIllllIlIll = 0; lllllllllllllIIlIIIlIIIllllIlIll < 4; ++lllllllllllllIIlIIIlIIIllllIlIll) {
                            this.setBlockState(lllllllllllllIIlIIIlIIIlllllIlII, MonumentBuilding.BRICKS_PRISMARINE, lllllllllllllIIlIIIlIIIllllIlllI + lllllllllllllIIlIIIlIIIllllIllII, 0, lllllllllllllIIlIIIlIIIllllIllIl + lllllllllllllIIlIIIlIIIllllIlIll, lllllllllllllIIlIIIlIIIlllllIIlI);
                            this.replaceAirAndLiquidDownwards(lllllllllllllIIlIIIlIIIlllllIlII, MonumentBuilding.BRICKS_PRISMARINE, lllllllllllllIIlIIIlIIIllllIlllI + lllllllllllllIIlIIIlIIIllllIllII, -1, lllllllllllllIIlIIIlIIIllllIllIl + lllllllllllllIIlIIIlIIIllllIlIll, lllllllllllllIIlIIIlIIIlllllIIlI);
                        }
                    }
                    if (lllllllllllllIIlIIIlIIIlllllIIII != 0 && lllllllllllllIIlIIIlIIIlllllIIII != 6) {
                        lllllllllllllIIlIIIlIIIllllIllll += 6;
                    }
                    else {
                        ++lllllllllllllIIlIIIlIIIllllIllll;
                    }
                }
            }
            for (int lllllllllllllIIlIIIlIIIllllIlIlI = 0; lllllllllllllIIlIIIlIIIllllIlIlI < 5; ++lllllllllllllIIlIIIlIIIllllIlIlI) {
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIlllllIIlI, -1 - lllllllllllllIIlIIIlIIIllllIlIlI, 0 + lllllllllllllIIlIIIlIIIllllIlIlI * 2, -1 - lllllllllllllIIlIIIlIIIllllIlIlI, -1 - lllllllllllllIIlIIIlIIIllllIlIlI, 23, 58 + lllllllllllllIIlIIIlIIIllllIlIlI, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIlllllIIlI, 58 + lllllllllllllIIlIIIlIIIllllIlIlI, 0 + lllllllllllllIIlIIIlIIIllllIlIlI * 2, -1 - lllllllllllllIIlIIIlIIIllllIlIlI, 58 + lllllllllllllIIlIIIlIIIllllIlIlI, 23, 58 + lllllllllllllIIlIIIlIIIllllIlIlI, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIlllllIIlI, 0 - lllllllllllllIIlIIIlIIIllllIlIlI, 0 + lllllllllllllIIlIIIlIIIllllIlIlI * 2, -1 - lllllllllllllIIlIIIlIIIllllIlIlI, 57 + lllllllllllllIIlIIIlIIIllllIlIlI, 23, -1 - lllllllllllllIIlIIIlIIIllllIlIlI, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIlllllIIlI, 0 - lllllllllllllIIlIIIlIIIllllIlIlI, 0 + lllllllllllllIIlIIIlIIIllllIlIlI * 2, 58 + lllllllllllllIIlIIIlIIIllllIlIlI, 57 + lllllllllllllIIlIIIlIIIllllIlIlI, 23, 58 + lllllllllllllIIlIIIlIIIllllIlIlI, false);
            }
            for (final Piece lllllllllllllIIlIIIlIIIllllIlIIl : this.childPieces) {
                if (lllllllllllllIIlIIIlIIIllllIlIIl.getBoundingBox().intersectsWith(lllllllllllllIIlIIIlIIIlllllIIlI)) {
                    lllllllllllllIIlIIIlIIIllllIlIIl.addComponentParts(lllllllllllllIIlIIIlIIIlllllIlII, lllllllllllllIIlIIIlIIIllllIIllI, lllllllllllllIIlIIIlIIIlllllIIlI);
                }
            }
            return true;
        }
        
        public MonumentBuilding(final Random lllllllllllllIIlIIIlIIlIIlIIllll, final int lllllllllllllIIlIIIlIIlIIllIIIIl, final int lllllllllllllIIlIIIlIIlIIlIIllIl, final EnumFacing lllllllllllllIIlIIIlIIlIIlIIllII) {
            super(0);
            this.childPieces = (List<Piece>)Lists.newArrayList();
            this.setCoordBaseMode(lllllllllllllIIlIIIlIIlIIlIIllII);
            final EnumFacing lllllllllllllIIlIIIlIIlIIlIllllI = this.getCoordBaseMode();
            if (lllllllllllllIIlIIIlIIlIIlIllllI.getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(lllllllllllllIIlIIIlIIlIIllIIIIl, 39, lllllllllllllIIlIIIlIIlIIlIIllIl, lllllllllllllIIlIIIlIIlIIllIIIIl + 58 - 1, 61, lllllllllllllIIlIIIlIIlIIlIIllIl + 58 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(lllllllllllllIIlIIIlIIlIIllIIIIl, 39, lllllllllllllIIlIIIlIIlIIlIIllIl, lllllllllllllIIlIIIlIIlIIllIIIIl + 58 - 1, 61, lllllllllllllIIlIIIlIIlIIlIIllIl + 58 - 1);
            }
            final List<RoomDefinition> lllllllllllllIIlIIIlIIlIIlIlllIl = this.generateRoomGraph(lllllllllllllIIlIIIlIIlIIlIIllll);
            this.sourceRoom.claimed = true;
            this.childPieces.add(new EntryRoom(lllllllllllllIIlIIIlIIlIIlIllllI, this.sourceRoom));
            this.childPieces.add(new MonumentCoreRoom(lllllllllllllIIlIIIlIIlIIlIllllI, this.coreRoom, lllllllllllllIIlIIIlIIlIIlIIllll));
            final List<MonumentRoomFitHelper> lllllllllllllIIlIIIlIIlIIlIlllII = (List<MonumentRoomFitHelper>)Lists.newArrayList();
            lllllllllllllIIlIIIlIIlIIlIlllII.add(new XYDoubleRoomFitHelper(null));
            lllllllllllllIIlIIIlIIlIIlIlllII.add(new YZDoubleRoomFitHelper(null));
            lllllllllllllIIlIIIlIIlIIlIlllII.add(new ZDoubleRoomFitHelper(null));
            lllllllllllllIIlIIIlIIlIIlIlllII.add(new XDoubleRoomFitHelper(null));
            lllllllllllllIIlIIIlIIlIIlIlllII.add(new YDoubleRoomFitHelper(null));
            lllllllllllllIIlIIIlIIlIIlIlllII.add(new FitSimpleRoomTopHelper(null));
            lllllllllllllIIlIIIlIIlIIlIlllII.add(new FitSimpleRoomHelper(null));
            for (final RoomDefinition lllllllllllllIIlIIIlIIlIIlIllIll : lllllllllllllIIlIIIlIIlIIlIlllIl) {
                if (!lllllllllllllIIlIIIlIIlIIlIllIll.claimed && !lllllllllllllIIlIIIlIIlIIlIllIll.isSpecial()) {
                    for (final MonumentRoomFitHelper lllllllllllllIIlIIIlIIlIIlIllIIl : lllllllllllllIIlIIIlIIlIIlIlllII) {
                        if (lllllllllllllIIlIIIlIIlIIlIllIIl.fits(lllllllllllllIIlIIIlIIlIIlIllIll)) {
                            this.childPieces.add(lllllllllllllIIlIIIlIIlIIlIllIIl.create(lllllllllllllIIlIIIlIIlIIlIllllI, lllllllllllllIIlIIIlIIlIIlIllIll, lllllllllllllIIlIIIlIIlIIlIIllll));
                            break;
                        }
                    }
                }
            }
            final int lllllllllllllIIlIIIlIIlIIlIllIII = this.boundingBox.minY;
            final int lllllllllllllIIlIIIlIIlIIlIlIlll = this.getXWithOffset(9, 22);
            final int lllllllllllllIIlIIIlIIlIIlIlIllI = this.getZWithOffset(9, 22);
            for (final Piece lllllllllllllIIlIIIlIIlIIlIlIlIl : this.childPieces) {
                lllllllllllllIIlIIIlIIlIIlIlIlIl.getBoundingBox().offset(lllllllllllllIIlIIIlIIlIIlIlIlll, lllllllllllllIIlIIIlIIlIIlIllIII, lllllllllllllIIlIIIlIIlIIlIlIllI);
            }
            final StructureBoundingBox lllllllllllllIIlIIIlIIlIIlIlIlII = StructureBoundingBox.createProper(this.getXWithOffset(1, 1), this.getYWithOffset(1), this.getZWithOffset(1, 1), this.getXWithOffset(23, 21), this.getYWithOffset(8), this.getZWithOffset(23, 21));
            final StructureBoundingBox lllllllllllllIIlIIIlIIlIIlIlIIll = StructureBoundingBox.createProper(this.getXWithOffset(34, 1), this.getYWithOffset(1), this.getZWithOffset(34, 1), this.getXWithOffset(56, 21), this.getYWithOffset(8), this.getZWithOffset(56, 21));
            final StructureBoundingBox lllllllllllllIIlIIIlIIlIIlIlIIlI = StructureBoundingBox.createProper(this.getXWithOffset(22, 22), this.getYWithOffset(13), this.getZWithOffset(22, 22), this.getXWithOffset(35, 35), this.getYWithOffset(17), this.getZWithOffset(35, 35));
            int lllllllllllllIIlIIIlIIlIIlIlIIIl = lllllllllllllIIlIIIlIIlIIlIIllll.nextInt();
            this.childPieces.add(new WingRoom(lllllllllllllIIlIIIlIIlIIlIllllI, lllllllllllllIIlIIIlIIlIIlIlIlII, lllllllllllllIIlIIIlIIlIIlIlIIIl++));
            this.childPieces.add(new WingRoom(lllllllllllllIIlIIIlIIlIIlIllllI, lllllllllllllIIlIIIlIIlIIlIlIIll, lllllllllllllIIlIIIlIIlIIlIlIIIl++));
            this.childPieces.add(new Penthouse(lllllllllllllIIlIIIlIIlIIlIllllI, lllllllllllllIIlIIIlIIlIIlIlIIlI));
        }
        
        private void generateMiddleWall(final World lllllllllllllIIlIIIlIIIlIllllIll, final Random lllllllllllllIIlIIIlIIIlIllllIlI, final StructureBoundingBox lllllllllllllIIlIIIlIIIlIllllIIl) {
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIlIllllIIl, 7, 21, 13, 50)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 7, 0, 21, 13, 0, 50, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 7, 1, 21, 13, 10, 50, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 11, 8, 21, 13, 8, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int lllllllllllllIIlIIIlIIIlIllllIII = 0; lllllllllllllIIlIIIlIIIlIllllIII < 4; ++lllllllllllllIIlIIIlIIIlIllllIII) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, lllllllllllllIIlIIIlIIIlIllllIII + 7, lllllllllllllIIlIIIlIIIlIllllIII + 5, 21, lllllllllllllIIlIIIlIIIlIllllIII + 7, lllllllllllllIIlIIIlIIIlIllllIII + 5, 54, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int lllllllllllllIIlIIIlIIIlIlllIlll = 21; lllllllllllllIIlIIIlIIIlIlllIlll <= 45; lllllllllllllIIlIIIlIIIlIlllIlll += 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, 12, 9, lllllllllllllIIlIIIlIIIlIlllIlll, lllllllllllllIIlIIIlIIIlIllllIIl);
                }
            }
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIlIllllIIl, 44, 21, 50, 54)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 44, 0, 21, 50, 0, 50, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 44, 1, 21, 50, 10, 50, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 44, 8, 21, 46, 8, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int lllllllllllllIIlIIIlIIIlIlllIllI = 0; lllllllllllllIIlIIIlIIIlIlllIllI < 4; ++lllllllllllllIIlIIIlIIIlIlllIllI) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 50 - lllllllllllllIIlIIIlIIIlIlllIllI, lllllllllllllIIlIIIlIIIlIlllIllI + 5, 21, 50 - lllllllllllllIIlIIIlIIIlIlllIllI, lllllllllllllIIlIIIlIIIlIlllIllI + 5, 54, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int lllllllllllllIIlIIIlIIIlIlllIlIl = 21; lllllllllllllIIlIIIlIIIlIlllIlIl <= 45; lllllllllllllIIlIIIlIIIlIlllIlIl += 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, 45, 9, lllllllllllllIIlIIIlIIIlIlllIlIl, lllllllllllllIIlIIIlIIIlIllllIIl);
                }
            }
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIlIllllIIl, 8, 44, 49, 54)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 14, 0, 44, 43, 0, 50, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 14, 1, 44, 43, 10, 50, false);
                for (int lllllllllllllIIlIIIlIIIlIlllIlII = 12; lllllllllllllIIlIIIlIIIlIlllIlII <= 45; lllllllllllllIIlIIIlIIIlIlllIlII += 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 9, 45, lllllllllllllIIlIIIlIIIlIllllIIl);
                    this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 9, 52, lllllllllllllIIlIIIlIIIlIllllIIl);
                    if (lllllllllllllIIlIIIlIIIlIlllIlII == 12 || lllllllllllllIIlIIIlIIIlIlllIlII == 18 || lllllllllllllIIlIIIlIIIlIlllIlII == 24 || lllllllllllllIIlIIIlIIIlIlllIlII == 33 || lllllllllllllIIlIIIlIIIlIlllIlII == 39 || lllllllllllllIIlIIIlIIIlIlllIlII == 45) {
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 9, 47, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 9, 50, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 10, 45, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 10, 46, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 10, 51, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 10, 52, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 11, 47, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 11, 50, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 12, 48, lllllllllllllIIlIIIlIIIlIllllIIl);
                        this.setBlockState(lllllllllllllIIlIIIlIIIlIllllIll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIlllIlII, 12, 49, lllllllllllllIIlIIIlIIIlIllllIIl);
                    }
                }
                for (int lllllllllllllIIlIIIlIIIlIlllIIll = 0; lllllllllllllIIlIIIlIIIlIlllIIll < 3; ++lllllllllllllIIlIIIlIIIlIlllIIll) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 8 + lllllllllllllIIlIIIlIIIlIlllIIll, 5 + lllllllllllllIIlIIIlIIIlIlllIIll, 54, 49 - lllllllllllllIIlIIIlIIIlIlllIIll, 5 + lllllllllllllIIlIIIlIIIlIlllIIll, 54, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                }
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 11, 8, 54, 46, 8, 54, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIllllIll, lllllllllllllIIlIIIlIIIlIllllIIl, 14, 8, 44, 43, 8, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
        }
        
        private List<RoomDefinition> generateRoomGraph(final Random lllllllllllllIIlIIIlIIlIIIIIlllI) {
            final RoomDefinition[] lllllllllllllIIlIIIlIIlIIIllIIII = new RoomDefinition[75];
            for (int lllllllllllllIIlIIIlIIlIIIlIllll = 0; lllllllllllllIIlIIIlIIlIIIlIllll < 5; ++lllllllllllllIIlIIIlIIlIIIlIllll) {
                for (int lllllllllllllIIlIIIlIIlIIIlIlllI = 0; lllllllllllllIIlIIIlIIlIIIlIlllI < 4; ++lllllllllllllIIlIIIlIIlIIIlIlllI) {
                    final int lllllllllllllIIlIIIlIIlIIIlIllIl = 0;
                    final int lllllllllllllIIlIIIlIIlIIIlIllII = Piece.getRoomIndex(lllllllllllllIIlIIIlIIlIIIlIllll, 0, lllllllllllllIIlIIIlIIlIIIlIlllI);
                    lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIlIllII] = new RoomDefinition(lllllllllllllIIlIIIlIIlIIIlIllII);
                }
            }
            for (int lllllllllllllIIlIIIlIIlIIIlIlIll = 0; lllllllllllllIIlIIIlIIlIIIlIlIll < 5; ++lllllllllllllIIlIIIlIIlIIIlIlIll) {
                for (int lllllllllllllIIlIIIlIIlIIIlIlIlI = 0; lllllllllllllIIlIIIlIIlIIIlIlIlI < 4; ++lllllllllllllIIlIIIlIIlIIIlIlIlI) {
                    final int lllllllllllllIIlIIIlIIlIIIlIlIIl = 1;
                    final int lllllllllllllIIlIIIlIIlIIIlIlIII = Piece.getRoomIndex(lllllllllllllIIlIIIlIIlIIIlIlIll, 1, lllllllllllllIIlIIIlIIlIIIlIlIlI);
                    lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIlIlIII] = new RoomDefinition(lllllllllllllIIlIIIlIIlIIIlIlIII);
                }
            }
            for (int lllllllllllllIIlIIIlIIlIIIlIIlll = 1; lllllllllllllIIlIIIlIIlIIIlIIlll < 4; ++lllllllllllllIIlIIIlIIlIIIlIIlll) {
                for (int lllllllllllllIIlIIIlIIlIIIlIIllI = 0; lllllllllllllIIlIIIlIIlIIIlIIllI < 2; ++lllllllllllllIIlIIIlIIlIIIlIIllI) {
                    final int lllllllllllllIIlIIIlIIlIIIlIIlIl = 2;
                    final int lllllllllllllIIlIIIlIIlIIIlIIlII = Piece.getRoomIndex(lllllllllllllIIlIIIlIIlIIIlIIlll, 2, lllllllllllllIIlIIIlIIlIIIlIIllI);
                    lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIlIIlII] = new RoomDefinition(lllllllllllllIIlIIIlIIlIIIlIIlII);
                }
            }
            this.sourceRoom = lllllllllllllIIlIIIlIIlIIIllIIII[MonumentBuilding.GRIDROOM_SOURCE_INDEX];
            for (int lllllllllllllIIlIIIlIIlIIIlIIIll = 0; lllllllllllllIIlIIIlIIlIIIlIIIll < 5; ++lllllllllllllIIlIIIlIIlIIIlIIIll) {
                for (int lllllllllllllIIlIIIlIIlIIIlIIIlI = 0; lllllllllllllIIlIIIlIIlIIIlIIIlI < 5; ++lllllllllllllIIlIIIlIIlIIIlIIIlI) {
                    for (int lllllllllllllIIlIIIlIIlIIIlIIIIl = 0; lllllllllllllIIlIIIlIIlIIIlIIIIl < 3; ++lllllllllllllIIlIIIlIIlIIIlIIIIl) {
                        final int lllllllllllllIIlIIIlIIlIIIlIIIII = Piece.getRoomIndex(lllllllllllllIIlIIIlIIlIIIlIIIll, lllllllllllllIIlIIIlIIlIIIlIIIIl, lllllllllllllIIlIIIlIIlIIIlIIIlI);
                        if (lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIlIIIII] != null) {
                            final char lllllllllllllIIlIIIlIIlIIIIIIlIl;
                            final short lllllllllllllIIlIIIlIIlIIIIIIllI = (short)((EnumFacing[])(Object)(lllllllllllllIIlIIIlIIlIIIIIIlIl = (char)(Object)EnumFacing.values())).length;
                            for (long lllllllllllllIIlIIIlIIlIIIIIIlll = 0; lllllllllllllIIlIIIlIIlIIIIIIlll < lllllllllllllIIlIIIlIIlIIIIIIllI; ++lllllllllllllIIlIIIlIIlIIIIIIlll) {
                                final EnumFacing lllllllllllllIIlIIIlIIlIIIIlllll = lllllllllllllIIlIIIlIIlIIIIIIlIl[lllllllllllllIIlIIIlIIlIIIIIIlll];
                                final int lllllllllllllIIlIIIlIIlIIIIllllI = lllllllllllllIIlIIIlIIlIIIlIIIll + lllllllllllllIIlIIIlIIlIIIIlllll.getFrontOffsetX();
                                final int lllllllllllllIIlIIIlIIlIIIIlllIl = lllllllllllllIIlIIIlIIlIIIlIIIIl + lllllllllllllIIlIIIlIIlIIIIlllll.getFrontOffsetY();
                                final int lllllllllllllIIlIIIlIIlIIIIlllII = lllllllllllllIIlIIIlIIlIIIlIIIlI + lllllllllllllIIlIIIlIIlIIIIlllll.getFrontOffsetZ();
                                if (lllllllllllllIIlIIIlIIlIIIIllllI >= 0 && lllllllllllllIIlIIIlIIlIIIIllllI < 5 && lllllllllllllIIlIIIlIIlIIIIlllII >= 0 && lllllllllllllIIlIIIlIIlIIIIlllII < 5 && lllllllllllllIIlIIIlIIlIIIIlllIl >= 0 && lllllllllllllIIlIIIlIIlIIIIlllIl < 3) {
                                    final int lllllllllllllIIlIIIlIIlIIIIllIll = Piece.getRoomIndex(lllllllllllllIIlIIIlIIlIIIIllllI, lllllllllllllIIlIIIlIIlIIIIlllIl, lllllllllllllIIlIIIlIIlIIIIlllII);
                                    if (lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIIllIll] != null) {
                                        if (lllllllllllllIIlIIIlIIlIIIIlllII == lllllllllllllIIlIIIlIIlIIIlIIIlI) {
                                            lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIlIIIII].setConnection(lllllllllllllIIlIIIlIIlIIIIlllll, lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIIllIll]);
                                        }
                                        else {
                                            lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIlIIIII].setConnection(lllllllllllllIIlIIIlIIlIIIIlllll.getOpposite(), lllllllllllllIIlIIIlIIlIIIllIIII[lllllllllllllIIlIIIlIIlIIIIllIll]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final RoomDefinition lllllllllllllIIlIIIlIIlIIIIllIlI = new RoomDefinition(1003);
            final RoomDefinition lllllllllllllIIlIIIlIIlIIIIllIIl = new RoomDefinition(1001);
            final RoomDefinition lllllllllllllIIlIIIlIIlIIIIllIII = new RoomDefinition(1002);
            lllllllllllllIIlIIIlIIlIIIllIIII[MonumentBuilding.GRIDROOM_TOP_CONNECT_INDEX].setConnection(EnumFacing.UP, lllllllllllllIIlIIIlIIlIIIIllIlI);
            lllllllllllllIIlIIIlIIlIIIllIIII[MonumentBuilding.GRIDROOM_LEFTWING_CONNECT_INDEX].setConnection(EnumFacing.SOUTH, lllllllllllllIIlIIIlIIlIIIIllIIl);
            lllllllllllllIIlIIIlIIlIIIllIIII[MonumentBuilding.GRIDROOM_RIGHTWING_CONNECT_INDEX].setConnection(EnumFacing.SOUTH, lllllllllllllIIlIIIlIIlIIIIllIII);
            lllllllllllllIIlIIIlIIlIIIIllIlI.claimed = true;
            lllllllllllllIIlIIIlIIlIIIIllIIl.claimed = true;
            lllllllllllllIIlIIIlIIlIIIIllIII.claimed = true;
            this.sourceRoom.isSource = true;
            this.coreRoom = lllllllllllllIIlIIIlIIlIIIllIIII[Piece.getRoomIndex(lllllllllllllIIlIIIlIIlIIIIIlllI.nextInt(4), 0, 2)];
            this.coreRoom.claimed = true;
            this.coreRoom.connections[EnumFacing.EAST.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.NORTH.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.EAST.getIndex()].connections[EnumFacing.NORTH.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.UP.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.EAST.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.NORTH.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            this.coreRoom.connections[EnumFacing.EAST.getIndex()].connections[EnumFacing.NORTH.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            final List<RoomDefinition> lllllllllllllIIlIIIlIIlIIIIlIlll = (List<RoomDefinition>)Lists.newArrayList();
            char lllllllllllllIIlIIIlIIlIIIIIIlIl;
            short lllllllllllllIIlIIIlIIlIIIIIIllI = (short)((RoomDefinition[])(Object)(lllllllllllllIIlIIIlIIlIIIIIIlIl = (char)(Object)lllllllllllllIIlIIIlIIlIIIllIIII)).length;
            for (long lllllllllllllIIlIIIlIIlIIIIIIlll = 0; lllllllllllllIIlIIIlIIlIIIIIIlll < lllllllllllllIIlIIIlIIlIIIIIIllI; ++lllllllllllllIIlIIIlIIlIIIIIIlll) {
                final RoomDefinition lllllllllllllIIlIIIlIIlIIIIlIllI = lllllllllllllIIlIIIlIIlIIIIIIlIl[lllllllllllllIIlIIIlIIlIIIIIIlll];
                if (lllllllllllllIIlIIIlIIlIIIIlIllI != null) {
                    lllllllllllllIIlIIIlIIlIIIIlIllI.updateOpenings();
                    lllllllllllllIIlIIIlIIlIIIIlIlll.add(lllllllllllllIIlIIIlIIlIIIIlIllI);
                }
            }
            lllllllllllllIIlIIIlIIlIIIIllIlI.updateOpenings();
            Collections.shuffle(lllllllllllllIIlIIIlIIlIIIIlIlll, lllllllllllllIIlIIIlIIlIIIIIlllI);
            int lllllllllllllIIlIIIlIIlIIIIlIlIl = 1;
            lllllllllllllIIlIIIlIIlIIIIIIllI = (short)lllllllllllllIIlIIIlIIlIIIIlIlll.iterator();
            while (((Iterator)lllllllllllllIIlIIIlIIlIIIIIIllI).hasNext()) {
                final RoomDefinition lllllllllllllIIlIIIlIIlIIIIlIlII = ((Iterator<RoomDefinition>)lllllllllllllIIlIIIlIIlIIIIIIllI).next();
                int lllllllllllllIIlIIIlIIlIIIIlIIll = 0;
                int lllllllllllllIIlIIIlIIlIIIIlIIlI = 0;
                while (lllllllllllllIIlIIIlIIlIIIIlIIll < 2 && lllllllllllllIIlIIIlIIlIIIIlIIlI < 5) {
                    ++lllllllllllllIIlIIIlIIlIIIIlIIlI;
                    final int lllllllllllllIIlIIIlIIlIIIIlIIIl = lllllllllllllIIlIIIlIIlIIIIIlllI.nextInt(6);
                    if (lllllllllllllIIlIIIlIIlIIIIlIlII.hasOpening[lllllllllllllIIlIIIlIIlIIIIlIIIl]) {
                        final int lllllllllllllIIlIIIlIIlIIIIlIIII = EnumFacing.getFront(lllllllllllllIIlIIIlIIlIIIIlIIIl).getOpposite().getIndex();
                        lllllllllllllIIlIIIlIIlIIIIlIlII.hasOpening[lllllllllllllIIlIIIlIIlIIIIlIIIl] = false;
                        lllllllllllllIIlIIIlIIlIIIIlIlII.connections[lllllllllllllIIlIIIlIIlIIIIlIIIl].hasOpening[lllllllllllllIIlIIIlIIlIIIIlIIII] = false;
                        if (lllllllllllllIIlIIIlIIlIIIIlIlII.findSource(lllllllllllllIIlIIIlIIlIIIIlIlIl++) && lllllllllllllIIlIIIlIIlIIIIlIlII.connections[lllllllllllllIIlIIIlIIlIIIIlIIIl].findSource(lllllllllllllIIlIIIlIIlIIIIlIlIl++)) {
                            ++lllllllllllllIIlIIIlIIlIIIIlIIll;
                        }
                        else {
                            lllllllllllllIIlIIIlIIlIIIIlIlII.hasOpening[lllllllllllllIIlIIIlIIlIIIIlIIIl] = true;
                            lllllllllllllIIlIIIlIIlIIIIlIlII.connections[lllllllllllllIIlIIIlIIlIIIIlIIIl].hasOpening[lllllllllllllIIlIIIlIIlIIIIlIIII] = true;
                        }
                    }
                }
            }
            lllllllllllllIIlIIIlIIlIIIIlIlll.add(lllllllllllllIIlIIIlIIlIIIIllIlI);
            lllllllllllllIIlIIIlIIlIIIIlIlll.add(lllllllllllllIIlIIIlIIlIIIIllIIl);
            lllllllllllllIIlIIIlIIlIIIIlIlll.add(lllllllllllllIIlIIIlIIlIIIIllIII);
            return lllllllllllllIIlIIIlIIlIIIIlIlll;
        }
        
        private void generateLowerWall(final World lllllllllllllIIlIIIlIIIllIIIIIll, final Random lllllllllllllIIlIIIlIIIllIIIllII, final StructureBoundingBox lllllllllllllIIlIIIlIIIllIIIIIlI) {
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIllIIIIIlI, 0, 21, 6, 58)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 0, 0, 21, 6, 0, 57, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 0, 1, 21, 6, 7, 57, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 4, 4, 21, 6, 4, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int lllllllllllllIIlIIIlIIIllIIIlIlI = 0; lllllllllllllIIlIIIlIIIllIIIlIlI < 4; ++lllllllllllllIIlIIIlIIIllIIIlIlI) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, lllllllllllllIIlIIIlIIIllIIIlIlI, lllllllllllllIIlIIIlIIIllIIIlIlI + 1, 21, lllllllllllllIIlIIIlIIIllIIIlIlI, lllllllllllllIIlIIIlIIIllIIIlIlI + 1, 57 - lllllllllllllIIlIIIlIIIllIIIlIlI, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int lllllllllllllIIlIIIlIIIllIIIlIIl = 23; lllllllllllllIIlIIIlIIIllIIIlIIl < 53; lllllllllllllIIlIIIlIIIllIIIlIIl += 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIIIIIll, MonumentBuilding.DOT_DECO_DATA, 5, 5, lllllllllllllIIlIIIlIIIllIIIlIIl, lllllllllllllIIlIIIlIIIllIIIIIlI);
                }
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIIIIll, MonumentBuilding.DOT_DECO_DATA, 5, 5, 52, lllllllllllllIIlIIIlIIIllIIIIIlI);
                for (int lllllllllllllIIlIIIlIIIllIIIlIII = 0; lllllllllllllIIlIIIlIIIllIIIlIII < 4; ++lllllllllllllIIlIIIlIIIllIIIlIII) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, lllllllllllllIIlIIIlIIIllIIIlIII, lllllllllllllIIlIIIlIIIllIIIlIII + 1, 21, lllllllllllllIIlIIIlIIIllIIIlIII, lllllllllllllIIlIIIlIIIllIIIlIII + 1, 57 - lllllllllllllIIlIIIlIIIllIIIlIII, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 4, 1, 52, 6, 3, 52, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 5, 1, 51, 5, 3, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIllIIIIIlI, 51, 21, 58, 58)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 51, 0, 21, 57, 0, 57, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 51, 1, 21, 57, 7, 57, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 51, 4, 21, 53, 4, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int lllllllllllllIIlIIIlIIIllIIIIlll = 0; lllllllllllllIIlIIIlIIIllIIIIlll < 4; ++lllllllllllllIIlIIIlIIIllIIIIlll) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 57 - lllllllllllllIIlIIIlIIIllIIIIlll, lllllllllllllIIlIIIlIIIllIIIIlll + 1, 21, 57 - lllllllllllllIIlIIIlIIIllIIIIlll, lllllllllllllIIlIIIlIIIllIIIIlll + 1, 57 - lllllllllllllIIlIIIlIIIllIIIIlll, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int lllllllllllllIIlIIIlIIIllIIIIllI = 23; lllllllllllllIIlIIIlIIIllIIIIllI < 53; lllllllllllllIIlIIIlIIIllIIIIllI += 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIIIIIll, MonumentBuilding.DOT_DECO_DATA, 52, 5, lllllllllllllIIlIIIlIIIllIIIIllI, lllllllllllllIIlIIIlIIIllIIIIIlI);
                }
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIIIIll, MonumentBuilding.DOT_DECO_DATA, 52, 5, 52, lllllllllllllIIlIIIlIIIllIIIIIlI);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 51, 1, 52, 53, 3, 52, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 52, 1, 51, 52, 3, 53, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIllIIIIIlI, 0, 51, 57, 57)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 7, 0, 51, 50, 0, 57, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, 7, 1, 51, 50, 10, 57, false);
                for (int lllllllllllllIIlIIIlIIIllIIIIlIl = 0; lllllllllllllIIlIIIlIIIllIIIIlIl < 4; ++lllllllllllllIIlIIIlIIIllIIIIlIl) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIIIIll, lllllllllllllIIlIIIlIIIllIIIIIlI, lllllllllllllIIlIIIlIIIllIIIIlIl + 1, lllllllllllllIIlIIIlIIIllIIIIlIl + 1, 57 - lllllllllllllIIlIIIlIIIllIIIIlIl, 56 - lllllllllllllIIlIIIlIIIllIIIIlIl, lllllllllllllIIlIIIlIIIllIIIIlIl + 1, 57 - lllllllllllllIIlIIIlIIIllIIIIlIl, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
            }
        }
        
        private void generateEntranceArchs(final World lllllllllllllIIlIIIlIIIllIllIIIl, final Random lllllllllllllIIlIIIlIIIllIllIlIl, final StructureBoundingBox lllllllllllllIIlIIIlIIIllIllIlII) {
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIllIllIlII, 22, 5, 35, 17)) {
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIllIIIl, lllllllllllllIIlIIIlIIIllIllIlII, 25, 0, 0, 32, 8, 20, false);
                for (int lllllllllllllIIlIIIlIIIllIllIIll = 0; lllllllllllllIIlIIIlIIIllIllIIll < 4; ++lllllllllllllIIlIIIlIIIllIllIIll) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIllIIIl, lllllllllllllIIlIIIlIIIllIllIlII, 24, 2, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, 24, 4, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIllIIIl, lllllllllllllIIlIIIlIIIllIllIlII, 22, 4, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, 23, 4, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIllIIIl, MonumentBuilding.BRICKS_PRISMARINE, 25, 5, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, lllllllllllllIIlIIIlIIIllIllIlII);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIllIIIl, MonumentBuilding.BRICKS_PRISMARINE, 26, 6, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, lllllllllllllIIlIIIlIIIllIllIlII);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIllIIIl, MonumentBuilding.SEA_LANTERN, 26, 5, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, lllllllllllllIIlIIIlIIIllIllIlII);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIllIIIl, lllllllllllllIIlIIIlIIIllIllIlII, 33, 2, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, 33, 4, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIllIIIl, lllllllllllllIIlIIIlIIIllIllIlII, 34, 4, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, 35, 4, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIllIIIl, MonumentBuilding.BRICKS_PRISMARINE, 32, 5, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, lllllllllllllIIlIIIlIIIllIllIlII);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIllIIIl, MonumentBuilding.BRICKS_PRISMARINE, 31, 6, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, lllllllllllllIIlIIIlIIIllIllIlII);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIllIIIl, MonumentBuilding.SEA_LANTERN, 31, 5, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, lllllllllllllIIlIIIlIIIllIllIlII);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIllIIIl, lllllllllllllIIlIIIlIIIllIllIlII, 27, 6, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, 30, 6, 5 + lllllllllllllIIlIIIlIIIllIllIIll * 4, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                }
            }
        }
        
        private void generateRoofPiece(final World lllllllllllllIIlIIIlIIIllIIlIlIl, final Random lllllllllllllIIlIIIlIIIllIIllIIl, final StructureBoundingBox lllllllllllllIIlIIIlIIIllIIllIII) {
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIllIIllIII, 21, 21, 36, 36)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 21, 0, 22, 36, 0, 36, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 21, 1, 22, 36, 23, 36, false);
                for (int lllllllllllllIIlIIIlIIIllIIlIlll = 0; lllllllllllllIIlIIIlIIIllIIlIlll < 4; ++lllllllllllllIIlIIIlIIIllIIlIlll) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 21 + lllllllllllllIIlIIIlIIIllIIlIlll, 13 + lllllllllllllIIlIIIlIIIllIIlIlll, 21 + lllllllllllllIIlIIIlIIIllIIlIlll, 36 - lllllllllllllIIlIIIlIIIllIIlIlll, 13 + lllllllllllllIIlIIIlIIIllIIlIlll, 21 + lllllllllllllIIlIIIlIIIllIIlIlll, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 21 + lllllllllllllIIlIIIlIIIllIIlIlll, 13 + lllllllllllllIIlIIIlIIIllIIlIlll, 36 - lllllllllllllIIlIIIlIIIllIIlIlll, 36 - lllllllllllllIIlIIIlIIIllIIlIlll, 13 + lllllllllllllIIlIIIlIIIllIIlIlll, 36 - lllllllllllllIIlIIIlIIIllIIlIlll, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 21 + lllllllllllllIIlIIIlIIIllIIlIlll, 13 + lllllllllllllIIlIIIlIIIllIIlIlll, 22 + lllllllllllllIIlIIIlIIIllIIlIlll, 21 + lllllllllllllIIlIIIlIIIllIIlIlll, 13 + lllllllllllllIIlIIIlIIIllIIlIlll, 35 - lllllllllllllIIlIIIlIIIllIIlIlll, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 36 - lllllllllllllIIlIIIlIIIllIIlIlll, 13 + lllllllllllllIIlIIIlIIIllIIlIlll, 22 + lllllllllllllIIlIIIlIIIllIIlIlll, 36 - lllllllllllllIIlIIIlIIIllIIlIlll, 13 + lllllllllllllIIlIIIlIIIllIIlIlll, 35 - lllllllllllllIIlIIIlIIIllIIlIlll, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 25, 16, 25, 32, 16, 32, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 25, 17, 25, 25, 19, 25, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 32, 17, 25, 32, 19, 25, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 25, 17, 32, 25, 19, 32, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 32, 17, 32, 32, 19, 32, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.BRICKS_PRISMARINE, 26, 20, 26, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.BRICKS_PRISMARINE, 27, 21, 27, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.SEA_LANTERN, 27, 20, 27, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.BRICKS_PRISMARINE, 26, 20, 31, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.BRICKS_PRISMARINE, 27, 21, 30, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.SEA_LANTERN, 27, 20, 30, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.BRICKS_PRISMARINE, 31, 20, 31, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.BRICKS_PRISMARINE, 30, 21, 30, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.SEA_LANTERN, 30, 20, 30, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.BRICKS_PRISMARINE, 31, 20, 26, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.BRICKS_PRISMARINE, 30, 21, 27, lllllllllllllIIlIIIlIIIllIIllIII);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIIlIlIl, MonumentBuilding.SEA_LANTERN, 30, 20, 27, lllllllllllllIIlIIIlIIIllIIllIII);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 28, 21, 27, 29, 21, 27, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 27, 21, 28, 27, 21, 29, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 28, 21, 30, 29, 21, 30, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIIlIlIl, lllllllllllllIIlIIIlIIIllIIllIII, 30, 21, 28, 30, 21, 29, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
        }
        
        private void generateWing(final boolean lllllllllllllIIlIIIlIIIlllIIIlII, final int lllllllllllllIIlIIIlIIIlllIlIIIl, final World lllllllllllllIIlIIIlIIIlllIlIIII, final Random lllllllllllllIIlIIIlIIIlllIIllll, final StructureBoundingBox lllllllllllllIIlIIIlIIIlllIIlllI) {
            final int lllllllllllllIIlIIIlIIIlllIIllIl = 24;
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl, 0, lllllllllllllIIlIIIlIIIlllIlIIIl + 23, 20)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 0, 0, 0, lllllllllllllIIlIIIlIIIlllIlIIIl + 24, 0, 20, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 0, 1, 0, lllllllllllllIIlIIIlIIIlllIlIIIl + 24, 10, 20, false);
                for (int lllllllllllllIIlIIIlIIIlllIIllII = 0; lllllllllllllIIlIIIlIIIlllIIllII < 4; ++lllllllllllllIIlIIIlIIIlllIIllII) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIIllII + 1, lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIlIIIl + lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIIllII + 1, 20, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + lllllllllllllIIlIIIlIIIlllIIllII + 7, lllllllllllllIIlIIIlIIIlllIIllII + 5, lllllllllllllIIlIIIlIIIlllIIllII + 7, lllllllllllllIIlIIIlIIIlllIlIIIl + lllllllllllllIIlIIIlIIIlllIIllII + 7, lllllllllllllIIlIIIlIIIlllIIllII + 5, 20, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 17 - lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIIllII + 5, lllllllllllllIIlIIIlIIIlllIIllII + 7, lllllllllllllIIlIIIlIIIlllIlIIIl + 17 - lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIIllII + 5, 20, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 24 - lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIIllII + 1, lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIlIIIl + 24 - lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIIllII + 1, 20, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + lllllllllllllIIlIIIlIIIlllIIllII + 1, lllllllllllllIIlIIIlIIIlllIIllII + 1, lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIlIIIl + 23 - lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIIllII + 1, lllllllllllllIIlIIIlIIIlllIIllII, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + lllllllllllllIIlIIIlIIIlllIIllII + 8, lllllllllllllIIlIIIlIIIlllIIllII + 5, lllllllllllllIIlIIIlIIIlllIIllII + 7, lllllllllllllIIlIIIlIIIlllIlIIIl + 16 - lllllllllllllIIlIIIlIIIlllIIllII, lllllllllllllIIlIIIlIIIlllIIllII + 5, lllllllllllllIIlIIIlIIIlllIIllII + 7, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 4, 4, 4, lllllllllllllIIlIIIlIIIlllIlIIIl + 6, 4, 20, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 7, 4, 4, lllllllllllllIIlIIIlIIIlllIlIIIl + 17, 4, 6, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 18, 4, 4, lllllllllllllIIlIIIlIIIlllIlIIIl + 20, 4, 20, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 11, 8, 11, lllllllllllllIIlIIIlIIIlllIlIIIl + 13, 8, 20, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.setBlockState(lllllllllllllIIlIIIlIIIlllIlIIII, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlllIlIIIl + 12, 9, 12, lllllllllllllIIlIIIlIIIlllIIlllI);
                this.setBlockState(lllllllllllllIIlIIIlIIIlllIlIIII, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlllIlIIIl + 12, 9, 15, lllllllllllllIIlIIIlIIIlllIIlllI);
                this.setBlockState(lllllllllllllIIlIIIlIIIlllIlIIII, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlllIlIIIl + 12, 9, 18, lllllllllllllIIlIIIlIIIlllIIlllI);
                final int lllllllllllllIIlIIIlIIIlllIIlIll = lllllllllllllIIlIIIlIIIlllIlIIIl + (lllllllllllllIIlIIIlIIIlllIIIlII ? 19 : 5);
                final int lllllllllllllIIlIIIlIIIlllIIlIlI = lllllllllllllIIlIIIlIIIlllIlIIIl + (lllllllllllllIIlIIIlIIIlllIIIlII ? 5 : 19);
                for (int lllllllllllllIIlIIIlIIIlllIIlIIl = 20; lllllllllllllIIlIIIlIIIlllIIlIIl >= 5; lllllllllllllIIlIIIlIIIlllIIlIIl -= 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIlllIlIIII, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlllIIlIll, 5, lllllllllllllIIlIIIlIIIlllIIlIIl, lllllllllllllIIlIIIlIIIlllIIlllI);
                }
                for (int lllllllllllllIIlIIIlIIIlllIIlIII = 19; lllllllllllllIIlIIIlIIIlllIIlIII >= 7; lllllllllllllIIlIIIlIIIlllIIlIII -= 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIlllIlIIII, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlllIIlIlI, 5, lllllllllllllIIlIIIlIIIlllIIlIII, lllllllllllllIIlIIIlIIIlllIIlllI);
                }
                for (int lllllllllllllIIlIIIlIIIlllIIIlll = 0; lllllllllllllIIlIIIlIIIlllIIIlll < 4; ++lllllllllllllIIlIIIlIIIlllIIIlll) {
                    final int lllllllllllllIIlIIIlIIIlllIIIllI = lllllllllllllIIlIIIlIIIlllIIIlII ? (lllllllllllllIIlIIIlIIIlllIlIIIl + (24 - (17 - lllllllllllllIIlIIIlIIIlllIIIlll * 3))) : (lllllllllllllIIlIIIlIIIlllIlIIIl + 17 - lllllllllllllIIlIIIlIIIlllIIIlll * 3);
                    this.setBlockState(lllllllllllllIIlIIIlIIIlllIlIIII, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlllIIIllI, 5, 5, lllllllllllllIIlIIIlIIIlllIIlllI);
                }
                this.setBlockState(lllllllllllllIIlIIIlIIIlllIlIIII, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlllIIlIlI, 5, 5, lllllllllllllIIlIIIlIIIlllIIlllI);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 11, 1, 12, lllllllllllllIIlIIIlIIIlllIlIIIl + 13, 7, 12, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlllIlIIII, lllllllllllllIIlIIIlIIIlllIIlllI, lllllllllllllIIlIIIlIIIlllIlIIIl + 12, 1, 11, lllllllllllllIIlIIIlIIIlllIlIIIl + 12, 7, 13, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
            }
        }
        
        private void generateUpperWall(final World lllllllllllllIIlIIIlIIIlIlIlllll, final Random lllllllllllllIIlIIIlIIIlIllIlIII, final StructureBoundingBox lllllllllllllIIlIIIlIIIlIllIIlll) {
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIlIllIIlll, 14, 21, 20, 43)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 14, 0, 21, 20, 0, 43, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 14, 1, 22, 20, 14, 43, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 18, 12, 22, 20, 12, 39, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 18, 12, 21, 20, 12, 21, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                for (int lllllllllllllIIlIIIlIIIlIllIIllI = 0; lllllllllllllIIlIIIlIIIlIllIIllI < 4; ++lllllllllllllIIlIIIlIIIlIllIIllI) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, lllllllllllllIIlIIIlIIIlIllIIllI + 14, lllllllllllllIIlIIIlIIIlIllIIllI + 9, 21, lllllllllllllIIlIIIlIIIlIllIIllI + 14, lllllllllllllIIlIIIlIIIlIllIIllI + 9, 43 - lllllllllllllIIlIIIlIIIlIllIIllI, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int lllllllllllllIIlIIIlIIIlIllIIlIl = 23; lllllllllllllIIlIIIlIIIlIllIIlIl <= 39; lllllllllllllIIlIIIlIIIlIllIIlIl += 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIlIlIlllll, MonumentBuilding.DOT_DECO_DATA, 19, 13, lllllllllllllIIlIIIlIIIlIllIIlIl, lllllllllllllIIlIIIlIIIlIllIIlll);
                }
            }
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIlIllIIlll, 37, 21, 43, 43)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 37, 0, 21, 43, 0, 43, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 37, 1, 22, 43, 14, 43, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 37, 12, 22, 39, 12, 39, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 37, 12, 21, 39, 12, 21, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                for (int lllllllllllllIIlIIIlIIIlIllIIlII = 0; lllllllllllllIIlIIIlIIIlIllIIlII < 4; ++lllllllllllllIIlIIIlIIIlIllIIlII) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 43 - lllllllllllllIIlIIIlIIIlIllIIlII, lllllllllllllIIlIIIlIIIlIllIIlII + 9, 21, 43 - lllllllllllllIIlIIIlIIIlIllIIlII, lllllllllllllIIlIIIlIIIlIllIIlII + 9, 43 - lllllllllllllIIlIIIlIIIlIllIIlII, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int lllllllllllllIIlIIIlIIIlIllIIIll = 23; lllllllllllllIIlIIIlIIIlIllIIIll <= 39; lllllllllllllIIlIIIlIIIlIllIIIll += 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIlIlIlllll, MonumentBuilding.DOT_DECO_DATA, 38, 13, lllllllllllllIIlIIIlIIIlIllIIIll, lllllllllllllIIlIIIlIIIlIllIIlll);
                }
            }
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIlIllIIlll, 15, 37, 42, 43)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 21, 0, 37, 36, 0, 43, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 21, 1, 37, 36, 14, 43, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 21, 12, 37, 36, 12, 39, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                for (int lllllllllllllIIlIIIlIIIlIllIIIlI = 0; lllllllllllllIIlIIIlIIIlIllIIIlI < 4; ++lllllllllllllIIlIIIlIIIlIllIIIlI) {
                    this.fillWithBlocks(lllllllllllllIIlIIIlIIIlIlIlllll, lllllllllllllIIlIIIlIIIlIllIIlll, 15 + lllllllllllllIIlIIIlIIIlIllIIIlI, lllllllllllllIIlIIIlIIIlIllIIIlI + 9, 43 - lllllllllllllIIlIIIlIIIlIllIIIlI, 42 - lllllllllllllIIlIIIlIIIlIllIIIlI, lllllllllllllIIlIIIlIIIlIllIIIlI + 9, 43 - lllllllllllllIIlIIIlIIIlIllIIIlI, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                }
                for (int lllllllllllllIIlIIIlIIIlIllIIIIl = 21; lllllllllllllIIlIIIlIIIlIllIIIIl <= 36; lllllllllllllIIlIIIlIIIlIllIIIIl += 3) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIlIlIlllll, MonumentBuilding.DOT_DECO_DATA, lllllllllllllIIlIIIlIIIlIllIIIIl, 13, 38, lllllllllllllIIlIIIlIIIlIllIIlll);
                }
            }
        }
        
        public MonumentBuilding() {
            this.childPieces = (List<Piece>)Lists.newArrayList();
        }
        
        private void generateEntranceWall(final World lllllllllllllIIlIIIlIIIllIlIlIIl, final Random lllllllllllllIIlIIIlIIIllIlIlIII, final StructureBoundingBox lllllllllllllIIlIIIlIIIllIlIIIIl) {
            if (this.doesChunkIntersect(lllllllllllllIIlIIIlIIIllIlIIIIl, 15, 20, 42, 21)) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 15, 0, 21, 42, 0, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 26, 1, 21, 31, 3, 21, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 21, 12, 21, 36, 12, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 17, 11, 21, 40, 11, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 16, 10, 21, 41, 10, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 15, 7, 21, 42, 9, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 16, 6, 21, 41, 6, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 17, 5, 21, 40, 5, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 21, 4, 21, 36, 4, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 22, 3, 21, 26, 3, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 31, 3, 21, 35, 3, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 23, 2, 21, 25, 2, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 32, 2, 21, 34, 2, 21, MonumentBuilding.ROUGH_PRISMARINE, MonumentBuilding.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 28, 4, 20, 29, 4, 21, MonumentBuilding.BRICKS_PRISMARINE, MonumentBuilding.BRICKS_PRISMARINE, false);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.BRICKS_PRISMARINE, 27, 3, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.BRICKS_PRISMARINE, 30, 3, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.BRICKS_PRISMARINE, 26, 2, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.BRICKS_PRISMARINE, 31, 2, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.BRICKS_PRISMARINE, 25, 1, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.BRICKS_PRISMARINE, 32, 1, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                for (int lllllllllllllIIlIIIlIIIllIlIIllI = 0; lllllllllllllIIlIIIlIIIllIlIIllI < 7; ++lllllllllllllIIlIIIlIIIllIlIIllI) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 28 - lllllllllllllIIlIIIlIIIllIlIIllI, 6 + lllllllllllllIIlIIIlIIIllIlIIllI, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 29 + lllllllllllllIIlIIIlIIIllIlIIllI, 6 + lllllllllllllIIlIIIlIIIllIlIIllI, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                }
                for (int lllllllllllllIIlIIIlIIIllIlIIlIl = 0; lllllllllllllIIlIIIlIIIllIlIIlIl < 4; ++lllllllllllllIIlIIIlIIIllIlIIlIl) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 28 - lllllllllllllIIlIIIlIIIllIlIIlIl, 9 + lllllllllllllIIlIIIlIIIllIlIIlIl, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 29 + lllllllllllllIIlIIIlIIIllIlIIlIl, 9 + lllllllllllllIIlIIIlIIIllIlIIlIl, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                }
                this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 28, 12, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 29, 12, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                for (int lllllllllllllIIlIIIlIIIllIlIIlII = 0; lllllllllllllIIlIIIlIIIllIlIIlII < 3; ++lllllllllllllIIlIIIlIIIllIlIIlII) {
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 22 - lllllllllllllIIlIIIlIIIllIlIIlII * 2, 8, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 22 - lllllllllllllIIlIIIlIIIllIlIIlII * 2, 9, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 35 + lllllllllllllIIlIIIlIIIllIlIIlII * 2, 8, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                    this.setBlockState(lllllllllllllIIlIIIlIIIllIlIlIIl, MonumentBuilding.DARK_PRISMARINE, 35 + lllllllllllllIIlIIIlIIIllIlIIlII * 2, 9, 21, lllllllllllllIIlIIIlIIIllIlIIIIl);
                }
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 15, 13, 21, 42, 15, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 15, 1, 21, 15, 6, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 16, 1, 21, 16, 5, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 17, 1, 21, 20, 4, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 21, 1, 21, 21, 3, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 22, 1, 21, 22, 2, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 23, 1, 21, 24, 1, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 42, 1, 21, 42, 6, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 41, 1, 21, 41, 5, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 37, 1, 21, 40, 4, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 36, 1, 21, 36, 3, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 33, 1, 21, 34, 1, 21, false);
                this.generateWaterBox(lllllllllllllIIlIIIlIIIllIlIlIIl, lllllllllllllIIlIIIlIIIllIlIIIIl, 35, 1, 21, 35, 2, 21, false);
            }
        }
    }
    
    static class YDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public Piece create(final EnumFacing lllllllllllllllIIllIIIlIlIIIlIII, final RoomDefinition lllllllllllllllIIllIIIlIlIIIIlll, final Random lllllllllllllllIIllIIIlIlIIIIllI) {
            lllllllllllllllIIllIIIlIlIIIIlll.claimed = true;
            lllllllllllllllIIllIIIlIlIIIIlll.connections[EnumFacing.UP.getIndex()].claimed = true;
            return new DoubleYRoom(lllllllllllllllIIllIIIlIlIIIlIII, lllllllllllllllIIllIIIlIlIIIIlll, lllllllllllllllIIllIIIlIlIIIIllI);
        }
        
        @Override
        public boolean fits(final RoomDefinition lllllllllllllllIIllIIIlIlIIlIIIl) {
            return lllllllllllllllIIllIIIlIlIIlIIIl.hasOpening[EnumFacing.UP.getIndex()] && !lllllllllllllllIIllIIIlIlIIlIIIl.connections[EnumFacing.UP.getIndex()].claimed;
        }
        
        private YDoubleRoomFitHelper() {
        }
    }
    
    static class FitSimpleRoomHelper implements MonumentRoomFitHelper
    {
        @Override
        public Piece create(final EnumFacing lllllllllllllIlllIlllIlIIIIIlllI, final RoomDefinition lllllllllllllIlllIlllIlIIIIlIIll, final Random lllllllllllllIlllIlllIlIIIIIllll) {
            lllllllllllllIlllIlllIlIIIIlIIll.claimed = true;
            return new SimpleRoom(lllllllllllllIlllIlllIlIIIIIlllI, lllllllllllllIlllIlllIlIIIIlIIll, lllllllllllllIlllIlllIlIIIIIllll);
        }
        
        @Override
        public boolean fits(final RoomDefinition lllllllllllllIlllIlllIlIIIlIIIIl) {
            return true;
        }
        
        private FitSimpleRoomHelper() {
        }
    }
    
    public static class SimpleRoom extends Piece
    {
        private /* synthetic */ int mainDesign;
        
        public SimpleRoom(final EnumFacing llllllllllllllllIlIlIIIlllllIlII, final RoomDefinition llllllllllllllllIlIlIIIlllllIlll, final Random llllllllllllllllIlIlIIIlllllIIlI) {
            super(1, llllllllllllllllIlIlIIIlllllIlII, llllllllllllllllIlIlIIIlllllIlll, 1, 1, 1);
            this.mainDesign = llllllllllllllllIlIlIIIlllllIIlI.nextInt(3);
        }
        
        public SimpleRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIlIlIIIllllIIllI, final Random llllllllllllllllIlIlIIIllllIIlIl, final StructureBoundingBox llllllllllllllllIlIlIIIllllIlIIl) {
            if (this.roomDefinition.index / 25 > 0) {
                this.generateDefaultFloor(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 0, this.roomDefinition.hasOpening[EnumFacing.DOWN.getIndex()]);
            }
            if (this.roomDefinition.connections[EnumFacing.UP.getIndex()] == null) {
                this.generateBoxOnFillOnly(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 4, 1, 6, 4, 6, SimpleRoom.ROUGH_PRISMARINE);
            }
            final boolean llllllllllllllllIlIlIIIllllIlIII = this.mainDesign != 0 && llllllllllllllllIlIlIIIllllIIlIl.nextBoolean() && !this.roomDefinition.hasOpening[EnumFacing.DOWN.getIndex()] && !this.roomDefinition.hasOpening[EnumFacing.UP.getIndex()] && this.roomDefinition.countOpenings() > 1;
            if (this.mainDesign == 0) {
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 0, 2, 1, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 3, 0, 2, 3, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 2, 0, 0, 2, 2, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 2, 0, 2, 2, 0, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.SEA_LANTERN, 1, 2, 1, llllllllllllllllIlIlIIIllllIlIIl);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 5, 1, 0, 7, 1, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 5, 3, 0, 7, 3, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 2, 0, 7, 2, 2, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 5, 2, 0, 6, 2, 0, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.SEA_LANTERN, 6, 2, 1, llllllllllllllllIlIlIIIllllIlIIl);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 5, 2, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 3, 5, 2, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 2, 5, 0, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 2, 7, 2, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.SEA_LANTERN, 1, 2, 6, llllllllllllllllIlIlIIIllllIlIIl);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 5, 1, 5, 7, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 5, 3, 5, 7, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 2, 5, 7, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 5, 2, 7, 6, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.SEA_LANTERN, 6, 2, 6, llllllllllllllllIlIlIIIllllIlIIl);
                if (this.roomDefinition.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 3, 0, 4, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 3, 0, 4, 3, 1, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 2, 0, 4, 2, 0, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 1, 0, 4, 1, 1, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.NORTH.getIndex()]) {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 3, 7, 4, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 3, 6, 4, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 2, 7, 4, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 1, 6, 4, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.WEST.getIndex()]) {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 3, 3, 0, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 3, 3, 1, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 2, 3, 0, 2, 4, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 3, 1, 1, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.EAST.getIndex()]) {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 3, 3, 7, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                else {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 6, 3, 3, 7, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 2, 3, 7, 2, 4, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 6, 1, 3, 7, 1, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
            }
            else if (this.mainDesign == 1) {
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 2, 1, 2, 2, 3, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 2, 1, 5, 2, 3, 5, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 5, 1, 5, 5, 3, 5, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 5, 1, 2, 5, 3, 2, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.SEA_LANTERN, 2, 2, 2, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.SEA_LANTERN, 2, 2, 5, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.SEA_LANTERN, 5, 2, 5, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.SEA_LANTERN, 5, 2, 2, llllllllllllllllIlIlIIIllllIlIIl);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 0, 1, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 1, 0, 3, 1, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 7, 1, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 6, 0, 3, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 6, 1, 7, 7, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 1, 6, 7, 3, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 6, 1, 0, 7, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 1, 1, 7, 3, 1, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.ROUGH_PRISMARINE, 1, 2, 0, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.ROUGH_PRISMARINE, 0, 2, 1, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.ROUGH_PRISMARINE, 1, 2, 7, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.ROUGH_PRISMARINE, 0, 2, 6, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.ROUGH_PRISMARINE, 6, 2, 7, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.ROUGH_PRISMARINE, 7, 2, 6, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.ROUGH_PRISMARINE, 6, 2, 0, llllllllllllllllIlIlIIIllllIlIIl);
                this.setBlockState(llllllllllllllllIlIlIIIllllIIllI, SimpleRoom.ROUGH_PRISMARINE, 7, 2, 1, llllllllllllllllIlIlIIIllllIlIIl);
                if (!this.roomDefinition.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 3, 0, 6, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 2, 0, 6, 2, 0, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 1, 0, 6, 1, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (!this.roomDefinition.hasOpening[EnumFacing.NORTH.getIndex()]) {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 3, 7, 6, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 2, 7, 6, 2, 7, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 1, 7, 6, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (!this.roomDefinition.hasOpening[EnumFacing.WEST.getIndex()]) {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 3, 1, 0, 3, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 2, 1, 0, 2, 6, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 1, 0, 1, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
                if (!this.roomDefinition.hasOpening[EnumFacing.EAST.getIndex()]) {
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 3, 1, 7, 3, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 2, 1, 7, 2, 6, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                    this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 1, 1, 7, 1, 6, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                }
            }
            else if (this.mainDesign == 2) {
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 0, 0, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 1, 0, 7, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 1, 0, 6, 1, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 1, 7, 6, 1, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 2, 0, 0, 2, 7, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 2, 0, 7, 2, 7, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 2, 0, 6, 2, 0, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 2, 7, 6, 2, 7, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 3, 0, 0, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 3, 0, 7, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 3, 0, 6, 3, 0, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 1, 3, 7, 6, 3, 7, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 3, 0, 2, 4, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 1, 3, 7, 2, 4, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 1, 0, 4, 2, 0, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 1, 7, 4, 2, 7, SimpleRoom.DARK_PRISMARINE, SimpleRoom.DARK_PRISMARINE, false);
                if (this.roomDefinition.hasOpening[EnumFacing.SOUTH.getIndex()]) {
                    this.generateWaterBox(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 1, 0, 4, 2, 0, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.NORTH.getIndex()]) {
                    this.generateWaterBox(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 1, 7, 4, 2, 7, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.WEST.getIndex()]) {
                    this.generateWaterBox(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 0, 1, 3, 0, 2, 4, false);
                }
                if (this.roomDefinition.hasOpening[EnumFacing.EAST.getIndex()]) {
                    this.generateWaterBox(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 7, 1, 3, 7, 2, 4, false);
                }
            }
            if (llllllllllllllllIlIlIIIllllIlIII) {
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 1, 3, 4, 1, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 2, 3, 4, 2, 4, SimpleRoom.ROUGH_PRISMARINE, SimpleRoom.ROUGH_PRISMARINE, false);
                this.fillWithBlocks(llllllllllllllllIlIlIIIllllIIllI, llllllllllllllllIlIlIIIllllIlIIl, 3, 3, 3, 4, 3, 4, SimpleRoom.BRICKS_PRISMARINE, SimpleRoom.BRICKS_PRISMARINE, false);
            }
            return true;
        }
    }
    
    public static class EntryRoom extends Piece
    {
        public EntryRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIlIlIlIllIIIIIIII, final Random lllllllllllllIIIlIlIlIlIllllllll, final StructureBoundingBox lllllllllllllIIIlIlIlIlIlllllIll) {
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 0, 3, 0, 2, 3, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 5, 3, 0, 7, 3, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 0, 2, 0, 1, 2, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 6, 2, 0, 7, 2, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 0, 1, 0, 0, 1, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 7, 1, 0, 7, 1, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 0, 1, 7, 7, 3, 7, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 1, 1, 0, 2, 3, 0, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            this.fillWithBlocks(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 5, 1, 0, 6, 3, 0, EntryRoom.BRICKS_PRISMARINE, EntryRoom.BRICKS_PRISMARINE, false);
            if (this.roomDefinition.hasOpening[EnumFacing.NORTH.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 3, 1, 7, 4, 2, 7, false);
            }
            if (this.roomDefinition.hasOpening[EnumFacing.WEST.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 0, 1, 3, 1, 2, 4, false);
            }
            if (this.roomDefinition.hasOpening[EnumFacing.EAST.getIndex()]) {
                this.generateWaterBox(lllllllllllllIIIlIlIlIllIIIIIIII, lllllllllllllIIIlIlIlIlIlllllIll, 6, 1, 3, 7, 2, 4, false);
            }
            return true;
        }
        
        public EntryRoom(final EnumFacing lllllllllllllIIIlIlIlIllIIIIlIIl, final RoomDefinition lllllllllllllIIIlIlIlIllIIIIlIII) {
            super(1, lllllllllllllIIIlIlIlIllIIIIlIIl, lllllllllllllIIIlIlIlIllIIIIlIII, 1, 1, 1);
        }
    }
    
    static class XYDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        @Override
        public boolean fits(final RoomDefinition lllllllllllllIlIIlIllIIIIIIlllll) {
            if (lllllllllllllIlIIlIllIIIIIIlllll.hasOpening[EnumFacing.EAST.getIndex()] && !lllllllllllllIlIIlIllIIIIIIlllll.connections[EnumFacing.EAST.getIndex()].claimed && lllllllllllllIlIIlIllIIIIIIlllll.hasOpening[EnumFacing.UP.getIndex()] && !lllllllllllllIlIIlIllIIIIIIlllll.connections[EnumFacing.UP.getIndex()].claimed) {
                final RoomDefinition lllllllllllllIlIIlIllIIIIIIllllI = lllllllllllllIlIIlIllIIIIIIlllll.connections[EnumFacing.EAST.getIndex()];
                return lllllllllllllIlIIlIllIIIIIIllllI.hasOpening[EnumFacing.UP.getIndex()] && !lllllllllllllIlIIlIllIIIIIIllllI.connections[EnumFacing.UP.getIndex()].claimed;
            }
            return false;
        }
        
        @Override
        public Piece create(final EnumFacing lllllllllllllIlIIlIllIIIIIIlIlll, final RoomDefinition lllllllllllllIlIIlIllIIIIIIlIllI, final Random lllllllllllllIlIIlIllIIIIIIlIlIl) {
            lllllllllllllIlIIlIllIIIIIIlIllI.claimed = true;
            lllllllllllllIlIIlIllIIIIIIlIllI.connections[EnumFacing.EAST.getIndex()].claimed = true;
            lllllllllllllIlIIlIllIIIIIIlIllI.connections[EnumFacing.UP.getIndex()].claimed = true;
            lllllllllllllIlIIlIllIIIIIIlIllI.connections[EnumFacing.EAST.getIndex()].connections[EnumFacing.UP.getIndex()].claimed = true;
            return new DoubleXYRoom(lllllllllllllIlIIlIllIIIIIIlIlll, lllllllllllllIlIIlIllIIIIIIlIllI, lllllllllllllIlIIlIllIIIIIIlIlIl);
        }
        
        private XYDoubleRoomFitHelper() {
        }
    }
    
    static class FitSimpleRoomTopHelper implements MonumentRoomFitHelper
    {
        @Override
        public boolean fits(final RoomDefinition lllllllllllllIIIlIlllIIllIlIIlII) {
            return !lllllllllllllIIIlIlllIIllIlIIlII.hasOpening[EnumFacing.WEST.getIndex()] && !lllllllllllllIIIlIlllIIllIlIIlII.hasOpening[EnumFacing.EAST.getIndex()] && !lllllllllllllIIIlIlllIIllIlIIlII.hasOpening[EnumFacing.NORTH.getIndex()] && !lllllllllllllIIIlIlllIIllIlIIlII.hasOpening[EnumFacing.SOUTH.getIndex()] && !lllllllllllllIIIlIlllIIllIlIIlII.hasOpening[EnumFacing.UP.getIndex()];
        }
        
        private FitSimpleRoomTopHelper() {
        }
        
        @Override
        public Piece create(final EnumFacing lllllllllllllIIIlIlllIIllIIlllll, final RoomDefinition lllllllllllllIIIlIlllIIllIIllIll, final Random lllllllllllllIIIlIlllIIllIIllIlI) {
            lllllllllllllIIIlIlllIIllIIllIll.claimed = true;
            return new SimpleTopRoom(lllllllllllllIIIlIlllIIllIIlllll, lllllllllllllIIIlIlllIIllIIllIll, lllllllllllllIIIlIlllIIllIIllIlI);
        }
    }
    
    static class ZDoubleRoomFitHelper implements MonumentRoomFitHelper
    {
        private ZDoubleRoomFitHelper() {
        }
        
        @Override
        public Piece create(final EnumFacing lllllllllllllIIllIllIlIIlIIlIlIl, final RoomDefinition lllllllllllllIIllIllIlIIlIIlIIII, final Random lllllllllllllIIllIllIlIIlIIlIIll) {
            RoomDefinition lllllllllllllIIllIllIlIIlIIlIIlI = lllllllllllllIIllIllIlIIlIIlIIII;
            if (!lllllllllllllIIllIllIlIIlIIlIIII.hasOpening[EnumFacing.NORTH.getIndex()] || lllllllllllllIIllIllIlIIlIIlIIII.connections[EnumFacing.NORTH.getIndex()].claimed) {
                lllllllllllllIIllIllIlIIlIIlIIlI = lllllllllllllIIllIllIlIIlIIlIIII.connections[EnumFacing.SOUTH.getIndex()];
            }
            lllllllllllllIIllIllIlIIlIIlIIlI.claimed = true;
            lllllllllllllIIllIllIlIIlIIlIIlI.connections[EnumFacing.NORTH.getIndex()].claimed = true;
            return new DoubleZRoom(lllllllllllllIIllIllIlIIlIIlIlIl, lllllllllllllIIllIllIlIIlIIlIIlI, lllllllllllllIIllIllIlIIlIIlIIll);
        }
        
        @Override
        public boolean fits(final RoomDefinition lllllllllllllIIllIllIlIIlIIlllII) {
            return lllllllllllllIIllIllIlIIlIIlllII.hasOpening[EnumFacing.NORTH.getIndex()] && !lllllllllllllIIllIllIlIIlIIlllII.connections[EnumFacing.NORTH.getIndex()].claimed;
        }
    }
}
