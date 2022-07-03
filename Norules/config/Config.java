package config;

import java.io.*;
import me.nrules.module.*;
import com.google.gson.*;

public final class Config implements Serializable
{
    private final /* synthetic */ File file;
    private final /* synthetic */ String name;
    
    public String getName() {
        return this.name;
    }
    
    public Config(final String llllllllllllllIlIlIIlllllllIIIII) {
        this.name = llllllllllllllIlIlIIlllllllIIIII;
        this.file = new File(ConfigManager.CONFIGS_DIR, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlIIlllllllIIIII)).append(".json")));
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            }
            catch (IOException ex) {}
        }
    }
    
    @Override
    public void load(final JsonObject llllllllllllllIlIlIIlllllIllllII) {
        if (llllllllllllllIlIlIIlllllIllllII.has("Modules")) {
            final JsonObject llllllllllllllIlIlIIlllllIlllIll = llllllllllllllIlIlIIlllllIllllII.getAsJsonObject("Modules");
            for (final Module llllllllllllllIlIlIIlllllIlllIlI : ModuleManager.getModules()) {
                if (llllllllllllllIlIlIIlllllIlllIll.has(llllllllllllllIlIlIIlllllIlllIlI.getName())) {
                    llllllllllllllIlIlIIlllllIlllIlI.load(llllllllllllllIlIlIIlllllIlllIll.getAsJsonObject(llllllllllllllIlIlIIlllllIlllIlI.getName()));
                }
            }
        }
    }
    
    @Override
    public JsonObject save() {
        final JsonObject llllllllllllllIlIlIIllllllIIlIII = new JsonObject();
        final JsonObject llllllllllllllIlIlIIllllllIIIlll = new JsonObject();
        for (final Module llllllllllllllIlIlIIllllllIIIllI : ModuleManager.getModules()) {
            llllllllllllllIlIlIIllllllIIIlll.add(llllllllllllllIlIlIIllllllIIIllI.getName(), (JsonElement)llllllllllllllIlIlIIllllllIIIllI.save());
        }
        llllllllllllllIlIlIIllllllIIlIII.add("Modules", (JsonElement)llllllllllllllIlIlIIllllllIIIlll);
        return llllllllllllllIlIlIIllllllIIlIII;
    }
    
    public File getFile() {
        return this.file;
    }
}
