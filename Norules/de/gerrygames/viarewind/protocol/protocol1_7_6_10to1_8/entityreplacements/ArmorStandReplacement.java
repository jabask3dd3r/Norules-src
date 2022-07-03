package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.entityreplacements;

import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import de.gerrygames.viarewind.utils.math.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;

public class ArmorStandReplacement implements EntityReplacement
{
    private /* synthetic */ UserConnection user;
    private /* synthetic */ float yaw;
    private /* synthetic */ float pitch;
    private /* synthetic */ boolean nameTagVisible;
    private /* synthetic */ boolean small;
    private /* synthetic */ double locY;
    private /* synthetic */ boolean invisible;
    private /* synthetic */ State currentState;
    private /* synthetic */ int entityId;
    private /* synthetic */ String name;
    private /* synthetic */ boolean marker;
    private /* synthetic */ double locZ;
    private static /* synthetic */ int ENTITY_ID;
    private /* synthetic */ float headYaw;
    private /* synthetic */ double locX;
    private /* synthetic */ int[] entityIds;
    private /* synthetic */ List<Metadata> datawatcher;
    
    @Override
    public void setYawPitch(final float lllllllllllllIIIIIIlIIIIlIlIlllI, final float lllllllllllllIIIIIIlIIIIlIlIllIl) {
        if ((this.yaw != lllllllllllllIIIIIIlIIIIlIlIlllI && this.pitch != lllllllllllllIIIIIIlIIIIlIlIllIl) || this.headYaw != lllllllllllllIIIIIIlIIIIlIlIlllI) {
            this.yaw = lllllllllllllIIIIIIlIIIIlIlIlllI;
            this.headYaw = lllllllllllllIIIIIIlIIIIlIlIlllI;
            this.pitch = lllllllllllllIIIIIIlIIIIlIlIllIl;
            this.updateLocation();
        }
    }
    
    static {
        ArmorStandReplacement.ENTITY_ID = 2147467647;
    }
    
