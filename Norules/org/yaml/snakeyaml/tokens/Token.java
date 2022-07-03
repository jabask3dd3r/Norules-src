package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public abstract class Token
{
    private final /* synthetic */ Mark endMark;
    private final /* synthetic */ Mark startMark;
    
    public Token(final Mark llllllllllllllIlIlIlIlIlIIlIIlII, final Mark llllllllllllllIlIlIlIlIlIIlIIIll) {
        if (llllllllllllllIlIlIlIlIlIIlIIlII == null || llllllllllllllIlIlIlIlIlIIlIIIll == null) {
            throw new YAMLException("Token requires marks.");
        }
        this.startMark = llllllllllllllIlIlIlIlIlIIlIIlII;
        this.endMark = llllllllllllllIlIlIlIlIlIIlIIIll;
    }
    
    public Mark getEndMark() {
        return this.endMark;
    }
    
    public abstract ID getTokenId();
    
    public Mark getStartMark() {
        return this.startMark;
    }
    
    public enum ID
    {
        Whitespace("<whitespace>"), 
        FlowSequenceEnd("]"), 
        DocumentEnd("<document end>"), 
        BlockEntry("-"), 
        FlowMappingStart("{"), 
        Tag("<tag>"), 
        BlockMappingStart("<block mapping start>"), 
        Alias("<alias>"), 
        BlockEnd("<block end>"), 
        StreamEnd("<stream end>"), 
        Error("<error>"), 
        Comment("#");
        
        private final /* synthetic */ String description;
        
        Scalar("<scalar>"), 
        BlockSequenceStart("<block sequence start>"), 
        DocumentStart("<document start>"), 
        Value(":"), 
        FlowSequenceStart("["), 
        FlowEntry(","), 
        Directive("<directive>"), 
        Key("?"), 
        FlowMappingEnd("}"), 
        StreamStart("<stream start>"), 
        Anchor("<anchor>");
        
        @Override
        public String toString() {
            return this.description;
        }
        
        private ID(final String llllllllllllllIlllIllIlIlIIIIIll) {
            this.description = llllllllllllllIlllIllIlIlIIIIIll;
        }
    }
}
