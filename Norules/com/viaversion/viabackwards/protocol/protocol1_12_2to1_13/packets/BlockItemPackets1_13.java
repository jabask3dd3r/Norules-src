package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.google.common.primitives.*;
import com.viaversion.viabackwards.api.rewriters.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.*;

public class BlockItemPackets1_13 extends ItemRewriter<Protocol1_12_2To1_13>
{
    private final /* synthetic */ Map<String, String> enchantmentMappings;
    private final /* synthetic */ String extraNbtTag;
    
    public static boolean isDamageable(final int llllllllllllllIIIlIllllIlIllllII) {
        return (llllllllllllllIIIlIllllIlIllllII >= 256 && llllllllllllllIIIlIllllIlIllllII <= 259) || llllllllllllllIIIlIllllIlIllllII == 261 || (llllllllllllllIIIlIllllIlIllllII >= 267 && llllllllllllllIIIlIllllIlIllllII <= 279) || (llllllllllllllIIIlIllllIlIllllII >= 283 && llllllllllllllIIIlIllllIlIllllII <= 286) || (llllllllllllllIIIlIllllIlIllllII >= 290 && llllllllllllllIIIlIllllIlIllllII <= 294) || (llllllllllllllIIIlIllllIlIllllII >= 298 && llllllllllllllIIIlIllllIlIllllII <= 317) || llllllllllllllIIIlIllllIlIllllII == 346 || llllllllllllllIIIlIllllIlIllllII == 359 || llllllllllllllIIIlIllllIlIllllII == 398 || llllllllllllllIIIlIllllIlIllllII == 442 || llllllllllllllIIIlIllllIlIllllII == 443;
    }
    
    @Override
    public Item handleItemToClient(final Item llllllllllllllIIIlIllllIlIlIIllI) {
        if (llllllllllllllIIIlIllllIlIlIIllI == null) {
            return null;
        }
        final int llllllllllllllIIIlIllllIlIlIIlIl = llllllllllllllIIIlIllllIlIlIIllI.identifier();
        Integer llllllllllllllIIIlIllllIlIlIIlII = null;
        boolean llllllllllllllIIIlIllllIlIlIIIll = false;
        CompoundTag llllllllllllllIIIlIllllIlIlIIIlI = llllllllllllllIIIlIllllIlIlIIllI.tag();
        final Tag llllllllllllllIIIlIllllIlIlIllII;
        if (llllllllllllllIIIlIllllIlIlIIIlI != null && (llllllllllllllIIIlIllllIlIlIllII = llllllllllllllIIIlIllllIlIlIIIlI.remove(this.extraNbtTag)) != null) {
            llllllllllllllIIIlIllllIlIlIIlII = ((NumberTag)llllllllllllllIIIlIllllIlIlIllII).asInt();
            llllllllllllllIIIlIllllIlIlIIIll = true;
        }
        if (llllllllllllllIIIlIllllIlIlIIlII == null) {
            super.handleItemToClient(llllllllllllllIIIlIllllIlIlIIllI);
            if (llllllllllllllIIIlIllllIlIlIIllI.identifier() == -1) {
                if (llllllllllllllIIIlIllllIlIlIIlIl == 362) {
                    llllllllllllllIIIlIllllIlIlIIlII = 15007744;
                }
                else {
                    if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                        ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Failed to get 1.12 item for ").append(llllllllllllllIIIlIllllIlIlIIlIl)));
                    }
                    llllllllllllllIIIlIllllIlIlIIlII = 65536;
                }
            }
            else {
                if (llllllllllllllIIIlIllllIlIlIIIlI == null) {
                    llllllllllllllIIIlIllllIlIlIIIlI = llllllllllllllIIIlIllllIlIlIIllI.tag();
                }
                llllllllllllllIIIlIllllIlIlIIlII = this.itemIdToRaw(llllllllllllllIIIlIllllIlIlIIllI.identifier(), llllllllllllllIIIlIllllIlIlIIllI, llllllllllllllIIIlIllllIlIlIIIlI);
            }
        }
        llllllllllllllIIIlIllllIlIlIIllI.setIdentifier(llllllllllllllIIIlIllllIlIlIIlII >> 16);
        llllllllllllllIIIlIllllIlIlIIllI.setData((short)(llllllllllllllIIIlIllllIlIlIIlII & 0xFFFF));
        if (llllllllllllllIIIlIllllIlIlIIIlI != null) {
            if (isDamageable(llllllllllllllIIIlIllllIlIlIIllI.identifier())) {
                final Tag llllllllllllllIIIlIllllIlIlIlIll = llllllllllllllIIIlIllllIlIlIIIlI.remove("Damage");
                if (!llllllllllllllIIIlIllllIlIlIIIll && llllllllllllllIIIlIllllIlIlIlIll instanceof IntTag) {
                    llllllllllllllIIIlIllllIlIlIIllI.setData((short)(int)llllllllllllllIIIlIllllIlIlIlIll.getValue());
                }
            }
            if (llllllllllllllIIIlIllllIlIlIIllI.identifier() == 358) {
                final Tag llllllllllllllIIIlIllllIlIlIlIlI = llllllllllllllIIIlIllllIlIlIIIlI.remove("map");
                if (!llllllllllllllIIIlIllllIlIlIIIll && llllllllllllllIIIlIllllIlIlIlIlI instanceof IntTag) {
                    llllllllllllllIIIlIllllIlIlIIllI.setData((short)(int)llllllllllllllIIIlIllllIlIlIlIlI.getValue());
                }
            }
            this.invertShieldAndBannerId(llllllllllllllIIIlIllllIlIlIIllI, llllllllllllllIIIlIllllIlIlIIIlI);
            final CompoundTag llllllllllllllIIIlIllllIlIlIlIII = llllllllllllllIIIlIllllIlIlIIIlI.get("display");
            if (llllllllllllllIIIlIllllIlIlIlIII != null) {
                final StringTag llllllllllllllIIIlIllllIlIlIlIIl = llllllllllllllIIIlIllllIlIlIlIII.get("Name");
                if (llllllllllllllIIIlIllllIlIlIlIIl != null) {
                    llllllllllllllIIIlIllllIlIlIlIII.put(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|Name")), new StringTag(llllllllllllllIIIlIllllIlIlIlIIl.getValue()));
                    llllllllllllllIIIlIllllIlIlIlIIl.setValue(ChatRewriter.jsonToLegacyText(llllllllllllllIIIlIllllIlIlIlIIl.getValue()));
                }
            }
            this.rewriteEnchantmentsToClient(llllllllllllllIIIlIllllIlIlIIIlI, false);
            this.rewriteEnchantmentsToClient(llllllllllllllIIIlIllllIlIlIIIlI, true);
            this.rewriteCanPlaceToClient(llllllllllllllIIIlIllllIlIlIIIlI, "CanPlaceOn");
            this.rewriteCanPlaceToClient(llllllllllllllIIIlIllllIlIlIIIlI, "CanDestroy");
        }
        return llllllllllllllIIIlIllllIlIlIIllI;
    }
    
    private void invertShieldAndBannerId(final Item llllllllllllllIIIlIlllIllIIlIIll, final CompoundTag llllllllllllllIIIlIlllIllIIllIII) {
        if (llllllllllllllIIIlIlllIllIIlIIll.identifier() != 442 && llllllllllllllIIIlIlllIllIIlIIll.identifier() != 425) {
            return;
        }
        final Tag llllllllllllllIIIlIlllIllIIlIlll = llllllllllllllIIIlIlllIllIIllIII.get("BlockEntityTag");
        if (!(llllllllllllllIIIlIlllIllIIlIlll instanceof CompoundTag)) {
            return;
        }
        final CompoundTag llllllllllllllIIIlIlllIllIIlIllI = (CompoundTag)llllllllllllllIIIlIlllIllIIlIlll;
        final Tag llllllllllllllIIIlIlllIllIIlIlIl = llllllllllllllIIIlIlllIllIIlIllI.get("Base");
        if (llllllllllllllIIIlIlllIllIIlIlIl instanceof IntTag) {
            final IntTag llllllllllllllIIIlIlllIllIIllllI = (IntTag)llllllllllllllIIIlIlllIllIIlIlIl;
            llllllllllllllIIIlIlllIllIIllllI.setValue(15 - llllllllllllllIIIlIlllIllIIllllI.asInt());
        }
        final Tag llllllllllllllIIIlIlllIllIIlIlII = llllllllllllllIIIlIlllIllIIlIllI.get("Patterns");
        if (llllllllllllllIIIlIlllIllIIlIlII instanceof ListTag) {
            final ListTag llllllllllllllIIIlIlllIllIIllIll = (ListTag)llllllllllllllIIIlIlllIllIIlIlII;
            for (final Tag llllllllllllllIIIlIlllIllIIlllII : llllllllllllllIIIlIlllIllIIllIll) {
                if (!(llllllllllllllIIIlIlllIllIIlllII instanceof CompoundTag)) {
                    continue;
                }
                final IntTag llllllllllllllIIIlIlllIllIIlllIl = ((CompoundTag)llllllllllllllIIIlIlllIllIIlllII).get("Color");
                llllllllllllllIIIlIlllIllIIlllIl.setValue(15 - llllllllllllllIIIlIlllIllIIlllIl.asInt());
            }
        }
    }
    
