package org.yaml.snakeyaml.tokens;

import java.util.*;
import org.yaml.snakeyaml.error.*;

public final class DirectiveToken<T> extends Token
{
    private final /* synthetic */ String name;
    private final /* synthetic */ List<T> value;
    
    public String getName() {
        return this.name;
    }
    
    public List<T> getValue() {
        return this.value;
    }
    
    public DirectiveToken(final String llllllllllllllIIlIIlllIlllllIIII, final List<T> llllllllllllllIIlIIlllIlllllIlII, final Mark llllllllllllllIIlIIlllIlllllIIll, final Mark llllllllllllllIIlIIlllIllllIllIl) {
        super(llllllllllllllIIlIIlllIlllllIIll, llllllllllllllIIlIIlllIllllIllIl);
        this.name = llllllllllllllIIlIIlllIlllllIIII;
        if (llllllllllllllIIlIIlllIlllllIlII != null && llllllllllllllIIlIIlllIlllllIlII.size() != 2) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("Two strings must be provided instead of ").append(String.valueOf(llllllllllllllIIlIIlllIlllllIlII.size()))));
        }
        this.value = llllllllllllllIIlIIlllIlllllIlII;
    }
    
    @Override
    public ID getTokenId() {
        return ID.Directive;
    }
}
