package com.viaversion.viaversion.util;

import com.viaversion.viaversion.api.configuration.*;
import java.net.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.legacy.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.representer.*;
import org.yaml.snakeyaml.constructor.*;
import java.util.concurrent.*;
import java.io.*;
import java.util.*;

public abstract class Config implements ConfigurationProvider
{
    private final /* synthetic */ CommentStore commentStore;
    private static final /* synthetic */ ThreadLocal<Yaml> YAML;
    private final /* synthetic */ File configFile;
    private /* synthetic */ Map<String, Object> config;
    
    @Override
    public void set(final String lllllllllllllIlIIIIIIIIlIIlIIIIl, final Object lllllllllllllIlIIIIIIIIlIIlIIIII) {
        this.config.put(lllllllllllllIlIIIIIIIIlIIlIIIIl, lllllllllllllIlIIIIIIIIlIIlIIIII);
    }
    
    public abstract URL getDefaultConfigURL();
    
    public JsonElement getSerializedComponent(final String lllllllllllllIlIIIIIIIIIllIIlIIl) {
        final Object lllllllllllllIlIIIIIIIIIllIIlIll = this.config.get(lllllllllllllIlIIIIIIIIIllIIlIIl);
        if (lllllllllllllIlIIIIIIIIIllIIlIll != null && !((String)lllllllllllllIlIIIIIIIIIllIIlIll).isEmpty()) {
            return GsonComponentSerializer.gson().serializeToTree(LegacyComponentSerializer.legacySection().deserialize((String)lllllllllllllIlIIIIIIIIIllIIlIll));
        }
        return null;
    }
    
    protected abstract void handleConfig(final Map<String, Object> p0);
    
    public List<Integer> getIntegerList(final String lllllllllllllIlIIIIIIIIIllIlIlIl) {
        final Object lllllllllllllIlIIIIIIIIIllIlIlII = this.config.get(lllllllllllllIlIIIIIIIIIllIlIlIl);
        if (lllllllllllllIlIIIIIIIIIllIlIlII != null) {
            return (List<Integer>)lllllllllllllIlIIIIIIIIIllIlIlII;
        }
        return new ArrayList<Integer>();
    }
    
    public synchronized void saveConfig(final File lllllllllllllIlIIIIIIIIlIIlIlIll, final Map<String, Object> lllllllllllllIlIIIIIIIIlIIlIlIlI) {
        try {
            this.commentStore.writeComments(Config.YAML.get().dump(lllllllllllllIlIIIIIIIIlIIlIlIlI), lllllllllllllIlIIIIIIIIlIIlIlIll);
        }
        catch (IOException lllllllllllllIlIIIIIIIIlIIllIIII) {
            lllllllllllllIlIIIIIIIIlIIllIIII.printStackTrace();
        }
    }
    
    @Override
    public void saveConfig() {
        this.configFile.getParentFile().mkdirs();
        this.saveConfig(this.configFile, this.config);
    }
    
    public boolean getBoolean(final String lllllllllllllIlIIIIIIIIlIIIIIlII, final boolean lllllllllllllIlIIIIIIIIlIIIIIIll) {
        final Object lllllllllllllIlIIIIIIIIlIIIIIIlI = this.config.get(lllllllllllllIlIIIIIIIIlIIIIIlII);
        if (lllllllllllllIlIIIIIIIIlIIIIIIlI != null) {
            return (boolean)lllllllllllllIlIIIIIIIIlIIIIIIlI;
        }
        return lllllllllllllIlIIIIIIIIlIIIIIIll;
    }
    
    public Config(final File lllllllllllllIlIIIIIIIIlIllIIlIl) {
        this.commentStore = new CommentStore('.', 2);
        this.configFile = lllllllllllllIlIIIIIIIIlIllIIlIl;
    }
    
    public <T> T get(final String lllllllllllllIlIIIIIIIIlIIIlIIIl, final Class<T> lllllllllllllIlIIIIIIIIlIIIlIIII, final T lllllllllllllIlIIIIIIIIlIIIIllll) {
        final Object lllllllllllllIlIIIIIIIIlIIIIlllI = this.config.get(lllllllllllllIlIIIIIIIIlIIIlIIIl);
        if (lllllllllllllIlIIIIIIIIlIIIIlllI != null) {
            return (T)lllllllllllllIlIIIIIIIIlIIIIlllI;
        }
        return lllllllllllllIlIIIIIIIIlIIIIllll;
    }
    
