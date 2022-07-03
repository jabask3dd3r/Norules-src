package net.minecraft.advancements;

import com.google.gson.reflect.*;
import net.minecraft.entity.player.*;
import net.minecraft.server.*;
import javax.annotation.*;
import org.apache.logging.log4j.*;
import java.lang.reflect.*;
import com.google.common.collect.*;
import net.minecraft.network.*;
import net.minecraft.util.text.*;
import net.minecraft.network.play.server.*;
import java.nio.charset.*;
import com.google.common.io.*;
import net.minecraft.util.*;
import com.google.gson.*;
import java.util.*;
import java.util.function.*;
import java.io.*;
import java.util.stream.*;

public class PlayerAdvancements
{
    private final /* synthetic */ Set<Advancement> field_192760_h;
    private static final /* synthetic */ Gson field_192754_b;
    private final /* synthetic */ Map<Advancement, AdvancementProgress> field_192758_f;
    private static final /* synthetic */ TypeToken<Map<ResourceLocation, AdvancementProgress>> field_192755_c;
    private /* synthetic */ boolean field_192763_k;
    private final /* synthetic */ Set<Advancement> field_192759_g;
    private final /* synthetic */ Set<Advancement> field_192761_i;
    private final /* synthetic */ File field_192757_e;
    private /* synthetic */ EntityPlayerMP field_192762_j;
    private final /* synthetic */ MinecraftServer field_192756_d;
    private static final /* synthetic */ Logger field_192753_a;
    @Nullable
    private /* synthetic */ Advancement field_194221_k;
    
    static {
        field_192753_a = LogManager.getLogger();
        field_192754_b = new GsonBuilder().registerTypeAdapter((Type)AdvancementProgress.class, (Object)new AdvancementProgress.Serializer()).registerTypeAdapter((Type)ResourceLocation.class, (Object)new ResourceLocation.Serializer()).setPrettyPrinting().create();
        field_192755_c = new TypeToken<Map<ResourceLocation, AdvancementProgress>>() {};
    }
    
    public void func_193766_b() {
        this.func_192745_a();
        this.field_192758_f.clear();
        this.field_192759_g.clear();
        this.field_192760_h.clear();
        this.field_192761_i.clear();
        this.field_192763_k = true;
        this.field_194221_k = null;
        this.func_192740_f();
    }
    
    public PlayerAdvancements(final MinecraftServer lllllllllllllIllIlIlllIlIIlIllIl, final File lllllllllllllIllIlIlllIlIIllIIII, final EntityPlayerMP lllllllllllllIllIlIlllIlIIlIlIll) {
        this.field_192758_f = (Map<Advancement, AdvancementProgress>)Maps.newLinkedHashMap();
        this.field_192759_g = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192760_h = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192761_i = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192763_k = true;
        this.field_192756_d = lllllllllllllIllIlIlllIlIIlIllIl;
        this.field_192757_e = lllllllllllllIllIlIlllIlIIllIIII;
        this.field_192762_j = lllllllllllllIllIlIlllIlIIlIlIll;
        this.func_192740_f();
    }
    
    private void func_192752_d() {
        final List<Advancement> lllllllllllllIllIlIlllIlIIIIllII = (List<Advancement>)Lists.newArrayList();
        for (final Map.Entry<Advancement, AdvancementProgress> lllllllllllllIllIlIlllIlIIIIlIll : this.field_192758_f.entrySet()) {
            if (lllllllllllllIllIlIlllIlIIIIlIll.getValue().func_192105_a()) {
                lllllllllllllIllIlIlllIlIIIIllII.add(lllllllllllllIllIlIlllIlIIIIlIll.getKey());
                this.field_192761_i.add(lllllllllllllIllIlIlllIlIIIIlIll.getKey());
            }
        }
        for (final Advancement lllllllllllllIllIlIlllIlIIIIlIlI : lllllllllllllIllIlIlllIlIIIIllII) {
            this.func_192742_b(lllllllllllllIllIlIlllIlIIIIlIlI);
        }
    }
    
