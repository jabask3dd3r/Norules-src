package net.minecraft.client.renderer.texture;

import net.minecraft.util.math.*;
import optifine.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.*;
import java.util.*;

public class Stitcher
{
    private final /* synthetic */ int mipmapLevelStitcher;
    private final /* synthetic */ int maxHeight;
    private final /* synthetic */ List<Slot> stitchSlots;
    private /* synthetic */ int currentWidth;
    private final /* synthetic */ int maxWidth;
    private final /* synthetic */ int maxTileDimension;
    private final /* synthetic */ Set<Holder> setStitchHolders;
    private /* synthetic */ int currentHeight;
    
    private boolean expandAndAllocateSlot(final Holder lllllllllllllIIlIIIlIIlllIIlIIIl) {
        final int lllllllllllllIIlIIIlIIlllIIlIIII = Math.min(lllllllllllllIIlIIIlIIlllIIlIIIl.getWidth(), lllllllllllllIIlIIIlIIlllIIlIIIl.getHeight());
        final int lllllllllllllIIlIIIlIIlllIIIllll = Math.max(lllllllllllllIIlIIIlIIlllIIlIIIl.getWidth(), lllllllllllllIIlIIIlIIlllIIlIIIl.getHeight());
        final int lllllllllllllIIlIIIlIIlllIIIlllI = MathHelper.smallestEncompassingPowerOfTwo(this.currentWidth);
        final int lllllllllllllIIlIIIlIIlllIIIllIl = MathHelper.smallestEncompassingPowerOfTwo(this.currentHeight);
        final int lllllllllllllIIlIIIlIIlllIIIllII = MathHelper.smallestEncompassingPowerOfTwo(this.currentWidth + lllllllllllllIIlIIIlIIlllIIlIIII);
        final int lllllllllllllIIlIIIlIIlllIIIlIll = MathHelper.smallestEncompassingPowerOfTwo(this.currentHeight + lllllllllllllIIlIIIlIIlllIIlIIII);
        final boolean lllllllllllllIIlIIIlIIlllIIIlIlI = lllllllllllllIIlIIIlIIlllIIIllII <= this.maxWidth;
        final boolean lllllllllllllIIlIIIlIIlllIIIlIIl = lllllllllllllIIlIIIlIIlllIIIlIll <= this.maxHeight;
        if (!lllllllllllllIIlIIIlIIlllIIIlIlI && !lllllllllllllIIlIIIlIIlllIIIlIIl) {
            return false;
        }
        final int lllllllllllllIIlIIIlIIlllIIIlIII = MathUtils.roundDownToPowerOfTwo(this.currentHeight);
        boolean lllllllllllllIIlIIIlIIlllIIIIlll = lllllllllllllIIlIIIlIIlllIIIlIlI && lllllllllllllIIlIIIlIIlllIIIllII <= 2 * lllllllllllllIIlIIIlIIlllIIIlIII;
        if (this.currentWidth == 0 && this.currentHeight == 0) {
            lllllllllllllIIlIIIlIIlllIIIIlll = true;
        }
        Slot lllllllllllllIIlIIIlIIlllIIIIlIl = null;
        if (lllllllllllllIIlIIIlIIlllIIIIlll) {
            if (lllllllllllllIIlIIIlIIlllIIlIIIl.getWidth() > lllllllllllllIIlIIIlIIlllIIlIIIl.getHeight()) {
                lllllllllllllIIlIIIlIIlllIIlIIIl.rotate();
            }
            if (this.currentHeight == 0) {
                this.currentHeight = lllllllllllllIIlIIIlIIlllIIlIIIl.getHeight();
            }
            final Slot lllllllllllllIIlIIIlIIlllIIIIllI = new Slot(this.currentWidth, 0, lllllllllllllIIlIIIlIIlllIIlIIIl.getWidth(), this.currentHeight);
            this.currentWidth += lllllllllllllIIlIIIlIIlllIIlIIIl.getWidth();
        }
        else {
            lllllllllllllIIlIIIlIIlllIIIIlIl = new Slot(0, this.currentHeight, this.currentWidth, lllllllllllllIIlIIIlIIlllIIlIIIl.getHeight());
            this.currentHeight += lllllllllllllIIlIIIlIIlllIIlIIIl.getHeight();
        }
        lllllllllllllIIlIIIlIIlllIIIIlIl.addSlot(lllllllllllllIIlIIIlIIlllIIlIIIl);
        this.stitchSlots.add(lllllllllllllIIlIIIlIIlllIIIIlIl);
        return true;
    }
    
