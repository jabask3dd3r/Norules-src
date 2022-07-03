package net.minecraft.entity.passive;

import java.util.*;
import net.minecraft.util.datafix.*;
import net.minecraft.item.crafting.*;
import javax.annotation.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public class EntitySheep extends EntityAnimal
{
    private static final /* synthetic */ DataParameter<Byte> DYE_COLOR;
    private /* synthetic */ int sheepTimer;
    private final /* synthetic */ InventoryCrafting inventoryCrafting;
    private static final /* synthetic */ Map<EnumDyeColor, float[]> DYE_TO_RGB;
    private /* synthetic */ EntityAIEatGrass entityAIEatGrass;
    
    public static EnumDyeColor getRandomSheepColor(final Random llllllllllllllIIllllllllIllIIIIl) {
        final int llllllllllllllIIllllllllIllIIIII = llllllllllllllIIllllllllIllIIIIl.nextInt(100);
        if (llllllllllllllIIllllllllIllIIIII < 5) {
            return EnumDyeColor.BLACK;
        }
        if (llllllllllllllIIllllllllIllIIIII < 10) {
            return EnumDyeColor.GRAY;
        }
        if (llllllllllllllIIllllllllIllIIIII < 15) {
            return EnumDyeColor.SILVER;
        }
        if (llllllllllllllIIllllllllIllIIIII < 18) {
            return EnumDyeColor.BROWN;
        }
        return (llllllllllllllIIllllllllIllIIIIl.nextInt(500) == 0) ? EnumDyeColor.PINK : EnumDyeColor.WHITE;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntitySheep.DYE_COLOR, (Byte)0);
    }
    
    public static void registerFixesSheep(final DataFixer llllllllllllllIIlllllllllIIlIIIl) {
        EntityLiving.registerFixesMob(llllllllllllllIIlllllllllIIlIIIl, EntitySheep.class);
    }
    
    public void setSheared(final boolean llllllllllllllIIllllllllIllIlIII) {
        final byte llllllllllllllIIllllllllIllIIlll = this.dataManager.get(EntitySheep.DYE_COLOR);
        if (llllllllllllllIIllllllllIllIlIII) {
            this.dataManager.set(EntitySheep.DYE_COLOR, (byte)(llllllllllllllIIllllllllIllIIlll | 0x10));
        }
        else {
            this.dataManager.set(EntitySheep.DYE_COLOR, (byte)(llllllllllllllIIllllllllIllIIlll & 0xFFFFFFEF));
        }
    }
    
    @Override
    public EntitySheep createChild(final EntityAgeable llllllllllllllIIllllllllIlIlIlII) {
        final EntitySheep llllllllllllllIIllllllllIlIlIlll = (EntitySheep)llllllllllllllIIllllllllIlIlIlII;
        final EntitySheep llllllllllllllIIllllllllIlIlIllI = new EntitySheep(this.world);
        llllllllllllllIIllllllllIlIlIllI.setFleeceColor(this.getDyeColorMixFromParents(this, llllllllllllllIIllllllllIlIlIlll));
        return llllllllllllllIIllllllllIlIlIllI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$EnumDyeColor() {
        final int[] $switch_TABLE$net$minecraft$item$EnumDyeColor = EntitySheep.$SWITCH_TABLE$net$minecraft$item$EnumDyeColor;
        if ($switch_TABLE$net$minecraft$item$EnumDyeColor != null) {
            return $switch_TABLE$net$minecraft$item$EnumDyeColor;
        }
        final byte llllllllllllllIIllllllllIIlIIlll = (Object)new int[EnumDyeColor.values().length];
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.BLACK.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.BLUE.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.BROWN.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.CYAN.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.GRAY.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.GREEN.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.LIGHT_BLUE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.LIME.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.MAGENTA.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.ORANGE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.PINK.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.PURPLE.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.RED.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.SILVER.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.WHITE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            llllllllllllllIIllllllllIIlIIlll[EnumDyeColor.YELLOW.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        return EntitySheep.$SWITCH_TABLE$net$minecraft$item$EnumDyeColor = (int[])(Object)llllllllllllllIIllllllllIIlIIlll;
    }
    
    public static float[] getDyeRgb(final EnumDyeColor llllllllllllllIIllllllllllIlIlll) {
        return EntitySheep.DYE_TO_RGB.get(llllllllllllllIIllllllllllIlIlll);
    }
    
    public float getHeadRotationPointY(final float llllllllllllllIIlllllllllIllIlII) {
        if (this.sheepTimer <= 0) {
            return 0.0f;
        }
        if (this.sheepTimer >= 4 && this.sheepTimer <= 36) {
            return 1.0f;
        }
        return (this.sheepTimer < 4) ? ((this.sheepTimer - llllllllllllllIIlllllllllIllIlII) / 4.0f) : (-(this.sheepTimer - 40 - llllllllllllllIIlllllllllIllIlII) / 4.0f);
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.world.isRemote) {
            this.sheepTimer = Math.max(0, this.sheepTimer - 1);
        }
        super.onLivingUpdate();
    }
    
    private EnumDyeColor getDyeColorMixFromParents(final EntityAnimal llllllllllllllIIllllllllIIllllIl, final EntityAnimal llllllllllllllIIllllllllIIllllII) {
        final int llllllllllllllIIllllllllIIlllIll = ((EntitySheep)llllllllllllllIIllllllllIIllllIl).getFleeceColor().getDyeDamage();
        final int llllllllllllllIIllllllllIIlllIlI = ((EntitySheep)llllllllllllllIIllllllllIIllllII).getFleeceColor().getDyeDamage();
        this.inventoryCrafting.getStackInSlot(0).setItemDamage(llllllllllllllIIllllllllIIlllIll);
        this.inventoryCrafting.getStackInSlot(1).setItemDamage(llllllllllllllIIllllllllIIlllIlI);
        final ItemStack llllllllllllllIIllllllllIIlllIIl = CraftingManager.findMatchingRecipe(this.inventoryCrafting, ((EntitySheep)llllllllllllllIIllllllllIIllllIl).world);
        int llllllllllllllIIllllllllIIllIlll = 0;
        if (llllllllllllllIIllllllllIIlllIIl.getItem() == Items.DYE) {
            final int llllllllllllllIIllllllllIIlllIII = llllllllllllllIIllllllllIIlllIIl.getMetadata();
        }
        else {
            llllllllllllllIIllllllllIIllIlll = (this.world.rand.nextBoolean() ? llllllllllllllIIllllllllIIlllIll : llllllllllllllIIllllllllIIlllIlI);
        }
        return EnumDyeColor.byDyeDamage(llllllllllllllIIllllllllIIllIlll);
    }
    
    @Override
    protected void updateAITasks() {
        this.sheepTimer = this.entityAIEatGrass.getEatingGrassTimer();
        super.updateAITasks();
    }
    
    public boolean getSheared() {
        return (this.dataManager.get(EntitySheep.DYE_COLOR) & 0x10) != 0x0;
    }
    
    public EnumDyeColor getFleeceColor() {
        return EnumDyeColor.byMetadata(this.dataManager.get(EntitySheep.DYE_COLOR) & 0xF);
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance llllllllllllllIIllllllllIlIIlIlI, @Nullable IEntityLivingData llllllllllllllIIllllllllIlIIIllI) {
        llllllllllllllIIllllllllIlIIIllI = (char)super.onInitialSpawn(llllllllllllllIIllllllllIlIIlIlI, (IEntityLivingData)llllllllllllllIIllllllllIlIIIllI);
        this.setFleeceColor(getRandomSheepColor(this.world.rand));
        return (IEntityLivingData)llllllllllllllIIllllllllIlIIIllI;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        if (this.getSheared()) {
            return LootTableList.ENTITIES_SHEEP;
        }
        switch ($SWITCH_TABLE$net$minecraft$item$EnumDyeColor()[this.getFleeceColor().ordinal()]) {
            default: {
                return LootTableList.ENTITIES_SHEEP_WHITE;
            }
            case 2: {
                return LootTableList.ENTITIES_SHEEP_ORANGE;
            }
            case 3: {
                return LootTableList.ENTITIES_SHEEP_MAGENTA;
            }
            case 4: {
                return LootTableList.ENTITIES_SHEEP_LIGHT_BLUE;
            }
            case 5: {
                return LootTableList.ENTITIES_SHEEP_YELLOW;
            }
            case 6: {
                return LootTableList.ENTITIES_SHEEP_LIME;
            }
            case 7: {
                return LootTableList.ENTITIES_SHEEP_PINK;
            }
            case 8: {
                return LootTableList.ENTITIES_SHEEP_GRAY;
            }
            case 9: {
                return LootTableList.ENTITIES_SHEEP_SILVER;
            }
            case 10: {
                return LootTableList.ENTITIES_SHEEP_CYAN;
            }
            case 11: {
                return LootTableList.ENTITIES_SHEEP_PURPLE;
            }
            case 12: {
                return LootTableList.ENTITIES_SHEEP_BLUE;
            }
            case 13: {
                return LootTableList.ENTITIES_SHEEP_BROWN;
            }
            case 14: {
                return LootTableList.ENTITIES_SHEEP_GREEN;
            }
            case 15: {
                return LootTableList.ENTITIES_SHEEP_RED;
            }
            case 16: {
                return LootTableList.ENTITIES_SHEEP_BLACK;
            }
        }
    }
    
    public void setFleeceColor(final EnumDyeColor llllllllllllllIIllllllllIlllIlII) {
        final byte llllllllllllllIIllllllllIlllIIll = this.dataManager.get(EntitySheep.DYE_COLOR);
        this.dataManager.set(EntitySheep.DYE_COLOR, (byte)((llllllllllllllIIllllllllIlllIIll & 0xF0) | (llllllllllllllIIllllllllIlllIlII.getMetadata() & 0xF)));
    }
    
    @Override
    protected void initEntityAI() {
        this.entityAIEatGrass = new EntityAIEatGrass(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0));
        this.tasks.addTask(3, new EntityAITempt(this, 1.1, Items.WHEAT, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1));
        this.tasks.addTask(5, this.entityAIEatGrass);
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SHEEP_DEATH;
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllllIIllllllllIllllllI, final Block llllllllllllllIIllllllllIlllllIl) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15f, 1.0f);
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllIIlllllllllIlllIlI) {
        if (llllllllllllllIIlllllllllIlllIlI == 10) {
            this.sheepTimer = 40;
        }
        else {
            super.handleStatusUpdate(llllllllllllllIIlllllllllIlllIlI);
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513);
    }
    
    @Override
    public void eatGrassBonus() {
        this.setSheared(false);
        if (this.isChild()) {
            this.addGrowth(60);
        }
    }
    
    @Override
    public float getEyeHeight() {
        return 0.95f * this.height;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlllllllllIIIllIl) {
        super.writeEntityToNBT(llllllllllllllIIlllllllllIIIllIl);
        llllllllllllllIIlllllllllIIIllIl.setBoolean("Sheared", this.getSheared());
        llllllllllllllIIlllllllllIIIllIl.setByte("Color", (byte)this.getFleeceColor().getMetadata());
    }
    
    static {
        DYE_COLOR = EntityDataManager.createKey(EntitySheep.class, DataSerializers.BYTE);
        DYE_TO_RGB = Maps.newEnumMap((Class)EnumDyeColor.class);
        char llllllllllllllIIlllllllllllIIIlI;
        for (Exception llllllllllllllIIlllllllllllIIIll = (Exception)((EnumDyeColor[])(Object)(llllllllllllllIIlllllllllllIIIlI = (char)(Object)EnumDyeColor.values())).length, llllllllllllllIIlllllllllllIIlII = (Exception)0; llllllllllllllIIlllllllllllIIlII < llllllllllllllIIlllllllllllIIIll; ++llllllllllllllIIlllllllllllIIlII) {
            final EnumDyeColor llllllllllllllIIlllllllllllIIllI = llllllllllllllIIlllllllllllIIIlI[llllllllllllllIIlllllllllllIIlII];
            EntitySheep.DYE_TO_RGB.put(llllllllllllllIIlllllllllllIIllI, func_192020_c(llllllllllllllIIlllllllllllIIllI));
        }
        EntitySheep.DYE_TO_RGB.put(EnumDyeColor.WHITE, new float[] { 0.9019608f, 0.9019608f, 0.9019608f });
    }
    
    public EntitySheep(final World llllllllllllllIIllllllllllIlIIII) {
        super(llllllllllllllIIllllllllllIlIIII);
        this.inventoryCrafting = new InventoryCrafting(new Container() {
            @Override
            public boolean canInteractWith(final EntityPlayer llllllllllllllIlIIlIllIllIIIIlll) {
                return false;
            }
        }, 2, 1);
        this.setSize(0.9f, 1.3f);
        this.inventoryCrafting.setInventorySlotContents(0, new ItemStack(Items.DYE));
        this.inventoryCrafting.setInventorySlotContents(1, new ItemStack(Items.DYE));
    }
    
    @Override
    public boolean processInteract(final EntityPlayer llllllllllllllIIlllllllllIIllIIl, final EnumHand llllllllllllllIIlllllllllIIlllll) {
        final ItemStack llllllllllllllIIlllllllllIIllllI = llllllllllllllIIlllllllllIIllIIl.getHeldItem(llllllllllllllIIlllllllllIIlllll);
        if (llllllllllllllIIlllllllllIIllllI.getItem() == Items.SHEARS && !this.getSheared() && !this.isChild()) {
            if (!this.world.isRemote) {
                this.setSheared(true);
                for (int llllllllllllllIIlllllllllIIlllIl = 1 + this.rand.nextInt(3), llllllllllllllIIlllllllllIIlllII = 0; llllllllllllllIIlllllllllIIlllII < llllllllllllllIIlllllllllIIlllIl; ++llllllllllllllIIlllllllllIIlllII) {
                    final EntityItem entityDropItem;
                    final EntityItem llllllllllllllIIlllllllllIIllIll = entityDropItem = this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, this.getFleeceColor().getMetadata()), 1.0f);
                    entityDropItem.motionY += this.rand.nextFloat() * 0.05f;
                    final EntityItem entityItem = llllllllllllllIIlllllllllIIllIll;
                    entityItem.motionX += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f;
                    final EntityItem entityItem2 = llllllllllllllIIlllllllllIIllIll;
                    entityItem2.motionZ += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f;
                }
            }
            llllllllllllllIIlllllllllIIllllI.damageItem(1, llllllllllllllIIlllllllllIIllIIl);
            this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0f, 1.0f);
        }
        return super.processInteract(llllllllllllllIIlllllllllIIllIIl, llllllllllllllIIlllllllllIIlllll);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIIlllllllllIIIIIlI) {
        return SoundEvents.ENTITY_SHEEP_HURT;
    }
    
    private static float[] func_192020_c(final EnumDyeColor llllllllllllllIIllllllllllIllIll) {
        final float[] llllllllllllllIIllllllllllIlllIl = llllllllllllllIIllllllllllIllIll.func_193349_f();
        final float llllllllllllllIIllllllllllIlllII = 0.75f;
        return new float[] { llllllllllllllIIllllllllllIlllIl[0] * 0.75f, llllllllllllllIIllllllllllIlllIl[1] * 0.75f, llllllllllllllIIllllllllllIlllIl[2] * 0.75f };
    }
    
    public float getHeadRotationAngleX(final float llllllllllllllIIlllllllllIlIllIl) {
        if (this.sheepTimer > 4 && this.sheepTimer <= 36) {
            final float llllllllllllllIIlllllllllIlIllII = (this.sheepTimer - 4 - llllllllllllllIIlllllllllIlIllIl) / 32.0f;
            return 0.62831855f + 0.2199115f * MathHelper.sin(llllllllllllllIIlllllllllIlIllII * 28.7f);
        }
        return (this.sheepTimer > 0) ? 0.62831855f : (this.rotationPitch * 0.017453292f);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SHEEP_AMBIENT;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlllllllllIIIIlll) {
        super.readEntityFromNBT(llllllllllllllIIlllllllllIIIIlll);
        this.setSheared(llllllllllllllIIlllllllllIIIIlll.getBoolean("Sheared"));
        this.setFleeceColor(EnumDyeColor.byMetadata(llllllllllllllIIlllllllllIIIIlll.getByte("Color")));
    }
}
