package net.minecraft.world.storage;

import net.minecraft.util.math.*;

public class MapDecoration
{
    private /* synthetic */ byte rotation;
    private /* synthetic */ byte x;
    private final /* synthetic */ Type field_191181_a;
    private /* synthetic */ byte y;
    
    public MapDecoration(final Type llllllllllllllIllIlllllIIllIIllI, final byte llllllllllllllIllIlllllIIllIlIlI, final byte llllllllllllllIllIlllllIIllIlIIl, final byte llllllllllllllIllIlllllIIllIIIll) {
        this.field_191181_a = llllllllllllllIllIlllllIIllIIllI;
        this.x = llllllllllllllIllIlllllIIllIlIlI;
        this.y = llllllllllllllIllIlllllIIllIlIIl;
        this.rotation = llllllllllllllIllIlllllIIllIIIll;
    }
    
    public boolean func_191180_f() {
        return this.field_191181_a.func_191160_b();
    }
    
    public byte getRotation() {
        return this.rotation;
    }
    
    public byte getX() {
        return this.x;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIllIlllllIIlIIIlII = this.field_191181_a.func_191163_a();
        llllllllllllllIllIlllllIIlIIIlII = 31 * llllllllllllllIllIlllllIIlIIIlII + this.x;
        llllllllllllllIllIlllllIIlIIIlII = 31 * llllllllllllllIllIlllllIIlIIIlII + this.y;
        llllllllllllllIllIlllllIIlIIIlII = 31 * llllllllllllllIllIlllllIIlIIIlII + this.rotation;
        return llllllllllllllIllIlllllIIlIIIlII;
    }
    
    public Type func_191179_b() {
        return this.field_191181_a;
    }
    
    public byte getType() {
        return this.field_191181_a.func_191163_a();
    }
    
    public byte getY() {
        return this.y;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllIlllllIIlIIlIIl) {
        if (this == llllllllllllllIllIlllllIIlIIlIIl) {
            return true;
        }
        if (!(llllllllllllllIllIlllllIIlIIlIIl instanceof MapDecoration)) {
            return false;
        }
        final MapDecoration llllllllllllllIllIlllllIIlIIlIll = (MapDecoration)llllllllllllllIllIlllllIIlIIlIIl;
        return this.field_191181_a == llllllllllllllIllIlllllIIlIIlIll.field_191181_a && this.rotation == llllllllllllllIllIlllllIIlIIlIll.rotation && this.x == llllllllllllllIllIlllllIIlIIlIll.x && this.y == llllllllllllllIllIlllllIIlIIlIll.y;
    }
    
    public enum Type
    {
        PLAYER_OFF_MAP("PLAYER_OFF_MAP", 6, false);
        
        private final /* synthetic */ boolean field_191176_l;
        
        TARGET_POINT("TARGET_POINT", 5, true), 
        MANSION("MANSION", 8, true, 5393476), 
        FRAME("FRAME", 1, true), 
        PLAYER("PLAYER", 0, false), 
        RED_MARKER("RED_MARKER", 2, false);
        
        private final /* synthetic */ byte field_191175_k;
        
        MONUMENT("MONUMENT", 9, true, 3830373);
        
        private final /* synthetic */ int field_191177_m;
        
        PLAYER_OFF_LIMITS("PLAYER_OFF_LIMITS", 7, false), 
        BLUE_MARKER("BLUE_MARKER", 3, false), 
        TARGET_X("TARGET_X", 4, true);
        
        private Type(final String lllllllllllllIllIIIIllIlIlllIlll, final int lllllllllllllIllIIIIllIlIlllIllI, final boolean lllllllllllllIllIIIIllIlIllllIlI, final int lllllllllllllIllIIIIllIlIlllIlII) {
            this.field_191175_k = (byte)this.ordinal();
            this.field_191176_l = lllllllllllllIllIIIIllIlIllllIlI;
            this.field_191177_m = lllllllllllllIllIIIIllIlIlllIlII;
        }
        
        public int func_191161_d() {
            return this.field_191177_m;
        }
        
        public static Type func_191159_a(final byte lllllllllllllIllIIIIllIlIllIIllI) {
            return values()[MathHelper.clamp(lllllllllllllIllIIIIllIlIllIIllI, 0, values().length - 1)];
        }
        
        public byte func_191163_a() {
            return this.field_191175_k;
        }
        
        public boolean func_191160_b() {
            return this.field_191176_l;
        }
        
        public boolean func_191162_c() {
            return this.field_191177_m >= 0;
        }
        
        private Type(final String lllllllllllllIllIIIIllIllIIIIIll, final int lllllllllllllIllIIIIllIllIIIIIlI, final boolean lllllllllllllIllIIIIllIllIIIIlIl) {
            this(lllllllllllllIllIIIIllIllIIIIIll, lllllllllllllIllIIIIllIllIIIIIlI, lllllllllllllIllIIIIllIllIIIIlIl, -1);
        }
    }
}
