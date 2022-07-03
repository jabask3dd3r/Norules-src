package org.yaml.snakeyaml;

import java.util.*;
import org.yaml.snakeyaml.error.*;
import org.yaml.snakeyaml.serializer.*;

public class DumperOptions
{
    private /* synthetic */ ScalarStyle defaultStyle;
    private /* synthetic */ boolean canonical;
    private /* synthetic */ int indent;
    private /* synthetic */ boolean splitLines;
    private /* synthetic */ NonPrintableStyle nonPrintableStyle;
    private /* synthetic */ Version version;
    private /* synthetic */ boolean explicitStart;
    private /* synthetic */ boolean allowReadOnlyProperties;
    private /* synthetic */ boolean explicitEnd;
    private /* synthetic */ int bestWidth;
    private /* synthetic */ FlowStyle defaultFlowStyle;
    private /* synthetic */ int maxSimpleKeyLength;
    private /* synthetic */ boolean allowUnicode;
    private /* synthetic */ AnchorGenerator anchorGenerator;
    private /* synthetic */ Map<String, String> tags;
    private /* synthetic */ Boolean prettyFlow;
    private /* synthetic */ LineBreak lineBreak;
    private /* synthetic */ int indicatorIndent;
    private /* synthetic */ boolean indentWithIndicator;
    private /* synthetic */ TimeZone timeZone;
    
    public boolean isAllowReadOnlyProperties() {
        return this.allowReadOnlyProperties;
    }
    
    public void setDefaultFlowStyle(final FlowStyle llllllllllllllIlIlIIIIlllIllIlll) {
        if (llllllllllllllIlIlIIIIlllIllIlll == null) {
            throw new NullPointerException("Use FlowStyle enum.");
        }
        this.defaultFlowStyle = llllllllllllllIlIlIIIIlllIllIlll;
    }
    
    public void setNonPrintableStyle(final NonPrintableStyle llllllllllllllIlIlIIIIllIIllIlII) {
        this.nonPrintableStyle = llllllllllllllIlIlIIIIllIIllIlII;
    }
    
    public void setAnchorGenerator(final AnchorGenerator llllllllllllllIlIlIIIIllIlIlIlII) {
        this.anchorGenerator = llllllllllllllIlIlIIIIllIlIlIlII;
    }
    
    public void setWidth(final int llllllllllllllIlIlIIIIllllIIllII) {
        this.bestWidth = llllllllllllllIlIlIIIIllllIIllII;
    }
    
    public ScalarStyle getDefaultScalarStyle() {
        return this.defaultStyle;
    }
    
    public void setTimeZone(final TimeZone llllllllllllllIlIlIIIIllIllIIlll) {
        this.timeZone = llllllllllllllIlIlIIIIllIllIIlll;
    }
    
    public void setIndent(final int llllllllllllllIlIlIIIlIIIIIIIIII) {
        if (llllllllllllllIlIlIIIlIIIIIIIIII < 1) {
            throw new YAMLException("Indent must be at least 1");
        }
        if (llllllllllllllIlIlIIIlIIIIIIIIII > 10) {
            throw new YAMLException("Indent must be at most 10");
        }
        this.indent = llllllllllllllIlIlIIIlIIIIIIIIII;
    }
    
    public boolean isCanonical() {
        return this.canonical;
    }
    
    public void setIndentWithIndicator(final boolean llllllllllllllIlIlIIIIlllllIllIl) {
        this.indentWithIndicator = llllllllllllllIlIlIIIIlllllIllIl;
    }
    
    public DumperOptions() {
        this.defaultStyle = ScalarStyle.PLAIN;
        this.defaultFlowStyle = FlowStyle.AUTO;
        this.canonical = false;
        this.allowUnicode = true;
        this.allowReadOnlyProperties = false;
        this.indent = 2;
        this.indicatorIndent = 0;
        this.indentWithIndicator = false;
        this.bestWidth = 80;
        this.splitLines = true;
        this.lineBreak = LineBreak.UNIX;
        this.explicitStart = false;
        this.explicitEnd = false;
        this.timeZone = null;
        this.maxSimpleKeyLength = 128;
        this.nonPrintableStyle = NonPrintableStyle.BINARY;
        this.version = null;
        this.tags = null;
        this.prettyFlow = false;
        this.anchorGenerator = new NumberAnchorGenerator(0);
    }
    
    public TimeZone getTimeZone() {
        return this.timeZone;
    }
    
    public int getWidth() {
        return this.bestWidth;
    }
    
