package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.reader.*;
import java.util.regex.*;
import org.yaml.snakeyaml.*;
import java.util.*;
import org.yaml.snakeyaml.error.*;
import java.nio.*;
import org.yaml.snakeyaml.util.*;
import java.nio.charset.*;
import org.yaml.snakeyaml.tokens.*;

public final class ScannerImpl implements Scanner
{
    private /* synthetic */ int flowLevel;
    private final /* synthetic */ StreamReader reader;
    public static final /* synthetic */ Map<Character, String> ESCAPE_REPLACEMENTS;
    private /* synthetic */ int tokensTaken;
    private /* synthetic */ ArrayStack<Integer> indents;
    private /* synthetic */ List<Token> tokens;
    private /* synthetic */ int indent;
    public static final /* synthetic */ Map<Character, Integer> ESCAPE_CODES;
    private /* synthetic */ boolean allowSimpleKey;
    private /* synthetic */ Map<Integer, SimpleKey> possibleSimpleKeys;
    private /* synthetic */ boolean done;
    private static final /* synthetic */ Pattern NOT_HEXA;
    
    private void fetchLiteral() {
        this.fetchBlockScalar('|');
    }
    
    private void fetchDocumentIndicator(final boolean llllllllllllllllIIIlIIllllIllIlI) {
        this.unwindIndent(-1);
        this.removePossibleSimpleKey();
        this.allowSimpleKey = false;
        final Mark llllllllllllllllIIIlIIllllIllllI = this.reader.getMark();
        this.reader.forward(3);
        final Mark llllllllllllllllIIIlIIllllIlllIl = this.reader.getMark();
        Token llllllllllllllllIIIlIIllllIlllII = null;
        if (llllllllllllllllIIIlIIllllIllIlI) {
            final Token llllllllllllllllIIIlIIlllllIIIIl = new DocumentStartToken(llllllllllllllllIIIlIIllllIllllI, llllllllllllllllIIIlIIllllIlllIl);
        }
        else {
            llllllllllllllllIIIlIIllllIlllII = new DocumentEndToken(llllllllllllllllIIIlIIllllIllllI, llllllllllllllllIIIlIIllllIlllIl);
        }
        this.tokens.add(llllllllllllllllIIIlIIllllIlllII);
    }
    
    private boolean checkDocumentStart() {
        return this.reader.getColumn() == 0 && "---".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }
    
