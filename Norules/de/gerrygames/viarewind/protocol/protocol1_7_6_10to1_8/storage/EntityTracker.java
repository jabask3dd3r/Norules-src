package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.type.types.version.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata.*;
import java.util.*;

public class EntityTracker extends StoredObject implements ClientEntityIdChangeListener
{
    private final /* synthetic */ Map<UUID, Integer> playersByUniqueId;
    private final /* synthetic */ Map<Integer, List<Metadata>> metadataBuffer;
    private /* synthetic */ int gamemode;
    private final /* synthetic */ Map<Integer, UUID> playersByEntityId;
    private final /* synthetic */ Map<Integer, Entity1_10Types.EntityType> clientEntityTypes;
    private final /* synthetic */ Map<Integer, EntityReplacement> entityReplacements;
    private final /* synthetic */ Map<Integer, Integer> vehicles;
    private final /* synthetic */ Map<UUID, Item[]> playerEquipment;
    private /* synthetic */ int spectating;
    private /* synthetic */ int playerId;
    private /* synthetic */ int dimension;
    
    public boolean setSpectating(final int lllllllllllllIllllIlIIlIllIlIlll) {
        if (lllllllllllllIllllIlIIlIllIlIlll != this.playerId && this.getPassenger(lllllllllllllIllllIlIIlIllIlIlll) != -1) {
            final PacketWrapper lllllllllllllIllllIlIIlIllIllllI = PacketWrapper.create(11, null, this.getUser());
            lllllllllllllIllllIlIIlIllIllllI.write(Type.VAR_INT, this.playerId);
            lllllllllllllIllllIlIIlIllIllllI.write(Type.VAR_INT, 0);
            lllllllllllllIllllIlIIlIllIllllI.write(Type.VAR_INT, 0);
            final PacketWrapper lllllllllllllIllllIlIIlIllIlllIl = PacketWrapper.create(11, null, this.getUser());
            lllllllllllllIllllIlIIlIllIlllIl.write(Type.VAR_INT, this.playerId);
            lllllllllllllIllllIlIIlIllIlllIl.write(Type.VAR_INT, 1);
            lllllllllllllIllllIlIIlIllIlllIl.write(Type.VAR_INT, 0);
            PacketUtil.sendToServer(lllllllllllllIllllIlIIlIllIllllI, Protocol1_7_6_10TO1_8.class, true, true);
            this.setSpectating(this.playerId);
            return false;
        }
        if (this.spectating != lllllllllllllIllllIlIIlIllIlIlll && this.spectating != this.playerId) {
            final PacketWrapper lllllllllllllIllllIlIIlIllIlllII = PacketWrapper.create(27, null, this.getUser());
            lllllllllllllIllllIlIIlIllIlllII.write(Type.INT, this.playerId);
            lllllllllllllIllllIlIIlIllIlllII.write(Type.INT, -1);
            lllllllllllllIllllIlIIlIllIlllII.write(Type.BOOLEAN, false);
            PacketUtil.sendPacket(lllllllllllllIllllIlIIlIllIlllII, Protocol1_7_6_10TO1_8.class);
        }
        if ((this.spectating = lllllllllllllIllllIlIIlIllIlIlll) != this.playerId) {
            final PacketWrapper lllllllllllllIllllIlIIlIllIllIll = PacketWrapper.create(27, null, this.getUser());
            lllllllllllllIllllIlIIlIllIllIll.write(Type.INT, this.playerId);
            lllllllllllllIllllIlIIlIllIllIll.write(Type.INT, this.spectating);
            lllllllllllllIllllIlIIlIllIllIll.write(Type.BOOLEAN, false);
            PacketUtil.sendPacket(lllllllllllllIllllIlIIlIllIllIll, Protocol1_7_6_10TO1_8.class);
        }
        return true;
    }
    
    public Item[] getPlayerEquipment(final UUID lllllllllllllIllllIlIIllIIllllIl) {
        return this.playerEquipment.get(lllllllllllllIllllIlIIllIIllllIl);
    }
    
