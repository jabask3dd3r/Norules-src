package net.minecraft.client.renderer.color;

import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;

public class ItemColors
{
    private final /* synthetic */ ObjectIntIdentityMap<IItemColor> mapItemColors;
    
    public void registerItemColorHandler(final IItemColor lllllllllllllIlIIIlIllIlIlIIlIII, final Block... lllllllllllllIlIIIlIllIlIlIIIIll) {
        final char lllllllllllllIlIIIlIllIlIIllllll = (Object)lllllllllllllIlIIIlIllIlIlIIIIll;
        for (long lllllllllllllIlIIIlIllIlIlIIIIII = lllllllllllllIlIIIlIllIlIlIIIIll.length, lllllllllllllIlIIIlIllIlIlIIIIIl = 0; lllllllllllllIlIIIlIllIlIlIIIIIl < lllllllllllllIlIIIlIllIlIlIIIIII; ++lllllllllllllIlIIIlIllIlIlIIIIIl) {
            final Block lllllllllllllIlIIIlIllIlIlIIIllI = lllllllllllllIlIIIlIllIlIIllllll[lllllllllllllIlIIIlIllIlIlIIIIIl];
            this.mapItemColors.put(lllllllllllllIlIIIlIllIlIlIIlIII, Item.getIdFromItem(Item.getItemFromBlock(lllllllllllllIlIIIlIllIlIlIIIllI)));
        }
    }
    
    public void registerItemColorHandler(final IItemColor lllllllllllllIlIIIlIllIlIIllIllI, final Item... lllllllllllllIlIIIlIllIlIIllIlIl) {
        final long lllllllllllllIlIIIlIllIlIIlIllIl = (Object)lllllllllllllIlIIIlIllIlIIllIlIl;
        final int lllllllllllllIlIIIlIllIlIIlIlllI = lllllllllllllIlIIIlIllIlIIllIlIl.length;
        for (Exception lllllllllllllIlIIIlIllIlIIlIllll = (Exception)0; lllllllllllllIlIIIlIllIlIIlIllll < lllllllllllllIlIIIlIllIlIIlIlllI; ++lllllllllllllIlIIIlIllIlIIlIllll) {
            final Item lllllllllllllIlIIIlIllIlIIllIlII = lllllllllllllIlIIIlIllIlIIlIllIl[lllllllllllllIlIIIlIllIlIIlIllll];
            this.mapItemColors.put(lllllllllllllIlIIIlIllIlIIllIllI, Item.getIdFromItem(lllllllllllllIlIIIlIllIlIIllIlII));
        }
    }
    
