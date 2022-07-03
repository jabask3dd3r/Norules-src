package com.viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.chat.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.google.common.collect.*;
import com.google.common.cache.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.legacy.bossbar.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata.*;

public class EntityTracker1_9 extends EntityTrackerBase
{
    private final /* synthetic */ Set<Integer> validBlocking;
    private final /* synthetic */ Map<Integer, Integer> vehicleMap;
    private /* synthetic */ GameMode gameMode;
    private /* synthetic */ Position currentlyDigging;
    private /* synthetic */ boolean autoTeam;
    private final /* synthetic */ Map<Integer, BossBar> bossBarMap;
    private final /* synthetic */ Map<Integer, List<Metadata>> metadataBuffer;
    private final /* synthetic */ Set<Integer> knownHolograms;
    private /* synthetic */ boolean blocking;
    private /* synthetic */ Item itemInSecondHand;
    private /* synthetic */ boolean teamExists;
    private final /* synthetic */ Set<Position> blockInteractions;
    private final /* synthetic */ Map<Integer, UUID> uuidMap;
    private /* synthetic */ String currentTeam;
    private /* synthetic */ int heldItemSlot;
    
    public int getProvidedEntityId() {
        try {
            return Via.getManager().getProviders().get(EntityIdProvider.class).getEntityId(this.user());
        }
        catch (Exception llllllllllllllIIllIllIlIIIlIllll) {
            return this.clientEntityId();
        }
    }
    
    public Map<Integer, BossBar> getBossBarMap() {
        return this.bossBarMap;
    }
    
    public boolean interactedBlockRecently(final int llllllllllllllIIllIllIlIlIIlllII, final int llllllllllllllIIllIllIlIlIIllIll, final int llllllllllllllIIllIllIlIlIIllIlI) {
        return this.blockInteractions.contains(new Position(llllllllllllllIIllIllIlIlIIlllII, (short)llllllllllllllIIllIllIlIlIIllIll, llllllllllllllIIllIllIlIlIIllIlI));
    }
    
    public Map<Integer, List<Metadata>> getMetadataBuffer() {
        return this.metadataBuffer;
    }
    
    public EntityTracker1_9(final UserConnection llllllllllllllIIllIllIlIllIllllI) {
        super(llllllllllllllIIllIllIlIllIllllI, Entity1_10Types.EntityType.PLAYER);
        this.uuidMap = new ConcurrentHashMap<Integer, UUID>();
        this.metadataBuffer = new ConcurrentHashMap<Integer, List<Metadata>>();
        this.vehicleMap = new ConcurrentHashMap<Integer, Integer>();
        this.bossBarMap = new ConcurrentHashMap<Integer, BossBar>();
        this.validBlocking = (Set<Integer>)Sets.newConcurrentHashSet();
        this.knownHolograms = (Set<Integer>)Sets.newConcurrentHashSet();
        this.blockInteractions = Collections.newSetFromMap((Map<Position, Boolean>)CacheBuilder.newBuilder().maximumSize(1000L).expireAfterAccess(250L, TimeUnit.MILLISECONDS).build().asMap());
        this.blocking = false;
        this.autoTeam = false;
        this.currentlyDigging = null;
        this.teamExists = false;
        this.itemInSecondHand = null;
    }
    
    public boolean hasSwordInHand() {
        final InventoryTracker llllllllllllllIIllIllIlIlIllIIIl = this.user().get(InventoryTracker.class);
        final int llllllllllllllIIllIllIlIlIllIIII = this.heldItemSlot + 36;
        final int llllllllllllllIIllIllIlIlIlIllll = llllllllllllllIIllIllIlIlIllIIIl.getItemId((short)0, (short)llllllllllllllIIllIllIlIlIllIIII);
        return Protocol1_9To1_8.isSword(llllllllllllllIIllIllIlIlIlIllll);
    }
    
    public void setAutoTeam(final boolean llllllllllllllIIllIllIlIIIIIIlll) {
        this.autoTeam = llllllllllllllIIllIllIlIIIIIIlll;
    }
    
