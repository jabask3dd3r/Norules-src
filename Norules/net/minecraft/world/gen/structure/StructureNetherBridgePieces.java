package net.minecraft.world.gen.structure;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.gen.structure.template.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;

public class StructureNetherBridgePieces
{
    private static final /* synthetic */ PieceWeight[] PRIMARY_COMPONENTS;
    private static final /* synthetic */ PieceWeight[] SECONDARY_COMPONENTS;
    
    static {
        PRIMARY_COMPONENTS = new PieceWeight[] { new PieceWeight(Straight.class, 30, 0, true), new PieceWeight(Crossing3.class, 10, 4), new PieceWeight(Crossing.class, 10, 4), new PieceWeight(Stairs.class, 10, 3), new PieceWeight(Throne.class, 5, 2), new PieceWeight(Entrance.class, 5, 1) };
        SECONDARY_COMPONENTS = new PieceWeight[] { new PieceWeight(Corridor5.class, 25, 0, true), new PieceWeight(Crossing2.class, 15, 5), new PieceWeight(Corridor2.class, 5, 10), new PieceWeight(Corridor.class, 5, 10), new PieceWeight(Corridor3.class, 10, 3, true), new PieceWeight(Corridor4.class, 7, 2), new PieceWeight(NetherStalkRoom.class, 5, 2) };
    }
    
