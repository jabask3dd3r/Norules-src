package com.viaversion.viaversion.protocols.protocol1_9to1_8;

import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class ItemRewriter
{
    private static final /* synthetic */ Map<Integer, String> POTION_ID_TO_NAME;
    private static final /* synthetic */ Map<Integer, String> ENTTIY_ID_TO_NAME;
    private static final /* synthetic */ Map<String, Integer> POTION_NAME_TO_ID;
    private static final /* synthetic */ Map<String, Integer> ENTTIY_NAME_TO_ID;
    private static final /* synthetic */ Int2IntMap POTION_INDEX;
    
    public static void toServer(final Item llllllllllllllIIlIIlIIIIlIIllIIl) {
        if (llllllllllllllIIlIIlIIIIlIIllIIl != null) {
            if (llllllllllllllIIlIIlIIIIlIIllIIl.identifier() == 383 && llllllllllllllIIlIIlIIIIlIIllIIl.data() == 0) {
                final CompoundTag llllllllllllllIIlIIlIIIIlIlIIlIl = llllllllllllllIIlIIlIIIIlIIllIIl.tag();
                int llllllllllllllIIlIIlIIIIlIlIIlII = 0;
                if (llllllllllllllIIlIIlIIIIlIlIIlIl != null && llllllllllllllIIlIIlIIIIlIlIIlIl.get("EntityTag") instanceof CompoundTag) {
                    final CompoundTag llllllllllllllIIlIIlIIIIlIlIIllI = llllllllllllllIIlIIlIIIIlIlIIlIl.get("EntityTag");
                    if (llllllllllllllIIlIIlIIIIlIlIIllI.get("id") instanceof StringTag) {
                        final StringTag llllllllllllllIIlIIlIIIIlIlIIlll = llllllllllllllIIlIIlIIIIlIlIIllI.get("id");
                        if (ItemRewriter.ENTTIY_NAME_TO_ID.containsKey(llllllllllllllIIlIIlIIIIlIlIIlll.getValue())) {
                            llllllllllllllIIlIIlIIIIlIlIIlII = ItemRewriter.ENTTIY_NAME_TO_ID.get(llllllllllllllIIlIIlIIIIlIlIIlll.getValue());
                        }
                    }
                    llllllllllllllIIlIIlIIIIlIlIIlIl.remove("EntityTag");
                }
                llllllllllllllIIlIIlIIIIlIIllIIl.setTag(llllllllllllllIIlIIlIIIIlIlIIlIl);
                llllllllllllllIIlIIlIIIIlIIllIIl.setData((short)llllllllllllllIIlIIlIIIIlIlIIlII);
            }
            if (llllllllllllllIIlIIlIIIIlIIllIIl.identifier() == 373) {
                final CompoundTag llllllllllllllIIlIIlIIIIlIlIIIIl = llllllllllllllIIlIIlIIIIlIIllIIl.tag();
                int llllllllllllllIIlIIlIIIIlIlIIIII = 0;
                if (llllllllllllllIIlIIlIIIIlIlIIIIl != null && llllllllllllllIIlIIlIIIIlIlIIIIl.get("Potion") instanceof StringTag) {
                    final StringTag llllllllllllllIIlIIlIIIIlIlIIIll = llllllllllllllIIlIIlIIIIlIlIIIIl.get("Potion");
                    final String llllllllllllllIIlIIlIIIIlIlIIIlI = llllllllllllllIIlIIlIIIIlIlIIIll.getValue().replace("minecraft:", "");
                    if (ItemRewriter.POTION_NAME_TO_ID.containsKey(llllllllllllllIIlIIlIIIIlIlIIIlI)) {
                        llllllllllllllIIlIIlIIIIlIlIIIII = ItemRewriter.POTION_NAME_TO_ID.get(llllllllllllllIIlIIlIIIIlIlIIIlI);
                    }
                    llllllllllllllIIlIIlIIIIlIlIIIIl.remove("Potion");
                }
                llllllllllllllIIlIIlIIIIlIIllIIl.setTag(llllllllllllllIIlIIlIIIIlIlIIIIl);
                llllllllllllllIIlIIlIIIIlIIllIIl.setData((short)llllllllllllllIIlIIlIIIIlIlIIIII);
            }
            if (llllllllllllllIIlIIlIIIIlIIllIIl.identifier() == 438) {
                final CompoundTag llllllllllllllIIlIIlIIIIlIIlllIl = llllllllllllllIIlIIlIIIIlIIllIIl.tag();
                int llllllllllllllIIlIIlIIIIlIIlllII = 0;
                llllllllllllllIIlIIlIIIIlIIllIIl.setIdentifier(373);
                if (llllllllllllllIIlIIlIIIIlIIlllIl != null && llllllllllllllIIlIIlIIIIlIIlllIl.get("Potion") instanceof StringTag) {
                    final StringTag llllllllllllllIIlIIlIIIIlIIlllll = llllllllllllllIIlIIlIIIIlIIlllIl.get("Potion");
                    final String llllllllllllllIIlIIlIIIIlIIllllI = llllllllllllllIIlIIlIIIIlIIlllll.getValue().replace("minecraft:", "");
                    if (ItemRewriter.POTION_NAME_TO_ID.containsKey(llllllllllllllIIlIIlIIIIlIIllllI)) {
                        llllllllllllllIIlIIlIIIIlIIlllII = ItemRewriter.POTION_NAME_TO_ID.get(llllllllllllllIIlIIlIIIIlIIllllI) + 8192;
                    }
                    llllllllllllllIIlIIlIIIIlIIlllIl.remove("Potion");
                }
                llllllllllllllIIlIIlIIIIlIIllIIl.setTag(llllllllllllllIIlIIlIIIIlIIlllIl);
                llllllllllllllIIlIIlIIIIlIIllIIl.setData((short)llllllllllllllIIlIIlIIIIlIIlllII);
            }
            boolean llllllllllllllIIlIIlIIIIlIIllIll = llllllllllllllIIlIIlIIIIlIIllIIl.identifier() >= 198 && llllllllllllllIIlIIlIIIIlIIllIIl.identifier() <= 212;
            llllllllllllllIIlIIlIIIIlIIllIll |= (llllllllllllllIIlIIlIIIIlIIllIIl.identifier() == 397 && llllllllllllllIIlIIlIIIIlIIllIIl.data() == 5);
            llllllllllllllIIlIIlIIIIlIIllIll |= (llllllllllllllIIlIIlIIIIlIIllIIl.identifier() >= 432 && llllllllllllllIIlIIlIIIIlIIllIIl.identifier() <= 448);
            if (llllllllllllllIIlIIlIIIIlIIllIll) {
                llllllllllllllIIlIIlIIIIlIIllIIl.setIdentifier(1);
                llllllllllllllIIlIIlIIIIlIIllIIl.setData((short)0);
            }
        }
    }
    
    public static void rewriteBookToServer(final Item llllllllllllllIIlIIlIIIIlIIIIlII) {
        final int llllllllllllllIIlIIlIIIIlIIIIlll = llllllllllllllIIlIIlIIIIlIIIIlII.identifier();
        if (llllllllllllllIIlIIlIIIIlIIIIlll != 387) {
            return;
        }
        final CompoundTag llllllllllllllIIlIIlIIIIlIIIIllI = llllllllllllllIIlIIlIIIIlIIIIlII.tag();
        final ListTag llllllllllllllIIlIIlIIIIlIIIIlIl = llllllllllllllIIlIIlIIIIlIIIIllI.get("pages");
        if (llllllllllllllIIlIIlIIIIlIIIIlIl == null) {
            return;
        }
        for (int llllllllllllllIIlIIlIIIIlIIIlIIl = 0; llllllllllllllIIlIIlIIIIlIIIlIIl < llllllllllllllIIlIIlIIIIlIIIIlIl.size(); ++llllllllllllllIIlIIlIIIIlIIIlIIl) {
            final Tag llllllllllllllIIlIIlIIIIlIIIllII = llllllllllllllIIlIIlIIIIlIIIIlIl.get(llllllllllllllIIlIIlIIIIlIIIlIIl);
            if (llllllllllllllIIlIIlIIIIlIIIllII instanceof StringTag) {
                final StringTag llllllllllllllIIlIIlIIIIlIIIlIll = (StringTag)llllllllllllllIIlIIlIIIIlIIIllII;
                String llllllllllllllIIlIIlIIIIlIIIlIlI = llllllllllllllIIlIIlIIIIlIIIlIll.getValue();
                if (llllllllllllllIIlIIlIIIIlIIIlIlI.replaceAll(" ", "").isEmpty()) {
                    llllllllllllllIIlIIlIIIIlIIIlIlI = String.valueOf(new StringBuilder().append("\"").append(fixBookSpaceChars(llllllllllllllIIlIIlIIIIlIIIlIlI)).append("\""));
                }
                else {
                    llllllllllllllIIlIIlIIIIlIIIlIlI = fixBookSpaceChars(llllllllllllllIIlIIlIIIIlIIIlIlI);
                }
                llllllllllllllIIlIIlIIIIlIIIlIll.setValue(llllllllllllllIIlIIlIIIIlIIIlIlI);
            }
        }
    }
    
    public static int getNewEffectID(int llllllllllllllIIlIIlIIIIIIIllIIl) {
        if (llllllllllllllIIlIIlIIIIIIIllIIl >= 16384) {
            llllllllllllllIIlIIlIIIIIIIllIIl -= 8192;
        }
        int llllllllllllllIIlIIlIIIIIIIllIlI = ItemRewriter.POTION_INDEX.get(llllllllllllllIIlIIlIIIIIIIllIIl);
        if (llllllllllllllIIlIIlIIIIIIIllIlI != -1) {
            return llllllllllllllIIlIIlIIIIIIIllIlI;
        }
        llllllllllllllIIlIIlIIIIIIIllIIl = ItemRewriter.POTION_NAME_TO_ID.get(potionNameFromDamage((short)llllllllllllllIIlIIlIIIIIIIllIIl));
        return ((llllllllllllllIIlIIlIIIIIIIllIlI = ItemRewriter.POTION_INDEX.get(llllllllllllllIIlIIlIIIIIIIllIIl)) != -1) ? llllllllllllllIIlIIlIIIIIIIllIlI : 0;
    }
    
    private static String fixBookSpaceChars(String llllllllllllllIIlIIlIIIIIllllIlI) {
        if (!llllllllllllllIIlIIlIIIIIllllIlI.startsWith(" ")) {
            return llllllllllllllIIlIIlIIIIIllllIlI;
        }
        llllllllllllllIIlIIlIIIIIllllIlI = String.valueOf(new StringBuilder().append("§r").append(llllllllllllllIIlIIlIIIIIllllIlI));
        return llllllllllllllIIlIIlIIIIIllllIlI;
    }
    
    public static String potionNameFromDamage(final short llllllllllllllIIlIIlIIIIIIlIllll) {
        final String llllllllllllllIIlIIlIIIIIIlIlllI = ItemRewriter.POTION_ID_TO_NAME.get((int)llllllllllllllIIlIIlIIIIIIlIllll);
        if (llllllllllllllIIlIIlIIIIIIlIlllI != null) {
            return llllllllllllllIIlIIlIIIIIIlIlllI;
        }
        if (llllllllllllllIIlIIlIIIIIIlIllll == 0) {
            return "water";
        }
        final int llllllllllllllIIlIIlIIIIIIlIllIl = llllllllllllllIIlIIlIIIIIIlIllll & 0xF;
        final int llllllllllllllIIlIIlIIIIIIlIllII = llllllllllllllIIlIIlIIIIIIlIllll & 0x3F;
        final boolean llllllllllllllIIlIIlIIIIIIlIlIll = (llllllllllllllIIlIIlIIIIIIlIllll & 0x20) > 0;
        final boolean llllllllllllllIIlIIlIIIIIIlIlIlI = (llllllllllllllIIlIIlIIIIIIlIllll & 0x40) > 0;
        boolean llllllllllllllIIlIIlIIIIIIlIlIIl = true;
        boolean llllllllllllllIIlIIlIIIIIIlIlIII = true;
        String llllllllllllllIIlIIlIIIIIIlIIlll = null;
        Label_0325: {
            switch (llllllllllllllIIlIIlIIIIIIlIllIl) {
                case 1: {
                    final String llllllllllllllIIlIIlIIIIIIllllll = "regeneration";
                    break;
                }
                case 2: {
                    final String llllllllllllllIIlIIlIIIIIIlllllI = "swiftness";
                    break;
                }
                case 3: {
                    final String llllllllllllllIIlIIlIIIIIIllllIl = "fire_resistance";
                    llllllllllllllIIlIIlIIIIIIlIlIIl = false;
                    break;
                }
                case 4: {
                    final String llllllllllllllIIlIIlIIIIIIllllII = "poison";
                    break;
                }
                case 5: {
                    final String llllllllllllllIIlIIlIIIIIIlllIll = "healing";
                    llllllllllllllIIlIIlIIIIIIlIlIII = false;
                    break;
                }
                case 6: {
                    final String llllllllllllllIIlIIlIIIIIIlllIlI = "night_vision";
                    llllllllllllllIIlIIlIIIIIIlIlIIl = false;
                    break;
                }
                case 8: {
                    final String llllllllllllllIIlIIlIIIIIIlllIIl = "weakness";
                    llllllllllllllIIlIIlIIIIIIlIlIIl = false;
                    break;
                }
                case 9: {
                    final String llllllllllllllIIlIIlIIIIIIlllIII = "strength";
                    break;
                }
                case 10: {
                    final String llllllllllllllIIlIIlIIIIIIllIlll = "slowness";
                    llllllllllllllIIlIIlIIIIIIlIlIIl = false;
                    break;
                }
                case 11: {
                    final String llllllllllllllIIlIIlIIIIIIllIllI = "leaping";
                    break;
                }
                case 12: {
                    final String llllllllllllllIIlIIlIIIIIIllIlIl = "harming";
                    llllllllllllllIIlIIlIIIIIIlIlIII = false;
                    break;
                }
                case 13: {
                    final String llllllllllllllIIlIIlIIIIIIllIlII = "water_breathing";
                    llllllllllllllIIlIIlIIIIIIlIlIIl = false;
                    break;
                }
                case 14: {
                    final String llllllllllllllIIlIIlIIIIIIllIIll = "invisibility";
                    llllllllllllllIIlIIlIIIIIIlIlIIl = false;
                    break;
                }
                default: {
                    llllllllllllllIIlIIlIIIIIIlIlIIl = false;
                    llllllllllllllIIlIIlIIIIIIlIlIII = false;
                    switch (llllllllllllllIIlIIlIIIIIIlIllII) {
                        case 0: {
                            final String llllllllllllllIIlIIlIIIIIIllIIlI = "mundane";
                            break Label_0325;
                        }
                        case 16: {
                            final String llllllllllllllIIlIIlIIIIIIllIIIl = "awkward";
                            break Label_0325;
                        }
                        case 32: {
                            final String llllllllllllllIIlIIlIIIIIIllIIII = "thick";
                            break Label_0325;
                        }
                        default: {
                            llllllllllllllIIlIIlIIIIIIlIIlll = "empty";
                            break Label_0325;
                        }
                    }
                    break;
                }
            }
        }
        if (llllllllllllllIIlIIlIIIIIIlIllIl > 0) {
            if (llllllllllllllIIlIIlIIIIIIlIlIIl && llllllllllllllIIlIIlIIIIIIlIlIll) {
                llllllllllllllIIlIIlIIIIIIlIIlll = String.valueOf(new StringBuilder().append("strong_").append(llllllllllllllIIlIIlIIIIIIlIIlll));
            }
            else if (llllllllllllllIIlIIlIIIIIIlIlIII && llllllllllllllIIlIIlIIIIIIlIlIlI) {
                llllllllllllllIIlIIlIIIIIIlIIlll = String.valueOf(new StringBuilder().append("long_").append(llllllllllllllIIlIIlIIIIIIlIIlll));
            }
        }
        return llllllllllllllIIlIIlIIIIIIlIIlll;
    }
    
    private static void registerEntity(final int llllllllllllllIIlIIlIIIIIIIlIIll, final String llllllllllllllIIlIIlIIIIIIIlIIlI) {
        ItemRewriter.ENTTIY_ID_TO_NAME.put(llllllllllllllIIlIIlIIIIIIIlIIll, llllllllllllllIIlIIlIIIIIIIlIIlI);
        ItemRewriter.ENTTIY_NAME_TO_ID.put(llllllllllllllIIlIIlIIIIIIIlIIlI, llllllllllllllIIlIIlIIIIIIIlIIll);
    }
    
    public static void toClient(final Item llllllllllllllIIlIIlIIIIIlIIlllI) {
        if (llllllllllllllIIlIIlIIIIIlIIlllI != null) {
            if (llllllllllllllIIlIIlIIIIIlIIlllI.identifier() == 383 && llllllllllllllIIlIIlIIIIIlIIlllI.data() != 0) {
                CompoundTag llllllllllllllIIlIIlIIIIIlIllIII = llllllllllllllIIlIIlIIIIIlIIlllI.tag();
                if (llllllllllllllIIlIIlIIIIIlIllIII == null) {
                    llllllllllllllIIlIIlIIIIIlIllIII = new CompoundTag();
                }
                final CompoundTag llllllllllllllIIlIIlIIIIIlIlIlll = new CompoundTag();
                final String llllllllllllllIIlIIlIIIIIlIlIllI = ItemRewriter.ENTTIY_ID_TO_NAME.get((int)llllllllllllllIIlIIlIIIIIlIIlllI.data());
                if (llllllllllllllIIlIIlIIIIIlIlIllI != null) {
                    final StringTag llllllllllllllIIlIIlIIIIIlIllIIl = new StringTag(llllllllllllllIIlIIlIIIIIlIlIllI);
                    llllllllllllllIIlIIlIIIIIlIlIlll.put("id", llllllllllllllIIlIIlIIIIIlIllIIl);
                    llllllllllllllIIlIIlIIIIIlIllIII.put("EntityTag", llllllllllllllIIlIIlIIIIIlIlIlll);
                }
                llllllllllllllIIlIIlIIIIIlIIlllI.setTag(llllllllllllllIIlIIlIIIIIlIllIII);
                llllllllllllllIIlIIlIIIIIlIIlllI.setData((short)0);
            }
            if (llllllllllllllIIlIIlIIIIIlIIlllI.identifier() == 373) {
                CompoundTag llllllllllllllIIlIIlIIIIIlIlIlIl = llllllllllllllIIlIIlIIIIIlIIlllI.tag();
                if (llllllllllllllIIlIIlIIIIIlIlIlIl == null) {
                    llllllllllllllIIlIIlIIIIIlIlIlIl = new CompoundTag();
                }
                if (llllllllllllllIIlIIlIIIIIlIIlllI.data() >= 16384) {
                    llllllllllllllIIlIIlIIIIIlIIlllI.setIdentifier(438);
                    llllllllllllllIIlIIlIIIIIlIIlllI.setData((short)(llllllllllllllIIlIIlIIIIIlIIlllI.data() - 8192));
                }
                final String llllllllllllllIIlIIlIIIIIlIlIlII = potionNameFromDamage(llllllllllllllIIlIIlIIIIIlIIlllI.data());
                final StringTag llllllllllllllIIlIIlIIIIIlIlIIll = new StringTag(String.valueOf(new StringBuilder().append("minecraft:").append(llllllllllllllIIlIIlIIIIIlIlIlII)));
                llllllllllllllIIlIIlIIIIIlIlIlIl.put("Potion", llllllllllllllIIlIIlIIIIIlIlIIll);
                llllllllllllllIIlIIlIIIIIlIIlllI.setTag(llllllllllllllIIlIIlIIIIIlIlIlIl);
                llllllllllllllIIlIIlIIIIIlIIlllI.setData((short)0);
            }
            if (llllllllllllllIIlIIlIIIIIlIIlllI.identifier() == 387) {
                CompoundTag llllllllllllllIIlIIlIIIIIlIlIIII = llllllllllllllIIlIIlIIIIIlIIlllI.tag();
                if (llllllllllllllIIlIIlIIIIIlIlIIII == null) {
                    llllllllllllllIIlIIlIIIIIlIlIIII = new CompoundTag();
                }
                ListTag llllllllllllllIIlIIlIIIIIlIIllll = llllllllllllllIIlIIlIIIIIlIlIIII.get("pages");
                if (llllllllllllllIIlIIlIIIIIlIIllll == null) {
                    llllllllllllllIIlIIlIIIIIlIIllll = new ListTag((List<Tag>)Collections.singletonList(new StringTag(Protocol1_9To1_8.fixJson("").toString())));
                    llllllllllllllIIlIIlIIIIIlIlIIII.put("pages", llllllllllllllIIlIIlIIIIIlIIllll);
                    llllllllllllllIIlIIlIIIIIlIIlllI.setTag(llllllllllllllIIlIIlIIIIIlIlIIII);
                    return;
                }
                for (int llllllllllllllIIlIIlIIIIIlIlIIIl = 0; llllllllllllllIIlIIlIIIIIlIlIIIl < llllllllllllllIIlIIlIIIIIlIIllll.size(); ++llllllllllllllIIlIIlIIIIIlIlIIIl) {
                    if (llllllllllllllIIlIIlIIIIIlIIllll.get(llllllllllllllIIlIIlIIIIIlIlIIIl) instanceof StringTag) {
                        final StringTag llllllllllllllIIlIIlIIIIIlIlIIlI = llllllllllllllIIlIIlIIIIIlIIllll.get(llllllllllllllIIlIIlIIIIIlIlIIIl);
                        llllllllllllllIIlIIlIIIIIlIlIIlI.setValue(Protocol1_9To1_8.fixJson(llllllllllllllIIlIIlIIIIIlIlIIlI.getValue()).toString());
                    }
                }
                llllllllllllllIIlIIlIIIIIlIIlllI.setTag(llllllllllllllIIlIIlIIIIIlIlIIII);
            }
        }
    }
    
    static {
        ENTTIY_NAME_TO_ID = new HashMap<String, Integer>();
        ENTTIY_ID_TO_NAME = new HashMap<Integer, String>();
        POTION_NAME_TO_ID = new HashMap<String, Integer>();
        POTION_ID_TO_NAME = new HashMap<Integer, String>();
        POTION_INDEX = new Int2IntOpenHashMap(36, 1.0f);
        registerEntity(1, "Item");
        registerEntity(2, "XPOrb");
        registerEntity(7, "ThrownEgg");
        registerEntity(8, "LeashKnot");
        registerEntity(9, "Painting");
        registerEntity(10, "Arrow");
        registerEntity(11, "Snowball");
        registerEntity(12, "Fireball");
        registerEntity(13, "SmallFireball");
        registerEntity(14, "ThrownEnderpearl");
        registerEntity(15, "EyeOfEnderSignal");
        registerEntity(16, "ThrownPotion");
        registerEntity(17, "ThrownExpBottle");
        registerEntity(18, "ItemFrame");
        registerEntity(19, "WitherSkull");
        registerEntity(20, "PrimedTnt");
        registerEntity(21, "FallingSand");
        registerEntity(22, "FireworksRocketEntity");
        registerEntity(30, "ArmorStand");
        registerEntity(40, "MinecartCommandBlock");
        registerEntity(41, "Boat");
        registerEntity(42, "MinecartRideable");
        registerEntity(43, "MinecartChest");
        registerEntity(44, "MinecartFurnace");
        registerEntity(45, "MinecartTNT");
        registerEntity(46, "MinecartHopper");
        registerEntity(47, "MinecartSpawner");
        registerEntity(48, "Mob");
        registerEntity(49, "Monster");
        registerEntity(50, "Creeper");
        registerEntity(51, "Skeleton");
        registerEntity(52, "Spider");
        registerEntity(53, "Giant");
        registerEntity(54, "Zombie");
        registerEntity(55, "Slime");
        registerEntity(56, "Ghast");
        registerEntity(57, "PigZombie");
        registerEntity(58, "Enderman");
        registerEntity(59, "CaveSpider");
        registerEntity(60, "Silverfish");
        registerEntity(61, "Blaze");
        registerEntity(62, "LavaSlime");
        registerEntity(63, "EnderDragon");
        registerEntity(64, "WitherBoss");
        registerEntity(65, "Bat");
        registerEntity(66, "Witch");
        registerEntity(67, "Endermite");
        registerEntity(68, "Guardian");
        registerEntity(90, "Pig");
        registerEntity(91, "Sheep");
        registerEntity(92, "Cow");
        registerEntity(93, "Chicken");
        registerEntity(94, "Squid");
        registerEntity(95, "Wolf");
        registerEntity(96, "MushroomCow");
        registerEntity(97, "SnowMan");
        registerEntity(98, "Ozelot");
        registerEntity(99, "VillagerGolem");
        registerEntity(100, "EntityHorse");
        registerEntity(101, "Rabbit");
        registerEntity(120, "Villager");
        registerEntity(200, "EnderCrystal");
        registerPotion(-1, "empty");
        registerPotion(0, "water");
        registerPotion(64, "mundane");
        registerPotion(32, "thick");
        registerPotion(16, "awkward");
        registerPotion(8198, "night_vision");
        registerPotion(8262, "long_night_vision");
        registerPotion(8206, "invisibility");
        registerPotion(8270, "long_invisibility");
        registerPotion(8203, "leaping");
        registerPotion(8267, "long_leaping");
        registerPotion(8235, "strong_leaping");
        registerPotion(8195, "fire_resistance");
        registerPotion(8259, "long_fire_resistance");
        registerPotion(8194, "swiftness");
        registerPotion(8258, "long_swiftness");
        registerPotion(8226, "strong_swiftness");
        registerPotion(8202, "slowness");
        registerPotion(8266, "long_slowness");
        registerPotion(8205, "water_breathing");
        registerPotion(8269, "long_water_breathing");
        registerPotion(8261, "healing");
        registerPotion(8229, "strong_healing");
        registerPotion(8204, "harming");
        registerPotion(8236, "strong_harming");
        registerPotion(8196, "poison");
        registerPotion(8260, "long_poison");
        registerPotion(8228, "strong_poison");
        registerPotion(8193, "regeneration");
        registerPotion(8257, "long_regeneration");
        registerPotion(8225, "strong_regeneration");
        registerPotion(8201, "strength");
        registerPotion(8265, "long_strength");
        registerPotion(8233, "strong_strength");
        registerPotion(8200, "weakness");
        registerPotion(8264, "long_weakness");
    }
    
    private static void registerPotion(final int llllllllllllllIIlIIlIIIIIIIIllll, final String llllllllllllllIIlIIlIIIIIIIIllII) {
        ItemRewriter.POTION_INDEX.put(llllllllllllllIIlIIlIIIIIIIIllll, ItemRewriter.POTION_ID_TO_NAME.size());
        ItemRewriter.POTION_ID_TO_NAME.put(llllllllllllllIIlIIlIIIIIIIIllll, llllllllllllllIIlIIlIIIIIIIIllII);
        ItemRewriter.POTION_NAME_TO_ID.put(llllllllllllllIIlIIlIIIIIIIIllII, llllllllllllllIIlIIlIIIIIIIIllll);
    }
}
