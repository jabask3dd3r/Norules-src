package net.minecraft.entity.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.network.datasync.*;

public class EntityItemFrame extends EntityHanging
{
    private /* synthetic */ float itemDropChance;
    private static final /* synthetic */ DataParameter<Integer> ROTATION;
    private static final /* synthetic */ DataParameter<ItemStack> ITEM;
    
    public void setItemRotation(final int lllllllllllllIIllIllIIllllllIlll) {
        this.setRotation(lllllllllllllIIllIllIIllllllIlll, true);
    }
    
    public int getRotation() {
        return this.getDataManager().get(EntityItemFrame.ROTATION);
    }
    
    public EntityItemFrame(final World lllllllllllllIIllIllIlIIIllIIIII) {
        super(lllllllllllllIIllIllIlIIIllIIIII);
        this.itemDropChance = 1.0f;
    }
    
    private void setRotation(final int lllllllllllllIIllIllIIllllllIIlI, final boolean lllllllllllllIIllIllIIlllllIlllI) {
        this.getDataManager().set(EntityItemFrame.ROTATION, lllllllllllllIIllIllIIllllllIIlI % 8);
        if (lllllllllllllIIllIllIIlllllIlllI && this.hangingPosition != null) {
            this.world.updateComparatorOutputLevel(this.hangingPosition, Blocks.AIR);
        }
    }
    
    @Override
    public boolean processInitialInteract(final EntityPlayer lllllllllllllIIllIllIIllllIlIllI, final EnumHand lllllllllllllIIllIllIIllllIlIIIl) {
        final ItemStack lllllllllllllIIllIllIIllllIlIlII = lllllllllllllIIllIllIIllllIlIllI.getHeldItem(lllllllllllllIIllIllIIllllIlIIIl);
        if (!this.world.isRemote) {
            if (this.getDisplayedItem().func_190926_b()) {
                if (!lllllllllllllIIllIllIIllllIlIlII.func_190926_b()) {
                    this.setDisplayedItem(lllllllllllllIIllIllIIllllIlIlII);
                    if (!lllllllllllllIIllIllIIllllIlIllI.capabilities.isCreativeMode) {
                        lllllllllllllIIllIllIIllllIlIlII.func_190918_g(1);
                    }
                }
            }
            else {
                this.playSound(SoundEvents.ENTITY_ITEMFRAME_ROTATE_ITEM, 1.0f, 1.0f);
                this.setItemRotation(this.getRotation() + 1);
            }
        }
        return true;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lllllllllllllIIllIllIlIIIIIIIIIl) {
        if (lllllllllllllIIllIllIlIIIIIIIIIl.equals(EntityItemFrame.ITEM)) {
            final ItemStack lllllllllllllIIllIllIlIIIIIIIIll = this.getDisplayedItem();
            if (!lllllllllllllIIllIllIlIIIIIIIIll.func_190926_b() && lllllllllllllIIllIllIlIIIIIIIIll.getItemFrame() != this) {
                lllllllllllllIIllIllIlIIIIIIIIll.setItemFrame(this);
            }
        }
    }
    
    @Override
    public void onBroken(@Nullable final Entity lllllllllllllIIllIllIlIIIIlllIII) {
        this.playSound(SoundEvents.ENTITY_ITEMFRAME_BREAK, 1.0f, 1.0f);
        this.dropItemOrSelf(lllllllllllllIIllIllIlIIIIlllIII, true);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIllIllIlIIIlIIlIIl, final float lllllllllllllIIllIllIlIIIlIIlIII) {
        if (this.isEntityInvulnerable(lllllllllllllIIllIllIlIIIlIIlIIl)) {
            return false;
        }
        if (!lllllllllllllIIllIllIlIIIlIIlIIl.isExplosion() && !this.getDisplayedItem().func_190926_b()) {
            if (!this.world.isRemote) {
                this.dropItemOrSelf(lllllllllllllIIllIllIlIIIlIIlIIl.getEntity(), false);
                this.playSound(SoundEvents.ENTITY_ITEMFRAME_REMOVE_ITEM, 1.0f, 1.0f);
                this.setDisplayedItem(ItemStack.field_190927_a);
            }
            return true;
        }
        return super.attackEntityFrom(lllllllllllllIIllIllIlIIIlIIlIIl, lllllllllllllIIllIllIlIIIlIIlIII);
    }
    
