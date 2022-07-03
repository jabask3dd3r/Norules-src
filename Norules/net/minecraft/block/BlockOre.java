package net.minecraft.block;

import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class BlockOre extends Block
{
    @Override
    public int quantityDroppedWithBonus(final int llllllllllllllIllllllIllIIIIIIlI, final Random llllllllllllllIllllllIllIIIIIIIl) {
        if (llllllllllllllIllllllIllIIIIIIlI > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), llllllllllllllIllllllIllIIIIIIIl, llllllllllllllIllllllIllIIIIIIlI)) {
            int llllllllllllllIllllllIllIIIIIIII = llllllllllllllIllllllIllIIIIIIIl.nextInt(llllllllllllllIllllllIllIIIIIIlI + 2) - 1;
            if (llllllllllllllIllllllIllIIIIIIII < 0) {
                llllllllllllllIllllllIllIIIIIIII = 0;
            }
            return this.quantityDropped(llllllllllllllIllllllIllIIIIIIIl) * (llllllllllllllIllllllIllIIIIIIII + 1);
        }
        return this.quantityDropped(llllllllllllllIllllllIllIIIIIIIl);
    }
    
    public BlockOre() {
        this(Material.ROCK.getMaterialMapColor());
    }
    
    public BlockOre(final MapColor llllllllllllllIllllllIllIIIlIlII) {
        super(Material.ROCK, llllllllllllllIllllllIllIIIlIlII);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIllllllIlIlllIIlII, final BlockPos llllllllllllllIllllllIlIlllIIIll, final IBlockState llllllllllllllIllllllIlIlllIIIlI) {
        return new ItemStack(this);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIllllllIlIllIllllI) {
        return (this == Blocks.LAPIS_ORE) ? EnumDyeColor.BLUE.getDyeDamage() : 0;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIllllllIlIllllIIll, final BlockPos llllllllllllllIllllllIlIllllIIlI, final IBlockState llllllllllllllIllllllIlIlllIlIlI, final float llllllllllllllIllllllIlIllllIIII, final int llllllllllllllIllllllIlIlllIllll) {
        super.dropBlockAsItemWithChance(llllllllllllllIllllllIlIllllIIll, llllllllllllllIllllllIlIllllIIlI, llllllllllllllIllllllIlIlllIlIlI, llllllllllllllIllllllIlIllllIIII, llllllllllllllIllllllIlIlllIllll);
        if (this.getItemDropped(llllllllllllllIllllllIlIlllIlIlI, llllllllllllllIllllllIlIllllIIll.rand, llllllllllllllIllllllIlIlllIllll) != Item.getItemFromBlock(this)) {
            int llllllllllllllIllllllIlIlllIlllI = 0;
            if (this == Blocks.COAL_ORE) {
                llllllllllllllIllllllIlIlllIlllI = MathHelper.getInt(llllllllllllllIllllllIlIllllIIll.rand, 0, 2);
            }
            else if (this == Blocks.DIAMOND_ORE) {
                llllllllllllllIllllllIlIlllIlllI = MathHelper.getInt(llllllllllllllIllllllIlIllllIIll.rand, 3, 7);
            }
            else if (this == Blocks.EMERALD_ORE) {
                llllllllllllllIllllllIlIlllIlllI = MathHelper.getInt(llllllllllllllIllllllIlIllllIIll.rand, 3, 7);
            }
            else if (this == Blocks.LAPIS_ORE) {
                llllllllllllllIllllllIlIlllIlllI = MathHelper.getInt(llllllllllllllIllllllIlIllllIIll.rand, 2, 5);
            }
            else if (this == Blocks.QUARTZ_ORE) {
                llllllllllllllIllllllIlIlllIlllI = MathHelper.getInt(llllllllllllllIllllllIlIllllIIll.rand, 2, 5);
            }
            this.dropXpOnBlockBreak(llllllllllllllIllllllIlIllllIIll, llllllllllllllIllllllIlIllllIIlI, llllllllllllllIllllllIlIlllIlllI);
        }
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIllllllIllIIIIlIlI) {
        return (this == Blocks.LAPIS_ORE) ? (4 + llllllllllllllIllllllIllIIIIlIlI.nextInt(5)) : 1;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIllllllIllIIIlIIIl, final Random llllllllllllllIllllllIllIIIlIIII, final int llllllllllllllIllllllIllIIIIllll) {
        if (this == Blocks.COAL_ORE) {
            return Items.COAL;
        }
        if (this == Blocks.DIAMOND_ORE) {
            return Items.DIAMOND;
        }
        if (this == Blocks.LAPIS_ORE) {
            return Items.DYE;
        }
        if (this == Blocks.EMERALD_ORE) {
            return Items.EMERALD;
        }
        return (this == Blocks.QUARTZ_ORE) ? Items.QUARTZ : Item.getItemFromBlock(this);
    }
}
