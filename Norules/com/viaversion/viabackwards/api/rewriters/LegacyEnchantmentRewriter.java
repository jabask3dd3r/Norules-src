package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;

public class LegacyEnchantmentRewriter
{
    private final /* synthetic */ Map<Short, String> enchantmentMappings;
    private final /* synthetic */ String nbtTagName;
    private /* synthetic */ Set<Short> hideLevelForEnchants;
    
    public LegacyEnchantmentRewriter(final String lllllllllllllIlIIlIlIlIlIlllIllI) {
        this.enchantmentMappings = new HashMap<Short, String>();
        this.nbtTagName = lllllllllllllIlIIlIlIlIlIlllIllI;
    }
    
    public void rewriteEnchantmentsToClient(final CompoundTag lllllllllllllIlIIlIlIlIlIlIIllIl, final boolean lllllllllllllIlIIlIlIlIlIlIIllII) {
        final String lllllllllllllIlIIlIlIlIlIlIlIIlI = lllllllllllllIlIIlIlIlIlIlIIllII ? "StoredEnchantments" : "ench";
        final ListTag lllllllllllllIlIIlIlIlIlIlIlIIIl = lllllllllllllIlIIlIlIlIlIlIIllIl.get(lllllllllllllIlIIlIlIlIlIlIlIIlI);
        final ListTag lllllllllllllIlIIlIlIlIlIlIlIIII = new ListTag(CompoundTag.class);
        final List<Tag> lllllllllllllIlIIlIlIlIlIlIIllll = new ArrayList<Tag>();
        for (final Tag lllllllllllllIlIIlIlIlIlIlIllIll : lllllllllllllIlIIlIlIlIlIlIlIIIl.clone()) {
            final Tag lllllllllllllIlIIlIlIlIlIlIllllI = ((CompoundTag)lllllllllllllIlIIlIlIlIlIlIllIll).get("id");
            if (lllllllllllllIlIIlIlIlIlIlIllllI == null) {
                continue;
            }
            final short lllllllllllllIlIIlIlIlIlIlIlllIl = ((NumberTag)lllllllllllllIlIIlIlIlIlIlIllllI).asShort();
            final String lllllllllllllIlIIlIlIlIlIlIlllII = this.enchantmentMappings.get(lllllllllllllIlIIlIlIlIlIlIlllIl);
            if (lllllllllllllIlIIlIlIlIlIlIlllII == null) {
                continue;
            }
            lllllllllllllIlIIlIlIlIlIlIlIIIl.remove(lllllllllllllIlIIlIlIlIlIlIllIll);
            final short lllllllllllllIlIIlIlIlIlIlIlllll = ((CompoundTag)lllllllllllllIlIIlIlIlIlIlIllIll).get("lvl").asShort();
            if (this.hideLevelForEnchants != null && this.hideLevelForEnchants.contains(lllllllllllllIlIIlIlIlIlIlIlllIl)) {
                lllllllllllllIlIIlIlIlIlIlIIllll.add(new StringTag(lllllllllllllIlIIlIlIlIlIlIlllII));
            }
            else {
                lllllllllllllIlIIlIlIlIlIlIIllll.add(new StringTag(String.valueOf(new StringBuilder().append(lllllllllllllIlIIlIlIlIlIlIlllII).append(" ").append(EnchantmentRewriter.getRomanNumber(lllllllllllllIlIIlIlIlIlIlIlllll)))));
            }
            lllllllllllllIlIIlIlIlIlIlIlIIII.add(lllllllllllllIlIIlIlIlIlIlIllIll);
        }
        if (!lllllllllllllIlIIlIlIlIlIlIIllll.isEmpty()) {
            if (!lllllllllllllIlIIlIlIlIlIlIIllII && lllllllllllllIlIIlIlIlIlIlIlIIIl.size() == 0) {
                final CompoundTag lllllllllllllIlIIlIlIlIlIlIllIlI = new CompoundTag();
                lllllllllllllIlIIlIlIlIlIlIllIlI.put("id", new ShortTag((short)0));
                lllllllllllllIlIIlIlIlIlIlIllIlI.put("lvl", new ShortTag((short)0));
                lllllllllllllIlIIlIlIlIlIlIlIIIl.add(lllllllllllllIlIIlIlIlIlIlIllIlI);
                lllllllllllllIlIIlIlIlIlIlIIllIl.put(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|dummyEnchant")), new ByteTag());
                IntTag lllllllllllllIlIIlIlIlIlIlIllIIl = lllllllllllllIlIIlIlIlIlIlIIllIl.get("HideFlags");
                if (lllllllllllllIlIIlIlIlIlIlIllIIl == null) {
                    lllllllllllllIlIIlIlIlIlIlIllIIl = new IntTag();
                }
                else {
                    lllllllllllllIlIIlIlIlIlIlIIllIl.put(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|oldHideFlags")), new IntTag(lllllllllllllIlIIlIlIlIlIlIllIIl.asByte()));
                }
                final int lllllllllllllIlIIlIlIlIlIlIllIII = lllllllllllllIlIIlIlIlIlIlIllIIl.asByte() | 0x1;
                lllllllllllllIlIIlIlIlIlIlIllIIl.setValue(lllllllllllllIlIIlIlIlIlIlIllIII);
                lllllllllllllIlIIlIlIlIlIlIIllIl.put("HideFlags", lllllllllllllIlIIlIlIlIlIlIllIIl);
            }
            lllllllllllllIlIIlIlIlIlIlIIllIl.put(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|").append(lllllllllllllIlIIlIlIlIlIlIlIIlI)), lllllllllllllIlIIlIlIlIlIlIlIIII);
            CompoundTag lllllllllllllIlIIlIlIlIlIlIlIlll = lllllllllllllIlIIlIlIlIlIlIIllIl.get("display");
            if (lllllllllllllIlIIlIlIlIlIlIlIlll == null) {
                lllllllllllllIlIIlIlIlIlIlIIllIl.put("display", lllllllllllllIlIIlIlIlIlIlIlIlll = new CompoundTag());
            }
            ListTag lllllllllllllIlIIlIlIlIlIlIlIllI = lllllllllllllIlIIlIlIlIlIlIlIlll.get("Lore");
            if (lllllllllllllIlIIlIlIlIlIlIlIllI == null) {
                lllllllllllllIlIIlIlIlIlIlIlIlll.put("Lore", lllllllllllllIlIIlIlIlIlIlIlIllI = new ListTag(StringTag.class));
            }
            lllllllllllllIlIIlIlIlIlIlIIllll.addAll(lllllllllllllIlIIlIlIlIlIlIlIllI.getValue());
            lllllllllllllIlIIlIlIlIlIlIlIllI.setValue(lllllllllllllIlIIlIlIlIlIlIIllll);
        }
    }
    
    public void rewriteEnchantmentsToServer(final CompoundTag lllllllllllllIlIIlIlIlIlIIlIlIIl, final boolean lllllllllllllIlIIlIlIlIlIIlIlIII) {
        final String lllllllllllllIlIIlIlIlIlIIlIllll = lllllllllllllIlIIlIlIlIlIIlIlIII ? "StoredEnchantments" : "ench";
        final ListTag lllllllllllllIlIIlIlIlIlIIlIlllI = lllllllllllllIlIIlIlIlIlIIlIlIIl.remove(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|").append(lllllllllllllIlIIlIlIlIlIIlIllll)));
        ListTag lllllllllllllIlIIlIlIlIlIIlIllIl = lllllllllllllIlIIlIlIlIlIIlIlIIl.get(lllllllllllllIlIIlIlIlIlIIlIllll);
        if (lllllllllllllIlIIlIlIlIlIIlIllIl == null) {
            lllllllllllllIlIIlIlIlIlIIlIllIl = new ListTag(CompoundTag.class);
        }
        if (!lllllllllllllIlIIlIlIlIlIIlIlIII && lllllllllllllIlIIlIlIlIlIIlIlIIl.remove(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|dummyEnchant"))) != null) {
            for (final Tag lllllllllllllIlIIlIlIlIlIIllIlIl : lllllllllllllIlIIlIlIlIlIIlIllIl.clone()) {
                final short lllllllllllllIlIIlIlIlIlIIllIlll = ((CompoundTag)lllllllllllllIlIIlIlIlIlIIllIlIl).get("id").asShort();
                final short lllllllllllllIlIIlIlIlIlIIllIllI = ((CompoundTag)lllllllllllllIlIIlIlIlIlIIllIlIl).get("lvl").asShort();
                if (lllllllllllllIlIIlIlIlIlIIllIlll == 0 && lllllllllllllIlIIlIlIlIlIIllIllI == 0) {
                    lllllllllllllIlIIlIlIlIlIIlIllIl.remove(lllllllllllllIlIIlIlIlIlIIllIlIl);
                }
            }
            final IntTag lllllllllllllIlIIlIlIlIlIIllIlII = lllllllllllllIlIIlIlIlIlIIlIlIIl.remove(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|oldHideFlags")));
            if (lllllllllllllIlIIlIlIlIlIIllIlII != null) {
                lllllllllllllIlIIlIlIlIlIIlIlIIl.put("HideFlags", new IntTag(lllllllllllllIlIIlIlIlIlIIllIlII.asByte()));
            }
            else {
                lllllllllllllIlIIlIlIlIlIIlIlIIl.remove("HideFlags");
            }
        }
        final CompoundTag lllllllllllllIlIIlIlIlIlIIlIllII = lllllllllllllIlIIlIlIlIlIIlIlIIl.get("display");
        final ListTag lllllllllllllIlIIlIlIlIlIIlIlIll = (lllllllllllllIlIIlIlIlIlIIlIllII != null) ? lllllllllllllIlIIlIlIlIlIIlIllII.get("Lore") : null;
        for (final Tag lllllllllllllIlIIlIlIlIlIIllIIll : lllllllllllllIlIIlIlIlIlIIlIlllI.clone()) {
            lllllllllllllIlIIlIlIlIlIIlIllIl.add(lllllllllllllIlIIlIlIlIlIIllIIll);
            if (lllllllllllllIlIIlIlIlIlIIlIlIll != null && lllllllllllllIlIIlIlIlIlIIlIlIll.size() != 0) {
                lllllllllllllIlIIlIlIlIlIIlIlIll.remove(lllllllllllllIlIIlIlIlIlIIlIlIll.get(0));
            }
        }
        if (lllllllllllllIlIIlIlIlIlIIlIlIll != null && lllllllllllllIlIIlIlIlIlIIlIlIll.size() == 0) {
            lllllllllllllIlIIlIlIlIlIIlIllII.remove("Lore");
            if (lllllllllllllIlIIlIlIlIlIIlIllII.isEmpty()) {
                lllllllllllllIlIIlIlIlIlIIlIlIIl.remove("display");
            }
        }
        lllllllllllllIlIIlIlIlIlIIlIlIIl.put(lllllllllllllIlIIlIlIlIlIIlIllll, lllllllllllllIlIIlIlIlIlIIlIllIl);
    }
    
    public void setHideLevelForEnchants(final int... lllllllllllllIlIIlIlIlIlIIIllIII) {
        this.hideLevelForEnchants = new HashSet<Short>();
        final short lllllllllllllIlIIlIlIlIlIIIlIlIl = (Object)lllllllllllllIlIIlIlIlIlIIIllIII;
        for (char lllllllllllllIlIIlIlIlIlIIIlIlII = (char)lllllllllllllIlIIlIlIlIlIIIlIlIl.length, lllllllllllllIlIIlIlIlIlIIIlIIll = '\0'; lllllllllllllIlIIlIlIlIlIIIlIIll < lllllllllllllIlIIlIlIlIlIIIlIlII; ++lllllllllllllIlIIlIlIlIlIIIlIIll) {
            final int lllllllllllllIlIIlIlIlIlIIIllIlI = lllllllllllllIlIIlIlIlIlIIIlIlIl[lllllllllllllIlIIlIlIlIlIIIlIIll];
            this.hideLevelForEnchants.add((short)lllllllllllllIlIIlIlIlIlIIIllIlI);
        }
    }
    
    public void registerEnchantment(final int lllllllllllllIlIIlIlIlIlIllIlllI, final String lllllllllllllIlIIlIlIlIlIlllIIII) {
        this.enchantmentMappings.put((short)lllllllllllllIlIIlIlIlIlIllIlllI, lllllllllllllIlIIlIlIlIlIlllIIII);
    }
}
