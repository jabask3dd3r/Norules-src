package org.yaml.snakeyaml.parser;

import org.yaml.snakeyaml.util.*;
import org.yaml.snakeyaml.reader.*;
import org.yaml.snakeyaml.scanner.*;
import org.yaml.snakeyaml.*;
import java.util.*;
import org.yaml.snakeyaml.error.*;
import org.yaml.snakeyaml.events.*;
import org.yaml.snakeyaml.tokens.*;

public class ParserImpl implements Parser
{
    private /* synthetic */ Event currentEvent;
    protected final /* synthetic */ Scanner scanner;
    private static final /* synthetic */ Map<String, String> DEFAULT_TAGS;
    private /* synthetic */ VersionTagsTuple directives;
    private final /* synthetic */ ArrayStack<Production> states;
    private final /* synthetic */ ArrayStack<Mark> marks;
    private /* synthetic */ Production state;
    
    static {
        (DEFAULT_TAGS = new HashMap<String, String>()).put("!", "!");
        ParserImpl.DEFAULT_TAGS.put("!!", "tag:yaml.org,2002:");
    }
    
    @Override
    public Event peekEvent() {
        if (this.currentEvent == null && this.state != null) {
            this.currentEvent = this.state.produce();
        }
        return this.currentEvent;
    }
    
    private Event parseBlockNodeOrIndentlessSequence() {
        return this.parseNode(true, true);
    }
    
    private Event parseFlowNode() {
        return this.parseNode(false, false);
    }
    
    public ParserImpl(final StreamReader lllllllllllllIlllIIIlIllIIllIlII) {
        this(new ScannerImpl(lllllllllllllIlllIIIlIllIIllIlII));
    }
    
