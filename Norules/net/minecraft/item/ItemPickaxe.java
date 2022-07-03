package net.minecraft.item;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import com.google.common.collect.*;

public class ItemPickaxe extends ItemTool
{
    private static final /* synthetic */ Set<Block> EFFECTIVE_ON;
    
    @Override
    public float getStrVsBlock(final ItemStack llIlIlIllllI, final IBlockState llIlIlIlllIl) {
        final Material llIlIlIlllII = llIlIlIlllIl.getMaterial();
        return (llIlIlIlllII != Material.IRON && llIlIlIlllII != Material.ANVIL && llIlIlIlllII != Material.ROCK) ? super.getStrVsBlock(llIlIlIllllI, llIlIlIlllIl) : this.efficiencyOnProperMaterial;
    }
    
    static {
        EFFECTIVE_ON = Sets.newHashSet((Object[])new Block[] { Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE });
    }
    
    protected ItemPickaxe(final ToolMaterial llIlIlllIIII) {
        super(1.0f, -2.8f, llIlIlllIIII, ItemPickaxe.EFFECTIVE_ON);
    }
    
    @Override
    public boolean canHarvestBlock(final IBlockState llIlIllIlIlI) {
        final Block llIlIllIlIIl = llIlIllIlIlI.getBlock();
        if (llIlIllIlIIl == Blocks.OBSIDIAN) {
            return this.toolMaterial.getHarvestLevel() == 3;
        }
        if (llIlIllIlIIl == Blocks.DIAMOND_BLOCK || llIlIllIlIIl == Blocks.DIAMOND_ORE) {
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
        if (llIlIllIlIIl == Blocks.EMERALD_ORE || llIlIllIlIIl == Blocks.EMERALD_BLOCK) {
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
        if (llIlIllIlIIl == Blocks.GOLD_BLOCK || llIlIllIlIIl == Blocks.GOLD_ORE) {
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
        if (llIlIllIlIIl == Blocks.IRON_BLOCK || llIlIllIlIIl == Blocks.IRON_ORE) {
            return this.toolMaterial.getHarvestLevel() >= 1;
        }
        if (llIlIllIlIIl == Blocks.LAPIS_BLOCK || llIlIllIlIIl == Blocks.LAPIS_ORE) {
            return this.toolMaterial.getHarvestLevel() >= 1;
        }
        if (llIlIllIlIIl != Blocks.REDSTONE_ORE && llIlIllIlIIl != Blocks.LIT_REDSTONE_ORE) {
            final Material llIlIllIlIII = llIlIllIlIlI.getMaterial();
            return llIlIllIlIII == Material.ROCK || llIlIllIlIII == Material.IRON || llIlIllIlIII == Material.ANVIL;
        }
        return this.toolMaterial.getHarvestLevel() >= 2;
    }
}
