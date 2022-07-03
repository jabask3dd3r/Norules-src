package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.util.*;
import net.minecraft.server.*;
import net.minecraft.world.gen.structure.template.*;

public class WorldGenFossils extends WorldGenerator
{
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_02;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_04;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_01_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_04_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_02;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_03_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_03;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_04;
    private static final /* synthetic */ ResourceLocation[] FOSSILS;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_03_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_01;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_01_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SPINE_02_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_04_COAL;
    private static final /* synthetic */ ResourceLocation[] FOSSILS_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_03;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_02_COAL;
    private static final /* synthetic */ ResourceLocation STRUCTURE_SKULL_01;
    
    @Override
    public boolean generate(final World llIIlllIlllllIl, final Random llIIllllIIlIIlI, final BlockPos llIIlllIlllllII) {
        final Random llIIllllIIlIIII = llIIlllIlllllIl.getChunkFromBlockCoords(llIIlllIlllllII).getRandomWithSeed(987234911L);
        final MinecraftServer llIIllllIIIllll = llIIlllIlllllIl.getMinecraftServer();
        final Rotation[] llIIllllIIIlllI = Rotation.values();
        final Rotation llIIllllIIIllIl = llIIllllIIIlllI[llIIllllIIlIIII.nextInt(llIIllllIIIlllI.length)];
        final int llIIllllIIIllII = llIIllllIIlIIII.nextInt(WorldGenFossils.FOSSILS.length);
        final TemplateManager llIIllllIIIlIll = llIIlllIlllllIl.getSaveHandler().getStructureTemplateManager();
        final Template llIIllllIIIlIlI = llIIllllIIIlIll.getTemplate(llIIllllIIIllll, WorldGenFossils.FOSSILS[llIIllllIIIllII]);
        final Template llIIllllIIIlIIl = llIIllllIIIlIll.getTemplate(llIIllllIIIllll, WorldGenFossils.FOSSILS_COAL[llIIllllIIIllII]);
        final ChunkPos llIIllllIIIlIII = new ChunkPos(llIIlllIlllllII);
        final StructureBoundingBox llIIllllIIIIlll = new StructureBoundingBox(llIIllllIIIlIII.getXStart(), 0, llIIllllIIIlIII.getZStart(), llIIllllIIIlIII.getXEnd(), 256, llIIllllIIIlIII.getZEnd());
        final PlacementSettings llIIllllIIIIllI = new PlacementSettings().setRotation(llIIllllIIIllIl).setBoundingBox(llIIllllIIIIlll).setRandom(llIIllllIIlIIII);
        final BlockPos llIIllllIIIIlIl = llIIllllIIIlIlI.transformedSize(llIIllllIIIllIl);
        final int llIIllllIIIIlII = llIIllllIIlIIII.nextInt(16 - llIIllllIIIIlIl.getX());
        final int llIIllllIIIIIll = llIIllllIIlIIII.nextInt(16 - llIIllllIIIIlIl.getZ());
        int llIIllllIIIIIlI = 256;
        for (int llIIllllIIIIIIl = 0; llIIllllIIIIIIl < llIIllllIIIIlIl.getX(); ++llIIllllIIIIIIl) {
            for (int llIIllllIIIIIII = 0; llIIllllIIIIIII < llIIllllIIIIlIl.getX(); ++llIIllllIIIIIII) {
                llIIllllIIIIIlI = Math.min(llIIllllIIIIIlI, llIIlllIlllllIl.getHeight(llIIlllIlllllII.getX() + llIIllllIIIIIIl + llIIllllIIIIlII, llIIlllIlllllII.getZ() + llIIllllIIIIIII + llIIllllIIIIIll));
            }
        }
        final int llIIlllIlllllll = Math.max(llIIllllIIIIIlI - 15 - llIIllllIIlIIII.nextInt(10), 10);
        final BlockPos llIIlllIllllllI = llIIllllIIIlIlI.getZeroPositionWithTransform(llIIlllIlllllII.add(llIIllllIIIIlII, llIIlllIlllllll, llIIllllIIIIIll), Mirror.NONE, llIIllllIIIllIl);
        llIIllllIIIIllI.setIntegrity(0.9f);
        llIIllllIIIlIlI.addBlocksToWorld(llIIlllIlllllIl, llIIlllIllllllI, llIIllllIIIIllI, 20);
        llIIllllIIIIllI.setIntegrity(0.1f);
        llIIllllIIIlIIl.addBlocksToWorld(llIIlllIlllllIl, llIIlllIllllllI, llIIllllIIIIllI, 20);
        return true;
    }
    
    static {
        STRUCTURE_SPINE_01 = new ResourceLocation("fossils/fossil_spine_01");
        STRUCTURE_SPINE_02 = new ResourceLocation("fossils/fossil_spine_02");
        STRUCTURE_SPINE_03 = new ResourceLocation("fossils/fossil_spine_03");
        STRUCTURE_SPINE_04 = new ResourceLocation("fossils/fossil_spine_04");
        STRUCTURE_SPINE_01_COAL = new ResourceLocation("fossils/fossil_spine_01_coal");
        STRUCTURE_SPINE_02_COAL = new ResourceLocation("fossils/fossil_spine_02_coal");
        STRUCTURE_SPINE_03_COAL = new ResourceLocation("fossils/fossil_spine_03_coal");
        STRUCTURE_SPINE_04_COAL = new ResourceLocation("fossils/fossil_spine_04_coal");
        STRUCTURE_SKULL_01 = new ResourceLocation("fossils/fossil_skull_01");
        STRUCTURE_SKULL_02 = new ResourceLocation("fossils/fossil_skull_02");
        STRUCTURE_SKULL_03 = new ResourceLocation("fossils/fossil_skull_03");
        STRUCTURE_SKULL_04 = new ResourceLocation("fossils/fossil_skull_04");
        STRUCTURE_SKULL_01_COAL = new ResourceLocation("fossils/fossil_skull_01_coal");
        STRUCTURE_SKULL_02_COAL = new ResourceLocation("fossils/fossil_skull_02_coal");
        STRUCTURE_SKULL_03_COAL = new ResourceLocation("fossils/fossil_skull_03_coal");
        STRUCTURE_SKULL_04_COAL = new ResourceLocation("fossils/fossil_skull_04_coal");
        FOSSILS = new ResourceLocation[] { WorldGenFossils.STRUCTURE_SPINE_01, WorldGenFossils.STRUCTURE_SPINE_02, WorldGenFossils.STRUCTURE_SPINE_03, WorldGenFossils.STRUCTURE_SPINE_04, WorldGenFossils.STRUCTURE_SKULL_01, WorldGenFossils.STRUCTURE_SKULL_02, WorldGenFossils.STRUCTURE_SKULL_03, WorldGenFossils.STRUCTURE_SKULL_04 };
        FOSSILS_COAL = new ResourceLocation[] { WorldGenFossils.STRUCTURE_SPINE_01_COAL, WorldGenFossils.STRUCTURE_SPINE_02_COAL, WorldGenFossils.STRUCTURE_SPINE_03_COAL, WorldGenFossils.STRUCTURE_SPINE_04_COAL, WorldGenFossils.STRUCTURE_SKULL_01_COAL, WorldGenFossils.STRUCTURE_SKULL_02_COAL, WorldGenFossils.STRUCTURE_SKULL_03_COAL, WorldGenFossils.STRUCTURE_SKULL_04_COAL };
    }
}
