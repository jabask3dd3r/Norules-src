package file;

import me.nrules.utils.config.*;
import java.io.*;
import net.minecraft.client.*;
import com.google.gson.*;

public class FileFactory extends Container<IFile>
{
    private final /* synthetic */ Gson GSON;
    private /* synthetic */ File root;
    
    public void load() {
        this.forEach(lllllllllllllIIlIIIIlIllllIIIIlI -> lllllllllllllIIlIIIIlIllllIIIIlI.load(this.GSON));
    }
    
    public void saveFile(final Class<? extends IFile> lllllllllllllIIlIIIIlIlllllIlIII) {
        final IFile lllllllllllllIIlIIIIlIlllllIlIlI = this.findByClass(lllllllllllllIIlIIIIlIlllllIlIII);
        if (lllllllllllllIIlIIIIlIlllllIlIlI != null) {
            lllllllllllllIIlIIIIlIlllllIlIlI.save(this.GSON);
        }
    }
    
    public void setupRoot(final String lllllllllllllIIlIIIIlIllllIlIlII) {
        this.root = new File(Minecraft.getMinecraft().mcDataDir, lllllllllllllIIlIIIIlIllllIlIlII);
        if (!this.root.exists() && !this.root.mkdirs()) {
            System.out.println("problem with creating folder!");
        }
    }
    
    public void save() {
        this.forEach(lllllllllllllIIlIIIIlIllllIIlIII -> lllllllllllllIIlIIIIlIllllIIlIII.save(this.GSON));
    }
    
    @Override
    public void add(final IFile lllllllllllllIIlIIIIlIllllllIIlI) {
        lllllllllllllIIlIIIIlIllllllIIlI.setFile(this.root);
        System.out.println("pipiska");
        super.add(lllllllllllllIIlIIIIlIllllllIIlI);
    }
    
    public void loadFile(final Class<? extends IFile> lllllllllllllIIlIIIIlIlllllIIIlI) {
        final IFile lllllllllllllIIlIIIIlIlllllIIIIl = this.findByClass(lllllllllllllIIlIIIIlIlllllIIIlI);
        if (lllllllllllllIIlIIIIlIlllllIIIIl != null) {
            lllllllllllllIIlIIIIlIlllllIIIIl.load(this.GSON);
        }
    }
    
    public FileFactory() {
        this.GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    }
}
