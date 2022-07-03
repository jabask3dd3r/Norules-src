package net.minecraft.entity.projectile;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;

public class EntitySpectralArrow extends EntityArrow
{
    private /* synthetic */ int duration;
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIIIlllIIlIIIIIlII) {
        super.writeEntityToNBT(llllllllllllllIIIIlllIIlIIIIIlII);
        llllllllllllllIIIIlllIIlIIIIIlII.setInteger("Duration", this.duration);
    }
    
    public EntitySpectralArrow(final World llllllllllllllIIIIlllIIlIIlIIIIl, final double llllllllllllllIIIIlllIIlIIlIIlIl, final double llllllllllllllIIIIlllIIlIIlIIlII, final double llllllllllllllIIIIlllIIlIIIllllI) {
        super(llllllllllllllIIIIlllIIlIIlIIIIl, llllllllllllllIIIIlllIIlIIlIIlIl, llllllllllllllIIIIlllIIlIIlIIlII, llllllllllllllIIIIlllIIlIIIllllI);
        this.duration = 200;
    }
    
    public EntitySpectralArrow(final World llllllllllllllIIIIlllIIlIIlllIII) {
        super(llllllllllllllIIIIlllIIlIIlllIII);
        this.duration = 200;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote && !this.inGround) {
            this.world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIIIlllIIlIIIIlIII) {
        super.readEntityFromNBT(llllllllllllllIIIIlllIIlIIIIlIII);
        if (llllllllllllllIIIIlllIIlIIIIlIII.hasKey("Duration")) {
            this.duration = llllllllllllllIIIIlllIIlIIIIlIII.getInteger("Duration");
        }
    }
    
    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(Items.SPECTRAL_ARROW);
    }
    
    public EntitySpectralArrow(final World llllllllllllllIIIIlllIIlIIlIlllI, final EntityLivingBase llllllllllllllIIIIlllIIlIIllIIII) {
        super(llllllllllllllIIIIlllIIlIIlIlllI, llllllllllllllIIIIlllIIlIIllIIII);
        this.duration = 200;
    }
    
    public static void registerFixesSpectralArrow(final DataFixer llllllllllllllIIIIlllIIlIIIIlllI) {
        EntityArrow.registerFixesArrow(llllllllllllllIIIIlllIIlIIIIlllI, "SpectralArrow");
    }
    
    @Override
    protected void arrowHit(final EntityLivingBase llllllllllllllIIIIlllIIlIIIlIlIl) {
        super.arrowHit(llllllllllllllIIIIlllIIlIIIlIlIl);
        final PotionEffect llllllllllllllIIIIlllIIlIIIlIlII = new PotionEffect(MobEffects.GLOWING, this.duration, 0);
        llllllllllllllIIIIlllIIlIIIlIlIl.addPotionEffect(llllllllllllllIIIIlllIIlIIIlIlII);
    }
}