    private String scanBlockScalarIgnoredLine(final Mark llllllllllllllllIIIlIIlIIIIIIlll) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        if (this.reader.peek() == 35) {
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek())) {
                this.reader.forward();
            }
        }
        final int llllllllllllllllIIIlIIlIIIIIlIlI = this.reader.peek();
        final String llllllllllllllllIIIlIIlIIIIIlIIl = this.scanLineBreak();
        if (llllllllllllllllIIIlIIlIIIIIlIIl.length() == 0 && llllllllllllllllIIIlIIlIIIIIlIlI != 0) {
            final String llllllllllllllllIIIlIIlIIIIIllIl = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIIIIIlIlI));
            throw new ScannerException("while scanning a block scalar", llllllllllllllllIIIlIIlIIIIIIlll, String.valueOf(new StringBuilder().append("expected a comment or a line break, but found ").append(llllllllllllllllIIIlIIlIIIIIllIl).append("(").append(llllllllllllllllIIIlIIlIIIIIlIlI).append(")")), this.reader.getMark());
        }
        return llllllllllllllllIIIlIIlIIIIIlIIl;
    }
    
    private String scanTagUri(final String llllllllllllllllIIIlIIIlIIllllII, final Mark llllllllllllllllIIIlIIIlIIlllIll) {
        final StringBuilder llllllllllllllllIIIlIIIlIlIIIIII = new StringBuilder();
        int llllllllllllllllIIIlIIIlIIllllll;
        int llllllllllllllllIIIlIIIlIIlllllI;
        for (llllllllllllllllIIIlIIIlIIllllll = 0, llllllllllllllllIIIlIIIlIIlllllI = this.reader.peek(llllllllllllllllIIIlIIIlIIllllll); Constant.URI_CHARS.has(llllllllllllllllIIIlIIIlIIlllllI); llllllllllllllllIIIlIIIlIIlllllI = this.reader.peek(llllllllllllllllIIIlIIIlIIllllll)) {
            if (llllllllllllllllIIIlIIIlIIlllllI == 37) {
                llllllllllllllllIIIlIIIlIlIIIIII.append(this.reader.prefixForward(llllllllllllllllIIIlIIIlIIllllll));
                llllllllllllllllIIIlIIIlIIllllll = 0;
                llllllllllllllllIIIlIIIlIlIIIIII.append(this.scanUriEscapes(llllllllllllllllIIIlIIIlIIllllII, llllllllllllllllIIIlIIIlIIlllIll));
            }
            else {
                ++llllllllllllllllIIIlIIIlIIllllll;
            }
        }
        if (llllllllllllllllIIIlIIIlIIllllll != 0) {
            llllllllllllllllIIIlIIIlIlIIIIII.append(this.reader.prefixForward(llllllllllllllllIIIlIIIlIIllllll));
        }
        if (llllllllllllllllIIIlIIIlIlIIIIII.length() == 0) {
            final String llllllllllllllllIIIlIIIlIlIIIlII = String.valueOf(Character.toChars(llllllllllllllllIIIlIIIlIIlllllI));
            throw new ScannerException(String.valueOf(new StringBuilder().append("while scanning a ").append(llllllllllllllllIIIlIIIlIIllllII)), llllllllllllllllIIIlIIIlIIlllIll, String.valueOf(new StringBuilder().append("expected URI, but found ").append(llllllllllllllllIIIlIIIlIlIIIlII).append("(").append(llllllllllllllllIIIlIIIlIIlllllI).append(")")), this.reader.getMark());
        }
        return String.valueOf(llllllllllllllllIIIlIIIlIlIIIIII);
    }
    
    private boolean checkPlain() {
        final int llllllllllllllllIIIlIIllIIlIlIIl = this.reader.peek();
        return Constant.NULL_BL_T_LINEBR.hasNo(llllllllllllllllIIIlIIllIIlIlIIl, "-?:,[]{}#&*!|>'\"%@`") || (Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(1)) && (llllllllllllllllIIIlIIllIIlIlIIl == 45 || (this.flowLevel == 0 && "?:".indexOf(llllllllllllllllIIIlIIllIIlIlIIl) != -1)));
    }
    
    private void fetchStreamEnd() {
        this.unwindIndent(-1);
        this.removePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.possibleSimpleKeys.clear();
        final Mark llllllllllllllllIIIlIIllllllIlll = this.reader.getMark();
        final Token llllllllllllllllIIIlIIllllllIllI = new StreamEndToken(llllllllllllllllIIIlIIllllllIlll, llllllllllllllllIIIlIIllllllIlll);
        this.tokens.add(llllllllllllllllIIIlIIllllllIllI);
        this.done = true;
    }
    
    private void fetchDirective() {
        this.unwindIndent(-1);
        this.removePossibleSimpleKey();
        this.allowSimpleKey = false;
        final Token llllllllllllllllIIIlIIlllllIllll = this.scanDirective();
        this.tokens.add(llllllllllllllllIIIlIIlllllIllll);
    }
    
    private boolean checkBlockEntry() {
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }
    
    private void fetchBlockEntry() {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "sequence entries are not allowed here", this.reader.getMark());
            }
            if (this.addIndent(this.reader.getColumn())) {
                final Mark llllllllllllllllIIIlIIlllIIllIlI = this.reader.getMark();
                this.tokens.add(new BlockSequenceStartToken(llllllllllllllllIIIlIIlllIIllIlI, llllllllllllllllIIIlIIlllIIllIlI));
            }
        }
        this.allowSimpleKey = true;
        this.removePossibleSimpleKey();
        final Mark llllllllllllllllIIIlIIlllIIllIII = this.reader.getMark();
        this.reader.forward();
        final Mark llllllllllllllllIIIlIIlllIIlIlll = this.reader.getMark();
        final Token llllllllllllllllIIIlIIlllIIlIllI = new BlockEntryToken(llllllllllllllllIIIlIIlllIIllIII, llllllllllllllllIIIlIIlllIIlIlll);
        this.tokens.add(llllllllllllllllIIIlIIlllIIlIllI);
    }
    
    private void unwindIndent(final int llllllllllllllllIIIlIlIIIIIIllII) {
        if (this.flowLevel != 0) {
            return;
        }
        while (this.indent > llllllllllllllllIIIlIlIIIIIIllII) {
            final Mark llllllllllllllllIIIlIlIIIIIlIIII = this.reader.getMark();
            this.indent = this.indents.pop();
            this.tokens.add(new BlockEndToken(llllllllllllllllIIIlIlIIIIIlIIII, llllllllllllllllIIIlIlIIIIIlIIII));
        }
    }
    
    public ScannerImpl(final StreamReader llllllllllllllllIIIlIlIIIlIlllII) {
        this.done = false;
        this.flowLevel = 0;
        this.tokensTaken = 0;
        this.indent = -1;
        this.allowSimpleKey = true;
        this.reader = llllllllllllllllIIIlIlIIIlIlllII;
        this.tokens = new ArrayList<Token>(100);
        this.indents = new ArrayStack<Integer>(10);
        this.possibleSimpleKeys = new LinkedHashMap<Integer, SimpleKey>();
        this.fetchStreamStart();
    }
    
    private int nextPossibleSimpleKey() {
        if (!this.possibleSimpleKeys.isEmpty()) {
            return this.possibleSimpleKeys.values().iterator().next().getTokenNumber();
        }
        return -1;
    }
    
    private void fetchSingle() {
        this.fetchFlowScalar('\'');
    }
    
    private boolean addIndent(final int llllllllllllllllIIIlIlIIIIIIIlll) {
        if (this.indent < llllllllllllllllIIIlIlIIIIIIIlll) {
            this.indents.push(this.indent);
            this.indent = llllllllllllllllIIIlIlIIIIIIIlll;
            return true;
        }
        return false;
    }
    
    private void fetchFlowSequenceStart() {
        this.fetchFlowCollectionStart(false);
    }
    
    private Token scanTag() {
        final Mark llllllllllllllllIIIlIIlIIllIlIIl = this.reader.getMark();
        int llllllllllllllllIIIlIIlIIllIlIII = this.reader.peek(1);
        String llllllllllllllllIIIlIIlIIllIIlll = null;
        String llllllllllllllllIIIlIIlIIllIIllI = null;
        if (llllllllllllllllIIIlIIlIIllIlIII == 60) {
            this.reader.forward(2);
            llllllllllllllllIIIlIIlIIllIIllI = this.scanTagUri("tag", llllllllllllllllIIIlIIlIIllIlIIl);
            llllllllllllllllIIIlIIlIIllIlIII = this.reader.peek();
            if (llllllllllllllllIIIlIIlIIllIlIII != 62) {
                final String llllllllllllllllIIIlIIlIIllIlllI = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIIllIlIII));
                throw new ScannerException("while scanning a tag", llllllllllllllllIIIlIIlIIllIlIIl, String.valueOf(new StringBuilder().append("expected '>', but found '").append(llllllllllllllllIIIlIIlIIllIlllI).append("' (").append(llllllllllllllllIIIlIIlIIllIlIII).append(")")), this.reader.getMark());
            }
            this.reader.forward();
        }
        else if (Constant.NULL_BL_T_LINEBR.has(llllllllllllllllIIIlIIlIIllIlIII)) {
            llllllllllllllllIIIlIIlIIllIIllI = "!";
            this.reader.forward();
        }
        else {
            int llllllllllllllllIIIlIIlIIllIllIl = 1;
            boolean llllllllllllllllIIIlIIlIIllIllII = false;
            while (Constant.NULL_BL_LINEBR.hasNo(llllllllllllllllIIIlIIlIIllIlIII)) {
                if (llllllllllllllllIIIlIIlIIllIlIII == 33) {
                    llllllllllllllllIIIlIIlIIllIllII = true;
                    break;
                }
                ++llllllllllllllllIIIlIIlIIllIllIl;
                llllllllllllllllIIIlIIlIIllIlIII = this.reader.peek(llllllllllllllllIIIlIIlIIllIllIl);
            }
            if (llllllllllllllllIIIlIIlIIllIllII) {
                llllllllllllllllIIIlIIlIIllIIlll = this.scanTagHandle("tag", llllllllllllllllIIIlIIlIIllIlIIl);
            }
            else {
                llllllllllllllllIIIlIIlIIllIIlll = "!";
                this.reader.forward();
            }
            llllllllllllllllIIIlIIlIIllIIllI = this.scanTagUri("tag", llllllllllllllllIIIlIIlIIllIlIIl);
        }
        llllllllllllllllIIIlIIlIIllIlIII = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(llllllllllllllllIIIlIIlIIllIlIII)) {
            final String llllllllllllllllIIIlIIlIIllIlIll = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIIllIlIII));
            throw new ScannerException("while scanning a tag", llllllllllllllllIIIlIIlIIllIlIIl, String.valueOf(new StringBuilder().append("expected ' ', but found '").append(llllllllllllllllIIIlIIlIIllIlIll).append("' (").append(llllllllllllllllIIIlIIlIIllIlIII).append(")")), this.reader.getMark());
        }
        final TagTuple llllllllllllllllIIIlIIlIIllIIlIl = new TagTuple(llllllllllllllllIIIlIIlIIllIIlll, llllllllllllllllIIIlIIlIIllIIllI);
        final Mark llllllllllllllllIIIlIIlIIllIIlII = this.reader.getMark();
        return new TagToken(llllllllllllllllIIIlIIlIIllIIlIl, llllllllllllllllIIIlIIlIIllIlIIl, llllllllllllllllIIIlIIlIIllIIlII);
    }
    
    @Override
    public Token peekToken() {
        while (this.needMoreTokens()) {
            this.fetchMoreTokens();
        }
        return this.tokens.get(0);
    }
    
    private Object[] scanBlockScalarIndentation() {
        final StringBuilder llllllllllllllllIIIlIIIllllllllI = new StringBuilder();
        int llllllllllllllllIIIlIIIlllllllIl = 0;
        Mark llllllllllllllllIIIlIIIlllllllII = this.reader.getMark();
        while (Constant.LINEBR.has(this.reader.peek(), " \r")) {
            if (this.reader.peek() != 32) {
                llllllllllllllllIIIlIIIllllllllI.append(this.scanLineBreak());
                llllllllllllllllIIIlIIIlllllllII = this.reader.getMark();
            }
            else {
                this.reader.forward();
                if (this.reader.getColumn() <= llllllllllllllllIIIlIIIlllllllIl) {
                    continue;
                }
                llllllllllllllllIIIlIIIlllllllIl = this.reader.getColumn();
            }
        }
        return new Object[] { String.valueOf(llllllllllllllllIIIlIIIllllllllI), llllllllllllllllIIIlIIIlllllllIl, llllllllllllllllIIIlIIIlllllllII };
    }
    
    private void fetchAnchor() {
        this.savePossibleSimpleKey();
        this.allowSimpleKey = false;
        final Token llllllllllllllllIIIlIIllIllIlIll = this.scanAnchor(true);
        this.tokens.add(llllllllllllllllIIIlIIllIllIlIll);
    }
    
    private boolean checkDirective() {
        return this.reader.getColumn() == 0;
    }
    
    private Token scanDirective() {
        final Mark llllllllllllllllIIIlIIllIIIlIIll = this.reader.getMark();
        this.reader.forward();
        final String llllllllllllllllIIIlIIllIIIlIIIl = this.scanDirectiveName(llllllllllllllllIIIlIIllIIIlIIll);
        List<?> llllllllllllllllIIIlIIllIIIlIIII = null;
        Mark llllllllllllllllIIIlIIllIIIlIIlI = null;
        if ("YAML".equals(llllllllllllllllIIIlIIllIIIlIIIl)) {
            llllllllllllllllIIIlIIllIIIlIIII = this.scanYamlDirectiveValue(llllllllllllllllIIIlIIllIIIlIIll);
            final Mark llllllllllllllllIIIlIIllIIIlIlll = this.reader.getMark();
        }
        else if ("TAG".equals(llllllllllllllllIIIlIIllIIIlIIIl)) {
            llllllllllllllllIIIlIIllIIIlIIII = this.scanTagDirectiveValue(llllllllllllllllIIIlIIllIIIlIIll);
            final Mark llllllllllllllllIIIlIIllIIIlIllI = this.reader.getMark();
        }
        else {
            llllllllllllllllIIIlIIllIIIlIIlI = this.reader.getMark();
            int llllllllllllllllIIIlIIllIIIlIlIl;
            for (llllllllllllllllIIIlIIllIIIlIlIl = 0; Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(llllllllllllllllIIIlIIllIIIlIlIl)); ++llllllllllllllllIIIlIIllIIIlIlIl) {}
            if (llllllllllllllllIIIlIIllIIIlIlIl > 0) {
                this.reader.forward(llllllllllllllllIIIlIIllIIIlIlIl);
            }
        }
        this.scanDirectiveIgnoredLine(llllllllllllllllIIIlIIllIIIlIIll);
        return new DirectiveToken<Object>(llllllllllllllllIIIlIIllIIIlIIIl, llllllllllllllllIIIlIIllIIIlIIII, llllllllllllllllIIIlIIllIIIlIIll, llllllllllllllllIIIlIIllIIIlIIlI);
    }
    
    private boolean checkKey() {
        return this.flowLevel != 0 || Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }
    
    private void removePossibleSimpleKey() {
        final SimpleKey llllllllllllllllIIIlIlIIIIIlIllI = this.possibleSimpleKeys.remove(this.flowLevel);
        if (llllllllllllllllIIIlIlIIIIIlIllI != null && llllllllllllllllIIIlIlIIIIIlIllI.isRequired()) {
            throw new ScannerException("while scanning a simple key", llllllllllllllllIIIlIlIIIIIlIllI.getMark(), "could not find expected ':'", this.reader.getMark());
        }
    }
    
    private void fetchStreamStart() {
        final Mark llllllllllllllllIIIlIlIIIIIIIIII = this.reader.getMark();
        final Token llllllllllllllllIIIlIIllllllllll = new StreamStartToken(llllllllllllllllIIIlIlIIIIIIIIII, llllllllllllllllIIIlIlIIIIIIIIII);
        this.tokens.add(llllllllllllllllIIIlIIllllllllll);
    }
    
    private void fetchDocumentEnd() {
        this.fetchDocumentIndicator(false);
    }
    
    private void fetchFlowMappingEnd() {
        this.fetchFlowCollectionEnd(true);
    }
    
    private String scanFlowScalarSpaces(final Mark llllllllllllllllIIIlIIIllIlIlIIl) {
        final StringBuilder llllllllllllllllIIIlIIIllIlIlIII = new StringBuilder();
        int llllllllllllllllIIIlIIIllIlIIlll;
        for (llllllllllllllllIIIlIIIllIlIIlll = 0; " \t".indexOf(this.reader.peek(llllllllllllllllIIIlIIIllIlIIlll)) != -1; ++llllllllllllllllIIIlIIIllIlIIlll) {}
        final String llllllllllllllllIIIlIIIllIlIIllI = this.reader.prefixForward(llllllllllllllllIIIlIIIllIlIIlll);
        final int llllllllllllllllIIIlIIIllIlIIlIl = this.reader.peek();
        if (llllllllllllllllIIIlIIIllIlIIlIl == 0) {
            throw new ScannerException("while scanning a quoted scalar", llllllllllllllllIIIlIIIllIlIlIIl, "found unexpected end of stream", this.reader.getMark());
        }
        final String llllllllllllllllIIIlIIIllIlIIlII = this.scanLineBreak();
        if (llllllllllllllllIIIlIIIllIlIIlII.length() != 0) {
            final String llllllllllllllllIIIlIIIllIlIlIll = this.scanFlowScalarBreaks(llllllllllllllllIIIlIIIllIlIlIIl);
            if (!"\n".equals(llllllllllllllllIIIlIIIllIlIIlII)) {
                llllllllllllllllIIIlIIIllIlIlIII.append(llllllllllllllllIIIlIIIllIlIIlII);
            }
            else if (llllllllllllllllIIIlIIIllIlIlIll.length() == 0) {
                llllllllllllllllIIIlIIIllIlIlIII.append(" ");
            }
            llllllllllllllllIIIlIIIllIlIlIII.append(llllllllllllllllIIIlIIIllIlIlIll);
        }
        else {
            llllllllllllllllIIIlIIIllIlIlIII.append(llllllllllllllllIIIlIIIllIlIIllI);
        }
        return String.valueOf(llllllllllllllllIIIlIIIllIlIlIII);
    }
    
    private void fetchMoreTokens() {
        this.scanToNextToken();
        this.stalePossibleSimpleKeys();
        this.unwindIndent(this.reader.getColumn());
        final int llllllllllllllllIIIlIlIIIIlllIlI = this.reader.peek();
        switch (llllllllllllllllIIIlIlIIIIlllIlI) {
            case 0: {
                this.fetchStreamEnd();
                return;
            }
            case 37: {
                if (this.checkDirective()) {
                    this.fetchDirective();
                    return;
                }
                break;
            }
            case 45: {
                if (this.checkDocumentStart()) {
                    this.fetchDocumentStart();
                    return;
                }
                if (this.checkBlockEntry()) {
                    this.fetchBlockEntry();
                    return;
                }
                break;
            }
            case 46: {
                if (this.checkDocumentEnd()) {
                    this.fetchDocumentEnd();
                    return;
                }
                break;
            }
            case 91: {
                this.fetchFlowSequenceStart();
                return;
            }
            case 123: {
                this.fetchFlowMappingStart();
                return;
            }
            case 93: {
                this.fetchFlowSequenceEnd();
                return;
            }
            case 125: {
                this.fetchFlowMappingEnd();
                return;
            }
            case 44: {
                this.fetchFlowEntry();
                return;
            }
            case 63: {
                if (this.checkKey()) {
                    this.fetchKey();
                    return;
                }
                break;
            }
            case 58: {
                if (this.checkValue()) {
                    this.fetchValue();
                    return;
                }
                break;
            }
            case 42: {
                this.fetchAlias();
                return;
            }
            case 38: {
                this.fetchAnchor();
                return;
            }
            case 33: {
                this.fetchTag();
                return;
            }
            case 124: {
                if (this.flowLevel == 0) {
                    this.fetchLiteral();
                    return;
                }
                break;
            }
            case 62: {
                if (this.flowLevel == 0) {
                    this.fetchFolded();
                    return;
                }
                break;
            }
            case 39: {
                this.fetchSingle();
                return;
            }
            case 34: {
                this.fetchDouble();
                return;
            }
        }
        if (this.checkPlain()) {
            this.fetchPlain();
            return;
        }
        String llllllllllllllllIIIlIlIIIIlllIIl = String.valueOf(Character.toChars(llllllllllllllllIIIlIlIIIIlllIlI));
        for (final Character llllllllllllllllIIIlIlIIIIllllIl : ScannerImpl.ESCAPE_REPLACEMENTS.keySet()) {
            final String llllllllllllllllIIIlIlIIIIlllllI = ScannerImpl.ESCAPE_REPLACEMENTS.get(llllllllllllllllIIIlIlIIIIllllIl);
            if (llllllllllllllllIIIlIlIIIIlllllI.equals(llllllllllllllllIIIlIlIIIIlllIIl)) {
                llllllllllllllllIIIlIlIIIIlllIIl = String.valueOf(new StringBuilder().append("\\").append(llllllllllllllllIIIlIlIIIIllllIl));
                break;
            }
        }
        if (llllllllllllllllIIIlIlIIIIlllIlI == 9) {
            llllllllllllllllIIIlIlIIIIlllIIl = String.valueOf(new StringBuilder().append(llllllllllllllllIIIlIlIIIIlllIIl).append("(TAB)"));
        }
        final String llllllllllllllllIIIlIlIIIIlllIII = String.format("found character '%s' that cannot start any token. (Do not use %s for indentation)", llllllllllllllllIIIlIlIIIIlllIIl, llllllllllllllllIIIlIlIIIIlllIIl);
        throw new ScannerException("while scanning for the next token", null, llllllllllllllllIIIlIlIIIIlllIII, this.reader.getMark());
    }
    
    private List<String> scanTagDirectiveValue(final Mark llllllllllllllllIIIlIIlIllIIIlll) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        final String llllllllllllllllIIIlIIlIllIIlIll = this.scanTagDirectiveHandle(llllllllllllllllIIIlIIlIllIIIlll);
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        final String llllllllllllllllIIIlIIlIllIIlIlI = this.scanTagDirectivePrefix(llllllllllllllllIIIlIIlIllIIIlll);
        final List<String> llllllllllllllllIIIlIIlIllIIlIIl = new ArrayList<String>(2);
        llllllllllllllllIIIlIIlIllIIlIIl.add(llllllllllllllllIIIlIIlIllIIlIll);
        llllllllllllllllIIIlIIlIllIIlIIl.add(llllllllllllllllIIIlIIlIllIIlIlI);
        return llllllllllllllllIIIlIIlIllIIlIIl;
    }
    
    private String scanTagDirectivePrefix(final Mark llllllllllllllllIIIlIIlIlIlIlIIl) {
        final String llllllllllllllllIIIlIIlIlIlIllII = this.scanTagUri("directive", llllllllllllllllIIIlIIlIlIlIlIIl);
        final int llllllllllllllllIIIlIIlIlIlIlIll = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(llllllllllllllllIIIlIIlIlIlIlIll)) {
            final String llllllllllllllllIIIlIIlIlIlIllll = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlIlIlIll));
            throw new ScannerException("while scanning a directive", llllllllllllllllIIIlIIlIlIlIlIIl, String.valueOf(new StringBuilder().append("expected ' ', but found ").append(llllllllllllllllIIIlIIlIlIlIllll).append("(").append(llllllllllllllllIIIlIIlIlIlIlIll).append(")")), this.reader.getMark());
        }
        return llllllllllllllllIIIlIIlIlIlIllII;
    }
    
    private void fetchFlowScalar(final char llllllllllllllllIIIlIIllIlIIlIIl) {
        this.savePossibleSimpleKey();
        this.allowSimpleKey = false;
        final Token llllllllllllllllIIIlIIllIlIIlIII = this.scanFlowScalar(llllllllllllllllIIIlIIllIlIIlIIl);
        this.tokens.add(llllllllllllllllIIIlIIllIlIIlIII);
    }
    
    private Token scanBlockScalar(final char llllllllllllllllIIIlIIlIIlIIIIIl) {
        boolean llllllllllllllllIIIlIIlIIlIIIIII = false;
        if (llllllllllllllllIIIlIIlIIlIIIIIl == '>') {
            final boolean llllllllllllllllIIIlIIlIIlIIllII = true;
        }
        else {
            llllllllllllllllIIIlIIlIIlIIIIII = false;
        }
        final StringBuilder llllllllllllllllIIIlIIlIIIllllll = new StringBuilder();
        final Mark llllllllllllllllIIIlIIlIIIlllllI = this.reader.getMark();
        this.reader.forward();
        final Chomping llllllllllllllllIIIlIIlIIIllllIl = this.scanBlockScalarIndicators(llllllllllllllllIIIlIIlIIIlllllI);
        final int llllllllllllllllIIIlIIlIIIllllII = llllllllllllllllIIIlIIlIIIllllIl.getIncrement();
        this.scanBlockScalarIgnoredLine(llllllllllllllllIIIlIIlIIIlllllI);
        int llllllllllllllllIIIlIIlIIIlllIll = this.indent + 1;
        if (llllllllllllllllIIIlIIlIIIlllIll < 1) {
            llllllllllllllllIIIlIIlIIIlllIll = 1;
        }
        int llllllllllllllllIIIlIIlIIIlllIIl = 0;
        String llllllllllllllllIIIlIIlIIIlllIlI = null;
        Mark llllllllllllllllIIIlIIlIIIlllIII = null;
        if (llllllllllllllllIIIlIIlIIIllllII == -1) {
            final Object[] llllllllllllllllIIIlIIlIIlIIlIll = this.scanBlockScalarIndentation();
            final String llllllllllllllllIIIlIIlIIlIIlIlI = (String)llllllllllllllllIIIlIIlIIlIIlIll[0];
            final int llllllllllllllllIIIlIIlIIlIIlIIl = (int)llllllllllllllllIIIlIIlIIlIIlIll[1];
            final Mark llllllllllllllllIIIlIIlIIlIIIlll = (Mark)llllllllllllllllIIIlIIlIIlIIlIll[2];
            final int llllllllllllllllIIIlIIlIIlIIlIII = Math.max(llllllllllllllllIIIlIIlIIIlllIll, llllllllllllllllIIIlIIlIIlIIlIIl);
        }
        else {
            llllllllllllllllIIIlIIlIIIlllIIl = llllllllllllllllIIIlIIlIIIlllIll + llllllllllllllllIIIlIIlIIIllllII - 1;
            final Object[] llllllllllllllllIIIlIIlIIlIIIllI = this.scanBlockScalarBreaks(llllllllllllllllIIIlIIlIIIlllIIl);
            llllllllllllllllIIIlIIlIIIlllIlI = (String)llllllllllllllllIIIlIIlIIlIIIllI[0];
            llllllllllllllllIIIlIIlIIIlllIII = (Mark)llllllllllllllllIIIlIIlIIlIIIllI[1];
        }
        String llllllllllllllllIIIlIIlIIIllIlll = "";
        while (this.reader.getColumn() == llllllllllllllllIIIlIIlIIIlllIIl && this.reader.peek() != 0) {
            llllllllllllllllIIIlIIlIIIllllll.append(llllllllllllllllIIIlIIlIIIlllIlI);
            final boolean llllllllllllllllIIIlIIlIIlIIIlIl = " \t".indexOf(this.reader.peek()) == -1;
            int llllllllllllllllIIIlIIlIIlIIIlII;
            for (llllllllllllllllIIIlIIlIIlIIIlII = 0; Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(llllllllllllllllIIIlIIlIIlIIIlII)); ++llllllllllllllllIIIlIIlIIlIIIlII) {}
            llllllllllllllllIIIlIIlIIIllllll.append(this.reader.prefixForward(llllllllllllllllIIIlIIlIIlIIIlII));
            llllllllllllllllIIIlIIlIIIllIlll = this.scanLineBreak();
            final Object[] llllllllllllllllIIIlIIlIIlIIIIll = this.scanBlockScalarBreaks(llllllllllllllllIIIlIIlIIIlllIIl);
            llllllllllllllllIIIlIIlIIIlllIlI = (String)llllllllllllllllIIIlIIlIIlIIIIll[0];
            llllllllllllllllIIIlIIlIIIlllIII = (Mark)llllllllllllllllIIIlIIlIIlIIIIll[1];
            if (this.reader.getColumn() != llllllllllllllllIIIlIIlIIIlllIIl || this.reader.peek() == 0) {
                break;
            }
            if (llllllllllllllllIIIlIIlIIlIIIIII && "\n".equals(llllllllllllllllIIIlIIlIIIllIlll) && llllllllllllllllIIIlIIlIIlIIIlIl && " \t".indexOf(this.reader.peek()) == -1) {
                if (llllllllllllllllIIIlIIlIIIlllIlI.length() != 0) {
                    continue;
                }
                llllllllllllllllIIIlIIlIIIllllll.append(" ");
            }
            else {
                llllllllllllllllIIIlIIlIIIllllll.append(llllllllllllllllIIIlIIlIIIllIlll);
            }
        }
        if (llllllllllllllllIIIlIIlIIIllllIl.chompTailIsNotFalse()) {
            llllllllllllllllIIIlIIlIIIllllll.append(llllllllllllllllIIIlIIlIIIllIlll);
        }
        if (llllllllllllllllIIIlIIlIIIllllIl.chompTailIsTrue()) {
            llllllllllllllllIIIlIIlIIIllllll.append(llllllllllllllllIIIlIIlIIIlllIlI);
        }
        return new ScalarToken(String.valueOf(llllllllllllllllIIIlIIlIIIllllll), false, llllllllllllllllIIIlIIlIIIlllllI, llllllllllllllllIIIlIIlIIIlllIII, DumperOptions.ScalarStyle.createStyle(llllllllllllllllIIIlIIlIIlIIIIIl));
    }
    
    private void fetchKey() {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping keys are not allowed here", this.reader.getMark());
            }
            if (this.addIndent(this.reader.getColumn())) {
                final Mark llllllllllllllllIIIlIIlllIIIllIl = this.reader.getMark();
                this.tokens.add(new BlockMappingStartToken(llllllllllllllllIIIlIIlllIIIllIl, llllllllllllllllIIIlIIlllIIIllIl));
            }
        }
        this.allowSimpleKey = (this.flowLevel == 0);
        this.removePossibleSimpleKey();
        final Mark llllllllllllllllIIIlIIlllIIIlIll = this.reader.getMark();
        this.reader.forward();
        final Mark llllllllllllllllIIIlIIlllIIIlIlI = this.reader.getMark();
        final Token llllllllllllllllIIIlIIlllIIIlIIl = new KeyToken(llllllllllllllllIIIlIIlllIIIlIll, llllllllllllllllIIIlIIlllIIIlIlI);
        this.tokens.add(llllllllllllllllIIIlIIlllIIIlIIl);
    }
    
    static {
        NOT_HEXA = Pattern.compile("[^0-9A-Fa-f]");
        ESCAPE_REPLACEMENTS = new HashMap<Character, String>();
        ESCAPE_CODES = new HashMap<Character, Integer>();
        ScannerImpl.ESCAPE_REPLACEMENTS.put('0', "\u0000");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('a', "\u0007");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('b', "\b");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('t', "\t");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('n', "\n");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('v', "\u000b");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('f', "\f");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('r', "\r");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('e', "\u001b");
        ScannerImpl.ESCAPE_REPLACEMENTS.put(' ', " ");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('\"', "\"");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('\\', "\\");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('N', "\u0085");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('_', " ");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('L', "\u2028");
        ScannerImpl.ESCAPE_REPLACEMENTS.put('P', "\u2029");
        ScannerImpl.ESCAPE_CODES.put('x', 2);
        ScannerImpl.ESCAPE_CODES.put('u', 4);
        ScannerImpl.ESCAPE_CODES.put('U', 8);
    }
    
    private Integer scanYamlDirectiveNumber(final Mark llllllllllllllllIIIlIIlIllIlIllI) {
        final int llllllllllllllllIIIlIIlIllIllIlI = this.reader.peek();
        if (!Character.isDigit(llllllllllllllllIIIlIIlIllIllIlI)) {
            final String llllllllllllllllIIIlIIlIllIlllIl = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIllIllIlI));
            throw new ScannerException("while scanning a directive", llllllllllllllllIIIlIIlIllIlIllI, String.valueOf(new StringBuilder().append("expected a digit, but found ").append(llllllllllllllllIIIlIIlIllIlllIl).append("(").append(llllllllllllllllIIIlIIlIllIllIlI).append(")")), this.reader.getMark());
        }
        int llllllllllllllllIIIlIIlIllIllIIl;
        for (llllllllllllllllIIIlIIlIllIllIIl = 0; Character.isDigit(this.reader.peek(llllllllllllllllIIIlIIlIllIllIIl)); ++llllllllllllllllIIIlIIlIllIllIIl) {}
        final Integer llllllllllllllllIIIlIIlIllIllIII = Integer.parseInt(this.reader.prefixForward(llllllllllllllllIIIlIIlIllIllIIl));
        return llllllllllllllllIIIlIIlIllIllIII;
    }
    
    private void savePossibleSimpleKey() {
        final boolean llllllllllllllllIIIlIlIIIIIllllI = this.flowLevel == 0 && this.indent == this.reader.getColumn();
        if (!this.allowSimpleKey && llllllllllllllllIIIlIlIIIIIllllI) {
            throw new YAMLException("A simple key is required only if it is the first token in the current line");
        }
        if (this.allowSimpleKey) {
            this.removePossibleSimpleKey();
            final int llllllllllllllllIIIlIlIIIIlIIIIl = this.tokensTaken + this.tokens.size();
            final SimpleKey llllllllllllllllIIIlIlIIIIlIIIII = new SimpleKey(llllllllllllllllIIIlIlIIIIlIIIIl, llllllllllllllllIIIlIlIIIIIllllI, this.reader.getIndex(), this.reader.getLine(), this.reader.getColumn(), this.reader.getMark());
            this.possibleSimpleKeys.put(this.flowLevel, llllllllllllllllIIIlIlIIIIlIIIII);
        }
    }
    
    private void scanDirectiveIgnoredLine(final Mark llllllllllllllllIIIlIIlIlIIllIlI) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        if (this.reader.peek() == 35) {
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek())) {
                this.reader.forward();
            }
        }
        final int llllllllllllllllIIIlIIlIlIIlllIl = this.reader.peek();
        final String llllllllllllllllIIIlIIlIlIIlllII = this.scanLineBreak();
        if (llllllllllllllllIIIlIIlIlIIlllII.length() == 0 && llllllllllllllllIIIlIIlIlIIlllIl != 0) {
            final String llllllllllllllllIIIlIIlIlIlIIIII = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlIIlllIl));
            throw new ScannerException("while scanning a directive", llllllllllllllllIIIlIIlIlIIllIlI, String.valueOf(new StringBuilder().append("expected a comment or a line break, but found ").append(llllllllllllllllIIIlIIlIlIlIIIII).append("(").append(llllllllllllllllIIIlIIlIlIIlllIl).append(")")), this.reader.getMark());
        }
    }
    
    @Override
    public boolean checkToken(final Token.ID... llllllllllllllllIIIlIlIIIlIlIIlI) {
        while (this.needMoreTokens()) {
            this.fetchMoreTokens();
        }
        if (!this.tokens.isEmpty()) {
            if (llllllllllllllllIIIlIlIIIlIlIIlI.length == 0) {
                return true;
            }
            final Token.ID llllllllllllllllIIIlIlIIIlIlIlII = this.tokens.get(0).getTokenId();
            for (int llllllllllllllllIIIlIlIIIlIlIlIl = 0; llllllllllllllllIIIlIlIIIlIlIlIl < llllllllllllllllIIIlIlIIIlIlIIlI.length; ++llllllllllllllllIIIlIlIIIlIlIlIl) {
                if (llllllllllllllllIIIlIlIIIlIlIlII == llllllllllllllllIIIlIlIIIlIlIIlI[llllllllllllllllIIIlIlIIIlIlIlIl]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private String scanLineBreak() {
        final int llllllllllllllllIIIlIIIlIIIlIIII = this.reader.peek();
        if (llllllllllllllllIIIlIIIlIIIlIIII == 13 || llllllllllllllllIIIlIIIlIIIlIIII == 10 || llllllllllllllllIIIlIIIlIIIlIIII == 133) {
            if (llllllllllllllllIIIlIIIlIIIlIIII == 13 && 10 == this.reader.peek(1)) {
                this.reader.forward(2);
            }
            else {
                this.reader.forward();
            }
            return "\n";
        }
        if (llllllllllllllllIIIlIIIlIIIlIIII == 8232 || llllllllllllllllIIIlIIIlIIIlIIII == 8233) {
            this.reader.forward();
            return String.valueOf(Character.toChars(llllllllllllllllIIIlIIIlIIIlIIII));
        }
        return "";
    }
    
    private void fetchDouble() {
        this.fetchFlowScalar('\"');
    }
    
    private String scanFlowScalarBreaks(final Mark llllllllllllllllIIIlIIIllIIlIIll) {
        final StringBuilder llllllllllllllllIIIlIIIllIIlIIlI = new StringBuilder();
        while (true) {
            final String llllllllllllllllIIIlIIIllIIlIllI = this.reader.prefix(3);
            if (("---".equals(llllllllllllllllIIIlIIIllIIlIllI) || "...".equals(llllllllllllllllIIIlIIIllIIlIllI)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
                throw new ScannerException("while scanning a quoted scalar", llllllllllllllllIIIlIIIllIIlIIll, "found unexpected document separator", this.reader.getMark());
            }
            while (" \t".indexOf(this.reader.peek()) != -1) {
                this.reader.forward();
            }
            final String llllllllllllllllIIIlIIIllIIlIlIl = this.scanLineBreak();
            if (llllllllllllllllIIIlIIIllIIlIlIl.length() == 0) {
                return String.valueOf(llllllllllllllllIIIlIIIllIIlIIlI);
            }
            llllllllllllllllIIIlIIIllIIlIIlI.append(llllllllllllllllIIIlIIIllIIlIlIl);
        }
    }
    
    private Chomping scanBlockScalarIndicators(final Mark llllllllllllllllIIIlIIlIIIIlIlll) {
        Boolean llllllllllllllllIIIlIIlIIIIllIll = null;
        int llllllllllllllllIIIlIIlIIIIllIlI = -1;
        int llllllllllllllllIIIlIIlIIIIllIIl = this.reader.peek();
        if (llllllllllllllllIIIlIIlIIIIllIIl == 45 || llllllllllllllllIIIlIIlIIIIllIIl == 43) {
            if (llllllllllllllllIIIlIIlIIIIllIIl == 43) {
                llllllllllllllllIIIlIIlIIIIllIll = Boolean.TRUE;
            }
            else {
                llllllllllllllllIIIlIIlIIIIllIll = Boolean.FALSE;
            }
            this.reader.forward();
            llllllllllllllllIIIlIIlIIIIllIIl = this.reader.peek();
            if (Character.isDigit(llllllllllllllllIIIlIIlIIIIllIIl)) {
                final String llllllllllllllllIIIlIIlIIIlIIIII = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIIIIllIIl));
                llllllllllllllllIIIlIIlIIIIllIlI = Integer.parseInt(llllllllllllllllIIIlIIlIIIlIIIII);
                if (llllllllllllllllIIIlIIlIIIIllIlI == 0) {
                    throw new ScannerException("while scanning a block scalar", llllllllllllllllIIIlIIlIIIIlIlll, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
                }
                this.reader.forward();
            }
        }
        else if (Character.isDigit(llllllllllllllllIIIlIIlIIIIllIIl)) {
            final String llllllllllllllllIIIlIIlIIIIlllll = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIIIIllIIl));
            llllllllllllllllIIIlIIlIIIIllIlI = Integer.parseInt(llllllllllllllllIIIlIIlIIIIlllll);
            if (llllllllllllllllIIIlIIlIIIIllIlI == 0) {
                throw new ScannerException("while scanning a block scalar", llllllllllllllllIIIlIIlIIIIlIlll, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
            }
            this.reader.forward();
            llllllllllllllllIIIlIIlIIIIllIIl = this.reader.peek();
            if (llllllllllllllllIIIlIIlIIIIllIIl == 45 || llllllllllllllllIIIlIIlIIIIllIIl == 43) {
                if (llllllllllllllllIIIlIIlIIIIllIIl == 43) {
                    llllllllllllllllIIIlIIlIIIIllIll = Boolean.TRUE;
                }
                else {
                    llllllllllllllllIIIlIIlIIIIllIll = Boolean.FALSE;
                }
                this.reader.forward();
            }
        }
        llllllllllllllllIIIlIIlIIIIllIIl = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(llllllllllllllllIIIlIIlIIIIllIIl)) {
            final String llllllllllllllllIIIlIIlIIIIllllI = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIIIIllIIl));
            throw new ScannerException("while scanning a block scalar", llllllllllllllllIIIlIIlIIIIlIlll, String.valueOf(new StringBuilder().append("expected chomping or indentation indicators, but found ").append(llllllllllllllllIIIlIIlIIIIllllI).append("(").append(llllllllllllllllIIIlIIlIIIIllIIl).append(")")), this.reader.getMark());
        }
        return new Chomping(llllllllllllllllIIIlIIlIIIIllIll, llllllllllllllllIIIlIIlIIIIllIlI);
    }
    
    private boolean checkValue() {
        return this.flowLevel != 0 || Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }
    
    private void fetchDocumentStart() {
        this.fetchDocumentIndicator(true);
    }
    
    private List<Integer> scanYamlDirectiveValue(final Mark llllllllllllllllIIIlIIlIlllIIlll) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        final Integer llllllllllllllllIIIlIIlIlllIllII = this.scanYamlDirectiveNumber(llllllllllllllllIIIlIIlIlllIIlll);
        int llllllllllllllllIIIlIIlIlllIlIll = this.reader.peek();
        if (llllllllllllllllIIIlIIlIlllIlIll != 46) {
            final String llllllllllllllllIIIlIIlIllllIIII = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlllIlIll));
            throw new ScannerException("while scanning a directive", llllllllllllllllIIIlIIlIlllIIlll, String.valueOf(new StringBuilder().append("expected a digit or '.', but found ").append(llllllllllllllllIIIlIIlIllllIIII).append("(").append(llllllllllllllllIIIlIIlIlllIlIll).append(")")), this.reader.getMark());
        }
        this.reader.forward();
        final Integer llllllllllllllllIIIlIIlIlllIlIlI = this.scanYamlDirectiveNumber(llllllllllllllllIIIlIIlIlllIIlll);
        llllllllllllllllIIIlIIlIlllIlIll = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(llllllllllllllllIIIlIIlIlllIlIll)) {
            final String llllllllllllllllIIIlIIlIlllIllll = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlllIlIll));
            throw new ScannerException("while scanning a directive", llllllllllllllllIIIlIIlIlllIIlll, String.valueOf(new StringBuilder().append("expected a digit or ' ', but found ").append(llllllllllllllllIIIlIIlIlllIllll).append("(").append(llllllllllllllllIIIlIIlIlllIlIll).append(")")), this.reader.getMark());
        }
        final List<Integer> llllllllllllllllIIIlIIlIlllIlIIl = new ArrayList<Integer>(2);
        llllllllllllllllIIIlIIlIlllIlIIl.add(llllllllllllllllIIIlIIlIlllIllII);
        llllllllllllllllIIIlIIlIlllIlIIl.add(llllllllllllllllIIIlIIlIlllIlIlI);
        return llllllllllllllllIIIlIIlIlllIlIIl;
    }
    
    private String scanTagHandle(final String llllllllllllllllIIIlIIIlIlIlIIII, final Mark llllllllllllllllIIIlIIIlIlIlIlIl) {
        int llllllllllllllllIIIlIIIlIlIlIlII = this.reader.peek();
        if (llllllllllllllllIIIlIIIlIlIlIlII != 33) {
            final String llllllllllllllllIIIlIIIlIlIllIIl = String.valueOf(Character.toChars(llllllllllllllllIIIlIIIlIlIlIlII));
            throw new ScannerException(String.valueOf(new StringBuilder().append("while scanning a ").append(llllllllllllllllIIIlIIIlIlIlIIII)), llllllllllllllllIIIlIIIlIlIlIlIl, String.valueOf(new StringBuilder().append("expected '!', but found ").append(llllllllllllllllIIIlIIIlIlIllIIl).append("(").append(llllllllllllllllIIIlIIIlIlIlIlII).append(")")), this.reader.getMark());
        }
        int llllllllllllllllIIIlIIIlIlIlIIll = 1;
        llllllllllllllllIIIlIIIlIlIlIlII = this.reader.peek(llllllllllllllllIIIlIIIlIlIlIIll);
        if (llllllllllllllllIIIlIIIlIlIlIlII != 32) {
            while (Constant.ALPHA.has(llllllllllllllllIIIlIIIlIlIlIlII)) {
                ++llllllllllllllllIIIlIIIlIlIlIIll;
                llllllllllllllllIIIlIIIlIlIlIlII = this.reader.peek(llllllllllllllllIIIlIIIlIlIlIIll);
            }
            if (llllllllllllllllIIIlIIIlIlIlIlII != 33) {
                this.reader.forward(llllllllllllllllIIIlIIIlIlIlIIll);
                final String llllllllllllllllIIIlIIIlIlIllIII = String.valueOf(Character.toChars(llllllllllllllllIIIlIIIlIlIlIlII));
                throw new ScannerException(String.valueOf(new StringBuilder().append("while scanning a ").append(llllllllllllllllIIIlIIIlIlIlIIII)), llllllllllllllllIIIlIIIlIlIlIlIl, String.valueOf(new StringBuilder().append("expected '!', but found ").append(llllllllllllllllIIIlIIIlIlIllIII).append("(").append(llllllllllllllllIIIlIIIlIlIlIlII).append(")")), this.reader.getMark());
            }
            ++llllllllllllllllIIIlIIIlIlIlIIll;
        }
        final String llllllllllllllllIIIlIIIlIlIlIIlI = this.reader.prefixForward(llllllllllllllllIIIlIIIlIlIlIIll);
        return llllllllllllllllIIIlIIIlIlIlIIlI;
    }
    
    private void fetchPlain() {
        this.savePossibleSimpleKey();
        this.allowSimpleKey = false;
        final Token llllllllllllllllIIIlIIllIlIIIIIl = this.scanPlain();
        this.tokens.add(llllllllllllllllIIIlIIllIlIIIIIl);
    }
    
    private Token scanAnchor(final boolean llllllllllllllllIIIlIIlIlIIIlIII) {
        final Mark llllllllllllllllIIIlIIlIlIIIIlll = this.reader.getMark();
        final int llllllllllllllllIIIlIIlIlIIIIllI = this.reader.peek();
        final String llllllllllllllllIIIlIIlIlIIIIlIl = (llllllllllllllllIIIlIIlIlIIIIllI == 42) ? "alias" : "anchor";
        this.reader.forward();
        int llllllllllllllllIIIlIIlIlIIIIlII;
        int llllllllllllllllIIIlIIlIlIIIIIll;
        for (llllllllllllllllIIIlIIlIlIIIIlII = 0, llllllllllllllllIIIlIIlIlIIIIIll = this.reader.peek(llllllllllllllllIIIlIIlIlIIIIlII); Constant.NULL_BL_T_LINEBR.hasNo(llllllllllllllllIIIlIIlIlIIIIIll, ":,[]{}"); llllllllllllllllIIIlIIlIlIIIIIll = this.reader.peek(llllllllllllllllIIIlIIlIlIIIIlII)) {
            ++llllllllllllllllIIIlIIlIlIIIIlII;
        }
        if (llllllllllllllllIIIlIIlIlIIIIlII == 0) {
            final String llllllllllllllllIIIlIIlIlIIIllII = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlIIIIIll));
            throw new ScannerException(String.valueOf(new StringBuilder().append("while scanning an ").append(llllllllllllllllIIIlIIlIlIIIIlIl)), llllllllllllllllIIIlIIlIlIIIIlll, String.valueOf(new StringBuilder().append("unexpected character found ").append(llllllllllllllllIIIlIIlIlIIIllII).append("(").append(llllllllllllllllIIIlIIlIlIIIIIll).append(")")), this.reader.getMark());
        }
        final String llllllllllllllllIIIlIIlIlIIIIIlI = this.reader.prefixForward(llllllllllllllllIIIlIIlIlIIIIlII);
        llllllllllllllllIIIlIIlIlIIIIIll = this.reader.peek();
        if (Constant.NULL_BL_T_LINEBR.hasNo(llllllllllllllllIIIlIIlIlIIIIIll, "?:,]}%@`")) {
            final String llllllllllllllllIIIlIIlIlIIIlIll = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlIIIIIll));
            throw new ScannerException(String.valueOf(new StringBuilder().append("while scanning an ").append(llllllllllllllllIIIlIIlIlIIIIlIl)), llllllllllllllllIIIlIIlIlIIIIlll, String.valueOf(new StringBuilder().append("unexpected character found ").append(llllllllllllllllIIIlIIlIlIIIlIll).append("(").append(llllllllllllllllIIIlIIlIlIIIIIll).append(")")), this.reader.getMark());
        }
        final Mark llllllllllllllllIIIlIIlIlIIIIIIl = this.reader.getMark();
        Token llllllllllllllllIIIlIIlIlIIIIIII = null;
        if (llllllllllllllllIIIlIIlIlIIIlIII) {
            final Token llllllllllllllllIIIlIIlIlIIIlIlI = new AnchorToken(llllllllllllllllIIIlIIlIlIIIIIlI, llllllllllllllllIIIlIIlIlIIIIlll, llllllllllllllllIIIlIIlIlIIIIIIl);
        }
        else {
            llllllllllllllllIIIlIIlIlIIIIIII = new AliasToken(llllllllllllllllIIIlIIlIlIIIIIlI, llllllllllllllllIIIlIIlIlIIIIlll, llllllllllllllllIIIlIIlIlIIIIIIl);
        }
        return llllllllllllllllIIIlIIlIlIIIIIII;
    }
    
    private void fetchValue() {
        final SimpleKey llllllllllllllllIIIlIIllIlllllIl = this.possibleSimpleKeys.remove(this.flowLevel);
        if (llllllllllllllllIIIlIIllIlllllIl != null) {
            this.tokens.add(llllllllllllllllIIIlIIllIlllllIl.getTokenNumber() - this.tokensTaken, new KeyToken(llllllllllllllllIIIlIIllIlllllIl.getMark(), llllllllllllllllIIIlIIllIlllllIl.getMark()));
            if (this.flowLevel == 0 && this.addIndent(llllllllllllllllIIIlIIllIlllllIl.getColumn())) {
                this.tokens.add(llllllllllllllllIIIlIIllIlllllIl.getTokenNumber() - this.tokensTaken, new BlockMappingStartToken(llllllllllllllllIIIlIIllIlllllIl.getMark(), llllllllllllllllIIIlIIllIlllllIl.getMark()));
            }
            this.allowSimpleKey = false;
        }
        else {
            if (this.flowLevel == 0 && !this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping values are not allowed here", this.reader.getMark());
            }
            if (this.flowLevel == 0 && this.addIndent(this.reader.getColumn())) {
                final Mark llllllllllllllllIIIlIIllIlllllll = this.reader.getMark();
                this.tokens.add(new BlockMappingStartToken(llllllllllllllllIIIlIIllIlllllll, llllllllllllllllIIIlIIllIlllllll));
            }
            this.allowSimpleKey = (this.flowLevel == 0);
            this.removePossibleSimpleKey();
        }
        final Mark llllllllllllllllIIIlIIllIlllllII = this.reader.getMark();
        this.reader.forward();
        final Mark llllllllllllllllIIIlIIllIllllIll = this.reader.getMark();
        final Token llllllllllllllllIIIlIIllIllllIlI = new ValueToken(llllllllllllllllIIIlIIllIlllllII, llllllllllllllllIIIlIIllIllllIll);
        this.tokens.add(llllllllllllllllIIIlIIllIllllIlI);
    }
    
    private Object[] scanBlockScalarBreaks(final int llllllllllllllllIIIlIIIlllllIIII) {
        final StringBuilder llllllllllllllllIIIlIIIllllIllll = new StringBuilder();
        Mark llllllllllllllllIIIlIIIllllIlllI = this.reader.getMark();
        for (int llllllllllllllllIIIlIIIllllIllIl = this.reader.getColumn(); llllllllllllllllIIIlIIIllllIllIl < llllllllllllllllIIIlIIIlllllIIII && this.reader.peek() == 32; ++llllllllllllllllIIIlIIIllllIllIl) {
            this.reader.forward();
        }
        String llllllllllllllllIIIlIIIllllIllII = null;
        while ((llllllllllllllllIIIlIIIllllIllII = this.scanLineBreak()).length() != 0) {
            llllllllllllllllIIIlIIIllllIllll.append(llllllllllllllllIIIlIIIllllIllII);
            llllllllllllllllIIIlIIIllllIlllI = this.reader.getMark();
            for (int llllllllllllllllIIIlIIIllllIllIl = this.reader.getColumn(); llllllllllllllllIIIlIIIllllIllIl < llllllllllllllllIIIlIIIlllllIIII && this.reader.peek() == 32; ++llllllllllllllllIIIlIIIllllIllIl) {
                this.reader.forward();
            }
        }
        return new Object[] { String.valueOf(llllllllllllllllIIIlIIIllllIllll), llllllllllllllllIIIlIIIllllIlllI };
    }
    
    private void fetchFlowEntry() {
        this.allowSimpleKey = true;
        this.removePossibleSimpleKey();
        final Mark llllllllllllllllIIIlIIlllIlIIlIl = this.reader.getMark();
        this.reader.forward();
        final Mark llllllllllllllllIIIlIIlllIlIIlII = this.reader.getMark();
        final Token llllllllllllllllIIIlIIlllIlIIIll = new FlowEntryToken(llllllllllllllllIIIlIIlllIlIIlIl, llllllllllllllllIIIlIIlllIlIIlII);
        this.tokens.add(llllllllllllllllIIIlIIlllIlIIIll);
    }
    
    private void fetchAlias() {
        this.savePossibleSimpleKey();
        this.allowSimpleKey = false;
        final Token llllllllllllllllIIIlIIllIlllIIIl = this.scanAnchor(false);
        this.tokens.add(llllllllllllllllIIIlIIllIlllIIIl);
    }
    
    private String scanUriEscapes(final String llllllllllllllllIIIlIIIlIIIlllIl, final Mark llllllllllllllllIIIlIIIlIIlIIIlI) {
        int llllllllllllllllIIIlIIIlIIlIIIIl;
        for (llllllllllllllllIIIlIIIlIIlIIIIl = 1; this.reader.peek(llllllllllllllllIIIlIIIlIIlIIIIl * 3) == 37; ++llllllllllllllllIIIlIIIlIIlIIIIl) {}
        final Mark llllllllllllllllIIIlIIIlIIlIIIII = this.reader.getMark();
        final ByteBuffer llllllllllllllllIIIlIIIlIIIlllll = ByteBuffer.allocate(llllllllllllllllIIIlIIIlIIlIIIIl);
        while (this.reader.peek() == 37) {
            this.reader.forward();
            try {
                final byte llllllllllllllllIIIlIIIlIIlIlIll = (byte)Integer.parseInt(this.reader.prefix(2), 16);
                llllllllllllllllIIIlIIIlIIIlllll.put(llllllllllllllllIIIlIIIlIIlIlIll);
            }
            catch (NumberFormatException llllllllllllllllIIIlIIIlIIlIIllI) {
                final int llllllllllllllllIIIlIIIlIIlIlIlI = this.reader.peek();
                final String llllllllllllllllIIIlIIIlIIlIlIIl = String.valueOf(Character.toChars(llllllllllllllllIIIlIIIlIIlIlIlI));
                final int llllllllllllllllIIIlIIIlIIlIlIII = this.reader.peek(1);
                final String llllllllllllllllIIIlIIIlIIlIIlll = String.valueOf(Character.toChars(llllllllllllllllIIIlIIIlIIlIlIII));
                throw new ScannerException(String.valueOf(new StringBuilder().append("while scanning a ").append(llllllllllllllllIIIlIIIlIIIlllIl)), llllllllllllllllIIIlIIIlIIlIIIlI, String.valueOf(new StringBuilder().append("expected URI escape sequence of 2 hexadecimal numbers, but found ").append(llllllllllllllllIIIlIIIlIIlIlIIl).append("(").append(llllllllllllllllIIIlIIIlIIlIlIlI).append(") and ").append(llllllllllllllllIIIlIIIlIIlIIlll).append("(").append(llllllllllllllllIIIlIIIlIIlIlIII).append(")")), this.reader.getMark());
            }
            this.reader.forward(2);
        }
        llllllllllllllllIIIlIIIlIIIlllll.flip();
        try {
            return UriEncoder.decode(llllllllllllllllIIIlIIIlIIIlllll);
        }
        catch (CharacterCodingException llllllllllllllllIIIlIIIlIIlIIlIl) {
            throw new ScannerException(String.valueOf(new StringBuilder().append("while scanning a ").append(llllllllllllllllIIIlIIIlIIIlllIl)), llllllllllllllllIIIlIIIlIIlIIIlI, String.valueOf(new StringBuilder().append("expected URI in UTF-8: ").append(llllllllllllllllIIIlIIIlIIlIIlIl.getMessage())), llllllllllllllllIIIlIIIlIIlIIIII);
        }
    }
    
    private String scanPlainSpaces() {
        int llllllllllllllllIIIlIIIlIllIlIIl;
        for (llllllllllllllllIIIlIIIlIllIlIIl = 0; this.reader.peek(llllllllllllllllIIIlIIIlIllIlIIl) == 32 || this.reader.peek(llllllllllllllllIIIlIIIlIllIlIIl) == 9; ++llllllllllllllllIIIlIIIlIllIlIIl) {}
        final String llllllllllllllllIIIlIIIlIllIlIII = this.reader.prefixForward(llllllllllllllllIIIlIIIlIllIlIIl);
        final String llllllllllllllllIIIlIIIlIllIIlll = this.scanLineBreak();
        if (llllllllllllllllIIIlIIIlIllIIlll.length() == 0) {
            return llllllllllllllllIIIlIIIlIllIlIII;
        }
        this.allowSimpleKey = true;
        String llllllllllllllllIIIlIIIlIllIllII = this.reader.prefix(3);
        if ("---".equals(llllllllllllllllIIIlIIIlIllIllII) || ("...".equals(llllllllllllllllIIIlIIIlIllIllII) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3)))) {
            return "";
        }
        final StringBuilder llllllllllllllllIIIlIIIlIllIlIll = new StringBuilder();
        while (true) {
            if (this.reader.peek() == 32) {
                this.reader.forward();
            }
            else {
                final String llllllllllllllllIIIlIIIlIllIllIl = this.scanLineBreak();
                if (llllllllllllllllIIIlIIIlIllIllIl.length() != 0) {
                    llllllllllllllllIIIlIIIlIllIlIll.append(llllllllllllllllIIIlIIIlIllIllIl);
                    llllllllllllllllIIIlIIIlIllIllII = this.reader.prefix(3);
                    if ("---".equals(llllllllllllllllIIIlIIIlIllIllII) || ("...".equals(llllllllllllllllIIIlIIIlIllIllII) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3)))) {
                        return "";
                    }
                    continue;
                }
                else {
                    if (!"\n".equals(llllllllllllllllIIIlIIIlIllIIlll)) {
                        return String.valueOf(new StringBuilder().append(llllllllllllllllIIIlIIIlIllIIlll).append((Object)llllllllllllllllIIIlIIIlIllIlIll));
                    }
                    if (llllllllllllllllIIIlIIIlIllIlIll.length() == 0) {
                        return " ";
                    }
                    return String.valueOf(llllllllllllllllIIIlIIIlIllIlIll);
                }
            }
        }
    }
    
    private String scanDirectiveName(final Mark llllllllllllllllIIIlIIlIlllllIll) {
        int llllllllllllllllIIIlIIlIllllllll;
        int llllllllllllllllIIIlIIlIlllllllI;
        for (llllllllllllllllIIIlIIlIllllllll = 0, llllllllllllllllIIIlIIlIlllllllI = this.reader.peek(llllllllllllllllIIIlIIlIllllllll); Constant.ALPHA.has(llllllllllllllllIIIlIIlIlllllllI); llllllllllllllllIIIlIIlIlllllllI = this.reader.peek(llllllllllllllllIIIlIIlIllllllll)) {
            ++llllllllllllllllIIIlIIlIllllllll;
        }
        if (llllllllllllllllIIIlIIlIllllllll == 0) {
            final String llllllllllllllllIIIlIIllIIIIIIll = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlllllllI));
            throw new ScannerException("while scanning a directive", llllllllllllllllIIIlIIlIlllllIll, String.valueOf(new StringBuilder().append("expected alphabetic or numeric character, but found ").append(llllllllllllllllIIIlIIllIIIIIIll).append("(").append(llllllllllllllllIIIlIIlIlllllllI).append(")")), this.reader.getMark());
        }
        final String llllllllllllllllIIIlIIlIllllllIl = this.reader.prefixForward(llllllllllllllllIIIlIIlIllllllll);
        llllllllllllllllIIIlIIlIlllllllI = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(llllllllllllllllIIIlIIlIlllllllI)) {
            final String llllllllllllllllIIIlIIllIIIIIIlI = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlllllllI));
            throw new ScannerException("while scanning a directive", llllllllllllllllIIIlIIlIlllllIll, String.valueOf(new StringBuilder().append("expected alphabetic or numeric character, but found ").append(llllllllllllllllIIIlIIllIIIIIIlI).append("(").append(llllllllllllllllIIIlIIlIlllllllI).append(")")), this.reader.getMark());
        }
        return llllllllllllllllIIIlIIlIllllllIl;
    }
    
    private void fetchFlowMappingStart() {
        this.fetchFlowCollectionStart(true);
    }
    
    @Override
    public Token getToken() {
        ++this.tokensTaken;
        return this.tokens.remove(0);
    }
    
    private void fetchFlowCollectionStart(final boolean llllllllllllllllIIIlIIllllIIIlII) {
        this.savePossibleSimpleKey();
        ++this.flowLevel;
        this.allowSimpleKey = true;
        final Mark llllllllllllllllIIIlIIllllIIlIII = this.reader.getMark();
        this.reader.forward(1);
        final Mark llllllllllllllllIIIlIIllllIIIlll = this.reader.getMark();
        Token llllllllllllllllIIIlIIllllIIIllI = null;
        if (llllllllllllllllIIIlIIllllIIIlII) {
            final Token llllllllllllllllIIIlIIllllIIlIll = new FlowMappingStartToken(llllllllllllllllIIIlIIllllIIlIII, llllllllllllllllIIIlIIllllIIIlll);
        }
        else {
            llllllllllllllllIIIlIIllllIIIllI = new FlowSequenceStartToken(llllllllllllllllIIIlIIllllIIlIII, llllllllllllllllIIIlIIllllIIIlll);
        }
        this.tokens.add(llllllllllllllllIIIlIIllllIIIllI);
    }
    
    private void stalePossibleSimpleKeys() {
        if (!this.possibleSimpleKeys.isEmpty()) {
            final Iterator<SimpleKey> llllllllllllllllIIIlIlIIIIlIlIlI = this.possibleSimpleKeys.values().iterator();
            while (llllllllllllllllIIIlIlIIIIlIlIlI.hasNext()) {
                final SimpleKey llllllllllllllllIIIlIlIIIIlIlIll = llllllllllllllllIIIlIlIIIIlIlIlI.next();
                if (llllllllllllllllIIIlIlIIIIlIlIll.getLine() != this.reader.getLine() || this.reader.getIndex() - llllllllllllllllIIIlIlIIIIlIlIll.getIndex() > 1024) {
                    if (llllllllllllllllIIIlIlIIIIlIlIll.isRequired()) {
                        throw new ScannerException("while scanning a simple key", llllllllllllllllIIIlIlIIIIlIlIll.getMark(), "could not find expected ':'", this.reader.getMark());
                    }
                    llllllllllllllllIIIlIlIIIIlIlIlI.remove();
                }
            }
        }
    }
    
    private Token scanPlain() {
        final StringBuilder llllllllllllllllIIIlIIIllIIIIIIl = new StringBuilder();
        Mark llllllllllllllllIIIlIIIlIlllllll;
        final Mark llllllllllllllllIIIlIIIllIIIIIII = llllllllllllllllIIIlIIIlIlllllll = this.reader.getMark();
        final int llllllllllllllllIIIlIIIlIllllllI = this.indent + 1;
        String llllllllllllllllIIIlIIIlIlllllIl = "";
        do {
            int llllllllllllllllIIIlIIIllIIIIIll = 0;
            if (this.reader.peek() == 35) {
                break;
            }
            while (true) {
                final int llllllllllllllllIIIlIIIllIIIIlII = this.reader.peek(llllllllllllllllIIIlIIIllIIIIIll);
                if (Constant.NULL_BL_T_LINEBR.has(llllllllllllllllIIIlIIIllIIIIlII) || (llllllllllllllllIIIlIIIllIIIIlII == 58 && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(llllllllllllllllIIIlIIIllIIIIIll + 1), (this.flowLevel != 0) ? ",[]{}" : "")) || (this.flowLevel != 0 && ",?[]{}".indexOf(llllllllllllllllIIIlIIIllIIIIlII) != -1)) {
                    break;
                }
                ++llllllllllllllllIIIlIIIllIIIIIll;
            }
            if (llllllllllllllllIIIlIIIllIIIIIll == 0) {
                break;
            }
            this.allowSimpleKey = false;
            llllllllllllllllIIIlIIIllIIIIIIl.append(llllllllllllllllIIIlIIIlIlllllIl);
            llllllllllllllllIIIlIIIllIIIIIIl.append(this.reader.prefixForward(llllllllllllllllIIIlIIIllIIIIIll));
            llllllllllllllllIIIlIIIlIlllllll = this.reader.getMark();
            llllllllllllllllIIIlIIIlIlllllIl = this.scanPlainSpaces();
            if (llllllllllllllllIIIlIIIlIlllllIl.length() == 0 || this.reader.peek() == 35) {
                break;
            }
        } while (this.flowLevel != 0 || this.reader.getColumn() >= llllllllllllllllIIIlIIIlIllllllI);
        return new ScalarToken(String.valueOf(llllllllllllllllIIIlIIIllIIIIIIl), llllllllllllllllIIIlIIIllIIIIIII, llllllllllllllllIIIlIIIlIlllllll, true);
    }
    
    private boolean needMoreTokens() {
        if (this.done) {
            return false;
        }
        if (this.tokens.isEmpty()) {
            return true;
        }
        this.stalePossibleSimpleKeys();
        return this.nextPossibleSimpleKey() == this.tokensTaken;
    }
    
    private void scanToNextToken() {
        if (this.reader.getIndex() == 0 && this.reader.peek() == 65279) {
            this.reader.forward();
        }
        boolean llllllllllllllllIIIlIIllIIlIIIIl = false;
        while (!llllllllllllllllIIIlIIllIIlIIIIl) {
            int llllllllllllllllIIIlIIllIIlIIIll;
            for (llllllllllllllllIIIlIIllIIlIIIll = 0; this.reader.peek(llllllllllllllllIIIlIIllIIlIIIll) == 32; ++llllllllllllllllIIIlIIllIIlIIIll) {}
            if (llllllllllllllllIIIlIIllIIlIIIll > 0) {
                this.reader.forward(llllllllllllllllIIIlIIllIIlIIIll);
            }
            if (this.reader.peek() == 35) {
                for (llllllllllllllllIIIlIIllIIlIIIll = 0; Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(llllllllllllllllIIIlIIllIIlIIIll)); ++llllllllllllllllIIIlIIllIIlIIIll) {}
                if (llllllllllllllllIIIlIIllIIlIIIll > 0) {
                    this.reader.forward(llllllllllllllllIIIlIIllIIlIIIll);
                }
            }
            if (this.scanLineBreak().length() != 0) {
                if (this.flowLevel != 0) {
                    continue;
                }
                this.allowSimpleKey = true;
            }
            else {
                llllllllllllllllIIIlIIllIIlIIIIl = true;
            }
        }
    }
    
    private void fetchFlowSequenceEnd() {
        this.fetchFlowCollectionEnd(false);
    }
    
    private void fetchBlockScalar(final char llllllllllllllllIIIlIIllIlIllIII) {
        this.allowSimpleKey = true;
        this.removePossibleSimpleKey();
        final Token llllllllllllllllIIIlIIllIlIlIlll = this.scanBlockScalar(llllllllllllllllIIIlIIllIlIllIII);
        this.tokens.add(llllllllllllllllIIIlIIllIlIlIlll);
    }
    
    private void fetchFlowCollectionEnd(final boolean llllllllllllllllIIIlIIlllIlIlllI) {
        this.removePossibleSimpleKey();
        --this.flowLevel;
        this.allowSimpleKey = false;
        final Mark llllllllllllllllIIIlIIlllIllIIlI = this.reader.getMark();
        this.reader.forward();
        final Mark llllllllllllllllIIIlIIlllIllIIIl = this.reader.getMark();
        Token llllllllllllllllIIIlIIlllIllIIII = null;
        if (llllllllllllllllIIIlIIlllIlIlllI) {
            final Token llllllllllllllllIIIlIIlllIllIlIl = new FlowMappingEndToken(llllllllllllllllIIIlIIlllIllIIlI, llllllllllllllllIIIlIIlllIllIIIl);
        }
        else {
            llllllllllllllllIIIlIIlllIllIIII = new FlowSequenceEndToken(llllllllllllllllIIIlIIlllIllIIlI, llllllllllllllllIIIlIIlllIllIIIl);
        }
        this.tokens.add(llllllllllllllllIIIlIIlllIllIIII);
    }
    
    private String scanTagDirectiveHandle(final Mark llllllllllllllllIIIlIIlIlIlllIII) {
        final String llllllllllllllllIIIlIIlIlIlllIll = this.scanTagHandle("directive", llllllllllllllllIIIlIIlIlIlllIII);
        final int llllllllllllllllIIIlIIlIlIlllIlI = this.reader.peek();
        if (llllllllllllllllIIIlIIlIlIlllIlI != 32) {
            final String llllllllllllllllIIIlIIlIlIlllllI = String.valueOf(Character.toChars(llllllllllllllllIIIlIIlIlIlllIlI));
            throw new ScannerException("while scanning a directive", llllllllllllllllIIIlIIlIlIlllIII, String.valueOf(new StringBuilder().append("expected ' ', but found ").append(llllllllllllllllIIIlIIlIlIlllllI).append("(").append(llllllllllllllllIIIlIIlIlIlllIlI).append(")")), this.reader.getMark());
        }
        return llllllllllllllllIIIlIIlIlIlllIll;
    }
    
    private boolean checkDocumentEnd() {
        return this.reader.getColumn() == 0 && "...".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }
    
    private void fetchTag() {
        this.savePossibleSimpleKey();
        this.allowSimpleKey = false;
        final Token llllllllllllllllIIIlIIllIllIIlIl = this.scanTag();
        this.tokens.add(llllllllllllllllIIIlIIllIllIIlIl);
    }
    
    private Token scanFlowScalar(final char llllllllllllllllIIIlIIIlllIlIlIl) {
        boolean llllllllllllllllIIIlIIIlllIllIll = false;
        if (llllllllllllllllIIIlIIIlllIlIlIl == '\"') {
            final boolean llllllllllllllllIIIlIIIlllIllllI = true;
        }
        else {
            llllllllllllllllIIIlIIIlllIllIll = false;
        }
        final StringBuilder llllllllllllllllIIIlIIIlllIllIlI = new StringBuilder();
        final Mark llllllllllllllllIIIlIIIlllIllIIl = this.reader.getMark();
        final int llllllllllllllllIIIlIIIlllIllIII = this.reader.peek();
        this.reader.forward();
        llllllllllllllllIIIlIIIlllIllIlI.append(this.scanFlowScalarNonSpaces(llllllllllllllllIIIlIIIlllIllIll, llllllllllllllllIIIlIIIlllIllIIl));
        while (this.reader.peek() != llllllllllllllllIIIlIIIlllIllIII) {
            llllllllllllllllIIIlIIIlllIllIlI.append(this.scanFlowScalarSpaces(llllllllllllllllIIIlIIIlllIllIIl));
            llllllllllllllllIIIlIIIlllIllIlI.append(this.scanFlowScalarNonSpaces(llllllllllllllllIIIlIIIlllIllIll, llllllllllllllllIIIlIIIlllIllIIl));
        }
        this.reader.forward();
        final Mark llllllllllllllllIIIlIIIlllIlIlll = this.reader.getMark();
        return new ScalarToken(String.valueOf(llllllllllllllllIIIlIIIlllIllIlI), false, llllllllllllllllIIIlIIIlllIllIIl, llllllllllllllllIIIlIIIlllIlIlll, DumperOptions.ScalarStyle.createStyle(llllllllllllllllIIIlIIIlllIlIlIl));
    }
    
    private void fetchFolded() {
        this.fetchBlockScalar('>');
    }
    
    private String scanFlowScalarNonSpaces(final boolean llllllllllllllllIIIlIIIllIllllll, final Mark llllllllllllllllIIIlIIIllIlllIlI) {
        final StringBuilder llllllllllllllllIIIlIIIllIllllIl = new StringBuilder();
        while (true) {
            int llllllllllllllllIIIlIIIlllIIIIlI;
            for (llllllllllllllllIIIlIIIlllIIIIlI = 0; Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(llllllllllllllllIIIlIIIlllIIIIlI), "'\"\\"); ++llllllllllllllllIIIlIIIlllIIIIlI) {}
            if (llllllllllllllllIIIlIIIlllIIIIlI != 0) {
                llllllllllllllllIIIlIIIllIllllIl.append(this.reader.prefixForward(llllllllllllllllIIIlIIIlllIIIIlI));
            }
            int llllllllllllllllIIIlIIIlllIIIIIl = this.reader.peek();
            if (!llllllllllllllllIIIlIIIllIllllll && llllllllllllllllIIIlIIIlllIIIIIl == 39 && this.reader.peek(1) == 39) {
                llllllllllllllllIIIlIIIllIllllIl.append("'");
                this.reader.forward(2);
            }
            else if ((llllllllllllllllIIIlIIIllIllllll && llllllllllllllllIIIlIIIlllIIIIIl == 39) || (!llllllllllllllllIIIlIIIllIllllll && "\"\\".indexOf(llllllllllllllllIIIlIIIlllIIIIIl) != -1)) {
                llllllllllllllllIIIlIIIllIllllIl.appendCodePoint(llllllllllllllllIIIlIIIlllIIIIIl);
                this.reader.forward();
            }
            else {
                if (!llllllllllllllllIIIlIIIllIllllll || llllllllllllllllIIIlIIIlllIIIIIl != 92) {
                    return String.valueOf(llllllllllllllllIIIlIIIllIllllIl);
                }
                this.reader.forward();
                llllllllllllllllIIIlIIIlllIIIIIl = this.reader.peek();
                if (!Character.isSupplementaryCodePoint(llllllllllllllllIIIlIIIlllIIIIIl) && ScannerImpl.ESCAPE_REPLACEMENTS.containsKey((char)llllllllllllllllIIIlIIIlllIIIIIl)) {
                    llllllllllllllllIIIlIIIllIllllIl.append(ScannerImpl.ESCAPE_REPLACEMENTS.get((char)llllllllllllllllIIIlIIIlllIIIIIl));
                    this.reader.forward();
                }
                else if (!Character.isSupplementaryCodePoint(llllllllllllllllIIIlIIIlllIIIIIl) && ScannerImpl.ESCAPE_CODES.containsKey((char)llllllllllllllllIIIlIIIlllIIIIIl)) {
                    llllllllllllllllIIIlIIIlllIIIIlI = ScannerImpl.ESCAPE_CODES.get((char)llllllllllllllllIIIlIIIlllIIIIIl);
                    this.reader.forward();
                    final String llllllllllllllllIIIlIIIlllIIIllI = this.reader.prefix(llllllllllllllllIIIlIIIlllIIIIlI);
                    if (ScannerImpl.NOT_HEXA.matcher(llllllllllllllllIIIlIIIlllIIIllI).find()) {
                        throw new ScannerException("while scanning a double-quoted scalar", llllllllllllllllIIIlIIIllIlllIlI, String.valueOf(new StringBuilder().append("expected escape sequence of ").append(llllllllllllllllIIIlIIIlllIIIIlI).append(" hexadecimal numbers, but found: ").append(llllllllllllllllIIIlIIIlllIIIllI)), this.reader.getMark());
                    }
                    final int llllllllllllllllIIIlIIIlllIIIlIl = Integer.parseInt(llllllllllllllllIIIlIIIlllIIIllI, 16);
                    final String llllllllllllllllIIIlIIIlllIIIlII = new String(Character.toChars(llllllllllllllllIIIlIIIlllIIIlIl));
                    llllllllllllllllIIIlIIIllIllllIl.append(llllllllllllllllIIIlIIIlllIIIlII);
                    this.reader.forward(llllllllllllllllIIIlIIIlllIIIIlI);
                }
                else {
                    if (this.scanLineBreak().length() == 0) {
                        final String llllllllllllllllIIIlIIIlllIIIIll = String.valueOf(Character.toChars(llllllllllllllllIIIlIIIlllIIIIIl));
                        throw new ScannerException("while scanning a double-quoted scalar", llllllllllllllllIIIlIIIllIlllIlI, String.valueOf(new StringBuilder().append("found unknown escape character ").append(llllllllllllllllIIIlIIIlllIIIIll).append("(").append(llllllllllllllllIIIlIIIlllIIIIIl).append(")")), this.reader.getMark());
                    }
                    llllllllllllllllIIIlIIIllIllllIl.append(this.scanFlowScalarBreaks(llllllllllllllllIIIlIIIllIlllIlI));
                }
            }
        }
    }
    
    private static class Chomping
    {
        private final /* synthetic */ int increment;
        private final /* synthetic */ Boolean value;
        
        public Chomping(final Boolean lllllllllllllllIIlIIIIlllIIlIlll, final int lllllllllllllllIIlIIIIlllIIllIIl) {
            this.value = lllllllllllllllIIlIIIIlllIIlIlll;
            this.increment = lllllllllllllllIIlIIIIlllIIllIIl;
        }
        
        public boolean chompTailIsTrue() {
            return this.value != null && this.value;
        }
        
        public int getIncrement() {
            return this.increment;
        }
        
        public boolean chompTailIsNotFalse() {
            return this.value == null || this.value;
        }
    }
}
