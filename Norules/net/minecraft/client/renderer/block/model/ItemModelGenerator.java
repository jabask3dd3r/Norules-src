package net.minecraft.client.renderer.block.model;

import com.google.common.collect.*;
import org.lwjgl.util.vector.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import java.util.*;
import javax.annotation.*;

public class ItemModelGenerator
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing;
    public static final /* synthetic */ List<String> LAYERS;
    
    private void createOrExpandSpan(final List<Span> lllllllllllllIlIlIIIlllIllIllIlI, final SpanFacing lllllllllllllIlIlIIIlllIllIllIIl, final int lllllllllllllIlIlIIIlllIllIIllll, final int lllllllllllllIlIlIIIlllIllIIlllI) {
        Span lllllllllllllIlIlIIIlllIllIlIllI = null;
        for (final Span lllllllllllllIlIlIIIlllIllIlIlIl : lllllllllllllIlIlIIIlllIllIllIlI) {
            if (lllllllllllllIlIlIIIlllIllIlIlIl.getFacing() == lllllllllllllIlIlIIIlllIllIllIIl) {
                final int lllllllllllllIlIlIIIlllIllIlIlII = lllllllllllllIlIlIIIlllIllIllIIl.isHorizontal() ? lllllllllllllIlIlIIIlllIllIIlllI : lllllllllllllIlIlIIIlllIllIIllll;
                if (lllllllllllllIlIlIIIlllIllIlIlIl.getAnchor() == lllllllllllllIlIlIIIlllIllIlIlII) {
                    lllllllllllllIlIlIIIlllIllIlIllI = lllllllllllllIlIlIIIlllIllIlIlIl;
                    break;
                }
                continue;
            }
        }
        final int lllllllllllllIlIlIIIlllIllIlIIll = lllllllllllllIlIlIIIlllIllIllIIl.isHorizontal() ? lllllllllllllIlIlIIIlllIllIIlllI : lllllllllllllIlIlIIIlllIllIIllll;
        final int lllllllllllllIlIlIIIlllIllIlIIlI = lllllllllllllIlIlIIIlllIllIllIIl.isHorizontal() ? lllllllllllllIlIlIIIlllIllIIllll : lllllllllllllIlIlIIIlllIllIIlllI;
        if (lllllllllllllIlIlIIIlllIllIlIllI == null) {
            lllllllllllllIlIlIIIlllIllIllIlI.add(new Span(lllllllllllllIlIlIIIlllIllIllIIl, lllllllllllllIlIlIIIlllIllIlIIlI, lllllllllllllIlIlIIIlllIllIlIIll));
        }
        else {
            lllllllllllllIlIlIIIlllIllIlIllI.expand(lllllllllllllIlIlIIIlllIllIlIIlI);
        }
    }
    
    private List<BlockPart> getBlockParts(final TextureAtlasSprite lllllllllllllIlIlIIIllllIlIlIIIl, final String lllllllllllllIlIlIIIllllIlIIllll, final int lllllllllllllIlIlIIIllllIllIlllI) {
        final float lllllllllllllIlIlIIIllllIllIllII = (float)lllllllllllllIlIlIIIllllIlIlIIIl.getIconWidth();
        final float lllllllllllllIlIlIIIllllIllIlIlI = (float)lllllllllllllIlIlIIIllllIlIlIIIl.getIconHeight();
        final List<BlockPart> lllllllllllllIlIlIIIllllIllIlIII = (List<BlockPart>)Lists.newArrayList();
        for (final Span lllllllllllllIlIlIIIllllIllIIlll : this.getSpans(lllllllllllllIlIlIIIllllIlIlIIIl)) {
            float lllllllllllllIlIlIIIllllIllIIllI = 0.0f;
            float lllllllllllllIlIlIIIllllIllIIlIl = 0.0f;
            float lllllllllllllIlIlIIIllllIllIIlII = 0.0f;
            float lllllllllllllIlIlIIIllllIllIIIll = 0.0f;
            float lllllllllllllIlIlIIIllllIllIIIlI = 0.0f;
            float lllllllllllllIlIlIIIllllIllIIIIl = 0.0f;
            float lllllllllllllIlIlIIIllllIllIIIII = 0.0f;
            float lllllllllllllIlIlIIIllllIlIlllll = 0.0f;
            float lllllllllllllIlIlIIIllllIlIllllI = 0.0f;
            float lllllllllllllIlIlIIIllllIlIlllIl = 0.0f;
            final float lllllllllllllIlIlIIIllllIlIlllII = (float)lllllllllllllIlIlIIIllllIllIIlll.getMin();
            final float lllllllllllllIlIlIIIllllIlIllIll = (float)lllllllllllllIlIlIIIllllIllIIlll.getMax();
            final float lllllllllllllIlIlIIIllllIlIllIlI = (float)lllllllllllllIlIlIIIllllIllIIlll.getAnchor();
            final SpanFacing lllllllllllllIlIlIIIllllIlIllIIl = lllllllllllllIlIlIIIllllIllIIlll.getFacing();
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing()[lllllllllllllIlIlIIIllllIlIllIIl.ordinal()]) {
                case 1: {
                    lllllllllllllIlIlIIIllllIllIIIlI = lllllllllllllIlIlIIIllllIlIlllII;
                    lllllllllllllIlIlIIIllllIllIIllI = lllllllllllllIlIlIIIllllIlIlllII;
                    lllllllllllllIlIlIIIllllIllIIIIl = (lllllllllllllIlIlIIIllllIllIIlII = lllllllllllllIlIlIIIllllIlIllIll + 1.0f);
                    lllllllllllllIlIlIIIllllIllIIIII = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIlIl = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIlIlllll = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIIll = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIlIllllI = 16.0f / lllllllllllllIlIlIIIllllIllIllII;
                    lllllllllllllIlIlIIIllllIlIlllIl = 16.0f / (lllllllllllllIlIlIIIllllIllIlIlI - 1.0f);
                    break;
                }
                case 2: {
                    lllllllllllllIlIlIIIllllIlIlllll = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIIII = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIIlI = lllllllllllllIlIlIIIllllIlIlllII;
                    lllllllllllllIlIlIIIllllIllIIllI = lllllllllllllIlIlIIIllllIlIlllII;
                    lllllllllllllIlIlIIIllllIllIIIIl = (lllllllllllllIlIlIIIllllIllIIlII = lllllllllllllIlIlIIIllllIlIllIll + 1.0f);
                    lllllllllllllIlIlIIIllllIllIIlIl = lllllllllllllIlIlIIIllllIlIllIlI + 1.0f;
                    lllllllllllllIlIlIIIllllIllIIIll = lllllllllllllIlIlIIIllllIlIllIlI + 1.0f;
                    lllllllllllllIlIlIIIllllIlIllllI = 16.0f / lllllllllllllIlIlIIIllllIllIllII;
                    lllllllllllllIlIlIIIllllIlIlllIl = 16.0f / (lllllllllllllIlIlIIIllllIllIlIlI - 1.0f);
                    break;
                }
                case 3: {
                    lllllllllllllIlIlIIIllllIllIIIlI = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIllI = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIIIl = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIlII = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIlIlllll = lllllllllllllIlIlIIIllllIlIlllII;
                    lllllllllllllIlIlIIIllllIllIIlIl = lllllllllllllIlIlIIIllllIlIlllII;
                    lllllllllllllIlIlIIIllllIllIIIII = (lllllllllllllIlIlIIIllllIllIIIll = lllllllllllllIlIlIIIllllIlIllIll + 1.0f);
                    lllllllllllllIlIlIIIllllIlIllllI = 16.0f / (lllllllllllllIlIlIIIllllIllIllII - 1.0f);
                    lllllllllllllIlIlIIIllllIlIlllIl = 16.0f / lllllllllllllIlIlIIIllllIllIlIlI;
                    break;
                }
                case 4: {
                    lllllllllllllIlIlIIIllllIllIIIIl = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIIlI = lllllllllllllIlIlIIIllllIlIllIlI;
                    lllllllllllllIlIlIIIllllIllIIllI = lllllllllllllIlIlIIIllllIlIllIlI + 1.0f;
                    lllllllllllllIlIlIIIllllIllIIlII = lllllllllllllIlIlIIIllllIlIllIlI + 1.0f;
                    lllllllllllllIlIlIIIllllIlIlllll = lllllllllllllIlIlIIIllllIlIlllII;
                    lllllllllllllIlIlIIIllllIllIIlIl = lllllllllllllIlIlIIIllllIlIlllII;
                    lllllllllllllIlIlIIIllllIllIIIII = (lllllllllllllIlIlIIIllllIllIIIll = lllllllllllllIlIlIIIllllIlIllIll + 1.0f);
                    lllllllllllllIlIlIIIllllIlIllllI = 16.0f / (lllllllllllllIlIlIIIllllIllIllII - 1.0f);
                    lllllllllllllIlIlIIIllllIlIlllIl = 16.0f / lllllllllllllIlIlIIIllllIllIlIlI;
                    break;
                }
            }
            final float lllllllllllllIlIlIIIllllIlIllIII = 16.0f / lllllllllllllIlIlIIIllllIllIllII;
            final float lllllllllllllIlIlIIIllllIlIlIllI = 16.0f / lllllllllllllIlIlIIIllllIllIlIlI;
            lllllllllllllIlIlIIIllllIllIIllI *= lllllllllllllIlIlIIIllllIlIllIII;
            lllllllllllllIlIlIIIllllIllIIlII *= lllllllllllllIlIlIIIllllIlIllIII;
            lllllllllllllIlIlIIIllllIllIIlIl *= lllllllllllllIlIlIIIllllIlIlIllI;
            lllllllllllllIlIlIIIllllIllIIIll *= lllllllllllllIlIlIIIllllIlIlIllI;
            lllllllllllllIlIlIIIllllIllIIlIl = 16.0f - lllllllllllllIlIlIIIllllIllIIlIl;
            lllllllllllllIlIlIIIllllIllIIIll = 16.0f - lllllllllllllIlIlIIIllllIllIIIll;
            lllllllllllllIlIlIIIllllIllIIIlI *= lllllllllllllIlIlIIIllllIlIllllI;
            lllllllllllllIlIlIIIllllIllIIIIl *= lllllllllllllIlIlIIIllllIlIllllI;
            lllllllllllllIlIlIIIllllIllIIIII *= lllllllllllllIlIlIIIllllIlIlllIl;
            lllllllllllllIlIlIIIllllIlIlllll *= lllllllllllllIlIlIIIllllIlIlllIl;
            final Map<EnumFacing, BlockPartFace> lllllllllllllIlIlIIIllllIlIlIlII = (Map<EnumFacing, BlockPartFace>)Maps.newHashMap();
            lllllllllllllIlIlIIIllllIlIlIlII.put(lllllllllllllIlIlIIIllllIlIllIIl.getFacing(), new BlockPartFace(null, lllllllllllllIlIlIIIllllIllIlllI, lllllllllllllIlIlIIIllllIlIIllll, new BlockFaceUV(new float[] { lllllllllllllIlIlIIIllllIllIIIlI, lllllllllllllIlIlIIIllllIllIIIII, lllllllllllllIlIlIIIllllIllIIIIl, lllllllllllllIlIlIIIllllIlIlllll }, 0)));
            switch ($SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing()[lllllllllllllIlIlIIIllllIlIllIIl.ordinal()]) {
                default: {
                    continue;
                }
                case 1: {
                    lllllllllllllIlIlIIIllllIllIlIII.add(new BlockPart(new Vector3f(lllllllllllllIlIlIIIllllIllIIllI, lllllllllllllIlIlIIIllllIllIIlIl, 7.5f), new Vector3f(lllllllllllllIlIlIIIllllIllIIlII, lllllllllllllIlIlIIIllllIllIIlIl, 8.5f), lllllllllllllIlIlIIIllllIlIlIlII, null, true));
                    continue;
                }
                case 2: {
                    lllllllllllllIlIlIIIllllIllIlIII.add(new BlockPart(new Vector3f(lllllllllllllIlIlIIIllllIllIIllI, lllllllllllllIlIlIIIllllIllIIIll, 7.5f), new Vector3f(lllllllllllllIlIlIIIllllIllIIlII, lllllllllllllIlIlIIIllllIllIIIll, 8.5f), lllllllllllllIlIlIIIllllIlIlIlII, null, true));
                    continue;
                }
                case 3: {
                    lllllllllllllIlIlIIIllllIllIlIII.add(new BlockPart(new Vector3f(lllllllllllllIlIlIIIllllIllIIllI, lllllllllllllIlIlIIIllllIllIIlIl, 7.5f), new Vector3f(lllllllllllllIlIlIIIllllIllIIllI, lllllllllllllIlIlIIIllllIllIIIll, 8.5f), lllllllllllllIlIlIIIllllIlIlIlII, null, true));
                    continue;
                }
                case 4: {
                    lllllllllllllIlIlIIIllllIllIlIII.add(new BlockPart(new Vector3f(lllllllllllllIlIlIIIllllIllIIlII, lllllllllllllIlIlIIIllllIllIIlIl, 7.5f), new Vector3f(lllllllllllllIlIlIIIllllIllIIlII, lllllllllllllIlIlIIIllllIllIIIll, 8.5f), lllllllllllllIlIlIIIllllIlIlIlII, null, true));
                    continue;
                }
            }
        }
        return lllllllllllllIlIlIIIllllIllIlIII;
    }
    
    @Nullable
    public ModelBlock makeItemModel(final TextureMap lllllllllllllIlIlIIIllllllIIllIl, final ModelBlock lllllllllllllIlIlIIIllllllIIllII) {
        final Map<String, String> lllllllllllllIlIlIIIllllllIlIlII = (Map<String, String>)Maps.newHashMap();
        final List<BlockPart> lllllllllllllIlIlIIIllllllIlIIll = (List<BlockPart>)Lists.newArrayList();
        for (int lllllllllllllIlIlIIIllllllIlIIlI = 0; lllllllllllllIlIlIIIllllllIlIIlI < ItemModelGenerator.LAYERS.size(); ++lllllllllllllIlIlIIIllllllIlIIlI) {
            final String lllllllllllllIlIlIIIllllllIlIIIl = ItemModelGenerator.LAYERS.get(lllllllllllllIlIlIIIllllllIlIIlI);
            if (!lllllllllllllIlIlIIIllllllIIllII.isTexturePresent(lllllllllllllIlIlIIIllllllIlIIIl)) {
                break;
            }
            final String lllllllllllllIlIlIIIllllllIlIIII = lllllllllllllIlIlIIIllllllIIllII.resolveTextureName(lllllllllllllIlIlIIIllllllIlIIIl);
            lllllllllllllIlIlIIIllllllIlIlII.put(lllllllllllllIlIlIIIllllllIlIIIl, lllllllllllllIlIlIIIllllllIlIIII);
            final TextureAtlasSprite lllllllllllllIlIlIIIllllllIIllll = lllllllllllllIlIlIIIllllllIIllIl.getAtlasSprite(new ResourceLocation(lllllllllllllIlIlIIIllllllIlIIII).toString());
            lllllllllllllIlIlIIIllllllIlIIll.addAll(this.getBlockParts(lllllllllllllIlIlIIIllllllIlIIlI, lllllllllllllIlIlIIIllllllIlIIIl, lllllllllllllIlIlIIIllllllIIllll));
        }
        if (lllllllllllllIlIlIIIllllllIlIIll.isEmpty()) {
            return null;
        }
        lllllllllllllIlIlIIIllllllIlIlII.put("particle", lllllllllllllIlIlIIIllllllIIllII.isTexturePresent("particle") ? lllllllllllllIlIlIIIllllllIIllII.resolveTextureName("particle") : lllllllllllllIlIlIIIllllllIlIlII.get("layer0"));
        return new ModelBlock(null, lllllllllllllIlIlIIIllllllIlIIll, lllllllllllllIlIlIIIllllllIlIlII, false, false, lllllllllllllIlIlIIIllllllIIllII.getAllTransforms(), lllllllllllllIlIlIIIllllllIIllII.getOverrides());
    }
    
    private void checkTransition(final SpanFacing lllllllllllllIlIlIIIlllIlllIllII, final List<Span> lllllllllllllIlIlIIIlllIlllIlIll, final int[] lllllllllllllIlIlIIIlllIllllIlII, final int lllllllllllllIlIlIIIlllIlllIlIIl, final int lllllllllllllIlIlIIIlllIllllIIlI, final int lllllllllllllIlIlIIIlllIllllIIIl, final int lllllllllllllIlIlIIIlllIlllIIllI, final boolean lllllllllllllIlIlIIIlllIlllIIlIl) {
        final boolean lllllllllllllIlIlIIIlllIlllIlllI = this.isTransparent(lllllllllllllIlIlIIIlllIllllIlII, lllllllllllllIlIlIIIlllIlllIlIIl + lllllllllllllIlIlIIIlllIlllIllII.getXOffset(), lllllllllllllIlIlIIIlllIllllIIlI + lllllllllllllIlIlIIIlllIlllIllII.getYOffset(), lllllllllllllIlIlIIIlllIllllIIIl, lllllllllllllIlIlIIIlllIlllIIllI) && lllllllllllllIlIlIIIlllIlllIIlIl;
        if (lllllllllllllIlIlIIIlllIlllIlllI) {
            this.createOrExpandSpan(lllllllllllllIlIlIIIlllIlllIlIll, lllllllllllllIlIlIIIlllIlllIllII, lllllllllllllIlIlIIIlllIlllIlIIl, lllllllllllllIlIlIIIlllIllllIIlI);
        }
    }
    
    private List<BlockPart> getBlockParts(final int lllllllllllllIlIlIIIlllllIlllIII, final String lllllllllllllIlIlIIIlllllIllIlll, final TextureAtlasSprite lllllllllllllIlIlIIIlllllIllIllI) {
        final Map<EnumFacing, BlockPartFace> lllllllllllllIlIlIIIlllllIlllIll = (Map<EnumFacing, BlockPartFace>)Maps.newHashMap();
        lllllllllllllIlIlIIIlllllIlllIll.put(EnumFacing.SOUTH, new BlockPartFace(null, lllllllllllllIlIlIIIlllllIlllIII, lllllllllllllIlIlIIIlllllIllIlll, new BlockFaceUV(new float[] { 0.0f, 0.0f, 16.0f, 16.0f }, 0)));
        lllllllllllllIlIlIIIlllllIlllIll.put(EnumFacing.NORTH, new BlockPartFace(null, lllllllllllllIlIlIIIlllllIlllIII, lllllllllllllIlIlIIIlllllIllIlll, new BlockFaceUV(new float[] { 16.0f, 0.0f, 0.0f, 16.0f }, 0)));
        final List<BlockPart> lllllllllllllIlIlIIIlllllIlllIlI = (List<BlockPart>)Lists.newArrayList();
        lllllllllllllIlIlIIIlllllIlllIlI.add(new BlockPart(new Vector3f(0.0f, 0.0f, 7.5f), new Vector3f(16.0f, 16.0f, 8.5f), lllllllllllllIlIlIIIlllllIlllIll, null, true));
        lllllllllllllIlIlIIIlllllIlllIlI.addAll(this.getBlockParts(lllllllllllllIlIlIIIlllllIllIllI, lllllllllllllIlIlIIIlllllIllIlll, lllllllllllllIlIlIIIlllllIlllIII));
        return lllllllllllllIlIlIIIlllllIlllIlI;
    }
    
    private List<Span> getSpans(final TextureAtlasSprite lllllllllllllIlIlIIIllllIIIlIlII) {
        final int lllllllllllllIlIlIIIllllIIIlIIll = lllllllllllllIlIlIIIllllIIIlIlII.getIconWidth();
        final int lllllllllllllIlIlIIIllllIIIlIIlI = lllllllllllllIlIlIIIllllIIIlIlII.getIconHeight();
        final List<Span> lllllllllllllIlIlIIIllllIIIlIIIl = (List<Span>)Lists.newArrayList();
        for (int lllllllllllllIlIlIIIllllIIIlIIII = 0; lllllllllllllIlIlIIIllllIIIlIIII < lllllllllllllIlIlIIIllllIIIlIlII.getFrameCount(); ++lllllllllllllIlIlIIIllllIIIlIIII) {
            final int[] lllllllllllllIlIlIIIllllIIIIllll = lllllllllllllIlIlIIIllllIIIlIlII.getFrameTextureData(lllllllllllllIlIlIIIllllIIIlIIII)[0];
            for (int lllllllllllllIlIlIIIllllIIIIlllI = 0; lllllllllllllIlIlIIIllllIIIIlllI < lllllllllllllIlIlIIIllllIIIlIIlI; ++lllllllllllllIlIlIIIllllIIIIlllI) {
                for (int lllllllllllllIlIlIIIllllIIIIllIl = 0; lllllllllllllIlIlIIIllllIIIIllIl < lllllllllllllIlIlIIIllllIIIlIIll; ++lllllllllllllIlIlIIIllllIIIIllIl) {
                    final boolean lllllllllllllIlIlIIIllllIIIIllII = !this.isTransparent(lllllllllllllIlIlIIIllllIIIIllll, lllllllllllllIlIlIIIllllIIIIllIl, lllllllllllllIlIlIIIllllIIIIlllI, lllllllllllllIlIlIIIllllIIIlIIll, lllllllllllllIlIlIIIllllIIIlIIlI);
                    this.checkTransition(SpanFacing.UP, lllllllllllllIlIlIIIllllIIIlIIIl, lllllllllllllIlIlIIIllllIIIIllll, lllllllllllllIlIlIIIllllIIIIllIl, lllllllllllllIlIlIIIllllIIIIlllI, lllllllllllllIlIlIIIllllIIIlIIll, lllllllllllllIlIlIIIllllIIIlIIlI, lllllllllllllIlIlIIIllllIIIIllII);
                    this.checkTransition(SpanFacing.DOWN, lllllllllllllIlIlIIIllllIIIlIIIl, lllllllllllllIlIlIIIllllIIIIllll, lllllllllllllIlIlIIIllllIIIIllIl, lllllllllllllIlIlIIIllllIIIIlllI, lllllllllllllIlIlIIIllllIIIlIIll, lllllllllllllIlIlIIIllllIIIlIIlI, lllllllllllllIlIlIIIllllIIIIllII);
                    this.checkTransition(SpanFacing.LEFT, lllllllllllllIlIlIIIllllIIIlIIIl, lllllllllllllIlIlIIIllllIIIIllll, lllllllllllllIlIlIIIllllIIIIllIl, lllllllllllllIlIlIIIllllIIIIlllI, lllllllllllllIlIlIIIllllIIIlIIll, lllllllllllllIlIlIIIllllIIIlIIlI, lllllllllllllIlIlIIIllllIIIIllII);
                    this.checkTransition(SpanFacing.RIGHT, lllllllllllllIlIlIIIllllIIIlIIIl, lllllllllllllIlIlIIIllllIIIIllll, lllllllllllllIlIlIIIllllIIIIllIl, lllllllllllllIlIlIIIllllIIIIlllI, lllllllllllllIlIlIIIllllIIIlIIll, lllllllllllllIlIlIIIllllIIIlIIlI, lllllllllllllIlIlIIIllllIIIIllII);
                }
            }
        }
        return lllllllllllllIlIlIIIllllIIIlIIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing = ItemModelGenerator.$SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing;
        if ($switch_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing != null) {
            return $switch_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing;
        }
        final Exception lllllllllllllIlIlIIIlllIlIlllIII = (Object)new int[SpanFacing.values().length];
        try {
            lllllllllllllIlIlIIIlllIlIlllIII[SpanFacing.DOWN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIlIIIlllIlIlllIII[SpanFacing.LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIlIIIlllIlIlllIII[SpanFacing.RIGHT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIlIIIlllIlIlllIII[SpanFacing.UP.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return ItemModelGenerator.$SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemModelGenerator$SpanFacing = (int[])(Object)lllllllllllllIlIlIIIlllIlIlllIII;
    }
    
    static {
        LAYERS = Lists.newArrayList((Object[])new String[] { "layer0", "layer1", "layer2", "layer3", "layer4" });
    }
    
    private boolean isTransparent(final int[] lllllllllllllIlIlIIIlllIllIIIIll, final int lllllllllllllIlIlIIIlllIllIIIIlI, final int lllllllllllllIlIlIIIlllIllIIIIIl, final int lllllllllllllIlIlIIIlllIllIIIIII, final int lllllllllllllIlIlIIIlllIlIllllll) {
        return lllllllllllllIlIlIIIlllIllIIIIlI < 0 || lllllllllllllIlIlIIIlllIllIIIIIl < 0 || lllllllllllllIlIlIIIlllIllIIIIlI >= lllllllllllllIlIlIIIlllIllIIIIII || lllllllllllllIlIlIIIlllIllIIIIIl >= lllllllllllllIlIlIIIlllIlIllllll || (lllllllllllllIlIlIIIlllIllIIIIll[lllllllllllllIlIlIIIlllIllIIIIIl * lllllllllllllIlIlIIIlllIllIIIIII + lllllllllllllIlIlIIIlllIllIIIIlI] >> 24 & 0xFF) == 0x0;
    }
    
    static class Span
    {
        private /* synthetic */ int min;
        private final /* synthetic */ int anchor;
        private final /* synthetic */ SpanFacing spanFacing;
        private /* synthetic */ int max;
        
        public int getMax() {
            return this.max;
        }
        
        public SpanFacing getFacing() {
            return this.spanFacing;
        }
        
        public Span(final SpanFacing lIIIIlIllllIlI, final int lIIIIlIlllllIl, final int lIIIIlIlllllII) {
            this.spanFacing = lIIIIlIllllIlI;
            this.min = lIIIIlIlllllIl;
            this.max = lIIIIlIlllllIl;
            this.anchor = lIIIIlIlllllII;
        }
        
        public void expand(final int lIIIIlIlllIIlI) {
            if (lIIIIlIlllIIlI < this.min) {
                this.min = lIIIIlIlllIIlI;
            }
            else if (lIIIIlIlllIIlI > this.max) {
                this.max = lIIIIlIlllIIlI;
            }
        }
        
        public int getAnchor() {
            return this.anchor;
        }
        
        public int getMin() {
            return this.min;
        }
    }
    
    enum SpanFacing
    {
        private final /* synthetic */ int xOffset;
        private final /* synthetic */ int yOffset;
        
        UP("UP", 0, EnumFacing.UP, 0, -1);
        
        private final /* synthetic */ EnumFacing facing;
        
        RIGHT("RIGHT", 3, EnumFacing.WEST, 1, 0), 
        DOWN("DOWN", 1, EnumFacing.DOWN, 0, 1), 
        LEFT("LEFT", 2, EnumFacing.EAST, -1, 0);
        
        private SpanFacing(final String lllllllllllllIlIllllIIlIIIlIlllI, final int lllllllllllllIlIllllIIlIIIlIllIl, final EnumFacing lllllllllllllIlIllllIIlIIIlIllII, final int lllllllllllllIlIllllIIlIIIlIlIll, final int lllllllllllllIlIllllIIlIIIlIlIlI) {
            this.facing = lllllllllllllIlIllllIIlIIIlIllII;
            this.xOffset = lllllllllllllIlIllllIIlIIIlIlIll;
            this.yOffset = lllllllllllllIlIllllIIlIIIlIlIlI;
        }
        
        public int getYOffset() {
            return this.yOffset;
        }
        
        private boolean isHorizontal() {
            return this == SpanFacing.DOWN || this == SpanFacing.UP;
        }
        
        public int getXOffset() {
            return this.xOffset;
        }
        
        public EnumFacing getFacing() {
            return this.facing;
        }
    }
}
