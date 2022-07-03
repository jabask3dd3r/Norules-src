package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import com.mojang.authlib.properties.*;
import java.io.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import com.mojang.authlib.*;
import net.minecraft.world.*;
import net.minecraft.util.text.*;
import net.minecraft.network.*;
import com.google.common.base.*;
import javax.annotation.*;

public class SPacketPlayerListItem implements Packet<INetHandlerPlayClient>
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
    private final /* synthetic */ List<AddPlayerData> players;
    private /* synthetic */ Action action;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIIIlllIlIlIIlII) throws IOException {
        llllllllllllllIlIIIIlllIlIlIIlII.writeEnumValue(this.action);
        llllllllllllllIlIIIIlllIlIlIIlII.writeVarIntToBuffer(this.players.size());
        for (final AddPlayerData llllllllllllllIlIIIIlllIlIlIIIll : this.players) {
            switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action()[this.action.ordinal()]) {
                case 1: {
                    llllllllllllllIlIIIIlllIlIlIIlII.writeUuid(llllllllllllllIlIIIIlllIlIlIIIll.getProfile().getId());
                    llllllllllllllIlIIIIlllIlIlIIlII.writeString(llllllllllllllIlIIIIlllIlIlIIIll.getProfile().getName());
                    llllllllllllllIlIIIIlllIlIlIIlII.writeVarIntToBuffer(llllllllllllllIlIIIIlllIlIlIIIll.getProfile().getProperties().size());
                    for (final Property llllllllllllllIlIIIIlllIlIlIIIlI : llllllllllllllIlIIIIlllIlIlIIIll.getProfile().getProperties().values()) {
                        llllllllllllllIlIIIIlllIlIlIIlII.writeString(llllllllllllllIlIIIIlllIlIlIIIlI.getName());
                        llllllllllllllIlIIIIlllIlIlIIlII.writeString(llllllllllllllIlIIIIlllIlIlIIIlI.getValue());
                        if (llllllllllllllIlIIIIlllIlIlIIIlI.hasSignature()) {
                            llllllllllllllIlIIIIlllIlIlIIlII.writeBoolean(true);
                            llllllllllllllIlIIIIlllIlIlIIlII.writeString(llllllllllllllIlIIIIlllIlIlIIIlI.getSignature());
                        }
                        else {
                            llllllllllllllIlIIIIlllIlIlIIlII.writeBoolean(false);
                        }
                    }
                    llllllllllllllIlIIIIlllIlIlIIlII.writeVarIntToBuffer(llllllllllllllIlIIIIlllIlIlIIIll.getGameMode().getID());
                    llllllllllllllIlIIIIlllIlIlIIlII.writeVarIntToBuffer(llllllllllllllIlIIIIlllIlIlIIIll.getPing());
                    if (llllllllllllllIlIIIIlllIlIlIIIll.getDisplayName() == null) {
                        llllllllllllllIlIIIIlllIlIlIIlII.writeBoolean(false);
                        continue;
                    }
                    llllllllllllllIlIIIIlllIlIlIIlII.writeBoolean(true);
                    llllllllllllllIlIIIIlllIlIlIIlII.writeTextComponent(llllllllllllllIlIIIIlllIlIlIIIll.getDisplayName());
                    continue;
                }
                case 4: {
                    llllllllllllllIlIIIIlllIlIlIIlII.writeUuid(llllllllllllllIlIIIIlllIlIlIIIll.getProfile().getId());
                    if (llllllllllllllIlIIIIlllIlIlIIIll.getDisplayName() == null) {
                        llllllllllllllIlIIIIlllIlIlIIlII.writeBoolean(false);
                        continue;
                    }
                    llllllllllllllIlIIIIlllIlIlIIlII.writeBoolean(true);
                    llllllllllllllIlIIIIlllIlIlIIlII.writeTextComponent(llllllllllllllIlIIIIlllIlIlIIIll.getDisplayName());
                    continue;
                }
                default: {
                    continue;
                }
                case 2: {
                    llllllllllllllIlIIIIlllIlIlIIlII.writeUuid(llllllllllllllIlIIIIlllIlIlIIIll.getProfile().getId());
                    llllllllllllllIlIIIIlllIlIlIIlII.writeVarIntToBuffer(llllllllllllllIlIIIIlllIlIlIIIll.getGameMode().getID());
                    continue;
                }
                case 3: {
                    llllllllllllllIlIIIIlllIlIlIIlII.writeUuid(llllllllllllllIlIIIIlllIlIlIIIll.getProfile().getId());
                    llllllllllllllIlIIIIlllIlIlIIlII.writeVarIntToBuffer(llllllllllllllIlIIIIlllIlIlIIIll.getPing());
                    continue;
                }
                case 5: {
                    llllllllllllllIlIIIIlllIlIlIIlII.writeUuid(llllllllllllllIlIIIIlllIlIlIIIll.getProfile().getId());
                    continue;
                }
            }
        }
    }
    
    public SPacketPlayerListItem() {
        this.players = (List<AddPlayerData>)Lists.newArrayList();
    }
    
    public SPacketPlayerListItem(final Action llllllllllllllIlIIIIlllIlllIIIll, final EntityPlayerMP... llllllllllllllIlIIIIlllIlllIIIlI) {
        this.players = (List<AddPlayerData>)Lists.newArrayList();
        this.action = llllllllllllllIlIIIIlllIlllIIIll;
        final long llllllllllllllIlIIIIlllIllIllllI = (Object)llllllllllllllIlIIIIlllIlllIIIlI;
        for (double llllllllllllllIlIIIIlllIllIlllll = llllllllllllllIlIIIIlllIlllIIIlI.length, llllllllllllllIlIIIIlllIlllIIIII = 0; llllllllllllllIlIIIIlllIlllIIIII < llllllllllllllIlIIIIlllIllIlllll; ++llllllllllllllIlIIIIlllIlllIIIII) {
            final EntityPlayerMP llllllllllllllIlIIIIlllIlllIIlIl = llllllllllllllIlIIIIlllIllIllllI[llllllllllllllIlIIIIlllIlllIIIII];
            this.players.add(new AddPlayerData(llllllllllllllIlIIIIlllIlllIIlIl.getGameProfile(), llllllllllllllIlIIIIlllIlllIIlIl.ping, llllllllllllllIlIIIIlllIlllIIlIl.interactionManager.getGameType(), llllllllllllllIlIIIIlllIlllIIlIl.getTabListDisplayName()));
        }
    }
    
    public SPacketPlayerListItem(final Action llllllllllllllIlIIIIlllIllIlIIll, final Iterable<EntityPlayerMP> llllllllllllllIlIIIIlllIllIlIllI) {
        this.players = (List<AddPlayerData>)Lists.newArrayList();
        this.action = llllllllllllllIlIIIIlllIllIlIIll;
        for (final EntityPlayerMP llllllllllllllIlIIIIlllIllIlIlIl : llllllllllllllIlIIIIlllIllIlIllI) {
            this.players.add(new AddPlayerData(llllllllllllllIlIIIIlllIllIlIlIl.getGameProfile(), llllllllllllllIlIIIIlllIllIlIlIl.ping, llllllllllllllIlIIIIlllIllIlIlIl.interactionManager.getGameType(), llllllllllllllIlIIIIlllIllIlIlIl.getTabListDisplayName()));
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIIIlllIlIllIllI) throws IOException {
        this.action = llllllllllllllIlIIIIlllIlIllIllI.readEnumValue(Action.class);
        for (int llllllllllllllIlIIIIlllIllIIIIIl = llllllllllllllIlIIIIlllIlIllIllI.readVarIntFromBuffer(), llllllllllllllIlIIIIlllIllIIIIII = 0; llllllllllllllIlIIIIlllIllIIIIII < llllllllllllllIlIIIIlllIllIIIIIl; ++llllllllllllllIlIIIIlllIllIIIIII) {
            GameProfile llllllllllllllIlIIIIlllIlIllllll = null;
            int llllllllllllllIlIIIIlllIlIlllllI = 0;
            GameType llllllllllllllIlIIIIlllIlIllllIl = null;
            ITextComponent llllllllllllllIlIIIIlllIlIllllII = null;
            switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action()[this.action.ordinal()]) {
                case 1: {
                    llllllllllllllIlIIIIlllIlIllllll = new GameProfile(llllllllllllllIlIIIIlllIlIllIllI.readUuid(), llllllllllllllIlIIIIlllIlIllIllI.readStringFromBuffer(16));
                    for (int llllllllllllllIlIIIIlllIlIlllIll = llllllllllllllIlIIIIlllIlIllIllI.readVarIntFromBuffer(), llllllllllllllIlIIIIlllIlIlllIlI = 0; llllllllllllllIlIIIIlllIlIlllIlI < llllllllllllllIlIIIIlllIlIlllIll; ++llllllllllllllIlIIIIlllIlIlllIlI) {
                        final String llllllllllllllIlIIIIlllIlIlllIIl = llllllllllllllIlIIIIlllIlIllIllI.readStringFromBuffer(32767);
                        final String llllllllllllllIlIIIIlllIlIlllIII = llllllllllllllIlIIIIlllIlIllIllI.readStringFromBuffer(32767);
                        if (llllllllllllllIlIIIIlllIlIllIllI.readBoolean()) {
                            llllllllllllllIlIIIIlllIlIllllll.getProperties().put((Object)llllllllllllllIlIIIIlllIlIlllIIl, (Object)new Property(llllllllllllllIlIIIIlllIlIlllIIl, llllllllllllllIlIIIIlllIlIlllIII, llllllllllllllIlIIIIlllIlIllIllI.readStringFromBuffer(32767)));
                        }
                        else {
                            llllllllllllllIlIIIIlllIlIllllll.getProperties().put((Object)llllllllllllllIlIIIIlllIlIlllIIl, (Object)new Property(llllllllllllllIlIIIIlllIlIlllIIl, llllllllllllllIlIIIIlllIlIlllIII));
                        }
                    }
                    llllllllllllllIlIIIIlllIlIllllIl = GameType.getByID(llllllllllllllIlIIIIlllIlIllIllI.readVarIntFromBuffer());
                    llllllllllllllIlIIIIlllIlIlllllI = llllllllllllllIlIIIIlllIlIllIllI.readVarIntFromBuffer();
                    if (llllllllllllllIlIIIIlllIlIllIllI.readBoolean()) {
                        llllllllllllllIlIIIIlllIlIllllII = llllllllllllllIlIIIIlllIlIllIllI.readTextComponent();
                        break;
                    }
                    break;
                }
                case 2: {
                    llllllllllllllIlIIIIlllIlIllllll = new GameProfile(llllllllllllllIlIIIIlllIlIllIllI.readUuid(), (String)null);
                    llllllllllllllIlIIIIlllIlIllllIl = GameType.getByID(llllllllllllllIlIIIIlllIlIllIllI.readVarIntFromBuffer());
                    break;
                }
                case 3: {
                    llllllllllllllIlIIIIlllIlIllllll = new GameProfile(llllllllllllllIlIIIIlllIlIllIllI.readUuid(), (String)null);
                    llllllllllllllIlIIIIlllIlIlllllI = llllllllllllllIlIIIIlllIlIllIllI.readVarIntFromBuffer();
                    break;
                }
                case 4: {
                    llllllllllllllIlIIIIlllIlIllllll = new GameProfile(llllllllllllllIlIIIIlllIlIllIllI.readUuid(), (String)null);
                    if (llllllllllllllIlIIIIlllIlIllIllI.readBoolean()) {
                        llllllllllllllIlIIIIlllIlIllllII = llllllllllllllIlIIIIlllIlIllIllI.readTextComponent();
                        break;
                    }
                    break;
                }
                case 5: {
                    llllllllllllllIlIIIIlllIlIllllll = new GameProfile(llllllllllllllIlIIIIlllIlIllIllI.readUuid(), (String)null);
                    break;
                }
            }
            this.players.add(new AddPlayerData(llllllllllllllIlIIIIlllIlIllllll, llllllllllllllIlIIIIlllIlIlllllI, llllllllllllllIlIIIIlllIlIllllIl, llllllllllllllIlIIIIlllIlIllllII));
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIIIIlllIlIIllIII) {
        llllllllllllllIlIIIIlllIlIIllIII.handlePlayerListItem(this);
    }
    
    public Action getAction() {
        return this.action;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action = SPacketPlayerListItem.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
        }
        final double llllllllllllllIlIIIIlllIlIIIIlll = (Object)new int[Action.values().length];
        try {
            llllllllllllllIlIIIIlllIlIIIIlll[Action.ADD_PLAYER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIIIIlllIlIIIIlll[Action.REMOVE_PLAYER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIIIIlllIlIIIIlll[Action.UPDATE_DISPLAY_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlIIIIlllIlIIIIlll[Action.UPDATE_GAME_MODE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIlIIIIlllIlIIIIlll[Action.UPDATE_LATENCY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return SPacketPlayerListItem.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action = (int[])(Object)llllllllllllllIlIIIIlllIlIIIIlll;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("action", (Object)this.action).add("entries", (Object)this.players).toString();
    }
    
    public List<AddPlayerData> getEntries() {
        return this.players;
    }
    
    public enum Action
    {
        UPDATE_DISPLAY_NAME("UPDATE_DISPLAY_NAME", 3), 
        ADD_PLAYER("ADD_PLAYER", 0), 
        REMOVE_PLAYER("REMOVE_PLAYER", 4), 
        UPDATE_LATENCY("UPDATE_LATENCY", 2), 
        UPDATE_GAME_MODE("UPDATE_GAME_MODE", 1);
        
        private Action(final String lllllllllllllIlIIlIIlIllIllIlllI, final int lllllllllllllIlIIlIIlIllIllIllIl) {
        }
    }
    
    public class AddPlayerData
    {
        private final /* synthetic */ ITextComponent displayName;
        private final /* synthetic */ GameProfile profile;
        private final /* synthetic */ int ping;
        private final /* synthetic */ GameType gamemode;
        
        @Override
        public String toString() {
            return MoreObjects.toStringHelper((Object)this).add("latency", this.ping).add("gameMode", (Object)this.gamemode).add("profile", (Object)this.profile).add("displayName", (Object)((this.displayName == null) ? null : ITextComponent.Serializer.componentToJson(this.displayName))).toString();
        }
        
        public GameType getGameMode() {
            return this.gamemode;
        }
        
        public int getPing() {
            return this.ping;
        }
        
        public GameProfile getProfile() {
            return this.profile;
        }
        
        public AddPlayerData(final GameProfile lllllllllllllIIIIllIIllIlIlIlIIl, final int lllllllllllllIIIIllIIllIlIlIlIII, @Nullable final GameType lllllllllllllIIIIllIIllIlIlIllIl, final ITextComponent lllllllllllllIIIIllIIllIlIlIllII) {
            this.profile = lllllllllllllIIIIllIIllIlIlIlIIl;
            this.ping = lllllllllllllIIIIllIIllIlIlIlIII;
            this.gamemode = lllllllllllllIIIIllIIllIlIlIllIl;
            this.displayName = lllllllllllllIIIIllIIllIlIlIllII;
        }
        
        @Nullable
        public ITextComponent getDisplayName() {
            return this.displayName;
        }
    }
}
