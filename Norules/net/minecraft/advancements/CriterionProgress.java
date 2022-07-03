package net.minecraft.advancements;

import java.util.*;
import net.minecraft.network.*;
import java.text.*;
import com.google.gson.*;

public class CriterionProgress
{
    private static final /* synthetic */ SimpleDateFormat field_192155_a;
    private final /* synthetic */ AdvancementProgress field_192156_b;
    private /* synthetic */ Date field_192157_c;
    
    public CriterionProgress(final AdvancementProgress llllllllllllllIIllIllIIlIIlllIlI) {
        this.field_192156_b = llllllllllllllIIllIllIIlIIlllIlI;
    }
    
    public static CriterionProgress func_192149_a(final PacketBuffer llllllllllllllIIllIllIIlIIIllIIl, final AdvancementProgress llllllllllllllIIllIllIIlIIIllIII) {
        final CriterionProgress llllllllllllllIIllIllIIlIIIllIlI = new CriterionProgress(llllllllllllllIIllIllIIlIIIllIII);
        if (llllllllllllllIIllIllIIlIIIllIIl.readBoolean()) {
            llllllllllllllIIllIllIIlIIIllIlI.field_192157_c = llllllllllllllIIllIllIIlIIIllIIl.func_192573_m();
        }
        return llllllllllllllIIllIllIIlIIIllIlI;
    }
    
    static {
        field_192155_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("CriterionProgress{obtained=").append((this.field_192157_c == null) ? "false" : this.field_192157_c).append('}'));
    }
    
    public static CriterionProgress func_192152_a(final AdvancementProgress llllllllllllllIIllIllIIlIIIIlllI, final String llllllllllllllIIllIllIIlIIIlIIIl) {
        final CriterionProgress llllllllllllllIIllIllIIlIIIlIIII = new CriterionProgress(llllllllllllllIIllIllIIlIIIIlllI);
        try {
            llllllllllllllIIllIllIIlIIIlIIII.field_192157_c = CriterionProgress.field_192155_a.parse(llllllllllllllIIllIllIIlIIIlIIIl);
            return llllllllllllllIIllIllIIlIIIlIIII;
        }
        catch (ParseException llllllllllllllIIllIllIIlIIIIllll) {
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Invalid datetime: ").append(llllllllllllllIIllIllIIlIIIlIIIl)), (Throwable)llllllllllllllIIllIllIIlIIIIllll);
        }
    }
    
    public void func_192153_b() {
        this.field_192157_c = new Date();
    }
    
    public JsonElement func_192148_e() {
        return (JsonElement)((this.field_192157_c != null) ? new JsonPrimitive(CriterionProgress.field_192155_a.format(this.field_192157_c)) : JsonNull.INSTANCE);
    }
    
    public void func_192150_a(final PacketBuffer llllllllllllllIIllIllIIlIIlIIIll) {
        llllllllllllllIIllIllIIlIIlIIIll.writeBoolean(this.field_192157_c != null);
        if (this.field_192157_c != null) {
            llllllllllllllIIllIllIIlIIlIIIll.func_192574_a(this.field_192157_c);
        }
    }
    
    public boolean func_192151_a() {
        return this.field_192157_c != null;
    }
    
    public Date func_193140_d() {
        return this.field_192157_c;
    }
    
    public void func_192154_c() {
        this.field_192157_c = null;
    }
}
