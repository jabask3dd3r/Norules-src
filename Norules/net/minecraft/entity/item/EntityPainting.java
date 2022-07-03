package net.minecraft.entity.item;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import java.util.*;

public class EntityPainting extends EntityHanging
{
    public /* synthetic */ EnumArt art;
    
    public EntityPainting(final World lllllllllllllIIlIlIllllIllIIlllI, final BlockPos lllllllllllllIIlIlIllllIllIIllIl, final EnumFacing lllllllllllllIIlIlIllllIllIIIllI, final String lllllllllllllIIlIlIllllIllIIIlIl) {
        this(lllllllllllllIIlIlIllllIllIIlllI, lllllllllllllIIlIlIllllIllIIllIl, lllllllllllllIIlIlIllllIllIIIllI);
        final Exception lllllllllllllIIlIlIllllIllIIIIIl;
        final byte lllllllllllllIIlIlIllllIllIIIIlI = (byte)((EnumArt[])(Object)(lllllllllllllIIlIlIllllIllIIIIIl = (Exception)(Object)EnumArt.values())).length;
        for (float lllllllllllllIIlIlIllllIllIIIIll = 0; lllllllllllllIIlIlIllllIllIIIIll < lllllllllllllIIlIlIllllIllIIIIlI; ++lllllllllllllIIlIlIllllIllIIIIll) {
            final EnumArt lllllllllllllIIlIlIllllIllIIlIlI = lllllllllllllIIlIlIllllIllIIIIIl[lllllllllllllIIlIlIllllIllIIIIll];
            if (lllllllllllllIIlIlIllllIllIIlIlI.title.equals(lllllllllllllIIlIlIllllIllIIIlIl)) {
                this.art = lllllllllllllIIlIlIllllIllIIlIlI;
                break;
            }
        }
        this.updateFacingWithBoundingBox(lllllllllllllIIlIlIllllIllIIIllI);
    }
    
    @Override
    public void setLocationAndAngles(final double lllllllllllllIIlIlIllllIlIIlIIIl, final double lllllllllllllIIlIlIllllIlIIIlIlI, final double lllllllllllllIIlIlIllllIlIIIlIIl, final float lllllllllllllIIlIlIllllIlIIIlllI, final float lllllllllllllIIlIlIllllIlIIIllIl) {
        this.setPosition(lllllllllllllIIlIlIllllIlIIlIIIl, lllllllllllllIIlIlIllllIlIIIlIlI, lllllllllllllIIlIlIllllIlIIIlIIl);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIlIlIllllIlIlIlllI) {
        final String lllllllllllllIIlIlIllllIlIllIIIl = lllllllllllllIIlIlIllllIlIlIlllI.getString("Motive");
        boolean lllllllllllllIIlIlIllllIlIlIlIIl;
        for (String lllllllllllllIIlIlIllllIlIlIlIlI = (String)((EnumArt[])(Object)(lllllllllllllIIlIlIllllIlIlIlIIl = (boolean)(Object)EnumArt.values())).length, lllllllllllllIIlIlIllllIlIlIlIll = (String)0; lllllllllllllIIlIlIllllIlIlIlIll < lllllllllllllIIlIlIllllIlIlIlIlI; ++lllllllllllllIIlIlIllllIlIlIlIll) {
            final EnumArt lllllllllllllIIlIlIllllIlIllIIII = lllllllllllllIIlIlIllllIlIlIlIIl[lllllllllllllIIlIlIllllIlIlIlIll];
            if (lllllllllllllIIlIlIllllIlIllIIII.title.equals(lllllllllllllIIlIlIllllIlIllIIIl)) {
                this.art = lllllllllllllIIlIlIllllIlIllIIII;
            }
        }
        if (this.art == null) {
            this.art = EnumArt.KEBAB;
        }
        super.readEntityFromNBT(lllllllllllllIIlIlIllllIlIlIlllI);
    }
    
    @Override
    public void playPlaceSound() {
        this.playSound(SoundEvents.ENTITY_PAINTING_PLACE, 1.0f, 1.0f);
    }
    
