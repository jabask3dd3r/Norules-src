package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.stats.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.util.text.*;

public class BlockWorkbench extends Block
{
    protected BlockWorkbench() {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlIIIIIlIlIlIIllIl, final BlockPos llllllllllllllIlIIIIIlIlIlIlIlIl, final IBlockState llllllllllllllIlIIIIIlIlIlIlIlII, final EntityPlayer llllllllllllllIlIIIIIlIlIlIlIIll, final EnumHand llllllllllllllIlIIIIIlIlIlIlIIlI, final EnumFacing llllllllllllllIlIIIIIlIlIlIlIIIl, final float llllllllllllllIlIIIIIlIlIlIlIIII, final float llllllllllllllIlIIIIIlIlIlIIllll, final float llllllllllllllIlIIIIIlIlIlIIlllI) {
        if (llllllllllllllIlIIIIIlIlIlIIllIl.isRemote) {
            return true;
        }
        llllllllllllllIlIIIIIlIlIlIlIIll.displayGui(new InterfaceCraftingTable(llllllllllllllIlIIIIIlIlIlIIllIl, llllllllllllllIlIIIIIlIlIlIlIlIl));
        llllllllllllllIlIIIIIlIlIlIlIIll.addStat(StatList.CRAFTING_TABLE_INTERACTION);
        return true;
    }
    
    public static class InterfaceCraftingTable implements IInteractionObject
    {
        private final /* synthetic */ BlockPos position;
        private final /* synthetic */ World world;
        
        @Override
        public Container createContainer(final InventoryPlayer lllllllllllllllIIIlIlllIlIIlllll, final EntityPlayer lllllllllllllllIIIlIlllIlIlIIIIl) {
            return new ContainerWorkbench(lllllllllllllllIIIlIlllIlIIlllll, this.world, this.position);
        }
        
        @Override
        public ITextComponent getDisplayName() {
            return new TextComponentTranslation(String.valueOf(new StringBuilder(String.valueOf(Blocks.CRAFTING_TABLE.getUnlocalizedName())).append(".name")), new Object[0]);
        }
        
        public InterfaceCraftingTable(final World lllllllllllllllIIIlIlllIlIlIlIlI, final BlockPos lllllllllllllllIIIlIlllIlIlIlIIl) {
            this.world = lllllllllllllllIIIlIlllIlIlIlIlI;
            this.position = lllllllllllllllIIIlIlllIlIlIlIIl;
        }
        
        @Override
        public String getName() {
            return "crafting_table";
        }
        
        @Override
        public boolean hasCustomName() {
            return false;
        }
        
        @Override
        public String getGuiID() {
            return "minecraft:crafting_table";
        }
    }
}
