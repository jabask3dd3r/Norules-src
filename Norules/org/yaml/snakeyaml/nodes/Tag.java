package org.yaml.snakeyaml.nodes;

import java.math.*;
import java.util.*;
import org.yaml.snakeyaml.util.*;
import org.yaml.snakeyaml.error.*;
import java.net.*;

public final class Tag
{
    public static final /* synthetic */ Tag INT;
    private /* synthetic */ boolean secondary;
    private final /* synthetic */ String value;
    protected static final /* synthetic */ Map<Tag, Set<Class<?>>> COMPATIBILITY_MAP;
    public static final /* synthetic */ Tag TIMESTAMP;
    public static final /* synthetic */ Tag FLOAT;
    
    @Override
    public boolean equals(final Object llllllllllllllllIlIIIIIllIIllIll) {
        return llllllllllllllllIlIIIIIllIIllIll instanceof Tag && this.value.equals(((Tag)llllllllllllllllIlIIIIIllIIllIll).getValue());
    }
    
    static {
        PREFIX = "tag:yaml.org,2002:";
        YAML = new Tag("tag:yaml.org,2002:yaml");
        MERGE = new Tag("tag:yaml.org,2002:merge");
        SET = new Tag("tag:yaml.org,2002:set");
        PAIRS = new Tag("tag:yaml.org,2002:pairs");
        OMAP = new Tag("tag:yaml.org,2002:omap");
        BINARY = new Tag("tag:yaml.org,2002:binary");
        INT = new Tag("tag:yaml.org,2002:int");
        FLOAT = new Tag("tag:yaml.org,2002:float");
        TIMESTAMP = new Tag("tag:yaml.org,2002:timestamp");
        BOOL = new Tag("tag:yaml.org,2002:bool");
        NULL = new Tag("tag:yaml.org,2002:null");
        STR = new Tag("tag:yaml.org,2002:str");
        SEQ = new Tag("tag:yaml.org,2002:seq");
        MAP = new Tag("tag:yaml.org,2002:map");
        COMPATIBILITY_MAP = new HashMap<Tag, Set<Class<?>>>();
        final Set<Class<?>> llllllllllllllllIlIIIIIllIIIIIll = new HashSet<Class<?>>();
        llllllllllllllllIlIIIIIllIIIIIll.add(Double.class);
        llllllllllllllllIlIIIIIllIIIIIll.add(Float.class);
        llllllllllllllllIlIIIIIllIIIIIll.add(BigDecimal.class);
        Tag.COMPATIBILITY_MAP.put(Tag.FLOAT, llllllllllllllllIlIIIIIllIIIIIll);
        final Set<Class<?>> llllllllllllllllIlIIIIIllIIIIIlI = new HashSet<Class<?>>();
        llllllllllllllllIlIIIIIllIIIIIlI.add(Integer.class);
        llllllllllllllllIlIIIIIllIIIIIlI.add(Long.class);
        llllllllllllllllIlIIIIIllIIIIIlI.add(BigInteger.class);
        Tag.COMPATIBILITY_MAP.put(Tag.INT, llllllllllllllllIlIIIIIllIIIIIlI);
        final Set<Class<?>> llllllllllllllllIlIIIIIllIIIIIIl = new HashSet<Class<?>>();
        llllllllllllllllIlIIIIIllIIIIIIl.add(Date.class);
        try {
            llllllllllllllllIlIIIIIllIIIIIIl.add(Class.forName("java.sql.Date"));
            llllllllllllllllIlIIIIIllIIIIIIl.add(Class.forName("java.sql.Timestamp"));
        }
        catch (ClassNotFoundException ex) {}
        Tag.COMPATIBILITY_MAP.put(Tag.TIMESTAMP, llllllllllllllllIlIIIIIllIIIIIIl);
    }
    
    public boolean startsWith(final String llllllllllllllllIlIIIIIllIlIlIIl) {
        return this.value.startsWith(llllllllllllllllIlIIIIIllIlIlIIl);
    }
    
    public boolean matches(final Class<?> llllllllllllllllIlIIIIIllIIIlIIl) {
        return this.value.equals(String.valueOf(new StringBuilder().append("tag:yaml.org,2002:").append(llllllllllllllllIlIIIIIllIIIlIIl.getName())));
    }
    
    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
    
    public boolean isSecondary() {
        return this.secondary;
    }
    
    public Tag(final Class<?> llllllllllllllllIlIIIIIllIlllIll) {
        this.secondary = false;
        if (llllllllllllllllIlIIIIIllIlllIll == null) {
            throw new NullPointerException("Class for tag must be provided.");
        }
        this.value = String.valueOf(new StringBuilder().append("tag:yaml.org,2002:").append(UriEncoder.encode(llllllllllllllllIlIIIIIllIlllIll.getName())));
    }
    
    public String getValue() {
        return this.value;
    }
    
    public Tag(final String llllllllllllllllIlIIIIIllIllllll) {
        this.secondary = false;
        if (llllllllllllllllIlIIIIIllIllllll == null) {
            throw new NullPointerException("Tag must be provided.");
        }
        if (llllllllllllllllIlIIIIIllIllllll.length() == 0) {
            throw new IllegalArgumentException("Tag must not be empty.");
        }
        if (llllllllllllllllIlIIIIIllIllllll.trim().length() != llllllllllllllllIlIIIIIllIllllll.length()) {
            throw new IllegalArgumentException("Tag must not contain leading or trailing spaces.");
        }
        this.value = UriEncoder.encode(llllllllllllllllIlIIIIIllIllllll);
        this.secondary = !llllllllllllllllIlIIIIIllIllllll.startsWith("tag:yaml.org,2002:");
    }
    
    public String getClassName() {
        if (!this.value.startsWith("tag:yaml.org,2002:")) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("Invalid tag: ").append(this.value)));
        }
        return UriEncoder.decode(this.value.substring("tag:yaml.org,2002:".length()));
    }
    
    @Override
    public String toString() {
        return this.value;
    }
    
    public boolean isCompatible(final Class<?> llllllllllllllllIlIIIIIllIIlIIll) {
        final Set<Class<?>> llllllllllllllllIlIIIIIllIIlIIlI = Tag.COMPATIBILITY_MAP.get(this);
        return llllllllllllllllIlIIIIIllIIlIIlI != null && llllllllllllllllIlIIIIIllIIlIIlI.contains(llllllllllllllllIlIIIIIllIIlIIll);
    }
    
    @Deprecated
    public Tag(final URI llllllllllllllllIlIIIIIllIllIlIl) {
        this.secondary = false;
        if (llllllllllllllllIlIIIIIllIllIlIl == null) {
            throw new NullPointerException("URI for tag must be provided.");
        }
        this.value = llllllllllllllllIlIIIIIllIllIlIl.toASCIIString();
    }
}
