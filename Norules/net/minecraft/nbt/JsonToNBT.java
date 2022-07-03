package net.minecraft.nbt;

import java.util.regex.*;
import java.util.*;
import com.google.common.collect.*;
import com.google.common.annotations.*;

public class JsonToNBT
{
    private final /* synthetic */ String field_193622_h;
    private static final /* synthetic */ Pattern field_193618_d;
    private static final /* synthetic */ Pattern field_193617_c;
    private static final /* synthetic */ Pattern field_193620_f;
    private static final /* synthetic */ Pattern field_193615_a;
    private static final /* synthetic */ Pattern field_193621_g;
    private static final /* synthetic */ Pattern field_193619_e;
    private static final /* synthetic */ Pattern field_193616_b;
    private /* synthetic */ int field_193623_i;
    
    private void func_193604_b(final char lllllllllllllIIIllIlllllIlIIIllI) throws NBTException {
        this.func_193607_l();
        final boolean lllllllllllllIIIllIlllllIlIIlIII = this.func_193612_g();
        if (lllllllllllllIIIllIlllllIlIIlIII && this.func_193598_n() == lllllllllllllIIIllIlllllIlIIIllI) {
            ++this.field_193623_i;
            return;
        }
        throw new NBTException(String.valueOf(new StringBuilder("Expected '").append(lllllllllllllIIIllIlllllIlIIIllI).append("' but got '").append(lllllllllllllIIIllIlllllIlIIlIII ? Character.valueOf(this.func_193598_n()) : "<EOF>").append("'")), this.field_193622_h, this.field_193623_i + 1);
    }
    
    private NBTBase func_193606_k() throws NBTException {
        this.func_193604_b('[');
        final char lllllllllllllIIIllIlllllIllIlIII = this.func_193594_o();
        this.func_193594_o();
        this.func_193607_l();
        if (!this.func_193612_g()) {
            throw this.func_193602_b("Expected value");
        }
        if (lllllllllllllIIIllIlllllIllIlIII == 'B') {
            return new NBTTagByteArray(this.func_193603_a((byte)7, (byte)1));
        }
        if (lllllllllllllIIIllIlllllIllIlIII == 'L') {
            return new NBTTagLongArray(this.func_193603_a((byte)12, (byte)4));
        }
        if (lllllllllllllIIIllIlllllIllIlIII == 'I') {
            return new NBTTagIntArray(this.func_193603_a((byte)11, (byte)3));
        }
        throw this.func_193602_b(String.valueOf(new StringBuilder("Invalid array type '").append(lllllllllllllIIIllIlllllIllIlIII).append("' found")));
    }
    
    private NBTBase func_193596_c(final String lllllllllllllIIIllIllllllIlIIIll) {
        try {
            if (JsonToNBT.field_193617_c.matcher(lllllllllllllIIIllIllllllIlIIIll).matches()) {
                return new NBTTagFloat(Float.parseFloat(lllllllllllllIIIllIllllllIlIIIll.substring(0, lllllllllllllIIIllIllllllIlIIIll.length() - 1)));
            }
            if (JsonToNBT.field_193618_d.matcher(lllllllllllllIIIllIllllllIlIIIll).matches()) {
                return new NBTTagByte(Byte.parseByte(lllllllllllllIIIllIllllllIlIIIll.substring(0, lllllllllllllIIIllIllllllIlIIIll.length() - 1)));
            }
            if (JsonToNBT.field_193619_e.matcher(lllllllllllllIIIllIllllllIlIIIll).matches()) {
                return new NBTTagLong(Long.parseLong(lllllllllllllIIIllIllllllIlIIIll.substring(0, lllllllllllllIIIllIllllllIlIIIll.length() - 1)));
            }
            if (JsonToNBT.field_193620_f.matcher(lllllllllllllIIIllIllllllIlIIIll).matches()) {
                return new NBTTagShort(Short.parseShort(lllllllllllllIIIllIllllllIlIIIll.substring(0, lllllllllllllIIIllIllllllIlIIIll.length() - 1)));
            }
            if (JsonToNBT.field_193621_g.matcher(lllllllllllllIIIllIllllllIlIIIll).matches()) {
                return new NBTTagInt(Integer.parseInt(lllllllllllllIIIllIllllllIlIIIll));
            }
            if (JsonToNBT.field_193616_b.matcher(lllllllllllllIIIllIllllllIlIIIll).matches()) {
                return new NBTTagDouble(Double.parseDouble(lllllllllllllIIIllIllllllIlIIIll.substring(0, lllllllllllllIIIllIllllllIlIIIll.length() - 1)));
            }
            if (JsonToNBT.field_193615_a.matcher(lllllllllllllIIIllIllllllIlIIIll).matches()) {
                return new NBTTagDouble(Double.parseDouble(lllllllllllllIIIllIllllllIlIIIll));
            }
            if ("true".equalsIgnoreCase(lllllllllllllIIIllIllllllIlIIIll)) {
                return new NBTTagByte((byte)1);
            }
            if ("false".equalsIgnoreCase(lllllllllllllIIIllIllllllIlIIIll)) {
                return new NBTTagByte((byte)0);
            }
        }
        catch (NumberFormatException ex) {}
        return new NBTTagString(lllllllllllllIIIllIllllllIlIIIll);
    }
    
