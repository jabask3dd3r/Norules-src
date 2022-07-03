package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import java.util.*;

public class EnchantmentRewriter
{
    private final /* synthetic */ Map<String, String> enchantmentMappings;
    private final /* synthetic */ boolean jsonFormat;
    private final /* synthetic */ ItemRewriter itemRewriter;
    
    public void rewriteEnchantmentsToServer(final CompoundTag llllllllllllllIIlllIIIlIlIllllll, final boolean llllllllllllllIIlllIIIlIlIlllllI) {
        final String llllllllllllllIIlllIIIlIlIllllIl = llllllllllllllIIlllIIIlIlIlllllI ? "StoredEnchantments" : "Enchantments";
        this.itemRewriter.restoreListTag(llllllllllllllIIlllIIIlIlIllllll, llllllllllllllIIlllIIIlIlIllllIl);
    }
    
    public EnchantmentRewriter(final ItemRewriter llllllllllllllIIlllIIIllIIIIllll) {
        this(llllllllllllllIIlllIIIllIIIIllll, true);
    }
    
    public void rewriteEnchantmentsToClient(final CompoundTag llllllllllllllIIlllIIIlIllIlIIIl, final boolean llllllllllllllIIlllIIIlIllIllIII) {
        final String llllllllllllllIIlllIIIlIllIlIlll = llllllllllllllIIlllIIIlIllIllIII ? "StoredEnchantments" : "Enchantments";
        final ListTag llllllllllllllIIlllIIIlIllIlIllI = llllllllllllllIIlllIIIlIllIlIIIl.get(llllllllllllllIIlllIIIlIllIlIlll);
        final List<Tag> llllllllllllllIIlllIIIlIllIlIlIl = new ArrayList<Tag>();
        boolean llllllllllllllIIlllIIIlIllIlIlII = false;
        final Iterator<Tag> llllllllllllllIIlllIIIlIllIlIIll = llllllllllllllIIlllIIIlIllIlIllI.iterator();
        while (llllllllllllllIIlllIIIlIllIlIIll.hasNext()) {
            final CompoundTag llllllllllllllIIlllIIIlIlllIIIIl = llllllllllllllIIlllIIIlIllIlIIll.next();
            final StringTag llllllllllllllIIlllIIIlIlllIIIII = llllllllllllllIIlllIIIlIlllIIIIl.get("id");
            if (llllllllllllllIIlllIIIlIlllIIIII == null) {
                continue;
            }
            final String llllllllllllllIIlllIIIlIllIlllll = llllllllllllllIIlllIIIlIlllIIIII.getValue();
            final String llllllllllllllIIlllIIIlIllIllllI = this.enchantmentMappings.get(llllllllllllllIIlllIIIlIllIlllll);
            if (llllllllllllllIIlllIIIlIllIllllI == null) {
                continue;
            }
            if (!llllllllllllllIIlllIIIlIllIlIlII) {
                this.itemRewriter.saveListTag(llllllllllllllIIlllIIIlIllIlIIIl, llllllllllllllIIlllIIIlIllIlIllI, llllllllllllllIIlllIIIlIllIlIlll);
                llllllllllllllIIlllIIIlIllIlIlII = true;
            }
            llllllllllllllIIlllIIIlIllIlIIll.remove();
            final int llllllllllllllIIlllIIIlIlllIIIll = llllllllllllllIIlllIIIlIlllIIIIl.get("lvl").asInt();
            String llllllllllllllIIlllIIIlIlllIIIlI = String.valueOf(new StringBuilder().append(llllllllllllllIIlllIIIlIllIllllI).append(" ").append(getRomanNumber(llllllllllllllIIlllIIIlIlllIIIll)));
            if (this.jsonFormat) {
                llllllllllllllIIlllIIIlIlllIIIlI = ChatRewriter.legacyTextToJsonString(llllllllllllllIIlllIIIlIlllIIIlI);
            }
            llllllllllllllIIlllIIIlIllIlIlIl.add(new StringTag(llllllllllllllIIlllIIIlIlllIIIlI));
        }
        if (!llllllllllllllIIlllIIIlIllIlIlIl.isEmpty()) {
            if (!llllllllllllllIIlllIIIlIllIllIII && llllllllllllllIIlllIIIlIllIlIllI.size() == 0) {
                final CompoundTag llllllllllllllIIlllIIIlIllIlllIl = new CompoundTag();
                llllllllllllllIIlllIIIlIllIlllIl.put("id", new StringTag());
                llllllllllllllIIlllIIIlIllIlllIl.put("lvl", new ShortTag((short)0));
                llllllllllllllIIlllIIIlIllIlIllI.add(llllllllllllllIIlllIIIlIllIlllIl);
            }
            CompoundTag llllllllllllllIIlllIIIlIllIlllII = llllllllllllllIIlllIIIlIllIlIIIl.get("display");
            if (llllllllllllllIIlllIIIlIllIlllII == null) {
                llllllllllllllIIlllIIIlIllIlIIIl.put("display", llllllllllllllIIlllIIIlIllIlllII = new CompoundTag());
            }
            ListTag llllllllllllllIIlllIIIlIllIllIll = llllllllllllllIIlllIIIlIllIlllII.get("Lore");
            if (llllllllllllllIIlllIIIlIllIllIll == null) {
                llllllllllllllIIlllIIIlIllIlllII.put("Lore", llllllllllllllIIlllIIIlIllIllIll = new ListTag(StringTag.class));
            }
            else {
                this.itemRewriter.saveListTag(llllllllllllllIIlllIIIlIllIlllII, llllllllllllllIIlllIIIlIllIllIll, "Lore");
            }
            llllllllllllllIIlllIIIlIllIlIlIl.addAll(llllllllllllllIIlllIIIlIllIllIll.getValue());
            llllllllllllllIIlllIIIlIllIllIll.setValue(llllllllllllllIIlllIIIlIllIlIlIl);
        }
    }
    
