package de.gerrygames.viarewind.protocol.protocol1_8to1_9.items;

import java.lang.reflect.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import java.util.*;

public class ItemRewriter
{
    private static /* synthetic */ Map<String, String> POTION_NAME_INDEX;
    private static /* synthetic */ Map<String, Integer> POTION_NAME_TO_ID;
    private static /* synthetic */ Map<String, Integer> ENTTIY_NAME_TO_ID;
    private static /* synthetic */ Map<Integer, String> ENTTIY_ID_TO_NAME;
    
    static {
        ItemRewriter.POTION_NAME_INDEX = new HashMap<String, String>();
        final double llllllllllllllIlIIIIIIlIIIllllll = (Object)ItemRewriter.class.getDeclaredFields();
        final boolean llllllllllllllIlIIIIIIlIIIlllllI = llllllllllllllIlIIIIIIlIIIllllll.length != 0;
        for (long llllllllllllllIlIIIIIIlIIIllllIl = 0; llllllllllllllIlIIIIIIlIIIllllIl < (llllllllllllllIlIIIIIIlIIIlllllI ? 1 : 0); ++llllllllllllllIlIIIIIIlIIIllllIl) {
            final Field llllllllllllllIlIIIIIIlIIlIIIIII = llllllllllllllIlIIIIIIlIIIllllll[llllllllllllllIlIIIIIIlIIIllllIl];
            try {
                final Field llllllllllllllIlIIIIIIlIIlIIIIIl = com.viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter.class.getDeclaredField(llllllllllllllIlIIIIIIlIIlIIIIII.getName());
                llllllllllllllIlIIIIIIlIIlIIIIIl.setAccessible(true);
                llllllllllllllIlIIIIIIlIIlIIIIII.setAccessible(true);
                llllllllllllllIlIIIIIIlIIlIIIIII.set(null, llllllllllllllIlIIIIIIlIIlIIIIIl.get(null));
            }
            catch (Exception ex) {}
        }
        ItemRewriter.POTION_NAME_TO_ID.put("luck", 8203);
        ItemRewriter.POTION_NAME_INDEX.put("water", "§rWater Bottle");
        ItemRewriter.POTION_NAME_INDEX.put("mundane", "§rMundane Potion");
        ItemRewriter.POTION_NAME_INDEX.put("thick", "§rThick Potion");
        ItemRewriter.POTION_NAME_INDEX.put("awkward", "§rAwkward Potion");
        ItemRewriter.POTION_NAME_INDEX.put("water_splash", "§rSplash Water Bottle");
        ItemRewriter.POTION_NAME_INDEX.put("mundane_splash", "§rMundane Splash Potion");
        ItemRewriter.POTION_NAME_INDEX.put("thick_splash", "§rThick Splash Potion");
        ItemRewriter.POTION_NAME_INDEX.put("awkward_splash", "§rAwkward Splash Potion");
        ItemRewriter.POTION_NAME_INDEX.put("water_lingering", "§rLingering Water Bottle");
        ItemRewriter.POTION_NAME_INDEX.put("mundane_lingering", "§rMundane Lingering Potion");
        ItemRewriter.POTION_NAME_INDEX.put("thick_lingering", "§rThick Lingering Potion");
        ItemRewriter.POTION_NAME_INDEX.put("awkward_lingering", "§rAwkward Lingering Potion");
        ItemRewriter.POTION_NAME_INDEX.put("night_vision_lingering", "§rLingering Potion of Night Vision");
        ItemRewriter.POTION_NAME_INDEX.put("long_night_vision_lingering", "§rLingering Potion of Night Vision");
        ItemRewriter.POTION_NAME_INDEX.put("invisibility_lingering", "§rLingering Potion of Invisibility");
        ItemRewriter.POTION_NAME_INDEX.put("long_invisibility_lingering", "§rLingering Potion of Invisibility");
        ItemRewriter.POTION_NAME_INDEX.put("leaping_lingering", "§rLingering Potion of Leaping");
        ItemRewriter.POTION_NAME_INDEX.put("long_leaping_lingering", "§rLingering Potion of Leaping");
        ItemRewriter.POTION_NAME_INDEX.put("strong_leaping_lingering", "§rLingering Potion of Leaping");
        ItemRewriter.POTION_NAME_INDEX.put("fire_resistance_lingering", "§rLingering Potion of Fire Resistance");
        ItemRewriter.POTION_NAME_INDEX.put("long_fire_resistance_lingering", "§rLingering Potion of Fire Resistance");
        ItemRewriter.POTION_NAME_INDEX.put("swiftness_lingering", "§rLingering Potion of Swiftness");
        ItemRewriter.POTION_NAME_INDEX.put("long_swiftness_lingering", "§rLingering Potion of Swiftness");
        ItemRewriter.POTION_NAME_INDEX.put("strong_swiftness_lingering", "§rLingering Potion of Swiftness");
        ItemRewriter.POTION_NAME_INDEX.put("slowness_lingering", "§rLingering Potion of Slowness");
        ItemRewriter.POTION_NAME_INDEX.put("long_slowness_lingering", "§rLingering Potion of Slowness");
        ItemRewriter.POTION_NAME_INDEX.put("water_breathing_lingering", "§rLingering Potion of Water Breathing");
        ItemRewriter.POTION_NAME_INDEX.put("long_water_breathing_lingering", "§rLingering Potion of Water Breathing");
        ItemRewriter.POTION_NAME_INDEX.put("healing_lingering", "§rLingering Potion of Healing");
        ItemRewriter.POTION_NAME_INDEX.put("strong_healing_lingering", "§rLingering Potion of Healing");
        ItemRewriter.POTION_NAME_INDEX.put("harming_lingering", "§rLingering Potion of Harming");
        ItemRewriter.POTION_NAME_INDEX.put("strong_harming_lingering", "§rLingering Potion of Harming");
        ItemRewriter.POTION_NAME_INDEX.put("poison_lingering", "§rLingering Potion of Poisen");
        ItemRewriter.POTION_NAME_INDEX.put("long_poison_lingering", "§rLingering Potion of Poisen");
        ItemRewriter.POTION_NAME_INDEX.put("strong_poison_lingering", "§rLingering Potion of Poisen");
        ItemRewriter.POTION_NAME_INDEX.put("regeneration_lingering", "§rLingering Potion of Regeneration");
        ItemRewriter.POTION_NAME_INDEX.put("long_regeneration_lingering", "§rLingering Potion of Regeneration");
        ItemRewriter.POTION_NAME_INDEX.put("strong_regeneration_lingering", "§rLingering Potion of Regeneration");
        ItemRewriter.POTION_NAME_INDEX.put("strength_lingering", "§rLingering Potion of Strength");
        ItemRewriter.POTION_NAME_INDEX.put("long_strength_lingering", "§rLingering Potion of Strength");
        ItemRewriter.POTION_NAME_INDEX.put("strong_strength_lingering", "§rLingering Potion of Strength");
        ItemRewriter.POTION_NAME_INDEX.put("weakness_lingering", "§rLingering Potion of Weakness");
        ItemRewriter.POTION_NAME_INDEX.put("long_weakness_lingering", "§rLingering Potion of Weakness");
        ItemRewriter.POTION_NAME_INDEX.put("luck_lingering", "§rLingering Potion of Luck");
        ItemRewriter.POTION_NAME_INDEX.put("luck", "§rPotion of Luck");
        ItemRewriter.POTION_NAME_INDEX.put("luck_splash", "§rSplash Potion of Luck");
    }
    