    private static Piece findAndCreateBridgePieceFactory(final PieceWeight lllllllllllllllIllIlIlIlllIllIlI, final List<StructureComponent> lllllllllllllllIllIlIlIlllIllIIl, final Random lllllllllllllllIllIlIlIlllIllIII, final int lllllllllllllllIllIlIlIlllIIllIl, final int lllllllllllllllIllIlIlIlllIIllII, final int lllllllllllllllIllIlIlIlllIIlIll, final EnumFacing lllllllllllllllIllIlIlIlllIlIlII, final int lllllllllllllllIllIlIlIlllIIlIIl) {
        final Class<? extends Piece> lllllllllllllllIllIlIlIlllIlIIlI = lllllllllllllllIllIlIlIlllIllIlI.weightClass;
        Piece lllllllllllllllIllIlIlIlllIlIIIl = null;
        if (lllllllllllllllIllIlIlIlllIlIIlI == Straight.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Straight.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Crossing3.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Crossing3.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Crossing.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Crossing.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Stairs.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Stairs.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIIlIIl, lllllllllllllllIllIlIlIlllIlIlII);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Throne.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Throne.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIIlIIl, lllllllllllllllIllIlIlIlllIlIlII);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Entrance.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Entrance.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Corridor5.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Corridor5.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Corridor2.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Corridor2.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Corridor.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Corridor.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Corridor3.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Corridor3.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Corridor4.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Corridor4.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == Crossing2.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = Crossing2.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        else if (lllllllllllllllIllIlIlIlllIlIIlI == NetherStalkRoom.class) {
            lllllllllllllllIllIlIlIlllIlIIIl = NetherStalkRoom.createPiece(lllllllllllllllIllIlIlIlllIllIIl, lllllllllllllllIllIlIlIlllIllIII, lllllllllllllllIllIlIlIlllIIllIl, lllllllllllllllIllIlIlIlllIIllII, lllllllllllllllIllIlIlIlllIIlIll, lllllllllllllllIllIlIlIlllIlIlII, lllllllllllllllIllIlIlIlllIIlIIl);
        }
        return lllllllllllllllIllIlIlIlllIlIIIl;
    }
    
    public static void registerNetherFortressPieces() {
        MapGenStructureIO.registerStructureComponent(Crossing3.class, "NeBCr");
        MapGenStructureIO.registerStructureComponent(End.class, "NeBEF");
        MapGenStructureIO.registerStructureComponent(Straight.class, "NeBS");
        MapGenStructureIO.registerStructureComponent(Corridor3.class, "NeCCS");
        MapGenStructureIO.registerStructureComponent(Corridor4.class, "NeCTB");
        MapGenStructureIO.registerStructureComponent(Entrance.class, "NeCE");
        MapGenStructureIO.registerStructureComponent(Crossing2.class, "NeSCSC");
        MapGenStructureIO.registerStructureComponent(Corridor.class, "NeSCLT");
        MapGenStructureIO.registerStructureComponent(Corridor5.class, "NeSC");
        MapGenStructureIO.registerStructureComponent(Corridor2.class, "NeSCRT");
        MapGenStructureIO.registerStructureComponent(NetherStalkRoom.class, "NeCSR");
        MapGenStructureIO.registerStructureComponent(Throne.class, "NeMT");
        MapGenStructureIO.registerStructureComponent(Crossing.class, "NeRC");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "NeSR");
        MapGenStructureIO.registerStructureComponent(Start.class, "NeStart");
    }
    
    public static class Stairs extends Piece
    {
        @Override
        public boolean addComponentParts(final World lllllllllllllIlIIIIIllllIIllllll, final Random lllllllllllllIlIIIIIllllIIlllllI, final StructureBoundingBox lllllllllllllIlIIIIIllllIIlllIII) {
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 0, 2, 0, 6, 10, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 0, 2, 0, 1, 8, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 5, 2, 0, 6, 8, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 0, 2, 1, 0, 8, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 6, 2, 1, 6, 8, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 1, 2, 6, 5, 8, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 0, 3, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 6, 3, 2, 6, 5, 2, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 6, 3, 4, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.setBlockState(lllllllllllllIlIIIIIllllIIllllll, Blocks.NETHER_BRICK.getDefaultState(), 5, 2, 5, lllllllllllllIlIIIIIllllIIlllIII);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 4, 2, 5, 4, 3, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 3, 2, 5, 3, 4, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 2, 2, 5, 2, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 1, 2, 5, 1, 6, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 1, 7, 1, 5, 7, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 6, 8, 2, 6, 8, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 2, 6, 0, 4, 8, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlIIIIIllllIIllllll, lllllllllllllIlIIIIIllllIIlllIII, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            for (int lllllllllllllIlIIIIIllllIIllllII = 0; lllllllllllllIlIIIIIllllIIllllII <= 6; ++lllllllllllllIlIIIIIllllIIllllII) {
                for (int lllllllllllllIlIIIIIllllIIlllIll = 0; lllllllllllllIlIIIIIllllIIlllIll <= 6; ++lllllllllllllIlIIIIIllllIIlllIll) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIlIIIIIllllIIllllll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIlIIIIIllllIIllllII, -1, lllllllllllllIlIIIIIllllIIlllIll, lllllllllllllIlIIIIIllllIIlllIII);
                }
            }
            return true;
        }
        
        public Stairs() {
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIlIIIIIllllIllIIIII, final List<StructureComponent> lllllllllllllIlIIIIIllllIllIIIll, final Random lllllllllllllIlIIIIIllllIlIllllI) {
            this.getNextComponentZ((Start)lllllllllllllIlIIIIIllllIllIIIII, lllllllllllllIlIIIIIllllIllIIIll, lllllllllllllIlIIIIIllllIlIllllI, 6, 2, false);
        }
        
        public static Stairs createPiece(final List<StructureComponent> lllllllllllllIlIIIIIllllIlIlIlIl, final Random lllllllllllllIlIIIIIllllIlIIllII, final int lllllllllllllIlIIIIIllllIlIlIIll, final int lllllllllllllIlIIIIIllllIlIlIIlI, final int lllllllllllllIlIIIIIllllIlIlIIIl, final int lllllllllllllIlIIIIIllllIlIlIIII, final EnumFacing lllllllllllllIlIIIIIllllIlIIIlll) {
            final StructureBoundingBox lllllllllllllIlIIIIIllllIlIIlllI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIlIIIIIllllIlIlIIll, lllllllllllllIlIIIIIllllIlIlIIlI, lllllllllllllIlIIIIIllllIlIlIIIl, -2, 0, 0, 7, 11, 7, lllllllllllllIlIIIIIllllIlIIIlll);
            return (Piece.isAboveGround(lllllllllllllIlIIIIIllllIlIIlllI) && StructureComponent.findIntersecting(lllllllllllllIlIIIIIllllIlIlIlIl, lllllllllllllIlIIIIIllllIlIIlllI) == null) ? new Stairs(lllllllllllllIlIIIIIllllIlIlIIII, lllllllllllllIlIIIIIllllIlIIllII, lllllllllllllIlIIIIIllllIlIIlllI, lllllllllllllIlIIIIIllllIlIIIlll) : null;
        }
        
        public Stairs(final int lllllllllllllIlIIIIIllllIllIllII, final Random lllllllllllllIlIIIIIllllIlllIIII, final StructureBoundingBox lllllllllllllIlIIIIIllllIllIlIll, final EnumFacing lllllllllllllIlIIIIIllllIllIlIlI) {
            super(lllllllllllllIlIIIIIllllIllIllII);
            this.setCoordBaseMode(lllllllllllllIlIIIIIllllIllIlIlI);
            this.boundingBox = lllllllllllllIlIIIIIllllIllIlIll;
        }
    }
    
    abstract static class Piece extends StructureComponent
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        
        private Piece generatePiece(final Start llllllllllllllllIlIlllIIIlIlIlII, final List<PieceWeight> llllllllllllllllIlIlllIIIlIlIIll, final List<StructureComponent> llllllllllllllllIlIlllIIIlIlIIlI, final Random llllllllllllllllIlIlllIIIlIIIIIl, final int llllllllllllllllIlIlllIIIlIlIIII, final int llllllllllllllllIlIlllIIIIllllll, final int llllllllllllllllIlIlllIIIlIIlllI, final EnumFacing llllllllllllllllIlIlllIIIIllllIl, final int llllllllllllllllIlIlllIIIlIIllII) {
            final int llllllllllllllllIlIlllIIIlIIlIll = this.getTotalWeight(llllllllllllllllIlIlllIIIlIlIIll);
            final boolean llllllllllllllllIlIlllIIIlIIlIlI = llllllllllllllllIlIlllIIIlIIlIll > 0 && llllllllllllllllIlIlllIIIlIIllII <= 30;
            int llllllllllllllllIlIlllIIIlIIlIIl = 0;
            while (llllllllllllllllIlIlllIIIlIIlIIl < 5 && llllllllllllllllIlIlllIIIlIIlIlI) {
                ++llllllllllllllllIlIlllIIIlIIlIIl;
                int llllllllllllllllIlIlllIIIlIIlIII = llllllllllllllllIlIlllIIIlIIIIIl.nextInt(llllllllllllllllIlIlllIIIlIIlIll);
                for (final PieceWeight llllllllllllllllIlIlllIIIlIIIlll : llllllllllllllllIlIlllIIIlIlIIll) {
                    llllllllllllllllIlIlllIIIlIIlIII -= llllllllllllllllIlIlllIIIlIIIlll.weight;
                    if (llllllllllllllllIlIlllIIIlIIlIII < 0) {
                        if (!llllllllllllllllIlIlllIIIlIIIlll.doPlace(llllllllllllllllIlIlllIIIlIIllII)) {
                            break;
                        }
                        if (llllllllllllllllIlIlllIIIlIIIlll == llllllllllllllllIlIlllIIIlIlIlII.theNetherBridgePieceWeight && !llllllllllllllllIlIlllIIIlIIIlll.allowInRow) {
                            break;
                        }
                        final Piece llllllllllllllllIlIlllIIIlIIIllI = findAndCreateBridgePieceFactory(llllllllllllllllIlIlllIIIlIIIlll, llllllllllllllllIlIlllIIIlIlIIlI, llllllllllllllllIlIlllIIIlIIIIIl, llllllllllllllllIlIlllIIIlIlIIII, llllllllllllllllIlIlllIIIIllllll, llllllllllllllllIlIlllIIIlIIlllI, llllllllllllllllIlIlllIIIIllllIl, llllllllllllllllIlIlllIIIlIIllII);
                        if (llllllllllllllllIlIlllIIIlIIIllI != null) {
                            final PieceWeight pieceWeight = llllllllllllllllIlIlllIIIlIIIlll;
                            ++pieceWeight.placeCount;
                            llllllllllllllllIlIlllIIIlIlIlII.theNetherBridgePieceWeight = llllllllllllllllIlIlllIIIlIIIlll;
                            if (!llllllllllllllllIlIlllIIIlIIIlll.isValid()) {
                                llllllllllllllllIlIlllIIIlIlIIll.remove(llllllllllllllllIlIlllIIIlIIIlll);
                            }
                            return llllllllllllllllIlIlllIIIlIIIllI;
                        }
                        continue;
                    }
                }
            }
            return End.createPiece(llllllllllllllllIlIlllIIIlIlIIlI, llllllllllllllllIlIlllIIIlIIIIIl, llllllllllllllllIlIlllIIIlIlIIII, llllllllllllllllIlIlllIIIIllllll, llllllllllllllllIlIlllIIIlIIlllI, llllllllllllllllIlIlllIIIIllllIl, llllllllllllllllIlIlllIIIlIIllII);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllllIlIlllIIIllllIIl, final TemplateManager llllllllllllllllIlIlllIIIllllIII) {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllllIlIlllIIIlllIllI) {
        }
        
        protected Piece(final int llllllllllllllllIlIlllIIIlllllIl) {
            super(llllllllllllllllIlIlllIIIlllllIl);
        }
        
        @Nullable
        protected StructureComponent getNextComponentNormal(final Start llllllllllllllllIlIllIllllllllll, final List<StructureComponent> llllllllllllllllIlIllIlllllllllI, final Random llllllllllllllllIlIllIllllllllIl, final int llllllllllllllllIlIllIllllllllII, final int llllllllllllllllIlIlllIIIIIIIIll, final boolean llllllllllllllllIlIllIlllllllIlI) {
            final EnumFacing llllllllllllllllIlIlllIIIIIIIIIl = this.getCoordBaseMode();
            if (llllllllllllllllIlIlllIIIIIIIIIl != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllllIlIlllIIIIIIIIIl.ordinal()]) {
                    case 3: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIllllllllll, llllllllllllllllIlIllIlllllllllI, llllllllllllllllIlIllIllllllllIl, this.boundingBox.minX + llllllllllllllllIlIllIllllllllII, this.boundingBox.minY + llllllllllllllllIlIlllIIIIIIIIll, this.boundingBox.minZ - 1, llllllllllllllllIlIlllIIIIIIIIIl, this.getComponentType(), llllllllllllllllIlIllIlllllllIlI);
                    }
                    case 4: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIllllllllll, llllllllllllllllIlIllIlllllllllI, llllllllllllllllIlIllIllllllllIl, this.boundingBox.minX + llllllllllllllllIlIllIllllllllII, this.boundingBox.minY + llllllllllllllllIlIlllIIIIIIIIll, this.boundingBox.maxZ + 1, llllllllllllllllIlIlllIIIIIIIIIl, this.getComponentType(), llllllllllllllllIlIllIlllllllIlI);
                    }
                    case 5: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIllllllllll, llllllllllllllllIlIllIlllllllllI, llllllllllllllllIlIllIllllllllIl, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllllllIlIlllIIIIIIIIll, this.boundingBox.minZ + llllllllllllllllIlIllIllllllllII, llllllllllllllllIlIlllIIIIIIIIIl, this.getComponentType(), llllllllllllllllIlIllIlllllllIlI);
                    }
                    case 6: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIllllllllll, llllllllllllllllIlIllIlllllllllI, llllllllllllllllIlIllIllllllllIl, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllllllIlIlllIIIIIIIIll, this.boundingBox.minZ + llllllllllllllllIlIllIllllllllII, llllllllllllllllIlIlllIIIIIIIIIl, this.getComponentType(), llllllllllllllllIlIllIlllllllIlI);
                    }
                }
            }
            return null;
        }
        
        @Nullable
        protected StructureComponent getNextComponentX(final Start llllllllllllllllIlIllIlllllIllll, final List<StructureComponent> llllllllllllllllIlIllIlllllIlllI, final Random llllllllllllllllIlIllIlllllIllIl, final int llllllllllllllllIlIllIlllllIllII, final int llllllllllllllllIlIllIlllllIIIll, final boolean llllllllllllllllIlIllIlllllIIIlI) {
            final EnumFacing llllllllllllllllIlIllIlllllIlIIl = this.getCoordBaseMode();
            if (llllllllllllllllIlIllIlllllIlIIl != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllllIlIllIlllllIlIIl.ordinal()]) {
                    case 3: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIlllllIllll, llllllllllllllllIlIllIlllllIlllI, llllllllllllllllIlIllIlllllIllIl, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllllllIlIllIlllllIllII, this.boundingBox.minZ + llllllllllllllllIlIllIlllllIIIll, EnumFacing.WEST, this.getComponentType(), llllllllllllllllIlIllIlllllIIIlI);
                    }
                    case 4: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIlllllIllll, llllllllllllllllIlIllIlllllIlllI, llllllllllllllllIlIllIlllllIllIl, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllllllIlIllIlllllIllII, this.boundingBox.minZ + llllllllllllllllIlIllIlllllIIIll, EnumFacing.WEST, this.getComponentType(), llllllllllllllllIlIllIlllllIIIlI);
                    }
                    case 5: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIlllllIllll, llllllllllllllllIlIllIlllllIlllI, llllllllllllllllIlIllIlllllIllIl, this.boundingBox.minX + llllllllllllllllIlIllIlllllIIIll, this.boundingBox.minY + llllllllllllllllIlIllIlllllIllII, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), llllllllllllllllIlIllIlllllIIIlI);
                    }
                    case 6: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIlllllIllll, llllllllllllllllIlIllIlllllIlllI, llllllllllllllllIlIllIlllllIllIl, this.boundingBox.minX + llllllllllllllllIlIllIlllllIIIll, this.boundingBox.minY + llllllllllllllllIlIllIlllllIllII, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType(), llllllllllllllllIlIllIlllllIIIlI);
                    }
                }
            }
            return null;
        }
        
        public Piece() {
        }
        
        @Nullable
        protected StructureComponent getNextComponentZ(final Start llllllllllllllllIlIllIllllIlIlll, final List<StructureComponent> llllllllllllllllIlIllIllllIlIllI, final Random llllllllllllllllIlIllIllllIIllIl, final int llllllllllllllllIlIllIllllIIllII, final int llllllllllllllllIlIllIllllIlIIll, final boolean llllllllllllllllIlIllIllllIlIIlI) {
            final EnumFacing llllllllllllllllIlIllIllllIlIIIl = this.getCoordBaseMode();
            if (llllllllllllllllIlIllIllllIlIIIl != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllllIlIllIllllIlIIIl.ordinal()]) {
                    case 3: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIllllIlIlll, llllllllllllllllIlIllIllllIlIllI, llllllllllllllllIlIllIllllIIllIl, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllllllIlIllIllllIIllII, this.boundingBox.minZ + llllllllllllllllIlIllIllllIlIIll, EnumFacing.EAST, this.getComponentType(), llllllllllllllllIlIllIllllIlIIlI);
                    }
                    case 4: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIllllIlIlll, llllllllllllllllIlIllIllllIlIllI, llllllllllllllllIlIllIllllIIllIl, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllllllIlIllIllllIIllII, this.boundingBox.minZ + llllllllllllllllIlIllIllllIlIIll, EnumFacing.EAST, this.getComponentType(), llllllllllllllllIlIllIllllIlIIlI);
                    }
                    case 5: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIllllIlIlll, llllllllllllllllIlIllIllllIlIllI, llllllllllllllllIlIllIllllIIllIl, this.boundingBox.minX + llllllllllllllllIlIllIllllIlIIll, this.boundingBox.minY + llllllllllllllllIlIllIllllIIllII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), llllllllllllllllIlIllIllllIlIIlI);
                    }
                    case 6: {
                        return this.generateAndAddPiece(llllllllllllllllIlIllIllllIlIlll, llllllllllllllllIlIllIllllIlIllI, llllllllllllllllIlIllIllllIIllIl, this.boundingBox.minX + llllllllllllllllIlIllIllllIlIIll, this.boundingBox.minY + llllllllllllllllIlIllIllllIIllII, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType(), llllllllllllllllIlIllIllllIlIIlI);
                    }
                }
            }
            return null;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Piece.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final boolean llllllllllllllllIlIllIllllIIIlII = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllllllllIlIllIllllIIIlII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllllIlIllIllllIIIlII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllllllIlIllIllllIIIlII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllllllIlIllIllllIIIlII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllllllllIlIllIllllIIIlII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllllllllIlIllIllllIIIlII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Piece.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllllIlIllIllllIIIlII;
        }
        
        private int getTotalWeight(final List<PieceWeight> llllllllllllllllIlIlllIIIllIllll) {
            boolean llllllllllllllllIlIlllIIIllIlllI = false;
            int llllllllllllllllIlIlllIIIllIllIl = 0;
            for (final PieceWeight llllllllllllllllIlIlllIIIllIllII : llllllllllllllllIlIlllIIIllIllll) {
                if (llllllllllllllllIlIlllIIIllIllII.maxPlaceCount > 0 && llllllllllllllllIlIlllIIIllIllII.placeCount < llllllllllllllllIlIlllIIIllIllII.maxPlaceCount) {
                    llllllllllllllllIlIlllIIIllIlllI = true;
                }
                llllllllllllllllIlIlllIIIllIllIl += llllllllllllllllIlIlllIIIllIllII.weight;
            }
            return llllllllllllllllIlIlllIIIllIlllI ? llllllllllllllllIlIlllIIIllIllIl : -1;
        }
        
        private StructureComponent generateAndAddPiece(final Start llllllllllllllllIlIlllIIIIIllIll, final List<StructureComponent> llllllllllllllllIlIlllIIIIlIIllI, final Random llllllllllllllllIlIlllIIIIlIIlIl, final int llllllllllllllllIlIlllIIIIlIIlII, final int llllllllllllllllIlIlllIIIIlIIIll, final int llllllllllllllllIlIlllIIIIlIIIlI, @Nullable final EnumFacing llllllllllllllllIlIlllIIIIlIIIIl, final int llllllllllllllllIlIlllIIIIlIIIII, final boolean llllllllllllllllIlIlllIIIIIlllll) {
            if (Math.abs(llllllllllllllllIlIlllIIIIlIIlII - llllllllllllllllIlIlllIIIIIllIll.getBoundingBox().minX) <= 112 && Math.abs(llllllllllllllllIlIlllIIIIlIIIlI - llllllllllllllllIlIlllIIIIIllIll.getBoundingBox().minZ) <= 112) {
                List<PieceWeight> llllllllllllllllIlIlllIIIIIllllI = llllllllllllllllIlIlllIIIIIllIll.primaryWeights;
                if (llllllllllllllllIlIlllIIIIIlllll) {
                    llllllllllllllllIlIlllIIIIIllllI = llllllllllllllllIlIlllIIIIIllIll.secondaryWeights;
                }
                final StructureComponent llllllllllllllllIlIlllIIIIIlllIl = this.generatePiece(llllllllllllllllIlIlllIIIIIllIll, llllllllllllllllIlIlllIIIIIllllI, llllllllllllllllIlIlllIIIIlIIllI, llllllllllllllllIlIlllIIIIlIIlIl, llllllllllllllllIlIlllIIIIlIIlII, llllllllllllllllIlIlllIIIIlIIIll, llllllllllllllllIlIlllIIIIlIIIlI, llllllllllllllllIlIlllIIIIlIIIIl, llllllllllllllllIlIlllIIIIlIIIII + 1);
                if (llllllllllllllllIlIlllIIIIIlllIl != null) {
                    llllllllllllllllIlIlllIIIIlIIllI.add(llllllllllllllllIlIlllIIIIIlllIl);
                    llllllllllllllllIlIlllIIIIIllIll.pendingChildren.add(llllllllllllllllIlIlllIIIIIlllIl);
                }
                return llllllllllllllllIlIlllIIIIIlllIl;
            }
            return End.createPiece(llllllllllllllllIlIlllIIIIlIIllI, llllllllllllllllIlIlllIIIIlIIlIl, llllllllllllllllIlIlllIIIIlIIlII, llllllllllllllllIlIlllIIIIlIIIll, llllllllllllllllIlIlllIIIIlIIIlI, llllllllllllllllIlIlllIIIIlIIIIl, llllllllllllllllIlIlllIIIIlIIIII);
        }
        
        protected static boolean isAboveGround(final StructureBoundingBox llllllllllllllllIlIllIllllIIIllI) {
            return llllllllllllllllIlIllIllllIIIllI != null && llllllllllllllllIlIllIllllIIIllI.minY > 10;
        }
    }
    
    public static class Start extends Crossing3
    {
        public /* synthetic */ PieceWeight theNetherBridgePieceWeight;
        public /* synthetic */ List<PieceWeight> primaryWeights;
        public /* synthetic */ List<PieceWeight> secondaryWeights;
        public /* synthetic */ List<StructureComponent> pendingChildren;
        
        public Start() {
            this.pendingChildren = (List<StructureComponent>)Lists.newArrayList();
        }
        
        public Start(final Random llllllllllllllllIIlIlIIlIIIlIIII, final int llllllllllllllllIIlIlIIlIIIIllll, final int llllllllllllllllIIlIlIIlIIIIlllI) {
            super(llllllllllllllllIIlIlIIlIIIlIIII, llllllllllllllllIIlIlIIlIIIIllll, llllllllllllllllIIlIlIIlIIIIlllI);
            this.pendingChildren = (List<StructureComponent>)Lists.newArrayList();
            this.primaryWeights = (List<PieceWeight>)Lists.newArrayList();
            boolean llllllllllllllllIIlIlIIlIIIIlIlI;
            int llllllllllllllllIIlIlIIlIIIIlIll = ((PieceWeight[])(Object)(llllllllllllllllIIlIlIIlIIIIlIlI = (boolean)(Object)StructureNetherBridgePieces.PRIMARY_COMPONENTS)).length;
            for (char llllllllllllllllIIlIlIIlIIIIllII = '\0'; llllllllllllllllIIlIlIIlIIIIllII < llllllllllllllllIIlIlIIlIIIIlIll; ++llllllllllllllllIIlIlIIlIIIIllII) {
                final PieceWeight llllllllllllllllIIlIlIIlIIIlIIll = llllllllllllllllIIlIlIIlIIIIlIlI[llllllllllllllllIIlIlIIlIIIIllII];
                llllllllllllllllIIlIlIIlIIIlIIll.placeCount = 0;
                this.primaryWeights.add(llllllllllllllllIIlIlIIlIIIlIIll);
            }
            this.secondaryWeights = (List<PieceWeight>)Lists.newArrayList();
            llllllllllllllllIIlIlIIlIIIIlIll = ((PieceWeight[])(Object)(llllllllllllllllIIlIlIIlIIIIlIlI = (boolean)(Object)StructureNetherBridgePieces.SECONDARY_COMPONENTS)).length;
            for (char llllllllllllllllIIlIlIIlIIIIllII = '\0'; llllllllllllllllIIlIlIIlIIIIllII < llllllllllllllllIIlIlIIlIIIIlIll; ++llllllllllllllllIIlIlIIlIIIIllII) {
                final PieceWeight llllllllllllllllIIlIlIIlIIIlIIlI = llllllllllllllllIIlIlIIlIIIIlIlI[llllllllllllllllIIlIlIIlIIIIllII];
                llllllllllllllllIIlIlIIlIIIlIIlI.placeCount = 0;
                this.secondaryWeights.add(llllllllllllllllIIlIlIIlIIIlIIlI);
            }
        }
    }
    
    static class PieceWeight
    {
        public /* synthetic */ int maxPlaceCount;
        public /* synthetic */ Class<? extends Piece> weightClass;
        public /* synthetic */ boolean allowInRow;
        public /* synthetic */ int placeCount;
        public final /* synthetic */ int weight;
        
        public PieceWeight(final Class<? extends Piece> llllIIlIllIIIIl, final int llllIIlIllIIIII, final int llllIIlIlIlllll) {
            this(llllIIlIllIIIIl, llllIIlIllIIIII, llllIIlIlIlllll, false);
        }
        
        public PieceWeight(final Class<? extends Piece> llllIIlIllIllll, final int llllIIlIllIlllI, final int llllIIlIllIlIII, final boolean llllIIlIllIIlll) {
            this.weightClass = llllIIlIllIllll;
            this.weight = llllIIlIllIlllI;
            this.maxPlaceCount = llllIIlIllIlIII;
            this.allowInRow = llllIIlIllIIlll;
        }
        
        public boolean isValid() {
            return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
        }
        
        public boolean doPlace(final int llllIIlIlIllIII) {
            return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
        }
    }
    
    public static class Crossing3 extends Piece
    {
        public static Crossing3 createPiece(final List<StructureComponent> llllllllllllllIlIlIIIlllIlIIllII, final Random llllllllllllllIlIlIIIlllIlIIlIlI, final int llllllllllllllIlIlIIIlllIlIIlIII, final int llllllllllllllIlIlIIIlllIlIIIlll, final int llllllllllllllIlIlIIIlllIlIlIlII, final EnumFacing llllllllllllllIlIlIIIlllIlIlIIlI, final int llllllllllllllIlIlIIIlllIlIlIIII) {
            final StructureBoundingBox llllllllllllllIlIlIIIlllIlIIlllI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIlIlIIIlllIlIIlIII, llllllllllllllIlIlIIIlllIlIIIlll, llllllllllllllIlIlIIIlllIlIlIlII, -8, -3, 0, 19, 10, 19, llllllllllllllIlIlIIIlllIlIlIIlI);
            return (Piece.isAboveGround(llllllllllllllIlIlIIIlllIlIIlllI) && StructureComponent.findIntersecting(llllllllllllllIlIlIIIlllIlIIllII, llllllllllllllIlIlIIIlllIlIIlllI) == null) ? new Crossing3(llllllllllllllIlIlIIIlllIlIlIIII, llllllllllllllIlIlIIIlllIlIIlIlI, llllllllllllllIlIlIIIlllIlIIlllI, llllllllllllllIlIlIIIlllIlIlIIlI) : null;
        }
        
        protected Crossing3(final Random llllllllllllllIlIlIIIlllIlllIlII, final int llllllllllllllIlIlIIIlllIlllIIll, final int llllllllllllllIlIlIIIlllIlllIIlI) {
            super(0);
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIlIlIIIlllIlllIlII));
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(llllllllllllllIlIlIIIlllIlllIIll, 64, llllllllllllllIlIlIIIlllIlllIIlI, llllllllllllllIlIlIIIlllIlllIIll + 19 - 1, 73, llllllllllllllIlIlIIIlllIlllIIlI + 19 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(llllllllllllllIlIlIIIlllIlllIIll, 64, llllllllllllllIlIlIIIlllIlllIIlI, llllllllllllllIlIlIIIlllIlllIIll + 19 - 1, 73, llllllllllllllIlIlIIIlllIlllIIlI + 19 - 1);
            }
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIlIIIllIllllIIll, final Random llllllllllllllIlIlIIIllIllllllII, final StructureBoundingBox llllllllllllllIlIlIIIllIlllllIll) {
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 7, 3, 0, 11, 4, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 0, 3, 7, 18, 4, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 8, 5, 0, 10, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 0, 5, 8, 18, 7, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 7, 5, 0, 7, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 7, 5, 11, 7, 5, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 11, 5, 0, 11, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 11, 5, 11, 11, 5, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 0, 5, 7, 7, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 11, 5, 7, 18, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 0, 5, 11, 7, 5, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 11, 5, 11, 18, 5, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 7, 2, 0, 11, 2, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 7, 2, 13, 11, 2, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 7, 0, 0, 11, 1, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 7, 0, 15, 11, 1, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllllllIlIlIIIllIlllllIIl = 7; llllllllllllllIlIlIIIllIlllllIIl <= 11; ++llllllllllllllIlIlIIIllIlllllIIl) {
                for (int llllllllllllllIlIlIIIllIllllIlll = 0; llllllllllllllIlIlIIIllIllllIlll <= 2; ++llllllllllllllIlIlIIIllIllllIlll) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIIllIllllIIll, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIlIlIIIllIlllllIIl, -1, llllllllllllllIlIlIIIllIllllIlll, llllllllllllllIlIlIIIllIlllllIll);
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIIllIllllIIll, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIlIlIIIllIlllllIIl, -1, 18 - llllllllllllllIlIlIIIllIllllIlll, llllllllllllllIlIlIIIllIlllllIll);
                }
            }
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 0, 2, 7, 5, 2, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 13, 2, 7, 18, 2, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 0, 0, 7, 3, 1, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIIllIllllIIll, llllllllllllllIlIlIIIllIlllllIll, 15, 0, 7, 18, 1, 11, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllllllIlIlIIIllIllllIllI = 0; llllllllllllllIlIlIIIllIllllIllI <= 2; ++llllllllllllllIlIlIIIllIllllIllI) {
                for (int llllllllllllllIlIlIIIllIllllIlIl = 7; llllllllllllllIlIlIIIllIllllIlIl <= 11; ++llllllllllllllIlIlIIIllIllllIlIl) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIIllIllllIIll, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIlIlIIIllIllllIllI, -1, llllllllllllllIlIlIIIllIllllIlIl, llllllllllllllIlIlIIIllIlllllIll);
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIIllIllllIIll, Blocks.NETHER_BRICK.getDefaultState(), 18 - llllllllllllllIlIlIIIllIllllIllI, -1, llllllllllllllIlIlIIIllIllllIlIl, llllllllllllllIlIlIIIllIlllllIll);
                }
            }
            return true;
        }
        
        public Crossing3(final int llllllllllllllIlIlIIIllllIIIIIll, final Random llllllllllllllIlIlIIIllllIIIlIll, final StructureBoundingBox llllllllllllllIlIlIIIllllIIIIIIl, final EnumFacing llllllllllllllIlIlIIIlllIlllllll) {
            super(llllllllllllllIlIlIIIllllIIIIIll);
            this.setCoordBaseMode(llllllllllllllIlIlIIIlllIlllllll);
            this.boundingBox = llllllllllllllIlIlIIIllllIIIIIIl;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIlIIIlllIllIlIII, final List<StructureComponent> llllllllllllllIlIlIIIlllIllIIlll, final Random llllllllllllllIlIlIIIlllIllIIllI) {
            this.getNextComponentNormal((Start)llllllllllllllIlIlIIIlllIllIlIII, llllllllllllllIlIlIIIlllIllIIlll, llllllllllllllIlIlIIIlllIllIIllI, 8, 3, false);
            this.getNextComponentX((Start)llllllllllllllIlIlIIIlllIllIlIII, llllllllllllllIlIlIIIlllIllIIlll, llllllllllllllIlIlIIIlllIllIIllI, 3, 8, false);
            this.getNextComponentZ((Start)llllllllllllllIlIlIIIlllIllIlIII, llllllllllllllIlIlIIIlllIllIIlll, llllllllllllllIlIlIIIlllIllIIllI, 3, 8, false);
        }
        
        public Crossing3() {
        }
    }
    
    public static class End extends Piece
    {
        private /* synthetic */ int fillSeed;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIIlIIlIIIIIlIlIlll) {
            super.writeStructureToNBT(lllllllllllllIIIlIIlIIIIIlIlIlll);
            lllllllllllllIIIlIIlIIIIIlIlIlll.setInteger("Seed", this.fillSeed);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIIlIIlIIIIIllIIIIl, final TemplateManager lllllllllllllIIIlIIlIIIIIlIlllIl) {
            super.readStructureFromNBT(lllllllllllllIIIlIIlIIIIIllIIIIl, lllllllllllllIIIlIIlIIIIIlIlllIl);
            this.fillSeed = lllllllllllllIIIlIIlIIIIIllIIIIl.getInteger("Seed");
        }
        
        public End() {
        }
        
        public End(final int lllllllllllllIIIlIIlIIIIlIIIIIIl, final Random lllllllllllllIIIlIIlIIIIlIIIIlIl, final StructureBoundingBox lllllllllllllIIIlIIlIIIIIlllllll, final EnumFacing lllllllllllllIIIlIIlIIIIlIIIIIll) {
            super(lllllllllllllIIIlIIlIIIIlIIIIIIl);
            this.setCoordBaseMode(lllllllllllllIIIlIIlIIIIlIIIIIll);
            this.boundingBox = lllllllllllllIIIlIIlIIIIIlllllll;
            this.fillSeed = lllllllllllllIIIlIIlIIIIlIIIIlIl.nextInt();
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIlIIlIIIIIlIIllIl, final Random lllllllllllllIIIlIIlIIIIIlIIllII, final StructureBoundingBox lllllllllllllIIIlIIlIIIIIIlllllI) {
            final Random lllllllllllllIIIlIIlIIIIIlIIlIlI = new Random(this.fillSeed);
            for (int lllllllllllllIIIlIIlIIIIIlIIlIIl = 0; lllllllllllllIIIlIIlIIIIIlIIlIIl <= 4; ++lllllllllllllIIIlIIlIIIIIlIIlIIl) {
                for (int lllllllllllllIIIlIIlIIIIIlIIlIII = 3; lllllllllllllIIIlIIlIIIIIlIIlIII <= 4; ++lllllllllllllIIIlIIlIIIIIlIIlIII) {
                    final int lllllllllllllIIIlIIlIIIIIlIIIlll = lllllllllllllIIIlIIlIIIIIlIIlIlI.nextInt(8);
                    this.fillWithBlocks(lllllllllllllIIIlIIlIIIIIlIIllIl, lllllllllllllIIIlIIlIIIIIIlllllI, lllllllllllllIIIlIIlIIIIIlIIlIIl, lllllllllllllIIIlIIlIIIIIlIIlIII, 0, lllllllllllllIIIlIIlIIIIIlIIlIIl, lllllllllllllIIIlIIlIIIIIlIIlIII, lllllllllllllIIIlIIlIIIIIlIIIlll, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                }
            }
            int lllllllllllllIIIlIIlIIIIIlIIIllI = lllllllllllllIIIlIIlIIIIIlIIlIlI.nextInt(8);
            this.fillWithBlocks(lllllllllllllIIIlIIlIIIIIlIIllIl, lllllllllllllIIIlIIlIIIIIIlllllI, 0, 5, 0, 0, 5, lllllllllllllIIIlIIlIIIIIlIIIllI, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            lllllllllllllIIIlIIlIIIIIlIIIllI = lllllllllllllIIIlIIlIIIIIlIIlIlI.nextInt(8);
            this.fillWithBlocks(lllllllllllllIIIlIIlIIIIIlIIllIl, lllllllllllllIIIlIIlIIIIIIlllllI, 4, 5, 0, 4, 5, lllllllllllllIIIlIIlIIIIIlIIIllI, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIIIlIIlIIIIIlIIIlIl = 0; lllllllllllllIIIlIIlIIIIIlIIIlIl <= 4; ++lllllllllllllIIIlIIlIIIIIlIIIlIl) {
                final int lllllllllllllIIIlIIlIIIIIlIIIlII = lllllllllllllIIIlIIlIIIIIlIIlIlI.nextInt(5);
                this.fillWithBlocks(lllllllllllllIIIlIIlIIIIIlIIllIl, lllllllllllllIIIlIIlIIIIIIlllllI, lllllllllllllIIIlIIlIIIIIlIIIlIl, 2, 0, lllllllllllllIIIlIIlIIIIIlIIIlIl, 2, lllllllllllllIIIlIIlIIIIIlIIIlII, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            }
            for (int lllllllllllllIIIlIIlIIIIIlIIIIll = 0; lllllllllllllIIIlIIlIIIIIlIIIIll <= 4; ++lllllllllllllIIIlIIlIIIIIlIIIIll) {
                for (int lllllllllllllIIIlIIlIIIIIlIIIIlI = 0; lllllllllllllIIIlIIlIIIIIlIIIIlI <= 1; ++lllllllllllllIIIlIIlIIIIIlIIIIlI) {
                    final int lllllllllllllIIIlIIlIIIIIlIIIIIl = lllllllllllllIIIlIIlIIIIIlIIlIlI.nextInt(3);
                    this.fillWithBlocks(lllllllllllllIIIlIIlIIIIIlIIllIl, lllllllllllllIIIlIIlIIIIIIlllllI, lllllllllllllIIIlIIlIIIIIlIIIIll, lllllllllllllIIIlIIlIIIIIlIIIIlI, 0, lllllllllllllIIIlIIlIIIIIlIIIIll, lllllllllllllIIIlIIlIIIIIlIIIIlI, lllllllllllllIIIlIIlIIIIIlIIIIIl, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                }
            }
            return true;
        }
        
        public static End createPiece(final List<StructureComponent> lllllllllllllIIIlIIlIIIIIlllIlIl, final Random lllllllllllllIIIlIIlIIIIIlllIlII, final int lllllllllllllIIIlIIlIIIIIllIlIll, final int lllllllllllllIIIlIIlIIIIIlllIIlI, final int lllllllllllllIIIlIIlIIIIIlllIIIl, final EnumFacing lllllllllllllIIIlIIlIIIIIlllIIII, final int lllllllllllllIIIlIIlIIIIIllIIlll) {
            final StructureBoundingBox lllllllllllllIIIlIIlIIIIIllIlllI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIIlIIlIIIIIllIlIll, lllllllllllllIIIlIIlIIIIIlllIIlI, lllllllllllllIIIlIIlIIIIIlllIIIl, -1, -3, 0, 5, 10, 8, lllllllllllllIIIlIIlIIIIIlllIIII);
            return (Piece.isAboveGround(lllllllllllllIIIlIIlIIIIIllIlllI) && StructureComponent.findIntersecting(lllllllllllllIIIlIIlIIIIIlllIlIl, lllllllllllllIIIlIIlIIIIIllIlllI) == null) ? new End(lllllllllllllIIIlIIlIIIIIllIIlll, lllllllllllllIIIlIIlIIIIIlllIlII, lllllllllllllIIIlIIlIIIIIllIlllI, lllllllllllllIIIlIIlIIIIIlllIIII) : null;
        }
    }
    
    public static class Corridor extends Piece
    {
        private /* synthetic */ boolean chest;
        
        public Corridor() {
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIIIIIlllllIlllIIlI, final List<StructureComponent> lllllllllllllIIIIIIlllllIlllIIIl, final Random lllllllllllllIIIIIIlllllIllIllII) {
            this.getNextComponentX((Start)lllllllllllllIIIIIIlllllIlllIIlI, lllllllllllllIIIIIIlllllIlllIIIl, lllllllllllllIIIIIIlllllIllIllII, 0, 1, true);
        }
        
        public Corridor(final int lllllllllllllIIIIIIllllllIIIlIlI, final Random lllllllllllllIIIIIIllllllIIIlllI, final StructureBoundingBox lllllllllllllIIIIIIllllllIIIllIl, final EnumFacing lllllllllllllIIIIIIllllllIIIllII) {
            super(lllllllllllllIIIIIIllllllIIIlIlI);
            this.setCoordBaseMode(lllllllllllllIIIIIIllllllIIIllII);
            this.boundingBox = lllllllllllllIIIIIIllllllIIIllIl;
            this.chest = (lllllllllllllIIIIIIllllllIIIlllI.nextInt(3) == 0);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIIIIIlllllIllllIII) {
            super.writeStructureToNBT(lllllllllllllIIIIIIlllllIllllIII);
            lllllllllllllIIIIIIlllllIllllIII.setBoolean("Chest", this.chest);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIIIIlllllIlIIIllI, final Random lllllllllllllIIIIIIlllllIlIIlIll, final StructureBoundingBox lllllllllllllIIIIIIlllllIlIIlIlI) {
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 4, 3, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 4, 3, 3, 4, 4, 3, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 0, 2, 4, 3, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            if (this.chest && lllllllllllllIIIIIIlllllIlIIlIlI.isVecInside(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
                this.chest = false;
                this.generateChest(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, lllllllllllllIIIIIIlllllIlIIlIll, 3, 2, 3, LootTableList.CHESTS_NETHER_BRIDGE);
            }
            this.fillWithBlocks(lllllllllllllIIIIIIlllllIlIIIllI, lllllllllllllIIIIIIlllllIlIIlIlI, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIIIIIIlllllIlIIlIIl = 0; lllllllllllllIIIIIIlllllIlIIlIIl <= 4; ++lllllllllllllIIIIIIlllllIlIIlIIl) {
                for (int lllllllllllllIIIIIIlllllIlIIlIII = 0; lllllllllllllIIIIIIlllllIlIIlIII <= 4; ++lllllllllllllIIIIIIlllllIlIIlIII) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIIIIIlllllIlIIIllI, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIIIIIlllllIlIIlIIl, -1, lllllllllllllIIIIIIlllllIlIIlIII, lllllllllllllIIIIIIlllllIlIIlIlI);
                }
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIIIIIllllllIIIIIlI, final TemplateManager lllllllllllllIIIIIIlllllIllllllI) {
            super.readStructureFromNBT(lllllllllllllIIIIIIllllllIIIIIlI, lllllllllllllIIIIIIlllllIllllllI);
            this.chest = lllllllllllllIIIIIIllllllIIIIIlI.getBoolean("Chest");
        }
        
        public static Corridor createPiece(final List<StructureComponent> lllllllllllllIIIIIIlllllIlIllIll, final Random lllllllllllllIIIIIIlllllIlIllIlI, final int lllllllllllllIIIIIIlllllIlIllIIl, final int lllllllllllllIIIIIIlllllIlIllIII, final int lllllllllllllIIIIIIlllllIlIlllll, final EnumFacing lllllllllllllIIIIIIlllllIlIllllI, final int lllllllllllllIIIIIIlllllIlIlIlIl) {
            final StructureBoundingBox lllllllllllllIIIIIIlllllIlIlllII = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIIIIIlllllIlIllIIl, lllllllllllllIIIIIIlllllIlIllIII, lllllllllllllIIIIIIlllllIlIlllll, -1, 0, 0, 5, 7, 5, lllllllllllllIIIIIIlllllIlIllllI);
            return (Piece.isAboveGround(lllllllllllllIIIIIIlllllIlIlllII) && StructureComponent.findIntersecting(lllllllllllllIIIIIIlllllIlIllIll, lllllllllllllIIIIIIlllllIlIlllII) == null) ? new Corridor(lllllllllllllIIIIIIlllllIlIlIlIl, lllllllllllllIIIIIIlllllIlIllIlI, lllllllllllllIIIIIIlllllIlIlllII, lllllllllllllIIIIIIlllllIlIllllI) : null;
        }
    }
    
    public static class Corridor5 extends Piece
    {
        public Corridor5(final int lllllllllllllIIIlIIllIIIlIlllIII, final Random lllllllllllllIIIlIIllIIIlIlllllI, final StructureBoundingBox lllllllllllllIIIlIIllIIIlIllllII, final EnumFacing lllllllllllllIIIlIIllIIIlIlllIlI) {
            super(lllllllllllllIIIlIIllIIIlIlllIII);
            this.setCoordBaseMode(lllllllllllllIIIlIIllIIIlIlllIlI);
            this.boundingBox = lllllllllllllIIIlIIllIIIlIllllII;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIIlIIllIIIlIlIllII, final List<StructureComponent> lllllllllllllIIIlIIllIIIlIlIlIll, final Random lllllllllllllIIIlIIllIIIlIlIlllI) {
            this.getNextComponentNormal((Start)lllllllllllllIIIlIIllIIIlIlIllII, lllllllllllllIIIlIIllIIIlIlIlIll, lllllllllllllIIIlIIllIIIlIlIlllI, 1, 0, true);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIlIIllIIIlIIIlIll, final Random lllllllllllllIIIlIIllIIIlIIIlIlI, final StructureBoundingBox lllllllllllllIIIlIIllIIIlIIIIlII) {
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 4, 3, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 4, 3, 3, 4, 4, 3, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlIIllIIIlIIIlIll, lllllllllllllIIIlIIllIIIlIIIIlII, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIIIlIIllIIIlIIIlIII = 0; lllllllllllllIIIlIIllIIIlIIIlIII <= 4; ++lllllllllllllIIIlIIllIIIlIIIlIII) {
                for (int lllllllllllllIIIlIIllIIIlIIIIlll = 0; lllllllllllllIIIlIIllIIIlIIIIlll <= 4; ++lllllllllllllIIIlIIllIIIlIIIIlll) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIIlIIllIIIlIIIlIll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIIlIIllIIIlIIIlIII, -1, lllllllllllllIIIlIIllIIIlIIIIlll, lllllllllllllIIIlIIllIIIlIIIIlII);
                }
            }
            return true;
        }
        
        public Corridor5() {
        }
        
        public static Corridor5 createPiece(final List<StructureComponent> lllllllllllllIIIlIIllIIIlIIllIIl, final Random lllllllllllllIIIlIIllIIIlIlIIIII, final int lllllllllllllIIIlIIllIIIlIIlllll, final int lllllllllllllIIIlIIllIIIlIIlIllI, final int lllllllllllllIIIlIIllIIIlIIlIlIl, final EnumFacing lllllllllllllIIIlIIllIIIlIIlllII, final int lllllllllllllIIIlIIllIIIlIIllIll) {
            final StructureBoundingBox lllllllllllllIIIlIIllIIIlIIllIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIIlIIllIIIlIIlllll, lllllllllllllIIIlIIllIIIlIIlIllI, lllllllllllllIIIlIIllIIIlIIlIlIl, -1, 0, 0, 5, 7, 5, lllllllllllllIIIlIIllIIIlIIlllII);
            return (Piece.isAboveGround(lllllllllllllIIIlIIllIIIlIIllIlI) && StructureComponent.findIntersecting(lllllllllllllIIIlIIllIIIlIIllIIl, lllllllllllllIIIlIIllIIIlIIllIlI) == null) ? new Corridor5(lllllllllllllIIIlIIllIIIlIIllIll, lllllllllllllIIIlIIllIIIlIlIIIII, lllllllllllllIIIlIIllIIIlIIllIlI, lllllllllllllIIIlIIllIIIlIIlllII) : null;
        }
    }
    
    public static class Corridor4 extends Piece
    {
        public static Corridor4 createPiece(final List<StructureComponent> llIIIllIlllllI, final Random llIIIllIllIlIl, final int llIIIllIllllII, final int llIIIllIlllIll, final int llIIIllIlllIlI, final EnumFacing llIIIllIllIIIl, final int llIIIllIllIIII) {
            final StructureBoundingBox llIIIllIllIlll = StructureBoundingBox.getComponentToAddBoundingBox(llIIIllIllllII, llIIIllIlllIll, llIIIllIlllIlI, -3, 0, 0, 9, 7, 9, llIIIllIllIIIl);
            return (Piece.isAboveGround(llIIIllIllIlll) && StructureComponent.findIntersecting(llIIIllIlllllI, llIIIllIllIlll) == null) ? new Corridor4(llIIIllIllIIII, llIIIllIllIlIl, llIIIllIllIlll, llIIIllIllIIIl) : null;
        }
        
        @Override
        public boolean addComponentParts(final World llIIIllIlIIIlI, final Random llIIIllIlIIlll, final StructureBoundingBox llIIIllIlIIllI) {
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 0, 0, 0, 8, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 0, 2, 0, 8, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 0, 6, 0, 8, 6, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 0, 2, 0, 2, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 6, 2, 0, 8, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 1, 3, 0, 1, 4, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 7, 3, 0, 7, 4, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 0, 2, 4, 8, 2, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 1, 1, 4, 2, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 6, 1, 4, 7, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 0, 3, 8, 8, 3, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 0, 3, 6, 0, 3, 7, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 8, 3, 6, 8, 3, 7, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 0, 3, 4, 0, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 8, 3, 4, 8, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 1, 3, 5, 2, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 6, 3, 5, 7, 5, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 1, 4, 5, 1, 5, 5, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llIIIllIlIIIlI, llIIIllIlIIllI, 7, 4, 5, 7, 5, 5, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            for (int llIIIllIlIIlIl = 0; llIIIllIlIIlIl <= 5; ++llIIIllIlIIlIl) {
                for (int llIIIllIlIIlII = 0; llIIIllIlIIlII <= 8; ++llIIIllIlIIlII) {
                    this.replaceAirAndLiquidDownwards(llIIIllIlIIIlI, Blocks.NETHER_BRICK.getDefaultState(), llIIIllIlIIlII, -1, llIIIllIlIIlIl, llIIIllIlIIllI);
                }
            }
            return true;
        }
        
        public Corridor4() {
        }
        
        public Corridor4(final int llIIIlllIllIll, final Random llIIIlllIlllll, final StructureBoundingBox llIIIlllIllllI, final EnumFacing llIIIlllIllIIl) {
            super(llIIIlllIllIll);
            this.setCoordBaseMode(llIIIlllIllIIl);
            this.boundingBox = llIIIlllIllllI;
        }
        
        @Override
        public void buildComponent(final StructureComponent llIIIlllIlIIIl, final List<StructureComponent> llIIIlllIlIIII, final Random llIIIlllIIllll) {
            int llIIIlllIIlllI = 1;
            final EnumFacing llIIIlllIIllIl = this.getCoordBaseMode();
            if (llIIIlllIIllIl == EnumFacing.WEST || llIIIlllIIllIl == EnumFacing.NORTH) {
                llIIIlllIIlllI = 5;
            }
            this.getNextComponentX((Start)llIIIlllIlIIIl, llIIIlllIlIIII, llIIIlllIIllll, 0, llIIIlllIIlllI, llIIIlllIIllll.nextInt(8) > 0);
            this.getNextComponentZ((Start)llIIIlllIlIIIl, llIIIlllIlIIII, llIIIlllIIllll, 0, llIIIlllIIlllI, llIIIlllIIllll.nextInt(8) > 0);
        }
    }
    
    public static class Straight extends Piece
    {
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIlIIIlIllIIIIl, final Random llllllllllllllIIlIIlIIIlIllIIllI, final StructureBoundingBox llllllllllllllIIlIIlIIIlIllIIIII) {
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 3, 0, 4, 4, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 1, 5, 0, 3, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 5, 0, 0, 5, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 4, 5, 0, 4, 5, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 2, 0, 4, 2, 5, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 2, 13, 4, 2, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 0, 0, 4, 1, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 0, 15, 4, 1, 18, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllllllIIlIIlIIIlIllIIlII = 0; llllllllllllllIIlIIlIIIlIllIIlII <= 4; ++llllllllllllllIIlIIlIIIlIllIIlII) {
                for (int llllllllllllllIIlIIlIIIlIllIIIll = 0; llllllllllllllIIlIIlIIIlIllIIIll <= 2; ++llllllllllllllIIlIIlIIIlIllIIIll) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIIlIIlIIIlIllIIIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIIlIIlIIIlIllIIlII, -1, llllllllllllllIIlIIlIIIlIllIIIll, llllllllllllllIIlIIlIIIlIllIIIII);
                    this.replaceAirAndLiquidDownwards(llllllllllllllIIlIIlIIIlIllIIIIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIIlIIlIIIlIllIIlII, -1, 18 - llllllllllllllIIlIIlIIIlIllIIIll, llllllllllllllIIlIIlIIIlIllIIIII);
                }
            }
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 1, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 3, 4, 0, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 3, 14, 0, 4, 14, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 0, 1, 17, 0, 4, 17, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 4, 1, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 4, 3, 4, 4, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 4, 3, 14, 4, 4, 14, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlIllIIIIl, llllllllllllllIIlIIlIIIlIllIIIII, 4, 1, 17, 4, 4, 17, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            return true;
        }
        
        public static Straight createPiece(final List<StructureComponent> llllllllllllllIIlIIlIIIlIlllllIl, final Random llllllllllllllIIlIIlIIIlIlllllII, final int llllllllllllllIIlIIlIIIlIllllIll, final int llllllllllllllIIlIIlIIIlIllllIlI, final int llllllllllllllIIlIIlIIIlIlllIIIl, final EnumFacing llllllllllllllIIlIIlIIIlIllllIII, final int llllllllllllllIIlIIlIIIlIlllIlll) {
            final StructureBoundingBox llllllllllllllIIlIIlIIIlIlllIllI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIIlIIlIIIlIllllIll, llllllllllllllIIlIIlIIIlIllllIlI, llllllllllllllIIlIIlIIIlIlllIIIl, -1, -3, 0, 5, 10, 19, llllllllllllllIIlIIlIIIlIllllIII);
            return (Piece.isAboveGround(llllllllllllllIIlIIlIIIlIlllIllI) && StructureComponent.findIntersecting(llllllllllllllIIlIIlIIIlIlllllIl, llllllllllllllIIlIIlIIIlIlllIllI) == null) ? new Straight(llllllllllllllIIlIIlIIIlIlllIlll, llllllllllllllIIlIIlIIIlIlllllII, llllllllllllllIIlIIlIIIlIlllIllI, llllllllllllllIIlIIlIIIlIllllIII) : null;
        }
        
        public Straight() {
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIIlIIlIIIllIIIllII, final List<StructureComponent> llllllllllllllIIlIIlIIIllIIIIlll, final Random llllllllllllllIIlIIlIIIllIIIIllI) {
            this.getNextComponentNormal((Start)llllllllllllllIIlIIlIIIllIIIllII, llllllllllllllIIlIIlIIIllIIIIlll, llllllllllllllIIlIIlIIIllIIIIllI, 1, 3, false);
        }
        
        public Straight(final int llllllllllllllIIlIIlIIIllIIllIIl, final Random llllllllllllllIIlIIlIIIllIIllIII, final StructureBoundingBox llllllllllllllIIlIIlIIIllIIlIIll, final EnumFacing llllllllllllllIIlIIlIIIllIIlIllI) {
            super(llllllllllllllIIlIIlIIIllIIllIIl);
            this.setCoordBaseMode(llllllllllllllIIlIIlIIIllIIlIllI);
            this.boundingBox = llllllllllllllIIlIIlIIIllIIlIIll;
        }
    }
    
    public static class Throne extends Piece
    {
        private /* synthetic */ boolean hasSpawner;
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIlIIIlllIlIlll, final Random llllllllllllllIIlIIlIIIlllIlIllI, final StructureBoundingBox llllllllllllllIIlIIlIIIlllIlIlIl) {
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 0, 2, 0, 6, 7, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 1, 0, 0, 5, 1, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 1, 2, 1, 5, 2, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 1, 3, 2, 5, 3, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 1, 4, 3, 5, 4, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 1, 2, 0, 1, 4, 2, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 5, 2, 0, 5, 4, 2, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 1, 5, 2, 1, 5, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 5, 5, 2, 5, 5, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 0, 5, 3, 0, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 6, 5, 3, 6, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 1, 5, 8, 5, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.setBlockState(llllllllllllllIIlIIlIIIlllIlIlll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 1, 6, 3, llllllllllllllIIlIIlIIIlllIlIlIl);
            this.setBlockState(llllllllllllllIIlIIlIIIlllIlIlll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 5, 6, 3, llllllllllllllIIlIIlIIIlllIlIlIl);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 0, 6, 3, 0, 6, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 6, 6, 3, 6, 6, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 1, 6, 8, 5, 7, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIIIlllIlIlll, llllllllllllllIIlIIlIIIlllIlIlIl, 2, 8, 8, 4, 8, 8, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            if (!this.hasSpawner) {
                final BlockPos llllllllllllllIIlIIlIIIlllIlIlII = new BlockPos(this.getXWithOffset(3, 5), this.getYWithOffset(5), this.getZWithOffset(3, 5));
                if (llllllllllllllIIlIIlIIIlllIlIlIl.isVecInside(llllllllllllllIIlIIlIIIlllIlIlII)) {
                    this.hasSpawner = true;
                    llllllllllllllIIlIIlIIIlllIlIlll.setBlockState(llllllllllllllIIlIIlIIIlllIlIlII, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                    final TileEntity llllllllllllllIIlIIlIIIlllIlIIll = llllllllllllllIIlIIlIIIlllIlIlll.getTileEntity(llllllllllllllIIlIIlIIIlllIlIlII);
                    if (llllllllllllllIIlIIlIIIlllIlIIll instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner)llllllllllllllIIlIIlIIIlllIlIIll).getSpawnerBaseLogic().func_190894_a(EntityList.func_191306_a(EntityBlaze.class));
                    }
                }
            }
            for (int llllllllllllllIIlIIlIIIlllIlIIlI = 0; llllllllllllllIIlIIlIIIlllIlIIlI <= 6; ++llllllllllllllIIlIIlIIIlllIlIIlI) {
                for (int llllllllllllllIIlIIlIIIlllIlIIIl = 0; llllllllllllllIIlIIlIIIlllIlIIIl <= 6; ++llllllllllllllIIlIIlIIIlllIlIIIl) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIIlIIlIIIlllIlIlll, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIIlIIlIIIlllIlIIlI, -1, llllllllllllllIIlIIlIIIlllIlIIIl, llllllllllllllIIlIIlIIIlllIlIlIl);
                }
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIIlIIlIIlIIIIIIIII, final TemplateManager llllllllllllllIIlIIlIIIlllllllll) {
            super.readStructureFromNBT(llllllllllllllIIlIIlIIlIIIIIIIII, llllllllllllllIIlIIlIIIlllllllll);
            this.hasSpawner = llllllllllllllIIlIIlIIlIIIIIIIII.getBoolean("Mob");
        }
        
        public Throne(final int llllllllllllllIIlIIlIIlIIIIIllII, final Random llllllllllllllIIlIIlIIlIIIIIlIll, final StructureBoundingBox llllllllllllllIIlIIlIIlIIIIIlIlI, final EnumFacing llllllllllllllIIlIIlIIlIIIIIlIIl) {
            super(llllllllllllllIIlIIlIIlIIIIIllII);
            this.setCoordBaseMode(llllllllllllllIIlIIlIIlIIIIIlIIl);
            this.boundingBox = llllllllllllllIIlIIlIIlIIIIIlIlI;
        }
        
        public static Throne createPiece(final List<StructureComponent> llllllllllllllIIlIIlIIIllllIIlIl, final Random llllllllllllllIIlIIlIIIllllIllII, final int llllllllllllllIIlIIlIIIllllIIIll, final int llllllllllllllIIlIIlIIIllllIlIlI, final int llllllllllllllIIlIIlIIIllllIlIIl, final int llllllllllllllIIlIIlIIIllllIIIII, final EnumFacing llllllllllllllIIlIIlIIIllllIIlll) {
            final StructureBoundingBox llllllllllllllIIlIIlIIIllllIIllI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIIlIIlIIIllllIIIll, llllllllllllllIIlIIlIIIllllIlIlI, llllllllllllllIIlIIlIIIllllIlIIl, -2, 0, 0, 7, 8, 9, llllllllllllllIIlIIlIIIllllIIlll);
            return (Piece.isAboveGround(llllllllllllllIIlIIlIIIllllIIllI) && StructureComponent.findIntersecting(llllllllllllllIIlIIlIIIllllIIlIl, llllllllllllllIIlIIlIIIllllIIllI) == null) ? new Throne(llllllllllllllIIlIIlIIIllllIIIII, llllllllllllllIIlIIlIIIllllIllII, llllllllllllllIIlIIlIIIllllIIllI, llllllllllllllIIlIIlIIIllllIIlll) : null;
        }
        
        public Throne() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIIlIIlIIIlllllIllI) {
            super.writeStructureToNBT(llllllllllllllIIlIIlIIIlllllIllI);
            llllllllllllllIIlIIlIIIlllllIllI.setBoolean("Mob", this.hasSpawner);
        }
    }
    
    public static class Corridor2 extends Piece
    {
        private /* synthetic */ boolean chest;
        
        public Corridor2(final int lllllllllllllIIlIIIllIlIlllIlIII, final Random lllllllllllllIIlIIIllIlIlllIIlll, final StructureBoundingBox lllllllllllllIIlIIIllIlIlllIIllI, final EnumFacing lllllllllllllIIlIIIllIlIlllIIlIl) {
            super(lllllllllllllIIlIIIllIlIlllIlIII);
            this.setCoordBaseMode(lllllllllllllIIlIIIllIlIlllIIlIl);
            this.boundingBox = lllllllllllllIIlIIIllIlIlllIIllI;
            this.chest = (lllllllllllllIIlIIIllIlIlllIIlll.nextInt(3) == 0);
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIlIIIllIlIllIlIIII, final List<StructureComponent> lllllllllllllIIlIIIllIlIllIIlIll, final Random lllllllllllllIIlIIIllIlIllIIlIlI) {
            this.getNextComponentZ((Start)lllllllllllllIIlIIIllIlIllIlIIII, lllllllllllllIIlIIIllIlIllIIlIll, lllllllllllllIIlIIIllIlIllIIlIlI, 0, 1, true);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIlIIIllIlIllIllIII) {
            super.writeStructureToNBT(lllllllllllllIIlIIIllIlIllIllIII);
            lllllllllllllIIlIIIllIlIllIllIII.setBoolean("Chest", this.chest);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIIIllIlIlIlIIlII, final Random lllllllllllllIIlIIIllIlIlIlIIIll, final StructureBoundingBox lllllllllllllIIlIIIllIlIlIlIlIII) {
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 1, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            if (this.chest && lllllllllllllIIlIIIllIlIlIlIlIII.isVecInside(new BlockPos(this.getXWithOffset(1, 3), this.getYWithOffset(2), this.getZWithOffset(1, 3)))) {
                this.chest = false;
                this.generateChest(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, lllllllllllllIIlIIIllIlIlIlIIIll, 1, 2, 3, LootTableList.CHESTS_NETHER_BRIDGE);
            }
            this.fillWithBlocks(lllllllllllllIIlIIIllIlIlIlIIlII, lllllllllllllIIlIIIllIlIlIlIlIII, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIIlIIIllIlIlIlIIlll = 0; lllllllllllllIIlIIIllIlIlIlIIlll <= 4; ++lllllllllllllIIlIIIllIlIlIlIIlll) {
                for (int lllllllllllllIIlIIIllIlIlIlIIllI = 0; lllllllllllllIIlIIIllIlIlIlIIllI <= 4; ++lllllllllllllIIlIIIllIlIlIlIIllI) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlIIIllIlIlIlIIlII, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIlIIIllIlIlIlIIlll, -1, lllllllllllllIIlIIIllIlIlIlIIllI, lllllllllllllIIlIIIllIlIlIlIlIII);
                }
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIlIIIllIlIllIlllIl, final TemplateManager lllllllllllllIIlIIIllIlIllIlllII) {
            super.readStructureFromNBT(lllllllllllllIIlIIIllIlIllIlllIl, lllllllllllllIIlIIIllIlIllIlllII);
            this.chest = lllllllllllllIIlIIIllIlIllIlllIl.getBoolean("Chest");
        }
        
        public Corridor2() {
        }
        
        public static Corridor2 createPiece(final List<StructureComponent> lllllllllllllIIlIIIllIlIlIlllIIl, final Random lllllllllllllIIlIIIllIlIllIIIIII, final int lllllllllllllIIlIIIllIlIlIllllll, final int lllllllllllllIIlIIIllIlIlIllIllI, final int lllllllllllllIIlIIIllIlIlIllllIl, final EnumFacing lllllllllllllIIlIIIllIlIlIllllII, final int lllllllllllllIIlIIIllIlIlIllIIll) {
            final StructureBoundingBox lllllllllllllIIlIIIllIlIlIlllIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlIIIllIlIlIllllll, lllllllllllllIIlIIIllIlIlIllIllI, lllllllllllllIIlIIIllIlIlIllllIl, -1, 0, 0, 5, 7, 5, lllllllllllllIIlIIIllIlIlIllllII);
            return (Piece.isAboveGround(lllllllllllllIIlIIIllIlIlIlllIlI) && StructureComponent.findIntersecting(lllllllllllllIIlIIIllIlIlIlllIIl, lllllllllllllIIlIIIllIlIlIlllIlI) == null) ? new Corridor2(lllllllllllllIIlIIIllIlIlIllIIll, lllllllllllllIIlIIIllIlIllIIIIII, lllllllllllllIIlIIIllIlIlIlllIlI, lllllllllllllIIlIIIllIlIlIllllII) : null;
        }
    }
    
    public static class NetherStalkRoom extends Piece
    {
        public static NetherStalkRoom createPiece(final List<StructureComponent> lllllllllllllIllIlIIIlIllIIIlIIl, final Random lllllllllllllIllIlIIIlIllIIIlIII, final int lllllllllllllIllIlIIIlIllIIIIlll, final int lllllllllllllIllIlIIIlIlIllllllI, final int lllllllllllllIllIlIIIlIllIIIIlIl, final EnumFacing lllllllllllllIllIlIIIlIlIlllllII, final int lllllllllllllIllIlIIIlIlIllllIll) {
            final StructureBoundingBox lllllllllllllIllIlIIIlIllIIIIIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIllIlIIIlIllIIIIlll, lllllllllllllIllIlIIIlIlIllllllI, lllllllllllllIllIlIIIlIllIIIIlIl, -5, -3, 0, 13, 14, 13, lllllllllllllIllIlIIIlIlIlllllII);
            return (Piece.isAboveGround(lllllllllllllIllIlIIIlIllIIIIIlI) && StructureComponent.findIntersecting(lllllllllllllIllIlIIIlIllIIIlIIl, lllllllllllllIllIlIIIlIllIIIIIlI) == null) ? new NetherStalkRoom(lllllllllllllIllIlIIIlIlIllllIll, lllllllllllllIllIlIIIlIllIIIlIII, lllllllllllllIllIlIIIlIllIIIIIlI, lllllllllllllIllIlIIIlIlIlllllII) : null;
        }
        
        public NetherStalkRoom(final int lllllllllllllIllIlIIIlIllIlIIIII, final Random lllllllllllllIllIlIIIlIllIlIIlII, final StructureBoundingBox lllllllllllllIllIlIIIlIllIIlllll, final EnumFacing lllllllllllllIllIlIIIlIllIlIIIlI) {
            super(lllllllllllllIllIlIIIlIllIlIIIII);
            this.setCoordBaseMode(lllllllllllllIllIlIIIlIllIlIIIlI);
            this.boundingBox = lllllllllllllIllIlIIIlIllIIlllll;
        }
        
        public NetherStalkRoom() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIllIlIIIlIlIlIlllll, final Random lllllllllllllIllIlIIIlIlIllIllll, final StructureBoundingBox lllllllllllllIllIlIIIlIlIllIlllI) {
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIllIlIIIlIlIllIllIl = 1; lllllllllllllIllIlIIIlIlIllIllIl <= 11; lllllllllllllIllIlIIIlIlIllIllIl += 2) {
                this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, lllllllllllllIllIlIIIlIlIllIllIl, 10, 0, lllllllllllllIllIlIIIlIlIllIllIl, 11, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, lllllllllllllIllIlIIIlIlIllIllIl, 10, 12, lllllllllllllIllIlIIIlIlIllIllIl, 11, 12, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 0, 10, lllllllllllllIllIlIIIlIlIllIllIl, 0, 11, lllllllllllllIllIlIIIlIlIllIllIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 12, 10, lllllllllllllIllIlIIIlIlIllIllIl, 12, 11, lllllllllllllIllIlIIIlIlIllIllIl, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIIIlIlIllIllIl, 13, 0, lllllllllllllIllIlIIIlIlIllIlllI);
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIIIlIlIllIllIl, 13, 12, lllllllllllllIllIlIIIlIlIllIlllI);
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK.getDefaultState(), 0, 13, lllllllllllllIllIlIIIlIlIllIllIl, lllllllllllllIllIlIIIlIlIllIlllI);
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK.getDefaultState(), 12, 13, lllllllllllllIllIlIIIlIlIllIllIl, lllllllllllllIllIlIIIlIlIllIlllI);
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), lllllllllllllIllIlIIIlIlIllIllIl + 1, 13, 0, lllllllllllllIllIlIIIlIlIllIlllI);
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), lllllllllllllIllIlIIIlIlIllIllIl + 1, 13, 12, lllllllllllllIllIlIIIlIlIllIlllI);
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, lllllllllllllIllIlIIIlIlIllIllIl + 1, lllllllllllllIllIlIIIlIlIllIlllI);
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 12, 13, lllllllllllllIllIlIIIlIlIllIllIl + 1, lllllllllllllIllIlIIIlIlIllIlllI);
            }
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 12, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 12, 13, 0, lllllllllllllIllIlIIIlIlIllIlllI);
            for (int lllllllllllllIllIlIIIlIlIllIllII = 3; lllllllllllllIllIlIIIlIlIllIllII <= 9; lllllllllllllIllIlIIIlIlIllIllII += 2) {
                this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 1, 7, lllllllllllllIllIlIIIlIlIllIllII, 1, 8, lllllllllllllIllIlIIIlIlIllIllII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 11, 7, lllllllllllllIllIlIIIlIlIllIllII, 11, 8, lllllllllllllIllIlIIIlIlIllIllII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            }
            final IBlockState lllllllllllllIllIlIIIlIlIllIlIll = Blocks.NETHER_BRICK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            for (int lllllllllllllIllIlIIIlIlIllIlIlI = 0; lllllllllllllIllIlIIIlIlIllIlIlI <= 6; ++lllllllllllllIllIlIIIlIlIllIlIlI) {
                final int lllllllllllllIllIlIIIlIlIllIlIIl = lllllllllllllIllIlIIIlIlIllIlIlI + 4;
                for (int lllllllllllllIllIlIIIlIlIllIlIII = 5; lllllllllllllIllIlIIIlIlIllIlIII <= 7; ++lllllllllllllIllIlIIIlIlIllIlIII) {
                    this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlIll, lllllllllllllIllIlIIIlIlIllIlIII, 5 + lllllllllllllIllIlIIIlIlIllIlIlI, lllllllllllllIllIlIIIlIlIllIlIIl, lllllllllllllIllIlIIIlIlIllIlllI);
                }
                if (lllllllllllllIllIlIIIlIlIllIlIIl >= 5 && lllllllllllllIllIlIIIlIlIllIlIIl <= 8) {
                    this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 5, 5, lllllllllllllIllIlIIIlIlIllIlIIl, 7, lllllllllllllIllIlIIIlIlIllIlIlI + 4, lllllllllllllIllIlIIIlIlIllIlIIl, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                }
                else if (lllllllllllllIllIlIIIlIlIllIlIIl >= 9 && lllllllllllllIllIlIIIlIlIllIlIIl <= 10) {
                    this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 5, 8, lllllllllllllIllIlIIIlIlIllIlIIl, 7, lllllllllllllIllIlIIIlIlIllIlIlI + 4, lllllllllllllIllIlIIIlIlIllIlIIl, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                }
                if (lllllllllllllIllIlIIIlIlIllIlIlI >= 1) {
                    this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 5, 6 + lllllllllllllIllIlIIIlIlIllIlIlI, lllllllllllllIllIlIIIlIlIllIlIIl, 7, 9 + lllllllllllllIllIlIIIlIlIllIlIlI, lllllllllllllIllIlIIIlIlIllIlIIl, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                }
            }
            for (int lllllllllllllIllIlIIIlIlIllIIlll = 5; lllllllllllllIllIlIIIlIlIllIIlll <= 7; ++lllllllllllllIllIlIIIlIlIllIIlll) {
                this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlIll, lllllllllllllIllIlIIIlIlIllIIlll, 12, 11, lllllllllllllIllIlIIIlIlIllIlllI);
            }
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 5, 6, 7, 5, 7, 7, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 7, 6, 7, 7, 7, 7, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 5, 13, 12, 7, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 2, 5, 2, 3, 5, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 2, 5, 9, 3, 5, 10, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 2, 5, 4, 2, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 9, 5, 2, 10, 5, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 9, 5, 9, 10, 5, 10, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 10, 5, 4, 10, 5, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            final IBlockState lllllllllllllIllIlIIIlIlIllIIllI = lllllllllllllIllIlIIIlIlIllIlIll.withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllllIllIlIIIlIlIllIIlIl = lllllllllllllIllIlIIIlIlIllIlIll.withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIIlIl, 4, 5, 2, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIIlIl, 4, 5, 3, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIIlIl, 4, 5, 9, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIIlIl, 4, 5, 10, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIIllI, 8, 5, 2, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIIllI, 8, 5, 3, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIIllI, 8, 5, 9, lllllllllllllIllIlIIIlIlIllIlllI);
            this.setBlockState(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIIllI, 8, 5, 10, lllllllllllllIllIlIIIlIlIllIlllI);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 3, 4, 4, 4, 4, 8, Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 8, 4, 4, 9, 4, 8, Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 3, 5, 4, 4, 5, 8, Blocks.NETHER_WART.getDefaultState(), Blocks.NETHER_WART.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 8, 5, 4, 9, 5, 8, Blocks.NETHER_WART.getDefaultState(), Blocks.NETHER_WART.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIllIlIIIlIlIlIlllll, lllllllllllllIllIlIIIlIlIllIlllI, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIllIlIIIlIlIllIIlII = 4; lllllllllllllIllIlIIIlIlIllIIlII <= 8; ++lllllllllllllIllIlIIIlIlIllIIlII) {
                for (int lllllllllllllIllIlIIIlIlIllIIIll = 0; lllllllllllllIllIlIIIlIlIllIIIll <= 2; ++lllllllllllllIllIlIIIlIlIllIIIll) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIIIlIlIllIIlII, -1, lllllllllllllIllIlIIIlIlIllIIIll, lllllllllllllIllIlIIIlIlIllIlllI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIIIlIlIllIIlII, -1, 12 - lllllllllllllIllIlIIIlIlIllIIIll, lllllllllllllIllIlIIIlIlIllIlllI);
                }
            }
            for (int lllllllllllllIllIlIIIlIlIllIIIlI = 0; lllllllllllllIllIlIIIlIlIllIIIlI <= 2; ++lllllllllllllIllIlIIIlIlIllIIIlI) {
                for (int lllllllllllllIllIlIIIlIlIllIIIIl = 4; lllllllllllllIllIlIIIlIlIllIIIIl <= 8; ++lllllllllllllIllIlIIIlIlIllIIIIl) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIllIlIIIlIlIllIIIlI, -1, lllllllllllllIllIlIIIlIlIllIIIIl, lllllllllllllIllIlIIIlIlIllIlllI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIllIlIIIlIlIlIlllll, Blocks.NETHER_BRICK.getDefaultState(), 12 - lllllllllllllIllIlIIIlIlIllIIIlI, -1, lllllllllllllIllIlIIIlIlIllIIIIl, lllllllllllllIllIlIIIlIlIllIlllI);
                }
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIllIlIIIlIllIIlIlII, final List<StructureComponent> lllllllllllllIllIlIIIlIllIIlIlll, final Random lllllllllllllIllIlIIIlIllIIlIllI) {
            this.getNextComponentNormal((Start)lllllllllllllIllIlIIIlIllIIlIlII, lllllllllllllIllIlIIIlIllIIlIlll, lllllllllllllIllIlIIIlIllIIlIllI, 5, 3, true);
            this.getNextComponentNormal((Start)lllllllllllllIllIlIIIlIllIIlIlII, lllllllllllllIllIlIIIlIllIIlIlll, lllllllllllllIllIlIIIlIllIIlIllI, 5, 11, true);
        }
    }
    
    public static class Crossing2 extends Piece
    {
        public Crossing2() {
        }
        
        public Crossing2(final int llllllllllllllIlIlIIlIlllIlIIlll, final Random llllllllllllllIlIlIIlIlllIlIlIll, final StructureBoundingBox llllllllllllllIlIlIIlIlllIlIIllI, final EnumFacing llllllllllllllIlIlIIlIlllIlIIlIl) {
            super(llllllllllllllIlIlIIlIlllIlIIlll);
            this.setCoordBaseMode(llllllllllllllIlIlIIlIlllIlIIlIl);
            this.boundingBox = llllllllllllllIlIlIIlIlllIlIIllI;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIlIlIIlIllIlIlIlII, final Random llllllllllllllIlIlIIlIllIlIllIIl, final StructureBoundingBox llllllllllllllIlIlIIlIllIlIllIII) {
            this.fillWithBlocks(llllllllllllllIlIlIIlIllIlIlIlII, llllllllllllllIlIlIIlIllIlIllIII, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIllIlIlIlII, llllllllllllllIlIlIIlIllIlIllIII, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIllIlIlIlII, llllllllllllllIlIlIIlIllIlIllIII, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIllIlIlIlII, llllllllllllllIlIlIIlIllIlIllIII, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIllIlIlIlII, llllllllllllllIlIlIIlIllIlIllIII, 0, 2, 4, 0, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIllIlIlIlII, llllllllllllllIlIlIIlIllIlIllIII, 4, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIlIlIIlIllIlIlIlII, llllllllllllllIlIlIIlIllIlIllIII, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int llllllllllllllIlIlIIlIllIlIlIlll = 0; llllllllllllllIlIlIIlIllIlIlIlll <= 4; ++llllllllllllllIlIlIIlIllIlIlIlll) {
                for (int llllllllllllllIlIlIIlIllIlIlIllI = 0; llllllllllllllIlIlIIlIllIlIlIllI <= 4; ++llllllllllllllIlIlIIlIllIlIlIllI) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllIlIlIIlIllIlIlIlII, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllIlIlIIlIllIlIlIlll, -1, llllllllllllllIlIlIIlIllIlIlIllI, llllllllllllllIlIlIIlIllIlIllIII);
                }
            }
            return true;
        }
        
        public static Crossing2 createPiece(final List<StructureComponent> llllllllllllllIlIlIIlIllIllIlllI, final Random llllllllllllllIlIlIIlIllIllIllII, final int llllllllllllllIlIlIIlIllIllIlIlI, final int llllllllllllllIlIlIIlIllIllIlIII, final int llllllllllllllIlIlIIlIllIlllIllI, final EnumFacing llllllllllllllIlIlIIlIllIlllIlII, final int llllllllllllllIlIlIIlIllIlllIIlI) {
            final StructureBoundingBox llllllllllllllIlIlIIlIllIlllIIII = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIlIlIIlIllIllIlIlI, llllllllllllllIlIlIIlIllIllIlIII, llllllllllllllIlIlIIlIllIlllIllI, -1, 0, 0, 5, 7, 5, llllllllllllllIlIlIIlIllIlllIlII);
            return (Piece.isAboveGround(llllllllllllllIlIlIIlIllIlllIIII) && StructureComponent.findIntersecting(llllllllllllllIlIlIIlIllIllIlllI, llllllllllllllIlIlIIlIllIlllIIII) == null) ? new Crossing2(llllllllllllllIlIlIIlIllIlllIIlI, llllllllllllllIlIlIIlIllIllIllII, llllllllllllllIlIlIIlIllIlllIIII, llllllllllllllIlIlIIlIllIlllIlII) : null;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIlIlIIlIlllIIlllII, final List<StructureComponent> llllllllllllllIlIlIIlIlllIIllIll, final Random llllllllllllllIlIlIIlIlllIIllIlI) {
            this.getNextComponentNormal((Start)llllllllllllllIlIlIIlIlllIIlllII, llllllllllllllIlIlIIlIlllIIllIll, llllllllllllllIlIlIIlIlllIIllIlI, 1, 0, true);
            this.getNextComponentX((Start)llllllllllllllIlIlIIlIlllIIlllII, llllllllllllllIlIlIIlIlllIIllIll, llllllllllllllIlIlIIlIlllIIllIlI, 0, 1, true);
            this.getNextComponentZ((Start)llllllllllllllIlIlIIlIlllIIlllII, llllllllllllllIlIlIIlIlllIIllIll, llllllllllllllIlIlIIlIlllIIllIlI, 0, 1, true);
        }
    }
    
    public static class Crossing extends Piece
    {
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIlIllIIlIlllIIIIlI, final List<StructureComponent> lllllllllllllIIlIllIIlIlllIIIIIl, final Random lllllllllllllIIlIllIIlIlllIIIIII) {
            this.getNextComponentNormal((Start)lllllllllllllIIlIllIIlIlllIIIIlI, lllllllllllllIIlIllIIlIlllIIIIIl, lllllllllllllIIlIllIIlIlllIIIIII, 2, 0, false);
            this.getNextComponentX((Start)lllllllllllllIIlIllIIlIlllIIIIlI, lllllllllllllIIlIllIIlIlllIIIIIl, lllllllllllllIIlIllIIlIlllIIIIII, 0, 2, false);
            this.getNextComponentZ((Start)lllllllllllllIIlIllIIlIlllIIIIlI, lllllllllllllIIlIllIIlIlllIIIIIl, lllllllllllllIIlIllIIlIlllIIIIII, 0, 2, false);
        }
        
        public static Crossing createPiece(final List<StructureComponent> lllllllllllllIIlIllIIlIllIllIIll, final Random lllllllllllllIIlIllIIlIllIllIIlI, final int lllllllllllllIIlIllIIlIllIllIIIl, final int lllllllllllllIIlIllIIlIllIllIIII, final int lllllllllllllIIlIllIIlIllIlIllll, final EnumFacing lllllllllllllIIlIllIIlIllIlIlllI, final int lllllllllllllIIlIllIIlIllIlIllIl) {
            final StructureBoundingBox lllllllllllllIIlIllIIlIllIlIllII = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlIllIIlIllIllIIIl, lllllllllllllIIlIllIIlIllIllIIII, lllllllllllllIIlIllIIlIllIlIllll, -2, 0, 0, 7, 9, 7, lllllllllllllIIlIllIIlIllIlIlllI);
            return (Piece.isAboveGround(lllllllllllllIIlIllIIlIllIlIllII) && StructureComponent.findIntersecting(lllllllllllllIIlIllIIlIllIllIIll, lllllllllllllIIlIllIIlIllIlIllII) == null) ? new Crossing(lllllllllllllIIlIllIIlIllIlIllIl, lllllllllllllIIlIllIIlIllIllIIlI, lllllllllllllIIlIllIIlIllIlIllII, lllllllllllllIIlIllIIlIllIlIlllI) : null;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIllIIlIllIIlIlll, final Random lllllllllllllIIlIllIIlIllIIlllII, final StructureBoundingBox lllllllllllllIIlIllIIlIllIIlIllI) {
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 0, 2, 0, 6, 7, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 0, 2, 0, 1, 6, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 0, 2, 6, 1, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 5, 2, 0, 6, 6, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 5, 2, 6, 6, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 0, 2, 0, 0, 6, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 0, 2, 5, 0, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 6, 2, 0, 6, 6, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 6, 2, 5, 6, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 2, 6, 0, 4, 6, 0, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 2, 6, 6, 4, 6, 6, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 2, 5, 6, 4, 5, 6, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 0, 6, 2, 0, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 0, 5, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 6, 6, 2, 6, 6, 4, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIllIIlIllIIlIlll, lllllllllllllIIlIllIIlIllIIlIllI, 6, 5, 2, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            for (int lllllllllllllIIlIllIIlIllIIllIlI = 0; lllllllllllllIIlIllIIlIllIIllIlI <= 6; ++lllllllllllllIIlIllIIlIllIIllIlI) {
                for (int lllllllllllllIIlIllIIlIllIIllIIl = 0; lllllllllllllIIlIllIIlIllIIllIIl <= 6; ++lllllllllllllIIlIllIIlIllIIllIIl) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlIllIIlIllIIlIlll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIlIllIIlIllIIllIlI, -1, lllllllllllllIIlIllIIlIllIIllIIl, lllllllllllllIIlIllIIlIllIIlIllI);
                }
            }
            return true;
        }
        
        public Crossing(final int lllllllllllllIIlIllIIlIlllIIllll, final Random lllllllllllllIIlIllIIlIlllIIlllI, final StructureBoundingBox lllllllllllllIIlIllIIlIlllIIlIIl, final EnumFacing lllllllllllllIIlIllIIlIlllIIlIII) {
            super(lllllllllllllIIlIllIIlIlllIIllll);
            this.setCoordBaseMode(lllllllllllllIIlIllIIlIlllIIlIII);
            this.boundingBox = lllllllllllllIIlIllIIlIlllIIlIIl;
        }
        
        public Crossing() {
        }
    }
    
    public static class Entrance extends Piece
    {
        public static Entrance createPiece(final List<StructureComponent> lllllllllllllIIlllIIlIllIIlllIlI, final Random lllllllllllllIIlllIIlIllIlIIIIIl, final int lllllllllllllIIlllIIlIllIlIIIIII, final int lllllllllllllIIlllIIlIllIIllllll, final int lllllllllllllIIlllIIlIllIIlllllI, final EnumFacing lllllllllllllIIlllIIlIllIIllIlIl, final int lllllllllllllIIlllIIlIllIIllIlII) {
            final StructureBoundingBox lllllllllllllIIlllIIlIllIIlllIll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlllIIlIllIlIIIIII, lllllllllllllIIlllIIlIllIIllllll, lllllllllllllIIlllIIlIllIIlllllI, -5, -3, 0, 13, 14, 13, lllllllllllllIIlllIIlIllIIllIlIl);
            return (Piece.isAboveGround(lllllllllllllIIlllIIlIllIIlllIll) && StructureComponent.findIntersecting(lllllllllllllIIlllIIlIllIIlllIlI, lllllllllllllIIlllIIlIllIIlllIll) == null) ? new Entrance(lllllllllllllIIlllIIlIllIIllIlII, lllllllllllllIIlllIIlIllIlIIIIIl, lllllllllllllIIlllIIlIllIIlllIll, lllllllllllllIIlllIIlIllIIllIlIl) : null;
        }
        
        public Entrance(final int lllllllllllllIIlllIIlIllIlIllIIl, final Random lllllllllllllIIlllIIlIllIlIlllIl, final StructureBoundingBox lllllllllllllIIlllIIlIllIlIlllII, final EnumFacing lllllllllllllIIlllIIlIllIlIllIll) {
            super(lllllllllllllIIlllIIlIllIlIllIIl);
            this.setCoordBaseMode(lllllllllllllIIlllIIlIllIlIllIll);
            this.boundingBox = lllllllllllllIIlllIIlIllIlIlllII;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlllIIlIllIIlIlIll, final Random lllllllllllllIIlllIIlIllIIlIlIlI, final StructureBoundingBox lllllllllllllIIlllIIlIllIIIlllIl) {
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 5, 8, 0, 7, 8, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            for (int lllllllllllllIIlllIIlIllIIlIlIII = 1; lllllllllllllIIlllIIlIllIIlIlIII <= 11; lllllllllllllIIlllIIlIllIIlIlIII += 2) {
                this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, lllllllllllllIIlllIIlIllIIlIlIII, 10, 0, lllllllllllllIIlllIIlIllIIlIlIII, 11, 0, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, lllllllllllllIIlllIIlIllIIlIlIII, 10, 12, lllllllllllllIIlllIIlIllIIlIlIII, 11, 12, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 0, 10, lllllllllllllIIlllIIlIllIIlIlIII, 0, 11, lllllllllllllIIlllIIlIllIIlIlIII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 12, 10, lllllllllllllIIlllIIlIllIIlIlIII, 12, 11, lllllllllllllIIlllIIlIllIIlIlIII, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIlllIIlIllIIlIlIII, 13, 0, lllllllllllllIIlllIIlIllIIIlllIl);
                this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIlllIIlIllIIlIlIII, 13, 12, lllllllllllllIIlllIIlIllIIIlllIl);
                this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), 0, 13, lllllllllllllIIlllIIlIllIIlIlIII, lllllllllllllIIlllIIlIllIIIlllIl);
                this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), 12, 13, lllllllllllllIIlllIIlIllIIlIlIII, lllllllllllllIIlllIIlIllIIIlllIl);
                this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), lllllllllllllIIlllIIlIllIIlIlIII + 1, 13, 0, lllllllllllllIIlllIIlIllIIIlllIl);
                this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), lllllllllllllIIlllIIlIllIIlIlIII + 1, 13, 12, lllllllllllllIIlllIIlIllIIIlllIl);
                this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, lllllllllllllIIlllIIlIllIIlIlIII + 1, lllllllllllllIIlllIIlIllIIIlllIl);
                this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 12, 13, lllllllllllllIIlllIIlIllIIlIlIII + 1, lllllllllllllIIlllIIlIllIIIlllIl);
            }
            this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, lllllllllllllIIlllIIlIllIIIlllIl);
            this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 12, lllllllllllllIIlllIIlIllIIIlllIl);
            this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 0, 13, 0, lllllllllllllIIlllIIlIllIIIlllIl);
            this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 12, 13, 0, lllllllllllllIIlllIIlIllIIIlllIl);
            for (int lllllllllllllIIlllIIlIllIIlIIlll = 3; lllllllllllllIIlllIIlIllIIlIIlll <= 9; lllllllllllllIIlllIIlIllIIlIIlll += 2) {
                this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 1, 7, lllllllllllllIIlllIIlIllIIlIIlll, 1, 8, lllllllllllllIIlllIIlIllIIlIIlll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 11, 7, lllllllllllllIIlllIIlIllIIlIIlll, 11, 8, lllllllllllllIIlllIIlIllIIlIIlll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
            }
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            for (int lllllllllllllIIlllIIlIllIIlIIllI = 4; lllllllllllllIIlllIIlIllIIlIIllI <= 8; ++lllllllllllllIIlllIIlIllIIlIIllI) {
                for (int lllllllllllllIIlllIIlIllIIlIIlIl = 0; lllllllllllllIIlllIIlIllIIlIIlIl <= 2; ++lllllllllllllIIlllIIlIllIIlIIlIl) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIlllIIlIllIIlIIllI, -1, lllllllllllllIIlllIIlIllIIlIIlIl, lllllllllllllIIlllIIlIllIIIlllIl);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIlllIIlIllIIlIIllI, -1, 12 - lllllllllllllIIlllIIlIllIIlIIlIl, lllllllllllllIIlllIIlIllIIIlllIl);
                }
            }
            for (int lllllllllllllIIlllIIlIllIIlIIlII = 0; lllllllllllllIIlllIIlIllIIlIIlII <= 2; ++lllllllllllllIIlllIIlIllIIlIIlII) {
                for (int lllllllllllllIIlllIIlIllIIlIIIll = 4; lllllllllllllIIlllIIlIllIIlIIIll <= 8; ++lllllllllllllIIlllIIlIllIIlIIIll) {
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), lllllllllllllIIlllIIlIllIIlIIlII, -1, lllllllllllllIIlllIIlIllIIlIIIll, lllllllllllllIIlllIIlIllIIIlllIl);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), 12 - lllllllllllllIIlllIIlIllIIlIIlII, -1, lllllllllllllIIlllIIlIllIIlIIIll, lllllllllllllIIlllIIlIllIIIlllIl);
                }
            }
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 5, 5, 5, 7, 5, 7, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIIlllIl, 6, 1, 6, 6, 4, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, Blocks.NETHER_BRICK.getDefaultState(), 6, 0, 6, lllllllllllllIIlllIIlIllIIIlllIl);
            final IBlockState lllllllllllllIIlllIIlIllIIlIIIlI = Blocks.FLOWING_LAVA.getDefaultState();
            this.setBlockState(lllllllllllllIIlllIIlIllIIlIlIll, lllllllllllllIIlllIIlIllIIlIIIlI, 6, 5, 6, lllllllllllllIIlllIIlIllIIIlllIl);
            final BlockPos lllllllllllllIIlllIIlIllIIlIIIIl = new BlockPos(this.getXWithOffset(6, 6), this.getYWithOffset(5), this.getZWithOffset(6, 6));
            if (lllllllllllllIIlllIIlIllIIIlllIl.isVecInside(lllllllllllllIIlllIIlIllIIlIIIIl)) {
                lllllllllllllIIlllIIlIllIIlIlIll.immediateBlockTick(lllllllllllllIIlllIIlIllIIlIIIIl, lllllllllllllIIlllIIlIllIIlIIIlI, lllllllllllllIIlllIIlIllIIlIlIlI);
            }
            return true;
        }
        
        public Entrance() {
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIlllIIlIllIlIlIIIl, final List<StructureComponent> lllllllllllllIIlllIIlIllIlIlIIII, final Random lllllllllllllIIlllIIlIllIlIIllll) {
            this.getNextComponentNormal((Start)lllllllllllllIIlllIIlIllIlIlIIIl, lllllllllllllIIlllIIlIllIlIlIIII, lllllllllllllIIlllIIlIllIlIIllll, 5, 3, true);
        }
    }
    
    public static class Corridor3 extends Piece
    {
        @Override
        public void buildComponent(final StructureComponent llllllllllllllllllIlllllIlllIlII, final List<StructureComponent> llllllllllllllllllIlllllIlllIIll, final Random llllllllllllllllllIlllllIlllIllI) {
            this.getNextComponentNormal((Start)llllllllllllllllllIlllllIlllIlII, llllllllllllllllllIlllllIlllIIll, llllllllllllllllllIlllllIlllIllI, 1, 0, true);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllllIlllllIlIIIlIl, final Random llllllllllllllllllIlllllIlIIlllI, final StructureBoundingBox llllllllllllllllllIlllllIlIIIlII) {
            final IBlockState llllllllllllllllllIlllllIlIIllII = Blocks.NETHER_BRICK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            for (int llllllllllllllllllIlllllIlIIlIll = 0; llllllllllllllllllIlllllIlIIlIll <= 9; ++llllllllllllllllllIlllllIlIIlIll) {
                final int llllllllllllllllllIlllllIlIIlIlI = Math.max(1, 7 - llllllllllllllllllIlllllIlIIlIll);
                final int llllllllllllllllllIlllllIlIIlIIl = Math.min(Math.max(llllllllllllllllllIlllllIlIIlIlI + 5, 14 - llllllllllllllllllIlllllIlIIlIll), 13);
                final int llllllllllllllllllIlllllIlIIlIII = llllllllllllllllllIlllllIlIIlIll;
                this.fillWithBlocks(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIIlII, 0, 0, llllllllllllllllllIlllllIlIIlIll, 4, llllllllllllllllllIlllllIlIIlIlI, llllllllllllllllllIlllllIlIIlIll, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIIlII, 1, llllllllllllllllllIlllllIlIIlIlI + 1, llllllllllllllllllIlllllIlIIlIll, 3, llllllllllllllllllIlllllIlIIlIIl - 1, llllllllllllllllllIlllllIlIIlIll, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                if (llllllllllllllllllIlllllIlIIlIll <= 6) {
                    this.setBlockState(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIllII, 1, llllllllllllllllllIlllllIlIIlIlI + 1, llllllllllllllllllIlllllIlIIlIll, llllllllllllllllllIlllllIlIIIlII);
                    this.setBlockState(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIllII, 2, llllllllllllllllllIlllllIlIIlIlI + 1, llllllllllllllllllIlllllIlIIlIll, llllllllllllllllllIlllllIlIIIlII);
                    this.setBlockState(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIllII, 3, llllllllllllllllllIlllllIlIIlIlI + 1, llllllllllllllllllIlllllIlIIlIll, llllllllllllllllllIlllllIlIIIlII);
                }
                this.fillWithBlocks(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIIlII, 0, llllllllllllllllllIlllllIlIIlIIl, llllllllllllllllllIlllllIlIIlIll, 4, llllllllllllllllllIlllllIlIIlIIl, llllllllllllllllllIlllllIlIIlIll, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIIlII, 0, llllllllllllllllllIlllllIlIIlIlI + 1, llllllllllllllllllIlllllIlIIlIll, 0, llllllllllllllllllIlllllIlIIlIIl - 1, llllllllllllllllllIlllllIlIIlIll, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                this.fillWithBlocks(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIIlII, 4, llllllllllllllllllIlllllIlIIlIlI + 1, llllllllllllllllllIlllllIlIIlIll, 4, llllllllllllllllllIlllllIlIIlIIl - 1, llllllllllllllllllIlllllIlIIlIll, Blocks.NETHER_BRICK.getDefaultState(), Blocks.NETHER_BRICK.getDefaultState(), false);
                if ((llllllllllllllllllIlllllIlIIlIll & 0x1) == 0x0) {
                    this.fillWithBlocks(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIIlII, 0, llllllllllllllllllIlllllIlIIlIlI + 2, llllllllllllllllllIlllllIlIIlIll, 0, llllllllllllllllllIlllllIlIIlIlI + 3, llllllllllllllllllIlllllIlIIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                    this.fillWithBlocks(llllllllllllllllllIlllllIlIIIlIl, llllllllllllllllllIlllllIlIIIlII, 4, llllllllllllllllllIlllllIlIIlIlI + 2, llllllllllllllllllIlllllIlIIlIll, 4, llllllllllllllllllIlllllIlIIlIlI + 3, llllllllllllllllllIlllllIlIIlIll, Blocks.NETHER_BRICK_FENCE.getDefaultState(), Blocks.NETHER_BRICK_FENCE.getDefaultState(), false);
                }
                for (int llllllllllllllllllIlllllIlIIIlll = 0; llllllllllllllllllIlllllIlIIIlll <= 4; ++llllllllllllllllllIlllllIlIIIlll) {
                    this.replaceAirAndLiquidDownwards(llllllllllllllllllIlllllIlIIIlIl, Blocks.NETHER_BRICK.getDefaultState(), llllllllllllllllllIlllllIlIIIlll, -1, llllllllllllllllllIlllllIlIIlIII, llllllllllllllllllIlllllIlIIIlII);
                }
            }
            return true;
        }
        
        public Corridor3(final int llllllllllllllllllIllllllIIIIIII, final Random llllllllllllllllllIllllllIIIIlII, final StructureBoundingBox llllllllllllllllllIllllllIIIIIll, final EnumFacing llllllllllllllllllIllllllIIIIIlI) {
            super(llllllllllllllllllIllllllIIIIIII);
            this.setCoordBaseMode(llllllllllllllllllIllllllIIIIIlI);
            this.boundingBox = llllllllllllllllllIllllllIIIIIll;
        }
        
        public static Corridor3 createPiece(final List<StructureComponent> llllllllllllllllllIlllllIllIIIIl, final Random llllllllllllllllllIlllllIllIIIII, final int llllllllllllllllllIlllllIlIlllll, final int llllllllllllllllllIlllllIlIllllI, final int llllllllllllllllllIlllllIllIIlIl, final EnumFacing llllllllllllllllllIlllllIlIlllII, final int llllllllllllllllllIlllllIlIllIll) {
            final StructureBoundingBox llllllllllllllllllIlllllIllIIIlI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllllllIlllllIlIlllll, llllllllllllllllllIlllllIlIllllI, llllllllllllllllllIlllllIllIIlIl, -1, -7, 0, 5, 14, 10, llllllllllllllllllIlllllIlIlllII);
            return (Piece.isAboveGround(llllllllllllllllllIlllllIllIIIlI) && StructureComponent.findIntersecting(llllllllllllllllllIlllllIllIIIIl, llllllllllllllllllIlllllIllIIIlI) == null) ? new Corridor3(llllllllllllllllllIlllllIlIllIll, llllllllllllllllllIlllllIllIIIII, llllllllllllllllllIlllllIllIIIlI, llllllllllllllllllIlllllIlIlllII) : null;
        }
        
        public Corridor3() {
        }
    }
}