    public void setPassenger(final int lllllllllllllIllllIlIIlIlllIllII, final int lllllllllllllIllllIlIIlIlllIlIII) {
        if (lllllllllllllIllllIlIIlIlllIllII == this.spectating && this.spectating != this.playerId) {
            try {
                final PacketWrapper lllllllllllllIllllIlIIlIllllIIIl = PacketWrapper.create(11, null, this.getUser());
                lllllllllllllIllllIlIIlIllllIIIl.write(Type.VAR_INT, this.playerId);
                lllllllllllllIllllIlIIlIllllIIIl.write(Type.VAR_INT, 0);
                lllllllllllllIllllIlIIlIllllIIIl.write(Type.VAR_INT, 0);
                final PacketWrapper lllllllllllllIllllIlIIlIllllIIII = PacketWrapper.create(11, null, this.getUser());
                lllllllllllllIllllIlIIlIllllIIII.write(Type.VAR_INT, this.playerId);
                lllllllllllllIllllIlIIlIllllIIII.write(Type.VAR_INT, 1);
                lllllllllllllIllllIlIIlIllllIIII.write(Type.VAR_INT, 0);
                PacketUtil.sendToServer(lllllllllllllIllllIlIIlIllllIIIl, Protocol1_7_6_10TO1_8.class, true, true);
                this.setSpectating(this.playerId);
            }
            catch (Exception lllllllllllllIllllIlIIlIlllIllll) {
                lllllllllllllIllllIlIIlIlllIllll.printStackTrace();
            }
        }
        if (lllllllllllllIllllIlIIlIlllIllII == -1) {
            final int lllllllllllllIllllIlIIlIlllIlllI = this.getVehicle(lllllllllllllIllllIlIIlIlllIlIII);
            this.vehicles.remove(lllllllllllllIllllIlIIlIlllIlllI);
        }
        else if (lllllllllllllIllllIlIIlIlllIlIII == -1) {
            this.vehicles.remove(lllllllllllllIllllIlIIlIlllIllII);
        }
        else {
            this.vehicles.put(lllllllllllllIllllIlIIlIlllIllII, lllllllllllllIllllIlIIlIlllIlIII);
        }
    }
    
    public void clearEntities() {
        this.clientEntityTypes.clear();
        this.entityReplacements.clear();
        this.vehicles.clear();
        this.metadataBuffer.clear();
    }
    
    public EntityTracker(final UserConnection lllllllllllllIllllIlIIllIlIllllI) {
        super(lllllllllllllIllllIlIIllIlIllllI);
        this.clientEntityTypes = new ConcurrentHashMap<Integer, Entity1_10Types.EntityType>();
        this.metadataBuffer = new ConcurrentHashMap<Integer, List<Metadata>>();
        this.vehicles = new ConcurrentHashMap<Integer, Integer>();
        this.entityReplacements = new ConcurrentHashMap<Integer, EntityReplacement>();
        this.playersByEntityId = new HashMap<Integer, UUID>();
        this.playersByUniqueId = new HashMap<UUID, Integer>();
        this.playerEquipment = new HashMap<UUID, Item[]>();
        this.gamemode = 0;
        this.playerId = -1;
        this.spectating = -1;
        this.dimension = 0;
    }
    
    @Override
    public void setClientEntityId(final int lllllllllllllIllllIlIIlIlIllIIll) {
        if (this.spectating == this.playerId) {
            this.spectating = lllllllllllllIllllIlIIlIlIllIIll;
        }
        this.clientEntityTypes.remove(this.playerId);
        this.playerId = lllllllllllllIllllIlIIlIlIllIIll;
        this.clientEntityTypes.put(this.playerId, Entity1_10Types.EntityType.ENTITY_HUMAN);
    }
    
    public void removeEntity(final int lllllllllllllIllllIlIIllIlIllIII) {
        this.clientEntityTypes.remove(lllllllllllllIllllIlIIllIlIllIII);
        if (this.entityReplacements.containsKey(lllllllllllllIllllIlIIllIlIllIII)) {
            this.entityReplacements.remove(lllllllllllllIllllIlIIllIlIllIII).despawn();
        }
        if (this.playersByEntityId.containsKey(lllllllllllllIllllIlIIllIlIllIII)) {
            this.playersByUniqueId.remove(this.playersByEntityId.remove(lllllllllllllIllllIlIIllIlIllIII));
        }
    }
    
    public int getGamemode() {
        return this.gamemode;
    }
    
    public Map<Integer, Entity1_10Types.EntityType> getClientEntityTypes() {
        return this.clientEntityTypes;
    }
    
    public void addPlayer(final Integer lllllllllllllIllllIlIIllIlIlIIIl, final UUID lllllllllllllIllllIlIIllIlIIllIl) {
        this.playersByUniqueId.put(lllllllllllllIllllIlIIllIlIIllIl, lllllllllllllIllllIlIIllIlIlIIIl);
        this.playersByEntityId.put(lllllllllllllIllllIlIIllIlIlIIIl, lllllllllllllIllllIlIIllIlIIllIl);
    }
    