    public boolean func_192744_b(final Advancement lllllllllllllIllIlIlllIIllIIIIII, final String lllllllllllllIllIlIlllIIlIllllll) {
        boolean lllllllllllllIllIlIlllIIlIlllllI = false;
        final AdvancementProgress lllllllllllllIllIlIlllIIlIllllIl = this.func_192747_a(lllllllllllllIllIlIlllIIllIIIIII);
        if (lllllllllllllIllIlIlllIIlIllllIl.func_192101_b(lllllllllllllIllIlIlllIIlIllllll)) {
            this.func_193764_b(lllllllllllllIllIlIlllIIllIIIIII);
            this.field_192761_i.add(lllllllllllllIllIlIlllIIllIIIIII);
            lllllllllllllIllIlIlllIIlIlllllI = true;
        }
        if (!lllllllllllllIllIlIlllIIlIllllIl.func_192108_b()) {
            this.func_192742_b(lllllllllllllIllIlIlllIIllIIIIII);
        }
        return lllllllllllllIllIlIlllIIlIlllllI;
    }
    
    public void func_192741_b(final EntityPlayerMP lllllllllllllIllIlIlllIIlIIIIIIl) {
        if (!this.field_192760_h.isEmpty() || !this.field_192761_i.isEmpty()) {
            final Map<ResourceLocation, AdvancementProgress> lllllllllllllIllIlIlllIIIlllllll = (Map<ResourceLocation, AdvancementProgress>)Maps.newHashMap();
            final Set<Advancement> lllllllllllllIllIlIlllIIIllllllI = (Set<Advancement>)Sets.newLinkedHashSet();
            final Set<ResourceLocation> lllllllllllllIllIlIlllIIIlllllII = (Set<ResourceLocation>)Sets.newLinkedHashSet();
            for (final Advancement lllllllllllllIllIlIlllIIIllllIlI : this.field_192761_i) {
                if (this.field_192759_g.contains(lllllllllllllIllIlIlllIIIllllIlI)) {
                    lllllllllllllIllIlIlllIIIlllllll.put(lllllllllllllIllIlIlllIIIllllIlI.func_192067_g(), this.field_192758_f.get(lllllllllllllIllIlIlllIIIllllIlI));
                }
            }
            for (final Advancement lllllllllllllIllIlIlllIIIllllIII : this.field_192760_h) {
                if (this.field_192759_g.contains(lllllllllllllIllIlIlllIIIllllIII)) {
                    lllllllllllllIllIlIlllIIIllllllI.add(lllllllllllllIllIlIlllIIIllllIII);
                }
                else {
                    lllllllllllllIllIlIlllIIIlllllII.add(lllllllllllllIllIlIlllIIIllllIII.func_192067_g());
                }
            }
            if (!lllllllllllllIllIlIlllIIIlllllll.isEmpty() || !lllllllllllllIllIlIlllIIIllllllI.isEmpty() || !lllllllllllllIllIlIlllIIIlllllII.isEmpty()) {
                lllllllllllllIllIlIlllIIlIIIIIIl.connection.sendPacket(new SPacketAdvancementInfo(this.field_192763_k, lllllllllllllIllIlIlllIIIllllllI, lllllllllllllIllIlIlllIIIlllllII, lllllllllllllIllIlIlllIIIlllllll));
                this.field_192760_h.clear();
                this.field_192761_i.clear();
            }
        }
        this.field_192763_k = false;
    }
    
