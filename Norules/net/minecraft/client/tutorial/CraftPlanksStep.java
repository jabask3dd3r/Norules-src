package net.minecraft.client.tutorial;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.client.entity.*;
import net.minecraft.stats.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.toasts.*;

public class CraftPlanksStep implements ITutorialStep
{
    private /* synthetic */ int field_193290_e;
    private final /* synthetic */ Tutorial field_193288_c;
    private static final /* synthetic */ ITextComponent field_193287_b;
    private static final /* synthetic */ ITextComponent field_193286_a;
    private /* synthetic */ TutorialToast field_193289_d;
    
    @Override
    public void func_193252_a(final ItemStack lllllllllllllIlIlIIllIlllIlllIII) {
        if (lllllllllllllIlIlIIllIlllIlllIII.getItem() == Item.getItemFromBlock(Blocks.PLANKS)) {
            this.field_193288_c.func_193292_a(TutorialSteps.NONE);
        }
    }
    
    @Override
    public void func_193248_b() {
        if (this.field_193289_d != null) {
            this.field_193289_d.func_193670_a();
            this.field_193289_d = null;
        }
    }
    
    static {
        field_193286_a = new TextComponentTranslation("tutorial.craft_planks.title", new Object[0]);
        field_193287_b = new TextComponentTranslation("tutorial.craft_planks.description", new Object[0]);
    }
    
    public static boolean func_194071_a(final EntityPlayerSP lllllllllllllIlIlIIllIlllIllIIll) {
        final StatBase lllllllllllllIlIlIIllIlllIllIIlI = StatList.getCraftStats(Item.getItemFromBlock(Blocks.PLANKS));
        return lllllllllllllIlIlIIllIlllIllIIlI != null && lllllllllllllIlIlIIllIlllIllIIll.getStatFileWriter().readStat(lllllllllllllIlIlIIllIlllIllIIlI) > 0;
    }
    
    @Override
    public void func_193245_a() {
        ++this.field_193290_e;
        if (this.field_193288_c.func_194072_f() != GameType.SURVIVAL) {
            this.field_193288_c.func_193292_a(TutorialSteps.NONE);
        }
        else {
            if (this.field_193290_e == 1) {
                final EntityPlayerSP lllllllllllllIlIlIIllIllllIIIIIl = this.field_193288_c.func_193295_e().player;
                if (lllllllllllllIlIlIIllIllllIIIIIl != null) {
                    if (lllllllllllllIlIlIIllIllllIIIIIl.inventory.hasItemStack(new ItemStack(Blocks.PLANKS))) {
                        this.field_193288_c.func_193292_a(TutorialSteps.NONE);
                        return;
                    }
                    if (func_194071_a(lllllllllllllIlIlIIllIllllIIIIIl)) {
                        this.field_193288_c.func_193292_a(TutorialSteps.NONE);
                        return;
                    }
                }
            }
            if (this.field_193290_e >= 1200 && this.field_193289_d == null) {
                this.field_193289_d = new TutorialToast(TutorialToast.Icons.WOODEN_PLANKS, CraftPlanksStep.field_193286_a, CraftPlanksStep.field_193287_b, false);
                this.field_193288_c.func_193295_e().func_193033_an().func_192988_a(this.field_193289_d);
            }
        }
    }
    
    public CraftPlanksStep(final Tutorial lllllllllllllIlIlIIllIllllIIIlll) {
        this.field_193288_c = lllllllllllllIlIlIIllIllllIIIlll;
    }
}
