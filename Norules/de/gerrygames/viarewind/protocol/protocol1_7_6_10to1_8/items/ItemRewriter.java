package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items;

import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import de.gerrygames.viarewind.utils.*;
import java.util.*;

public class ItemRewriter
{
    public static Item toServer(final Item llllllllllllIlllllIIIIIlIIIllIII) {
        if (llllllllllllIlllllIIIIIlIIIllIII == null) {
            return null;
        }
        final CompoundTag llllllllllllIlllllIIIIIlIIIllIlI = llllllllllllIlllllIIIIIlIIIllIII.tag();
        if (llllllllllllIlllllIIIIIlIIIllIlI == null || !llllllllllllIlllllIIIIIlIIIllIII.tag().contains("ViaRewind1_7_6_10to1_8")) {
            return llllllllllllIlllllIIIIIlIIIllIII;
        }
        final CompoundTag llllllllllllIlllllIIIIIlIIIllIIl = llllllllllllIlllllIIIIIlIIIllIlI.remove("ViaRewind1_7_6_10to1_8");
        llllllllllllIlllllIIIIIlIIIllIII.setIdentifier((short)llllllllllllIlllllIIIIIlIIIllIIl.get("id").getValue());
        llllllllllllIlllllIIIIIlIIIllIII.setData((short)llllllllllllIlllllIIIIIlIIIllIIl.get("data").getValue());
        if (llllllllllllIlllllIIIIIlIIIllIIl.contains("noDisplay")) {
            llllllllllllIlllllIIIIIlIIIllIlI.remove("display");
        }
        if (llllllllllllIlllllIIIIIlIIIllIIl.contains("displayName")) {
            CompoundTag llllllllllllIlllllIIIIIlIIIllllI = llllllllllllIlllllIIIIIlIIIllIlI.get("display");
            if (llllllllllllIlllllIIIIIlIIIllllI == null) {
                llllllllllllIlllllIIIIIlIIIllIlI.put("display", llllllllllllIlllllIIIIIlIIIllllI = new CompoundTag());
            }
            final StringTag llllllllllllIlllllIIIIIlIIIlllIl = llllllllllllIlllllIIIIIlIIIllllI.get("Name");
            if (llllllllllllIlllllIIIIIlIIIlllIl == null) {
                llllllllllllIlllllIIIIIlIIIllllI.put("Name", new StringTag((String)llllllllllllIlllllIIIIIlIIIllIIl.get("displayName").getValue()));
            }
            else {
                llllllllllllIlllllIIIIIlIIIlllIl.setValue((String)llllllllllllIlllllIIIIIlIIIllIIl.get("displayName").getValue());
            }
        }
        else if (llllllllllllIlllllIIIIIlIIIllIlI.contains("display")) {
            llllllllllllIlllllIIIIIlIIIllIlI.get("display").remove("Name");
        }
        if (llllllllllllIlllllIIIIIlIIIllIII.identifier() == 387) {
            final ListTag llllllllllllIlllllIIIIIlIIIlllII = llllllllllllIlllllIIIIIlIIIllIIl.get("pages");
            llllllllllllIlllllIIIIIlIIIllIlI.remove("pages");
            llllllllllllIlllllIIIIIlIIIllIlI.put("pages", llllllllllllIlllllIIIIIlIIIlllII);
        }
        return llllllllllllIlllllIIIIIlIIIllIII;
    }
    
