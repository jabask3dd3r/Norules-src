package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketCombatEvent implements Packet<INetHandlerPlayClient>
{
    public /* synthetic */ ITextComponent deathMessage;
    public /* synthetic */ int entityId;
    public /* synthetic */ Event eventType;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event;
    public /* synthetic */ int duration;
    public /* synthetic */ int playerId;
    
    public SPacketCombatEvent() {
    }
    
    public SPacketCombatEvent(final CombatTracker lllllllllllllllllllIllIIIlIIlIll, final Event lllllllllllllllllllIllIIIlIIllll, final boolean lllllllllllllllllllIllIIIlIIlllI) {
        this.eventType = lllllllllllllllllllIllIIIlIIllll;
        final EntityLivingBase lllllllllllllllllllIllIIIlIIllIl = lllllllllllllllllllIllIIIlIIlIll.getBestAttacker();
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event()[lllllllllllllllllllIllIIIlIIllll.ordinal()]) {
            case 2: {
                this.duration = lllllllllllllllllllIllIIIlIIlIll.getCombatDuration();
                this.entityId = ((lllllllllllllllllllIllIIIlIIllIl == null) ? -1 : lllllllllllllllllllIllIIIlIIllIl.getEntityId());
                break;
            }
            case 3: {
                this.playerId = lllllllllllllllllllIllIIIlIIlIll.getFighter().getEntityId();
                this.entityId = ((lllllllllllllllllllIllIIIlIIllIl == null) ? -1 : lllllllllllllllllllIllIIIlIIllIl.getEntityId());
                if (lllllllllllllllllllIllIIIlIIlllI) {
                    this.deathMessage = lllllllllllllllllllIllIIIlIIlIll.getDeathMessage();
                    break;
                }
                this.deathMessage = new TextComponentString("");
                break;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event = SPacketCombatEvent.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event;
        }
        final float lllllllllllllllllllIllIIIIllIIII = (Object)new int[Event.values().length];
        try {
            lllllllllllllllllllIllIIIIllIIII[Event.END_COMBAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllllIllIIIIllIIII[Event.ENTER_COMBAT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllllIllIIIIllIIII[Event.ENTITY_DIED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return SPacketCombatEvent.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketCombatEvent$Event = (int[])(Object)lllllllllllllllllllIllIIIIllIIII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllllllIllIIIIlllllI) throws IOException {
        lllllllllllllllllllIllIIIIlllllI.writeEnumValue(this.eventType);
        if (this.eventType == Event.END_COMBAT) {
            lllllllllllllllllllIllIIIIlllllI.writeVarIntToBuffer(this.duration);
            lllllllllllllllllllIllIIIIlllllI.writeInt(this.entityId);
        }
        else if (this.eventType == Event.ENTITY_DIED) {
            lllllllllllllllllllIllIIIIlllllI.writeVarIntToBuffer(this.playerId);
            lllllllllllllllllllIllIIIIlllllI.writeInt(this.entityId);
            lllllllllllllllllllIllIIIIlllllI.writeTextComponent(this.deathMessage);
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllllllIllIIIIlllIII) {
        lllllllllllllllllllIllIIIIlllIII.handleCombatEvent(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllllllIllIIIlIIIIlI) throws IOException {
        this.eventType = lllllllllllllllllllIllIIIlIIIIlI.readEnumValue(Event.class);
        if (this.eventType == Event.END_COMBAT) {
            this.duration = lllllllllllllllllllIllIIIlIIIIlI.readVarIntFromBuffer();
            this.entityId = lllllllllllllllllllIllIIIlIIIIlI.readInt();
        }
        else if (this.eventType == Event.ENTITY_DIED) {
            this.playerId = lllllllllllllllllllIllIIIlIIIIlI.readVarIntFromBuffer();
            this.entityId = lllllllllllllllllllIllIIIlIIIIlI.readInt();
            this.deathMessage = lllllllllllllllllllIllIIIlIIIIlI.readTextComponent();
        }
    }
    
    public SPacketCombatEvent(final CombatTracker lllllllllllllllllllIllIIIlIllIll, final Event lllllllllllllllllllIllIIIlIllIlI) {
        this(lllllllllllllllllllIllIIIlIllIll, lllllllllllllllllllIllIIIlIllIlI, true);
    }
    
    public enum Event
    {
        ENTER_COMBAT("ENTER_COMBAT", 0), 
        ENTITY_DIED("ENTITY_DIED", 2), 
        END_COMBAT("END_COMBAT", 1);
        
        private Event(final String lllllllllllllIIIIIIIlIlIlIlIIIIl, final int lllllllllllllIIIIIIIlIlIlIIlllll) {
        }
    }
}