    public EntityItemFrame(final World lllllllllllllIIllIllIlIIIlIlIlII, final BlockPos lllllllllllllIIllIllIlIIIlIlIlll, final EnumFacing lllllllllllllIIllIllIlIIIlIlIllI) {
        super(lllllllllllllIIllIllIlIIIlIlIlII, lllllllllllllIIllIllIlIIIlIlIlll);
        this.itemDropChance = 1.0f;
        this.updateFacingWithBoundingBox(lllllllllllllIIllIllIlIIIlIlIllI);
    }
    
    public void setDisplayedItem(final ItemStack lllllllllllllIIllIllIlIIIIIlIIlI) {
        this.setDisplayedItemWithUpdate(lllllllllllllIIllIllIlIIIIIlIIlI, true);
    }
    
    @Override
    public float getCollisionBorderSize() {
        return 0.0f;
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllIIllIllIlIIIIllllIl) {
        double lllllllllllllIIllIllIlIIIIlllllI = 16.0;
        lllllllllllllIIllIllIlIIIIlllllI = lllllllllllllIIllIllIlIIIIlllllI * 64.0 * getRenderDistanceWeight();
        return lllllllllllllIIllIllIlIIIIllllIl < lllllllllllllIIllIllIlIIIIlllllI * lllllllllllllIIllIllIlIIIIlllllI;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIllIllIIlllllIIlll) {
        if (!this.getDisplayedItem().func_190926_b()) {
            lllllllllllllIIllIllIIlllllIIlll.setTag("Item", this.getDisplayedItem().writeToNBT(new NBTTagCompound()));
            lllllllllllllIIllIllIIlllllIIlll.setByte("ItemRotation", (byte)this.getRotation());
            lllllllllllllIIllIllIIlllllIIlll.setFloat("ItemDropChance", this.itemDropChance);
        }
        super.writeEntityToNBT(lllllllllllllIIllIllIIlllllIIlll);
    }
    
    public int getAnalogOutput() {
        return this.getDisplayedItem().func_190926_b() ? 0 : (this.getRotation() % 8 + 1);
    }
    
    @Override
    protected void entityInit() {
        this.getDataManager().register(EntityItemFrame.ITEM, ItemStack.field_190927_a);
        this.getDataManager().register(EntityItemFrame.ROTATION, 0);
    }
    
    private void removeFrameFromMap(final ItemStack lllllllllllllIIllIllIlIIIIIlllII) {
        if (!lllllllllllllIIllIllIlIIIIIlllII.func_190926_b()) {
            if (lllllllllllllIIllIllIlIIIIIlllII.getItem() == Items.FILLED_MAP) {
                final MapData lllllllllllllIIllIllIlIIIIIllllI = ((ItemMap)lllllllllllllIIllIllIlIIIIIlllII.getItem()).getMapData(lllllllllllllIIllIllIlIIIIIlllII, this.world);
                lllllllllllllIIllIllIlIIIIIllllI.mapDecorations.remove(String.valueOf(new StringBuilder("frame-").append(this.getEntityId())));
            }
            lllllllllllllIIllIllIlIIIIIlllII.setItemFrame(null);
        }
    }
    
    public static void registerFixesItemFrame(final DataFixer lllllllllllllIIllIllIIlllllIlIll) {
        lllllllllllllIIllIllIIlllllIlIll.registerWalker(FixTypes.ENTITY, new ItemStackData(EntityItemFrame.class, new String[] { "Item" }));
    }
    
