package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.world.border.*;
import net.minecraft.network.*;

public class SPacketWorldBorder implements Packet<INetHandlerPlayClient>
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action;
    private /* synthetic */ long timeUntilTarget;
    private /* synthetic */ double centerX;
    private /* synthetic */ int warningDistance;
    private /* synthetic */ int warningTime;
    private /* synthetic */ double centerZ;
    private /* synthetic */ Action action;
    private /* synthetic */ double targetSize;
    private /* synthetic */ int size;
    private /* synthetic */ double diameter;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIllIIllIIIIlIllIl) throws IOException {
        this.action = lllllllllllllIIIllIIllIIIIlIllIl.readEnumValue(Action.class);
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action()[this.action.ordinal()]) {
            case 1: {
                this.targetSize = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                break;
            }
            case 2: {
                this.diameter = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                this.targetSize = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                this.timeUntilTarget = lllllllllllllIIIllIIllIIIIlIllIl.readVarLong();
                break;
            }
            case 3: {
                this.centerX = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                this.centerZ = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                break;
            }
            case 6: {
                this.warningDistance = lllllllllllllIIIllIIllIIIIlIllIl.readVarIntFromBuffer();
                break;
            }
            case 5: {
                this.warningTime = lllllllllllllIIIllIIllIIIIlIllIl.readVarIntFromBuffer();
                break;
            }
            case 4: {
                this.centerX = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                this.centerZ = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                this.diameter = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                this.targetSize = lllllllllllllIIIllIIllIIIIlIllIl.readDouble();
                this.timeUntilTarget = lllllllllllllIIIllIIllIIIIlIllIl.readVarLong();
                this.size = lllllllllllllIIIllIIllIIIIlIllIl.readVarIntFromBuffer();
                this.warningDistance = lllllllllllllIIIllIIllIIIIlIllIl.readVarIntFromBuffer();
                this.warningTime = lllllllllllllIIIllIIllIIIIlIllIl.readVarIntFromBuffer();
                break;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action = SPacketWorldBorder.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action;
        }
        final byte lllllllllllllIIIllIIllIIIIIIIIIl = (Object)new int[Action.values().length];
        try {
            lllllllllllllIIIllIIllIIIIIIIIIl[Action.INITIALIZE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIllIIllIIIIIIIIIl[Action.LERP_SIZE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIllIIllIIIIIIIIIl[Action.SET_CENTER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIllIIllIIIIIIIIIl[Action.SET_SIZE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIllIIllIIIIIIIIIl[Action.SET_WARNING_BLOCKS.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIIllIIllIIIIIIIIIl[Action.SET_WARNING_TIME.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return SPacketWorldBorder.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action = (int[])(Object)lllllllllllllIIIllIIllIIIIIIIIIl;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIllIIllIIIIlIIlll) throws IOException {
        lllllllllllllIIIllIIllIIIIlIIlll.writeEnumValue(this.action);
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action()[this.action.ordinal()]) {
            case 1: {
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.targetSize);
                break;
            }
            case 2: {
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.diameter);
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.targetSize);
                lllllllllllllIIIllIIllIIIIlIIlll.writeVarLong(this.timeUntilTarget);
                break;
            }
            case 3: {
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.centerX);
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.centerZ);
                break;
            }
            case 6: {
                lllllllllllllIIIllIIllIIIIlIIlll.writeVarIntToBuffer(this.warningDistance);
                break;
            }
            case 5: {
                lllllllllllllIIIllIIllIIIIlIIlll.writeVarIntToBuffer(this.warningTime);
                break;
            }
            case 4: {
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.centerX);
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.centerZ);
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.diameter);
                lllllllllllllIIIllIIllIIIIlIIlll.writeDouble(this.targetSize);
                lllllllllllllIIIllIIllIIIIlIIlll.writeVarLong(this.timeUntilTarget);
                lllllllllllllIIIllIIllIIIIlIIlll.writeVarIntToBuffer(this.size);
                lllllllllllllIIIllIIllIIIIlIIlll.writeVarIntToBuffer(this.warningDistance);
                lllllllllllllIIIllIIllIIIIlIIlll.writeVarIntToBuffer(this.warningTime);
                break;
            }
        }
    }
    
    public void apply(final WorldBorder lllllllllllllIIIllIIllIIIIIlIIll) {
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketWorldBorder$Action()[this.action.ordinal()]) {
            case 1: {
                lllllllllllllIIIllIIllIIIIIlIIll.setTransition(this.targetSize);
                break;
            }
            case 2: {
                lllllllllllllIIIllIIllIIIIIlIIll.setTransition(this.diameter, this.targetSize, this.timeUntilTarget);
                break;
            }
            case 3: {
                lllllllllllllIIIllIIllIIIIIlIIll.setCenter(this.centerX, this.centerZ);
                break;
            }
            case 6: {
                lllllllllllllIIIllIIllIIIIIlIIll.setWarningDistance(this.warningDistance);
                break;
            }
            case 5: {
                lllllllllllllIIIllIIllIIIIIlIIll.setWarningTime(this.warningTime);
                break;
            }
            case 4: {
                lllllllllllllIIIllIIllIIIIIlIIll.setCenter(this.centerX, this.centerZ);
                if (this.timeUntilTarget > 0L) {
                    lllllllllllllIIIllIIllIIIIIlIIll.setTransition(this.diameter, this.targetSize, this.timeUntilTarget);
                }
                else {
                    lllllllllllllIIIllIIllIIIIIlIIll.setTransition(this.targetSize);
                }
                lllllllllllllIIIllIIllIIIIIlIIll.setSize(this.size);
                lllllllllllllIIIllIIllIIIIIlIIll.setWarningDistance(this.warningDistance);
                lllllllllllllIIIllIIllIIIIIlIIll.setWarningTime(this.warningTime);
                break;
            }
        }
    }
    
    public SPacketWorldBorder(final WorldBorder lllllllllllllIIIllIIllIIIIllIIlI, final Action lllllllllllllIIIllIIllIIIIllIlII) {
        this.action = lllllllllllllIIIllIIllIIIIllIlII;
        this.centerX = lllllllllllllIIIllIIllIIIIllIIlI.getCenterX();
        this.centerZ = lllllllllllllIIIllIIllIIIIllIIlI.getCenterZ();
        this.diameter = lllllllllllllIIIllIIllIIIIllIIlI.getDiameter();
        this.targetSize = lllllllllllllIIIllIIllIIIIllIIlI.getTargetSize();
        this.timeUntilTarget = lllllllllllllIIIllIIllIIIIllIIlI.getTimeUntilTarget();
        this.size = lllllllllllllIIIllIIllIIIIllIIlI.getSize();
        this.warningDistance = lllllllllllllIIIllIIllIIIIllIIlI.getWarningDistance();
        this.warningTime = lllllllllllllIIIllIIllIIIIllIIlI.getWarningTime();
    }
    
    public SPacketWorldBorder() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIllIIllIIIIlIIIIl) {
        lllllllllllllIIIllIIllIIIIlIIIIl.handleWorldBorder(this);
    }
    
    public enum Action
    {
        SET_WARNING_TIME("SET_WARNING_TIME", 4), 
        SET_CENTER("SET_CENTER", 2), 
        INITIALIZE("INITIALIZE", 3), 
        SET_SIZE("SET_SIZE", 0), 
        SET_WARNING_BLOCKS("SET_WARNING_BLOCKS", 5), 
        LERP_SIZE("LERP_SIZE", 1);
        
        private Action(final String lllllllllllllIllIlIlIIlIIllIIllI, final int lllllllllllllIllIlIlIIlIIllIIlIl) {
        }
    }
}
