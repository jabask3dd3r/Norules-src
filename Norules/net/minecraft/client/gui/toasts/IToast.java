package net.minecraft.client.gui.toasts;

import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import net.minecraft.init.*;

public interface IToast
{
    public static final /* synthetic */ Object field_193655_b = new Object();
    
    default Object func_193652_b() {
        return IToast.field_193655_b;
    }
    
    Visibility func_193653_a(final GuiToast p0, final long p1);
    
    public enum Visibility
    {
        SHOW("SHOW", 0, SoundEvents.field_194226_id);
        
        private final /* synthetic */ SoundEvent field_194170_c;
        
        HIDE("HIDE", 1, SoundEvents.field_194227_ie);
        
        public void func_194169_a(final SoundHandler lllllllllllllIlIIIIlIllIlllllIII) {
            lllllllllllllIlIIIIlIllIlllllIII.playSound(PositionedSoundRecord.func_194007_a(this.field_194170_c, 1.0f, 1.0f));
        }
        
        private Visibility(final String lllllllllllllIlIIIIlIllIlllllllI, final int lllllllllllllIlIIIIlIllIllllllIl, final SoundEvent lllllllllllllIlIIIIlIllIllllllII) {
            this.field_194170_c = lllllllllllllIlIIIIlIllIllllllII;
        }
    }
}