    public void setCurrentTeam(final String llllllllllllllIIllIllIIllllIIlll) {
        this.currentTeam = llllllllllllllIIllIllIIllllIIlll;
    }
    
    public Metadata getMetaByIndex(final List<Metadata> llllllllllllllIIllIllIlIIlIlllll, final int llllllllllllllIIllIllIlIIllIIIII) {
        for (final Metadata llllllllllllllIIllIllIlIIllIIIll : llllllllllllllIIllIllIlIIlIlllll) {
            if (llllllllllllllIIllIllIlIIllIIIII == llllllllllllllIIllIllIlIIllIIIll.id()) {
                return llllllllllllllIIllIllIlIIllIIIll;
            }
        }
        return null;
    }
    
    public Item getItemInSecondHand() {
        return this.itemInSecondHand;
    }
    
    public Set<Position> getBlockInteractions() {
        return this.blockInteractions;
    }
    
    public boolean isBlocking() {
        return this.blocking;
    }
    
    public boolean isTeamExists() {
        return this.teamExists;
    }
    
    public void syncShieldWithSword() {
        final boolean llllllllllllllIIllIllIlIlIlllIIl = this.hasSwordInHand();
        if (!llllllllllllllIIllIllIlIlIlllIIl || this.itemInSecondHand == null) {
            this.setSecondHand(llllllllllllllIIllIllIlIlIlllIIl ? new DataItem(442, (byte)1, (short)0, null) : null);
        }
    }
    
    public void addMetadataToBuffer(final int llllllllllllllIIllIllIlIIlIIIIll, final List<Metadata> llllllllllllllIIllIllIlIIlIIIllI) {
        final List<Metadata> llllllllllllllIIllIllIlIIlIIIlIl = this.metadataBuffer.get(llllllllllllllIIllIllIlIIlIIIIll);
        if (llllllllllllllIIllIllIlIIlIIIlIl != null) {
            llllllllllllllIIllIllIlIIlIIIlIl.addAll(llllllllllllllIIllIllIlIIlIIIllI);
        }
        else {
            this.metadataBuffer.put(llllllllllllllIIllIllIlIIlIIIIll, llllllllllllllIIllIllIlIIlIIIllI);
        }
    }
    
    public Set<Integer> getValidBlocking() {
        return this.validBlocking;
    }
    
    public void setCurrentlyDigging(final Position llllllllllllllIIllIllIIlllllllII) {
        this.currentlyDigging = llllllllllllllIIllIllIIlllllllII;
    }
    
    public void setGameMode(final GameMode llllllllllllllIIllIllIIlllllIIII) {
        this.gameMode = llllllllllllllIIllIllIIlllllIIII;
    }
    
    public void addBlockInteraction(final Position llllllllllllllIIllIllIlIlIIlIIlI) {
        this.blockInteractions.add(llllllllllllllIIllIllIlIlIIlIIlI);
    }
    
    public void setBlocking(final boolean llllllllllllllIIllIllIlIIIIlIIII) {
        this.blocking = llllllllllllllIIllIllIlIIIIlIIII;
    }
    
    public void setSecondHand(final int llllllllllllllIIllIllIlIllIIIIll, final Item llllllllllllllIIllIllIlIllIIIIlI) {
        final PacketWrapper llllllllllllllIIllIllIlIllIIIlIl = PacketWrapper.create(ClientboundPackets1_9.ENTITY_EQUIPMENT, null, this.user());
        llllllllllllllIIllIllIlIllIIIlIl.write(Type.VAR_INT, llllllllllllllIIllIllIlIllIIIIll);
        llllllllllllllIIllIllIlIllIIIlIl.write(Type.VAR_INT, 1);
        final PacketWrapper packetWrapper = llllllllllllllIIllIllIlIllIIIlIl;
        final Type<Item> item = Type.ITEM;
        this.itemInSecondHand = llllllllllllllIIllIllIlIllIIIIlI;
        packetWrapper.write(item, llllllllllllllIIllIllIlIllIIIIlI);
        try {
            llllllllllllllIIllIllIlIllIIIlIl.scheduleSend(Protocol1_9To1_8.class);
        }
        catch (Exception llllllllllllllIIllIllIlIllIIlIIl) {
            llllllllllllllIIllIllIlIllIIlIIl.printStackTrace();
        }
    }
    