    private void rewriteEnchantmentsToClient(final CompoundTag llllllllllllllIIIlIllllIIIlllllI, final boolean llllllllllllllIIIlIllllIIIllllIl) {
        final String llllllllllllllIIIlIllllIIIllllII = llllllllllllllIIIlIllllIIIllllIl ? "StoredEnchantments" : "Enchantments";
        final ListTag llllllllllllllIIIlIllllIIIlllIll = llllllllllllllIIIlIllllIIIlllllI.get(llllllllllllllIIIlIllllIIIllllII);
        if (llllllllllllllIIIlIllllIIIlllIll == null) {
            return;
        }
        final ListTag llllllllllllllIIIlIllllIIIlllIlI = new ListTag(CompoundTag.class);
        final ListTag llllllllllllllIIIlIllllIIIlllIIl = new ListTag(CompoundTag.class);
        final List<Tag> llllllllllllllIIIlIllllIIIlllIII = new ArrayList<Tag>();
        boolean llllllllllllllIIIlIllllIIIllIlll = false;
        for (final Tag llllllllllllllIIIlIllllIIlIIIlll : llllllllllllllIIIlIllllIIIlllIll.clone()) {
            final CompoundTag llllllllllllllIIIlIllllIIlIIllIl = (CompoundTag)llllllllllllllIIIlIllllIIlIIIlll;
            final Tag llllllllllllllIIIlIllllIIlIIllII = llllllllllllllIIIlIllllIIlIIllIl.get("id");
            if (!(llllllllllllllIIIlIllllIIlIIllII instanceof StringTag)) {
                continue;
            }
            final String llllllllllllllIIIlIllllIIlIIlIll = (String)llllllllllllllIIIlIllllIIlIIllII.getValue();
            final int llllllllllllllIIIlIllllIIlIIlIlI = llllllllllllllIIIlIllllIIlIIllIl.get("lvl").asInt();
            final short llllllllllllllIIIlIllllIIlIIlIIl = (short)((llllllllllllllIIIlIllllIIlIIlIlI < 32767) ? ((short)llllllllllllllIIIlIllllIIlIIlIlI) : 32767);
            final String llllllllllllllIIIlIllllIIlIIlIII = this.enchantmentMappings.get(llllllllllllllIIIlIllllIIlIIlIll);
            if (llllllllllllllIIIlIllllIIlIIlIII != null) {
                llllllllllllllIIIlIllllIIIlllIII.add(new StringTag(String.valueOf(new StringBuilder().append(llllllllllllllIIIlIllllIIlIIlIII).append(" ").append(EnchantmentRewriter.getRomanNumber(llllllllllllllIIIlIllllIIlIIlIIl)))));
                llllllllllllllIIIlIllllIIIlllIlI.add(llllllllllllllIIIlIllllIIlIIllIl);
            }
            else {
                if (llllllllllllllIIIlIllllIIlIIlIll.isEmpty()) {
                    continue;
                }
                Short llllllllllllllIIIlIllllIIlIIllll = (Short)Protocol1_13To1_12_2.MAPPINGS.getOldEnchantmentsIds().inverse().get((Object)llllllllllllllIIIlIllllIIlIIlIll);
                if (llllllllllllllIIIlIllllIIlIIllll == null) {
                    if (!llllllllllllllIIIlIllllIIlIIlIll.startsWith("viaversion:legacy/")) {
                        llllllllllllllIIIlIllllIIIlllIlI.add(llllllllllllllIIIlIllllIIlIIllIl);
                        if (ViaBackwards.getConfig().addCustomEnchantsToLore()) {
                            String llllllllllllllIIIlIllllIIlIlIIIl = llllllllllllllIIIlIllllIIlIIlIll;
                            final int llllllllllllllIIIlIllllIIlIlIIII = llllllllllllllIIIlIllllIIlIlIIIl.indexOf(58) + 1;
                            if (llllllllllllllIIIlIllllIIlIlIIII != 0 && llllllllllllllIIIlIllllIIlIlIIII != llllllllllllllIIIlIllllIIlIlIIIl.length()) {
                                llllllllllllllIIIlIllllIIlIlIIIl = llllllllllllllIIIlIllllIIlIlIIIl.substring(llllllllllllllIIIlIllllIIlIlIIII);
                            }
                            llllllllllllllIIIlIllllIIlIlIIIl = String.valueOf(new StringBuilder().append("§7").append(Character.toUpperCase(llllllllllllllIIIlIllllIIlIlIIIl.charAt(0))).append(llllllllllllllIIIlIllllIIlIlIIIl.substring(1).toLowerCase(Locale.ENGLISH)));
                            llllllllllllllIIIlIllllIIIlllIII.add(new StringTag(String.valueOf(new StringBuilder().append(llllllllllllllIIIlIllllIIlIlIIIl).append(" ").append(EnchantmentRewriter.getRomanNumber(llllllllllllllIIIlIllllIIlIIlIIl)))));
                        }
                        if (Via.getManager().isDebug()) {
                            ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Found unknown enchant: ").append(llllllllllllllIIIlIllllIIlIIlIll)));
                            continue;
                        }
                        continue;
                    }
                    else {
                        llllllllllllllIIIlIllllIIlIIllll = Short.valueOf(llllllllllllllIIIlIllllIIlIIlIll.substring(18));
                    }
                }
                if (llllllllllllllIIIlIllllIIlIIlIIl != 0) {
                    llllllllllllllIIIlIllllIIIllIlll = true;
                }
                final CompoundTag llllllllllllllIIIlIllllIIlIIlllI = new CompoundTag();
                llllllllllllllIIIlIllllIIlIIlllI.put("id", new ShortTag(llllllllllllllIIIlIllllIIlIIllll));
                llllllllllllllIIIlIllllIIlIIlllI.put("lvl", new ShortTag(llllllllllllllIIIlIllllIIlIIlIIl));
                llllllllllllllIIIlIllllIIIlllIIl.add(llllllllllllllIIIlIllllIIlIIlllI);
            }
        }
        if (!llllllllllllllIIIlIllllIIIllllIl && !llllllllllllllIIIlIllllIIIllIlll) {
            IntTag llllllllllllllIIIlIllllIIlIIIlIl = llllllllllllllIIIlIllllIIIlllllI.get("HideFlags");
            if (llllllllllllllIIIlIllllIIlIIIlIl == null) {
                llllllllllllllIIIlIllllIIlIIIlIl = new IntTag();
                llllllllllllllIIIlIllllIIIlllllI.put(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|DummyEnchant")), new ByteTag());
            }
            else {
                llllllllllllllIIIlIllllIIIlllllI.put(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|OldHideFlags")), new IntTag(llllllllllllllIIIlIllllIIlIIIlIl.asByte()));
            }
            if (llllllllllllllIIIlIllllIIIlllIIl.size() == 0) {
                final CompoundTag llllllllllllllIIIlIllllIIlIIIllI = new CompoundTag();
                llllllllllllllIIIlIllllIIlIIIllI.put("id", new ShortTag((short)0));
                llllllllllllllIIIlIllllIIlIIIllI.put("lvl", new ShortTag((short)0));
                llllllllllllllIIIlIllllIIIlllIIl.add(llllllllllllllIIIlIllllIIlIIIllI);
            }
            final int llllllllllllllIIIlIllllIIlIIIlII = llllllllllllllIIIlIllllIIlIIIlIl.asByte() | 0x1;
            llllllllllllllIIIlIllllIIlIIIlIl.setValue(llllllllllllllIIIlIllllIIlIIIlII);
            llllllllllllllIIIlIllllIIIlllllI.put("HideFlags", llllllllllllllIIIlIllllIIlIIIlIl);
        }
        if (llllllllllllllIIIlIllllIIIlllIlI.size() != 0) {
            llllllllllllllIIIlIllllIIIlllllI.put(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|").append(llllllllllllllIIIlIllllIIIllllII)), llllllllllllllIIIlIllllIIIlllIlI);
            if (!llllllllllllllIIIlIllllIIIlllIII.isEmpty()) {
                CompoundTag llllllllllllllIIIlIllllIIlIIIIIl = llllllllllllllIIIlIllllIIIlllllI.get("display");
                if (llllllllllllllIIIlIllllIIlIIIIIl == null) {
                    llllllllllllllIIIlIllllIIIlllllI.put("display", llllllllllllllIIIlIllllIIlIIIIIl = new CompoundTag());
                }
                ListTag llllllllllllllIIIlIllllIIlIIIIII = llllllllllllllIIIlIllllIIlIIIIIl.get("Lore");
                if (llllllllllllllIIIlIllllIIlIIIIII == null) {
                    llllllllllllllIIIlIllllIIlIIIIIl.put("Lore", llllllllllllllIIIlIllllIIlIIIIII = new ListTag(StringTag.class));
                    llllllllllllllIIIlIllllIIIlllllI.put(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|DummyLore")), new ByteTag());
                }
                else if (llllllllllllllIIIlIllllIIlIIIIII.size() != 0) {
                    final ListTag llllllllllllllIIIlIllllIIlIIIIlI = new ListTag(StringTag.class);
                    for (final Tag llllllllllllllIIIlIllllIIlIIIIll : llllllllllllllIIIlIllllIIlIIIIII) {
                        llllllllllllllIIIlIllllIIlIIIIlI.add(llllllllllllllIIIlIllllIIlIIIIll.clone());
                    }
                    llllllllllllllIIIlIllllIIIlllllI.put(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|OldLore")), llllllllllllllIIIlIllllIIlIIIIlI);
                    llllllllllllllIIIlIllllIIIlllIII.addAll(llllllllllllllIIIlIllllIIlIIIIII.getValue());
                }
                llllllllllllllIIIlIllllIIlIIIIII.setValue(llllllllllllllIIIlIllllIIIlllIII);
            }
        }
        llllllllllllllIIIlIllllIIIlllllI.remove("Enchantments");
        llllllllllllllIIIlIllllIIIlllllI.put(llllllllllllllIIIlIllllIIIllllIl ? llllllllllllllIIIlIllllIIIllllII : "ench", llllllllllllllIIIlIllllIIIlllIIl);
    }
    
    @Override
    public Item handleItemToServer(final Item llllllllllllllIIIlIllllIIIIlIIlI) {
        if (llllllllllllllIIIlIllllIIIIlIIlI == null) {
            return null;
        }
        CompoundTag llllllllllllllIIIlIllllIIIIlIIIl = llllllllllllllIIIlIllllIIIIlIIlI.tag();
        final int llllllllllllllIIIlIllllIIIIlIIII = llllllllllllllIIIlIllllIIIIlIIlI.identifier() << 16 | (llllllllllllllIIIlIllllIIIIlIIlI.data() & 0xFFFF);
        int llllllllllllllIIIlIllllIIIIIllll = llllllllllllllIIIlIllllIIIIlIIlI.identifier() << 4 | (llllllllllllllIIIlIllllIIIIlIIlI.data() & 0xF);
        if (isDamageable(llllllllllllllIIIlIllllIIIIlIIlI.identifier())) {
            if (llllllllllllllIIIlIllllIIIIlIIIl == null) {
                llllllllllllllIIIlIllllIIIIlIIlI.setTag(llllllllllllllIIIlIllllIIIIlIIIl = new CompoundTag());
            }
            llllllllllllllIIIlIllllIIIIlIIIl.put("Damage", new IntTag(llllllllllllllIIIlIllllIIIIlIIlI.data()));
        }
        if (llllllllllllllIIIlIllllIIIIlIIlI.identifier() == 358) {
            if (llllllllllllllIIIlIllllIIIIlIIIl == null) {
                llllllllllllllIIIlIllllIIIIlIIlI.setTag(llllllllllllllIIIlIllllIIIIlIIIl = new CompoundTag());
            }
            llllllllllllllIIIlIllllIIIIlIIIl.put("map", new IntTag(llllllllllllllIIIlIllllIIIIlIIlI.data()));
        }
        if (llllllllllllllIIIlIllllIIIIlIIIl != null) {
            this.invertShieldAndBannerId(llllllllllllllIIIlIllllIIIIlIIlI, llllllllllllllIIIlIllllIIIIlIIIl);
            final Tag llllllllllllllIIIlIllllIIIIlIlII = llllllllllllllIIIlIllllIIIIlIIIl.get("display");
            if (llllllllllllllIIIlIllllIIIIlIlII instanceof CompoundTag) {
                final CompoundTag llllllllllllllIIIlIllllIIIIllIII = (CompoundTag)llllllllllllllIIIlIllllIIIIlIlII;
                final StringTag llllllllllllllIIIlIllllIIIIlIlll = llllllllllllllIIIlIllllIIIIllIII.get("Name");
                if (llllllllllllllIIIlIllllIIIIlIlll != null) {
                    final StringTag llllllllllllllIIIlIllllIIIIllIIl = llllllllllllllIIIlIllllIIIIllIII.remove(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|Name")));
                    llllllllllllllIIIlIllllIIIIlIlll.setValue((llllllllllllllIIIlIllllIIIIllIIl != null) ? llllllllllllllIIIlIllllIIIIllIIl.getValue() : ChatRewriter.legacyTextToJsonString(llllllllllllllIIIlIllllIIIIlIlll.getValue()));
                }
            }
            this.rewriteEnchantmentsToServer(llllllllllllllIIIlIllllIIIIlIIIl, false);
            this.rewriteEnchantmentsToServer(llllllllllllllIIIlIllllIIIIlIIIl, true);
            this.rewriteCanPlaceToServer(llllllllllllllIIIlIllllIIIIlIIIl, "CanPlaceOn");
            this.rewriteCanPlaceToServer(llllllllllllllIIIlIllllIIIIlIIIl, "CanDestroy");
            if (llllllllllllllIIIlIllllIIIIlIIlI.identifier() == 383) {
                final CompoundTag llllllllllllllIIIlIllllIIIIlIlIl = llllllllllllllIIIlIllllIIIIlIIIl.get("EntityTag");
                final StringTag llllllllllllllIIIlIllllIIIIlIllI;
                if (llllllllllllllIIIlIllllIIIIlIlIl != null && (llllllllllllllIIIlIllllIIIIlIllI = llllllllllllllIIIlIllllIIIIlIlIl.get("id")) != null) {
                    llllllllllllllIIIlIllllIIIIIllll = SpawnEggRewriter.getSpawnEggId(llllllllllllllIIIlIllllIIIIlIllI.getValue());
                    if (llllllllllllllIIIlIllllIIIIIllll == -1) {
                        llllllllllllllIIIlIllllIIIIIllll = 25100288;
                    }
                    else {
                        llllllllllllllIIIlIllllIIIIlIlIl.remove("id");
                        if (llllllllllllllIIIlIllllIIIIlIlIl.isEmpty()) {
                            llllllllllllllIIIlIllllIIIIlIIIl.remove("EntityTag");
                        }
                    }
                }
                else {
                    llllllllllllllIIIlIllllIIIIIllll = 25100288;
                }
            }
            if (llllllllllllllIIIlIllllIIIIlIIIl.isEmpty()) {
                llllllllllllllIIIlIllllIIIIlIIlI.setTag(llllllllllllllIIIlIllllIIIIlIIIl = null);
            }
        }
        final int llllllllllllllIIIlIllllIIIIIlllI = llllllllllllllIIIlIllllIIIIlIIlI.identifier();
        llllllllllllllIIIlIllllIIIIlIIlI.setIdentifier(llllllllllllllIIIlIllllIIIIIllll);
        super.handleItemToServer(llllllllllllllIIIlIllllIIIIlIIlI);
        if (llllllllllllllIIIlIllllIIIIlIIlI.identifier() != llllllllllllllIIIlIllllIIIIIllll && llllllllllllllIIIlIllllIIIIlIIlI.identifier() != -1) {
            return llllllllllllllIIIlIllllIIIIlIIlI;
        }
        llllllllllllllIIIlIllllIIIIlIIlI.setIdentifier(llllllllllllllIIIlIllllIIIIIlllI);
        int llllllllllllllIIIlIllllIIIIIllIl = -1;
        if (!((Protocol1_12_2To1_13)this.protocol).getMappingData().getItemMappings().inverse().containsKey(llllllllllllllIIIlIllllIIIIIllll)) {
            if (!isDamageable(llllllllllllllIIIlIllllIIIIlIIlI.identifier()) && llllllllllllllIIIlIllllIIIIlIIlI.identifier() != 358) {
                if (llllllllllllllIIIlIllllIIIIlIIIl == null) {
                    llllllllllllllIIIlIllllIIIIlIIlI.setTag(llllllllllllllIIIlIllllIIIIlIIIl = new CompoundTag());
                }
                llllllllllllllIIIlIllllIIIIlIIIl.put(this.extraNbtTag, new IntTag(llllllllllllllIIIlIllllIIIIlIIII));
            }
            if (llllllllllllllIIIlIllllIIIIlIIlI.identifier() == 229) {
                llllllllllllllIIIlIllllIIIIIllIl = 362;
            }
            else if (llllllllllllllIIIlIllllIIIIlIIlI.identifier() == 31 && llllllllllllllIIIlIllllIIIIlIIlI.data() == 0) {
                llllllllllllllIIIlIllllIIIIIllll = 512;
            }
            else if (((Protocol1_12_2To1_13)this.protocol).getMappingData().getItemMappings().inverse().containsKey(llllllllllllllIIIlIllllIIIIIllll & 0xFFFFFFF0)) {
                llllllllllllllIIIlIllllIIIIIllll &= 0xFFFFFFF0;
            }
            else {
                if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                    ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Failed to get 1.13 item for ").append(llllllllllllllIIIlIllllIIIIlIIlI.identifier())));
                }
                llllllllllllllIIIlIllllIIIIIllll = 16;
            }
        }
        if (llllllllllllllIIIlIllllIIIIIllIl == -1) {
            llllllllllllllIIIlIllllIIIIIllIl = ((Protocol1_12_2To1_13)this.protocol).getMappingData().getItemMappings().inverse().get(llllllllllllllIIIlIllllIIIIIllll);
        }
        llllllllllllllIIIlIllllIIIIlIIlI.setIdentifier(llllllllllllllIIIlIllllIIIIIllIl);
        llllllllllllllIIIlIllllIIIIlIIlI.setData((short)0);
        return llllllllllllllIIIlIllllIIIIlIIlI;
    }
    
    private static void flowerPotSpecialTreatment(final UserConnection llllllllllllllIIIlIlllIlIlllllII, final int llllllllllllllIIIlIlllIlIllllIll, final Position llllllllllllllIIIlIlllIlIllllIlI) throws Exception {
        if (FlowerPotHandler.isFlowah(llllllllllllllIIIlIlllIlIllllIll)) {
            final BackwardsBlockEntityProvider llllllllllllllIIIlIlllIllIIIIIIl = Via.getManager().getProviders().get(BackwardsBlockEntityProvider.class);
            final CompoundTag llllllllllllllIIIlIlllIllIIIIIII = llllllllllllllIIIlIlllIllIIIIIIl.transform(llllllllllllllIIIlIlllIlIlllllII, llllllllllllllIIIlIlllIlIllllIlI, "minecraft:flower_pot");
            final PacketWrapper llllllllllllllIIIlIlllIlIlllllll = PacketWrapper.create(11, null, llllllllllllllIIIlIlllIlIlllllII);
            llllllllllllllIIIlIlllIlIlllllll.write(Type.POSITION, llllllllllllllIIIlIlllIlIllllIlI);
            llllllllllllllIIIlIlllIlIlllllll.write(Type.VAR_INT, 0);
            llllllllllllllIIIlIlllIlIlllllll.scheduleSend(Protocol1_12_2To1_13.class);
            final PacketWrapper llllllllllllllIIIlIlllIlIllllllI = PacketWrapper.create(11, null, llllllllllllllIIIlIlllIlIlllllII);
            llllllllllllllIIIlIlllIlIllllllI.write(Type.POSITION, llllllllllllllIIIlIlllIlIllllIlI);
            llllllllllllllIIIlIlllIlIllllllI.write(Type.VAR_INT, Protocol1_12_2To1_13.MAPPINGS.getNewBlockStateId(llllllllllllllIIIlIlllIlIllllIll));
            llllllllllllllIIIlIlllIlIllllllI.scheduleSend(Protocol1_12_2To1_13.class);
            final PacketWrapper llllllllllllllIIIlIlllIlIlllllIl = PacketWrapper.create(9, null, llllllllllllllIIIlIlllIlIlllllII);
            llllllllllllllIIIlIlllIlIlllllIl.write(Type.POSITION, llllllllllllllIIIlIlllIlIllllIlI);
            llllllllllllllIIIlIlllIlIlllllIl.write(Type.UNSIGNED_BYTE, (Short)5);
            llllllllllllllIIIlIlllIlIlllllIl.write(Type.NBT, llllllllllllllIIIlIlllIllIIIIIII);
            llllllllllllllIIIlIlllIlIlllllIl.scheduleSend(Protocol1_12_2To1_13.class);
        }
    }
    
    private void rewriteCanPlaceToClient(final CompoundTag llllllllllllllIIIlIllllIIlllIIIl, final String llllllllllllllIIIlIllllIIlllIIII) {
        if (!(llllllllllllllIIIlIllllIIlllIIIl.get(llllllllllllllIIIlIllllIIlllIIII) instanceof ListTag)) {
            return;
        }
        final ListTag llllllllllllllIIIlIllllIIlllIlII = llllllllllllllIIIlIllllIIlllIIIl.get(llllllllllllllIIIlIllllIIlllIIII);
        if (llllllllllllllIIIlIllllIIlllIlII == null) {
            return;
        }
        final ListTag llllllllllllllIIIlIllllIIlllIIll = new ListTag(StringTag.class);
        llllllllllllllIIIlIllllIIlllIIIl.put(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|").append(llllllllllllllIIIlIllllIIlllIIII)), ConverterRegistry.convertToTag(ConverterRegistry.convertToValue(llllllllllllllIIIlIllllIIlllIlII)));
        for (final Tag llllllllllllllIIIlIllllIIllllIII : llllllllllllllIIIlIllllIIlllIlII) {
            final Object llllllllllllllIIIlIllllIIllllIlI = llllllllllllllIIIlIllllIIllllIII.getValue();
            final String[] llllllllllllllIIIlIllllIIllllIIl = (llllllllllllllIIIlIllllIIllllIlI instanceof String) ? BlockIdData.fallbackReverseMapping.get(((String)llllllllllllllIIIlIllllIIllllIlI).replace("minecraft:", "")) : null;
            if (llllllllllllllIIIlIllllIIllllIIl != null) {
                final int llllllllllllllIIIlIllllIIllIlIIl = (Object)llllllllllllllIIIlIllllIIllllIIl;
                final long llllllllllllllIIIlIllllIIllIlIII = llllllllllllllIIIlIllllIIllIlIIl.length;
                for (short llllllllllllllIIIlIllllIIllIIlll = 0; llllllllllllllIIIlIllllIIllIIlll < llllllllllllllIIIlIllllIIllIlIII; ++llllllllllllllIIIlIllllIIllIIlll) {
                    final String llllllllllllllIIIlIllllIIllllIll = llllllllllllllIIIlIllllIIllIlIIl[llllllllllllllIIIlIllllIIllIIlll];
                    llllllllllllllIIIlIllllIIlllIIll.add(new StringTag(llllllllllllllIIIlIllllIIllllIll));
                }
            }
            else {
                llllllllllllllIIIlIllllIIlllIIll.add(llllllllllllllIIIlIllllIIllllIII);
            }
        }
        llllllllllllllIIIlIllllIIlllIIIl.put(llllllllllllllIIIlIllllIIlllIIII, llllllllllllllIIIlIllllIIlllIIll);
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.COOLDOWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIlIlllIIIlIIlIl) throws Exception {
                        int llllllllllllllIIIIlIlllIIIlIIlII = llllllllllllllIIIIlIlllIIIlIIlIl.read((Type<Integer>)Type.VAR_INT);
                        final int llllllllllllllIIIIlIlllIIIlIIIll = ((Protocol1_12_2To1_13)BlockItemPackets1_13.this.protocol).getMappingData().getItemMappings().get(llllllllllllllIIIIlIlllIIIlIIlII);
                        if (llllllllllllllIIIIlIlllIIIlIIIll != -1) {
                            final Optional<String> llllllllllllllIIIIlIlllIIIlIIlll = SpawnEggRewriter.getEntityId(llllllllllllllIIIIlIlllIIIlIIIll);
                            if (llllllllllllllIIIIlIlllIIIlIIlll.isPresent()) {
                                llllllllllllllIIIIlIlllIIIlIIlII = 25100288;
                            }
                            else {
                                llllllllllllllIIIIlIlllIIIlIIlII = (llllllllllllllIIIIlIlllIIIlIIIll >> 4 << 16 | (llllllllllllllIIIIlIlllIIIlIIIll & 0xF));
                            }
                        }
                        llllllllllllllIIIIlIlllIIIlIIlIl.write(Type.VAR_INT, llllllllllllllIIIIlIlllIIIlIIlII);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.BLOCK_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIlllIIllIIIIlIllI) throws Exception {
                        int llllllllllllllIIlllIIllIIIIlIlll = llllllllllllllIIlllIIllIIIIlIllI.get((Type<Integer>)Type.VAR_INT, 0);
                        if (llllllllllllllIIlllIIllIIIIlIlll == 73) {
                            llllllllllllllIIlllIIllIIIIlIlll = 25;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll == 99) {
                            llllllllllllllIIlllIIllIIIIlIlll = 33;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll == 92) {
                            llllllllllllllIIlllIIllIIIIlIlll = 29;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll == 142) {
                            llllllllllllllIIlllIIllIIIIlIlll = 54;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll == 305) {
                            llllllllllllllIIlllIIllIIIIlIlll = 146;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll == 249) {
                            llllllllllllllIIlllIIllIIIIlIlll = 130;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll == 257) {
                            llllllllllllllIIlllIIllIIIIlIlll = 138;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll == 140) {
                            llllllllllllllIIlllIIllIIIIlIlll = 52;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll == 472) {
                            llllllllllllllIIlllIIllIIIIlIlll = 209;
                        }
                        else if (llllllllllllllIIlllIIllIIIIlIlll >= 483 && llllllllllllllIIlllIIllIIIIlIlll <= 498) {
                            llllllllllllllIIlllIIllIIIIlIlll = llllllllllllllIIlllIIllIIIIlIlll - 483 + 219;
                        }
                        llllllllllllllIIlllIIllIIIIlIllI.set(Type.VAR_INT, 0, llllllllllllllIIlllIIllIIIIlIlll);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIIllIlIIlIllIlIl) throws Exception {
                        final BackwardsBlockEntityProvider llllllllllllllIlIIllIlIIlIllIlII = Via.getManager().getProviders().get(BackwardsBlockEntityProvider.class);
                        if (llllllllllllllIlIIllIlIIlIllIlIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 5) {
                            llllllllllllllIlIIllIlIIlIllIlIl.cancel();
                        }
                        llllllllllllllIlIIllIlIIlIllIlIl.set(Type.NBT, 0, llllllllllllllIlIIllIlIIlIllIlII.transform(llllllllllllllIlIIllIlIIlIllIlIl.user(), llllllllllllllIlIIllIlIIlIllIlIl.get(Type.POSITION, 0), llllllllllllllIlIIllIlIIlIllIlIl.get(Type.NBT, 0)));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.UNLOAD_CHUNK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIlIIIlIIlIlIIl) throws Exception {
                        final int llllllllllllllIllIIlIIIlIIlIlllI = llllllllllllllIllIIlIIIlIIlIlIIl.passthrough((Type<Integer>)Type.INT) << 4;
                        final int llllllllllllllIllIIlIIIlIIlIllIl = llllllllllllllIllIIlIIIlIIlIlIIl.passthrough((Type<Integer>)Type.INT) << 4;
                        final int llllllllllllllIllIIlIIIlIIlIllII = llllllllllllllIllIIlIIIlIIlIlllI + 15;
                        final int llllllllllllllIllIIlIIIlIIlIlIll = llllllllllllllIllIIlIIIlIIlIllIl + 15;
                        final BackwardsBlockStorage llllllllllllllIllIIlIIIlIIlIlIlI = llllllllllllllIllIIlIIIlIIlIlIIl.user().get(BackwardsBlockStorage.class);
                        final Position llllllllllllllIllIIlIIIlIIIllIII;
                        final int n;
                        final int n2;
                        final int n3;
                        final int n4;
                        llllllllllllllIllIIlIIIlIIlIlIlI.getBlocks().entrySet().removeIf(llllllllllllllIllIIlIIIlIIIllIIl -> {
                            llllllllllllllIllIIlIIIlIIIllIII = llllllllllllllIllIIlIIIlIIIllIIl.getKey();
                            return llllllllllllllIllIIlIIIlIIIllIII.getX() >= n && llllllllllllllIllIIlIIIlIIIllIII.getZ() >= n2 && llllllllllllllIllIIlIIIlIIIllIII.getX() <= n3 && llllllllllllllIllIIlIIIlIIIllIII.getZ() <= n4;
                        });
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllllIlIllllIlllIl) throws Exception {
                        final int lllllllllllllIIllllIlIlllllIIIIl = lllllllllllllIIllllIlIllllIlllIl.read((Type<Integer>)Type.VAR_INT);
                        final Position lllllllllllllIIllllIlIlllllIIIII = lllllllllllllIIllllIlIllllIlllIl.get(Type.POSITION, 0);
                        final BackwardsBlockStorage lllllllllllllIIllllIlIllllIlllll = lllllllllllllIIllllIlIllllIlllIl.user().get(BackwardsBlockStorage.class);
                        lllllllllllllIIllllIlIllllIlllll.checkAndStore(lllllllllllllIIllllIlIlllllIIIII, lllllllllllllIIllllIlIlllllIIIIl);
                        lllllllllllllIIllllIlIllllIlllIl.write(Type.VAR_INT, ((Protocol1_12_2To1_13)BlockItemPackets1_13.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIllllIlIlllllIIIIl));
                        flowerPotSpecialTreatment(lllllllllllllIIllllIlIllllIlllIl.user(), lllllllllllllIIllllIlIlllllIIIIl, lllllllllllllIIllllIlIlllllIIIII);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BLOCK_CHANGE_RECORD_ARRAY);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lIIllIllIIlIlI) throws Exception {
                        final BackwardsBlockStorage lIIllIllIIllII = lIIllIllIIlIlI.user().get(BackwardsBlockStorage.class);
                        final float lIIllIllIIlIII = lIIllIllIIlIlI.get((Type<Float>)Type.BLOCK_CHANGE_RECORD_ARRAY, 0);
                        final Exception lIIllIllIIIlll = (Exception)lIIllIllIIlIII.length;
                        for (short lIIllIllIIIllI = 0; lIIllIllIIIllI < lIIllIllIIIlll; ++lIIllIllIIIllI) {
                            final BlockChangeRecord lIIllIllIIllll = lIIllIllIIlIII[lIIllIllIIIllI];
                            final int lIIllIllIlIIll = lIIllIllIIlIlI.get((Type<Integer>)Type.INT, 0);
                            final int lIIllIllIlIIlI = lIIllIllIIlIlI.get((Type<Integer>)Type.INT, 1);
                            final int lIIllIllIlIIIl = lIIllIllIIllll.getBlockId();
                            final Position lIIllIllIlIIII = new Position(lIIllIllIIllll.getSectionX() + lIIllIllIlIIll * 16, lIIllIllIIllll.getY(), lIIllIllIIllll.getSectionZ() + lIIllIllIlIIlI * 16);
                            lIIllIllIIllII.checkAndStore(lIIllIllIlIIII, lIIllIllIlIIIl);
                            flowerPotSpecialTreatment(lIIllIllIIlIlI.user(), lIIllIllIlIIIl, lIIllIllIlIIII);
                            lIIllIllIIllll.setBlockId(((Protocol1_12_2To1_13)BlockItemPackets1_13.this.protocol).getMappingData().getNewBlockStateId(lIIllIllIlIIIl));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.FLAT_ITEM_ARRAY, Type.ITEM_ARRAY);
                this.handler(BlockItemPackets1_13.this.itemArrayHandler(Type.ITEM_ARRAY));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.FLAT_ITEM, Type.ITEM);
                this.handler(BlockItemPackets1_13.this.itemToClientHandler(Type.ITEM));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final ClientWorld lllllllllllllllIllIllIlIllllIllI;
                final Chunk1_9_3_4Type lllllllllllllllIllIllIlIllllIlIl;
                final Chunk1_13Type lllllllllllllllIllIllIlIllllIlII;
                final Chunk lllllllllllllllIllIllIlIllllIIll;
                final BackwardsBlockEntityProvider lllllllllllllllIllIllIlIllllIIlI;
                final BackwardsBlockStorage lllllllllllllllIllIllIlIllllIIIl;
                final Iterator<CompoundTag> iterator;
                CompoundTag lllllllllllllllIllIllIllIIIIIlll;
                Tag lllllllllllllllIllIllIllIIIlIIII;
                String lllllllllllllllIllIllIllIIIIllll;
                int lllllllllllllllIllIllIllIIIIlllI;
                ChunkSection lllllllllllllllIllIllIllIIIIllIl;
                int lllllllllllllllIllIllIllIIIIllII;
                int lllllllllllllllIllIllIllIIIIlIll;
                int lllllllllllllllIllIllIllIIIIlIlI;
                Position lllllllllllllllIllIllIllIIIIlIIl;
                int lllllllllllllllIllIllIllIIIIlIII;
                int lllllllllllllllIllIllIlIllllllII;
                ChunkSection lllllllllllllllIllIllIlIllllllIl;
                int lllllllllllllllIllIllIllIIIIIIIl;
                int lllllllllllllllIllIllIllIIIIIIlI;
                int lllllllllllllllIllIllIllIIIIIIll;
                int lllllllllllllllIllIllIllIIIIIlII;
                Position lllllllllllllllIllIllIllIIIIIllI;
                CompoundTag lllllllllllllllIllIllIllIIIIIlIl;
                int lllllllllllllllIllIllIlIlllllllI;
                int lllllllllllllllIllIllIlIllllllll;
                int lllllllllllllllIllIllIllIIIIIIII;
                int lllllllllllllllIllIllIlIlllllIIl;
                int lllllllllllllllIllIllIlIlllllIll;
                int lllllllllllllllIllIllIlIlllllIlI;
                this.handler(lllllllllllllllIllIllIlIllllIlll -> {
                    lllllllllllllllIllIllIlIllllIllI = lllllllllllllllIllIllIlIllllIlll.user().get(ClientWorld.class);
                    lllllllllllllllIllIllIlIllllIlIl = new Chunk1_9_3_4Type(lllllllllllllllIllIllIlIllllIllI);
                    lllllllllllllllIllIllIlIllllIlII = new Chunk1_13Type(lllllllllllllllIllIllIlIllllIllI);
                    lllllllllllllllIllIllIlIllllIIll = lllllllllllllllIllIllIlIllllIlll.read((Type<Chunk>)lllllllllllllllIllIllIlIllllIlII);
                    lllllllllllllllIllIllIlIllllIIlI = Via.getManager().getProviders().get(BackwardsBlockEntityProvider.class);
                    lllllllllllllllIllIllIlIllllIIIl = lllllllllllllllIllIllIlIllllIlll.user().get(BackwardsBlockStorage.class);
                    lllllllllllllllIllIllIlIllllIIll.getBlockEntities().iterator();
                    while (iterator.hasNext()) {
                        lllllllllllllllIllIllIllIIIIIlll = iterator.next();
                        lllllllllllllllIllIllIllIIIlIIII = lllllllllllllllIllIllIllIIIIIlll.get("id");
                        if (lllllllllllllllIllIllIllIIIlIIII == null) {
                            continue;
                        }
                        else {
                            lllllllllllllllIllIllIllIIIIllll = (String)lllllllllllllllIllIllIllIIIlIIII.getValue();
                            if (!lllllllllllllllIllIllIlIllllIIlI.isHandled(lllllllllllllllIllIllIllIIIIllll)) {
                                continue;
                            }
                            else {
                                lllllllllllllllIllIllIllIIIIlllI = lllllllllllllllIllIllIllIIIIIlll.get("y").asInt() >> 4;
                                if (lllllllllllllllIllIllIllIIIIlllI >= 0) {
                                    if (lllllllllllllllIllIllIllIIIIlllI > 15) {
                                        continue;
                                    }
                                    else {
                                        lllllllllllllllIllIllIllIIIIllIl = lllllllllllllllIllIllIlIllllIIll.getSections()[lllllllllllllllIllIllIllIIIIlllI];
                                        lllllllllllllllIllIllIllIIIIllII = lllllllllllllllIllIllIllIIIIIlll.get("x").asInt();
                                        lllllllllllllllIllIllIllIIIIlIll = lllllllllllllllIllIllIllIIIIIlll.get("y").asInt();
                                        lllllllllllllllIllIllIllIIIIlIlI = lllllllllllllllIllIllIllIIIIIlll.get("z").asInt();
                                        lllllllllllllllIllIllIllIIIIlIIl = new Position(lllllllllllllllIllIllIllIIIIllII, (short)lllllllllllllllIllIllIllIIIIlIll, lllllllllllllllIllIllIllIIIIlIlI);
                                        lllllllllllllllIllIllIllIIIIlIII = lllllllllllllllIllIllIllIIIIllIl.getFlatBlock(lllllllllllllllIllIllIllIIIIllII & 0xF, lllllllllllllllIllIllIllIIIIlIll & 0xF, lllllllllllllllIllIllIllIIIIlIlI & 0xF);
                                        lllllllllllllllIllIllIlIllllIIIl.checkAndStore(lllllllllllllllIllIllIllIIIIlIIl, lllllllllllllllIllIllIllIIIIlIII);
                                        lllllllllllllllIllIllIlIllllIIlI.transform(lllllllllllllllIllIllIlIllllIlll.user(), lllllllllllllllIllIllIllIIIIlIIl, lllllllllllllllIllIllIllIIIIIlll);
                                    }
                                }
                                else {
                                    continue;
                                }
                            }
                        }
                    }
                    for (lllllllllllllllIllIllIlIllllllII = 0; lllllllllllllllIllIllIlIllllllII < lllllllllllllllIllIllIlIllllIIll.getSections().length; ++lllllllllllllllIllIllIlIllllllII) {
                        lllllllllllllllIllIllIlIllllllIl = lllllllllllllllIllIllIlIllllIIll.getSections()[lllllllllllllllIllIllIlIllllllII];
                        if (lllllllllllllllIllIllIlIllllllIl != null) {
                            for (lllllllllllllllIllIllIllIIIIIIIl = 0; lllllllllllllllIllIllIllIIIIIIIl < 16; ++lllllllllllllllIllIllIllIIIIIIIl) {
                                for (lllllllllllllllIllIllIllIIIIIIlI = 0; lllllllllllllllIllIllIllIIIIIIlI < 16; ++lllllllllllllllIllIllIllIIIIIIlI) {
                                    for (lllllllllllllllIllIllIllIIIIIIll = 0; lllllllllllllllIllIllIllIIIIIIll < 16; ++lllllllllllllllIllIllIllIIIIIIll) {
                                        lllllllllllllllIllIllIllIIIIIlII = lllllllllllllllIllIllIlIllllllIl.getFlatBlock(lllllllllllllllIllIllIllIIIIIIll, lllllllllllllllIllIllIllIIIIIIIl, lllllllllllllllIllIllIllIIIIIIlI);
                                        if (FlowerPotHandler.isFlowah(lllllllllllllllIllIllIllIIIIIlII)) {
                                            lllllllllllllllIllIllIllIIIIIllI = new Position(lllllllllllllllIllIllIllIIIIIIll + (lllllllllllllllIllIllIlIllllIIll.getX() << 4), (short)(lllllllllllllllIllIllIllIIIIIIIl + (lllllllllllllllIllIllIlIllllllII << 4)), lllllllllllllllIllIllIllIIIIIIlI + (lllllllllllllllIllIllIlIllllIIll.getZ() << 4));
                                            lllllllllllllllIllIllIlIllllIIIl.checkAndStore(lllllllllllllllIllIllIllIIIIIllI, lllllllllllllllIllIllIllIIIIIlII);
                                            lllllllllllllllIllIllIllIIIIIlIl = lllllllllllllllIllIllIlIllllIIlI.transform(lllllllllllllllIllIllIlIllllIlll.user(), lllllllllllllllIllIllIllIIIIIllI, "minecraft:flower_pot");
                                            lllllllllllllllIllIllIlIllllIIll.getBlockEntities().add(lllllllllllllllIllIllIllIIIIIlIl);
                                        }
                                    }
                                }
                            }
                            for (lllllllllllllllIllIllIlIlllllllI = 0; lllllllllllllllIllIllIlIlllllllI < lllllllllllllllIllIllIlIllllllIl.getPaletteSize(); ++lllllllllllllllIllIllIlIlllllllI) {
                                lllllllllllllllIllIllIlIllllllll = lllllllllllllllIllIllIlIllllllIl.getPaletteEntry(lllllllllllllllIllIllIlIlllllllI);
                                if (lllllllllllllllIllIllIlIllllllll != 0) {
                                    lllllllllllllllIllIllIllIIIIIIII = ((Protocol1_12_2To1_13)BlockItemPackets1_13.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllllIllIllIlIllllllll);
                                    lllllllllllllllIllIllIlIllllllIl.setPaletteEntry(lllllllllllllllIllIllIlIlllllllI, lllllllllllllllIllIllIllIIIIIIII);
                                }
                            }
                        }
                    }
                    if (lllllllllllllllIllIllIlIllllIIll.isBiomeData()) {
                        for (lllllllllllllllIllIllIlIlllllIIl = 0; lllllllllllllllIllIllIlIlllllIIl < 256; ++lllllllllllllllIllIllIlIlllllIIl) {
                            lllllllllllllllIllIllIlIlllllIll = lllllllllllllllIllIllIlIllllIIll.getBiomeData()[lllllllllllllllIllIllIlIlllllIIl];
                            lllllllllllllllIllIllIlIlllllIlI = -1;
                            switch (lllllllllllllllIllIllIlIlllllIll) {
                                case 40:
                                case 41:
                                case 42:
                                case 43: {
                                    lllllllllllllllIllIllIlIlllllIlI = 9;
                                    break;
                                }
                                case 47:
                                case 48:
                                case 49: {
                                    lllllllllllllllIllIllIlIlllllIlI = 24;
                                    break;
                                }
                                case 50: {
                                    lllllllllllllllIllIllIlIlllllIlI = 10;
                                    break;
                                }
                                case 44:
                                case 45:
                                case 46: {
                                    lllllllllllllllIllIllIlIlllllIlI = 0;
                                    break;
                                }
                            }
                            if (lllllllllllllllIllIllIlIlllllIlI != -1) {
                                lllllllllllllllIllIllIlIllllIIll.getBiomeData()[lllllllllllllllIllIllIlIlllllIIl] = lllllllllllllllIllIllIlIlllllIlI;
                            }
                        }
                    }
                    lllllllllllllllIllIllIlIllllIlll.write((Type<Chunk>)lllllllllllllllIllIllIlIllllIlIl, lllllllllllllllIllIllIlIllllIIll);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.POSITION);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlIIllIIIllIlIIII) throws Exception {
                        final int lllllllllllllIIIlIIllIIIllIIllll = lllllllllllllIIIlIIllIIIllIlIIII.get((Type<Integer>)Type.INT, 0);
                        int lllllllllllllIIIlIIllIIIllIIlllI = lllllllllllllIIIlIIllIIIllIlIIII.get((Type<Integer>)Type.INT, 1);
                        if (lllllllllllllIIIlIIllIIIllIIllll == 1010) {
                            lllllllllllllIIIlIIllIIIllIlIIII.set(Type.INT, 1, ((Protocol1_12_2To1_13)BlockItemPackets1_13.this.protocol).getMappingData().getItemMappings().get(lllllllllllllIIIlIIllIIIllIIlllI) >> 4);
                        }
                        else if (lllllllllllllIIIlIIllIIIllIIllll == 2001) {
                            lllllllllllllIIIlIIllIIIllIIlllI = ((Protocol1_12_2To1_13)BlockItemPackets1_13.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIlIIllIIIllIIlllI);
                            final int lllllllllllllIIIlIIllIIIllIlIIll = lllllllllllllIIIlIIllIIIllIIlllI >> 4;
                            final int lllllllllllllIIIlIIllIIIllIlIIlI = lllllllllllllIIIlIIllIIIllIIlllI & 0xF;
                            lllllllllllllIIIlIIllIIIllIlIIII.set(Type.INT, 1, (lllllllllllllIIIlIIllIIIllIlIIll & 0xFFF) | lllllllllllllIIIlIIllIIIllIlIIlI << 12);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIIlIlIIllIllIlIl) throws Exception {
                        for (int lllllllllllllIllIIlIlIIllIllIllI = lllllllllllllIllIIlIlIIllIllIlIl.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIllIIlIlIIllIlllIIl = 0; lllllllllllllIllIIlIlIIllIlllIIl < lllllllllllllIllIIlIlIIllIllIllI; ++lllllllllllllIllIIlIlIIllIlllIIl) {
                            final int lllllllllllllIllIIlIlIIllIllllIl = lllllllllllllIllIIlIlIIllIllIlIl.read((Type<Integer>)Type.VAR_INT);
                            final byte lllllllllllllIllIIlIlIIllIllllII = lllllllllllllIllIIlIlIIllIllIlIl.read((Type<Byte>)Type.BYTE);
                            final byte lllllllllllllIllIIlIlIIllIlllIll = lllllllllllllIllIIlIlIIllIllIlIl.read((Type<Byte>)Type.BYTE);
                            final byte lllllllllllllIllIIlIlIIllIlllIlI = lllllllllllllIllIIlIlIIllIllIlIl.read((Type<Byte>)Type.BYTE);
                            if (lllllllllllllIllIIlIlIIllIllIlIl.read((Type<Boolean>)Type.BOOLEAN)) {
                                lllllllllllllIllIIlIlIIllIllIlIl.read(Type.COMPONENT);
                            }
                            if (lllllllllllllIllIIlIlIIllIllllIl > 9) {
                                lllllllllllllIllIIlIlIIllIllIlIl.set(Type.VAR_INT, 1, lllllllllllllIllIIlIlIIllIllIlIl.get((Type<Integer>)Type.VAR_INT, 1) - 1);
                            }
                            else {
                                lllllllllllllIllIIlIlIIllIllIlIl.write(Type.BYTE, (byte)(lllllllllllllIllIIlIlIIllIllllIl << 4 | (lllllllllllllIllIIlIlIIllIlllIlI & 0xF)));
                                lllllllllllllIllIIlIlIIllIllIlIl.write(Type.BYTE, lllllllllllllIllIIlIlIIllIllllII);
                                lllllllllllllIllIIlIlIIllIllIlIl.write(Type.BYTE, lllllllllllllIllIIlIlIIllIlllIll);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.FLAT_ITEM, Type.ITEM);
                this.handler(BlockItemPackets1_13.this.itemToClientHandler(Type.ITEM));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.WINDOW_PROPERTY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                final short lllllllllllllllllIlIIllIIIIlIIII;
                short lllllllllllllllllIlIIllIIIIlIIll;
                this.handler(lllllllllllllllllIlIIllIIIIlIIIl -> {
                    lllllllllllllllllIlIIllIIIIlIIII = lllllllllllllllllIlIIllIIIIlIIIl.get((Type<Short>)Type.SHORT, 0);
                    if (lllllllllllllllllIlIIllIIIIlIIII >= 4 && lllllllllllllllllIlIIllIIIIlIIII <= 6) {
                        lllllllllllllllllIlIIllIIIIlIIll = lllllllllllllllllIlIIllIIIIlIIIl.get((Type<Short>)Type.SHORT, 1);
                        lllllllllllllllllIlIIllIIIIlIIIl.set(Type.SHORT, 1, (short)((Protocol1_12_2To1_13)BlockItemPackets1_13.this.protocol).getMappingData().getEnchantmentMappings().getNewId(lllllllllllllllllIlIIllIIIIlIIll));
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this.protocol).registerServerbound(ServerboundPackets1_12_1.CREATIVE_INVENTORY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.map(Type.ITEM, Type.FLAT_ITEM);
                this.handler(BlockItemPackets1_13.this.itemToServerHandler(Type.FLAT_ITEM));
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this.protocol).registerServerbound(ServerboundPackets1_12_1.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.VAR_INT);
                this.map(Type.ITEM, Type.FLAT_ITEM);
                this.handler(BlockItemPackets1_13.this.itemToServerHandler(Type.FLAT_ITEM));
            }
        });
    }
    
    @Override
    protected void registerRewrites() {
        this.enchantmentMappings.put("minecraft:loyalty", "§7Loyalty");
        this.enchantmentMappings.put("minecraft:impaling", "§7Impaling");
        this.enchantmentMappings.put("minecraft:riptide", "§7Riptide");
        this.enchantmentMappings.put("minecraft:channeling", "§7Channeling");
    }
    
    private int itemIdToRaw(final int llllllllllllllIIIlIllllIlIIlIIIl, final Item llllllllllllllIIIlIllllIlIIlIIII, CompoundTag llllllllllllllIIIlIllllIlIIIlIll) {
        final Optional<String> llllllllllllllIIIlIllllIlIIIlllI = SpawnEggRewriter.getEntityId(llllllllllllllIIIlIllllIlIIlIIIl);
        if (llllllllllllllIIIlIllllIlIIIlllI.isPresent()) {
            if (llllllllllllllIIIlIllllIlIIIlIll == null) {
                llllllllllllllIIIlIllllIlIIlIIII.setTag((CompoundTag)(llllllllllllllIIIlIllllIlIIIlIll = new CompoundTag()));
            }
            if (!((CompoundTag)llllllllllllllIIIlIllllIlIIIlIll).contains("EntityTag")) {
                final CompoundTag llllllllllllllIIIlIllllIlIIlIIll = new CompoundTag();
                llllllllllllllIIIlIllllIlIIlIIll.put("id", new StringTag(llllllllllllllIIIlIllllIlIIIlllI.get()));
                ((CompoundTag)llllllllllllllIIIlIllllIlIIIlIll).put("EntityTag", llllllllllllllIIIlIllllIlIIlIIll);
            }
            return 25100288;
        }
        return llllllllllllllIIIlIllllIlIIlIIIl >> 4 << 16 | (llllllllllllllIIIlIllllIlIIlIIIl & 0xF);
    }
    
    private void rewriteCanPlaceToServer(final CompoundTag llllllllllllllIIIlIlllIllllIlIII, final String llllllllllllllIIIlIlllIllllIIlll) {
        if (!(llllllllllllllIIIlIlllIllllIlIII.get(llllllllllllllIIIlIlllIllllIIlll) instanceof ListTag)) {
            return;
        }
        ListTag llllllllllllllIIIlIlllIllllIIllI = llllllllllllllIIIlIlllIllllIlIII.remove(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|").append(llllllllllllllIIIlIlllIllllIIlll)));
        if (llllllllllllllIIIlIlllIllllIIllI != null) {
            llllllllllllllIIIlIlllIllllIlIII.put(llllllllllllllIIIlIlllIllllIIlll, ConverterRegistry.convertToTag(ConverterRegistry.convertToValue(llllllllllllllIIIlIlllIllllIIllI)));
        }
        else if ((llllllllllllllIIIlIlllIllllIIllI = llllllllllllllIIIlIlllIllllIlIII.get(llllllllllllllIIIlIlllIllllIIlll)) != null) {
            final ListTag llllllllllllllIIIlIlllIllllIlIlI = new ListTag(StringTag.class);
            for (final Tag llllllllllllllIIIlIlllIllllIlIll : llllllllllllllIIIlIlllIllllIIllI) {
                final Object llllllllllllllIIIlIlllIlllllIIIl = llllllllllllllIIIlIlllIllllIlIll.getValue();
                String llllllllllllllIIIlIlllIlllllIIII = llllllllllllllIIIlIlllIlllllIIIl.toString().replace("minecraft:", "");
                final int llllllllllllllIIIlIlllIllllIllll = Ints.tryParse(llllllllllllllIIIlIlllIlllllIIII);
                final String llllllllllllllIIIlIlllIllllIlllI = BlockIdData.numberIdToString.get(llllllllllllllIIIlIlllIllllIllll);
                if (llllllllllllllIIIlIlllIllllIlllI != null) {
                    llllllllllllllIIIlIlllIlllllIIII = llllllllllllllIIIlIlllIllllIlllI;
                }
                final String llllllllllllllIIIlIlllIllllIllIl = llllllllllllllIIIlIlllIlllllIIII.toLowerCase(Locale.ROOT);
                final String[] llllllllllllllIIIlIlllIllllIllII = BlockIdData.blockIdMapping.get(llllllllllllllIIIlIlllIllllIllIl);
                if (llllllllllllllIIIlIlllIllllIllII != null) {
                    final double llllllllllllllIIIlIlllIlllIllIII = (Object)llllllllllllllIIIlIlllIllllIllII;
                    final boolean llllllllllllllIIIlIlllIlllIlIlll = llllllllllllllIIIlIlllIlllIllIII.length != 0;
                    for (short llllllllllllllIIIlIlllIlllIlIllI = 0; llllllllllllllIIIlIlllIlllIlIllI < (llllllllllllllIIIlIlllIlllIlIlll ? 1 : 0); ++llllllllllllllIIIlIlllIlllIlIllI) {
                        final String llllllllllllllIIIlIlllIlllllIIlI = llllllllllllllIIIlIlllIlllIllIII[llllllllllllllIIIlIlllIlllIlIllI];
                        llllllllllllllIIIlIlllIllllIlIlI.add(new StringTag(llllllllllllllIIIlIlllIlllllIIlI));
                    }
                }
                else {
                    llllllllllllllIIIlIlllIllllIlIlI.add(new StringTag(llllllllllllllIIIlIlllIllllIllIl));
                }
            }
            llllllllllllllIIIlIlllIllllIlIII.put(llllllllllllllIIIlIlllIllllIIlll, llllllllllllllIIIlIlllIllllIlIlI);
        }
    }
    
    public BlockItemPackets1_13(final Protocol1_12_2To1_13 llllllllllllllIIIlIllllIllIIIIIl) {
        super(llllllllllllllIIIlIllllIllIIIIIl, null);
        this.enchantmentMappings = new HashMap<String, String>();
        this.extraNbtTag = String.valueOf(new StringBuilder().append("VB|").append(llllllllllllllIIIlIllllIllIIIIIl.getClass().getSimpleName()).append("|2"));
    }
    
    private void rewriteEnchantmentsToServer(final CompoundTag llllllllllllllIIIlIlllIllIllIlII, final boolean llllllllllllllIIIlIlllIllIllIIll) {
        final String llllllllllllllIIIlIlllIllIllllII = llllllllllllllIIIlIlllIllIllIIll ? "StoredEnchantments" : "Enchantments";
        final ListTag llllllllllllllIIIlIlllIllIlllIll = llllllllllllllIIIlIlllIllIllIlII.get(llllllllllllllIIIlIlllIllIllIIll ? llllllllllllllIIIlIlllIllIllllII : "ench");
        if (llllllllllllllIIIlIlllIllIlllIll == null) {
            return;
        }
        final ListTag llllllllllllllIIIlIlllIllIlllIlI = new ListTag(CompoundTag.class);
        boolean llllllllllllllIIIlIlllIllIlllIIl = false;
        if (!llllllllllllllIIIlIlllIllIllIIll) {
            final IntTag llllllllllllllIIIlIlllIlllIIIlll = llllllllllllllIIIlIlllIllIllIlII.remove(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|OldHideFlags")));
            if (llllllllllllllIIIlIlllIlllIIIlll != null) {
                llllllllllllllIIIlIlllIllIllIlII.put("HideFlags", new IntTag(llllllllllllllIIIlIlllIlllIIIlll.asByte()));
                llllllllllllllIIIlIlllIllIlllIIl = true;
            }
            else if (llllllllllllllIIIlIlllIllIllIlII.remove(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|DummyEnchant"))) != null) {
                llllllllllllllIIIlIlllIllIllIlII.remove("HideFlags");
                llllllllllllllIIIlIlllIllIlllIIl = true;
            }
        }
        for (final Tag llllllllllllllIIIlIlllIlllIIIIlI : llllllllllllllIIIlIlllIllIlllIll) {
            final CompoundTag llllllllllllllIIIlIlllIlllIIIllI = new CompoundTag();
            final short llllllllllllllIIIlIlllIlllIIIlIl = ((CompoundTag)llllllllllllllIIIlIlllIlllIIIIlI).get("id").asShort();
            final short llllllllllllllIIIlIlllIlllIIIlII = ((CompoundTag)llllllllllllllIIIlIlllIlllIIIIlI).get("lvl").asShort();
            if (llllllllllllllIIIlIlllIllIlllIIl && llllllllllllllIIIlIlllIlllIIIlIl == 0 && llllllllllllllIIIlIlllIlllIIIlII == 0) {
                continue;
            }
            String llllllllllllllIIIlIlllIlllIIIIll = (String)Protocol1_13To1_12_2.MAPPINGS.getOldEnchantmentsIds().get((Object)llllllllllllllIIIlIlllIlllIIIlIl);
            if (llllllllllllllIIIlIlllIlllIIIIll == null) {
                llllllllllllllIIIlIlllIlllIIIIll = String.valueOf(new StringBuilder().append("viaversion:legacy/").append(llllllllllllllIIIlIlllIlllIIIlIl));
            }
            llllllllllllllIIIlIlllIlllIIIllI.put("id", new StringTag(llllllllllllllIIIlIlllIlllIIIIll));
            llllllllllllllIIIlIlllIlllIIIllI.put("lvl", new ShortTag(llllllllllllllIIIlIlllIlllIIIlII));
            llllllllllllllIIIlIlllIllIlllIlI.add(llllllllllllllIIIlIlllIlllIIIllI);
        }
        final ListTag llllllllllllllIIIlIlllIllIlllIII = llllllllllllllIIIlIlllIllIllIlII.remove(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|Enchantments")));
        if (llllllllllllllIIIlIlllIllIlllIII != null) {
            for (final Tag llllllllllllllIIIlIlllIlllIIIIIl : llllllllllllllIIIlIlllIllIlllIII) {
                llllllllllllllIIIlIlllIllIlllIlI.add(llllllllllllllIIIlIlllIlllIIIIIl);
            }
        }
        CompoundTag llllllllllllllIIIlIlllIllIllIlll = llllllllllllllIIIlIlllIllIllIlII.get("display");
        if (llllllllllllllIIIlIlllIllIllIlll == null) {
            llllllllllllllIIIlIlllIllIllIlII.put("display", llllllllllllllIIIlIlllIllIllIlll = new CompoundTag());
        }
        final ListTag llllllllllllllIIIlIlllIllIllIllI = llllllllllllllIIIlIlllIllIllIlII.remove(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|OldLore")));
        if (llllllllllllllIIIlIlllIllIllIllI != null) {
            ListTag llllllllllllllIIIlIlllIlllIIIIII = llllllllllllllIIIlIlllIllIllIlll.get("Lore");
            if (llllllllllllllIIIlIlllIlllIIIIII == null) {
                llllllllllllllIIIlIlllIllIllIlII.put("Lore", llllllllllllllIIIlIlllIlllIIIIII = new ListTag());
            }
            llllllllllllllIIIlIlllIlllIIIIII.setValue(llllllllllllllIIIlIlllIllIllIllI.getValue());
        }
        else if (llllllllllllllIIIlIlllIllIllIlII.remove(String.valueOf(new StringBuilder().append(this.extraNbtTag).append("|DummyLore"))) != null) {
            llllllllllllllIIIlIlllIllIllIlll.remove("Lore");
            if (llllllllllllllIIIlIlllIllIllIlll.isEmpty()) {
                llllllllllllllIIIlIlllIllIllIlII.remove("display");
            }
        }
        if (!llllllllllllllIIIlIlllIllIllIIll) {
            llllllllllllllIIIlIlllIllIllIlII.remove("ench");
        }
        llllllllllllllIIIlIlllIllIllIlII.put(llllllllllllllIIIlIlllIllIllllII, llllllllllllllIIIlIlllIllIlllIlI);
    }
}
