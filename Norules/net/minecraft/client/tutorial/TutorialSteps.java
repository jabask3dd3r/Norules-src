package net.minecraft.client.tutorial;

import java.util.function.*;

public enum TutorialSteps
{
    MOVEMENT("movement", (Function<Tutorial, T>)MovementStep::new);
    
    private final /* synthetic */ String field_193316_g;
    
    CRAFT_PLANKS("craft_planks", (Function<Tutorial, T>)CraftPlanksStep::new), 
    NONE("none", (Function<Tutorial, T>)CompletedTutorialStep::new), 
    FIND_TREE("find_tree", (Function<Tutorial, T>)FindTreeStep::new);
    
    private final /* synthetic */ Function<Tutorial, ? extends ITutorialStep> field_193317_h;
    
    OPEN_INVENTORY("open_inventory", (Function<Tutorial, T>)OpenInventoryStep::new), 
    PUNCH_TREE("punch_tree", (Function<Tutorial, T>)PunchTreeStep::new);
    
    public String func_193308_a() {
        return this.field_193316_g;
    }
    
    public ITutorialStep func_193309_a(final Tutorial lllllllllllllIIllIIllIIllIIlIIIl) {
        return (ITutorialStep)this.field_193317_h.apply(lllllllllllllIIllIIllIIllIIlIIIl);
    }
    
    public static TutorialSteps func_193307_a(final String lllllllllllllIIllIIllIIllIIIIlII) {
        final short lllllllllllllIIllIIllIIllIIIIIII;
        final double lllllllllllllIIllIIllIIllIIIIIIl = ((TutorialSteps[])(Object)(lllllllllllllIIllIIllIIllIIIIIII = (short)(Object)values())).length;
        for (byte lllllllllllllIIllIIllIIllIIIIIlI = 0; lllllllllllllIIllIIllIIllIIIIIlI < lllllllllllllIIllIIllIIllIIIIIIl; ++lllllllllllllIIllIIllIIllIIIIIlI) {
            final TutorialSteps lllllllllllllIIllIIllIIllIIIIlIl = lllllllllllllIIllIIllIIllIIIIIII[lllllllllllllIIllIIllIIllIIIIIlI];
            if (lllllllllllllIIllIIllIIllIIIIlIl.field_193316_g.equals(lllllllllllllIIllIIllIIllIIIIlII)) {
                return lllllllllllllIIllIIllIIllIIIIlIl;
            }
        }
        return TutorialSteps.NONE;
    }
    
    private <T extends ITutorialStep> TutorialSteps(final String lllllllllllllIIllIIllIIllIIllIll, final Function<Tutorial, T> lllllllllllllIIllIIllIIllIIlIlIl) {
        this.field_193316_g = lllllllllllllIIllIIllIIllIIllIll;
        this.field_193317_h = lllllllllllllIIllIIllIIllIIlIlIl;
    }
}
