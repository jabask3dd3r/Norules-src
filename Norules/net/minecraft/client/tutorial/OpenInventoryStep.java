package net.minecraft.client.tutorial;

import net.minecraft.world.*;
import net.minecraft.client.gui.toasts.*;
import net.minecraft.util.text.*;

public class OpenInventoryStep implements ITutorialStep
{
    private final /* synthetic */ Tutorial field_193283_c;
    private static final /* synthetic */ ITextComponent field_193282_b;
    private /* synthetic */ TutorialToast field_193284_d;
    private static final /* synthetic */ ITextComponent field_193281_a;
    private /* synthetic */ int field_193285_e;
    
    @Override
    public void func_193248_b() {
        if (this.field_193284_d != null) {
            this.field_193284_d.func_193670_a();
            this.field_193284_d = null;
        }
    }
    
    public OpenInventoryStep(final Tutorial llllIlIllIIl) {
        this.field_193283_c = llllIlIllIIl;
    }
    
    @Override
    public void func_193251_c() {
        this.field_193283_c.func_193292_a(TutorialSteps.CRAFT_PLANKS);
    }
    
    @Override
    public void func_193245_a() {
        ++this.field_193285_e;
        if (this.field_193283_c.func_194072_f() != GameType.SURVIVAL) {
            this.field_193283_c.func_193292_a(TutorialSteps.NONE);
        }
        else if (this.field_193285_e >= 600 && this.field_193284_d == null) {
            this.field_193284_d = new TutorialToast(TutorialToast.Icons.RECIPE_BOOK, OpenInventoryStep.field_193281_a, OpenInventoryStep.field_193282_b, false);
            this.field_193283_c.func_193295_e().func_193033_an().func_192988_a(this.field_193284_d);
        }
    }
    
    static {
        field_193281_a = new TextComponentTranslation("tutorial.open_inventory.title", new Object[0]);
        field_193282_b = new TextComponentTranslation("tutorial.open_inventory.description", new Object[] { Tutorial.func_193291_a("inventory") });
    }
}