    @Override
    public void reloadConfig() {
        this.configFile.getParentFile().mkdirs();
        this.config = new ConcurrentSkipListMap<String, Object>(this.loadConfig(this.configFile));
    }
    
    @Override
    public Map<String, Object> getValues() {
        return this.config;
    }
    
    public String getString(final String lllllllllllllIlIIIIIIIIIlllllIII, final String lllllllllllllIlIIIIIIIIIllllIIll) {
        final Object lllllllllllllIlIIIIIIIIIllllIllI = this.config.get(lllllllllllllIlIIIIIIIIIlllllIII);
        if (lllllllllllllIlIIIIIIIIIllllIllI != null) {
            return (String)lllllllllllllIlIIIIIIIIIllllIllI;
        }
        return lllllllllllllIlIIIIIIIIIllllIIll;
    }
    
    public int getInt(final String lllllllllllllIlIIIIIIIIIlllIllII, final int lllllllllllllIlIIIIIIIIIlllIlIll) {
        final Object lllllllllllllIlIIIIIIIIIlllIlIlI = this.config.get(lllllllllllllIlIIIIIIIIIlllIllII);
        if (lllllllllllllIlIIIIIIIIIlllIlIlI == null) {
            return lllllllllllllIlIIIIIIIIIlllIlIll;
        }
        if (lllllllllllllIlIIIIIIIIIlllIlIlI instanceof Number) {
            return ((Number)lllllllllllllIlIIIIIIIIIlllIlIlI).intValue();
        }
        return lllllllllllllIlIIIIIIIIIlllIlIll;
    }
    
    public double getDouble(final String lllllllllllllIlIIIIIIIIIlllIIIII, final double lllllllllllllIlIIIIIIIIIllIllIll) {
        final Object lllllllllllllIlIIIIIIIIIllIllllI = this.config.get(lllllllllllllIlIIIIIIIIIlllIIIII);
        if (lllllllllllllIlIIIIIIIIIllIllllI == null) {
            return lllllllllllllIlIIIIIIIIIllIllIll;
        }
        if (lllllllllllllIlIIIIIIIIIllIllllI instanceof Number) {
            return ((Number)lllllllllllllIlIIIIIIIIIllIllllI).doubleValue();
        }
        return lllllllllllllIlIIIIIIIIIllIllIll;
    }
    
    static {
        final DumperOptions lllllllllllllIlIIIIIIIIIllIIIllI;
        final Object o;
        YAML = ThreadLocal.withInitial(() -> {
            lllllllllllllIlIIIIIIIIIllIIIllI = new DumperOptions();
            lllllllllllllIlIIIIIIIIIllIIIllI.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            lllllllllllllIlIIIIIIIIIllIIIllI.setPrettyFlow(false);
            lllllllllllllIlIIIIIIIIIllIIIllI.setIndent(2);
            new Yaml(new YamlConstructor(), new Representer(), lllllllllllllIlIIIIIIIIIllIIIllI);
            return o;
        });
    }
    
    public abstract List<String> getUnsupportedOptions();
    
