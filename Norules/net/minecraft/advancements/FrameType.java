package net.minecraft.advancements;

import net.minecraft.util.text.*;

public enum FrameType
{
    private final /* synthetic */ TextFormatting field_193230_f;
    private final /* synthetic */ int field_192314_e;
    
    TASK("TASK", 0, "task", 0, TextFormatting.GREEN);
    
    private final /* synthetic */ String field_192313_d;
    
    CHALLENGE("CHALLENGE", 1, "challenge", 26, TextFormatting.DARK_PURPLE), 
    GOAL("GOAL", 2, "goal", 52, TextFormatting.GREEN);
    
    public String func_192307_a() {
        return this.field_192313_d;
    }
    
    public static FrameType func_192308_a(final String lllllllllllllllIIlIlIlIlllIIIlll) {
        final float lllllllllllllllIIlIlIlIlllIIIIIl;
        final char lllllllllllllllIIlIlIlIlllIIIIlI = (char)((FrameType[])(Object)(lllllllllllllllIIlIlIlIlllIIIIIl = (float)(Object)values())).length;
        for (final FrameType lllllllllllllllIIlIlIlIlllIIIllI : lllllllllllllllIIlIlIlIlllIIIIIl) {
            if (lllllllllllllllIIlIlIlIlllIIIllI.field_192313_d.equals(lllllllllllllllIIlIlIlIlllIIIlll)) {
                return lllllllllllllllIIlIlIlIlllIIIllI;
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown frame type '").append(lllllllllllllllIIlIlIlIlllIIIlll).append("'")));
    }
    
    public int func_192309_b() {
        return this.field_192314_e;
    }
    
    private FrameType(final String lllllllllllllllIIlIlIlIlllIlIlll, final int lllllllllllllllIIlIlIlIlllIlIllI, final String lllllllllllllllIIlIlIlIlllIlIlIl, final int lllllllllllllllIIlIlIlIlllIllIlI, final TextFormatting lllllllllllllllIIlIlIlIlllIllIIl) {
        this.field_192313_d = lllllllllllllllIIlIlIlIlllIlIlIl;
        this.field_192314_e = lllllllllllllllIIlIlIlIlllIllIlI;
        this.field_193230_f = lllllllllllllllIIlIlIlIlllIllIIl;
    }
    
    public TextFormatting func_193229_c() {
        return this.field_193230_f;
    }
}
