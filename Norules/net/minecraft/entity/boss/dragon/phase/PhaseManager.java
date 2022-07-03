package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.entity.boss.*;
import org.apache.logging.log4j.*;

public class PhaseManager
{
    private final /* synthetic */ IPhase[] phases;
    private /* synthetic */ IPhase phase;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ EntityDragon dragon;
    
    public PhaseManager(final EntityDragon llllllllllllllllIllIlIIlIIIllIIl) {
        this.phases = new IPhase[PhaseList.getTotalPhases()];
        this.dragon = llllllllllllllllIllIlIIlIIIllIIl;
        this.setPhase(PhaseList.HOVER);
    }
    
    public <T extends IPhase> T getPhase(final PhaseList<T> llllllllllllllllIllIlIIlIIIIlIIl) {
        final int llllllllllllllllIllIlIIlIIIIlIII = llllllllllllllllIllIlIIlIIIIlIIl.getId();
        if (this.phases[llllllllllllllllIllIlIIlIIIIlIII] == null) {
            this.phases[llllllllllllllllIllIlIIlIIIIlIII] = llllllllllllllllIllIlIIlIIIIlIIl.createPhase(this.dragon);
        }
        return (T)this.phases[llllllllllllllllIllIlIIlIIIIlIII];
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public IPhase getCurrentPhase() {
        return this.phase;
    }
    
    public void setPhase(final PhaseList<?> llllllllllllllllIllIlIIlIIIlIIll) {
        if (this.phase == null || llllllllllllllllIllIlIIlIIIlIIll != this.phase.getPhaseList()) {
            if (this.phase != null) {
                this.phase.removeAreaEffect();
            }
            this.phase = this.getPhase(llllllllllllllllIllIlIIlIIIlIIll);
            if (!this.dragon.world.isRemote) {
                this.dragon.getDataManager().set(EntityDragon.PHASE, llllllllllllllllIllIlIIlIIIlIIll.getId());
            }
            PhaseManager.LOGGER.debug("Dragon is now in phase {} on the {}", (Object)llllllllllllllllIllIlIIlIIIlIIll, (Object)(this.dragon.world.isRemote ? "client" : "server"));
            this.phase.initPhase();
        }
    }
}
