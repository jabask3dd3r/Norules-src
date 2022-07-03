package net.minecraft.client.renderer.block.model;

import org.lwjgl.util.vector.*;
import javax.annotation.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import com.google.gson.*;

public class BlockPart
{
    public final /* synthetic */ boolean shade;
    public final /* synthetic */ Vector3f positionTo;
    public final /* synthetic */ BlockPartRotation partRotation;
    public final /* synthetic */ Map<EnumFacing, BlockPartFace> mapFaces;
    public final /* synthetic */ Vector3f positionFrom;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockPart.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final boolean llllllllllllllIIIIIllIIIIlIlIlII = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllIIIIIllIIIIlIlIlII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIIIllIIIIlIlIlII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIIIllIIIIlIlIlII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIIIllIIIIlIlIlII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIIIIllIIIIlIlIlII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIIIIllIIIIlIlIlII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockPart.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIIIIIllIIIIlIlIlII;
    }
    
    private float[] getFaceUvs(final EnumFacing llllllllllllllIIIIIllIIIIlIllIII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIIIIIllIIIIlIllIII.ordinal()]) {
            case 1: {
                return new float[] { this.positionFrom.x, 16.0f - this.positionTo.z, this.positionTo.x, 16.0f - this.positionFrom.z };
            }
            case 2: {
                return new float[] { this.positionFrom.x, this.positionFrom.z, this.positionTo.x, this.positionTo.z };
            }
            default: {
                return new float[] { 16.0f - this.positionTo.x, 16.0f - this.positionTo.y, 16.0f - this.positionFrom.x, 16.0f - this.positionFrom.y };
            }
            case 4: {
                return new float[] { this.positionFrom.x, 16.0f - this.positionTo.y, this.positionTo.x, 16.0f - this.positionFrom.y };
            }
            case 5: {
                return new float[] { this.positionFrom.z, 16.0f - this.positionTo.y, this.positionTo.z, 16.0f - this.positionFrom.y };
            }
            case 6: {
                return new float[] { 16.0f - this.positionTo.z, 16.0f - this.positionTo.y, 16.0f - this.positionFrom.z, 16.0f - this.positionFrom.y };
            }
        }
    }
    
    public BlockPart(final Vector3f llllllllllllllIIIIIllIIIIllIlIll, final Vector3f llllllllllllllIIIIIllIIIIllIlIlI, final Map<EnumFacing, BlockPartFace> llllllllllllllIIIIIllIIIIllIllll, @Nullable final BlockPartRotation llllllllllllllIIIIIllIIIIllIlllI, final boolean llllllllllllllIIIIIllIIIIllIIlll) {
        this.positionFrom = llllllllllllllIIIIIllIIIIllIlIll;
        this.positionTo = llllllllllllllIIIIIllIIIIllIlIlI;
        this.mapFaces = llllllllllllllIIIIIllIIIIllIllll;
        this.partRotation = llllllllllllllIIIIIllIIIIllIlllI;
        this.shade = llllllllllllllIIIIIllIIIIllIIlll;
        this.setDefaultUvs();
    }
    
    private void setDefaultUvs() {
        for (final Map.Entry<EnumFacing, BlockPartFace> llllllllllllllIIIIIllIIIIllIIIIl : this.mapFaces.entrySet()) {
            final float[] llllllllllllllIIIIIllIIIIllIIIII = this.getFaceUvs(llllllllllllllIIIIIllIIIIllIIIIl.getKey());
            llllllllllllllIIIIIllIIIIllIIIIl.getValue().blockFaceUV.setUvs(llllllllllllllIIIIIllIIIIllIIIII);
        }
    }
    
    static class Deserializer implements JsonDeserializer<BlockPart>
    {
        private EnumFacing parseEnumFacing(final String llllllllllllllIlIIIlllIIlIlIllII) {
            final EnumFacing llllllllllllllIlIIIlllIIlIlIlIll = EnumFacing.byName(llllllllllllllIlIIIlllIIlIlIllII);
            if (llllllllllllllIlIIIlllIIlIlIlIll == null) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Unknown facing: ").append(llllllllllllllIlIIIlllIIlIlIllII)));
            }
            return llllllllllllllIlIIIlllIIlIlIlIll;
        }
        
        private Map<EnumFacing, BlockPartFace> parseFacesCheck(final JsonDeserializationContext llllllllllllllIlIIIlllIIllIIllIl, final JsonObject llllllllllllllIlIIIlllIIllIIllII) {
            final Map<EnumFacing, BlockPartFace> llllllllllllllIlIIIlllIIllIIlIll = this.parseFaces(llllllllllllllIlIIIlllIIllIIllIl, llllllllllllllIlIIIlllIIllIIllII);
            if (llllllllllllllIlIIIlllIIllIIlIll.isEmpty()) {
                throw new JsonParseException("Expected between 1 and 6 unique faces, got 0");
            }
            return llllllllllllllIlIIIlllIIllIIlIll;
        }
        
        private Vector3f parsePositionFrom(final JsonObject llllllllllllllIlIIIlllIIlIIllIII) {
            final Vector3f llllllllllllllIlIIIlllIIlIIllIlI = this.parsePosition(llllllllllllllIlIIIlllIIlIIllIII, "from");
            if (llllllllllllllIlIIIlllIIlIIllIlI.x >= -16.0f && llllllllllllllIlIIIlllIIlIIllIlI.y >= -16.0f && llllllllllllllIlIIIlllIIlIIllIlI.z >= -16.0f && llllllllllllllIlIIIlllIIlIIllIlI.x <= 32.0f && llllllllllllllIlIIIlllIIlIIllIlI.y <= 32.0f && llllllllllllllIlIIIlllIIlIIllIlI.z <= 32.0f) {
                return llllllllllllllIlIIIlllIIlIIllIlI;
            }
            throw new JsonParseException(String.valueOf(new StringBuilder("'from' specifier exceeds the allowed boundaries: ").append(llllllllllllllIlIIIlllIIlIIllIlI)));
        }
        
        private Vector3f parsePositionTo(final JsonObject llllllllllllllIlIIIlllIIlIlIIIIl) {
            final Vector3f llllllllllllllIlIIIlllIIlIlIIIll = this.parsePosition(llllllllllllllIlIIIlllIIlIlIIIIl, "to");
            if (llllllllllllllIlIIIlllIIlIlIIIll.x >= -16.0f && llllllllllllllIlIIIlllIIlIlIIIll.y >= -16.0f && llllllllllllllIlIIIlllIIlIlIIIll.z >= -16.0f && llllllllllllllIlIIIlllIIlIlIIIll.x <= 32.0f && llllllllllllllIlIIIlllIIlIlIIIll.y <= 32.0f && llllllllllllllIlIIIlllIIlIlIIIll.z <= 32.0f) {
                return llllllllllllllIlIIIlllIIlIlIIIll;
            }
            throw new JsonParseException(String.valueOf(new StringBuilder("'to' specifier exceeds the allowed boundaries: ").append(llllllllllllllIlIIIlllIIlIlIIIll)));
        }
        
        private EnumFacing.Axis parseAxis(final JsonObject llllllllllllllIlIIIlllIIllIlIlIl) {
            final String llllllllllllllIlIIIlllIIllIlIlll = JsonUtils.getString(llllllllllllllIlIIIlllIIllIlIlIl, "axis");
            final EnumFacing.Axis llllllllllllllIlIIIlllIIllIlIllI = EnumFacing.Axis.byName(llllllllllllllIlIIIlllIIllIlIlll.toLowerCase(Locale.ROOT));
            if (llllllllllllllIlIIIlllIIllIlIllI == null) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid rotation axis: ").append(llllllllllllllIlIIIlllIIllIlIlll)));
            }
            return llllllllllllllIlIIIlllIIllIlIllI;
        }
        
        public BlockPart deserialize(final JsonElement llllllllllllllIlIIIlllIlIIIIIIll, final Type llllllllllllllIlIIIlllIlIIIIllII, final JsonDeserializationContext llllllllllllllIlIIIlllIlIIIIlIll) throws JsonParseException {
            final JsonObject llllllllllllllIlIIIlllIlIIIIlIlI = llllllllllllllIlIIIlllIlIIIIIIll.getAsJsonObject();
            final Vector3f llllllllllllllIlIIIlllIlIIIIlIIl = this.parsePositionFrom(llllllllllllllIlIIIlllIlIIIIlIlI);
            final Vector3f llllllllllllllIlIIIlllIlIIIIlIII = this.parsePositionTo(llllllllllllllIlIIIlllIlIIIIlIlI);
            final BlockPartRotation llllllllllllllIlIIIlllIlIIIIIlll = this.parseRotation(llllllllllllllIlIIIlllIlIIIIlIlI);
            final Map<EnumFacing, BlockPartFace> llllllllllllllIlIIIlllIlIIIIIllI = this.parseFacesCheck(llllllllllllllIlIIIlllIlIIIIlIll, llllllllllllllIlIIIlllIlIIIIlIlI);
            if (llllllllllllllIlIIIlllIlIIIIlIlI.has("shade") && !JsonUtils.isBoolean(llllllllllllllIlIIIlllIlIIIIlIlI, "shade")) {
                throw new JsonParseException("Expected shade to be a Boolean");
            }
            final boolean llllllllllllllIlIIIlllIlIIIIIlIl = JsonUtils.getBoolean(llllllllllllllIlIIIlllIlIIIIlIlI, "shade", true);
            return new BlockPart(llllllllllllllIlIIIlllIlIIIIlIIl, llllllllllllllIlIIIlllIlIIIIlIII, llllllllllllllIlIIIlllIlIIIIIllI, llllllllllllllIlIIIlllIlIIIIIlll, llllllllllllllIlIIIlllIlIIIIIlIl);
        }
        
        private float parseAngle(final JsonObject llllllllllllllIlIIIlllIIllIllllI) {
            final float llllllllllllllIlIIIlllIIllIlllll = JsonUtils.getFloat(llllllllllllllIlIIIlllIIllIllllI, "angle");
            if (llllllllllllllIlIIIlllIIllIlllll != 0.0f && MathHelper.abs(llllllllllllllIlIIIlllIIllIlllll) != 22.5f && MathHelper.abs(llllllllllllllIlIIIlllIIllIlllll) != 45.0f) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Invalid rotation ").append(llllllllllllllIlIIIlllIIllIlllll).append(" found, only -45/-22.5/0/22.5/45 allowed")));
            }
            return llllllllllllllIlIIIlllIIllIlllll;
        }
        
        private Map<EnumFacing, BlockPartFace> parseFaces(final JsonDeserializationContext llllllllllllllIlIIIlllIIlIllllIl, final JsonObject llllllllllllllIlIIIlllIIlIllllII) {
            final Map<EnumFacing, BlockPartFace> llllllllllllllIlIIIlllIIlIlllIll = (Map<EnumFacing, BlockPartFace>)Maps.newEnumMap((Class)EnumFacing.class);
            final JsonObject llllllllllllllIlIIIlllIIlIlllIlI = JsonUtils.getJsonObject(llllllllllllllIlIIIlllIIlIllllII, "faces");
            for (final Map.Entry<String, JsonElement> llllllllllllllIlIIIlllIIlIlllIIl : llllllllllllllIlIIIlllIIlIlllIlI.entrySet()) {
                final EnumFacing llllllllllllllIlIIIlllIIlIlllIII = this.parseEnumFacing(llllllllllllllIlIIIlllIIlIlllIIl.getKey());
                llllllllllllllIlIIIlllIIlIlllIll.put(llllllllllllllIlIIIlllIIlIlllIII, (BlockPartFace)llllllllllllllIlIIIlllIIlIllllIl.deserialize((JsonElement)llllllllllllllIlIIIlllIIlIlllIIl.getValue(), (Type)BlockPartFace.class));
            }
            return llllllllllllllIlIIIlllIIlIlllIll;
        }
        
        @Nullable
        private BlockPartRotation parseRotation(final JsonObject llllllllllllllIlIIIlllIIlllIlIlI) {
            BlockPartRotation llllllllllllllIlIIIlllIIllllIIIl = null;
            if (llllllllllllllIlIIIlllIIlllIlIlI.has("rotation")) {
                final JsonObject llllllllllllllIlIIIlllIIllllIIII = JsonUtils.getJsonObject(llllllllllllllIlIIIlllIIlllIlIlI, "rotation");
                final Vector3f llllllllllllllIlIIIlllIIlllIllll = this.parsePosition(llllllllllllllIlIIIlllIIllllIIII, "origin");
                llllllllllllllIlIIIlllIIlllIllll.scale(0.0625f);
                final EnumFacing.Axis llllllllllllllIlIIIlllIIlllIlllI = this.parseAxis(llllllllllllllIlIIIlllIIllllIIII);
                final float llllllllllllllIlIIIlllIIlllIllIl = this.parseAngle(llllllllllllllIlIIIlllIIllllIIII);
                final boolean llllllllllllllIlIIIlllIIlllIllII = JsonUtils.getBoolean(llllllllllllllIlIIIlllIIllllIIII, "rescale", false);
                llllllllllllllIlIIIlllIIllllIIIl = new BlockPartRotation(llllllllllllllIlIIIlllIIlllIllll, llllllllllllllIlIIIlllIIlllIlllI, llllllllllllllIlIIIlllIIlllIllIl, llllllllllllllIlIIIlllIIlllIllII);
            }
            return llllllllllllllIlIIIlllIIllllIIIl;
        }
        
        private Vector3f parsePosition(final JsonObject llllllllllllllIlIIIlllIIlIIlIIII, final String llllllllllllllIlIIIlllIIlIIIllll) {
            final JsonArray llllllllllllllIlIIIlllIIlIIIlllI = JsonUtils.getJsonArray(llllllllllllllIlIIIlllIIlIIlIIII, llllllllllllllIlIIIlllIIlIIIllll);
            if (llllllllllllllIlIIIlllIIlIIIlllI.size() != 3) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Expected 3 ").append(llllllllllllllIlIIIlllIIlIIIllll).append(" values, found: ").append(llllllllllllllIlIIIlllIIlIIIlllI.size())));
            }
            final float[] llllllllllllllIlIIIlllIIlIIIllIl = new float[3];
            for (int llllllllllllllIlIIIlllIIlIIIllII = 0; llllllllllllllIlIIIlllIIlIIIllII < llllllllllllllIlIIIlllIIlIIIllIl.length; ++llllllllllllllIlIIIlllIIlIIIllII) {
                llllllllllllllIlIIIlllIIlIIIllIl[llllllllllllllIlIIIlllIIlIIIllII] = JsonUtils.getFloat(llllllllllllllIlIIIlllIIlIIIlllI.get(llllllllllllllIlIIIlllIIlIIIllII), String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIIlllIIlIIIllll)).append("[").append(llllllllllllllIlIIIlllIIlIIIllII).append("]")));
            }
            return new Vector3f(llllllllllllllIlIIIlllIIlIIIllIl[0], llllllllllllllIlIIIlllIIlIIIllIl[1], llllllllllllllIlIIIlllIIlIIIllIl[2]);
        }
    }
}