    public static ItemColors init(final BlockColors lllllllllllllIlIIIlIllIlIllIIlll) {
        final ItemColors lllllllllllllIlIIIlIllIlIllIIlIl = new ItemColors();
        lllllllllllllIlIIIlIllIlIllIIlIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllllIIlIIIlIlllIllIIllI, final int lllllllllllllIIlIIIlIlllIllIIIll) {
                return (lllllllllllllIIlIIIlIlllIllIIIll > 0) ? -1 : ((ItemArmor)lllllllllllllIIlIIIlIlllIllIIllI.getItem()).getColor(lllllllllllllIIlIIIlIlllIllIIllI);
            }
        }, Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS);
        lllllllllllllIlIIIlIllIlIllIIlIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllllllllIIIlIlllIIIlllI, final int lllllllllllllllllIIIlIlllIIIllIl) {
                final BlockDoublePlant.EnumPlantType lllllllllllllllllIIIlIlllIIIllII = BlockDoublePlant.EnumPlantType.byMetadata(lllllllllllllllllIIIlIlllIIIlllI.getMetadata());
                return (lllllllllllllllllIIIlIlllIIIllII != BlockDoublePlant.EnumPlantType.GRASS && lllllllllllllllllIIIlIlllIIIllII != BlockDoublePlant.EnumPlantType.FERN) ? -1 : ColorizerGrass.getGrassColor(0.5, 1.0);
            }
        }, Blocks.DOUBLE_PLANT);
        lllllllllllllIlIIIlIllIlIllIIlIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack llllIlllllIllIl, final int llllIlllllIllII) {
                if (llllIlllllIllII != 1) {
                    return -1;
                }
                final NBTBase llllIlllllIlIll = ItemFireworkCharge.getExplosionTag(llllIlllllIllIl, "Colors");
                if (!(llllIlllllIlIll instanceof NBTTagIntArray)) {
                    return 9079434;
                }
                final int[] llllIlllllIlIlI = ((NBTTagIntArray)llllIlllllIlIll).getIntArray();
                if (llllIlllllIlIlI.length == 1) {
                    return llllIlllllIlIlI[0];
                }
                int llllIlllllIlIIl = 0;
                int llllIlllllIlIII = 0;
                int llllIlllllIIlll = 0;
                final Exception llllIllllIllIll;
                final boolean llllIllllIlllII = ((int[])(Object)(llllIllllIllIll = (Exception)(Object)llllIlllllIlIlI)).length != 0;
                for (long llllIllllIlllIl = 0; llllIllllIlllIl < (llllIllllIlllII ? 1 : 0); ++llllIllllIlllIl) {
                    final int llllIlllllIIllI = llllIllllIllIll[llllIllllIlllIl];
                    llllIlllllIlIIl += (llllIlllllIIllI & 0xFF0000) >> 16;
                    llllIlllllIlIII += (llllIlllllIIllI & 0xFF00) >> 8;
                    llllIlllllIIlll += (llllIlllllIIllI & 0xFF) >> 0;
                }
                llllIlllllIlIIl /= llllIlllllIlIlI.length;
                llllIlllllIlIII /= llllIlllllIlIlI.length;
                llllIlllllIIlll /= llllIlllllIlIlI.length;
                return llllIlllllIlIIl << 16 | llllIlllllIlIII << 8 | llllIlllllIIlll;
            }
        }, Items.FIREWORK_CHARGE);
        lllllllllllllIlIIIlIllIlIllIIlIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllllllllIIIlIllIIlIllII, final int lllllllllllllllllIIIlIllIIlIlIlI) {
                return (lllllllllllllllllIIIlIllIIlIlIlI > 0) ? -1 : PotionUtils.func_190932_c(lllllllllllllllllIIIlIllIIlIllII);
            }
        }, Items.POTIONITEM, Items.SPLASH_POTION, Items.LINGERING_POTION);
        lllllllllllllIlIIIlIllIlIllIIlIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllllIIlIIlIllIllIIIllll, final int lllllllllllllIIlIIlIllIllIIIlIll) {
                final EntityList.EntityEggInfo lllllllllllllIIlIIlIllIllIIIllIl = EntityList.ENTITY_EGGS.get(ItemMonsterPlacer.func_190908_h(lllllllllllllIIlIIlIllIllIIIllll));
                if (lllllllllllllIIlIIlIllIllIIIllIl == null) {
                    return -1;
                }
                return (lllllllllllllIIlIIlIllIllIIIlIll == 0) ? lllllllllllllIIlIIlIllIllIIIllIl.primaryColor : lllllllllllllIIlIIlIllIllIIIllIl.secondaryColor;
            }
        }, Items.SPAWN_EGG);
        lllllllllllllIlIIIlIllIlIllIIlIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllllIIlIIllIIIIIIIllIIl, final int lllllllllllllIIlIIllIIIIIIIllIII) {
                final IBlockState lllllllllllllIIlIIllIIIIIIIlIlll = ((ItemBlock)lllllllllllllIIlIIllIIIIIIIllIIl.getItem()).getBlock().getStateFromMeta(lllllllllllllIIlIIllIIIIIIIllIIl.getMetadata());
                return lllllllllllllIlIIIlIllIlIllIIlll.colorMultiplier(lllllllllllllIIlIIllIIIIIIIlIlll, null, null, lllllllllllllIIlIIllIIIIIIIllIII);
            }
        }, Blocks.GRASS, Blocks.TALLGRASS, Blocks.VINE, Blocks.LEAVES, Blocks.LEAVES2, Blocks.WATERLILY);
        lllllllllllllIlIIIlIllIlIllIIlIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllllIlIlllIllllllIllIIl, final int lllllllllllllIlIlllIllllllIlIllI) {
                return (lllllllllllllIlIlllIllllllIlIllI == 0) ? PotionUtils.func_190932_c(lllllllllllllIlIlllIllllllIllIIl) : -1;
            }
        }, Items.TIPPED_ARROW);
        lllllllllllllIlIIIlIllIlIllIIlIl.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(final ItemStack lllllllllllllIllllIllIllIllIlIlI, final int lllllllllllllIllllIllIllIllIIlll) {
                return (lllllllllllllIllllIllIllIllIIlll == 0) ? -1 : ItemMap.func_190907_h(lllllllllllllIllllIllIllIllIlIlI);
            }
        }, Items.FILLED_MAP);
        return lllllllllllllIlIIIlIllIlIllIIlIl;
    }
    
    public int getColorFromItemstack(final ItemStack lllllllllllllIlIIIlIllIlIlIlIIll, final int lllllllllllllIlIIIlIllIlIlIlIIlI) {
        final IItemColor lllllllllllllIlIIIlIllIlIlIlIlIl = this.mapItemColors.getByValue(Item.REGISTRY.getIDForObject(lllllllllllllIlIIIlIllIlIlIlIIll.getItem()));
        return (lllllllllllllIlIIIlIllIlIlIlIlIl == null) ? -1 : lllllllllllllIlIIIlIllIlIlIlIlIl.getColorFromItemstack(lllllllllllllIlIIIlIllIlIlIlIIll, lllllllllllllIlIIIlIllIlIlIlIIlI);
    }
    
    public ItemColors() {
        this.mapItemColors = new ObjectIntIdentityMap<IItemColor>(32);
    }
}
