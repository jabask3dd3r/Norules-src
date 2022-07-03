package net.minecraft.world.gen.structure;

import com.google.common.collect.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.server.*;
import net.minecraft.world.gen.structure.template.*;

public class StructureEndCityPieces
{
    private static final /* synthetic */ IGenerator FAT_TOWER_GENERATOR;
    private static final /* synthetic */ PlacementSettings OVERWRITE;
    private static final /* synthetic */ IGenerator TOWER_BRIDGE_GENERATOR;
    private static final /* synthetic */ PlacementSettings INSERT;
    private static final /* synthetic */ IGenerator HOUSE_TOWER_GENERATOR;
    private static final /* synthetic */ List<Tuple<Rotation, BlockPos>> FAT_TOWER_BRIDGES;
    private static final /* synthetic */ List<Tuple<Rotation, BlockPos>> TOWER_BRIDGES;
    private static final /* synthetic */ IGenerator TOWER_GENERATOR;
    
    private static CityTemplate func_191090_b(final TemplateManager lllllllllllllIlIIllIlIllllIIlIll, final CityTemplate lllllllllllllIlIIllIlIllllIIIIlI, final BlockPos lllllllllllllIlIIllIlIllllIIlIIl, final String lllllllllllllIlIIllIlIllllIIIIII, final Rotation lllllllllllllIlIIllIlIlllIllllll, final boolean lllllllllllllIlIIllIlIlllIlllllI) {
        final CityTemplate lllllllllllllIlIIllIlIllllIIIlIl = new CityTemplate(lllllllllllllIlIIllIlIllllIIlIll, lllllllllllllIlIIllIlIllllIIIIII, lllllllllllllIlIIllIlIllllIIIIlI.templatePosition, lllllllllllllIlIIllIlIlllIllllll, lllllllllllllIlIIllIlIlllIlllllI);
        final BlockPos lllllllllllllIlIIllIlIllllIIIlII = lllllllllllllIlIIllIlIllllIIIIlI.template.calculateConnectedPos(lllllllllllllIlIIllIlIllllIIIIlI.placeSettings, lllllllllllllIlIIllIlIllllIIlIIl, lllllllllllllIlIIllIlIllllIIIlIl.placeSettings, BlockPos.ORIGIN);
        lllllllllllllIlIIllIlIllllIIIlIl.offset(lllllllllllllIlIIllIlIllllIIIlII.getX(), lllllllllllllIlIIllIlIllllIIIlII.getY(), lllllllllllllIlIIllIlIllllIIIlII.getZ());
        return lllllllllllllIlIIllIlIllllIIIlIl;
    }
    
    private static boolean func_191088_b(final TemplateManager lllllllllllllIlIIllIlIlllIIIlIlI, final IGenerator lllllllllllllIlIIllIlIlllIIIlIIl, final int lllllllllllllIlIIllIlIlllIIlIlII, final CityTemplate lllllllllllllIlIIllIlIlllIIlIIll, final BlockPos lllllllllllllIlIIllIlIlllIIlIIlI, final List<StructureComponent> lllllllllllllIlIIllIlIlllIIIIIll, final Random lllllllllllllIlIIllIlIlllIIlIIII) {
        if (lllllllllllllIlIIllIlIlllIIlIlII > 8) {
            return false;
        }
        final List<StructureComponent> lllllllllllllIlIIllIlIlllIIIllll = (List<StructureComponent>)Lists.newArrayList();
        if (lllllllllllllIlIIllIlIlllIIIlIIl.func_191086_a(lllllllllllllIlIIllIlIlllIIIlIlI, lllllllllllllIlIIllIlIlllIIlIlII, lllllllllllllIlIIllIlIlllIIlIIll, lllllllllllllIlIIllIlIlllIIlIIlI, lllllllllllllIlIIllIlIlllIIIllll, lllllllllllllIlIIllIlIlllIIlIIII)) {
            boolean lllllllllllllIlIIllIlIlllIIIlllI = false;
            final int lllllllllllllIlIIllIlIlllIIIllIl = lllllllllllllIlIIllIlIlllIIlIIII.nextInt();
            for (final StructureComponent lllllllllllllIlIIllIlIlllIIIllII : lllllllllllllIlIIllIlIlllIIIllll) {
                lllllllllllllIlIIllIlIlllIIIllII.componentType = lllllllllllllIlIIllIlIlllIIIllIl;
                final StructureComponent lllllllllllllIlIIllIlIlllIIIlIll = StructureComponent.findIntersecting(lllllllllllllIlIIllIlIlllIIIIIll, lllllllllllllIlIIllIlIlllIIIllII.getBoundingBox());
                if (lllllllllllllIlIIllIlIlllIIIlIll != null && lllllllllllllIlIIllIlIlllIIIlIll.componentType != lllllllllllllIlIIllIlIlllIIlIIll.componentType) {
                    lllllllllllllIlIIllIlIlllIIIlllI = true;
                    break;
                }
            }
            if (!lllllllllllllIlIIllIlIlllIIIlllI) {
                lllllllllllllIlIIllIlIlllIIIIIll.addAll(lllllllllllllIlIIllIlIlllIIIllll);
                return true;
            }
        }
        return false;
    }
    
