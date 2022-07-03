package net.minecraft.advancements;

import net.minecraft.util.*;
import com.google.common.base.*;
import java.util.function.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;

public class AdvancementList
{
    private static final /* synthetic */ Logger field_192091_a;
    private final /* synthetic */ Set<Advancement> field_192093_c;
    private /* synthetic */ Listener field_192095_e;
    private final /* synthetic */ Set<Advancement> field_192094_d;
    private final /* synthetic */ Map<ResourceLocation, Advancement> field_192092_b;
    
    public void func_192085_a(final Set<ResourceLocation> llllllllllllllIIIIIllIllllllIIIl) {
        for (final ResourceLocation llllllllllllllIIIIIllIllllllIlII : llllllllllllllIIIIIllIllllllIIIl) {
            final Advancement llllllllllllllIIIIIllIllllllIIll = this.field_192092_b.get(llllllllllllllIIIIIllIllllllIlII);
            if (llllllllllllllIIIIIllIllllllIIll == null) {
                AdvancementList.field_192091_a.warn(String.valueOf(new StringBuilder("Told to remove advancement ").append(llllllllllllllIIIIIllIllllllIlII).append(" but I don't know what that is")));
            }
            else {
                this.func_192090_a(llllllllllllllIIIIIllIllllllIIll);
            }
        }
    }
    
    public void func_192083_a(final Map<ResourceLocation, Advancement.Builder> llllllllllllllIIIIIllIlllllIIIll) {
        final Function<ResourceLocation, Advancement> llllllllllllllIIIIIllIlllllIIIlI = (Function<ResourceLocation, Advancement>)Functions.forMap((Map)this.field_192092_b, (Object)null);
        while (!llllllllllllllIIIIIllIlllllIIIll.isEmpty()) {
            boolean llllllllllllllIIIIIllIlllllIIIIl = false;
            Iterator<Map.Entry<ResourceLocation, Advancement.Builder>> llllllllllllllIIIIIllIlllllIIIII = llllllllllllllIIIIIllIlllllIIIll.entrySet().iterator();
            while (llllllllllllllIIIIIllIlllllIIIII.hasNext()) {
                final Map.Entry<ResourceLocation, Advancement.Builder> llllllllllllllIIIIIllIllllIlllll = llllllllllllllIIIIIllIlllllIIIII.next();
                final ResourceLocation llllllllllllllIIIIIllIllllIllllI = llllllllllllllIIIIIllIllllIlllll.getKey();
                final Advancement.Builder llllllllllllllIIIIIllIllllIlllIl = llllllllllllllIIIIIllIllllIlllll.getValue();
                if (llllllllllllllIIIIIllIllllIlllIl.func_192058_a(llllllllllllllIIIIIllIlllllIIIlI)) {
                    final Advancement llllllllllllllIIIIIllIllllIlllII = llllllllllllllIIIIIllIllllIlllIl.func_192056_a(llllllllllllllIIIIIllIllllIllllI);
                    this.field_192092_b.put(llllllllllllllIIIIIllIllllIllllI, llllllllllllllIIIIIllIllllIlllII);
                    llllllllllllllIIIIIllIlllllIIIIl = true;
                    llllllllllllllIIIIIllIlllllIIIII.remove();
                    if (llllllllllllllIIIIIllIllllIlllII.func_192070_b() == null) {
                        this.field_192093_c.add(llllllllllllllIIIIIllIllllIlllII);
                        if (this.field_192095_e == null) {
                            continue;
                        }
                        this.field_192095_e.func_191931_a(llllllllllllllIIIIIllIllllIlllII);
                    }
                    else {
                        this.field_192094_d.add(llllllllllllllIIIIIllIllllIlllII);
                        if (this.field_192095_e == null) {
                            continue;
                        }
                        this.field_192095_e.func_191932_c(llllllllllllllIIIIIllIllllIlllII);
                    }
                }
            }
            if (!llllllllllllllIIIIIllIlllllIIIIl) {
                llllllllllllllIIIIIllIlllllIIIII = llllllllllllllIIIIIllIlllllIIIll.entrySet().iterator();
                while (llllllllllllllIIIIIllIlllllIIIII.hasNext()) {
                    final Map.Entry<ResourceLocation, Advancement.Builder> llllllllllllllIIIIIllIllllIllIll = llllllllllllllIIIIIllIlllllIIIII.next();
                    AdvancementList.field_192091_a.error(String.valueOf(new StringBuilder("Couldn't load advancement ").append(llllllllllllllIIIIIllIllllIllIll.getKey()).append(": ").append(llllllllllllllIIIIIllIllllIllIll.getValue())));
                }
                break;
            }
        }
        AdvancementList.field_192091_a.info(String.valueOf(new StringBuilder("Loaded ").append(this.field_192092_b.size()).append(" advancements")));
    }
    