    public void handleToClient(final Item llllllllllllllIIlllIIIlIllllllll) {
        final CompoundTag llllllllllllllIIlllIIIlIlllllllI = llllllllllllllIIlllIIIlIllllllll.tag();
        if (llllllllllllllIIlllIIIlIlllllllI == null) {
            return;
        }
        if (llllllllllllllIIlllIIIlIlllllllI.get("Enchantments") instanceof ListTag) {
            this.rewriteEnchantmentsToClient(llllllllllllllIIlllIIIlIlllllllI, false);
        }
        if (llllllllllllllIIlllIIIlIlllllllI.get("StoredEnchantments") instanceof ListTag) {
            this.rewriteEnchantmentsToClient(llllllllllllllIIlllIIIlIlllllllI, true);
        }
    }
    
    public void registerEnchantment(final String llllllllllllllIIlllIIIllIIIIIlIl, final String llllllllllllllIIlllIIIllIIIIIlll) {
        this.enchantmentMappings.put(llllllllllllllIIlllIIIllIIIIIlIl, llllllllllllllIIlllIIIllIIIIIlll);
    }
    
    public static String getRomanNumber(final int llllllllllllllIIlllIIIlIlIllIlll) {
        switch (llllllllllllllIIlllIIIlIlIllIlll) {
            case 1: {
                return "I";
            }
            case 2: {
                return "II";
            }
            case 3: {
                return "III";
            }
            case 4: {
                return "IV";
            }
            case 5: {
                return "V";
            }
            case 6: {
                return "VI";
            }
            case 7: {
                return "VII";
            }
            case 8: {
                return "VIII";
            }
            case 9: {
                return "IX";
            }
            case 10: {
                return "X";
            }
            default: {
                return Integer.toString(llllllllllllllIIlllIIIlIlIllIlll);
            }
        }
    }
    
    public void handleToServer(final Item llllllllllllllIIlllIIIlIllllIIll) {
        final CompoundTag llllllllllllllIIlllIIIlIllllIlIl = llllllllllllllIIlllIIIlIllllIIll.tag();
        if (llllllllllllllIIlllIIIlIllllIlIl == null) {
            return;
        }
        if (llllllllllllllIIlllIIIlIllllIlIl.contains(String.valueOf(new StringBuilder().append(this.itemRewriter.getNbtTagName()).append("|Enchantments")))) {
            this.rewriteEnchantmentsToServer(llllllllllllllIIlllIIIlIllllIlIl, false);
        }
        if (llllllllllllllIIlllIIIlIllllIlIl.contains(String.valueOf(new StringBuilder().append(this.itemRewriter.getNbtTagName()).append("|StoredEnchantments")))) {
            this.rewriteEnchantmentsToServer(llllllllllllllIIlllIIIlIllllIlIl, true);
        }
    }
    
    public EnchantmentRewriter(final ItemRewriter llllllllllllllIIlllIIIllIIIlIlll, final boolean llllllllllllllIIlllIIIllIIIlIllI) {
        this.enchantmentMappings = new HashMap<String, String>();
        this.itemRewriter = llllllllllllllIIlllIIIllIIIlIlll;
        this.jsonFormat = llllllllllllllIIlllIIIllIIIlIllI;
    }
}
