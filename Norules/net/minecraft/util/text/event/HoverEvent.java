package net.minecraft.util.text.event;

import net.minecraft.util.text.*;
import java.util.*;
import com.google.common.collect.*;

public class HoverEvent
{
    private final /* synthetic */ Action action;
    private final /* synthetic */ ITextComponent value;
    
    @Override
    public int hashCode() {
        int lllllllllllllIIllllIIlIIlllIIllI = this.action.hashCode();
        lllllllllllllIIllllIIlIIlllIIllI = 31 * lllllllllllllIIllllIIlIIlllIIllI + ((this.value != null) ? this.value.hashCode() : 0);
        return lllllllllllllIIllllIIlIIlllIIllI;
    }
    
    public Action getAction() {
        return this.action;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllllIIlIIllllIIIl) {
        if (this == lllllllllllllIIllllIIlIIllllIIIl) {
            return true;
        }
        if (lllllllllllllIIllllIIlIIllllIIIl == null || this.getClass() != lllllllllllllIIllllIIlIIllllIIIl.getClass()) {
            return false;
        }
        final HoverEvent lllllllllllllIIllllIIlIIllllIIII = (HoverEvent)lllllllllllllIIllllIIlIIllllIIIl;
        if (this.action != lllllllllllllIIllllIIlIIllllIIII.action) {
            return false;
        }
        if (this.value != null) {
            if (!this.value.equals(lllllllllllllIIllllIIlIIllllIIII.value)) {
                return false;
            }
        }
        else if (lllllllllllllIIllllIIlIIllllIIII.value != null) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("HoverEvent{action=").append(this.action).append(", value='").append(this.value).append('\'').append('}'));
    }
    
    public HoverEvent(final Action lllllllllllllIIllllIIlIIllllllIl, final ITextComponent lllllllllllllIIllllIIlIIllllllll) {
        this.action = lllllllllllllIIllllIIlIIllllllIl;
        this.value = lllllllllllllIIllllIIlIIllllllll;
    }
    
    public ITextComponent getValue() {
        return this.value;
    }
    
    public enum Action
    {
        SHOW_ENTITY("SHOW_ENTITY", 2, "show_entity", true), 
        SHOW_TEXT("SHOW_TEXT", 0, "show_text", true);
        
        private static final /* synthetic */ Map<String, Action> NAME_MAPPING;
        private final /* synthetic */ String canonicalName;
        
        SHOW_ITEM("SHOW_ITEM", 1, "show_item", true);
        
        private final /* synthetic */ boolean allowedInChat;
        
        private Action(final String lllllllllllllIlIIIIIlIllIIlIIlll, final int lllllllllllllIlIIIIIlIllIIlIIllI, final String lllllllllllllIlIIIIIlIllIIlIIlIl, final boolean lllllllllllllIlIIIIIlIllIIlIlIIl) {
            this.canonicalName = lllllllllllllIlIIIIIlIllIIlIIlIl;
            this.allowedInChat = lllllllllllllIlIIIIIlIllIIlIlIIl;
        }
        
        static {
            NAME_MAPPING = Maps.newHashMap();
            final double lllllllllllllIlIIIIIlIllIIllIIIl;
            final Exception lllllllllllllIlIIIIIlIllIIllIIlI = (Exception)((Action[])(Object)(lllllllllllllIlIIIIIlIllIIllIIIl = (double)(Object)values())).length;
            for (double lllllllllllllIlIIIIIlIllIIllIIll = 0; lllllllllllllIlIIIIIlIllIIllIIll < lllllllllllllIlIIIIIlIllIIllIIlI; ++lllllllllllllIlIIIIIlIllIIllIIll) {
                final Action lllllllllllllIlIIIIIlIllIIllIlIl = lllllllllllllIlIIIIIlIllIIllIIIl[lllllllllllllIlIIIIIlIllIIllIIll];
                Action.NAME_MAPPING.put(lllllllllllllIlIIIIIlIllIIllIlIl.getCanonicalName(), lllllllllllllIlIIIIIlIllIIllIlIl);
            }
        }
        
        public String getCanonicalName() {
            return this.canonicalName;
        }
        
        public boolean shouldAllowInChat() {
            return this.allowedInChat;
        }
        
        public static Action getValueByCanonicalName(final String lllllllllllllIlIIIIIlIllIIIlllII) {
            return Action.NAME_MAPPING.get(lllllllllllllIlIIIIIlIllIIIlllII);
        }
    }
}