    public void setDefaultScalarStyle(final ScalarStyle llllllllllllllIlIlIIIlIIIIIIIllI) {
        if (llllllllllllllIlIlIIIlIIIIIIIllI == null) {
            throw new NullPointerException("Use ScalarStyle enum.");
        }
        this.defaultStyle = llllllllllllllIlIlIIIlIIIIIIIllI;
    }
    
    public void setExplicitEnd(final boolean llllllllllllllIlIlIIIIlllIIlIIII) {
        this.explicitEnd = llllllllllllllIlIlIIIIlllIIlIIII;
    }
    
    public void setSplitLines(final boolean llllllllllllllIlIlIIIIllllIIIIll) {
        this.splitLines = llllllllllllllIlIlIIIIllllIIIIll;
    }
    
    public void setLineBreak(final LineBreak llllllllllllllIlIlIIIIlllIlIlllI) {
        if (llllllllllllllIlIlIIIIlllIlIlllI == null) {
            throw new NullPointerException("Specify line break.");
        }
        this.lineBreak = llllllllllllllIlIlIIIIlllIlIlllI;
    }
    
    public AnchorGenerator getAnchorGenerator() {
        return this.anchorGenerator;
    }
    
    public boolean isExplicitStart() {
        return this.explicitStart;
    }
    
    public void setPrettyFlow(final boolean llllllllllllllIlIlIIIIllllIlIlIl) {
        this.prettyFlow = llllllllllllllIlIlIIIIllllIlIlIl;
    }
    
    public boolean getSplitLines() {
        return this.splitLines;
    }
    
    public void setVersion(final Version llllllllllllllIlIlIIIIlllllIIlll) {
        this.version = llllllllllllllIlIlIIIIlllllIIlll;
    }
    
    public void setCanonical(final boolean llllllllllllllIlIlIIIIllllIllllI) {
        this.canonical = llllllllllllllIlIlIIIIllllIllllI;
    }
    
    public int getIndent() {
        return this.indent;
    }
    
    public boolean isExplicitEnd() {
        return this.explicitEnd;
    }
    
    public int getMaxSimpleKeyLength() {
        return this.maxSimpleKeyLength;
    }
    
    public LineBreak getLineBreak() {
        return this.lineBreak;
    }
    
    public int getIndicatorIndent() {
        return this.indicatorIndent;
    }
    
    public void setAllowReadOnlyProperties(final boolean llllllllllllllIlIlIIIIllIlllIlIl) {
        this.allowReadOnlyProperties = llllllllllllllIlIlIIIIllIlllIlIl;
    }
    
    public void setTags(final Map<String, String> llllllllllllllIlIlIIIIlllIIIIIlI) {
        this.tags = llllllllllllllIlIlIIIIlllIIIIIlI;
    }
    
    public boolean getIndentWithIndicator() {
        return this.indentWithIndicator;
    }
    
    public void setMaxSimpleKeyLength(final int llllllllllllllIlIlIIIIllIlIIIlIl) {
        if (llllllllllllllIlIlIIIIllIlIIIlIl > 1024) {
            throw new YAMLException("The simple key must not span more than 1024 stream characters. See https://yaml.org/spec/1.1/#id934537");
        }
        this.maxSimpleKeyLength = llllllllllllllIlIlIIIIllIlIIIlIl;
    }
    
    public FlowStyle getDefaultFlowStyle() {
        return this.defaultFlowStyle;
    }
    
    public void setIndicatorIndent(final int llllllllllllllIlIlIIIIllllllIlll) {
        if (llllllllllllllIlIlIIIIllllllIlll < 0) {
            throw new YAMLException("Indicator indent must be non-negative.");
        }
        if (llllllllllllllIlIlIIIIllllllIlll > 9) {
            throw new YAMLException("Indicator indent must be at most Emitter.MAX_INDENT-1: 9");
        }
        this.indicatorIndent = llllllllllllllIlIlIIIIllllllIlll;
    }
    
    public Map<String, String> getTags() {
        return this.tags;
    }
    
    public void setAllowUnicode(final boolean llllllllllllllIlIlIIIlIIIIIlIIIl) {
        this.allowUnicode = llllllllllllllIlIlIIIlIIIIIlIIIl;
    }
    
    public boolean isAllowUnicode() {
        return this.allowUnicode;
    }
    
    public NonPrintableStyle getNonPrintableStyle() {
        return this.nonPrintableStyle;
    }
    
    public boolean isPrettyFlow() {
        return this.prettyFlow;
    }
    
