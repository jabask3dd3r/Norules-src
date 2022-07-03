package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;

public class SlotFurnaceOutput extends Slot
{
    private /* synthetic */ int removeCount;
    private final /* synthetic */ EntityPlayer thePlayer;
    
    @Override
    public boolean isItemValid(final ItemStack llllllllllllIllllllllIllIlllIIII) {
        return false;
    }
    
    @Override
    public ItemStack func_190901_a(final EntityPlayer llllllllllllIllllllllIllIllIIlIl, final ItemStack llllllllllllIllllllllIllIllIIIIl) {
        this.onCrafting(llllllllllllIllllllllIllIllIIIIl);
        super.func_190901_a(llllllllllllIllllllllIllIllIIlIl, llllllllllllIllllllllIllIllIIIIl);
        return llllllllllllIllllllllIllIllIIIIl;
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllIllllllllIllIlIIlIll) {
        llllllllllllIllllllllIllIlIIlIll.onCrafting(this.thePlayer.world, this.thePlayer, this.removeCount);
        if (!this.thePlayer.world.isRemote) {
            int llllllllllllIllllllllIllIlIlIIII = this.removeCount;
            final float llllllllllllIllllllllIllIlIIllll = FurnaceRecipes.instance().getSmeltingExperience(llllllllllllIllllllllIllIlIIlIll);
            if (llllllllllllIllllllllIllIlIIllll == 0.0f) {
                llllllllllllIllllllllIllIlIlIIII = 0;
            }
            else if (llllllllllllIllllllllIllIlIIllll < 1.0f) {
                int llllllllllllIllllllllIllIlIIlllI = MathHelper.floor(llllllllllllIllllllllIllIlIlIIII * llllllllllllIllllllllIllIlIIllll);
                if (llllllllllllIllllllllIllIlIIlllI < MathHelper.ceil(llllllllllllIllllllllIllIlIlIIII * llllllllllllIllllllllIllIlIIllll) && Math.random() < llllllllllllIllllllllIllIlIlIIII * llllllllllllIllllllllIllIlIIllll - llllllllllllIllllllllIllIlIIlllI) {
                    ++llllllllllllIllllllllIllIlIIlllI;
                }
                llllllllllllIllllllllIllIlIlIIII = llllllllllllIllllllllIllIlIIlllI;
            }
            while (llllllllllllIllllllllIllIlIlIIII > 0) {
                final int llllllllllllIllllllllIllIlIIllIl = EntityXPOrb.getXPSplit(llllllllllllIllllllllIllIlIlIIII);
                llllllllllllIllllllllIllIlIlIIII -= llllllllllllIllllllllIllIlIIllIl;
                this.thePlayer.world.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.world, this.thePlayer.posX, this.thePlayer.posY + 0.5, this.thePlayer.posZ + 0.5, llllllllllllIllllllllIllIlIIllIl));
            }
        }
        this.removeCount = 0;
    }
    
    public SlotFurnaceOutput(final EntityPlayer llllllllllllIllllllllIllIlllllII, final IInventory llllllllllllIllllllllIllIlllIlIl, final int llllllllllllIllllllllIllIlllIlII, final int llllllllllllIllllllllIllIlllIIll, final int llllllllllllIllllllllIllIllllIII) {
        super(llllllllllllIllllllllIllIlllIlIl, llllllllllllIllllllllIllIlllIlII, llllllllllllIllllllllIllIlllIIll, llllllllllllIllllllllIllIllllIII);
        this.thePlayer = llllllllllllIllllllllIllIlllllII;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllIllllllllIllIllIlIlI) {
        if (this.getHasStack()) {
            this.removeCount += Math.min(llllllllllllIllllllllIllIllIlIlI, this.getStack().func_190916_E());
        }
        return super.decrStackSize(llllllllllllIllllllllIllIllIlIlI);
    }
    
    @Override
    protected void onCrafting(final ItemStack llllllllllllIllllllllIllIlIlllII, final int llllllllllllIllllllllIllIlIllIII) {
        this.removeCount += llllllllllllIllllllllIllIlIllIII;
        this.onCrafting(llllllllllllIllllllllIllIlIlllII);
    }
}
