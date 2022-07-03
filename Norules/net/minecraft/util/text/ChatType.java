package net.minecraft.util.text;

public enum ChatType
{
    SYSTEM("SYSTEM", 1, (byte)1), 
    CHAT("CHAT", 0, (byte)0);
    
    private final /* synthetic */ byte field_192588_d;
    
    GAME_INFO("GAME_INFO", 2, (byte)2);
    
    public byte func_192583_a() {
        return this.field_192588_d;
    }
    
    private ChatType(final String lllllllllllllIIIIllIlIlllIllIllI, final int lllllllllllllIIIIllIlIlllIllIlIl, final byte lllllllllllllIIIIllIlIlllIllIlII) {
        this.field_192588_d = lllllllllllllIIIIllIlIlllIllIlII;
    }
    
    public static ChatType func_192582_a(final byte lllllllllllllIIIIllIlIlllIlIlIll) {
        final Exception lllllllllllllIIIIllIlIlllIlIIlIl;
        final double lllllllllllllIIIIllIlIlllIlIIllI = ((ChatType[])(Object)(lllllllllllllIIIIllIlIlllIlIIlIl = (Exception)(Object)values())).length;
        for (long lllllllllllllIIIIllIlIlllIlIIlll = 0; lllllllllllllIIIIllIlIlllIlIIlll < lllllllllllllIIIIllIlIlllIlIIllI; ++lllllllllllllIIIIllIlIlllIlIIlll) {
            final ChatType lllllllllllllIIIIllIlIlllIlIlIlI = lllllllllllllIIIIllIlIlllIlIIlIl[lllllllllllllIIIIllIlIlllIlIIlll];
            if (lllllllllllllIIIIllIlIlllIlIlIll == lllllllllllllIIIIllIlIlllIlIlIlI.field_192588_d) {
                return lllllllllllllIIIIllIlIlllIlIlIlI;
            }
        }
        return ChatType.CHAT;
    }
}