    public Stitcher(final int lllllllllllllIIlIIIlIIllllllIIll, final int lllllllllllllIIlIIIlIIllllllIIlI, final int lllllllllllllIIlIIIlIIlllllIllII, final int lllllllllllllIIlIIIlIIlllllIlIll) {
        this.setStitchHolders = (Set<Holder>)Sets.newHashSetWithExpectedSize(256);
        this.stitchSlots = (List<Slot>)Lists.newArrayListWithCapacity(256);
        this.mipmapLevelStitcher = lllllllllllllIIlIIIlIIlllllIlIll;
        this.maxWidth = lllllllllllllIIlIIIlIIllllllIIll;
        this.maxHeight = lllllllllllllIIlIIIlIIllllllIIlI;
        this.maxTileDimension = lllllllllllllIIlIIIlIIlllllIllII;
    }
    
    public int getCurrentHeight() {
        return this.currentHeight;
    }
    
    private boolean allocateSlot(final Holder lllllllllllllIIlIIIlIIlllIlIlIII) {
        final TextureAtlasSprite lllllllllllllIIlIIIlIIlllIlIIlll = lllllllllllllIIlIIIlIIlllIlIlIII.getAtlasSprite();
        final boolean lllllllllllllIIlIIIlIIlllIlIIllI = lllllllllllllIIlIIIlIIlllIlIIlll.getIconWidth() != lllllllllllllIIlIIIlIIlllIlIIlll.getIconHeight();
        for (int lllllllllllllIIlIIIlIIlllIlIIlIl = 0; lllllllllllllIIlIIIlIIlllIlIIlIl < this.stitchSlots.size(); ++lllllllllllllIIlIIIlIIlllIlIIlIl) {
            if (this.stitchSlots.get(lllllllllllllIIlIIIlIIlllIlIIlIl).addSlot(lllllllllllllIIlIIIlIIlllIlIlIII)) {
                return true;
            }
            if (lllllllllllllIIlIIIlIIlllIlIIllI) {
                lllllllllllllIIlIIIlIIlllIlIlIII.rotate();
                if (this.stitchSlots.get(lllllllllllllIIlIIIlIIlllIlIIlIl).addSlot(lllllllllllllIIlIIIlIIlllIlIlIII)) {
                    return true;
                }
                lllllllllllllIIlIIIlIIlllIlIlIII.rotate();
            }
        }
        return this.expandAndAllocateSlot(lllllllllllllIIlIIIlIIlllIlIlIII);
    }
    
    public List<TextureAtlasSprite> getStichSlots() {
        final List<Slot> lllllllllllllIIlIIIlIIllllIIIIIl = (List<Slot>)Lists.newArrayList();
        for (final Slot lllllllllllllIIlIIIlIIllllIIIIII : this.stitchSlots) {
            lllllllllllllIIlIIIlIIllllIIIIII.getAllStitchSlots(lllllllllllllIIlIIIlIIllllIIIIIl);
        }
        final List<TextureAtlasSprite> lllllllllllllIIlIIIlIIlllIllllll = (List<TextureAtlasSprite>)Lists.newArrayList();
        for (final Slot lllllllllllllIIlIIIlIIlllIlllllI : lllllllllllllIIlIIIlIIllllIIIIIl) {
            final Holder lllllllllllllIIlIIIlIIlllIllllIl = lllllllllllllIIlIIIlIIlllIlllllI.getStitchHolder();
            final TextureAtlasSprite lllllllllllllIIlIIIlIIlllIllllII = lllllllllllllIIlIIIlIIlllIllllIl.getAtlasSprite();
            lllllllllllllIIlIIIlIIlllIllllII.initSprite(this.currentWidth, this.currentHeight, lllllllllllllIIlIIIlIIlllIlllllI.getOriginX(), lllllllllllllIIlIIIlIIlllIlllllI.getOriginY(), lllllllllllllIIlIIIlIIlllIllllIl.isRotated());
            lllllllllllllIIlIIIlIIlllIllllll.add(lllllllllllllIIlIIIlIIlllIllllII);
        }
        return lllllllllllllIIlIIIlIIlllIllllll;
    }
    
