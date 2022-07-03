package optifine;

import java.util.regex.*;
import org.apache.commons.lang3.*;
import net.minecraft.nbt.*;
import java.util.*;

public class NbtTagValue
{
    private /* synthetic */ String[] parents;
    private /* synthetic */ boolean negative;
    private /* synthetic */ String value;
    private /* synthetic */ int type;
    private /* synthetic */ String name;
    private static final /* synthetic */ Pattern PATTERN_HEX_COLOR;
    private /* synthetic */ int valueFormat;
    
    public NbtTagValue(final String lllllllllllllIIIIlIIlllIIIIlIIll, String lllllllllllllIIIIlIIlllIIIIlIIlI) {
        this.parents = null;
        this.name = null;
        this.negative = false;
        this.type = 0;
        this.value = null;
        this.valueFormat = 0;
        final String[] lllllllllllllIIIIlIIlllIIIIlIlIl = Config.tokenize(lllllllllllllIIIIlIIlllIIIIlIIll, ".");
        this.parents = Arrays.copyOfRange(lllllllllllllIIIIlIIlllIIIIlIlIl, 0, lllllllllllllIIIIlIIlllIIIIlIlIl.length - 1);
        this.name = lllllllllllllIIIIlIIlllIIIIlIlIl[lllllllllllllIIIIlIIlllIIIIlIlIl.length - 1];
        if (((String)lllllllllllllIIIIlIIlllIIIIlIIlI).startsWith("!")) {
            this.negative = true;
            lllllllllllllIIIIlIIlllIIIIlIIlI = ((String)lllllllllllllIIIIlIIlllIIIIlIIlI).substring(1);
        }
        if (((String)lllllllllllllIIIIlIIlllIIIIlIIlI).startsWith("pattern:")) {
            this.type = 1;
            lllllllllllllIIIIlIIlllIIIIlIIlI = ((String)lllllllllllllIIIIlIIlllIIIIlIIlI).substring("pattern:".length());
        }
        else if (((String)lllllllllllllIIIIlIIlllIIIIlIIlI).startsWith("ipattern:")) {
            this.type = 2;
            lllllllllllllIIIIlIIlllIIIIlIIlI = ((String)lllllllllllllIIIIlIIlllIIIIlIIlI).substring("ipattern:".length()).toLowerCase();
        }
        else if (((String)lllllllllllllIIIIlIIlllIIIIlIIlI).startsWith("regex:")) {
            this.type = 3;
            lllllllllllllIIIIlIIlllIIIIlIIlI = ((String)lllllllllllllIIIIlIIlllIIIIlIIlI).substring("regex:".length());
        }
        else if (((String)lllllllllllllIIIIlIIlllIIIIlIIlI).startsWith("iregex:")) {
            this.type = 4;
            lllllllllllllIIIIlIIlllIIIIlIIlI = ((String)lllllllllllllIIIIlIIlllIIIIlIIlI).substring("iregex:".length()).toLowerCase();
        }
        else {
            this.type = 0;
        }
        lllllllllllllIIIIlIIlllIIIIlIIlI = StringEscapeUtils.unescapeJava((String)lllllllllllllIIIIlIIlllIIIIlIIlI);
        if (this.type == 0 && NbtTagValue.PATTERN_HEX_COLOR.matcher((CharSequence)lllllllllllllIIIIlIIlllIIIIlIIlI).matches()) {
            this.valueFormat = 1;
        }
        this.value = (String)lllllllllllllIIIIlIIlllIIIIlIIlI;
    }
    
