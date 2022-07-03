package net.minecraft.client.resources.data;

import net.minecraft.util.registry.*;
import net.minecraft.util.text.*;
import net.minecraft.util.*;
import com.google.gson.*;
import java.lang.reflect.*;

public class MetadataSerializer
{
    private final /* synthetic */ IRegistry<String, Registration<? extends IMetadataSection>> metadataSectionSerializerRegistry;
    private final /* synthetic */ GsonBuilder gsonBuilder;
    private /* synthetic */ Gson gson;
    
    public MetadataSerializer() {
        this.metadataSectionSerializerRegistry = new RegistrySimple<String, Registration<? extends IMetadataSection>>();
        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new ITextComponent.Serializer());
        this.gsonBuilder.registerTypeHierarchyAdapter((Class)Style.class, (Object)new Style.Serializer());
        this.gsonBuilder.registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory());
    }
    
    public <T extends IMetadataSection> T parseMetadataSection(final String lllllllllllllIIIlIIIIllIIllllIlI, final JsonObject lllllllllllllIIIlIIIIllIIlllIlIl) {
        if (lllllllllllllIIIlIIIIllIIllllIlI == null) {
            throw new IllegalArgumentException("Metadata section name cannot be null");
        }
        if (!lllllllllllllIIIlIIIIllIIlllIlIl.has(lllllllllllllIIIlIIIIllIIllllIlI)) {
            return null;
        }
        if (!lllllllllllllIIIlIIIIllIIlllIlIl.get(lllllllllllllIIIlIIIIllIIllllIlI).isJsonObject()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid metadata for '").append(lllllllllllllIIIlIIIIllIIllllIlI).append("' - expected object, found ").append(lllllllllllllIIIlIIIIllIIlllIlIl.get(lllllllllllllIIIlIIIIllIIllllIlI))));
        }
        final Registration<?> lllllllllllllIIIlIIIIllIIllllIII = this.metadataSectionSerializerRegistry.getObject(lllllllllllllIIIlIIIIllIIllllIlI);
        if (lllllllllllllIIIlIIIIllIIllllIII == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to handle metadata section '").append(lllllllllllllIIIlIIIIllIIllllIlI).append("'")));
        }
        return (T)this.getGson().fromJson((JsonElement)lllllllllllllIIIlIIIIllIIlllIlIl.getAsJsonObject(lllllllllllllIIIlIIIIllIIllllIlI), (Class)lllllllllllllIIIlIIIIllIIllllIII.clazz);
    }
    
    private Gson getGson() {
        if (this.gson == null) {
            this.gson = this.gsonBuilder.create();
        }
        return this.gson;
    }
    
    public <T extends IMetadataSection> void registerMetadataSectionType(final IMetadataSectionSerializer<T> lllllllllllllIIIlIIIIllIlIIIIIIl, final Class<T> lllllllllllllIIIlIIIIllIlIIIIIII) {
        this.metadataSectionSerializerRegistry.putObject(lllllllllllllIIIlIIIIllIlIIIIIIl.getSectionName(), new Registration<IMetadataSection>((IMetadataSectionSerializer)lllllllllllllIIIlIIIIllIlIIIIIIl, (Class)lllllllllllllIIIlIIIIllIlIIIIIII, (Registration<IMetadataSection>)null));
        this.gsonBuilder.registerTypeAdapter((Type)lllllllllllllIIIlIIIIllIlIIIIIII, (Object)lllllllllllllIIIlIIIIllIlIIIIIIl);
        this.gson = null;
    }
    
    class Registration<T extends IMetadataSection>
    {
        final /* synthetic */ Class<T> clazz;
        final /* synthetic */ IMetadataSectionSerializer<T> section;
        
        private Registration(final IMetadataSectionSerializer<T> lllllllllllllIlIlIlIlIllIlIllIII, final Class<T> lllllllllllllIlIlIlIlIllIlIlIlll) {
            this.section = lllllllllllllIlIlIlIlIllIlIllIII;
            this.clazz = lllllllllllllIlIlIlIlIllIlIlIlll;
        }
    }
}
