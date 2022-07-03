package com.viaversion.viaversion.rewriter.meta;

import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;
import com.google.common.base.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.rewriter.*;

public class MetaFilter
{
    private final /* synthetic */ boolean filterFamily;
    private final /* synthetic */ int index;
    private final /* synthetic */ EntityType type;
    private final /* synthetic */ MetaHandler handler;
    
    public EntityType type() {
        return this.type;
    }
    
    public MetaHandler handler() {
        return this.handler;
    }
    
    private boolean matchesType(final EntityType lllllllllllllllIllIlIllIIllllIIl) {
        return lllllllllllllllIllIlIllIIllllIIl != null && (this.filterFamily ? lllllllllllllllIllIlIllIIllllIIl.isOrHasParent(this.type) : (this.type == lllllllllllllllIllIlIllIIllllIIl));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIllIlIllIIlllIIlI) {
        if (this == lllllllllllllllIllIlIllIIlllIIlI) {
            return true;
        }
        if (lllllllllllllllIllIlIllIIlllIIlI == null || this.getClass() != lllllllllllllllIllIlIllIIlllIIlI.getClass()) {
            return false;
        }
        final MetaFilter lllllllllllllllIllIlIllIIlllIIIl = (MetaFilter)lllllllllllllllIllIlIllIIlllIIlI;
        return this.index == lllllllllllllllIllIlIllIIlllIIIl.index && this.filterFamily == lllllllllllllllIllIlIllIIlllIIIl.filterFamily && this.handler.equals(lllllllllllllllIllIlIllIIlllIIIl.handler) && Objects.equals(this.type, lllllllllllllllIllIlIllIIlllIIIl.type);
    }
    
    public int index() {
        return this.index;
    }
    
    public MetaFilter(final EntityType lllllllllllllllIllIlIllIlIIlIlIl, final boolean lllllllllllllllIllIlIllIlIIllIIl, final int lllllllllllllllIllIlIllIlIIlIIll, final MetaHandler lllllllllllllllIllIlIllIlIIlIIlI) {
        Preconditions.checkNotNull((Object)lllllllllllllllIllIlIllIlIIlIIlI, (Object)"MetaHandler cannot be null");
        this.type = lllllllllllllllIllIlIllIlIIlIlIl;
        this.filterFamily = lllllllllllllllIllIlIllIlIIllIIl;
        this.index = lllllllllllllllIllIlIllIlIIlIIll;
        this.handler = lllllllllllllllIllIlIllIlIIlIIlI;
    }
    
