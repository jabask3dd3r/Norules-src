package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viabackwards.api.data.*;

public abstract class ItemRewriter<T extends BackwardsProtocol> extends ItemRewriterBase<T>
{
    private final /* synthetic */ TranslatableRewriter translatableRewriter;
    
    @Override
    public Item handleItemToClient(final Item llllllllllllllllIlIlIllIIIIIllll) {
        if (llllllllllllllllIlIlIllIIIIIllll == null) {
            return null;
        }
        CompoundTag llllllllllllllllIlIlIllIIIIIlllI = (llllllllllllllllIlIlIllIIIIIllll.tag() != null) ? llllllllllllllllIlIlIllIIIIIllll.tag().get("display") : null;
        if (this.translatableRewriter != null && llllllllllllllllIlIlIllIIIIIlllI != null) {
            final StringTag llllllllllllllllIlIlIllIIIIlIIlI = llllllllllllllllIlIlIllIIIIIlllI.get("Name");
            if (llllllllllllllllIlIlIllIIIIlIIlI != null) {
                final String llllllllllllllllIlIlIllIIIIlIlll = this.translatableRewriter.processText(llllllllllllllllIlIlIllIIIIlIIlI.getValue()).toString();
                if (!llllllllllllllllIlIlIllIIIIlIlll.equals(llllllllllllllllIlIlIllIIIIlIIlI.getValue())) {
                    this.saveStringTag(llllllllllllllllIlIlIllIIIIIlllI, llllllllllllllllIlIlIllIIIIlIIlI, "Name");
                }
                llllllllllllllllIlIlIllIIIIlIIlI.setValue(llllllllllllllllIlIlIllIIIIlIlll);
            }
            final ListTag llllllllllllllllIlIlIllIIIIlIIIl = llllllllllllllllIlIlIllIIIIIlllI.get("Lore");
            if (llllllllllllllllIlIlIllIIIIlIIIl != null) {
                boolean llllllllllllllllIlIlIllIIIIlIIll = false;
                for (final Tag llllllllllllllllIlIlIllIIIIlIlII : llllllllllllllllIlIlIllIIIIlIIIl) {
                    if (!(llllllllllllllllIlIlIllIIIIlIlII instanceof StringTag)) {
                        continue;
                    }
                    final StringTag llllllllllllllllIlIlIllIIIIlIllI = (StringTag)llllllllllllllllIlIlIllIIIIlIlII;
                    final String llllllllllllllllIlIlIllIIIIlIlIl = this.translatableRewriter.processText(llllllllllllllllIlIlIllIIIIlIllI.getValue()).toString();
                    if (!llllllllllllllllIlIlIllIIIIlIIll && !llllllllllllllllIlIlIllIIIIlIlIl.equals(llllllllllllllllIlIlIllIIIIlIllI.getValue())) {
                        llllllllllllllllIlIlIllIIIIlIIll = true;
                        this.saveListTag(llllllllllllllllIlIlIllIIIIIlllI, llllllllllllllllIlIlIllIIIIlIIIl, "Lore");
                    }
                    llllllllllllllllIlIlIllIIIIlIllI.setValue(llllllllllllllllIlIlIllIIIIlIlIl);
                }
            }
        }
        final MappedItem llllllllllllllllIlIlIllIIIIIllIl = this.protocol.getMappingData().getMappedItem(llllllllllllllllIlIlIllIIIIIllll.identifier());
        if (llllllllllllllllIlIlIllIIIIIllIl == null) {
            return super.handleItemToClient(llllllllllllllllIlIlIllIIIIIllll);
        }
        if (llllllllllllllllIlIlIllIIIIIllll.tag() == null) {
            llllllllllllllllIlIlIllIIIIIllll.setTag(new CompoundTag());
        }
        llllllllllllllllIlIlIllIIIIIllll.tag().put(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|id")), new IntTag(llllllllllllllllIlIlIllIIIIIllll.identifier()));
        llllllllllllllllIlIlIllIIIIIllll.setIdentifier(llllllllllllllllIlIlIllIIIIIllIl.getId());
        if (llllllllllllllllIlIlIllIIIIIlllI == null) {
            llllllllllllllllIlIlIllIIIIIllll.tag().put("display", llllllllllllllllIlIlIllIIIIIlllI = new CompoundTag());
        }
        if (!llllllllllllllllIlIlIllIIIIIlllI.contains("Name")) {
            llllllllllllllllIlIlIllIIIIIlllI.put("Name", new StringTag(llllllllllllllllIlIlIllIIIIIllIl.getJsonName()));
            llllllllllllllllIlIlIllIIIIIlllI.put(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|customName")), new ByteTag());
        }
        return llllllllllllllllIlIlIllIIIIIllll;
    }
    
    @Override
    public Item handleItemToServer(final Item llllllllllllllllIlIlIlIllllIlIlI) {
        if (llllllllllllllllIlIlIlIllllIlIlI == null) {
            return null;
        }
        super.handleItemToServer(llllllllllllllllIlIlIlIllllIlIlI);
        if (llllllllllllllllIlIlIlIllllIlIlI.tag() != null) {
            final IntTag llllllllllllllllIlIlIlIllllIlllI = llllllllllllllllIlIlIlIllllIlIlI.tag().remove(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|id")));
            if (llllllllllllllllIlIlIlIllllIlllI != null) {
                llllllllllllllllIlIlIlIllllIlIlI.setIdentifier(llllllllllllllllIlIlIlIllllIlllI.asInt());
            }
        }
        return llllllllllllllllIlIlIlIllllIlIlI;
    }
    
    protected ItemRewriter(final T llllllllllllllllIlIlIllIIIlIllII, final TranslatableRewriter llllllllllllllllIlIlIllIIIlIlIII) {
        super(llllllllllllllllIlIlIllIIIlIllII, true);
        this.translatableRewriter = llllllllllllllllIlIlIllIIIlIlIII;
    }
}
