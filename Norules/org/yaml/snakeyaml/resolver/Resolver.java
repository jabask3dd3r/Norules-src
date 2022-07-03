package org.yaml.snakeyaml.resolver;

import java.util.regex.*;
import org.yaml.snakeyaml.nodes.*;
import java.util.*;

public class Resolver
{
    public static final /* synthetic */ Pattern NULL;
    public static final /* synthetic */ Pattern YAML;
    public static final /* synthetic */ Pattern MERGE;
    protected /* synthetic */ Map<Character, List<ResolverTuple>> yamlImplicitResolvers;
    public static final /* synthetic */ Pattern TIMESTAMP;
    public static final /* synthetic */ Pattern BOOL;
    public static final /* synthetic */ Pattern INT;
    public static final /* synthetic */ Pattern FLOAT;
    public static final /* synthetic */ Pattern EMPTY;
    
    protected void addImplicitResolvers() {
        this.addImplicitResolver(Tag.BOOL, Resolver.BOOL, "yYnNtTfFoO");
        this.addImplicitResolver(Tag.INT, Resolver.INT, "-+0123456789");
        this.addImplicitResolver(Tag.FLOAT, Resolver.FLOAT, "-+0123456789.");
        this.addImplicitResolver(Tag.MERGE, Resolver.MERGE, "<");
        this.addImplicitResolver(Tag.NULL, Resolver.NULL, "~nN\u0000");
        this.addImplicitResolver(Tag.NULL, Resolver.EMPTY, null);
        this.addImplicitResolver(Tag.TIMESTAMP, Resolver.TIMESTAMP, "0123456789");
        this.addImplicitResolver(Tag.YAML, Resolver.YAML, "!&*");
    }
    