    public static Item toServer(final Item llllllllllllllIlIIIIIIlIIlIIlllI) {
        if (llllllllllllllIlIIIIIIlIIlIIlllI == null) {
            return null;
        }
        CompoundTag llllllllllllllIlIIIIIIlIIlIIllIl = llllllllllllllIlIIIIIIlIIlIIlllI.tag();
        if (llllllllllllllIlIIIIIIlIIlIIlllI.identifier() == 383 && llllllllllllllIlIIIIIIlIIlIIlllI.data() != 0) {
            if (llllllllllllllIlIIIIIIlIIlIIllIl == null) {
                llllllllllllllIlIIIIIIlIIlIIlllI.setTag(llllllllllllllIlIIIIIIlIIlIIllIl = new CompoundTag());
            }
            if (!llllllllllllllIlIIIIIIlIIlIIllIl.contains("EntityTag") && ItemRewriter.ENTTIY_ID_TO_NAME.containsKey((int)llllllllllllllIlIIIIIIlIIlIIlllI.data())) {
                final CompoundTag llllllllllllllIlIIIIIIlIIlIlIlII = new CompoundTag();
                llllllllllllllIlIIIIIIlIIlIlIlII.put("id", new StringTag(ItemRewriter.ENTTIY_ID_TO_NAME.get((int)llllllllllllllIlIIIIIIlIIlIIlllI.data())));
                llllllllllllllIlIIIIIIlIIlIIllIl.put("EntityTag", llllllllllllllIlIIIIIIlIIlIlIlII);
            }
            llllllllllllllIlIIIIIIlIIlIIlllI.setData((short)0);
        }
        if (llllllllllllllIlIIIIIIlIIlIIlllI.identifier() == 373 && (llllllllllllllIlIIIIIIlIIlIIllIl == null || !llllllllllllllIlIIIIIIlIIlIIllIl.contains("Potion"))) {
            if (llllllllllllllIlIIIIIIlIIlIIllIl == null) {
                llllllllllllllIlIIIIIIlIIlIIlllI.setTag(llllllllllllllIlIIIIIIlIIlIIllIl = new CompoundTag());
            }
            if (llllllllllllllIlIIIIIIlIIlIIlllI.data() >= 16384) {
                llllllllllllllIlIIIIIIlIIlIIlllI.setIdentifier(438);
                llllllllllllllIlIIIIIIlIIlIIlllI.setData((short)(llllllllllllllIlIIIIIIlIIlIIlllI.data() - 8192));
            }
            final String llllllllllllllIlIIIIIIlIIlIlIIll = (llllllllllllllIlIIIIIIlIIlIIlllI.data() == 8192) ? "water" : com.viaversion.viaversion.protocols.protocol1_9to1_8.ItemRewriter.potionNameFromDamage(llllllllllllllIlIIIIIIlIIlIIlllI.data());
            llllllllllllllIlIIIIIIlIIlIIllIl.put("Potion", new StringTag(String.valueOf(new StringBuilder().append("minecraft:").append(llllllllllllllIlIIIIIIlIIlIlIIll))));
            llllllllllllllIlIIIIIIlIIlIIlllI.setData((short)0);
        }
        if (llllllllllllllIlIIIIIIlIIlIIllIl == null || !llllllllllllllIlIIIIIIlIIlIIlllI.tag().contains("ViaRewind1_8to1_9")) {
            return llllllllllllllIlIIIIIIlIIlIIlllI;
        }
        final CompoundTag llllllllllllllIlIIIIIIlIIlIIllII = llllllllllllllIlIIIIIIlIIlIIllIl.remove("ViaRewind1_8to1_9");
        llllllllllllllIlIIIIIIlIIlIIlllI.setIdentifier((short)llllllllllllllIlIIIIIIlIIlIIllII.get("id").getValue());
        llllllllllllllIlIIIIIIlIIlIIlllI.setData((short)llllllllllllllIlIIIIIIlIIlIIllII.get("data").getValue());
        if (llllllllllllllIlIIIIIIlIIlIIllII.contains("noDisplay")) {
            llllllllllllllIlIIIIIIlIIlIIllIl.remove("display");
        }
        if (llllllllllllllIlIIIIIIlIIlIIllII.contains("Unbreakable")) {
            llllllllllllllIlIIIIIIlIIlIIllIl.put("Unbreakable", llllllllllllllIlIIIIIIlIIlIIllII.get("Unbreakable").clone());
        }
        if (llllllllllllllIlIIIIIIlIIlIIllII.contains("displayName")) {
            CompoundTag llllllllllllllIlIIIIIIlIIlIlIIlI = llllllllllllllIlIIIIIIlIIlIIllIl.get("display");
            if (llllllllllllllIlIIIIIIlIIlIlIIlI == null) {
                llllllllllllllIlIIIIIIlIIlIIllIl.put("display", llllllllllllllIlIIIIIIlIIlIlIIlI = new CompoundTag());
            }
            final StringTag llllllllllllllIlIIIIIIlIIlIlIIIl = llllllllllllllIlIIIIIIlIIlIlIIlI.get("Name");
            if (llllllllllllllIlIIIIIIlIIlIlIIIl == null) {
                llllllllllllllIlIIIIIIlIIlIlIIlI.put("Name", new StringTag((String)llllllllllllllIlIIIIIIlIIlIIllII.get("displayName").getValue()));
            }
            else {
                llllllllllllllIlIIIIIIlIIlIlIIIl.setValue((String)llllllllllllllIlIIIIIIlIIlIIllII.get("displayName").getValue());
            }
        }
        else if (llllllllllllllIlIIIIIIlIIlIIllIl.contains("display")) {
            llllllllllllllIlIIIIIIlIIlIIllIl.get("display").remove("Name");
        }
        if (llllllllllllllIlIIIIIIlIIlIIllII.contains("lore")) {
            CompoundTag llllllllllllllIlIIIIIIlIIlIlIIII = llllllllllllllIlIIIIIIlIIlIIllIl.get("display");
            if (llllllllllllllIlIIIIIIlIIlIlIIII == null) {
                llllllllllllllIlIIIIIIlIIlIIllIl.put("display", llllllllllllllIlIIIIIIlIIlIlIIII = new CompoundTag());
            }
            final ListTag llllllllllllllIlIIIIIIlIIlIIllll = llllllllllllllIlIIIIIIlIIlIlIIII.get("Lore");
            if (llllllllllllllIlIIIIIIlIIlIIllll == null) {
                llllllllllllllIlIIIIIIlIIlIlIIII.put("Lore", new ListTag((List<Tag>)llllllllllllllIlIIIIIIlIIlIIllII.get("lore").getValue()));
            }
            else {
                llllllllllllllIlIIIIIIlIIlIIllll.setValue((List<Tag>)llllllllllllllIlIIIIIIlIIlIIllII.get("lore").getValue());
            }
        }
        else if (llllllllllllllIlIIIIIIlIIlIIllIl.contains("display")) {
            llllllllllllllIlIIIIIIlIIlIIllIl.get("display").remove("Lore");
        }
        llllllllllllllIlIIIIIIlIIlIIllIl.remove("AttributeModifiers");
        if (llllllllllllllIlIIIIIIlIIlIIllII.contains("AttributeModifiers")) {
            llllllllllllllIlIIIIIIlIIlIIllIl.put("AttributeModifiers", llllllllllllllIlIIIIIIlIIlIIllII.get("AttributeModifiers"));
        }
        return llllllllllllllIlIIIIIIlIIlIIlllI;
    }
    
