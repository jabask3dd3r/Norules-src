package net.minecraft.util;

import java.util.*;
import org.apache.commons.lang3.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class ResourceLocation implements Comparable<ResourceLocation>
{
    protected final /* synthetic */ String resourceDomain;
    protected final /* synthetic */ String resourcePath;
    
    @Override
    public int hashCode() {
        return 31 * this.resourceDomain.hashCode() + this.resourcePath.hashCode();
    }
    
    protected static String[] splitObjectName(final String lllllllllllllIlIlIIIlIIIIlIlIlIl) {
        final String[] lllllllllllllIlIlIIIlIIIIlIlIlII = { "minecraft", lllllllllllllIlIlIIIlIIIIlIlIlIl };
        final int lllllllllllllIlIlIIIlIIIIlIlIIll = lllllllllllllIlIlIIIlIIIIlIlIlIl.indexOf(58);
        if (lllllllllllllIlIlIIIlIIIIlIlIIll >= 0) {
            lllllllllllllIlIlIIIlIIIIlIlIlII[1] = lllllllllllllIlIlIIIlIIIIlIlIlIl.substring(lllllllllllllIlIlIIIlIIIIlIlIIll + 1, lllllllllllllIlIlIIIlIIIIlIlIlIl.length());
            if (lllllllllllllIlIlIIIlIIIIlIlIIll > 1) {
                lllllllllllllIlIlIIIlIIIIlIlIlII[0] = lllllllllllllIlIlIIIlIIIIlIlIlIl.substring(0, lllllllllllllIlIlIIIlIIIIlIlIIll);
            }
        }
        return lllllllllllllIlIlIIIlIIIIlIlIlII;
    }
    
    protected ResourceLocation(final int lllllllllllllIlIlIIIlIIIIllllIlI, final String... lllllllllllllIlIlIIIlIIIIllllIIl) {
        this.resourceDomain = (StringUtils.isEmpty((CharSequence)lllllllllllllIlIlIIIlIIIIllllIIl[0]) ? "minecraft" : lllllllllllllIlIlIIIlIIIIllllIIl[0].toLowerCase(Locale.ROOT));
        this.resourcePath = lllllllllllllIlIlIIIlIIIIllllIIl[1].toLowerCase(Locale.ROOT);
        Validate.notNull((Object)this.resourcePath);
    }
    
    public ResourceLocation(final String lllllllllllllIlIlIIIlIIIIlllIIII) {
        this(0, splitObjectName(lllllllllllllIlIlIIIlIIIIlllIIII));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIlIIIlIIIIIlIlIll) {
        if (this == lllllllllllllIlIlIIIlIIIIIlIlIll) {
            return true;
        }
        if (!(lllllllllllllIlIlIIIlIIIIIlIlIll instanceof ResourceLocation)) {
            return false;
        }
        final ResourceLocation lllllllllllllIlIlIIIlIIIIIlIlIlI = (ResourceLocation)lllllllllllllIlIlIIIlIIIIIlIlIll;
        return this.resourceDomain.equals(lllllllllllllIlIlIIIlIIIIIlIlIlI.resourceDomain) && this.resourcePath.equals(lllllllllllllIlIlIIIlIIIIIlIlIlI.resourcePath);
    }
    
    public String getResourceDomain() {
        return this.resourceDomain;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.resourceDomain)).append(':').append(this.resourcePath));
    }
    
    @Override
    public int compareTo(final ResourceLocation lllllllllllllIlIlIIIlIIIIIIlIIlI) {
        int lllllllllllllIlIlIIIlIIIIIIlIIIl = this.resourceDomain.compareTo(lllllllllllllIlIlIIIlIIIIIIlIIlI.resourceDomain);
        if (lllllllllllllIlIlIIIlIIIIIIlIIIl == 0) {
            lllllllllllllIlIlIIIlIIIIIIlIIIl = this.resourcePath.compareTo(lllllllllllllIlIlIIIlIIIIIIlIIlI.resourcePath);
        }
        return lllllllllllllIlIlIIIlIIIIIIlIIIl;
    }
    
    public ResourceLocation(final String lllllllllllllIlIlIIIlIIIIlIlllIl, final String lllllllllllllIlIlIIIlIIIIlIllIll) {
        this(0, new String[] { lllllllllllllIlIlIIIlIIIIlIlllIl, lllllllllllllIlIlIIIlIIIIlIllIll });
    }
    
    public String getResourcePath() {
        return this.resourcePath;
    }
    
    public static class Serializer implements JsonDeserializer<ResourceLocation>, JsonSerializer<ResourceLocation>
    {
        public JsonElement serialize(final ResourceLocation llllllllllllllIlIIIlIlIIlIIlllIl, final Type llllllllllllllIlIIIlIlIIlIIlllII, final JsonSerializationContext llllllllllllllIlIIIlIlIIlIIllIll) {
            return (JsonElement)new JsonPrimitive(llllllllllllllIlIIIlIlIIlIIlllIl.toString());
        }
        
        public ResourceLocation deserialize(final JsonElement llllllllllllllIlIIIlIlIIlIlIIIll, final Type llllllllllllllIlIIIlIlIIlIlIIIlI, final JsonDeserializationContext llllllllllllllIlIIIlIlIIlIlIIIIl) throws JsonParseException {
            return new ResourceLocation(JsonUtils.getString(llllllllllllllIlIIIlIlIIlIlIIIll, "location"));
        }
    }
}
