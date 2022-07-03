package net.minecraft.client.renderer.block.model;

import javax.annotation.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class BlockFaceUV
{
    public /* synthetic */ float[] uvs;
    public final /* synthetic */ int rotation;
    
    public void setUvs(final float[] llllllllllllllllIllIllllllIIllIl) {
        if (this.uvs == null) {
            this.uvs = llllllllllllllllIllIllllllIIllIl;
        }
    }
    
    private int getVertexRotated(final int llllllllllllllllIllIllllllIllIIl) {
        return (llllllllllllllllIllIllllllIllIIl + this.rotation / 90) % 4;
    }
    
    public float getVertexU(final int llllllllllllllllIllIlllllllIllII) {
        if (this.uvs == null) {
            throw new NullPointerException("uvs");
        }
        final int llllllllllllllllIllIlllllllIlIll = this.getVertexRotated(llllllllllllllllIllIlllllllIllII);
        return (llllllllllllllllIllIlllllllIlIll != 0 && llllllllllllllllIllIlllllllIlIll != 1) ? this.uvs[2] : this.uvs[0];
    }
    
    public float getVertexV(final int llllllllllllllllIllIlllllllIIIII) {
        if (this.uvs == null) {
            throw new NullPointerException("uvs");
        }
        final int llllllllllllllllIllIlllllllIIIlI = this.getVertexRotated(llllllllllllllllIllIlllllllIIIII);
        return (llllllllllllllllIllIlllllllIIIlI != 0 && llllllllllllllllIllIlllllllIIIlI != 3) ? this.uvs[3] : this.uvs[1];
    }
    
    public int getVertexRotatedRev(final int llllllllllllllllIllIllllllIlIlIl) {
        return (llllllllllllllllIllIllllllIlIlIl + (4 - this.rotation / 90)) % 4;
    }
    
    public BlockFaceUV(@Nullable final float[] llllllllllllllllIllIllllllllIlIl, final int llllllllllllllllIllIllllllllIlII) {
        this.uvs = llllllllllllllllIllIllllllllIlIl;
        this.rotation = llllllllllllllllIllIllllllllIlII;
    }
    
    static class Deserializer implements JsonDeserializer<BlockFaceUV>
    {
        public BlockFaceUV deserialize(final JsonElement llllllllllllllllIIlllIllIIIIlIIl, final Type llllllllllllllllIIlllIllIIIIlIII, final JsonDeserializationContext llllllllllllllllIIlllIllIIIIIlll) throws JsonParseException {
            final JsonObject llllllllllllllllIIlllIllIIIIIllI = llllllllllllllllIIlllIllIIIIlIIl.getAsJsonObject();
            final float[] llllllllllllllllIIlllIllIIIIIlIl = this.parseUV(llllllllllllllllIIlllIllIIIIIllI);
            final int llllllllllllllllIIlllIllIIIIIlII = this.parseRotation(llllllllllllllllIIlllIllIIIIIllI);
            return new BlockFaceUV(llllllllllllllllIIlllIllIIIIIlIl, llllllllllllllllIIlllIllIIIIIlII);
        }
        
        @Nullable
        private float[] parseUV(final JsonObject llllllllllllllllIIlllIlIlllIlllI) {
            if (!llllllllllllllllIIlllIlIlllIlllI.has("uv")) {
                return null;
            }
            final JsonArray llllllllllllllllIIlllIlIllllIIIl = JsonUtils.getJsonArray(llllllllllllllllIIlllIlIlllIlllI, "uv");
            if (llllllllllllllllIIlllIlIllllIIIl.size() != 4) {
                throw new JsonParseException(String.valueOf(new StringBuilder("Expected 4 uv values, found: ").append(llllllllllllllllIIlllIlIllllIIIl.size())));
            }
            final float[] llllllllllllllllIIlllIlIllllIIII = new float[4];
            for (int llllllllllllllllIIlllIlIlllIllll = 0; llllllllllllllllIIlllIlIlllIllll < llllllllllllllllIIlllIlIllllIIII.length; ++llllllllllllllllIIlllIlIlllIllll) {
                llllllllllllllllIIlllIlIllllIIII[llllllllllllllllIIlllIlIlllIllll] = JsonUtils.getFloat(llllllllllllllllIIlllIlIllllIIIl.get(llllllllllllllllIIlllIlIlllIllll), String.valueOf(new StringBuilder("uv[").append(llllllllllllllllIIlllIlIlllIllll).append("]")));
            }
            return llllllllllllllllIIlllIlIllllIIII;
        }
        
        protected int parseRotation(final JsonObject llllllllllllllllIIlllIlIlllllIIl) {
            final int llllllllllllllllIIlllIlIlllllIlI = JsonUtils.getInt(llllllllllllllllIIlllIlIlllllIIl, "rotation", 0);
            if (llllllllllllllllIIlllIlIlllllIlI >= 0 && llllllllllllllllIIlllIlIlllllIlI % 90 == 0 && llllllllllllllllIIlllIlIlllllIlI / 90 <= 3) {
                return llllllllllllllllIIlllIlIlllllIlI;
            }
            throw new JsonParseException(String.valueOf(new StringBuilder("Invalid rotation ").append(llllllllllllllllIIlllIlIlllllIlI).append(" found, only 0/90/180/270 allowed")));
        }
    }
}
