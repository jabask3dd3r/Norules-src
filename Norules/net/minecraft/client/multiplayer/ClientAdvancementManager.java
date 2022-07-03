package net.minecraft.client.multiplayer;

import javax.annotation.*;
import java.util.*;
import net.minecraft.client.*;
import net.minecraft.advancements.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.toasts.*;

public class ClientAdvancementManager
{
    private static final /* synthetic */ Logger field_192800_a;
    @Nullable
    private /* synthetic */ IListener field_192804_e;
    private final /* synthetic */ Map<Advancement, AdvancementProgress> field_192803_d;
    private final /* synthetic */ Minecraft field_192801_b;
    @Nullable
    private /* synthetic */ Advancement field_194231_f;
    private final /* synthetic */ AdvancementList field_192802_c;
    
    static {
        field_192800_a = LogManager.getLogger();
    }
    
    public void func_192798_a(@Nullable final IListener lllllllllllllIIIllIlIlIIIlIIllII) {
        this.field_192804_e = lllllllllllllIIIllIlIlIIIlIIllII;
        this.field_192802_c.func_192086_a(lllllllllllllIIIllIlIlIIIlIIllII);
        if (lllllllllllllIIIllIlIlIIIlIIllII != null) {
            for (final Map.Entry<Advancement, AdvancementProgress> lllllllllllllIIIllIlIlIIIlIIlllI : this.field_192803_d.entrySet()) {
                lllllllllllllIIIllIlIlIIIlIIllII.func_191933_a(lllllllllllllIIIllIlIlIIIlIIlllI.getKey(), lllllllllllllIIIllIlIlIIIlIIlllI.getValue());
            }
            lllllllllllllIIIllIlIlIIIlIIllII.func_193982_e(this.field_194231_f);
        }
    }
    
    public ClientAdvancementManager(final Minecraft lllllllllllllIIIllIlIlIIIlllIlIl) {
        this.field_192802_c = new AdvancementList();
        this.field_192803_d = (Map<Advancement, AdvancementProgress>)Maps.newHashMap();
        this.field_192801_b = lllllllllllllIIIllIlIlIIIlllIlIl;
    }
    
    public void func_194230_a(@Nullable final Advancement lllllllllllllIIIllIlIlIIIlIlIlll, final boolean lllllllllllllIIIllIlIlIIIlIllIlI) {
        final NetHandlerPlayClient lllllllllllllIIIllIlIlIIIlIllIIl = this.field_192801_b.getConnection();
        if (lllllllllllllIIIllIlIlIIIlIllIIl != null && lllllllllllllIIIllIlIlIIIlIlIlll != null && lllllllllllllIIIllIlIlIIIlIllIlI) {
            lllllllllllllIIIllIlIlIIIlIllIIl.sendPacket(CPacketSeenAdvancements.func_194163_a(lllllllllllllIIIllIlIlIIIlIlIlll));
        }
        if (this.field_194231_f != lllllllllllllIIIllIlIlIIIlIlIlll) {
            this.field_194231_f = lllllllllllllIIIllIlIlIIIlIlIlll;
            if (this.field_192804_e != null) {
                this.field_192804_e.func_193982_e(lllllllllllllIIIllIlIlIIIlIlIlll);
            }
        }
    }
    
    public void func_192799_a(final SPacketAdvancementInfo lllllllllllllIIIllIlIlIIIllIlIII) {
        if (lllllllllllllIIIllIlIlIIIllIlIII.func_192602_d()) {
            this.field_192802_c.func_192087_a();
            this.field_192803_d.clear();
        }
        this.field_192802_c.func_192085_a(lllllllllllllIIIllIlIlIIIllIlIII.func_192600_b());
        this.field_192802_c.func_192083_a(lllllllllllllIIIllIlIlIIIllIlIII.func_192603_a());
        for (final Map.Entry<ResourceLocation, AdvancementProgress> lllllllllllllIIIllIlIlIIIllIllII : lllllllllllllIIIllIlIlIIIllIlIII.func_192604_c().entrySet()) {
            final Advancement lllllllllllllIIIllIlIlIIIllIlIll = this.field_192802_c.func_192084_a(lllllllllllllIIIllIlIlIIIllIllII.getKey());
            if (lllllllllllllIIIllIlIlIIIllIlIll != null) {
                final AdvancementProgress lllllllllllllIIIllIlIlIIIllIlIlI = lllllllllllllIIIllIlIlIIIllIllII.getValue();
                lllllllllllllIIIllIlIlIIIllIlIlI.func_192099_a(lllllllllllllIIIllIlIlIIIllIlIll.func_192073_f(), lllllllllllllIIIllIlIlIIIllIlIll.func_192074_h());
                this.field_192803_d.put(lllllllllllllIIIllIlIlIIIllIlIll, lllllllllllllIIIllIlIlIIIllIlIlI);
                if (this.field_192804_e != null) {
                    this.field_192804_e.func_191933_a(lllllllllllllIIIllIlIlIIIllIlIll, lllllllllllllIIIllIlIlIIIllIlIlI);
                }
                if (lllllllllllllIIIllIlIlIIIllIlIII.func_192602_d() || !lllllllllllllIIIllIlIlIIIllIlIlI.func_192105_a() || lllllllllllllIIIllIlIlIIIllIlIll.func_192068_c() == null || !lllllllllllllIIIllIlIlIIIllIlIll.func_192068_c().func_193223_h()) {
                    continue;
                }
                this.field_192801_b.func_193033_an().func_192988_a(new AdvancementToast(lllllllllllllIIIllIlIlIIIllIlIll));
            }
            else {
                ClientAdvancementManager.field_192800_a.warn(String.valueOf(new StringBuilder("Server informed client about progress for unknown advancement ").append(lllllllllllllIIIllIlIlIIIllIllII.getKey())));
            }
        }
    }
    
    public AdvancementList func_194229_a() {
        return this.field_192802_c;
    }
    
    public interface IListener extends AdvancementList.Listener
    {
        void func_193982_e(final Advancement p0);
        
        void func_191933_a(final Advancement p0, final AdvancementProgress p1);
    }
}
