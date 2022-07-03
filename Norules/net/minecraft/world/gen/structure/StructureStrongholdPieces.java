package net.minecraft.world.gen.structure;

import java.util.*;
import net.minecraft.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.block.*;

public class StructureStrongholdPieces
{
    private static final /* synthetic */ PieceWeight[] PIECE_WEIGHTS;
    private static /* synthetic */ Class<? extends Stronghold> strongComponentType;
    private static final /* synthetic */ Stones STRONGHOLD_STONES;
    static /* synthetic */ int totalWeight;
    private static /* synthetic */ List<PieceWeight> structurePieceList;
    
    private static Stronghold generatePieceFromSmallDoor(final Stairs2 llllllllllllIllllllIlIllIlllIIll, final List<StructureComponent> llllllllllllIllllllIlIlllIIIIIII, final Random llllllllllllIllllllIlIllIlllllll, final int llllllllllllIllllllIlIllIlllIIII, final int llllllllllllIllllllIlIllIllIllll, final int llllllllllllIllllllIlIllIllIlllI, final EnumFacing llllllllllllIllllllIlIllIllllIll, final int llllllllllllIllllllIlIllIllllIlI) {
        if (!canAddStructurePieces()) {
            return null;
        }
        if (StructureStrongholdPieces.strongComponentType != null) {
            final Stronghold llllllllllllIllllllIlIllIllllIIl = findAndCreatePieceFactory(StructureStrongholdPieces.strongComponentType, llllllllllllIllllllIlIlllIIIIIII, llllllllllllIllllllIlIllIlllllll, llllllllllllIllllllIlIllIlllIIII, llllllllllllIllllllIlIllIllIllll, llllllllllllIllllllIlIllIllIlllI, llllllllllllIllllllIlIllIllllIll, llllllllllllIllllllIlIllIllllIlI);
            StructureStrongholdPieces.strongComponentType = null;
            if (llllllllllllIllllllIlIllIllllIIl != null) {
                return llllllllllllIllllllIlIllIllllIIl;
            }
        }
        int llllllllllllIllllllIlIllIllllIII = 0;
        while (llllllllllllIllllllIlIllIllllIII < 5) {
            ++llllllllllllIllllllIlIllIllllIII;
            int llllllllllllIllllllIlIllIlllIlll = llllllllllllIllllllIlIllIlllllll.nextInt(StructureStrongholdPieces.totalWeight);
            for (final PieceWeight llllllllllllIllllllIlIllIlllIllI : StructureStrongholdPieces.structurePieceList) {
                llllllllllllIllllllIlIllIlllIlll -= llllllllllllIllllllIlIllIlllIllI.pieceWeight;
                if (llllllllllllIllllllIlIllIlllIlll < 0) {
                    if (!llllllllllllIllllllIlIllIlllIllI.canSpawnMoreStructuresOfType(llllllllllllIllllllIlIllIllllIlI)) {
                        break;
                    }
                    if (llllllllllllIllllllIlIllIlllIllI == llllllllllllIllllllIlIllIlllIIll.strongholdPieceWeight) {
                        break;
                    }
                    final Stronghold llllllllllllIllllllIlIllIlllIlIl = findAndCreatePieceFactory(llllllllllllIllllllIlIllIlllIllI.pieceClass, llllllllllllIllllllIlIlllIIIIIII, llllllllllllIllllllIlIllIlllllll, llllllllllllIllllllIlIllIlllIIII, llllllllllllIllllllIlIllIllIllll, llllllllllllIllllllIlIllIllIlllI, llllllllllllIllllllIlIllIllllIll, llllllllllllIllllllIlIllIllllIlI);
                    if (llllllllllllIllllllIlIllIlllIlIl != null) {
                        final PieceWeight pieceWeight = llllllllllllIllllllIlIllIlllIllI;
                        ++pieceWeight.instancesSpawned;
                        llllllllllllIllllllIlIllIlllIIll.strongholdPieceWeight = llllllllllllIllllllIlIllIlllIllI;
                        if (!llllllllllllIllllllIlIllIlllIllI.canSpawnMoreStructures()) {
                            StructureStrongholdPieces.structurePieceList.remove(llllllllllllIllllllIlIllIlllIllI);
                        }
                        return llllllllllllIllllllIlIllIlllIlIl;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox llllllllllllIllllllIlIllIlllIlII = Corridor.findPieceBox(llllllllllllIllllllIlIlllIIIIIII, llllllllllllIllllllIlIllIlllllll, llllllllllllIllllllIlIllIlllIIII, llllllllllllIllllllIlIllIllIllll, llllllllllllIllllllIlIllIllIlllI, llllllllllllIllllllIlIllIllllIll);
        if (llllllllllllIllllllIlIllIlllIlII != null && llllllllllllIllllllIlIllIlllIlII.minY > 1) {
            return new Corridor(llllllllllllIllllllIlIllIllllIlI, llllllllllllIllllllIlIllIlllllll, llllllllllllIllllllIlIllIlllIlII, llllllllllllIllllllIlIllIllllIll);
        }
        return null;
    }
    
    private static Stronghold findAndCreatePieceFactory(final Class<? extends Stronghold> llllllllllllIllllllIlIlllIIlIlll, final List<StructureComponent> llllllllllllIllllllIlIlllIIlIllI, final Random llllllllllllIllllllIlIlllIIllllI, final int llllllllllllIllllllIlIlllIIlllIl, final int llllllllllllIllllllIlIlllIIlllII, final int llllllllllllIllllllIlIlllIIlIIlI, @Nullable final EnumFacing llllllllllllIllllllIlIlllIIllIlI, final int llllllllllllIllllllIlIlllIIlIIII) {
        Stronghold llllllllllllIllllllIlIlllIIllIII = null;
        if (llllllllllllIllllllIlIlllIIlIlll == Straight.class) {
            llllllllllllIllllllIlIlllIIllIII = Straight.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == Prison.class) {
            llllllllllllIllllllIlIlllIIllIII = Prison.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == LeftTurn.class) {
            llllllllllllIllllllIlIlllIIllIII = LeftTurn.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == RightTurn.class) {
            llllllllllllIllllllIlIlllIIllIII = LeftTurn.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == RoomCrossing.class) {
            llllllllllllIllllllIlIlllIIllIII = RoomCrossing.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == StairsStraight.class) {
            llllllllllllIllllllIlIlllIIllIII = StairsStraight.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == Stairs.class) {
            llllllllllllIllllllIlIlllIIllIII = Stairs.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == Crossing.class) {
            llllllllllllIllllllIlIlllIIllIII = Crossing.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == ChestCorridor.class) {
            llllllllllllIllllllIlIlllIIllIII = ChestCorridor.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == Library.class) {
            llllllllllllIllllllIlIlllIIllIII = Library.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        else if (llllllllllllIllllllIlIlllIIlIlll == PortalRoom.class) {
            llllllllllllIllllllIlIlllIIllIII = PortalRoom.createPiece(llllllllllllIllllllIlIlllIIlIllI, llllllllllllIllllllIlIlllIIllllI, llllllllllllIllllllIlIlllIIlllIl, llllllllllllIllllllIlIlllIIlllII, llllllllllllIllllllIlIlllIIlIIlI, llllllllllllIllllllIlIlllIIllIlI, llllllllllllIllllllIlIlllIIlIIII);
        }
        return llllllllllllIllllllIlIlllIIllIII;
    }
    
    public static void registerStrongholdPieces() {
        MapGenStructureIO.registerStructureComponent(ChestCorridor.class, "SHCC");
        MapGenStructureIO.registerStructureComponent(Corridor.class, "SHFC");
        MapGenStructureIO.registerStructureComponent(Crossing.class, "SH5C");
        MapGenStructureIO.registerStructureComponent(LeftTurn.class, "SHLT");
        MapGenStructureIO.registerStructureComponent(Library.class, "SHLi");
        MapGenStructureIO.registerStructureComponent(PortalRoom.class, "SHPR");
        MapGenStructureIO.registerStructureComponent(Prison.class, "SHPH");
        MapGenStructureIO.registerStructureComponent(RightTurn.class, "SHRT");
        MapGenStructureIO.registerStructureComponent(RoomCrossing.class, "SHRC");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "SHSD");
        MapGenStructureIO.registerStructureComponent(Stairs2.class, "SHStart");
        MapGenStructureIO.registerStructureComponent(Straight.class, "SHS");
        MapGenStructureIO.registerStructureComponent(StairsStraight.class, "SHSSD");
    }
    
    static {
        PIECE_WEIGHTS = new PieceWeight[] { new PieceWeight(Straight.class, 40, 0), new PieceWeight(Prison.class, 5, 5), new PieceWeight(LeftTurn.class, 20, 0), new PieceWeight(RightTurn.class, 20, 0), new PieceWeight(RoomCrossing.class, 10, 6), new PieceWeight(StairsStraight.class, 5, 5), new PieceWeight(Stairs.class, 5, 5), new PieceWeight(Crossing.class, 5, 4), new PieceWeight(ChestCorridor.class, 5, 4), new PieceWeight(10, 2) {
                @Override
                public boolean canSpawnMoreStructuresOfType(final int lllllllllllllIIlIlIllllIIIlIllIl) {
                    return super.canSpawnMoreStructuresOfType(lllllllllllllIIlIlIllllIIIlIllIl) && lllllllllllllIIlIlIllllIIIlIllIl > 4;
                }
            }, new PieceWeight(20, 1) {
                @Override
                public boolean canSpawnMoreStructuresOfType(final int lllllllllllllIIIIlIllIlIIIlllIIl) {
                    return super.canSpawnMoreStructuresOfType(lllllllllllllIIIIlIllIlIIIlllIIl) && lllllllllllllIIIIlIllIlIIIlllIIl > 5;
                }
            } };
        STRONGHOLD_STONES = new Stones(null);
    }
    
    private static StructureComponent generateAndAddPiece(final Stairs2 llllllllllllIllllllIlIllIlIlIlII, final List<StructureComponent> llllllllllllIllllllIlIllIlIlllII, final Random llllllllllllIllllllIlIllIlIllIll, final int llllllllllllIllllllIlIllIlIllIlI, final int llllllllllllIllllllIlIllIlIllIIl, final int llllllllllllIllllllIlIllIlIllIII, @Nullable final EnumFacing llllllllllllIllllllIlIllIlIIlllI, final int llllllllllllIllllllIlIllIlIIllIl) {
        if (llllllllllllIllllllIlIllIlIIllIl > 50) {
            return null;
        }
        if (Math.abs(llllllllllllIllllllIlIllIlIllIlI - llllllllllllIllllllIlIllIlIlIlII.getBoundingBox().minX) <= 112 && Math.abs(llllllllllllIllllllIlIllIlIllIII - llllllllllllIllllllIlIllIlIlIlII.getBoundingBox().minZ) <= 112) {
            final StructureComponent llllllllllllIllllllIlIllIlIlIlIl = generatePieceFromSmallDoor(llllllllllllIllllllIlIllIlIlIlII, llllllllllllIllllllIlIllIlIlllII, llllllllllllIllllllIlIllIlIllIll, llllllllllllIllllllIlIllIlIllIlI, llllllllllllIllllllIlIllIlIllIIl, llllllllllllIllllllIlIllIlIllIII, llllllllllllIllllllIlIllIlIIlllI, llllllllllllIllllllIlIllIlIIllIl + 1);
            if (llllllllllllIllllllIlIllIlIlIlIl != null) {
                llllllllllllIllllllIlIllIlIlllII.add(llllllllllllIllllllIlIllIlIlIlIl);
                llllllllllllIllllllIlIllIlIlIlII.pendingChildren.add(llllllllllllIllllllIlIllIlIlIlIl);
            }
            return llllllllllllIllllllIlIllIlIlIlIl;
        }
        return null;
    }
    
    private static boolean canAddStructurePieces() {
        boolean llllllllllllIllllllIlIlllIlIlllI = false;
        StructureStrongholdPieces.totalWeight = 0;
        for (final PieceWeight llllllllllllIllllllIlIlllIlIllIl : StructureStrongholdPieces.structurePieceList) {
            if (llllllllllllIllllllIlIlllIlIllIl.instancesLimit > 0 && llllllllllllIllllllIlIlllIlIllIl.instancesSpawned < llllllllllllIllllllIlIlllIlIllIl.instancesLimit) {
                llllllllllllIllllllIlIlllIlIlllI = true;
            }
            StructureStrongholdPieces.totalWeight += llllllllllllIllllllIlIlllIlIllIl.pieceWeight;
        }
        return llllllllllllIllllllIlIlllIlIlllI;
    }
    
    public static void prepareStructurePieces() {
        StructureStrongholdPieces.structurePieceList = (List<PieceWeight>)Lists.newArrayList();
        final String llllllllllllIllllllIlIlllIllIIlI;
        final short llllllllllllIllllllIlIlllIllIIll = (short)((PieceWeight[])(Object)(llllllllllllIllllllIlIlllIllIIlI = (String)(Object)StructureStrongholdPieces.PIECE_WEIGHTS)).length;
        for (String llllllllllllIllllllIlIlllIllIlII = (String)0; llllllllllllIllllllIlIlllIllIlII < llllllllllllIllllllIlIlllIllIIll; ++llllllllllllIllllllIlIlllIllIlII) {
            final PieceWeight llllllllllllIllllllIlIlllIllIllI = llllllllllllIllllllIlIlllIllIIlI[llllllllllllIllllllIlIlllIllIlII];
            llllllllllllIllllllIlIlllIllIllI.instancesSpawned = 0;
            StructureStrongholdPieces.structurePieceList.add(llllllllllllIllllllIlIlllIllIllI);
        }
        StructureStrongholdPieces.strongComponentType = null;
    }
    
    static /* synthetic */ void access$2(final Class llllllllllllIllllllIlIllIlIIlIlI) {
        StructureStrongholdPieces.strongComponentType = (Class<? extends Stronghold>)llllllllllllIllllllIlIllIlIIlIlI;
    }
    
    public static class Stairs2 extends Stairs
    {
        public /* synthetic */ PortalRoom strongholdPortalRoom;
        public /* synthetic */ List<StructureComponent> pendingChildren;
        public /* synthetic */ PieceWeight strongholdPieceWeight;
        
        public Stairs2() {
            this.pendingChildren = (List<StructureComponent>)Lists.newArrayList();
        }
        
        public Stairs2(final int llllllllllllllIllllIllllllIIlIII, final Random llllllllllllllIllllIllllllIIIlll, final int llllllllllllllIllllIllllllIIIllI, final int llllllllllllllIllllIllllllIIIIIl) {
            super(0, llllllllllllllIllllIllllllIIIlll, llllllllllllllIllllIllllllIIIllI, llllllllllllllIllllIllllllIIIIIl);
            this.pendingChildren = (List<StructureComponent>)Lists.newArrayList();
        }
    }
    
    public static class PortalRoom extends Stronghold
    {
        private /* synthetic */ boolean hasSpawner;
        
        public PortalRoom(final int lllllllllllllIIlIIIIlIIlIlIIIllI, final Random lllllllllllllIIlIIIIlIIlIlIIlIlI, final StructureBoundingBox lllllllllllllIIlIIIIlIIlIlIIIlIl, final EnumFacing lllllllllllllIIlIIIIlIIlIlIIIlII) {
            super(lllllllllllllIIlIIIIlIIlIlIIIllI);
            this.setCoordBaseMode(lllllllllllllIIlIIIIlIIlIlIIIlII);
            this.boundingBox = lllllllllllllIIlIIIIlIIlIlIIIlIl;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIIIIlIIlIIIIIlIl, final Random lllllllllllllIIlIIIIlIIIllllIIIl, final StructureBoundingBox lllllllllllllIIlIIIIlIIlIIIIIIll) {
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 0, 0, 0, 10, 7, 15, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIIIl, lllllllllllllIIlIIIIlIIlIIIIIIll, Door.GRATES, 4, 1, 0);
            int lllllllllllllIIlIIIIlIIlIIIIIIlI = 6;
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 1, lllllllllllllIIlIIIIlIIlIIIIIIlI, 1, 1, lllllllllllllIIlIIIIlIIlIIIIIIlI, 14, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 9, lllllllllllllIIlIIIIlIIlIIIIIIlI, 1, 9, lllllllllllllIIlIIIIlIIlIIIIIIlI, 14, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 2, lllllllllllllIIlIIIIlIIlIIIIIIlI, 1, 8, lllllllllllllIIlIIIIlIIlIIIIIIlI, 2, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 2, lllllllllllllIIlIIIIlIIlIIIIIIlI, 14, 8, lllllllllllllIIlIIIIlIIlIIIIIIlI, 14, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 1, 1, 1, 2, 1, 4, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 8, 1, 1, 9, 1, 4, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 1, 1, 1, 1, 1, 3, Blocks.FLOWING_LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 9, 1, 1, 9, 1, 3, Blocks.FLOWING_LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 3, 1, 8, 7, 1, 12, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 4, 1, 9, 6, 1, 11, Blocks.FLOWING_LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState(), false);
            for (int lllllllllllllIIlIIIIlIIlIIIIIIIl = 3; lllllllllllllIIlIIIIlIIlIIIIIIIl < 14; lllllllllllllIIlIIIIlIIlIIIIIIIl += 2) {
                this.fillWithBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 0, 3, lllllllllllllIIlIIIIlIIlIIIIIIIl, 0, 4, lllllllllllllIIlIIIIlIIlIIIIIIIl, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 10, 3, lllllllllllllIIlIIIIlIIlIIIIIIIl, 10, 4, lllllllllllllIIlIIIIlIIlIIIIIIIl, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
            }
            for (int lllllllllllllIIlIIIIlIIlIIIIIIII = 2; lllllllllllllIIlIIIIlIIlIIIIIIII < 9; lllllllllllllIIlIIIIlIIlIIIIIIII += 2) {
                this.fillWithBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, lllllllllllllIIlIIIIlIIlIIIIIIII, 3, 15, lllllllllllllIIlIIIIlIIlIIIIIIII, 4, 15, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
            }
            final IBlockState lllllllllllllIIlIIIIlIIIllllllll = Blocks.STONE_BRICK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 4, 1, 5, 6, 1, 7, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 4, 2, 6, 6, 2, 7, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIlIIIIIIll, 4, 3, 7, 6, 3, 7, false, lllllllllllllIIlIIIIlIIIllllIIIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            for (int lllllllllllllIIlIIIIlIIIlllllllI = 4; lllllllllllllIIlIIIIlIIIlllllllI <= 6; ++lllllllllllllIIlIIIIlIIIlllllllI) {
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllll, lllllllllllllIIlIIIIlIIIlllllllI, 1, 4, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllll, lllllllllllllIIlIIIIlIIIlllllllI, 2, 5, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllll, lllllllllllllIIlIIIIlIIIlllllllI, 3, 6, lllllllllllllIIlIIIIlIIlIIIIIIll);
            }
            final IBlockState lllllllllllllIIlIIIIlIIIllllllIl = Blocks.END_PORTAL_FRAME.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.NORTH);
            final IBlockState lllllllllllllIIlIIIIlIIIllllllII = Blocks.END_PORTAL_FRAME.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.SOUTH);
            final IBlockState lllllllllllllIIlIIIIlIIIlllllIll = Blocks.END_PORTAL_FRAME.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllllIIlIIIIlIIIlllllIlI = Blocks.END_PORTAL_FRAME.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.WEST);
            boolean lllllllllllllIIlIIIIlIIIlllllIIl = true;
            final boolean[] lllllllllllllIIlIIIIlIIIlllllIII = new boolean[12];
            for (int lllllllllllllIIlIIIIlIIIllllIlll = 0; lllllllllllllIIlIIIIlIIIllllIlll < lllllllllllllIIlIIIIlIIIlllllIII.length; ++lllllllllllllIIlIIIIlIIIllllIlll) {
                lllllllllllllIIlIIIIlIIIlllllIII[lllllllllllllIIlIIIIlIIIllllIlll] = (lllllllllllllIIlIIIIlIIIllllIIIl.nextFloat() > 0.9f);
                lllllllllllllIIlIIIIlIIIlllllIIl &= lllllllllllllIIlIIIIlIIIlllllIII[lllllllllllllIIlIIIIlIIIllllIlll];
            }
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllIl.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[0]), 4, 3, 8, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllIl.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[1]), 5, 3, 8, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllIl.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[2]), 6, 3, 8, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllII.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[3]), 4, 3, 12, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllII.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[4]), 5, 3, 12, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllllII.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[5]), 6, 3, 12, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIlllllIll.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[6]), 3, 3, 9, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIlllllIll.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[7]), 3, 3, 10, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIlllllIll.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[8]), 3, 3, 11, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIlllllIlI.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[9]), 7, 3, 9, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIlllllIlI.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[10]), 7, 3, 10, lllllllllllllIIlIIIIlIIlIIIIIIll);
            this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIlllllIlI.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, lllllllllllllIIlIIIIlIIIlllllIII[11]), 7, 3, 11, lllllllllllllIIlIIIIlIIlIIIIIIll);
            if (lllllllllllllIIlIIIIlIIIlllllIIl) {
                final IBlockState lllllllllllllIIlIIIIlIIIllllIllI = Blocks.END_PORTAL.getDefaultState();
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 4, 3, 9, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 5, 3, 9, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 6, 3, 9, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 4, 3, 10, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 5, 3, 10, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 6, 3, 10, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 4, 3, 11, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 5, 3, 11, lllllllllllllIIlIIIIlIIlIIIIIIll);
                this.setBlockState(lllllllllllllIIlIIIIlIIlIIIIIlIl, lllllllllllllIIlIIIIlIIIllllIllI, 6, 3, 11, lllllllllllllIIlIIIIlIIlIIIIIIll);
            }
            if (!this.hasSpawner) {
                lllllllllllllIIlIIIIlIIlIIIIIIlI = this.getYWithOffset(3);
                final BlockPos lllllllllllllIIlIIIIlIIIllllIlIl = new BlockPos(this.getXWithOffset(5, 6), lllllllllllllIIlIIIIlIIlIIIIIIlI, this.getZWithOffset(5, 6));
                if (lllllllllllllIIlIIIIlIIlIIIIIIll.isVecInside(lllllllllllllIIlIIIIlIIIllllIlIl)) {
                    this.hasSpawner = true;
                    lllllllllllllIIlIIIIlIIlIIIIIlIl.setBlockState(lllllllllllllIIlIIIIlIIIllllIlIl, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                    final TileEntity lllllllllllllIIlIIIIlIIIllllIlII = lllllllllllllIIlIIIIlIIlIIIIIlIl.getTileEntity(lllllllllllllIIlIIIIlIIIllllIlIl);
                    if (lllllllllllllIIlIIIIlIIIllllIlII instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner)lllllllllllllIIlIIIIlIIIllllIlII).getSpawnerBaseLogic().func_190894_a(EntityList.func_191306_a(EntitySilverfish.class));
                    }
                }
            }
            return true;
        }
        
        public static PortalRoom createPiece(final List<StructureComponent> lllllllllllllIIlIIIIlIIlIIIlllII, final Random lllllllllllllIIlIIIIlIIlIIIllIll, final int lllllllllllllIIlIIIIlIIlIIlIIIlI, final int lllllllllllllIIlIIIIlIIlIIlIIIIl, final int lllllllllllllIIlIIIIlIIlIIlIIIII, final EnumFacing lllllllllllllIIlIIIIlIIlIIIlllll, final int lllllllllllllIIlIIIIlIIlIIIllllI) {
            final StructureBoundingBox lllllllllllllIIlIIIIlIIlIIIlllIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlIIIIlIIlIIlIIIlI, lllllllllllllIIlIIIIlIIlIIlIIIIl, lllllllllllllIIlIIIIlIIlIIlIIIII, -4, -1, 0, 11, 8, 16, lllllllllllllIIlIIIIlIIlIIIlllll);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllIIlIIIIlIIlIIIlllIl) && StructureComponent.findIntersecting(lllllllllllllIIlIIIIlIIlIIIlllII, lllllllllllllIIlIIIIlIIlIIIlllIl) == null) ? new PortalRoom(lllllllllllllIIlIIIIlIIlIIIllllI, lllllllllllllIIlIIIIlIIlIIIllIll, lllllllllllllIIlIIIIlIIlIIIlllIl, lllllllllllllIIlIIIIlIIlIIIlllll) : null;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIlIIIIlIIlIIlllllI) {
            super.writeStructureToNBT(lllllllllllllIIlIIIIlIIlIIlllllI);
            lllllllllllllIIlIIIIlIIlIIlllllI.setBoolean("Mob", this.hasSpawner);
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIlIIIIlIIlIIlIllIl, final List<StructureComponent> lllllllllllllIIlIIIIlIIlIIllIIII, final Random lllllllllllllIIlIIIIlIIlIIlIllll) {
            if (lllllllllllllIIlIIIIlIIlIIlIllIl != null) {
                ((Stairs2)lllllllllllllIIlIIIIlIIlIIlIllIl).strongholdPortalRoom = this;
            }
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIlIIIIlIIlIIllIllI, final TemplateManager lllllllllllllIIlIIIIlIIlIIllIlIl) {
            super.readStructureFromNBT(lllllllllllllIIlIIIIlIIlIIllIllI, lllllllllllllIIlIIIIlIIlIIllIlIl);
            this.hasSpawner = lllllllllllllIIlIIIIlIIlIIllIllI.getBoolean("Mob");
        }
        
        public PortalRoom() {
        }
    }
    
    abstract static class Stronghold extends StructureComponent
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door;
        protected /* synthetic */ Door entryDoor;
        
        protected void placeDoor(final World llllllllllllllllIIlllIIlllIIlIII, final Random llllllllllllllllIIlllIIlllIIIlll, final StructureBoundingBox llllllllllllllllIIlllIIlllIIIllI, final Door llllllllllllllllIIlllIIllIlllllI, final int llllllllllllllllIIlllIIlllIIIlII, final int llllllllllllllllIIlllIIllIllllII, final int llllllllllllllllIIlllIIlllIIIIlI) {
            switch ($SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door()[llllllllllllllllIIlllIIllIlllllI.ordinal()]) {
                case 1: {
                    this.fillWithBlocks(llllllllllllllllIIlllIIlllIIlIII, llllllllllllllllIIlllIIlllIIIllI, llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIlII + 3 - 1, llllllllllllllllIIlllIIllIllllII + 3 - 1, llllllllllllllllIIlllIIlllIIIIlI, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
                    break;
                }
                case 2: {
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.OAK_DOOR.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.OAK_DOOR.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    break;
                }
                case 3: {
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.AIR.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.AIR.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_BARS.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_BARS.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_BARS.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_BARS.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_BARS.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_BARS.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_BARS.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    break;
                }
                case 4: {
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII + 2, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONEBRICK.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_DOOR.getDefaultState(), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.IRON_DOOR.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), llllllllllllllllIIlllIIlllIIIlII + 1, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONE_BUTTON.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, EnumFacing.NORTH), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI + 1, llllllllllllllllIIlllIIlllIIIllI);
                    this.setBlockState(llllllllllllllllIIlllIIlllIIlIII, Blocks.STONE_BUTTON.getDefaultState().withProperty((IProperty<Comparable>)BlockButton.FACING, EnumFacing.SOUTH), llllllllllllllllIIlllIIlllIIIlII + 2, llllllllllllllllIIlllIIllIllllII + 1, llllllllllllllllIIlllIIlllIIIIlI - 1, llllllllllllllllIIlllIIlllIIIllI);
                    break;
                }
            }
        }
        
        protected Door getRandomDoor(final Random llllllllllllllllIIlllIIllIllIlIl) {
            final int llllllllllllllllIIlllIIllIllIllI = llllllllllllllllIIlllIIllIllIlIl.nextInt(5);
            switch (llllllllllllllllIIlllIIllIllIllI) {
                default: {
                    return Door.OPENING;
                }
                case 2: {
                    return Door.WOOD_DOOR;
                }
                case 3: {
                    return Door.GRATES;
                }
                case 4: {
                    return Door.IRON_DOOR;
                }
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllllIIlllIIlllIllIlI) {
            llllllllllllllllIIlllIIlllIllIlI.setString("EntryDoor", this.entryDoor.name());
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door() {
            final int[] $switch_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door = Stronghold.$SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door;
            if ($switch_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door != null) {
                return $switch_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door;
            }
            final byte llllllllllllllllIIlllIIlIlllIIII = (Object)new int[Door.values().length];
            try {
                llllllllllllllllIIlllIIlIlllIIII[Door.GRATES.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllllIIlllIIlIlllIIII[Door.IRON_DOOR.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllllllIIlllIIlIlllIIII[Door.OPENING.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllllllIIlllIIlIlllIIII[Door.WOOD_DOOR.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            return Stronghold.$SWITCH_TABLE$net$minecraft$world$gen$structure$StructureStrongholdPieces$Stronghold$Door = (int[])(Object)llllllllllllllllIIlllIIlIlllIIII;
        }
        
        protected Stronghold(final int llllllllllllllllIIlllIIlllIllllI) {
            super(llllllllllllllllIIlllIIlllIllllI);
            this.entryDoor = Door.OPENING;
        }
        
        protected static boolean canStrongholdGoDeeper(final StructureBoundingBox llllllllllllllllIIlllIIlIlllIIll) {
            return llllllllllllllllIIlllIIlIlllIIll != null && llllllllllllllllIIlllIIlIlllIIll.minY > 10;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Stronghold.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final float llllllllllllllllIIlllIIlIllIlllI = (Object)new int[EnumFacing.values().length];
            try {
                llllllllllllllllIIlllIIlIllIlllI[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllllllllllllIIlllIIlIllIlllI[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllllllllllllIIlllIIlIllIlllI[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllllllllllllIIlllIIlIllIlllI[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllllllllllllIIlllIIlIllIlllI[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllllllllllllIIlllIIlIllIlllI[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Stronghold.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllllIIlllIIlIllIlllI;
        }
        
        @Nullable
        protected StructureComponent getNextComponentX(final Stairs2 llllllllllllllllIIlllIIllIIIllll, final List<StructureComponent> llllllllllllllllIIlllIIllIIIlllI, final Random llllllllllllllllIIlllIIllIIIllIl, final int llllllllllllllllIIlllIIllIIlIIll, final int llllllllllllllllIIlllIIllIIIlIll) {
            final EnumFacing llllllllllllllllIIlllIIllIIlIIIl = this.getCoordBaseMode();
            if (llllllllllllllllIIlllIIllIIlIIIl != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllllIIlllIIllIIlIIIl.ordinal()]) {
                    case 3: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIIIllll, llllllllllllllllIIlllIIllIIIlllI, llllllllllllllllIIlllIIllIIIllIl, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllllllIIlllIIllIIlIIll, this.boundingBox.minZ + llllllllllllllllIIlllIIllIIIlIll, EnumFacing.WEST, this.getComponentType());
                    }
                    case 4: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIIIllll, llllllllllllllllIIlllIIllIIIlllI, llllllllllllllllIIlllIIllIIIllIl, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllllllIIlllIIllIIlIIll, this.boundingBox.minZ + llllllllllllllllIIlllIIllIIIlIll, EnumFacing.WEST, this.getComponentType());
                    }
                    case 5: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIIIllll, llllllllllllllllIIlllIIllIIIlllI, llllllllllllllllIIlllIIllIIIllIl, this.boundingBox.minX + llllllllllllllllIIlllIIllIIIlIll, this.boundingBox.minY + llllllllllllllllIIlllIIllIIlIIll, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                    case 6: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIIIllll, llllllllllllllllIIlllIIllIIIlllI, llllllllllllllllIIlllIIllIIIllIl, this.boundingBox.minX + llllllllllllllllIIlllIIllIIIlIll, this.boundingBox.minY + llllllllllllllllIIlllIIllIIlIIll, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        public Stronghold() {
            this.entryDoor = Door.OPENING;
        }
        
        @Nullable
        protected StructureComponent getNextComponentZ(final Stairs2 llllllllllllllllIIlllIIllIIIIIIl, final List<StructureComponent> llllllllllllllllIIlllIIllIIIIIII, final Random llllllllllllllllIIlllIIlIlllllll, final int llllllllllllllllIIlllIIlIlllIlll, final int llllllllllllllllIIlllIIlIlllIllI) {
            final EnumFacing llllllllllllllllIIlllIIlIlllllII = this.getCoordBaseMode();
            if (llllllllllllllllIIlllIIlIlllllII != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllllIIlllIIlIlllllII.ordinal()]) {
                    case 3: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIIIIIIl, llllllllllllllllIIlllIIllIIIIIII, llllllllllllllllIIlllIIlIlllllll, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllllllIIlllIIlIlllIlll, this.boundingBox.minZ + llllllllllllllllIIlllIIlIlllIllI, EnumFacing.EAST, this.getComponentType());
                    }
                    case 4: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIIIIIIl, llllllllllllllllIIlllIIllIIIIIII, llllllllllllllllIIlllIIlIlllllll, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllllllIIlllIIlIlllIlll, this.boundingBox.minZ + llllllllllllllllIIlllIIlIlllIllI, EnumFacing.EAST, this.getComponentType());
                    }
                    case 5: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIIIIIIl, llllllllllllllllIIlllIIllIIIIIII, llllllllllllllllIIlllIIlIlllllll, this.boundingBox.minX + llllllllllllllllIIlllIIlIlllIllI, this.boundingBox.minY + llllllllllllllllIIlllIIlIlllIlll, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                    case 6: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIIIIIIl, llllllllllllllllIIlllIIllIIIIIII, llllllllllllllllIIlllIIlIlllllll, this.boundingBox.minX + llllllllllllllllIIlllIIlIlllIllI, this.boundingBox.minY + llllllllllllllllIIlllIIlIlllIlll, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllllIIlllIIlllIlIIIl, final TemplateManager llllllllllllllllIIlllIIlllIlIIll) {
            this.entryDoor = Door.valueOf(llllllllllllllllIIlllIIlllIlIIIl.getString("EntryDoor"));
        }
        
        @Nullable
        protected StructureComponent getNextComponentNormal(final Stairs2 llllllllllllllllIIlllIIllIlIlIll, final List<StructureComponent> llllllllllllllllIIlllIIllIlIIIll, final Random llllllllllllllllIIlllIIllIlIIIlI, final int llllllllllllllllIIlllIIllIlIIIIl, final int llllllllllllllllIIlllIIllIlIIlll) {
            final EnumFacing llllllllllllllllIIlllIIllIlIIllI = this.getCoordBaseMode();
            if (llllllllllllllllIIlllIIllIlIIllI != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllllIIlllIIllIlIIllI.ordinal()]) {
                    case 3: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIlIlIll, llllllllllllllllIIlllIIllIlIIIll, llllllllllllllllIIlllIIllIlIIIlI, this.boundingBox.minX + llllllllllllllllIIlllIIllIlIIIIl, this.boundingBox.minY + llllllllllllllllIIlllIIllIlIIlll, this.boundingBox.minZ - 1, llllllllllllllllIIlllIIllIlIIllI, this.getComponentType());
                    }
                    case 4: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIlIlIll, llllllllllllllllIIlllIIllIlIIIll, llllllllllllllllIIlllIIllIlIIIlI, this.boundingBox.minX + llllllllllllllllIIlllIIllIlIIIIl, this.boundingBox.minY + llllllllllllllllIIlllIIllIlIIlll, this.boundingBox.maxZ + 1, llllllllllllllllIIlllIIllIlIIllI, this.getComponentType());
                    }
                    case 5: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIlIlIll, llllllllllllllllIIlllIIllIlIIIll, llllllllllllllllIIlllIIllIlIIIlI, this.boundingBox.minX - 1, this.boundingBox.minY + llllllllllllllllIIlllIIllIlIIlll, this.boundingBox.minZ + llllllllllllllllIIlllIIllIlIIIIl, llllllllllllllllIIlllIIllIlIIllI, this.getComponentType());
                    }
                    case 6: {
                        return generateAndAddPiece(llllllllllllllllIIlllIIllIlIlIll, llllllllllllllllIIlllIIllIlIIIll, llllllllllllllllIIlllIIllIlIIIlI, this.boundingBox.maxX + 1, this.boundingBox.minY + llllllllllllllllIIlllIIllIlIIlll, this.boundingBox.minZ + llllllllllllllllIIlllIIllIlIIIIl, llllllllllllllllIIlllIIllIlIIllI, this.getComponentType());
                    }
                }
            }
            return null;
        }
        
        public enum Door
        {
            GRATES("GRATES", 2), 
            WOOD_DOOR("WOOD_DOOR", 1), 
            IRON_DOOR("IRON_DOOR", 3), 
            OPENING("OPENING", 0);
            
            private Door(final String llllllllllllIlllllIIlIIlIllIIlIl, final int llllllllllllIlllllIIlIIlIllIIlII) {
            }
        }
    }
    
    static class Stones extends StructureComponent.BlockSelector
    {
        @Override
        public void selectBlocks(final Random llllllllllllllllIIIIIlIIIIlIIlll, final int llllllllllllllllIIIIIlIIIIlIllIl, final int llllllllllllllllIIIIIlIIIIlIllII, final int llllllllllllllllIIIIIlIIIIlIlIll, final boolean llllllllllllllllIIIIIlIIIIlIlIlI) {
            if (llllllllllllllllIIIIIlIIIIlIlIlI) {
                final float llllllllllllllllIIIIIlIIIIlIlIIl = llllllllllllllllIIIIIlIIIIlIIlll.nextFloat();
                if (llllllllllllllllIIIIIlIIIIlIlIIl < 0.2f) {
                    this.blockstate = Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CRACKED_META);
                }
                else if (llllllllllllllllIIIIIlIIIIlIlIIl < 0.5f) {
                    this.blockstate = Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.MOSSY_META);
                }
                else if (llllllllllllllllIIIIIlIIIIlIlIIl < 0.55f) {
                    this.blockstate = Blocks.MONSTER_EGG.getStateFromMeta(BlockSilverfish.EnumType.STONEBRICK.getMetadata());
                }
                else {
                    this.blockstate = Blocks.STONEBRICK.getDefaultState();
                }
            }
            else {
                this.blockstate = Blocks.AIR.getDefaultState();
            }
        }
        
        private Stones() {
        }
    }
    
    static class PieceWeight
    {
        public /* synthetic */ int instancesLimit;
        public /* synthetic */ Class<? extends Stronghold> pieceClass;
        public /* synthetic */ int instancesSpawned;
        public final /* synthetic */ int pieceWeight;
        
        public PieceWeight(final Class<? extends Stronghold> llllllllllllllllIlIlIIlIlIllIIIl, final int llllllllllllllllIlIlIIlIlIllIlII, final int llllllllllllllllIlIlIIlIlIlIllll) {
            this.pieceClass = llllllllllllllllIlIlIIlIlIllIIIl;
            this.pieceWeight = llllllllllllllllIlIlIIlIlIllIlII;
            this.instancesLimit = llllllllllllllllIlIlIIlIlIlIllll;
        }
        
        public boolean canSpawnMoreStructures() {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
        
        public boolean canSpawnMoreStructuresOfType(final int llllllllllllllllIlIlIIlIlIlIlIlI) {
            return this.instancesLimit == 0 || this.instancesSpawned < this.instancesLimit;
        }
    }
    
    public static class Stairs extends Stronghold
    {
        private /* synthetic */ boolean source;
        
        public Stairs() {
        }
        
        public static Stairs createPiece(final List<StructureComponent> lllllllllllllIIlIlIlIllIllIllllI, final Random lllllllllllllIIlIlIlIllIllIlllIl, final int lllllllllllllIIlIlIlIllIlllIIlII, final int lllllllllllllIIlIlIlIllIllIllIll, final int lllllllllllllIIlIlIlIllIllIllIlI, final EnumFacing lllllllllllllIIlIlIlIllIllIllIIl, final int lllllllllllllIIlIlIlIllIllIllIII) {
            final StructureBoundingBox lllllllllllllIIlIlIlIllIllIlllll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlIlIlIllIlllIIlII, lllllllllllllIIlIlIlIllIllIllIll, lllllllllllllIIlIlIlIllIllIllIlI, -1, -7, 0, 5, 11, 5, lllllllllllllIIlIlIlIllIllIllIIl);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllIIlIlIlIllIllIlllll) && StructureComponent.findIntersecting(lllllllllllllIIlIlIlIllIllIllllI, lllllllllllllIIlIlIlIllIllIlllll) == null) ? new Stairs(lllllllllllllIIlIlIlIllIllIllIII, lllllllllllllIIlIlIlIllIllIlllIl, lllllllllllllIIlIlIlIllIllIlllll, lllllllllllllIIlIlIlIllIllIllIIl) : null;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIlIlIlIllIllllIlIl, final List<StructureComponent> lllllllllllllIIlIlIlIllIllllIIII, final Random lllllllllllllIIlIlIlIllIllllIIll) {
            if (this.source) {
                StructureStrongholdPieces.access$2(Crossing.class);
            }
            this.getNextComponentNormal((Stairs2)lllllllllllllIIlIlIlIllIllllIlIl, lllllllllllllIIlIlIlIllIllllIIII, lllllllllllllIIlIlIlIllIllllIIll, 1, 1);
        }
        
        public Stairs(final int lllllllllllllIIlIlIlIlllIIlIIIIl, final Random lllllllllllllIIlIlIlIlllIIlIIIII, final int lllllllllllllIIlIlIlIlllIIIllIlI, final int lllllllllllllIIlIlIlIlllIIIllllI) {
            super(lllllllllllllIIlIlIlIlllIIlIIIIl);
            this.source = true;
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(lllllllllllllIIlIlIlIlllIIlIIIII));
            this.entryDoor = Door.OPENING;
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(lllllllllllllIIlIlIlIlllIIIllIlI, 64, lllllllllllllIIlIlIlIlllIIIllllI, lllllllllllllIIlIlIlIlllIIIllIlI + 5 - 1, 74, lllllllllllllIIlIlIlIlllIIIllllI + 5 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(lllllllllllllIIlIlIlIlllIIIllIlI, 64, lllllllllllllIIlIlIlIlllIIIllllI, lllllllllllllIIlIlIlIlllIIIllIlI + 5 - 1, 74, lllllllllllllIIlIlIlIlllIIIllllI + 5 - 1);
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIlIlIlIlllIIIIIllI) {
            super.writeStructureToNBT(lllllllllllllIIlIlIlIlllIIIIIllI);
            lllllllllllllIIlIlIlIlllIIIIIllI.setBoolean("Source", this.source);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIlIlIlIllIllllllII, final TemplateManager lllllllllllllIIlIlIlIllIlllllllI) {
            super.readStructureFromNBT(lllllllllllllIIlIlIlIllIllllllII, lllllllllllllIIlIlIlIllIlllllllI);
            this.source = lllllllllllllIIlIlIlIllIllllllII.getBoolean("Source");
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIlIlIllIllIlIIIl, final Random lllllllllllllIIlIlIlIllIllIlIIII, final StructureBoundingBox lllllllllllllIIlIlIlIllIllIIllll) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIIlIlIlIllIllIlIIIl, lllllllllllllIIlIlIlIllIllIIllll)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllIIlIlIlIllIllIlIIIl, lllllllllllllIIlIlIlIllIllIIllll, 0, 0, 0, 4, 10, 4, true, lllllllllllllIIlIlIlIllIllIlIIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllIIlIlIlIllIllIlIIIl, lllllllllllllIIlIlIlIllIllIlIIII, lllllllllllllIIlIlIlIllIllIIllll, this.entryDoor, 1, 7, 0);
            this.placeDoor(lllllllllllllIIlIlIlIllIllIlIIIl, lllllllllllllIIlIlIlIllIllIlIIII, lllllllllllllIIlIlIlIllIllIIllll, Door.OPENING, 1, 1, 4);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 2, 6, 1, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 1, 5, 1, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 6, 1, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 1, 5, 2, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 1, 4, 3, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 5, 3, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 2, 4, 3, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 3, 3, 3, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 3, 4, 3, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 3, 3, 2, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 3, 2, 1, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 3, 3, 1, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 2, 2, 1, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 1, 1, 1, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 2, 1, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONEBRICK.getDefaultState(), 1, 1, 2, lllllllllllllIIlIlIlIllIllIIllll);
            this.setBlockState(lllllllllllllIIlIlIlIllIllIlIIIl, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.STONE.getMetadata()), 1, 1, 3, lllllllllllllIIlIlIlIllIllIIllll);
            return true;
        }
        
        public Stairs(final int lllllllllllllIIlIlIlIlllIIIlIIlI, final Random lllllllllllllIIlIlIlIlllIIIIllII, final StructureBoundingBox lllllllllllllIIlIlIlIlllIIIIlIll, final EnumFacing lllllllllllllIIlIlIlIlllIIIIllll) {
            super(lllllllllllllIIlIlIlIlllIIIlIIlI);
            this.source = false;
            this.setCoordBaseMode(lllllllllllllIIlIlIlIlllIIIIllll);
            this.entryDoor = this.getRandomDoor(lllllllllllllIIlIlIlIlllIIIIllII);
            this.boundingBox = lllllllllllllIIlIlIlIlllIIIIlIll;
        }
    }
    
    public static class Crossing extends Stronghold
    {
        private /* synthetic */ boolean leftLow;
        private /* synthetic */ boolean rightHigh;
        private /* synthetic */ boolean leftHigh;
        private /* synthetic */ boolean rightLow;
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIlIIIlIIlIllllIlIl, final List<StructureComponent> lllllllllllllIIlIIIlIIlIlllIllIl, final Random lllllllllllllIIlIIIlIIlIllllIIll) {
            int lllllllllllllIIlIIIlIIlIllllIIlI = 3;
            int lllllllllllllIIlIIIlIIlIllllIIIl = 5;
            final EnumFacing lllllllllllllIIlIIIlIIlIllllIIII = this.getCoordBaseMode();
            if (lllllllllllllIIlIIIlIIlIllllIIII == EnumFacing.WEST || lllllllllllllIIlIIIlIIlIllllIIII == EnumFacing.NORTH) {
                lllllllllllllIIlIIIlIIlIllllIIlI = 8 - lllllllllllllIIlIIIlIIlIllllIIlI;
                lllllllllllllIIlIIIlIIlIllllIIIl = 8 - lllllllllllllIIlIIIlIIlIllllIIIl;
            }
            this.getNextComponentNormal((Stairs2)lllllllllllllIIlIIIlIIlIllllIlIl, lllllllllllllIIlIIIlIIlIlllIllIl, lllllllllllllIIlIIIlIIlIllllIIll, 5, 1);
            if (this.leftLow) {
                this.getNextComponentX((Stairs2)lllllllllllllIIlIIIlIIlIllllIlIl, lllllllllllllIIlIIIlIIlIlllIllIl, lllllllllllllIIlIIIlIIlIllllIIll, lllllllllllllIIlIIIlIIlIllllIIlI, 1);
            }
            if (this.leftHigh) {
                this.getNextComponentX((Stairs2)lllllllllllllIIlIIIlIIlIllllIlIl, lllllllllllllIIlIIIlIIlIlllIllIl, lllllllllllllIIlIIIlIIlIllllIIll, lllllllllllllIIlIIIlIIlIllllIIIl, 7);
            }
            if (this.rightLow) {
                this.getNextComponentZ((Stairs2)lllllllllllllIIlIIIlIIlIllllIlIl, lllllllllllllIIlIIIlIIlIlllIllIl, lllllllllllllIIlIIIlIIlIllllIIll, lllllllllllllIIlIIIlIIlIllllIIlI, 1);
            }
            if (this.rightHigh) {
                this.getNextComponentZ((Stairs2)lllllllllllllIIlIIIlIIlIllllIlIl, lllllllllllllIIlIIIlIIlIlllIllIl, lllllllllllllIIlIIIlIIlIllllIIll, lllllllllllllIIlIIIlIIlIllllIIIl, 7);
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIIIlIIlIllIIIlll, final Random lllllllllllllIIlIIIlIIlIllIIlIlI, final StructureBoundingBox lllllllllllllIIlIIIlIIlIllIIlIIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 0, 0, 0, 9, 8, 10, true, lllllllllllllIIlIIIlIIlIllIIlIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIlI, lllllllllllllIIlIIIlIIlIllIIlIIl, this.entryDoor, 4, 3, 0);
            if (this.leftLow) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 0, 3, 1, 0, 5, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            if (this.rightLow) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 9, 3, 1, 9, 5, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            if (this.leftHigh) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 0, 5, 7, 0, 7, 9, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            if (this.rightHigh) {
                this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 9, 5, 7, 9, 7, 9, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 5, 1, 10, 7, 3, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 1, 2, 1, 8, 2, 6, false, lllllllllllllIIlIIIlIIlIllIIlIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 4, 1, 5, 4, 4, 9, false, lllllllllllllIIlIIIlIIlIllIIlIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 8, 1, 5, 8, 4, 9, false, lllllllllllllIIlIIIlIIlIllIIlIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 1, 4, 7, 3, 4, 9, false, lllllllllllllIIlIIIlIIlIllIIlIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 1, 3, 5, 3, 3, 6, false, lllllllllllllIIlIIIlIIlIllIIlIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 1, 3, 4, 3, 3, 4, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 1, 4, 6, 3, 4, 6, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 5, 1, 7, 7, 1, 8, false, lllllllllllllIIlIIIlIIlIllIIlIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 5, 1, 9, 7, 1, 9, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 5, 2, 7, 7, 2, 7, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 4, 5, 7, 4, 5, 9, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 8, 5, 7, 8, 5, 9, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIIlIIlIllIIIlll, lllllllllllllIIlIIIlIIlIllIIlIIl, 5, 5, 7, 7, 5, 9, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), Blocks.DOUBLE_STONE_SLAB.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIlIIIlIIlIllIIIlll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.SOUTH), 6, 5, 6, lllllllllllllIIlIIIlIIlIllIIlIIl);
            return true;
        }
        
        public Crossing(final int lllllllllllllIIlIIIlIIllIIIlIlIl, final Random lllllllllllllIIlIIIlIIllIIIIllll, final StructureBoundingBox lllllllllllllIIlIIIlIIllIIIlIIll, final EnumFacing lllllllllllllIIlIIIlIIllIIIIllIl) {
            super(lllllllllllllIIlIIIlIIllIIIlIlIl);
            this.setCoordBaseMode(lllllllllllllIIlIIIlIIllIIIIllIl);
            this.entryDoor = this.getRandomDoor(lllllllllllllIIlIIIlIIllIIIIllll);
            this.boundingBox = lllllllllllllIIlIIIlIIllIIIlIIll;
            this.leftLow = lllllllllllllIIlIIIlIIllIIIIllll.nextBoolean();
            this.leftHigh = lllllllllllllIIlIIIlIIllIIIIllll.nextBoolean();
            this.rightLow = lllllllllllllIIlIIIlIIllIIIIllll.nextBoolean();
            this.rightHigh = (lllllllllllllIIlIIIlIIllIIIIllll.nextInt(3) > 0);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIlIIIlIIllIIIIIlll) {
            super.writeStructureToNBT(lllllllllllllIIlIIIlIIllIIIIIlll);
            lllllllllllllIIlIIIlIIllIIIIIlll.setBoolean("leftLow", this.leftLow);
            lllllllllllllIIlIIIlIIllIIIIIlll.setBoolean("leftHigh", this.leftHigh);
            lllllllllllllIIlIIIlIIllIIIIIlll.setBoolean("rightLow", this.rightLow);
            lllllllllllllIIlIIIlIIllIIIIIlll.setBoolean("rightHigh", this.rightHigh);
        }
        
        public Crossing() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIlIIIlIIllIIIIIIlI, final TemplateManager lllllllllllllIIlIIIlIIllIIIIIIIl) {
            super.readStructureFromNBT(lllllllllllllIIlIIIlIIllIIIIIIlI, lllllllllllllIIlIIIlIIllIIIIIIIl);
            this.leftLow = lllllllllllllIIlIIIlIIllIIIIIIlI.getBoolean("leftLow");
            this.leftHigh = lllllllllllllIIlIIIlIIllIIIIIIlI.getBoolean("leftHigh");
            this.rightLow = lllllllllllllIIlIIIlIIllIIIIIIlI.getBoolean("rightLow");
            this.rightHigh = lllllllllllllIIlIIIlIIllIIIIIIlI.getBoolean("rightHigh");
        }
        
        public static Crossing createPiece(final List<StructureComponent> lllllllllllllIIlIIIlIIlIlllIIIII, final Random lllllllllllllIIlIIIlIIlIllIlIlll, final int lllllllllllllIIlIIIlIIlIllIllllI, final int lllllllllllllIIlIIIlIIlIllIlllIl, final int lllllllllllllIIlIIIlIIlIllIlllII, final EnumFacing lllllllllllllIIlIIIlIIlIllIllIll, final int lllllllllllllIIlIIIlIIlIllIllIlI) {
            final StructureBoundingBox lllllllllllllIIlIIIlIIlIllIllIIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlIIIlIIlIllIllllI, lllllllllllllIIlIIIlIIlIllIlllIl, lllllllllllllIIlIIIlIIlIllIlllII, -4, -3, 0, 10, 9, 11, lllllllllllllIIlIIIlIIlIllIllIll);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllIIlIIIlIIlIllIllIIl) && StructureComponent.findIntersecting(lllllllllllllIIlIIIlIIlIlllIIIII, lllllllllllllIIlIIIlIIlIllIllIIl) == null) ? new Crossing(lllllllllllllIIlIIIlIIlIllIllIlI, lllllllllllllIIlIIIlIIlIllIlIlll, lllllllllllllIIlIIIlIIlIllIllIIl, lllllllllllllIIlIIIlIIlIllIllIll) : null;
        }
    }
    
    public static class ChestCorridor extends Stronghold
    {
        private /* synthetic */ boolean hasMadeChest;
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllIllIIIIllIlllII, final Random lllllllllllllllllIllIIIIllIlIllI, final StructureBoundingBox lllllllllllllllllIllIIIIllIllIlI) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllllIllIIIIllIlllII, lllllllllllllllllIllIIIIllIllIlI)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllllllIllIIIIllIlllII, lllllllllllllllllIllIIIIllIllIlI, 0, 0, 0, 4, 4, 6, true, lllllllllllllllllIllIIIIllIlIllI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllllllIllIIIIllIlllII, lllllllllllllllllIllIIIIllIlIllI, lllllllllllllllllIllIIIIllIllIlI, this.entryDoor, 1, 1, 0);
            this.placeDoor(lllllllllllllllllIllIIIIllIlllII, lllllllllllllllllIllIIIIllIlIllI, lllllllllllllllllIllIIIIllIllIlI, Door.OPENING, 1, 1, 6);
            this.fillWithBlocks(lllllllllllllllllIllIIIIllIlllII, lllllllllllllllllIllIIIIllIllIlI, 3, 1, 2, 3, 1, 4, Blocks.STONEBRICK.getDefaultState(), Blocks.STONEBRICK.getDefaultState(), false);
            this.setBlockState(lllllllllllllllllIllIIIIllIlllII, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 1, 1, lllllllllllllllllIllIIIIllIllIlI);
            this.setBlockState(lllllllllllllllllIllIIIIllIlllII, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 1, 5, lllllllllllllllllIllIIIIllIllIlI);
            this.setBlockState(lllllllllllllllllIllIIIIllIlllII, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 2, 2, lllllllllllllllllIllIIIIllIllIlI);
            this.setBlockState(lllllllllllllllllIllIIIIllIlllII, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 3, 2, 4, lllllllllllllllllIllIIIIllIllIlI);
            for (int lllllllllllllllllIllIIIIllIllIIl = 2; lllllllllllllllllIllIIIIllIllIIl <= 4; ++lllllllllllllllllIllIIIIllIllIIl) {
                this.setBlockState(lllllllllllllllllIllIIIIllIlllII, Blocks.STONE_SLAB.getStateFromMeta(BlockStoneSlab.EnumType.SMOOTHBRICK.getMetadata()), 2, 1, lllllllllllllllllIllIIIIllIllIIl, lllllllllllllllllIllIIIIllIllIlI);
            }
            if (!this.hasMadeChest && lllllllllllllllllIllIIIIllIllIlI.isVecInside(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
                this.hasMadeChest = true;
                this.generateChest(lllllllllllllllllIllIIIIllIlllII, lllllllllllllllllIllIIIIllIllIlI, lllllllllllllllllIllIIIIllIlIllI, 3, 2, 3, LootTableList.CHESTS_STRONGHOLD_CORRIDOR);
            }
            return true;
        }
        
        public static ChestCorridor createPiece(final List<StructureComponent> lllllllllllllllllIllIIIlIIIIlIII, final Random lllllllllllllllllIllIIIlIIIIIlll, final int lllllllllllllllllIllIIIlIIIIIlIl, final int lllllllllllllllllIllIIIIlllllIlI, final int lllllllllllllllllIllIIIIlllllIII, final EnumFacing lllllllllllllllllIllIIIIllllIllI, final int lllllllllllllllllIllIIIIllllIlII) {
            final StructureBoundingBox lllllllllllllllllIllIIIIlllllllI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllllIllIIIlIIIIIlIl, lllllllllllllllllIllIIIIlllllIlI, lllllllllllllllllIllIIIIlllllIII, -1, -1, 0, 5, 5, 7, lllllllllllllllllIllIIIIllllIllI);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllllllIllIIIIlllllllI) && StructureComponent.findIntersecting(lllllllllllllllllIllIIIlIIIIlIII, lllllllllllllllllIllIIIIlllllllI) == null) ? new ChestCorridor(lllllllllllllllllIllIIIIllllIlII, lllllllllllllllllIllIIIlIIIIIlll, lllllllllllllllllIllIIIIlllllllI, lllllllllllllllllIllIIIIllllIllI) : null;
        }
        
        public ChestCorridor(final int lllllllllllllllllIllIIIlIlIlIIII, final Random lllllllllllllllllIllIIIlIlIIllll, final StructureBoundingBox lllllllllllllllllIllIIIlIlIlIIll, final EnumFacing lllllllllllllllllIllIIIlIlIlIIlI) {
            super(lllllllllllllllllIllIIIlIlIlIIII);
            this.setCoordBaseMode(lllllllllllllllllIllIIIlIlIlIIlI);
            this.entryDoor = this.getRandomDoor(lllllllllllllllllIllIIIlIlIIllll);
            this.boundingBox = lllllllllllllllllIllIIIlIlIlIIll;
        }
        
        public ChestCorridor() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllllIllIIIlIlIIIlIl) {
            super.writeStructureToNBT(lllllllllllllllllIllIIIlIlIIIlIl);
            lllllllllllllllllIllIIIlIlIIIlIl.setBoolean("Chest", this.hasMadeChest);
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllllIllIIIlIIlIIIll, final List<StructureComponent> lllllllllllllllllIllIIIlIIlIlIII, final Random lllllllllllllllllIllIIIlIIlIIlll) {
            this.getNextComponentNormal((Stairs2)lllllllllllllllllIllIIIlIIlIIIll, lllllllllllllllllIllIIIlIIlIlIII, lllllllllllllllllIllIIIlIIlIIlll, 1, 1);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllllIllIIIlIIllIlll, final TemplateManager lllllllllllllllllIllIIIlIIlllIll) {
            super.readStructureFromNBT(lllllllllllllllllIllIIIlIIllIlll, lllllllllllllllllIllIIIlIIlllIll);
            this.hasMadeChest = lllllllllllllllllIllIIIlIIllIlll.getBoolean("Chest");
        }
    }
    
    public static class Prison extends Stronghold
    {
        public static Prison createPiece(final List<StructureComponent> lllllllllllllIlllIllIIIllIlllllI, final Random lllllllllllllIlllIllIIIllIllllIl, final int lllllllllllllIlllIllIIIllIllllII, final int lllllllllllllIlllIllIIIllIllIIll, final int lllllllllllllIlllIllIIIllIlllIlI, final EnumFacing lllllllllllllIlllIllIIIllIlllIIl, final int lllllllllllllIlllIllIIIllIlllIII) {
            final StructureBoundingBox lllllllllllllIlllIllIIIllIllIlll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIlllIllIIIllIllllII, lllllllllllllIlllIllIIIllIllIIll, lllllllllllllIlllIllIIIllIlllIlI, -1, -1, 0, 9, 5, 11, lllllllllllllIlllIllIIIllIlllIIl);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllIlllIllIIIllIllIlll) && StructureComponent.findIntersecting(lllllllllllllIlllIllIIIllIlllllI, lllllllllllllIlllIllIIIllIllIlll) == null) ? new Prison(lllllllllllllIlllIllIIIllIlllIII, lllllllllllllIlllIllIIIllIllllIl, lllllllllllllIlllIllIIIllIllIlll, lllllllllllllIlllIllIIIllIlllIIl) : null;
        }
        
        public Prison() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIlllIllIIIllIlIIlll, final Random lllllllllllllIlllIllIIIllIlIIllI, final StructureBoundingBox lllllllllllllIlllIllIIIllIlIIlIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl, 0, 0, 0, 8, 4, 10, true, lllllllllllllIlllIllIIIllIlIIllI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIllI, lllllllllllllIlllIllIIIllIlIIlIl, this.entryDoor, 1, 1, 0);
            this.fillWithBlocks(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl, 1, 1, 10, 3, 3, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithRandomizedBlocks(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl, 4, 1, 1, 4, 3, 1, false, lllllllllllllIlllIllIIIllIlIIllI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl, 4, 1, 3, 4, 3, 3, false, lllllllllllllIlllIllIIIllIlIIllI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl, 4, 1, 7, 4, 3, 7, false, lllllllllllllIlllIllIIIllIlIIllI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithRandomizedBlocks(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl, 4, 1, 9, 4, 3, 9, false, lllllllllllllIlllIllIIIllIlIIllI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.fillWithBlocks(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl, 4, 1, 4, 4, 3, 6, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlIl, 5, 1, 5, 7, 3, 5, Blocks.IRON_BARS.getDefaultState(), Blocks.IRON_BARS.getDefaultState(), false);
            this.setBlockState(lllllllllllllIlllIllIIIllIlIIlll, Blocks.IRON_BARS.getDefaultState(), 4, 3, 2, lllllllllllllIlllIllIIIllIlIIlIl);
            this.setBlockState(lllllllllllllIlllIllIIIllIlIIlll, Blocks.IRON_BARS.getDefaultState(), 4, 3, 8, lllllllllllllIlllIllIIIllIlIIlIl);
            final IBlockState lllllllllllllIlllIllIIIllIlIIlII = Blocks.IRON_DOOR.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, EnumFacing.WEST);
            final IBlockState lllllllllllllIlllIllIIIllIlIIIll = Blocks.IRON_DOOR.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, EnumFacing.WEST).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER);
            this.setBlockState(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlII, 4, 1, 2, lllllllllllllIlllIllIIIllIlIIlIl);
            this.setBlockState(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIIll, 4, 2, 2, lllllllllllllIlllIllIIIllIlIIlIl);
            this.setBlockState(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIlII, 4, 1, 8, lllllllllllllIlllIllIIIllIlIIlIl);
            this.setBlockState(lllllllllllllIlllIllIIIllIlIIlll, lllllllllllllIlllIllIIIllIlIIIll, 4, 2, 8, lllllllllllllIlllIllIIIllIlIIlIl);
            return true;
        }
        
        public Prison(final int lllllllllllllIlllIllIIIlllIllIll, final Random lllllllllllllIlllIllIIIlllIllIlI, final StructureBoundingBox lllllllllllllIlllIllIIIlllIllIIl, final EnumFacing lllllllllllllIlllIllIIIlllIllIII) {
            super(lllllllllllllIlllIllIIIlllIllIll);
            this.setCoordBaseMode(lllllllllllllIlllIllIIIlllIllIII);
            this.entryDoor = this.getRandomDoor(lllllllllllllIlllIllIIIlllIllIlI);
            this.boundingBox = lllllllllllllIlllIllIIIlllIllIIl;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIlllIllIIIlllIIlIIl, final List<StructureComponent> lllllllllllllIlllIllIIIlllIIllII, final Random lllllllllllllIlllIllIIIlllIIlIll) {
            this.getNextComponentNormal((Stairs2)lllllllllllllIlllIllIIIlllIIlIIl, lllllllllllllIlllIllIIIlllIIllII, lllllllllllllIlllIllIIIlllIIlIll, 1, 1);
        }
    }
    
    public static class StairsStraight extends Stronghold
    {
        public StairsStraight(final int llllllllllllllIIlIIlIIIIllllIlll, final Random llllllllllllllIIlIIlIIIIllllIllI, final StructureBoundingBox llllllllllllllIIlIIlIIIIllllIlIl, final EnumFacing llllllllllllllIIlIIlIIIIlllIllll) {
            super(llllllllllllllIIlIIlIIIIllllIlll);
            this.setCoordBaseMode(llllllllllllllIIlIIlIIIIlllIllll);
            this.entryDoor = this.getRandomDoor(llllllllllllllIIlIIlIIIIllllIllI);
            this.boundingBox = llllllllllllllIIlIIlIIIIllllIlIl;
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIlIIIIlIllllIl, final Random llllllllllllllIIlIIlIIIIllIIIIlI, final StructureBoundingBox llllllllllllllIIlIIlIIIIlIlllIll) {
            if (this.isLiquidInStructureBoundingBox(llllllllllllllIIlIIlIIIIlIllllIl, llllllllllllllIIlIIlIIIIlIlllIll)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllllllllIIlIIlIIIIlIllllIl, llllllllllllllIIlIIlIIIIlIlllIll, 0, 0, 0, 4, 10, 7, true, llllllllllllllIIlIIlIIIIllIIIIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(llllllllllllllIIlIIlIIIIlIllllIl, llllllllllllllIIlIIlIIIIllIIIIlI, llllllllllllllIIlIIlIIIIlIlllIll, this.entryDoor, 1, 7, 0);
            this.placeDoor(llllllllllllllIIlIIlIIIIlIllllIl, llllllllllllllIIlIIlIIIIllIIIIlI, llllllllllllllIIlIIlIIIIlIlllIll, Door.OPENING, 1, 1, 7);
            final IBlockState llllllllllllllIIlIIlIIIIllIIIIII = Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH);
            for (int llllllllllllllIIlIIlIIIIlIllllll = 0; llllllllllllllIIlIIlIIIIlIllllll < 6; ++llllllllllllllIIlIIlIIIIlIllllll) {
                this.setBlockState(llllllllllllllIIlIIlIIIIlIllllIl, llllllllllllllIIlIIlIIIIllIIIIII, 1, 6 - llllllllllllllIIlIIlIIIIlIllllll, 1 + llllllllllllllIIlIIlIIIIlIllllll, llllllllllllllIIlIIlIIIIlIlllIll);
                this.setBlockState(llllllllllllllIIlIIlIIIIlIllllIl, llllllllllllllIIlIIlIIIIllIIIIII, 2, 6 - llllllllllllllIIlIIlIIIIlIllllll, 1 + llllllllllllllIIlIIlIIIIlIllllll, llllllllllllllIIlIIlIIIIlIlllIll);
                this.setBlockState(llllllllllllllIIlIIlIIIIlIllllIl, llllllllllllllIIlIIlIIIIllIIIIII, 3, 6 - llllllllllllllIIlIIlIIIIlIllllll, 1 + llllllllllllllIIlIIlIIIIlIllllll, llllllllllllllIIlIIlIIIIlIlllIll);
                if (llllllllllllllIIlIIlIIIIlIllllll < 5) {
                    this.setBlockState(llllllllllllllIIlIIlIIIIlIllllIl, Blocks.STONEBRICK.getDefaultState(), 1, 5 - llllllllllllllIIlIIlIIIIlIllllll, 1 + llllllllllllllIIlIIlIIIIlIllllll, llllllllllllllIIlIIlIIIIlIlllIll);
                    this.setBlockState(llllllllllllllIIlIIlIIIIlIllllIl, Blocks.STONEBRICK.getDefaultState(), 2, 5 - llllllllllllllIIlIIlIIIIlIllllll, 1 + llllllllllllllIIlIIlIIIIlIllllll, llllllllllllllIIlIIlIIIIlIlllIll);
                    this.setBlockState(llllllllllllllIIlIIlIIIIlIllllIl, Blocks.STONEBRICK.getDefaultState(), 3, 5 - llllllllllllllIIlIIlIIIIlIllllll, 1 + llllllllllllllIIlIIlIIIIlIllllll, llllllllllllllIIlIIlIIIIlIlllIll);
                }
            }
            return true;
        }
        
        public static StairsStraight createPiece(final List<StructureComponent> llllllllllllllIIlIIlIIIIllIlIIlI, final Random llllllllllllllIIlIIlIIIIllIllIIl, final int llllllllllllllIIlIIlIIIIllIlIIII, final int llllllllllllllIIlIIlIIIIllIlIlll, final int llllllllllllllIIlIIlIIIIllIIlllI, final EnumFacing llllllllllllllIIlIIlIIIIllIlIlIl, final int llllllllllllllIIlIIlIIIIllIlIlII) {
            final StructureBoundingBox llllllllllllllIIlIIlIIIIllIlIIll = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIIlIIlIIIIllIlIIII, llllllllllllllIIlIIlIIIIllIlIlll, llllllllllllllIIlIIlIIIIllIIlllI, -1, -7, 0, 5, 11, 8, llllllllllllllIIlIIlIIIIllIlIlIl);
            return (Stronghold.canStrongholdGoDeeper(llllllllllllllIIlIIlIIIIllIlIIll) && StructureComponent.findIntersecting(llllllllllllllIIlIIlIIIIllIlIIlI, llllllllllllllIIlIIlIIIIllIlIIll) == null) ? new StairsStraight(llllllllllllllIIlIIlIIIIllIlIlII, llllllllllllllIIlIIlIIIIllIllIIl, llllllllllllllIIlIIlIIIIllIlIIll, llllllllllllllIIlIIlIIIIllIlIlIl) : null;
        }
        
        @Override
        public void buildComponent(final StructureComponent llllllllllllllIIlIIlIIIIlllIIlIl, final List<StructureComponent> llllllllllllllIIlIIlIIIIlllIIlII, final Random llllllllllllllIIlIIlIIIIlllIIlll) {
            this.getNextComponentNormal((Stairs2)llllllllllllllIIlIIlIIIIlllIIlIl, llllllllllllllIIlIIlIIIIlllIIlII, llllllllllllllIIlIIlIIIIlllIIlll, 1, 1);
        }
        
        public StairsStraight() {
        }
    }
    
    public static class RoomCrossing extends Stronghold
    {
        protected /* synthetic */ int roomType;
        
        public RoomCrossing(final int llllllllllIlIII, final Random llllllllllIIlll, final StructureBoundingBox llllllllllIlIll, final EnumFacing llllllllllIlIlI) {
            super(llllllllllIlIII);
            this.setCoordBaseMode(llllllllllIlIlI);
            this.entryDoor = this.getRandomDoor(llllllllllIIlll);
            this.boundingBox = llllllllllIlIll;
            this.roomType = llllllllllIIlll.nextInt(5);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllIIIIl) {
            super.writeStructureToNBT(llllllllllIIIIl);
            llllllllllIIIIl.setInteger("Type", this.roomType);
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllIlIIII, final List<StructureComponent> lllllllllIIlIll, final Random lllllllllIIlllI) {
            this.getNextComponentNormal((Stairs2)lllllllllIlIIII, lllllllllIIlIll, lllllllllIIlllI, 4, 1);
            this.getNextComponentX((Stairs2)lllllllllIlIIII, lllllllllIIlIll, lllllllllIIlllI, 1, 4);
            this.getNextComponentZ((Stairs2)lllllllllIlIIII, lllllllllIIlIll, lllllllllIIlllI, 1, 4);
        }
        
        @Override
        public boolean addComponentParts(final World llllllllIlIlIll, final Random llllllllIlIIIII, final StructureBoundingBox llllllllIIlllll) {
            if (this.isLiquidInStructureBoundingBox(llllllllIlIlIll, llllllllIIlllll)) {
                return false;
            }
            this.fillWithRandomizedBlocks(llllllllIlIlIll, llllllllIIlllll, 0, 0, 0, 10, 6, 10, true, llllllllIlIIIII, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(llllllllIlIlIll, llllllllIlIIIII, llllllllIIlllll, this.entryDoor, 4, 1, 0);
            this.fillWithBlocks(llllllllIlIlIll, llllllllIIlllll, 4, 1, 10, 6, 3, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllIlIlIll, llllllllIIlllll, 0, 1, 4, 0, 3, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllIlIlIll, llllllllIIlllll, 10, 1, 4, 10, 3, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            switch (this.roomType) {
                case 0: {
                    this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 5, 1, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 5, 2, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 5, 3, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.WEST), 4, 3, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.EAST), 6, 3, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.SOUTH), 5, 3, 4, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.NORTH), 5, 3, 6, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONE_SLAB.getDefaultState(), 4, 1, 4, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONE_SLAB.getDefaultState(), 4, 1, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONE_SLAB.getDefaultState(), 4, 1, 6, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONE_SLAB.getDefaultState(), 6, 1, 4, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONE_SLAB.getDefaultState(), 6, 1, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONE_SLAB.getDefaultState(), 6, 1, 6, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONE_SLAB.getDefaultState(), 5, 1, 4, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONE_SLAB.getDefaultState(), 5, 1, 6, llllllllIIlllll);
                    break;
                }
                case 1: {
                    for (int llllllllIlIlIII = 0; llllllllIlIlIII < 5; ++llllllllIlIlIII) {
                        this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 3, 1, 3 + llllllllIlIlIII, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 7, 1, 3 + llllllllIlIlIII, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 3 + llllllllIlIlIII, 1, 3, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 3 + llllllllIlIlIII, 1, 7, llllllllIIlllll);
                    }
                    this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 5, 1, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 5, 2, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.STONEBRICK.getDefaultState(), 5, 3, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.FLOWING_WATER.getDefaultState(), 5, 4, 5, llllllllIIlllll);
                    break;
                }
                case 2: {
                    for (int llllllllIlIIlll = 1; llllllllIlIIlll <= 9; ++llllllllIlIIlll) {
                        this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 1, 3, llllllllIlIIlll, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 9, 3, llllllllIlIIlll, llllllllIIlllll);
                    }
                    for (int llllllllIlIIllI = 1; llllllllIlIIllI <= 9; ++llllllllIlIIllI) {
                        this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), llllllllIlIIllI, 3, 1, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), llllllllIlIIllI, 3, 9, llllllllIIlllll);
                    }
                    this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 5, 1, 4, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 5, 1, 6, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 5, 3, 4, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 5, 3, 6, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 4, 1, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 6, 1, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 4, 3, 5, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 6, 3, 5, llllllllIIlllll);
                    for (int llllllllIlIIlIl = 1; llllllllIlIIlIl <= 3; ++llllllllIlIIlIl) {
                        this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 4, llllllllIlIIlIl, 4, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 6, llllllllIlIIlIl, 4, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 4, llllllllIlIIlIl, 6, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.COBBLESTONE.getDefaultState(), 6, llllllllIlIIlIl, 6, llllllllIIlllll);
                    }
                    this.setBlockState(llllllllIlIlIll, Blocks.TORCH.getDefaultState(), 5, 3, 5, llllllllIIlllll);
                    for (int llllllllIlIIlII = 2; llllllllIlIIlII <= 8; ++llllllllIlIIlII) {
                        this.setBlockState(llllllllIlIlIll, Blocks.PLANKS.getDefaultState(), 2, 3, llllllllIlIIlII, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.PLANKS.getDefaultState(), 3, 3, llllllllIlIIlII, llllllllIIlllll);
                        if (llllllllIlIIlII <= 3 || llllllllIlIIlII >= 7) {
                            this.setBlockState(llllllllIlIlIll, Blocks.PLANKS.getDefaultState(), 4, 3, llllllllIlIIlII, llllllllIIlllll);
                            this.setBlockState(llllllllIlIlIll, Blocks.PLANKS.getDefaultState(), 5, 3, llllllllIlIIlII, llllllllIIlllll);
                            this.setBlockState(llllllllIlIlIll, Blocks.PLANKS.getDefaultState(), 6, 3, llllllllIlIIlII, llllllllIIlllll);
                        }
                        this.setBlockState(llllllllIlIlIll, Blocks.PLANKS.getDefaultState(), 7, 3, llllllllIlIIlII, llllllllIIlllll);
                        this.setBlockState(llllllllIlIlIll, Blocks.PLANKS.getDefaultState(), 8, 3, llllllllIlIIlII, llllllllIIlllll);
                    }
                    final IBlockState llllllllIlIIIll = Blocks.LADDER.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.WEST);
                    this.setBlockState(llllllllIlIlIll, llllllllIlIIIll, 9, 1, 3, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, llllllllIlIIIll, 9, 2, 3, llllllllIIlllll);
                    this.setBlockState(llllllllIlIlIll, llllllllIlIIIll, 9, 3, 3, llllllllIIlllll);
                    this.generateChest(llllllllIlIlIll, llllllllIIlllll, llllllllIlIIIII, 3, 4, 8, LootTableList.CHESTS_STRONGHOLD_CROSSING);
                    break;
                }
            }
            return true;
        }
        
        public RoomCrossing() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllIlIlll, final TemplateManager lllllllllIlIllI) {
            super.readStructureFromNBT(lllllllllIlIlll, lllllllllIlIllI);
            this.roomType = lllllllllIlIlll.getInteger("Type");
        }
        
        public static RoomCrossing createPiece(final List<StructureComponent> llllllllIlllIIl, final Random llllllllIlllIII, final int llllllllIllIlll, final int llllllllIllIllI, final int llllllllIllllIl, final EnumFacing llllllllIllIlII, final int llllllllIlllIll) {
            final StructureBoundingBox llllllllIlllIlI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllIllIlll, llllllllIllIllI, llllllllIllllIl, -4, -1, 0, 11, 7, 11, llllllllIllIlII);
            return (Stronghold.canStrongholdGoDeeper(llllllllIlllIlI) && StructureComponent.findIntersecting(llllllllIlllIIl, llllllllIlllIlI) == null) ? new RoomCrossing(llllllllIlllIll, llllllllIlllIII, llllllllIlllIlI, llllllllIllIlII) : null;
        }
    }
    
    public static class RightTurn extends LeftTurn
    {
        @Override
        public boolean addComponentParts(final World lllllllllllllIlIIIIIlIllIllllIll, final Random lllllllllllllIlIIIIIlIllIllllIlI, final StructureBoundingBox lllllllllllllIlIIIIIlIllIllllIIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIlIIIIIlIllIllllIll, lllllllllllllIlIIIIIlIllIllllIIl)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllIlIIIIIlIllIllllIll, lllllllllllllIlIIIIIlIllIllllIIl, 0, 0, 0, 4, 4, 4, true, lllllllllllllIlIIIIIlIllIllllIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllIlIIIIIlIllIllllIll, lllllllllllllIlIIIIIlIllIllllIlI, lllllllllllllIlIIIIIlIllIllllIIl, this.entryDoor, 1, 1, 0);
            final EnumFacing lllllllllllllIlIIIIIlIllIlllllIl = this.getCoordBaseMode();
            if (lllllllllllllIlIIIIIlIllIlllllIl != EnumFacing.NORTH && lllllllllllllIlIIIIIlIllIlllllIl != EnumFacing.EAST) {
                this.fillWithBlocks(lllllllllllllIlIIIIIlIllIllllIll, lllllllllllllIlIIIIIlIllIllllIIl, 0, 1, 1, 0, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            else {
                this.fillWithBlocks(lllllllllllllIlIIIIIlIllIllllIll, lllllllllllllIlIIIIIlIllIllllIIl, 4, 1, 1, 4, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            return true;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIlIIIIIlIlllIIIllll, final List<StructureComponent> lllllllllllllIlIIIIIlIlllIIIlllI, final Random lllllllllllllIlIIIIIlIlllIIIllIl) {
            final EnumFacing lllllllllllllIlIIIIIlIlllIIIllII = this.getCoordBaseMode();
            if (lllllllllllllIlIIIIIlIlllIIIllII != EnumFacing.NORTH && lllllllllllllIlIIIIIlIlllIIIllII != EnumFacing.EAST) {
                this.getNextComponentX((Stairs2)lllllllllllllIlIIIIIlIlllIIIllll, lllllllllllllIlIIIIIlIlllIIIlllI, lllllllllllllIlIIIIIlIlllIIIllIl, 1, 1);
            }
            else {
                this.getNextComponentZ((Stairs2)lllllllllllllIlIIIIIlIlllIIIllll, lllllllllllllIlIIIIIlIlllIIIlllI, lllllllllllllIlIIIIIlIlllIIIllIl, 1, 1);
            }
        }
    }
    
    public static class LeftTurn extends Stronghold
    {
        public static LeftTurn createPiece(final List<StructureComponent> lllllllllllllIIllIIllIlIIlIIlIlI, final Random lllllllllllllIIllIIllIlIIlIIlIIl, final int lllllllllllllIIllIIllIlIIlIIlIII, final int lllllllllllllIIllIIllIlIIlIIIlll, final int lllllllllllllIIllIIllIlIIlIIIllI, final EnumFacing lllllllllllllIIllIIllIlIIIllllIl, final int lllllllllllllIIllIIllIlIIIllllII) {
            final StructureBoundingBox lllllllllllllIIllIIllIlIIlIIIIll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIllIIllIlIIlIIlIII, lllllllllllllIIllIIllIlIIlIIIlll, lllllllllllllIIllIIllIlIIlIIIllI, -1, -1, 0, 5, 5, 5, lllllllllllllIIllIIllIlIIIllllIl);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllIIllIIllIlIIlIIIIll) && StructureComponent.findIntersecting(lllllllllllllIIllIIllIlIIlIIlIlI, lllllllllllllIIllIIllIlIIlIIIIll) == null) ? new LeftTurn(lllllllllllllIIllIIllIlIIIllllII, lllllllllllllIIllIIllIlIIlIIlIIl, lllllllllllllIIllIIllIlIIlIIIIll, lllllllllllllIIllIIllIlIIIllllIl) : null;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIllIIllIlIIIllIlII, final Random lllllllllllllIIllIIllIlIIIllIIll, final StructureBoundingBox lllllllllllllIIllIIllIlIIIllIIlI) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIIllIIllIlIIIllIlII, lllllllllllllIIllIIllIlIIIllIIlI)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllIIllIIllIlIIIllIlII, lllllllllllllIIllIIllIlIIIllIIlI, 0, 0, 0, 4, 4, 4, true, lllllllllllllIIllIIllIlIIIllIIll, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllIIllIIllIlIIIllIlII, lllllllllllllIIllIIllIlIIIllIIll, lllllllllllllIIllIIllIlIIIllIIlI, this.entryDoor, 1, 1, 0);
            final EnumFacing lllllllllllllIIllIIllIlIIIllIIIl = this.getCoordBaseMode();
            if (lllllllllllllIIllIIllIlIIIllIIIl != EnumFacing.NORTH && lllllllllllllIIllIIllIlIIIllIIIl != EnumFacing.EAST) {
                this.fillWithBlocks(lllllllllllllIIllIIllIlIIIllIlII, lllllllllllllIIllIIllIlIIIllIIlI, 4, 1, 1, 4, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            else {
                this.fillWithBlocks(lllllllllllllIIllIIllIlIIIllIlII, lllllllllllllIIllIIllIlIIIllIIlI, 0, 1, 1, 0, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            return true;
        }
        
        public LeftTurn(final int lllllllllllllIIllIIllIlIIllIlIlI, final Random lllllllllllllIIllIIllIlIIllIIlII, final StructureBoundingBox lllllllllllllIIllIIllIlIIllIIIll, final EnumFacing lllllllllllllIIllIIllIlIIllIIlll) {
            super(lllllllllllllIIllIIllIlIIllIlIlI);
            this.setCoordBaseMode(lllllllllllllIIllIIllIlIIllIIlll);
            this.entryDoor = this.getRandomDoor(lllllllllllllIIllIIllIlIIllIIlII);
            this.boundingBox = lllllllllllllIIllIIllIlIIllIIIll;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllIIllIIllIlIIlIlIllI, final List<StructureComponent> lllllllllllllIIllIIllIlIIlIlIlIl, final Random lllllllllllllIIllIIllIlIIlIllIIl) {
            final EnumFacing lllllllllllllIIllIIllIlIIlIllIII = this.getCoordBaseMode();
            if (lllllllllllllIIllIIllIlIIlIllIII != EnumFacing.NORTH && lllllllllllllIIllIIllIlIIlIllIII != EnumFacing.EAST) {
                this.getNextComponentZ((Stairs2)lllllllllllllIIllIIllIlIIlIlIllI, lllllllllllllIIllIIllIlIIlIlIlIl, lllllllllllllIIllIIllIlIIlIllIIl, 1, 1);
            }
            else {
                this.getNextComponentX((Stairs2)lllllllllllllIIllIIllIlIIlIlIllI, lllllllllllllIIllIIllIlIIlIlIlIl, lllllllllllllIIllIIllIlIIlIllIIl, 1, 1);
            }
        }
        
        public LeftTurn() {
        }
    }
    
    public static class Library extends Stronghold
    {
        private /* synthetic */ boolean isLargeRoom;
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIlIIIIIlllIllIllIll, final Random lllllllllllllIlIIIIIlllIllIllIlI, final StructureBoundingBox lllllllllllllIlIIIIIlllIllIllIIl) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl)) {
                return false;
            }
            int lllllllllllllIlIIIIIlllIlllIIlIl = 11;
            if (!this.isLargeRoom) {
                lllllllllllllIlIIIIIlllIlllIIlIl = 6;
            }
            this.fillWithRandomizedBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 0, 0, 0, 13, lllllllllllllIlIIIIIlllIlllIIlIl - 1, 14, true, lllllllllllllIlIIIIIlllIllIllIlI, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIlI, lllllllllllllIlIIIIIlllIllIllIIl, this.entryDoor, 4, 1, 0);
            this.func_189914_a(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, lllllllllllllIlIIIIIlllIllIllIlI, 0.07f, 2, 1, 1, 11, 4, 13, Blocks.WEB.getDefaultState(), Blocks.WEB.getDefaultState(), false, 0);
            final int lllllllllllllIlIIIIIlllIlllIIlII = 1;
            final int lllllllllllllIlIIIIIlllIlllIIIll = 12;
            for (int lllllllllllllIlIIIIIlllIlllIIIlI = 1; lllllllllllllIlIIIIIlllIlllIIIlI <= 13; ++lllllllllllllIlIIIIIlllIlllIIIlI) {
                if ((lllllllllllllIlIIIIIlllIlllIIIlI - 1) % 4 == 0) {
                    this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 1, 1, lllllllllllllIlIIIIIlllIlllIIIlI, 1, 4, lllllllllllllIlIIIIIlllIlllIIIlI, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                    this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 12, 1, lllllllllllllIlIIIIIlllIlllIIIlI, 12, 4, lllllllllllllIlIIIIIlllIlllIIIlI, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                    this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.EAST), 2, 3, lllllllllllllIlIIIIIlllIlllIIIlI, lllllllllllllIlIIIIIlllIllIllIIl);
                    this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.WEST), 11, 3, lllllllllllllIlIIIIIlllIlllIIIlI, lllllllllllllIlIIIIIlllIllIllIIl);
                    if (this.isLargeRoom) {
                        this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 1, 6, lllllllllllllIlIIIIIlllIlllIIIlI, 1, 9, lllllllllllllIlIIIIIlllIlllIIIlI, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                        this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 12, 6, lllllllllllllIlIIIIIlllIlllIIIlI, 12, 9, lllllllllllllIlIIIIIlllIlllIIIlI, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                    }
                }
                else {
                    this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 1, 1, lllllllllllllIlIIIIIlllIlllIIIlI, 1, 4, lllllllllllllIlIIIIIlllIlllIIIlI, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                    this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 12, 1, lllllllllllllIlIIIIIlllIlllIIIlI, 12, 4, lllllllllllllIlIIIIIlllIlllIIIlI, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                    if (this.isLargeRoom) {
                        this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 1, 6, lllllllllllllIlIIIIIlllIlllIIIlI, 1, 9, lllllllllllllIlIIIIIlllIlllIIIlI, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                        this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 12, 6, lllllllllllllIlIIIIIlllIlllIIIlI, 12, 9, lllllllllllllIlIIIIIlllIlllIIIlI, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                    }
                }
            }
            for (int lllllllllllllIlIIIIIlllIlllIIIIl = 3; lllllllllllllIlIIIIIlllIlllIIIIl < 12; lllllllllllllIlIIIIIlllIlllIIIIl += 2) {
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 3, 1, lllllllllllllIlIIIIIlllIlllIIIIl, 4, 3, lllllllllllllIlIIIIIlllIlllIIIIl, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 6, 1, lllllllllllllIlIIIIIlllIlllIIIIl, 7, 3, lllllllllllllIlIIIIIlllIlllIIIIl, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 9, 1, lllllllllllllIlIIIIIlllIlllIIIIl, 10, 3, lllllllllllllIlIIIIIlllIlllIIIIl, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
            }
            if (this.isLargeRoom) {
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 1, 5, 1, 3, 5, 13, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 10, 5, 1, 12, 5, 13, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 4, 5, 1, 9, 5, 2, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 4, 5, 12, 9, 5, 13, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.PLANKS.getDefaultState(), 9, 5, 11, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.PLANKS.getDefaultState(), 8, 5, 11, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.PLANKS.getDefaultState(), 9, 5, 10, lllllllllllllIlIIIIIlllIllIllIIl);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 3, 6, 2, 3, 6, 12, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 10, 6, 2, 10, 6, 10, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 4, 6, 2, 9, 6, 2, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
                this.fillWithBlocks(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, 4, 6, 12, 8, 6, 12, Blocks.OAK_FENCE.getDefaultState(), Blocks.OAK_FENCE.getDefaultState(), false);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 9, 6, 11, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 8, 6, 11, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 9, 6, 10, lllllllllllllIlIIIIIlllIllIllIIl);
                final IBlockState lllllllllllllIlIIIIIlllIlllIIIII = Blocks.LADDER.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.SOUTH);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIlllIIIII, 10, 1, 13, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIlllIIIII, 10, 2, 13, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIlllIIIII, 10, 3, 13, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIlllIIIII, 10, 4, 13, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIlllIIIII, 10, 5, 13, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIlllIIIII, 10, 6, 13, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIlllIIIII, 10, 7, 13, lllllllllllllIlIIIIIlllIllIllIIl);
                final int lllllllllllllIlIIIIIlllIllIlllll = 7;
                final int lllllllllllllIlIIIIIlllIllIllllI = 7;
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 6, 9, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 7, 9, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 6, 8, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 7, 8, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 6, 7, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 7, 7, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 5, 7, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 8, 7, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 6, 7, 6, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 6, 7, 8, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 7, 7, 6, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.OAK_FENCE.getDefaultState(), 7, 7, 8, lllllllllllllIlIIIIIlllIllIllIIl);
                final IBlockState lllllllllllllIlIIIIIlllIllIlllIl = Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.UP);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIlllIl, 5, 8, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIlllIl, 8, 8, 7, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIlllIl, 6, 8, 6, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIlllIl, 6, 8, 8, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIlllIl, 7, 8, 6, lllllllllllllIlIIIIIlllIllIllIIl);
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIlllIl, 7, 8, 8, lllllllllllllIlIIIIIlllIllIllIIl);
            }
            this.generateChest(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, lllllllllllllIlIIIIIlllIllIllIlI, 3, 3, 5, LootTableList.CHESTS_STRONGHOLD_LIBRARY);
            if (this.isLargeRoom) {
                this.setBlockState(lllllllllllllIlIIIIIlllIllIllIll, Blocks.AIR.getDefaultState(), 12, 9, 1, lllllllllllllIlIIIIIlllIllIllIIl);
                this.generateChest(lllllllllllllIlIIIIIlllIllIllIll, lllllllllllllIlIIIIIlllIllIllIIl, lllllllllllllIlIIIIIlllIllIllIlI, 12, 8, 1, LootTableList.CHESTS_STRONGHOLD_LIBRARY);
            }
            return true;
        }
        
        public Library() {
        }
        
        public static Library createPiece(final List<StructureComponent> lllllllllllllIlIIIIIlllIllllllII, final Random lllllllllllllIlIIIIIlllIlllllIll, final int lllllllllllllIlIIIIIllllIIIIIIlI, final int lllllllllllllIlIIIIIllllIIIIIIIl, final int lllllllllllllIlIIIIIlllIlllllIII, final EnumFacing lllllllllllllIlIIIIIlllIllllllll, final int lllllllllllllIlIIIIIlllIllllIllI) {
            StructureBoundingBox lllllllllllllIlIIIIIlllIllllllIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIlIIIIIllllIIIIIIlI, lllllllllllllIlIIIIIllllIIIIIIIl, lllllllllllllIlIIIIIlllIlllllIII, -4, -1, 0, 14, 11, 15, lllllllllllllIlIIIIIlllIllllllll);
            if (!Stronghold.canStrongholdGoDeeper(lllllllllllllIlIIIIIlllIllllllIl) || StructureComponent.findIntersecting(lllllllllllllIlIIIIIlllIllllllII, lllllllllllllIlIIIIIlllIllllllIl) != null) {
                lllllllllllllIlIIIIIlllIllllllIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIlIIIIIllllIIIIIIlI, lllllllllllllIlIIIIIllllIIIIIIIl, lllllllllllllIlIIIIIlllIlllllIII, -4, -1, 0, 14, 6, 15, lllllllllllllIlIIIIIlllIllllllll);
                if (!Stronghold.canStrongholdGoDeeper(lllllllllllllIlIIIIIlllIllllllIl) || StructureComponent.findIntersecting(lllllllllllllIlIIIIIlllIllllllII, lllllllllllllIlIIIIIlllIllllllIl) != null) {
                    return null;
                }
            }
            return new Library(lllllllllllllIlIIIIIlllIllllIllI, lllllllllllllIlIIIIIlllIlllllIll, lllllllllllllIlIIIIIlllIllllllIl, lllllllllllllIlIIIIIlllIllllllll);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIlIIIIIllllIIIIlllI, final TemplateManager lllllllllllllIlIIIIIllllIIIlIIII) {
            super.readStructureFromNBT(lllllllllllllIlIIIIIllllIIIIlllI, lllllllllllllIlIIIIIllllIIIlIIII);
            this.isLargeRoom = lllllllllllllIlIIIIIllllIIIIlllI.getBoolean("Tall");
        }
        
        public Library(final int lllllllllllllIlIIIIIllllIIIlllll, final Random lllllllllllllIlIIIIIllllIIlIIIll, final StructureBoundingBox lllllllllllllIlIIIIIllllIIlIIIlI, final EnumFacing lllllllllllllIlIIIIIllllIIIlllII) {
            super(lllllllllllllIlIIIIIllllIIIlllll);
            this.setCoordBaseMode(lllllllllllllIlIIIIIllllIIIlllII);
            this.entryDoor = this.getRandomDoor(lllllllllllllIlIIIIIllllIIlIIIll);
            this.boundingBox = lllllllllllllIlIIIIIllllIIlIIIlI;
            this.isLargeRoom = (lllllllllllllIlIIIIIllllIIlIIIlI.getYSize() > 6);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIlIIIIIllllIIIllIII) {
            super.writeStructureToNBT(lllllllllllllIlIIIIIllllIIIllIII);
            lllllllllllllIlIIIIIllllIIIllIII.setBoolean("Tall", this.isLargeRoom);
        }
    }
    
    public static class Straight extends Stronghold
    {
        private /* synthetic */ boolean expandsZ;
        private /* synthetic */ boolean expandsX;
        
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIlllllIlIlIIIIllI, final List<StructureComponent> lllllllllllllllIlllllIlIlIIIlIIl, final Random lllllllllllllllIlllllIlIlIIIlIII) {
            this.getNextComponentNormal((Stairs2)lllllllllllllllIlllllIlIlIIIIllI, lllllllllllllllIlllllIlIlIIIlIIl, lllllllllllllllIlllllIlIlIIIlIII, 1, 1);
            if (this.expandsX) {
                this.getNextComponentX((Stairs2)lllllllllllllllIlllllIlIlIIIIllI, lllllllllllllllIlllllIlIlIIIlIIl, lllllllllllllllIlllllIlIlIIIlIII, 1, 2);
            }
            if (this.expandsZ) {
                this.getNextComponentZ((Stairs2)lllllllllllllllIlllllIlIlIIIIllI, lllllllllllllllIlllllIlIlIIIlIIl, lllllllllllllllIlllllIlIlIIIlIII, 1, 2);
            }
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlllllIlIIllIIlII, final Random lllllllllllllllIlllllIlIIlIlllIl, final StructureBoundingBox lllllllllllllllIlllllIlIIllIIIlI) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIllIIIlI)) {
                return false;
            }
            this.fillWithRandomizedBlocks(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIllIIIlI, 0, 0, 0, 4, 4, 6, true, lllllllllllllllIlllllIlIIlIlllIl, StructureStrongholdPieces.STRONGHOLD_STONES);
            this.placeDoor(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIlIlllIl, lllllllllllllllIlllllIlIIllIIIlI, this.entryDoor, 1, 1, 0);
            this.placeDoor(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIlIlllIl, lllllllllllllllIlllllIlIIllIIIlI, Door.OPENING, 1, 1, 6);
            final IBlockState lllllllllllllllIlllllIlIIllIIIIl = Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.EAST);
            final IBlockState lllllllllllllllIlllllIlIIllIIIII = Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, EnumFacing.WEST);
            this.randomlyPlaceBlock(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIllIIIlI, lllllllllllllllIlllllIlIIlIlllIl, 0.1f, 1, 2, 1, lllllllllllllllIlllllIlIIllIIIIl);
            this.randomlyPlaceBlock(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIllIIIlI, lllllllllllllllIlllllIlIIlIlllIl, 0.1f, 3, 2, 1, lllllllllllllllIlllllIlIIllIIIII);
            this.randomlyPlaceBlock(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIllIIIlI, lllllllllllllllIlllllIlIIlIlllIl, 0.1f, 1, 2, 5, lllllllllllllllIlllllIlIIllIIIIl);
            this.randomlyPlaceBlock(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIllIIIlI, lllllllllllllllIlllllIlIIlIlllIl, 0.1f, 3, 2, 5, lllllllllllllllIlllllIlIIllIIIII);
            if (this.expandsX) {
                this.fillWithBlocks(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIllIIIlI, 0, 1, 2, 0, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            if (this.expandsZ) {
                this.fillWithBlocks(lllllllllllllllIlllllIlIIllIIlII, lllllllllllllllIlllllIlIIllIIIlI, 4, 1, 2, 4, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIlllllIlIlIIlIIIl, final TemplateManager lllllllllllllllIlllllIlIlIIlIIII) {
            super.readStructureFromNBT(lllllllllllllllIlllllIlIlIIlIIIl, lllllllllllllllIlllllIlIlIIlIIII);
            this.expandsX = lllllllllllllllIlllllIlIlIIlIIIl.getBoolean("Left");
            this.expandsZ = lllllllllllllllIlllllIlIlIIlIIIl.getBoolean("Right");
        }
        
        public Straight(final int lllllllllllllllIlllllIlIlIlIIIlI, final Random lllllllllllllllIlllllIlIlIlIIIIl, final StructureBoundingBox lllllllllllllllIlllllIlIlIlIIIII, final EnumFacing lllllllllllllllIlllllIlIlIIlllll) {
            super(lllllllllllllllIlllllIlIlIlIIIlI);
            this.setCoordBaseMode(lllllllllllllllIlllllIlIlIIlllll);
            this.entryDoor = this.getRandomDoor(lllllllllllllllIlllllIlIlIlIIIIl);
            this.boundingBox = lllllllllllllllIlllllIlIlIlIIIII;
            this.expandsX = (lllllllllllllllIlllllIlIlIlIIIIl.nextInt(2) == 0);
            this.expandsZ = (lllllllllllllllIlllllIlIlIlIIIIl.nextInt(2) == 0);
        }
        
        public static Straight createPiece(final List<StructureComponent> lllllllllllllllIlllllIlIIllllIll, final Random lllllllllllllllIlllllIlIIlllIIlI, final int lllllllllllllllIlllllIlIIlllIIIl, final int lllllllllllllllIlllllIlIIlllIIII, final int lllllllllllllllIlllllIlIIllIllll, final EnumFacing lllllllllllllllIlllllIlIIllIlllI, final int lllllllllllllllIlllllIlIIlllIlIl) {
            final StructureBoundingBox lllllllllllllllIlllllIlIIlllIlII = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllIlllllIlIIlllIIIl, lllllllllllllllIlllllIlIIlllIIII, lllllllllllllllIlllllIlIIllIllll, -1, -1, 0, 5, 5, 7, lllllllllllllllIlllllIlIIllIlllI);
            return (Stronghold.canStrongholdGoDeeper(lllllllllllllllIlllllIlIIlllIlII) && StructureComponent.findIntersecting(lllllllllllllllIlllllIlIIllllIll, lllllllllllllllIlllllIlIIlllIlII) == null) ? new Straight(lllllllllllllllIlllllIlIIlllIlIl, lllllllllllllllIlllllIlIIlllIIlI, lllllllllllllllIlllllIlIIlllIlII, lllllllllllllllIlllllIlIIllIlllI) : null;
        }
        
        public Straight() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIlllllIlIlIIllIIl) {
            super.writeStructureToNBT(lllllllllllllllIlllllIlIlIIllIIl);
            lllllllllllllllIlllllIlIlIIllIIl.setBoolean("Left", this.expandsX);
            lllllllllllllllIlllllIlIlIIllIIl.setBoolean("Right", this.expandsZ);
        }
    }
    
    public static class Corridor extends Stronghold
    {
        private /* synthetic */ int steps;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllllIlIIlIllllIlIIl, final TemplateManager lllllllllllllllllIlIIlIllllIlIII) {
            super.readStructureFromNBT(lllllllllllllllllIlIIlIllllIlIIl, lllllllllllllllllIlIIlIllllIlIII);
            this.steps = lllllllllllllllllIlIIlIllllIlIIl.getInteger("Steps");
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllllIlIIlIllllIlllI) {
            super.writeStructureToNBT(lllllllllllllllllIlIIlIllllIlllI);
            lllllllllllllllllIlIIlIllllIlllI.setInteger("Steps", this.steps);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllIlIIlIllIllllII, final Random lllllllllllllllllIlIIlIlllIIIIIl, final StructureBoundingBox lllllllllllllllllIlIIlIlllIIIIII) {
            if (this.isLiquidInStructureBoundingBox(lllllllllllllllllIlIIlIllIllllII, lllllllllllllllllIlIIlIlllIIIIII)) {
                return false;
            }
            for (int lllllllllllllllllIlIIlIllIllllll = 0; lllllllllllllllllIlIIlIllIllllll < this.steps; ++lllllllllllllllllIlIIlIllIllllll) {
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 0, 0, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 1, 0, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 2, 0, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 3, 0, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 4, 0, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                for (int lllllllllllllllllIlIIlIllIlllllI = 1; lllllllllllllllllIlIIlIllIlllllI <= 3; ++lllllllllllllllllIlIIlIllIlllllI) {
                    this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 0, lllllllllllllllllIlIIlIllIlllllI, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                    this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.AIR.getDefaultState(), 1, lllllllllllllllllIlIIlIllIlllllI, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                    this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.AIR.getDefaultState(), 2, lllllllllllllllllIlIIlIllIlllllI, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                    this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.AIR.getDefaultState(), 3, lllllllllllllllllIlIIlIllIlllllI, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                    this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 4, lllllllllllllllllIlIIlIllIlllllI, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                }
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 0, 4, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 1, 4, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 2, 4, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 3, 4, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
                this.setBlockState(lllllllllllllllllIlIIlIllIllllII, Blocks.STONEBRICK.getDefaultState(), 4, 4, lllllllllllllllllIlIIlIllIllllll, lllllllllllllllllIlIIlIlllIIIIII);
            }
            return true;
        }
        
        public static StructureBoundingBox findPieceBox(final List<StructureComponent> lllllllllllllllllIlIIlIlllIllIll, final Random lllllllllllllllllIlIIlIlllIllIlI, final int lllllllllllllllllIlIIlIlllIlIIII, final int lllllllllllllllllIlIIlIlllIIllll, final int lllllllllllllllllIlIIlIlllIIlllI, final EnumFacing lllllllllllllllllIlIIlIlllIIllIl) {
            final int lllllllllllllllllIlIIlIlllIlIlIl = 3;
            StructureBoundingBox lllllllllllllllllIlIIlIlllIlIlII = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllllIlIIlIlllIlIIII, lllllllllllllllllIlIIlIlllIIllll, lllllllllllllllllIlIIlIlllIIlllI, -1, -1, 0, 5, 5, 4, lllllllllllllllllIlIIlIlllIIllIl);
            final StructureComponent lllllllllllllllllIlIIlIlllIlIIll = StructureComponent.findIntersecting(lllllllllllllllllIlIIlIlllIllIll, lllllllllllllllllIlIIlIlllIlIlII);
            if (lllllllllllllllllIlIIlIlllIlIIll == null) {
                return null;
            }
            if (lllllllllllllllllIlIIlIlllIlIIll.getBoundingBox().minY == lllllllllllllllllIlIIlIlllIlIlII.minY) {
                for (int lllllllllllllllllIlIIlIlllIlIIlI = 3; lllllllllllllllllIlIIlIlllIlIIlI >= 1; --lllllllllllllllllIlIIlIlllIlIIlI) {
                    lllllllllllllllllIlIIlIlllIlIlII = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllllIlIIlIlllIlIIII, lllllllllllllllllIlIIlIlllIIllll, lllllllllllllllllIlIIlIlllIIlllI, -1, -1, 0, 5, 5, lllllllllllllllllIlIIlIlllIlIIlI - 1, lllllllllllllllllIlIIlIlllIIllIl);
                    if (!lllllllllllllllllIlIIlIlllIlIIll.getBoundingBox().intersectsWith(lllllllllllllllllIlIIlIlllIlIlII)) {
                        return StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllllIlIIlIlllIlIIII, lllllllllllllllllIlIIlIlllIIllll, lllllllllllllllllIlIIlIlllIIlllI, -1, -1, 0, 5, 5, lllllllllllllllllIlIIlIlllIlIIlI, lllllllllllllllllIlIIlIlllIIllIl);
                    }
                }
            }
            return null;
        }
        
        public Corridor(final int lllllllllllllllllIlIIlIllllllIll, final Random lllllllllllllllllIlIIlIllllllIlI, final StructureBoundingBox lllllllllllllllllIlIIlIllllllIIl, final EnumFacing lllllllllllllllllIlIIlIlllllIlII) {
            super(lllllllllllllllllIlIIlIllllllIll);
            this.setCoordBaseMode(lllllllllllllllllIlIIlIlllllIlII);
            this.boundingBox = lllllllllllllllllIlIIlIllllllIIl;
            this.steps = ((lllllllllllllllllIlIIlIlllllIlII != EnumFacing.NORTH && lllllllllllllllllIlIIlIlllllIlII != EnumFacing.SOUTH) ? lllllllllllllllllIlIIlIllllllIIl.getXSize() : lllllllllllllllllIlIIlIllllllIIl.getZSize());
        }
        
        public Corridor() {
        }
    }
}
