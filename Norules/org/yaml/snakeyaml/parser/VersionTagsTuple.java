package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.*;
import java.util.*;

class VersionTagsTuple
{
    private /* synthetic */ DumperOptions.Version version;
    private /* synthetic */ Map<String, String> tags;
    
    @Override
    public String toString() {
        return String.format("VersionTagsTuple<%s, %s>", this.version, this.tags);
    }
    
    public Map<String, String> getTags() {
        return this.tags;
    }
    
    public VersionTagsTuple(final DumperOptions.Version lllllllllllllIlIlIIIIllllllIIIll, final Map<String, String> lllllllllllllIlIlIIIIllllllIIlIl) {
        this.version = lllllllllllllIlIlIIIIllllllIIIll;
        this.tags = lllllllllllllIlIlIIIIllllllIIlIl;
    }
    
    public DumperOptions.Version getVersion() {
        return this.version;
    }
}
