package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

public class LegacyV2Adapter implements IResourcePack
{
    private final /* synthetic */ IResourcePack field_191383_a;
    
    @Override
    public String getPackName() {
        return this.field_191383_a.getPackName();
    }
    
    @Nullable
    @Override
    public <T extends IMetadataSection> T getPackMetadata(final MetadataSerializer lllllllllllllIlllIlIllIIIllllIll, final String lllllllllllllIlllIlIllIIIllllIlI) throws IOException {
        return this.field_191383_a.getPackMetadata(lllllllllllllIlllIlIllIIIllllIll, lllllllllllllIlllIlIllIIIllllIlI);
    }
    
    public LegacyV2Adapter(final IResourcePack lllllllllllllIlllIlIllIIlIlIIIII) {
        this.field_191383_a = lllllllllllllIlllIlIllIIlIlIIIII;
    }
    
    @Override
    public boolean resourceExists(final ResourceLocation lllllllllllllIlllIlIllIIlIIIIlIl) {
        return this.field_191383_a.resourceExists(this.func_191382_c(lllllllllllllIlllIlIllIIlIIIIlIl));
    }
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return this.field_191383_a.getPackImage();
    }
    
    private ResourceLocation func_191382_c(final ResourceLocation lllllllllllllIlllIlIllIIlIIlIIIl) {
        final String lllllllllllllIlllIlIllIIlIIlIIII = lllllllllllllIlllIlIllIIlIIlIIIl.getResourcePath();
        if (!"lang/swg_de.lang".equals(lllllllllllllIlllIlIllIIlIIlIIII) && lllllllllllllIlllIlIllIIlIIlIIII.startsWith("lang/") && lllllllllllllIlllIlIllIIlIIlIIII.endsWith(".lang")) {
            final int lllllllllllllIlllIlIllIIlIIIllll = lllllllllllllIlllIlIllIIlIIlIIII.indexOf(95);
            if (lllllllllllllIlllIlIllIIlIIIllll != -1) {
                final String lllllllllllllIlllIlIllIIlIIIlllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIlIllIIlIIlIIII.substring(0, lllllllllllllIlllIlIllIIlIIIllll + 1))).append(lllllllllllllIlllIlIllIIlIIlIIII.substring(lllllllllllllIlllIlIllIIlIIIllll + 1, lllllllllllllIlllIlIllIIlIIlIIII.indexOf(46, lllllllllllllIlllIlIllIIlIIIllll)).toUpperCase()).append(".lang"));
                return new ResourceLocation(lllllllllllllIlllIlIllIIlIIlIIIl.getResourceDomain(), "") {
                    @Override
                    public String getResourcePath() {
                        return lllllllllllllIlllIlIllIIlIIIlllI;
                    }
                };
            }
        }
        return lllllllllllllIlllIlIllIIlIIlIIIl;
    }
    
    @Override
    public InputStream getInputStream(final ResourceLocation lllllllllllllIlllIlIllIIlIIllIlI) throws IOException {
        return this.field_191383_a.getInputStream(this.func_191382_c(lllllllllllllIlllIlIllIIlIIllIlI));
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return this.field_191383_a.getResourceDomains();
    }
}
