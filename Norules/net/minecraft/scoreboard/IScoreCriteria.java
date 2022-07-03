package net.minecraft.scoreboard;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;

public interface IScoreCriteria
{
    EnumRenderType getRenderType();
    
    boolean isReadOnly();
    
    String getName();
    
    public enum EnumRenderType
    {
        HEARTS("HEARTS", 1, "hearts");
        
        private static final /* synthetic */ Map<String, EnumRenderType> BY_NAME;
        
        INTEGER("INTEGER", 0, "integer");
        
        private final /* synthetic */ String renderType;
        
        static {
            BY_NAME = Maps.newHashMap();
            final float lIIIlIllIlllII;
            final long lIIIlIllIlllIl = ((EnumRenderType[])(Object)(lIIIlIllIlllII = (float)(Object)values())).length;
            for (double lIIIlIllIllllI = 0; lIIIlIllIllllI < lIIIlIllIlllIl; ++lIIIlIllIllllI) {
                final EnumRenderType lIIIlIlllIIIII = lIIIlIllIlllII[lIIIlIllIllllI];
                EnumRenderType.BY_NAME.put(lIIIlIlllIIIII.getRenderType(), lIIIlIlllIIIII);
            }
        }
        
        public String getRenderType() {
            return this.renderType;
        }
        
        private EnumRenderType(final String lIIIlIllIlIlII, final int lIIIlIllIlIIll, final String lIIIlIllIlIIlI) {
            this.renderType = lIIIlIllIlIIlI;
        }
        
        public static EnumRenderType getByName(final String lIIIlIllIIlIlI) {
            final EnumRenderType lIIIlIllIIlIll = EnumRenderType.BY_NAME.get(lIIIlIllIIlIlI);
            return (lIIIlIllIIlIll == null) ? EnumRenderType.INTEGER : lIIIlIllIIlIll;
        }
    }
}
