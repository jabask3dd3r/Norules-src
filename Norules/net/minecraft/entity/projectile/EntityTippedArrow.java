package net.minecraft.entity.projectile;

import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.*;

public class EntityTippedArrow extends EntityArrow
{
    private /* synthetic */ boolean field_191509_at;
    private final /* synthetic */ Set<PotionEffect> customPotionEffects;
    private static final /* synthetic */ DataParameter<Integer> COLOR;
    private /* synthetic */ PotionType potion;
    
    public EntityTippedArrow(final World llllllllllllllIIIllIIlllIIIlllIl, final EntityLivingBase llllllllllllllIIIllIIlllIIIlllII) {
        super(llllllllllllllIIIllIIlllIIIlllIl, llllllllllllllIIIllIIlllIIIlllII);
        this.potion = PotionTypes.EMPTY;
        this.customPotionEffects = (Set<PotionEffect>)Sets.newHashSet();
    }
    
    public EntityTippedArrow(final World llllllllllllllIIIllIIlllIIlIllIl, final double llllllllllllllIIIllIIlllIIlIllII, final double llllllllllllllIIIllIIlllIIlIlIll, final double llllllllllllllIIIllIIlllIIlIIlIl) {
        super(llllllllllllllIIIllIIlllIIlIllIl, llllllllllllllIIIllIIlllIIlIllII, llllllllllllllIIIllIIlllIIlIlIll, llllllllllllllIIIllIIlllIIlIIlIl);
        this.potion = PotionTypes.EMPTY;
        this.customPotionEffects = (Set<PotionEffect>)Sets.newHashSet();
    }
    
    public EntityTippedArrow(final World llllllllllllllIIIllIIlllIIllIllI) {
        super(llllllllllllllIIIllIIlllIIllIllI);
        this.potion = PotionTypes.EMPTY;
        this.customPotionEffects = (Set<PotionEffect>)Sets.newHashSet();
    }
    
    private void func_191507_d(final int llllllllllllllIIIllIIllIllIlllII) {
        this.field_191509_at = true;
        this.dataManager.set(EntityTippedArrow.COLOR, llllllllllllllIIIllIIllIllIlllII);
    }
    
    @Override
    protected ItemStack getArrowStack() {
        if (this.customPotionEffects.isEmpty() && this.potion == PotionTypes.EMPTY) {
            return new ItemStack(Items.ARROW);
        }
        final ItemStack llllllllllllllIIIllIIllIlIlIllIl = new ItemStack(Items.TIPPED_ARROW);
        PotionUtils.addPotionToItemStack(llllllllllllllIIIllIIllIlIlIllIl, this.potion);
        PotionUtils.appendEffects(llllllllllllllIIIllIIllIlIlIllIl, this.customPotionEffects);
        if (this.field_191509_at) {
            NBTTagCompound llllllllllllllIIIllIIllIlIlIllII = llllllllllllllIIIllIIllIlIlIllIl.getTagCompound();
            if (llllllllllllllIIIllIIllIlIlIllII == null) {
                llllllllllllllIIIllIIllIlIlIllII = new NBTTagCompound();
                llllllllllllllIIIllIIllIlIlIllIl.setTagCompound(llllllllllllllIIIllIIllIlIlIllII);
            }
            llllllllllllllIIIllIIllIlIlIllII.setInteger("CustomPotionColor", this.getColor());
        }
        return llllllllllllllIIIllIIllIlIlIllIl;
    }
    
    public static int func_191508_b(final ItemStack llllllllllllllIIIllIIlllIIIIlIII) {
        final NBTTagCompound llllllllllllllIIIllIIlllIIIIlIIl = llllllllllllllIIIllIIlllIIIIlIII.getTagCompound();
        return (llllllllllllllIIIllIIlllIIIIlIIl != null && llllllllllllllIIIllIIlllIIIIlIIl.hasKey("CustomPotionColor", 99)) ? llllllllllllllIIIllIIlllIIIIlIIl.getInteger("CustomPotionColor") : -1;
    }
    