    private void setDisplayedItemWithUpdate(ItemStack lllllllllllllIIllIllIlIIIIIIlIlI, final boolean lllllllllllllIIllIllIlIIIIIIlIIl) {
        if (!lllllllllllllIIllIllIlIIIIIIlIlI.func_190926_b()) {
            lllllllllllllIIllIllIlIIIIIIlIlI = lllllllllllllIIllIllIlIIIIIIlIlI.copy();
            lllllllllllllIIllIllIlIIIIIIlIlI.func_190920_e(1);
            lllllllllllllIIllIllIlIIIIIIlIlI.setItemFrame(this);
        }
        this.getDataManager().set(EntityItemFrame.ITEM, lllllllllllllIIllIllIlIIIIIIlIlI);
        this.getDataManager().setDirty(EntityItemFrame.ITEM);
        if (!lllllllllllllIIllIllIlIIIIIIlIlI.func_190926_b()) {
            this.playSound(SoundEvents.ENTITY_ITEMFRAME_ADD_ITEM, 1.0f, 1.0f);
        }
        if (lllllllllllllIIllIllIlIIIIIIlIIl && this.hangingPosition != null) {
            this.world.updateComparatorOutputLevel(this.hangingPosition, Blocks.AIR);
        }
    }
    
    @Override
    public int getWidthPixels() {
        return 12;
    }
    
    @Override
    public int getHeightPixels() {
        return 12;
    }
    
    public ItemStack getDisplayedItem() {
        return this.getDataManager().get(EntityItemFrame.ITEM);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIllIllIIllllIlllIl) {
        final NBTTagCompound lllllllllllllIIllIllIIllllIlllll = lllllllllllllIIllIllIIllllIlllIl.getCompoundTag("Item");
        if (lllllllllllllIIllIllIIllllIlllll != null && !lllllllllllllIIllIllIIllllIlllll.hasNoTags()) {
            this.setDisplayedItemWithUpdate(new ItemStack(lllllllllllllIIllIllIIllllIlllll), false);
            this.setRotation(lllllllllllllIIllIllIIllllIlllIl.getByte("ItemRotation"), false);
            if (lllllllllllllIIllIllIIllllIlllIl.hasKey("ItemDropChance", 99)) {
                this.itemDropChance = lllllllllllllIIllIllIIllllIlllIl.getFloat("ItemDropChance");
            }
        }
        super.readEntityFromNBT(lllllllllllllIIllIllIIllllIlllIl);
    }
    
    static {
        ITEM = EntityDataManager.createKey(EntityItemFrame.class, DataSerializers.OPTIONAL_ITEM_STACK);
        ROTATION = EntityDataManager.createKey(EntityItemFrame.class, DataSerializers.VARINT);
    }
    
    @Override
    public void playPlaceSound() {
        this.playSound(SoundEvents.ENTITY_ITEMFRAME_PLACE, 1.0f, 1.0f);
    }
    
    public void dropItemOrSelf(@Nullable final Entity lllllllllllllIIllIllIlIIIIlIllII, final boolean lllllllllllllIIllIllIlIIIIlIlIll) {
        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
            ItemStack lllllllllllllIIllIllIlIIIIlIlIlI = this.getDisplayedItem();
            if (lllllllllllllIIllIllIlIIIIlIllII instanceof EntityPlayer) {
                final EntityPlayer lllllllllllllIIllIllIlIIIIlIlIIl = (EntityPlayer)lllllllllllllIIllIllIlIIIIlIllII;
                if (lllllllllllllIIllIllIlIIIIlIlIIl.capabilities.isCreativeMode) {
                    this.removeFrameFromMap(lllllllllllllIIllIllIlIIIIlIlIlI);
                    return;
                }
            }
            if (lllllllllllllIIllIllIlIIIIlIlIll) {
                this.entityDropItem(new ItemStack(Items.ITEM_FRAME), 0.0f);
            }
            if (!lllllllllllllIIllIllIlIIIIlIlIlI.func_190926_b() && this.rand.nextFloat() < this.itemDropChance) {
                lllllllllllllIIllIllIlIIIIlIlIlI = lllllllllllllIIllIllIlIIIIlIlIlI.copy();
                this.removeFrameFromMap(lllllllllllllIIllIllIlIIIIlIlIlI);
                this.entityDropItem(lllllllllllllIIllIllIlIIIIlIlIlI, 0.0f);
            }
        }
    }
}
