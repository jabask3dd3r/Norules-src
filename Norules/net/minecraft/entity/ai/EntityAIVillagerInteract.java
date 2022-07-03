package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;

public class EntityAIVillagerInteract extends EntityAIWatchClosest2
{
    private final /* synthetic */ EntityVillager villager;
    private /* synthetic */ int interactionDelay;
    
    public EntityAIVillagerInteract(final EntityVillager lllllllllllllIllIIIlllIllIlIIIII) {
        super(lllllllllllllIllIIIlllIllIlIIIII, EntityVillager.class, 3.0f, 0.02f);
        this.villager = lllllllllllllIllIIIlllIllIlIIIII;
    }
    
    @Override
    public void startExecuting() {
        super.startExecuting();
        if (this.villager.canAbondonItems() && this.closestEntity instanceof EntityVillager && ((EntityVillager)this.closestEntity).wantsMoreFood()) {
            this.interactionDelay = 10;
        }
        else {
            this.interactionDelay = 0;
        }
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
        if (this.interactionDelay > 0) {
            --this.interactionDelay;
            if (this.interactionDelay == 0) {
                final InventoryBasic lllllllllllllIllIIIlllIllIIIlllI = this.villager.getVillagerInventory();
                for (int lllllllllllllIllIIIlllIllIIIllIl = 0; lllllllllllllIllIIIlllIllIIIllIl < lllllllllllllIllIIIlllIllIIIlllI.getSizeInventory(); ++lllllllllllllIllIIIlllIllIIIllIl) {
                    final ItemStack lllllllllllllIllIIIlllIllIIIllII = lllllllllllllIllIIIlllIllIIIlllI.getStackInSlot(lllllllllllllIllIIIlllIllIIIllIl);
                    ItemStack lllllllllllllIllIIIlllIllIIIlIll = ItemStack.field_190927_a;
                    if (!lllllllllllllIllIIIlllIllIIIllII.func_190926_b()) {
                        final Item lllllllllllllIllIIIlllIllIIIlIlI = lllllllllllllIllIIIlllIllIIIllII.getItem();
                        if ((lllllllllllllIllIIIlllIllIIIlIlI == Items.BREAD || lllllllllllllIllIIIlllIllIIIlIlI == Items.POTATO || lllllllllllllIllIIIlllIllIIIlIlI == Items.CARROT || lllllllllllllIllIIIlllIllIIIlIlI == Items.BEETROOT) && lllllllllllllIllIIIlllIllIIIllII.func_190916_E() > 3) {
                            final int lllllllllllllIllIIIlllIllIIIlIIl = lllllllllllllIllIIIlllIllIIIllII.func_190916_E() / 2;
                            lllllllllllllIllIIIlllIllIIIllII.func_190918_g(lllllllllllllIllIIIlllIllIIIlIIl);
                            lllllllllllllIllIIIlllIllIIIlIll = new ItemStack(lllllllllllllIllIIIlllIllIIIlIlI, lllllllllllllIllIIIlllIllIIIlIIl, lllllllllllllIllIIIlllIllIIIllII.getMetadata());
                        }
                        else if (lllllllllllllIllIIIlllIllIIIlIlI == Items.WHEAT && lllllllllllllIllIIIlllIllIIIllII.func_190916_E() > 5) {
                            final int lllllllllllllIllIIIlllIllIIIlIII = lllllllllllllIllIIIlllIllIIIllII.func_190916_E() / 2 / 3 * 3;
                            final int lllllllllllllIllIIIlllIllIIIIlll = lllllllllllllIllIIIlllIllIIIlIII / 3;
                            lllllllllllllIllIIIlllIllIIIllII.func_190918_g(lllllllllllllIllIIIlllIllIIIlIII);
                            lllllllllllllIllIIIlllIllIIIlIll = new ItemStack(Items.BREAD, lllllllllllllIllIIIlllIllIIIIlll, 0);
                        }
                        if (lllllllllllllIllIIIlllIllIIIllII.func_190926_b()) {
                            lllllllllllllIllIIIlllIllIIIlllI.setInventorySlotContents(lllllllllllllIllIIIlllIllIIIllIl, ItemStack.field_190927_a);
                        }
                    }
                    if (!lllllllllllllIllIIIlllIllIIIlIll.func_190926_b()) {
                        final double lllllllllllllIllIIIlllIllIIIIllI = this.villager.posY - 0.30000001192092896 + this.villager.getEyeHeight();
                        final EntityItem lllllllllllllIllIIIlllIllIIIIlIl = new EntityItem(this.villager.world, this.villager.posX, lllllllllllllIllIIIlllIllIIIIllI, this.villager.posZ, lllllllllllllIllIIIlllIllIIIlIll);
                        final float lllllllllllllIllIIIlllIllIIIIlII = 0.3f;
                        final float lllllllllllllIllIIIlllIllIIIIIll = this.villager.rotationYawHead;
                        final float lllllllllllllIllIIIlllIllIIIIIlI = this.villager.rotationPitch;
                        lllllllllllllIllIIIlllIllIIIIlIl.motionX = -MathHelper.sin(lllllllllllllIllIIIlllIllIIIIIll * 0.017453292f) * MathHelper.cos(lllllllllllllIllIIIlllIllIIIIIlI * 0.017453292f) * 0.3f;
                        lllllllllllllIllIIIlllIllIIIIlIl.motionZ = MathHelper.cos(lllllllllllllIllIIIlllIllIIIIIll * 0.017453292f) * MathHelper.cos(lllllllllllllIllIIIlllIllIIIIIlI * 0.017453292f) * 0.3f;
                        lllllllllllllIllIIIlllIllIIIIlIl.motionY = -MathHelper.sin(lllllllllllllIllIIIlllIllIIIIIlI * 0.017453292f) * 0.3f + 0.1f;
                        lllllllllllllIllIIIlllIllIIIIlIl.setDefaultPickupDelay();
                        this.villager.world.spawnEntityInWorld(lllllllllllllIllIIIlllIllIIIIlIl);
                        break;
                    }
                }
            }
        }
    }
}
