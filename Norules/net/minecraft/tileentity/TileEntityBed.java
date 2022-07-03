package net.minecraft.tileentity;

import net.minecraft.network.play.server.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;

public class TileEntityBed extends TileEntity
{
    private /* synthetic */ EnumDyeColor field_193053_a;
    
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 11, this.getUpdateTag());
    }
    
    public ItemStack func_193049_f() {
        return new ItemStack(Items.BED, 1, this.field_193053_a.getMetadata());
    }
    
    public TileEntityBed() {
        this.field_193053_a = EnumDyeColor.RED;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllIIIllllIIllllIlllI) {
        super.writeToNBT(llllllllllllllIIIllllIIllllIlllI);
        llllllllllllllIIIllllIIllllIlllI.setInteger("color", this.field_193053_a.getMetadata());
        return llllllllllllllIIIllllIIllllIlllI;
    }
    
    public void func_193051_a(final ItemStack llllllllllllllIIIllllIlIIIIIIlII) {
        this.func_193052_a(EnumDyeColor.byMetadata(llllllllllllllIIIllllIlIIIIIIlII.getMetadata()));
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public boolean func_193050_e() {
        return BlockBed.func_193385_b(this.getBlockMetadata());
    }
    
    public void func_193052_a(final EnumDyeColor llllllllllllllIIIllllIIlllIlIlll) {
        this.field_193053_a = llllllllllllllIIIllllIIlllIlIlll;
        this.markDirty();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIllllIIlllllIllI) {
        super.readFromNBT(llllllllllllllIIIllllIIlllllIllI);
        if (llllllllllllllIIIllllIIlllllIllI.hasKey("color")) {
            this.field_193053_a = EnumDyeColor.byMetadata(llllllllllllllIIIllllIIlllllIllI.getInteger("color"));
        }
    }
    
    public EnumDyeColor func_193048_a() {
        return this.field_193053_a;
    }
}
