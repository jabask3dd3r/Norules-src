package net.minecraft.item;

import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.*;
import net.minecraft.dispenser.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;

public class ItemMinecart extends Item
{
    private static final /* synthetic */ IBehaviorDispenseItem MINECART_DISPENSER_BEHAVIOR;
    private final /* synthetic */ EntityMinecart.Type minecartType;
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer llllllllllllIlllllIIlIlIlIllllII, final World llllllllllllIlllllIIlIlIlIlllIll, final BlockPos llllllllllllIlllllIIlIlIlIlIllII, final EnumHand llllllllllllIlllllIIlIlIlIlIlIll, final EnumFacing llllllllllllIlllllIIlIlIlIlllIII, final float llllllllllllIlllllIIlIlIlIllIlll, final float llllllllllllIlllllIIlIlIlIllIllI, final float llllllllllllIlllllIIlIlIlIllIlIl) {
        final IBlockState llllllllllllIlllllIIlIlIlIllIlII = llllllllllllIlllllIIlIlIlIlllIll.getBlockState(llllllllllllIlllllIIlIlIlIlIllII);
        if (!BlockRailBase.isRailBlock(llllllllllllIlllllIIlIlIlIllIlII)) {
            return EnumActionResult.FAIL;
        }
        final ItemStack llllllllllllIlllllIIlIlIlIllIIll = llllllllllllIlllllIIlIlIlIllllII.getHeldItem(llllllllllllIlllllIIlIlIlIlIlIll);
        if (!llllllllllllIlllllIIlIlIlIlllIll.isRemote) {
            final BlockRailBase.EnumRailDirection llllllllllllIlllllIIlIlIlIllIIlI = (llllllllllllIlllllIIlIlIlIllIlII.getBlock() instanceof BlockRailBase) ? llllllllllllIlllllIIlIlIlIllIlII.getValue(((BlockRailBase)llllllllllllIlllllIIlIlIlIllIlII.getBlock()).getShapeProperty()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
            double llllllllllllIlllllIIlIlIlIllIIIl = 0.0;
            if (llllllllllllIlllllIIlIlIlIllIIlI.isAscending()) {
                llllllllllllIlllllIIlIlIlIllIIIl = 0.5;
            }
            final EntityMinecart llllllllllllIlllllIIlIlIlIllIIII = EntityMinecart.create(llllllllllllIlllllIIlIlIlIlllIll, llllllllllllIlllllIIlIlIlIlIllII.getX() + 0.5, llllllllllllIlllllIIlIlIlIlIllII.getY() + 0.0625 + llllllllllllIlllllIIlIlIlIllIIIl, llllllllllllIlllllIIlIlIlIlIllII.getZ() + 0.5, this.minecartType);
            if (llllllllllllIlllllIIlIlIlIllIIll.hasDisplayName()) {
                llllllllllllIlllllIIlIlIlIllIIII.setCustomNameTag(llllllllllllIlllllIIlIlIlIllIIll.getDisplayName());
            }
            llllllllllllIlllllIIlIlIlIlllIll.spawnEntityInWorld(llllllllllllIlllllIIlIlIlIllIIII);
        }
        llllllllllllIlllllIIlIlIlIllIIll.func_190918_g(1);
        return EnumActionResult.SUCCESS;
    }
    
    public ItemMinecart(final EntityMinecart.Type llllllllllllIlllllIIlIlIllIIlIII) {
        this.maxStackSize = 1;
        this.minecartType = llllllllllllIlllllIIlIlIllIIlIII;
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemMinecart.MINECART_DISPENSER_BEHAVIOR);
    }
    
    static {
        MINECART_DISPENSER_BEHAVIOR = new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem behaviourDefaultDispenseItem = new BehaviorDefaultDispenseItem();
            
            @Override
            protected void playDispenseSound(final IBlockSource lllllllllllllIIIllIlIIIIIIlIIIIl) {
                lllllllllllllIIIllIlIIIIIIlIIIIl.getWorld().playEvent(1000, lllllllllllllIIIllIlIIIIIIlIIIIl.getBlockPos(), 0);
            }
            
            public ItemStack dispenseStack(final IBlockSource lllllllllllllIIIllIlIIIIIIllIIIl, final ItemStack lllllllllllllIIIllIlIIIIIlIIIIlI) {
                final EnumFacing lllllllllllllIIIllIlIIIIIlIIIIIl = lllllllllllllIIIllIlIIIIIIllIIIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final World lllllllllllllIIIllIlIIIIIlIIIIII = lllllllllllllIIIllIlIIIIIIllIIIl.getWorld();
                final double lllllllllllllIIIllIlIIIIIIllllll = lllllllllllllIIIllIlIIIIIIllIIIl.getX() + lllllllllllllIIIllIlIIIIIlIIIIIl.getFrontOffsetX() * 1.125;
                final double lllllllllllllIIIllIlIIIIIIlllllI = Math.floor(lllllllllllllIIIllIlIIIIIIllIIIl.getY()) + lllllllllllllIIIllIlIIIIIlIIIIIl.getFrontOffsetY();
                final double lllllllllllllIIIllIlIIIIIIllllIl = lllllllllllllIIIllIlIIIIIIllIIIl.getZ() + lllllllllllllIIIllIlIIIIIlIIIIIl.getFrontOffsetZ() * 1.125;
                final BlockPos lllllllllllllIIIllIlIIIIIIllllII = lllllllllllllIIIllIlIIIIIIllIIIl.getBlockPos().offset(lllllllllllllIIIllIlIIIIIlIIIIIl);
                final IBlockState lllllllllllllIIIllIlIIIIIIlllIll = lllllllllllllIIIllIlIIIIIlIIIIII.getBlockState(lllllllllllllIIIllIlIIIIIIllllII);
                final BlockRailBase.EnumRailDirection lllllllllllllIIIllIlIIIIIIlllIlI = (lllllllllllllIIIllIlIIIIIIlllIll.getBlock() instanceof BlockRailBase) ? lllllllllllllIIIllIlIIIIIIlllIll.getValue(((BlockRailBase)lllllllllllllIIIllIlIIIIIIlllIll.getBlock()).getShapeProperty()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
                double lllllllllllllIIIllIlIIIIIIllIllI = 0.0;
                if (BlockRailBase.isRailBlock(lllllllllllllIIIllIlIIIIIIlllIll)) {
                    if (lllllllllllllIIIllIlIIIIIIlllIlI.isAscending()) {
                        final double lllllllllllllIIIllIlIIIIIIlllIIl = 0.6;
                    }
                    else {
                        final double lllllllllllllIIIllIlIIIIIIlllIII = 0.1;
                    }
                }
                else {
                    if (lllllllllllllIIIllIlIIIIIIlllIll.getMaterial() != Material.AIR || !BlockRailBase.isRailBlock(lllllllllllllIIIllIlIIIIIlIIIIII.getBlockState(lllllllllllllIIIllIlIIIIIIllllII.down()))) {
                        return this.behaviourDefaultDispenseItem.dispense(lllllllllllllIIIllIlIIIIIIllIIIl, lllllllllllllIIIllIlIIIIIlIIIIlI);
                    }
                    final IBlockState lllllllllllllIIIllIlIIIIIIllIlIl = lllllllllllllIIIllIlIIIIIlIIIIII.getBlockState(lllllllllllllIIIllIlIIIIIIllllII.down());
                    final BlockRailBase.EnumRailDirection lllllllllllllIIIllIlIIIIIIllIlII = (lllllllllllllIIIllIlIIIIIIllIlIl.getBlock() instanceof BlockRailBase) ? lllllllllllllIIIllIlIIIIIIllIlIl.getValue(((BlockRailBase)lllllllllllllIIIllIlIIIIIIllIlIl.getBlock()).getShapeProperty()) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
                    if (lllllllllllllIIIllIlIIIIIlIIIIIl != EnumFacing.DOWN && lllllllllllllIIIllIlIIIIIIllIlII.isAscending()) {
                        final double lllllllllllllIIIllIlIIIIIIllIlll = -0.4;
                    }
                    else {
                        lllllllllllllIIIllIlIIIIIIllIllI = -0.9;
                    }
                }
                final EntityMinecart lllllllllllllIIIllIlIIIIIIllIIll = EntityMinecart.create(lllllllllllllIIIllIlIIIIIlIIIIII, lllllllllllllIIIllIlIIIIIIllllll, lllllllllllllIIIllIlIIIIIIlllllI + lllllllllllllIIIllIlIIIIIIllIllI, lllllllllllllIIIllIlIIIIIIllllIl, ((ItemMinecart)lllllllllllllIIIllIlIIIIIlIIIIlI.getItem()).minecartType);
                if (lllllllllllllIIIllIlIIIIIlIIIIlI.hasDisplayName()) {
                    lllllllllllllIIIllIlIIIIIIllIIll.setCustomNameTag(lllllllllllllIIIllIlIIIIIlIIIIlI.getDisplayName());
                }
                lllllllllllllIIIllIlIIIIIlIIIIII.spawnEntityInWorld(lllllllllllllIIIllIlIIIIIIllIIll);
                lllllllllllllIIIllIlIIIIIlIIIIlI.func_190918_g(1);
                return lllllllllllllIIIllIlIIIIIlIIIIlI;
            }
        };
    }
}