    private static CityTemplate func_189935_b(final List<StructureComponent> lllllllllllllIlIIllIlIlllIlIIlll, final CityTemplate lllllllllllllIlIIllIlIlllIlIIllI) {
        lllllllllllllIlIIllIlIlllIlIIlll.add(lllllllllllllIlIIllIlIlllIlIIllI);
        return lllllllllllllIlIIllIlIlllIlIIllI;
    }
    
    public static void func_191087_a(final TemplateManager lllllllllllllIlIIllIlIlllIlIllll, final BlockPos lllllllllllllIlIIllIlIlllIllIlII, final Rotation lllllllllllllIlIIllIlIlllIllIIll, final List<StructureComponent> lllllllllllllIlIIllIlIlllIllIIlI, final Random lllllllllllllIlIIllIlIlllIllIIIl) {
        StructureEndCityPieces.FAT_TOWER_GENERATOR.init();
        StructureEndCityPieces.HOUSE_TOWER_GENERATOR.init();
        StructureEndCityPieces.TOWER_BRIDGE_GENERATOR.init();
        StructureEndCityPieces.TOWER_GENERATOR.init();
        CityTemplate lllllllllllllIlIIllIlIlllIllIIII = func_189935_b(lllllllllllllIlIIllIlIlllIllIIlI, new CityTemplate(lllllllllllllIlIIllIlIlllIlIllll, "base_floor", lllllllllllllIlIIllIlIlllIllIlII, lllllllllllllIlIIllIlIlllIllIIll, true));
        lllllllllllllIlIIllIlIlllIllIIII = func_189935_b(lllllllllllllIlIIllIlIlllIllIIlI, func_191090_b(lllllllllllllIlIIllIlIlllIlIllll, lllllllllllllIlIIllIlIlllIllIIII, new BlockPos(-1, 0, -1), "second_floor", lllllllllllllIlIIllIlIlllIllIIll, false));
        lllllllllllllIlIIllIlIlllIllIIII = func_189935_b(lllllllllllllIlIIllIlIlllIllIIlI, func_191090_b(lllllllllllllIlIIllIlIlllIlIllll, lllllllllllllIlIIllIlIlllIllIIII, new BlockPos(-1, 4, -1), "third_floor", lllllllllllllIlIIllIlIlllIllIIll, false));
        lllllllllllllIlIIllIlIlllIllIIII = func_189935_b(lllllllllllllIlIIllIlIlllIllIIlI, func_191090_b(lllllllllllllIlIIllIlIlllIlIllll, lllllllllllllIlIIllIlIlllIllIIII, new BlockPos(-1, 8, -1), "third_roof", lllllllllllllIlIIllIlIlllIllIIll, true));
        func_191088_b(lllllllllllllIlIIllIlIlllIlIllll, StructureEndCityPieces.TOWER_GENERATOR, 1, lllllllllllllIlIIllIlIlllIllIIII, null, lllllllllllllIlIIllIlIlllIllIIlI, lllllllllllllIlIIllIlIlllIllIIIl);
    }
    
