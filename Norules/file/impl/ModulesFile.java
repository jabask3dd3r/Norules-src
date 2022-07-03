package file.impl;

import file.*;
import java.io.*;
import me.nrules.module.*;
import com.google.gson.*;

public class ModulesFile implements IFile
{
    private /* synthetic */ File file;
    
    @Override
    public void save(final Gson llllllllllllllIllIIllIIIIlIIIlIl) {
        final JsonObject llllllllllllllIllIIllIIIIlIIlIIl = new JsonObject();
        final JsonObject llllllllllllllIllIIllIIIIlIIlIII = new JsonObject();
        for (final Module llllllllllllllIllIIllIIIIlIIIlll : ModuleManager.getModules()) {
            llllllllllllllIllIIllIIIIlIIlIII.add(llllllllllllllIllIIllIIIIlIIIlll.getName(), (JsonElement)llllllllllllllIllIIllIIIIlIIIlll.save());
        }
        llllllllllllllIllIIllIIIIlIIlIIl.add("Modules", (JsonElement)llllllllllllllIllIIllIIIIlIIlIII);
        this.writeFile(llllllllllllllIllIIllIIIIlIIIlIl.toJson((JsonElement)llllllllllllllIllIIllIIIIlIIlIIl), this.file);
    }
    
    @Override
    public void load(final Gson llllllllllllllIllIIllIIIIIlllIIl) {
        if (!this.file.exists()) {
            return;
        }
        final JsonObject llllllllllllllIllIIllIIIIIlllIII = (JsonObject)llllllllllllllIllIIllIIIIIlllIIl.fromJson(this.readFile(this.file), (Class)JsonObject.class);
        if (llllllllllllllIllIIllIIIIIlllIII.has("Modules")) {
            final JsonObject llllllllllllllIllIIllIIIIIllIlll = llllllllllllllIllIIllIIIIIlllIII.getAsJsonObject("Modules");
            for (final Module llllllllllllllIllIIllIIIIIllIllI : ModuleManager.getModules()) {
                if (llllllllllllllIllIIllIIIIIllIlll.has(llllllllllllllIllIIllIIIIIllIllI.getName())) {
                    llllllllllllllIllIIllIIIIIllIllI.load(llllllllllllllIllIIllIIIIIllIlll.getAsJsonObject(llllllllllllllIllIIllIIIIIllIllI.getName()));
                }
            }
        }
    }
    
    @Override
    public void setFile(final File llllllllllllllIllIIllIIIIIlIllII) {
        this.file = new File(llllllllllllllIllIIllIIIIIlIllII, "/modules.json");
    }
}
