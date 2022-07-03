package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public abstract class ItemRewriterBase<T extends BackwardsProtocol> extends ItemRewriter<T>
{
    protected final /* synthetic */ boolean jsonNameFormat;
    protected final /* synthetic */ String nbtTagName;
    
    protected void restoreDisplayTag(final Item lllllllllllllIlIlIIllIIlIIlllIll) {
        if (lllllllllllllIlIlIIllIIlIIlllIll.tag() == null) {
            return;
        }
        final CompoundTag lllllllllllllIlIlIIllIIlIIlllIlI = lllllllllllllIlIlIIllIIlIIlllIll.tag().get("display");
        if (lllllllllllllIlIlIIllIIlIIlllIlI != null) {
            if (lllllllllllllIlIlIIllIIlIIlllIlI.remove(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|customName"))) != null) {
                lllllllllllllIlIlIIllIIlIIlllIlI.remove("Name");
            }
            else {
                this.restoreStringTag(lllllllllllllIlIlIIllIIlIIlllIlI, "Name");
            }
            this.restoreListTag(lllllllllllllIlIlIIllIIlIIlllIlI, "Lore");
        }
    }
    
    protected boolean hasBackupTag(final CompoundTag lllllllllllllIlIlIIllIIlIllIIlll, final String lllllllllllllIlIlIIllIIlIllIIllI) {
        return lllllllllllllIlIlIIllIIlIllIIlll.contains(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|o").append(lllllllllllllIlIlIIllIIlIllIIllI)));
    }
    
    protected ItemRewriterBase(final T lllllllllllllIlIlIIllIIlIlllIllI, final boolean lllllllllllllIlIlIIllIIlIllllIII) {
        super(lllllllllllllIlIlIIllIIlIlllIllI);
        this.jsonNameFormat = lllllllllllllIlIlIIllIIlIllllIII;
        this.nbtTagName = String.valueOf(new StringBuilder().append("VB|").append(lllllllllllllIlIlIIllIIlIlllIllI.getClass().getSimpleName()));
    }
    
    @Override
    public Item handleItemToServer(final Item lllllllllllllIlIlIIllIIlIlllIIIl) {
        if (lllllllllllllIlIlIIllIIlIlllIIIl == null) {
            return null;
        }
        super.handleItemToServer(lllllllllllllIlIlIIllIIlIlllIIIl);
        this.restoreDisplayTag(lllllllllllllIlIlIIllIIlIlllIIIl);
        return lllllllllllllIlIlIIllIIlIlllIIIl;
    }
    
    protected void saveStringTag(final CompoundTag lllllllllllllIlIlIIllIIlIlIllIlI, final StringTag lllllllllllllIlIlIIllIIlIlIllIIl, final String lllllllllllllIlIlIIllIIlIlIlllIl) {
        final String lllllllllllllIlIlIIllIIlIlIlllII = String.valueOf(new StringBuilder().append(this.nbtTagName).append("|o").append(lllllllllllllIlIlIIllIIlIlIlllIl));
        if (!lllllllllllllIlIlIIllIIlIlIllIlI.contains(lllllllllllllIlIlIIllIIlIlIlllII)) {
            lllllllllllllIlIlIIllIIlIlIllIlI.put(lllllllllllllIlIlIIllIIlIlIlllII, new StringTag(lllllllllllllIlIlIIllIIlIlIllIIl.getValue()));
        }
    }
    
    public String getNbtTagName() {
        return this.nbtTagName;
    }
    
    protected void saveListTag(final CompoundTag lllllllllllllIlIlIIllIIlIlIIIllI, final ListTag lllllllllllllIlIlIIllIIlIlIIlIlI, final String lllllllllllllIlIlIIllIIlIlIIIlII) {
        final String lllllllllllllIlIlIIllIIlIlIIlIII = String.valueOf(new StringBuilder().append(this.nbtTagName).append("|o").append(lllllllllllllIlIlIIllIIlIlIIIlII));
        if (!lllllllllllllIlIlIIllIIlIlIIIllI.contains(lllllllllllllIlIlIIllIIlIlIIlIII)) {
            final ListTag lllllllllllllIlIlIIllIIlIlIIllIl = new ListTag();
            for (final Tag lllllllllllllIlIlIIllIIlIlIIlllI : lllllllllllllIlIlIIllIIlIlIIlIlI.getValue()) {
                lllllllllllllIlIlIIllIIlIlIIllIl.add(lllllllllllllIlIlIIllIIlIlIIlllI.clone());
            }
            lllllllllllllIlIlIIllIIlIlIIIllI.put(lllllllllllllIlIlIIllIIlIlIIlIII, lllllllllllllIlIlIIllIIlIlIIllIl);
        }
    }
    
    protected void restoreStringTag(final CompoundTag lllllllllllllIlIlIIllIIlIIllIIIl, final String lllllllllllllIlIlIIllIIlIIlIllII) {
        final StringTag lllllllllllllIlIlIIllIIlIIlIllll = lllllllllllllIlIlIIllIIlIIllIIIl.remove(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|o").append(lllllllllllllIlIlIIllIIlIIlIllII)));
        if (lllllllllllllIlIlIIllIIlIIlIllll != null) {
            lllllllllllllIlIlIIllIIlIIllIIIl.put(lllllllllllllIlIlIIllIIlIIlIllII, new StringTag(lllllllllllllIlIlIIllIIlIIlIllll.getValue()));
        }
    }
    
    protected void restoreListTag(final CompoundTag lllllllllllllIlIlIIllIIlIIlIIlIl, final String lllllllllllllIlIlIIllIIlIIlIIIII) {
        final ListTag lllllllllllllIlIlIIllIIlIIlIIIll = lllllllllllllIlIlIIllIIlIIlIIlIl.remove(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|o").append(lllllllllllllIlIlIIllIIlIIlIIIII)));
        if (lllllllllllllIlIlIIllIIlIIlIIIll != null) {
            lllllllllllllIlIlIIllIIlIIlIIlIl.put(lllllllllllllIlIlIIllIIlIIlIIIII, new ListTag(lllllllllllllIlIlIIllIIlIIlIIIll.getValue()));
        }
    }
}
