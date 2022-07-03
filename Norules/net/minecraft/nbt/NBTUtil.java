package net.minecraft.nbt;

import com.mojang.authlib.*;
import com.mojang.authlib.properties.*;
import javax.annotation.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.annotations.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import com.google.common.base.*;

public final class NBTUtil
{
    private static final /* synthetic */ Logger field_193591_a;
    
    public static NBTTagCompound createUUIDTag(final UUID lllllllllllllllIIlIllllIIIllIIII) {
        final NBTTagCompound lllllllllllllllIIlIllllIIIlIllll = new NBTTagCompound();
        lllllllllllllllIIlIllllIIIlIllll.setLong("M", lllllllllllllllIIlIllllIIIllIIII.getMostSignificantBits());
        lllllllllllllllIIlIllllIIIlIllll.setLong("L", lllllllllllllllIIlIllllIIIllIIII.getLeastSignificantBits());
        return lllllllllllllllIIlIllllIIIlIllll;
    }
    
    @Nullable
    public static GameProfile readGameProfileFromNBT(final NBTTagCompound lllllllllllllllIIlIllllIlIIIllIl) {
        String lllllllllllllllIIlIllllIlIIIllII = null;
        String lllllllllllllllIIlIllllIlIIIlIll = null;
        if (lllllllllllllllIIlIllllIlIIIllIl.hasKey("Name", 8)) {
            lllllllllllllllIIlIllllIlIIIllII = lllllllllllllllIIlIllllIlIIIllIl.getString("Name");
        }
        Label_0040: {
            if (!lllllllllllllllIIlIllllIlIIIllIl.hasKey("Id", 8)) {
                break Label_0040;
            }
            lllllllllllllllIIlIllllIlIIIlIll = lllllllllllllllIIlIllllIlIIIllIl.getString("Id");
            try {
                UUID lllllllllllllllIIlIllllIlIIIlIIl = null;
                try {
                    final UUID lllllllllllllllIIlIllllIlIIIlIlI = UUID.fromString(lllllllllllllllIIlIllllIlIIIlIll);
                }
                catch (Throwable lllllllllllllllIIlIllllIlIIIlIII) {
                    lllllllllllllllIIlIllllIlIIIlIIl = null;
                }
                final GameProfile lllllllllllllllIIlIllllIlIIIIlll = new GameProfile(lllllllllllllllIIlIllllIlIIIlIIl, lllllllllllllllIIlIllllIlIIIllII);
                if (lllllllllllllllIIlIllllIlIIIllIl.hasKey("Properties", 10)) {
                    final NBTTagCompound lllllllllllllllIIlIllllIlIIIIllI = lllllllllllllllIIlIllllIlIIIllIl.getCompoundTag("Properties");
                    for (final String lllllllllllllllIIlIllllIlIIIIlII : lllllllllllllllIIlIllllIlIIIIllI.getKeySet()) {
                        final NBTTagList lllllllllllllllIIlIllllIlIIIIIlI = lllllllllllllllIIlIllllIlIIIIllI.getTagList(lllllllllllllllIIlIllllIlIIIIlII, 10);
                        for (int lllllllllllllllIIlIllllIlIIIIIIl = 0; lllllllllllllllIIlIllllIlIIIIIIl < lllllllllllllllIIlIllllIlIIIIIlI.tagCount(); ++lllllllllllllllIIlIllllIlIIIIIIl) {
                            final NBTTagCompound lllllllllllllllIIlIllllIlIIIIIII = lllllllllllllllIIlIllllIlIIIIIlI.getCompoundTagAt(lllllllllllllllIIlIllllIlIIIIIIl);
                            final String lllllllllllllllIIlIllllIIlllllll = lllllllllllllllIIlIllllIlIIIIIII.getString("Value");
                            if (lllllllllllllllIIlIllllIlIIIIIII.hasKey("Signature", 8)) {
                                lllllllllllllllIIlIllllIlIIIIlll.getProperties().put((Object)lllllllllllllllIIlIllllIlIIIIlII, (Object)new Property(lllllllllllllllIIlIllllIlIIIIlII, lllllllllllllllIIlIllllIIlllllll, lllllllllllllllIIlIllllIlIIIIIII.getString("Signature")));
                            }
                            else {
                                lllllllllllllllIIlIllllIlIIIIlll.getProperties().put((Object)lllllllllllllllIIlIllllIlIIIIlII, (Object)new Property(lllllllllllllllIIlIllllIlIIIIlII, lllllllllllllllIIlIllllIIlllllll));
                            }
                        }
                    }
                }
                return lllllllllllllllIIlIllllIlIIIIlll;
            }
            catch (Throwable lllllllllllllllIIlIllllIIllllllI) {
                return null;
            }
        }
    }
    
