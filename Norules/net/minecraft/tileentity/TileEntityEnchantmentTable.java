package net.minecraft.tileentity;

import net.minecraft.util.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.util.text.*;

public class TileEntityEnchantmentTable extends TileEntity implements ITickable, IInteractionObject
{
    public /* synthetic */ float bookRotationPrev;
    public /* synthetic */ float pageFlipPrev;
    public /* synthetic */ float bookSpread;
    public /* synthetic */ float flipA;
    public /* synthetic */ float bookRotation;
    public /* synthetic */ float bookSpreadPrev;
    public /* synthetic */ float pageFlip;
    private static final /* synthetic */ Random rand;
    public /* synthetic */ float flipT;
    public /* synthetic */ int tickCount;
    private /* synthetic */ String customName;
    public /* synthetic */ float tRot;
    
    public void setCustomName(final String lllllllllllllIllIllIlIllllIllllI) {
        this.customName = lllllllllllllIllIllIlIllllIllllI;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIllIllIllIIIIIIIllI) {
        super.writeToNBT(lllllllllllllIllIllIllIIIIIIIllI);
        if (this.hasCustomName()) {
            lllllllllllllIllIllIllIIIIIIIllI.setString("CustomName", this.customName);
        }
        return lllllllllllllIllIllIllIIIIIIIllI;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:enchanting_table";
    }
    
    static {
        rand = new Random();
    }
    
    @Override
    public void update() {
        this.bookSpreadPrev = this.bookSpread;
        this.bookRotationPrev = this.bookRotation;
        final EntityPlayer lllllllllllllIllIllIlIllllllIllI = this.world.getClosestPlayer(this.pos.getX() + 0.5f, this.pos.getY() + 0.5f, this.pos.getZ() + 0.5f, 3.0, false);
        if (lllllllllllllIllIllIlIllllllIllI != null) {
            final double lllllllllllllIllIllIlIllllllIlIl = lllllllllllllIllIllIlIllllllIllI.posX - (this.pos.getX() + 0.5f);
            final double lllllllllllllIllIllIlIllllllIlII = lllllllllllllIllIllIlIllllllIllI.posZ - (this.pos.getZ() + 0.5f);
            this.tRot = (float)MathHelper.atan2(lllllllllllllIllIllIlIllllllIlII, lllllllllllllIllIllIlIllllllIlIl);
            this.bookSpread += 0.1f;
            if (this.bookSpread < 0.5f || TileEntityEnchantmentTable.rand.nextInt(40) == 0) {
                final float lllllllllllllIllIllIlIllllllIIll = this.flipT;
                do {
                    this.flipT += TileEntityEnchantmentTable.rand.nextInt(4) - TileEntityEnchantmentTable.rand.nextInt(4);
                } while (lllllllllllllIllIllIlIllllllIIll == this.flipT);
            }
        }
        else {
            this.tRot += 0.02f;
            this.bookSpread -= 0.1f;
        }
        while (this.bookRotation >= 3.1415927f) {
            this.bookRotation -= 6.2831855f;
        }
        while (this.bookRotation < -3.1415927f) {
            this.bookRotation += 6.2831855f;
        }
        while (this.tRot >= 3.1415927f) {
            this.tRot -= 6.2831855f;
        }
        while (this.tRot < -3.1415927f) {
            this.tRot += 6.2831855f;
        }
        float lllllllllllllIllIllIlIllllllIIlI;
        for (lllllllllllllIllIllIlIllllllIIlI = this.tRot - this.bookRotation; lllllllllllllIllIllIlIllllllIIlI >= 3.1415927f; lllllllllllllIllIllIlIllllllIIlI -= 6.2831855f) {}
        while (lllllllllllllIllIllIlIllllllIIlI < -3.1415927f) {
            lllllllllllllIllIllIlIllllllIIlI += 6.2831855f;
        }
        this.bookRotation += lllllllllllllIllIllIlIllllllIIlI * 0.4f;
        this.bookSpread = MathHelper.clamp(this.bookSpread, 0.0f, 1.0f);
        ++this.tickCount;
        this.pageFlipPrev = this.pageFlip;
        float lllllllllllllIllIllIlIllllllIIIl = (this.flipT - this.pageFlip) * 0.4f;
        final float lllllllllllllIllIllIlIllllllIIII = 0.2f;
        lllllllllllllIllIllIlIllllllIIIl = MathHelper.clamp(lllllllllllllIllIllIlIllllllIIIl, -0.2f, 0.2f);
        this.flipA += (lllllllllllllIllIllIlIllllllIIIl - this.flipA) * 0.9f;
        this.pageFlip += this.flipA;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllIllIllIlIllllIlIlll, final EntityPlayer lllllllllllllIllIllIlIllllIlIllI) {
        return new ContainerEnchantment(lllllllllllllIllIllIlIllllIlIlll, this.world, this.pos);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIllIllIllIIIIIIIIII) {
        super.readFromNBT(lllllllllllllIllIllIllIIIIIIIIII);
        if (lllllllllllllIllIllIllIIIIIIIIII.hasKey("CustomName", 8)) {
            this.customName = lllllllllllllIllIllIllIIIIIIIIII.getString("CustomName");
        }
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.enchant";
    }
    
    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }
}
