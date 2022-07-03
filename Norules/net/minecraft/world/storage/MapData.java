package net.minecraft.world.storage;

import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.network.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import net.minecraft.network.play.server.*;

public class MapData extends WorldSavedData
{
    public /* synthetic */ boolean trackingPosition;
    public /* synthetic */ List<MapInfo> playersArrayList;
    private final /* synthetic */ Map<EntityPlayer, MapInfo> playersHashMap;
    public /* synthetic */ boolean field_191096_f;
    public /* synthetic */ byte[] colors;
    public /* synthetic */ byte scale;
    public /* synthetic */ int zCenter;
    public /* synthetic */ Map<String, MapDecoration> mapDecorations;
    public /* synthetic */ byte dimension;
    public /* synthetic */ int xCenter;
    
    public static void func_191094_a(final ItemStack lllllllllllllllllIIIllllIllIIlIl, final BlockPos lllllllllllllllllIIIllllIlIlllII, final String lllllllllllllllllIIIllllIllIIIll, final MapDecoration.Type lllllllllllllllllIIIllllIllIIIlI) {
        NBTTagList lllllllllllllllllIIIllllIllIIIII = null;
        if (lllllllllllllllllIIIllllIllIIlIl.hasTagCompound() && lllllllllllllllllIIIllllIllIIlIl.getTagCompound().hasKey("Decorations", 9)) {
            final NBTTagList lllllllllllllllllIIIllllIllIIIIl = lllllllllllllllllIIIllllIllIIlIl.getTagCompound().getTagList("Decorations", 10);
        }
        else {
            lllllllllllllllllIIIllllIllIIIII = new NBTTagList();
            lllllllllllllllllIIIllllIllIIlIl.setTagInfo("Decorations", lllllllllllllllllIIIllllIllIIIII);
        }
        final NBTTagCompound lllllllllllllllllIIIllllIlIlllll = new NBTTagCompound();
        lllllllllllllllllIIIllllIlIlllll.setByte("type", lllllllllllllllllIIIllllIllIIIlI.func_191163_a());
        lllllllllllllllllIIIllllIlIlllll.setString("id", lllllllllllllllllIIIllllIllIIIll);
        lllllllllllllllllIIIllllIlIlllll.setDouble("x", lllllllllllllllllIIIllllIlIlllII.getX());
        lllllllllllllllllIIIllllIlIlllll.setDouble("z", lllllllllllllllllIIIllllIlIlllII.getZ());
        lllllllllllllllllIIIllllIlIlllll.setDouble("rot", 180.0);
        lllllllllllllllllIIIllllIllIIIII.appendTag(lllllllllllllllllIIIllllIlIlllll);
        if (lllllllllllllllllIIIllllIllIIIlI.func_191162_c()) {
            final NBTTagCompound lllllllllllllllllIIIllllIlIllllI = lllllllllllllllllIIIllllIllIIlIl.func_190925_c("display");
            lllllllllllllllllIIIllllIlIllllI.setInteger("MapColor", lllllllllllllllllIIIllllIllIIIlI.func_191161_d());
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllllIIIlllllIIIIllI) {
        lllllllllllllllllIIIlllllIIIIllI.setByte("dimension", this.dimension);
        lllllllllllllllllIIIlllllIIIIllI.setInteger("xCenter", this.xCenter);
        lllllllllllllllllIIIlllllIIIIllI.setInteger("zCenter", this.zCenter);
        lllllllllllllllllIIIlllllIIIIllI.setByte("scale", this.scale);
        lllllllllllllllllIIIlllllIIIIllI.setShort("width", (short)128);
        lllllllllllllllllIIIlllllIIIIllI.setShort("height", (short)128);
        lllllllllllllllllIIIlllllIIIIllI.setByteArray("colors", this.colors);
        lllllllllllllllllIIIlllllIIIIllI.setBoolean("trackingPosition", this.trackingPosition);
        lllllllllllllllllIIIlllllIIIIllI.setBoolean("unlimitedTracking", this.field_191096_f);
        return lllllllllllllllllIIIlllllIIIIllI;
    }
    
    public MapData(final String lllllllllllllllllIIIllllllIIIIlI) {
        super(lllllllllllllllllIIIllllllIIIIlI);
        this.colors = new byte[16384];
        this.playersArrayList = (List<MapInfo>)Lists.newArrayList();
        this.playersHashMap = (Map<EntityPlayer, MapInfo>)Maps.newHashMap();
        this.mapDecorations = (Map<String, MapDecoration>)Maps.newLinkedHashMap();
    }
    
    @Nullable
    public Packet<?> getMapPacket(final ItemStack lllllllllllllllllIIIllllIIIlllIl, final World lllllllllllllllllIIIllllIIlIIIIl, final EntityPlayer lllllllllllllllllIIIllllIIlIIIII) {
        final MapInfo lllllllllllllllllIIIllllIIIlllll = this.playersHashMap.get(lllllllllllllllllIIIllllIIlIIIII);
        return (lllllllllllllllllIIIllllIIIlllll == null) ? null : lllllllllllllllllIIIllllIIIlllll.getPacket(lllllllllllllllllIIIllllIIIlllIl);
    }
    
    public void updateMapData(final int lllllllllllllllllIIIllllIIIlIIII, final int lllllllllllllllllIIIllllIIIIllll) {
        super.markDirty();
        for (final MapInfo lllllllllllllllllIIIllllIIIlIIlI : this.playersArrayList) {
            lllllllllllllllllIIIllllIIIlIIlI.update(lllllllllllllllllIIIllllIIIlIIII, lllllllllllllllllIIIllllIIIIllll);
        }
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllllIIIlllllIIllllI) {
        this.dimension = lllllllllllllllllIIIlllllIIllllI.getByte("dimension");
        this.xCenter = lllllllllllllllllIIIlllllIIllllI.getInteger("xCenter");
        this.zCenter = lllllllllllllllllIIIlllllIIllllI.getInteger("zCenter");
        this.scale = lllllllllllllllllIIIlllllIIllllI.getByte("scale");
        this.scale = (byte)MathHelper.clamp(this.scale, 0, 4);
        if (lllllllllllllllllIIIlllllIIllllI.hasKey("trackingPosition", 1)) {
            this.trackingPosition = lllllllllllllllllIIIlllllIIllllI.getBoolean("trackingPosition");
        }
        else {
            this.trackingPosition = true;
        }
        this.field_191096_f = lllllllllllllllllIIIlllllIIllllI.getBoolean("unlimitedTracking");
        final int lllllllllllllllllIIIlllllIIlllIl = lllllllllllllllllIIIlllllIIllllI.getShort("width");
        final int lllllllllllllllllIIIlllllIIlllII = lllllllllllllllllIIIlllllIIllllI.getShort("height");
        if (lllllllllllllllllIIIlllllIIlllIl == 128 && lllllllllllllllllIIIlllllIIlllII == 128) {
            this.colors = lllllllllllllllllIIIlllllIIllllI.getByteArray("colors");
        }
        else {
            final byte[] lllllllllllllllllIIIlllllIIllIll = lllllllllllllllllIIIlllllIIllllI.getByteArray("colors");
            this.colors = new byte[16384];
            final int lllllllllllllllllIIIlllllIIllIlI = (128 - lllllllllllllllllIIIlllllIIlllIl) / 2;
            final int lllllllllllllllllIIIlllllIIllIIl = (128 - lllllllllllllllllIIIlllllIIlllII) / 2;
            for (int lllllllllllllllllIIIlllllIIllIII = 0; lllllllllllllllllIIIlllllIIllIII < lllllllllllllllllIIIlllllIIlllII; ++lllllllllllllllllIIIlllllIIllIII) {
                final int lllllllllllllllllIIIlllllIIlIlll = lllllllllllllllllIIIlllllIIllIII + lllllllllllllllllIIIlllllIIllIIl;
                if (lllllllllllllllllIIIlllllIIlIlll >= 0 || lllllllllllllllllIIIlllllIIlIlll < 128) {
                    for (int lllllllllllllllllIIIlllllIIlIllI = 0; lllllllllllllllllIIIlllllIIlIllI < lllllllllllllllllIIIlllllIIlllIl; ++lllllllllllllllllIIIlllllIIlIllI) {
                        final int lllllllllllllllllIIIlllllIIlIlIl = lllllllllllllllllIIIlllllIIlIllI + lllllllllllllllllIIIlllllIIllIlI;
                        if (lllllllllllllllllIIIlllllIIlIlIl >= 0 || lllllllllllllllllIIIlllllIIlIlIl < 128) {
                            this.colors[lllllllllllllllllIIIlllllIIlIlIl + lllllllllllllllllIIIlllllIIlIlll * 128] = lllllllllllllllllIIIlllllIIllIll[lllllllllllllllllIIIlllllIIlIllI + lllllllllllllllllIIIlllllIIllIII * lllllllllllllllllIIIlllllIIlllIl];
                        }
                    }
                }
            }
        }
    }
    
    public MapInfo getMapInfo(final EntityPlayer lllllllllllllllllIIIllllIIIIlIII) {
        MapInfo lllllllllllllllllIIIllllIIIIIlll = this.playersHashMap.get(lllllllllllllllllIIIllllIIIIlIII);
        if (lllllllllllllllllIIIllllIIIIIlll == null) {
            lllllllllllllllllIIIllllIIIIIlll = new MapInfo(lllllllllllllllllIIIllllIIIIlIII);
            this.playersHashMap.put(lllllllllllllllllIIIllllIIIIlIII, lllllllllllllllllIIIllllIIIIIlll);
            this.playersArrayList.add(lllllllllllllllllIIIllllIIIIIlll);
        }
        return lllllllllllllllllIIIllllIIIIIlll;
    }
    
    public void calculateMapCenter(final double lllllllllllllllllIIIlllllIllIIII, final double lllllllllllllllllIIIlllllIllIllI, final int lllllllllllllllllIIIlllllIllIlIl) {
        final int lllllllllllllllllIIIlllllIllIlII = 128 * (1 << lllllllllllllllllIIIlllllIllIlIl);
        final int lllllllllllllllllIIIlllllIllIIll = MathHelper.floor((lllllllllllllllllIIIlllllIllIIII + 64.0) / lllllllllllllllllIIIlllllIllIlII);
        final int lllllllllllllllllIIIlllllIllIIlI = MathHelper.floor((lllllllllllllllllIIIlllllIllIllI + 64.0) / lllllllllllllllllIIIlllllIllIlII);
        this.xCenter = lllllllllllllllllIIIlllllIllIIll * lllllllllllllllllIIIlllllIllIlII + lllllllllllllllllIIIlllllIllIlII / 2 - 64;
        this.zCenter = lllllllllllllllllIIIlllllIllIIlI * lllllllllllllllllIIIlllllIllIlII + lllllllllllllllllIIIlllllIllIlII / 2 - 64;
    }
    
    public void updateVisiblePlayers(final EntityPlayer lllllllllllllllllIIIllllIlllIIIl, final ItemStack lllllllllllllllllIIIllllIllllIll) {
        if (!this.playersHashMap.containsKey(lllllllllllllllllIIIllllIlllIIIl)) {
            final MapInfo lllllllllllllllllIIIllllIllllIlI = new MapInfo(lllllllllllllllllIIIllllIlllIIIl);
            this.playersHashMap.put(lllllllllllllllllIIIllllIlllIIIl, lllllllllllllllllIIIllllIllllIlI);
            this.playersArrayList.add(lllllllllllllllllIIIllllIllllIlI);
        }
        if (!lllllllllllllllllIIIllllIlllIIIl.inventory.hasItemStack(lllllllllllllllllIIIllllIllllIll)) {
            this.mapDecorations.remove(lllllllllllllllllIIIllllIlllIIIl.getName());
        }
        for (int lllllllllllllllllIIIllllIllllIIl = 0; lllllllllllllllllIIIllllIllllIIl < this.playersArrayList.size(); ++lllllllllllllllllIIIllllIllllIIl) {
            final MapInfo lllllllllllllllllIIIllllIllllIII = this.playersArrayList.get(lllllllllllllllllIIIllllIllllIIl);
            if (!lllllllllllllllllIIIllllIllllIII.entityplayerObj.isDead && (lllllllllllllllllIIIllllIllllIII.entityplayerObj.inventory.hasItemStack(lllllllllllllllllIIIllllIllllIll) || lllllllllllllllllIIIllllIllllIll.isOnItemFrame())) {
                if (!lllllllllllllllllIIIllllIllllIll.isOnItemFrame() && lllllllllllllllllIIIllllIllllIII.entityplayerObj.dimension == this.dimension && this.trackingPosition) {
                    this.func_191095_a(MapDecoration.Type.PLAYER, lllllllllllllllllIIIllllIllllIII.entityplayerObj.world, lllllllllllllllllIIIllllIllllIII.entityplayerObj.getName(), lllllllllllllllllIIIllllIllllIII.entityplayerObj.posX, lllllllllllllllllIIIllllIllllIII.entityplayerObj.posZ, lllllllllllllllllIIIllllIllllIII.entityplayerObj.rotationYaw);
                }
            }
            else {
                this.playersHashMap.remove(lllllllllllllllllIIIllllIllllIII.entityplayerObj);
                this.playersArrayList.remove(lllllllllllllllllIIIllllIllllIII);
            }
        }
        if (lllllllllllllllllIIIllllIllllIll.isOnItemFrame() && this.trackingPosition) {
            final EntityItemFrame lllllllllllllllllIIIllllIlllIlll = lllllllllllllllllIIIllllIllllIll.getItemFrame();
            final BlockPos lllllllllllllllllIIIllllIlllIllI = lllllllllllllllllIIIllllIlllIlll.getHangingPosition();
            this.func_191095_a(MapDecoration.Type.FRAME, lllllllllllllllllIIIllllIlllIIIl.world, String.valueOf(new StringBuilder("frame-").append(lllllllllllllllllIIIllllIlllIlll.getEntityId())), lllllllllllllllllIIIllllIlllIllI.getX(), lllllllllllllllllIIIllllIlllIllI.getZ(), lllllllllllllllllIIIllllIlllIlll.facingDirection.getHorizontalIndex() * 90);
        }
        if (lllllllllllllllllIIIllllIllllIll.hasTagCompound() && lllllllllllllllllIIIllllIllllIll.getTagCompound().hasKey("Decorations", 9)) {
            final NBTTagList lllllllllllllllllIIIllllIlllIlIl = lllllllllllllllllIIIllllIllllIll.getTagCompound().getTagList("Decorations", 10);
            for (int lllllllllllllllllIIIllllIlllIlII = 0; lllllllllllllllllIIIllllIlllIlII < lllllllllllllllllIIIllllIlllIlIl.tagCount(); ++lllllllllllllllllIIIllllIlllIlII) {
                final NBTTagCompound lllllllllllllllllIIIllllIlllIIll = lllllllllllllllllIIIllllIlllIlIl.getCompoundTagAt(lllllllllllllllllIIIllllIlllIlII);
                if (!this.mapDecorations.containsKey(lllllllllllllllllIIIllllIlllIIll.getString("id"))) {
                    this.func_191095_a(MapDecoration.Type.func_191159_a(lllllllllllllllllIIIllllIlllIIll.getByte("type")), lllllllllllllllllIIIllllIlllIIIl.world, lllllllllllllllllIIIllllIlllIIll.getString("id"), lllllllllllllllllIIIllllIlllIIll.getDouble("x"), lllllllllllllllllIIIllllIlllIIll.getDouble("z"), lllllllllllllllllIIIllllIlllIIll.getDouble("rot"));
                }
            }
        }
    }
    
    private void func_191095_a(MapDecoration.Type lllllllllllllllllIIIllllIIllIlIl, final World lllllllllllllllllIIIllllIlIIIlIl, final String lllllllllllllllllIIIllllIlIIIlII, final double lllllllllllllllllIIIllllIIllIIlI, final double lllllllllllllllllIIIllllIlIIIIlI, double lllllllllllllllllIIIllllIIllIIII) {
        final int lllllllllllllllllIIIllllIlIIIIII = 1 << this.scale;
        final float lllllllllllllllllIIIllllIIllllll = (float)(lllllllllllllllllIIIllllIIllIIlI - this.xCenter) / lllllllllllllllllIIIllllIlIIIIII;
        final float lllllllllllllllllIIIllllIIlllllI = (float)(lllllllllllllllllIIIllllIlIIIIlI - this.zCenter) / lllllllllllllllllIIIllllIlIIIIII;
        byte lllllllllllllllllIIIllllIIllllIl = (byte)(lllllllllllllllllIIIllllIIllllll * 2.0f + 0.5);
        byte lllllllllllllllllIIIllllIIllllII = (byte)(lllllllllllllllllIIIllllIIlllllI * 2.0f + 0.5);
        final int lllllllllllllllllIIIllllIIlllIll = 63;
        byte lllllllllllllllllIIIllllIIlllIIl = 0;
        if (lllllllllllllllllIIIllllIIllllll >= -63.0f && lllllllllllllllllIIIllllIIlllllI >= -63.0f && lllllllllllllllllIIIllllIIllllll <= 63.0f && lllllllllllllllllIIIllllIIlllllI <= 63.0f) {
            lllllllllllllllllIIIllllIIllIIII += ((lllllllllllllllllIIIllllIIllIIII < 0.0) ? -8.0 : 8.0);
            byte lllllllllllllllllIIIllllIIlllIlI = (byte)(lllllllllllllllllIIIllllIIllIIII * 16.0 / 360.0);
            if (this.dimension < 0) {
                final int lllllllllllllllllIIIllllIIlllIII = (int)(lllllllllllllllllIIIllllIlIIIlIl.getWorldInfo().getWorldTime() / 10L);
                lllllllllllllllllIIIllllIIlllIlI = (byte)(lllllllllllllllllIIIllllIIlllIII * lllllllllllllllllIIIllllIIlllIII * 34187121 + lllllllllllllllllIIIllllIIlllIII * 121 >> 15 & 0xF);
            }
        }
        else {
            if (lllllllllllllllllIIIllllIIllIlIl != MapDecoration.Type.PLAYER) {
                this.mapDecorations.remove(lllllllllllllllllIIIllllIlIIIlII);
                return;
            }
            final int lllllllllllllllllIIIllllIIllIlll = 320;
            if (Math.abs(lllllllllllllllllIIIllllIIllllll) < 320.0f && Math.abs(lllllllllllllllllIIIllllIIlllllI) < 320.0f) {
                lllllllllllllllllIIIllllIIllIlIl = MapDecoration.Type.PLAYER_OFF_MAP;
            }
            else {
                if (!this.field_191096_f) {
                    this.mapDecorations.remove(lllllllllllllllllIIIllllIlIIIlII);
                    return;
                }
                lllllllllllllllllIIIllllIIllIlIl = MapDecoration.Type.PLAYER_OFF_LIMITS;
            }
            lllllllllllllllllIIIllllIIlllIIl = 0;
            if (lllllllllllllllllIIIllllIIllllll <= -63.0f) {
                lllllllllllllllllIIIllllIIllllIl = -128;
            }
            if (lllllllllllllllllIIIllllIIlllllI <= -63.0f) {
                lllllllllllllllllIIIllllIIllllII = -128;
            }
            if (lllllllllllllllllIIIllllIIllllll >= 63.0f) {
                lllllllllllllllllIIIllllIIllllIl = 127;
            }
            if (lllllllllllllllllIIIllllIIlllllI >= 63.0f) {
                lllllllllllllllllIIIllllIIllllII = 127;
            }
        }
        this.mapDecorations.put(lllllllllllllllllIIIllllIlIIIlII, new MapDecoration(lllllllllllllllllIIIllllIIllIlIl, lllllllllllllllllIIIllllIIllllIl, lllllllllllllllllIIIllllIIllllII, lllllllllllllllllIIIllllIIlllIIl));
    }
    
    public class MapInfo
    {
        private /* synthetic */ int maxY;
        private /* synthetic */ int maxX;
        private /* synthetic */ boolean isDirty;
        public final /* synthetic */ EntityPlayer entityplayerObj;
        private /* synthetic */ int minY;
        private /* synthetic */ int tick;
        private /* synthetic */ int minX;
        
        public MapInfo(final EntityPlayer lllllllllllllIIllIIllIIIlIIlIlII) {
            this.isDirty = true;
            this.maxX = 127;
            this.maxY = 127;
            this.entityplayerObj = lllllllllllllIIllIIllIIIlIIlIlII;
        }
        
        public void update(final int lllllllllllllIIllIIllIIIlIIIIllI, final int lllllllllllllIIllIIllIIIlIIIIlIl) {
            if (this.isDirty) {
                this.minX = Math.min(this.minX, lllllllllllllIIllIIllIIIlIIIIllI);
                this.minY = Math.min(this.minY, lllllllllllllIIllIIllIIIlIIIIlIl);
                this.maxX = Math.max(this.maxX, lllllllllllllIIllIIllIIIlIIIIllI);
                this.maxY = Math.max(this.maxY, lllllllllllllIIllIIllIIIlIIIIlIl);
            }
            else {
                this.isDirty = true;
                this.minX = lllllllllllllIIllIIllIIIlIIIIllI;
                this.minY = lllllllllllllIIllIIllIIIlIIIIlIl;
                this.maxX = lllllllllllllIIllIIllIIIlIIIIllI;
                this.maxY = lllllllllllllIIllIIllIIIlIIIIlIl;
            }
        }
        
        @Nullable
        public Packet<?> getPacket(final ItemStack lllllllllllllIIllIIllIIIlIIIlIll) {
            if (this.isDirty) {
                this.isDirty = false;
                return new SPacketMaps(lllllllllllllIIllIIllIIIlIIIlIll.getMetadata(), MapData.this.scale, MapData.this.trackingPosition, MapData.this.mapDecorations.values(), MapData.this.colors, this.minX, this.minY, this.maxX + 1 - this.minX, this.maxY + 1 - this.minY);
            }
            return (this.tick++ % 5 == 0) ? new SPacketMaps(lllllllllllllIIllIIllIIIlIIIlIll.getMetadata(), MapData.this.scale, MapData.this.trackingPosition, MapData.this.mapDecorations.values(), MapData.this.colors, 0, 0, 0, 0) : null;
        }
    }
}
