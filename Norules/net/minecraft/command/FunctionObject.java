package net.minecraft.command;

import net.minecraft.advancements.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.*;
import javax.annotation.*;

public class FunctionObject
{
    private final /* synthetic */ Entry[] field_193530_b;
    
    public static FunctionObject func_193527_a(final FunctionManager llllllllllllIlllllIllIIllIIIlIIl, final List<String> llllllllllllIlllllIllIIllIIIIIlI) {
        final List<Entry> llllllllllllIlllllIllIIllIIIIlll = (List<Entry>)Lists.newArrayListWithCapacity(llllllllllllIlllllIllIIllIIIIIlI.size());
        for (String llllllllllllIlllllIllIIllIIIIllI : llllllllllllIlllllIllIIllIIIIIlI) {
            llllllllllllIlllllIllIIllIIIIllI = llllllllllllIlllllIllIIllIIIIllI.trim();
            if (!llllllllllllIlllllIllIIllIIIIllI.startsWith("#") && !llllllllllllIlllllIllIIllIIIIllI.isEmpty()) {
                final String[] llllllllllllIlllllIllIIllIIIIlIl = llllllllllllIlllllIllIIllIIIIllI.split(" ", 2);
                final String llllllllllllIlllllIllIIllIIIIlII = llllllllllllIlllllIllIIllIIIIlIl[0];
                if (!llllllllllllIlllllIllIIllIIIlIIl.func_193062_a().getCommands().containsKey(llllllllllllIlllllIllIIllIIIIlII)) {
                    if (llllllllllllIlllllIllIIllIIIIlII.startsWith("//")) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown or invalid command '").append(llllllllllllIlllllIllIIllIIIIlII).append("' (if you intended to make a comment, use '#' not '//')")));
                    }
                    if (llllllllllllIlllllIllIIllIIIIlII.startsWith("/") && llllllllllllIlllllIllIIllIIIIlII.length() > 1) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown or invalid command '").append(llllllllllllIlllllIllIIllIIIIlII).append("' (did you mean '").append(llllllllllllIlllllIllIIllIIIIlII.substring(1)).append("'? Do not use a preceding forwards slash.)")));
                    }
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown or invalid command '").append(llllllllllllIlllllIllIIllIIIIlII).append("'")));
                }
                else {
                    llllllllllllIlllllIllIIllIIIIlll.add(new CommandEntry(llllllllllllIlllllIllIIllIIIIllI));
                }
            }
        }
        return new FunctionObject(llllllllllllIlllllIllIIllIIIIlll.toArray(new Entry[llllllllllllIlllllIllIIllIIIIlll.size()]));
    }
    
    public Entry[] func_193528_a() {
        return this.field_193530_b;
    }
    
    public FunctionObject(final Entry[] llllllllllllIlllllIllIIllIIlIllI) {
        this.field_193530_b = llllllllllllIlllllIllIIllIIlIllI;
    }
    
    public static class CommandEntry implements Entry
    {
        private final /* synthetic */ String field_193525_a;
        
        @Override
        public void func_194145_a(final FunctionManager lllllllllllllIIllIIlIllIIIIlIIII, final ICommandSender lllllllllllllIIllIIlIllIIIIlIlII, final ArrayDeque<FunctionManager.QueuedCommand> lllllllllllllIIllIIlIllIIIIlIIll, final int lllllllllllllIIllIIlIllIIIIlIIlI) {
            lllllllllllllIIllIIlIllIIIIlIIII.func_193062_a().executeCommand(lllllllllllllIIllIIlIllIIIIlIlII, this.field_193525_a);
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("/").append(this.field_193525_a));
        }
        
        public CommandEntry(final String lllllllllllllIIllIIlIllIIIIlllII) {
            this.field_193525_a = lllllllllllllIIllIIlIllIIIIlllII;
        }
    }
    
    public interface Entry
    {
        void func_194145_a(final FunctionManager p0, final ICommandSender p1, final ArrayDeque<FunctionManager.QueuedCommand> p2, final int p3);
    }
    
    public static class CacheableFunction
    {
        private /* synthetic */ boolean field_193521_c;
        @Nullable
        private final /* synthetic */ ResourceLocation field_193520_b;
        private /* synthetic */ FunctionObject field_193522_d;
        
        public CacheableFunction() {
            this.field_193520_b = null;
        }
        
        public CacheableFunction(@Nullable final ResourceLocation lllllllllllllllIIlllIIIlllIIlIlI) {
            this.field_193520_b = lllllllllllllllIIlllIIIlllIIlIlI;
        }
        
        static {
            field_193519_a = new CacheableFunction((ResourceLocation)null);
        }
        
        @Nullable
        public FunctionObject func_193518_a(final FunctionManager lllllllllllllllIIlllIIIlllIIIIII) {
            if (!this.field_193521_c) {
                if (this.field_193520_b != null) {
                    this.field_193522_d = lllllllllllllllIIlllIIIlllIIIIII.func_193058_a(this.field_193520_b);
                }
                this.field_193521_c = true;
            }
            return this.field_193522_d;
        }
        
        @Override
        public String toString() {
            return String.valueOf(this.field_193520_b);
        }
    }
    
    public static class FunctionEntry implements Entry
    {
        private final /* synthetic */ CacheableFunction field_193524_a;
        
        @Override
        public void func_194145_a(final FunctionManager llllllllllllllIlIIllIIIIIllIlIll, final ICommandSender llllllllllllllIlIIllIIIIIlllIlII, final ArrayDeque<FunctionManager.QueuedCommand> llllllllllllllIlIIllIIIIIllIlIIl, final int llllllllllllllIlIIllIIIIIlllIIlI) {
            final FunctionObject llllllllllllllIlIIllIIIIIlllIIIl = this.field_193524_a.func_193518_a(llllllllllllllIlIIllIIIIIllIlIll);
            if (llllllllllllllIlIIllIIIIIlllIIIl != null) {
                final Entry[] llllllllllllllIlIIllIIIIIlllIIII = llllllllllllllIlIIllIIIIIlllIIIl.func_193528_a();
                final int llllllllllllllIlIIllIIIIIllIllll = llllllllllllllIlIIllIIIIIlllIIlI - llllllllllllllIlIIllIIIIIllIlIIl.size();
                final int llllllllllllllIlIIllIIIIIllIlllI = Math.min(llllllllllllllIlIIllIIIIIlllIIII.length, llllllllllllllIlIIllIIIIIllIllll);
                for (int llllllllllllllIlIIllIIIIIllIllIl = llllllllllllllIlIIllIIIIIllIlllI - 1; llllllllllllllIlIIllIIIIIllIllIl >= 0; --llllllllllllllIlIIllIIIIIllIllIl) {
                    llllllllllllllIlIIllIIIIIllIlIIl.addFirst(new FunctionManager.QueuedCommand(llllllllllllllIlIIllIIIIIllIlIll, llllllllllllllIlIIllIIIIIlllIlII, llllllllllllllIlIIllIIIIIlllIIII[llllllllllllllIlIIllIIIIIllIllIl]));
                }
            }
        }
        
        public FunctionEntry(final FunctionObject llllllllllllllIlIIllIIIIlIIIIIll) {
            this.field_193524_a = new CacheableFunction(llllllllllllllIlIIllIIIIlIIIIIll);
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("/function ").append(this.field_193524_a));
        }
    }
}