    @Nullable
    public Advancement func_192084_a(final ResourceLocation llllllllllllllIIIIIllIllllIIIlIl) {
        return this.field_192092_b.get(llllllllllllllIIIIIllIllllIIIlIl);
    }
    
    public void func_192086_a(@Nullable final Listener llllllllllllllIIIIIllIlllIllllIl) {
        this.field_192095_e = llllllllllllllIIIIIllIlllIllllIl;
        if (llllllllllllllIIIIIllIlllIllllIl != null) {
            for (final Advancement llllllllllllllIIIIIllIlllIllllII : this.field_192093_c) {
                llllllllllllllIIIIIllIlllIllllIl.func_191931_a(llllllllllllllIIIIIllIlllIllllII);
            }
            for (final Advancement llllllllllllllIIIIIllIlllIlllIll : this.field_192094_d) {
                llllllllllllllIIIIIllIlllIllllIl.func_191932_c(llllllllllllllIIIIIllIlllIlllIll);
            }
        }
    }
    
    private void func_192090_a(final Advancement llllllllllllllIIIIIlllIIIIIIIIIl) {
        for (final Advancement llllllllllllllIIIIIlllIIIIIIIIII : llllllllllllllIIIIIlllIIIIIIIIIl.func_192069_e()) {
            this.func_192090_a(llllllllllllllIIIIIlllIIIIIIIIII);
        }
        AdvancementList.field_192091_a.info(String.valueOf(new StringBuilder("Forgot about advancement ").append(llllllllllllllIIIIIlllIIIIIIIIIl.func_192067_g())));
        this.field_192092_b.remove(llllllllllllllIIIIIlllIIIIIIIIIl.func_192067_g());
        if (llllllllllllllIIIIIlllIIIIIIIIIl.func_192070_b() == null) {
            this.field_192093_c.remove(llllllllllllllIIIIIlllIIIIIIIIIl);
            if (this.field_192095_e != null) {
                this.field_192095_e.func_191928_b(llllllllllllllIIIIIlllIIIIIIIIIl);
            }
        }
        else {
            this.field_192094_d.remove(llllllllllllllIIIIIlllIIIIIIIIIl);
            if (this.field_192095_e != null) {
                this.field_192095_e.func_191929_d(llllllllllllllIIIIIlllIIIIIIIIIl);
            }
        }
    }
    
    public void func_192087_a() {
        this.field_192092_b.clear();
        this.field_192093_c.clear();
        this.field_192094_d.clear();
        if (this.field_192095_e != null) {
            this.field_192095_e.func_191930_a();
        }
    }
    
    public AdvancementList() {
        this.field_192092_b = (Map<ResourceLocation, Advancement>)Maps.newHashMap();
        this.field_192093_c = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192094_d = (Set<Advancement>)Sets.newLinkedHashSet();
    }
    
    static {
        field_192091_a = LogManager.getLogger();
    }
    
    public Iterable<Advancement> func_192088_b() {
        return this.field_192093_c;
    }
    
    public Iterable<Advancement> func_192089_c() {
        return this.field_192092_b.values();
    }
    
    public interface Listener
    {
        void func_191929_d(final Advancement p0);
        
        void func_191930_a();
        
        void func_191932_c(final Advancement p0);
        
        void func_191931_a(final Advancement p0);
        
        void func_191928_b(final Advancement p0);
    }
}
