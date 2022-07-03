package de.gerrygames.viarewind.replacement;

import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class Replacement
{
    private /* synthetic */ String bracketName;
    private /* synthetic */ String name;
    private /* synthetic */ int id;
    private /* synthetic */ int data;
    private /* synthetic */ String resetName;
    
    public String getName() {
        return this.name;
    }
    
    public Item replace(final Item lllllllllllllIIIIlIIlIlIIIIIllII) {
        lllllllllllllIIIIlIIlIlIIIIIllII.setIdentifier(this.id);
        if (this.data != -1) {
            lllllllllllllIIIIlIIlIlIIIIIllII.setData((short)this.data);
        }
        if (this.name != null) {
            final CompoundTag lllllllllllllIIIIlIIlIlIIIIlIIIl = (lllllllllllllIIIIlIIlIlIIIIIllII.tag() == null) ? new CompoundTag() : lllllllllllllIIIIlIIlIlIIIIIllII.tag();
            if (!lllllllllllllIIIIlIIlIlIIIIlIIIl.contains("display")) {
                lllllllllllllIIIIlIIlIlIIIIlIIIl.put("display", new CompoundTag());
            }
            final CompoundTag lllllllllllllIIIIlIIlIlIIIIlIIII = lllllllllllllIIIIlIIlIlIIIIlIIIl.get("display");
            if (lllllllllllllIIIIlIIlIlIIIIlIIII.contains("Name")) {
                final StringTag lllllllllllllIIIIlIIlIlIIIIlIIlI = lllllllllllllIIIIlIIlIlIIIIlIIII.get("Name");
                if (!lllllllllllllIIIIlIIlIlIIIIlIIlI.getValue().equals(this.resetName) && !lllllllllllllIIIIlIIlIlIIIIlIIlI.getValue().endsWith(this.bracketName)) {
                    lllllllllllllIIIIlIIlIlIIIIlIIlI.setValue(String.valueOf(new StringBuilder().append(lllllllllllllIIIIlIIlIlIIIIlIIlI.getValue()).append(this.bracketName)));
                }
            }
            else {
                lllllllllllllIIIIlIIlIlIIIIlIIII.put("Name", new StringTag(this.resetName));
            }
            lllllllllllllIIIIlIIlIlIIIIIllII.setTag(lllllllllllllIIIIlIIlIlIIIIlIIIl);
        }
        return lllllllllllllIIIIlIIlIlIIIIIllII;
    }
    
    public Replacement(final int lllllllllllllIIIIlIIlIlIIIlllIlI, final int lllllllllllllIIIIlIIlIlIIIlllIIl) {
        this(lllllllllllllIIIIlIIlIlIIIlllIlI, lllllllllllllIIIIlIIlIlIIIlllIIl, null);
    }
    
    public Replacement(final int lllllllllllllIIIIlIIlIlIIIllIIIl, final String lllllllllllllIIIIlIIlIlIIIlIllIl) {
        this(lllllllllllllIIIIlIIlIlIIIllIIIl, -1, lllllllllllllIIIIlIIlIlIIIlIllIl);
    }
    
    public int replaceData(final int lllllllllllllIIIIlIIlIlIIIIIIIll) {
        return (this.data == -1) ? lllllllllllllIIIIlIIlIlIIIIIIIll : this.data;
    }
    
    public Replacement(final int lllllllllllllIIIIlIIlIlIIlIIIIIl) {
        this(lllllllllllllIIIIlIIlIlIIlIIIIIl, -1);
    }
    
    public Replacement(final int lllllllllllllIIIIlIIlIlIIIlIIlll, final int lllllllllllllIIIIlIIlIlIIIlIIllI, final String lllllllllllllIIIIlIIlIlIIIlIIlIl) {
        this.id = lllllllllllllIIIIlIIlIlIIIlIIlll;
        this.data = lllllllllllllIIIIlIIlIlIIIlIIllI;
        this.name = lllllllllllllIIIIlIIlIlIIIlIIlIl;
        if (lllllllllllllIIIIlIIlIlIIIlIIlIl != null) {
            this.resetName = String.valueOf(new StringBuilder().append("§r").append(lllllllllllllIIIIlIIlIlIIIlIIlIl));
            this.bracketName = String.valueOf(new StringBuilder().append(" §r§7(").append(lllllllllllllIIIIlIIlIlIIIlIIlIl).append("§r§7)"));
        }
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getData() {
        return this.data;
    }
}