    public static NBTTagCompound writeBlockState(final NBTTagCompound lllllllllllllllIIlIlllIllllIlIll, final IBlockState lllllllllllllllIIlIlllIlllllIIII) {
        lllllllllllllllIIlIlllIllllIlIll.setString("Name", Block.REGISTRY.getNameForObject(lllllllllllllllIIlIlllIlllllIIII.getBlock()).toString());
        if (!lllllllllllllllIIlIlllIlllllIIII.getProperties().isEmpty()) {
            final NBTTagCompound lllllllllllllllIIlIlllIllllIllll = new NBTTagCompound();
            for (final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllllllIIlIlllIllllIllIl : lllllllllllllllIIlIlllIlllllIIII.getProperties().entrySet()) {
                final IProperty<?> lllllllllllllllIIlIlllIllllIllII = lllllllllllllllIIlIlllIllllIllIl.getKey();
                lllllllllllllllIIlIlllIllllIllll.setString(lllllllllllllllIIlIlllIllllIllII.getName(), getName(lllllllllllllllIIlIlllIllllIllII, lllllllllllllllIIlIlllIllllIllIl.getValue()));
            }
            lllllllllllllllIIlIlllIllllIlIll.setTag("Properties", lllllllllllllllIIlIlllIllllIllll);
        }
        return lllllllllllllllIIlIlllIllllIlIll;
    }
    
    public static NBTTagCompound writeGameProfile(final NBTTagCompound lllllllllllllllIIlIllllIIlIllIlI, final GameProfile lllllllllllllllIIlIllllIIlIllIIl) {
        if (!StringUtils.isNullOrEmpty(lllllllllllllllIIlIllllIIlIllIIl.getName())) {
            lllllllllllllllIIlIllllIIlIllIlI.setString("Name", lllllllllllllllIIlIllllIIlIllIIl.getName());
        }
        if (lllllllllllllllIIlIllllIIlIllIIl.getId() != null) {
            lllllllllllllllIIlIllllIIlIllIlI.setString("Id", lllllllllllllllIIlIllllIIlIllIIl.getId().toString());
        }
        if (!lllllllllllllllIIlIllllIIlIllIIl.getProperties().isEmpty()) {
            final NBTTagCompound lllllllllllllllIIlIllllIIlIlllll = new NBTTagCompound();
            for (final String lllllllllllllllIIlIllllIIlIllllI : lllllllllllllllIIlIllllIIlIllIIl.getProperties().keySet()) {
                final NBTTagList lllllllllllllllIIlIllllIIlIlllIl = new NBTTagList();
                for (final Property lllllllllllllllIIlIllllIIlIlllII : lllllllllllllllIIlIllllIIlIllIIl.getProperties().get((Object)lllllllllllllllIIlIllllIIlIllllI)) {
                    final NBTTagCompound lllllllllllllllIIlIllllIIlIllIll = new NBTTagCompound();
                    lllllllllllllllIIlIllllIIlIllIll.setString("Value", lllllllllllllllIIlIllllIIlIlllII.getValue());
                    if (lllllllllllllllIIlIllllIIlIlllII.hasSignature()) {
                        lllllllllllllllIIlIllllIIlIllIll.setString("Signature", lllllllllllllllIIlIllllIIlIlllII.getSignature());
                    }
                    lllllllllllllllIIlIllllIIlIlllIl.appendTag(lllllllllllllllIIlIllllIIlIllIll);
                }
                lllllllllllllllIIlIllllIIlIlllll.setTag(lllllllllllllllIIlIllllIIlIllllI, lllllllllllllllIIlIllllIIlIlllIl);
            }
            lllllllllllllllIIlIllllIIlIllIlI.setTag("Properties", lllllllllllllllIIlIllllIIlIlllll);
        }
        return lllllllllllllllIIlIllllIIlIllIlI;
    }
    
