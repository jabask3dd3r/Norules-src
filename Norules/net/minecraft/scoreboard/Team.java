package net.minecraft.scoreboard;

import net.minecraft.util.text.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.collect.*;

public abstract class Team
{
    public abstract String getRegisteredName();
    
    public abstract TextFormatting getChatFormat();
    
    public abstract CollisionRule getCollisionRule();
    
    public boolean isSameTeam(@Nullable final Team lllllllllllllIllllIllllIlllIIIII) {
        return lllllllllllllIllllIllllIlllIIIII != null && this == lllllllllllllIllllIllllIlllIIIII;
    }
    
    public abstract String formatString(final String p0);
    
    public abstract boolean getAllowFriendlyFire();
    
    public abstract Collection<String> getMembershipCollection();
    
    public abstract EnumVisible getDeathMessageVisibility();
    
    public abstract boolean getSeeFriendlyInvisiblesEnabled();
    
    public abstract EnumVisible getNameTagVisibility();
    
    public enum EnumVisible
    {
        NEVER("NEVER", 1, "never", 1);
        
        public final /* synthetic */ String internalName;
        
        HIDE_FOR_OTHER_TEAMS("HIDE_FOR_OTHER_TEAMS", 2, "hideForOtherTeams", 2), 
        HIDE_FOR_OWN_TEAM("HIDE_FOR_OWN_TEAM", 3, "hideForOwnTeam", 3);
        
        private static final /* synthetic */ Map<String, EnumVisible> nameMap;
        
        ALWAYS("ALWAYS", 0, "always", 0);
        
        public final /* synthetic */ int id;
        
        public static String[] getNames() {
            return EnumVisible.nameMap.keySet().toArray(new String[EnumVisible.nameMap.size()]);
        }
        
        private EnumVisible(final String lllllllllllllIllIlllIlIIlIIllllI, final int lllllllllllllIllIlllIlIIlIIlllIl, final String lllllllllllllIllIlllIlIIlIlIIIIl, final int lllllllllllllIllIlllIlIIlIIllIll) {
            this.internalName = lllllllllllllIllIlllIlIIlIlIIIIl;
            this.id = lllllllllllllIllIlllIlIIlIIllIll;
        }
        
        @Nullable
        public static EnumVisible getByName(final String lllllllllllllIllIlllIlIIlIlIlIIl) {
            return EnumVisible.nameMap.get(lllllllllllllIllIlllIlIIlIlIlIIl);
        }
        
        static {
            nameMap = Maps.newHashMap();
            final float lllllllllllllIllIlllIlIIlIlIlIll;
            final float lllllllllllllIllIlllIlIIlIlIllII = ((EnumVisible[])(Object)(lllllllllllllIllIlllIlIIlIlIlIll = (float)(Object)values())).length;
            for (Exception lllllllllllllIllIlllIlIIlIlIllIl = (Exception)0; lllllllllllllIllIlllIlIIlIlIllIl < lllllllllllllIllIlllIlIIlIlIllII; ++lllllllllllllIllIlllIlIIlIlIllIl) {
                final EnumVisible lllllllllllllIllIlllIlIIlIlIllll = lllllllllllllIllIlllIlIIlIlIlIll[lllllllllllllIllIlllIlIIlIlIllIl];
                EnumVisible.nameMap.put(lllllllllllllIllIlllIlIIlIlIllll.internalName, lllllllllllllIllIlllIlIIlIlIllll);
            }
        }
    }
    
    public enum CollisionRule
    {
        HIDE_FOR_OWN_TEAM("HIDE_FOR_OWN_TEAM", 3, "pushOwnTeam", 3);
        
        private static final /* synthetic */ Map<String, CollisionRule> nameMap;
        
        ALWAYS("ALWAYS", 0, "always", 0), 
        HIDE_FOR_OTHER_TEAMS("HIDE_FOR_OTHER_TEAMS", 2, "pushOtherTeams", 2);
        
        public final /* synthetic */ int id;
        
        NEVER("NEVER", 1, "never", 1);
        
        public final /* synthetic */ String name;
        
        public static String[] getNames() {
            return CollisionRule.nameMap.keySet().toArray(new String[CollisionRule.nameMap.size()]);
        }
        
        static {
            nameMap = Maps.newHashMap();
            final byte lllllllllllllllIlIlllIlIIllIlIIl;
            final long lllllllllllllllIlIlllIlIIllIlIlI = ((CollisionRule[])(Object)(lllllllllllllllIlIlllIlIIllIlIIl = (byte)(Object)values())).length;
            for (Exception lllllllllllllllIlIlllIlIIllIlIll = (Exception)0; lllllllllllllllIlIlllIlIIllIlIll < lllllllllllllllIlIlllIlIIllIlIlI; ++lllllllllllllllIlIlllIlIIllIlIll) {
                final CollisionRule lllllllllllllllIlIlllIlIIllIllIl = lllllllllllllllIlIlllIlIIllIlIIl[lllllllllllllllIlIlllIlIIllIlIll];
                CollisionRule.nameMap.put(lllllllllllllllIlIlllIlIIllIllIl.name, lllllllllllllllIlIlllIlIIllIllIl);
            }
        }
        
        @Nullable
        public static CollisionRule getByName(final String lllllllllllllllIlIlllIlIIllIIllI) {
            return CollisionRule.nameMap.get(lllllllllllllllIlIlllIlIIllIIllI);
        }
        
        private CollisionRule(final String lllllllllllllllIlIlllIlIIlIlllII, final int lllllllllllllllIlIlllIlIIlIllIll, final String lllllllllllllllIlIlllIlIIlIlllll, final int lllllllllllllllIlIlllIlIIlIllIIl) {
            this.name = lllllllllllllllIlIlllIlIIlIlllll;
            this.id = lllllllllllllllIlIlllIlIIlIllIIl;
        }
    }
}
