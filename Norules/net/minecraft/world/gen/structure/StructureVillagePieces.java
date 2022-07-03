package net.minecraft.world.gen.structure;

import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class StructureVillagePieces
{
    private static int updatePieceWeight(final List<PieceWeight> llllllllllllllIIlIIIIllIlIlIlllI) {
        boolean llllllllllllllIIlIIIIllIlIlIllIl = false;
        int llllllllllllllIIlIIIIllIlIlIllII = 0;
        for (final PieceWeight llllllllllllllIIlIIIIllIlIlIlIll : llllllllllllllIIlIIIIllIlIlIlllI) {
            if (llllllllllllllIIlIIIIllIlIlIlIll.villagePiecesLimit > 0 && llllllllllllllIIlIIIIllIlIlIlIll.villagePiecesSpawned < llllllllllllllIIlIIIIllIlIlIlIll.villagePiecesLimit) {
                llllllllllllllIIlIIIIllIlIlIllIl = true;
            }
            llllllllllllllIIlIIIIllIlIlIllII += llllllllllllllIIlIIIIllIlIlIlIll.villagePieceWeight;
        }
        return llllllllllllllIIlIIIIllIlIlIllIl ? llllllllllllllIIlIIIIllIlIlIllII : -1;
    }
    
    private static StructureComponent generateAndAddRoadPiece(final Start llllllllllllllIIlIIIIllIIIlIlIll, final List<StructureComponent> llllllllllllllIIlIIIIllIIIlIlIlI, final Random llllllllllllllIIlIIIIllIIIllIIll, final int llllllllllllllIIlIIIIllIIIllIIlI, final int llllllllllllllIIlIIIIllIIIlIIlll, final int llllllllllllllIIlIIIIllIIIlIIllI, final EnumFacing llllllllllllllIIlIIIIllIIIlIllll, final int llllllllllllllIIlIIIIllIIIlIlllI) {
        if (llllllllllllllIIlIIIIllIIIlIlllI > 3 + llllllllllllllIIlIIIIllIIIlIlIll.terrainType) {
            return null;
        }
        if (Math.abs(llllllllllllllIIlIIIIllIIIllIIlI - llllllllllllllIIlIIIIllIIIlIlIll.getBoundingBox().minX) > 112 || Math.abs(llllllllllllllIIlIIIIllIIIlIIllI - llllllllllllllIIlIIIIllIIIlIlIll.getBoundingBox().minZ) > 112) {
            return null;
        }
        final StructureBoundingBox llllllllllllllIIlIIIIllIIIlIllIl = Path.findPieceBox(llllllllllllllIIlIIIIllIIIlIlIll, llllllllllllllIIlIIIIllIIIlIlIlI, llllllllllllllIIlIIIIllIIIllIIll, llllllllllllllIIlIIIIllIIIllIIlI, llllllllllllllIIlIIIIllIIIlIIlll, llllllllllllllIIlIIIIllIIIlIIllI, llllllllllllllIIlIIIIllIIIlIllll);
        if (llllllllllllllIIlIIIIllIIIlIllIl != null && llllllllllllllIIlIIIIllIIIlIllIl.minY > 10) {
            final StructureComponent llllllllllllllIIlIIIIllIIIlIllII = new Path(llllllllllllllIIlIIIIllIIIlIlIll, llllllllllllllIIlIIIIllIIIlIlllI, llllllllllllllIIlIIIIllIIIllIIll, llllllllllllllIIlIIIIllIIIlIllIl, llllllllllllllIIlIIIIllIIIlIllll);
            llllllllllllllIIlIIIIllIIIlIlIlI.add(llllllllllllllIIlIIIIllIIIlIllII);
            llllllllllllllIIlIIIIllIIIlIlIll.pendingRoads.add(llllllllllllllIIlIIIIllIIIlIllII);
            return llllllllllllllIIlIIIIllIIIlIllII;
        }
        return null;
    }
    
    private static Village findAndCreateComponentFactory(final Start llllllllllllllIIlIIIIllIlIIllIlI, final PieceWeight llllllllllllllIIlIIIIllIlIIllIIl, final List<StructureComponent> llllllllllllllIIlIIIIllIlIIIllIl, final Random llllllllllllllIIlIIIIllIlIIlIlll, final int llllllllllllllIIlIIIIllIlIIIlIll, final int llllllllllllllIIlIIIIllIlIIIlIlI, final int llllllllllllllIIlIIIIllIlIIIlIIl, final EnumFacing llllllllllllllIIlIIIIllIlIIlIIll, final int llllllllllllllIIlIIIIllIlIIlIIlI) {
        final Class<? extends Village> llllllllllllllIIlIIIIllIlIIlIIIl = llllllllllllllIIlIIIIllIlIIllIIl.villagePieceClass;
        Village llllllllllllllIIlIIIIllIlIIlIIII = null;
        if (llllllllllllllIIlIIIIllIlIIlIIIl == House4Garden.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = House4Garden.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        else if (llllllllllllllIIlIIIIllIlIIlIIIl == Church.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = Church.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        else if (llllllllllllllIIlIIIIllIlIIlIIIl == House1.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = House1.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        else if (llllllllllllllIIlIIIIllIlIIlIIIl == WoodHut.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = WoodHut.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        else if (llllllllllllllIIlIIIIllIlIIlIIIl == Hall.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = Hall.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        else if (llllllllllllllIIlIIIIllIlIIlIIIl == Field1.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = Field1.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        else if (llllllllllllllIIlIIIIllIlIIlIIIl == Field2.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = Field2.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        else if (llllllllllllllIIlIIIIllIlIIlIIIl == House2.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = House2.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        else if (llllllllllllllIIlIIIIllIlIIlIIIl == House3.class) {
            llllllllllllllIIlIIIIllIlIIlIIII = House3.createPiece(llllllllllllllIIlIIIIllIlIIllIlI, llllllllllllllIIlIIIIllIlIIIllIl, llllllllllllllIIlIIIIllIlIIlIlll, llllllllllllllIIlIIIIllIlIIIlIll, llllllllllllllIIlIIIIllIlIIIlIlI, llllllllllllllIIlIIIIllIlIIIlIIl, llllllllllllllIIlIIIIllIlIIlIIll, llllllllllllllIIlIIIIllIlIIlIIlI);
        }
        return llllllllllllllIIlIIIIllIlIIlIIII;
    }
    
    public static void registerVillagePieces() {
        MapGenStructureIO.registerStructureComponent(House1.class, "ViBH");
        MapGenStructureIO.registerStructureComponent(Field1.class, "ViDF");
        MapGenStructureIO.registerStructureComponent(Field2.class, "ViF");
        MapGenStructureIO.registerStructureComponent(Torch.class, "ViL");
        MapGenStructureIO.registerStructureComponent(Hall.class, "ViPH");
        MapGenStructureIO.registerStructureComponent(House4Garden.class, "ViSH");
        MapGenStructureIO.registerStructureComponent(WoodHut.class, "ViSmH");
        MapGenStructureIO.registerStructureComponent(Church.class, "ViST");
        MapGenStructureIO.registerStructureComponent(House2.class, "ViS");
        MapGenStructureIO.registerStructureComponent(Start.class, "ViStart");
        MapGenStructureIO.registerStructureComponent(Path.class, "ViSR");
        MapGenStructureIO.registerStructureComponent(House3.class, "ViTRH");
        MapGenStructureIO.registerStructureComponent(Well.class, "ViW");
    }
    
    private static Village generateComponent(final Start llllllllllllllIIlIIIIllIIlllIllI, final List<StructureComponent> llllllllllllllIIlIIIIllIIllIIlll, final Random llllllllllllllIIlIIIIllIIlllIlII, final int llllllllllllllIIlIIIIllIIllIIlIl, final int llllllllllllllIIlIIIIllIIlllIIlI, final int llllllllllllllIIlIIIIllIIlllIIIl, final EnumFacing llllllllllllllIIlIIIIllIIlllIIII, final int llllllllllllllIIlIIIIllIIllIIIIl) {
        final int llllllllllllllIIlIIIIllIIllIlllI = updatePieceWeight(llllllllllllllIIlIIIIllIIlllIllI.structureVillageWeightedPieceList);
        if (llllllllllllllIIlIIIIllIIllIlllI <= 0) {
            return null;
        }
        int llllllllllllllIIlIIIIllIIllIllIl = 0;
        while (llllllllllllllIIlIIIIllIIllIllIl < 5) {
            ++llllllllllllllIIlIIIIllIIllIllIl;
            int llllllllllllllIIlIIIIllIIllIllII = llllllllllllllIIlIIIIllIIlllIlII.nextInt(llllllllllllllIIlIIIIllIIllIlllI);
            for (final PieceWeight llllllllllllllIIlIIIIllIIllIlIll : llllllllllllllIIlIIIIllIIlllIllI.structureVillageWeightedPieceList) {
                llllllllllllllIIlIIIIllIIllIllII -= llllllllllllllIIlIIIIllIIllIlIll.villagePieceWeight;
                if (llllllllllllllIIlIIIIllIIllIllII < 0) {
                    if (!llllllllllllllIIlIIIIllIIllIlIll.canSpawnMoreVillagePiecesOfType(llllllllllllllIIlIIIIllIIllIIIIl)) {
                        break;
                    }
                    if (llllllllllllllIIlIIIIllIIllIlIll == llllllllllllllIIlIIIIllIIlllIllI.structVillagePieceWeight && llllllllllllllIIlIIIIllIIlllIllI.structureVillageWeightedPieceList.size() > 1) {
                        break;
                    }
                    final Village llllllllllllllIIlIIIIllIIllIlIlI = findAndCreateComponentFactory(llllllllllllllIIlIIIIllIIlllIllI, llllllllllllllIIlIIIIllIIllIlIll, llllllllllllllIIlIIIIllIIllIIlll, llllllllllllllIIlIIIIllIIlllIlII, llllllllllllllIIlIIIIllIIllIIlIl, llllllllllllllIIlIIIIllIIlllIIlI, llllllllllllllIIlIIIIllIIlllIIIl, llllllllllllllIIlIIIIllIIlllIIII, llllllllllllllIIlIIIIllIIllIIIIl);
                    if (llllllllllllllIIlIIIIllIIllIlIlI != null) {
                        final PieceWeight pieceWeight = llllllllllllllIIlIIIIllIIllIlIll;
                        ++pieceWeight.villagePiecesSpawned;
                        llllllllllllllIIlIIIIllIIlllIllI.structVillagePieceWeight = llllllllllllllIIlIIIIllIIllIlIll;
                        if (!llllllllllllllIIlIIIIllIIllIlIll.canSpawnMoreVillagePieces()) {
                            llllllllllllllIIlIIIIllIIlllIllI.structureVillageWeightedPieceList.remove(llllllllllllllIIlIIIIllIIllIlIll);
                        }
                        return llllllllllllllIIlIIIIllIIllIlIlI;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox llllllllllllllIIlIIIIllIIllIlIIl = Torch.findPieceBox(llllllllllllllIIlIIIIllIIlllIllI, llllllllllllllIIlIIIIllIIllIIlll, llllllllllllllIIlIIIIllIIlllIlII, llllllllllllllIIlIIIIllIIllIIlIl, llllllllllllllIIlIIIIllIIlllIIlI, llllllllllllllIIlIIIIllIIlllIIIl, llllllllllllllIIlIIIIllIIlllIIII);
        if (llllllllllllllIIlIIIIllIIllIlIIl != null) {
            return new Torch(llllllllllllllIIlIIIIllIIlllIllI, llllllllllllllIIlIIIIllIIllIIIIl, llllllllllllllIIlIIIIllIIlllIlII, llllllllllllllIIlIIIIllIIllIlIIl, llllllllllllllIIlIIIIllIIlllIIII);
        }
        return null;
    }
    
    private static StructureComponent generateAndAddComponent(final Start llllllllllllllIIlIIIIllIIlIlIIIl, final List<StructureComponent> llllllllllllllIIlIIIIllIIlIIIlll, final Random llllllllllllllIIlIIIIllIIlIIIllI, final int llllllllllllllIIlIIIIllIIlIIIlIl, final int llllllllllllllIIlIIIIllIIlIIIlII, final int llllllllllllllIIlIIIIllIIlIIIIll, final EnumFacing llllllllllllllIIlIIIIllIIlIIlIll, final int llllllllllllllIIlIIIIllIIlIIIIIl) {
        if (llllllllllllllIIlIIIIllIIlIIIIIl > 50) {
            return null;
        }
        if (Math.abs(llllllllllllllIIlIIIIllIIlIIIlIl - llllllllllllllIIlIIIIllIIlIlIIIl.getBoundingBox().minX) > 112 || Math.abs(llllllllllllllIIlIIIIllIIlIIIIll - llllllllllllllIIlIIIIllIIlIlIIIl.getBoundingBox().minZ) > 112) {
            return null;
        }
        final StructureComponent llllllllllllllIIlIIIIllIIlIIlIIl = generateComponent(llllllllllllllIIlIIIIllIIlIlIIIl, llllllllllllllIIlIIIIllIIlIIIlll, llllllllllllllIIlIIIIllIIlIIIllI, llllllllllllllIIlIIIIllIIlIIIlIl, llllllllllllllIIlIIIIllIIlIIIlII, llllllllllllllIIlIIIIllIIlIIIIll, llllllllllllllIIlIIIIllIIlIIlIll, llllllllllllllIIlIIIIllIIlIIIIIl + 1);
        if (llllllllllllllIIlIIIIllIIlIIlIIl != null) {
            llllllllllllllIIlIIIIllIIlIIIlll.add(llllllllllllllIIlIIIIllIIlIIlIIl);
            llllllllllllllIIlIIIIllIIlIlIIIl.pendingHouses.add(llllllllllllllIIlIIIIllIIlIIlIIl);
            return llllllllllllllIIlIIIIllIIlIIlIIl;
        }
        return null;
    }
    
    public static List<PieceWeight> getStructureVillageWeightedPieceList(final Random llllllllllllllIIlIIIIllIlIlllIll, final int llllllllllllllIIlIIIIllIlIlllIlI) {
        final List<PieceWeight> llllllllllllllIIlIIIIllIlIlllIIl = (List<PieceWeight>)Lists.newArrayList();
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(House4Garden.class, 4, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 2 + llllllllllllllIIlIIIIllIlIlllIlI, 4 + llllllllllllllIIlIIIIllIlIlllIlI * 2)));
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(Church.class, 20, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 0 + llllllllllllllIIlIIIIllIlIlllIlI, 1 + llllllllllllllIIlIIIIllIlIlllIlI)));
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(House1.class, 20, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 0 + llllllllllllllIIlIIIIllIlIlllIlI, 2 + llllllllllllllIIlIIIIllIlIlllIlI)));
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(WoodHut.class, 3, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 2 + llllllllllllllIIlIIIIllIlIlllIlI, 5 + llllllllllllllIIlIIIIllIlIlllIlI * 3)));
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(Hall.class, 15, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 0 + llllllllllllllIIlIIIIllIlIlllIlI, 2 + llllllllllllllIIlIIIIllIlIlllIlI)));
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(Field1.class, 3, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 1 + llllllllllllllIIlIIIIllIlIlllIlI, 4 + llllllllllllllIIlIIIIllIlIlllIlI)));
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(Field2.class, 3, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 2 + llllllllllllllIIlIIIIllIlIlllIlI, 4 + llllllllllllllIIlIIIIllIlIlllIlI * 2)));
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(House2.class, 15, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 0, 1 + llllllllllllllIIlIIIIllIlIlllIlI)));
        llllllllllllllIIlIIIIllIlIlllIIl.add(new PieceWeight(House3.class, 8, MathHelper.getInt(llllllllllllllIIlIIIIllIlIlllIll, 0 + llllllllllllllIIlIIIIllIlIlllIlI, 3 + llllllllllllllIIlIIIIllIlIlllIlI * 2)));
        final Iterator<PieceWeight> llllllllllllllIIlIIIIllIlIlllIII = llllllllllllllIIlIIIIllIlIlllIIl.iterator();
        while (llllllllllllllIIlIIIIllIlIlllIII.hasNext()) {
            if (llllllllllllllIIlIIIIllIlIlllIII.next().villagePiecesLimit == 0) {
                llllllllllllllIIlIIIIllIlIlllIII.remove();
            }
        }
        return llllllllllllllIIlIIIIllIlIlllIIl;
    }
    
    public static class Start extends Well
    {
        public /* synthetic */ PieceWeight structVillagePieceWeight;
        public /* synthetic */ List<PieceWeight> structureVillageWeightedPieceList;
        public /* synthetic */ BiomeProvider worldChunkMngr;
        public /* synthetic */ List<StructureComponent> pendingRoads;
        public /* synthetic */ int terrainType;
        public /* synthetic */ List<StructureComponent> pendingHouses;
        
        public Start() {
            this.pendingHouses = (List<StructureComponent>)Lists.newArrayList();
            this.pendingRoads = (List<StructureComponent>)Lists.newArrayList();
        }
        
        public Start(final BiomeProvider lllllllllllllIlIIllIIIllllllIIlI, final int lllllllllllllIlIIllIIIllllllIIIl, final Random lllllllllllllIlIIllIIIllllllIIII, final int lllllllllllllIlIIllIIIlllllIIlll, final int lllllllllllllIlIIllIIIlllllIIllI, final List<PieceWeight> lllllllllllllIlIIllIIIlllllIllIl, final int lllllllllllllIlIIllIIIlllllIIlII) {
            super(null, 0, lllllllllllllIlIIllIIIllllllIIII, lllllllllllllIlIIllIIIlllllIIlll, lllllllllllllIlIIllIIIlllllIIllI);
            this.pendingHouses = (List<StructureComponent>)Lists.newArrayList();
            this.pendingRoads = (List<StructureComponent>)Lists.newArrayList();
            this.worldChunkMngr = lllllllllllllIlIIllIIIllllllIIlI;
            this.structureVillageWeightedPieceList = lllllllllllllIlIIllIIIlllllIllIl;
            this.terrainType = lllllllllllllIlIIllIIIlllllIIlII;
            final Biome lllllllllllllIlIIllIIIlllllIlIll = lllllllllllllIlIIllIIIllllllIIlI.getBiome(new BlockPos(lllllllllllllIlIIllIIIlllllIIlll, 0, lllllllllllllIlIIllIIIlllllIIllI), Biomes.DEFAULT);
            if (lllllllllllllIlIIllIIIlllllIlIll instanceof BiomeDesert) {
                this.structureType = 1;
            }
            else if (lllllllllllllIlIIllIIIlllllIlIll instanceof BiomeSavanna) {
                this.structureType = 2;
            }
            else if (lllllllllllllIlIIllIIIlllllIlIll instanceof BiomeTaiga) {
                this.structureType = 3;
            }
            this.func_189924_a(this.structureType);
            this.isZombieInfested = (lllllllllllllIlIIllIIIllllllIIII.nextInt(50) == 0);
        }
    }
    
    public static class Well extends Village
    {
        @Override
        public void buildComponent(final StructureComponent lllllllllllllllIIIllIlIlIllIllII, final List<StructureComponent> lllllllllllllllIIIllIlIlIllIlIll, final Random lllllllllllllllIIIllIlIlIllIlllI) {
            generateAndAddRoadPiece((Start)lllllllllllllllIIIllIlIlIllIllII, lllllllllllllllIIIllIlIlIllIlIll, lllllllllllllllIIIllIlIlIllIlllI, this.boundingBox.minX - 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.WEST, this.getComponentType());
            generateAndAddRoadPiece((Start)lllllllllllllllIIIllIlIlIllIllII, lllllllllllllllIIIllIlIlIllIlIll, lllllllllllllllIIIllIlIlIllIlllI, this.boundingBox.maxX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.EAST, this.getComponentType());
            generateAndAddRoadPiece((Start)lllllllllllllllIIIllIlIlIllIllII, lllllllllllllllIIIllIlIlIllIlIll, lllllllllllllllIIIllIlIlIllIlllI, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
            generateAndAddRoadPiece((Start)lllllllllllllllIIIllIlIlIllIllII, lllllllllllllllIIIllIlIlIllIlIll, lllllllllllllllIIIllIlIlIllIlllI, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIIIllIlIlIllIIIIl, final Random lllllllllllllllIIIllIlIlIllIIIII, final StructureBoundingBox lllllllllllllllIIIllIlIlIlIlllll) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllll);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 3, 0);
            }
            final IBlockState lllllllllllllllIIIllIlIlIlIllllI = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllllllIIIllIlIlIlIlllIl = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllll, 1, 0, 1, 4, 12, 4, lllllllllllllllIIIllIlIlIlIllllI, Blocks.FLOWING_WATER.getDefaultState(), false);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, Blocks.AIR.getDefaultState(), 2, 12, 2, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, Blocks.AIR.getDefaultState(), 3, 12, 2, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, Blocks.AIR.getDefaultState(), 2, 12, 3, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, Blocks.AIR.getDefaultState(), 3, 12, 3, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllIl, 1, 13, 1, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllIl, 1, 14, 1, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllIl, 4, 13, 1, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllIl, 4, 14, 1, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllIl, 1, 13, 4, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllIl, 1, 14, 4, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllIl, 4, 13, 4, lllllllllllllllIIIllIlIlIlIlllll);
            this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllIl, 4, 14, 4, lllllllllllllllIIIllIlIlIlIlllll);
            this.fillWithBlocks(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIlllll, 1, 15, 1, 4, 15, 4, lllllllllllllllIIIllIlIlIlIllllI, lllllllllllllllIIIllIlIlIlIllllI, false);
            for (int lllllllllllllllIIIllIlIlIlIlllII = 0; lllllllllllllllIIIllIlIlIlIlllII <= 5; ++lllllllllllllllIIIllIlIlIlIlllII) {
                for (int lllllllllllllllIIIllIlIlIlIllIll = 0; lllllllllllllllIIIllIlIlIlIllIll <= 5; ++lllllllllllllllIIIllIlIlIlIllIll) {
                    if (lllllllllllllllIIIllIlIlIlIllIll == 0 || lllllllllllllllIIIllIlIlIlIllIll == 5 || lllllllllllllllIIIllIlIlIlIlllII == 0 || lllllllllllllllIIIllIlIlIlIlllII == 5) {
                        this.setBlockState(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIllllI, lllllllllllllllIIIllIlIlIlIllIll, 11, lllllllllllllllIIIllIlIlIlIlllII, lllllllllllllllIIIllIlIlIlIlllll);
                        this.clearCurrentPositionBlocksUpwards(lllllllllllllllIIIllIlIlIllIIIIl, lllllllllllllllIIIllIlIlIlIllIll, 12, lllllllllllllllIIIllIlIlIlIlllII, lllllllllllllllIIIllIlIlIlIlllll);
                    }
                }
            }
            return true;
        }
        
        public Well(final Start lllllllllllllllIIIllIlIlIllllIlI, final int lllllllllllllllIIIllIlIlIllllIIl, final Random lllllllllllllllIIIllIlIlIllllIII, final int lllllllllllllllIIIllIlIlIlllIlll, final int lllllllllllllllIIIllIlIlIlllIllI) {
            super(lllllllllllllllIIIllIlIlIllllIlI, lllllllllllllllIIIllIlIlIllllIIl);
            this.setCoordBaseMode(EnumFacing.Plane.HORIZONTAL.random(lllllllllllllllIIIllIlIlIllllIII));
            if (this.getCoordBaseMode().getAxis() == EnumFacing.Axis.Z) {
                this.boundingBox = new StructureBoundingBox(lllllllllllllllIIIllIlIlIlllIlll, 64, lllllllllllllllIIIllIlIlIlllIllI, lllllllllllllllIIIllIlIlIlllIlll + 6 - 1, 78, lllllllllllllllIIIllIlIlIlllIllI + 6 - 1);
            }
            else {
                this.boundingBox = new StructureBoundingBox(lllllllllllllllIIIllIlIlIlllIlll, 64, lllllllllllllllIIIllIlIlIlllIllI, lllllllllllllllIIIllIlIlIlllIlll + 6 - 1, 78, lllllllllllllllIIIllIlIlIlllIllI + 6 - 1);
            }
        }
        
        public Well() {
        }
    }
    
    abstract static class Village extends StructureComponent
    {
        protected /* synthetic */ int structureType;
        protected /* synthetic */ int averageGroundLvl;
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        private /* synthetic */ int villagersSpawned;
        protected /* synthetic */ boolean isZombieInfested;
        
        protected Village(final Start lllllllllllllIIllIlllIlllIIIlIIl, final int lllllllllllllIIllIlllIlllIIIlIII) {
            super(lllllllllllllIIllIlllIlllIIIlIII);
            this.averageGroundLvl = -1;
            if (lllllllllllllIIllIlllIlllIIIlIIl != null) {
                this.structureType = lllllllllllllIIllIlllIlllIIIlIIl.structureType;
                this.isZombieInfested = lllllllllllllIIllIlllIlllIIIlIIl.isZombieInfested;
            }
        }
        
        protected IBlockState getBiomeSpecificBlockState(final IBlockState lllllllllllllIIllIlllIllIIIIIllI) {
            if (this.structureType == 1) {
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.LOG || lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.LOG2) {
                    return Blocks.SANDSTONE.getDefaultState();
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.COBBLESTONE) {
                    return Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.DEFAULT.getMetadata());
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.PLANKS) {
                    return Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata());
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.OAK_STAIRS) {
                    return Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, (EnumFacing)lllllllllllllIIllIlllIllIIIIIllI.getValue((IProperty<V>)BlockStairs.FACING));
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.STONE_STAIRS) {
                    return Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, (EnumFacing)lllllllllllllIIllIlllIllIIIIIllI.getValue((IProperty<V>)BlockStairs.FACING));
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.GRAVEL) {
                    return Blocks.SANDSTONE.getDefaultState();
                }
            }
            else if (this.structureType == 3) {
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.LOG || lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.LOG2) {
                    return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLog.LOG_AXIS, (BlockLog.EnumAxis)lllllllllllllIIllIlllIllIIIIIllI.getValue((IProperty<V>)BlockLog.LOG_AXIS));
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.PLANKS) {
                    return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.OAK_STAIRS) {
                    return Blocks.SPRUCE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, (EnumFacing)lllllllllllllIIllIlllIllIIIIIllI.getValue((IProperty<V>)BlockStairs.FACING));
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.OAK_FENCE) {
                    return Blocks.SPRUCE_FENCE.getDefaultState();
                }
            }
            else if (this.structureType == 2) {
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.LOG || lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.LOG2) {
                    return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, (BlockLog.EnumAxis)lllllllllllllIIllIlllIllIIIIIllI.getValue((IProperty<V>)BlockLog.LOG_AXIS));
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.PLANKS) {
                    return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.OAK_STAIRS) {
                    return Blocks.ACACIA_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, (EnumFacing)lllllllllllllIIllIlllIllIIIIIllI.getValue((IProperty<V>)BlockStairs.FACING));
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.COBBLESTONE) {
                    return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y);
                }
                if (lllllllllllllIIllIlllIllIIIIIllI.getBlock() == Blocks.OAK_FENCE) {
                    return Blocks.ACACIA_FENCE.getDefaultState();
                }
            }
            return lllllllllllllIIllIlllIllIIIIIllI;
        }
        
        @Nullable
        protected StructureComponent getNextComponentPP(final Start lllllllllllllIIllIlllIllIlIlllIl, final List<StructureComponent> lllllllllllllIIllIlllIllIlIlllII, final Random lllllllllllllIIllIlllIllIlIlIlII, final int lllllllllllllIIllIlllIllIlIllIlI, final int lllllllllllllIIllIlllIllIlIlIIlI) {
            final EnumFacing lllllllllllllIIllIlllIllIlIllIII = this.getCoordBaseMode();
            if (lllllllllllllIIllIlllIllIlIllIII == null) {
                return null;
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIllIlllIllIlIllIII.ordinal()]) {
                default: {
                    return generateAndAddComponent(lllllllllllllIIllIlllIllIlIlllIl, lllllllllllllIIllIlllIllIlIlllII, lllllllllllllIIllIlllIllIlIlIlII, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllIIllIlllIllIlIllIlI, this.boundingBox.minZ + lllllllllllllIIllIlllIllIlIlIIlI, EnumFacing.EAST, this.getComponentType());
                }
                case 4: {
                    return generateAndAddComponent(lllllllllllllIIllIlllIllIlIlllIl, lllllllllllllIIllIlllIllIlIlllII, lllllllllllllIIllIlllIllIlIlIlII, this.boundingBox.maxX + 1, this.boundingBox.minY + lllllllllllllIIllIlllIllIlIllIlI, this.boundingBox.minZ + lllllllllllllIIllIlllIllIlIlIIlI, EnumFacing.EAST, this.getComponentType());
                }
                case 5: {
                    return generateAndAddComponent(lllllllllllllIIllIlllIllIlIlllIl, lllllllllllllIIllIlllIllIlIlllII, lllllllllllllIIllIlllIllIlIlIlII, this.boundingBox.minX + lllllllllllllIIllIlllIllIlIlIIlI, this.boundingBox.minY + lllllllllllllIIllIlllIllIlIllIlI, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                }
                case 6: {
                    return generateAndAddComponent(lllllllllllllIIllIlllIllIlIlllIl, lllllllllllllIIllIlllIllIlIlllII, lllllllllllllIIllIlllIllIlIlIlII, this.boundingBox.minX + lllllllllllllIIllIlllIllIlIlIIlI, this.boundingBox.minY + lllllllllllllIIllIlllIllIlIllIlI, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                }
            }
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Village.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final short lllllllllllllIIllIlllIlIlIlllIII = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllllIIllIlllIlIlIlllIII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIIllIlllIlIlIlllIII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIIllIlllIlIlIlllIII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIIllIlllIlIlIlllIII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIIllIlllIlIlIlllIII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIIllIlllIlIlIlllIII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Village.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIllIlllIlIlIlllIII;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIllIlllIllIllllIll, final TemplateManager lllllllllllllIIllIlllIllIlllllIl) {
            this.averageGroundLvl = lllllllllllllIIllIlllIllIllllIll.getInteger("HPos");
            this.villagersSpawned = lllllllllllllIIllIlllIllIllllIll.getInteger("VCount");
            this.structureType = lllllllllllllIIllIlllIllIllllIll.getByte("Type");
            if (lllllllllllllIIllIlllIllIllllIll.getBoolean("Desert")) {
                this.structureType = 1;
            }
            this.isZombieInfested = lllllllllllllIIllIlllIllIllllIll.getBoolean("Zombie");
        }
        
        @Override
        protected void replaceAirAndLiquidDownwards(final World lllllllllllllIIllIlllIlIllIIlllI, final IBlockState lllllllllllllIIllIlllIlIllIIllIl, final int lllllllllllllIIllIlllIlIllIIllII, final int lllllllllllllIIllIlllIlIllIIlIll, final int lllllllllllllIIllIlllIlIllIIIIlI, final StructureBoundingBox lllllllllllllIIllIlllIlIllIIIIIl) {
            final IBlockState lllllllllllllIIllIlllIlIllIIlIII = this.getBiomeSpecificBlockState(lllllllllllllIIllIlllIlIllIIllIl);
            super.replaceAirAndLiquidDownwards(lllllllllllllIIllIlllIlIllIIlllI, lllllllllllllIIllIlllIlIllIIlIII, lllllllllllllIIllIlllIlIllIIllII, lllllllllllllIIllIlllIlIllIIlIll, lllllllllllllIIllIlllIlIllIIIIlI, lllllllllllllIIllIlllIlIllIIIIIl);
        }
        
        @Nullable
        protected StructureComponent getNextComponentNN(final Start lllllllllllllIIllIlllIllIlllIIlI, final List<StructureComponent> lllllllllllllIIllIlllIllIllIlIlI, final Random lllllllllllllIIllIlllIllIllIlIIl, final int lllllllllllllIIllIlllIllIllIlIII, final int lllllllllllllIIllIlllIllIllIlllI) {
            final EnumFacing lllllllllllllIIllIlllIllIllIllIl = this.getCoordBaseMode();
            if (lllllllllllllIIllIlllIllIllIllIl == null) {
                return null;
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIllIlllIllIllIllIl.ordinal()]) {
                default: {
                    return generateAndAddComponent(lllllllllllllIIllIlllIllIlllIIlI, lllllllllllllIIllIlllIllIllIlIlI, lllllllllllllIIllIlllIllIllIlIIl, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllIIllIlllIllIllIlIII, this.boundingBox.minZ + lllllllllllllIIllIlllIllIllIlllI, EnumFacing.WEST, this.getComponentType());
                }
                case 4: {
                    return generateAndAddComponent(lllllllllllllIIllIlllIllIlllIIlI, lllllllllllllIIllIlllIllIllIlIlI, lllllllllllllIIllIlllIllIllIlIIl, this.boundingBox.minX - 1, this.boundingBox.minY + lllllllllllllIIllIlllIllIllIlIII, this.boundingBox.minZ + lllllllllllllIIllIlllIllIllIlllI, EnumFacing.WEST, this.getComponentType());
                }
                case 5: {
                    return generateAndAddComponent(lllllllllllllIIllIlllIllIlllIIlI, lllllllllllllIIllIlllIllIllIlIlI, lllllllllllllIIllIlllIllIllIlIIl, this.boundingBox.minX + lllllllllllllIIllIlllIllIllIlllI, this.boundingBox.minY + lllllllllllllIIllIlllIllIllIlIII, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                }
                case 6: {
                    return generateAndAddComponent(lllllllllllllIIllIlllIllIlllIIlI, lllllllllllllIIllIlllIllIllIlIlI, lllllllllllllIIllIlllIllIllIlIIl, this.boundingBox.minX + lllllllllllllIIllIlllIllIllIlllI, this.boundingBox.minY + lllllllllllllIIllIlllIllIllIlIII, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                }
            }
        }
        
        protected void func_189927_a(final World lllllllllllllIIllIlllIlIlllllIlI, final StructureBoundingBox lllllllllllllIIllIlllIlIlllllIIl, final Random lllllllllllllIIllIlllIlIllllIIII, final int lllllllllllllIIllIlllIlIllllIlll, final int lllllllllllllIIllIlllIlIllllIllI, final int lllllllllllllIIllIlllIlIlllIllIl, final EnumFacing lllllllllllllIIllIlllIlIllllIlII) {
            if (!this.isZombieInfested) {
                this.func_189915_a(lllllllllllllIIllIlllIlIlllllIlI, lllllllllllllIIllIlllIlIlllllIIl, lllllllllllllIIllIlllIlIllllIIII, lllllllllllllIIllIlllIlIllllIlll, lllllllllllllIIllIlllIlIllllIllI, lllllllllllllIIllIlllIlIlllIllIl, EnumFacing.NORTH, this.func_189925_i());
            }
        }
        
        protected void spawnVillagers(final World lllllllllllllIIllIlllIllIIIllIll, final StructureBoundingBox lllllllllllllIIllIlllIllIIlIIlll, final int lllllllllllllIIllIlllIllIIIllIIl, final int lllllllllllllIIllIlllIllIIIllIII, final int lllllllllllllIIllIlllIllIIIlIlll, final int lllllllllllllIIllIlllIllIIIlIllI) {
            if (this.villagersSpawned < lllllllllllllIIllIlllIllIIIlIllI) {
                for (int lllllllllllllIIllIlllIllIIlIIIlI = this.villagersSpawned; lllllllllllllIIllIlllIllIIlIIIlI < lllllllllllllIIllIlllIllIIIlIllI; ++lllllllllllllIIllIlllIllIIlIIIlI) {
                    final int lllllllllllllIIllIlllIllIIlIIIIl = this.getXWithOffset(lllllllllllllIIllIlllIllIIIllIIl + lllllllllllllIIllIlllIllIIlIIIlI, lllllllllllllIIllIlllIllIIIlIlll);
                    final int lllllllllllllIIllIlllIllIIlIIIII = this.getYWithOffset(lllllllllllllIIllIlllIllIIIllIII);
                    final int lllllllllllllIIllIlllIllIIIlllll = this.getZWithOffset(lllllllllllllIIllIlllIllIIIllIIl + lllllllllllllIIllIlllIllIIlIIIlI, lllllllllllllIIllIlllIllIIIlIlll);
                    if (!lllllllllllllIIllIlllIllIIlIIlll.isVecInside(new BlockPos(lllllllllllllIIllIlllIllIIlIIIIl, lllllllllllllIIllIlllIllIIlIIIII, lllllllllllllIIllIlllIllIIIlllll))) {
                        break;
                    }
                    ++this.villagersSpawned;
                    if (this.isZombieInfested) {
                        final EntityZombieVillager lllllllllllllIIllIlllIllIIIllllI = new EntityZombieVillager(lllllllllllllIIllIlllIllIIIllIll);
                        lllllllllllllIIllIlllIllIIIllllI.setLocationAndAngles(lllllllllllllIIllIlllIllIIlIIIIl + 0.5, lllllllllllllIIllIlllIllIIlIIIII, lllllllllllllIIllIlllIllIIIlllll + 0.5, 0.0f, 0.0f);
                        lllllllllllllIIllIlllIllIIIllllI.onInitialSpawn(lllllllllllllIIllIlllIllIIIllIll.getDifficultyForLocation(new BlockPos(lllllllllllllIIllIlllIllIIIllllI)), null);
                        lllllllllllllIIllIlllIllIIIllllI.func_190733_a(this.chooseProfession(lllllllllllllIIllIlllIllIIlIIIlI, 0));
                        lllllllllllllIIllIlllIllIIIllllI.enablePersistence();
                        lllllllllllllIIllIlllIllIIIllIll.spawnEntityInWorld(lllllllllllllIIllIlllIllIIIllllI);
                    }
                    else {
                        final EntityVillager lllllllllllllIIllIlllIllIIIlllIl = new EntityVillager(lllllllllllllIIllIlllIllIIIllIll);
                        lllllllllllllIIllIlllIllIIIlllIl.setLocationAndAngles(lllllllllllllIIllIlllIllIIlIIIIl + 0.5, lllllllllllllIIllIlllIllIIlIIIII, lllllllllllllIIllIlllIllIIIlllll + 0.5, 0.0f, 0.0f);
                        lllllllllllllIIllIlllIllIIIlllIl.setProfession(this.chooseProfession(lllllllllllllIIllIlllIllIIlIIIlI, lllllllllllllIIllIlllIllIIIllIll.rand.nextInt(6)));
                        lllllllllllllIIllIlllIllIIIlllIl.func_190672_a(lllllllllllllIIllIlllIllIIIllIll.getDifficultyForLocation(new BlockPos(lllllllllllllIIllIlllIllIIIlllIl)), null, false);
                        lllllllllllllIIllIlllIllIIIllIll.spawnEntityInWorld(lllllllllllllIIllIlllIllIIIlllIl);
                    }
                }
            }
        }
        
        protected static boolean canVillageGoDeeper(final StructureBoundingBox lllllllllllllIIllIlllIllIIllIlll) {
            return lllllllllllllIIllIlllIllIIllIlll != null && lllllllllllllIIllIlllIllIIllIlll.minY > 10;
        }
        
        protected void func_189924_a(final int lllllllllllllIIllIlllIlIlIllllII) {
            this.structureType = lllllllllllllIIllIlllIlIlIllllII;
        }
        
        protected BlockDoor func_189925_i() {
            switch (this.structureType) {
                case 2: {
                    return Blocks.ACACIA_DOOR;
                }
                case 3: {
                    return Blocks.SPRUCE_DOOR;
                }
                default: {
                    return Blocks.OAK_DOOR;
                }
            }
        }
        
        protected int chooseProfession(final int lllllllllllllIIllIlllIllIIIIlllI, final int lllllllllllllIIllIlllIllIIIIllIl) {
            return lllllllllllllIIllIlllIllIIIIllIl;
        }
        
        protected int getAverageGroundLevel(final World lllllllllllllIIllIlllIllIlIIIlll, final StructureBoundingBox lllllllllllllIIllIlllIllIlIIIllI) {
            int lllllllllllllIIllIlllIllIlIIIlIl = 0;
            int lllllllllllllIIllIlllIllIlIIIlII = 0;
            final BlockPos.MutableBlockPos lllllllllllllIIllIlllIllIlIIIIll = new BlockPos.MutableBlockPos();
            for (int lllllllllllllIIllIlllIllIlIIIIlI = this.boundingBox.minZ; lllllllllllllIIllIlllIllIlIIIIlI <= this.boundingBox.maxZ; ++lllllllllllllIIllIlllIllIlIIIIlI) {
                for (int lllllllllllllIIllIlllIllIlIIIIIl = this.boundingBox.minX; lllllllllllllIIllIlllIllIlIIIIIl <= this.boundingBox.maxX; ++lllllllllllllIIllIlllIllIlIIIIIl) {
                    lllllllllllllIIllIlllIllIlIIIIll.setPos(lllllllllllllIIllIlllIllIlIIIIIl, 64, lllllllllllllIIllIlllIllIlIIIIlI);
                    if (lllllllllllllIIllIlllIllIlIIIllI.isVecInside(lllllllllllllIIllIlllIllIlIIIIll)) {
                        lllllllllllllIIllIlllIllIlIIIlIl += Math.max(lllllllllllllIIllIlllIllIlIIIlll.getTopSolidOrLiquidBlock(lllllllllllllIIllIlllIllIlIIIIll).getY(), lllllllllllllIIllIlllIllIlIIIlll.provider.getAverageGroundLevel() - 1);
                        ++lllllllllllllIIllIlllIllIlIIIlII;
                    }
                }
            }
            if (lllllllllllllIIllIlllIllIlIIIlII == 0) {
                return -1;
            }
            return lllllllllllllIIllIlllIllIlIIIlIl / lllllllllllllIIllIlllIllIlIIIlII;
        }
        
        protected void func_189926_a(final World lllllllllllllIIllIlllIlIllIlllIl, final EnumFacing lllllllllllllIIllIlllIlIlllIIIll, final int lllllllllllllIIllIlllIlIllIllIll, final int lllllllllllllIIllIlllIlIlllIIIIl, final int lllllllllllllIIllIlllIlIlllIIIII, final StructureBoundingBox lllllllllllllIIllIlllIlIllIllIII) {
            if (!this.isZombieInfested) {
                this.setBlockState(lllllllllllllIIllIlllIlIllIlllIl, Blocks.TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockTorch.FACING, lllllllllllllIIllIlllIlIlllIIIll), lllllllllllllIIllIlllIlIllIllIll, lllllllllllllIIllIlllIlIlllIIIIl, lllllllllllllIIllIlllIlIlllIIIII, lllllllllllllIIllIlllIlIllIllIII);
            }
        }
        
        public Village() {
            this.averageGroundLvl = -1;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIllIlllIlllIIIIlII) {
            lllllllllllllIIllIlllIlllIIIIlII.setInteger("HPos", this.averageGroundLvl);
            lllllllllllllIIllIlllIlllIIIIlII.setInteger("VCount", this.villagersSpawned);
            lllllllllllllIIllIlllIlllIIIIlII.setByte("Type", (byte)this.structureType);
            lllllllllllllIIllIlllIlllIIIIlII.setBoolean("Zombie", this.isZombieInfested);
        }
    }
    
    public static class PieceWeight
    {
        public /* synthetic */ int villagePiecesLimit;
        public /* synthetic */ int villagePiecesSpawned;
        public /* synthetic */ Class<? extends Village> villagePieceClass;
        public final /* synthetic */ int villagePieceWeight;
        
        public boolean canSpawnMoreVillagePieces() {
            return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
        }
        
        public boolean canSpawnMoreVillagePiecesOfType(final int lllllllllllllllIllIlllllIlIlIlII) {
            return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
        }
        
        public PieceWeight(final Class<? extends Village> lllllllllllllllIllIlllllIlIllIIl, final int lllllllllllllllIllIlllllIlIlllII, final int lllllllllllllllIllIlllllIlIllIll) {
            this.villagePieceClass = lllllllllllllllIllIlllllIlIllIIl;
            this.villagePieceWeight = lllllllllllllllIllIlllllIlIlllII;
            this.villagePiecesLimit = lllllllllllllllIllIlllllIlIllIll;
        }
    }
    
    public static class Field2 extends Village
    {
        private /* synthetic */ Block cropTypeB;
        private /* synthetic */ Block cropTypeA;
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllllIIlIIIIIIIlIlllI) {
            super.writeStructureToNBT(llllllllllllllllIIlIIIIIIIlIlllI);
            llllllllllllllllIIlIIIIIIIlIlllI.setInteger("CA", Block.REGISTRY.getIDForObject(this.cropTypeA));
            llllllllllllllllIIlIIIIIIIlIlllI.setInteger("CB", Block.REGISTRY.getIDForObject(this.cropTypeB));
        }
        
        public Field2() {
        }
        
        public static Field2 createPiece(final Start llllllllllllllllIIlIIIIIIIIIlllI, final List<StructureComponent> llllllllllllllllIIlIIIIIIIIIllIl, final Random llllllllllllllllIIlIIIIIIIIIllII, final int llllllllllllllllIIlIIIIIIIIlIlII, final int llllllllllllllllIIlIIIIIIIIIlIlI, final int llllllllllllllllIIlIIIIIIIIIlIIl, final EnumFacing llllllllllllllllIIlIIIIIIIIIlIII, final int llllllllllllllllIIlIIIIIIIIIIlll) {
            final StructureBoundingBox llllllllllllllllIIlIIIIIIIIIllll = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllllIIlIIIIIIIIlIlII, llllllllllllllllIIlIIIIIIIIIlIlI, llllllllllllllllIIlIIIIIIIIIlIIl, 0, 0, 0, 7, 4, 9, llllllllllllllllIIlIIIIIIIIIlIII);
            return (Village.canVillageGoDeeper(llllllllllllllllIIlIIIIIIIIIllll) && StructureComponent.findIntersecting(llllllllllllllllIIlIIIIIIIIIllIl, llllllllllllllllIIlIIIIIIIIIllll) == null) ? new Field2(llllllllllllllllIIlIIIIIIIIIlllI, llllllllllllllllIIlIIIIIIIIIIlll, llllllllllllllllIIlIIIIIIIIIllII, llllllllllllllllIIlIIIIIIIIIllll, llllllllllllllllIIlIIIIIIIIIlIII) : null;
        }
        
        public Field2(final Start llllllllllllllllIIlIIIIIIIlllllI, final int llllllllllllllllIIlIIIIIIIllllIl, final Random llllllllllllllllIIlIIIIIIIllllII, final StructureBoundingBox llllllllllllllllIIlIIIIIIIlllIll, final EnumFacing llllllllllllllllIIlIIIIIIIllIlII) {
            super(llllllllllllllllIIlIIIIIIIlllllI, llllllllllllllllIIlIIIIIIIllllIl);
            this.setCoordBaseMode(llllllllllllllllIIlIIIIIIIllIlII);
            this.boundingBox = llllllllllllllllIIlIIIIIIIlllIll;
            this.cropTypeA = this.getRandomCropType(llllllllllllllllIIlIIIIIIIllllII);
            this.cropTypeB = this.getRandomCropType(llllllllllllllllIIlIIIIIIIllllII);
        }
        
        private Block getRandomCropType(final Random llllllllllllllllIIlIIIIIIIlIIIIl) {
            switch (llllllllllllllllIIlIIIIIIIlIIIIl.nextInt(10)) {
                case 0:
                case 1: {
                    return Blocks.CARROTS;
                }
                case 2:
                case 3: {
                    return Blocks.POTATOES;
                }
                case 4: {
                    return Blocks.BEETROOTS;
                }
                default: {
                    return Blocks.WHEAT;
                }
            }
        }
        
        @Override
        public boolean addComponentParts(final World llllllllllllllllIIIllllllllllIlI, final Random llllllllllllllllIIIllllllllIllIl, final StructureBoundingBox llllllllllllllllIIIllllllllIllII) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 4 - 1, 0);
            }
            final IBlockState llllllllllllllllIIIlllllllllIlll = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            this.fillWithBlocks(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII, 0, 1, 0, 6, 4, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII, 0, 0, 0, 0, 0, 8, llllllllllllllllIIIlllllllllIlll, llllllllllllllllIIIlllllllllIlll, false);
            this.fillWithBlocks(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII, 6, 0, 0, 6, 0, 8, llllllllllllllllIIIlllllllllIlll, llllllllllllllllIIIlllllllllIlll, false);
            this.fillWithBlocks(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII, 1, 0, 0, 5, 0, 0, llllllllllllllllIIIlllllllllIlll, llllllllllllllllIIIlllllllllIlll, false);
            this.fillWithBlocks(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII, 1, 0, 8, 5, 0, 8, llllllllllllllllIIIlllllllllIlll, llllllllllllllllIIIlllllllllIlll, false);
            this.fillWithBlocks(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIllllllllIllII, 3, 0, 1, 3, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
            for (int llllllllllllllllIIIlllllllllIllI = 1; llllllllllllllllIIIlllllllllIllI <= 7; ++llllllllllllllllIIIlllllllllIllI) {
                final int llllllllllllllllIIIlllllllllIlIl = ((BlockCrops)this.cropTypeA).getMaxAge();
                final int llllllllllllllllIIIlllllllllIlII = llllllllllllllllIIIlllllllllIlIl / 3;
                this.setBlockState(llllllllllllllllIIIllllllllllIlI, this.cropTypeA.getStateFromMeta(MathHelper.getInt(llllllllllllllllIIIllllllllIllIl, llllllllllllllllIIIlllllllllIlII, llllllllllllllllIIIlllllllllIlIl)), 1, 1, llllllllllllllllIIIlllllllllIllI, llllllllllllllllIIIllllllllIllII);
                this.setBlockState(llllllllllllllllIIIllllllllllIlI, this.cropTypeA.getStateFromMeta(MathHelper.getInt(llllllllllllllllIIIllllllllIllIl, llllllllllllllllIIIlllllllllIlII, llllllllllllllllIIIlllllllllIlIl)), 2, 1, llllllllllllllllIIIlllllllllIllI, llllllllllllllllIIIllllllllIllII);
                final int llllllllllllllllIIIlllllllllIIll = ((BlockCrops)this.cropTypeB).getMaxAge();
                final int llllllllllllllllIIIlllllllllIIlI = llllllllllllllllIIIlllllllllIIll / 3;
                this.setBlockState(llllllllllllllllIIIllllllllllIlI, this.cropTypeB.getStateFromMeta(MathHelper.getInt(llllllllllllllllIIIllllllllIllIl, llllllllllllllllIIIlllllllllIIlI, llllllllllllllllIIIlllllllllIIll)), 4, 1, llllllllllllllllIIIlllllllllIllI, llllllllllllllllIIIllllllllIllII);
                this.setBlockState(llllllllllllllllIIIllllllllllIlI, this.cropTypeB.getStateFromMeta(MathHelper.getInt(llllllllllllllllIIIllllllllIllIl, llllllllllllllllIIIlllllllllIIlI, llllllllllllllllIIIlllllllllIIll)), 5, 1, llllllllllllllllIIIlllllllllIllI, llllllllllllllllIIIllllllllIllII);
            }
            for (int llllllllllllllllIIIlllllllllIIIl = 0; llllllllllllllllIIIlllllllllIIIl < 9; ++llllllllllllllllIIIlllllllllIIIl) {
                for (int llllllllllllllllIIIlllllllllIIII = 0; llllllllllllllllIIIlllllllllIIII < 7; ++llllllllllllllllIIIlllllllllIIII) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllllIIIllllllllllIlI, llllllllllllllllIIIlllllllllIIII, 4, llllllllllllllllIIIlllllllllIIIl, llllllllllllllllIIIllllllllIllII);
                    this.replaceAirAndLiquidDownwards(llllllllllllllllIIIllllllllllIlI, Blocks.DIRT.getDefaultState(), llllllllllllllllIIIlllllllllIIII, -1, llllllllllllllllIIIlllllllllIIIl, llllllllllllllllIIIllllllllIllII);
                }
            }
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllllIIlIIIIIIIlIIllI, final TemplateManager llllllllllllllllIIlIIIIIIIlIIlIl) {
            super.readStructureFromNBT(llllllllllllllllIIlIIIIIIIlIIllI, llllllllllllllllIIlIIIIIIIlIIlIl);
            this.cropTypeA = Block.getBlockById(llllllllllllllllIIlIIIIIIIlIIllI.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(llllllllllllllllIIlIIIIIIIlIIllI.getInteger("CB"));
        }
    }
    
    public abstract static class Road extends Village
    {
        protected Road(final Start lllllllllllllllIIIlIlIllllIIlIlI, final int lllllllllllllllIIIlIlIllllIIllII) {
            super(lllllllllllllllIIIlIlIllllIIlIlI, lllllllllllllllIIIlIlIllllIIllII);
        }
        
        public Road() {
        }
    }
    
    public static class Path extends Road
    {
        private /* synthetic */ int length;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllIlIllII, final TemplateManager lllllllIlIlIll) {
            super.readStructureFromNBT(lllllllIlIllII, lllllllIlIlIll);
            this.length = lllllllIlIllII.getInteger("Length");
        }
        
        public Path() {
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Path.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final boolean llllllIlIlIIll = (Object)new int[EnumFacing.values().length];
            try {
                llllllIlIlIIll[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                llllllIlIlIIll[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                llllllIlIlIIll[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                llllllIlIlIIll[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                llllllIlIlIIll[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                llllllIlIlIIll[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return Path.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllIlIlIIll;
        }
        
        @Override
        public void buildComponent(final StructureComponent lllllllIIlIlIl, final List<StructureComponent> lllllllIIlIlII, final Random lllllllIIlIIll) {
            boolean lllllllIIlllII = false;
            for (int lllllllIIllIll = lllllllIIlIIll.nextInt(5); lllllllIIllIll < this.length - 8; lllllllIIllIll += 2 + lllllllIIlIIll.nextInt(5)) {
                final StructureComponent lllllllIIllIlI = this.getNextComponentNN((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, 0, lllllllIIllIll);
                if (lllllllIIllIlI != null) {
                    lllllllIIllIll += Math.max(lllllllIIllIlI.boundingBox.getXSize(), lllllllIIllIlI.boundingBox.getZSize());
                    lllllllIIlllII = true;
                }
            }
            for (int lllllllIIllIIl = lllllllIIlIIll.nextInt(5); lllllllIIllIIl < this.length - 8; lllllllIIllIIl += 2 + lllllllIIlIIll.nextInt(5)) {
                final StructureComponent lllllllIIllIII = this.getNextComponentPP((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, 0, lllllllIIllIIl);
                if (lllllllIIllIII != null) {
                    lllllllIIllIIl += Math.max(lllllllIIllIII.boundingBox.getXSize(), lllllllIIllIII.boundingBox.getZSize());
                    lllllllIIlllII = true;
                }
            }
            final EnumFacing lllllllIIlIlll = this.getCoordBaseMode();
            if (lllllllIIlllII && lllllllIIlIIll.nextInt(3) > 0 && lllllllIIlIlll != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllIIlIlll.ordinal()]) {
                    default: {
                        generateAndAddRoadPiece((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, this.getComponentType());
                        break;
                    }
                    case 4: {
                        generateAndAddRoadPiece((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.WEST, this.getComponentType());
                        break;
                    }
                    case 5: {
                        generateAndAddRoadPiece((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                        break;
                    }
                    case 6: {
                        generateAndAddRoadPiece((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                        break;
                    }
                }
            }
            if (lllllllIIlllII && lllllllIIlIIll.nextInt(3) > 0 && lllllllIIlIlll != null) {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllIIlIlll.ordinal()]) {
                    default: {
                        generateAndAddRoadPiece((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, this.getComponentType());
                        break;
                    }
                    case 4: {
                        generateAndAddRoadPiece((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.EAST, this.getComponentType());
                        break;
                    }
                    case 5: {
                        generateAndAddRoadPiece((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                        break;
                    }
                    case 6: {
                        generateAndAddRoadPiece((Start)lllllllIIlIlIl, lllllllIIlIlII, lllllllIIlIIll, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                        break;
                    }
                }
            }
        }
        
        @Override
        public boolean addComponentParts(final World llllllIlIllllI, final Random llllllIllIlIIl, final StructureBoundingBox llllllIlIlllIl) {
            final IBlockState llllllIllIIlll = this.getBiomeSpecificBlockState(Blocks.GRASS_PATH.getDefaultState());
            final IBlockState llllllIllIIllI = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState llllllIllIIlIl = this.getBiomeSpecificBlockState(Blocks.GRAVEL.getDefaultState());
            final IBlockState llllllIllIIlII = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            for (int llllllIllIIIll = this.boundingBox.minX; llllllIllIIIll <= this.boundingBox.maxX; ++llllllIllIIIll) {
                for (int llllllIllIIIlI = this.boundingBox.minZ; llllllIllIIIlI <= this.boundingBox.maxZ; ++llllllIllIIIlI) {
                    BlockPos llllllIllIIIIl = new BlockPos(llllllIllIIIll, 64, llllllIllIIIlI);
                    if (llllllIlIlllIl.isVecInside(llllllIllIIIIl)) {
                        llllllIllIIIIl = llllllIlIllllI.getTopSolidOrLiquidBlock(llllllIllIIIIl).down();
                        if (llllllIllIIIIl.getY() < llllllIlIllllI.getSeaLevel()) {
                            llllllIllIIIIl = new BlockPos(llllllIllIIIIl.getX(), llllllIlIllllI.getSeaLevel() - 1, llllllIllIIIIl.getZ());
                        }
                        while (llllllIllIIIIl.getY() >= llllllIlIllllI.getSeaLevel() - 1) {
                            final IBlockState llllllIllIIIII = llllllIlIllllI.getBlockState(llllllIllIIIIl);
                            if (llllllIllIIIII.getBlock() == Blocks.GRASS && llllllIlIllllI.isAirBlock(llllllIllIIIIl.up())) {
                                llllllIlIllllI.setBlockState(llllllIllIIIIl, llllllIllIIlll, 2);
                                break;
                            }
                            if (llllllIllIIIII.getMaterial().isLiquid()) {
                                llllllIlIllllI.setBlockState(llllllIllIIIIl, llllllIllIIllI, 2);
                                break;
                            }
                            if (llllllIllIIIII.getBlock() == Blocks.SAND || llllllIllIIIII.getBlock() == Blocks.SANDSTONE || llllllIllIIIII.getBlock() == Blocks.RED_SANDSTONE) {
                                llllllIlIllllI.setBlockState(llllllIllIIIIl, llllllIllIIlIl, 2);
                                llllllIlIllllI.setBlockState(llllllIllIIIIl.down(), llllllIllIIlII, 2);
                                break;
                            }
                            llllllIllIIIIl = llllllIllIIIIl.down();
                        }
                    }
                }
            }
            return true;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllIllIIll) {
            super.writeStructureToNBT(lllllllIllIIll);
            lllllllIllIIll.setInteger("Length", this.length);
        }
        
        public static StructureBoundingBox findPieceBox(final Start lllllllIIIIlll, final List<StructureComponent> lllllllIIIIllI, final Random llllllIlllllIl, final int llllllIlllllII, final int lllllllIIIIIll, final int lllllllIIIIIlI, final EnumFacing llllllIllllIIl) {
            for (int lllllllIIIIIII = 7 * MathHelper.getInt(llllllIlllllIl, 3, 5); lllllllIIIIIII >= 7; lllllllIIIIIII -= 7) {
                final StructureBoundingBox llllllIlllllll = StructureBoundingBox.getComponentToAddBoundingBox(llllllIlllllII, lllllllIIIIIll, lllllllIIIIIlI, 0, 0, 0, 3, 3, lllllllIIIIIII, llllllIllllIIl);
                if (StructureComponent.findIntersecting(lllllllIIIIllI, llllllIlllllll) == null) {
                    return llllllIlllllll;
                }
            }
            return null;
        }
        
        public Path(final Start lllllllIlllIlI, final int lllllllIlllIIl, final Random lllllllIlllllI, final StructureBoundingBox lllllllIllllIl, final EnumFacing lllllllIllIlll) {
            super(lllllllIlllIlI, lllllllIlllIIl);
            this.setCoordBaseMode(lllllllIllIlll);
            this.boundingBox = lllllllIllllIl;
            this.length = Math.max(lllllllIllllIl.getXSize(), lllllllIllllIl.getZSize());
        }
    }
    
    public static class House2 extends Village
    {
        private /* synthetic */ boolean hasMadeChest;
        
        @Override
        protected int chooseProfession(final int lllllllllllllIIlIIllIIIlllllIllI, final int lllllllllllllIIlIIllIIIlllllIlIl) {
            return 3;
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIlIIllIIlIIIlIlIll) {
            super.writeStructureToNBT(lllllllllllllIIlIIllIIlIIIlIlIll);
            lllllllllllllIIlIIllIIlIIIlIlIll.setBoolean("Chest", this.hasMadeChest);
        }
        
        public House2(final Start lllllllllllllIIlIIllIIlIIlIIllIl, final int lllllllllllllIIlIIllIIlIIlIIllII, final Random lllllllllllllIIlIIllIIlIIlIlIIIl, final StructureBoundingBox lllllllllllllIIlIIllIIlIIlIlIIII, final EnumFacing lllllllllllllIIlIIllIIlIIlIIlIlI) {
            super(lllllllllllllIIlIIllIIlIIlIIllIl, lllllllllllllIIlIIllIIlIIlIIllII);
            this.setCoordBaseMode(lllllllllllllIIlIIllIIlIIlIIlIlI);
            this.boundingBox = lllllllllllllIIlIIllIIlIIlIlIIII;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIIllIIlIIIIlIIIl, final Random lllllllllllllIIlIIllIIlIIIIlIIII, final StructureBoundingBox lllllllllllllIIlIIllIIlIIIIIllll) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 6 - 1, 0);
            }
            final IBlockState lllllllllllllIIlIIllIIlIIIIIlllI = Blocks.COBBLESTONE.getDefaultState();
            final IBlockState lllllllllllllIIlIIllIIlIIIIIllIl = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllIIlIIllIIlIIIIIllII = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST));
            final IBlockState lllllllllllllIIlIIllIIlIIIIIlIll = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllllIIlIIllIIlIIIIIlIlI = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllIIlIIllIIlIIIIIlIIl = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            final IBlockState lllllllllllllIIlIIllIIlIIIIIlIII = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 0, 1, 0, 9, 4, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 0, 0, 0, 9, 0, 6, lllllllllllllIIlIIllIIlIIIIIlllI, lllllllllllllIIlIIllIIlIIIIIlllI, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 0, 4, 0, 9, 4, 6, lllllllllllllIIlIIllIIlIIIIIlllI, lllllllllllllIIlIIllIIlIIIIIlllI, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 0, 5, 0, 9, 5, 6, Blocks.STONE_SLAB.getDefaultState(), Blocks.STONE_SLAB.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 1, 5, 1, 8, 5, 5, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 1, 1, 0, 2, 3, 0, lllllllllllllIIlIIllIIlIIIIIlIll, lllllllllllllIIlIIllIIlIIIIIlIll, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 0, 1, 0, 0, 4, 0, lllllllllllllIIlIIllIIlIIIIIlIIl, lllllllllllllIIlIIllIIlIIIIIlIIl, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 3, 1, 0, 3, 4, 0, lllllllllllllIIlIIllIIlIIIIIlIIl, lllllllllllllIIlIIllIIlIIIIIlIIl, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 0, 1, 6, 0, 4, 6, lllllllllllllIIlIIllIIlIIIIIlIIl, lllllllllllllIIlIIllIIlIIIIIlIIl, false);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIlIll, 3, 3, 1, lllllllllllllIIlIIllIIlIIIIIllll);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 3, 1, 2, 3, 3, 2, lllllllllllllIIlIIllIIlIIIIIlIll, lllllllllllllIIlIIllIIlIIIIIlIll, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 4, 1, 3, 5, 3, 3, lllllllllllllIIlIIllIIlIIIIIlIll, lllllllllllllIIlIIllIIlIIIIIlIll, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 0, 1, 1, 0, 3, 5, lllllllllllllIIlIIllIIlIIIIIlIll, lllllllllllllIIlIIllIIlIIIIIlIll, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 1, 1, 6, 5, 3, 6, lllllllllllllIIlIIllIIlIIIIIlIll, lllllllllllllIIlIIllIIlIIIIIlIll, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 5, 1, 0, 5, 3, 0, lllllllllllllIIlIIllIIlIIIIIlIII, lllllllllllllIIlIIllIIlIIIIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 9, 1, 0, 9, 3, 0, lllllllllllllIIlIIllIIlIIIIIlIII, lllllllllllllIIlIIllIIlIIIIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 6, 1, 4, 9, 4, 6, lllllllllllllIIlIIllIIlIIIIIlllI, lllllllllllllIIlIIllIIlIIIIIlllI, false);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.FLOWING_LAVA.getDefaultState(), 7, 1, 5, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.FLOWING_LAVA.getDefaultState(), 8, 1, 5, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.IRON_BARS.getDefaultState(), 9, 2, 5, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.IRON_BARS.getDefaultState(), 9, 2, 4, lllllllllllllIIlIIllIIlIIIIIllll);
            this.fillWithBlocks(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 7, 2, 4, 8, 2, 5, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIlllI, 6, 1, 3, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.FURNACE.getDefaultState(), 6, 2, 3, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.FURNACE.getDefaultState(), 6, 3, 3, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), 8, 1, 1, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 4, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 6, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 6, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIlIII, 2, 1, 4, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 2, 2, 4, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIlIll, 1, 1, 5, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllIl, 2, 1, 5, lllllllllllllIIlIIllIIlIIIIIllll);
            this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllII, 1, 1, 4, lllllllllllllIIlIIllIIlIIIIIllll);
            if (!this.hasMadeChest && lllllllllllllIIlIIllIIlIIIIIllll.isVecInside(new BlockPos(this.getXWithOffset(5, 5), this.getYWithOffset(1), this.getZWithOffset(5, 5)))) {
                this.hasMadeChest = true;
                this.generateChest(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, lllllllllllllIIlIIllIIlIIIIlIIII, 5, 1, 5, LootTableList.CHESTS_VILLAGE_BLACKSMITH);
            }
            for (int lllllllllllllIIlIIllIIlIIIIIIlll = 6; lllllllllllllIIlIIllIIlIIIIIIlll <= 8; ++lllllllllllllIIlIIllIIlIIIIIIlll) {
                if (this.getBlockStateFromPos(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIIlll, 0, -1, lllllllllllllIIlIIllIIlIIIIIllll).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIIlll, -1, -1, lllllllllllllIIlIIllIIlIIIIIllll).getMaterial() != Material.AIR) {
                    this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIlIlI, lllllllllllllIIlIIllIIlIIIIIIlll, 0, -1, lllllllllllllIIlIIllIIlIIIIIllll);
                    if (this.getBlockStateFromPos(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIIlll, -1, -1, lllllllllllllIIlIIllIIlIIIIIllll).getBlock() == Blocks.GRASS_PATH) {
                        this.setBlockState(lllllllllllllIIlIIllIIlIIIIlIIIl, Blocks.GRASS.getDefaultState(), lllllllllllllIIlIIllIIlIIIIIIlll, -1, -1, lllllllllllllIIlIIllIIlIIIIIllll);
                    }
                }
            }
            for (int lllllllllllllIIlIIllIIlIIIIIIllI = 0; lllllllllllllIIlIIllIIlIIIIIIllI < 7; ++lllllllllllllIIlIIllIIlIIIIIIllI) {
                for (int lllllllllllllIIlIIllIIlIIIIIIlIl = 0; lllllllllllllIIlIIllIIlIIIIIIlIl < 10; ++lllllllllllllIIlIIllIIlIIIIIIlIl) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIIlIl, 6, lllllllllllllIIlIIllIIlIIIIIIllI, lllllllllllllIIlIIllIIlIIIIIllll);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIlllI, lllllllllllllIIlIIllIIlIIIIIIlIl, -1, lllllllllllllIIlIIllIIlIIIIIIllI, lllllllllllllIIlIIllIIlIIIIIllll);
                }
            }
            this.spawnVillagers(lllllllllllllIIlIIllIIlIIIIlIIIl, lllllllllllllIIlIIllIIlIIIIIllll, 7, 1, 1, 1);
            return true;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIlIIllIIlIIIlIIIIl, final TemplateManager lllllllllllllIIlIIllIIlIIIlIIIll) {
            super.readStructureFromNBT(lllllllllllllIIlIIllIIlIIIlIIIIl, lllllllllllllIIlIIllIIlIIIlIIIll);
            this.hasMadeChest = lllllllllllllIIlIIllIIlIIIlIIIIl.getBoolean("Chest");
        }
        
        public House2() {
        }
        
        public static House2 createPiece(final Start lllllllllllllIIlIIllIIlIIlIIIIII, final List<StructureComponent> lllllllllllllIIlIIllIIlIIIllllll, final Random lllllllllllllIIlIIllIIlIIIllIlIl, final int lllllllllllllIIlIIllIIlIIIllIlII, final int lllllllllllllIIlIIllIIlIIIllllII, final int lllllllllllllIIlIIllIIlIIIllIIlI, final EnumFacing lllllllllllllIIlIIllIIlIIIllIIIl, final int lllllllllllllIIlIIllIIlIIIllIIII) {
            final StructureBoundingBox lllllllllllllIIlIIllIIlIIIlllIII = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlIIllIIlIIIllIlII, lllllllllllllIIlIIllIIlIIIllllII, lllllllllllllIIlIIllIIlIIIllIIlI, 0, 0, 0, 10, 6, 7, lllllllllllllIIlIIllIIlIIIllIIIl);
            return (Village.canVillageGoDeeper(lllllllllllllIIlIIllIIlIIIlllIII) && StructureComponent.findIntersecting(lllllllllllllIIlIIllIIlIIIllllll, lllllllllllllIIlIIllIIlIIIlllIII) == null) ? new House2(lllllllllllllIIlIIllIIlIIlIIIIII, lllllllllllllIIlIIllIIlIIIllIIII, lllllllllllllIIlIIllIIlIIIllIlIl, lllllllllllllIIlIIllIIlIIIlllIII, lllllllllllllIIlIIllIIlIIIllIIIl) : null;
        }
    }
    
    public static class Hall extends Village
    {
        public Hall(final Start lllllllllllllllIIllIIIlIIlllIllI, final int lllllllllllllllIIllIIIlIIlllIlIl, final Random lllllllllllllllIIllIIIlIIlllIlII, final StructureBoundingBox lllllllllllllllIIllIIIlIIllIlllI, final EnumFacing lllllllllllllllIIllIIIlIIlllIIlI) {
            super(lllllllllllllllIIllIIIlIIlllIllI, lllllllllllllllIIllIIIlIIlllIlIl);
            this.setCoordBaseMode(lllllllllllllllIIllIIIlIIlllIIlI);
            this.boundingBox = lllllllllllllllIIllIIIlIIllIlllI;
        }
        
        public static Hall createPiece(final Start lllllllllllllllIIllIIIlIIlIllIlI, final List<StructureComponent> lllllllllllllllIIllIIIlIIlIllIIl, final Random lllllllllllllllIIllIIIlIIllIIIIl, final int lllllllllllllllIIllIIIlIIllIIIII, final int lllllllllllllllIIllIIIlIIlIlllll, final int lllllllllllllllIIllIIIlIIlIllllI, final EnumFacing lllllllllllllllIIllIIIlIIlIlllIl, final int lllllllllllllllIIllIIIlIIlIlllII) {
            final StructureBoundingBox lllllllllllllllIIllIIIlIIlIllIll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllIIllIIIlIIllIIIII, lllllllllllllllIIllIIIlIIlIlllll, lllllllllllllllIIllIIIlIIlIllllI, 0, 0, 0, 9, 7, 11, lllllllllllllllIIllIIIlIIlIlllIl);
            return (Village.canVillageGoDeeper(lllllllllllllllIIllIIIlIIlIllIll) && StructureComponent.findIntersecting(lllllllllllllllIIllIIIlIIlIllIIl, lllllllllllllllIIllIIIlIIlIllIll) == null) ? new Hall(lllllllllllllllIIllIIIlIIlIllIlI, lllllllllllllllIIllIIIlIIlIlllII, lllllllllllllllIIllIIIlIIllIIIIl, lllllllllllllllIIllIIIlIIlIllIll, lllllllllllllllIIllIIIlIIlIlllIl) : null;
        }
        
        public Hall() {
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIIllIIIlIIlIIIIIl, final Random lllllllllllllllIIllIIIlIIIlIllll, final StructureBoundingBox lllllllllllllllIIllIIIlIIIlIlllI) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 7 - 1, 0);
            }
            final IBlockState lllllllllllllllIIllIIIlIIIlllllI = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllllllIIllIIIlIIIllllIl = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllllIIllIIIlIIIllllII = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH));
            final IBlockState lllllllllllllllIIllIIIlIIIlllIll = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST));
            final IBlockState lllllllllllllllIIllIIIlIIIlllIlI = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllllllIIllIIIlIIIlllIIl = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            final IBlockState lllllllllllllllIIllIIIlIIIlllIII = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 1, 1, 1, 7, 4, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 2, 1, 6, 8, 4, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 2, 0, 6, 8, 0, 10, Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState(), false);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllllI, 6, 0, 6, lllllllllllllllIIllIIIlIIIlIlllI);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 2, 1, 6, 2, 1, 10, lllllllllllllllIIllIIIlIIIlllIII, lllllllllllllllIIllIIIlIIIlllIII, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 8, 1, 6, 8, 1, 10, lllllllllllllllIIllIIIlIIIlllIII, lllllllllllllllIIllIIIlIIIlllIII, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 3, 1, 10, 7, 1, 10, lllllllllllllllIIllIIIlIIIlllIII, lllllllllllllllIIllIIIlIIIlllIII, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 1, 0, 1, 7, 0, 4, lllllllllllllllIIllIIIlIIIlllIlI, lllllllllllllllIIllIIIlIIIlllIlI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 0, 0, 0, 0, 3, 5, lllllllllllllllIIllIIIlIIIlllllI, lllllllllllllllIIllIIIlIIIlllllI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 8, 0, 0, 8, 3, 5, lllllllllllllllIIllIIIlIIIlllllI, lllllllllllllllIIllIIIlIIIlllllI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 1, 0, 0, 7, 1, 0, lllllllllllllllIIllIIIlIIIlllllI, lllllllllllllllIIllIIIlIIIlllllI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 1, 0, 5, 7, 1, 5, lllllllllllllllIIllIIIlIIIlllllI, lllllllllllllllIIllIIIlIIIlllllI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 1, 2, 0, 7, 3, 0, lllllllllllllllIIllIIIlIIIlllIlI, lllllllllllllllIIllIIIlIIIlllIlI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 1, 2, 5, 7, 3, 5, lllllllllllllllIIllIIIlIIIlllIlI, lllllllllllllllIIllIIIlIIIlllIlI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 0, 4, 1, 8, 4, 1, lllllllllllllllIIllIIIlIIIlllIlI, lllllllllllllllIIllIIIlIIIlllIlI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 0, 4, 4, 8, 4, 4, lllllllllllllllIIllIIIlIIIlllIlI, lllllllllllllllIIllIIIlIIIlllIlI, false);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 0, 5, 2, 8, 5, 3, lllllllllllllllIIllIIIlIIIlllIlI, lllllllllllllllIIllIIIlIIIlllIlI, false);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIlI, 0, 4, 2, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIlI, 0, 4, 3, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIlI, 8, 4, 2, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIlI, 8, 4, 3, lllllllllllllllIIllIIIlIIIlIlllI);
            final IBlockState lllllllllllllllIIllIIIlIIIllIlll = lllllllllllllllIIllIIIlIIIllllIl;
            final IBlockState lllllllllllllllIIllIIIlIIIllIllI = lllllllllllllllIIllIIIlIIIllllII;
            for (int lllllllllllllllIIllIIIlIIIllIlIl = -1; lllllllllllllllIIllIIIlIIIllIlIl <= 2; ++lllllllllllllllIIllIIIlIIIllIlIl) {
                for (int lllllllllllllllIIllIIIlIIIllIlII = 0; lllllllllllllllIIllIIIlIIIllIlII <= 8; ++lllllllllllllllIIllIIIlIIIllIlII) {
                    this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIllIlll, lllllllllllllllIIllIIIlIIIllIlII, 4 + lllllllllllllllIIllIIIlIIIllIlIl, lllllllllllllllIIllIIIlIIIllIlIl, lllllllllllllllIIllIIIlIIIlIlllI);
                    this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIllIllI, lllllllllllllllIIllIIIlIIIllIlII, 4 + lllllllllllllllIIllIIIlIIIllIlIl, 5 - lllllllllllllllIIllIIIlIIIllIlIl, lllllllllllllllIIllIIIlIIIlIlllI);
                }
            }
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIIl, 0, 2, 1, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIIl, 0, 2, 4, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIIl, 8, 2, 1, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIIl, 8, 2, 4, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 2, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 5, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 5, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 0, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 5, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIII, 2, 1, 3, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 2, 2, 3, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIlI, 1, 1, 4, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIllIlll, 2, 1, 4, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllIll, 1, 1, 3, lllllllllllllllIIllIIIlIIIlIlllI);
            this.fillWithBlocks(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 5, 0, 1, 7, 0, 3, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), Blocks.DOUBLE_STONE_SLAB.getDefaultState(), false);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), 6, 1, 1, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.DOUBLE_STONE_SLAB.getDefaultState(), 6, 1, 2, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.AIR.getDefaultState(), 2, 1, 0, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.AIR.getDefaultState(), 2, 2, 0, lllllllllllllllIIllIIIlIIIlIlllI);
            this.func_189926_a(lllllllllllllllIIllIIIlIIlIIIIIl, EnumFacing.NORTH, 2, 3, 1, lllllllllllllllIIllIIIlIIIlIlllI);
            this.func_189927_a(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, lllllllllllllllIIllIIIlIIIlIllll, 2, 1, 0, EnumFacing.NORTH);
            if (this.getBlockStateFromPos(lllllllllllllllIIllIIIlIIlIIIIIl, 2, 0, -1, lllllllllllllllIIllIIIlIIIlIlllI).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllllllIIllIIIlIIlIIIIIl, 2, -1, -1, lllllllllllllllIIllIIIlIIIlIlllI).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIllIlll, 2, 0, -1, lllllllllllllllIIllIIIlIIIlIlllI);
                if (this.getBlockStateFromPos(lllllllllllllllIIllIIIlIIlIIIIIl, 2, -1, -1, lllllllllllllllIIllIIIlIIIlIlllI).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.GRASS.getDefaultState(), 2, -1, -1, lllllllllllllllIIllIIIlIIIlIlllI);
                }
            }
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.AIR.getDefaultState(), 6, 1, 5, lllllllllllllllIIllIIIlIIIlIlllI);
            this.setBlockState(lllllllllllllllIIllIIIlIIlIIIIIl, Blocks.AIR.getDefaultState(), 6, 2, 5, lllllllllllllllIIllIIIlIIIlIlllI);
            this.func_189926_a(lllllllllllllllIIllIIIlIIlIIIIIl, EnumFacing.SOUTH, 6, 3, 4, lllllllllllllllIIllIIIlIIIlIlllI);
            this.func_189927_a(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, lllllllllllllllIIllIIIlIIIlIllll, 6, 1, 5, EnumFacing.SOUTH);
            for (int lllllllllllllllIIllIIIlIIIllIIll = 0; lllllllllllllllIIllIIIlIIIllIIll < 5; ++lllllllllllllllIIllIIIlIIIllIIll) {
                for (int lllllllllllllllIIllIIIlIIIllIIlI = 0; lllllllllllllllIIllIIIlIIIllIIlI < 9; ++lllllllllllllllIIllIIIlIIIllIIlI) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIllIIlI, 7, lllllllllllllllIIllIIIlIIIllIIll, lllllllllllllllIIllIIIlIIIlIlllI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlllllI, lllllllllllllllIIllIIIlIIIllIIlI, -1, lllllllllllllllIIllIIIlIIIllIIll, lllllllllllllllIIllIIIlIIIlIlllI);
                }
            }
            this.spawnVillagers(lllllllllllllllIIllIIIlIIlIIIIIl, lllllllllllllllIIllIIIlIIIlIlllI, 4, 1, 2, 2);
            return true;
        }
        
        @Override
        protected int chooseProfession(final int lllllllllllllllIIllIIIlIIIIllIll, final int lllllllllllllllIIllIIIlIIIIlllIl) {
            return (lllllllllllllllIIllIIIlIIIIllIll == 0) ? 4 : super.chooseProfession(lllllllllllllllIIllIIIlIIIIllIll, lllllllllllllllIIllIIIlIIIIlllIl);
        }
    }
    
    public static class House1 extends Village
    {
        public House1() {
        }
        
        @Override
        protected int chooseProfession(final int lllllllllllllIIIlllIllIlIIlIllll, final int lllllllllllllIIIlllIllIlIIlIlllI) {
            return 1;
        }
        
        public static House1 createPiece(final Start lllllllllllllIIIlllIllIlIllIIIlI, final List<StructureComponent> lllllllllllllIIIlllIllIlIllIlIlI, final Random lllllllllllllIIIlllIllIlIllIIIII, final int lllllllllllllIIIlllIllIlIllIlIII, final int lllllllllllllIIIlllIllIlIllIIlll, final int lllllllllllllIIIlllIllIlIlIlllIl, final EnumFacing lllllllllllllIIIlllIllIlIlIlllII, final int lllllllllllllIIIlllIllIlIlIllIll) {
            final StructureBoundingBox lllllllllllllIIIlllIllIlIllIIIll = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIIlllIllIlIllIlIII, lllllllllllllIIIlllIllIlIllIIlll, lllllllllllllIIIlllIllIlIlIlllIl, 0, 0, 0, 9, 9, 6, lllllllllllllIIIlllIllIlIlIlllII);
            return (Village.canVillageGoDeeper(lllllllllllllIIIlllIllIlIllIIIll) && StructureComponent.findIntersecting(lllllllllllllIIIlllIllIlIllIlIlI, lllllllllllllIIIlllIllIlIllIIIll) == null) ? new House1(lllllllllllllIIIlllIllIlIllIIIlI, lllllllllllllIIIlllIllIlIlIllIll, lllllllllllllIIIlllIllIlIllIIIII, lllllllllllllIIIlllIllIlIllIIIll, lllllllllllllIIIlllIllIlIlIlllII) : null;
        }
        
        public House1(final Start lllllllllllllIIIlllIllIlIllllllI, final int lllllllllllllIIIlllIllIlIlllllIl, final Random lllllllllllllIIIlllIllIlIlllllII, final StructureBoundingBox lllllllllllllIIIlllIllIlIlllIllI, final EnumFacing lllllllllllllIIIlllIllIlIlllIlIl) {
            super(lllllllllllllIIIlllIllIlIllllllI, lllllllllllllIIIlllIllIlIlllllIl);
            this.setCoordBaseMode(lllllllllllllIIIlllIllIlIlllIlIl);
            this.boundingBox = lllllllllllllIIIlllIllIlIlllIllI;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIlllIllIlIlIIlIll, final Random lllllllllllllIIIlllIllIlIlIIlIlI, final StructureBoundingBox lllllllllllllIIIlllIllIlIlIIlIIl) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 9 - 1, 0);
            }
            final IBlockState lllllllllllllIIIlllIllIlIlIIlIII = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllllIIIlllIllIlIlIIIlll = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllIIIlllIllIlIlIIIllI = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH));
            final IBlockState lllllllllllllIIIlllIllIlIlIIIlIl = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST));
            final IBlockState lllllllllllllIIIlllIllIlIlIIIlII = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllllIIIlllIllIlIlIIIIll = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllIIIlllIllIlIlIIIIlI = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 1, 1, 1, 7, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 0, 0, 0, 8, 0, 5, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 0, 5, 0, 8, 5, 5, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 0, 6, 1, 8, 6, 4, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 0, 7, 2, 8, 7, 3, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            for (int lllllllllllllIIIlllIllIlIlIIIIIl = -1; lllllllllllllIIIlllIllIlIlIIIIIl <= 2; ++lllllllllllllIIIlllIllIlIlIIIIIl) {
                for (int lllllllllllllIIIlllIllIlIlIIIIII = 0; lllllllllllllIIIlllIllIlIlIIIIII <= 8; ++lllllllllllllIIIlllIllIlIlIIIIII) {
                    this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIlll, lllllllllllllIIIlllIllIlIlIIIIII, 6 + lllllllllllllIIIlllIllIlIlIIIIIl, lllllllllllllIIIlllIllIlIlIIIIIl, lllllllllllllIIIlllIllIlIlIIlIIl);
                    this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIllI, lllllllllllllIIIlllIllIlIlIIIIII, 6 + lllllllllllllIIIlllIllIlIlIIIIIl, 5 - lllllllllllllIIIlllIllIlIlIIIIIl, lllllllllllllIIIlllIllIlIlIIlIIl);
                }
            }
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 0, 1, 0, 0, 1, 5, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 1, 1, 5, 8, 1, 5, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 8, 1, 0, 8, 1, 4, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 2, 1, 0, 7, 1, 0, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 0, 2, 0, 0, 4, 0, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 0, 2, 5, 0, 4, 5, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 8, 2, 5, 8, 4, 5, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 8, 2, 0, 8, 4, 0, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIlIIlIII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 0, 2, 1, 0, 4, 4, lllllllllllllIIIlllIllIlIlIIIlII, lllllllllllllIIIlllIllIlIlIIIlII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 1, 2, 5, 7, 4, 5, lllllllllllllIIIlllIllIlIlIIIlII, lllllllllllllIIIlllIllIlIlIIIlII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 8, 2, 1, 8, 4, 4, lllllllllllllIIIlllIllIlIlIIIlII, lllllllllllllIIIlllIllIlIlIIIlII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 1, 2, 0, 7, 4, 0, lllllllllllllIIIlllIllIlIlIIIlII, lllllllllllllIIIlllIllIlIlIIIlII, false);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 0, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 0, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 0, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 0, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 5, 3, 0, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 6, 3, 0, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 2, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 2, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 8, 3, 2, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 8, 3, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 5, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 5, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 5, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 5, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 1, 4, 1, 7, 4, 1, lllllllllllllIIIlllIllIlIlIIIlII, lllllllllllllIIIlllIllIlIlIIIlII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 1, 4, 4, 7, 4, 4, lllllllllllllIIIlllIllIlIlIIIlII, lllllllllllllIIIlllIllIlIlIIIlII, false);
            this.fillWithBlocks(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 1, 3, 4, 7, 3, 4, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIlII, 7, 1, 4, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIlIl, 7, 1, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIlll, 6, 1, 4, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIlll, 5, 1, 4, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIlll, 4, 1, 4, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIlll, 3, 1, 4, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIIlI, 6, 1, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 6, 2, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIIlI, 4, 1, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 4, 2, 3, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.CRAFTING_TABLE.getDefaultState(), 7, 1, 1, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.AIR.getDefaultState(), 1, 1, 0, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.AIR.getDefaultState(), 1, 2, 0, lllllllllllllIIIlllIllIlIlIIlIIl);
            this.func_189927_a(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, lllllllllllllIIIlllIllIlIlIIlIlI, 1, 1, 0, EnumFacing.NORTH);
            if (this.getBlockStateFromPos(lllllllllllllIIIlllIllIlIlIIlIll, 1, 0, -1, lllllllllllllIIIlllIllIlIlIIlIIl).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllllIIIlllIllIlIlIIlIll, 1, -1, -1, lllllllllllllIIIlllIllIlIlIIlIIl).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIIIll, 1, 0, -1, lllllllllllllIIIlllIllIlIlIIlIIl);
                if (this.getBlockStateFromPos(lllllllllllllIIIlllIllIlIlIIlIll, 1, -1, -1, lllllllllllllIIIlllIllIlIlIIlIIl).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllllIIIlllIllIlIlIIlIll, Blocks.GRASS.getDefaultState(), 1, -1, -1, lllllllllllllIIIlllIllIlIlIIlIIl);
                }
            }
            for (int lllllllllllllIIIlllIllIlIIllllll = 0; lllllllllllllIIIlllIllIlIIllllll < 6; ++lllllllllllllIIIlllIllIlIIllllll) {
                for (int lllllllllllllIIIlllIllIlIIlllllI = 0; lllllllllllllIIIlllIllIlIIlllllI < 9; ++lllllllllllllIIIlllIllIlIIlllllI) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIIlllllI, 9, lllllllllllllIIIlllIllIlIIllllll, lllllllllllllIIIlllIllIlIlIIlIIl);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIII, lllllllllllllIIIlllIllIlIIlllllI, -1, lllllllllllllIIIlllIllIlIIllllll, lllllllllllllIIIlllIllIlIlIIlIIl);
                }
            }
            this.spawnVillagers(lllllllllllllIIIlllIllIlIlIIlIll, lllllllllllllIIIlllIllIlIlIIlIIl, 2, 1, 2, 1);
            return true;
        }
    }
    
    public static class House4Garden extends Village
    {
        private /* synthetic */ boolean isRoofAccessible;
        
        public House4Garden(final Start lllllllllllllllIlIlIIlIIllIllIII, final int lllllllllllllllIlIlIIlIIllIlIIIl, final Random lllllllllllllllIlIlIIlIIllIlIllI, final StructureBoundingBox lllllllllllllllIlIlIIlIIllIlIlIl, final EnumFacing lllllllllllllllIlIlIIlIIllIIlllI) {
            super(lllllllllllllllIlIlIIlIIllIllIII, lllllllllllllllIlIlIIlIIllIlIIIl);
            this.setCoordBaseMode(lllllllllllllllIlIlIIlIIllIIlllI);
            this.boundingBox = lllllllllllllllIlIlIIlIIllIlIlIl;
            this.isRoofAccessible = lllllllllllllllIlIlIIlIIllIlIllI.nextBoolean();
        }
        
        public House4Garden() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIlIlIIlIIllIIIIII, final TemplateManager lllllllllllllllIlIlIIlIIlIllllll) {
            super.readStructureFromNBT(lllllllllllllllIlIlIIlIIllIIIIII, lllllllllllllllIlIlIIlIIlIllllll);
            this.isRoofAccessible = lllllllllllllllIlIlIIlIIllIIIIII.getBoolean("Terrace");
        }
        
        public static House4Garden createPiece(final Start lllllllllllllllIlIlIIlIIlIllIlIl, final List<StructureComponent> lllllllllllllllIlIlIIlIIlIlIlIll, final Random lllllllllllllllIlIlIIlIIlIlIlIlI, final int lllllllllllllllIlIlIIlIIlIlIlIIl, final int lllllllllllllllIlIlIIlIIlIlIlIII, final int lllllllllllllllIlIlIIlIIlIlIIlll, final EnumFacing lllllllllllllllIlIlIIlIIlIlIllll, final int lllllllllllllllIlIlIIlIIlIlIlllI) {
            final StructureBoundingBox lllllllllllllllIlIlIIlIIlIlIllIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllIlIlIIlIIlIlIlIIl, lllllllllllllllIlIlIIlIIlIlIlIII, lllllllllllllllIlIlIIlIIlIlIIlll, 0, 0, 0, 5, 6, 5, lllllllllllllllIlIlIIlIIlIlIllll);
            return (StructureComponent.findIntersecting(lllllllllllllllIlIlIIlIIlIlIlIll, lllllllllllllllIlIlIIlIIlIlIllIl) != null) ? null : new House4Garden(lllllllllllllllIlIlIIlIIlIllIlIl, lllllllllllllllIlIlIIlIIlIlIlllI, lllllllllllllllIlIlIIlIIlIlIlIlI, lllllllllllllllIlIlIIlIIlIlIllIl, lllllllllllllllIlIlIIlIIlIlIllll);
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIlIlIIlIIllIIlIlI) {
            super.writeStructureToNBT(lllllllllllllllIlIlIIlIIllIIlIlI);
            lllllllllllllllIlIlIIlIIllIIlIlI.setBoolean("Terrace", this.isRoofAccessible);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllIlIlIIlIIlIIIllII, final Random lllllllllllllllIlIlIIlIIlIIlIlll, final StructureBoundingBox lllllllllllllllIlIlIIlIIlIIIlIll) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 6 - 1, 0);
            }
            final IBlockState lllllllllllllllIlIlIIlIIlIIlIlIl = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllllllIlIlIIlIIlIIlIlII = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllllllIlIlIIlIIlIIlIIll = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllllIlIlIIlIIlIIlIIlI = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            final IBlockState lllllllllllllllIlIlIIlIIlIIlIIIl = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll, 0, 0, 0, 4, 0, 4, lllllllllllllllIlIlIIlIIlIIlIlIl, lllllllllllllllIlIlIIlIIlIIlIlIl, false);
            this.fillWithBlocks(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll, 0, 4, 0, 4, 4, 4, lllllllllllllllIlIlIIlIIlIIlIIlI, lllllllllllllllIlIlIIlIIlIIlIIlI, false);
            this.fillWithBlocks(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll, 1, 4, 1, 3, 4, 3, lllllllllllllllIlIlIIlIIlIIlIlII, lllllllllllllllIlIlIIlIIlIIlIlII, false);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 0, 1, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 0, 2, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 0, 3, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 4, 1, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 4, 2, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 4, 3, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 0, 1, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 0, 2, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 0, 3, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 4, 1, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 4, 2, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, 4, 3, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.fillWithBlocks(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll, 0, 1, 1, 0, 3, 3, lllllllllllllllIlIlIIlIIlIIlIlII, lllllllllllllllIlIlIIlIIlIIlIlII, false);
            this.fillWithBlocks(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll, 4, 1, 1, 4, 3, 3, lllllllllllllllIlIlIIlIIlIIlIlII, lllllllllllllllIlIlIIlIIlIIlIlII, false);
            this.fillWithBlocks(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll, 1, 1, 4, 3, 3, 4, lllllllllllllllIlIlIIlIIlIIlIlII, lllllllllllllllIlIlIIlIIlIIlIlII, false);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 2, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlII, 1, 1, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlII, 1, 2, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlII, 1, 3, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlII, 2, 3, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlII, 3, 3, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlII, 3, 2, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlII, 3, 1, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
            if (this.getBlockStateFromPos(lllllllllllllllIlIlIIlIIlIIIllII, 2, 0, -1, lllllllllllllllIlIlIIlIIlIIIlIll).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllllllIlIlIIlIIlIIIllII, 2, -1, -1, lllllllllllllllIlIlIIlIIlIIIlIll).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIll, 2, 0, -1, lllllllllllllllIlIlIIlIIlIIIlIll);
                if (this.getBlockStateFromPos(lllllllllllllllIlIlIIlIIlIIIllII, 2, -1, -1, lllllllllllllllIlIlIIlIIlIIIlIll).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, Blocks.GRASS.getDefaultState(), 2, -1, -1, lllllllllllllllIlIlIIlIIlIIIlIll);
                }
            }
            this.fillWithBlocks(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll, 1, 1, 1, 3, 3, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            if (this.isRoofAccessible) {
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 0, 5, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 1, 5, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 2, 5, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 3, 5, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 4, 5, 0, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 0, 5, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 1, 5, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 2, 5, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 3, 5, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 4, 5, 4, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 4, 5, 1, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 4, 5, 2, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 4, 5, 3, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 0, 5, 1, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 0, 5, 2, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIIl, 0, 5, 3, lllllllllllllllIlIlIIlIIlIIIlIll);
            }
            if (this.isRoofAccessible) {
                final IBlockState lllllllllllllllIlIlIIlIIlIIlIIII = Blocks.LADDER.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.SOUTH);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIII, 3, 1, 3, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIII, 3, 2, 3, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIII, 3, 3, 3, lllllllllllllllIlIlIIlIIlIIIlIll);
                this.setBlockState(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIIII, 3, 4, 3, lllllllllllllllIlIlIIlIIlIIIlIll);
            }
            this.func_189926_a(lllllllllllllllIlIlIIlIIlIIIllII, EnumFacing.NORTH, 2, 3, 1, lllllllllllllllIlIlIIlIIlIIIlIll);
            for (int lllllllllllllllIlIlIIlIIlIIIllll = 0; lllllllllllllllIlIlIIlIIlIIIllll < 5; ++lllllllllllllllIlIlIIlIIlIIIllll) {
                for (int lllllllllllllllIlIlIIlIIlIIIlllI = 0; lllllllllllllllIlIlIIlIIlIIIlllI < 5; ++lllllllllllllllIlIlIIlIIlIIIlllI) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlllI, 6, lllllllllllllllIlIlIIlIIlIIIllll, lllllllllllllllIlIlIIlIIlIIIlIll);
                    this.replaceAirAndLiquidDownwards(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIlIlIl, lllllllllllllllIlIlIIlIIlIIIlllI, -1, lllllllllllllllIlIlIIlIIlIIIllll, lllllllllllllllIlIlIIlIIlIIIlIll);
                }
            }
            this.spawnVillagers(lllllllllllllllIlIlIIlIIlIIIllII, lllllllllllllllIlIlIIlIIlIIIlIll, 1, 1, 2, 1);
            return true;
        }
    }
    
    public static class Church extends Village
    {
        @Override
        protected int chooseProfession(final int lllllllllllllllllllIllIlIIIlllIl, final int lllllllllllllllllllIllIlIIIlllII) {
            return 2;
        }
        
        public Church() {
        }
        
        public Church(final Start lllllllllllllllllllIllIlIlIlllll, final int lllllllllllllllllllIllIlIlIllllI, final Random lllllllllllllllllllIllIlIllIIIll, final StructureBoundingBox lllllllllllllllllllIllIlIllIIIlI, final EnumFacing lllllllllllllllllllIllIlIlIlllII) {
            super(lllllllllllllllllllIllIlIlIlllll, lllllllllllllllllllIllIlIlIllllI);
            this.setCoordBaseMode(lllllllllllllllllllIllIlIlIlllII);
            this.boundingBox = lllllllllllllllllllIllIlIllIIIlI;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllllIllIlIIllIlII, final Random lllllllllllllllllllIllIlIIllIIll, final StructureBoundingBox lllllllllllllllllllIllIlIIllIIlI) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 12 - 1, 0);
            }
            final IBlockState lllllllllllllllllllIllIlIIllIIIl = Blocks.COBBLESTONE.getDefaultState();
            final IBlockState lllllllllllllllllllIllIlIIllIIII = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllllllllIllIlIIlIllll = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST));
            final IBlockState lllllllllllllllllllIllIlIIlIlllI = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST));
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 1, 1, 1, 3, 3, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 1, 5, 1, 3, 9, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 1, 0, 0, 3, 0, 8, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 1, 1, 0, 3, 10, 0, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 0, 1, 1, 0, 10, 3, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 4, 1, 1, 4, 10, 3, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 0, 0, 4, 0, 4, 7, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 4, 0, 4, 4, 4, 7, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 1, 1, 8, 3, 4, 8, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 1, 5, 4, 3, 10, 4, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 1, 5, 5, 3, 5, 7, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 0, 9, 0, 4, 9, 4, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.fillWithBlocks(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 0, 4, 0, 4, 4, 4, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIllIIIl, false);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 0, 11, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 4, 11, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 2, 11, 0, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 2, 11, 4, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 1, 1, 6, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 1, 1, 7, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 2, 1, 7, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 3, 1, 6, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, 3, 1, 7, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIII, 1, 1, 5, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIII, 2, 1, 6, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIII, 3, 1, 5, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIlIllll, 1, 2, 7, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIlIlllI, 3, 2, 7, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 0, 6, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 0, 7, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 4, 6, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 4, 7, 2, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 2, 6, 0, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 2, 7, 0, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 2, 6, 4, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 2, 7, 4, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 6, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 6, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GLASS_PANE.getDefaultState(), 2, 3, 8, lllllllllllllllllllIllIlIIllIIlI);
            this.func_189926_a(lllllllllllllllllllIllIlIIllIlII, EnumFacing.SOUTH, 2, 4, 7, lllllllllllllllllllIllIlIIllIIlI);
            this.func_189926_a(lllllllllllllllllllIllIlIIllIlII, EnumFacing.EAST, 1, 4, 6, lllllllllllllllllllIllIlIIllIIlI);
            this.func_189926_a(lllllllllllllllllllIllIlIIllIlII, EnumFacing.WEST, 3, 4, 6, lllllllllllllllllllIllIlIIllIIlI);
            this.func_189926_a(lllllllllllllllllllIllIlIIllIlII, EnumFacing.NORTH, 2, 4, 5, lllllllllllllllllllIllIlIIllIIlI);
            final IBlockState lllllllllllllllllllIllIlIIlIllIl = Blocks.LADDER.getDefaultState().withProperty((IProperty<Comparable>)BlockLadder.FACING, EnumFacing.WEST);
            for (int lllllllllllllllllllIllIlIIlIllII = 1; lllllllllllllllllllIllIlIIlIllII <= 9; ++lllllllllllllllllllIllIlIIlIllII) {
                this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIlIllIl, 3, lllllllllllllllllllIllIlIIlIllII, 3, lllllllllllllllllllIllIlIIllIIlI);
            }
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.AIR.getDefaultState(), 2, 1, 0, lllllllllllllllllllIllIlIIllIIlI);
            this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.AIR.getDefaultState(), 2, 2, 0, lllllllllllllllllllIllIlIIllIIlI);
            this.func_189927_a(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, lllllllllllllllllllIllIlIIllIIll, 2, 1, 0, EnumFacing.NORTH);
            if (this.getBlockStateFromPos(lllllllllllllllllllIllIlIIllIlII, 2, 0, -1, lllllllllllllllllllIllIlIIllIIlI).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllllllllllIllIlIIllIlII, 2, -1, -1, lllllllllllllllllllIllIlIIllIIlI).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIII, 2, 0, -1, lllllllllllllllllllIllIlIIllIIlI);
                if (this.getBlockStateFromPos(lllllllllllllllllllIllIlIIllIlII, 2, -1, -1, lllllllllllllllllllIllIlIIllIIlI).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllllllllllIllIlIIllIlII, Blocks.GRASS.getDefaultState(), 2, -1, -1, lllllllllllllllllllIllIlIIllIIlI);
                }
            }
            for (int lllllllllllllllllllIllIlIIlIlIll = 0; lllllllllllllllllllIllIlIIlIlIll < 9; ++lllllllllllllllllllIllIlIIlIlIll) {
                for (int lllllllllllllllllllIllIlIIlIlIlI = 0; lllllllllllllllllllIllIlIIlIlIlI < 5; ++lllllllllllllllllllIllIlIIlIlIlI) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIlIlIlI, 12, lllllllllllllllllllIllIlIIlIlIll, lllllllllllllllllllIllIlIIllIIlI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIIl, lllllllllllllllllllIllIlIIlIlIlI, -1, lllllllllllllllllllIllIlIIlIlIll, lllllllllllllllllllIllIlIIllIIlI);
                }
            }
            this.spawnVillagers(lllllllllllllllllllIllIlIIllIlII, lllllllllllllllllllIllIlIIllIIlI, 2, 1, 2, 1);
            return true;
        }
        
        public static Church createPiece(final Start lllllllllllllllllllIllIlIlIlIIlI, final List<StructureComponent> lllllllllllllllllllIllIlIlIIlIII, final Random lllllllllllllllllllIllIlIlIlIIII, final int lllllllllllllllllllIllIlIlIIIllI, final int lllllllllllllllllllIllIlIlIIlllI, final int lllllllllllllllllllIllIlIlIIllIl, final EnumFacing lllllllllllllllllllIllIlIlIIllII, final int lllllllllllllllllllIllIlIlIIIIlI) {
            final StructureBoundingBox lllllllllllllllllllIllIlIlIIlIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllllllIllIlIlIIIllI, lllllllllllllllllllIllIlIlIIlllI, lllllllllllllllllllIllIlIlIIllIl, 0, 0, 0, 5, 12, 9, lllllllllllllllllllIllIlIlIIllII);
            return (Village.canVillageGoDeeper(lllllllllllllllllllIllIlIlIIlIlI) && StructureComponent.findIntersecting(lllllllllllllllllllIllIlIlIIlIII, lllllllllllllllllllIllIlIlIIlIlI) == null) ? new Church(lllllllllllllllllllIllIlIlIlIIlI, lllllllllllllllllllIllIlIlIIIIlI, lllllllllllllllllllIllIlIlIlIIII, lllllllllllllllllllIllIlIlIIlIlI, lllllllllllllllllllIllIlIlIIllII) : null;
        }
    }
    
    public static class Field1 extends Village
    {
        private /* synthetic */ Block cropTypeC;
        private /* synthetic */ Block cropTypeD;
        private /* synthetic */ Block cropTypeA;
        private /* synthetic */ Block cropTypeB;
        
        private Block getRandomCropType(final Random lllllllllllllIIlIlllIlIIllIIlIII) {
            switch (lllllllllllllIIlIlllIlIIllIIlIII.nextInt(10)) {
                case 0:
                case 1: {
                    return Blocks.CARROTS;
                }
                case 2:
                case 3: {
                    return Blocks.POTATOES;
                }
                case 4: {
                    return Blocks.BEETROOTS;
                }
                default: {
                    return Blocks.WHEAT;
                }
            }
        }
        
        public Field1() {
        }
        
        public Field1(final Start lllllllllllllIIlIlllIlIIllIllllI, final int lllllllllllllIIlIlllIlIIllIlllIl, final Random lllllllllllllIIlIlllIlIIlllIIIlI, final StructureBoundingBox lllllllllllllIIlIlllIlIIllIllIll, final EnumFacing lllllllllllllIIlIlllIlIIllIllIlI) {
            super(lllllllllllllIIlIlllIlIIllIllllI, lllllllllllllIIlIlllIlIIllIlllIl);
            this.setCoordBaseMode(lllllllllllllIIlIlllIlIIllIllIlI);
            this.boundingBox = lllllllllllllIIlIlllIlIIllIllIll;
            this.cropTypeA = this.getRandomCropType(lllllllllllllIIlIlllIlIIlllIIIlI);
            this.cropTypeB = this.getRandomCropType(lllllllllllllIIlIlllIlIIlllIIIlI);
            this.cropTypeC = this.getRandomCropType(lllllllllllllIIlIlllIlIIlllIIIlI);
            this.cropTypeD = this.getRandomCropType(lllllllllllllIIlIlllIlIIlllIIIlI);
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIlIlllIlIIlIIlllII, final Random lllllllllllllIIlIlllIlIIlIIllIll, final StructureBoundingBox lllllllllllllIIlIlllIlIIlIIIlIlI) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 4 - 1, 0);
            }
            final IBlockState lllllllllllllIIlIlllIlIIlIIllIIl = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 0, 1, 0, 12, 4, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 7, 0, 1, 8, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 10, 0, 1, 11, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 0, 0, 0, 0, 0, 8, lllllllllllllIIlIlllIlIIlIIllIIl, lllllllllllllIIlIlllIlIIlIIllIIl, false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 6, 0, 0, 6, 0, 8, lllllllllllllIIlIlllIlIIlIIllIIl, lllllllllllllIIlIlllIlIIlIIllIIl, false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 12, 0, 0, 12, 0, 8, lllllllllllllIIlIlllIlIIlIIllIIl, lllllllllllllIIlIlllIlIIlIIllIIl, false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 1, 0, 0, 11, 0, 0, lllllllllllllIIlIlllIlIIlIIllIIl, lllllllllllllIIlIlllIlIIlIIllIIl, false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 1, 0, 8, 11, 0, 8, lllllllllllllIIlIlllIlIIlIIllIIl, lllllllllllllIIlIlllIlIIlIIllIIl, false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 3, 0, 1, 3, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlIlI, 9, 0, 1, 9, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
            for (int lllllllllllllIIlIlllIlIIlIIllIII = 1; lllllllllllllIIlIlllIlIIlIIllIII <= 7; ++lllllllllllllIIlIlllIlIIlIIllIII) {
                final int lllllllllllllIIlIlllIlIIlIIlIlll = ((BlockCrops)this.cropTypeA).getMaxAge();
                final int lllllllllllllIIlIlllIlIIlIIlIllI = lllllllllllllIIlIlllIlIIlIIlIlll / 3;
                this.setBlockState(lllllllllllllIIlIlllIlIIlIIlllII, this.cropTypeA.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlllIlIIlIIllIll, lllllllllllllIIlIlllIlIIlIIlIllI, lllllllllllllIIlIlllIlIIlIIlIlll)), 1, 1, lllllllllllllIIlIlllIlIIlIIllIII, lllllllllllllIIlIlllIlIIlIIIlIlI);
                this.setBlockState(lllllllllllllIIlIlllIlIIlIIlllII, this.cropTypeA.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlllIlIIlIIllIll, lllllllllllllIIlIlllIlIIlIIlIllI, lllllllllllllIIlIlllIlIIlIIlIlll)), 2, 1, lllllllllllllIIlIlllIlIIlIIllIII, lllllllllllllIIlIlllIlIIlIIIlIlI);
                final int lllllllllllllIIlIlllIlIIlIIlIlIl = ((BlockCrops)this.cropTypeB).getMaxAge();
                final int lllllllllllllIIlIlllIlIIlIIlIlII = lllllllllllllIIlIlllIlIIlIIlIlIl / 3;
                this.setBlockState(lllllllllllllIIlIlllIlIIlIIlllII, this.cropTypeB.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlllIlIIlIIllIll, lllllllllllllIIlIlllIlIIlIIlIlII, lllllllllllllIIlIlllIlIIlIIlIlIl)), 4, 1, lllllllllllllIIlIlllIlIIlIIllIII, lllllllllllllIIlIlllIlIIlIIIlIlI);
                this.setBlockState(lllllllllllllIIlIlllIlIIlIIlllII, this.cropTypeB.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlllIlIIlIIllIll, lllllllllllllIIlIlllIlIIlIIlIlII, lllllllllllllIIlIlllIlIIlIIlIlIl)), 5, 1, lllllllllllllIIlIlllIlIIlIIllIII, lllllllllllllIIlIlllIlIIlIIIlIlI);
                final int lllllllllllllIIlIlllIlIIlIIlIIll = ((BlockCrops)this.cropTypeC).getMaxAge();
                final int lllllllllllllIIlIlllIlIIlIIlIIlI = lllllllllllllIIlIlllIlIIlIIlIIll / 3;
                this.setBlockState(lllllllllllllIIlIlllIlIIlIIlllII, this.cropTypeC.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlllIlIIlIIllIll, lllllllllllllIIlIlllIlIIlIIlIIlI, lllllllllllllIIlIlllIlIIlIIlIIll)), 7, 1, lllllllllllllIIlIlllIlIIlIIllIII, lllllllllllllIIlIlllIlIIlIIIlIlI);
                this.setBlockState(lllllllllllllIIlIlllIlIIlIIlllII, this.cropTypeC.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlllIlIIlIIllIll, lllllllllllllIIlIlllIlIIlIIlIIlI, lllllllllllllIIlIlllIlIIlIIlIIll)), 8, 1, lllllllllllllIIlIlllIlIIlIIllIII, lllllllllllllIIlIlllIlIIlIIIlIlI);
                final int lllllllllllllIIlIlllIlIIlIIlIIIl = ((BlockCrops)this.cropTypeD).getMaxAge();
                final int lllllllllllllIIlIlllIlIIlIIlIIII = lllllllllllllIIlIlllIlIIlIIlIIIl / 3;
                this.setBlockState(lllllllllllllIIlIlllIlIIlIIlllII, this.cropTypeD.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlllIlIIlIIllIll, lllllllllllllIIlIlllIlIIlIIlIIII, lllllllllllllIIlIlllIlIIlIIlIIIl)), 10, 1, lllllllllllllIIlIlllIlIIlIIllIII, lllllllllllllIIlIlllIlIIlIIIlIlI);
                this.setBlockState(lllllllllllllIIlIlllIlIIlIIlllII, this.cropTypeD.getStateFromMeta(MathHelper.getInt(lllllllllllllIIlIlllIlIIlIIllIll, lllllllllllllIIlIlllIlIIlIIlIIII, lllllllllllllIIlIlllIlIIlIIlIIIl)), 11, 1, lllllllllllllIIlIlllIlIIlIIllIII, lllllllllllllIIlIlllIlIIlIIIlIlI);
            }
            for (int lllllllllllllIIlIlllIlIIlIIIllll = 0; lllllllllllllIIlIlllIlIIlIIIllll < 9; ++lllllllllllllIIlIlllIlIIlIIIllll) {
                for (int lllllllllllllIIlIlllIlIIlIIIlllI = 0; lllllllllllllIIlIlllIlIIlIIIlllI < 13; ++lllllllllllllIIlIlllIlIIlIIIlllI) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllIIlIlllIlIIlIIlllII, lllllllllllllIIlIlllIlIIlIIIlllI, 4, lllllllllllllIIlIlllIlIIlIIIllll, lllllllllllllIIlIlllIlIIlIIIlIlI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllIIlIlllIlIIlIIlllII, Blocks.DIRT.getDefaultState(), lllllllllllllIIlIlllIlIIlIIIlllI, -1, lllllllllllllIIlIlllIlIIlIIIllll, lllllllllllllIIlIlllIlIIlIIIlIlI);
                }
            }
            return true;
        }
        
        public static Field1 createPiece(final Start lllllllllllllIIlIlllIlIIlIllllIl, final List<StructureComponent> lllllllllllllIIlIlllIlIIlIllIIll, final Random lllllllllllllIIlIlllIlIIlIllIIlI, final int lllllllllllllIIlIlllIlIIlIllIIIl, final int lllllllllllllIIlIlllIlIIlIlllIIl, final int lllllllllllllIIlIlllIlIIlIlllIII, final EnumFacing lllllllllllllIIlIlllIlIIlIllIlll, final int lllllllllllllIIlIlllIlIIlIlIllIl) {
            final StructureBoundingBox lllllllllllllIIlIlllIlIIlIllIlIl = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIlIlllIlIIlIllIIIl, lllllllllllllIIlIlllIlIIlIlllIIl, lllllllllllllIIlIlllIlIIlIlllIII, 0, 0, 0, 13, 4, 9, lllllllllllllIIlIlllIlIIlIllIlll);
            return (Village.canVillageGoDeeper(lllllllllllllIIlIlllIlIIlIllIlIl) && StructureComponent.findIntersecting(lllllllllllllIIlIlllIlIIlIllIIll, lllllllllllllIIlIlllIlIIlIllIlIl) == null) ? new Field1(lllllllllllllIIlIlllIlIIlIllllIl, lllllllllllllIIlIlllIlIIlIlIllIl, lllllllllllllIIlIlllIlIIlIllIIlI, lllllllllllllIIlIlllIlIIlIllIlIl, lllllllllllllIIlIlllIlIIlIllIlll) : null;
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIIlIlllIlIIllIIllll, final TemplateManager lllllllllllllIIlIlllIlIIllIIlIll) {
            super.readStructureFromNBT(lllllllllllllIIlIlllIlIIllIIllll, lllllllllllllIIlIlllIlIIllIIlIll);
            this.cropTypeA = Block.getBlockById(lllllllllllllIIlIlllIlIIllIIllll.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(lllllllllllllIIlIlllIlIIllIIllll.getInteger("CB"));
            this.cropTypeC = Block.getBlockById(lllllllllllllIIlIlllIlIIllIIllll.getInteger("CC"));
            this.cropTypeD = Block.getBlockById(lllllllllllllIIlIlllIlIIllIIllll.getInteger("CD"));
            if (!(this.cropTypeA instanceof BlockCrops)) {
                this.cropTypeA = Blocks.WHEAT;
            }
            if (!(this.cropTypeB instanceof BlockCrops)) {
                this.cropTypeB = Blocks.CARROTS;
            }
            if (!(this.cropTypeC instanceof BlockCrops)) {
                this.cropTypeC = Blocks.POTATOES;
            }
            if (!(this.cropTypeD instanceof BlockCrops)) {
                this.cropTypeD = Blocks.BEETROOTS;
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIIlIlllIlIIllIlIllI) {
            super.writeStructureToNBT(lllllllllllllIIlIlllIlIIllIlIllI);
            lllllllllllllIIlIlllIlIIllIlIllI.setInteger("CA", Block.REGISTRY.getIDForObject(this.cropTypeA));
            lllllllllllllIIlIlllIlIIllIlIllI.setInteger("CB", Block.REGISTRY.getIDForObject(this.cropTypeB));
            lllllllllllllIIlIlllIlIIllIlIllI.setInteger("CC", Block.REGISTRY.getIDForObject(this.cropTypeC));
            lllllllllllllIIlIlllIlIIllIlIllI.setInteger("CD", Block.REGISTRY.getIDForObject(this.cropTypeD));
        }
    }
    
    public static class Torch extends Village
    {
        public Torch() {
        }
        
        public static StructureBoundingBox findPieceBox(final Start lllllllllllllIIIIlIIIIlIIIlIIIIl, final List<StructureComponent> lllllllllllllIIIIlIIIIlIIIlIIIII, final Random lllllllllllllIIIIlIIIIlIIIIlllll, final int lllllllllllllIIIIlIIIIlIIIIllIII, final int lllllllllllllIIIIlIIIIlIIIIlIlll, final int lllllllllllllIIIIlIIIIlIIIIlIllI, final EnumFacing lllllllllllllIIIIlIIIIlIIIIlIlIl) {
            final StructureBoundingBox lllllllllllllIIIIlIIIIlIIIIllIlI = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllIIIIlIIIIlIIIIllIII, lllllllllllllIIIIlIIIIlIIIIlIlll, lllllllllllllIIIIlIIIIlIIIIlIllI, 0, 0, 0, 3, 4, 2, lllllllllllllIIIIlIIIIlIIIIlIlIl);
            return (StructureComponent.findIntersecting(lllllllllllllIIIIlIIIIlIIIlIIIII, lllllllllllllIIIIlIIIIlIIIIllIlI) != null) ? null : lllllllllllllIIIIlIIIIlIIIIllIlI;
        }
        
        public Torch(final Start lllllllllllllIIIIlIIIIlIIIlIlIll, final int lllllllllllllIIIIlIIIIlIIIllIIII, final Random lllllllllllllIIIIlIIIIlIIIlIllll, final StructureBoundingBox lllllllllllllIIIIlIIIIlIIIlIlllI, final EnumFacing lllllllllllllIIIIlIIIIlIIIlIlIII) {
            super(lllllllllllllIIIIlIIIIlIIIlIlIll, lllllllllllllIIIIlIIIIlIIIllIIII);
            this.setCoordBaseMode(lllllllllllllIIIIlIIIIlIIIlIlIII);
            this.boundingBox = lllllllllllllIIIIlIIIIlIIIlIlllI;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllIIIIlIIIIlIIIIIlllI, final Random lllllllllllllIIIIlIIIIlIIIIIllIl, final StructureBoundingBox lllllllllllllIIIIlIIIIlIIIIIllII) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllIIIIlIIIIlIIIIIlllI, lllllllllllllIIIIlIIIIlIIIIIllII);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 4 - 1, 0);
            }
            final IBlockState lllllllllllllIIIIlIIIIlIIIIIlIll = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(lllllllllllllIIIIlIIIIlIIIIIlllI, lllllllllllllIIIIlIIIIlIIIIIllII, 0, 0, 0, 2, 3, 1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.setBlockState(lllllllllllllIIIIlIIIIlIIIIIlllI, lllllllllllllIIIIlIIIIlIIIIIlIll, 1, 0, 0, lllllllllllllIIIIlIIIIlIIIIIllII);
            this.setBlockState(lllllllllllllIIIIlIIIIlIIIIIlllI, lllllllllllllIIIIlIIIIlIIIIIlIll, 1, 1, 0, lllllllllllllIIIIlIIIIlIIIIIllII);
            this.setBlockState(lllllllllllllIIIIlIIIIlIIIIIlllI, lllllllllllllIIIIlIIIIlIIIIIlIll, 1, 2, 0, lllllllllllllIIIIlIIIIlIIIIIllII);
            this.setBlockState(lllllllllllllIIIIlIIIIlIIIIIlllI, Blocks.WOOL.getStateFromMeta(EnumDyeColor.WHITE.getDyeDamage()), 1, 3, 0, lllllllllllllIIIIlIIIIlIIIIIllII);
            this.func_189926_a(lllllllllllllIIIIlIIIIlIIIIIlllI, EnumFacing.EAST, 2, 3, 0, lllllllllllllIIIIlIIIIlIIIIIllII);
            this.func_189926_a(lllllllllllllIIIIlIIIIlIIIIIlllI, EnumFacing.NORTH, 1, 3, 1, lllllllllllllIIIIlIIIIlIIIIIllII);
            this.func_189926_a(lllllllllllllIIIIlIIIIlIIIIIlllI, EnumFacing.WEST, 0, 3, 0, lllllllllllllIIIIlIIIIlIIIIIllII);
            this.func_189926_a(lllllllllllllIIIIlIIIIlIIIIIlllI, EnumFacing.SOUTH, 1, 3, -1, lllllllllllllIIIIlIIIIlIIIIIllII);
            return true;
        }
    }
    
    public static class House3 extends Village
    {
        public House3(final Start lllllllllllllllllIIllllIIIllIIll, final int lllllllllllllllllIIllllIIIlIllII, final Random lllllllllllllllllIIllllIIIllIIIl, final StructureBoundingBox lllllllllllllllllIIllllIIIlIlIll, final EnumFacing lllllllllllllllllIIllllIIIlIllll) {
            super(lllllllllllllllllIIllllIIIllIIll, lllllllllllllllllIIllllIIIlIllII);
            this.setCoordBaseMode(lllllllllllllllllIIllllIIIlIllll);
            this.boundingBox = lllllllllllllllllIIllllIIIlIlIll;
        }
        
        @Override
        public boolean addComponentParts(final World lllllllllllllllllIIlllIllllIIIll, final Random lllllllllllllllllIIlllIllllIIIlI, final StructureBoundingBox lllllllllllllllllIIlllIllllllIlI) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 7 - 1, 0);
            }
            final IBlockState lllllllllllllllllIIlllIllllllIIl = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState lllllllllllllllllIIlllIllllllIII = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState lllllllllllllllllIIlllIlllllIlll = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.SOUTH));
            final IBlockState lllllllllllllllllIIlllIlllllIllI = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.EAST));
            final IBlockState lllllllllllllllllIIlllIlllllIlIl = this.getBiomeSpecificBlockState(Blocks.OAK_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.WEST));
            final IBlockState lllllllllllllllllIIlllIlllllIlII = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState lllllllllllllllllIIlllIlllllIIll = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 1, 1, 1, 7, 4, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 2, 1, 6, 8, 4, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 2, 0, 5, 8, 0, 10, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 1, 0, 1, 7, 0, 4, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 0, 0, 0, 0, 3, 5, lllllllllllllllllIIlllIllllllIIl, lllllllllllllllllIIlllIllllllIIl, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 8, 0, 0, 8, 3, 10, lllllllllllllllllIIlllIllllllIIl, lllllllllllllllllIIlllIllllllIIl, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 1, 0, 0, 7, 2, 0, lllllllllllllllllIIlllIllllllIIl, lllllllllllllllllIIlllIllllllIIl, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 1, 0, 5, 2, 1, 5, lllllllllllllllllIIlllIllllllIIl, lllllllllllllllllIIlllIllllllIIl, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 2, 0, 6, 2, 3, 10, lllllllllllllllllIIlllIllllllIIl, lllllllllllllllllIIlllIllllllIIl, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 3, 0, 10, 7, 3, 10, lllllllllllllllllIIlllIllllllIIl, lllllllllllllllllIIlllIllllllIIl, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 1, 2, 0, 7, 3, 0, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 1, 2, 5, 2, 3, 5, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 0, 4, 1, 8, 4, 1, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 0, 4, 4, 3, 4, 4, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 0, 5, 2, 8, 5, 3, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 0, 4, 2, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 0, 4, 3, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 8, 4, 2, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 8, 4, 3, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 8, 4, 4, lllllllllllllllllIIlllIllllllIlI);
            final IBlockState lllllllllllllllllIIlllIlllllIIlI = lllllllllllllllllIIlllIllllllIII;
            final IBlockState lllllllllllllllllIIlllIlllllIIIl = lllllllllllllllllIIlllIlllllIlll;
            final IBlockState lllllllllllllllllIIlllIlllllIIII = lllllllllllllllllIIlllIlllllIlIl;
            final IBlockState lllllllllllllllllIIlllIllllIllll = lllllllllllllllllIIlllIlllllIllI;
            for (int lllllllllllllllllIIlllIllllIlllI = -1; lllllllllllllllllIIlllIllllIlllI <= 2; ++lllllllllllllllllIIlllIllllIlllI) {
                for (int lllllllllllllllllIIlllIllllIllIl = 0; lllllllllllllllllIIlllIllllIllIl <= 8; ++lllllllllllllllllIIlllIllllIllIl) {
                    this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIlI, lllllllllllllllllIIlllIllllIllIl, 4 + lllllllllllllllllIIlllIllllIlllI, lllllllllllllllllIIlllIllllIlllI, lllllllllllllllllIIlllIllllllIlI);
                    if ((lllllllllllllllllIIlllIllllIlllI > -1 || lllllllllllllllllIIlllIllllIllIl <= 1) && (lllllllllllllllllIIlllIllllIlllI > 0 || lllllllllllllllllIIlllIllllIllIl <= 3) && (lllllllllllllllllIIlllIllllIlllI > 1 || lllllllllllllllllIIlllIllllIllIl <= 4 || lllllllllllllllllIIlllIllllIllIl >= 6)) {
                        this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIIl, lllllllllllllllllIIlllIllllIllIl, 4 + lllllllllllllllllIIlllIllllIlllI, 5 - lllllllllllllllllIIlllIllllIlllI, lllllllllllllllllIIlllIllllllIlI);
                    }
                }
            }
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 3, 4, 5, 3, 4, 10, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 7, 4, 2, 7, 4, 10, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 4, 5, 4, 4, 5, 10, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 6, 5, 4, 6, 5, 10, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 5, 6, 3, 5, 6, 10, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIlllllIlII, false);
            for (int lllllllllllllllllIIlllIllllIllII = 4; lllllllllllllllllIIlllIllllIllII >= 1; --lllllllllllllllllIIlllIllllIllII) {
                this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, lllllllllllllllllIIlllIllllIllII, 2 + lllllllllllllllllIIlllIllllIllII, 7 - lllllllllllllllllIIlllIllllIllII, lllllllllllllllllIIlllIllllllIlI);
                for (int lllllllllllllllllIIlllIllllIlIll = 8 - lllllllllllllllllIIlllIllllIllII; lllllllllllllllllIIlllIllllIlIll <= 10; ++lllllllllllllllllIIlllIllllIlIll) {
                    this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllIllll, lllllllllllllllllIIlllIllllIllII, 2 + lllllllllllllllllIIlllIllllIllII, lllllllllllllllllIIlllIllllIlIll, lllllllllllllllllIIlllIllllllIlI);
                }
            }
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 6, 6, 3, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 7, 5, 4, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlIl, 6, 6, 4, lllllllllllllllllIIlllIllllllIlI);
            for (int lllllllllllllllllIIlllIllllIlIlI = 6; lllllllllllllllllIIlllIllllIlIlI <= 8; ++lllllllllllllllllIIlllIllllIlIlI) {
                for (int lllllllllllllllllIIlllIllllIlIIl = 5; lllllllllllllllllIIlllIllllIlIIl <= 10; ++lllllllllllllllllIIlllIllllIlIIl) {
                    this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIII, lllllllllllllllllIIlllIllllIlIlI, 12 - lllllllllllllllllIIlllIllllIlIlI, lllllllllllllllllIIlllIllllIlIIl, lllllllllllllllllIIlllIllllllIlI);
                }
            }
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 0, 2, 1, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 0, 2, 4, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 4, 2, 0, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 5, 2, 0, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 6, 2, 0, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 8, 2, 1, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 2, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 8, 2, 4, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 8, 2, 5, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 8, 2, 6, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 7, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 8, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 8, 2, 9, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 2, 2, 6, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 7, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 8, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 2, 2, 9, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 4, 4, 10, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GLASS_PANE.getDefaultState(), 5, 4, 10, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIll, 6, 4, 10, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIlII, 5, 5, 10, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.AIR.getDefaultState(), 2, 1, 0, lllllllllllllllllIIlllIllllllIlI);
            this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.AIR.getDefaultState(), 2, 2, 0, lllllllllllllllllIIlllIllllllIlI);
            this.func_189926_a(lllllllllllllllllIIlllIllllIIIll, EnumFacing.NORTH, 2, 3, 1, lllllllllllllllllIIlllIllllllIlI);
            this.func_189927_a(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, lllllllllllllllllIIlllIllllIIIlI, 2, 1, 0, EnumFacing.NORTH);
            this.fillWithBlocks(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 1, 0, -1, 3, 2, -1, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            if (this.getBlockStateFromPos(lllllllllllllllllIIlllIllllIIIll, 2, 0, -1, lllllllllllllllllIIlllIllllllIlI).getMaterial() == Material.AIR && this.getBlockStateFromPos(lllllllllllllllllIIlllIllllIIIll, 2, -1, -1, lllllllllllllllllIIlllIllllllIlI).getMaterial() != Material.AIR) {
                this.setBlockState(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIlllllIIlI, 2, 0, -1, lllllllllllllllllIIlllIllllllIlI);
                if (this.getBlockStateFromPos(lllllllllllllllllIIlllIllllIIIll, 2, -1, -1, lllllllllllllllllIIlllIllllllIlI).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(lllllllllllllllllIIlllIllllIIIll, Blocks.GRASS.getDefaultState(), 2, -1, -1, lllllllllllllllllIIlllIllllllIlI);
                }
            }
            for (int lllllllllllllllllIIlllIllllIlIII = 0; lllllllllllllllllIIlllIllllIlIII < 5; ++lllllllllllllllllIIlllIllllIlIII) {
                for (int lllllllllllllllllIIlllIllllIIlll = 0; lllllllllllllllllIIlllIllllIIlll < 9; ++lllllllllllllllllIIlllIllllIIlll) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllIIlll, 7, lllllllllllllllllIIlllIllllIlIII, lllllllllllllllllIIlllIllllllIlI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIIl, lllllllllllllllllIIlllIllllIIlll, -1, lllllllllllllllllIIlllIllllIlIII, lllllllllllllllllIIlllIllllllIlI);
                }
            }
            for (int lllllllllllllllllIIlllIllllIIllI = 5; lllllllllllllllllIIlllIllllIIllI < 11; ++lllllllllllllllllIIlllIllllIIllI) {
                for (int lllllllllllllllllIIlllIllllIIlIl = 2; lllllllllllllllllIIlllIllllIIlIl < 9; ++lllllllllllllllllIIlllIllllIIlIl) {
                    this.clearCurrentPositionBlocksUpwards(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllIIlIl, 7, lllllllllllllllllIIlllIllllIIllI, lllllllllllllllllIIlllIllllllIlI);
                    this.replaceAirAndLiquidDownwards(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIIl, lllllllllllllllllIIlllIllllIIlIl, -1, lllllllllllllllllIIlllIllllIIllI, lllllllllllllllllIIlllIllllllIlI);
                }
            }
            this.spawnVillagers(lllllllllllllllllIIlllIllllIIIll, lllllllllllllllllIIlllIllllllIlI, 4, 1, 2, 2);
            return true;
        }
        
        public static House3 createPiece(final Start lllllllllllllllllIIllllIIIlIIIII, final List<StructureComponent> lllllllllllllllllIIllllIIIIlIllI, final Random lllllllllllllllllIIllllIIIIlIlIl, final int lllllllllllllllllIIllllIIIIlIlII, final int lllllllllllllllllIIllllIIIIlllII, final int lllllllllllllllllIIllllIIIIlIIlI, final EnumFacing lllllllllllllllllIIllllIIIIlIIIl, final int lllllllllllllllllIIllllIIIIlIIII) {
            final StructureBoundingBox lllllllllllllllllIIllllIIIIllIII = StructureBoundingBox.getComponentToAddBoundingBox(lllllllllllllllllIIllllIIIIlIlII, lllllllllllllllllIIllllIIIIlllII, lllllllllllllllllIIllllIIIIlIIlI, 0, 0, 0, 9, 7, 12, lllllllllllllllllIIllllIIIIlIIIl);
            return (Village.canVillageGoDeeper(lllllllllllllllllIIllllIIIIllIII) && StructureComponent.findIntersecting(lllllllllllllllllIIllllIIIIlIllI, lllllllllllllllllIIllllIIIIllIII) == null) ? new House3(lllllllllllllllllIIllllIIIlIIIII, lllllllllllllllllIIllllIIIIlIIII, lllllllllllllllllIIllllIIIIlIlIl, lllllllllllllllllIIllllIIIIllIII, lllllllllllllllllIIllllIIIIlIIIl) : null;
        }
        
        public House3() {
        }
    }
    
    public static class WoodHut extends Village
    {
        private /* synthetic */ boolean isTallHouse;
        private /* synthetic */ int tablePosition;
        
        @Override
        public boolean addComponentParts(final World llllllllllllllIIlIIlIllIIlIlllIl, final Random llllllllllllllIIlIIlIllIIllIIlll, final StructureBoundingBox llllllllllllllIIlIIlIllIIllIIllI) {
            if (this.averageGroundLvl < 0) {
                this.averageGroundLvl = this.getAverageGroundLevel(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI);
                if (this.averageGroundLvl < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 6 - 1, 0);
            }
            final IBlockState llllllllllllllIIlIIlIllIIllIIlIl = this.getBiomeSpecificBlockState(Blocks.COBBLESTONE.getDefaultState());
            final IBlockState llllllllllllllIIlIIlIllIIllIIlII = this.getBiomeSpecificBlockState(Blocks.PLANKS.getDefaultState());
            final IBlockState llllllllllllllIIlIIlIllIIllIIIll = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty((IProperty<Comparable>)BlockStairs.FACING, EnumFacing.NORTH));
            final IBlockState llllllllllllllIIlIIlIllIIllIIIlI = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
            final IBlockState llllllllllllllIIlIIlIllIIllIIIIl = this.getBiomeSpecificBlockState(Blocks.OAK_FENCE.getDefaultState());
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 1, 1, 1, 3, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 0, 0, 0, 3, 0, 4, llllllllllllllIIlIIlIllIIllIIlIl, llllllllllllllIIlIIlIllIIllIIlIl, false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 1, 0, 1, 2, 0, 3, Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState(), false);
            if (this.isTallHouse) {
                this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 1, 4, 1, 2, 4, 3, llllllllllllllIIlIIlIllIIllIIIlI, llllllllllllllIIlIIlIllIIllIIIlI, false);
            }
            else {
                this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 1, 5, 1, 2, 5, 3, llllllllllllllIIlIIlIllIIllIIIlI, llllllllllllllIIlIIlIllIIllIIIlI, false);
            }
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 1, 4, 0, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 2, 4, 0, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 1, 4, 4, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 2, 4, 4, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 0, 4, 1, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 0, 4, 2, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 0, 4, 3, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 3, 4, 1, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 3, 4, 2, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIlI, 3, 4, 3, llllllllllllllIIlIIlIllIIllIIllI);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 0, 1, 0, 0, 3, 0, llllllllllllllIIlIIlIllIIllIIIlI, llllllllllllllIIlIIlIllIIllIIIlI, false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 3, 1, 0, 3, 3, 0, llllllllllllllIIlIIlIllIIllIIIlI, llllllllllllllIIlIIlIllIIllIIIlI, false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 0, 1, 4, 0, 3, 4, llllllllllllllIIlIIlIllIIllIIIlI, llllllllllllllIIlIIlIllIIllIIIlI, false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 3, 1, 4, 3, 3, 4, llllllllllllllIIlIIlIllIIllIIIlI, llllllllllllllIIlIIlIllIIllIIIlI, false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 0, 1, 1, 0, 3, 3, llllllllllllllIIlIIlIllIIllIIlII, llllllllllllllIIlIIlIllIIllIIlII, false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 3, 1, 1, 3, 3, 3, llllllllllllllIIlIIlIllIIllIIlII, llllllllllllllIIlIIlIllIIllIIlII, false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 1, 1, 0, 2, 3, 0, llllllllllllllIIlIIlIllIIllIIlII, llllllllllllllIIlIIlIllIIllIIlII, false);
            this.fillWithBlocks(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 1, 1, 4, 2, 3, 4, llllllllllllllIIlIIlIllIIllIIlII, llllllllllllllIIlIIlIllIIllIIlII, false);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, Blocks.GLASS_PANE.getDefaultState(), 3, 2, 2, llllllllllllllIIlIIlIllIIllIIllI);
            if (this.tablePosition > 0) {
                this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIIl, this.tablePosition, 1, 3, llllllllllllllIIlIIlIllIIllIIllI);
                this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), this.tablePosition, 2, 3, llllllllllllllIIlIIlIllIIllIIllI);
            }
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, Blocks.AIR.getDefaultState(), 1, 1, 0, llllllllllllllIIlIIlIllIIllIIllI);
            this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, Blocks.AIR.getDefaultState(), 1, 2, 0, llllllllllllllIIlIIlIllIIllIIllI);
            this.func_189927_a(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, llllllllllllllIIlIIlIllIIllIIlll, 1, 1, 0, EnumFacing.NORTH);
            if (this.getBlockStateFromPos(llllllllllllllIIlIIlIllIIlIlllIl, 1, 0, -1, llllllllllllllIIlIIlIllIIllIIllI).getMaterial() == Material.AIR && this.getBlockStateFromPos(llllllllllllllIIlIIlIllIIlIlllIl, 1, -1, -1, llllllllllllllIIlIIlIllIIllIIllI).getMaterial() != Material.AIR) {
                this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIIll, 1, 0, -1, llllllllllllllIIlIIlIllIIllIIllI);
                if (this.getBlockStateFromPos(llllllllllllllIIlIIlIllIIlIlllIl, 1, -1, -1, llllllllllllllIIlIIlIllIIllIIllI).getBlock() == Blocks.GRASS_PATH) {
                    this.setBlockState(llllllllllllllIIlIIlIllIIlIlllIl, Blocks.GRASS.getDefaultState(), 1, -1, -1, llllllllllllllIIlIIlIllIIllIIllI);
                }
            }
            for (int llllllllllllllIIlIIlIllIIllIIIII = 0; llllllllllllllIIlIIlIllIIllIIIII < 5; ++llllllllllllllIIlIIlIllIIllIIIII) {
                for (int llllllllllllllIIlIIlIllIIlIlllll = 0; llllllllllllllIIlIIlIllIIlIlllll < 4; ++llllllllllllllIIlIIlIllIIlIlllll) {
                    this.clearCurrentPositionBlocksUpwards(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIlIlllll, 6, llllllllllllllIIlIIlIllIIllIIIII, llllllllllllllIIlIIlIllIIllIIllI);
                    this.replaceAirAndLiquidDownwards(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIlIl, llllllllllllllIIlIIlIllIIlIlllll, -1, llllllllllllllIIlIIlIllIIllIIIII, llllllllllllllIIlIIlIllIIllIIllI);
                }
            }
            this.spawnVillagers(llllllllllllllIIlIIlIllIIlIlllIl, llllllllllllllIIlIIlIllIIllIIllI, 1, 1, 2, 1);
            return true;
        }
        
        public WoodHut(final Start llllllllllllllIIlIIlIllIlIlIIIll, final int llllllllllllllIIlIIlIllIlIlIIIlI, final Random llllllllllllllIIlIIlIllIlIlIIlll, final StructureBoundingBox llllllllllllllIIlIIlIllIlIlIIllI, final EnumFacing llllllllllllllIIlIIlIllIlIlIIlIl) {
            super(llllllllllllllIIlIIlIllIlIlIIIll, llllllllllllllIIlIIlIllIlIlIIIlI);
            this.setCoordBaseMode(llllllllllllllIIlIIlIllIlIlIIlIl);
            this.boundingBox = llllllllllllllIIlIIlIllIlIlIIllI;
            this.isTallHouse = llllllllllllllIIlIIlIllIlIlIIlll.nextBoolean();
            this.tablePosition = llllllllllllllIIlIIlIllIlIlIIlll.nextInt(3);
        }
        
        public WoodHut() {
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIIlIIlIllIlIIllIIl) {
            super.writeStructureToNBT(llllllllllllllIIlIIlIllIlIIllIIl);
            llllllllllllllIIlIIlIllIlIIllIIl.setInteger("T", this.tablePosition);
            llllllllllllllIIlIIlIllIlIIllIIl.setBoolean("C", this.isTallHouse);
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIIlIIlIllIlIIlIIIl, final TemplateManager llllllllllllllIIlIIlIllIlIIlIIII) {
            super.readStructureFromNBT(llllllllllllllIIlIIlIllIlIIlIIIl, llllllllllllllIIlIIlIllIlIIlIIII);
            this.tablePosition = llllllllllllllIIlIIlIllIlIIlIIIl.getInteger("T");
            this.isTallHouse = llllllllllllllIIlIIlIllIlIIlIIIl.getBoolean("C");
        }
        
        public static WoodHut createPiece(final Start llllllllllllllIIlIIlIllIIlllllIl, final List<StructureComponent> llllllllllllllIIlIIlIllIIlllllII, final Random llllllllllllllIIlIIlIllIlIIIIlII, final int llllllllllllllIIlIIlIllIIllllIlI, final int llllllllllllllIIlIIlIllIlIIIIIlI, final int llllllllllllllIIlIIlIllIlIIIIIIl, final EnumFacing llllllllllllllIIlIIlIllIIlllIlll, final int llllllllllllllIIlIIlIllIIlllllll) {
            final StructureBoundingBox llllllllllllllIIlIIlIllIIllllllI = StructureBoundingBox.getComponentToAddBoundingBox(llllllllllllllIIlIIlIllIIllllIlI, llllllllllllllIIlIIlIllIlIIIIIlI, llllllllllllllIIlIIlIllIlIIIIIIl, 0, 0, 0, 4, 6, 5, llllllllllllllIIlIIlIllIIlllIlll);
            return (Village.canVillageGoDeeper(llllllllllllllIIlIIlIllIIllllllI) && StructureComponent.findIntersecting(llllllllllllllIIlIIlIllIIlllllII, llllllllllllllIIlIIlIllIIllllllI) == null) ? new WoodHut(llllllllllllllIIlIIlIllIIlllllIl, llllllllllllllIIlIIlIllIIlllllll, llllllllllllllIIlIIlIllIlIIIIlII, llllllllllllllIIlIIlIllIIllllllI, llllllllllllllIIlIIlIllIIlllIlll) : null;
        }
    }
}
