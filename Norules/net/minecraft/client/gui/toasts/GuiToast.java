package net.minecraft.client.gui.toasts;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.util.*;
import com.google.common.collect.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;

public class GuiToast extends Gui
{
    private final /* synthetic */ Deque<IToast> field_191792_h;
    private final /* synthetic */ Minecraft field_191790_f;
    private final /* synthetic */ ToastInstance<?>[] field_191791_g;
    
    public void func_191783_a(final ScaledResolution llllllllllllllIlIIIIIlIlIIIIIIll) {
        if (!this.field_191790_f.gameSettings.hideGUI) {
            RenderHelper.disableStandardItemLighting();
            for (int llllllllllllllIlIIIIIlIlIIIIIllI = 0; llllllllllllllIlIIIIIlIlIIIIIllI < this.field_191791_g.length; ++llllllllllllllIlIIIIIlIlIIIIIllI) {
                final ToastInstance<?> llllllllllllllIlIIIIIlIlIIIIIlIl = this.field_191791_g[llllllllllllllIlIIIIIlIlIIIIIllI];
                if (llllllllllllllIlIIIIIlIlIIIIIlIl != null && llllllllllllllIlIIIIIlIlIIIIIlIl.func_193684_a(llllllllllllllIlIIIIIlIlIIIIIIll.getScaledWidth(), llllllllllllllIlIIIIIlIlIIIIIllI)) {
                    this.field_191791_g[llllllllllllllIlIIIIIlIlIIIIIllI] = null;
                }
                if (this.field_191791_g[llllllllllllllIlIIIIIlIlIIIIIllI] == null && !this.field_191792_h.isEmpty()) {
                    this.field_191791_g[llllllllllllllIlIIIIIlIlIIIIIllI] = new ToastInstance<Object>((IToast)this.field_191792_h.removeFirst(), (ToastInstance<?>)null);
                }
            }
        }
    }
    
    public void func_192988_a(final IToast llllllllllllllIlIIIIIlIIlllIIlIl) {
        this.field_191792_h.add(llllllllllllllIlIIIIIlIIlllIIlIl);
    }
    
    public void func_191788_b() {
        Arrays.fill(this.field_191791_g, null);
        this.field_191792_h.clear();
    }
    
    public Minecraft func_192989_b() {
        return this.field_191790_f;
    }
    
    public GuiToast(final Minecraft llllllllllllllIlIIIIIlIlIIIIllIl) {
        this.field_191791_g = (ToastInstance<?>[])new ToastInstance[5];
        this.field_191792_h = (Deque<IToast>)Queues.newArrayDeque();
        this.field_191790_f = llllllllllllllIlIIIIIlIlIIIIllIl;
    }
    
    @Nullable
    public <T extends IToast> T func_192990_a(final Class<? extends T> llllllllllllllIlIIIIIlIIllllIIll, final Object llllllllllllllIlIIIIIlIIllllIIlI) {
        String llllllllllllllIlIIIIIlIIlllIlllI;
        for (double llllllllllllllIlIIIIIlIIlllIllll = ((ToastInstance<?>[])(Object)(llllllllllllllIlIIIIIlIIlllIlllI = (String)(Object)this.field_191791_g)).length, llllllllllllllIlIIIIIlIIllllIIII = 0; llllllllllllllIlIIIIIlIIllllIIII < llllllllllllllIlIIIIIlIIlllIllll; ++llllllllllllllIlIIIIIlIIllllIIII) {
            final ToastInstance<?> llllllllllllllIlIIIIIlIIllllIllI = llllllllllllllIlIIIIIlIIlllIlllI[llllllllllllllIlIIIIIlIIllllIIII];
            if (llllllllllllllIlIIIIIlIIllllIllI != null && llllllllllllllIlIIIIIlIIllllIIll.isAssignableFrom(llllllllllllllIlIIIIIlIIllllIllI.func_193685_a().getClass()) && ((IToast)llllllllllllllIlIIIIIlIIllllIllI.func_193685_a()).func_193652_b().equals(llllllllllllllIlIIIIIlIIllllIIlI)) {
                return (T)llllllllllllllIlIIIIIlIIllllIllI.func_193685_a();
            }
        }
        for (final IToast llllllllllllllIlIIIIIlIIllllIlIl : this.field_191792_h) {
            if (llllllllllllllIlIIIIIlIIllllIIll.isAssignableFrom(llllllllllllllIlIIIIIlIIllllIlIl.getClass()) && llllllllllllllIlIIIIIlIIllllIlIl.func_193652_b().equals(llllllllllllllIlIIIIIlIIllllIIlI)) {
                return (T)llllllllllllllIlIIIIIlIIllllIlIl;
            }
        }
        return null;
    }
    
