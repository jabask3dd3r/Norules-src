package net.minecraft.entity.passive;

import net.minecraft.world.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;

public abstract class AbstractChestHorse extends AbstractHorse
{
    private static final /* synthetic */ DataParameter<Boolean> field_190698_bG;
    
    public AbstractChestHorse(final World lllllllllllllIllIIlllllIlllllIlI) {
        super(lllllllllllllIllIIlllllIlllllIlI);
        this.field_190688_bE = false;
    }
    
    protected void func_190697_dk() {
        this.playSound(SoundEvents.ENTITY_DONKEY_CHEST, 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
    }
    
    @Override
    protected int func_190686_di() {
        return this.func_190695_dh() ? 17 : super.func_190686_di();
    }
    
    public static void func_190694_b(final DataFixer lllllllllllllIllIIlllllIllIlIlll, final Class<?> lllllllllllllIllIIlllllIllIllIII) {
        AbstractHorse.func_190683_c(lllllllllllllIllIIlllllIllIlIlll, lllllllllllllIllIIlllllIllIllIII);
        lllllllllllllIllIIlllllIllIlIlll.registerWalker(FixTypes.ENTITY, new ItemStackDataLists(lllllllllllllIllIIlllllIllIllIII, new String[] { "Items" }));
    }
    
    static {
        field_190698_bG = EntityDataManager.createKey(AbstractChestHorse.class, DataSerializers.BOOLEAN);
    }
    
    @Override
    public boolean processInteract(final EntityPlayer lllllllllllllIllIIlllllIlIIlllIl, final EnumHand lllllllllllllIllIIlllllIlIIlllII) {
        final ItemStack lllllllllllllIllIIlllllIlIlIIIII = lllllllllllllIllIIlllllIlIIlllIl.getHeldItem(lllllllllllllIllIIlllllIlIIlllII);
        if (lllllllllllllIllIIlllllIlIlIIIII.getItem() == Items.SPAWN_EGG) {
            return super.processInteract(lllllllllllllIllIIlllllIlIIlllIl, lllllllllllllIllIIlllllIlIIlllII);
        }
        if (!this.isChild()) {
            if (this.isTame() && lllllllllllllIllIIlllllIlIIlllIl.isSneaking()) {
                this.openGUI(lllllllllllllIllIIlllllIlIIlllIl);
                return true;
            }
            if (this.isBeingRidden()) {
                return super.processInteract(lllllllllllllIllIIlllllIlIIlllIl, lllllllllllllIllIIlllllIlIIlllII);
            }
        }
        if (!lllllllllllllIllIIlllllIlIlIIIII.func_190926_b()) {
            boolean lllllllllllllIllIIlllllIlIIlllll = this.func_190678_b(lllllllllllllIllIIlllllIlIIlllIl, lllllllllllllIllIIlllllIlIlIIIII);
            if (!lllllllllllllIllIIlllllIlIIlllll && !this.isTame()) {
                if (lllllllllllllIllIIlllllIlIlIIIII.interactWithEntity(lllllllllllllIllIIlllllIlIIlllIl, this, lllllllllllllIllIIlllllIlIIlllII)) {
                    return true;
                }
                this.func_190687_dF();
                return true;
            }
            else {
                if (!lllllllllllllIllIIlllllIlIIlllll && !this.func_190695_dh() && lllllllllllllIllIIlllllIlIlIIIII.getItem() == Item.getItemFromBlock(Blocks.CHEST)) {
                    this.setChested(true);
                    this.func_190697_dk();
                    lllllllllllllIllIIlllllIlIIlllll = true;
                    this.initHorseChest();
                }
                if (!lllllllllllllIllIIlllllIlIIlllll && !this.isChild() && !this.isHorseSaddled() && lllllllllllllIllIIlllllIlIlIIIII.getItem() == Items.SADDLE) {
                    this.openGUI(lllllllllllllIllIIlllllIlIIlllIl);
                    return true;
                }
                if (lllllllllllllIllIIlllllIlIIlllll) {
                    if (!lllllllllllllIllIIlllllIlIIlllIl.capabilities.isCreativeMode) {
                        lllllllllllllIllIIlllllIlIlIIIII.func_190918_g(1);
                    }
                    return true;
                }
            }
        }
        if (this.isChild()) {
            return super.processInteract(lllllllllllllIllIIlllllIlIIlllIl, lllllllllllllIllIIlllllIlIIlllII);
        }
        if (lllllllllllllIllIIlllllIlIlIIIII.interactWithEntity(lllllllllllllIllIIlllllIlIIlllIl, this, lllllllllllllIllIIlllllIlIIlllII)) {
            return true;
        }
        this.mountTo(lllllllllllllIllIIlllllIlIIlllIl);
        return true;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIllIIlllllIlIllllII) {
        super.readEntityFromNBT(lllllllllllllIllIIlllllIlIllllII);
        this.setChested(lllllllllllllIllIIlllllIlIllllII.getBoolean("ChestedHorse"));
        if (this.func_190695_dh()) {
            final NBTTagList lllllllllllllIllIIlllllIlIlllIll = lllllllllllllIllIIlllllIlIllllII.getTagList("Items", 10);
            this.initHorseChest();
            for (int lllllllllllllIllIIlllllIlIlllIlI = 0; lllllllllllllIllIIlllllIlIlllIlI < lllllllllllllIllIIlllllIlIlllIll.tagCount(); ++lllllllllllllIllIIlllllIlIlllIlI) {
                final NBTTagCompound lllllllllllllIllIIlllllIlIlllIIl = lllllllllllllIllIIlllllIlIlllIll.getCompoundTagAt(lllllllllllllIllIIlllllIlIlllIlI);
                final int lllllllllllllIllIIlllllIlIlllIII = lllllllllllllIllIIlllllIlIlllIIl.getByte("Slot") & 0xFF;
                if (lllllllllllllIllIIlllllIlIlllIII >= 2 && lllllllllllllIllIIlllllIlIlllIII < this.horseChest.getSizeInventory()) {
                    this.horseChest.setInventorySlotContents(lllllllllllllIllIIlllllIlIlllIII, new ItemStack(lllllllllllllIllIIlllllIlIlllIIl));
                }
            }
        }
        this.updateHorseSlots();
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(AbstractChestHorse.field_190698_bG, false);
    }
    
    @Override
    protected SoundEvent getAngrySound() {
        super.getAngrySound();
        return SoundEvents.ENTITY_DONKEY_ANGRY;
    }
    
    @Override
    public double getMountedYOffset() {
        return super.getMountedYOffset() - 0.25;
    }
    
    @Override
    public boolean replaceItemInInventory(final int lllllllllllllIllIIlllllIlIlIllIl, final ItemStack lllllllllllllIllIIlllllIlIlIllII) {
        if (lllllllllllllIllIIlllllIlIlIllIl == 499) {
            if (this.func_190695_dh() && lllllllllllllIllIIlllllIlIlIllII.func_190926_b()) {
                this.setChested(false);
                this.initHorseChest();
                return true;
            }
            if (!this.func_190695_dh() && lllllllllllllIllIIlllllIlIlIllII.getItem() == Item.getItemFromBlock(Blocks.CHEST)) {
                this.setChested(true);
                this.initHorseChest();
                return true;
            }
        }
        return super.replaceItemInInventory(lllllllllllllIllIIlllllIlIlIllIl, lllllllllllllIllIIlllllIlIlIllII);
    }
    
    @Override
    public void onDeath(final DamageSource lllllllllllllIllIIlllllIllIllllI) {
        super.onDeath(lllllllllllllIllIIlllllIllIllllI);
        if (this.func_190695_dh()) {
            if (!this.world.isRemote) {
                this.dropItem(Item.getItemFromBlock(Blocks.CHEST), 1);
            }
            this.setChested(false);
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.getModifiedMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.17499999701976776);
        this.getEntityAttribute(AbstractChestHorse.JUMP_STRENGTH).setBaseValue(0.5);
    }
    
    public void setChested(final boolean lllllllllllllIllIIlllllIlllIllIl) {
        this.dataManager.set(AbstractChestHorse.field_190698_bG, lllllllllllllIllIIlllllIlllIllIl);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIllIIlllllIllIIlIII) {
        super.writeEntityToNBT(lllllllllllllIllIIlllllIllIIlIII);
        lllllllllllllIllIIlllllIllIIlIII.setBoolean("ChestedHorse", this.func_190695_dh());
        if (this.func_190695_dh()) {
            final NBTTagList lllllllllllllIllIIlllllIllIIllIl = new NBTTagList();
            for (int lllllllllllllIllIIlllllIllIIllII = 2; lllllllllllllIllIIlllllIllIIllII < this.horseChest.getSizeInventory(); ++lllllllllllllIllIIlllllIllIIllII) {
                final ItemStack lllllllllllllIllIIlllllIllIIlIll = this.horseChest.getStackInSlot(lllllllllllllIllIIlllllIllIIllII);
                if (!lllllllllllllIllIIlllllIllIIlIll.func_190926_b()) {
                    final NBTTagCompound lllllllllllllIllIIlllllIllIIlIlI = new NBTTagCompound();
                    lllllllllllllIllIIlllllIllIIlIlI.setByte("Slot", (byte)lllllllllllllIllIIlllllIllIIllII);
                    lllllllllllllIllIIlllllIllIIlIll.writeToNBT(lllllllllllllIllIIlllllIllIIlIlI);
                    lllllllllllllIllIIlllllIllIIllIl.appendTag(lllllllllllllIllIIlllllIllIIlIlI);
                }
            }
            lllllllllllllIllIIlllllIllIIlIII.setTag("Items", lllllllllllllIllIIlllllIllIIllIl);
        }
    }
    
    public boolean func_190695_dh() {
        return this.dataManager.get(AbstractChestHorse.field_190698_bG);
    }
    
    public int func_190696_dl() {
        return 5;
    }
}
