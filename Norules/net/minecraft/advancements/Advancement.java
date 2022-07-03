package net.minecraft.advancements;

import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.*;
import net.minecraft.util.*;
import com.google.gson.*;
import org.apache.commons.lang3.*;
import java.util.*;
import net.minecraft.network.*;
import java.util.function.*;
import java.io.*;

public class Advancement
{
    private final /* synthetic */ AdvancementRewards field_192078_c;
    private final /* synthetic */ String[][] field_192081_f;
    private final /* synthetic */ Map<String, Criterion> field_192080_e;
    private final /* synthetic */ ResourceLocation field_192079_d;
    private final /* synthetic */ Set<Advancement> field_192082_g;
    private final /* synthetic */ Advancement field_192076_a;
    private final /* synthetic */ DisplayInfo field_192077_b;
    private final /* synthetic */ ITextComponent field_193125_h;
    
    public int func_193124_g() {
        return this.field_192081_f.length;
    }
    
    @Nullable
    public Advancement func_192070_b() {
        return this.field_192076_a;
    }
    
    public Advancement(final ResourceLocation llllllllllllIlllllllIllIIlIlIllI, @Nullable final Advancement llllllllllllIlllllllIllIIlIlllll, @Nullable final DisplayInfo llllllllllllIlllllllIllIIlIllllI, final AdvancementRewards llllllllllllIlllllllIllIIlIlIIll, final Map<String, Criterion> llllllllllllIlllllllIllIIlIlllII, final String[][] llllllllllllIlllllllIllIIlIlIIIl) {
        this.field_192082_g = (Set<Advancement>)Sets.newLinkedHashSet();
        this.field_192079_d = llllllllllllIlllllllIllIIlIlIllI;
        this.field_192077_b = llllllllllllIlllllllIllIIlIllllI;
        this.field_192080_e = (Map<String, Criterion>)ImmutableMap.copyOf((Map)llllllllllllIlllllllIllIIlIlllII);
        this.field_192076_a = llllllllllllIlllllllIllIIlIlllll;
        this.field_192078_c = llllllllllllIlllllllIllIIlIlIIll;
        this.field_192081_f = llllllllllllIlllllllIllIIlIlIIIl;
        if (llllllllllllIlllllllIllIIlIlllll != null) {
            llllllllllllIlllllllIllIIlIlllll.func_192071_a(this);
        }
        if (llllllllllllIlllllllIllIIlIllllI == null) {
            this.field_193125_h = new TextComponentString(llllllllllllIlllllllIllIIlIlIllI.toString());
        }
        else {
            this.field_193125_h = new TextComponentString("[");
            this.field_193125_h.getStyle().setColor(llllllllllllIlllllllIllIIlIllllI.func_192291_d().func_193229_c());
            final ITextComponent llllllllllllIlllllllIllIIlIllIlI = llllllllllllIlllllllIllIIlIllllI.func_192297_a().createCopy();
            final ITextComponent llllllllllllIlllllllIllIIlIllIIl = new TextComponentString("");
            final ITextComponent llllllllllllIlllllllIllIIlIllIII = llllllllllllIlllllllIllIIlIllIlI.createCopy();
            llllllllllllIlllllllIllIIlIllIII.getStyle().setColor(llllllllllllIlllllllIllIIlIllllI.func_192291_d().func_193229_c());
            llllllllllllIlllllllIllIIlIllIIl.appendSibling(llllllllllllIlllllllIllIIlIllIII);
            llllllllllllIlllllllIllIIlIllIIl.appendText("\n");
            llllllllllllIlllllllIllIIlIllIIl.appendSibling(llllllllllllIlllllllIllIIlIllllI.func_193222_b());
            llllllllllllIlllllllIllIIlIllIlI.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, llllllllllllIlllllllIllIIlIllIIl));
            this.field_193125_h.appendSibling(llllllllllllIlllllllIllIIlIllIlI);
            this.field_193125_h.appendText("]");
        }
    }
    
    public AdvancementRewards func_192072_d() {
        return this.field_192078_c;
    }
    
    @Nullable
    public DisplayInfo func_192068_c() {
        return this.field_192077_b;
    }
    
    public Builder func_192075_a() {
        return new Builder((this.field_192076_a == null) ? null : this.field_192076_a.func_192067_g(), this.field_192077_b, this.field_192078_c, this.field_192080_e, this.field_192081_f);
    }
    
    public Iterable<Advancement> func_192069_e() {
        return this.field_192082_g;
    }
    
    public ITextComponent func_193123_j() {
        return this.field_193125_h;
    }
    
    public ResourceLocation func_192067_g() {
        return this.field_192079_d;
    }
    
    @Override
    public boolean equals(final Object llllllllllllIlllllllIllIIIlIIlIl) {
        if (this == llllllllllllIlllllllIllIIIlIIlIl) {
            return true;
        }
        if (!(llllllllllllIlllllllIllIIIlIIlIl instanceof Advancement)) {
            return false;
        }
        final Advancement llllllllllllIlllllllIllIIIlIIlll = (Advancement)llllllllllllIlllllllIllIIIlIIlIl;
        return this.field_192079_d.equals(llllllllllllIlllllllIllIIIlIIlll.field_192079_d);
    }
    
    public Map<String, Criterion> func_192073_f() {
        return this.field_192080_e;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("SimpleAdvancement{id=").append(this.func_192067_g()).append(", parent=").append((this.field_192076_a == null) ? "null" : this.field_192076_a.func_192067_g()).append(", display=").append(this.field_192077_b).append(", rewards=").append(this.field_192078_c).append(", criteria=").append(this.field_192080_e).append(", requirements=").append(Arrays.deepToString(this.field_192081_f)).append('}'));
    }
    
    public String[][] func_192074_h() {
        return this.field_192081_f;
    }
    
    @Override
    public int hashCode() {
        return this.field_192079_d.hashCode();
    }
    
    public void func_192071_a(final Advancement llllllllllllIlllllllIllIIIllIIlI) {
        this.field_192082_g.add(llllllllllllIlllllllIllIIIllIIlI);
    }
    
    public static class Builder
    {
        private final /* synthetic */ DisplayInfo field_192063_c;
        private final /* synthetic */ ResourceLocation field_192061_a;
        private final /* synthetic */ String[][] field_192066_f;
        private /* synthetic */ Advancement field_192062_b;
        private final /* synthetic */ AdvancementRewards field_192064_d;
        private final /* synthetic */ Map<String, Criterion> field_192065_e;
        
        Builder(@Nullable final ResourceLocation lllllllllllllllIIIllllIlIIIIlIll, @Nullable final DisplayInfo lllllllllllllllIIIllllIlIIIIIlII, final AdvancementRewards lllllllllllllllIIIllllIlIIIIIIll, final Map<String, Criterion> lllllllllllllllIIIllllIlIIIIIIlI, final String[][] lllllllllllllllIIIllllIlIIIIIIIl) {
            this.field_192061_a = lllllllllllllllIIIllllIlIIIIlIll;
            this.field_192063_c = lllllllllllllllIIIllllIlIIIIIlII;
            this.field_192064_d = lllllllllllllllIIIllllIlIIIIIIll;
            this.field_192065_e = lllllllllllllllIIIllllIlIIIIIIlI;
            this.field_192066_f = lllllllllllllllIIIllllIlIIIIIIIl;
        }
        
        public static Builder func_192059_a(final JsonObject lllllllllllllllIIIllllIIllIIlIIl, final JsonDeserializationContext lllllllllllllllIIIllllIIllIIlIII) {
            final ResourceLocation lllllllllllllllIIIllllIIllIIIlll = lllllllllllllllIIIllllIIllIIlIIl.has("parent") ? new ResourceLocation(JsonUtils.getString(lllllllllllllllIIIllllIIllIIlIIl, "parent")) : null;
            final DisplayInfo lllllllllllllllIIIllllIIllIIIllI = lllllllllllllllIIIllllIIllIIlIIl.has("display") ? DisplayInfo.func_192294_a(JsonUtils.getJsonObject(lllllllllllllllIIIllllIIllIIlIIl, "display"), lllllllllllllllIIIllllIIllIIlIII) : null;
            final AdvancementRewards lllllllllllllllIIIllllIIllIIIlIl = JsonUtils.deserializeClass(lllllllllllllllIIIllllIIllIIlIIl, "rewards", AdvancementRewards.field_192114_a, lllllllllllllllIIIllllIIllIIlIII, AdvancementRewards.class);
            final Map<String, Criterion> lllllllllllllllIIIllllIIllIIIlII = Criterion.func_192144_b(JsonUtils.getJsonObject(lllllllllllllllIIIllllIIllIIlIIl, "criteria"), lllllllllllllllIIIllllIIllIIlIII);
            if (lllllllllllllllIIIllllIIllIIIlII.isEmpty()) {
                throw new JsonSyntaxException("Advancement criteria cannot be empty");
            }
            final JsonArray lllllllllllllllIIIllllIIllIIIIll = JsonUtils.getJsonArray(lllllllllllllllIIIllllIIllIIlIIl, "requirements", new JsonArray());
            String[][] lllllllllllllllIIIllllIIllIIIIlI = new String[lllllllllllllllIIIllllIIllIIIIll.size()][];
            for (int lllllllllllllllIIIllllIIllIIIIIl = 0; lllllllllllllllIIIllllIIllIIIIIl < lllllllllllllllIIIllllIIllIIIIll.size(); ++lllllllllllllllIIIllllIIllIIIIIl) {
                final JsonArray lllllllllllllllIIIllllIIllIIIIII = JsonUtils.getJsonArray(lllllllllllllllIIIllllIIllIIIIll.get(lllllllllllllllIIIllllIIllIIIIIl), String.valueOf(new StringBuilder("requirements[").append(lllllllllllllllIIIllllIIllIIIIIl).append("]")));
                lllllllllllllllIIIllllIIllIIIIlI[lllllllllllllllIIIllllIIllIIIIIl] = new String[lllllllllllllllIIIllllIIllIIIIII.size()];
                for (int lllllllllllllllIIIllllIIlIllllll = 0; lllllllllllllllIIIllllIIlIllllll < lllllllllllllllIIIllllIIllIIIIII.size(); ++lllllllllllllllIIIllllIIlIllllll) {
                    lllllllllllllllIIIllllIIllIIIIlI[lllllllllllllllIIIllllIIllIIIIIl][lllllllllllllllIIIllllIIlIllllll] = JsonUtils.getString(lllllllllllllllIIIllllIIllIIIIII.get(lllllllllllllllIIIllllIIlIllllll), String.valueOf(new StringBuilder("requirements[").append(lllllllllllllllIIIllllIIllIIIIIl).append("][").append(lllllllllllllllIIIllllIIlIllllll).append("]")));
                }
            }
            if (lllllllllllllllIIIllllIIllIIIIlI.length == 0) {
                lllllllllllllllIIIllllIIllIIIIlI = new String[lllllllllllllllIIIllllIIllIIIlII.size()][];
                int lllllllllllllllIIIllllIIlIlllllI = 0;
                for (final String lllllllllllllllIIIllllIIlIllllIl : lllllllllllllllIIIllllIIllIIIlII.keySet()) {
                    lllllllllllllllIIIllllIIllIIIIlI[lllllllllllllllIIIllllIIlIlllllI++] = new String[] { lllllllllllllllIIIllllIIlIllllIl };
                }
            }
            String lllllllllllllllIIIllllIIlIlIllII;
            for (int length = (lllllllllllllllIIIllllIIlIlIllII = (String)(Object)lllllllllllllllIIIllllIIllIIIIlI).length, i = 0; i < length; ++i) {
                final String[] lllllllllllllllIIIllllIIlIllllII = lllllllllllllllIIIllllIIlIlIllII[i];
                if (lllllllllllllllIIIllllIIlIllllII.length == 0 && lllllllllllllllIIIllllIIllIIIlII.isEmpty()) {
                    throw new JsonSyntaxException("Requirement entry cannot be empty");
                }
                final char lllllllllllllllIIIllllIIlIlIlIII;
                final short lllllllllllllllIIIllllIIlIlIlIIl = (short)((String[])(Object)(lllllllllllllllIIIllllIIlIlIlIII = (char)(Object)lllllllllllllllIIIllllIIlIllllII)).length;
                for (boolean lllllllllllllllIIIllllIIlIlIlIlI = false; (lllllllllllllllIIIllllIIlIlIlIlI ? 1 : 0) < lllllllllllllllIIIllllIIlIlIlIIl; ++lllllllllllllllIIIllllIIlIlIlIlI) {
                    final String lllllllllllllllIIIllllIIlIlllIll = lllllllllllllllIIIllllIIlIlIlIII[lllllllllllllllIIIllllIIlIlIlIlI];
                    if (!lllllllllllllllIIIllllIIllIIIlII.containsKey(lllllllllllllllIIIllllIIlIlllIll)) {
                        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown required criterion '").append(lllllllllllllllIIIllllIIlIlllIll).append("'")));
                    }
                }
            }
            for (final String lllllllllllllllIIIllllIIlIlllIlI : lllllllllllllllIIIllllIIllIIIlII.keySet()) {
                boolean lllllllllllllllIIIllllIIlIlllIIl = false;
                final short lllllllllllllllIIIllllIIlIlIlIIl;
                final boolean lllllllllllllllIIIllllIIlIlIlIlI = ((String[][])(Object)(lllllllllllllllIIIllllIIlIlIlIIl = (short)(Object)lllllllllllllllIIIllllIIllIIIIlI)).length != 0;
                for (final String[] lllllllllllllllIIIllllIIlIlllIII : lllllllllllllllIIIllllIIlIlIlIIl) {
                    if (ArrayUtils.contains((Object[])lllllllllllllllIIIllllIIlIlllIII, (Object)lllllllllllllllIIIllllIIlIlllIlI)) {
                        lllllllllllllllIIIllllIIlIlllIIl = true;
                        break;
                    }
                }
                if (!lllllllllllllllIIIllllIIlIlllIIl) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Criterion '").append(lllllllllllllllIIIllllIIlIlllIlI).append("' isn't a requirement for completion. This isn't supported behaviour, all criteria must be required.")));
                }
            }
            return new Builder(lllllllllllllllIIIllllIIllIIIlll, lllllllllllllllIIIllllIIllIIIllI, lllllllllllllllIIIllllIIllIIIlIl, lllllllllllllllIIIllllIIllIIIlII, lllllllllllllllIIIllllIIllIIIIlI);
        }
        
        public void func_192057_a(final PacketBuffer lllllllllllllllIIIllllIIlllIIlIl) {
            if (this.field_192061_a == null) {
                lllllllllllllllIIIllllIIlllIIlIl.writeBoolean(false);
            }
            else {
                lllllllllllllllIIIllllIIlllIIlIl.writeBoolean(true);
                lllllllllllllllIIIllllIIlllIIlIl.func_192572_a(this.field_192061_a);
            }
            if (this.field_192063_c == null) {
                lllllllllllllllIIIllllIIlllIIlIl.writeBoolean(false);
            }
            else {
                lllllllllllllllIIIllllIIlllIIlIl.writeBoolean(true);
                this.field_192063_c.func_192290_a(lllllllllllllllIIIllllIIlllIIlIl);
            }
            Criterion.func_192141_a(this.field_192065_e, lllllllllllllllIIIllllIIlllIIlIl);
            lllllllllllllllIIIllllIIlllIIlIl.writeVarIntToBuffer(this.field_192066_f.length);
            final float lllllllllllllllIIIllllIIlllIIIIl;
            final Exception lllllllllllllllIIIllllIIlllIIIlI = (Exception)((String[][])(Object)(lllllllllllllllIIIllllIIlllIIIIl = (float)(Object)this.field_192066_f)).length;
            for (char lllllllllllllllIIIllllIIlllIIIll = '\0'; lllllllllllllllIIIllllIIlllIIIll < lllllllllllllllIIIllllIIlllIIIlI; ++lllllllllllllllIIIllllIIlllIIIll) {
                final String[] lllllllllllllllIIIllllIIlllIlIII = lllllllllllllllIIIllllIIlllIIIIl[lllllllllllllllIIIllllIIlllIIIll];
                lllllllllllllllIIIllllIIlllIIlIl.writeVarIntToBuffer(lllllllllllllllIIIllllIIlllIlIII.length);
                final int lllllllllllllllIIIllllIIllIlllIl;
                final Exception lllllllllllllllIIIllllIIllIllllI = (Exception)((String[])(Object)(lllllllllllllllIIIllllIIllIlllIl = (int)(Object)lllllllllllllllIIIllllIIlllIlIII)).length;
                for (long lllllllllllllllIIIllllIIllIlllll = 0; lllllllllllllllIIIllllIIllIlllll < lllllllllllllllIIIllllIIllIllllI; ++lllllllllllllllIIIllllIIllIlllll) {
                    final String lllllllllllllllIIIllllIIlllIIlll = lllllllllllllllIIIllllIIllIlllIl[lllllllllllllllIIIllllIIllIlllll];
                    lllllllllllllllIIIllllIIlllIIlIl.writeString(lllllllllllllllIIIllllIIlllIIlll);
                }
            }
        }
        
        public boolean func_192058_a(final Function<ResourceLocation, Advancement> lllllllllllllllIIIllllIIlllllIll) {
            if (this.field_192061_a == null) {
                return true;
            }
            this.field_192062_b = lllllllllllllllIIIllllIIlllllIll.apply(this.field_192061_a);
            return this.field_192062_b != null;
        }
        
        public Advancement func_192056_a(final ResourceLocation lllllllllllllllIIIllllIIllllIlIl) {
            return new Advancement(lllllllllllllllIIIllllIIllllIlIl, this.field_192062_b, this.field_192063_c, this.field_192064_d, this.field_192065_e, this.field_192066_f);
        }
        
        public static Builder func_192060_b(final PacketBuffer lllllllllllllllIIIllllIIlIIllIIl) throws IOException {
            final ResourceLocation lllllllllllllllIIIllllIIlIIlllll = lllllllllllllllIIIllllIIlIIllIIl.readBoolean() ? lllllllllllllllIIIllllIIlIIllIIl.func_192575_l() : null;
            final DisplayInfo lllllllllllllllIIIllllIIlIIllllI = lllllllllllllllIIIllllIIlIIllIIl.readBoolean() ? DisplayInfo.func_192295_b(lllllllllllllllIIIllllIIlIIllIIl) : null;
            final Map<String, Criterion> lllllllllllllllIIIllllIIlIIlllIl = Criterion.func_192142_c(lllllllllllllllIIIllllIIlIIllIIl);
            final String[][] lllllllllllllllIIIllllIIlIIlllII = new String[lllllllllllllllIIIllllIIlIIllIIl.readVarIntFromBuffer()][];
            for (int lllllllllllllllIIIllllIIlIIllIll = 0; lllllllllllllllIIIllllIIlIIllIll < lllllllllllllllIIIllllIIlIIlllII.length; ++lllllllllllllllIIIllllIIlIIllIll) {
                lllllllllllllllIIIllllIIlIIlllII[lllllllllllllllIIIllllIIlIIllIll] = new String[lllllllllllllllIIIllllIIlIIllIIl.readVarIntFromBuffer()];
                for (int lllllllllllllllIIIllllIIlIIllIlI = 0; lllllllllllllllIIIllllIIlIIllIlI < lllllllllllllllIIIllllIIlIIlllII[lllllllllllllllIIIllllIIlIIllIll].length; ++lllllllllllllllIIIllllIIlIIllIlI) {
                    lllllllllllllllIIIllllIIlIIlllII[lllllllllllllllIIIllllIIlIIllIll][lllllllllllllllIIIllllIIlIIllIlI] = lllllllllllllllIIIllllIIlIIllIIl.readStringFromBuffer(32767);
                }
            }
            return new Builder(lllllllllllllllIIIllllIIlIIlllll, lllllllllllllllIIIllllIIlIIllllI, AdvancementRewards.field_192114_a, lllllllllllllllIIIllllIIlIIlllIl, lllllllllllllllIIIllllIIlIIlllII);
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("Task Advancement{parentId=").append(this.field_192061_a).append(", display=").append(this.field_192063_c).append(", rewards=").append(this.field_192064_d).append(", criteria=").append(this.field_192065_e).append(", requirements=").append(Arrays.deepToString(this.field_192066_f)).append('}'));
        }
    }
}