    private static String getNbtString(final NBTBase lllllllllllllIIIIlIIllIllIllIIII, final int lllllllllllllIIIIlIIllIllIlllIII) {
        if (lllllllllllllIIIIlIIllIllIllIIII == null) {
            return null;
        }
        if (lllllllllllllIIIIlIIllIllIllIIII instanceof NBTTagString) {
            final NBTTagString lllllllllllllIIIIlIIllIllIllIlll = (NBTTagString)lllllllllllllIIIIlIIllIllIllIIII;
            return lllllllllllllIIIIlIIllIllIllIlll.getString();
        }
        if (lllllllllllllIIIIlIIllIllIllIIII instanceof NBTTagInt) {
            final NBTTagInt lllllllllllllIIIIlIIllIllIllIllI = (NBTTagInt)lllllllllllllIIIIlIIllIllIllIIII;
            return (lllllllllllllIIIIlIIllIllIlllIII == 1) ? String.valueOf(new StringBuilder("#").append(StrUtils.fillLeft(Integer.toHexString(lllllllllllllIIIIlIIllIllIllIllI.getInt()), 6, '0'))) : Integer.toString(lllllllllllllIIIIlIIllIllIllIllI.getInt());
        }
        if (lllllllllllllIIIIlIIllIllIllIIII instanceof NBTTagByte) {
            final NBTTagByte lllllllllllllIIIIlIIllIllIllIlIl = (NBTTagByte)lllllllllllllIIIIlIIllIllIllIIII;
            return Byte.toString(lllllllllllllIIIIlIIllIllIllIlIl.getByte());
        }
        if (lllllllllllllIIIIlIIllIllIllIIII instanceof NBTTagShort) {
            final NBTTagShort lllllllllllllIIIIlIIllIllIllIlII = (NBTTagShort)lllllllllllllIIIIlIIllIllIllIIII;
            return Short.toString(lllllllllllllIIIIlIIllIllIllIlII.getShort());
        }
        if (lllllllllllllIIIIlIIllIllIllIIII instanceof NBTTagLong) {
            final NBTTagLong lllllllllllllIIIIlIIllIllIllIIll = (NBTTagLong)lllllllllllllIIIIlIIllIllIllIIII;
            return Long.toString(lllllllllllllIIIIlIIllIllIllIIll.getLong());
        }
        if (lllllllllllllIIIIlIIllIllIllIIII instanceof NBTTagFloat) {
            final NBTTagFloat lllllllllllllIIIIlIIllIllIllIIlI = (NBTTagFloat)lllllllllllllIIIIlIIllIllIllIIII;
            return Float.toString(lllllllllllllIIIIlIIllIllIllIIlI.getFloat());
        }
        if (lllllllllllllIIIIlIIllIllIllIIII instanceof NBTTagDouble) {
            final NBTTagDouble lllllllllllllIIIIlIIllIllIllIIIl = (NBTTagDouble)lllllllllllllIIIIlIIllIllIllIIII;
            return Double.toString(lllllllllllllIIIIlIIllIllIllIIIl.getDouble());
        }
        return lllllllllllllIIIIlIIllIllIllIIII.toString();
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIIIIlIIllIllIlIlIII = new StringBuffer();
        for (int lllllllllllllIIIIlIIllIllIlIIlll = 0; lllllllllllllIIIIlIIllIllIlIIlll < this.parents.length; ++lllllllllllllIIIIlIIllIllIlIIlll) {
            final String lllllllllllllIIIIlIIllIllIlIIllI = this.parents[lllllllllllllIIIIlIIllIllIlIIlll];
            if (lllllllllllllIIIIlIIllIllIlIIlll > 0) {
                lllllllllllllIIIIlIIllIllIlIlIII.append(".");
            }
            lllllllllllllIIIIlIIllIllIlIlIII.append(lllllllllllllIIIIlIIllIllIlIIllI);
        }
        if (lllllllllllllIIIIlIIllIllIlIlIII.length() > 0) {
            lllllllllllllIIIIlIIllIllIlIlIII.append(".");
        }
        lllllllllllllIIIIlIIllIllIlIlIII.append(this.name);
        lllllllllllllIIIIlIIllIllIlIlIII.append(" = ");
        lllllllllllllIIIIlIIllIllIlIlIII.append(this.value);
        return lllllllllllllIIIIlIIllIllIlIlIII.toString();
    }
    