    public boolean func_192750_a(final Advancement lllllllllllllIllIlIlllIIllIlIIIl, final String lllllllllllllIllIlIlllIIllIlIIII) {
        boolean lllllllllllllIllIlIlllIIllIIllll = false;
        final AdvancementProgress lllllllllllllIllIlIlllIIllIIlllI = this.func_192747_a(lllllllllllllIllIlIlllIIllIlIIIl);
        final boolean lllllllllllllIllIlIlllIIllIIllIl = lllllllllllllIllIlIlllIIllIIlllI.func_192105_a();
        if (lllllllllllllIllIlIlllIIllIIlllI.func_192109_a(lllllllllllllIllIlIlllIIllIlIIII)) {
            this.func_193765_c(lllllllllllllIllIlIlllIIllIlIIIl);
            this.field_192761_i.add(lllllllllllllIllIlIlllIIllIlIIIl);
            lllllllllllllIllIlIlllIIllIIllll = true;
            if (!lllllllllllllIllIlIlllIIllIIllIl && lllllllllllllIllIlIlllIIllIIlllI.func_192105_a()) {
                lllllllllllllIllIlIlllIIllIlIIIl.func_192072_d().func_192113_a(this.field_192762_j);
                if (lllllllllllllIllIlIlllIIllIlIIIl.func_192068_c() != null && lllllllllllllIllIlIlllIIllIlIIIl.func_192068_c().func_193220_i() && this.field_192762_j.world.getGameRules().getBoolean("announceAdvancements")) {
                    this.field_192756_d.getPlayerList().sendChatMsg(new TextComponentTranslation(String.valueOf(new StringBuilder("chat.type.advancement.").append(lllllllllllllIllIlIlllIIllIlIIIl.func_192068_c().func_192291_d().func_192307_a())), new Object[] { this.field_192762_j.getDisplayName(), lllllllllllllIllIlIlllIIllIlIIIl.func_193123_j() }));
                }
            }
        }
        if (lllllllllllllIllIlIlllIIllIIlllI.func_192105_a()) {
            this.func_192742_b(lllllllllllllIllIlIlllIIllIlIIIl);
        }
        return lllllllllllllIllIlIlllIIllIIllll;
    }
    
    private void func_193765_c(final Advancement lllllllllllllIllIlIlllIIlIIlIIII) {
        final AdvancementProgress lllllllllllllIllIlIlllIIlIIlIllI = this.func_192747_a(lllllllllllllIllIlIlllIIlIIlIIII);
        for (final Map.Entry<String, Criterion> lllllllllllllIllIlIlllIIlIIlIlIl : lllllllllllllIllIlIlllIIlIIlIIII.func_192073_f().entrySet()) {
            final CriterionProgress lllllllllllllIllIlIlllIIlIIlIlII = lllllllllllllIllIlIlllIIlIIlIllI.func_192106_c(lllllllllllllIllIlIlllIIlIIlIlIl.getKey());
            if (lllllllllllllIllIlIlllIIlIIlIlII != null && (lllllllllllllIllIlIlllIIlIIlIlII.func_192151_a() || lllllllllllllIllIlIlllIIlIIlIllI.func_192105_a())) {
                final ICriterionInstance lllllllllllllIllIlIlllIIlIIlIIll = lllllllllllllIllIlIlllIIlIIlIlIl.getValue().func_192143_a();
                if (lllllllllllllIllIlIlllIIlIIlIIll == null) {
                    continue;
                }
                final ICriterionTrigger<ICriterionInstance> lllllllllllllIllIlIlllIIlIIlIIlI = CriteriaTriggers.func_192119_a(lllllllllllllIllIlIlllIIlIIlIIll.func_192244_a());
                if (lllllllllllllIllIlIlllIIlIIlIIlI == null) {
                    continue;
                }
                lllllllllllllIllIlIlllIIlIIlIIlI.func_192164_b(this, new ICriterionTrigger.Listener<ICriterionInstance>(lllllllllllllIllIlIlllIIlIIlIIll, lllllllllllllIllIlIlllIIlIIlIIII, lllllllllllllIllIlIlllIIlIIlIlIl.getKey()));
            }
        }
    }
    
