package net.minecraft.advancements;

import net.minecraft.item.crafting.*;
import java.nio.file.*;
import java.net.*;
import java.util.*;
import java.io.*;
import javax.annotation.*;
import com.google.common.collect.*;
import org.apache.commons.io.*;
import java.nio.charset.*;
import org.apache.logging.log4j.*;
import java.lang.reflect.*;
import net.minecraft.util.text.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class AdvancementManager
{
    private final /* synthetic */ File field_192785_d;
    private /* synthetic */ boolean field_193768_e;
    private static final /* synthetic */ Logger field_192782_a;
    private static final /* synthetic */ Gson field_192783_b;
    private static final /* synthetic */ AdvancementList field_192784_c;
    
    private void func_192777_a(final Map<ResourceLocation, Advancement.Builder> lllllllllllllIIllIIIllIllllIllll) {
        FileSystem lllllllllllllIIllIIIllIllllIlllI = null;
        try {
            final URL lllllllllllllIIllIIIllIllllIllIl = AdvancementManager.class.getResource("/assets/.mcassetsroot");
            if (lllllllllllllIIllIIIllIllllIllIl != null) {
                final URI lllllllllllllIIllIIIllIllllIllII = lllllllllllllIIllIIIllIllllIllIl.toURI();
                Path lllllllllllllIIllIIIllIllllIlIlI = null;
                if ("file".equals(lllllllllllllIIllIIIllIllllIllII.getScheme())) {
                    final Path lllllllllllllIIllIIIllIllllIlIll = Paths.get(CraftingManager.class.getResource("/assets/minecraft/advancements").toURI());
                }
                else {
                    if (!"jar".equals(lllllllllllllIIllIIIllIllllIllII.getScheme())) {
                        AdvancementManager.field_192782_a.error(String.valueOf(new StringBuilder("Unsupported scheme ").append(lllllllllllllIIllIIIllIllllIllII).append(" trying to list all built-in advancements (NYI?)")));
                        this.field_193768_e = true;
                        return;
                    }
                    lllllllllllllIIllIIIllIllllIlllI = FileSystems.newFileSystem(lllllllllllllIIllIIIllIllllIllII, Collections.emptyMap());
                    lllllllllllllIIllIIIllIllllIlIlI = lllllllllllllIIllIIIllIllllIlllI.getPath("/assets/minecraft/advancements", new String[0]);
                }
                for (final Path lllllllllllllIIllIIIllIllllIlIII : Files.walk(lllllllllllllIIllIIIllIllllIlIlI, new FileVisitOption[0])) {
                    if ("json".equals(FilenameUtils.getExtension(lllllllllllllIIllIIIllIllllIlIII.toString()))) {
                        final Path lllllllllllllIIllIIIllIllllIIlll = lllllllllllllIIllIIIllIllllIlIlI.relativize(lllllllllllllIIllIIIllIllllIlIII);
                        final String lllllllllllllIIllIIIllIllllIIllI = FilenameUtils.removeExtension(lllllllllllllIIllIIIllIllllIIlll.toString()).replaceAll("\\\\", "/");
                        final ResourceLocation lllllllllllllIIllIIIllIllllIIlIl = new ResourceLocation("minecraft", lllllllllllllIIllIIIllIllllIIllI);
                        if (lllllllllllllIIllIIIllIllllIllll.containsKey(lllllllllllllIIllIIIllIllllIIlIl)) {
                            continue;
                        }
                        BufferedReader lllllllllllllIIllIIIllIllllIIlII = null;
                        try {
                            lllllllllllllIIllIIIllIllllIIlII = Files.newBufferedReader(lllllllllllllIIllIIIllIllllIlIII);
                            final Advancement.Builder lllllllllllllIIllIIIllIllllIIIll = JsonUtils.func_193839_a(AdvancementManager.field_192783_b, lllllllllllllIIllIIIllIllllIIlII, Advancement.Builder.class);
                            lllllllllllllIIllIIIllIllllIllll.put(lllllllllllllIIllIIIllIllllIIlIl, lllllllllllllIIllIIIllIllllIIIll);
                        }
                        catch (JsonParseException lllllllllllllIIllIIIllIllllIIIlI) {
                            AdvancementManager.field_192782_a.error(String.valueOf(new StringBuilder("Parsing error loading built-in advancement ").append(lllllllllllllIIllIIIllIllllIIlIl)), (Throwable)lllllllllllllIIllIIIllIllllIIIlI);
                            this.field_193768_e = true;
                        }
                        catch (IOException lllllllllllllIIllIIIllIllllIIIIl) {
                            AdvancementManager.field_192782_a.error(String.valueOf(new StringBuilder("Couldn't read advancement ").append(lllllllllllllIIllIIIllIllllIIlIl).append(" from ").append(lllllllllllllIIllIIIllIllllIlIII)), (Throwable)lllllllllllllIIllIIIllIllllIIIIl);
                            this.field_193768_e = true;
                        }
                        finally {
                            IOUtils.closeQuietly((Reader)lllllllllllllIIllIIIllIllllIIlII);
                        }
                        IOUtils.closeQuietly((Reader)lllllllllllllIIllIIIllIllllIIlII);
                    }
                }
                return;
            }
            AdvancementManager.field_192782_a.error("Couldn't find .mcassetsroot");
            this.field_193768_e = true;
        }
        catch (IOException ex) {}
        catch (URISyntaxException lllllllllllllIIllIIIllIllllIIIII) {
            AdvancementManager.field_192782_a.error("Couldn't get a list of all built-in advancement files", (Throwable)lllllllllllllIIllIIIllIllllIIIII);
            this.field_193768_e = true;
            return;
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllllIIllIIIllIllllIlllI);
        }
        IOUtils.closeQuietly((Closeable)lllllllllllllIIllIIIllIllllIlllI);
    }
    
    public void func_192779_a() {
        this.field_193768_e = false;
        AdvancementManager.field_192784_c.func_192087_a();
        final Map<ResourceLocation, Advancement.Builder> lllllllllllllIIllIIIlllIIIlIIIIl = this.func_192781_c();
        this.func_192777_a(lllllllllllllIIllIIIlllIIIlIIIIl);
        AdvancementManager.field_192784_c.func_192083_a(lllllllllllllIIllIIIlllIIIlIIIIl);
        for (final Advancement lllllllllllllIIllIIIlllIIIlIIIII : AdvancementManager.field_192784_c.func_192088_b()) {
            if (lllllllllllllIIllIIIlllIIIlIIIII.func_192068_c() != null) {
                AdvancementTreeNode.func_192323_a(lllllllllllllIIllIIIlllIIIlIIIII);
            }
        }
    }
    
    @Nullable
    public Advancement func_192778_a(final ResourceLocation lllllllllllllIIllIIIllIlllIIllIl) {
        return AdvancementManager.field_192784_c.func_192084_a(lllllllllllllIIllIIIllIlllIIllIl);
    }
    
    public AdvancementManager(@Nullable final File lllllllllllllIIllIIIlllIIIlIlIIl) {
        this.field_192785_d = lllllllllllllIIllIIIlllIIIlIlIIl;
        this.func_192779_a();
    }
    
    private Map<ResourceLocation, Advancement.Builder> func_192781_c() {
        if (this.field_192785_d == null) {
            return (Map<ResourceLocation, Advancement.Builder>)Maps.newHashMap();
        }
        final Map<ResourceLocation, Advancement.Builder> lllllllllllllIIllIIIlllIIIIIllll = (Map<ResourceLocation, Advancement.Builder>)Maps.newHashMap();
        this.field_192785_d.mkdirs();
        for (final File lllllllllllllIIllIIIlllIIIIIlllI : FileUtils.listFiles(this.field_192785_d, new String[] { "json" }, true)) {
            final String lllllllllllllIIllIIIlllIIIIIllIl = FilenameUtils.removeExtension(this.field_192785_d.toURI().relativize(lllllllllllllIIllIIIlllIIIIIlllI.toURI()).toString());
            final String[] lllllllllllllIIllIIIlllIIIIIllII = lllllllllllllIIllIIIlllIIIIIllIl.split("/", 2);
            if (lllllllllllllIIllIIIlllIIIIIllII.length == 2) {
                final ResourceLocation lllllllllllllIIllIIIlllIIIIIlIll = new ResourceLocation(lllllllllllllIIllIIIlllIIIIIllII[0], lllllllllllllIIllIIIlllIIIIIllII[1]);
                try {
                    final Advancement.Builder lllllllllllllIIllIIIlllIIIIIlIlI = JsonUtils.gsonDeserialize(AdvancementManager.field_192783_b, FileUtils.readFileToString(lllllllllllllIIllIIIlllIIIIIlllI, StandardCharsets.UTF_8), Advancement.Builder.class);
                    if (lllllllllllllIIllIIIlllIIIIIlIlI == null) {
                        AdvancementManager.field_192782_a.error(String.valueOf(new StringBuilder("Couldn't load custom advancement ").append(lllllllllllllIIllIIIlllIIIIIlIll).append(" from ").append(lllllllllllllIIllIIIlllIIIIIlllI).append(" as it's empty or null")));
                    }
                    else {
                        lllllllllllllIIllIIIlllIIIIIllll.put(lllllllllllllIIllIIIlllIIIIIlIll, lllllllllllllIIllIIIlllIIIIIlIlI);
                    }
                }
                catch (IllegalArgumentException | JsonParseException ex2) {
                    final RuntimeException ex;
                    final RuntimeException lllllllllllllIIllIIIlllIIIIIlIIl = ex;
                    AdvancementManager.field_192782_a.error(String.valueOf(new StringBuilder("Parsing error loading custom advancement ").append(lllllllllllllIIllIIIlllIIIIIlIll)), (Throwable)lllllllllllllIIllIIIlllIIIIIlIIl);
                    this.field_193768_e = true;
                }
                catch (IOException lllllllllllllIIllIIIlllIIIIIlIII) {
                    AdvancementManager.field_192782_a.error(String.valueOf(new StringBuilder("Couldn't read custom advancement ").append(lllllllllllllIIllIIIlllIIIIIlIll).append(" from ").append(lllllllllllllIIllIIIlllIIIIIlllI)), (Throwable)lllllllllllllIIllIIIlllIIIIIlIII);
                    this.field_193768_e = true;
                }
            }
        }
        return lllllllllllllIIllIIIlllIIIIIllll;
    }
    
    public boolean func_193767_b() {
        return this.field_193768_e;
    }
    
    static {
        field_192782_a = LogManager.getLogger();
        field_192783_b = new GsonBuilder().registerTypeHierarchyAdapter((Class)Advancement.Builder.class, (Object)new JsonDeserializer<Advancement.Builder>() {
            public Advancement.Builder deserialize(final JsonElement lllllllllllllllIlllIllllIllllIlI, final Type lllllllllllllllIlllIllllIllllIIl, final JsonDeserializationContext lllllllllllllllIlllIllllIlllIlIl) throws JsonParseException {
                final JsonObject lllllllllllllllIlllIllllIlllIlll = JsonUtils.getJsonObject(lllllllllllllllIlllIllllIllllIlI, "advancement");
                return Advancement.Builder.func_192059_a(lllllllllllllllIlllIllllIlllIlll, lllllllllllllllIlllIllllIlllIlIl);
            }
        }).registerTypeAdapter((Type)AdvancementRewards.class, (Object)new AdvancementRewards.Deserializer()).registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new ITextComponent.Serializer()).registerTypeHierarchyAdapter((Class)Style.class, (Object)new Style.Serializer()).registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory()).create();
        field_192784_c = new AdvancementList();
    }
    
    public Iterable<Advancement> func_192780_b() {
        return AdvancementManager.field_192784_c.func_192089_c();
    }
}
