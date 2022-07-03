package net.minecraft.util.text.event;

import java.util.*;
import com.google.common.collect.*;

public class ClickEvent
{
    private final /* synthetic */ Action action;
    private final /* synthetic */ String value;
    
    public Action getAction() {
        return this.action;
    }
    
    public ClickEvent(final Action lllllllllllllllIllIIIlIIllIlIIlI, final String lllllllllllllllIllIIIlIIllIlIlII) {
        this.action = lllllllllllllllIllIIIlIIllIlIIlI;
        this.value = lllllllllllllllIllIIIlIIllIlIlII;
    }
    
    public String getValue() {
        return this.value;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIllIIIlIIlIlllIll = this.action.hashCode();
        lllllllllllllllIllIIIlIIlIlllIll = 31 * lllllllllllllllIllIIIlIIlIlllIll + ((this.value != null) ? this.value.hashCode() : 0);
        return lllllllllllllllIllIIIlIIlIlllIll;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIllIIIlIIllIIIllI) {
        if (this == lllllllllllllllIllIIIlIIllIIIllI) {
            return true;
        }
        if (lllllllllllllllIllIIIlIIllIIIllI == null || this.getClass() != lllllllllllllllIllIIIlIIllIIIllI.getClass()) {
            return false;
        }
        final ClickEvent lllllllllllllllIllIIIlIIllIIIlIl = (ClickEvent)lllllllllllllllIllIIIlIIllIIIllI;
        if (this.action != lllllllllllllllIllIIIlIIllIIIlIl.action) {
            return false;
        }
        if (this.value != null) {
            if (!this.value.equals(lllllllllllllllIllIIIlIIllIIIlIl.value)) {
                return false;
            }
        }
        else if (lllllllllllllllIllIIIlIIllIIIlIl.value != null) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("ClickEvent{action=").append(this.action).append(", value='").append(this.value).append('\'').append('}'));
    }
    
    public enum Action
    {
        SUGGEST_COMMAND("SUGGEST_COMMAND", 3, "suggest_command", true), 
        RUN_COMMAND("RUN_COMMAND", 2, "run_command", true);
        
        private final /* synthetic */ boolean allowedInChat;
        
        OPEN_URL("OPEN_URL", 0, "open_url", true), 
        OPEN_FILE("OPEN_FILE", 1, "open_file", false);
        
        private static final /* synthetic */ Map<String, Action> NAME_MAPPING;
        private final /* synthetic */ String canonicalName;
        
        CHANGE_PAGE("CHANGE_PAGE", 4, "change_page", true);
        
        public boolean shouldAllowInChat() {
            return this.allowedInChat;
        }
        
        private Action(final String llllllllllllllllIllIIlIllllIIIIl, final int llllllllllllllllIllIIlIllllIIIII, final String llllllllllllllllIllIIlIllllIIlII, final boolean llllllllllllllllIllIIlIllllIIIll) {
            this.canonicalName = llllllllllllllllIllIIlIllllIIlII;
            this.allowedInChat = llllllllllllllllIllIIlIllllIIIll;
        }
        
        public String getCanonicalName() {
            return this.canonicalName;
        }
        
        static {
            NAME_MAPPING = Maps.newHashMap();
            final int llllllllllllllllIllIIlIllllIlIll;
            final boolean llllllllllllllllIllIIlIllllIllII = ((Action[])(Object)(llllllllllllllllIllIIlIllllIlIll = (int)(Object)values())).length != 0;
            for (byte llllllllllllllllIllIIlIllllIllIl = 0; llllllllllllllllIllIIlIllllIllIl < (llllllllllllllllIllIIlIllllIllII ? 1 : 0); ++llllllllllllllllIllIIlIllllIllIl) {
                final Action llllllllllllllllIllIIlIllllIllll = llllllllllllllllIllIIlIllllIlIll[llllllllllllllllIllIIlIllllIllIl];
                Action.NAME_MAPPING.put(llllllllllllllllIllIIlIllllIllll.getCanonicalName(), llllllllllllllllIllIIlIllllIllll);
            }
        }
        
        public static Action getValueByCanonicalName(final String llllllllllllllllIllIIlIlllIlIllI) {
            return Action.NAME_MAPPING.get(llllllllllllllllIllIIlIlllIlIllI);
        }
    }
}
