package config;

import java.util.*;
import org.apache.commons.io.*;
import com.google.gson.*;
import java.io.*;
import me.nrules.*;

public final class ConfigManager extends Manager<Config>
{
    public static final /* synthetic */ File CONFIGS_DIR;
    
    public ConfigManager() {
        this.setContents(loadConfigs());
        ConfigManager.CONFIGS_DIR.mkdirs();
    }
    
    private static ArrayList<Config> loadConfigs() {
        final ArrayList<Config> llllllllllllllIIllIIIlIllIlllllI = new ArrayList<Config>();
        final File[] llllllllllllllIIllIIIlIllIllllIl = ConfigManager.CONFIGS_DIR.listFiles();
        if (llllllllllllllIIllIIIlIllIllllIl != null) {
            final String llllllllllllllIIllIIIlIllIllIllI;
            final Exception llllllllllllllIIllIIIlIllIllIlll = (Exception)((File[])(Object)(llllllllllllllIIllIIIlIllIllIllI = (String)(Object)llllllllllllllIIllIIIlIllIllllIl)).length;
            for (char llllllllllllllIIllIIIlIllIlllIII = '\0'; llllllllllllllIIllIIIlIllIlllIII < llllllllllllllIIllIIIlIllIllIlll; ++llllllllllllllIIllIIIlIllIlllIII) {
                final File llllllllllllllIIllIIIlIllIllllII = llllllllllllllIIllIIIlIllIllIllI[llllllllllllllIIllIIIlIllIlllIII];
                if (FilenameUtils.getExtension(llllllllllllllIIllIIIlIllIllllII.getName()).equals("json")) {
                    llllllllllllllIIllIIIlIllIlllllI.add(new Config(FilenameUtils.removeExtension(llllllllllllllIIllIIIlIllIllllII.getName())));
                }
            }
        }
        return llllllllllllllIIllIIIlIllIlllllI;
    }
    
    public boolean deleteConfig(final String llllllllllllllIIllIIIlIllIIIIIIl) {
        if (llllllllllllllIIllIIIlIllIIIIIIl == null) {
            return false;
        }
        final Config llllllllllllllIIllIIIlIllIIIIIII;
        if ((llllllllllllllIIllIIIlIllIIIIIII = this.findConfig(llllllllllllllIIllIIIlIllIIIIIIl)) != null) {
            final File llllllllllllllIIllIIIlIlIlllllll = llllllllllllllIIllIIIlIllIIIIIII.getFile();
            this.getContents().remove(llllllllllllllIIllIIIlIllIIIIIII);
            return llllllllllllllIIllIIIlIlIlllllll.exists() && llllllllllllllIIllIIIlIlIlllllll.delete();
        }
        return false;
    }
    
    public boolean saveConfig(final String llllllllllllllIIllIIIlIllIIlllII) {
        if (llllllllllllllIIllIIIlIllIIlllII == null) {
            return false;
        }
        Config llllllllllllllIIllIIIlIllIIllIll;
        if ((llllllllllllllIIllIIIlIllIIllIll = this.findConfig(llllllllllllllIIllIIIlIllIIlllII)) == null) {
            final Config llllllllllllllIIllIIIlIllIIllIlI;
            llllllllllllllIIllIIIlIllIIllIll = (llllllllllllllIIllIIIlIllIIllIlI = new Config(llllllllllllllIIllIIIlIllIIlllII));
            this.getContents().add(llllllllllllllIIllIIIlIllIIllIlI);
        }
        final String llllllllllllllIIllIIIlIllIIllIIl = new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement)llllllllllllllIIllIIIlIllIIllIll.save());
        try {
            final FileWriter llllllllllllllIIllIIIlIllIIllIII = new FileWriter(llllllllllllllIIllIIIlIllIIllIll.getFile());
            llllllllllllllIIllIIIlIllIIllIII.write(llllllllllllllIIllIIIlIllIIllIIl);
            llllllllllllllIIllIIIlIllIIllIII.close();
            return true;
        }
        catch (IOException llllllllllllllIIllIIIlIllIIlIlll) {
            return false;
        }
    }
    
    public boolean loadConfig(final String llllllllllllllIIllIIIlIllIlIIlll) {
        if (llllllllllllllIIllIIIlIllIlIIlll == null) {
            return false;
        }
        final Config llllllllllllllIIllIIIlIllIlIllIl = this.findConfig(llllllllllllllIIllIIIlIllIlIIlll);
        if (llllllllllllllIIllIIIlIllIlIllIl == null) {
            return false;
        }
        try {
            final FileReader llllllllllllllIIllIIIlIllIlIllII = new FileReader(llllllllllllllIIllIIIlIllIlIllIl.getFile());
            final JsonParser llllllllllllllIIllIIIlIllIlIlIll = new JsonParser();
            final JsonObject llllllllllllllIIllIIIlIllIlIlIlI = (JsonObject)llllllllllllllIIllIIIlIllIlIlIll.parse((Reader)llllllllllllllIIllIIIlIllIlIllII);
            llllllllllllllIIllIIIlIllIlIllIl.load(llllllllllllllIIllIIIlIllIlIlIlI);
            return true;
        }
        catch (FileNotFoundException llllllllllllllIIllIIIlIllIlIlIIl) {
            return false;
        }
    }
    
    static {
        EXTENTION = ".json";
        CONFIGS_DIR = new File(Main.name, "configs");
    }
    
    public Config findConfig(final String llllllllllllllIIllIIIlIllIIIllII) {
        if (llllllllllllllIIllIIIlIllIIIllII == null) {
            return null;
        }
        for (final Config llllllllllllllIIllIIIlIllIIIlIll : this.getContents()) {
            if (llllllllllllllIIllIIIlIllIIIlIll.getName().equalsIgnoreCase(llllllllllllllIIllIIIlIllIIIllII)) {
                return llllllllllllllIIllIIIlIllIIIlIll;
            }
        }
        if (new File(ConfigManager.CONFIGS_DIR, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIIIlIllIIIllII)).append(".json"))).exists()) {
            return new Config(llllllllllllllIIllIIIlIllIIIllII);
        }
        return null;
    }
}
