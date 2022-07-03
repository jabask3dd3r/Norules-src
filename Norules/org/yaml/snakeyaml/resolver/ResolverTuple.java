package org.yaml.snakeyaml.resolver;

import org.yaml.snakeyaml.nodes.*;
import java.util.regex.*;

final class ResolverTuple
{
    private final /* synthetic */ Tag tag;
    private final /* synthetic */ Pattern regexp;
    
    public ResolverTuple(final Tag lllllllllllllIlIIllllIIIllIIlllI, final Pattern lllllllllllllIlIIllllIIIllIIllIl) {
        this.tag = lllllllllllllIlIIllllIIIllIIlllI;
        this.regexp = lllllllllllllIlIIllllIIIllIIllIl;
    }
    
    public Pattern getRegexp() {
        return this.regexp;
    }
    
    public Tag getTag() {
        return this.tag;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Tuple tag=").append(this.tag).append(" regexp=").append(this.regexp));
    }
}