    public void setHeldItemSlot(final int llllllllllllllIIllIllIIllllIIIIl) {
        this.heldItemSlot = llllllllllllllIIllIllIIllllIIIIl;
    }
    
    public GameMode getGameMode() {
        return this.gameMode;
    }
    
    public void handleMetadata(final int llllllllllllllIIllIllIlIIlllIIIl, final List<Metadata> llllllllllllllIIllIllIlIIlllIlII) {
        final EntityType llllllllllllllIIllIllIlIIlllIIll = this.entityType(llllllllllllllIIllIllIlIIlllIIIl);
        if (llllllllllllllIIllIllIlIIlllIIll == null) {
            return;
        }
        for (final Metadata llllllllllllllIIllIllIlIIlllIlll : new ArrayList(llllllllllllllIIllIllIlIIlllIlII)) {
            if (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.WITHER && llllllllllllllIIllIllIlIIlllIlll.id() == 10) {
                llllllllllllllIIllIllIlIIlllIlII.remove(llllllllllllllIIllIllIlIIlllIlll);
            }
            if (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.ENDER_DRAGON && llllllllllllllIIllIllIlIIlllIlll.id() == 11) {
                llllllllllllllIIllIllIlIIlllIlII.remove(llllllllllllllIIllIllIlIIlllIlll);
            }
            if (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.SKELETON && this.getMetaByIndex(llllllllllllllIIllIllIlIIlllIlII, 12) == null) {
                llllllllllllllIIllIllIlIIlllIlII.add(new Metadata(12, MetaType1_9.Boolean, true));
            }
            if (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.HORSE && llllllllllllllIIllIllIlIIlllIlll.id() == 16 && (int)llllllllllllllIIllIllIlIIlllIlll.getValue() == Integer.MIN_VALUE) {
                llllllllllllllIIllIllIlIIlllIlll.setValue(0);
            }
            if (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.PLAYER) {
                if (llllllllllllllIIllIllIlIIlllIlll.id() == 0) {
                    final byte llllllllllllllIIllIllIlIlIIIIIll = (byte)llllllllllllllIIllIllIlIIlllIlll.getValue();
                    if (llllllllllllllIIllIllIlIIlllIIIl != this.getProvidedEntityId() && Via.getConfig().isShieldBlocking()) {
                        if ((llllllllllllllIIllIllIlIlIIIIIll & 0x10) == 0x10) {
                            if (this.validBlocking.contains(llllllllllllllIIllIllIlIIlllIIIl)) {
                                final Item llllllllllllllIIllIllIlIlIIIIlII = new DataItem(442, (byte)1, (short)0, null);
                                this.setSecondHand(llllllllllllllIIllIllIlIIlllIIIl, llllllllllllllIIllIllIlIlIIIIlII);
                            }
                            else {
                                this.setSecondHand(llllllllllllllIIllIllIlIIlllIIIl, null);
                            }
                        }
                        else {
                            this.setSecondHand(llllllllllllllIIllIllIlIIlllIIIl, null);
                        }
                    }
                }
                if (llllllllllllllIIllIllIlIIlllIlll.id() == 12 && Via.getConfig().isLeftHandedHandling()) {
                    llllllllllllllIIllIllIlIIlllIlII.add(new Metadata(13, MetaType1_9.Byte, (byte)((((byte)llllllllllllllIIllIllIlIIlllIlll.getValue() & 0x80) == 0x0) ? 1 : 0)));
                }
            }
            if (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.ARMOR_STAND && Via.getConfig().isHologramPatch() && llllllllllllllIIllIllIlIIlllIlll.id() == 0 && this.getMetaByIndex(llllllllllllllIIllIllIlIIlllIlII, 10) != null) {
                final Metadata llllllllllllllIIllIllIlIlIIIIIIl = this.getMetaByIndex(llllllllllllllIIllIllIlIIlllIlII, 10);
                final byte llllllllllllllIIllIllIlIlIIIIIII = (byte)llllllllllllllIIllIllIlIIlllIlll.getValue();
                final Metadata llllllllllllllIIllIllIlIIlllllll;
                final Metadata llllllllllllllIIllIllIlIIllllllI;
                if ((llllllllllllllIIllIllIlIlIIIIIII & 0x20) == 0x20 && ((byte)llllllllllllllIIllIllIlIlIIIIIIl.getValue() & 0x1) == 0x1 && (llllllllllllllIIllIllIlIIlllllll = this.getMetaByIndex(llllllllllllllIIllIllIlIIlllIlII, 2)) != null && !((String)llllllllllllllIIllIllIlIIlllllll.getValue()).isEmpty() && (llllllllllllllIIllIllIlIIllllllI = this.getMetaByIndex(llllllllllllllIIllIllIlIIlllIlII, 3)) != null && (boolean)llllllllllllllIIllIllIlIIllllllI.getValue() && !this.knownHolograms.contains(llllllllllllllIIllIllIlIIlllIIIl)) {
                    this.knownHolograms.add(llllllllllllllIIllIllIlIIlllIIIl);
                    try {
                        final PacketWrapper llllllllllllllIIllIllIlIlIIIIIlI = PacketWrapper.create(ClientboundPackets1_9.ENTITY_POSITION, null, this.user());
                        llllllllllllllIIllIllIlIlIIIIIlI.write(Type.VAR_INT, llllllllllllllIIllIllIlIIlllIIIl);
                        llllllllllllllIIllIllIlIlIIIIIlI.write(Type.SHORT, (Short)0);
                        llllllllllllllIIllIllIlIlIIIIIlI.write(Type.SHORT, (short)(128.0 * (Via.getConfig().getHologramYOffset() * 32.0)));
                        llllllllllllllIIllIllIlIlIIIIIlI.write(Type.SHORT, (Short)0);
                        llllllllllllllIIllIllIlIlIIIIIlI.write(Type.BOOLEAN, true);
                        llllllllllllllIIllIllIlIlIIIIIlI.scheduleSend(Protocol1_9To1_8.class);
                    }
                    catch (Exception ex) {}
                }
            }
            if (Via.getConfig().isBossbarPatch() && (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.ENDER_DRAGON || llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.WITHER)) {
                if (llllllllllllllIIllIllIlIIlllIlll.id() == 2) {
                    BossBar llllllllllllllIIllIllIlIIlllllIl = this.bossBarMap.get(llllllllllllllIIllIllIlIIlllIIIl);
                    String llllllllllllllIIllIllIlIIlllllII = (String)llllllllllllllIIllIllIlIIlllIlll.getValue();
                    llllllllllllllIIllIllIlIIlllllII = (llllllllllllllIIllIllIlIIlllllII.isEmpty() ? ((llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.ENDER_DRAGON) ? "Ender Dragon" : "Wither") : llllllllllllllIIllIllIlIIlllllII);
                    if (llllllllllllllIIllIllIlIIlllllIl == null) {
                        llllllllllllllIIllIllIlIIlllllIl = Via.getAPI().legacyAPI().createLegacyBossBar(llllllllllllllIIllIllIlIIlllllII, BossColor.PINK, BossStyle.SOLID);
                        this.bossBarMap.put(llllllllllllllIIllIllIlIIlllIIIl, llllllllllllllIIllIllIlIIlllllIl);
                        llllllllllllllIIllIllIlIIlllllIl.addConnection(this.user());
                        llllllllllllllIIllIllIlIIlllllIl.show();
                        Via.getManager().getProviders().get(BossBarProvider.class).handleAdd(this.user(), llllllllllllllIIllIllIlIIlllllIl.getId());
                    }
                    else {
                        llllllllllllllIIllIllIlIIlllllIl.setTitle(llllllllllllllIIllIllIlIIlllllII);
                    }
                }
                else {
                    if (llllllllllllllIIllIllIlIIlllIlll.id() != 6 || Via.getConfig().isBossbarAntiflicker()) {
                        continue;
                    }
                    BossBar llllllllllllllIIllIllIlIIllllIlI = this.bossBarMap.get(llllllllllllllIIllIllIlIIlllIIIl);
                    final float llllllllllllllIIllIllIlIIllllIIl = (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.ENDER_DRAGON) ? 200.0f : 300.0f;
                    final float llllllllllllllIIllIllIlIIllllIII = Math.max(0.0f, Math.min((float)llllllllllllllIIllIllIlIIlllIlll.getValue() / llllllllllllllIIllIllIlIIllllIIl, 1.0f));
                    if (llllllllllllllIIllIllIlIIllllIlI == null) {
                        final String llllllllllllllIIllIllIlIIllllIll = (llllllllllllllIIllIllIlIIlllIIll == Entity1_10Types.EntityType.ENDER_DRAGON) ? "Ender Dragon" : "Wither";
                        llllllllllllllIIllIllIlIIllllIlI = Via.getAPI().legacyAPI().createLegacyBossBar(llllllllllllllIIllIllIlIIllllIll, llllllllllllllIIllIllIlIIllllIII, BossColor.PINK, BossStyle.SOLID);
                        this.bossBarMap.put(llllllllllllllIIllIllIlIIlllIIIl, llllllllllllllIIllIllIlIIllllIlI);
                        llllllllllllllIIllIllIlIIllllIlI.addConnection(this.user());
                        llllllllllllllIIllIllIlIIllllIlI.show();
                        Via.getManager().getProviders().get(BossBarProvider.class).handleAdd(this.user(), llllllllllllllIIllIllIlIIllllIlI.getId());
                    }
                    else {
                        llllllllllllllIIllIllIlIIllllIlI.setHealth(llllllllllllllIIllIllIlIIllllIII);
                    }
                }
            }
        }
    }
    