    public void updateLocation() {
        if (this.entityIds == null) {
            return;
        }
        if (this.currentState == State.ZOMBIE) {
            final PacketWrapper lllllllllllllIIIIIIlIIIIlIIIIlII = PacketWrapper.create(24, null, this.user);
            lllllllllllllIIIIIIlIIIIlIIIIlII.write(Type.INT, this.entityId);
            lllllllllllllIIIIIIlIIIIlIIIIlII.write(Type.INT, (int)(this.locX * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIlII.write(Type.INT, (int)(this.locY * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIlII.write(Type.INT, (int)(this.locZ * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIlII.write(Type.BYTE, (byte)(this.yaw / 360.0f * 256.0f));
            lllllllllllllIIIIIIlIIIIlIIIIlII.write(Type.BYTE, (byte)(this.pitch / 360.0f * 256.0f));
            final PacketWrapper lllllllllllllIIIIIIlIIIIlIIIIIll = PacketWrapper.create(25, null, this.user);
            lllllllllllllIIIIIIlIIIIlIIIIIll.write(Type.INT, this.entityId);
            lllllllllllllIIIIIIlIIIIlIIIIIll.write(Type.BYTE, (byte)(this.headYaw / 360.0f * 256.0f));
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIlIIIIlII, Protocol1_7_6_10TO1_8.class, true, true);
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIlIIIIIll, Protocol1_7_6_10TO1_8.class, true, true);
        }
        else if (this.currentState == State.HOLOGRAM) {
            final PacketWrapper lllllllllllllIIIIIIlIIIIlIIIIIlI = PacketWrapper.create(27, null, this.user);
            lllllllllllllIIIIIIlIIIIlIIIIIlI.write(Type.INT, this.entityIds[1]);
            lllllllllllllIIIIIIlIIIIlIIIIIlI.write(Type.INT, -1);
            lllllllllllllIIIIIIlIIIIlIIIIIlI.write(Type.BOOLEAN, false);
            final PacketWrapper lllllllllllllIIIIIIlIIIIlIIIIIIl = PacketWrapper.create(24, null, this.user);
            lllllllllllllIIIIIIlIIIIlIIIIIIl.write(Type.INT, this.entityIds[0]);
            lllllllllllllIIIIIIlIIIIlIIIIIIl.write(Type.INT, (int)(this.locX * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIIIl.write(Type.INT, (int)((this.locY + (this.marker ? 54.85 : (this.small ? 56.0 : 57.0))) * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIIIl.write(Type.INT, (int)(this.locZ * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIIIl.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIlIIIIIIl.write(Type.BYTE, (Byte)0);
            final PacketWrapper lllllllllllllIIIIIIlIIIIlIIIIIII = PacketWrapper.create(24, null, this.user);
            lllllllllllllIIIIIIlIIIIlIIIIIII.write(Type.INT, this.entityIds[1]);
            lllllllllllllIIIIIIlIIIIlIIIIIII.write(Type.INT, (int)(this.locX * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIIII.write(Type.INT, (int)((this.locY + 56.75) * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIIII.write(Type.INT, (int)(this.locZ * 32.0));
            lllllllllllllIIIIIIlIIIIlIIIIIII.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIlIIIIIII.write(Type.BYTE, (Byte)0);
            final PacketWrapper lllllllllllllIIIIIIlIIIIIllllllI = PacketWrapper.create(27, null, this.user);
            lllllllllllllIIIIIIlIIIIIllllllI.write(Type.INT, this.entityIds[1]);
            lllllllllllllIIIIIIlIIIIIllllllI.write(Type.INT, this.entityIds[0]);
            lllllllllllllIIIIIIlIIIIIllllllI.write(Type.BOOLEAN, false);
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIlIIIIIlI, Protocol1_7_6_10TO1_8.class, true, true);
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIlIIIIIIl, Protocol1_7_6_10TO1_8.class, true, true);
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIlIIIIIII, Protocol1_7_6_10TO1_8.class, true, true);
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIIllllllI, Protocol1_7_6_10TO1_8.class, true, true);
        }
    }
    
    @Override
    public void setHeadYaw(final float lllllllllllllIIIIIIlIIIIlIlIIlII) {
        if (this.headYaw != lllllllllllllIIIIIIlIIIIlIlIIlII) {
            this.headYaw = lllllllllllllIIIIIIlIIIIlIlIIlII;
            this.updateLocation();
        }
    }
    
    @Override
    public void updateMetadata(final List<Metadata> lllllllllllllIIIIIIlIIIIlIIllIll) {
        for (final Metadata lllllllllllllIIIIIIlIIIIlIIlllll : lllllllllllllIIIIIIlIIIIlIIllIll) {
            this.datawatcher.removeIf(lllllllllllllIIIIIIlIIIIIIlIlIII -> lllllllllllllIIIIIIlIIIIIIlIlIII.id() == lllllllllllllIIIIIIlIIIIlIIlllll.id());
            this.datawatcher.add(lllllllllllllIIIIIIlIIIIlIIlllll);
        }
        this.updateState();
    }
    
    public void updateState() {
        byte lllllllllllllIIIIIIlIIIIlIIlIIIl = 0;
        byte lllllllllllllIIIIIIlIIIIlIIlIIII = 0;
        for (final Metadata lllllllllllllIIIIIIlIIIIlIIlIIll : this.datawatcher) {
            if (lllllllllllllIIIIIIlIIIIlIIlIIll.id() == 0 && lllllllllllllIIIIIIlIIIIlIIlIIll.metaType() == MetaType1_8.Byte) {
                lllllllllllllIIIIIIlIIIIlIIlIIIl = (byte)lllllllllllllIIIIIIlIIIIlIIlIIll.getValue();
            }
            else if (lllllllllllllIIIIIIlIIIIlIIlIIll.id() == 2 && lllllllllllllIIIIIIlIIIIlIIlIIll.metaType() == MetaType1_8.String) {
                this.name = (String)lllllllllllllIIIIIIlIIIIlIIlIIll.getValue();
                if (this.name == null || !this.name.equals("")) {
                    continue;
                }
                this.name = null;
            }
            else if (lllllllllllllIIIIIIlIIIIlIIlIIll.id() == 10 && lllllllllllllIIIIIIlIIIIlIIlIIll.metaType() == MetaType1_8.Byte) {
                lllllllllllllIIIIIIlIIIIlIIlIIII = (byte)lllllllllllllIIIIIIlIIIIlIIlIIll.getValue();
            }
            else {
                if (lllllllllllllIIIIIIlIIIIlIIlIIll.id() != 3 || lllllllllllllIIIIIIlIIIIlIIlIIll.metaType() != MetaType1_8.Byte) {
                    continue;
                }
                this.nameTagVisible = ((byte)lllllllllllllIIIIIIlIIIIlIIlIIll.id() != 0);
            }
        }
        this.invisible = ((lllllllllllllIIIIIIlIIIIlIIlIIIl & 0x20) != 0x0);
        this.small = ((lllllllllllllIIIIIIlIIIIlIIlIIII & 0x1) != 0x0);
        this.marker = ((lllllllllllllIIIIIIlIIIIlIIlIIII & 0x10) != 0x0);
        final State lllllllllllllIIIIIIlIIIIlIIIllll = this.currentState;
        if (this.invisible && this.name != null) {
            this.currentState = State.HOLOGRAM;
        }
        else {
            this.currentState = State.ZOMBIE;
        }
        if (this.currentState != lllllllllllllIIIIIIlIIIIlIIIllll) {
            this.despawn();
            this.spawn();
        }
        else {
            this.updateMetadata();
            this.updateLocation();
        }
    }
    
    public AABB getBoundingBox() {
        final double lllllllllllllIIIIIIlIIIIIlIIIIll = this.small ? 0.25 : 0.5;
        final double lllllllllllllIIIIIIlIIIIIlIIIIlI = this.small ? 0.9875 : 1.975;
        final Vector3d lllllllllllllIIIIIIlIIIIIlIIIIIl = new Vector3d(this.locX - lllllllllllllIIIIIIlIIIIIlIIIIll / 2.0, this.locY, this.locZ - lllllllllllllIIIIIIlIIIIIlIIIIll / 2.0);
        final Vector3d lllllllllllllIIIIIIlIIIIIlIIIIII = new Vector3d(this.locX + lllllllllllllIIIIIIlIIIIIlIIIIll / 2.0, this.locY + lllllllllllllIIIIIIlIIIIIlIIIIlI, this.locZ + lllllllllllllIIIIIIlIIIIIlIIIIll / 2.0);
        return new AABB(lllllllllllllIIIIIIlIIIIIlIIIIIl, lllllllllllllIIIIIIlIIIIIlIIIIII);
    }
    
    @Override
    public void spawn() {
        if (this.entityIds != null) {
            this.despawn();
        }
        if (this.currentState == State.ZOMBIE) {
            final PacketWrapper lllllllllllllIIIIIIlIIIIIlIlIIlI = PacketWrapper.create(15, null, this.user);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.VAR_INT, this.entityId);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.UNSIGNED_BYTE, (Short)54);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.INT, (int)(this.locX * 32.0));
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.INT, (int)(this.locY * 32.0));
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.INT, (int)(this.locZ * 32.0));
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.SHORT, (Short)0);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.SHORT, (Short)0);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write(Type.SHORT, (Short)0);
            lllllllllllllIIIIIIlIIIIIlIlIIlI.write((Type<ArrayList>)Types1_7_6_10.METADATA_LIST, new ArrayList());
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIIlIlIIlI, Protocol1_7_6_10TO1_8.class, true, true);
            this.entityIds = new int[] { this.entityId };
        }
        else if (this.currentState == State.HOLOGRAM) {
            final int[] lllllllllllllIIIIIIlIIIIIlIlIIIl = { this.entityId, ArmorStandReplacement.ENTITY_ID-- };
            final PacketWrapper lllllllllllllIIIIIIlIIIIIlIlIIII = PacketWrapper.create(14, null, this.user);
            lllllllllllllIIIIIIlIIIIIlIlIIII.write(Type.VAR_INT, lllllllllllllIIIIIIlIIIIIlIlIIIl[0]);
            lllllllllllllIIIIIIlIIIIIlIlIIII.write(Type.BYTE, (Byte)66);
            lllllllllllllIIIIIIlIIIIIlIlIIII.write(Type.INT, (int)(this.locX * 32.0));
            lllllllllllllIIIIIIlIIIIIlIlIIII.write(Type.INT, (int)(this.locY * 32.0));
            lllllllllllllIIIIIIlIIIIIlIlIIII.write(Type.INT, (int)(this.locZ * 32.0));
            lllllllllllllIIIIIIlIIIIIlIlIIII.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIIlIlIIII.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIIlIlIIII.write(Type.INT, 0);
            final PacketWrapper lllllllllllllIIIIIIlIIIIIlIIllll = PacketWrapper.create(15, null, this.user);
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.VAR_INT, lllllllllllllIIIIIIlIIIIIlIlIIIl[1]);
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.UNSIGNED_BYTE, (Short)100);
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.INT, (int)(this.locX * 32.0));
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.INT, (int)(this.locY * 32.0));
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.INT, (int)(this.locZ * 32.0));
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.BYTE, (Byte)0);
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.SHORT, (Short)0);
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.SHORT, (Short)0);
            lllllllllllllIIIIIIlIIIIIlIIllll.write(Type.SHORT, (Short)0);
            lllllllllllllIIIIIIlIIIIIlIIllll.write((Type<ArrayList>)Types1_7_6_10.METADATA_LIST, new ArrayList());
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIIlIlIIII, Protocol1_7_6_10TO1_8.class, true, true);
            PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIIlIIllll, Protocol1_7_6_10TO1_8.class, true, true);
            this.entityIds = lllllllllllllIIIIIIlIIIIIlIlIIIl;
        }
        this.updateMetadata();
        this.updateLocation();
    }
    
    @Override
    public void setLocation(final double lllllllllllllIIIIIIlIIIIllIIIIIl, final double lllllllllllllIIIIIIlIIIIllIIIlII, final double lllllllllllllIIIIIIlIIIIlIllllll) {
        if (lllllllllllllIIIIIIlIIIIllIIIIIl != this.locX || lllllllllllllIIIIIIlIIIIllIIIlII != this.locY || lllllllllllllIIIIIIlIIIIlIllllll != this.locZ) {
            this.locX = lllllllllllllIIIIIIlIIIIllIIIIIl;
            this.locY = lllllllllllllIIIIIIlIIIIllIIIlII;
            this.locZ = lllllllllllllIIIIIIlIIIIlIllllll;
            this.updateLocation();
        }
    }
    
    public ArmorStandReplacement(final int lllllllllllllIIIIIIlIIIIllIIllII, final UserConnection lllllllllllllIIIIIIlIIIIllIIlIll) {
        this.datawatcher = new ArrayList<Metadata>();
        this.entityIds = null;
        this.currentState = null;
        this.invisible = false;
        this.nameTagVisible = false;
        this.name = null;
        this.small = false;
        this.marker = false;
        this.entityId = lllllllllllllIIIIIIlIIIIllIIllII;
        this.user = lllllllllllllIIIIIIlIIIIllIIlIll;
    }
    
    public void updateMetadata() {
        if (this.entityIds == null) {
            return;
        }
        final PacketWrapper lllllllllllllIIIIIIlIIIIIlIlllII = PacketWrapper.create(28, null, this.user);
        if (this.currentState == State.ZOMBIE) {
            lllllllllllllIIIIIIlIIIIIlIlllII.write(Type.INT, this.entityIds[0]);
            final List<Metadata> lllllllllllllIIIIIIlIIIIIlIlllll = new ArrayList<Metadata>();
            for (final Metadata lllllllllllllIIIIIIlIIIIIllIIIIl : this.datawatcher) {
                if (lllllllllllllIIIIIIlIIIIIllIIIIl.id() >= 0) {
                    if (lllllllllllllIIIIIIlIIIIIllIIIIl.id() > 9) {
                        continue;
                    }
                    lllllllllllllIIIIIIlIIIIIlIlllll.add(new Metadata(lllllllllllllIIIIIIlIIIIIllIIIIl.id(), lllllllllllllIIIIIIlIIIIIllIIIIl.metaType(), lllllllllllllIIIIIIlIIIIIllIIIIl.getValue()));
                }
            }
            if (this.small) {
                lllllllllllllIIIIIIlIIIIIlIlllll.add(new Metadata(12, MetaType1_8.Byte, 1));
            }
            MetadataRewriter.transform(Entity1_10Types.EntityType.ZOMBIE, lllllllllllllIIIIIIlIIIIIlIlllll);
            lllllllllllllIIIIIIlIIIIIlIlllII.write(Types1_7_6_10.METADATA_LIST, lllllllllllllIIIIIIlIIIIIlIlllll);
        }
        else {
            if (this.currentState != State.HOLOGRAM) {
                return;
            }
            lllllllllllllIIIIIIlIIIIIlIlllII.write(Type.INT, this.entityIds[1]);
            final List<Metadata> lllllllllllllIIIIIIlIIIIIlIllllI = new ArrayList<Metadata>();
            lllllllllllllIIIIIIlIIIIIlIllllI.add(new Metadata(12, MetaType1_7_6_10.Int, -1700000));
            lllllllllllllIIIIIIlIIIIIlIllllI.add(new Metadata(10, MetaType1_7_6_10.String, this.name));
            lllllllllllllIIIIIIlIIIIIlIllllI.add(new Metadata(11, MetaType1_7_6_10.Byte, 1));
            lllllllllllllIIIIIIlIIIIIlIlllII.write(Types1_7_6_10.METADATA_LIST, lllllllllllllIIIIIIlIIIIIlIllllI);
        }
        PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIIlIlllII, Protocol1_7_6_10TO1_8.class);
    }
    
    @Override
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void relMove(final double lllllllllllllIIIIIIlIIIIlIlllIIl, final double lllllllllllllIIIIIIlIIIIlIllIlII, final double lllllllllllllIIIIIIlIIIIlIllIIll) {
        if (lllllllllllllIIIIIIlIIIIlIlllIIl == 0.0 && lllllllllllllIIIIIIlIIIIlIllIlII == 0.0 && lllllllllllllIIIIIIlIIIIlIllIIll == 0.0) {
            return;
        }
        this.locX += lllllllllllllIIIIIIlIIIIlIlllIIl;
        this.locY += lllllllllllllIIIIIIlIIIIlIllIlII;
        this.locZ += lllllllllllllIIIIIIlIIIIlIllIIll;
        this.updateLocation();
    }
    
    @Override
    public void despawn() {
        if (this.entityIds == null) {
            return;
        }
        final PacketWrapper lllllllllllllIIIIIIlIIIIIIllIIlI = PacketWrapper.create(19, null, this.user);
        lllllllllllllIIIIIIlIIIIIIllIIlI.write(Type.BYTE, (byte)this.entityIds.length);
        final char lllllllllllllIIIIIIlIIIIIIlIllll = (Object)this.entityIds;
        final long lllllllllllllIIIIIIlIIIIIIlIlllI = lllllllllllllIIIIIIlIIIIIIlIllll.length;
        for (final int lllllllllllllIIIIIIlIIIIIIllIlII : lllllllllllllIIIIIIlIIIIIIlIllll) {
            lllllllllllllIIIIIIlIIIIIIllIIlI.write(Type.INT, lllllllllllllIIIIIIlIIIIIIllIlII);
        }
        this.entityIds = null;
        PacketUtil.sendPacket(lllllllllllllIIIIIIlIIIIIIllIIlI, Protocol1_7_6_10TO1_8.class, true, true);
    }
    
    private enum State
    {
        HOLOGRAM, 
        ZOMBIE;
    }
}
