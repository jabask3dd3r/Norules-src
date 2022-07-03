package net.minecraft.item;

import net.minecraft.world.storage.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import com.google.common.collect.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.state.*;
import net.minecraft.world.biome.*;
import net.minecraft.network.*;
import net.minecraft.nbt.*;

public class ItemMap extends ItemMapBase
{
    protected static void enableMapTracking(final ItemStack lllllllllllllllIlIllIllIIlllIllI, final World lllllllllllllllIlIllIllIIlllIIIl) {
        final MapData lllllllllllllllIlIllIllIIlllIlII = Items.FILLED_MAP.getMapData(lllllllllllllllIlIllIllIIlllIllI, lllllllllllllllIlIllIllIIlllIIIl);
        lllllllllllllllIlIllIllIIlllIllI.setItemDamage(lllllllllllllllIlIllIllIIlllIIIl.getUniqueDataId("map"));
        final MapData lllllllllllllllIlIllIllIIlllIIll = new MapData(String.valueOf(new StringBuilder("map_").append(lllllllllllllllIlIllIllIIlllIllI.getMetadata())));
        lllllllllllllllIlIllIllIIlllIIll.trackingPosition = true;
        if (lllllllllllllllIlIllIllIIlllIlII != null) {
            lllllllllllllllIlIllIllIIlllIIll.xCenter = lllllllllllllllIlIllIllIIlllIlII.xCenter;
            lllllllllllllllIlIllIllIIlllIIll.zCenter = lllllllllllllllIlIllIllIIlllIlII.zCenter;
            lllllllllllllllIlIllIllIIlllIIll.scale = lllllllllllllllIlIllIllIIlllIlII.scale;
            lllllllllllllllIlIllIllIIlllIIll.dimension = lllllllllllllllIlIllIllIIlllIlII.dimension;
            lllllllllllllllIlIllIllIIlllIIll.markDirty();
            lllllllllllllllIlIllIllIIlllIIIl.setItemData(String.valueOf(new StringBuilder("map_").append(lllllllllllllllIlIllIllIIlllIllI.getMetadata())), lllllllllllllllIlIllIllIIlllIIll);
        }
    }
    
    @Override
    public void addInformation(final ItemStack lllllllllllllllIlIllIllIIllIIIIl, @Nullable final World lllllllllllllllIlIllIllIIllIIllI, final List<String> lllllllllllllllIlIllIllIIllIIlIl, final ITooltipFlag lllllllllllllllIlIllIllIIllIIlII) {
        if (lllllllllllllllIlIllIllIIllIIlII.func_194127_a()) {
            final MapData lllllllllllllllIlIllIllIIllIIIll = (lllllllllllllllIlIllIllIIllIIllI == null) ? null : this.getMapData(lllllllllllllllIlIllIllIIllIIIIl, lllllllllllllllIlIllIllIIllIIllI);
            if (lllllllllllllllIlIllIllIIllIIIll != null) {
                lllllllllllllllIlIllIllIIllIIlIl.add(I18n.translateToLocalFormatted("filled_map.scale", 1 << lllllllllllllllIlIllIllIIllIIIll.scale));
                lllllllllllllllIlIllIllIIllIIlIl.add(I18n.translateToLocalFormatted("filled_map.level", lllllllllllllllIlIllIllIIllIIIll.scale, 4));
            }
            else {
                lllllllllllllllIlIllIllIIllIIlIl.add(I18n.translateToLocal("filled_map.unknown"));
            }
        }
    }
    
    protected static void scaleMap(final ItemStack lllllllllllllllIlIllIllIlIIIIlII, final World lllllllllllllllIlIllIllIlIIIIIll, final int lllllllllllllllIlIllIllIlIIIIIlI) {
        final MapData lllllllllllllllIlIllIllIlIIIIIIl = Items.FILLED_MAP.getMapData(lllllllllllllllIlIllIllIlIIIIlII, lllllllllllllllIlIllIllIlIIIIIll);
        lllllllllllllllIlIllIllIlIIIIlII.setItemDamage(lllllllllllllllIlIllIllIlIIIIIll.getUniqueDataId("map"));
        final MapData lllllllllllllllIlIllIllIlIIIIIII = new MapData(String.valueOf(new StringBuilder("map_").append(lllllllllllllllIlIllIllIlIIIIlII.getMetadata())));
        if (lllllllllllllllIlIllIllIlIIIIIIl != null) {
            lllllllllllllllIlIllIllIlIIIIIII.scale = (byte)MathHelper.clamp(lllllllllllllllIlIllIllIlIIIIIIl.scale + lllllllllllllllIlIllIllIlIIIIIlI, 0, 4);
            lllllllllllllllIlIllIllIlIIIIIII.trackingPosition = lllllllllllllllIlIllIllIlIIIIIIl.trackingPosition;
            lllllllllllllllIlIllIllIlIIIIIII.calculateMapCenter(lllllllllllllllIlIllIllIlIIIIIIl.xCenter, lllllllllllllllIlIllIllIlIIIIIIl.zCenter, lllllllllllllllIlIllIllIlIIIIIII.scale);
            lllllllllllllllIlIllIllIlIIIIIII.dimension = lllllllllllllllIlIllIllIlIIIIIIl.dimension;
            lllllllllllllllIlIllIllIlIIIIIII.markDirty();
            lllllllllllllllIlIllIllIlIIIIIll.setItemData(String.valueOf(new StringBuilder("map_").append(lllllllllllllllIlIllIllIlIIIIlII.getMetadata())), lllllllllllllllIlIllIllIlIIIIIII);
        }
    }
    
