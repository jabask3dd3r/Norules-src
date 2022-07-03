package net.minecraft.client.resources;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.data.*;
import java.nio.charset.*;
import com.google.gson.*;
import org.apache.commons.io.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.io.*;

public class SimpleResource implements IResource
{
    private /* synthetic */ boolean mcmetaJsonChecked;
    private final /* synthetic */ Map<String, IMetadataSection> mapMetadataSections;
    private /* synthetic */ JsonObject mcmetaJson;
    private final /* synthetic */ InputStream resourceInputStream;
    private final /* synthetic */ ResourceLocation srResourceLocation;
    private final /* synthetic */ InputStream mcmetaInputStream;
    private final /* synthetic */ String resourcePackName;
    private final /* synthetic */ MetadataSerializer srMetadataSerializer;
    
    @Override
    public int hashCode() {
        int lllllllllllllIIlIIlIlIlIIllIIIlI = (this.resourcePackName != null) ? this.resourcePackName.hashCode() : 0;
        lllllllllllllIIlIIlIlIlIIllIIIlI = 31 * lllllllllllllIIlIIlIlIlIIllIIIlI + ((this.srResourceLocation != null) ? this.srResourceLocation.hashCode() : 0);
        return lllllllllllllIIlIIlIlIlIIllIIIlI;
    }
    
    @Override
    public String getResourcePackName() {
        return this.resourcePackName;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIIlIlIlIIllIIlll) {
        if (this == lllllllllllllIIlIIlIlIlIIllIIlll) {
            return true;
        }
        if (!(lllllllllllllIIlIIlIlIlIIllIIlll instanceof SimpleResource)) {
            return false;
        }
        final SimpleResource lllllllllllllIIlIIlIlIlIIllIlIIl = (SimpleResource)lllllllllllllIIlIIlIlIlIIllIIlll;
        if (this.srResourceLocation != null) {
            if (!this.srResourceLocation.equals(lllllllllllllIIlIIlIlIlIIllIlIIl.srResourceLocation)) {
                return false;
            }
        }
        else if (lllllllllllllIIlIIlIlIlIIllIlIIl.srResourceLocation != null) {
            return false;
        }
        if (this.resourcePackName != null) {
            if (!this.resourcePackName.equals(lllllllllllllIIlIIlIlIlIIllIlIIl.resourcePackName)) {
                return false;
            }
        }
        else if (lllllllllllllIIlIIlIlIlIIllIlIIl.resourcePackName != null) {
            return false;
        }
        return true;
    }
    
    @Override
    public InputStream getInputStream() {
        return this.resourceInputStream;
    }
    
    @Override
    public boolean hasMetadata() {
        return this.mcmetaInputStream != null;
    }
    
    @Nullable
    @Override
    public <T extends IMetadataSection> T getMetadata(final String lllllllllllllIIlIIlIlIlIIlllIlII) {
        if (!this.hasMetadata()) {
            return null;
        }
        if (this.mcmetaJson == null && !this.mcmetaJsonChecked) {
            this.mcmetaJsonChecked = true;
            BufferedReader lllllllllllllIIlIIlIlIlIIlllIlll = null;
            try {
                lllllllllllllIIlIIlIlIlIIlllIlll = new BufferedReader(new InputStreamReader(this.mcmetaInputStream, StandardCharsets.UTF_8));
                this.mcmetaJson = new JsonParser().parse((Reader)lllllllllllllIIlIIlIlIlIIlllIlll).getAsJsonObject();
            }
            finally {
                IOUtils.closeQuietly((Reader)lllllllllllllIIlIIlIlIlIIlllIlll);
            }
            IOUtils.closeQuietly((Reader)lllllllllllllIIlIIlIlIlIIlllIlll);
        }
        T lllllllllllllIIlIIlIlIlIIlllIllI = (T)this.mapMetadataSections.get(lllllllllllllIIlIIlIlIlIIlllIlII);
        if (lllllllllllllIIlIIlIlIlIIlllIllI == null) {
            lllllllllllllIIlIIlIlIlIIlllIllI = this.srMetadataSerializer.parseMetadataSection(lllllllllllllIIlIIlIlIlIIlllIlII, this.mcmetaJson);
        }
        return lllllllllllllIIlIIlIlIlIIlllIllI;
    }
    
    public SimpleResource(final String lllllllllllllIIlIIlIlIlIlIIlIIIl, final ResourceLocation lllllllllllllIIlIIlIlIlIlIIlIIII, final InputStream lllllllllllllIIlIIlIlIlIlIIIllll, final InputStream lllllllllllllIIlIIlIlIlIlIIIlIII, final MetadataSerializer lllllllllllllIIlIIlIlIlIlIIIIlll) {
        this.mapMetadataSections = (Map<String, IMetadataSection>)Maps.newHashMap();
        this.resourcePackName = lllllllllllllIIlIIlIlIlIlIIlIIIl;
        this.srResourceLocation = lllllllllllllIIlIIlIlIlIlIIlIIII;
        this.resourceInputStream = lllllllllllllIIlIIlIlIlIlIIIllll;
        this.mcmetaInputStream = lllllllllllllIIlIIlIlIlIlIIIlIII;
        this.srMetadataSerializer = lllllllllllllIIlIIlIlIlIlIIIIlll;
    }
    
    @Override
    public void close() throws IOException {
        this.resourceInputStream.close();
        if (this.mcmetaInputStream != null) {
            this.mcmetaInputStream.close();
        }
    }
    
    @Override
    public ResourceLocation getResourceLocation() {
        return this.srResourceLocation;
    }
}