    public synchronized Map<String, Object> loadConfig(final File lllllllllllllIlIIIIIIIIlIIllllII) {
        final List<String> lllllllllllllIlIIIIIIIIlIlIIIIIl = this.getUnsupportedOptions();
        final URL lllllllllllllIlIIIIIIIIlIlIIIIII = this.getDefaultConfigURL();
        try {
            this.commentStore.storeComments(lllllllllllllIlIIIIIIIIlIlIIIIII.openStream());
            for (final String lllllllllllllIlIIIIIIIIlIlIIllII : lllllllllllllIlIIIIIIIIlIlIIIIIl) {
                final List<String> lllllllllllllIlIIIIIIIIlIlIIllIl = this.commentStore.header(lllllllllllllIlIIIIIIIIlIlIIllII);
                if (lllllllllllllIlIIIIIIIIlIlIIllIl != null) {
                    lllllllllllllIlIIIIIIIIlIlIIllIl.clear();
                }
            }
        }
        catch (IOException lllllllllllllIlIIIIIIIIlIlIIlIll) {
            lllllllllllllIlIIIIIIIIlIlIIlIll.printStackTrace();
        }
        Map<String, Object> lllllllllllllIlIIIIIIIIlIIllllll = null;
        if (lllllllllllllIlIIIIIIIIlIIllllII.exists()) {
            try {
                final FileInputStream lllllllllllllIlIIIIIIIIlIlIIlIlI = new FileInputStream(lllllllllllllIlIIIIIIIIlIIllllII);
                try {
                    lllllllllllllIlIIIIIIIIlIIllllll = Config.YAML.get().load(lllllllllllllIlIIIIIIIIlIlIIlIlI);
                    lllllllllllllIlIIIIIIIIlIlIIlIlI.close();
                }
                catch (Throwable lllllllllllllIlIIIIIIIIlIIllIlll) {
                    try {
                        lllllllllllllIlIIIIIIIIlIlIIlIlI.close();
                    }
                    catch (Throwable lllllllllllllIlIIIIIIIIlIIllIllI) {
                        ((Throwable)lllllllllllllIlIIIIIIIIlIIllIlll).addSuppressed((Throwable)lllllllllllllIlIIIIIIIIlIIllIllI);
                    }
                    throw lllllllllllllIlIIIIIIIIlIIllIlll;
                }
            }
            catch (FileNotFoundException lllllllllllllIlIIIIIIIIlIlIIlIIl) {
                lllllllllllllIlIIIIIIIIlIlIIlIIl.printStackTrace();
            }
            catch (IOException lllllllllllllIlIIIIIIIIlIlIIlIII) {
                lllllllllllllIlIIIIIIIIlIlIIlIII.printStackTrace();
            }
        }
        if (lllllllllllllIlIIIIIIIIlIIllllll == null) {
            lllllllllllllIlIIIIIIIIlIIllllll = new HashMap<String, Object>();
        }
        Map<String, Object> lllllllllllllIlIIIIIIIIlIIlllllI = lllllllllllllIlIIIIIIIIlIIllllll;
        try {
            final InputStream lllllllllllllIlIIIIIIIIlIlIIIlIl = lllllllllllllIlIIIIIIIIlIlIIIIII.openStream();
            try {
                lllllllllllllIlIIIIIIIIlIIlllllI = Config.YAML.get().load(lllllllllllllIlIIIIIIIIlIlIIIlIl);
                for (final String lllllllllllllIlIIIIIIIIlIlIIIlll : lllllllllllllIlIIIIIIIIlIlIIIIIl) {
                    lllllllllllllIlIIIIIIIIlIIlllllI.remove(lllllllllllllIlIIIIIIIIlIlIIIlll);
                }
                for (final Map.Entry<String, Object> lllllllllllllIlIIIIIIIIlIlIIIllI : lllllllllllllIlIIIIIIIIlIIllllll.entrySet()) {
                    if (lllllllllllllIlIIIIIIIIlIIlllllI.containsKey(lllllllllllllIlIIIIIIIIlIlIIIllI.getKey()) && !lllllllllllllIlIIIIIIIIlIlIIIIIl.contains(lllllllllllllIlIIIIIIIIlIlIIIllI.getKey())) {
                        lllllllllllllIlIIIIIIIIlIIlllllI.put(lllllllllllllIlIIIIIIIIlIlIIIllI.getKey(), lllllllllllllIlIIIIIIIIlIlIIIllI.getValue());
                    }
                }
                if (lllllllllllllIlIIIIIIIIlIlIIIlIl != null) {
                    lllllllllllllIlIIIIIIIIlIlIIIlIl.close();
                }
            }
            catch (Throwable lllllllllllllIlIIIIIIIIlIIllIllI) {
                if (lllllllllllllIlIIIIIIIIlIlIIIlIl != null) {
                    try {
                        lllllllllllllIlIIIIIIIIlIlIIIlIl.close();
                    }
                    catch (Throwable lllllllllllllIlIIIIIIIIlIIllIlIl) {
                        ((Throwable)lllllllllllllIlIIIIIIIIlIIllIllI).addSuppressed((Throwable)lllllllllllllIlIIIIIIIIlIIllIlIl);
                    }
                }
                throw lllllllllllllIlIIIIIIIIlIIllIllI;
            }
        }
        catch (IOException lllllllllllllIlIIIIIIIIlIlIIIlII) {
            lllllllllllllIlIIIIIIIIlIlIIIlII.printStackTrace();
        }
        this.handleConfig(lllllllllllllIlIIIIIIIIlIIlllllI);
        this.saveConfig(lllllllllllllIlIIIIIIIIlIIllllII, lllllllllllllIlIIIIIIIIlIIlllllI);
        return lllllllllllllIlIIIIIIIIlIIlllllI;
    }
}
