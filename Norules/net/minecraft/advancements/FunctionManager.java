package net.minecraft.advancements;

import java.io.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.command.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import org.apache.logging.log4j.*;
import org.apache.commons.io.*;
import java.nio.charset.*;
import com.google.common.io.*;
import java.util.*;

public class FunctionManager implements ITickable
{
    private /* synthetic */ boolean field_194021_h;
    private static final /* synthetic */ Logger field_193067_a;
    private final /* synthetic */ ICommandSender field_193073_g;
    private final /* synthetic */ File field_193068_b;
    private final /* synthetic */ MinecraftServer field_193069_c;
    private final /* synthetic */ Map<ResourceLocation, FunctionObject> field_193070_d;
    private /* synthetic */ FunctionObject field_193072_f;
    private final /* synthetic */ ArrayDeque<QueuedCommand> field_194020_g;
    private /* synthetic */ String field_193071_e;
    
    @Override
    public void update() {
        final String llllllllllllllIIlIlllIllIlIlIIll = this.field_193069_c.worldServers[0].getGameRules().getString("gameLoopFunction");
        if (!llllllllllllllIIlIlllIllIlIlIIll.equals(this.field_193071_e)) {
            this.field_193071_e = llllllllllllllIIlIlllIllIlIlIIll;
            this.field_193072_f = this.func_193058_a(new ResourceLocation(llllllllllllllIIlIlllIllIlIlIIll));
        }
        if (this.field_193072_f != null) {
            this.func_194019_a(this.field_193072_f, this.field_193073_g);
        }
    }
    
    public ICommandManager func_193062_a() {
        return this.field_193069_c.getCommandManager();
    }
    
    public void func_193059_f() {
        this.field_193070_d.clear();
        this.field_193072_f = null;
        this.field_193071_e = "-";
        this.func_193061_h();
    }
    
    public Map<ResourceLocation, FunctionObject> func_193066_d() {
        return this.field_193070_d;
    }
    
    public int func_193065_c() {
        return this.field_193069_c.worldServers[0].getGameRules().getInt("maxCommandChainLength");
    }
    
    public FunctionManager(@Nullable final File llllllllllllllIIlIlllIllIllIlIlI, final MinecraftServer llllllllllllllIIlIlllIllIllIlIIl) {
        this.field_193070_d = (Map<ResourceLocation, FunctionObject>)Maps.newHashMap();
        this.field_193071_e = "-";
        this.field_194020_g = new ArrayDeque<QueuedCommand>();
        this.field_194021_h = false;
        this.field_193073_g = new ICommandSender() {
            @Override
            public MinecraftServer getServer() {
                return FunctionManager.this.field_193069_c;
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int lllllllllllllIlIllIIlIllIIIIlllI, final String lllllllllllllIlIllIIlIllIIIIllll) {
                return lllllllllllllIlIllIIlIllIIIIlllI <= 2;
            }
            
            @Override
            public String getName() {
                return FunctionManager.this.field_193071_e;
            }
            
            @Override
            public World getEntityWorld() {
                return FunctionManager.this.field_193069_c.worldServers[0];
            }
        };
        this.field_193068_b = llllllllllllllIIlIlllIllIllIlIlI;
        this.field_193069_c = llllllllllllllIIlIlllIllIllIlIIl;
        this.func_193059_f();
    }
    
    static {
        field_193067_a = LogManager.getLogger();
    }
    