    protected String func_193601_b() throws NBTException {
        this.func_193607_l();
        if (!this.func_193612_g()) {
            throw this.func_193602_b("Expected key");
        }
        return (this.func_193598_n() == '\"') ? this.func_193595_h() : this.func_193614_i();
    }
    
    protected NBTBase func_193610_d() throws NBTException {
        this.func_193607_l();
        if (!this.func_193612_g()) {
            throw this.func_193602_b("Expected value");
        }
        final char lllllllllllllIIIllIllllllIIIlIIl = this.func_193598_n();
        if (lllllllllllllIIIllIllllllIIIlIIl == '{') {
            return this.func_193593_f();
        }
        return (lllllllllllllIIIllIllllllIIIlIIl == '[') ? this.func_193605_e() : this.func_193611_c();
    }
    
    private void func_193607_l() {
        while (this.func_193612_g() && Character.isWhitespace(this.func_193598_n())) {
            ++this.field_193623_i;
        }
    }
    
    protected NBTTagCompound func_193593_f() throws NBTException {
        this.func_193604_b('{');
        final NBTTagCompound lllllllllllllIIIllIlllllIlllllll = new NBTTagCompound();
        this.func_193607_l();
        while (this.func_193612_g() && this.func_193598_n() != '}') {
            final String lllllllllllllIIIllIlllllIllllllI = this.func_193601_b();
            if (lllllllllllllIIIllIlllllIllllllI.isEmpty()) {
                throw this.func_193602_b("Expected non-empty key");
            }
            this.func_193604_b(':');
            lllllllllllllIIIllIlllllIlllllll.setTag(lllllllllllllIIIllIlllllIllllllI, this.func_193610_d());
            if (!this.func_193613_m()) {
                break;
            }
            if (!this.func_193612_g()) {
                throw this.func_193602_b("Expected key");
            }
        }
        this.func_193604_b('}');
        return lllllllllllllIIIllIlllllIlllllll;
    }
    
    private String func_193595_h() throws NBTException {
        final int lllllllllllllIIIllIllllllIIllIll = ++this.field_193623_i;
        StringBuilder lllllllllllllIIIllIllllllIIllIlI = null;
        boolean lllllllllllllIIIllIllllllIIllIIl = false;
        while (this.func_193612_g()) {
            final char lllllllllllllIIIllIllllllIIllIII = this.func_193594_o();
            if (lllllllllllllIIIllIllllllIIllIIl) {
                if (lllllllllllllIIIllIllllllIIllIII != '\\' && lllllllllllllIIIllIllllllIIllIII != '\"') {
                    throw this.func_193602_b(String.valueOf(new StringBuilder("Invalid escape of '").append(lllllllllllllIIIllIllllllIIllIII).append("'")));
                }
                lllllllllllllIIIllIllllllIIllIIl = false;
            }
            else if (lllllllllllllIIIllIllllllIIllIII == '\\') {
                lllllllllllllIIIllIllllllIIllIIl = true;
                if (lllllllllllllIIIllIllllllIIllIlI == null) {
                    lllllllllllllIIIllIllllllIIllIlI = new StringBuilder(this.field_193622_h.substring(lllllllllllllIIIllIllllllIIllIll, this.field_193623_i - 1));
                    continue;
                }
                continue;
            }
            else if (lllllllllllllIIIllIllllllIIllIII == '\"') {
                return (lllllllllllllIIIllIllllllIIllIlI == null) ? this.field_193622_h.substring(lllllllllllllIIIllIllllllIIllIll, this.field_193623_i - 1) : String.valueOf(lllllllllllllIIIllIllllllIIllIlI);
            }
            if (lllllllllllllIIIllIllllllIIllIlI != null) {
                lllllllllllllIIIllIllllllIIllIlI.append(lllllllllllllIIIllIllllllIIllIII);
            }
        }
        throw this.func_193602_b("Missing termination quote");
    }
    