    public Map<Integer, Integer> getVehicleMap() {
        return this.vehicleMap;
    }
    
    public void sendTeamPacket(final boolean llllllllllllllIIllIllIlIIlIlIlII, final boolean llllllllllllllIIllIllIlIIlIlIIll) {
        final PacketWrapper llllllllllllllIIllIllIlIIlIlIIlI = PacketWrapper.create(ClientboundPackets1_9.TEAMS, null, this.user());
        llllllllllllllIIllIllIlIIlIlIIlI.write(Type.STRING, "viaversion");
        if (llllllllllllllIIllIllIlIIlIlIlII) {
            if (!this.teamExists) {
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.BYTE, (Byte)0);
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.STRING, "viaversion");
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.STRING, "§f");
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.STRING, "");
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.BYTE, (Byte)0);
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.STRING, "");
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.STRING, "never");
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.BYTE, (Byte)15);
            }
            else {
                llllllllllllllIIllIllIlIIlIlIIlI.write(Type.BYTE, (Byte)3);
            }
            llllllllllllllIIllIllIlIIlIlIIlI.write(Type.STRING_ARRAY, new String[] { this.user().getProtocolInfo().getUsername() });
        }
        else {
            llllllllllllllIIllIllIlIIlIlIIlI.write(Type.BYTE, (Byte)1);
        }
        this.teamExists = llllllllllllllIIllIllIlIIlIlIlII;
        try {
            if (llllllllllllllIIllIllIlIIlIlIIll) {
                llllllllllllllIIllIllIlIIlIlIIlI.send(Protocol1_9To1_8.class);
            }
            else {
                llllllllllllllIIllIllIlIIlIlIIlI.scheduleSend(Protocol1_9To1_8.class);
            }
        }
        catch (Exception llllllllllllllIIllIllIlIIlIlIllI) {
            llllllllllllllIIllIllIlIIlIlIllI.printStackTrace();
        }
    }
    
    public Map<Integer, UUID> getUuidMap() {
        return this.uuidMap;
    }
    
    public Set<Integer> getKnownHolograms() {
        return this.knownHolograms;
    }
    
    public String getCurrentTeam() {
        return this.currentTeam;
    }
    
    public void setSecondHand(final Item llllllllllllllIIllIllIlIllIlIIIl) {
        this.setSecondHand(this.clientEntityId(), llllllllllllllIIllIllIlIllIlIIIl);
    }
    
    public boolean isAutoTeam() {
        return this.autoTeam;
    }
    
    @Override
    public void removeEntity(final int llllllllllllllIIllIllIlIlIlIIIll) {
        super.removeEntity(llllllllllllllIIllIllIlIlIlIIIll);
        this.vehicleMap.remove(llllllllllllllIIllIllIlIlIlIIIll);
        this.uuidMap.remove(llllllllllllllIIllIllIlIlIlIIIll);
        this.validBlocking.remove(llllllllllllllIIllIllIlIlIlIIIll);
        this.knownHolograms.remove(llllllllllllllIIllIllIlIlIlIIIll);
        this.metadataBuffer.remove(llllllllllllllIIllIllIlIlIlIIIll);
        final BossBar llllllllllllllIIllIllIlIlIlIIlIl = this.bossBarMap.remove(llllllllllllllIIllIllIlIlIlIIIll);
        if (llllllllllllllIIllIllIlIlIlIIlIl != null) {
            llllllllllllllIIllIllIlIlIlIIlIl.hide();
            Via.getManager().getProviders().get(BossBarProvider.class).handleRemove(this.user(), llllllllllllllIIllIllIlIlIlIIlIl.getId());
        }
    }
    
    public void sendMetadataBuffer(final int llllllllllllllIIllIllIlIIIllIlIl) {
        final List<Metadata> llllllllllllllIIllIllIlIIIllIlll = this.metadataBuffer.get(llllllllllllllIIllIllIlIIIllIlIl);
        if (llllllllllllllIIllIllIlIIIllIlll != null) {
            final PacketWrapper llllllllllllllIIllIllIlIIIlllIlI = PacketWrapper.create(ClientboundPackets1_9.ENTITY_METADATA, null, this.user());
            llllllllllllllIIllIllIlIIIlllIlI.write(Type.VAR_INT, llllllllllllllIIllIllIlIIIllIlIl);
            llllllllllllllIIllIllIlIIIlllIlI.write(Types1_9.METADATA_LIST, llllllllllllllIIllIllIlIIIllIlll);
            Via.getManager().getProtocolManager().getProtocol(Protocol1_9To1_8.class).get(MetadataRewriter1_9To1_8.class).handleMetadata(llllllllllllllIIllIllIlIIIllIlIl, llllllllllllllIIllIllIlIIIllIlll, this.user());
            this.handleMetadata(llllllllllllllIIllIllIlIIIllIlIl, llllllllllllllIIllIllIlIIIllIlll);
            if (!llllllllllllllIIllIllIlIIIllIlll.isEmpty()) {
                try {
                    llllllllllllllIIllIllIlIIIlllIlI.scheduleSend(Protocol1_9To1_8.class);
                }
                catch (Exception llllllllllllllIIllIllIlIIIlllIll) {
                    llllllllllllllIIllIllIlIIIlllIll.printStackTrace();
                }
            }
            this.metadataBuffer.remove(llllllllllllllIIllIllIlIIIllIlIl);
        }
    }
    
    public Position getCurrentlyDigging() {
        return this.currentlyDigging;
    }
    
    public UUID getEntityUUID(final int llllllllllllllIIllIllIlIllIllIIl) {
        UUID llllllllllllllIIllIllIlIllIllIII = this.uuidMap.get(llllllllllllllIIllIllIlIllIllIIl);
        if (llllllllllllllIIllIllIlIllIllIII == null) {
            llllllllllllllIIllIllIlIllIllIII = UUID.randomUUID();
            this.uuidMap.put(llllllllllllllIIllIllIlIllIllIIl, llllllllllllllIIllIllIlIllIllIII);
        }
        return llllllllllllllIIllIllIlIllIllIII;
    }
}