    public boolean isFiltered(final EntityType lllllllllllllllIllIlIllIlIIIIIIl, final Metadata lllllllllllllllIllIlIllIlIIIIIII) {
        return (this.index == -1 || lllllllllllllllIllIlIllIlIIIIIII.id() == this.index) && (this.type == null || this.matchesType(lllllllllllllllIllIlIllIlIIIIIIl));
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("MetaFilter{type=").append(this.type).append(", filterFamily=").append(this.filterFamily).append(", index=").append(this.index).append(", handler=").append(this.handler).append('}'));
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIllIlIllIIllIlIlI = this.handler.hashCode();
        lllllllllllllllIllIlIllIIllIlIlI = 31 * lllllllllllllllIllIlIllIIllIlIlI + ((this.type != null) ? this.type.hashCode() : 0);
        lllllllllllllllIllIlIllIIllIlIlI = 31 * lllllllllllllllIllIlIllIIllIlIlI + this.index;
        lllllllllllllllIllIlIllIIllIlIlI = 31 * lllllllllllllllIllIlIllIIllIlIlI + (this.filterFamily ? 1 : 0);
        return lllllllllllllllIllIlIllIIllIlIlI;
    }
    
    public boolean filterFamily() {
        return this.filterFamily;
    }
    
    public static final class Builder
    {
        private /* synthetic */ MetaHandler handler;
        private /* synthetic */ int index;
        private final /* synthetic */ EntityRewriter rewriter;
        private /* synthetic */ boolean filterFamily;
        private /* synthetic */ EntityType type;
        
        public void register() {
            this.rewriter.registerFilter(this.build());
        }
        
        public void removeIndex(final int lllllllllllllIlIlIlIllllIIlIIlII) {
            Preconditions.checkArgument(this.index == -1);
            final int lllllllllllllIlIlIlIllllIIIIlIII;
            this.handler((lllllllllllllIlIlIlIllllIIIIIllI, lllllllllllllIlIlIlIllllIIIIlIlI) -> {
                lllllllllllllIlIlIlIllllIIIIlIII = lllllllllllllIlIlIlIllllIIIIIllI.index();
                if (lllllllllllllIlIlIlIllllIIIIlIII == lllllllllllllIlIlIlIllllIIlIIlII) {
                    lllllllllllllIlIlIlIllllIIIIIllI.cancel();
                }
                else if (lllllllllllllIlIlIlIllllIIIIlIII > lllllllllllllIlIlIlIllllIIlIIlII) {
                    lllllllllllllIlIlIlIllllIIIIIllI.setIndex(lllllllllllllIlIlIlIllllIIIIlIII - 1);
                }
            });
        }
        
        public Builder handlerNoRegister(final MetaHandler lllllllllllllIlIlIlIllllIlllIlIl) {
            Preconditions.checkArgument(this.handler == null);
            this.handler = lllllllllllllIlIlIlIllllIlllIlIl;
            return this;
        }
        
        public Builder type(final EntityType lllllllllllllIlIlIlIlllllIIllIII) {
            Preconditions.checkArgument(this.type == null);
            this.type = lllllllllllllIlIlIlIlllllIIllIII;
            return this;
        }
        
        public void toIndex(final int lllllllllllllIlIlIlIllllIlIIIlII) {
            Preconditions.checkArgument(this.index != -1);
            this.handler((lllllllllllllIlIlIlIlllIlllIlIIl, lllllllllllllIlIlIlIlllIlllIllIl) -> lllllllllllllIlIlIlIlllIlllIlIIl.setIndex(lllllllllllllIlIlIlIllllIlIIIlII));
        }
        
        public Builder filterFamily(final EntityType lllllllllllllIlIlIlIllllIllllIIl) {
            Preconditions.checkArgument(this.type == null);
            this.type = lllllllllllllIlIlIlIllllIllllIIl;
            this.filterFamily = true;
            return this;
        }
        
        public Builder(final EntityRewriter lllllllllllllIlIlIlIlllllIIllllI) {
            this.index = -1;
            this.rewriter = lllllllllllllIlIlIlIlllllIIllllI;
        }
        
        public void addIndex(final int lllllllllllllIlIlIlIllllIIllIlII) {
            Preconditions.checkArgument(this.index == -1);
            this.handler((lllllllllllllIlIlIlIlllIlllllIII, lllllllllllllIlIlIlIlllIlllllIlI) -> {
                if (lllllllllllllIlIlIlIlllIlllllIII.index() >= lllllllllllllIlIlIlIllllIIllIlII) {
                    lllllllllllllIlIlIlIlllIlllllIII.setIndex(lllllllllllllIlIlIlIlllIlllllIII.index() + 1);
                }
            });
        }
        
        public void handler(final MetaHandler lllllllllllllIlIlIlIllllIllIlIIl) {
            Preconditions.checkArgument(this.handler == null);
            this.handler = lllllllllllllIlIlIlIllllIllIlIIl;
            this.register();
        }
        
        public MetaFilter build() {
            return new MetaFilter(this.type, this.filterFamily, this.index, this.handler);
        }
        
        public void cancel(final int lllllllllllllIlIlIlIllllIlIlIlll) {
            this.index = lllllllllllllIlIlIlIllllIlIlIlll;
            this.handler((lllllllllllllIlIlIlIlllIlllIIlIl, lllllllllllllIlIlIlIlllIlllIIIll) -> lllllllllllllIlIlIlIlllIlllIIlIl.cancel());
        }
        
        public Builder index(final int lllllllllllllIlIlIlIlllllIIIIlIl) {
            Preconditions.checkArgument(this.index == -1);
            this.index = lllllllllllllIlIlIlIlllllIIIIlIl;
            return this;
        }
    }
}
