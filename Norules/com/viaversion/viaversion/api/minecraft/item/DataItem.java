package com.viaversion.viaversion.api.minecraft.item;

import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.gson.annotations.*;
import java.util.*;

public class DataItem implements Item
{
    private /* synthetic */ CompoundTag tag;
    private /* synthetic */ short data;
    @SerializedName(value = "identifier", alternate = { "id" })
    private /* synthetic */ int identifier;
    private /* synthetic */ byte amount;
    
    @Override
    public void setData(final short lllllllllllllIlIllIllllIlIlIIllI) {
        this.data = lllllllllllllIlIllIllllIlIlIIllI;
    }
    
    @Override
    public void setTag(final CompoundTag lllllllllllllIlIllIllllIlIIlllIl) {
        this.tag = lllllllllllllIlIllIllllIlIIlllIl;
    }
    
    public DataItem(final Item lllllllllllllIlIllIllllIllIIIIIl) {
        this(lllllllllllllIlIllIllllIllIIIIIl.identifier(), (byte)lllllllllllllIlIllIllllIllIIIIIl.amount(), lllllllllllllIlIllIllllIllIIIIIl.data(), lllllllllllllIlIllIllllIllIIIIIl.tag());
    }
    
    public DataItem() {
    }
    
    @Override
    public void setIdentifier(final int lllllllllllllIlIllIllllIlIllIllI) {
        this.identifier = lllllllllllllIlIllIllllIlIllIllI;
    }
    
    public DataItem(final int lllllllllllllIlIllIllllIllIIlIII, final byte lllllllllllllIlIllIllllIllIIllII, final short lllllllllllllIlIllIllllIllIIIllI, final CompoundTag lllllllllllllIlIllIllllIllIIIlIl) {
        this.identifier = lllllllllllllIlIllIllllIllIIlIII;
        this.amount = lllllllllllllIlIllIllllIllIIllII;
        this.data = lllllllllllllIlIllIllllIllIIIllI;
        this.tag = lllllllllllllIlIllIllllIllIIIlIl;
    }
    
    @Override
    public int identifier() {
        return this.identifier;
    }
    
    @Override
    public int amount() {
        return this.amount;
    }
    
    @Override
    public void setAmount(final int lllllllllllllIlIllIllllIlIlIllIl) {
        if (lllllllllllllIlIllIllllIlIlIllIl > 127 || lllllllllllllIlIllIllllIlIlIllIl < -128) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid item amount: ").append(lllllllllllllIlIllIllllIlIlIllIl)));
        }
        this.amount = (byte)lllllllllllllIlIllIllllIlIlIllIl;
    }
    
    @Override
    public short data() {
        return this.data;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Item{identifier=").append(this.identifier).append(", amount=").append(this.amount).append(", data=").append(this.data).append(", tag=").append(this.tag).append('}'));
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlIllIllllIlIIIlllI = this.identifier;
        lllllllllllllIlIllIllllIlIIIlllI = 31 * lllllllllllllIlIllIllllIlIIIlllI + this.amount;
        lllllllllllllIlIllIllllIlIIIlllI = 31 * lllllllllllllIlIllIllllIlIIIlllI + this.data;
        lllllllllllllIlIllIllllIlIIIlllI = 31 * lllllllllllllIlIllIllllIlIIIlllI + ((this.tag != null) ? this.tag.hashCode() : 0);
        return lllllllllllllIlIllIllllIlIIIlllI;
    }
    
    @Override
    public CompoundTag tag() {
        return this.tag;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIllIllllIlIIlIllI) {
        if (this == lllllllllllllIlIllIllllIlIIlIllI) {
            return true;
        }
        if (lllllllllllllIlIllIllllIlIIlIllI == null || this.getClass() != lllllllllllllIlIllIllllIlIIlIllI.getClass()) {
            return false;
        }
        final DataItem lllllllllllllIlIllIllllIlIIlIlIl = (DataItem)lllllllllllllIlIllIllllIlIIlIllI;
        return this.identifier == lllllllllllllIlIllIllllIlIIlIlIl.identifier && this.amount == lllllllllllllIlIllIllllIlIIlIlIl.amount && this.data == lllllllllllllIlIllIllllIlIIlIlIl.data && Objects.equals(this.tag, lllllllllllllIlIllIllllIlIIlIlIl.tag);
    }
}
