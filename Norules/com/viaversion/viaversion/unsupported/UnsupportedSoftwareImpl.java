package com.viaversion.viaversion.unsupported;

import com.viaversion.viaversion.api.platform.*;
import com.google.common.base.*;
import java.util.*;

public final class UnsupportedSoftwareImpl implements UnsupportedSoftware
{
    private final /* synthetic */ List<UnsupportedMethods> methods;
    private final /* synthetic */ String reason;
    private final /* synthetic */ List<String> classNames;
    private final /* synthetic */ String name;
    
    @Override
    public String getReason() {
        return this.reason;
    }
    
    @Override
    public boolean findMatch() {
        for (final String lllllllllllllIlIllIlIIllIlllIlII : this.classNames) {
            try {
                Class.forName(lllllllllllllIlIllIlIIllIlllIlII);
                return true;
            }
            catch (ClassNotFoundException lllllllllllllIlIllIlIIllIllIlllI) {
                continue;
            }
            break;
        }
        for (final UnsupportedMethods lllllllllllllIlIllIlIIllIlllIIll : this.methods) {
            if (lllllllllllllIlIllIlIIllIlllIIll.findMatch()) {
                return true;
            }
        }
        return false;
    }
    
    public UnsupportedSoftwareImpl(final String lllllllllllllIlIllIlIIlllIIIIlll, final List<String> lllllllllllllIlIllIlIIlllIIIIIIl, final List<UnsupportedMethods> lllllllllllllIlIllIlIIlllIIIIlIl, final String lllllllllllllIlIllIlIIlllIIIIlII) {
        this.name = lllllllllllllIlIllIlIIlllIIIIlll;
        this.classNames = Collections.unmodifiableList((List<? extends String>)lllllllllllllIlIllIlIIlllIIIIIIl);
        this.methods = Collections.unmodifiableList((List<? extends UnsupportedMethods>)lllllllllllllIlIllIlIIlllIIIIlIl);
        this.reason = lllllllllllllIlIllIlIIlllIIIIlII;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    public static final class Reason
    {
        static {
            DANGEROUS_SERVER_SOFTWARE = "You are using server software that - outside of possibly breaking ViaVersion - can also cause severe damage to your server's integrity as a whole.";
        }
    }
    
    public static final class Builder
    {
        private /* synthetic */ String reason;
        private /* synthetic */ String name;
        private final /* synthetic */ List<String> classNames;
        private final /* synthetic */ List<UnsupportedMethods> methods;
        
        public Builder addMethods(final String llllllllllllllIlIlIIIllIlIIIllII, final String... llllllllllllllIlIlIIIllIlIIIlllI) {
            this.methods.add(new UnsupportedMethods(llllllllllllllIlIlIIIllIlIIIllII, new HashSet<String>(Arrays.asList(llllllllllllllIlIlIIIllIlIIIlllI))));
            return this;
        }
        
        public Builder addMethod(final String llllllllllllllIlIlIIIllIlIIllIII, final String llllllllllllllIlIlIIIllIlIIlIlll) {
            this.methods.add(new UnsupportedMethods(llllllllllllllIlIlIIIllIlIIllIII, Collections.singleton(llllllllllllllIlIlIIIllIlIIlIlll)));
            return this;
        }
        
        public Builder addClassName(final String llllllllllllllIlIlIIIllIlIIIIlll) {
            this.classNames.add(llllllllllllllIlIlIIIllIlIIIIlll);
            return this;
        }
        
        public UnsupportedSoftware build() {
            Preconditions.checkNotNull((Object)this.name);
            Preconditions.checkNotNull((Object)this.reason);
            return new UnsupportedSoftwareImpl(this.name, this.classNames, this.methods, this.reason);
        }
        
        public Builder() {
            this.classNames = new ArrayList<String>();
            this.methods = new ArrayList<UnsupportedMethods>();
        }
        
        public Builder reason(final String llllllllllllllIlIlIIIllIlIIlllll) {
            this.reason = llllllllllllllIlIlIIIllIlIIlllll;
            return this;
        }
        
        public Builder name(final String llllllllllllllIlIlIIIllIlIlIIIll) {
            this.name = llllllllllllllIlIlIIIllIlIlIIIll;
            return this;
        }
    }
}