    static {
        field_193615_a = Pattern.compile("[-+]?(?:[0-9]+[.]|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?", 2);
        field_193616_b = Pattern.compile("[-+]?(?:[0-9]+[.]?|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?d", 2);
        field_193617_c = Pattern.compile("[-+]?(?:[0-9]+[.]?|[0-9]*[.][0-9]+)(?:e[-+]?[0-9]+)?f", 2);
        field_193618_d = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)b", 2);
        field_193619_e = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)l", 2);
        field_193620_f = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)s", 2);
        field_193621_g = Pattern.compile("[-+]?(?:0|[1-9][0-9]*)");
    }
    
    private char func_193597_b(final int lllllllllllllIIIllIlllllIIllIlII) {
        return this.field_193622_h.charAt(this.field_193623_i + lllllllllllllIIIllIlllllIIllIlII);
    }
    
    private <T extends Number> List<T> func_193603_a(final byte lllllllllllllIIIllIlllllIlIllIII, final byte lllllllllllllIIIllIlllllIlIlIlll) throws NBTException {
        final List<T> lllllllllllllIIIllIlllllIlIlllII = (List<T>)Lists.newArrayList();
        while (this.func_193598_n() != ']') {
            final NBTBase lllllllllllllIIIllIlllllIlIllIll = this.func_193610_d();
            final int lllllllllllllIIIllIlllllIlIllIlI = lllllllllllllIIIllIlllllIlIllIll.getId();
            if (lllllllllllllIIIllIlllllIlIllIlI != lllllllllllllIIIllIlllllIlIlIlll) {
                throw this.func_193602_b(String.valueOf(new StringBuilder("Unable to insert ").append(NBTBase.func_193581_j(lllllllllllllIIIllIlllllIlIllIlI)).append(" into ").append(NBTBase.func_193581_j(lllllllllllllIIIllIlllllIlIllIII))));
            }
            if (lllllllllllllIIIllIlllllIlIlIlll == 1) {
                lllllllllllllIIIllIlllllIlIlllII.add((T)((NBTPrimitive)lllllllllllllIIIllIlllllIlIllIll).getByte());
            }
            else if (lllllllllllllIIIllIlllllIlIlIlll == 4) {
                lllllllllllllIIIllIlllllIlIlllII.add((T)((NBTPrimitive)lllllllllllllIIIllIlllllIlIllIll).getLong());
            }
            else {
                lllllllllllllIIIllIlllllIlIlllII.add((T)((NBTPrimitive)lllllllllllllIIIllIlllllIlIllIll).getInt());
            }
            if (!this.func_193613_m()) {
                break;
            }
            if (!this.func_193612_g()) {
                throw this.func_193602_b("Expected value");
            }
        }
        this.func_193604_b(']');
        return lllllllllllllIIIllIlllllIlIlllII;
    }
    
    boolean func_193612_g() {
        return this.func_193608_a(0);
    }
    
    @VisibleForTesting
    NBTTagCompound func_193609_a() throws NBTException {
        final NBTTagCompound lllllllllllllIIIllIllllllIllllll = this.func_193593_f();
        this.func_193607_l();
        if (this.func_193612_g()) {
            ++this.field_193623_i;
            throw this.func_193602_b("Trailing data found");
        }
        return lllllllllllllIIIllIllllllIllllll;
    }
    
    private String func_193614_i() {
        final int lllllllllllllIIIllIllllllIIIllll = this.field_193623_i;
        while (this.func_193612_g() && this.func_193599_a(this.func_193598_n())) {
            ++this.field_193623_i;
        }
        return this.field_193622_h.substring(lllllllllllllIIIllIllllllIIIllll, this.field_193623_i);
    }
    
    private NBTBase func_193600_j() throws NBTException {
        this.func_193604_b('[');
        this.func_193607_l();
        if (!this.func_193612_g()) {
            throw this.func_193602_b("Expected value");
        }
        final NBTTagList lllllllllllllIIIllIlllllIlllIlII = new NBTTagList();
        int lllllllllllllIIIllIlllllIlllIIll = -1;
        while (this.func_193598_n() != ']') {
            final NBTBase lllllllllllllIIIllIlllllIlllIIlI = this.func_193610_d();
            final int lllllllllllllIIIllIlllllIlllIIIl = lllllllllllllIIIllIlllllIlllIIlI.getId();
            if (lllllllllllllIIIllIlllllIlllIIll < 0) {
                lllllllllllllIIIllIlllllIlllIIll = lllllllllllllIIIllIlllllIlllIIIl;
            }
            else if (lllllllllllllIIIllIlllllIlllIIIl != lllllllllllllIIIllIlllllIlllIIll) {
                throw this.func_193602_b(String.valueOf(new StringBuilder("Unable to insert ").append(NBTBase.func_193581_j(lllllllllllllIIIllIlllllIlllIIIl)).append(" into ListTag of type ").append(NBTBase.func_193581_j(lllllllllllllIIIllIlllllIlllIIll))));
            }
            lllllllllllllIIIllIlllllIlllIlII.appendTag(lllllllllllllIIIllIlllllIlllIIlI);
            if (!this.func_193613_m()) {
                break;
            }
            if (!this.func_193612_g()) {
                throw this.func_193602_b("Expected value");
            }
        }
        this.func_193604_b(']');
        return lllllllllllllIIIllIlllllIlllIlII;
    }
    
    private boolean func_193613_m() {
        this.func_193607_l();
        if (this.func_193612_g() && this.func_193598_n() == ',') {
            ++this.field_193623_i;
            this.func_193607_l();
            return true;
        }
        return false;
    }
    
    private NBTException func_193602_b(final String lllllllllllllIIIllIllllllIlIlllI) {
        return new NBTException(lllllllllllllIIIllIllllllIlIlllI, this.field_193622_h, this.field_193623_i);
    }
    
    private char func_193594_o() {
        return this.field_193622_h.charAt(this.field_193623_i++);
    }
    
    public static NBTTagCompound getTagFromJson(final String lllllllllllllIIIllIlllllllIIIlII) throws NBTException {
        return new JsonToNBT(lllllllllllllIIIllIlllllllIIIlII).func_193609_a();
    }
    
    protected NBTBase func_193611_c() throws NBTException {
        this.func_193607_l();
        if (this.func_193598_n() == '\"') {
            return new NBTTagString(this.func_193595_h());
        }
        final String lllllllllllllIIIllIllllllIlIlIlI = this.func_193614_i();
        if (lllllllllllllIIIllIllllllIlIlIlI.isEmpty()) {
            throw this.func_193602_b("Expected value");
        }
        return this.func_193596_c(lllllllllllllIIIllIllllllIlIlIlI);
    }
    
    private char func_193598_n() {
        return this.func_193597_b(0);
    }
    
    protected boolean func_193599_a(final char lllllllllllllIIIllIlllllIlIIIIIl) {
        return (lllllllllllllIIIllIlllllIlIIIIIl >= '0' && lllllllllllllIIIllIlllllIlIIIIIl <= '9') || (lllllllllllllIIIllIlllllIlIIIIIl >= 'A' && lllllllllllllIIIllIlllllIlIIIIIl <= 'Z') || (lllllllllllllIIIllIlllllIlIIIIIl >= 'a' && lllllllllllllIIIllIlllllIlIIIIIl <= 'z') || lllllllllllllIIIllIlllllIlIIIIIl == '_' || lllllllllllllIIIllIlllllIlIIIIIl == '-' || lllllllllllllIIIllIlllllIlIIIIIl == '.' || lllllllllllllIIIllIlllllIlIIIIIl == '+';
    }
    
    @VisibleForTesting
    JsonToNBT(final String lllllllllllllIIIllIllllllIllIlll) {
        this.field_193622_h = lllllllllllllIIIllIllllllIllIlll;
    }
    
    protected NBTBase func_193605_e() throws NBTException {
        return (this.func_193608_a(2) && this.func_193597_b(1) != '\"' && this.func_193597_b(2) == ';') ? this.func_193606_k() : this.func_193600_j();
    }
    
    private boolean func_193608_a(final int lllllllllllllIIIllIlllllIIlllIll) {
        return this.field_193623_i + lllllllllllllIIIllIlllllIIlllIll < this.field_193622_h.length();
    }
}