    @VisibleForTesting
    public static boolean areNBTEquals(final NBTBase lllllllllllllllIIlIllllIIlIIlIII, final NBTBase lllllllllllllllIIlIllllIIIlllIlI, final boolean lllllllllllllllIIlIllllIIIlllIIl) {
        if (lllllllllllllllIIlIllllIIlIIlIII == lllllllllllllllIIlIllllIIIlllIlI) {
            return true;
        }
        if (lllllllllllllllIIlIllllIIlIIlIII == null) {
            return true;
        }
        if (lllllllllllllllIIlIllllIIIlllIlI == null) {
            return false;
        }
        if (!lllllllllllllllIIlIllllIIlIIlIII.getClass().equals(lllllllllllllllIIlIllllIIIlllIlI.getClass())) {
            return false;
        }
        if (lllllllllllllllIIlIllllIIlIIlIII instanceof NBTTagCompound) {
            final NBTTagCompound lllllllllllllllIIlIllllIIlIIIlIl = (NBTTagCompound)lllllllllllllllIIlIllllIIlIIlIII;
            final NBTTagCompound lllllllllllllllIIlIllllIIlIIIlII = (NBTTagCompound)lllllllllllllllIIlIllllIIIlllIlI;
            for (final String lllllllllllllllIIlIllllIIlIIIIll : lllllllllllllllIIlIllllIIlIIIlIl.getKeySet()) {
                final NBTBase lllllllllllllllIIlIllllIIlIIIIlI = lllllllllllllllIIlIllllIIlIIIlIl.getTag(lllllllllllllllIIlIllllIIlIIIIll);
                if (!areNBTEquals(lllllllllllllllIIlIllllIIlIIIIlI, lllllllllllllllIIlIllllIIlIIIlII.getTag(lllllllllllllllIIlIllllIIlIIIIll), lllllllllllllllIIlIllllIIIlllIIl)) {
                    return false;
                }
            }
            return true;
        }
        if (!(lllllllllllllllIIlIllllIIlIIlIII instanceof NBTTagList) || !lllllllllllllllIIlIllllIIIlllIIl) {
            return lllllllllllllllIIlIllllIIlIIlIII.equals(lllllllllllllllIIlIllllIIIlllIlI);
        }
        final NBTTagList lllllllllllllllIIlIllllIIlIIIIIl = (NBTTagList)lllllllllllllllIIlIllllIIlIIlIII;
        final NBTTagList lllllllllllllllIIlIllllIIlIIIIII = (NBTTagList)lllllllllllllllIIlIllllIIIlllIlI;
        if (lllllllllllllllIIlIllllIIlIIIIIl.hasNoTags()) {
            return lllllllllllllllIIlIllllIIlIIIIII.hasNoTags();
        }
        for (int lllllllllllllllIIlIllllIIIllllll = 0; lllllllllllllllIIlIllllIIIllllll < lllllllllllllllIIlIllllIIlIIIIIl.tagCount(); ++lllllllllllllllIIlIllllIIIllllll) {
            final NBTBase lllllllllllllllIIlIllllIIIlllllI = lllllllllllllllIIlIllllIIlIIIIIl.get(lllllllllllllllIIlIllllIIIllllll);
            boolean lllllllllllllllIIlIllllIIIllllIl = false;
            for (int lllllllllllllllIIlIllllIIIllllII = 0; lllllllllllllllIIlIllllIIIllllII < lllllllllllllllIIlIllllIIlIIIIII.tagCount(); ++lllllllllllllllIIlIllllIIIllllII) {
                if (areNBTEquals(lllllllllllllllIIlIllllIIIlllllI, lllllllllllllllIIlIllllIIlIIIIII.get(lllllllllllllllIIlIllllIIIllllII), lllllllllllllllIIlIllllIIIlllIIl)) {
                    lllllllllllllllIIlIllllIIIllllIl = true;
                    break;
                }
            }
            if (!lllllllllllllllIIlIllllIIIllllIl) {
                return false;
            }
        }
        return true;
    }
    
    static {
        field_193591_a = LogManager.getLogger();
    }
    
    private static <T extends Comparable<T>> String getName(final IProperty<T> lllllllllllllllIIlIlllIllllIIIIl, final Comparable<?> lllllllllllllllIIlIlllIllllIIIII) {
        return lllllllllllllllIIlIlllIllllIIIIl.getName((T)lllllllllllllllIIlIlllIllllIIIII);
    }
    
    public static UUID getUUIDFromTag(final NBTTagCompound lllllllllllllllIIlIllllIIIlIlIll) {
        return new UUID(lllllllllllllllIIlIllllIIIlIlIll.getLong("M"), lllllllllllllllIIlIllllIIIlIlIll.getLong("L"));
    }
    