    class ToastInstance<T extends IToast>
    {
        private /* synthetic */ long field_193690_d;
        private /* synthetic */ IToast.Visibility field_193691_e;
        private final /* synthetic */ T field_193688_b;
        private /* synthetic */ long field_193689_c;
        
        public boolean func_193684_a(final int lllllllllllllIlllIllIllIIIlIIIlI, final int lllllllllllllIlllIllIllIIIlIIllI) {
            final long lllllllllllllIlllIllIllIIIlIIlIl = Minecraft.getSystemTime();
            if (this.field_193689_c == -1L) {
                this.field_193689_c = lllllllllllllIlllIllIllIIIlIIlIl;
                this.field_193691_e.func_194169_a(GuiToast.this.field_191790_f.getSoundHandler());
            }
            if (this.field_193691_e == IToast.Visibility.SHOW && lllllllllllllIlllIllIllIIIlIIlIl - this.field_193689_c <= 600L) {
                this.field_193690_d = lllllllllllllIlllIllIllIIIlIIlIl;
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(lllllllllllllIlllIllIllIIIlIIIlI - 160.0f * this.func_193686_a(lllllllllllllIlllIllIllIIIlIIlIl), (float)(lllllllllllllIlllIllIllIIIlIIllI * 32), (float)(500 + lllllllllllllIlllIllIllIIIlIIllI));
            final IToast.Visibility lllllllllllllIlllIllIllIIIlIIlII = this.field_193688_b.func_193653_a(GuiToast.this, lllllllllllllIlllIllIllIIIlIIlIl - this.field_193690_d);
            GlStateManager.popMatrix();
            if (lllllllllllllIlllIllIllIIIlIIlII != this.field_193691_e) {
                this.field_193689_c = lllllllllllllIlllIllIllIIIlIIlIl - (int)((1.0f - this.func_193686_a(lllllllllllllIlllIllIllIIIlIIlIl)) * 600.0f);
                this.field_193691_e = lllllllllllllIlllIllIllIIIlIIlII;
                this.field_193691_e.func_194169_a(GuiToast.this.field_191790_f.getSoundHandler());
            }
            return this.field_193691_e == IToast.Visibility.HIDE && lllllllllllllIlllIllIllIIIlIIlIl - this.field_193689_c > 600L;
        }
        
        private ToastInstance(final T lllllllllllllIlllIllIllIIIlllIlI) {
            this.field_193689_c = -1L;
            this.field_193690_d = -1L;
            this.field_193691_e = IToast.Visibility.SHOW;
            this.field_193688_b = lllllllllllllIlllIllIllIIIlllIlI;
        }
        
        public T func_193685_a() {
            return this.field_193688_b;
        }
        
        private float func_193686_a(final long lllllllllllllIlllIllIllIIIlIllll) {
            float lllllllllllllIlllIllIllIIIllIIIl = MathHelper.clamp((lllllllllllllIlllIllIllIIIlIllll - this.field_193689_c) / 600.0f, 0.0f, 1.0f);
            lllllllllllllIlllIllIllIIIllIIIl *= lllllllllllllIlllIllIllIIIllIIIl;
            return (this.field_193691_e == IToast.Visibility.HIDE) ? (1.0f - lllllllllllllIlllIllIllIIIllIIIl) : lllllllllllllIlllIllIllIIIllIIIl;
        }
    }
}
