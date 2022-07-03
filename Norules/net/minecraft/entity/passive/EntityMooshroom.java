package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import net.minecraft.init.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;

public class EntityMooshroom extends EntityCow
{
    @Override
    public boolean processInteract(final EntityPlayer llllllllllllllIllllIllIIlIllIllI, final EnumHand llllllllllllllIllllIllIIlIllIlIl) {
        final ItemStack llllllllllllllIllllIllIIlIllIlII = llllllllllllllIllllIllIIlIllIllI.getHeldItem(llllllllllllllIllllIllIIlIllIlIl);
        if (llllllllllllllIllllIllIIlIllIlII.getItem() == Items.BOWL && this.getGrowingAge() >= 0 && !llllllllllllllIllllIllIIlIllIllI.capabilities.isCreativeMode) {
            llllllllllllllIllllIllIIlIllIlII.func_190918_g(1);
            if (llllllllllllllIllllIllIIlIllIlII.func_190926_b()) {
                llllllllllllllIllllIllIIlIllIllI.setHeldItem(llllllllllllllIllllIllIIlIllIlIl, new ItemStack(Items.MUSHROOM_STEW));
            }
            else if (!llllllllllllllIllllIllIIlIllIllI.inventory.addItemStackToInventory(new ItemStack(Items.MUSHROOM_STEW))) {
                llllllllllllllIllllIllIIlIllIllI.dropItem(new ItemStack(Items.MUSHROOM_STEW), false);
            }
            return true;
        }
        if (llllllllllllllIllllIllIIlIllIlII.getItem() == Items.SHEARS && this.getGrowingAge() >= 0) {
            this.setDead();
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY + this.height / 2.0f, this.posZ, 0.0, 0.0, 0.0, new int[0]);
            if (!this.world.isRemote) {
                final EntityCow llllllllllllllIllllIllIIlIllIIll = new EntityCow(this.world);
                llllllllllllllIllllIllIIlIllIIll.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
                llllllllllllllIllllIllIIlIllIIll.setHealth(this.getHealth());
                llllllllllllllIllllIllIIlIllIIll.renderYawOffset = this.renderYawOffset;
                if (this.hasCustomName()) {
                    llllllllllllllIllllIllIIlIllIIll.setCustomNameTag(this.getCustomNameTag());
                }
                this.world.spawnEntityInWorld(llllllllllllllIllllIllIIlIllIIll);
                for (int llllllllllllllIllllIllIIlIllIIlI = 0; llllllllllllllIllllIllIIlIllIIlI < 5; ++llllllllllllllIllllIllIIlIllIIlI) {
                    this.world.spawnEntityInWorld(new EntityItem(this.world, this.posX, this.posY + this.height, this.posZ, new ItemStack(Blocks.RED_MUSHROOM)));
                }
                llllllllllllllIllllIllIIlIllIlII.damageItem(1, llllllllllllllIllllIllIIlIllIllI);
                this.playSound(SoundEvents.ENTITY_MOOSHROOM_SHEAR, 1.0f, 1.0f);
            }
            return true;
        }
        return super.processInteract(llllllllllllllIllllIllIIlIllIllI, llllllllllllllIllllIllIIlIllIlIl);
    }
    
    public static void registerFixesMooshroom(final DataFixer llllllllllllllIllllIllIIlIllllll) {
        EntityLiving.registerFixesMob(llllllllllllllIllllIllIIlIllllll, EntityMooshroom.class);
    }
    
    public EntityMooshroom(final World llllllllllllllIllllIllIIllIIIIIl) {
        super(llllllllllllllIllllIllIIllIIIIIl);
        this.setSize(0.9f, 1.4f);
        this.spawnableBlock = Blocks.MYCELIUM;
    }
    
    @Override
    public EntityMooshroom createChild(final EntityAgeable llllllllllllllIllllIllIIlIlIlIIl) {
        return new EntityMooshroom(this.world);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_MUSHROOM_COW;
    }
}
