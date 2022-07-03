package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.data.*;
import com.viaversion.viabackwards.utils.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import java.util.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;

public abstract class LegacyBlockItemRewriter<T extends BackwardsProtocol> extends ItemRewriterBase<T>
{
    protected final /* synthetic */ Int2ObjectMap<MappedLegacyBlockItem> replacementData;
    private static final /* synthetic */ Map<String, Int2ObjectMap<MappedLegacyBlockItem>> LEGACY_MAPPINGS;
    
    @Override
    public Item handleItemToClient(final Item lllllllllllllIIlIIlIlIIlIIllllll) {
        if (lllllllllllllIIlIIlIlIIlIIllllll == null) {
            return null;
        }
        final MappedLegacyBlockItem lllllllllllllIIlIIlIlIIlIIlllllI = this.replacementData.get(lllllllllllllIIlIIlIlIIlIIllllll.identifier());
        if (lllllllllllllIIlIIlIlIIlIIlllllI == null) {
            return super.handleItemToClient(lllllllllllllIIlIIlIlIIlIIllllll);
        }
        final short lllllllllllllIIlIIlIlIIlIIllllIl = lllllllllllllIIlIIlIlIIlIIllllll.data();
        lllllllllllllIIlIIlIlIIlIIllllll.setIdentifier(lllllllllllllIIlIIlIlIIlIIlllllI.getId());
        if (lllllllllllllIIlIIlIlIIlIIlllllI.getData() != -1) {
            lllllllllllllIIlIIlIlIIlIIllllll.setData(lllllllllllllIIlIIlIlIIlIIlllllI.getData());
        }
        if (lllllllllllllIIlIIlIlIIlIIlllllI.getName() != null) {
            if (lllllllllllllIIlIIlIlIIlIIllllll.tag() == null) {
                lllllllllllllIIlIIlIlIIlIIllllll.setTag(new CompoundTag());
            }
            CompoundTag lllllllllllllIIlIIlIlIIlIlIIIIll = lllllllllllllIIlIIlIlIIlIIllllll.tag().get("display");
            if (lllllllllllllIIlIIlIlIIlIlIIIIll == null) {
                lllllllllllllIIlIIlIlIIlIIllllll.tag().put("display", lllllllllllllIIlIIlIlIIlIlIIIIll = new CompoundTag());
            }
            StringTag lllllllllllllIIlIIlIlIIlIlIIIIlI = lllllllllllllIIlIIlIlIIlIlIIIIll.get("Name");
            if (lllllllllllllIIlIIlIlIIlIlIIIIlI == null) {
                lllllllllllllIIlIIlIlIIlIlIIIIll.put("Name", lllllllllllllIIlIIlIlIIlIlIIIIlI = new StringTag(lllllllllllllIIlIIlIlIIlIIlllllI.getName()));
                lllllllllllllIIlIIlIlIIlIlIIIIll.put(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|customName")), new ByteTag());
            }
            final String lllllllllllllIIlIIlIlIIlIlIIIIIl = lllllllllllllIIlIIlIlIIlIlIIIIlI.getValue();
            if (lllllllllllllIIlIIlIlIIlIlIIIIIl.contains("%vb_color%")) {
                lllllllllllllIIlIIlIlIIlIlIIIIll.put("Name", new StringTag(lllllllllllllIIlIIlIlIIlIlIIIIIl.replace("%vb_color%", BlockColors.get(lllllllllllllIIlIIlIlIIlIIllllIl))));
            }
        }
        return lllllllllllllIIlIIlIlIIlIIllllll;
    }
    
    public Block handleBlock(final int lllllllllllllIIlIIlIlIIlIIIllIll, final int lllllllllllllIIlIIlIlIIlIIIllIlI) {
        final MappedLegacyBlockItem lllllllllllllIIlIIlIlIIlIIIllllI = this.replacementData.get(lllllllllllllIIlIIlIlIIlIIIllIll);
        if (lllllllllllllIIlIIlIlIIlIIIllllI == null || !lllllllllllllIIlIIlIlIIlIIIllllI.isBlock()) {
            return null;
        }
        final Block lllllllllllllIIlIIlIlIIlIIIlllIl = lllllllllllllIIlIIlIlIIlIIIllllI.getBlock();
        if (lllllllllllllIIlIIlIlIIlIIIlllIl.getData() == -1) {
            return lllllllllllllIIlIIlIlIIlIIIlllIl.withData(lllllllllllllIIlIIlIlIIlIIIllIlI);
        }
        return lllllllllllllIIlIIlIlIIlIIIlllIl;
    }
    
    protected CompoundTag getNamedTag(String lllllllllllllIIlIIlIlIIIllIlIlII) {
        final CompoundTag lllllllllllllIIlIIlIlIIIllIlIllI = new CompoundTag();
        lllllllllllllIIlIIlIlIIIllIlIllI.put("display", new CompoundTag());
        lllllllllllllIIlIIlIlIIIllIlIlII = (Exception)String.valueOf(new StringBuilder().append("§r").append((String)lllllllllllllIIlIIlIlIIIllIlIlII));
        lllllllllllllIIlIIlIlIIIllIlIllI.get("display").put("Name", new StringTag((String)(this.jsonNameFormat ? ChatRewriter.legacyTextToJsonString((String)lllllllllllllIIlIIlIlIIIllIlIlII) : lllllllllllllIIlIIlIlIIIllIlIlII)));
        return lllllllllllllIIlIIlIlIIIllIlIllI;
    }
    
    static {
        LEGACY_MAPPINGS = new HashMap<String, Int2ObjectMap<MappedLegacyBlockItem>>();
        final JsonObject lllllllllllllIIlIIlIlIIIlIllIIII = VBMappingDataLoader.loadFromDataDir("legacy-mappings.json");
        for (final Map.Entry<String, JsonElement> lllllllllllllIIlIIlIlIIIlIllIIIl : lllllllllllllIIlIIlIlIIIlIllIIII.entrySet()) {
            final Int2ObjectMap<MappedLegacyBlockItem> lllllllllllllIIlIIlIlIIIlIllIIlI = new Int2ObjectOpenHashMap<MappedLegacyBlockItem>(8);
            LegacyBlockItemRewriter.LEGACY_MAPPINGS.put(lllllllllllllIIlIIlIlIIIlIllIIIl.getKey(), lllllllllllllIIlIIlIlIIIlIllIIlI);
            for (final Map.Entry<String, JsonElement> lllllllllllllIIlIIlIlIIIlIllIIll : lllllllllllllIIlIIlIlIIIlIllIIIl.getValue().getAsJsonObject().entrySet()) {
                final JsonObject lllllllllllllIIlIIlIlIIIlIlllIlI = lllllllllllllIIlIIlIlIIIlIllIIll.getValue().getAsJsonObject();
                final int lllllllllllllIIlIIlIlIIIlIlllIIl = lllllllllllllIIlIIlIlIIIlIlllIlI.getAsJsonPrimitive("id").getAsInt();
                final JsonPrimitive lllllllllllllIIlIIlIlIIIlIlllIII = lllllllllllllIIlIIlIlIIIlIlllIlI.getAsJsonPrimitive("data");
                final short lllllllllllllIIlIIlIlIIIlIllIlll = (short)((lllllllllllllIIlIIlIlIIIlIlllIII != null) ? lllllllllllllIIlIIlIlIIIlIlllIII.getAsShort() : 0);
                final String lllllllllllllIIlIIlIlIIIlIllIllI = lllllllllllllIIlIIlIlIIIlIlllIlI.getAsJsonPrimitive("name").getAsString();
                final JsonPrimitive lllllllllllllIIlIIlIlIIIlIllIlIl = lllllllllllllIIlIIlIlIIIlIlllIlI.getAsJsonPrimitive("block");
                final boolean lllllllllllllIIlIIlIlIIIlIllIlII = lllllllllllllIIlIIlIlIIIlIllIlIl != null && lllllllllllllIIlIIlIlIIIlIllIlIl.getAsBoolean();
                if (lllllllllllllIIlIIlIlIIIlIllIIll.getKey().indexOf(45) != -1) {
                    final String[] lllllllllllllIIlIIlIlIIIlIllllIl = lllllllllllllIIlIIlIlIIIlIllIIll.getKey().split("-", 2);
                    final int lllllllllllllIIlIIlIlIIIlIllllII = Integer.parseInt(lllllllllllllIIlIIlIlIIIlIllllIl[0]);
                    final int lllllllllllllIIlIIlIlIIIlIlllIll = Integer.parseInt(lllllllllllllIIlIIlIlIIIlIllllIl[1]);
                    if (lllllllllllllIIlIIlIlIIIlIllIllI.contains("%color%")) {
                        for (int lllllllllllllIIlIIlIlIIIllIIIIII = lllllllllllllIIlIIlIlIIIlIllllII; lllllllllllllIIlIIlIlIIIllIIIIII <= lllllllllllllIIlIIlIlIIIlIlllIll; ++lllllllllllllIIlIIlIlIIIllIIIIII) {
                            lllllllllllllIIlIIlIlIIIlIllIIlI.put(lllllllllllllIIlIIlIlIIIllIIIIII, new MappedLegacyBlockItem(lllllllllllllIIlIIlIlIIIlIlllIIl, lllllllllllllIIlIIlIlIIIlIllIlll, lllllllllllllIIlIIlIlIIIlIllIllI.replace("%color%", BlockColors.get(lllllllllllllIIlIIlIlIIIllIIIIII - lllllllllllllIIlIIlIlIIIlIllllII)), lllllllllllllIIlIIlIlIIIlIllIlII));
                        }
                    }
                    else {
                        final MappedLegacyBlockItem lllllllllllllIIlIIlIlIIIlIlllllI = new MappedLegacyBlockItem(lllllllllllllIIlIIlIlIIIlIlllIIl, lllllllllllllIIlIIlIlIIIlIllIlll, lllllllllllllIIlIIlIlIIIlIllIllI, lllllllllllllIIlIIlIlIIIlIllIlII);
                        for (int lllllllllllllIIlIIlIlIIIlIllllll = lllllllllllllIIlIIlIlIIIlIllllII; lllllllllllllIIlIIlIlIIIlIllllll <= lllllllllllllIIlIIlIlIIIlIlllIll; ++lllllllllllllIIlIIlIlIIIlIllllll) {
                            lllllllllllllIIlIIlIlIIIlIllIIlI.put(lllllllllllllIIlIIlIlIIIlIllllll, lllllllllllllIIlIIlIlIIIlIlllllI);
                        }
                    }
                }
                else {
                    lllllllllllllIIlIIlIlIIIlIllIIlI.put(Integer.parseInt(lllllllllllllIIlIIlIlIIIlIllIIll.getKey()), new MappedLegacyBlockItem(lllllllllllllIIlIIlIlIIIlIlllIIl, lllllllllllllIIlIIlIlIIIlIllIlll, lllllllllllllIIlIIlIlIIIlIllIllI, lllllllllllllIIlIIlIlIIIlIllIlII));
                }
            }
        }
    }
    
    public int handleBlockID(final int lllllllllllllIIlIIlIlIIlIIlIlIlI) {
        final int lllllllllllllIIlIIlIlIIlIIlIlllI = lllllllllllllIIlIIlIlIIlIIlIlIlI >> 4;
        final int lllllllllllllIIlIIlIlIIlIIlIllIl = lllllllllllllIIlIIlIlIIlIIlIlIlI & 0xF;
        final Block lllllllllllllIIlIIlIlIIlIIlIllII = this.handleBlock(lllllllllllllIIlIIlIlIIlIIlIlllI, lllllllllllllIIlIIlIlIIlIIlIllIl);
        if (lllllllllllllIIlIIlIlIIlIIlIllII == null) {
            return lllllllllllllIIlIIlIlIIlIIlIlIlI;
        }
        return lllllllllllllIIlIIlIlIIlIIlIllII.getId() << 4 | (lllllllllllllIIlIIlIlIIlIIlIllII.getData() & 0xF);
    }
    
    protected void handleChunk(final Chunk lllllllllllllIIlIIlIlIIIlllIlIIl) {
        final Map<Pos, CompoundTag> lllllllllllllIIlIIlIlIIIlllIlIll = new HashMap<Pos, CompoundTag>();
        for (final CompoundTag lllllllllllllIIlIIlIlIIlIIIIIIII : lllllllllllllIIlIIlIlIIIlllIlIIl.getBlockEntities()) {
            final Tag lllllllllllllIIlIIlIlIIlIIIIlIII;
            final Tag lllllllllllllIIlIIlIlIIlIIIIIlll;
            if ((lllllllllllllIIlIIlIlIIlIIIIlIII = lllllllllllllIIlIIlIlIIlIIIIIIII.get("x")) != null && (lllllllllllllIIlIIlIlIIlIIIIIlll = lllllllllllllIIlIIlIlIIlIIIIIIII.get("y")) != null) {
                final Tag lllllllllllllIIlIIlIlIIlIIIIIllI;
                if ((lllllllllllllIIlIIlIlIIlIIIIIllI = lllllllllllllIIlIIlIlIIlIIIIIIII.get("z")) == null) {
                    continue;
                }
                final Pos lllllllllllllIIlIIlIlIIlIIIIIlIl = new Pos(((NumberTag)lllllllllllllIIlIIlIlIIlIIIIlIII).asInt() & 0xF, ((NumberTag)lllllllllllllIIlIIlIlIIlIIIIIlll).asInt(), ((NumberTag)lllllllllllllIIlIIlIlIIlIIIIIllI).asInt() & 0xF);
                lllllllllllllIIlIIlIlIIIlllIlIll.put(lllllllllllllIIlIIlIlIIlIIIIIlIl, lllllllllllllIIlIIlIlIIlIIIIIIII);
                if (lllllllllllllIIlIIlIlIIlIIIIIlIl.getY() < 0) {
                    continue;
                }
                if (lllllllllllllIIlIIlIlIIlIIIIIlIl.getY() > 255) {
                    continue;
                }
                final ChunkSection lllllllllllllIIlIIlIlIIlIIIIIlII = lllllllllllllIIlIIlIlIIIlllIlIIl.getSections()[lllllllllllllIIlIIlIlIIlIIIIIlIl.getY() >> 4];
                if (lllllllllllllIIlIIlIlIIlIIIIIlII == null) {
                    continue;
                }
                final int lllllllllllllIIlIIlIlIIlIIIIIIll = lllllllllllllIIlIIlIlIIlIIIIIlII.getFlatBlock(lllllllllllllIIlIIlIlIIlIIIIIlIl.getX(), lllllllllllllIIlIIlIlIIlIIIIIlIl.getY() & 0xF, lllllllllllllIIlIIlIlIIlIIIIIlIl.getZ());
                final int lllllllllllllIIlIIlIlIIlIIIIIIlI = lllllllllllllIIlIIlIlIIlIIIIIIll >> 4;
                final MappedLegacyBlockItem lllllllllllllIIlIIlIlIIlIIIIIIIl = this.replacementData.get(lllllllllllllIIlIIlIlIIlIIIIIIlI);
                if (lllllllllllllIIlIIlIlIIlIIIIIIIl == null || !lllllllllllllIIlIIlIlIIlIIIIIIIl.hasBlockEntityHandler()) {
                    continue;
                }
                lllllllllllllIIlIIlIlIIlIIIIIIIl.getBlockEntityHandler().handleOrNewCompoundTag(lllllllllllllIIlIIlIlIIlIIIIIIll, lllllllllllllIIlIIlIlIIlIIIIIIII);
            }
        }
        for (int lllllllllllllIIlIIlIlIIIlllIlllI = 0; lllllllllllllIIlIIlIlIIIlllIlllI < lllllllllllllIIlIIlIlIIIlllIlIIl.getSections().length; ++lllllllllllllIIlIIlIlIIIlllIlllI) {
            final ChunkSection lllllllllllllIIlIIlIlIIIllllIIII = lllllllllllllIIlIIlIlIIIlllIlIIl.getSections()[lllllllllllllIIlIIlIlIIIlllIlllI];
            if (lllllllllllllIIlIIlIlIIIllllIIII != null) {
                boolean lllllllllllllIIlIIlIlIIIlllIllll = false;
                for (int lllllllllllllIIlIIlIlIIIlllllIlI = 0; lllllllllllllIIlIIlIlIIIlllllIlI < lllllllllllllIIlIIlIlIIIllllIIII.getPaletteSize(); ++lllllllllllllIIlIIlIlIIIlllllIlI) {
                    final int lllllllllllllIIlIIlIlIIIllllllll = lllllllllllllIIlIIlIlIIIllllIIII.getPaletteEntry(lllllllllllllIIlIIlIlIIIlllllIlI);
                    final int lllllllllllllIIlIIlIlIIIlllllllI = lllllllllllllIIlIIlIlIIIllllllll >> 4;
                    final int lllllllllllllIIlIIlIlIIIllllllIl = lllllllllllllIIlIIlIlIIIllllllll & 0xF;
                    final Block lllllllllllllIIlIIlIlIIIllllllII = this.handleBlock(lllllllllllllIIlIIlIlIIIlllllllI, lllllllllllllIIlIIlIlIIIllllllIl);
                    if (lllllllllllllIIlIIlIlIIIllllllII != null) {
                        lllllllllllllIIlIIlIlIIIllllIIII.setPaletteEntry(lllllllllllllIIlIIlIlIIIlllllIlI, lllllllllllllIIlIIlIlIIIllllllII.getId() << 4 | (lllllllllllllIIlIIlIlIIIllllllII.getData() & 0xF));
                    }
                    if (!lllllllllllllIIlIIlIlIIIlllIllll) {
                        final MappedLegacyBlockItem lllllllllllllIIlIIlIlIIIlllllIll = this.replacementData.get(lllllllllllllIIlIIlIlIIIlllllllI);
                        if (lllllllllllllIIlIIlIlIIIlllllIll != null && lllllllllllllIIlIIlIlIIIlllllIll.hasBlockEntityHandler()) {
                            lllllllllllllIIlIIlIlIIIlllIllll = true;
                        }
                    }
                }
                if (lllllllllllllIIlIIlIlIIIlllIllll) {
                    for (int lllllllllllllIIlIIlIlIIIllllIIIl = 0; lllllllllllllIIlIIlIlIIIllllIIIl < 16; ++lllllllllllllIIlIIlIlIIIllllIIIl) {
                        for (int lllllllllllllIIlIIlIlIIIllllIIlI = 0; lllllllllllllIIlIIlIlIIIllllIIlI < 16; ++lllllllllllllIIlIIlIlIIIllllIIlI) {
                            for (int lllllllllllllIIlIIlIlIIIllllIIll = 0; lllllllllllllIIlIIlIlIIIllllIIll < 16; ++lllllllllllllIIlIIlIlIIIllllIIll) {
                                final int lllllllllllllIIlIIlIlIIIlllllIIl = lllllllllllllIIlIIlIlIIIllllIIII.getFlatBlock(lllllllllllllIIlIIlIlIIIllllIIIl, lllllllllllllIIlIIlIlIIIllllIIlI, lllllllllllllIIlIIlIlIIIllllIIll);
                                final int lllllllllllllIIlIIlIlIIIlllllIII = lllllllllllllIIlIIlIlIIIlllllIIl >> 4;
                                final int lllllllllllllIIlIIlIlIIIllllIlll = lllllllllllllIIlIIlIlIIIlllllIIl & 0xF;
                                final MappedLegacyBlockItem lllllllllllllIIlIIlIlIIIllllIllI = this.replacementData.get(lllllllllllllIIlIIlIlIIIlllllIII);
                                if (lllllllllllllIIlIIlIlIIIllllIllI != null) {
                                    if (lllllllllllllIIlIIlIlIIIllllIllI.hasBlockEntityHandler()) {
                                        final Pos lllllllllllllIIlIIlIlIIIllllIlIl = new Pos(lllllllllllllIIlIIlIlIIIllllIIIl, lllllllllllllIIlIIlIlIIIllllIIlI + (lllllllllllllIIlIIlIlIIIlllIlllI << 4), lllllllllllllIIlIIlIlIIIllllIIll);
                                        if (!lllllllllllllIIlIIlIlIIIlllIlIll.containsKey(lllllllllllllIIlIIlIlIIIllllIlIl)) {
                                            final CompoundTag lllllllllllllIIlIIlIlIIIllllIlII = new CompoundTag();
                                            lllllllllllllIIlIIlIlIIIllllIlII.put("x", new IntTag(lllllllllllllIIlIIlIlIIIllllIIIl + (lllllllllllllIIlIIlIlIIIlllIlIIl.getX() << 4)));
                                            lllllllllllllIIlIIlIlIIIllllIlII.put("y", new IntTag(lllllllllllllIIlIIlIlIIIllllIIlI + (lllllllllllllIIlIIlIlIIIlllIlllI << 4)));
                                            lllllllllllllIIlIIlIlIIIllllIlII.put("z", new IntTag(lllllllllllllIIlIIlIlIIIllllIIll + (lllllllllllllIIlIIlIlIIIlllIlIIl.getZ() << 4)));
                                            lllllllllllllIIlIIlIlIIIllllIllI.getBlockEntityHandler().handleOrNewCompoundTag(lllllllllllllIIlIIlIlIIIlllllIIl, lllllllllllllIIlIIlIlIIIllllIlII);
                                            lllllllllllllIIlIIlIlIIIlllIlIIl.getBlockEntities().add(lllllllllllllIIlIIlIlIIIllllIlII);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected LegacyBlockItemRewriter(final T lllllllllllllIIlIIlIlIIlIlIIllIl) {
        super(lllllllllllllIIlIIlIlIIlIlIIllIl, false);
        this.replacementData = LegacyBlockItemRewriter.LEGACY_MAPPINGS.get(lllllllllllllIIlIIlIlIIlIlIIllIl.getClass().getSimpleName().split("To")[1].replace("_", "."));
    }
    
    private static final class Pos
    {
        private final /* synthetic */ int x;
        private final /* synthetic */ short y;
        private final /* synthetic */ int z;
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("Pos{x=").append(this.x).append(", y=").append(this.y).append(", z=").append(this.z).append('}'));
        }
        
        private Pos(final int lllllllllllllllllIlIllIlIllIIlll, final int lllllllllllllllllIlIllIlIllIIllI, final int lllllllllllllllllIlIllIlIllIIIIl) {
            this.x = lllllllllllllllllIlIllIlIllIIlll;
            this.y = (short)lllllllllllllllllIlIllIlIllIIllI;
            this.z = lllllllllllllllllIlIllIlIllIIIIl;
        }
        
        @Override
        public int hashCode() {
            int lllllllllllllllllIlIllIlIlIIlIll = this.x;
            lllllllllllllllllIlIllIlIlIIlIll = 31 * lllllllllllllllllIlIllIlIlIIlIll + this.y;
            lllllllllllllllllIlIllIlIlIIlIll = 31 * lllllllllllllllllIlIllIlIlIIlIll + this.z;
            return lllllllllllllllllIlIllIlIlIIlIll;
        }
        
        public int getY() {
            return this.y;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllllllIlIllIlIlIlIIII) {
            if (this == lllllllllllllllllIlIllIlIlIlIIII) {
                return true;
            }
            if (lllllllllllllllllIlIllIlIlIlIIII == null || this.getClass() != lllllllllllllllllIlIllIlIlIlIIII.getClass()) {
                return false;
            }
            final Pos lllllllllllllllllIlIllIlIlIlIIlI = (Pos)lllllllllllllllllIlIllIlIlIlIIII;
            return this.x == lllllllllllllllllIlIllIlIlIlIIlI.x && this.y == lllllllllllllllllIlIllIlIlIlIIlI.y && this.z == lllllllllllllllllIlIllIlIlIlIIlI.z;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getZ() {
            return this.z;
        }
    }
}