    public int func_194019_a(final FunctionObject llllllllllllllIIlIlllIllIlIIIlIl, final ICommandSender llllllllllllllIIlIlllIllIlIIIlII) {
        final int llllllllllllllIIlIlllIllIlIIIIll = this.func_193065_c();
        if (this.field_194021_h) {
            if (this.field_194020_g.size() < llllllllllllllIIlIlllIllIlIIIIll) {
                this.field_194020_g.addFirst(new QueuedCommand(this, llllllllllllllIIlIlllIllIlIIIlII, new FunctionObject.FunctionEntry(llllllllllllllIIlIlllIllIlIIIlIl)));
            }
            return 0;
        }
        Label_0186: {
            try {
                this.field_194021_h = true;
                int llllllllllllllIIlIlllIllIIllllll = 0;
                final FunctionObject.Entry[] llllllllllllllIIlIlllIllIIlllllI = llllllllllllllIIlIlllIllIlIIIlIl.func_193528_a();
                for (int llllllllllllllIIlIlllIllIIllllIl = llllllllllllllIIlIlllIllIIlllllI.length - 1; llllllllllllllIIlIlllIllIIllllIl >= 0; --llllllllllllllIIlIlllIllIIllllIl) {
                    this.field_194020_g.push(new QueuedCommand(this, llllllllllllllIIlIlllIllIlIIIlII, llllllllllllllIIlIlllIllIIlllllI[llllllllllllllIIlIlllIllIIllllIl]));
                }
                while (!this.field_194020_g.isEmpty()) {
                    this.field_194020_g.removeFirst().func_194222_a(this.field_194020_g, llllllllllllllIIlIlllIllIlIIIIll);
                    if (++llllllllllllllIIlIlllIllIIllllll >= llllllllllllllIIlIlllIllIlIIIIll) {
                        final int llllllllllllllIIlIlllIllIlIIIIIl = llllllllllllllIIlIlllIllIIllllll;
                        break Label_0186;
                    }
                }
                final byte llllllllllllllIIlIlllIllIIllIIll;
                final int llllllllllllllIIlIlllIllIlIIIIlI = llllllllllllllIIlIlllIllIIllIIll = (byte)llllllllllllllIIlIlllIllIIllllll;
                return llllllllllllllIIlIlllIllIIllIIll;
            }
            finally {
                this.field_194020_g.clear();
                this.field_194021_h = false;
            }
        }
        this.field_194020_g.clear();
        this.field_194021_h = false;
        final int llllllllllllllIIlIlllIllIlIIIIII;
        return llllllllllllllIIlIlllIllIlIIIIII;
    }
    
    @Nullable
    public FunctionObject func_193058_a(final ResourceLocation llllllllllllllIIlIlllIllIllIIIII) {
        return this.field_193070_d.get(llllllllllllllIIlIlllIllIllIIIII);
    }
    
    private void func_193061_h() {
        if (this.field_193068_b != null) {
            this.field_193068_b.mkdirs();
            for (final File llllllllllllllIIlIlllIllIIlIIlll : FileUtils.listFiles(this.field_193068_b, new String[] { "mcfunction" }, true)) {
                final String llllllllllllllIIlIlllIllIIlIIllI = FilenameUtils.removeExtension(this.field_193068_b.toURI().relativize(llllllllllllllIIlIlllIllIIlIIlll.toURI()).toString());
                final String[] llllllllllllllIIlIlllIllIIlIIlIl = llllllllllllllIIlIlllIllIIlIIllI.split("/", 2);
                if (llllllllllllllIIlIlllIllIIlIIlIl.length == 2) {
                    final ResourceLocation llllllllllllllIIlIlllIllIIlIIlII = new ResourceLocation(llllllllllllllIIlIlllIllIIlIIlIl[0], llllllllllllllIIlIlllIllIIlIIlIl[1]);
                    try {
                        this.field_193070_d.put(llllllllllllllIIlIlllIllIIlIIlII, FunctionObject.func_193527_a(this, Files.readLines(llllllllllllllIIlIlllIllIIlIIlll, StandardCharsets.UTF_8)));
                    }
                    catch (Throwable llllllllllllllIIlIlllIllIIlIIIll) {
                        FunctionManager.field_193067_a.error(String.valueOf(new StringBuilder("Couldn't read custom function ").append(llllllllllllllIIlIlllIllIIlIIlII).append(" from ").append(llllllllllllllIIlIlllIllIIlIIlll)), llllllllllllllIIlIlllIllIIlIIIll);
                    }
                }
            }
            if (!this.field_193070_d.isEmpty()) {
                FunctionManager.field_193067_a.info(String.valueOf(new StringBuilder("Loaded ").append(this.field_193070_d.size()).append(" custom command functions")));
            }
        }
    }
    
    public static class QueuedCommand
    {
        private final /* synthetic */ ICommandSender field_194224_b;
        private final /* synthetic */ FunctionObject.Entry field_194225_c;
        private final /* synthetic */ FunctionManager field_194223_a;
        
        public void func_194222_a(final ArrayDeque<QueuedCommand> llllllllllllllllllIIIlIlIlIlIIlI, final int llllllllllllllllllIIIlIlIlIIlllI) {
            this.field_194225_c.func_194145_a(this.field_194223_a, this.field_194224_b, llllllllllllllllllIIIlIlIlIlIIlI, llllllllllllllllllIIIlIlIlIIlllI);
        }
        
        @Override
        public String toString() {
            return this.field_194225_c.toString();
        }
        
        public QueuedCommand(final ICommandSender llllllllllllllllllIIIlIlIlIllIII, final FunctionObject.Entry llllllllllllllllllIIIlIlIlIlIlll) {
            this.field_194224_b = llllllllllllllllllIIIlIlIlIllIII;
            this.field_194225_c = llllllllllllllllllIIIlIlIlIlIlll;
        }
    }
}
