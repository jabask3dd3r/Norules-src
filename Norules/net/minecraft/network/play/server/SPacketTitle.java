package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.text.*;
import java.io.*;
import net.minecraft.network.*;
import javax.annotation.*;
import java.util.*;

public class SPacketTitle implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int displayTime;
    private /* synthetic */ Type type;
    private /* synthetic */ ITextComponent message;
    private /* synthetic */ int fadeOutTime;
    private /* synthetic */ int fadeInTime;
    
    public int getDisplayTime() {
        return this.displayTime;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllIllIIlIIlIlllII) throws IOException {
        this.type = lllllllllllllIIllIllIIlIIlIlllII.readEnumValue(Type.class);
        if (this.type == Type.TITLE || this.type == Type.SUBTITLE || this.type == Type.ACTIONBAR) {
            this.message = lllllllllllllIIllIllIIlIIlIlllII.readTextComponent();
        }
        if (this.type == Type.TIMES) {
            this.fadeInTime = lllllllllllllIIllIllIIlIIlIlllII.readInt();
            this.displayTime = lllllllllllllIIllIllIIlIIlIlllII.readInt();
            this.fadeOutTime = lllllllllllllIIllIllIIlIIlIlllII.readInt();
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIllIllIIlIIlIlIIII) {
        lllllllllllllIIllIllIIlIIlIlIIII.handleTitle(this);
    }
    
    public int getFadeOutTime() {
        return this.fadeOutTime;
    }
    
    public SPacketTitle(final int lllllllllllllIIllIllIIlIIllllIII, final int lllllllllllllIIllIllIIlIIlllIlll, final int lllllllllllllIIllIllIIlIIlllIllI) {
        this(Type.TIMES, null, lllllllllllllIIllIllIIlIIllllIII, lllllllllllllIIllIllIIlIIlllIlll, lllllllllllllIIllIllIIlIIlllIllI);
    }
    
    public SPacketTitle(final Type lllllllllllllIIllIllIIlIlIIIIIlI, final ITextComponent lllllllllllllIIllIllIIlIlIIIIIIl) {
        this(lllllllllllllIIllIllIIlIlIIIIIlI, lllllllllllllIIllIllIIlIlIIIIIIl, -1, -1, -1);
    }
    
    public Type getType() {
        return this.type;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllIllIIlIIlIlIlII) throws IOException {
        lllllllllllllIIllIllIIlIIlIlIlII.writeEnumValue(this.type);
        if (this.type == Type.TITLE || this.type == Type.SUBTITLE || this.type == Type.ACTIONBAR) {
            lllllllllllllIIllIllIIlIIlIlIlII.writeTextComponent(this.message);
        }
        if (this.type == Type.TIMES) {
            lllllllllllllIIllIllIIlIIlIlIlII.writeInt(this.fadeInTime);
            lllllllllllllIIllIllIIlIIlIlIlII.writeInt(this.displayTime);
            lllllllllllllIIllIllIIlIIlIlIlII.writeInt(this.fadeOutTime);
        }
    }
    
    public ITextComponent getMessage() {
        return this.message;
    }
    
    public SPacketTitle(final Type lllllllllllllIIllIllIIlIIllIlIlI, @Nullable final ITextComponent lllllllllllllIIllIllIIlIIllIIIll, final int lllllllllllllIIllIllIIlIIllIlIII, final int lllllllllllllIIllIllIIlIIllIIIIl, final int lllllllllllllIIllIllIIlIIllIIllI) {
        this.type = lllllllllllllIIllIllIIlIIllIlIlI;
        this.message = lllllllllllllIIllIllIIlIIllIIIll;
        this.fadeInTime = lllllllllllllIIllIllIIlIIllIlIII;
        this.displayTime = lllllllllllllIIllIllIIlIIllIIIIl;
        this.fadeOutTime = lllllllllllllIIllIllIIlIIllIIllI;
    }
    
    public SPacketTitle() {
    }
    
    public int getFadeInTime() {
        return this.fadeInTime;
    }
    
    public enum Type
    {
        RESET("RESET", 5), 
        TITLE("TITLE", 0), 
        ACTIONBAR("ACTIONBAR", 2), 
        TIMES("TIMES", 3), 
        SUBTITLE("SUBTITLE", 1), 
        CLEAR("CLEAR", 4);
        
        private Type(final String lllllllllllllllllIlIllllIlllIllI, final int lllllllllllllllllIlIllllIlllIlIl) {
        }
        
        public static String[] getNames() {
            final String[] lllllllllllllllllIlIllllIllIIIlI = new String[values().length];
            int lllllllllllllllllIlIllllIllIIIIl = 0;
            final boolean lllllllllllllllllIlIllllIlIllIlI;
            final byte lllllllllllllllllIlIllllIlIllIll = (byte)((Type[])(Object)(lllllllllllllllllIlIllllIlIllIlI = (boolean)(Object)values())).length;
            for (double lllllllllllllllllIlIllllIlIlllII = 0; lllllllllllllllllIlIllllIlIlllII < lllllllllllllllllIlIllllIlIllIll; ++lllllllllllllllllIlIllllIlIlllII) {
                final Type lllllllllllllllllIlIllllIllIIIII = lllllllllllllllllIlIllllIlIllIlI[lllllllllllllllllIlIllllIlIlllII];
                lllllllllllllllllIlIllllIllIIIlI[lllllllllllllllllIlIllllIllIIIIl++] = lllllllllllllllllIlIllllIllIIIII.name().toLowerCase(Locale.ROOT);
            }
            return lllllllllllllllllIlIllllIllIIIlI;
        }
        
        public static Type byName(final String lllllllllllllllllIlIllllIllIllll) {
            final float lllllllllllllllllIlIllllIllIlIIl;
            final double lllllllllllllllllIlIllllIllIlIlI = ((Type[])(Object)(lllllllllllllllllIlIllllIllIlIIl = (float)(Object)values())).length;
            for (String lllllllllllllllllIlIllllIllIlIll = (String)0; lllllllllllllllllIlIllllIllIlIll < lllllllllllllllllIlIllllIllIlIlI; ++lllllllllllllllllIlIllllIllIlIll) {
                final Type lllllllllllllllllIlIllllIllIlllI = lllllllllllllllllIlIllllIllIlIIl[lllllllllllllllllIlIllllIllIlIll];
                if (lllllllllllllllllIlIllllIllIlllI.name().equalsIgnoreCase(lllllllllllllllllIlIllllIllIllll)) {
                    return lllllllllllllllllIlIllllIllIlllI;
                }
            }
            return Type.TITLE;
        }
    }
}
