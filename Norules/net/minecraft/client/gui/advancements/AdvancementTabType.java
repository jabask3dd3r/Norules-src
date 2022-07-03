package net.minecraft.client.gui.advancements;

import net.minecraft.client.renderer.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.gui.*;

enum AdvancementTabType
{
    RIGHT("RIGHT", 3, 96, 64, 32, 28, 5), 
    ABOVE("ABOVE", 0, 0, 0, 28, 32, 8);
    
    private final /* synthetic */ int field_192662_h;
    private final /* synthetic */ int field_192661_g;
    
    LEFT("LEFT", 2, 0, 64, 32, 28, 5);
    
    private final /* synthetic */ int field_192664_j;
    private final /* synthetic */ int field_192660_f;
    
    BELOW("BELOW", 1, 84, 0, 28, 32, 8);
    
    private final /* synthetic */ int field_192663_i;
    
    static {
        int llllllllllllllIlIlIIIIlIllIlIIIl = 0;
        final byte llllllllllllllIlIlIIIIlIllIIlIll;
        final long llllllllllllllIlIlIIIIlIllIIllII = ((AdvancementTabType[])(Object)(llllllllllllllIlIlIIIIlIllIIlIll = (byte)(Object)values())).length;
        for (final AdvancementTabType llllllllllllllIlIlIIIIlIllIlIIII : llllllllllllllIlIlIIIIlIllIIlIll) {
            llllllllllllllIlIlIIIIlIllIlIIIl += llllllllllllllIlIlIIIIlIllIlIIII.field_192664_j;
        }
        field_192659_e = llllllllllllllIlIlIIIIlIllIlIIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType() {
        final int[] $switch_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType = AdvancementTabType.$SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType;
        if ($switch_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType != null) {
            return $switch_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType;
        }
        final boolean llllllllllllllIlIlIIIIlIIlIlIlII = (Object)new int[values().length];
        try {
            llllllllllllllIlIlIIIIlIIlIlIlII[AdvancementTabType.ABOVE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIlIIIIlIIlIlIlII[AdvancementTabType.BELOW.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIlIIIIlIIlIlIlII[AdvancementTabType.LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlIlIIIIlIIlIlIlII[AdvancementTabType.RIGHT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return AdvancementTabType.$SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType = (int[])(Object)llllllllllllllIlIlIIIIlIIlIlIlII;
    }
    
    public int func_192650_a() {
        return this.field_192664_j;
    }
    
    public void func_192652_a(final int llllllllllllllIlIlIIIIlIlIIIlIII, final int llllllllllllllIlIlIIIIlIlIIIIlll, final int llllllllllllllIlIlIIIIlIlIIIlllI, final RenderItem llllllllllllllIlIlIIIIlIlIIIllIl, final ItemStack llllllllllllllIlIlIIIIlIlIIIllII) {
        int llllllllllllllIlIlIIIIlIlIIIlIll = llllllllllllllIlIlIIIIlIlIIIlIII + this.func_192648_a(llllllllllllllIlIlIIIIlIlIIIlllI);
        int llllllllllllllIlIlIIIIlIlIIIlIlI = llllllllllllllIlIlIIIIlIlIIIIlll + this.func_192653_b(llllllllllllllIlIlIIIIlIlIIIlllI);
        switch ($SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType()[this.ordinal()]) {
            case 1: {
                llllllllllllllIlIlIIIIlIlIIIlIll += 6;
                llllllllllllllIlIlIIIIlIlIIIlIlI += 9;
                break;
            }
            case 2: {
                llllllllllllllIlIlIIIIlIlIIIlIll += 6;
                llllllllllllllIlIlIIIIlIlIIIlIlI += 6;
                break;
            }
            case 3: {
                llllllllllllllIlIlIIIIlIlIIIlIll += 10;
                llllllllllllllIlIlIIIIlIlIIIlIlI += 5;
                break;
            }
            case 4: {
                llllllllllllllIlIlIIIIlIlIIIlIll += 6;
                llllllllllllllIlIlIIIIlIlIIIlIlI += 5;
                break;
            }
        }
        llllllllllllllIlIlIIIIlIlIIIllIl.renderItemAndEffectIntoGUI(null, llllllllllllllIlIlIIIIlIlIIIllII, llllllllllllllIlIlIIIIlIlIIIlIll, llllllllllllllIlIlIIIIlIlIIIlIlI);
    }
    
    public int func_192653_b(final int llllllllllllllIlIlIIIIlIIlllIllI) {
        switch ($SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType()[this.ordinal()]) {
            case 1: {
                return -this.field_192663_i + 4;
            }
            case 2: {
                return 136;
            }
            case 3: {
                return this.field_192663_i * llllllllllllllIlIlIIIIlIIlllIllI;
            }
            case 4: {
                return this.field_192663_i * llllllllllllllIlIlIIIIlIIlllIllI;
            }
            default: {
                throw new UnsupportedOperationException(String.valueOf(new StringBuilder("Don't know what this tab type is!").append(this)));
            }
        }
    }
    
    public boolean func_192654_a(final int llllllllllllllIlIlIIIIlIIllIIlII, final int llllllllllllllIlIlIIIIlIIllIIIll, final int llllllllllllllIlIlIIIIlIIllIIIlI, final int llllllllllllllIlIlIIIIlIIllIIIIl, final int llllllllllllllIlIlIIIIlIIllIIIII) {
        final int llllllllllllllIlIlIIIIlIIllIIlll = llllllllllllllIlIlIIIIlIIllIIlII + this.func_192648_a(llllllllllllllIlIlIIIIlIIllIIIlI);
        final int llllllllllllllIlIlIIIIlIIllIIllI = llllllllllllllIlIlIIIIlIIllIIIll + this.func_192653_b(llllllllllllllIlIlIIIIlIIllIIIlI);
        return llllllllllllllIlIlIIIIlIIllIIIIl > llllllllllllllIlIlIIIIlIIllIIlll && llllllllllllllIlIlIIIIlIIllIIIIl < llllllllllllllIlIlIIIIlIIllIIlll + this.field_192662_h && llllllllllllllIlIlIIIIlIIllIIIII > llllllllllllllIlIlIIIIlIIllIIllI && llllllllllllllIlIlIIIIlIIllIIIII < llllllllllllllIlIlIIIIlIIllIIllI + this.field_192663_i;
    }
    
    public void func_192651_a(final Gui llllllllllllllIlIlIIIIlIlIlIIIII, final int llllllllllllllIlIlIIIIlIlIIlllll, final int llllllllllllllIlIlIIIIlIlIIllllI, final boolean llllllllllllllIlIlIIIIlIlIIlllIl, final int llllllllllllllIlIlIIIIlIlIlIIlII) {
        int llllllllllllllIlIlIIIIlIlIlIIIll = this.field_192660_f;
        if (llllllllllllllIlIlIIIIlIlIlIIlII > 0) {
            llllllllllllllIlIlIIIIlIlIlIIIll += this.field_192662_h;
        }
        if (llllllllllllllIlIlIIIIlIlIlIIlII == this.field_192664_j - 1) {
            llllllllllllllIlIlIIIIlIlIlIIIll += this.field_192662_h;
        }
        final int llllllllllllllIlIlIIIIlIlIlIIIlI = llllllllllllllIlIlIIIIlIlIIlllIl ? (this.field_192661_g + this.field_192663_i) : this.field_192661_g;
        llllllllllllllIlIlIIIIlIlIlIIIII.drawTexturedModalRect(llllllllllllllIlIlIIIIlIlIIlllll + this.func_192648_a(llllllllllllllIlIlIIIIlIlIlIIlII), llllllllllllllIlIlIIIIlIlIIllllI + this.func_192653_b(llllllllllllllIlIlIIIIlIlIlIIlII), llllllllllllllIlIlIIIIlIlIlIIIll, llllllllllllllIlIlIIIIlIlIlIIIlI, this.field_192662_h, this.field_192663_i);
    }
    
    public int func_192648_a(final int llllllllllllllIlIlIIIIlIIlllllII) {
        switch ($SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType()[this.ordinal()]) {
            case 1: {
                return (this.field_192662_h + 4) * llllllllllllllIlIlIIIIlIIlllllII;
            }
            case 2: {
                return (this.field_192662_h + 4) * llllllllllllllIlIlIIIIlIIlllllII;
            }
            case 3: {
                return -this.field_192662_h + 4;
            }
            case 4: {
                return 248;
            }
            default: {
                throw new UnsupportedOperationException(String.valueOf(new StringBuilder("Don't know what this tab type is!").append(this)));
            }
        }
    }
    
    private AdvancementTabType(final String llllllllllllllIlIlIIIIlIlIlllIll, final int llllllllllllllIlIlIIIIlIlIlllIlI, final int llllllllllllllIlIlIIIIlIlIlllIIl, final int llllllllllllllIlIlIIIIlIllIIIIII, final int llllllllllllllIlIlIIIIlIlIllIlll, final int llllllllllllllIlIlIIIIlIlIllIllI, final int llllllllllllllIlIlIIIIlIlIllIlIl) {
        this.field_192660_f = llllllllllllllIlIlIIIIlIlIlllIIl;
        this.field_192661_g = llllllllllllllIlIlIIIIlIllIIIIII;
        this.field_192662_h = llllllllllllllIlIlIIIIlIlIllIlll;
        this.field_192663_i = llllllllllllllIlIlIIIIlIlIllIllI;
        this.field_192664_j = llllllllllllllIlIlIIIIlIlIllIlIl;
    }
}
