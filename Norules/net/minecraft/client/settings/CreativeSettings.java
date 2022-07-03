package net.minecraft.client.settings;

import java.io.*;
import net.minecraft.client.*;
import org.apache.logging.log4j.*;
import net.minecraft.nbt.*;

public class CreativeSettings
{
    private final /* synthetic */ HotbarSnapshot[] field_192568_d;
    private final /* synthetic */ File field_192567_c;
    protected /* synthetic */ Minecraft field_192565_a;
    private static final /* synthetic */ Logger field_192566_b;
    
    public CreativeSettings(final Minecraft llllllllllllllIlIllllIlIIIIIlIII, final File llllllllllllllIlIllllIlIIIIIIlll) {
        this.field_192568_d = new HotbarSnapshot[9];
        this.field_192565_a = llllllllllllllIlIllllIlIIIIIlIII;
        this.field_192567_c = new File(llllllllllllllIlIllllIlIIIIIIlll, "hotbar.nbt");
        for (int llllllllllllllIlIllllIlIIIIIlIlI = 0; llllllllllllllIlIllllIlIIIIIlIlI < 9; ++llllllllllllllIlIllllIlIIIIIlIlI) {
            this.field_192568_d[llllllllllllllIlIllllIlIIIIIlIlI] = new HotbarSnapshot();
        }
        this.func_192562_a();
    }
    
    public void func_192562_a() {
        try {
            final NBTTagCompound llllllllllllllIlIllllIlIIIIIIIIl = CompressedStreamTools.read(this.field_192567_c);
            if (llllllllllllllIlIllllIlIIIIIIIIl == null) {
                return;
            }
            for (int llllllllllllllIlIllllIlIIIIIIIII = 0; llllllllllllllIlIllllIlIIIIIIIII < 9; ++llllllllllllllIlIllllIlIIIIIIIII) {
                this.field_192568_d[llllllllllllllIlIllllIlIIIIIIIII].func_192833_a(llllllllllllllIlIllllIlIIIIIIIIl.getTagList(String.valueOf(llllllllllllllIlIllllIlIIIIIIIII), 10));
            }
        }
        catch (Exception llllllllllllllIlIllllIIlllllllll) {
            CreativeSettings.field_192566_b.error("Failed to load creative mode options", (Throwable)llllllllllllllIlIllllIIlllllllll);
        }
    }
    
    public HotbarSnapshot func_192563_a(final int llllllllllllllIlIllllIIllllIllII) {
        return this.field_192568_d[llllllllllllllIlIllllIIllllIllII];
    }
    
    static {
        field_192566_b = LogManager.getLogger();
    }
    
    public void func_192564_b() {
        try {
            final NBTTagCompound llllllllllllllIlIllllIIlllllIlll = new NBTTagCompound();
            for (int llllllllllllllIlIllllIIlllllIllI = 0; llllllllllllllIlIllllIIlllllIllI < 9; ++llllllllllllllIlIllllIIlllllIllI) {
                llllllllllllllIlIllllIIlllllIlll.setTag(String.valueOf(llllllllllllllIlIllllIIlllllIllI), this.field_192568_d[llllllllllllllIlIllllIIlllllIllI].func_192834_a());
            }
            CompressedStreamTools.write(llllllllllllllIlIllllIIlllllIlll, this.field_192567_c);
        }
        catch (Exception llllllllllllllIlIllllIIlllllIlIl) {
            CreativeSettings.field_192566_b.error("Failed to save creative mode options", (Throwable)llllllllllllllIlIllllIIlllllIlIl);
        }
    }
}
