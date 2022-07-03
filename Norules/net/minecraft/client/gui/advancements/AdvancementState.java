package net.minecraft.client.gui.advancements;

public enum AdvancementState
{
    OBTAINED("OBTAINED", 0, 0), 
    UNOBTAINED("UNOBTAINED", 1, 1);
    
    private final /* synthetic */ int field_192671_d;
    
    public int func_192667_a() {
        return this.field_192671_d;
    }
    
    private AdvancementState(final String lllllllllllllllIIlllllllIlIIIlIl, final int lllllllllllllllIIlllllllIlIIIlII, final int lllllllllllllllIIlllllllIlIIIIlI) {
        this.field_192671_d = lllllllllllllllIIlllllllIlIIIIlI;
    }
}