    public void doStitch() {
        final Holder[] lllllllllllllIIlIIIlIIllllIlIIll = this.setStitchHolders.toArray(new Holder[this.setStitchHolders.size()]);
        Arrays.sort(lllllllllllllIIlIIIlIIllllIlIIll);
        final long lllllllllllllIIlIIIlIIllllIIlIll;
        final long lllllllllllllIIlIIIlIIllllIIllII = ((Holder[])(Object)(lllllllllllllIIlIIIlIIllllIIlIll = (long)(Object)lllllllllllllIIlIIIlIIllllIlIIll)).length;
        for (float lllllllllllllIIlIIIlIIllllIIllIl = 0; lllllllllllllIIlIIIlIIllllIIllIl < lllllllllllllIIlIIIlIIllllIIllII; ++lllllllllllllIIlIIIlIIllllIIllIl) {
            final Holder lllllllllllllIIlIIIlIIllllIlIIlI = lllllllllllllIIlIIIlIIllllIIlIll[lllllllllllllIIlIIIlIIllllIIllIl];
            if (!this.allocateSlot(lllllllllllllIIlIIIlIIllllIlIIlI)) {
                final String lllllllllllllIIlIIIlIIllllIlIIIl = String.format("Unable to fit: %s, size: %dx%d, atlas: %dx%d, atlasMax: %dx%d - Maybe try a lower resolution resourcepack?", lllllllllllllIIlIIIlIIllllIlIIlI.getAtlasSprite().getIconName(), lllllllllllllIIlIIIlIIllllIlIIlI.getAtlasSprite().getIconWidth(), lllllllllllllIIlIIIlIIllllIlIIlI.getAtlasSprite().getIconHeight(), this.currentWidth, this.currentHeight, this.maxWidth, this.maxHeight);
                throw new StitcherException(lllllllllllllIIlIIIlIIllllIlIIlI, lllllllllllllIIlIIIlIIllllIlIIIl);
            }
        }
        this.currentWidth = MathHelper.smallestEncompassingPowerOfTwo(this.currentWidth);
        this.currentHeight = MathHelper.smallestEncompassingPowerOfTwo(this.currentHeight);
    }
    
    public int getCurrentWidth() {
        return this.currentWidth;
    }
    
    public void addSprite(final TextureAtlasSprite lllllllllllllIIlIIIlIIlllllIIIII) {
        final Holder lllllllllllllIIlIIIlIIllllIlllll = new Holder(lllllllllllllIIlIIIlIIlllllIIIII, this.mipmapLevelStitcher);
        if (this.maxTileDimension > 0) {
            lllllllllllllIIlIIIlIIllllIlllll.setNewDimension(this.maxTileDimension);
        }
        this.setStitchHolders.add(lllllllllllllIIlIIIlIIllllIlllll);
    }
    
    private static int getMipmapDimension(final int lllllllllllllIIlIIIlIIlllIllIIII, final int lllllllllllllIIlIIIlIIlllIlIllll) {
        return (lllllllllllllIIlIIIlIIlllIllIIII >> lllllllllllllIIlIIIlIIlllIlIllll) + (((lllllllllllllIIlIIIlIIlllIllIIII & (1 << lllllllllllllIIlIIIlIIlllIlIllll) - 1) != 0x0) ? 1 : 0) << lllllllllllllIIlIIIlIIlllIlIllll;
    }
    
    public static class Holder implements Comparable<Holder>
    {
        private /* synthetic */ float scaleFactor;
        private final /* synthetic */ TextureAtlasSprite theTexture;
        private final /* synthetic */ int mipmapLevelHolder;
        private /* synthetic */ boolean rotated;
        private final /* synthetic */ int height;
        private final /* synthetic */ int width;
        
        public TextureAtlasSprite getAtlasSprite() {
            return this.theTexture;
        }
        
        public int getHeight() {
            final int lIIIllIlIIIIIl = this.rotated ? this.width : this.height;
            return getMipmapDimension((int)(lIIIllIlIIIIIl * this.scaleFactor), this.mipmapLevelHolder);
        }
        
        public void rotate() {
            this.rotated = !this.rotated;
        }
        
        public boolean isRotated() {
            return this.rotated;
        }
        
        public int getWidth() {
            final int lIIIllIlIIIlll = this.rotated ? this.height : this.width;
            return getMipmapDimension((int)(lIIIllIlIIIlll * this.scaleFactor), this.mipmapLevelHolder);
        }
        
        public void setNewDimension(final int lIIIllIIllIIll) {
            if (this.width > lIIIllIIllIIll && this.height > lIIIllIIllIIll) {
                this.scaleFactor = lIIIllIIllIIll / (float)Math.min(this.width, this.height);
            }
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("Holder{width=").append(this.width).append(", height=").append(this.height).append(", name=").append(this.theTexture.getIconName()).append('}'));
        }
        
        @Override
        public int compareTo(final Holder lIIIllIIlIlIll) {
            int lIIIllIIlIlIIl = 0;
            if (this.getHeight() == lIIIllIIlIlIll.getHeight()) {
                if (this.getWidth() == lIIIllIIlIlIll.getWidth()) {
                    if (this.theTexture.getIconName() == null) {
                        return (lIIIllIIlIlIll.theTexture.getIconName() == null) ? 0 : -1;
                    }
                    return this.theTexture.getIconName().compareTo(lIIIllIIlIlIll.theTexture.getIconName());
                }
                else {
                    final int lIIIllIIlIlIlI = (this.getWidth() < lIIIllIIlIlIll.getWidth()) ? 1 : -1;
                }
            }
            else {
                lIIIllIIlIlIIl = ((this.getHeight() < lIIIllIIlIlIll.getHeight()) ? 1 : -1);
            }
            return lIIIllIIlIlIIl;
        }
        
