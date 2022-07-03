package net.minecraft.client.tutorial;

import net.minecraft.world.*;
import net.minecraft.client.gui.toasts.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.util.*;

public class MovementStep implements ITutorialStep
{
    private /* synthetic */ int field_193262_i;
    private /* synthetic */ boolean field_193265_l;
    private static final /* synthetic */ ITextComponent field_193255_b;
    private /* synthetic */ int field_193266_m;
    private /* synthetic */ TutorialToast field_193260_g;
    private static final /* synthetic */ ITextComponent field_193257_d;
    private /* synthetic */ TutorialToast field_193259_f;
    private /* synthetic */ int field_193263_j;
    private /* synthetic */ boolean field_193264_k;
    private static final /* synthetic */ ITextComponent field_193256_c;
    private static final /* synthetic */ ITextComponent field_193254_a;
    private /* synthetic */ int field_193267_n;
    private final /* synthetic */ Tutorial field_193258_e;
    private /* synthetic */ int field_193261_h;
    
    @Override
    public void func_193248_b() {
        if (this.field_193259_f != null) {
            this.field_193259_f.func_193670_a();
            this.field_193259_f = null;
        }
        if (this.field_193260_g != null) {
            this.field_193260_g.func_193670_a();
            this.field_193260_g = null;
        }
    }
    
    @Override
    public void func_193245_a() {
        ++this.field_193261_h;
        if (this.field_193264_k) {
            ++this.field_193262_i;
            this.field_193264_k = false;
        }
        if (this.field_193265_l) {
            ++this.field_193263_j;
            this.field_193265_l = false;
        }
        if (this.field_193266_m == -1 && this.field_193262_i > 40) {
            if (this.field_193259_f != null) {
                this.field_193259_f.func_193670_a();
                this.field_193259_f = null;
            }
            this.field_193266_m = this.field_193261_h;
        }
        if (this.field_193267_n == -1 && this.field_193263_j > 40) {
            if (this.field_193260_g != null) {
                this.field_193260_g.func_193670_a();
                this.field_193260_g = null;
            }
            this.field_193267_n = this.field_193261_h;
        }
        if (this.field_193266_m != -1 && this.field_193267_n != -1) {
            if (this.field_193258_e.func_194072_f() == GameType.SURVIVAL) {
                this.field_193258_e.func_193292_a(TutorialSteps.FIND_TREE);
            }
            else {
                this.field_193258_e.func_193292_a(TutorialSteps.NONE);
            }
        }
        if (this.field_193259_f != null) {
            this.field_193259_f.func_193669_a(this.field_193262_i / 40.0f);
        }
        if (this.field_193260_g != null) {
            this.field_193260_g.func_193669_a(this.field_193263_j / 40.0f);
        }
        if (this.field_193261_h >= 100) {
            if (this.field_193266_m == -1 && this.field_193259_f == null) {
                this.field_193259_f = new TutorialToast(TutorialToast.Icons.MOVEMENT_KEYS, MovementStep.field_193254_a, MovementStep.field_193255_b, true);
                this.field_193258_e.func_193295_e().func_193033_an().func_192988_a(this.field_193259_f);
            }
            else if (this.field_193266_m != -1 && this.field_193261_h - this.field_193266_m >= 20 && this.field_193267_n == -1 && this.field_193260_g == null) {
                this.field_193260_g = new TutorialToast(TutorialToast.Icons.MOUSE, MovementStep.field_193256_c, MovementStep.field_193257_d, true);
                this.field_193258_e.func_193295_e().func_193033_an().func_192988_a(this.field_193260_g);
            }
        }
    }
    
    @Override
    public void func_193249_a(final MouseHelper llllllllllllllIIlIlIlIIIlIllIIll) {
        if (MathHelper.abs(llllllllllllllIIlIlIlIIIlIllIIll.deltaX) > 0.01 || MathHelper.abs(llllllllllllllIIlIlIlIIIlIllIIll.deltaY) > 0.01) {
            this.field_193265_l = true;
        }
    }
    
    static {
        field_193254_a = new TextComponentTranslation("tutorial.move.title", new Object[] { Tutorial.func_193291_a("forward"), Tutorial.func_193291_a("left"), Tutorial.func_193291_a("back"), Tutorial.func_193291_a("right") });
        field_193255_b = new TextComponentTranslation("tutorial.move.description", new Object[] { Tutorial.func_193291_a("jump") });
        field_193256_c = new TextComponentTranslation("tutorial.look.title", new Object[0]);
        field_193257_d = new TextComponentTranslation("tutorial.look.description", new Object[0]);
    }
    
    public MovementStep(final Tutorial llllllllllllllIIlIlIlIIIllIlIlII) {
        this.field_193266_m = -1;
        this.field_193267_n = -1;
        this.field_193258_e = llllllllllllllIIlIlIlIIIllIlIlII;
    }
    
    @Override
    public void func_193247_a(final MovementInput llllllllllllllIIlIlIlIIIlIllllII) {
        if (llllllllllllllIIlIlIlIIIlIllllII.forwardKeyDown || llllllllllllllIIlIlIlIIIlIllllII.backKeyDown || llllllllllllllIIlIlIlIIIlIllllII.leftKeyDown || llllllllllllllIIlIlIlIIIlIllllII.rightKeyDown || llllllllllllllIIlIlIlIIIlIllllII.jump) {
            this.field_193264_k = true;
        }
    }
}
