package net.minecraft.client.resources;

import java.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import java.nio.charset.*;
import com.google.common.io.*;
import net.minecraft.util.*;
import com.google.gson.*;
import org.apache.commons.io.*;
import java.io.*;

public class ResourceIndex
{
    private final /* synthetic */ Map<String, File> resourceMap;
    private static final /* synthetic */ Logger LOGGER;
    
    @Nullable
    public File getFile(final ResourceLocation lllllllllllllIlllllIIIlIIIIlIllI) {
        final String lllllllllllllIlllllIIIlIIIIllIII = lllllllllllllIlllllIIIlIIIIlIllI.toString();
        return this.resourceMap.get(lllllllllllllIlllllIIIlIIIIllIII);
    }
    
    protected ResourceIndex() {
        this.resourceMap = (Map<String, File>)Maps.newHashMap();
    }
    
    public File getPackMcmeta() {
        return this.resourceMap.get("pack.mcmeta");
    }
    
    public boolean isFileExisting(final ResourceLocation lllllllllllllIlllllIIIlIIIIIllIl) {
        final File lllllllllllllIlllllIIIlIIIIIllll = this.getFile(lllllllllllllIlllllIIIlIIIIIllIl);
        return lllllllllllllIlllllIIIlIIIIIllll != null && lllllllllllllIlllllIIIlIIIIIllll.isFile();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public ResourceIndex(final File lllllllllllllIlllllIIIlIIIlllllI, final String lllllllllllllIlllllIIIlIIIlIllII) {
        this.resourceMap = (Map<String, File>)Maps.newHashMap();
        final File lllllllllllllIlllllIIIlIIIllllII = new File(lllllllllllllIlllllIIIlIIIlllllI, "objects");
        final File lllllllllllllIlllllIIIlIIIlllIll = new File(lllllllllllllIlllllIIIlIIIlllllI, String.valueOf(new StringBuilder("indexes/").append(lllllllllllllIlllllIIIlIIIlIllII).append(".json")));
        BufferedReader lllllllllllllIlllllIIIlIIIlllIlI = null;
        try {
            lllllllllllllIlllllIIIlIIIlllIlI = Files.newReader(lllllllllllllIlllllIIIlIIIlllIll, StandardCharsets.UTF_8);
            final JsonObject lllllllllllllIlllllIIIlIIIlllIIl = new JsonParser().parse((Reader)lllllllllllllIlllllIIIlIIIlllIlI).getAsJsonObject();
            final JsonObject lllllllllllllIlllllIIIlIIIlllIII = JsonUtils.getJsonObject(lllllllllllllIlllllIIIlIIIlllIIl, "objects", null);
            if (lllllllllllllIlllllIIIlIIIlllIII != null) {
                for (final Map.Entry<String, JsonElement> lllllllllllllIlllllIIIlIIIllIlll : lllllllllllllIlllllIIIlIIIlllIII.entrySet()) {
                    final JsonObject lllllllllllllIlllllIIIlIIIllIllI = (JsonObject)lllllllllllllIlllllIIIlIIIllIlll.getValue();
                    final String lllllllllllllIlllllIIIlIIIllIlIl = lllllllllllllIlllllIIIlIIIllIlll.getKey();
                    final String[] lllllllllllllIlllllIIIlIIIllIlII = lllllllllllllIlllllIIIlIIIllIlIl.split("/", 2);
                    final String lllllllllllllIlllllIIIlIIIllIIll = (lllllllllllllIlllllIIIlIIIllIlII.length == 1) ? lllllllllllllIlllllIIIlIIIllIlII[0] : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllllIIIlIIIllIlII[0])).append(":").append(lllllllllllllIlllllIIIlIIIllIlII[1]));
                    final String lllllllllllllIlllllIIIlIIIllIIlI = JsonUtils.getString(lllllllllllllIlllllIIIlIIIllIllI, "hash");
                    final File lllllllllllllIlllllIIIlIIIllIIIl = new File(lllllllllllllIlllllIIIlIIIllllII, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllllIIIlIIIllIIlI.substring(0, 2))).append("/").append(lllllllllllllIlllllIIIlIIIllIIlI)));
                    this.resourceMap.put(lllllllllllllIlllllIIIlIIIllIIll, lllllllllllllIlllllIIIlIIIllIIIl);
                }
            }
        }
        catch (JsonParseException lllllllllllllIlllllIIIlIIIllIIII) {
            ResourceIndex.LOGGER.error("Unable to parse resource index file: {}", (Object)lllllllllllllIlllllIIIlIIIlllIll);
        }
        catch (FileNotFoundException lllllllllllllIlllllIIIlIIIlIllll) {
            ResourceIndex.LOGGER.error("Can't find the resource index file: {}", (Object)lllllllllllllIlllllIIIlIIIlllIll);
        }
        finally {
            IOUtils.closeQuietly((Reader)lllllllllllllIlllllIIIlIIIlllIlI);
        }
        IOUtils.closeQuietly((Reader)lllllllllllllIlllllIIIlIIIlllIlI);
    }
}