    static {
        BOOL = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
        FLOAT = Pattern.compile("^([-+]?(\\.[0-9]+|[0-9_]+(\\.[0-9_]*)?)([eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
        INT = Pattern.compile("^(?:[-+]?0b[0-1_]+|[-+]?0[0-7_]+|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x[0-9a-fA-F_]+|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
        MERGE = Pattern.compile("^(?:<<)$");
        NULL = Pattern.compile("^(?:~|null|Null|NULL| )$");
        EMPTY = Pattern.compile("^$");
        TIMESTAMP = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
        VALUE = Pattern.compile("^(?:=)$");
        YAML = Pattern.compile("^(?:!|&|\\*)$");
    }
    
    public void addImplicitResolver(final Tag lllllllllllllIIllIIlllIlllllllII, final Pattern lllllllllllllIIllIIlllIlllllllll, final String lllllllllllllIIllIIlllIllllllIlI) {
        if (lllllllllllllIIllIIlllIllllllIlI == null) {
            List<ResolverTuple> lllllllllllllIIllIIllllIIIIIIlll = this.yamlImplicitResolvers.get(null);
            if (lllllllllllllIIllIIllllIIIIIIlll == null) {
                lllllllllllllIIllIIllllIIIIIIlll = new ArrayList<ResolverTuple>();
                this.yamlImplicitResolvers.put(null, lllllllllllllIIllIIllllIIIIIIlll);
            }
            lllllllllllllIIllIIllllIIIIIIlll.add(new ResolverTuple(lllllllllllllIIllIIlllIlllllllII, lllllllllllllIIllIIlllIlllllllll));
        }
        else {
            final char[] lllllllllllllIIllIIllllIIIIIIIlI = lllllllllllllIIllIIlllIllllllIlI.toCharArray();
            for (int lllllllllllllIIllIIllllIIIIIIlII = 0, lllllllllllllIIllIIllllIIIIIIIll = lllllllllllllIIllIIllllIIIIIIIlI.length; lllllllllllllIIllIIllllIIIIIIlII < lllllllllllllIIllIIllllIIIIIIIll; ++lllllllllllllIIllIIllllIIIIIIlII) {
                Character lllllllllllllIIllIIllllIIIIIIllI = lllllllllllllIIllIIllllIIIIIIIlI[lllllllllllllIIllIIllllIIIIIIlII];
                if (lllllllllllllIIllIIllllIIIIIIllI == '\0') {
                    lllllllllllllIIllIIllllIIIIIIllI = null;
                }
                List<ResolverTuple> lllllllllllllIIllIIllllIIIIIIlIl = this.yamlImplicitResolvers.get(lllllllllllllIIllIIllllIIIIIIllI);
                if (lllllllllllllIIllIIllllIIIIIIlIl == null) {
                    lllllllllllllIIllIIllllIIIIIIlIl = new ArrayList<ResolverTuple>();
                    this.yamlImplicitResolvers.put(lllllllllllllIIllIIllllIIIIIIllI, lllllllllllllIIllIIllllIIIIIIlIl);
                }
                lllllllllllllIIllIIllllIIIIIIlIl.add(new ResolverTuple(lllllllllllllIIllIIlllIlllllllII, lllllllllllllIIllIIlllIlllllllll));
            }
        }
    }
    
    public Resolver() {
        this.yamlImplicitResolvers = new HashMap<Character, List<ResolverTuple>>();
        this.addImplicitResolvers();
    }
    
    public Tag resolve(final NodeId lllllllllllllIIllIIlllIllllIIIII, final String lllllllllllllIIllIIlllIlllIlllll, final boolean lllllllllllllIIllIIlllIlllIllIlI) {
        if (lllllllllllllIIllIIlllIllllIIIII == NodeId.scalar && lllllllllllllIIllIIlllIlllIllIlI) {
            List<ResolverTuple> lllllllllllllIIllIIlllIllllIIIlI = null;
            if (lllllllllllllIIllIIlllIlllIlllll.length() == 0) {
                final List<ResolverTuple> lllllllllllllIIllIIlllIllllIlIll = this.yamlImplicitResolvers.get('\0');
            }
            else {
                lllllllllllllIIllIIlllIllllIIIlI = this.yamlImplicitResolvers.get(lllllllllllllIIllIIlllIlllIlllll.charAt(0));
            }
            if (lllllllllllllIIllIIlllIllllIIIlI != null) {
                for (final ResolverTuple lllllllllllllIIllIIlllIllllIlIII : lllllllllllllIIllIIlllIllllIIIlI) {
                    final Tag lllllllllllllIIllIIlllIllllIlIlI = lllllllllllllIIllIIlllIllllIlIII.getTag();
                    final Pattern lllllllllllllIIllIIlllIllllIlIIl = lllllllllllllIIllIIlllIllllIlIII.getRegexp();
                    if (lllllllllllllIIllIIlllIllllIlIIl.matcher(lllllllllllllIIllIIlllIlllIlllll).matches()) {
                        return lllllllllllllIIllIIlllIllllIlIlI;
                    }
                }
            }
            if (this.yamlImplicitResolvers.containsKey(null)) {
                for (final ResolverTuple lllllllllllllIIllIIlllIllllIIlII : this.yamlImplicitResolvers.get(null)) {
                    final Tag lllllllllllllIIllIIlllIllllIIllI = lllllllllllllIIllIIlllIllllIIlII.getTag();
                    final Pattern lllllllllllllIIllIIlllIllllIIlIl = lllllllllllllIIllIIlllIllllIIlII.getRegexp();
                    if (lllllllllllllIIllIIlllIllllIIlIl.matcher(lllllllllllllIIllIIlllIlllIlllll).matches()) {
                        return lllllllllllllIIllIIlllIllllIIllI;
                    }
                }
            }
        }
        switch (lllllllllllllIIllIIlllIllllIIIII) {
            case scalar: {
                return Tag.STR;
            }
            case sequence: {
                return Tag.SEQ;
            }
            default: {
                return Tag.MAP;
            }
        }
    }
}
