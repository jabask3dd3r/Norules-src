package net.minecraft.entity.item;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class EntityMinecartChest extends EntityMinecartContainer
{
    public EntityMinecartChest(final World lllllllllllllllIllIIllIllIllIIll, final double lllllllllllllllIllIIllIllIlIllIl, final double lllllllllllllllIllIIllIllIlIllII, final double lllllllllllllllIllIIllIllIlIlIll) {
        super(lllllllllllllllIllIIllIllIllIIll, lllllllllllllllIllIIllIllIlIllIl, lllllllllllllllIllIIllIllIlIllII, lllllllllllllllIllIIllIllIlIlIll);
    }
    
    @Override
    public int getDefaultDisplayTileOffset() {
        return 8;
    }
    
    public EntityMinecartChest(final World lllllllllllllllIllIIllIllIlllIlI) {
        super(lllllllllllllllIllIIllIllIlllIlI);
    }
    
    @Override
    public IBlockState getDefaultDisplayTile() {
        return Blocks.CHEST.getDefaultState().withProperty((IProperty<Comparable>)BlockChest.FACING, EnumFacing.NORTH);
    }
    
    public static void registerFixesMinecartChest(final DataFixer lllllllllllllllIllIIllIllIlIlIII) {
        EntityMinecartContainer.func_190574_b(lllllllllllllllIllIIllIllIlIlIII, EntityMinecartChest.class);
    }
    
    @Override
    public Type getType() {
        return Type.CHEST;
    }
    
    @Override
    public void killMinecart(final DamageSource lllllllllllllllIllIIllIllIlIIIlI) {
        super.killMinecart(lllllllllllllllIllIIllIllIlIIIlI);
        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
            this.dropItemWithOffset(Item.getItemFromBlock(Blocks.CHEST), 1, 0.0f);
        }
    }
    
    @Override
    public int getSizeInventory() {
        return 27;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllllIllIIllIllIIllIII, final EntityPlayer lllllllllllllllIllIIllIllIIlIlII) {
        this.addLoot(lllllllllllllllIllIIllIllIIlIlII);
        return new ContainerChest(lllllllllllllllIllIIllIllIIllIII, this, lllllllllllllllIllIIllIllIIlIlII);
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:chest";
    }
}