    @Override
    public void onBroken(@Nullable final Entity lllllllllllllIIlIlIllllIlIIllIll) {
        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
            this.playSound(SoundEvents.ENTITY_PAINTING_BREAK, 1.0f, 1.0f);
            if (lllllllllllllIIlIlIllllIlIIllIll instanceof EntityPlayer) {
                final EntityPlayer lllllllllllllIIlIlIllllIlIIlllIl = (EntityPlayer)lllllllllllllIIlIlIllllIlIIllIll;
                if (lllllllllllllIIlIlIllllIlIIlllIl.capabilities.isCreativeMode) {
                    return;
                }
            }
            this.entityDropItem(new ItemStack(Items.PAINTING), 0.0f);
        }
    }
    
    @Override
    public int getWidthPixels() {
        return this.art.sizeX;
    }
    
    public EntityPainting(final World lllllllllllllIIlIlIllllIlllIllII, final BlockPos lllllllllllllIIlIlIllllIlllIIIIl, final EnumFacing lllllllllllllIIlIlIllllIlllIlIlI) {
        super(lllllllllllllIIlIlIllllIlllIllII, lllllllllllllIIlIlIllllIlllIIIIl);
        final List<EnumArt> lllllllllllllIIlIlIllllIlllIlIIl = (List<EnumArt>)Lists.newArrayList();
        int lllllllllllllIIlIlIllllIlllIlIII = 0;
        String lllllllllllllIIlIlIllllIllIllIlI;
        for (byte lllllllllllllIIlIlIllllIllIllIll = (byte)((EnumArt[])(Object)(lllllllllllllIIlIlIllllIllIllIlI = (String)(Object)EnumArt.values())).length, b = 0; b < lllllllllllllIIlIlIllllIllIllIll; ++b) {
            final EnumArt lllllllllllllIIlIlIllllIlllIIlll = lllllllllllllIIlIlIllllIllIllIlI[b];
            this.art = lllllllllllllIIlIlIllllIlllIIlll;
            this.updateFacingWithBoundingBox(lllllllllllllIIlIlIllllIlllIlIlI);
            if (this.onValidSurface()) {
                lllllllllllllIIlIlIllllIlllIlIIl.add(lllllllllllllIIlIlIllllIlllIIlll);
                final int lllllllllllllIIlIlIllllIlllIIllI = lllllllllllllIIlIlIllllIlllIIlll.sizeX * lllllllllllllIIlIlIllllIlllIIlll.sizeY;
                if (lllllllllllllIIlIlIllllIlllIIllI > lllllllllllllIIlIlIllllIlllIlIII) {
                    lllllllllllllIIlIlIllllIlllIlIII = lllllllllllllIIlIlIllllIlllIIllI;
                }
            }
        }
        if (!lllllllllllllIIlIlIllllIlllIlIIl.isEmpty()) {
            final Iterator<EnumArt> lllllllllllllIIlIlIllllIlllIIlIl = lllllllllllllIIlIlIllllIlllIlIIl.iterator();
            while (lllllllllllllIIlIlIllllIlllIIlIl.hasNext()) {
                final EnumArt lllllllllllllIIlIlIllllIlllIIlII = lllllllllllllIIlIlIllllIlllIIlIl.next();
                if (lllllllllllllIIlIlIllllIlllIIlII.sizeX * lllllllllllllIIlIlIllllIlllIIlII.sizeY < lllllllllllllIIlIlIllllIlllIlIII) {
                    lllllllllllllIIlIlIllllIlllIIlIl.remove();
                }
            }
            this.art = lllllllllllllIIlIlIllllIlllIlIIl.get(this.rand.nextInt(lllllllllllllIIlIlIllllIlllIlIIl.size()));
        }
        this.updateFacingWithBoundingBox(lllllllllllllIIlIlIllllIlllIlIlI);
    }
    
    public EntityPainting(final World lllllllllllllIIlIlIllllIlllllIll) {
        super(lllllllllllllIIlIlIllllIlllllIll);
    }
    
    @Override
    public int getHeightPixels() {
        return this.art.sizeY;
    }
    
    @Override
    public void setPositionAndRotationDirect(final double lllllllllllllIIlIlIllllIIllllIIl, final double lllllllllllllIIlIlIllllIlIIIIIIl, final double lllllllllllllIIlIlIllllIIlllIlll, final float lllllllllllllIIlIlIllllIIlllllll, final float lllllllllllllIIlIlIllllIIllllllI, final int lllllllllllllIIlIlIllllIIlllllIl, final boolean lllllllllllllIIlIlIllllIIlllllII) {
        final BlockPos lllllllllllllIIlIlIllllIIllllIll = this.hangingPosition.add(lllllllllllllIIlIlIllllIIllllIIl - this.posX, lllllllllllllIIlIlIllllIlIIIIIIl - this.posY, lllllllllllllIIlIlIllllIIlllIlll - this.posZ);
        this.setPosition(lllllllllllllIIlIlIllllIIllllIll.getX(), lllllllllllllIIlIlIllllIIllllIll.getY(), lllllllllllllIIlIlIllllIIllllIll.getZ());
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIlIlIllllIlIlllIll) {
        lllllllllllllIIlIlIllllIlIlllIll.setString("Motive", this.art.title);
        super.writeEntityToNBT(lllllllllllllIIlIlIllllIlIlllIll);
    }
    
    public enum EnumArt
    {
        public final /* synthetic */ String title;
        
        BURNING_SKULL("BURNING_SKULL", 23, "BurningSkull", 64, 64, 128, 192), 
        BOMB("BOMB", 4, "Bomb", 16, 16, 64, 0), 
        KEBAB("KEBAB", 0, "Kebab", 16, 16, 0, 0), 
        PLANT("PLANT", 5, "Plant", 16, 16, 80, 0), 
        DONKEY_KONG("DONKEY_KONG", 25, "DonkeyKong", 64, 48, 192, 112);
        
        public final /* synthetic */ int offsetY;
        
        BUST("BUST", 15, "Bust", 32, 32, 32, 128), 
        VOID("VOID", 17, "Void", 32, 32, 96, 128), 
        ALBAN("ALBAN", 2, "Alban", 16, 16, 32, 0), 
        WASTELAND("WASTELAND", 6, "Wasteland", 16, 16, 96, 0), 
        PIGSCENE("PIGSCENE", 22, "Pigscene", 64, 64, 64, 192), 
        WANDERER("WANDERER", 12, "Wanderer", 16, 32, 0, 64), 
        SUNSET("SUNSET", 10, "Sunset", 32, 16, 96, 32), 
        SKULL_AND_ROSES("SKULL_AND_ROSES", 18, "SkullAndRoses", 32, 32, 128, 128), 
        MATCH("MATCH", 14, "Match", 32, 32, 0, 128), 
        GRAHAM("GRAHAM", 13, "Graham", 16, 32, 16, 64), 
        COURBET("COURBET", 8, "Courbet", 32, 16, 32, 32), 
        AZTEC_2("AZTEC_2", 3, "Aztec2", 16, 16, 48, 0), 
        CREEBET("CREEBET", 11, "Creebet", 32, 16, 128, 32), 
        FIGHTERS("FIGHTERS", 20, "Fighters", 64, 32, 0, 96), 
        WITHER("WITHER", 19, "Wither", 32, 32, 160, 128);
        
        public final /* synthetic */ int sizeY;
        
        SEA("SEA", 9, "Sea", 32, 16, 64, 32);
        
        public final /* synthetic */ int sizeX;
        
        STAGE("STAGE", 16, "Stage", 32, 32, 64, 128), 
        AZTEC("AZTEC", 1, "Aztec", 16, 16, 16, 0), 
        SKELETON("SKELETON", 24, "Skeleton", 64, 48, 192, 64), 
        POINTER("POINTER", 21, "Pointer", 64, 64, 0, 192);
        
        public final /* synthetic */ int offsetX;
        
        POOL("POOL", 7, "Pool", 32, 16, 0, 32);
        
        private EnumArt(final String llllllllllllllIIlllIllIIlIIlllIl, final int llllllllllllllIIlllIllIIlIIlllII, final String llllllllllllllIIlllIllIIlIIllIll, final int llllllllllllllIIlllIllIIlIlIIIlI, final int llllllllllllllIIlllIllIIlIlIIIIl, final int llllllllllllllIIlllIllIIlIlIIIII, final int llllllllllllllIIlllIllIIlIIlllll) {
            this.title = llllllllllllllIIlllIllIIlIIllIll;
            this.sizeX = llllllllllllllIIlllIllIIlIlIIIlI;
            this.sizeY = llllllllllllllIIlllIllIIlIlIIIIl;
            this.offsetX = llllllllllllllIIlllIllIIlIlIIIII;
            this.offsetY = llllllllllllllIIlllIllIIlIIlllll;
        }
        
        static {
            MAX_NAME_LENGTH = "SkullAndRoses".length();
        }
    }
}