    static {
        OVERWRITE = new PlacementSettings().setIgnoreEntities(true);
        INSERT = new PlacementSettings().setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
        HOUSE_TOWER_GENERATOR = new IGenerator() {
            @Override
            public void init() {
            }
            
            @Override
            public boolean func_191086_a(final TemplateManager lllllllllllllIIIIlIlllIIlllllIlI, final int lllllllllllllIIIIlIlllIIllllIIII, final CityTemplate lllllllllllllIIIIlIlllIIlllllIII, final BlockPos lllllllllllllIIIIlIlllIIllllIlll, final List<StructureComponent> lllllllllllllIIIIlIlllIIlllIllIl, final Random lllllllllllllIIIIlIlllIIlllIllII) {
                if (lllllllllllllIIIIlIlllIIllllIIII > 8) {
                    return false;
                }
                final Rotation lllllllllllllIIIIlIlllIIllllIlII = lllllllllllllIIIIlIlllIIlllllIII.placeSettings.getRotation();
                CityTemplate lllllllllllllIIIIlIlllIIllllIIll = func_189935_b(lllllllllllllIIIIlIlllIIlllIllIl, func_191090_b(lllllllllllllIIIIlIlllIIlllllIlI, lllllllllllllIIIIlIlllIIlllllIII, lllllllllllllIIIIlIlllIIllllIlll, "base_floor", lllllllllllllIIIIlIlllIIllllIlII, true));
                final int lllllllllllllIIIIlIlllIIllllIIlI = lllllllllllllIIIIlIlllIIlllIllII.nextInt(3);
                if (lllllllllllllIIIIlIlllIIllllIIlI == 0) {
                    func_189935_b(lllllllllllllIIIIlIlllIIlllIllIl, func_191090_b(lllllllllllllIIIIlIlllIIlllllIlI, lllllllllllllIIIIlIlllIIllllIIll, new BlockPos(-1, 4, -1), "base_roof", lllllllllllllIIIIlIlllIIllllIlII, true));
                }
                else if (lllllllllllllIIIIlIlllIIllllIIlI == 1) {
                    lllllllllllllIIIIlIlllIIllllIIll = func_189935_b(lllllllllllllIIIIlIlllIIlllIllIl, func_191090_b(lllllllllllllIIIIlIlllIIlllllIlI, lllllllllllllIIIIlIlllIIllllIIll, new BlockPos(-1, 0, -1), "second_floor_2", lllllllllllllIIIIlIlllIIllllIlII, false));
                    lllllllllllllIIIIlIlllIIllllIIll = func_189935_b(lllllllllllllIIIIlIlllIIlllIllIl, func_191090_b(lllllllllllllIIIIlIlllIIlllllIlI, lllllllllllllIIIIlIlllIIllllIIll, new BlockPos(-1, 8, -1), "second_roof", lllllllllllllIIIIlIlllIIllllIlII, false));
                    func_191088_b(lllllllllllllIIIIlIlllIIlllllIlI, StructureEndCityPieces.TOWER_GENERATOR, lllllllllllllIIIIlIlllIIllllIIII + 1, lllllllllllllIIIIlIlllIIllllIIll, null, lllllllllllllIIIIlIlllIIlllIllIl, lllllllllllllIIIIlIlllIIlllIllII);
                }
                else if (lllllllllllllIIIIlIlllIIllllIIlI == 2) {
                    lllllllllllllIIIIlIlllIIllllIIll = func_189935_b(lllllllllllllIIIIlIlllIIlllIllIl, func_191090_b(lllllllllllllIIIIlIlllIIlllllIlI, lllllllllllllIIIIlIlllIIllllIIll, new BlockPos(-1, 0, -1), "second_floor_2", lllllllllllllIIIIlIlllIIllllIlII, false));
                    lllllllllllllIIIIlIlllIIllllIIll = func_189935_b(lllllllllllllIIIIlIlllIIlllIllIl, func_191090_b(lllllllllllllIIIIlIlllIIlllllIlI, lllllllllllllIIIIlIlllIIllllIIll, new BlockPos(-1, 4, -1), "third_floor_c", lllllllllllllIIIIlIlllIIllllIlII, false));
                    lllllllllllllIIIIlIlllIIllllIIll = func_189935_b(lllllllllllllIIIIlIlllIIlllIllIl, func_191090_b(lllllllllllllIIIIlIlllIIlllllIlI, lllllllllllllIIIIlIlllIIllllIIll, new BlockPos(-1, 8, -1), "third_roof", lllllllllllllIIIIlIlllIIllllIlII, true));
                    func_191088_b(lllllllllllllIIIIlIlllIIlllllIlI, StructureEndCityPieces.TOWER_GENERATOR, lllllllllllllIIIIlIlllIIllllIIII + 1, lllllllllllllIIIIlIlllIIllllIIll, null, lllllllllllllIIIIlIlllIIlllIllIl, lllllllllllllIIIIlIlllIIlllIllII);
                }
                return true;
            }
        };
        TOWER_BRIDGES = Lists.newArrayList((Object[])new Tuple[] { new Tuple((A)Rotation.NONE, (B)new BlockPos(1, -1, 0)), new Tuple((A)Rotation.CLOCKWISE_90, (B)new BlockPos(6, -1, 1)), new Tuple((A)Rotation.COUNTERCLOCKWISE_90, (B)new BlockPos(0, -1, 5)), new Tuple((A)Rotation.CLOCKWISE_180, (B)new BlockPos(5, -1, 6)) });
        TOWER_GENERATOR = new IGenerator() {
            @Override
            public boolean func_191086_a(final TemplateManager lllllllllllllllIllIIlllIIllIIlIl, final int lllllllllllllllIllIIlllIIlllIIIl, final CityTemplate lllllllllllllllIllIIlllIIlllIIII, final BlockPos lllllllllllllllIllIIlllIIllIllll, final List<StructureComponent> lllllllllllllllIllIIlllIIllIIIlI, final Random lllllllllllllllIllIIlllIIllIIIIl) {
                final Rotation lllllllllllllllIllIIlllIIllIllII = lllllllllllllllIllIIlllIIlllIIII.placeSettings.getRotation();
                CityTemplate lllllllllllllllIllIIlllIIllIlIll = func_189935_b(lllllllllllllllIllIIlllIIllIIIlI, func_191090_b(lllllllllllllllIllIIlllIIllIIlIl, lllllllllllllllIllIIlllIIlllIIII, new BlockPos(3 + lllllllllllllllIllIIlllIIllIIIIl.nextInt(2), -3, 3 + lllllllllllllllIllIIlllIIllIIIIl.nextInt(2)), "tower_base", lllllllllllllllIllIIlllIIllIllII, true));
                lllllllllllllllIllIIlllIIllIlIll = func_189935_b(lllllllllllllllIllIIlllIIllIIIlI, func_191090_b(lllllllllllllllIllIIlllIIllIIlIl, lllllllllllllllIllIIlllIIllIlIll, new BlockPos(0, 7, 0), "tower_piece", lllllllllllllllIllIIlllIIllIllII, true));
                CityTemplate lllllllllllllllIllIIlllIIllIlIlI = (lllllllllllllllIllIIlllIIllIIIIl.nextInt(3) == 0) ? lllllllllllllllIllIIlllIIllIlIll : null;
                for (int lllllllllllllllIllIIlllIIllIlIIl = 1 + lllllllllllllllIllIIlllIIllIIIIl.nextInt(3), lllllllllllllllIllIIlllIIllIlIII = 0; lllllllllllllllIllIIlllIIllIlIII < lllllllllllllllIllIIlllIIllIlIIl; ++lllllllllllllllIllIIlllIIllIlIII) {
                    lllllllllllllllIllIIlllIIllIlIll = func_189935_b(lllllllllllllllIllIIlllIIllIIIlI, func_191090_b(lllllllllllllllIllIIlllIIllIIlIl, lllllllllllllllIllIIlllIIllIlIll, new BlockPos(0, 4, 0), "tower_piece", lllllllllllllllIllIIlllIIllIllII, true));
                    if (lllllllllllllllIllIIlllIIllIlIII < lllllllllllllllIllIIlllIIllIlIIl - 1 && lllllllllllllllIllIIlllIIllIIIIl.nextBoolean()) {
                        lllllllllllllllIllIIlllIIllIlIlI = lllllllllllllllIllIIlllIIllIlIll;
                    }
                }
                if (lllllllllllllllIllIIlllIIllIlIlI != null) {
                    for (final Tuple<Rotation, BlockPos> lllllllllllllllIllIIlllIIllIIlll : StructureEndCityPieces.TOWER_BRIDGES) {
                        if (lllllllllllllllIllIIlllIIllIIIIl.nextBoolean()) {
                            final CityTemplate lllllllllllllllIllIIlllIIllIIllI = func_189935_b(lllllllllllllllIllIIlllIIllIIIlI, func_191090_b(lllllllllllllllIllIIlllIIllIIlIl, lllllllllllllllIllIIlllIIllIlIlI, lllllllllllllllIllIIlllIIllIIlll.getSecond(), "bridge_end", lllllllllllllllIllIIlllIIllIllII.add(lllllllllllllllIllIIlllIIllIIlll.getFirst()), true));
                            func_191088_b(lllllllllllllllIllIIlllIIllIIlIl, StructureEndCityPieces.TOWER_BRIDGE_GENERATOR, lllllllllllllllIllIIlllIIlllIIIl + 1, lllllllllllllllIllIIlllIIllIIllI, null, lllllllllllllllIllIIlllIIllIIIlI, lllllllllllllllIllIIlllIIllIIIIl);
                        }
                    }
                    func_189935_b(lllllllllllllllIllIIlllIIllIIIlI, func_191090_b(lllllllllllllllIllIIlllIIllIIlIl, lllllllllllllllIllIIlllIIllIlIll, new BlockPos(-1, 4, -1), "tower_top", lllllllllllllllIllIIlllIIllIllII, true));
                }
                else {
                    if (lllllllllllllllIllIIlllIIlllIIIl != 7) {
                        return func_191088_b(lllllllllllllllIllIIlllIIllIIlIl, StructureEndCityPieces.FAT_TOWER_GENERATOR, lllllllllllllllIllIIlllIIlllIIIl + 1, lllllllllllllllIllIIlllIIllIlIll, null, lllllllllllllllIllIIlllIIllIIIlI, lllllllllllllllIllIIlllIIllIIIIl);
                    }
                    func_189935_b(lllllllllllllllIllIIlllIIllIIIlI, func_191090_b(lllllllllllllllIllIIlllIIllIIlIl, lllllllllllllllIllIIlllIIllIlIll, new BlockPos(-1, 4, -1), "tower_top", lllllllllllllllIllIIlllIIllIllII, true));
                }
                return true;
            }
            
            @Override
            public void init() {
            }
        };
        TOWER_BRIDGE_GENERATOR = new IGenerator() {
            public /* synthetic */ boolean shipCreated;
            
            @Override
            public boolean func_191086_a(final TemplateManager llllllllllllllllllllllIIlIlIlIIl, final int llllllllllllllllllllllIIlIlIlIII, final CityTemplate llllllllllllllllllllllIIlIllIIll, final BlockPos llllllllllllllllllllllIIlIllIIlI, final List<StructureComponent> llllllllllllllllllllllIIlIlIIllI, final Random llllllllllllllllllllllIIlIllIIII) {
                final Rotation llllllllllllllllllllllIIlIlIllll = llllllllllllllllllllllIIlIllIIll.placeSettings.getRotation();
                final int llllllllllllllllllllllIIlIlIlllI = llllllllllllllllllllllIIlIllIIII.nextInt(4) + 1;
                CityTemplate llllllllllllllllllllllIIlIlIllIl = func_189935_b(llllllllllllllllllllllIIlIlIIllI, func_191090_b(llllllllllllllllllllllIIlIlIlIIl, llllllllllllllllllllllIIlIllIIll, new BlockPos(0, 0, -4), "bridge_piece", llllllllllllllllllllllIIlIlIllll, true));
                llllllllllllllllllllllIIlIlIllIl.componentType = -1;
                int llllllllllllllllllllllIIlIlIllII = 0;
                for (int llllllllllllllllllllllIIlIlIlIll = 0; llllllllllllllllllllllIIlIlIlIll < llllllllllllllllllllllIIlIlIlllI; ++llllllllllllllllllllllIIlIlIlIll) {
                    if (llllllllllllllllllllllIIlIllIIII.nextBoolean()) {
                        llllllllllllllllllllllIIlIlIllIl = func_189935_b(llllllllllllllllllllllIIlIlIIllI, func_191090_b(llllllllllllllllllllllIIlIlIlIIl, llllllllllllllllllllllIIlIlIllIl, new BlockPos(0, llllllllllllllllllllllIIlIlIllII, -4), "bridge_piece", llllllllllllllllllllllIIlIlIllll, true));
                        llllllllllllllllllllllIIlIlIllII = 0;
                    }
                    else {
                        if (llllllllllllllllllllllIIlIllIIII.nextBoolean()) {
                            llllllllllllllllllllllIIlIlIllIl = func_189935_b(llllllllllllllllllllllIIlIlIIllI, func_191090_b(llllllllllllllllllllllIIlIlIlIIl, llllllllllllllllllllllIIlIlIllIl, new BlockPos(0, llllllllllllllllllllllIIlIlIllII, -4), "bridge_steep_stairs", llllllllllllllllllllllIIlIlIllll, true));
                        }
                        else {
                            llllllllllllllllllllllIIlIlIllIl = func_189935_b(llllllllllllllllllllllIIlIlIIllI, func_191090_b(llllllllllllllllllllllIIlIlIlIIl, llllllllllllllllllllllIIlIlIllIl, new BlockPos(0, llllllllllllllllllllllIIlIlIllII, -8), "bridge_gentle_stairs", llllllllllllllllllllllIIlIlIllll, true));
                        }
                        llllllllllllllllllllllIIlIlIllII = 4;
                    }
                }
                if (!this.shipCreated && llllllllllllllllllllllIIlIllIIII.nextInt(10 - llllllllllllllllllllllIIlIlIlIII) == 0) {
                    func_189935_b(llllllllllllllllllllllIIlIlIIllI, func_191090_b(llllllllllllllllllllllIIlIlIlIIl, llllllllllllllllllllllIIlIlIllIl, new BlockPos(-8 + llllllllllllllllllllllIIlIllIIII.nextInt(8), llllllllllllllllllllllIIlIlIllII, -70 + llllllllllllllllllllllIIlIllIIII.nextInt(10)), "ship", llllllllllllllllllllllIIlIlIllll, true));
                    this.shipCreated = true;
                }
                else if (!func_191088_b(llllllllllllllllllllllIIlIlIlIIl, StructureEndCityPieces.HOUSE_TOWER_GENERATOR, llllllllllllllllllllllIIlIlIlIII + 1, llllllllllllllllllllllIIlIlIllIl, new BlockPos(-3, llllllllllllllllllllllIIlIlIllII + 1, -11), llllllllllllllllllllllIIlIlIIllI, llllllllllllllllllllllIIlIllIIII)) {
                    return false;
                }
                llllllllllllllllllllllIIlIlIllIl = func_189935_b(llllllllllllllllllllllIIlIlIIllI, func_191090_b(llllllllllllllllllllllIIlIlIlIIl, llllllllllllllllllllllIIlIlIllIl, new BlockPos(4, llllllllllllllllllllllIIlIlIllII, 0), "bridge_end", llllllllllllllllllllllIIlIlIllll.add(Rotation.CLOCKWISE_180), true));
                llllllllllllllllllllllIIlIlIllIl.componentType = -1;
                return true;
            }
            
            @Override
            public void init() {
                this.shipCreated = false;
            }
        };
        FAT_TOWER_BRIDGES = Lists.newArrayList((Object[])new Tuple[] { new Tuple((A)Rotation.NONE, (B)new BlockPos(4, -1, 0)), new Tuple((A)Rotation.CLOCKWISE_90, (B)new BlockPos(12, -1, 4)), new Tuple((A)Rotation.COUNTERCLOCKWISE_90, (B)new BlockPos(0, -1, 8)), new Tuple((A)Rotation.CLOCKWISE_180, (B)new BlockPos(8, -1, 12)) });
        FAT_TOWER_GENERATOR = new IGenerator() {
            @Override
            public void init() {
            }
            
            @Override
            public boolean func_191086_a(final TemplateManager lllllllllllllllIlIlllIllIlllIlII, final int lllllllllllllllIlIlllIllIlllIIll, final CityTemplate lllllllllllllllIlIlllIllIlllIIlI, final BlockPos lllllllllllllllIlIlllIllIlllIIIl, final List<StructureComponent> lllllllllllllllIlIlllIllIlllIIII, final Random lllllllllllllllIlIlllIllIllIIlIl) {
                final Rotation lllllllllllllllIlIlllIllIllIlllI = lllllllllllllllIlIlllIllIlllIIlI.placeSettings.getRotation();
                CityTemplate lllllllllllllllIlIlllIllIllIllIl = func_189935_b(lllllllllllllllIlIlllIllIlllIIII, func_191090_b(lllllllllllllllIlIlllIllIlllIlII, lllllllllllllllIlIlllIllIlllIIlI, new BlockPos(-3, 4, -3), "fat_tower_base", lllllllllllllllIlIlllIllIllIlllI, true));
                lllllllllllllllIlIlllIllIllIllIl = func_189935_b(lllllllllllllllIlIlllIllIlllIIII, func_191090_b(lllllllllllllllIlIlllIllIlllIlII, lllllllllllllllIlIlllIllIllIllIl, new BlockPos(0, 4, 0), "fat_tower_middle", lllllllllllllllIlIlllIllIllIlllI, true));
                for (int lllllllllllllllIlIlllIllIllIllII = 0; lllllllllllllllIlIlllIllIllIllII < 2 && lllllllllllllllIlIlllIllIllIIlIl.nextInt(3) != 0; ++lllllllllllllllIlIlllIllIllIllII) {
                    lllllllllllllllIlIlllIllIllIllIl = func_189935_b(lllllllllllllllIlIlllIllIlllIIII, func_191090_b(lllllllllllllllIlIlllIllIlllIlII, lllllllllllllllIlIlllIllIllIllIl, new BlockPos(0, 8, 0), "fat_tower_middle", lllllllllllllllIlIlllIllIllIlllI, true));
                    for (final Tuple<Rotation, BlockPos> lllllllllllllllIlIlllIllIllIlIll : StructureEndCityPieces.FAT_TOWER_BRIDGES) {
                        if (lllllllllllllllIlIlllIllIllIIlIl.nextBoolean()) {
                            final CityTemplate lllllllllllllllIlIlllIllIllIlIlI = func_189935_b(lllllllllllllllIlIlllIllIlllIIII, func_191090_b(lllllllllllllllIlIlllIllIlllIlII, lllllllllllllllIlIlllIllIllIllIl, lllllllllllllllIlIlllIllIllIlIll.getSecond(), "bridge_end", lllllllllllllllIlIlllIllIllIlllI.add(lllllllllllllllIlIlllIllIllIlIll.getFirst()), true));
                            func_191088_b(lllllllllllllllIlIlllIllIlllIlII, StructureEndCityPieces.TOWER_BRIDGE_GENERATOR, lllllllllllllllIlIlllIllIlllIIll + 1, lllllllllllllllIlIlllIllIllIlIlI, null, lllllllllllllllIlIlllIllIlllIIII, lllllllllllllllIlIlllIllIllIIlIl);
                        }
                    }
                }
                func_189935_b(lllllllllllllllIlIlllIllIlllIIII, func_191090_b(lllllllllllllllIlIlllIllIlllIlII, lllllllllllllllIlIlllIllIllIllIl, new BlockPos(-2, 8, -2), "fat_tower_top", lllllllllllllllIlIlllIllIllIlllI, true));
                return true;
            }
        };
    }
    