        public Holder(final TextureAtlasSprite lIIIllIlIlIIlI, final int lIIIllIlIlIIIl) {
            this.scaleFactor = 1.0f;
            this.theTexture = lIIIllIlIlIIlI;
            this.width = lIIIllIlIlIIlI.getIconWidth();
            this.height = lIIIllIlIlIIlI.getIconHeight();
            this.mipmapLevelHolder = lIIIllIlIlIIIl;
            this.rotated = (getMipmapDimension(this.height, lIIIllIlIlIIIl) > getMipmapDimension(this.width, lIIIllIlIlIIIl));
        }
    }
    
    public static class Slot
    {
        private /* synthetic */ Holder holder;
        private /* synthetic */ List<Slot> subSlots;
        private final /* synthetic */ int height;
        private final /* synthetic */ int originY;
        private final /* synthetic */ int originX;
        private final /* synthetic */ int width;
        
        public boolean addSlot(final Holder lIllllIIIllIIll) {
            if (this.holder != null) {
                return false;
            }
            final int lIllllIIIllIIlI = lIllllIIIllIIll.getWidth();
            final int lIllllIIIllIIIl = lIllllIIIllIIll.getHeight();
            if (lIllllIIIllIIlI > this.width || lIllllIIIllIIIl > this.height) {
                return false;
            }
            if (lIllllIIIllIIlI == this.width && lIllllIIIllIIIl == this.height) {
                this.holder = lIllllIIIllIIll;
                return true;
            }
            if (this.subSlots == null) {
                this.subSlots = (List<Slot>)Lists.newArrayListWithCapacity(1);
                this.subSlots.add(new Slot(this.originX, this.originY, lIllllIIIllIIlI, lIllllIIIllIIIl));
                final int lIllllIIIllIIII = this.width - lIllllIIIllIIlI;
                final int lIllllIIIlIllll = this.height - lIllllIIIllIIIl;
                if (lIllllIIIlIllll > 0 && lIllllIIIllIIII > 0) {
                    final int lIllllIIIlIlllI = Math.max(this.height, lIllllIIIllIIII);
                    final int lIllllIIIlIllIl = Math.max(this.width, lIllllIIIlIllll);
                    if (lIllllIIIlIlllI >= lIllllIIIlIllIl) {
                        this.subSlots.add(new Slot(this.originX, this.originY + lIllllIIIllIIIl, lIllllIIIllIIlI, lIllllIIIlIllll));
                        this.subSlots.add(new Slot(this.originX + lIllllIIIllIIlI, this.originY, lIllllIIIllIIII, this.height));
                    }
                    else {
                        this.subSlots.add(new Slot(this.originX + lIllllIIIllIIlI, this.originY, lIllllIIIllIIII, lIllllIIIllIIIl));
                        this.subSlots.add(new Slot(this.originX, this.originY + lIllllIIIllIIIl, this.width, lIllllIIIlIllll));
                    }
                }
                else if (lIllllIIIllIIII == 0) {
                    this.subSlots.add(new Slot(this.originX, this.originY + lIllllIIIllIIIl, lIllllIIIllIIlI, lIllllIIIlIllll));
                }
                else if (lIllllIIIlIllll == 0) {
                    this.subSlots.add(new Slot(this.originX + lIllllIIIllIIlI, this.originY, lIllllIIIllIIII, lIllllIIIllIIIl));
                }
            }
            for (final Slot lIllllIIIlIllII : this.subSlots) {
                if (lIllllIIIlIllII.addSlot(lIllllIIIllIIll)) {
                    return true;
                }
            }
            return false;
        }
        
        public int getOriginY() {
            return this.originY;
        }
        
        public void getAllStitchSlots(final List<Slot> lIllllIIIIllIll) {
            if (this.holder != null) {
                lIllllIIIIllIll.add(this);
            }
            else if (this.subSlots != null) {
                for (final Slot lIllllIIIIlllIl : this.subSlots) {
                    lIllllIIIIlllIl.getAllStitchSlots(lIllllIIIIllIll);
                }
            }
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("Slot{originX=").append(this.originX).append(", originY=").append(this.originY).append(", width=").append(this.width).append(", height=").append(this.height).append(", texture=").append(this.holder).append(", subSlots=").append(this.subSlots).append('}'));
        }
        
        public int getOriginX() {
            return this.originX;
        }
        
        public Slot(final int lIllllIIlIIlIIl, final int lIllllIIlIIllIl, final int lIllllIIlIIIlll, final int lIllllIIlIIIllI) {
            this.originX = lIllllIIlIIlIIl;
            this.originY = lIllllIIlIIllIl;
            this.width = lIllllIIlIIIlll;
            this.height = lIllllIIlIIIllI;
        }
        
        public Holder getStitchHolder() {
            return this.holder;
        }
    }
}
