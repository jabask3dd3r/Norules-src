package net.minecraft.potion;

import net.minecraft.entity.*;
import org.apache.logging.log4j.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;

public class PotionEffect implements Comparable<PotionEffect>
{
    private /* synthetic */ boolean isAmbient;
    private /* synthetic */ boolean isSplashPotion;
    private /* synthetic */ int amplifier;
    private /* synthetic */ int duration;
    private /* synthetic */ boolean isPotionDurationMax;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ boolean showParticles;
    private final /* synthetic */ Potion potion;
    
    public boolean onUpdate(final EntityLivingBase lllllllllllllIlIIlllIllllIlIIlIl) {
        if (this.duration > 0) {
            if (this.potion.isReady(this.duration, this.amplifier)) {
                this.performEffect(lllllllllllllIlIIlllIllllIlIIlIl);
            }
            this.deincrementDuration();
        }
        return this.duration > 0;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public Potion getPotion() {
        return this.potion;
    }
    
    public PotionEffect(final Potion lllllllllllllIlIIlllIllllllIllIl) {
        this(lllllllllllllIlIIlllIllllllIllIl, 0, 0);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIIlllIllllIIIlIll) {
        if (this == lllllllllllllIlIIlllIllllIIIlIll) {
            return true;
        }
        if (!(lllllllllllllIlIIlllIllllIIIlIll instanceof PotionEffect)) {
            return false;
        }
        final PotionEffect lllllllllllllIlIIlllIllllIIIlIlI = (PotionEffect)lllllllllllllIlIIlllIllllIIIlIll;
        return this.duration == lllllllllllllIlIIlllIllllIIIlIlI.duration && this.amplifier == lllllllllllllIlIIlllIllllIIIlIlI.amplifier && this.isSplashPotion == lllllllllllllIlIIlllIllllIIIlIlI.isSplashPotion && this.isAmbient == lllllllllllllIlIIlllIllllIIIlIlI.isAmbient && this.potion.equals(lllllllllllllIlIIlllIllllIIIlIlI.potion);
    }
    
    public boolean doesShowParticles() {
        return this.showParticles;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public String getEffectName() {
        return this.potion.getName();
    }
    
    public int getAmplifier() {
        return this.amplifier;
    }
    
    public PotionEffect(final Potion lllllllllllllIlIIlllIlllllIlllII, final int lllllllllllllIlIIlllIlllllIllIll, final int lllllllllllllIlIIlllIlllllIllIlI) {
        this(lllllllllllllIlIIlllIlllllIlllII, lllllllllllllIlIIlllIlllllIllIll, lllllllllllllIlIIlllIlllllIllIlI, false, true);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlIIlllIllllIIIIIll = this.potion.hashCode();
        lllllllllllllIlIIlllIllllIIIIIll = 31 * lllllllllllllIlIIlllIllllIIIIIll + this.duration;
        lllllllllllllIlIIlllIllllIIIIIll = 31 * lllllllllllllIlIIlllIllllIIIIIll + this.amplifier;
        lllllllllllllIlIIlllIllllIIIIIll = 31 * lllllllllllllIlIIlllIllllIIIIIll + (this.isSplashPotion ? 1 : 0);
        lllllllllllllIlIIlllIllllIIIIIll = 31 * lllllllllllllIlIIlllIllllIIIIIll + (this.isAmbient ? 1 : 0);
        return lllllllllllllIlIIlllIllllIIIIIll;
    }
    
    public NBTTagCompound writeCustomPotionEffectToNBT(final NBTTagCompound lllllllllllllIlIIlllIlllIlllllIl) {
        lllllllllllllIlIIlllIlllIlllllIl.setByte("Id", (byte)Potion.getIdFromPotion(this.getPotion()));
        lllllllllllllIlIIlllIlllIlllllIl.setByte("Amplifier", (byte)this.getAmplifier());
        lllllllllllllIlIIlllIlllIlllllIl.setInteger("Duration", this.getDuration());
        lllllllllllllIlIIlllIlllIlllllIl.setBoolean("Ambient", this.getIsAmbient());
        lllllllllllllIlIIlllIlllIlllllIl.setBoolean("ShowParticles", this.doesShowParticles());
        return lllllllllllllIlIIlllIlllIlllllIl;
    }
    
    public PotionEffect(final Potion lllllllllllllIlIIlllIlllllIIlllI, final int lllllllllllllIlIIlllIlllllIIllIl, final int lllllllllllllIlIIlllIlllllIIIllI, final boolean lllllllllllllIlIIlllIlllllIIlIll, final boolean lllllllllllllIlIIlllIlllllIIIlII) {
        this.potion = lllllllllllllIlIIlllIlllllIIlllI;
        this.duration = lllllllllllllIlIIlllIlllllIIllIl;
        this.amplifier = lllllllllllllIlIIlllIlllllIIIllI;
        this.isAmbient = lllllllllllllIlIIlllIlllllIIlIll;
        this.showParticles = lllllllllllllIlIIlllIlllllIIIlII;
    }
    
    public void setPotionDurationMax(final boolean lllllllllllllIlIIlllIlllIllIIIII) {
        this.isPotionDurationMax = lllllllllllllIlIIlllIlllIllIIIII;
    }
    
    @Override
    public String toString() {
        String lllllllllllllIlIIlllIllllIIlIIlI = null;
        if (this.amplifier > 0) {
            final String lllllllllllllIlIIlllIllllIIlIIll = String.valueOf(new StringBuilder(String.valueOf(this.getEffectName())).append(" x ").append(this.amplifier + 1).append(", Duration: ").append(this.duration));
        }
        else {
            lllllllllllllIlIIlllIllllIIlIIlI = String.valueOf(new StringBuilder(String.valueOf(this.getEffectName())).append(", Duration: ").append(this.duration));
        }
        if (this.isSplashPotion) {
            lllllllllllllIlIIlllIllllIIlIIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIlllIllllIIlIIlI)).append(", Splash: true"));
        }
        if (!this.showParticles) {
            lllllllllllllIlIIlllIllllIIlIIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIlllIllllIIlIIlI)).append(", Particles: false"));
        }
        return lllllllllllllIlIIlllIllllIIlIIlI;
    }
    
    public boolean getIsAmbient() {
        return this.isAmbient;
    }
    
    public void combine(final PotionEffect lllllllllllllIlIIlllIllllIlllIlI) {
        if (this.potion != lllllllllllllIlIIlllIllllIlllIlI.potion) {
            PotionEffect.LOGGER.warn("This method should only be called for matching effects!");
        }
        if (lllllllllllllIlIIlllIllllIlllIlI.amplifier > this.amplifier) {
            this.amplifier = lllllllllllllIlIIlllIllllIlllIlI.amplifier;
            this.duration = lllllllllllllIlIIlllIllllIlllIlI.duration;
        }
        else if (lllllllllllllIlIIlllIllllIlllIlI.amplifier == this.amplifier && this.duration < lllllllllllllIlIIlllIllllIlllIlI.duration) {
            this.duration = lllllllllllllIlIIlllIllllIlllIlI.duration;
        }
        else if (!lllllllllllllIlIIlllIllllIlllIlI.isAmbient && this.isAmbient) {
            this.isAmbient = lllllllllllllIlIIlllIllllIlllIlI.isAmbient;
        }
        this.showParticles = lllllllllllllIlIIlllIllllIlllIlI.showParticles;
    }
    
    public boolean getIsPotionDurationMax() {
        return this.isPotionDurationMax;
    }
    
    public PotionEffect(final Potion lllllllllllllIlIIlllIllllllIIllI, final int lllllllllllllIlIIlllIllllllIIIlI) {
        this(lllllllllllllIlIIlllIllllllIIllI, lllllllllllllIlIIlllIllllllIIIlI, 0);
    }
    
    public void performEffect(final EntityLivingBase lllllllllllllIlIIlllIllllIIlllII) {
        if (this.duration > 0) {
            this.potion.performEffect(lllllllllllllIlIIlllIllllIIlllII, this.amplifier);
        }
    }
    
    public static PotionEffect readCustomPotionEffectFromNBT(final NBTTagCompound lllllllllllllIlIIlllIlllIllIllII) {
        final int lllllllllllllIlIIlllIlllIlllIIlI = lllllllllllllIlIIlllIlllIllIllII.getByte("Id");
        final Potion lllllllllllllIlIIlllIlllIlllIIIl = Potion.getPotionById(lllllllllllllIlIIlllIlllIlllIIlI);
        if (lllllllllllllIlIIlllIlllIlllIIIl == null) {
            return null;
        }
        final int lllllllllllllIlIIlllIlllIlllIIII = lllllllllllllIlIIlllIlllIllIllII.getByte("Amplifier");
        final int lllllllllllllIlIIlllIlllIllIllll = lllllllllllllIlIIlllIlllIllIllII.getInteger("Duration");
        final boolean lllllllllllllIlIIlllIlllIllIlllI = lllllllllllllIlIIlllIlllIllIllII.getBoolean("Ambient");
        boolean lllllllllllllIlIIlllIlllIllIllIl = true;
        if (lllllllllllllIlIIlllIlllIllIllII.hasKey("ShowParticles", 1)) {
            lllllllllllllIlIIlllIlllIllIllIl = lllllllllllllIlIIlllIlllIllIllII.getBoolean("ShowParticles");
        }
        return new PotionEffect(lllllllllllllIlIIlllIlllIlllIIIl, lllllllllllllIlIIlllIlllIllIllll, (lllllllllllllIlIIlllIlllIlllIIII < 0) ? 0 : lllllllllllllIlIIlllIlllIlllIIII, lllllllllllllIlIIlllIlllIllIlllI, lllllllllllllIlIIlllIlllIllIllIl);
    }
    
    private int deincrementDuration() {
        final int duration = this.duration - 1;
        this.duration = duration;
        return duration;
    }
    
    public PotionEffect(final PotionEffect lllllllllllllIlIIlllIlllllIIIIII) {
        this.potion = lllllllllllllIlIIlllIlllllIIIIII.potion;
        this.duration = lllllllllllllIlIIlllIlllllIIIIII.duration;
        this.amplifier = lllllllllllllIlIIlllIlllllIIIIII.amplifier;
        this.isAmbient = lllllllllllllIlIIlllIlllllIIIIII.isAmbient;
        this.showParticles = lllllllllllllIlIIlllIlllllIIIIII.showParticles;
    }
    
    @Override
    public int compareTo(final PotionEffect lllllllllllllIlIIlllIlllIlIlIlIl) {
        final int lllllllllllllIlIIlllIlllIlIlIlll = 32147;
        return ((this.getDuration() <= 32147 || lllllllllllllIlIIlllIlllIlIlIlIl.getDuration() <= 32147) && (!this.getIsAmbient() || !lllllllllllllIlIIlllIlllIlIlIlIl.getIsAmbient())) ? ComparisonChain.start().compare(Boolean.valueOf(this.getIsAmbient()), Boolean.valueOf(lllllllllllllIlIIlllIlllIlIlIlIl.getIsAmbient())).compare(this.getDuration(), lllllllllllllIlIIlllIlllIlIlIlIl.getDuration()).compare(this.getPotion().getLiquidColor(), lllllllllllllIlIIlllIlllIlIlIlIl.getPotion().getLiquidColor()).result() : ComparisonChain.start().compare(Boolean.valueOf(this.getIsAmbient()), Boolean.valueOf(lllllllllllllIlIIlllIlllIlIlIlIl.getIsAmbient())).compare(this.getPotion().getLiquidColor(), lllllllllllllIlIIlllIlllIlIlIlIl.getPotion().getLiquidColor()).result();
    }
}
