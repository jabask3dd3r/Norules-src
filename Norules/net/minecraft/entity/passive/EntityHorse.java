package net.minecraft.entity.passive;

import java.util.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import javax.annotation.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.block.*;

public class EntityHorse extends AbstractHorse
{
    private static final /* synthetic */ String[] HORSE_TEXTURES_ABBR;
    private static final /* synthetic */ UUID ARMOR_MODIFIER_UUID;
    private static final /* synthetic */ String[] HORSE_MARKING_TEXTURES;
    private static final /* synthetic */ String[] HORSE_TEXTURES;
    private static final /* synthetic */ DataParameter<Integer> HORSE_VARIANT;
    private /* synthetic */ String texturePrefix;
    private final /* synthetic */ String[] horseTexturesArray;
    private static final /* synthetic */ String[] HORSE_MARKING_TEXTURES_ABBR;
    private static final /* synthetic */ DataParameter<Integer> HORSE_ARMOR;
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityHorse.HORSE_VARIANT, 0);
        this.dataManager.register(EntityHorse.HORSE_ARMOR, HorseArmorType.NONE.getOrdinal());
    }
    
    public String[] getVariantTexturePaths() {
        if (this.texturePrefix == null) {
            this.setHorseTexturePaths();
        }
        return this.horseTexturesArray;
    }
    
    public static void registerFixesHorse(final DataFixer lllllllllllllIllIIIllllIlllIlllI) {
        AbstractHorse.func_190683_c(lllllllllllllIllIIIllllIlllIlllI, EntityHorse.class);
        lllllllllllllIllIIIllllIlllIlllI.registerWalker(FixTypes.ENTITY, new ItemStackData(EntityHorse.class, new String[] { "ArmorItem" }));
    }
    
    public HorseArmorType getHorseArmorType() {
        return HorseArmorType.getByOrdinal(this.dataManager.get(EntityHorse.HORSE_ARMOR));
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIllIIIllllIlIIIIlll) {
        super.getHurtSound(lllllllllllllIllIIIllllIlIIIIlll);
        return SoundEvents.ENTITY_HORSE_HURT;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote && this.dataManager.isDirty()) {
            this.dataManager.setClean();
            this.resetTexturePrefix();
        }
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal lllllllllllllIllIIIllllIIllIlIII) {
        return lllllllllllllIllIIIllllIIllIlIII != this && (lllllllllllllIllIIIllllIIllIlIII instanceof EntityDonkey || lllllllllllllIllIIIllllIIllIlIII instanceof EntityHorse) && (this.canMate() && ((AbstractHorse)lllllllllllllIllIIIllllIIllIlIII).canMate());
    }
    
    private void setHorseTexturePaths() {
        final int lllllllllllllIllIIIllllIllIIlIll = this.getHorseVariant();
        final int lllllllllllllIllIIIllllIllIIlIlI = (lllllllllllllIllIIIllllIllIIlIll & 0xFF) % 7;
        final int lllllllllllllIllIIIllllIllIIlIIl = ((lllllllllllllIllIIIllllIllIIlIll & 0xFF00) >> 8) % 5;
        final HorseArmorType lllllllllllllIllIIIllllIllIIlIII = this.getHorseArmorType();
        this.horseTexturesArray[0] = EntityHorse.HORSE_TEXTURES[lllllllllllllIllIIIllllIllIIlIlI];
        this.horseTexturesArray[1] = EntityHorse.HORSE_MARKING_TEXTURES[lllllllllllllIllIIIllllIllIIlIIl];
        this.horseTexturesArray[2] = lllllllllllllIllIIIllllIllIIlIII.getTextureName();
        this.texturePrefix = String.valueOf(new StringBuilder("horse/").append(EntityHorse.HORSE_TEXTURES_ABBR[lllllllllllllIllIIIllllIllIIlIlI]).append(EntityHorse.HORSE_MARKING_TEXTURES_ABBR[lllllllllllllIllIIIllllIllIIlIIl]).append(lllllllllllllIllIIIllllIllIIlIII.getHash()));
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIllIIIllllIIlIIIlIl, @Nullable IEntityLivingData lllllllllllllIllIIIllllIIIllllll) {
        lllllllllllllIllIIIllllIIIllllll = (float)super.onInitialSpawn(lllllllllllllIllIIIllllIIlIIIlIl, (IEntityLivingData)lllllllllllllIllIIIllllIIIllllll);
        int lllllllllllllIllIIIllllIIlIIIIlI = 0;
        if (lllllllllllllIllIIIllllIIIllllll instanceof GroupData) {
            final int lllllllllllllIllIIIllllIIlIIIIll = ((GroupData)lllllllllllllIllIIIllllIIIllllll).field_190885_a;
        }
        else {
            lllllllllllllIllIIIllllIIlIIIIlI = this.rand.nextInt(7);
            lllllllllllllIllIIIllllIIIllllll = (float)new GroupData(lllllllllllllIllIIIllllIIlIIIIlI);
        }
        this.setHorseVariant(lllllllllllllIllIIIllllIIlIIIIlI | this.rand.nextInt(5) << 8);
        return (IEntityLivingData)lllllllllllllIllIIIllllIIIllllll;
    }
    
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_HORSE;
    }
    
    @Override
    protected SoundEvent getAngrySound() {
        super.getAngrySound();
        return SoundEvents.ENTITY_HORSE_ANGRY;
    }
    
    @Override
    public boolean processInteract(final EntityPlayer lllllllllllllIllIIIllllIIllllIlI, final EnumHand lllllllllllllIllIIIllllIIlllIIlI) {
        final ItemStack lllllllllllllIllIIIllllIIllllIII = lllllllllllllIllIIIllllIIllllIlI.getHeldItem(lllllllllllllIllIIIllllIIlllIIlI);
        final boolean lllllllllllllIllIIIllllIIlllIlll = !lllllllllllllIllIIIllllIIllllIII.func_190926_b();
        if (lllllllllllllIllIIIllllIIlllIlll && lllllllllllllIllIIIllllIIllllIII.getItem() == Items.SPAWN_EGG) {
            return super.processInteract(lllllllllllllIllIIIllllIIllllIlI, lllllllllllllIllIIIllllIIlllIIlI);
        }
        if (!this.isChild()) {
            if (this.isTame() && lllllllllllllIllIIIllllIIllllIlI.isSneaking()) {
                this.openGUI(lllllllllllllIllIIIllllIIllllIlI);
                return true;
            }
            if (this.isBeingRidden()) {
                return super.processInteract(lllllllllllllIllIIIllllIIllllIlI, lllllllllllllIllIIIllllIIlllIIlI);
            }
        }
        if (lllllllllllllIllIIIllllIIlllIlll) {
            if (this.func_190678_b(lllllllllllllIllIIIllllIIllllIlI, lllllllllllllIllIIIllllIIllllIII)) {
                if (!lllllllllllllIllIIIllllIIllllIlI.capabilities.isCreativeMode) {
                    lllllllllllllIllIIIllllIIllllIII.func_190918_g(1);
                }
                return true;
            }
            if (lllllllllllllIllIIIllllIIllllIII.interactWithEntity(lllllllllllllIllIIIllllIIllllIlI, this, lllllllllllllIllIIIllllIIlllIIlI)) {
                return true;
            }
            if (!this.isTame()) {
                this.func_190687_dF();
                return true;
            }
            final boolean lllllllllllllIllIIIllllIIlllIllI = HorseArmorType.getByItemStack(lllllllllllllIllIIIllllIIllllIII) != HorseArmorType.NONE;
            final boolean lllllllllllllIllIIIllllIIlllIlIl = !this.isChild() && !this.isHorseSaddled() && lllllllllllllIllIIIllllIIllllIII.getItem() == Items.SADDLE;
            if (lllllllllllllIllIIIllllIIlllIllI || lllllllllllllIllIIIllllIIlllIlIl) {
                this.openGUI(lllllllllllllIllIIIllllIIllllIlI);
                return true;
            }
        }
        if (this.isChild()) {
            return super.processInteract(lllllllllllllIllIIIllllIIllllIlI, lllllllllllllIllIIIllllIIlllIIlI);
        }
        this.mountTo(lllllllllllllIllIIIllllIIllllIlI);
        return true;
    }
    
    public void setHorseVariant(final int lllllllllllllIllIIIllllIllIllIlI) {
        this.dataManager.set(EntityHorse.HORSE_VARIANT, lllllllllllllIllIIIllllIllIllIlI);
        this.resetTexturePrefix();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(this.getModifiedMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(this.getModifiedMovementSpeed());
        this.getEntityAttribute(EntityHorse.JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundEvents.ENTITY_HORSE_AMBIENT;
    }
    
    public EntityHorse(final World lllllllllllllIllIIIllllIllllIIll) {
        super(lllllllllllllIllIIIllllIllllIIll);
        this.horseTexturesArray = new String[3];
    }
    
    public String getHorseTexture() {
        if (this.texturePrefix == null) {
            this.setHorseTexturePaths();
        }
        return this.texturePrefix;
    }
    
    @Override
    protected void updateHorseSlots() {
        super.updateHorseSlots();
        this.setHorseArmorStack(this.horseChest.getStackInSlot(1));
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable lllllllllllllIllIIIllllIIlIlIlIl) {
        AbstractHorse lllllllllllllIllIIIllllIIlIlllIl = null;
        if (lllllllllllllIllIIIllllIIlIlIlIl instanceof EntityDonkey) {
            final AbstractHorse lllllllllllllIllIIIllllIIlIllllI = new EntityMule(this.world);
        }
        else {
            final EntityHorse lllllllllllllIllIIIllllIIlIlllII = (EntityHorse)lllllllllllllIllIIIllllIIlIlIlIl;
            lllllllllllllIllIIIllllIIlIlllIl = new EntityHorse(this.world);
            final int lllllllllllllIllIIIllllIIlIllIll = this.rand.nextInt(9);
            int lllllllllllllIllIIIllllIIlIllIII = 0;
            if (lllllllllllllIllIIIllllIIlIllIll < 4) {
                final int lllllllllllllIllIIIllllIIlIllIlI = this.getHorseVariant() & 0xFF;
            }
            else if (lllllllllllllIllIIIllllIIlIllIll < 8) {
                final int lllllllllllllIllIIIllllIIlIllIIl = lllllllllllllIllIIIllllIIlIlllII.getHorseVariant() & 0xFF;
            }
            else {
                lllllllllllllIllIIIllllIIlIllIII = this.rand.nextInt(7);
            }
            final int lllllllllllllIllIIIllllIIlIlIlll = this.rand.nextInt(5);
            if (lllllllllllllIllIIIllllIIlIlIlll < 2) {
                lllllllllllllIllIIIllllIIlIllIII |= (this.getHorseVariant() & 0xFF00);
            }
            else if (lllllllllllllIllIIIllllIIlIlIlll < 4) {
                lllllllllllllIllIIIllllIIlIllIII |= (lllllllllllllIllIIIllllIIlIlllII.getHorseVariant() & 0xFF00);
            }
            else {
                lllllllllllllIllIIIllllIIlIllIII |= (this.rand.nextInt(5) << 8 & 0xFF00);
            }
            ((EntityHorse)lllllllllllllIllIIIllllIIlIlllIl).setHorseVariant(lllllllllllllIllIIIllllIIlIllIII);
        }
        this.func_190681_a(lllllllllllllIllIIIllllIIlIlIlIl, lllllllllllllIllIIIllllIIlIlllIl);
        return lllllllllllllIllIIIllllIIlIlllIl;
    }
    
    @Override
    public boolean func_190677_dK() {
        return true;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIllIIIllllIlllIlIIl) {
        super.writeEntityToNBT(lllllllllllllIllIIIllllIlllIlIIl);
        lllllllllllllIllIIIllllIlllIlIIl.setInteger("Variant", this.getHorseVariant());
        if (!this.horseChest.getStackInSlot(1).func_190926_b()) {
            lllllllllllllIllIIIllllIlllIlIIl.setTag("ArmorItem", this.horseChest.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
        }
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundEvents.ENTITY_HORSE_DEATH;
    }
    
    @Override
    public boolean func_190682_f(final ItemStack lllllllllllllIllIIIllllIIlIIllII) {
        return HorseArmorType.isHorseArmor(lllllllllllllIllIIIllllIIlIIllII.getItem());
    }
    
    @Override
    public void onInventoryChanged(final IInventory lllllllllllllIllIIIllllIlIlIIlIl) {
        final HorseArmorType lllllllllllllIllIIIllllIlIlIIlII = this.getHorseArmorType();
        super.onInventoryChanged(lllllllllllllIllIIIllllIlIlIIlIl);
        final HorseArmorType lllllllllllllIllIIIllllIlIlIIIll = this.getHorseArmorType();
        if (this.ticksExisted > 20 && lllllllllllllIllIIIllllIlIlIIlII != lllllllllllllIllIIIllllIlIlIIIll && lllllllllllllIllIIIllllIlIlIIIll != HorseArmorType.NONE) {
            this.playSound(SoundEvents.ENTITY_HORSE_ARMOR, 0.5f, 1.0f);
        }
    }
    
    static {
        ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");
        HORSE_VARIANT = EntityDataManager.createKey(EntityHorse.class, DataSerializers.VARINT);
        HORSE_ARMOR = EntityDataManager.createKey(EntityHorse.class, DataSerializers.VARINT);
        HORSE_TEXTURES = new String[] { "textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png" };
        HORSE_TEXTURES_ABBR = new String[] { "hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb" };
        HORSE_MARKING_TEXTURES = new String[] { null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png" };
        HORSE_MARKING_TEXTURES_ABBR = new String[] { "", "wo_", "wmo", "wdo", "bdo" };
    }
    
    public void setHorseArmorStack(final ItemStack lllllllllllllIllIIIllllIlIllIlII) {
        final HorseArmorType lllllllllllllIllIIIllllIlIllIIll = HorseArmorType.getByItemStack(lllllllllllllIllIIIllllIlIllIlII);
        this.dataManager.set(EntityHorse.HORSE_ARMOR, lllllllllllllIllIIIllllIlIllIIll.getOrdinal());
        this.resetTexturePrefix();
        if (!this.world.isRemote) {
            this.getEntityAttribute(SharedMonsterAttributes.ARMOR).removeModifier(EntityHorse.ARMOR_MODIFIER_UUID);
            final int lllllllllllllIllIIIllllIlIllIIlI = lllllllllllllIllIIIllllIlIllIIll.getProtection();
            if (lllllllllllllIllIIIllllIlIllIIlI != 0) {
                this.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(new AttributeModifier(EntityHorse.ARMOR_MODIFIER_UUID, "Horse armor bonus", lllllllllllllIllIIIllllIlIllIIlI, 0).setSaved(false));
            }
        }
    }
    
    private void resetTexturePrefix() {
        this.texturePrefix = null;
    }
    
    public int getHorseVariant() {
        return this.dataManager.get(EntityHorse.HORSE_VARIANT);
    }
    
    @Override
    protected void func_190680_a(final SoundType lllllllllllllIllIIIllllIlIIllIll) {
        super.func_190680_a(lllllllllllllIllIIIllllIlIIllIll);
        if (this.rand.nextInt(10) == 0) {
            this.playSound(SoundEvents.ENTITY_HORSE_BREATHE, lllllllllllllIllIIIllllIlIIllIll.getVolume() * 0.6f, lllllllllllllIllIIIllllIlIIllIll.getPitch());
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIllIIIllllIllIlllll) {
        super.readEntityFromNBT(lllllllllllllIllIIIllllIllIlllll);
        this.setHorseVariant(lllllllllllllIllIIIllllIllIlllll.getInteger("Variant"));
        if (lllllllllllllIllIIIllllIllIlllll.hasKey("ArmorItem", 10)) {
            final ItemStack lllllllllllllIllIIIllllIlllIIIIl = new ItemStack(lllllllllllllIllIIIllllIllIlllll.getCompoundTag("ArmorItem"));
            if (!lllllllllllllIllIIIllllIlllIIIIl.func_190926_b() && HorseArmorType.isHorseArmor(lllllllllllllIllIIIllllIlllIIIIl.getItem())) {
                this.horseChest.setInventorySlotContents(1, lllllllllllllIllIIIllllIlllIIIIl);
            }
        }
        this.updateHorseSlots();
    }
    
    public static class GroupData implements IEntityLivingData
    {
        public /* synthetic */ int field_190885_a;
        
        public GroupData(final int lIIIlllIIlIlIII) {
            this.field_190885_a = lIIIlllIIlIlIII;
        }
    }
}