    @Override
    protected void arrowHit(final EntityLivingBase llllllllllllllIIIllIIllIlIllIlII) {
        super.arrowHit(llllllllllllllIIIllIIllIlIllIlII);
        for (final PotionEffect llllllllllllllIIIllIIllIlIllIlll : this.potion.getEffects()) {
            llllllllllllllIIIllIIllIlIllIlII.addPotionEffect(new PotionEffect(llllllllllllllIIIllIIllIlIllIlll.getPotion(), Math.max(llllllllllllllIIIllIIllIlIllIlll.getDuration() / 8, 1), llllllllllllllIIIllIIllIlIllIlll.getAmplifier(), llllllllllllllIIIllIIllIlIllIlll.getIsAmbient(), llllllllllllllIIIllIIllIlIllIlll.doesShowParticles()));
        }
        if (!this.customPotionEffects.isEmpty()) {
            for (final PotionEffect llllllllllllllIIIllIIllIlIllIllI : this.customPotionEffects) {
                llllllllllllllIIIllIIllIlIllIlII.addPotionEffect(llllllllllllllIIIllIIllIlIllIllI);
            }
        }
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllIIIllIIllIlIlIIIII) {
        if (llllllllllllllIIIllIIllIlIlIIIII == 0) {
            final int llllllllllllllIIIllIIllIlIIlllll = this.getColor();
            if (llllllllllllllIIIllIIllIlIIlllll != -1) {
                final double llllllllllllllIIIllIIllIlIIllllI = (llllllllllllllIIIllIIllIlIIlllll >> 16 & 0xFF) / 255.0;
                final double llllllllllllllIIIllIIllIlIIlllIl = (llllllllllllllIIIllIIllIlIIlllll >> 8 & 0xFF) / 255.0;
                final double llllllllllllllIIIllIIllIlIIlllII = (llllllllllllllIIIllIIllIlIIlllll >> 0 & 0xFF) / 255.0;
                for (int llllllllllllllIIIllIIllIlIIllIll = 0; llllllllllllllIIIllIIllIlIIllIll < 20; ++llllllllllllllIIIllIIllIlIIllIll) {
                    this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, llllllllllllllIIIllIIllIlIIllllI, llllllllllllllIIIllIIllIlIIlllIl, llllllllllllllIIIllIIllIlIIlllII, new int[0]);
                }
            }
        }
        else {
            super.handleStatusUpdate(llllllllllllllIIIllIIllIlIlIIIII);
        }
    }
    
    private void func_190548_o() {
        this.field_191509_at = false;
        this.dataManager.set(EntityTippedArrow.COLOR, PotionUtils.getPotionColorFromEffectList(PotionUtils.mergeEffects(this.potion, this.customPotionEffects)));
    }
    
    public static void registerFixesTippedArrow(final DataFixer llllllllllllllIIIllIIllIllIlIlll) {
        EntityArrow.registerFixesArrow(llllllllllllllIIIllIIllIllIlIlll, "TippedArrow");
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIIllIIllIllIIllII) {
        super.writeEntityToNBT(llllllllllllllIIIllIIllIllIIllII);
        if (this.potion != PotionTypes.EMPTY && this.potion != null) {
            llllllllllllllIIIllIIllIllIIllII.setString("Potion", PotionType.REGISTRY.getNameForObject(this.potion).toString());
        }
        if (this.field_191509_at) {
            llllllllllllllIIIllIIllIllIIllII.setInteger("Color", this.getColor());
        }
        if (!this.customPotionEffects.isEmpty()) {
            final NBTTagList llllllllllllllIIIllIIllIllIIllll = new NBTTagList();
            for (final PotionEffect llllllllllllllIIIllIIllIllIIlllI : this.customPotionEffects) {
                llllllllllllllIIIllIIllIllIIllll.appendTag(llllllllllllllIIIllIIllIllIIlllI.writeCustomPotionEffectToNBT(new NBTTagCompound()));
            }
            llllllllllllllIIIllIIllIllIIllII.setTag("CustomPotionEffects", llllllllllllllIIIllIIllIllIIllll);
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIIllIIllIllIIIIII) {
        super.readEntityFromNBT(llllllllllllllIIIllIIllIllIIIIII);
        if (llllllllllllllIIIllIIllIllIIIIII.hasKey("Potion", 8)) {
            this.potion = PotionUtils.getPotionTypeFromNBT(llllllllllllllIIIllIIllIllIIIIII);
        }
        for (final PotionEffect llllllllllllllIIIllIIllIllIIIIlI : PotionUtils.getFullEffectsFromTag(llllllllllllllIIIllIIllIllIIIIII)) {
            this.addEffect(llllllllllllllIIIllIIllIllIIIIlI);
        }
        if (llllllllllllllIIIllIIllIllIIIIII.hasKey("Color", 99)) {
            this.func_191507_d(llllllllllllllIIIllIIllIllIIIIII.getInteger("Color"));
        }
        else {
            this.func_190548_o();
        }
    }
    
    public int getColor() {
        return this.dataManager.get(EntityTippedArrow.COLOR);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityTippedArrow.COLOR, -1);
    }
    
    private void spawnPotionParticles(final int llllllllllllllIIIllIIllIlllIllll) {
        final int llllllllllllllIIIllIIllIlllIlllI = this.getColor();
        if (llllllllllllllIIIllIIllIlllIlllI != -1 && llllllllllllllIIIllIIllIlllIllll > 0) {
            final double llllllllllllllIIIllIIllIlllIllIl = (llllllllllllllIIIllIIllIlllIlllI >> 16 & 0xFF) / 255.0;
            final double llllllllllllllIIIllIIllIlllIllII = (llllllllllllllIIIllIIllIlllIlllI >> 8 & 0xFF) / 255.0;
            final double llllllllllllllIIIllIIllIlllIlIll = (llllllllllllllIIIllIIllIlllIlllI >> 0 & 0xFF) / 255.0;
            for (int llllllllllllllIIIllIIllIlllIlIlI = 0; llllllllllllllIIIllIIllIlllIlIlI < llllllllllllllIIIllIIllIlllIllll; ++llllllllllllllIIIllIIllIlllIlIlI) {
                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, llllllllllllllIIIllIIllIlllIllIl, llllllllllllllIIIllIIllIlllIllII, llllllllllllllIIIllIIllIlllIlIll, new int[0]);
            }
        }
    }
    
    public void setPotionEffect(final ItemStack llllllllllllllIIIllIIlllIIIlIlIl) {
        if (llllllllllllllIIIllIIlllIIIlIlIl.getItem() == Items.TIPPED_ARROW) {
            this.potion = PotionUtils.getPotionFromItem(llllllllllllllIIIllIIlllIIIlIlIl);
            final Collection<PotionEffect> llllllllllllllIIIllIIlllIIIlIlII = PotionUtils.getFullEffectsFromItem(llllllllllllllIIIllIIlllIIIlIlIl);
            if (!llllllllllllllIIIllIIlllIIIlIlII.isEmpty()) {
                for (final PotionEffect llllllllllllllIIIllIIlllIIIlIIll : llllllllllllllIIIllIIlllIIIlIlII) {
                    this.customPotionEffects.add(new PotionEffect(llllllllllllllIIIllIIlllIIIlIIll));
                }
            }
            final int llllllllllllllIIIllIIlllIIIlIIlI = func_191508_b(llllllllllllllIIIllIIlllIIIlIlIl);
            if (llllllllllllllIIIllIIlllIIIlIIlI == -1) {
                this.func_190548_o();
            }
            else {
                this.func_191507_d(llllllllllllllIIIllIIlllIIIlIIlI);
            }
        }
        else if (llllllllllllllIIIllIIlllIIIlIlIl.getItem() == Items.ARROW) {
            this.potion = PotionTypes.EMPTY;
            this.customPotionEffects.clear();
            this.dataManager.set(EntityTippedArrow.COLOR, -1);
        }
    }
    
    static {
        COLOR = EntityDataManager.createKey(EntityTippedArrow.class, DataSerializers.VARINT);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote) {
            if (this.inGround) {
                if (this.timeInGround % 5 == 0) {
                    this.spawnPotionParticles(1);
                }
            }
            else {
                this.spawnPotionParticles(2);
            }
        }
        else if (this.inGround && this.timeInGround != 0 && !this.customPotionEffects.isEmpty() && this.timeInGround >= 600) {
            this.world.setEntityState(this, (byte)0);
            this.potion = PotionTypes.EMPTY;
            this.customPotionEffects.clear();
            this.dataManager.set(EntityTippedArrow.COLOR, -1);
        }
    }
    
    public void addEffect(final PotionEffect llllllllllllllIIIllIIllIlllllllI) {
        this.customPotionEffects.add(llllllllllllllIIIllIIllIlllllllI);
        this.getDataManager().set(EntityTippedArrow.COLOR, PotionUtils.getPotionColorFromEffectList(PotionUtils.mergeEffects(this.potion, this.customPotionEffects)));
    }
}