    private boolean func_192746_d(final Advancement lllllllllllllIllIlIllIlllllIlllI) {
        final AdvancementProgress lllllllllllllIllIlIllIllllllIIlI = this.func_192747_a(lllllllllllllIllIlIllIlllllIlllI);
        if (lllllllllllllIllIlIllIllllllIIlI.func_192105_a()) {
            return true;
        }
        for (final Advancement lllllllllllllIllIlIllIllllllIIIl : lllllllllllllIllIlIllIlllllIlllI.func_192069_e()) {
            if (this.func_192746_d(lllllllllllllIllIlIllIllllllIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    private void func_192742_b(final Advancement lllllllllllllIllIlIlllIIIIllIlIl) {
        final boolean lllllllllllllIllIlIlllIIIIllIlII = this.func_192738_c(lllllllllllllIllIlIlllIIIIllIlIl);
        final boolean lllllllllllllIllIlIlllIIIIllIIll = this.field_192759_g.contains(lllllllllllllIllIlIlllIIIIllIlIl);
        if (lllllllllllllIllIlIlllIIIIllIlII && !lllllllllllllIllIlIlllIIIIllIIll) {
            this.field_192759_g.add(lllllllllllllIllIlIlllIIIIllIlIl);
            this.field_192760_h.add(lllllllllllllIllIlIlllIIIIllIlIl);
            if (this.field_192758_f.containsKey(lllllllllllllIllIlIlllIIIIllIlIl)) {
                this.field_192761_i.add(lllllllllllllIllIlIlllIIIIllIlIl);
            }
        }
        else if (!lllllllllllllIllIlIlllIIIIllIlII && lllllllllllllIllIlIlllIIIIllIIll) {
            this.field_192759_g.remove(lllllllllllllIllIlIlllIIIIllIlIl);
            this.field_192760_h.add(lllllllllllllIllIlIlllIIIIllIlIl);
        }
        if (lllllllllllllIllIlIlllIIIIllIlII != lllllllllllllIllIlIlllIIIIllIIll && lllllllllllllIllIlIlllIIIIllIlIl.func_192070_b() != null) {
            this.func_192742_b(lllllllllllllIllIlIlllIIIIllIlIl.func_192070_b());
        }
        for (final Advancement lllllllllllllIllIlIlllIIIIllIIlI : lllllllllllllIllIlIlllIIIIllIlIl.func_192069_e()) {
            this.func_192742_b(lllllllllllllIllIlIlllIIIIllIIlI);
        }
    }
    
    private void func_192743_a(final Advancement lllllllllllllIllIlIlllIIIlIlIIIl, final AdvancementProgress lllllllllllllIllIlIlllIIIlIIllIl) {
        lllllllllllllIllIlIlllIIIlIIllIl.func_192099_a(lllllllllllllIllIlIlllIIIlIlIIIl.func_192073_f(), lllllllllllllIllIlIlllIIIlIlIIIl.func_192074_h());
        this.field_192758_f.put(lllllllllllllIllIlIlllIIIlIlIIIl, lllllllllllllIllIlIlllIIIlIIllIl);
    }
    
    public void func_194220_a(@Nullable final Advancement lllllllllllllIllIlIlllIIIllIIllI) {
        final Advancement lllllllllllllIllIlIlllIIIllIlIII = this.field_194221_k;
        if (lllllllllllllIllIlIlllIIIllIIllI != null && lllllllllllllIllIlIlllIIIllIIllI.func_192070_b() == null && lllllllllllllIllIlIlllIIIllIIllI.func_192068_c() != null) {
            this.field_194221_k = lllllllllllllIllIlIlllIIIllIIllI;
        }
        else {
            this.field_194221_k = null;
        }
        if (lllllllllllllIllIlIlllIIIllIlIII != this.field_194221_k) {
            this.field_192762_j.connection.sendPacket(new SPacketSelectAdvancementsTab((this.field_194221_k == null) ? null : this.field_194221_k.func_192067_g()));
        }
    }
    
    public void func_192739_a(final EntityPlayerMP lllllllllllllIllIlIlllIlIIlIIlIl) {
        this.field_192762_j = lllllllllllllIllIlIlllIlIIlIIlIl;
    }
    
    private void func_192748_e() {
        for (final Advancement lllllllllllllIllIlIlllIlIIIIIIIl : this.field_192756_d.func_191949_aK().func_192780_b()) {
            if (lllllllllllllIllIlIlllIlIIIIIIIl.func_192073_f().isEmpty()) {
                this.func_192750_a(lllllllllllllIllIlIlllIlIIIIIIIl, "");
                lllllllllllllIllIlIlllIlIIIIIIIl.func_192072_d().func_192113_a(this.field_192762_j);
            }
        }
    }
    
    private void func_192740_f() {
        if (this.field_192757_e.isFile()) {
            try {
                final String lllllllllllllIllIlIlllIIllllIlIl = Files.toString(this.field_192757_e, StandardCharsets.UTF_8);
                final Map<ResourceLocation, AdvancementProgress> lllllllllllllIllIlIlllIIllllIlII = JsonUtils.func_193840_a(PlayerAdvancements.field_192754_b, lllllllllllllIllIlIlllIIllllIlIl, PlayerAdvancements.field_192755_c.getType());
                if (lllllllllllllIllIlIlllIIllllIlII == null) {
                    throw new JsonParseException("Found null for advancements");
                }
                final Stream<Map.Entry<ResourceLocation, AdvancementProgress>> lllllllllllllIllIlIlllIIllllIIll = lllllllllllllIllIlIlllIIllllIlII.entrySet().stream().sorted(Comparator.comparing((Function<? super Map.Entry<ResourceLocation, AdvancementProgress>, ? extends Comparable>)Map.Entry::getValue));
                for (final Map.Entry<ResourceLocation, AdvancementProgress> lllllllllllllIllIlIlllIIllllIIlI : lllllllllllllIllIlIlllIIllllIIll.collect((Collector<? super Map.Entry<ResourceLocation, AdvancementProgress>, ?, List<? super Map.Entry<ResourceLocation, AdvancementProgress>>>)Collectors.toList())) {
                    final Advancement lllllllllllllIllIlIlllIIllllIIIl = this.field_192756_d.func_191949_aK().func_192778_a(lllllllllllllIllIlIlllIIllllIIlI.getKey());
                    if (lllllllllllllIllIlIlllIIllllIIIl == null) {
                        PlayerAdvancements.field_192753_a.warn(String.valueOf(new StringBuilder("Ignored advancement '").append(lllllllllllllIllIlIlllIIllllIIlI.getKey()).append("' in progress file ").append(this.field_192757_e).append(" - it doesn't exist anymore?")));
                    }
                    else {
                        this.func_192743_a(lllllllllllllIllIlIlllIIllllIIIl, lllllllllllllIllIlIlllIIllllIIlI.getValue());
                    }
                }
            }
            catch (JsonParseException lllllllllllllIllIlIlllIIllllIIII) {
                PlayerAdvancements.field_192753_a.error(String.valueOf(new StringBuilder("Couldn't parse player advancements in ").append(this.field_192757_e)), (Throwable)lllllllllllllIllIlIlllIIllllIIII);
            }
            catch (IOException lllllllllllllIllIlIlllIIlllIllll) {
                PlayerAdvancements.field_192753_a.error(String.valueOf(new StringBuilder("Couldn't access player advancements in ").append(this.field_192757_e)), (Throwable)lllllllllllllIllIlIlllIIlllIllll);
            }
        }
        this.func_192748_e();
        this.func_192752_d();
        this.func_192751_c();
    }
    
    private void func_192751_c() {
        for (final Advancement lllllllllllllIllIlIlllIlIIIlIlIl : this.field_192756_d.func_191949_aK().func_192780_b()) {
            this.func_193764_b(lllllllllllllIllIlIlllIlIIIlIlIl);
        }
    }
    
    private void func_193764_b(final Advancement lllllllllllllIllIlIlllIIlIlIIlll) {
        final AdvancementProgress lllllllllllllIllIlIlllIIlIlIllIl = this.func_192747_a(lllllllllllllIllIlIlllIIlIlIIlll);
        if (!lllllllllllllIllIlIlllIIlIlIllIl.func_192105_a()) {
            for (final Map.Entry<String, Criterion> lllllllllllllIllIlIlllIIlIlIllII : lllllllllllllIllIlIlllIIlIlIIlll.func_192073_f().entrySet()) {
                final CriterionProgress lllllllllllllIllIlIlllIIlIlIlIll = lllllllllllllIllIlIlllIIlIlIllIl.func_192106_c(lllllllllllllIllIlIlllIIlIlIllII.getKey());
                if (lllllllllllllIllIlIlllIIlIlIlIll != null && !lllllllllllllIllIlIlllIIlIlIlIll.func_192151_a()) {
                    final ICriterionInstance lllllllllllllIllIlIlllIIlIlIlIlI = lllllllllllllIllIlIlllIIlIlIllII.getValue().func_192143_a();
                    if (lllllllllllllIllIlIlllIIlIlIlIlI == null) {
                        continue;
                    }
                    final ICriterionTrigger<ICriterionInstance> lllllllllllllIllIlIlllIIlIlIlIIl = CriteriaTriggers.func_192119_a(lllllllllllllIllIlIlllIIlIlIlIlI.func_192244_a());
                    if (lllllllllllllIllIlIlllIIlIlIlIIl == null) {
                        continue;
                    }
                    lllllllllllllIllIlIlllIIlIlIlIIl.func_192165_a(this, new ICriterionTrigger.Listener<ICriterionInstance>(lllllllllllllIllIlIlllIIlIlIlIlI, lllllllllllllIllIlIlllIIlIlIIlll, lllllllllllllIllIlIlllIIlIlIllII.getKey()));
                }
            }
        }
    }
    
    public AdvancementProgress func_192747_a(final Advancement lllllllllllllIllIlIlllIIIlIlllll) {
        AdvancementProgress lllllllllllllIllIlIlllIIIlIlllIl = this.field_192758_f.get(lllllllllllllIllIlIlllIIIlIlllll);
        if (lllllllllllllIllIlIlllIIIlIlllIl == null) {
            lllllllllllllIllIlIlllIIIlIlllIl = new AdvancementProgress();
            this.func_192743_a(lllllllllllllIllIlIlllIIIlIlllll, lllllllllllllIllIlIlllIIIlIlllIl);
        }
        return lllllllllllllIllIlIlllIIIlIlllIl;
    }
    
    public void func_192745_a() {
        for (final ICriterionTrigger<?> lllllllllllllIllIlIlllIlIIlIIIII : CriteriaTriggers.func_192120_a()) {
            lllllllllllllIllIlIlllIlIIlIIIII.func_192167_a(this);
        }
    }
    
    public void func_192749_b() {
        final Map<ResourceLocation, AdvancementProgress> lllllllllllllIllIlIlllIIlllIIIIl = (Map<ResourceLocation, AdvancementProgress>)Maps.newHashMap();
        for (final Map.Entry<Advancement, AdvancementProgress> lllllllllllllIllIlIlllIIlllIIIII : this.field_192758_f.entrySet()) {
            final AdvancementProgress lllllllllllllIllIlIlllIIllIlllll = lllllllllllllIllIlIlllIIlllIIIII.getValue();
            if (lllllllllllllIllIlIlllIIllIlllll.func_192108_b()) {
                lllllllllllllIllIlIlllIIlllIIIIl.put(lllllllllllllIllIlIlllIIlllIIIII.getKey().func_192067_g(), lllllllllllllIllIlIlllIIllIlllll);
            }
        }
        if (this.field_192757_e.getParentFile() != null) {
            this.field_192757_e.getParentFile().mkdirs();
        }
        try {
            Files.write((CharSequence)PlayerAdvancements.field_192754_b.toJson((Object)lllllllllllllIllIlIlllIIlllIIIIl), this.field_192757_e, StandardCharsets.UTF_8);
        }
        catch (IOException lllllllllllllIllIlIlllIIllIllllI) {
            PlayerAdvancements.field_192753_a.error(String.valueOf(new StringBuilder("Couldn't save player advancements to ").append(this.field_192757_e)), (Throwable)lllllllllllllIllIlIlllIIllIllllI);
        }
    }
    
    private boolean func_192738_c(Advancement lllllllllllllIllIlIlllIIIIIIlIll) {
        for (int lllllllllllllIllIlIlllIIIIIIllll = 0; lllllllllllllIllIlIlllIIIIIIlIll != null && lllllllllllllIllIlIlllIIIIIIllll <= 2; lllllllllllllIllIlIlllIIIIIIlIll = ((Advancement)lllllllllllllIllIlIlllIIIIIIlIll).func_192070_b(), ++lllllllllllllIllIlIlllIIIIIIllll) {
            if (lllllllllllllIllIlIlllIIIIIIllll == 0 && this.func_192746_d((Advancement)lllllllllllllIllIlIlllIIIIIIlIll)) {
                return true;
            }
            if (((Advancement)lllllllllllllIllIlIlllIIIIIIlIll).func_192068_c() == null) {
                return false;
            }
            final AdvancementProgress lllllllllllllIllIlIlllIIIIIIllIl = this.func_192747_a((Advancement)lllllllllllllIllIlIlllIIIIIIlIll);
            if (lllllllllllllIllIlIlllIIIIIIllIl.func_192105_a()) {
                return true;
            }
            if (((Advancement)lllllllllllllIllIlIlllIIIIIIlIll).func_192068_c().func_193224_j()) {
                return false;
            }
        }
        return false;
    }
}