    public void sendMetadataBuffer(final int lllllllllllllIllllIlIIllIIIIlIlI) {
        if (!this.metadataBuffer.containsKey(lllllllllllllIllllIlIIllIIIIlIlI)) {
            return;
        }
        if (this.entityReplacements.containsKey(lllllllllllllIllllIlIIllIIIIlIlI)) {
            this.entityReplacements.get(lllllllllllllIllllIlIIllIIIIlIlI).updateMetadata(this.metadataBuffer.remove(lllllllllllllIllllIlIIllIIIIlIlI));
        }
        else {
            final Entity1_10Types.EntityType lllllllllllllIllllIlIIllIIIIllll = this.getClientEntityTypes().get(lllllllllllllIllllIlIIllIIIIlIlI);
            final PacketWrapper lllllllllllllIllllIlIIllIIIIlllI = PacketWrapper.create(28, null, this.getUser());
            lllllllllllllIllllIlIIllIIIIlllI.write(Type.VAR_INT, lllllllllllllIllllIlIIllIIIIlIlI);
            lllllllllllllIllllIlIIllIIIIlllI.write(Types1_8.METADATA_LIST, this.metadataBuffer.get(lllllllllllllIllllIlIIllIIIIlIlI));
            MetadataRewriter.transform(lllllllllllllIllllIlIIllIIIIllll, this.metadataBuffer.get(lllllllllllllIllllIlIIllIIIIlIlI));
            if (!this.metadataBuffer.get(lllllllllllllIllllIlIIllIIIIlIlI).isEmpty()) {
                PacketUtil.sendPacket(lllllllllllllIllllIlIIllIIIIlllI, Protocol1_7_6_10TO1_8.class);
            }
            this.metadataBuffer.remove(lllllllllllllIllllIlIIllIIIIlIlI);
        }
    }
    
    public int getPlayerId() {
        return this.playerId;
    }
    
    public void setGamemode(final int lllllllllllllIllllIlIIlIllIIlllI) {
        this.gamemode = lllllllllllllIllllIlIIlIllIIlllI;
    }
    
    public void addMetadataToBuffer(final int lllllllllllllIllllIlIIllIIlIlIlI, final List<Metadata> lllllllllllllIllllIlIIllIIlIIllI) {
        if (this.metadataBuffer.containsKey(lllllllllllllIllllIlIIllIIlIlIlI)) {
            this.metadataBuffer.get(lllllllllllllIllllIlIIllIIlIlIlI).addAll(lllllllllllllIllllIlIIllIIlIIllI);
        }
        else if (!lllllllllllllIllllIlIIllIIlIIllI.isEmpty()) {
            this.metadataBuffer.put(lllllllllllllIllllIlIIllIIlIlIlI, lllllllllllllIllllIlIIllIIlIIllI);
        }
    }
    
    public int getDimension() {
        return this.dimension;
    }
    
    public void setPlayerEquipment(final UUID lllllllllllllIllllIlIIllIIllIllI, final Item[] lllllllllllllIllllIlIIllIIllIlIl) {
        this.playerEquipment.put(lllllllllllllIllllIlIIllIIllIllI, lllllllllllllIllllIlIIllIIllIlIl);
    }
    
    public UUID getPlayerUUID(final int lllllllllllllIllllIlIIllIlIIIlll) {
        return this.playersByEntityId.get(lllllllllllllIllllIlIIllIlIIIlll);
    }
    
    public void setPlayerId(final int lllllllllllllIllllIlIIlIllIIIlIl) {
        this.spectating = lllllllllllllIllllIlIIlIllIIIlIl;
        this.playerId = lllllllllllllIllllIlIIlIllIIIlIl;
    }
    
    public void addEntityReplacement(final EntityReplacement lllllllllllllIllllIlIIllIIlIIIII) {
        this.entityReplacements.put(lllllllllllllIllllIlIIllIIlIIIII.getEntityId(), lllllllllllllIllllIlIIllIIlIIIII);
    }
    
    public void setDimension(final int lllllllllllllIllllIlIIlIlIllIlll) {
        this.dimension = lllllllllllllIllllIlIIlIlIllIlll;
    }
    
    public int getSpectating() {
        return this.spectating;
    }
    
    public int getPlayerEntityId(final UUID lllllllllllllIllllIlIIllIlIIIIIl) {
        return this.playersByUniqueId.getOrDefault(lllllllllllllIllllIlIIllIlIIIIIl, -1);
    }
    
    public int getVehicle(final int lllllllllllllIllllIlIIllIIIIIIIl) {
        for (final Map.Entry<Integer, Integer> lllllllllllllIllllIlIIllIIIIIIll : this.vehicles.entrySet()) {
            if (lllllllllllllIllllIlIIllIIIIIIll.getValue() == lllllllllllllIllllIlIIllIIIIIIIl) {
                return lllllllllllllIllllIlIIllIIIIIIll.getValue();
            }
        }
        return -1;
    }
    
    public EntityReplacement getEntityReplacement(final int lllllllllllllIllllIlIIllIIIllIlI) {
        return this.entityReplacements.get(lllllllllllllIllllIlIIllIIIllIlI);
    }
    
    public int getPassenger(final int lllllllllllllIllllIlIIlIllllIlll) {
        return this.vehicles.getOrDefault(lllllllllllllIllllIlIIlIllllIlll, -1);
    }
    
    public List<Metadata> getBufferedMetadata(final int lllllllllllllIllllIlIIllIIIlIllI) {
        return this.metadataBuffer.get(lllllllllllllIllllIlIIllIIIlIllI);
    }
}