    public Version getVersion() {
        return this.version;
    }
    
    public void setExplicitStart(final boolean llllllllllllllIlIlIIIIlllIIllIll) {
        this.explicitStart = llllllllllllllIlIlIIIIlllIIllIll;
    }
    
    public enum LineBreak
    {
        WIN("\r\n");
        
        private /* synthetic */ String lineBreak;
        
        UNIX("\n"), 
        MAC("\r");
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("Line break: ").append(this.name()));
        }
        
        private LineBreak(final String llllllllllllllIIIlllIllIlIIIIIll) {
            this.lineBreak = llllllllllllllIIIlllIllIlIIIIIll;
        }
        
        public String getString() {
            return this.lineBreak;
        }
        
        public static LineBreak getPlatformLineBreak() {
            final String llllllllllllllIIIlllIllIIllIllll = System.getProperty("line.separator");
            for (final LineBreak llllllllllllllIIIlllIllIIlllIIll : values()) {
                if (llllllllllllllIIIlllIllIIlllIIll.lineBreak.equals(llllllllllllllIIIlllIllIIllIllll)) {
                    return llllllllllllllIIIlllIllIIlllIIll;
                }
            }
            return LineBreak.UNIX;
        }
    }
    
    public enum NonPrintableStyle
    {
        ESCAPE, 
        BINARY;
    }
    
    public enum FlowStyle
    {
        BLOCK(Boolean.FALSE), 
        AUTO((Boolean)null);
        
        private /* synthetic */ Boolean styleBoolean;
        
        FLOW(Boolean.TRUE);
        
        private FlowStyle(final Boolean lllllllllllllIllIlIIlIlIlIIllllI) {
            this.styleBoolean = lllllllllllllIllIlIIlIlIlIIllllI;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("Flow style: '").append(this.styleBoolean).append("'"));
        }
        
        @Deprecated
        public static FlowStyle fromBoolean(final Boolean lllllllllllllIllIlIIlIlIlIIllIII) {
            return (lllllllllllllIllIlIIlIlIlIIllIII == null) ? FlowStyle.AUTO : (lllllllllllllIllIlIIlIlIlIIllIII ? FlowStyle.FLOW : FlowStyle.BLOCK);
        }
        
        public Boolean getStyleBoolean() {
            return this.styleBoolean;
        }
    }
    
    public enum ScalarStyle
    {
        DOUBLE_QUOTED(Character.valueOf('\"')), 
        PLAIN((Character)null);
        
        private /* synthetic */ Character styleChar;
        
        FOLDED(Character.valueOf('>')), 
        SINGLE_QUOTED(Character.valueOf('\'')), 
        LITERAL(Character.valueOf('|'));
        
        private ScalarStyle(final Character lllllllllllllIIIllIllIlIIIlIIIll) {
            this.styleChar = lllllllllllllIIIllIllIlIIIlIIIll;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("Scalar style: '").append(this.styleChar).append("'"));
        }
        
        public Character getChar() {
            return this.styleChar;
        }
        
        public static ScalarStyle createStyle(final Character lllllllllllllIIIllIllIlIIIIIllll) {
            if (lllllllllllllIIIllIllIlIIIIIllll == null) {
                return ScalarStyle.PLAIN;
            }
            switch ((char)lllllllllllllIIIllIllIlIIIIIllll) {
                case '\"': {
                    return ScalarStyle.DOUBLE_QUOTED;
                }
                case '\'': {
                    return ScalarStyle.SINGLE_QUOTED;
                }
                case '|': {
                    return ScalarStyle.LITERAL;
                }
                case '>': {
                    return ScalarStyle.FOLDED;
                }
                default: {
                    throw new YAMLException(String.valueOf(new StringBuilder().append("Unknown scalar style character: ").append(lllllllllllllIIIllIllIlIIIIIllll)));
                }
            }
        }
    }
    
    public enum Version
    {
        V1_0(new Integer[] { 1, 0 });
        
        private /* synthetic */ Integer[] version;
        
        V1_1(new Integer[] { 1, 1 });
        
        public String getRepresentation() {
            return String.valueOf(new StringBuilder().append(this.version[0]).append(".").append(this.version[1]));
        }
        
        private Version(final Integer[] llllllllllllllIlllllIIIIIIIIIIlI) {
            this.version = llllllllllllllIlllllIIIIIIIIIIlI;
        }
        
        public int minor() {
            return this.version[1];
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("Version: ").append(this.getRepresentation()));
        }
        
        public int major() {
            return this.version[0];
        }
    }
}
