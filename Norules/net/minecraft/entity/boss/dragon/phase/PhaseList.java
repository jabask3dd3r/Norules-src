package net.minecraft.entity.boss.dragon.phase;

import java.lang.reflect.*;
import net.minecraft.entity.boss.*;
import java.util.*;

public class PhaseList<T extends IPhase>
{
    private final /* synthetic */ Class<? extends IPhase> clazz;
    private final /* synthetic */ String name;
    private static /* synthetic */ PhaseList<?>[] phases;
    private final /* synthetic */ int id;
    public static final /* synthetic */ PhaseList<PhaseHoldingPattern> HOLDING_PATTERN;
    
    protected Constructor<? extends IPhase> getConstructor() throws NoSuchMethodException {
        return this.clazz.getConstructor(EntityDragon.class);
    }
    
    static {
        PhaseList.phases = (PhaseList<?>[])new PhaseList[0];
        HOLDING_PATTERN = create(PhaseHoldingPattern.class, "HoldingPattern");
        STRAFE_PLAYER = create(PhaseStrafePlayer.class, "StrafePlayer");
        LANDING_APPROACH = create(PhaseLandingApproach.class, "LandingApproach");
        LANDING = create(PhaseLanding.class, "Landing");
        TAKEOFF = create(PhaseTakeoff.class, "Takeoff");
        SITTING_FLAMING = create(PhaseSittingFlaming.class, "SittingFlaming");
        SITTING_SCANNING = create(PhaseSittingScanning.class, "SittingScanning");
        SITTING_ATTACKING = create(PhaseSittingAttacking.class, "SittingAttacking");
        CHARGING_PLAYER = create(PhaseChargingPlayer.class, "ChargingPlayer");
        DYING = create(PhaseDying.class, "Dying");
        HOVER = create(PhaseHover.class, "Hover");
    }
    
    public int getId() {
        return this.id;
    }
    
    public static PhaseList<?> getById(final int lllllllllllllIIIlllIllIIIIlIllII) {
        return (lllllllllllllIIIlllIllIIIIlIllII >= 0 && lllllllllllllIIIlllIllIIIIlIllII < PhaseList.phases.length) ? PhaseList.phases[lllllllllllllIIIlllIllIIIIlIllII] : PhaseList.HOLDING_PATTERN;
    }
    
    private PhaseList(final int lllllllllllllIIIlllIllIIIlIIIIll, final Class<? extends IPhase> lllllllllllllIIIlllIllIIIlIIIIlI, final String lllllllllllllIIIlllIllIIIlIIIIIl) {
        this.id = lllllllllllllIIIlllIllIIIlIIIIll;
        this.clazz = lllllllllllllIIIlllIllIIIlIIIIlI;
        this.name = lllllllllllllIIIlllIllIIIlIIIIIl;
    }
    
    public IPhase createPhase(final EntityDragon lllllllllllllIIIlllIllIIIIllllII) {
        try {
            final Constructor<? extends IPhase> lllllllllllllIIIlllIllIIIIlllIll = this.getConstructor();
            return (IPhase)lllllllllllllIIIlllIllIIIIlllIll.newInstance(lllllllllllllIIIlllIllIIIIllllII);
        }
        catch (Exception lllllllllllllIIIlllIllIIIIlllIlI) {
            throw new Error(lllllllllllllIIIlllIllIIIIlllIlI);
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.name)).append(" (#").append(this.id).append(")"));
    }
    
    private static <T extends IPhase> PhaseList<T> create(final Class<T> lllllllllllllIIIlllIllIIIIlIIlII, final String lllllllllllllIIIlllIllIIIIlIIIll) {
        final PhaseList<T> lllllllllllllIIIlllIllIIIIlIIlIl = new PhaseList<T>(PhaseList.phases.length, lllllllllllllIIIlllIllIIIIlIIlII, lllllllllllllIIIlllIllIIIIlIIIll);
        PhaseList.phases = Arrays.copyOf(PhaseList.phases, PhaseList.phases.length + 1);
        return (PhaseList<T>)(PhaseList.phases[lllllllllllllIIIlllIllIIIIlIIlIl.getId()] = lllllllllllllIIIlllIllIIIIlIIlIl);
    }
    
    public static int getTotalPhases() {
        return PhaseList.phases.length;
    }
}
