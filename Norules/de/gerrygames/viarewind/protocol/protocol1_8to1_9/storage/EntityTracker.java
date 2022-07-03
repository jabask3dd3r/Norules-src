package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.metadata.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public class EntityTracker extends StoredObject implements ClientEntityIdChangeListener
{
    private final /* synthetic */ Map<Integer, List<Integer>> vehicleMap;
    private /* synthetic */ int playerId;
    private final /* synthetic */ Map<Integer, Vector> entityOffsets;
    private final /* synthetic */ Map<Integer, List<Metadata>> metadataBuffer;
    private final /* synthetic */ Map<Integer, Entity1_10Types.EntityType> clientEntityTypes;
    private final /* synthetic */ Map<Integer, EntityReplacement> entityReplacements;
    private /* synthetic */ int playerGamemode;
    
    public List<Integer> getPassengers(final int lllllllllllllIIlllIllIIllllIIIll) {
        return this.vehicleMap.getOrDefault(lllllllllllllIIlllIllIIllllIIIll, new ArrayList<Integer>());
    }
    
    public int getPlayerGamemode() {
        return this.playerGamemode;
    }
    
    public boolean isPassenger(final int lllllllllllllIIlllIllIIllIIlllll, final int lllllllllllllIIlllIllIIllIIllllI) {
        return this.vehicleMap.containsKey(lllllllllllllIIlllIllIIllIIlllll) && this.vehicleMap.get(lllllllllllllIIlllIllIIllIIlllll).contains(lllllllllllllIIlllIllIIllIIllllI);
    }
    
    public void setEntityOffset(final int lllllllllllllIIlllIllIIlllllIIll, final short lllllllllllllIIlllIllIIlllllIIlI, final short lllllllllllllIIlllIllIIlllllIllI, final short lllllllllllllIIlllIllIIlllllIlIl) {
        this.entityOffsets.compute(lllllllllllllIIlllIllIIlllllIIll, (lllllllllllllIIlllIllIIllIIIIIIl, lllllllllllllIIlllIllIIlIlllllII) -> {
            if (lllllllllllllIIlllIllIIlIlllllII == null) {
                return new Vector(lllllllllllllIIlllIllIIlllllIIlI, lllllllllllllIIlllIllIIlllllIllI, lllllllllllllIIlllIllIIlllllIlIl);
            }
            else {
                lllllllllllllIIlllIllIIlIlllllII.setBlockX(lllllllllllllIIlllIllIIlllllIIlI);
                lllllllllllllIIlllIllIIlIlllllII.setBlockY(lllllllllllllIIlllIllIIlllllIllI);
                lllllllllllllIIlllIllIIlIlllllII.setBlockZ(lllllllllllllIIlllIllIIlllllIlIl);
                return lllllllllllllIIlllIllIIlIlllllII;
            }
        });
    }
    
    public void setPassengers(final int lllllllllllllIIlllIllIIlllIllIIl, final List<Integer> lllllllllllllIIlllIllIIlllIllIII) {
        this.vehicleMap.put(lllllllllllllIIlllIllIIlllIllIIl, lllllllllllllIIlllIllIIlllIllIII);
    }
    
    public EntityReplacement getEntityReplacement(final int lllllllllllllIIlllIllIIlllIIllII) {
        return this.entityReplacements.get(lllllllllllllIIlllIllIIlllIIllII);
    }
    
    public void removeEntity(final int lllllllllllllIIlllIllIlIIIIllIlI) {
        this.vehicleMap.remove(lllllllllllllIIlllIllIlIIIIllIlI);
        this.vehicleMap.forEach((lllllllllllllIIlllIllIIlIllIIlll, lllllllllllllIIlllIllIIlIllIIllI) -> lllllllllllllIIlllIllIIlIllIIllI.remove((Object)lllllllllllllIIlllIllIlIIIIllIlI));
        this.vehicleMap.entrySet().removeIf(lllllllllllllIIlllIllIIlIllIllII -> lllllllllllllIIlllIllIIlIllIllII.getValue().isEmpty());
        this.clientEntityTypes.remove(lllllllllllllIIlllIllIlIIIIllIlI);
        this.entityOffsets.remove(lllllllllllllIIlllIllIlIIIIllIlI);
        if (this.entityReplacements.containsKey(lllllllllllllIIlllIllIlIIIIllIlI)) {
            this.entityReplacements.remove(lllllllllllllIIlllIllIlIIIIllIlI).despawn();
        }
    }
    
    public List<Metadata> getBufferedMetadata(final int lllllllllllllIIlllIllIIllIlllIlI) {
        return this.metadataBuffer.get(lllllllllllllIIlllIllIIllIlllIlI);
    }
    
    public void resetEntityOffset(final int lllllllllllllIIlllIllIlIIIIlIlII) {
        this.entityOffsets.remove(lllllllllllllIIlllIllIlIIIIlIlII);
    }
    
    public boolean isInsideVehicle(final int lllllllllllllIIlllIllIIllIllIIIl) {
        for (final List<Integer> lllllllllllllIIlllIllIIllIllIlIl : this.vehicleMap.values()) {
            if (lllllllllllllIIlllIllIIllIllIlIl.contains(lllllllllllllIIlllIllIIllIllIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    public void addToEntityOffset(final int lllllllllllllIIlllIllIlIIIIIIlll, final short lllllllllllllIIlllIllIlIIIIIIllI, final short lllllllllllllIIlllIllIlIIIIIIlIl, final short lllllllllllllIIlllIllIIlllllllll) {
        this.entityOffsets.compute(lllllllllllllIIlllIllIlIIIIIIlll, (lllllllllllllIIlllIllIIlIlllIlII, lllllllllllllIIlllIllIIlIlllIIll) -> {
            if (lllllllllllllIIlllIllIIlIlllIIll == null) {
                return new Vector(lllllllllllllIIlllIllIlIIIIIIllI, lllllllllllllIIlllIllIlIIIIIIlIl, lllllllllllllIIlllIllIIlllllllll);
            }
            else {
                lllllllllllllIIlllIllIIlIlllIIll.setBlockX(lllllllllllllIIlllIllIIlIlllIIll.getBlockX() + lllllllllllllIIlllIllIlIIIIIIllI);
                lllllllllllllIIlllIllIIlIlllIIll.setBlockY(lllllllllllllIIlllIllIIlIlllIIll.getBlockY() + lllllllllllllIIlllIllIlIIIIIIlIl);
                lllllllllllllIIlllIllIIlIlllIIll.setBlockZ(lllllllllllllIIlllIllIIlIlllIIll.getBlockZ() + lllllllllllllIIlllIllIIlllllllll);
                return lllllllllllllIIlllIllIIlIlllIIll;
            }
        });
    }
    
    public void addEntityReplacement(final EntityReplacement lllllllllllllIIlllIllIIlllIlIIlI) {
        this.entityReplacements.put(lllllllllllllIIlllIllIIlllIlIIlI.getEntityId(), lllllllllllllIIlllIllIIlllIlIIlI);
    }
    
    public Map<Integer, Entity1_10Types.EntityType> getClientEntityTypes() {
        return this.clientEntityTypes;
    }
    
    public int getVehicle(final int lllllllllllllIIlllIllIIllIlIlIII) {
        for (final Map.Entry<Integer, List<Integer>> lllllllllllllIIlllIllIIllIlIlIlI : this.vehicleMap.entrySet()) {
            if (lllllllllllllIIlllIllIIllIlIlIlI.getValue().contains(lllllllllllllIIlllIllIIllIlIlIII)) {
                return lllllllllllllIIlllIllIIllIlIlIlI.getKey();
            }
        }
        return -1;
    }
    
    public Vector getEntityOffset(final int lllllllllllllIIlllIllIlIIIIlIIII) {
        return this.entityOffsets.computeIfAbsent(lllllllllllllIIlllIllIlIIIIlIIII, lllllllllllllIIlllIllIIlIllIlllI -> new Vector(0, 0, 0));
    }
    
    public void setEntityOffset(final int lllllllllllllIIlllIllIIllllIlIII, final Vector lllllllllllllIIlllIllIIllllIlIlI) {
        this.entityOffsets.put(lllllllllllllIIlllIllIIllllIlIII, lllllllllllllIIlllIllIIllllIlIlI);
    }
    
    @Override
    public void setClientEntityId(final int lllllllllllllIIlllIllIIllIIIlIll) {
        this.clientEntityTypes.remove(this.playerId);
        this.playerId = lllllllllllllIIlllIllIIllIIIlIll;
        this.clientEntityTypes.put(this.playerId, Entity1_10Types.EntityType.ENTITY_HUMAN);
    }
    
    public EntityTracker(final UserConnection lllllllllllllIIlllIllIlIIIllIlII) {
        super(lllllllllllllIIlllIllIlIIIllIlII);
        this.vehicleMap = new ConcurrentHashMap<Integer, List<Integer>>();
        this.clientEntityTypes = new ConcurrentHashMap<Integer, Entity1_10Types.EntityType>();
        this.metadataBuffer = new ConcurrentHashMap<Integer, List<Metadata>>();
        this.entityReplacements = new ConcurrentHashMap<Integer, EntityReplacement>();
        this.entityOffsets = new ConcurrentHashMap<Integer, Vector>();
        this.playerGamemode = 0;
    }
    
    public void setPlayerId(final int lllllllllllllIIlllIllIlIIIlIllII) {
        this.playerId = lllllllllllllIIlllIllIlIIIlIllII;
    }
    
    public void sendMetadataBuffer(final int lllllllllllllIIlllIllIIllIIlIIll) {
        if (!this.metadataBuffer.containsKey(lllllllllllllIIlllIllIIllIIlIIll)) {
            return;
        }
        if (this.entityReplacements.containsKey(lllllllllllllIIlllIllIIllIIlIIll)) {
            this.entityReplacements.get(lllllllllllllIIlllIllIIllIIlIIll).updateMetadata(this.metadataBuffer.remove(lllllllllllllIIlllIllIIllIIlIIll));
        }
        else {
            final PacketWrapper lllllllllllllIIlllIllIIllIIlIlIl = PacketWrapper.create(28, null, this.getUser());
            lllllllllllllIIlllIllIIllIIlIlIl.write(Type.VAR_INT, lllllllllllllIIlllIllIIllIIlIIll);
            lllllllllllllIIlllIllIIllIIlIlIl.write(Types1_8.METADATA_LIST, this.metadataBuffer.get(lllllllllllllIIlllIllIIllIIlIIll));
            MetadataRewriter.transform(this.getClientEntityTypes().get(lllllllllllllIIlllIllIIllIIlIIll), this.metadataBuffer.get(lllllllllllllIIlllIllIIllIIlIIll));
            if (!this.metadataBuffer.get(lllllllllllllIIlllIllIIllIIlIIll).isEmpty()) {
                try {
                    lllllllllllllIIlllIllIIllIIlIlIl.send(Protocol1_8TO1_9.class);
                }
                catch (Exception lllllllllllllIIlllIllIIllIIlIllI) {
                    lllllllllllllIIlllIllIIllIIlIllI.printStackTrace();
                }
            }
            this.metadataBuffer.remove(lllllllllllllIIlllIllIIllIIlIIll);
        }
    }
    
    public void setPlayerGamemode(final int lllllllllllllIIlllIllIlIIIlIIIlI) {
        this.playerGamemode = lllllllllllllIIlllIllIlIIIlIIIlI;
    }
    
    public int getPlayerId() {
        return this.playerId;
    }
    
    public void addMetadataToBuffer(final int lllllllllllllIIlllIllIIlllIIIIIl, final List<Metadata> lllllllllllllIIlllIllIIlllIIIIll) {
        if (this.metadataBuffer.containsKey(lllllllllllllIIlllIllIIlllIIIIIl)) {
            this.metadataBuffer.get(lllllllllllllIIlllIllIIlllIIIIIl).addAll(lllllllllllllIIlllIllIIlllIIIIll);
        }
        else if (!lllllllllllllIIlllIllIIlllIIIIll.isEmpty()) {
            this.metadataBuffer.put(lllllllllllllIIlllIllIIlllIIIIIl, lllllllllllllIIlllIllIIlllIIIIll);
        }
    }
}