    @Nullable
    public static MapData loadMapData(final int lllllllllllllllIlIllIlllIlIllIlI, final World lllllllllllllllIlIllIlllIlIlllII) {
        final String lllllllllllllllIlIllIlllIlIllIll = String.valueOf(new StringBuilder("map_").append(lllllllllllllllIlIllIlllIlIllIlI));
        return (MapData)lllllllllllllllIlIllIlllIlIlllII.loadItemData(MapData.class, lllllllllllllllIlIllIlllIlIllIll);
    }
    
    public void updateMapData(final World lllllllllllllllIlIllIlllIIIIIIll, final Entity lllllllllllllllIlIllIlllIIIIIIlI, final MapData lllllllllllllllIlIllIlllIIlIIlll) {
        if (lllllllllllllllIlIllIlllIIIIIIll.provider.getDimensionType().getId() == lllllllllllllllIlIllIlllIIlIIlll.dimension && lllllllllllllllIlIllIlllIIIIIIlI instanceof EntityPlayer) {
            final int lllllllllllllllIlIllIlllIIlIIllI = 1 << lllllllllllllllIlIllIlllIIlIIlll.scale;
            final int lllllllllllllllIlIllIlllIIlIIlIl = lllllllllllllllIlIllIlllIIlIIlll.xCenter;
            final int lllllllllllllllIlIllIlllIIlIIlII = lllllllllllllllIlIllIlllIIlIIlll.zCenter;
            final int lllllllllllllllIlIllIlllIIlIIIll = MathHelper.floor(lllllllllllllllIlIllIlllIIIIIIlI.posX - lllllllllllllllIlIllIlllIIlIIlIl) / lllllllllllllllIlIllIlllIIlIIllI + 64;
            final int lllllllllllllllIlIllIlllIIlIIIlI = MathHelper.floor(lllllllllllllllIlIllIlllIIIIIIlI.posZ - lllllllllllllllIlIllIlllIIlIIlII) / lllllllllllllllIlIllIlllIIlIIllI + 64;
            int lllllllllllllllIlIllIlllIIlIIIIl = 128 / lllllllllllllllIlIllIlllIIlIIllI;
            if (lllllllllllllllIlIllIlllIIIIIIll.provider.getHasNoSky()) {
                lllllllllllllllIlIllIlllIIlIIIIl /= 2;
            }
            final MapData.MapInfo mapInfo;
            final MapData.MapInfo lllllllllllllllIlIllIlllIIlIIIII = mapInfo = lllllllllllllllIlIllIlllIIlIIlll.getMapInfo((EntityPlayer)lllllllllllllllIlIllIlllIIIIIIlI);
            ++mapInfo.step;
            boolean lllllllllllllllIlIllIlllIIIlllll = false;
            for (int lllllllllllllllIlIllIlllIIIllllI = lllllllllllllllIlIllIlllIIlIIIll - lllllllllllllllIlIllIlllIIlIIIIl + 1; lllllllllllllllIlIllIlllIIIllllI < lllllllllllllllIlIllIlllIIlIIIll + lllllllllllllllIlIllIlllIIlIIIIl; ++lllllllllllllllIlIllIlllIIIllllI) {
                if ((lllllllllllllllIlIllIlllIIIllllI & 0xF) == (lllllllllllllllIlIllIlllIIlIIIII.step & 0xF) || lllllllllllllllIlIllIlllIIIlllll) {
                    lllllllllllllllIlIllIlllIIIlllll = false;
                    double lllllllllllllllIlIllIlllIIIlllIl = 0.0;
                    for (int lllllllllllllllIlIllIlllIIIlllII = lllllllllllllllIlIllIlllIIlIIIlI - lllllllllllllllIlIllIlllIIlIIIIl - 1; lllllllllllllllIlIllIlllIIIlllII < lllllllllllllllIlIllIlllIIlIIIlI + lllllllllllllllIlIllIlllIIlIIIIl; ++lllllllllllllllIlIllIlllIIIlllII) {
                        if (lllllllllllllllIlIllIlllIIIllllI >= 0 && lllllllllllllllIlIllIlllIIIlllII >= -1 && lllllllllllllllIlIllIlllIIIllllI < 128 && lllllllllllllllIlIllIlllIIIlllII < 128) {
                            final int lllllllllllllllIlIllIlllIIIllIll = lllllllllllllllIlIllIlllIIIllllI - lllllllllllllllIlIllIlllIIlIIIll;
                            final int lllllllllllllllIlIllIlllIIIllIlI = lllllllllllllllIlIllIlllIIIlllII - lllllllllllllllIlIllIlllIIlIIIlI;
                            final boolean lllllllllllllllIlIllIlllIIIllIIl = lllllllllllllllIlIllIlllIIIllIll * lllllllllllllllIlIllIlllIIIllIll + lllllllllllllllIlIllIlllIIIllIlI * lllllllllllllllIlIllIlllIIIllIlI > (lllllllllllllllIlIllIlllIIlIIIIl - 2) * (lllllllllllllllIlIllIlllIIlIIIIl - 2);
                            final int lllllllllllllllIlIllIlllIIIllIII = (lllllllllllllllIlIllIlllIIlIIlIl / lllllllllllllllIlIllIlllIIlIIllI + lllllllllllllllIlIllIlllIIIllllI - 64) * lllllllllllllllIlIllIlllIIlIIllI;
                            final int lllllllllllllllIlIllIlllIIIlIlll = (lllllllllllllllIlIllIlllIIlIIlII / lllllllllllllllIlIllIlllIIlIIllI + lllllllllllllllIlIllIlllIIIlllII - 64) * lllllllllllllllIlIllIlllIIlIIllI;
                            final Multiset<MapColor> lllllllllllllllIlIllIlllIIIlIllI = (Multiset<MapColor>)HashMultiset.create();
                            final Chunk lllllllllllllllIlIllIlllIIIlIlIl = lllllllllllllllIlIllIlllIIIIIIll.getChunkFromBlockCoords(new BlockPos(lllllllllllllllIlIllIlllIIIllIII, 0, lllllllllllllllIlIllIlllIIIlIlll));
                            if (!lllllllllllllllIlIllIlllIIIlIlIl.isEmpty()) {
                                final int lllllllllllllllIlIllIlllIIIlIlII = lllllllllllllllIlIllIlllIIIllIII & 0xF;
                                final int lllllllllllllllIlIllIlllIIIlIIll = lllllllllllllllIlIllIlllIIIlIlll & 0xF;
                                int lllllllllllllllIlIllIlllIIIlIIlI = 0;
                                double lllllllllllllllIlIllIlllIIIlIIIl = 0.0;
                                if (lllllllllllllllIlIllIlllIIIIIIll.provider.getHasNoSky()) {
                                    int lllllllllllllllIlIllIlllIIIlIIII = lllllllllllllllIlIllIlllIIIllIII + lllllllllllllllIlIllIlllIIIlIlll * 231871;
                                    lllllllllllllllIlIllIlllIIIlIIII = lllllllllllllllIlIllIlllIIIlIIII * lllllllllllllllIlIllIlllIIIlIIII * 31287121 + lllllllllllllllIlIllIlllIIIlIIII * 11;
                                    if ((lllllllllllllllIlIllIlllIIIlIIII >> 20 & 0x1) == 0x0) {
                                        lllllllllllllllIlIllIlllIIIlIllI.add((Object)Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT).getMapColor(lllllllllllllllIlIllIlllIIIIIIll, BlockPos.ORIGIN), 10);
                                    }
                                    else {
                                        lllllllllllllllIlIllIlllIIIlIllI.add((Object)Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE).getMapColor(lllllllllllllllIlIllIlllIIIIIIll, BlockPos.ORIGIN), 100);
                                    }
                                    lllllllllllllllIlIllIlllIIIlIIIl = 100.0;
                                }
                                else {
                                    final BlockPos.MutableBlockPos lllllllllllllllIlIllIlllIIIIllll = new BlockPos.MutableBlockPos();
                                    for (int lllllllllllllllIlIllIlllIIIIlllI = 0; lllllllllllllllIlIllIlllIIIIlllI < lllllllllllllllIlIllIlllIIlIIllI; ++lllllllllllllllIlIllIlllIIIIlllI) {
                                        for (int lllllllllllllllIlIllIlllIIIIllIl = 0; lllllllllllllllIlIllIlllIIIIllIl < lllllllllllllllIlIllIlllIIlIIllI; ++lllllllllllllllIlIllIlllIIIIllIl) {
                                            int lllllllllllllllIlIllIlllIIIIllII = lllllllllllllllIlIllIlllIIIlIlIl.getHeightValue(lllllllllllllllIlIllIlllIIIIlllI + lllllllllllllllIlIllIlllIIIlIlII, lllllllllllllllIlIllIlllIIIIllIl + lllllllllllllllIlIllIlllIIIlIIll) + 1;
                                            IBlockState lllllllllllllllIlIllIlllIIIIlIll = Blocks.AIR.getDefaultState();
                                            if (lllllllllllllllIlIllIlllIIIIllII <= 1) {
                                                lllllllllllllllIlIllIlllIIIIlIll = Blocks.BEDROCK.getDefaultState();
                                            }
                                            else {
                                                do {
                                                    --lllllllllllllllIlIllIlllIIIIllII;
                                                    lllllllllllllllIlIllIlllIIIIlIll = lllllllllllllllIlIllIlllIIIlIlIl.getBlockState(lllllllllllllllIlIllIlllIIIIlllI + lllllllllllllllIlIllIlllIIIlIlII, lllllllllllllllIlIllIlllIIIIllII, lllllllllllllllIlIllIlllIIIIllIl + lllllllllllllllIlIllIlllIIIlIIll);
                                                    lllllllllllllllIlIllIlllIIIIllll.setPos((lllllllllllllllIlIllIlllIIIlIlIl.xPosition << 4) + lllllllllllllllIlIllIlllIIIIlllI + lllllllllllllllIlIllIlllIIIlIlII, lllllllllllllllIlIllIlllIIIIllII, (lllllllllllllllIlIllIlllIIIlIlIl.zPosition << 4) + lllllllllllllllIlIllIlllIIIIllIl + lllllllllllllllIlIllIlllIIIlIIll);
                                                } while (lllllllllllllllIlIllIlllIIIIlIll.getMapColor(lllllllllllllllIlIllIlllIIIIIIll, lllllllllllllllIlIllIlllIIIIllll) == MapColor.AIR && lllllllllllllllIlIllIlllIIIIllII > 0);
                                                if (lllllllllllllllIlIllIlllIIIIllII > 0 && lllllllllllllllIlIllIlllIIIIlIll.getMaterial().isLiquid()) {
                                                    int lllllllllllllllIlIllIlllIIIIlIlI = lllllllllllllllIlIllIlllIIIIllII - 1;
                                                    IBlockState lllllllllllllllIlIllIlllIIIIlIIl;
                                                    do {
                                                        lllllllllllllllIlIllIlllIIIIlIIl = lllllllllllllllIlIllIlllIIIlIlIl.getBlockState(lllllllllllllllIlIllIlllIIIIlllI + lllllllllllllllIlIllIlllIIIlIlII, lllllllllllllllIlIllIlllIIIIlIlI--, lllllllllllllllIlIllIlllIIIIllIl + lllllllllllllllIlIllIlllIIIlIIll);
                                                        ++lllllllllllllllIlIllIlllIIIlIIlI;
                                                    } while (lllllllllllllllIlIllIlllIIIIlIlI > 0 && lllllllllllllllIlIllIlllIIIIlIIl.getMaterial().isLiquid());
                                                }
                                            }
                                            lllllllllllllllIlIllIlllIIIlIIIl += lllllllllllllllIlIllIlllIIIIllII / (double)(lllllllllllllllIlIllIlllIIlIIllI * lllllllllllllllIlIllIlllIIlIIllI);
                                            lllllllllllllllIlIllIlllIIIlIllI.add((Object)lllllllllllllllIlIllIlllIIIIlIll.getMapColor(lllllllllllllllIlIllIlllIIIIIIll, lllllllllllllllIlIllIlllIIIIllll));
                                        }
                                    }
                                }
                                lllllllllllllllIlIllIlllIIIlIIlI /= lllllllllllllllIlIllIlllIIlIIllI * lllllllllllllllIlIllIlllIIlIIllI;
                                double lllllllllllllllIlIllIlllIIIIlIII = (lllllllllllllllIlIllIlllIIIlIIIl - lllllllllllllllIlIllIlllIIIlllIl) * 4.0 / (lllllllllllllllIlIllIlllIIlIIllI + 4) + ((lllllllllllllllIlIllIlllIIIllllI + lllllllllllllllIlIllIlllIIIlllII & 0x1) - 0.5) * 0.4;
                                int lllllllllllllllIlIllIlllIIIIIlll = 1;
                                if (lllllllllllllllIlIllIlllIIIIlIII > 0.6) {
                                    lllllllllllllllIlIllIlllIIIIIlll = 2;
                                }
                                if (lllllllllllllllIlIllIlllIIIIlIII < -0.6) {
                                    lllllllllllllllIlIllIlllIIIIIlll = 0;
                                }
                                final MapColor lllllllllllllllIlIllIlllIIIIIllI = (MapColor)Iterables.getFirst((Iterable)Multisets.copyHighestCountFirst((Multiset)lllllllllllllllIlIllIlllIIIlIllI), (Object)MapColor.AIR);
                                if (lllllllllllllllIlIllIlllIIIIIllI == MapColor.WATER) {
                                    lllllllllllllllIlIllIlllIIIIlIII = lllllllllllllllIlIllIlllIIIlIIlI * 0.1 + (lllllllllllllllIlIllIlllIIIllllI + lllllllllllllllIlIllIlllIIIlllII & 0x1) * 0.2;
                                    lllllllllllllllIlIllIlllIIIIIlll = 1;
                                    if (lllllllllllllllIlIllIlllIIIIlIII < 0.5) {
                                        lllllllllllllllIlIllIlllIIIIIlll = 2;
                                    }
                                    if (lllllllllllllllIlIllIlllIIIIlIII > 0.9) {
                                        lllllllllllllllIlIllIlllIIIIIlll = 0;
                                    }
                                }
                                lllllllllllllllIlIllIlllIIIlllIl = lllllllllllllllIlIllIlllIIIlIIIl;
                                if (lllllllllllllllIlIllIlllIIIlllII >= 0 && lllllllllllllllIlIllIlllIIIllIll * lllllllllllllllIlIllIlllIIIllIll + lllllllllllllllIlIllIlllIIIllIlI * lllllllllllllllIlIllIlllIIIllIlI < lllllllllllllllIlIllIlllIIlIIIIl * lllllllllllllllIlIllIlllIIlIIIIl && (!lllllllllllllllIlIllIlllIIIllIIl || (lllllllllllllllIlIllIlllIIIllllI + lllllllllllllllIlIllIlllIIIlllII & 0x1) != 0x0)) {
                                    final byte lllllllllllllllIlIllIlllIIIIIlIl = lllllllllllllllIlIllIlllIIlIIlll.colors[lllllllllllllllIlIllIlllIIIllllI + lllllllllllllllIlIllIlllIIIlllII * 128];
                                    final byte lllllllllllllllIlIllIlllIIIIIlII = (byte)(lllllllllllllllIlIllIlllIIIIIllI.colorIndex * 4 + lllllllllllllllIlIllIlllIIIIIlll);
                                    if (lllllllllllllllIlIllIlllIIIIIlIl != lllllllllllllllIlIllIlllIIIIIlII) {
                                        lllllllllllllllIlIllIlllIIlIIlll.colors[lllllllllllllllIlIllIlllIIIllllI + lllllllllllllllIlIllIlllIIIlllII * 128] = lllllllllllllllIlIllIlllIIIIIlII;
                                        lllllllllllllllIlIllIlllIIlIIlll.updateMapData(lllllllllllllllIlIllIlllIIIllllI, lllllllllllllllIlIllIlllIIIlllII);
                                        lllllllllllllllIlIllIlllIIIlllll = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void func_190905_a(final World lllllllllllllllIlIllIllIllIlIlII, final ItemStack lllllllllllllllIlIllIllIllIlIIll) {
        if (lllllllllllllllIlIllIllIllIlIIll.getItem() == Items.FILLED_MAP) {
            final MapData lllllllllllllllIlIllIllIllIlIIlI = Items.FILLED_MAP.getMapData(lllllllllllllllIlIllIllIllIlIIll, lllllllllllllllIlIllIllIllIlIlII);
            if (lllllllllllllllIlIllIllIllIlIIlI != null && lllllllllllllllIlIllIllIllIlIlII.provider.getDimensionType().getId() == lllllllllllllllIlIllIllIllIlIIlI.dimension) {
                final int lllllllllllllllIlIllIllIllIlIIIl = 1 << lllllllllllllllIlIllIllIllIlIIlI.scale;
                final int lllllllllllllllIlIllIllIllIlIIII = lllllllllllllllIlIllIllIllIlIIlI.xCenter;
                final int lllllllllllllllIlIllIllIllIIllll = lllllllllllllllIlIllIllIllIlIIlI.zCenter;
                final Biome[] lllllllllllllllIlIllIllIllIIlllI = lllllllllllllllIlIllIllIllIlIlII.getBiomeProvider().getBiomes(null, (lllllllllllllllIlIllIllIllIlIIII / lllllllllllllllIlIllIllIllIlIIIl - 64) * lllllllllllllllIlIllIllIllIlIIIl, (lllllllllllllllIlIllIllIllIIllll / lllllllllllllllIlIllIllIllIlIIIl - 64) * lllllllllllllllIlIllIllIllIlIIIl, 128 * lllllllllllllllIlIllIllIllIlIIIl, 128 * lllllllllllllllIlIllIllIllIlIIIl, false);
                for (int lllllllllllllllIlIllIllIllIIllIl = 0; lllllllllllllllIlIllIllIllIIllIl < 128; ++lllllllllllllllIlIllIllIllIIllIl) {
                    for (int lllllllllllllllIlIllIllIllIIllII = 0; lllllllllllllllIlIllIllIllIIllII < 128; ++lllllllllllllllIlIllIllIllIIllII) {
                        final int lllllllllllllllIlIllIllIllIIlIll = lllllllllllllllIlIllIllIllIIllIl * lllllllllllllllIlIllIllIllIlIIIl;
                        final int lllllllllllllllIlIllIllIllIIlIlI = lllllllllllllllIlIllIllIllIIllII * lllllllllllllllIlIllIllIllIlIIIl;
                        final Biome lllllllllllllllIlIllIllIllIIlIIl = lllllllllllllllIlIllIllIllIIlllI[lllllllllllllllIlIllIllIllIIlIll + lllllllllllllllIlIllIllIllIIlIlI * 128 * lllllllllllllllIlIllIllIllIlIIIl];
                        MapColor lllllllllllllllIlIllIllIllIIlIII = MapColor.AIR;
                        int lllllllllllllllIlIllIllIllIIIlll = 3;
                        int lllllllllllllllIlIllIllIllIIIllI = 8;
                        if (lllllllllllllllIlIllIllIllIIllIl > 0 && lllllllllllllllIlIllIllIllIIllII > 0 && lllllllllllllllIlIllIllIllIIllIl < 127 && lllllllllllllllIlIllIllIllIIllII < 127) {
                            if (lllllllllllllllIlIllIllIllIIlllI[(lllllllllllllllIlIllIllIllIIllIl - 1) * lllllllllllllllIlIllIllIllIlIIIl + (lllllllllllllllIlIllIllIllIIllII - 1) * lllllllllllllllIlIllIllIllIlIIIl * 128 * lllllllllllllllIlIllIllIllIlIIIl].getBaseHeight() >= 0.0f) {
                                --lllllllllllllllIlIllIllIllIIIllI;
                            }
                            if (lllllllllllllllIlIllIllIllIIlllI[(lllllllllllllllIlIllIllIllIIllIl - 1) * lllllllllllllllIlIllIllIllIlIIIl + (lllllllllllllllIlIllIllIllIIllII + 1) * lllllllllllllllIlIllIllIllIlIIIl * 128 * lllllllllllllllIlIllIllIllIlIIIl].getBaseHeight() >= 0.0f) {
                                --lllllllllllllllIlIllIllIllIIIllI;
                            }
                            if (lllllllllllllllIlIllIllIllIIlllI[(lllllllllllllllIlIllIllIllIIllIl - 1) * lllllllllllllllIlIllIllIllIlIIIl + lllllllllllllllIlIllIllIllIIllII * lllllllllllllllIlIllIllIllIlIIIl * 128 * lllllllllllllllIlIllIllIllIlIIIl].getBaseHeight() >= 0.0f) {
                                --lllllllllllllllIlIllIllIllIIIllI;
                            }
                            if (lllllllllllllllIlIllIllIllIIlllI[(lllllllllllllllIlIllIllIllIIllIl + 1) * lllllllllllllllIlIllIllIllIlIIIl + (lllllllllllllllIlIllIllIllIIllII - 1) * lllllllllllllllIlIllIllIllIlIIIl * 128 * lllllllllllllllIlIllIllIllIlIIIl].getBaseHeight() >= 0.0f) {
                                --lllllllllllllllIlIllIllIllIIIllI;
                            }
                            if (lllllllllllllllIlIllIllIllIIlllI[(lllllllllllllllIlIllIllIllIIllIl + 1) * lllllllllllllllIlIllIllIllIlIIIl + (lllllllllllllllIlIllIllIllIIllII + 1) * lllllllllllllllIlIllIllIllIlIIIl * 128 * lllllllllllllllIlIllIllIllIlIIIl].getBaseHeight() >= 0.0f) {
                                --lllllllllllllllIlIllIllIllIIIllI;
                            }
                            if (lllllllllllllllIlIllIllIllIIlllI[(lllllllllllllllIlIllIllIllIIllIl + 1) * lllllllllllllllIlIllIllIllIlIIIl + lllllllllllllllIlIllIllIllIIllII * lllllllllllllllIlIllIllIllIlIIIl * 128 * lllllllllllllllIlIllIllIllIlIIIl].getBaseHeight() >= 0.0f) {
                                --lllllllllllllllIlIllIllIllIIIllI;
                            }
                            if (lllllllllllllllIlIllIllIllIIlllI[lllllllllllllllIlIllIllIllIIllIl * lllllllllllllllIlIllIllIllIlIIIl + (lllllllllllllllIlIllIllIllIIllII - 1) * lllllllllllllllIlIllIllIllIlIIIl * 128 * lllllllllllllllIlIllIllIllIlIIIl].getBaseHeight() >= 0.0f) {
                                --lllllllllllllllIlIllIllIllIIIllI;
                            }
                            if (lllllllllllllllIlIllIllIllIIlllI[lllllllllllllllIlIllIllIllIIllIl * lllllllllllllllIlIllIllIllIlIIIl + (lllllllllllllllIlIllIllIllIIllII + 1) * lllllllllllllllIlIllIllIllIlIIIl * 128 * lllllllllllllllIlIllIllIllIlIIIl].getBaseHeight() >= 0.0f) {
                                --lllllllllllllllIlIllIllIllIIIllI;
                            }
                            if (lllllllllllllllIlIllIllIllIIlIIl.getBaseHeight() < 0.0f) {
                                lllllllllllllllIlIllIllIllIIlIII = MapColor.ADOBE;
                                if (lllllllllllllllIlIllIllIllIIIllI > 7 && lllllllllllllllIlIllIllIllIIllII % 2 == 0) {
                                    lllllllllllllllIlIllIllIllIIIlll = (lllllllllllllllIlIllIllIllIIllIl + (int)(MathHelper.sin(lllllllllllllllIlIllIllIllIIllII + 0.0f) * 7.0f)) / 8 % 5;
                                    if (lllllllllllllllIlIllIllIllIIIlll == 3) {
                                        lllllllllllllllIlIllIllIllIIIlll = 1;
                                    }
                                    else if (lllllllllllllllIlIllIllIllIIIlll == 4) {
                                        lllllllllllllllIlIllIllIllIIIlll = 0;
                                    }
                                }
                                else if (lllllllllllllllIlIllIllIllIIIllI > 7) {
                                    lllllllllllllllIlIllIllIllIIlIII = MapColor.AIR;
                                }
                                else if (lllllllllllllllIlIllIllIllIIIllI > 5) {
                                    lllllllllllllllIlIllIllIllIIIlll = 1;
                                }
                                else if (lllllllllllllllIlIllIllIllIIIllI > 3) {
                                    lllllllllllllllIlIllIllIllIIIlll = 0;
                                }
                                else if (lllllllllllllllIlIllIllIllIIIllI > 1) {
                                    lllllllllllllllIlIllIllIllIIIlll = 0;
                                }
                            }
                            else if (lllllllllllllllIlIllIllIllIIIllI > 0) {
                                lllllllllllllllIlIllIllIllIIlIII = MapColor.BROWN;
                                if (lllllllllllllllIlIllIllIllIIIllI > 3) {
                                    lllllllllllllllIlIllIllIllIIIlll = 1;
                                }
                                else {
                                    lllllllllllllllIlIllIllIllIIIlll = 3;
                                }
                            }
                        }
                        if (lllllllllllllllIlIllIllIllIIlIII != MapColor.AIR) {
                            lllllllllllllllIlIllIllIllIlIIlI.colors[lllllllllllllllIlIllIllIllIIllIl + lllllllllllllllIlIllIllIllIIllII * 128] = (byte)(lllllllllllllllIlIllIllIllIIlIII.colorIndex * 4 + lllllllllllllllIlIllIllIllIIIlll);
                            lllllllllllllllIlIllIllIllIlIIlI.updateMapData(lllllllllllllllIlIllIllIllIIllIl, lllllllllllllllIlIllIllIllIIllII);
                        }
                    }
                }
            }
        }
    }
    
    @Nullable
    @Override
    public Packet<?> createMapDataPacket(final ItemStack lllllllllllllllIlIllIllIlIIlIlll, final World lllllllllllllllIlIllIllIlIIlIllI, final EntityPlayer lllllllllllllllIlIllIllIlIIllIIl) {
        return this.getMapData(lllllllllllllllIlIllIllIlIIlIlll, lllllllllllllllIlIllIllIlIIlIllI).getMapPacket(lllllllllllllllIlIllIllIlIIlIlll, lllllllllllllllIlIllIllIlIIlIllI, lllllllllllllllIlIllIllIlIIllIIl);
    }
    
    protected ItemMap() {
        this.setHasSubtypes(true);
    }
    
    public static int func_190907_h(final ItemStack lllllllllllllllIlIllIllIIlIlIllI) {
        final NBTTagCompound lllllllllllllllIlIllIllIIlIllIII = lllllllllllllllIlIllIllIIlIlIllI.getSubCompound("display");
        if (lllllllllllllllIlIllIllIIlIllIII != null && lllllllllllllllIlIllIllIIlIllIII.hasKey("MapColor", 99)) {
            final int lllllllllllllllIlIllIllIIlIlIlll = lllllllllllllllIlIllIllIIlIllIII.getInteger("MapColor");
            return 0xFF000000 | (lllllllllllllllIlIllIllIIlIlIlll & 0xFFFFFF);
        }
        return -12173266;
    }
    
    @Nullable
    public MapData getMapData(final ItemStack lllllllllllllllIlIllIlllIlIlIIlI, final World lllllllllllllllIlIllIlllIlIIllIl) {
        String lllllllllllllllIlIllIlllIlIlIIII = String.valueOf(new StringBuilder("map_").append(lllllllllllllllIlIllIlllIlIlIIlI.getMetadata()));
        MapData lllllllllllllllIlIllIlllIlIIllll = (MapData)lllllllllllllllIlIllIlllIlIIllIl.loadItemData(MapData.class, lllllllllllllllIlIllIlllIlIlIIII);
        if (lllllllllllllllIlIllIlllIlIIllll == null && !lllllllllllllllIlIllIlllIlIIllIl.isRemote) {
            lllllllllllllllIlIllIlllIlIlIIlI.setItemDamage(lllllllllllllllIlIllIlllIlIIllIl.getUniqueDataId("map"));
            lllllllllllllllIlIllIlllIlIlIIII = String.valueOf(new StringBuilder("map_").append(lllllllllllllllIlIllIlllIlIlIIlI.getMetadata()));
            lllllllllllllllIlIllIlllIlIIllll = new MapData(lllllllllllllllIlIllIlllIlIlIIII);
            lllllllllllllllIlIllIlllIlIIllll.scale = 3;
            lllllllllllllllIlIllIlllIlIIllll.calculateMapCenter(lllllllllllllllIlIllIlllIlIIllIl.getWorldInfo().getSpawnX(), lllllllllllllllIlIllIlllIlIIllIl.getWorldInfo().getSpawnZ(), lllllllllllllllIlIllIlllIlIIllll.scale);
            lllllllllllllllIlIllIlllIlIIllll.dimension = (byte)lllllllllllllllIlIllIlllIlIIllIl.provider.getDimensionType().getId();
            lllllllllllllllIlIllIlllIlIIllll.markDirty();
            lllllllllllllllIlIllIlllIlIIllIl.setItemData(lllllllllllllllIlIllIlllIlIlIIII, lllllllllllllllIlIllIlllIlIIllll);
        }
        return lllllllllllllllIlIllIlllIlIIllll;
    }
    
    @Override
    public void onCreated(final ItemStack lllllllllllllllIlIllIllIlIIlIIII, final World lllllllllllllllIlIllIllIlIIIlIll, final EntityPlayer lllllllllllllllIlIllIllIlIIIlllI) {
        final NBTTagCompound lllllllllllllllIlIllIllIlIIIllIl = lllllllllllllllIlIllIllIlIIlIIII.getTagCompound();
        if (lllllllllllllllIlIllIllIlIIIllIl != null) {
            if (lllllllllllllllIlIllIllIlIIIllIl.hasKey("map_scale_direction", 99)) {
                scaleMap(lllllllllllllllIlIllIllIlIIlIIII, lllllllllllllllIlIllIllIlIIIlIll, lllllllllllllllIlIllIllIlIIIllIl.getInteger("map_scale_direction"));
                lllllllllllllllIlIllIllIlIIIllIl.removeTag("map_scale_direction");
            }
            else if (lllllllllllllllIlIllIllIlIIIllIl.getBoolean("map_tracking_position")) {
                enableMapTracking(lllllllllllllllIlIllIllIlIIlIIII, lllllllllllllllIlIllIllIlIIIlIll);
                lllllllllllllllIlIllIllIlIIIllIl.removeTag("map_tracking_position");
            }
        }
    }
    
    @Override
    public void onUpdate(final ItemStack lllllllllllllllIlIllIllIlIlIIllI, final World lllllllllllllllIlIllIllIlIlIIlIl, final Entity lllllllllllllllIlIllIllIlIlIIlII, final int lllllllllllllllIlIllIllIlIlIlIll, final boolean lllllllllllllllIlIllIllIlIlIlIlI) {
        if (!lllllllllllllllIlIllIllIlIlIIlIl.isRemote) {
            final MapData lllllllllllllllIlIllIllIlIlIlIIl = this.getMapData(lllllllllllllllIlIllIllIlIlIIllI, lllllllllllllllIlIllIllIlIlIIlIl);
            if (lllllllllllllllIlIllIllIlIlIIlII instanceof EntityPlayer) {
                final EntityPlayer lllllllllllllllIlIllIllIlIlIlIII = (EntityPlayer)lllllllllllllllIlIllIllIlIlIIlII;
                lllllllllllllllIlIllIllIlIlIlIIl.updateVisiblePlayers(lllllllllllllllIlIllIllIlIlIlIII, lllllllllllllllIlIllIllIlIlIIllI);
            }
            if (lllllllllllllllIlIllIllIlIlIlIlI || (lllllllllllllllIlIllIllIlIlIIlII instanceof EntityPlayer && ((EntityPlayer)lllllllllllllllIlIllIllIlIlIIlII).getHeldItemOffhand() == lllllllllllllllIlIllIllIlIlIIllI)) {
                this.updateMapData(lllllllllllllllIlIllIllIlIlIIlIl, lllllllllllllllIlIllIllIlIlIIlII, lllllllllllllllIlIllIllIlIlIlIIl);
            }
        }
    }
    
    public static ItemStack func_190906_a(final World lllllllllllllllIlIllIlllIlllIIlI, final double lllllllllllllllIlIllIlllIllIlIII, final double lllllllllllllllIlIllIlllIlllIIII, final byte lllllllllllllllIlIllIlllIllIllll, final boolean lllllllllllllllIlIllIlllIllIlllI, final boolean lllllllllllllllIlIllIlllIllIllIl) {
        final ItemStack lllllllllllllllIlIllIlllIllIllII = new ItemStack(Items.FILLED_MAP, 1, lllllllllllllllIlIllIlllIlllIIlI.getUniqueDataId("map"));
        final String lllllllllllllllIlIllIlllIllIlIll = String.valueOf(new StringBuilder("map_").append(lllllllllllllllIlIllIlllIllIllII.getMetadata()));
        final MapData lllllllllllllllIlIllIlllIllIlIlI = new MapData(lllllllllllllllIlIllIlllIllIlIll);
        lllllllllllllllIlIllIlllIlllIIlI.setItemData(lllllllllllllllIlIllIlllIllIlIll, lllllllllllllllIlIllIlllIllIlIlI);
        lllllllllllllllIlIllIlllIllIlIlI.scale = lllllllllllllllIlIllIlllIllIllll;
        lllllllllllllllIlIllIlllIllIlIlI.calculateMapCenter(lllllllllllllllIlIllIlllIllIlIII, lllllllllllllllIlIllIlllIlllIIII, lllllllllllllllIlIllIlllIllIlIlI.scale);
        lllllllllllllllIlIllIlllIllIlIlI.dimension = (byte)lllllllllllllllIlIllIlllIlllIIlI.provider.getDimensionType().getId();
        lllllllllllllllIlIllIlllIllIlIlI.trackingPosition = lllllllllllllllIlIllIlllIllIlllI;
        lllllllllllllllIlIllIlllIllIlIlI.field_191096_f = lllllllllllllllIlIllIlllIllIllIl;
        lllllllllllllllIlIllIlllIllIlIlI.markDirty();
        return lllllllllllllllIlIllIlllIllIllII;
    }
}