    public static BlockPos getPosFromTag(final NBTTagCompound lllllllllllllllIIlIllllIIIlIlIII) {
        return new BlockPos(lllllllllllllllIIlIllllIIIlIlIII.getInteger("X"), lllllllllllllllIIlIllllIIIlIlIII.getInteger("Y"), lllllllllllllllIIlIllllIIIlIlIII.getInteger("Z"));
    }
    
    public static IBlockState readBlockState(final NBTTagCompound lllllllllllllllIIlIllllIIIIlIIIl) {
        if (!lllllllllllllllIIlIllllIIIIlIIIl.hasKey("Name", 8)) {
            return Blocks.AIR.getDefaultState();
        }
        final Block lllllllllllllllIIlIllllIIIIlIlll = Block.REGISTRY.getObject(new ResourceLocation(lllllllllllllllIIlIllllIIIIlIIIl.getString("Name")));
        IBlockState lllllllllllllllIIlIllllIIIIlIllI = lllllllllllllllIIlIllllIIIIlIlll.getDefaultState();
        if (lllllllllllllllIIlIllllIIIIlIIIl.hasKey("Properties", 10)) {
            final NBTTagCompound lllllllllllllllIIlIllllIIIIlIlIl = lllllllllllllllIIlIllllIIIIlIIIl.getCompoundTag("Properties");
            final BlockStateContainer lllllllllllllllIIlIllllIIIIlIlII = lllllllllllllllIIlIllllIIIIlIlll.getBlockState();
            for (final String lllllllllllllllIIlIllllIIIIlIIll : lllllllllllllllIIlIllllIIIIlIlIl.getKeySet()) {
                final IProperty<?> lllllllllllllllIIlIllllIIIIlIIlI = lllllllllllllllIIlIllllIIIIlIlII.getProperty(lllllllllllllllIIlIllllIIIIlIIll);
                if (lllllllllllllllIIlIllllIIIIlIIlI != null) {
                    lllllllllllllllIIlIllllIIIIlIllI = func_193590_a(lllllllllllllllIIlIllllIIIIlIllI, lllllllllllllllIIlIllllIIIIlIIlI, lllllllllllllllIIlIllllIIIIlIIll, lllllllllllllllIIlIllllIIIIlIlIl, lllllllllllllllIIlIllllIIIIlIIIl);
                }
            }
        }
        return lllllllllllllllIIlIllllIIIIlIllI;
    }
    
    private static <T extends Comparable<T>> IBlockState func_193590_a(final IBlockState lllllllllllllllIIlIllllIIIIIIIll, final IProperty<T> lllllllllllllllIIlIlllIlllllllII, final String lllllllllllllllIIlIllllIIIIIIIIl, final NBTTagCompound lllllllllllllllIIlIllllIIIIIIIII, final NBTTagCompound lllllllllllllllIIlIlllIllllllIIl) {
        final Optional<T> lllllllllllllllIIlIlllIllllllllI = lllllllllllllllIIlIlllIlllllllII.parseValue(lllllllllllllllIIlIllllIIIIIIIII.getString(lllllllllllllllIIlIllllIIIIIIIIl));
        if (lllllllllllllllIIlIlllIllllllllI.isPresent()) {
            return lllllllllllllllIIlIllllIIIIIIIll.withProperty(lllllllllllllllIIlIlllIlllllllII, lllllllllllllllIIlIlllIllllllllI.get());
        }
        NBTUtil.field_193591_a.warn("Unable to read property: {} with value: {} for blockstate: {}", (Object)lllllllllllllllIIlIllllIIIIIIIIl, (Object)lllllllllllllllIIlIllllIIIIIIIII.getString(lllllllllllllllIIlIllllIIIIIIIIl), (Object)lllllllllllllllIIlIlllIllllllIIl.toString());
        return lllllllllllllllIIlIllllIIIIIIIll;
    }
    
    public static NBTTagCompound createPosTag(final BlockPos lllllllllllllllIIlIllllIIIlIIlII) {
        final NBTTagCompound lllllllllllllllIIlIllllIIIlIIIll = new NBTTagCompound();
        lllllllllllllllIIlIllllIIIlIIIll.setInteger("X", lllllllllllllllIIlIllllIIIlIIlII.getX());
        lllllllllllllllIIlIllllIIIlIIIll.setInteger("Y", lllllllllllllllIIlIllllIIIlIIlII.getY());
        lllllllllllllllIIlIllllIIIlIIIll.setInteger("Z", lllllllllllllllIIlIllllIIIlIIlII.getZ());
        return lllllllllllllllIIlIllllIIIlIIIll;
    }
}
