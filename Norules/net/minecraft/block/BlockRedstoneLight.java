package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;

public class BlockRedstoneLight extends Block
{
    private final /* synthetic */ boolean isOn;
    
    @Override
    public void onBlockAdded(final World llIIIllIIlllIlI, final BlockPos llIIIllIIllIlIl, final IBlockState llIIIllIIlllIII) {
        if (!llIIIllIIlllIlI.isRemote) {
            if (this.isOn && !llIIIllIIlllIlI.isBlockPowered(llIIIllIIllIlIl)) {
                llIIIllIIlllIlI.setBlockState(llIIIllIIllIlIl, Blocks.REDSTONE_LAMP.getDefaultState(), 2);
            }
            else if (!this.isOn && llIIIllIIlllIlI.isBlockPowered(llIIIllIIllIlIl)) {
                llIIIllIIlllIlI.setBlockState(llIIIllIIllIlIl, Blocks.LIT_REDSTONE_LAMP.getDefaultState(), 2);
            }
        }
    }
    
    @Override
    public void updateTick(final World llIIIllIIlIIlII, final BlockPos llIIIllIIlIIIll, final IBlockState llIIIllIIlIIIlI, final Random llIIIllIIlIIIIl) {
        if (!llIIIllIIlIIlII.isRemote && this.isOn && !llIIIllIIlIIlII.isBlockPowered(llIIIllIIlIIIll)) {
            llIIIllIIlIIlII.setBlockState(llIIIllIIlIIIll, Blocks.REDSTONE_LAMP.getDefaultState(), 2);
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState llIIIllIIllIIII, final World llIIIllIIlIllll, final BlockPos llIIIllIIlIlIIl, final Block llIIIllIIlIllIl, final BlockPos llIIIllIIlIllII) {
        if (!llIIIllIIlIllll.isRemote) {
            if (this.isOn && !llIIIllIIlIllll.isBlockPowered(llIIIllIIlIlIIl)) {
                llIIIllIIlIllll.scheduleUpdate(llIIIllIIlIlIIl, this, 4);
            }
            else if (!this.isOn && llIIIllIIlIllll.isBlockPowered(llIIIllIIlIlIIl)) {
                llIIIllIIlIllll.setBlockState(llIIIllIIlIlIIl, Blocks.LIT_REDSTONE_LAMP.getDefaultState(), 2);
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState llIIIllIIIlllII, final Random llIIIllIIIllIll, final int llIIIllIIIllIlI) {
        return Item.getItemFromBlock(Blocks.REDSTONE_LAMP);
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llIIIllIIIlIlII) {
        return new ItemStack(Blocks.REDSTONE_LAMP);
    }
    
    public BlockRedstoneLight(final boolean llIIIllIIllllll) {
        super(Material.REDSTONE_LIGHT);
        this.isOn = llIIIllIIllllll;
        if (llIIIllIIllllll) {
            this.setLightLevel(1.0f);
        }
    }
    
    @Override
    public ItemStack getItem(final World llIIIllIIIllIII, final BlockPos llIIIllIIIlIlll, final IBlockState llIIIllIIIlIllI) {
        return new ItemStack(Blocks.REDSTONE_LAMP);
    }
}