    public static void registerPieces() {
        MapGenStructureIO.registerStructureComponent(CityTemplate.class, "ECP");
    }
    
    interface IGenerator
    {
        void init();
        
        boolean func_191086_a(final TemplateManager p0, final int p1, final CityTemplate p2, final BlockPos p3, final List<StructureComponent> p4, final Random p5);
    }
    
    public static class CityTemplate extends StructureComponentTemplate
    {
        private /* synthetic */ boolean overwrite;
        private /* synthetic */ String pieceName;
        private /* synthetic */ Rotation rotation;
        
        public CityTemplate() {
        }
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound lllllllllllllIllllIllIlIlIllIIIl, final TemplateManager lllllllllllllIllllIllIlIlIllIIII) {
            super.readStructureFromNBT(lllllllllllllIllllIllIlIlIllIIIl, lllllllllllllIllllIllIlIlIllIIII);
            this.pieceName = lllllllllllllIllllIllIlIlIllIIIl.getString("Template");
            this.rotation = Rotation.valueOf(lllllllllllllIllllIllIlIlIllIIIl.getString("Rot"));
            this.overwrite = lllllllllllllIllllIllIlIlIllIIIl.getBoolean("OW");
            this.func_191085_a(lllllllllllllIllllIllIlIlIllIIII);
        }
        
