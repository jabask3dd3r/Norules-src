package net.minecraft.advancements;

import net.minecraft.network.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;
import java.lang.reflect.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class AdvancementProgress implements Comparable<AdvancementProgress>
{
    private /* synthetic */ String[][] field_192111_b;
    private final /* synthetic */ Map<String, CriterionProgress> field_192110_a;
    
    public Iterable<String> func_192107_d() {
        final List<String> lllllllllllllllIlllIIlIIllllIllI = (List<String>)Lists.newArrayList();
        for (final Map.Entry<String, CriterionProgress> lllllllllllllllIlllIIlIIllllIlIl : this.field_192110_a.entrySet()) {
            if (!lllllllllllllllIlllIIlIIllllIlIl.getValue().func_192151_a()) {
                lllllllllllllllIlllIIlIIllllIllI.add(lllllllllllllllIlllIIlIIllllIlIl.getKey());
            }
        }
        return lllllllllllllllIlllIIlIIllllIllI;
    }
    
    public Iterable<String> func_192102_e() {
        final List<String> lllllllllllllllIlllIIlIIllIllllI = (List<String>)Lists.newArrayList();
        for (final Map.Entry<String, CriterionProgress> lllllllllllllllIlllIIlIIllIlllIl : this.field_192110_a.entrySet()) {
            if (lllllllllllllllIlllIIlIIllIlllIl.getValue().func_192151_a()) {
                lllllllllllllllIlllIIlIIllIllllI.add(lllllllllllllllIlllIIlIIllIlllIl.getKey());
            }
        }
        return lllllllllllllllIlllIIlIIllIllllI;
    }
    
    public static AdvancementProgress func_192100_b(final PacketBuffer lllllllllllllllIlllIIlIlIllIlIll) {
        final AdvancementProgress lllllllllllllllIlllIIlIlIlllIIIl = new AdvancementProgress();
        for (int lllllllllllllllIlllIIlIlIllIllll = lllllllllllllllIlllIIlIlIllIlIll.readVarIntFromBuffer(), lllllllllllllllIlllIIlIlIllIllIl = 0; lllllllllllllllIlllIIlIlIllIllIl < lllllllllllllllIlllIIlIlIllIllll; ++lllllllllllllllIlllIIlIlIllIllIl) {
            lllllllllllllllIlllIIlIlIlllIIIl.field_192110_a.put(lllllllllllllllIlllIIlIlIllIlIll.readStringFromBuffer(32767), CriterionProgress.func_192149_a(lllllllllllllllIlllIIlIlIllIlIll, lllllllllllllllIlllIIlIlIlllIIIl));
        }
        return lllllllllllllllIlllIIlIlIlllIIIl;
    }
    
    @Nullable
    public CriterionProgress func_192106_c(final String lllllllllllllllIlllIIlIlIlIlllll) {
        return this.field_192110_a.get(lllllllllllllllIlllIIlIlIlIlllll);
    }
    
    @Nullable
    public String func_193126_d() {
        if (this.field_192110_a.isEmpty()) {
            return null;
        }
        final int lllllllllllllllIlllIIlIlIIlllIIl = this.field_192111_b.length;
        if (lllllllllllllllIlllIIlIlIIlllIIl <= 1) {
            return null;
        }
        final int lllllllllllllllIlllIIlIlIIllIlll = this.func_194032_h();
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlllIIlIlIIllIlll)).append("/").append(lllllllllllllllIlllIIlIlIIlllIIl));
    }
    
    public AdvancementProgress() {
        this.field_192110_a = (Map<String, CriterionProgress>)Maps.newHashMap();
        this.field_192111_b = new String[0][];
    }
    
    public boolean func_192101_b(final String lllllllllllllllIlllIIlIllIIlllll) {
        final CriterionProgress lllllllllllllllIlllIIlIllIlIIIIl = this.field_192110_a.get(lllllllllllllllIlllIIlIllIIlllll);
        if (lllllllllllllllIlllIIlIllIlIIIIl != null && lllllllllllllllIlllIIlIllIlIIIIl.func_192151_a()) {
            lllllllllllllllIlllIIlIllIlIIIIl.func_192154_c();
            return true;
        }
        return false;
    }
    
    @Nullable
    public Date func_193128_g() {
        Date lllllllllllllllIlllIIlIIlIllllII = null;
        for (final CriterionProgress lllllllllllllllIlllIIlIIlIlllIlI : this.field_192110_a.values()) {
            if (lllllllllllllllIlllIIlIIlIlllIlI.func_192151_a() && (lllllllllllllllIlllIIlIIlIllllII == null || lllllllllllllllIlllIIlIIlIlllIlI.func_193140_d().before(lllllllllllllllIlllIIlIIlIllllII))) {
                lllllllllllllllIlllIIlIIlIllllII = lllllllllllllllIlllIIlIIlIlllIlI.func_193140_d();
            }
        }
        return lllllllllllllllIlllIIlIIlIllllII;
    }
    
    @Override
    public int compareTo(final AdvancementProgress lllllllllllllllIlllIIlIIlIIlllII) {
        final Date lllllllllllllllIlllIIlIIlIlIIIlI = this.func_193128_g();
        final Date lllllllllllllllIlllIIlIIlIlIIIII = lllllllllllllllIlllIIlIIlIIlllII.func_193128_g();
        if (lllllllllllllllIlllIIlIIlIlIIIlI == null && lllllllllllllllIlllIIlIIlIlIIIII != null) {
            return 1;
        }
        if (lllllllllllllllIlllIIlIIlIlIIIlI != null && lllllllllllllllIlllIIlIIlIlIIIII == null) {
            return -1;
        }
        return (lllllllllllllllIlllIIlIIlIlIIIlI == null && lllllllllllllllIlllIIlIIlIlIIIII == null) ? 0 : lllllllllllllllIlllIIlIIlIlIIIlI.compareTo(lllllllllllllllIlllIIlIIlIlIIIII);
    }
    
    private int func_194032_h() {
        int lllllllllllllllIlllIIlIlIIIIllII = 0;
        final Exception lllllllllllllllIlllIIlIlIIIIIIlI;
        final Exception lllllllllllllllIlllIIlIlIIIIIIll = (Exception)((String[][])(Object)(lllllllllllllllIlllIIlIlIIIIIIlI = (Exception)(Object)this.field_192111_b)).length;
        for (char lllllllllllllllIlllIIlIlIIIIIlII = '\0'; lllllllllllllllIlllIIlIlIIIIIlII < lllllllllllllllIlllIIlIlIIIIIIll; ++lllllllllllllllIlllIIlIlIIIIIlII) {
            final String[] lllllllllllllllIlllIIlIlIIIIlIll = lllllllllllllllIlllIIlIlIIIIIIlI[lllllllllllllllIlllIIlIlIIIIIlII];
            boolean lllllllllllllllIlllIIlIlIIIIlIlI = false;
            final Exception lllllllllllllllIlllIIlIIllllllIl;
            final double lllllllllllllllIlllIIlIIlllllllI = ((String[])(Object)(lllllllllllllllIlllIIlIIllllllIl = (Exception)(Object)lllllllllllllllIlllIIlIlIIIIlIll)).length;
            for (byte lllllllllllllllIlllIIlIIllllllll = 0; lllllllllllllllIlllIIlIIllllllll < lllllllllllllllIlllIIlIIlllllllI; ++lllllllllllllllIlllIIlIIllllllll) {
                final String lllllllllllllllIlllIIlIlIIIIlIIl = lllllllllllllllIlllIIlIIllllllIl[lllllllllllllllIlllIIlIIllllllll];
                final CriterionProgress lllllllllllllllIlllIIlIlIIIIlIII = this.func_192106_c(lllllllllllllllIlllIIlIlIIIIlIIl);
                if (lllllllllllllllIlllIIlIlIIIIlIII != null && lllllllllllllllIlllIIlIlIIIIlIII.func_192151_a()) {
                    lllllllllllllllIlllIIlIlIIIIlIlI = true;
                    break;
                }
            }
            if (lllllllllllllllIlllIIlIlIIIIlIlI) {
                ++lllllllllllllllIlllIIlIlIIIIllII;
            }
        }
        return lllllllllllllllIlllIIlIlIIIIllII;
    }
    
    public boolean func_192105_a() {
        if (this.field_192111_b.length == 0) {
            return false;
        }
        final long lllllllllllllllIlllIIlIlllIlIlll;
        final int lllllllllllllllIlllIIlIlllIllIIl = ((String[][])(Object)(lllllllllllllllIlllIIlIlllIlIlll = (long)(Object)this.field_192111_b)).length;
        for (float lllllllllllllllIlllIIlIlllIllIll = 0; lllllllllllllllIlllIIlIlllIllIll < lllllllllllllllIlllIIlIlllIllIIl; ++lllllllllllllllIlllIIlIlllIllIll) {
            final String[] lllllllllllllllIlllIIlIllllIIlll = lllllllllllllllIlllIIlIlllIlIlll[lllllllllllllllIlllIIlIlllIllIll];
            boolean lllllllllllllllIlllIIlIllllIIlIl = false;
            final Exception lllllllllllllllIlllIIlIlllIlIIII;
            final String lllllllllllllllIlllIIlIlllIlIIIl = (String)((String[])(Object)(lllllllllllllllIlllIIlIlllIlIIII = (Exception)(Object)lllllllllllllllIlllIIlIllllIIlll)).length;
            for (short lllllllllllllllIlllIIlIlllIlIIlI = 0; lllllllllllllllIlllIIlIlllIlIIlI < lllllllllllllllIlllIIlIlllIlIIIl; ++lllllllllllllllIlllIIlIlllIlIIlI) {
                final String lllllllllllllllIlllIIlIllllIIIll = lllllllllllllllIlllIIlIlllIlIIII[lllllllllllllllIlllIIlIlllIlIIlI];
                final CriterionProgress lllllllllllllllIlllIIlIllllIIIIl = this.func_192106_c(lllllllllllllllIlllIIlIllllIIIll);
                if (lllllllllllllllIlllIIlIllllIIIIl != null && lllllllllllllllIlllIIlIllllIIIIl.func_192151_a()) {
                    lllllllllllllllIlllIIlIllllIIlIl = true;
                    break;
                }
            }
            if (!lllllllllllllllIlllIIlIllllIIlIl) {
                return false;
            }
        }
        return true;
    }
    
    public boolean func_192109_a(final String lllllllllllllllIlllIIlIllIlllIlI) {
        final CriterionProgress lllllllllllllllIlllIIlIllIlllIII = this.field_192110_a.get(lllllllllllllllIlllIIlIllIlllIlI);
        if (lllllllllllllllIlllIIlIllIlllIII != null && !lllllllllllllllIlllIIlIllIlllIII.func_192151_a()) {
            lllllllllllllllIlllIIlIllIlllIII.func_192153_b();
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("AdvancementProgress{criteria=").append(this.field_192110_a).append(", requirements=").append(Arrays.deepToString(this.field_192111_b)).append('}'));
    }
    
    public float func_192103_c() {
        if (this.field_192110_a.isEmpty()) {
            return 0.0f;
        }
        final float lllllllllllllllIlllIIlIlIlIIlIll = (float)this.field_192111_b.length;
        final float lllllllllllllllIlllIIlIlIlIIlIlI = (float)this.func_194032_h();
        return lllllllllllllllIlllIIlIlIlIIlIlI / lllllllllllllllIlllIIlIlIlIIlIll;
    }
    
    public void func_192099_a(final Map<String, Criterion> lllllllllllllllIlllIIllIIIIllllI, final String[][] lllllllllllllllIlllIIllIIIIlllIl) {
        final Set<String> lllllllllllllllIlllIIllIIIIlllII = lllllllllllllllIlllIIllIIIIllllI.keySet();
        final Iterator<Map.Entry<String, CriterionProgress>> lllllllllllllllIlllIIllIIIIllIll = this.field_192110_a.entrySet().iterator();
        while (lllllllllllllllIlllIIllIIIIllIll.hasNext()) {
            final Map.Entry<String, CriterionProgress> lllllllllllllllIlllIIllIIIIllIlI = lllllllllllllllIlllIIllIIIIllIll.next();
            if (!lllllllllllllllIlllIIllIIIIlllII.contains(lllllllllllllllIlllIIllIIIIllIlI.getKey())) {
                lllllllllllllllIlllIIllIIIIllIll.remove();
            }
        }
        for (final String lllllllllllllllIlllIIllIIIIllIIl : lllllllllllllllIlllIIllIIIIlllII) {
            if (!this.field_192110_a.containsKey(lllllllllllllllIlllIIllIIIIllIIl)) {
                this.field_192110_a.put(lllllllllllllllIlllIIllIIIIllIIl, new CriterionProgress(this));
            }
        }
        this.field_192111_b = lllllllllllllllIlllIIllIIIIlllIl;
    }
    
    public void func_192104_a(final PacketBuffer lllllllllllllllIlllIIlIllIIIllIl) {
        lllllllllllllllIlllIIlIllIIIllIl.writeVarIntToBuffer(this.field_192110_a.size());
        for (final Map.Entry<String, CriterionProgress> lllllllllllllllIlllIIlIllIIIlIll : this.field_192110_a.entrySet()) {
            lllllllllllllllIlllIIlIllIIIllIl.writeString(lllllllllllllllIlllIIlIllIIIlIll.getKey());
            lllllllllllllllIlllIIlIllIIIlIll.getValue().func_192150_a(lllllllllllllllIlllIIlIllIIIllIl);
        }
    }
    
    public boolean func_192108_b() {
        for (final CriterionProgress lllllllllllllllIlllIIlIlllIIlIlI : this.field_192110_a.values()) {
            if (lllllllllllllllIlllIIlIlllIIlIlI.func_192151_a()) {
                return true;
            }
        }
        return false;
    }
    
    public static class Serializer implements JsonDeserializer<AdvancementProgress>, JsonSerializer<AdvancementProgress>
    {
        public JsonElement serialize(final AdvancementProgress llllllllllllllIlIIIIlllIIlIllIlI, final Type llllllllllllllIlIIIIlllIIlIllIIl, final JsonSerializationContext llllllllllllllIlIIIIlllIIlIllIII) {
            final JsonObject llllllllllllllIlIIIIlllIIlIlIlll = new JsonObject();
            final JsonObject llllllllllllllIlIIIIlllIIlIlIllI = new JsonObject();
            for (final Map.Entry<String, CriterionProgress> llllllllllllllIlIIIIlllIIlIlIlIl : llllllllllllllIlIIIIlllIIlIllIlI.field_192110_a.entrySet()) {
                final CriterionProgress llllllllllllllIlIIIIlllIIlIlIlII = llllllllllllllIlIIIIlllIIlIlIlIl.getValue();
                if (llllllllllllllIlIIIIlllIIlIlIlII.func_192151_a()) {
                    llllllllllllllIlIIIIlllIIlIlIllI.add((String)llllllllllllllIlIIIIlllIIlIlIlIl.getKey(), llllllllllllllIlIIIIlllIIlIlIlII.func_192148_e());
                }
            }
            if (!llllllllllllllIlIIIIlllIIlIlIllI.entrySet().isEmpty()) {
                llllllllllllllIlIIIIlllIIlIlIlll.add("criteria", (JsonElement)llllllllllllllIlIIIIlllIIlIlIllI);
            }
            llllllllllllllIlIIIIlllIIlIlIlll.addProperty("done", Boolean.valueOf(llllllllllllllIlIIIIlllIIlIllIlI.func_192105_a()));
            return (JsonElement)llllllllllllllIlIIIIlllIIlIlIlll;
        }
        
        public AdvancementProgress deserialize(final JsonElement llllllllllllllIlIIIIlllIIlIIIlIl, final Type llllllllllllllIlIIIIlllIIlIIIlII, final JsonDeserializationContext llllllllllllllIlIIIIlllIIlIIIIll) throws JsonParseException {
            final JsonObject llllllllllllllIlIIIIlllIIlIIIIlI = JsonUtils.getJsonObject(llllllllllllllIlIIIIlllIIlIIIlIl, "advancement");
            final JsonObject llllllllllllllIlIIIIlllIIlIIIIIl = JsonUtils.getJsonObject(llllllllllllllIlIIIIlllIIlIIIIlI, "criteria", new JsonObject());
            final AdvancementProgress llllllllllllllIlIIIIlllIIlIIIIII = new AdvancementProgress();
            for (final Map.Entry<String, JsonElement> llllllllllllllIlIIIIlllIIIllllll : llllllllllllllIlIIIIlllIIlIIIIIl.entrySet()) {
                final String llllllllllllllIlIIIIlllIIIlllllI = llllllllllllllIlIIIIlllIIIllllll.getKey();
                llllllllllllllIlIIIIlllIIlIIIIII.field_192110_a.put(llllllllllllllIlIIIIlllIIIlllllI, CriterionProgress.func_192152_a(llllllllllllllIlIIIIlllIIlIIIIII, JsonUtils.getString(llllllllllllllIlIIIIlllIIIllllll.getValue(), llllllllllllllIlIIIIlllIIIlllllI)));
            }
            return llllllllllllllIlIIIIlllIIlIIIIII;
        }
    }
}