    public static Item toClient(final Item llllllllllllIlllllIIIIIlIIlIlllI) {
        if (llllllllllllIlllllIIIIIlIIlIlllI == null) {
            return null;
        }
        CompoundTag llllllllllllIlllllIIIIIlIIllIIIl = llllllllllllIlllllIIIIIlIIlIlllI.tag();
        if (llllllllllllIlllllIIIIIlIIllIIIl == null) {
            llllllllllllIlllllIIIIIlIIlIlllI.setTag(llllllllllllIlllllIIIIIlIIllIIIl = new CompoundTag());
        }
        final CompoundTag llllllllllllIlllllIIIIIlIIllIIII = new CompoundTag();
        llllllllllllIlllllIIIIIlIIllIIIl.put("ViaRewind1_7_6_10to1_8", llllllllllllIlllllIIIIIlIIllIIII);
        llllllllllllIlllllIIIIIlIIllIIII.put("id", new ShortTag((short)llllllllllllIlllllIIIIIlIIlIlllI.identifier()));
        llllllllllllIlllllIIIIIlIIllIIII.put("data", new ShortTag(llllllllllllIlllllIIIIIlIIlIlllI.data()));
        CompoundTag llllllllllllIlllllIIIIIlIIlIllll = llllllllllllIlllllIIIIIlIIllIIIl.get("display");
        if (llllllllllllIlllllIIIIIlIIlIllll != null && llllllllllllIlllllIIIIIlIIlIllll.contains("Name")) {
            llllllllllllIlllllIIIIIlIIllIIII.put("displayName", new StringTag((String)llllllllllllIlllllIIIIIlIIlIllll.get("Name").getValue()));
        }
        if (llllllllllllIlllllIIIIIlIIlIllll != null && llllllllllllIlllllIIIIIlIIlIllll.contains("Lore")) {
            llllllllllllIlllllIIIIIlIIllIIII.put("lore", new ListTag(llllllllllllIlllllIIIIIlIIlIllll.get("Lore").getValue()));
        }
        if (llllllllllllIlllllIIIIIlIIllIIIl.contains("ench") || llllllllllllIlllllIIIIIlIIllIIIl.contains("StoredEnchantments")) {
            final ListTag llllllllllllIlllllIIIIIlIIlllIIl = llllllllllllIlllllIIIIIlIIllIIIl.contains("ench") ? llllllllllllIlllllIIIIIlIIllIIIl.get("ench") : llllllllllllIlllllIIIIIlIIllIIIl.get("StoredEnchantments");
            final List<Tag> llllllllllllIlllllIIIIIlIIlllIII = new ArrayList<Tag>();
            for (final Tag llllllllllllIlllllIIIIIlIIlllIll : new ArrayList<Tag>(llllllllllllIlllllIIIIIlIIlllIIl.getValue())) {
                final short llllllllllllIlllllIIIIIlIIlllllI = ((CompoundTag)llllllllllllIlllllIIIIIlIIlllIll).get("id").asShort();
                final short llllllllllllIlllllIIIIIlIIllllIl = ((CompoundTag)llllllllllllIlllllIIIIIlIIlllIll).get("lvl").asShort();
                if (llllllllllllIlllllIIIIIlIIlllllI == 8) {
                    String llllllllllllIlllllIIIIIlIIllllII = "§r§7Depth Strider ";
                    llllllllllllIlllllIIIIIlIIlllIIl.remove(llllllllllllIlllllIIIIIlIIlllIll);
                    llllllllllllIlllllIIIIIlIIllllII = String.valueOf(new StringBuilder().append(llllllllllllIlllllIIIIIlIIllllII).append(Enchantments.ENCHANTMENTS.getOrDefault(llllllllllllIlllllIIIIIlIIllllIl, String.valueOf(new StringBuilder().append("enchantment.level.").append(llllllllllllIlllllIIIIIlIIllllIl)))));
                    llllllllllllIlllllIIIIIlIIlllIII.add(new StringTag(llllllllllllIlllllIIIIIlIIllllII));
                }
            }
            if (!llllllllllllIlllllIIIIIlIIlllIII.isEmpty()) {
                if (llllllllllllIlllllIIIIIlIIlIllll == null) {
                    llllllllllllIlllllIIIIIlIIllIIIl.put("display", llllllllllllIlllllIIIIIlIIlIllll = new CompoundTag());
                    llllllllllllIlllllIIIIIlIIllIIII.put("noDisplay", new ByteTag());
                }
                ListTag llllllllllllIlllllIIIIIlIIlllIlI = llllllllllllIlllllIIIIIlIIlIllll.get("Lore");
                if (llllllllllllIlllllIIIIIlIIlllIlI == null) {
                    llllllllllllIlllllIIIIIlIIlIllll.put("Lore", llllllllllllIlllllIIIIIlIIlllIlI = new ListTag(StringTag.class));
                }
                llllllllllllIlllllIIIIIlIIlllIII.addAll(llllllllllllIlllllIIIIIlIIlllIlI.getValue());
                llllllllllllIlllllIIIIIlIIlllIlI.setValue(llllllllllllIlllllIIIIIlIIlllIII);
            }
        }
        if (llllllllllllIlllllIIIIIlIIlIlllI.identifier() == 387 && llllllllllllIlllllIIIIIlIIllIIIl.contains("pages")) {
            final ListTag llllllllllllIlllllIIIIIlIIllIlII = llllllllllllIlllllIIIIIlIIllIIIl.get("pages");
            final ListTag llllllllllllIlllllIIIIIlIIllIIll = new ListTag(StringTag.class);
            llllllllllllIlllllIIIIIlIIllIIII.put("pages", llllllllllllIlllllIIIIIlIIllIIll);
            for (int llllllllllllIlllllIIIIIlIIllIlIl = 0; llllllllllllIlllllIIIIIlIIllIlIl < llllllllllllIlllllIIIIIlIIllIlII.size(); ++llllllllllllIlllllIIIIIlIIllIlIl) {
                final StringTag llllllllllllIlllllIIIIIlIIllIlll = llllllllllllIlllllIIIIIlIIllIlII.get(llllllllllllIlllllIIIIIlIIllIlIl);
                String llllllllllllIlllllIIIIIlIIllIllI = llllllllllllIlllllIIIIIlIIllIlll.getValue();
                llllllllllllIlllllIIIIIlIIllIIll.add(new StringTag(llllllllllllIlllllIIIIIlIIllIllI));
                llllllllllllIlllllIIIIIlIIllIllI = ChatUtil.jsonToLegacy(llllllllllllIlllllIIIIIlIIllIllI);
                llllllllllllIlllllIIIIIlIIllIlll.setValue(llllllllllllIlllllIIIIIlIIllIllI);
            }
        }
        ReplacementRegistry1_7_6_10to1_8.replace(llllllllllllIlllllIIIIIlIIlIlllI);
        if (llllllllllllIlllllIIIIIlIIllIIII.size() == 2 && (short)llllllllllllIlllllIIIIIlIIllIIII.get("id").getValue() == llllllllllllIlllllIIIIIlIIlIlllI.identifier() && (short)llllllllllllIlllllIIIIIlIIllIIII.get("data").getValue() == llllllllllllIlllllIIIIIlIIlIlllI.data()) {
            llllllllllllIlllllIIIIIlIIlIlllI.tag().remove("ViaRewind1_7_6_10to1_8");
            if (llllllllllllIlllllIIIIIlIIlIlllI.tag().isEmpty()) {
                llllllllllllIlllllIIIIIlIIlIlllI.setTag(null);
            }
        }
        return llllllllllllIlllllIIIIIlIIlIlllI;
    }
}
