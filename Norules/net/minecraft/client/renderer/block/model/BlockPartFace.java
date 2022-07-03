package net.minecraft.client.renderer.block.model;

import javax.annotation.*;
import net.minecraft.util.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class BlockPartFace
{
    public final /* synthetic */ int tintIndex;
    public final /* synthetic */ String texture;
    public final /* synthetic */ EnumFacing cullFace;
    public final /* synthetic */ BlockFaceUV blockFaceUV;
    
    static {
        FACING_DEFAULT = null;
    }
    
    public BlockPartFace(@Nullable final EnumFacing lllllllllllllIllIIIIllllIllIlIlI, final int lllllllllllllIllIIIIllllIllIlIIl, final String lllllllllllllIllIIIIllllIllIlIII, final BlockFaceUV lllllllllllllIllIIIIllllIllIIlll) {
        this.cullFace = lllllllllllllIllIIIIllllIllIlIlI;
        this.tintIndex = lllllllllllllIllIIIIllllIllIlIIl;
        this.texture = lllllllllllllIllIIIIllllIllIlIII;
        this.blockFaceUV = lllllllllllllIllIIIIllllIllIIlll;
    }
    
    static class Deserializer implements JsonDeserializer<BlockPartFace>
    {
        @Nullable
        private EnumFacing parseCullFace(final JsonObject llllllllllllllIIlIlllIIllIIlIIIl) {
            final String llllllllllllllIIlIlllIIllIIlIIII = JsonUtils.getString(llllllllllllllIIlIlllIIllIIlIIIl, "cullface", "");
            return EnumFacing.byName(llllllllllllllIIlIlllIIllIIlIIII);
        }
        
        private String parseTexture(final JsonObject llllllllllllllIIlIlllIIllIIlIllI) {
            return JsonUtils.getString(llllllllllllllIIlIlllIIllIIlIllI, "texture");
        }
        
        protected int parseTintIndex(final JsonObject llllllllllllllIIlIlllIIllIIllIIl) {
            return JsonUtils.getInt(llllllllllllllIIlIlllIIllIIllIIl, "tintindex", -1);
        }
        
        public BlockPartFace deserialize(final JsonElement llllllllllllllIIlIlllIIllIlIIIll, final Type llllllllllllllIIlIlllIIllIllIIlI, final JsonDeserializationContext llllllllllllllIIlIlllIIllIlIIIlI) throws JsonParseException {
            final JsonObject llllllllllllllIIlIlllIIllIlIlllI = llllllllllllllIIlIlllIIllIlIIIll.getAsJsonObject();
            final EnumFacing llllllllllllllIIlIlllIIllIlIllII = this.parseCullFace(llllllllllllllIIlIlllIIllIlIlllI);
            final int llllllllllllllIIlIlllIIllIlIlIlI = this.parseTintIndex(llllllllllllllIIlIlllIIllIlIlllI);
            final String llllllllllllllIIlIlllIIllIlIlIII = this.parseTexture(llllllllllllllIIlIlllIIllIlIlllI);
            final BlockFaceUV llllllllllllllIIlIlllIIllIlIIllI = (BlockFaceUV)llllllllllllllIIlIlllIIllIlIIIlI.deserialize((JsonElement)llllllllllllllIIlIlllIIllIlIlllI, (Type)BlockFaceUV.class);
            return new BlockPartFace(llllllllllllllIIlIlllIIllIlIllII, llllllllllllllIIlIlllIIllIlIlIlI, llllllllllllllIIlIlllIIllIlIlIII, llllllllllllllIIlIlllIIllIlIIllI);
        }
    }
}
