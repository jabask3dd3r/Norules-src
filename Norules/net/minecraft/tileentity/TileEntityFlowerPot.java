package net.minecraft.tileentity;

import net.minecraft.nbt.*;
import net.minecraft.item.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.datafix.*;

public class TileEntityFlowerPot extends TileEntity
{
    private /* synthetic */ Item flowerPotItem;
    private /* synthetic */ int flowerPotData;
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public TileEntityFlowerPot(final Item llllllllllllllllllIIIIIIIIlIlIII, final int llllllllllllllllllIIIIIIIIlIIlII) {
        this.flowerPotItem = llllllllllllllllllIIIIIIIIlIlIII;
        this.flowerPotData = llllllllllllllllllIIIIIIIIlIIlII;
    }
    
    public void func_190614_a(final ItemStack llllllllllllllllllIIIIIIIIIIlIII) {
        this.flowerPotItem = llllllllllllllllllIIIIIIIIIIlIII.getItem();
        this.flowerPotData = llllllllllllllllllIIIIIIIIIIlIII.getMetadata();
    }
    
    public TileEntityFlowerPot() {
    }
    
    @Nullable
    public Item getFlowerPotItem() {
        return this.flowerPotItem;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllllllIIIIIIIIIlIllI) {
        super.readFromNBT(llllllllllllllllllIIIIIIIIIlIllI);
        if (llllllllllllllllllIIIIIIIIIlIllI.hasKey("Item", 8)) {
            this.flowerPotItem = Item.getByNameOrId(llllllllllllllllllIIIIIIIIIlIllI.getString("Item"));
        }
        else {
            this.flowerPotItem = Item.getItemById(llllllllllllllllllIIIIIIIIIlIllI.getInteger("Item"));
        }
        this.flowerPotData = llllllllllllllllllIIIIIIIIIlIllI.getInteger("Data");
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllllllIIIIIIIIIllIll) {
        super.writeToNBT(llllllllllllllllllIIIIIIIIIllIll);
        final ResourceLocation llllllllllllllllllIIIIIIIIIlllIl = Item.REGISTRY.getNameForObject(this.flowerPotItem);
        llllllllllllllllllIIIIIIIIIllIll.setString("Item", (llllllllllllllllllIIIIIIIIIlllIl == null) ? "" : llllllllllllllllllIIIIIIIIIlllIl.toString());
        llllllllllllllllllIIIIIIIIIllIll.setInteger("Data", this.flowerPotData);
        return llllllllllllllllllIIIIIIIIIllIll;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 5, this.getUpdateTag());
    }
    
    public ItemStack getFlowerItemStack() {
        return (this.flowerPotItem == null) ? ItemStack.field_190927_a : new ItemStack(this.flowerPotItem, 1, this.flowerPotData);
    }
    
    public int getFlowerPotData() {
        return this.flowerPotData;
    }
    
    public static void registerFixesFlowerPot(final DataFixer llllllllllllllllllIIIIIIIIlIIIll) {
    }
}