        @Override
        protected void handleDataMarker(final String lllllllllllllIllllIllIlIlIIllIIl, final BlockPos lllllllllllllIllllIllIlIlIlIIIlI, final World lllllllllllllIllllIllIlIlIIlIlll, final Random lllllllllllllIllllIllIlIlIlIIIII, final StructureBoundingBox lllllllllllllIllllIllIlIlIIlIlIl) {
            if (lllllllllllllIllllIllIlIlIIllIIl.startsWith("Chest")) {
                final BlockPos lllllllllllllIllllIllIlIlIIllllI = lllllllllllllIllllIllIlIlIlIIIlI.down();
                if (lllllllllllllIllllIllIlIlIIlIlIl.isVecInside(lllllllllllllIllllIllIlIlIIllllI)) {
                    final TileEntity lllllllllllllIllllIllIlIlIIlllIl = lllllllllllllIllllIllIlIlIIlIlll.getTileEntity(lllllllllllllIllllIllIlIlIIllllI);
                    if (lllllllllllllIllllIllIlIlIIlllIl instanceof TileEntityChest) {
                        ((TileEntityChest)lllllllllllllIllllIllIlIlIIlllIl).setLootTable(LootTableList.CHESTS_END_CITY_TREASURE, lllllllllllllIllllIllIlIlIlIIIII.nextLong());
                    }
                }
            }
            else if (lllllllllllllIllllIllIlIlIIllIIl.startsWith("Sentry")) {
                final EntityShulker lllllllllllllIllllIllIlIlIIlllII = new EntityShulker(lllllllllllllIllllIllIlIlIIlIlll);
                lllllllllllllIllllIllIlIlIIlllII.setPosition(lllllllllllllIllllIllIlIlIlIIIlI.getX() + 0.5, lllllllllllllIllllIllIlIlIlIIIlI.getY() + 0.5, lllllllllllllIllllIllIlIlIlIIIlI.getZ() + 0.5);
                lllllllllllllIllllIllIlIlIIlllII.setAttachmentPos(lllllllllllllIllllIllIlIlIlIIIlI);
                lllllllllllllIllllIllIlIlIIlIlll.spawnEntityInWorld(lllllllllllllIllllIllIlIlIIlllII);
            }
            else if (lllllllllllllIllllIllIlIlIIllIIl.startsWith("Elytra")) {
                final EntityItemFrame lllllllllllllIllllIllIlIlIIllIll = new EntityItemFrame(lllllllllllllIllllIllIlIlIIlIlll, lllllllllllllIllllIllIlIlIlIIIlI, this.rotation.rotate(EnumFacing.SOUTH));
                lllllllllllllIllllIllIlIlIIllIll.setDisplayedItem(new ItemStack(Items.ELYTRA));
                lllllllllllllIllllIllIlIlIIlIlll.spawnEntityInWorld(lllllllllllllIllllIllIlIlIIllIll);
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound lllllllllllllIllllIllIlIlIlllIII) {
            super.writeStructureToNBT(lllllllllllllIllllIllIlIlIlllIII);
            lllllllllllllIllllIllIlIlIlllIII.setString("Template", this.pieceName);
            lllllllllllllIllllIllIlIlIlllIII.setString("Rot", this.rotation.name());
            lllllllllllllIllllIllIlIlIlllIII.setBoolean("OW", this.overwrite);
        }
        
        public CityTemplate(final TemplateManager lllllllllllllIllllIllIlIllIIllII, final String lllllllllllllIllllIllIlIllIlIIIl, final BlockPos lllllllllllllIllllIllIlIllIlIIII, final Rotation lllllllllllllIllllIllIlIllIIllll, final boolean lllllllllllllIllllIllIlIllIIlllI) {
            super(0);
            this.pieceName = lllllllllllllIllllIllIlIllIlIIIl;
            this.templatePosition = lllllllllllllIllllIllIlIllIlIIII;
            this.rotation = lllllllllllllIllllIllIlIllIIllll;
            this.overwrite = lllllllllllllIllllIllIlIllIIlllI;
            this.func_191085_a(lllllllllllllIllllIllIlIllIIllII);
        }
        
        private void func_191085_a(final TemplateManager lllllllllllllIllllIllIlIllIIIIlI) {
            final Template lllllllllllllIllllIllIlIllIIIIIl = lllllllllllllIllllIllIlIllIIIIlI.getTemplate(null, new ResourceLocation(String.valueOf(new StringBuilder("endcity/").append(this.pieceName))));
            final PlacementSettings lllllllllllllIllllIllIlIllIIIIII = (this.overwrite ? StructureEndCityPieces.OVERWRITE : StructureEndCityPieces.INSERT).copy().setRotation(this.rotation);
            this.setup(lllllllllllllIllllIllIlIllIIIIIl, this.templatePosition, lllllllllllllIllllIllIlIllIIIIII);
        }
    }
}
