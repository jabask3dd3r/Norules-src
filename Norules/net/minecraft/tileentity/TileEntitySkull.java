package net.minecraft.tileentity;

import com.mojang.authlib.*;
import net.minecraft.server.management.*;
import com.mojang.authlib.minecraft.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.network.play.server.*;
import java.util.*;
import net.minecraft.util.*;
import com.mojang.authlib.properties.*;
import com.google.common.collect.*;

public class TileEntitySkull extends TileEntity implements ITickable
{
    private /* synthetic */ int dragonAnimatedTicks;
    private /* synthetic */ GameProfile playerProfile;
    private static /* synthetic */ PlayerProfileCache profileCache;
    private /* synthetic */ int skullRotation;
    private /* synthetic */ boolean dragonAnimated;
    private /* synthetic */ int skullType;
    private static /* synthetic */ MinecraftSessionService sessionService;
    
    @Nullable
    public GameProfile getPlayerProfile() {
        return this.playerProfile;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIllllIlllIlllIIllIl) {
        super.writeToNBT(lllllllllllllIllllIlllIlllIIllIl);
        lllllllllllllIllllIlllIlllIIllIl.setByte("SkullType", (byte)(this.skullType & 0xFF));
        lllllllllllllIllllIlllIlllIIllIl.setByte("Rot", (byte)(this.skullRotation & 0xFF));
        if (this.playerProfile != null) {
            final NBTTagCompound lllllllllllllIllllIlllIlllIIllll = new NBTTagCompound();
            NBTUtil.writeGameProfile(lllllllllllllIllllIlllIlllIIllll, this.playerProfile);
            lllllllllllllIllllIlllIlllIIllIl.setTag("Owner", lllllllllllllIllllIlllIlllIIllll);
        }
        return lllllllllllllIllllIlllIlllIIllIl;
    }
    
    public static void setProfileCache(final PlayerProfileCache lllllllllllllIllllIlllIlllIllIII) {
        TileEntitySkull.profileCache = lllllllllllllIllllIlllIlllIllIII;
    }
    
    public float getAnimationProgress(final float lllllllllllllIllllIlllIllIllllII) {
        return this.dragonAnimated ? (this.dragonAnimatedTicks + lllllllllllllIllllIlllIllIllllII) : ((float)this.dragonAnimatedTicks);
    }
    
    @Override
    public void rotate(final Rotation lllllllllllllIllllIlllIllIIIIIll) {
        if (this.world != null && this.world.getBlockState(this.getPos()).getValue((IProperty<Comparable>)BlockSkull.FACING) == EnumFacing.UP) {
            this.skullRotation = lllllllllllllIllllIlllIllIIIIIll.rotate(this.skullRotation, 16);
        }
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 4, this.getUpdateTag());
    }
    
    public void setSkullRotation(final int lllllllllllllIllllIlllIllIIIllIl) {
        this.skullRotation = lllllllllllllIllllIlllIllIIIllIl;
    }
    
    public void setType(final int lllllllllllllIllllIlllIllIlIlIll) {
        this.skullType = lllllllllllllIllllIlllIllIlIlIll;
        this.playerProfile = null;
    }
    
    @Override
    public void update() {
        if (this.skullType == 5) {
            if (this.world.isBlockPowered(this.pos)) {
                this.dragonAnimated = true;
                ++this.dragonAnimatedTicks;
            }
            else {
                this.dragonAnimated = false;
            }
        }
    }
    
    public static void setSessionService(final MinecraftSessionService lllllllllllllIllllIlllIlllIlIllI) {
        TileEntitySkull.sessionService = lllllllllllllIllllIlllIlllIlIllI;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIllllIlllIlllIIIlll) {
        super.readFromNBT(lllllllllllllIllllIlllIlllIIIlll);
        this.skullType = lllllllllllllIllllIlllIlllIIIlll.getByte("SkullType");
        this.skullRotation = lllllllllllllIllllIlllIlllIIIlll.getByte("Rot");
        if (this.skullType == 3) {
            if (lllllllllllllIllllIlllIlllIIIlll.hasKey("Owner", 10)) {
                this.playerProfile = NBTUtil.readGameProfileFromNBT(lllllllllllllIllllIlllIlllIIIlll.getCompoundTag("Owner"));
            }
            else if (lllllllllllllIllllIlllIlllIIIlll.hasKey("ExtraType", 8)) {
                final String lllllllllllllIllllIlllIlllIIIllI = lllllllllllllIllllIlllIlllIIIlll.getString("ExtraType");
                if (!StringUtils.isNullOrEmpty(lllllllllllllIllllIlllIlllIIIllI)) {
                    this.playerProfile = new GameProfile((UUID)null, lllllllllllllIllllIlllIlllIIIllI);
                    this.updatePlayerProfile();
                }
            }
        }
    }
    
    private void updatePlayerProfile() {
        this.playerProfile = updateGameprofile(this.playerProfile);
        this.markDirty();
    }
    
    @Override
    public void mirror(final Mirror lllllllllllllIllllIlllIllIIIIlll) {
        if (this.world != null && this.world.getBlockState(this.getPos()).getValue((IProperty<Comparable>)BlockSkull.FACING) == EnumFacing.UP) {
            this.skullRotation = lllllllllllllIllllIlllIllIIIIlll.mirrorRotation(this.skullRotation, 16);
        }
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public void setPlayerProfile(@Nullable final GameProfile lllllllllllllIllllIlllIllIlIIlll) {
        this.skullType = 3;
        this.playerProfile = lllllllllllllIllllIlllIllIlIIlll;
        this.updatePlayerProfile();
    }
    
    public int getSkullType() {
        return this.skullType;
    }
    
    public static GameProfile updateGameprofile(final GameProfile lllllllllllllIllllIlllIllIIllllI) {
        if (lllllllllllllIllllIlllIllIIllllI == null || StringUtils.isNullOrEmpty(lllllllllllllIllllIlllIllIIllllI.getName())) {
            return lllllllllllllIllllIlllIllIIllllI;
        }
        if (lllllllllllllIllllIlllIllIIllllI.isComplete() && lllllllllllllIllllIlllIllIIllllI.getProperties().containsKey((Object)"textures")) {
            return lllllllllllllIllllIlllIllIIllllI;
        }
        if (TileEntitySkull.profileCache == null || TileEntitySkull.sessionService == null) {
            return lllllllllllllIllllIlllIllIIllllI;
        }
        GameProfile lllllllllllllIllllIlllIllIIlllIl = TileEntitySkull.profileCache.getGameProfileForUsername(lllllllllllllIllllIlllIllIIllllI.getName());
        if (lllllllllllllIllllIlllIllIIlllIl == null) {
            return lllllllllllllIllllIlllIllIIllllI;
        }
        final Property lllllllllllllIllllIlllIllIIlllII = (Property)Iterables.getFirst((Iterable)lllllllllllllIllllIlllIllIIlllIl.getProperties().get((Object)"textures"), (Object)null);
        if (lllllllllllllIllllIlllIllIIlllII == null) {
            lllllllllllllIllllIlllIllIIlllIl = TileEntitySkull.sessionService.fillProfileProperties(lllllllllllllIllllIlllIllIIlllIl, true);
        }
        return lllllllllllllIllllIlllIllIIlllIl;
    }
    
    public int getSkullRotation() {
        return this.skullRotation;
    }
}