    private boolean matchesAnyChild(final NBTBase lllllllllllllIIIIlIIllIllllIlIll) {
        if (lllllllllllllIIIIlIIllIllllIlIll instanceof NBTTagCompound) {
            final NBTTagCompound lllllllllllllIIIIlIIllIlllllIIll = (NBTTagCompound)lllllllllllllIIIIlIIllIllllIlIll;
            for (final String lllllllllllllIIIIlIIllIlllllIIlI : lllllllllllllIIIIlIIllIlllllIIll.getKeySet()) {
                final NBTBase lllllllllllllIIIIlIIllIlllllIIIl = lllllllllllllIIIIlIIllIlllllIIll.getTag(lllllllllllllIIIIlIIllIlllllIIlI);
                if (this.matchesBase(lllllllllllllIIIIlIIllIlllllIIIl)) {
                    return true;
                }
            }
        }
        if (lllllllllllllIIIIlIIllIllllIlIll instanceof NBTTagList) {
            final NBTTagList lllllllllllllIIIIlIIllIlllllIIII = (NBTTagList)lllllllllllllIIIIlIIllIllllIlIll;
            for (int lllllllllllllIIIIlIIllIllllIllll = lllllllllllllIIIIlIIllIlllllIIII.tagCount(), lllllllllllllIIIIlIIllIllllIlllI = 0; lllllllllllllIIIIlIIllIllllIlllI < lllllllllllllIIIIlIIllIllllIllll; ++lllllllllllllIIIIlIIllIllllIlllI) {
                final NBTBase lllllllllllllIIIIlIIllIllllIllIl = lllllllllllllIIIIlIIllIlllllIIII.get(lllllllllllllIIIIlIIllIllllIlllI);
                if (this.matchesBase(lllllllllllllIIIIlIIllIllllIllIl)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean matchesCompound(final NBTTagCompound lllllllllllllIIIIlIIlllIIIIIIlII) {
        if (lllllllllllllIIIIlIIlllIIIIIIlII == null) {
            return false;
        }
        NBTBase lllllllllllllIIIIlIIlllIIIIIIIll = lllllllllllllIIIIlIIlllIIIIIIlII;
        for (int lllllllllllllIIIIlIIlllIIIIIIIlI = 0; lllllllllllllIIIIlIIlllIIIIIIIlI < this.parents.length; ++lllllllllllllIIIIlIIlllIIIIIIIlI) {
            final String lllllllllllllIIIIlIIlllIIIIIIIIl = this.parents[lllllllllllllIIIIlIIlllIIIIIIIlI];
            lllllllllllllIIIIlIIlllIIIIIIIll = getChildTag(lllllllllllllIIIIlIIlllIIIIIIIll, lllllllllllllIIIIlIIlllIIIIIIIIl);
            if (lllllllllllllIIIIlIIlllIIIIIIIll == null) {
                return false;
            }
        }
        if (this.name.equals("*")) {
            return this.matchesAnyChild(lllllllllllllIIIIlIIlllIIIIIIIll);
        }
        lllllllllllllIIIIlIIlllIIIIIIIll = getChildTag(lllllllllllllIIIIlIIlllIIIIIIIll, this.name);
        return lllllllllllllIIIIlIIlllIIIIIIIll != null && this.matchesBase(lllllllllllllIIIIlIIlllIIIIIIIll);
    }
    
    private boolean matchesPattern(final String lllllllllllllIIIIlIIllIlllIIIlIl, final String lllllllllllllIIIIlIIllIlllIIIllI) {
        return StrUtils.equalsMask(lllllllllllllIIIIlIIllIlllIIIlIl, lllllllllllllIIIIlIIllIlllIIIllI, '*', '?');
    }
    
    static {
        PREFIX_PATTERN = "pattern:";
        TYPE_TEXT = 0;
        FORMAT_HEX_COLOR = 1;
        PREFIX_IREGEX = "iregex:";
        FORMAT_DEFAULT = 0;
        PREFIX_IPATTERN = "ipattern:";
        PREFIX_HEX_COLOR = "#";
        TYPE_IPATTERN = 2;
        TYPE_REGEX = 3;
        TYPE_IREGEX = 4;
        TYPE_PATTERN = 1;
        PREFIX_REGEX = "regex:";
        PATTERN_HEX_COLOR = Pattern.compile("^#[0-9a-f]{6}+$");
    }
    
    public boolean matchesBase(final NBTBase lllllllllllllIIIIlIIllIlllIlIIlI) {
        if (lllllllllllllIIIIlIIllIlllIlIIlI == null) {
            return false;
        }
        final String lllllllllllllIIIIlIIllIlllIlIlII = getNbtString(lllllllllllllIIIIlIIllIlllIlIIlI, this.valueFormat);
        return this.matchesValue(lllllllllllllIIIIlIIllIlllIlIlII);
    }
    
    public boolean matchesValue(final String lllllllllllllIIIIlIIllIlllIIlIll) {
        if (lllllllllllllIIIIlIIllIlllIIlIll == null) {
            return false;
        }
        switch (this.type) {
            case 0: {
                return lllllllllllllIIIIlIIllIlllIIlIll.equals(this.value);
            }
            case 1: {
                return this.matchesPattern(lllllllllllllIIIIlIIllIlllIIlIll, this.value);
            }
            case 2: {
                return this.matchesPattern(lllllllllllllIIIIlIIllIlllIIlIll.toLowerCase(), this.value);
            }
            case 3: {
                return this.matchesRegex(lllllllllllllIIIIlIIllIlllIIlIll, this.value);
            }
            case 4: {
                return this.matchesRegex(lllllllllllllIIIIlIIllIlllIIlIll.toLowerCase(), this.value);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown NbtTagValue type: ").append(this.type)));
            }
        }
    }
    
    private boolean matchesRegex(final String lllllllllllllIIIIlIIllIllIlllllI, final String lllllllllllllIIIIlIIllIllIllllll) {
        return lllllllllllllIIIIlIIllIllIlllllI.matches(lllllllllllllIIIIlIIllIllIllllll);
    }
    
    public boolean matches(final NBTTagCompound lllllllllllllIIIIlIIlllIIIIIllIl) {
        if (this.negative) {
            return !this.matchesCompound(lllllllllllllIIIIlIIlllIIIIIllIl);
        }
        return this.matchesCompound(lllllllllllllIIIIlIIlllIIIIIllIl);
    }
    
    private static NBTBase getChildTag(final NBTBase lllllllllllllIIIIlIIllIlllIlllIl, final String lllllllllllllIIIIlIIllIlllIlllII) {
        if (lllllllllllllIIIIlIIllIlllIlllIl instanceof NBTTagCompound) {
            final NBTTagCompound lllllllllllllIIIIlIIllIllllIIIII = (NBTTagCompound)lllllllllllllIIIIlIIllIlllIlllIl;
            return lllllllllllllIIIIlIIllIllllIIIII.getTag(lllllllllllllIIIIlIIllIlllIlllII);
        }
        if (!(lllllllllllllIIIIlIIllIlllIlllIl instanceof NBTTagList)) {
            return null;
        }
        final NBTTagList lllllllllllllIIIIlIIllIlllIlllll = (NBTTagList)lllllllllllllIIIIlIIllIlllIlllIl;
        if (lllllllllllllIIIIlIIllIlllIlllII.equals("count")) {
            return new NBTTagInt(lllllllllllllIIIIlIIllIlllIlllll.tagCount());
        }
        final int lllllllllllllIIIIlIIllIlllIllllI = Config.parseInt(lllllllllllllIIIIlIIllIlllIlllII, -1);
        return (lllllllllllllIIIIlIIllIlllIllllI < 0) ? null : lllllllllllllIIIIlIIllIlllIlllll.get(lllllllllllllIIIIlIIllIlllIllllI);
    }
}
