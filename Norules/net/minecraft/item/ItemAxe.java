package net.minecraft.item;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;

public class ItemAxe extends ItemTool
{
    private static final /* synthetic */ float[] ATTACK_SPEEDS;
    private static final /* synthetic */ Set<Block> EFFECTIVE_ON;
    private static final /* synthetic */ float[] ATTACK_DAMAGES;
    
    static {
        EFFECTIVE_ON = Sets.newHashSet((Object[])new Block[] { Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE });
        ATTACK_DAMAGES = new float[] { 6.0f, 8.0f, 8.0f, 8.0f, 6.0f };
        ATTACK_SPEEDS = new float[] { -3.2f, -3.2f, -3.1f, -3.0f, -3.0f };
    }
    
    protected ItemAxe(final ToolMaterial lllllllllllllIlIllIlIlIlllIlllIl) {
        super(lllllllllllllIlIllIlIlIlllIlllIl, ItemAxe.EFFECTIVE_ON);
        this.damageVsEntity = ItemAxe.ATTACK_DAMAGES[lllllllllllllIlIllIlIlIlllIlllIl.ordinal()];
        this.attackSpeed = ItemAxe.ATTACK_SPEEDS[lllllllllllllIlIllIlIlIlllIlllIl.ordinal()];
    }
    
    @Override
    public float getStrVsBlock(final ItemStack lllllllllllllIlIllIlIlIlllIIIIIl, final IBlockState lllllllllllllIlIllIlIlIllIllllll) {
        final Material lllllllllllllIlIllIlIlIlllIIIlIl = lllllllllllllIlIllIlIlIllIllllll.getMaterial();
        return (lllllllllllllIlIllIlIlIlllIIIlIl != Material.WOOD && lllllllllllllIlIllIlIlIlllIIIlIl != Material.PLANTS && lllllllllllllIlIllIlIlIlllIIIlIl != Material.VINE) ? super.getStrVsBlock(lllllllllllllIlIllIlIlIlllIIIIIl, lllllllllllllIlIllIlIlIllIllllll) : this.efficiencyOnProperMaterial;
    }
}