    private Event parseNode(final boolean lllllllllllllIlllIIIlIlIllIlIllI, final boolean lllllllllllllIlllIIIlIlIllIlIlIl) {
        Mark lllllllllllllIlllIIIlIlIllIllIlI = null;
        Mark lllllllllllllIlllIIIlIlIllIllIIl = null;
        Mark lllllllllllllIlllIIIlIlIllIllIII = null;
        Event lllllllllllllIlllIIIlIlIllIllIll = null;
        if (this.scanner.checkToken(Token.ID.Alias)) {
            final AliasToken lllllllllllllIlllIIIlIlIllllIIIl = (AliasToken)this.scanner.getToken();
            final Event lllllllllllllIlllIIIlIlIllllIIII = new AliasEvent(lllllllllllllIlllIIIlIlIllllIIIl.getValue(), lllllllllllllIlllIIIlIlIllllIIIl.getStartMark(), lllllllllllllIlllIIIlIlIllllIIIl.getEndMark());
            this.state = this.states.pop();
        }
        else {
            String lllllllllllllIlllIIIlIlIlllIIIlI = null;
            TagTuple lllllllllllllIlllIIIlIlIlllIIIIl = null;
            if (this.scanner.checkToken(Token.ID.Anchor)) {
                final AnchorToken lllllllllllllIlllIIIlIlIlllIlllI = (AnchorToken)this.scanner.getToken();
                lllllllllllllIlllIIIlIlIllIllIlI = lllllllllllllIlllIIIlIlIlllIlllI.getStartMark();
                lllllllllllllIlllIIIlIlIllIllIIl = lllllllllllllIlllIIIlIlIlllIlllI.getEndMark();
                lllllllllllllIlllIIIlIlIlllIIIlI = lllllllllllllIlllIIIlIlIlllIlllI.getValue();
                if (this.scanner.checkToken(Token.ID.Tag)) {
                    final TagToken lllllllllllllIlllIIIlIlIlllIllll = (TagToken)this.scanner.getToken();
                    lllllllllllllIlllIIIlIlIllIllIII = lllllllllllllIlllIIIlIlIlllIllll.getStartMark();
                    lllllllllllllIlllIIIlIlIllIllIIl = lllllllllllllIlllIIIlIlIlllIllll.getEndMark();
                    lllllllllllllIlllIIIlIlIlllIIIIl = lllllllllllllIlllIIIlIlIlllIllll.getValue();
                }
            }
            else if (this.scanner.checkToken(Token.ID.Tag)) {
                final TagToken lllllllllllllIlllIIIlIlIlllIllII = (TagToken)this.scanner.getToken();
                lllllllllllllIlllIIIlIlIllIllIlI = (lllllllllllllIlllIIIlIlIllIllIII = lllllllllllllIlllIIIlIlIlllIllII.getStartMark());
                lllllllllllllIlllIIIlIlIllIllIIl = lllllllllllllIlllIIIlIlIlllIllII.getEndMark();
                lllllllllllllIlllIIIlIlIlllIIIIl = lllllllllllllIlllIIIlIlIlllIllII.getValue();
                if (this.scanner.checkToken(Token.ID.Anchor)) {
                    final AnchorToken lllllllllllllIlllIIIlIlIlllIllIl = (AnchorToken)this.scanner.getToken();
                    lllllllllllllIlllIIIlIlIllIllIIl = lllllllllllllIlllIIIlIlIlllIllIl.getEndMark();
                    lllllllllllllIlllIIIlIlIlllIIIlI = lllllllllllllIlllIIIlIlIlllIllIl.getValue();
                }
            }
            String lllllllllllllIlllIIIlIlIlllIIIII = null;
            if (lllllllllllllIlllIIIlIlIlllIIIIl != null) {
                final String lllllllllllllIlllIIIlIlIlllIlIll = lllllllllllllIlllIIIlIlIlllIIIIl.getHandle();
                final String lllllllllllllIlllIIIlIlIlllIlIlI = lllllllllllllIlllIIIlIlIlllIIIIl.getSuffix();
                if (lllllllllllllIlllIIIlIlIlllIlIll != null) {
                    if (!this.directives.getTags().containsKey(lllllllllllllIlllIIIlIlIlllIlIll)) {
                        throw new ParserException("while parsing a node", lllllllllllllIlllIIIlIlIllIllIlI, String.valueOf(new StringBuilder().append("found undefined tag handle ").append(lllllllllllllIlllIIIlIlIlllIlIll)), lllllllllllllIlllIIIlIlIllIllIII);
                    }
                    lllllllllllllIlllIIIlIlIlllIIIII = String.valueOf(new StringBuilder().append(this.directives.getTags().get(lllllllllllllIlllIIIlIlIlllIlIll)).append(lllllllllllllIlllIIIlIlIlllIlIlI));
                }
                else {
                    lllllllllllllIlllIIIlIlIlllIIIII = lllllllllllllIlllIIIlIlIlllIlIlI;
                }
            }
            if (lllllllllllllIlllIIIlIlIllIllIlI == null) {
                lllllllllllllIlllIIIlIlIllIllIlI = (lllllllllllllIlllIIIlIlIllIllIIl = this.scanner.peekToken().getStartMark());
            }
            lllllllllllllIlllIIIlIlIllIllIll = null;
            final boolean lllllllllllllIlllIIIlIlIllIlllll = lllllllllllllIlllIIIlIlIlllIIIII == null || lllllllllllllIlllIIIlIlIlllIIIII.equals("!");
            if (lllllllllllllIlllIIIlIlIllIlIlIl && this.scanner.checkToken(Token.ID.BlockEntry)) {
                lllllllllllllIlllIIIlIlIllIllIIl = this.scanner.peekToken().getEndMark();
                lllllllllllllIlllIIIlIlIllIllIll = new SequenceStartEvent(lllllllllllllIlllIIIlIlIlllIIIlI, lllllllllllllIlllIIIlIlIlllIIIII, lllllllllllllIlllIIIlIlIllIlllll, lllllllllllllIlllIIIlIlIllIllIlI, lllllllllllllIlllIIIlIlIllIllIIl, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseIndentlessSequenceEntry();
            }
            else if (this.scanner.checkToken(Token.ID.Scalar)) {
                final ScalarToken lllllllllllllIlllIIIlIlIlllIIlll = (ScalarToken)this.scanner.getToken();
                lllllllllllllIlllIIIlIlIllIllIIl = lllllllllllllIlllIIIlIlIlllIIlll.getEndMark();
                ImplicitTuple lllllllllllllIlllIIIlIlIlllIIllI = null;
                if ((lllllllllllllIlllIIIlIlIlllIIlll.getPlain() && lllllllllllllIlllIIIlIlIlllIIIII == null) || "!".equals(lllllllllllllIlllIIIlIlIlllIIIII)) {
                    final ImplicitTuple lllllllllllllIlllIIIlIlIlllIlIIl = new ImplicitTuple(true, false);
                }
                else if (lllllllllllllIlllIIIlIlIlllIIIII == null) {
                    final ImplicitTuple lllllllllllllIlllIIIlIlIlllIlIII = new ImplicitTuple(false, true);
                }
                else {
                    lllllllllllllIlllIIIlIlIlllIIllI = new ImplicitTuple(false, false);
                }
                lllllllllllllIlllIIIlIlIllIllIll = new ScalarEvent(lllllllllllllIlllIIIlIlIlllIIIlI, lllllllllllllIlllIIIlIlIlllIIIII, lllllllllllllIlllIIIlIlIlllIIllI, lllllllllllllIlllIIIlIlIlllIIlll.getValue(), lllllllllllllIlllIIIlIlIllIllIlI, lllllllllllllIlllIIIlIlIllIllIIl, lllllllllllllIlllIIIlIlIlllIIlll.getStyle());
                this.state = this.states.pop();
            }
            else if (this.scanner.checkToken(Token.ID.FlowSequenceStart)) {
                lllllllllllllIlllIIIlIlIllIllIIl = this.scanner.peekToken().getEndMark();
                lllllllllllllIlllIIIlIlIllIllIll = new SequenceStartEvent(lllllllllllllIlllIIIlIlIlllIIIlI, lllllllllllllIlllIIIlIlIlllIIIII, lllllllllllllIlllIIIlIlIllIlllll, lllllllllllllIlllIIIlIlIllIllIlI, lllllllllllllIlllIIIlIlIllIllIIl, DumperOptions.FlowStyle.FLOW);
                this.state = new ParseFlowSequenceFirstEntry();
            }
            else if (this.scanner.checkToken(Token.ID.FlowMappingStart)) {
                lllllllllllllIlllIIIlIlIllIllIIl = this.scanner.peekToken().getEndMark();
                lllllllllllllIlllIIIlIlIllIllIll = new MappingStartEvent(lllllllllllllIlllIIIlIlIlllIIIlI, lllllllllllllIlllIIIlIlIlllIIIII, lllllllllllllIlllIIIlIlIllIlllll, lllllllllllllIlllIIIlIlIllIllIlI, lllllllllllllIlllIIIlIlIllIllIIl, DumperOptions.FlowStyle.FLOW);
                this.state = new ParseFlowMappingFirstKey();
            }
            else if (lllllllllllllIlllIIIlIlIllIlIllI && this.scanner.checkToken(Token.ID.BlockSequenceStart)) {
                lllllllllllllIlllIIIlIlIllIllIIl = this.scanner.peekToken().getStartMark();
                lllllllllllllIlllIIIlIlIllIllIll = new SequenceStartEvent(lllllllllllllIlllIIIlIlIlllIIIlI, lllllllllllllIlllIIIlIlIlllIIIII, lllllllllllllIlllIIIlIlIllIlllll, lllllllllllllIlllIIIlIlIllIllIlI, lllllllllllllIlllIIIlIlIllIllIIl, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseBlockSequenceFirstEntry();
            }
            else if (lllllllllllllIlllIIIlIlIllIlIllI && this.scanner.checkToken(Token.ID.BlockMappingStart)) {
                lllllllllllllIlllIIIlIlIllIllIIl = this.scanner.peekToken().getStartMark();
                lllllllllllllIlllIIIlIlIllIllIll = new MappingStartEvent(lllllllllllllIlllIIIlIlIlllIIIlI, lllllllllllllIlllIIIlIlIlllIIIII, lllllllllllllIlllIIIlIlIllIlllll, lllllllllllllIlllIIIlIlIllIllIlI, lllllllllllllIlllIIIlIlIllIllIIl, DumperOptions.FlowStyle.BLOCK);
                this.state = new ParseBlockMappingFirstKey();
            }
            else {
                if (lllllllllllllIlllIIIlIlIlllIIIlI == null && lllllllllllllIlllIIIlIlIlllIIIII == null) {
                    String lllllllllllllIlllIIIlIlIlllIIlII = null;
                    if (lllllllllllllIlllIIIlIlIllIlIllI) {
                        final String lllllllllllllIlllIIIlIlIlllIIlIl = "block";
                    }
                    else {
                        lllllllllllllIlllIIIlIlIlllIIlII = "flow";
                    }
                    final Token lllllllllllllIlllIIIlIlIlllIIIll = this.scanner.peekToken();
                    throw new ParserException(String.valueOf(new StringBuilder().append("while parsing a ").append(lllllllllllllIlllIIIlIlIlllIIlII).append(" node")), lllllllllllllIlllIIIlIlIllIllIlI, String.valueOf(new StringBuilder().append("expected the node content, but found '").append(lllllllllllllIlllIIIlIlIlllIIIll.getTokenId()).append("'")), lllllllllllllIlllIIIlIlIlllIIIll.getStartMark());
                }
                lllllllllllllIlllIIIlIlIllIllIll = new ScalarEvent(lllllllllllllIlllIIIlIlIlllIIIlI, lllllllllllllIlllIIIlIlIlllIIIII, new ImplicitTuple(lllllllllllllIlllIIIlIlIllIlllll, false), "", lllllllllllllIlllIIIlIlIllIllIlI, lllllllllllllIlllIIIlIlIllIllIIl, DumperOptions.ScalarStyle.PLAIN);
                this.state = this.states.pop();
            }
        }
        return lllllllllllllIlllIIIlIlIllIllIll;
    }
    
    @Override
    public boolean checkEvent(final Event.ID lllllllllllllIlllIIIlIllIIlIlIlI) {
        this.peekEvent();
        return this.currentEvent != null && this.currentEvent.is(lllllllllllllIlllIIIlIllIIlIlIlI);
    }
    
    @Override
    public Event getEvent() {
        this.peekEvent();
        final Event lllllllllllllIlllIIIlIllIIlIIIIl = this.currentEvent;
        this.currentEvent = null;
        return lllllllllllllIlllIIIlIllIIlIIIIl;
    }
    
    private VersionTagsTuple processDirectives() {
        DumperOptions.Version lllllllllllllIlllIIIlIllIIIIllIl = null;
        final HashMap<String, String> lllllllllllllIlllIIIlIllIIIIllII = new HashMap<String, String>();
        while (this.scanner.checkToken(Token.ID.Directive)) {
            final DirectiveToken lllllllllllllIlllIIIlIllIIIlIIIl = (DirectiveToken)this.scanner.getToken();
            if (lllllllllllllIlllIIIlIllIIIlIIIl.getName().equals("YAML")) {
                if (lllllllllllllIlllIIIlIllIIIIllIl != null) {
                    throw new ParserException(null, null, "found duplicate YAML directive", lllllllllllllIlllIIIlIllIIIlIIIl.getStartMark());
                }
                final List<Integer> lllllllllllllIlllIIIlIllIIIlIlll = lllllllllllllIlllIIIlIllIIIlIIIl.getValue();
                final Integer lllllllllllllIlllIIIlIllIIIlIllI = lllllllllllllIlllIIIlIllIIIlIlll.get(0);
                if (lllllllllllllIlllIIIlIllIIIlIllI != 1) {
                    throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", lllllllllllllIlllIIIlIllIIIlIIIl.getStartMark());
                }
                final Integer lllllllllllllIlllIIIlIllIIIlIlIl = lllllllllllllIlllIIIlIllIIIlIlll.get(1);
                switch (lllllllllllllIlllIIIlIllIIIlIlIl) {
                    case 0: {
                        lllllllllllllIlllIIIlIllIIIIllIl = DumperOptions.Version.V1_0;
                        continue;
                    }
                    default: {
                        lllllllllllllIlllIIIlIllIIIIllIl = DumperOptions.Version.V1_1;
                        continue;
                    }
                }
            }
            else {
                if (!lllllllllllllIlllIIIlIllIIIlIIIl.getName().equals("TAG")) {
                    continue;
                }
                final List<String> lllllllllllllIlllIIIlIllIIIlIlII = lllllllllllllIlllIIIlIllIIIlIIIl.getValue();
                final String lllllllllllllIlllIIIlIllIIIlIIll = lllllllllllllIlllIIIlIllIIIlIlII.get(0);
                final String lllllllllllllIlllIIIlIllIIIlIIlI = lllllllllllllIlllIIIlIllIIIlIlII.get(1);
                if (lllllllllllllIlllIIIlIllIIIIllII.containsKey(lllllllllllllIlllIIIlIllIIIlIIll)) {
                    throw new ParserException(null, null, String.valueOf(new StringBuilder().append("duplicate tag handle ").append(lllllllllllllIlllIIIlIllIIIlIIll)), lllllllllllllIlllIIIlIllIIIlIIIl.getStartMark());
                }
                lllllllllllllIlllIIIlIllIIIIllII.put(lllllllllllllIlllIIIlIllIIIlIIll, lllllllllllllIlllIIIlIllIIIlIIlI);
            }
        }
        if (lllllllllllllIlllIIIlIllIIIIllIl != null || !lllllllllllllIlllIIIlIllIIIIllII.isEmpty()) {
            for (final String lllllllllllllIlllIIIlIllIIIlIIII : ParserImpl.DEFAULT_TAGS.keySet()) {
                if (!lllllllllllllIlllIIIlIllIIIIllII.containsKey(lllllllllllllIlllIIIlIllIIIlIIII)) {
                    lllllllllllllIlllIIIlIllIIIIllII.put(lllllllllllllIlllIIIlIllIIIlIIII, ParserImpl.DEFAULT_TAGS.get(lllllllllllllIlllIIIlIllIIIlIIII));
                }
            }
            this.directives = new VersionTagsTuple(lllllllllllllIlllIIIlIllIIIIllIl, lllllllllllllIlllIIIlIllIIIIllII);
        }
        return this.directives;
    }
    
    private Event processEmptyScalar(final Mark lllllllllllllIlllIIIlIlIllIIIlll) {
        return new ScalarEvent(null, null, new ImplicitTuple(true, false), "", lllllllllllllIlllIIIlIlIllIIIlll, lllllllllllllIlllIIIlIlIllIIIlll, DumperOptions.ScalarStyle.PLAIN);
    }
    
    public ParserImpl(final Scanner lllllllllllllIlllIIIlIllIIlIlllI) {
        this.scanner = lllllllllllllIlllIIIlIllIIlIlllI;
        this.currentEvent = null;
        this.directives = new VersionTagsTuple(null, new HashMap<String, String>(ParserImpl.DEFAULT_TAGS));
        this.states = new ArrayStack<Production>(100);
        this.marks = new ArrayStack<Mark>(10);
        this.state = new ParseStreamStart();
    }
    
    private class ParseFlowSequenceEntryMappingValue implements Production
    {
        @Override
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
                final Token lllllllllllllIIlllIIIlllIllllIII = ParserImpl.this.scanner.peekToken();
                return ParserImpl.this.processEmptyScalar(lllllllllllllIIlllIIIlllIllllIII.getStartMark());
            }
            final Token lllllllllllllIIlllIIIlllIllllIIl = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingEnd());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
            return ParserImpl.this.processEmptyScalar(lllllllllllllIIlllIIIlllIllllIIl.getEndMark());
        }
    }
    
    private class ParseFlowSequenceEntryMappingEnd implements Production
    {
        @Override
        public Event produce() {
            ParserImpl.this.state = new ParseFlowSequenceEntry(false);
            final Token lllllllllllllIIIIIllIIlIlIIllIIl = ParserImpl.this.scanner.peekToken();
            return new MappingEndEvent(lllllllllllllIIIIIllIIlIlIIllIIl.getStartMark(), lllllllllllllIIIIIllIIlIlIIllIIl.getEndMark());
        }
    }
    
    private class ParseFlowSequenceEntry implements Production
    {
        private /* synthetic */ boolean first;
        
        public ParseFlowSequenceEntry(final boolean lllllllllllllIIIIllIlIlllllllIlI) {
            this.first = false;
            this.first = lllllllllllllIIIIllIlIlllllllIlI;
        }
        
        @Override
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                if (!this.first) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        final Token lllllllllllllIIIIllIlIllllllIIll = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow sequence", ParserImpl.this.marks.pop(), String.valueOf(new StringBuilder().append("expected ',' or ']', but got ").append(lllllllllllllIIIIllIlIllllllIIll.getTokenId())), lllllllllllllIIIIllIlIllllllIIll.getStartMark());
                    }
                    ParserImpl.this.scanner.getToken();
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    final Token lllllllllllllIIIIllIlIllllllIIlI = ParserImpl.this.scanner.peekToken();
                    final Event lllllllllllllIIIIllIlIllllllIIIl = new MappingStartEvent(null, null, true, lllllllllllllIIIIllIlIllllllIIlI.getStartMark(), lllllllllllllIIIIllIlIllllllIIlI.getEndMark(), DumperOptions.FlowStyle.FLOW);
                    ParserImpl.this.state = new ParseFlowSequenceEntryMappingKey();
                    return lllllllllllllIIIIllIlIllllllIIIl;
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(new ParseFlowSequenceEntry(false));
                    return ParserImpl.this.parseFlowNode();
                }
            }
            final Token lllllllllllllIIIIllIlIlllllIllll = ParserImpl.this.scanner.getToken();
            final Event lllllllllllllIIIIllIlIlllllIlllI = new SequenceEndEvent(lllllllllllllIIIIllIlIlllllIllll.getStartMark(), lllllllllllllIIIIllIlIlllllIllll.getEndMark());
            ParserImpl.this.state = ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return lllllllllllllIIIIllIlIlllllIlllI;
        }
    }
    
    private class ParseFlowSequenceEntryMappingKey implements Production
    {
        @Override
        public Event produce() {
            final Token lllllllllllllIlIIllIlllllIllllIl = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingValue());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingValue();
            return ParserImpl.this.processEmptyScalar(lllllllllllllIlIIllIlllllIllllIl.getEndMark());
        }
    }
    
    private class ParseDocumentStart implements Production
    {
        @Override
        public Event produce() {
            while (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                ParserImpl.this.scanner.getToken();
            }
            Event lllllllllllllllIllIIIlIlIIlIIIIl = null;
            if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                Token lllllllllllllllIllIIIlIlIIlIlIII = ParserImpl.this.scanner.peekToken();
                final Mark lllllllllllllllIllIIIlIlIIlIIlll = lllllllllllllllIllIIIlIlIIlIlIII.getStartMark();
                final VersionTagsTuple lllllllllllllllIllIIIlIlIIlIIllI = ParserImpl.this.processDirectives();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.DocumentStart)) {
                    throw new ParserException(null, null, String.valueOf(new StringBuilder().append("expected '<document start>', but found '").append(ParserImpl.this.scanner.peekToken().getTokenId()).append("'")), ParserImpl.this.scanner.peekToken().getStartMark());
                }
                lllllllllllllllIllIIIlIlIIlIlIII = ParserImpl.this.scanner.getToken();
                final Mark lllllllllllllllIllIIIlIlIIlIIlIl = lllllllllllllllIllIIIlIlIIlIlIII.getEndMark();
                final Event lllllllllllllllIllIIIlIlIIlIIlII = new DocumentStartEvent(lllllllllllllllIllIIIlIlIIlIIlll, lllllllllllllllIllIIIlIlIIlIIlIl, true, lllllllllllllllIllIIIlIlIIlIIllI.getVersion(), lllllllllllllllIllIIIlIlIIlIIllI.getTags());
                ParserImpl.this.states.push(new ParseDocumentEnd());
                ParserImpl.this.state = new ParseDocumentContent();
            }
            else {
                final StreamEndToken lllllllllllllllIllIIIlIlIIlIIIll = (StreamEndToken)ParserImpl.this.scanner.getToken();
                lllllllllllllllIllIIIlIlIIlIIIIl = new StreamEndEvent(lllllllllllllllIllIIIlIlIIlIIIll.getStartMark(), lllllllllllllllIllIIIlIlIIlIIIll.getEndMark());
                if (!ParserImpl.this.states.isEmpty()) {
                    throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected end of stream. States left: ").append(ParserImpl.this.states)));
                }
                if (!ParserImpl.this.marks.isEmpty()) {
                    throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected end of stream. Marks left: ").append(ParserImpl.this.marks)));
                }
                ParserImpl.this.state = null;
            }
            return lllllllllllllllIllIIIlIlIIlIIIIl;
        }
    }
    
    private class ParseDocumentContent implements Production
    {
        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd)) {
                final Event lllllllllllllIlIlIlIlIIllIIIlllI = ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
                ParserImpl.this.state = ParserImpl.this.states.pop();
                return lllllllllllllIlIlIlIlIIllIIIlllI;
            }
            final Production lllllllllllllIlIlIlIlIIllIIIllIl = new ParseBlockNode();
            return lllllllllllllIlIlIlIlIIllIIIllIl.produce();
        }
    }
    
    private class ParseBlockNode implements Production
    {
        @Override
        public Event produce() {
            return ParserImpl.this.parseNode(true, false);
        }
    }
    
    private class ParseDocumentEnd implements Production
    {
        @Override
        public Event produce() {
            Token llllllllllllllIllIllIllIlIIIlIlI = ParserImpl.this.scanner.peekToken();
            Mark llllllllllllllIllIllIllIlIIIlIII;
            final Mark llllllllllllllIllIllIllIlIIIlIIl = llllllllllllllIllIllIllIlIIIlIII = llllllllllllllIllIllIllIlIIIlIlI.getStartMark();
            boolean llllllllllllllIllIllIllIlIIIIlll = false;
            if (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                llllllllllllllIllIllIllIlIIIlIlI = ParserImpl.this.scanner.getToken();
                llllllllllllllIllIllIllIlIIIlIII = llllllllllllllIllIllIllIlIIIlIlI.getEndMark();
                llllllllllllllIllIllIllIlIIIIlll = true;
            }
            final Event llllllllllllllIllIllIllIlIIIIllI = new DocumentEndEvent(llllllllllllllIllIllIllIlIIIlIIl, llllllllllllllIllIllIllIlIIIlIII, llllllllllllllIllIllIllIlIIIIlll);
            ParserImpl.this.state = new ParseDocumentStart();
            return llllllllllllllIllIllIllIlIIIIllI;
        }
    }
    
    private class ParseFlowMappingKey implements Production
    {
        private /* synthetic */ boolean first;
        
        public ParseFlowMappingKey(final boolean lllllllllllllllIIlllllIIllIllllI) {
            this.first = false;
            this.first = lllllllllllllllIIlllllIIllIllllI;
        }
        
        @Override
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                if (!this.first) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        final Token lllllllllllllllIIlllllIIllIllIlI = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow mapping", ParserImpl.this.marks.pop(), String.valueOf(new StringBuilder().append("expected ',' or '}', but got ").append(lllllllllllllllIIlllllIIllIllIlI.getTokenId())), lllllllllllllllIIlllllIIllIllIlI.getStartMark());
                    }
                    ParserImpl.this.scanner.getToken();
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    final Token lllllllllllllllIIlllllIIllIllIIl = ParserImpl.this.scanner.getToken();
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                        ParserImpl.this.states.push(new ParseFlowMappingValue());
                        return ParserImpl.this.parseFlowNode();
                    }
                    ParserImpl.this.state = new ParseFlowMappingValue();
                    return ParserImpl.this.processEmptyScalar(lllllllllllllllIIlllllIIllIllIIl.getEndMark());
                }
                else if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingEmptyValue());
                    return ParserImpl.this.parseFlowNode();
                }
            }
            final Token lllllllllllllllIIlllllIIllIlIlll = ParserImpl.this.scanner.getToken();
            final Event lllllllllllllllIIlllllIIllIlIllI = new MappingEndEvent(lllllllllllllllIIlllllIIllIlIlll.getStartMark(), lllllllllllllllIIlllllIIllIlIlll.getEndMark());
            ParserImpl.this.state = ParserImpl.this.states.pop();
            ParserImpl.this.marks.pop();
            return lllllllllllllllIIlllllIIllIlIllI;
        }
    }
    
    private class ParseFlowMappingEmptyValue implements Production
    {
        @Override
        public Event produce() {
            ParserImpl.this.state = new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
        }
    }
    
    private class ParseFlowMappingValue implements Production
    {
        @Override
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = new ParseFlowMappingKey(false);
                final Token lllllllllllllIIIlIIlllIIlllllIII = ParserImpl.this.scanner.peekToken();
                return ParserImpl.this.processEmptyScalar(lllllllllllllIIIlIIlllIIlllllIII.getStartMark());
            }
            final Token lllllllllllllIIIlIIlllIIlllllIIl = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                ParserImpl.this.states.push(new ParseFlowMappingKey(false));
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(lllllllllllllIIIlIIlllIIlllllIIl.getEndMark());
        }
    }
    
    private class ParseStreamStart implements Production
    {
        @Override
        public Event produce() {
            final StreamStartToken llllllllllllllIIIIlIIlIllIIIlIII = (StreamStartToken)ParserImpl.this.scanner.getToken();
            final Event llllllllllllllIIIIlIIlIllIIIIlll = new StreamStartEvent(llllllllllllllIIIIlIIlIllIIIlIII.getStartMark(), llllllllllllllIIIIlIIlIllIIIlIII.getEndMark());
            ParserImpl.this.state = new ParseImplicitDocumentStart();
            return llllllllllllllIIIIlIIlIllIIIIlll;
        }
    }
    
    private class ParseImplicitDocumentStart implements Production
    {
        @Override
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd)) {
                ParserImpl.this.directives = new VersionTagsTuple(null, ParserImpl.DEFAULT_TAGS);
                final Token lllllllllllllIlIlIllIIlIlIIlllll = ParserImpl.this.scanner.peekToken();
                final Mark lllllllllllllIlIlIllIIlIlIIlllIl;
                final Mark lllllllllllllIlIlIllIIlIlIIllllI = lllllllllllllIlIlIllIIlIlIIlllIl = lllllllllllllIlIlIllIIlIlIIlllll.getStartMark();
                final Event lllllllllllllIlIlIllIIlIlIIlllII = new DocumentStartEvent(lllllllllllllIlIlIllIIlIlIIllllI, lllllllllllllIlIlIllIIlIlIIlllIl, false, null, null);
                ParserImpl.this.states.push(new ParseDocumentEnd());
                ParserImpl.this.state = new ParseBlockNode();
                return lllllllllllllIlIlIllIIlIlIIlllII;
            }
            final Production lllllllllllllIlIlIllIIlIlIIllIll = new ParseDocumentStart();
            return lllllllllllllIlIlIllIIlIlIIllIll.produce();
        }
    }
    
    private class ParseIndentlessSequenceEntry implements Production
    {
        @Override
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                final Token lllllllllllllIIIIIllllllIlIIIlll = ParserImpl.this.scanner.peekToken();
                final Event lllllllllllllIIIIIllllllIlIIIllI = new SequenceEndEvent(lllllllllllllIIIIIllllllIlIIIlll.getStartMark(), lllllllllllllIIIIIllllllIlIIIlll.getEndMark());
                ParserImpl.this.state = ParserImpl.this.states.pop();
                return lllllllllllllIIIIIllllllIlIIIllI;
            }
            final Token lllllllllllllIIIIIllllllIlIIlIIl = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseIndentlessSequenceEntry());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseIndentlessSequenceEntry();
            return ParserImpl.this.processEmptyScalar(lllllllllllllIIIIIllllllIlIIlIIl.getEndMark());
        }
    }
    
    private class ParseFlowMappingFirstKey implements Production
    {
        @Override
        public Event produce() {
            final Token lllllllllllllIIIIIIIllllllIlllll = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(lllllllllllllIIIIIIIllllllIlllll.getStartMark());
            return new ParseFlowMappingKey(true).produce();
        }
    }
    
    private class ParseBlockSequenceEntry implements Production
    {
        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                final BlockEntryToken lllllllllllllIllIIIlIIIlIIlIIIll = (BlockEntryToken)ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockSequenceEntry());
                    return new ParseBlockNode().produce();
                }
                ParserImpl.this.state = new ParseBlockSequenceEntry();
                return ParserImpl.this.processEmptyScalar(lllllllllllllIllIIIlIIIlIIlIIIll.getEndMark());
            }
            else {
                if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                    final Token lllllllllllllIllIIIlIIIlIIlIIIlI = ParserImpl.this.scanner.peekToken();
                    throw new ParserException("while parsing a block collection", ParserImpl.this.marks.pop(), String.valueOf(new StringBuilder().append("expected <block end>, but found '").append(lllllllllllllIllIIIlIIIlIIlIIIlI.getTokenId()).append("'")), lllllllllllllIllIIIlIIIlIIlIIIlI.getStartMark());
                }
                final Token lllllllllllllIllIIIlIIIlIIlIIIII = ParserImpl.this.scanner.getToken();
                final Event lllllllllllllIllIIIlIIIlIIIlllll = new SequenceEndEvent(lllllllllllllIllIIIlIIIlIIlIIIII.getStartMark(), lllllllllllllIllIIIlIIIlIIlIIIII.getEndMark());
                ParserImpl.this.state = ParserImpl.this.states.pop();
                ParserImpl.this.marks.pop();
                return lllllllllllllIllIIIlIIIlIIIlllll;
            }
        }
    }
    
    private class ParseBlockSequenceFirstEntry implements Production
    {
        @Override
        public Event produce() {
            final Token llllllllllllllIllllllIIIlIIllIII = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(llllllllllllllIllllllIIIlIIllIII.getStartMark());
            return new ParseBlockSequenceEntry().produce();
        }
    }
    
    private class ParseBlockMappingValue implements Production
    {
        @Override
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = new ParseBlockMappingKey();
                final Token lllllllllllllIIllIllIlllllIlllIl = ParserImpl.this.scanner.peekToken();
                return ParserImpl.this.processEmptyScalar(lllllllllllllIIllIllIlllllIlllIl.getStartMark());
            }
            final Token lllllllllllllIIllIllIlllllIlllll = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseBlockMappingKey());
                return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
            }
            ParserImpl.this.state = new ParseBlockMappingKey();
            return ParserImpl.this.processEmptyScalar(lllllllllllllIIllIllIlllllIlllll.getEndMark());
        }
    }
    
    private class ParseBlockMappingKey implements Production
    {
        @Override
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                final Token lllllllllllllIlIllIIlIIIllIlIIIl = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingValue());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingValue();
                return ParserImpl.this.processEmptyScalar(lllllllllllllIlIllIIlIIIllIlIIIl.getEndMark());
            }
            else {
                if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                    final Token lllllllllllllIlIllIIlIIIllIlIIII = ParserImpl.this.scanner.peekToken();
                    throw new ParserException("while parsing a block mapping", ParserImpl.this.marks.pop(), String.valueOf(new StringBuilder().append("expected <block end>, but found '").append(lllllllllllllIlIllIIlIIIllIlIIII.getTokenId()).append("'")), lllllllllllllIlIllIIlIIIllIlIIII.getStartMark());
                }
                final Token lllllllllllllIlIllIIlIIIllIIlllI = ParserImpl.this.scanner.getToken();
                final Event lllllllllllllIlIllIIlIIIllIIllIl = new MappingEndEvent(lllllllllllllIlIllIIlIIIllIIlllI.getStartMark(), lllllllllllllIlIllIIlIIIllIIlllI.getEndMark());
                ParserImpl.this.state = ParserImpl.this.states.pop();
                ParserImpl.this.marks.pop();
                return lllllllllllllIlIllIIlIIIllIIllIl;
            }
        }
    }
    
    private class ParseFlowSequenceFirstEntry implements Production
    {
        @Override
        public Event produce() {
            final Token llllllllllllllIllIIlllIllIlIllII = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(llllllllllllllIllIIlllIllIlIllII.getStartMark());
            return new ParseFlowSequenceEntry(true).produce();
        }
    }
    
    private class ParseBlockMappingFirstKey implements Production
    {
        @Override
        public Event produce() {
            final Token lllllllllllllllllIIIlIllllIIIlII = ParserImpl.this.scanner.getToken();
            ParserImpl.this.marks.push(lllllllllllllllllIIIlIllllIIIlII.getStartMark());
            return new ParseBlockMappingKey().produce();
        }
    }
}