    public static Item toClient(final Item llllllllllllllIlIIIIIIlIIllIIlII) {
        if (llllllllllllllIlIIIIIIlIIllIIlII == null) {
            return null;
        }
        CompoundTag llllllllllllllIlIIIIIIlIIllIIlll = llllllllllllllIlIIIIIIlIIllIIlII.tag();
        if (llllllllllllllIlIIIIIIlIIllIIlll == null) {
            llllllllllllllIlIIIIIIlIIllIIlII.setTag(llllllllllllllIlIIIIIIlIIllIIlll = new CompoundTag());
        }
        final CompoundTag llllllllllllllIlIIIIIIlIIllIIllI = new CompoundTag();
        llllllllllllllIlIIIIIIlIIllIIlll.put("ViaRewind1_8to1_9", llllllllllllllIlIIIIIIlIIllIIllI);
        llllllllllllllIlIIIIIIlIIllIIllI.put("id", new ShortTag((short)llllllllllllllIlIIIIIIlIIllIIlII.identifier()));
        llllllllllllllIlIIIIIIlIIllIIllI.put("data", new ShortTag(llllllllllllllIlIIIIIIlIIllIIlII.data()));
        CompoundTag llllllllllllllIlIIIIIIlIIllIIlIl = llllllllllllllIlIIIIIIlIIllIIlll.get("display");
        if (llllllllllllllIlIIIIIIlIIllIIlIl != null && llllllllllllllIlIIIIIIlIIllIIlIl.contains("Name")) {
            llllllllllllllIlIIIIIIlIIllIIllI.put("displayName", new StringTag((String)llllllllllllllIlIIIIIIlIIllIIlIl.get("Name").getValue()));
        }
        if (llllllllllllllIlIIIIIIlIIllIIlIl != null && llllllllllllllIlIIIIIIlIIllIIlIl.contains("Lore")) {
            llllllllllllllIlIIIIIIlIIllIIllI.put("lore", new ListTag(llllllllllllllIlIIIIIIlIIllIIlIl.get("Lore").getValue()));
        }
        if (llllllllllllllIlIIIIIIlIIllIIlll.contains("ench") || llllllllllllllIlIIIIIIlIIllIIlll.contains("StoredEnchantments")) {
            final ListTag llllllllllllllIlIIIIIIlIIlllIllI = llllllllllllllIlIIIIIIlIIllIIlll.contains("ench") ? llllllllllllllIlIIIIIIlIIllIIlll.get("ench") : llllllllllllllIlIIIIIIlIIllIIlll.get("StoredEnchantments");
            final List<Tag> llllllllllllllIlIIIIIIlIIlllIlIl = new ArrayList<Tag>();
            for (final Tag llllllllllllllIlIIIIIIlIIllllIII : new ArrayList<Tag>(llllllllllllllIlIIIIIIlIIlllIllI.getValue())) {
                final short llllllllllllllIlIIIIIIlIIllllIll = ((CompoundTag)llllllllllllllIlIIIIIIlIIllllIII).get("id").asShort();
                final short llllllllllllllIlIIIIIIlIIllllIlI = ((CompoundTag)llllllllllllllIlIIIIIIlIIllllIII).get("lvl").asShort();
                String llllllllllllllIlIIIIIIlIIllllIIl = null;
                if (llllllllllllllIlIIIIIIlIIllllIll == 70) {
                    final String llllllllllllllIlIIIIIIlIIlllllII = "§r§7Mending ";
                }
                else {
                    if (llllllllllllllIlIIIIIIlIIllllIll != 9) {
                        continue;
                    }
                    llllllllllllllIlIIIIIIlIIllllIIl = "§r§7Frost Walker ";
                }
                llllllllllllllIlIIIIIIlIIlllIllI.remove(llllllllllllllIlIIIIIIlIIllllIII);
                llllllllllllllIlIIIIIIlIIllllIIl = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIIIlIIllllIIl).append(Enchantments.ENCHANTMENTS.getOrDefault(llllllllllllllIlIIIIIIlIIllllIlI, String.valueOf(new StringBuilder().append("enchantment.level.").append(llllllllllllllIlIIIIIIlIIllllIlI)))));
                llllllllllllllIlIIIIIIlIIlllIlIl.add(new StringTag(llllllllllllllIlIIIIIIlIIllllIIl));
            }
            if (!llllllllllllllIlIIIIIIlIIlllIlIl.isEmpty()) {
                if (llllllllllllllIlIIIIIIlIIllIIlIl == null) {
                    llllllllllllllIlIIIIIIlIIllIIlll.put("display", llllllllllllllIlIIIIIIlIIllIIlIl = new CompoundTag());
                    llllllllllllllIlIIIIIIlIIllIIllI.put("noDisplay", new ByteTag());
                }
                ListTag llllllllllllllIlIIIIIIlIIlllIlll = llllllllllllllIlIIIIIIlIIllIIlIl.get("Lore");
                if (llllllllllllllIlIIIIIIlIIlllIlll == null) {
                    llllllllllllllIlIIIIIIlIIllIIlIl.put("Lore", llllllllllllllIlIIIIIIlIIlllIlll = new ListTag(StringTag.class));
                }
                llllllllllllllIlIIIIIIlIIlllIlIl.addAll(llllllllllllllIlIIIIIIlIIlllIlll.getValue());
                llllllllllllllIlIIIIIIlIIlllIlll.setValue(llllllllllllllIlIIIIIIlIIlllIlIl);
            }
        }
        if (llllllllllllllIlIIIIIIlIIllIIlII.data() != 0 && llllllllllllllIlIIIIIIlIIllIIlll.contains("Unbreakable")) {
            final ByteTag llllllllllllllIlIIIIIIlIIlllIIll = llllllllllllllIlIIIIIIlIIllIIlll.get("Unbreakable");
            if (llllllllllllllIlIIIIIIlIIlllIIll.asByte() != 0) {
                llllllllllllllIlIIIIIIlIIllIIllI.put("Unbreakable", new ByteTag(llllllllllllllIlIIIIIIlIIlllIIll.asByte()));
                llllllllllllllIlIIIIIIlIIllIIlll.remove("Unbreakable");
                if (llllllllllllllIlIIIIIIlIIllIIlIl == null) {
                    llllllllllllllIlIIIIIIlIIllIIlll.put("display", llllllllllllllIlIIIIIIlIIllIIlIl = new CompoundTag());
                    llllllllllllllIlIIIIIIlIIllIIllI.put("noDisplay", new ByteTag());
                }
                ListTag llllllllllllllIlIIIIIIlIIlllIlII = llllllllllllllIlIIIIIIlIIllIIlIl.get("Lore");
                if (llllllllllllllIlIIIIIIlIIlllIlII == null) {
                    llllllllllllllIlIIIIIIlIIllIIlIl.put("Lore", llllllllllllllIlIIIIIIlIIlllIlII = new ListTag(StringTag.class));
                }
                llllllllllllllIlIIIIIIlIIlllIlII.add(new StringTag("§9Unbreakable"));
            }
        }
        if (llllllllllllllIlIIIIIIlIIllIIlll.contains("AttributeModifiers")) {
            llllllllllllllIlIIIIIIlIIllIIllI.put("AttributeModifiers", llllllllllllllIlIIIIIIlIIllIIlll.get("AttributeModifiers").clone());
        }
        if (llllllllllllllIlIIIIIIlIIllIIlII.identifier() == 383 && llllllllllllllIlIIIIIIlIIllIIlII.data() == 0) {
            int llllllllllllllIlIIIIIIlIIlllIIII = 0;
            if (llllllllllllllIlIIIIIIlIIllIIlll.contains("EntityTag")) {
                final CompoundTag llllllllllllllIlIIIIIIlIIlllIIIl = llllllllllllllIlIIIIIIlIIllIIlll.get("EntityTag");
                if (llllllllllllllIlIIIIIIlIIlllIIIl.contains("id")) {
                    final StringTag llllllllllllllIlIIIIIIlIIlllIIlI = llllllllllllllIlIIIIIIlIIlllIIIl.get("id");
                    if (ItemRewriter.ENTTIY_NAME_TO_ID.containsKey(llllllllllllllIlIIIIIIlIIlllIIlI.getValue())) {
                        llllllllllllllIlIIIIIIlIIlllIIII = ItemRewriter.ENTTIY_NAME_TO_ID.get(llllllllllllllIlIIIIIIlIIlllIIlI.getValue());
                    }
                    else if (llllllllllllllIlIIIIIIlIIllIIlIl == null) {
                        llllllllllllllIlIIIIIIlIIllIIlll.put("display", llllllllllllllIlIIIIIIlIIllIIlIl = new CompoundTag());
                        llllllllllllllIlIIIIIIlIIllIIllI.put("noDisplay", new ByteTag());
                        llllllllllllllIlIIIIIIlIIllIIlIl.put("Name", new StringTag(String.valueOf(new StringBuilder().append("§rSpawn ").append(llllllllllllllIlIIIIIIlIIlllIIlI.getValue()))));
                    }
                }
            }
            llllllllllllllIlIIIIIIlIIllIIlII.setData((short)llllllllllllllIlIIIIIIlIIlllIIII);
        }
        ReplacementRegistry1_8to1_9.replace(llllllllllllllIlIIIIIIlIIllIIlII);
        if (llllllllllllllIlIIIIIIlIIllIIlII.identifier() == 373 || llllllllllllllIlIIIIIIlIIllIIlII.identifier() == 438 || llllllllllllllIlIIIIIIlIIllIIlII.identifier() == 441) {
            int llllllllllllllIlIIIIIIlIIllIllIl = 0;
            if (llllllllllllllIlIIIIIIlIIllIIlll.contains("Potion")) {
                final StringTag llllllllllllllIlIIIIIIlIIllIllll = llllllllllllllIlIIIIIIlIIllIIlll.get("Potion");
                String llllllllllllllIlIIIIIIlIIllIlllI = llllllllllllllIlIIIIIIlIIllIllll.getValue().replace("minecraft:", "");
                if (ItemRewriter.POTION_NAME_TO_ID.containsKey(llllllllllllllIlIIIIIIlIIllIlllI)) {
                    llllllllllllllIlIIIIIIlIIllIllIl = ItemRewriter.POTION_NAME_TO_ID.get(llllllllllllllIlIIIIIIlIIllIlllI);
                }
                if (llllllllllllllIlIIIIIIlIIllIIlII.identifier() == 438) {
                    llllllllllllllIlIIIIIIlIIllIlllI = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIIIlIIllIlllI).append("_splash"));
                }
                else if (llllllllllllllIlIIIIIIlIIllIIlII.identifier() == 441) {
                    llllllllllllllIlIIIIIIlIIllIlllI = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIIIlIIllIlllI).append("_lingering"));
                }
                if ((llllllllllllllIlIIIIIIlIIllIIlIl == null || !llllllllllllllIlIIIIIIlIIllIIlIl.contains("Name")) && ItemRewriter.POTION_NAME_INDEX.containsKey(llllllllllllllIlIIIIIIlIIllIlllI)) {
                    if (llllllllllllllIlIIIIIIlIIllIIlIl == null) {
                        llllllllllllllIlIIIIIIlIIllIIlll.put("display", llllllllllllllIlIIIIIIlIIllIIlIl = new CompoundTag());
                        llllllllllllllIlIIIIIIlIIllIIllI.put("noDisplay", new ByteTag());
                    }
                    llllllllllllllIlIIIIIIlIIllIIlIl.put("Name", new StringTag(ItemRewriter.POTION_NAME_INDEX.get(llllllllllllllIlIIIIIIlIIllIlllI)));
                }
            }
            if (llllllllllllllIlIIIIIIlIIllIIlII.identifier() == 438 || llllllllllllllIlIIIIIIlIIllIIlII.identifier() == 441) {
                llllllllllllllIlIIIIIIlIIllIIlII.setIdentifier(373);
                llllllllllllllIlIIIIIIlIIllIllIl += 8192;
            }
            llllllllllllllIlIIIIIIlIIllIIlII.setData((short)llllllllllllllIlIIIIIIlIIllIllIl);
        }
        if (llllllllllllllIlIIIIIIlIIllIIlll.contains("AttributeModifiers")) {
            final ListTag llllllllllllllIlIIIIIIlIIllIlIIl = llllllllllllllIlIIIIIIlIIllIIlll.get("AttributeModifiers");
            for (int llllllllllllllIlIIIIIIlIIllIlIlI = 0; llllllllllllllIlIIIIIIlIIllIlIlI < llllllllllllllIlIIIIIIlIIllIlIIl.size(); ++llllllllllllllIlIIIIIIlIIllIlIlI) {
                final CompoundTag llllllllllllllIlIIIIIIlIIllIllII = llllllllllllllIlIIIIIIlIIllIlIIl.get(llllllllllllllIlIIIIIIlIIllIlIlI);
                final String llllllllllllllIlIIIIIIlIIllIlIll = (String)llllllllllllllIlIIIIIIlIIllIllII.get("AttributeName").getValue();
                if (!Protocol1_8TO1_9.VALID_ATTRIBUTES.contains(llllllllllllllIlIIIIIIlIIllIllII)) {
                    llllllllllllllIlIIIIIIlIIllIlIIl.remove(llllllllllllllIlIIIIIIlIIllIllII);
                    --llllllllllllllIlIIIIIIlIIllIlIlI;
                }
            }
        }
        if (llllllllllllllIlIIIIIIlIIllIIllI.size() == 2 && (short)llllllllllllllIlIIIIIIlIIllIIllI.get("id").getValue() == llllllllllllllIlIIIIIIlIIllIIlII.identifier() && (short)llllllllllllllIlIIIIIIlIIllIIllI.get("data").getValue() == llllllllllllllIlIIIIIIlIIllIIlII.data()) {
            llllllllllllllIlIIIIIIlIIllIIlII.tag().remove("ViaRewind1_8to1_9");
            if (llllllllllllllIlIIIIIIlIIllIIlII.tag().isEmpty()) {
                llllllllllllllIlIIIIIIlIIllIIlII.setTag(null);
            }
        }
        return llllllllllllllIlIIIIIIlIIllIIlII;
    }
}
