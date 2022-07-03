package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketUpdateBossInfo implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ UUID uniqueId;
    private /* synthetic */ float percent;
    private /* synthetic */ boolean createFog;
    private /* synthetic */ boolean darkenSky;
    private /* synthetic */ Operation operation;
    private /* synthetic */ ITextComponent name;
    private /* synthetic */ boolean playEndBossMusic;
    private /* synthetic */ BossInfo.Overlay overlay;
    private /* synthetic */ BossInfo.Color color;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation = SPacketUpdateBossInfo.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
        }
        final int lllllllllllllIIIlllIlIlIIlIIlIlI = (Object)new int[Operation.values().length];
        try {
            lllllllllllllIIIlllIlIlIIlIIlIlI[Operation.ADD.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIlllIlIlIIlIIlIlI[Operation.REMOVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIlllIlIlIIlIIlIlI[Operation.UPDATE_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIlllIlIlIIlIIlIlI[Operation.UPDATE_PCT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIlllIlIlIIlIIlIlI[Operation.UPDATE_PROPERTIES.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIIlllIlIlIIlIIlIlI[Operation.UPDATE_STYLE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return SPacketUpdateBossInfo.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation = (int[])(Object)lllllllllllllIIIlllIlIlIIlIIlIlI;
    }
    
    public boolean shouldDarkenSky() {
        return this.darkenSky;
    }
    
    public Operation getOperation() {
        return this.operation;
    }
    
    public float getPercent() {
        return this.percent;
    }
    
    public ITextComponent getName() {
        return this.name;
    }
    
    private void setFlags(final int lllllllllllllIIIlllIlIlIIlllllll) {
        this.darkenSky = ((lllllllllllllIIIlllIlIlIIlllllll & 0x1) > 0);
        this.playEndBossMusic = ((lllllllllllllIIIlllIlIlIIlllllll & 0x2) > 0);
        this.createFog = ((lllllllllllllIIIlllIlIlIIlllllll & 0x2) > 0);
    }
    
    public SPacketUpdateBossInfo(final Operation lllllllllllllIIIlllIlIlIlIIIlIlI, final BossInfo lllllllllllllIIIlllIlIlIlIIIlIIl) {
        this.operation = lllllllllllllIIIlllIlIlIlIIIlIlI;
        this.uniqueId = lllllllllllllIIIlllIlIlIlIIIlIIl.getUniqueId();
        this.name = lllllllllllllIIIlllIlIlIlIIIlIIl.getName();
        this.percent = lllllllllllllIIIlllIlIlIlIIIlIIl.getPercent();
        this.color = lllllllllllllIIIlllIlIlIlIIIlIIl.getColor();
        this.overlay = lllllllllllllIIIlllIlIlIlIIIlIIl.getOverlay();
        this.darkenSky = lllllllllllllIIIlllIlIlIlIIIlIIl.shouldDarkenSky();
        this.playEndBossMusic = lllllllllllllIIIlllIlIlIlIIIlIIl.shouldPlayEndBossMusic();
        this.createFog = lllllllllllllIIIlllIlIlIlIIIlIIl.shouldCreateFog();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIlllIlIlIIlllIlll) throws IOException {
        lllllllllllllIIIlllIlIlIIlllIlll.writeUuid(this.uniqueId);
        lllllllllllllIIIlllIlIlIIlllIlll.writeEnumValue(this.operation);
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation()[this.operation.ordinal()]) {
            case 1: {
                lllllllllllllIIIlllIlIlIIlllIlll.writeTextComponent(this.name);
                lllllllllllllIIIlllIlIlIIlllIlll.writeFloat(this.percent);
                lllllllllllllIIIlllIlIlIIlllIlll.writeEnumValue(this.color);
                lllllllllllllIIIlllIlIlIIlllIlll.writeEnumValue(this.overlay);
                lllllllllllllIIIlllIlIlIIlllIlll.writeByte(this.getFlags());
                break;
            }
            case 3: {
                lllllllllllllIIIlllIlIlIIlllIlll.writeFloat(this.percent);
                break;
            }
            case 4: {
                lllllllllllllIIIlllIlIlIIlllIlll.writeTextComponent(this.name);
                break;
            }
            case 5: {
                lllllllllllllIIIlllIlIlIIlllIlll.writeEnumValue(this.color);
                lllllllllllllIIIlllIlIlIIlllIlll.writeEnumValue(this.overlay);
                break;
            }
            case 6: {
                lllllllllllllIIIlllIlIlIIlllIlll.writeByte(this.getFlags());
                break;
            }
        }
    }
    
    public SPacketUpdateBossInfo() {
    }
    
    private int getFlags() {
        int lllllllllllllIIIlllIlIlIIlllIIll = 0;
        if (this.darkenSky) {
            lllllllllllllIIIlllIlIlIIlllIIll |= 0x1;
        }
        if (this.playEndBossMusic) {
            lllllllllllllIIIlllIlIlIIlllIIll |= 0x2;
        }
        if (this.createFog) {
            lllllllllllllIIIlllIlIlIIlllIIll |= 0x2;
        }
        return lllllllllllllIIIlllIlIlIIlllIIll;
    }
    
    public boolean shouldCreateFog() {
        return this.createFog;
    }
    
    public BossInfo.Color getColor() {
        return this.color;
    }
    
    public BossInfo.Overlay getOverlay() {
        return this.overlay;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIlllIlIlIlIIIIIll) throws IOException {
        this.uniqueId = lllllllllllllIIIlllIlIlIlIIIIIll.readUuid();
        this.operation = lllllllllllllIIIlllIlIlIlIIIIIll.readEnumValue(Operation.class);
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation()[this.operation.ordinal()]) {
            case 1: {
                this.name = lllllllllllllIIIlllIlIlIlIIIIIll.readTextComponent();
                this.percent = lllllllllllllIIIlllIlIlIlIIIIIll.readFloat();
                this.color = lllllllllllllIIIlllIlIlIlIIIIIll.readEnumValue(BossInfo.Color.class);
                this.overlay = lllllllllllllIIIlllIlIlIlIIIIIll.readEnumValue(BossInfo.Overlay.class);
                this.setFlags(lllllllllllllIIIlllIlIlIlIIIIIll.readUnsignedByte());
                break;
            }
            case 3: {
                this.percent = lllllllllllllIIIlllIlIlIlIIIIIll.readFloat();
                break;
            }
            case 4: {
                this.name = lllllllllllllIIIlllIlIlIlIIIIIll.readTextComponent();
                break;
            }
            case 5: {
                this.color = lllllllllllllIIIlllIlIlIlIIIIIll.readEnumValue(BossInfo.Color.class);
                this.overlay = lllllllllllllIIIlllIlIlIlIIIIIll.readEnumValue(BossInfo.Overlay.class);
                break;
            }
            case 6: {
                this.setFlags(lllllllllllllIIIlllIlIlIlIIIIIll.readUnsignedByte());
                break;
            }
        }
    }
    
    public boolean shouldPlayEndBossMusic() {
        return this.playEndBossMusic;
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIlllIlIlIIllIlIll) {
        lllllllllllllIIIlllIlIlIIllIlIll.handleUpdateEntityNBT(this);
    }
    
    public enum Operation
    {
        ADD("ADD", 0), 
        UPDATE_NAME("UPDATE_NAME", 3), 
        UPDATE_PCT("UPDATE_PCT", 2), 
        REMOVE("REMOVE", 1), 
        UPDATE_STYLE("UPDATE_STYLE", 4), 
        UPDATE_PROPERTIES("UPDATE_PROPERTIES", 5);
        
        private Operation(final String llllllllllllIlllllIlllIIIlllIlIl, final int llllllllllllIlllllIlllIIIlllIlII) {
        }
    }
}
