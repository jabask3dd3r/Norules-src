package org.yaml.snakeyaml.extensions.compactnotation;

import java.util.*;

public class CompactData
{
    private /* synthetic */ List<String> arguments;
    private /* synthetic */ Map<String, String> properties;
    private /* synthetic */ String prefix;
    
    public CompactData(final String llllllllllllllIIlIIllIlllIIllIII) {
        this.arguments = new ArrayList<String>();
        this.properties = new HashMap<String, String>();
        this.prefix = llllllllllllllIIlIIllIlllIIllIII;
    }
    
    public List<String> getArguments() {
        return this.arguments;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("CompactData: ").append(this.prefix).append(" ").append(this.properties));
    }
    
    public Map<String, String> getProperties() {
        return this.properties;
    }
}
