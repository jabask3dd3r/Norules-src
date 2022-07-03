package org.yaml.snakeyaml.emitter;

import org.yaml.snakeyaml.util.*;
import org.yaml.snakeyaml.*;
import java.io.*;
import org.yaml.snakeyaml.scanner.*;
import java.util.regex.*;
import org.yaml.snakeyaml.error.*;
import java.util.concurrent.*;
import org.yaml.snakeyaml.reader.*;
import java.util.*;
import org.yaml.snakeyaml.events.*;

public final class Emitter implements Emitable
{
    private final /* synthetic */ boolean splitLines;
    private final /* synthetic */ Boolean canonical;
    private final /* synthetic */ char[] bestLineBreak;
    private /* synthetic */ ScalarAnalysis analysis;
    private static final /* synthetic */ Pattern HANDLE_FORMAT;
    private final /* synthetic */ ArrayStack<Integer> indents;
    private final /* synthetic */ int maxSimpleKeyLength;
    private final /* synthetic */ ArrayStack<EmitterState> states;
    private static final /* synthetic */ Map<Character, String> ESCAPE_REPLACEMENTS;
    private /* synthetic */ EmitterState state;
    private /* synthetic */ boolean mappingContext;
    private /* synthetic */ String preparedTag;
    private final /* synthetic */ Writer stream;
    private static final /* synthetic */ Set<Character> INVALID_ANCHOR;
    private /* synthetic */ boolean simpleKeyContext;
    private /* synthetic */ Map<String, String> tagPrefixes;
    private /* synthetic */ int bestWidth;
    private static final /* synthetic */ Map<String, String> DEFAULT_TAG_PREFIXES;
    private /* synthetic */ boolean rootContext;
    private static final /* synthetic */ Pattern SPACES_PATTERN;
    private /* synthetic */ Integer indent;
    private /* synthetic */ int bestIndent;
    private /* synthetic */ boolean indention;
    private /* synthetic */ DumperOptions.ScalarStyle style;
    private /* synthetic */ Event event;
    private /* synthetic */ boolean whitespace;
    private final /* synthetic */ Boolean prettyFlow;
    private /* synthetic */ boolean openEnded;
    private /* synthetic */ int flowLevel;
    private final /* synthetic */ Queue<Event> events;
    private static final /* synthetic */ char[] SPACE;
    private final /* synthetic */ boolean indentWithIndicator;
    private /* synthetic */ int column;
    private final /* synthetic */ int indicatorIndent;
    private final /* synthetic */ boolean allowUnicode;
    private /* synthetic */ String preparedAnchor;
    
    private void writeLineBreak(final String llllllllllllllIlIlllIlllllllllll) throws IOException {
        this.whitespace = true;
        this.indention = true;
        this.column = 0;
        if (llllllllllllllIlIlllIlllllllllll == null) {
            this.stream.write(this.bestLineBreak);
        }
        else {
            this.stream.write(llllllllllllllIlIlllIlllllllllll);
        }
    }
    
    static {
        MIN_INDENT = 1;
        MAX_INDENT = 10;
        SPACE = new char[] { ' ' };
        SPACES_PATTERN = Pattern.compile("\\s");
        (INVALID_ANCHOR = new HashSet<Character>()).add('[');
        Emitter.INVALID_ANCHOR.add(']');
        Emitter.INVALID_ANCHOR.add('{');
        Emitter.INVALID_ANCHOR.add('}');
        Emitter.INVALID_ANCHOR.add(',');
        Emitter.INVALID_ANCHOR.add('*');
        Emitter.INVALID_ANCHOR.add('&');
        (ESCAPE_REPLACEMENTS = new HashMap<Character, String>()).put('\0', "0");
        Emitter.ESCAPE_REPLACEMENTS.put('\u0007', "a");
        Emitter.ESCAPE_REPLACEMENTS.put('\b', "b");
        Emitter.ESCAPE_REPLACEMENTS.put('\t', "t");
        Emitter.ESCAPE_REPLACEMENTS.put('\n', "n");
        Emitter.ESCAPE_REPLACEMENTS.put('\u000b', "v");
        Emitter.ESCAPE_REPLACEMENTS.put('\f', "f");
        Emitter.ESCAPE_REPLACEMENTS.put('\r', "r");
        Emitter.ESCAPE_REPLACEMENTS.put('\u001b', "e");
        Emitter.ESCAPE_REPLACEMENTS.put('\"', "\"");
        Emitter.ESCAPE_REPLACEMENTS.put('\\', "\\");
        Emitter.ESCAPE_REPLACEMENTS.put('\u0085', "N");
        Emitter.ESCAPE_REPLACEMENTS.put(' ', "_");
        Emitter.ESCAPE_REPLACEMENTS.put('\u2028', "L");
        Emitter.ESCAPE_REPLACEMENTS.put('\u2029', "P");
        (DEFAULT_TAG_PREFIXES = new LinkedHashMap<String, String>()).put("!", "!");
        Emitter.DEFAULT_TAG_PREFIXES.put("tag:yaml.org,2002:", "!!");
        HANDLE_FORMAT = Pattern.compile("^![-_\\w]*!$");
    }
    
    private ScalarAnalysis analyzeScalar(final String llllllllllllllIlIllllIIIIIllllll) {
        if (llllllllllllllIlIllllIIIIIllllll.length() == 0) {
            return new ScalarAnalysis(llllllllllllllIlIllllIIIIIllllll, true, false, false, true, true, false);
        }
        boolean llllllllllllllIlIllllIIIIlIlIIll = false;
        boolean llllllllllllllIlIllllIIIIlIlIIlI = false;
        boolean llllllllllllllIlIllllIIIIlIlIIIl = false;
        boolean llllllllllllllIlIllllIIIIlIlIIII = false;
        boolean llllllllllllllIlIllllIIIIlIIllll = false;
        boolean llllllllllllllIlIllllIIIIlIIlllI = false;
        boolean llllllllllllllIlIllllIIIIlIIllIl = false;
        boolean llllllllllllllIlIllllIIIIlIIllII = false;
        boolean llllllllllllllIlIllllIIIIlIIlIll = false;
        boolean llllllllllllllIlIllllIIIIlIIlIlI = false;
        if (llllllllllllllIlIllllIIIIIllllll.startsWith("---") || llllllllllllllIlIllllIIIIIllllll.startsWith("...")) {
            llllllllllllllIlIllllIIIIlIlIIll = true;
            llllllllllllllIlIllllIIIIlIlIIlI = true;
        }
        boolean llllllllllllllIlIllllIIIIlIIlIIl = true;
        boolean llllllllllllllIlIllllIIIIlIIlIII = llllllllllllllIlIllllIIIIIllllll.length() == 1 || Constant.NULL_BL_T_LINEBR.has(llllllllllllllIlIllllIIIIIllllll.codePointAt(1));
        boolean llllllllllllllIlIllllIIIIlIIIlll = false;
        boolean llllllllllllllIlIllllIIIIlIIIllI = false;
        int llllllllllllllIlIllllIIIIlIIIlIl = 0;
        while (llllllllllllllIlIllllIIIIlIIIlIl < llllllllllllllIlIllllIIIIIllllll.length()) {
            final int llllllllllllllIlIllllIIIIlIlIlll = llllllllllllllIlIllllIIIIIllllll.codePointAt(llllllllllllllIlIllllIIIIlIIIlIl);
            if (llllllllllllllIlIllllIIIIlIIIlIl == 0) {
                if ("#,[]{}&*!|>'\"%@`".indexOf(llllllllllllllIlIllllIIIIlIlIlll) != -1) {
                    llllllllllllllIlIllllIIIIlIlIIlI = true;
                    llllllllllllllIlIllllIIIIlIlIIll = true;
                }
                if (llllllllllllllIlIllllIIIIlIlIlll == 63 || llllllllllllllIlIllllIIIIlIlIlll == 58) {
                    llllllllllllllIlIllllIIIIlIlIIlI = true;
                    if (llllllllllllllIlIllllIIIIlIIlIII) {
                        llllllllllllllIlIllllIIIIlIlIIll = true;
                    }
                }
                if (llllllllllllllIlIllllIIIIlIlIlll == 45 && llllllllllllllIlIllllIIIIlIIlIII) {
                    llllllllllllllIlIllllIIIIlIlIIlI = true;
                    llllllllllllllIlIllllIIIIlIlIIll = true;
                }
            }
            else {
                if (",?[]{}".indexOf(llllllllllllllIlIllllIIIIlIlIlll) != -1) {
                    llllllllllllllIlIllllIIIIlIlIIlI = true;
                }
                if (llllllllllllllIlIllllIIIIlIlIlll == 58) {
                    llllllllllllllIlIllllIIIIlIlIIlI = true;
                    if (llllllllllllllIlIllllIIIIlIIlIII) {
                        llllllllllllllIlIllllIIIIlIlIIll = true;
                    }
                }
                if (llllllllllllllIlIllllIIIIlIlIlll == 35 && llllllllllllllIlIllllIIIIlIIlIIl) {
                    llllllllllllllIlIllllIIIIlIlIIlI = true;
                    llllllllllllllIlIllllIIIIlIlIIll = true;
                }
            }
            final boolean llllllllllllllIlIllllIIIIlIlIllI = Constant.LINEBR.has(llllllllllllllIlIllllIIIIlIlIlll);
            if (llllllllllllllIlIllllIIIIlIlIllI) {
                llllllllllllllIlIllllIIIIlIlIIIl = true;
            }
            if (llllllllllllllIlIllllIIIIlIlIlll != 10 && (32 > llllllllllllllIlIllllIIIIlIlIlll || llllllllllllllIlIllllIIIIlIlIlll > 126)) {
                if (llllllllllllllIlIllllIIIIlIlIlll == 133 || (llllllllllllllIlIllllIIIIlIlIlll >= 160 && llllllllllllllIlIllllIIIIlIlIlll <= 55295) || (llllllllllllllIlIllllIIIIlIlIlll >= 57344 && llllllllllllllIlIllllIIIIlIlIlll <= 65533) || (llllllllllllllIlIllllIIIIlIlIlll >= 65536 && llllllllllllllIlIllllIIIIlIlIlll <= 1114111)) {
                    if (!this.allowUnicode) {
                        llllllllllllllIlIllllIIIIlIlIIII = true;
                    }
                }
                else {
                    llllllllllllllIlIllllIIIIlIlIIII = true;
                }
            }
            if (llllllllllllllIlIllllIIIIlIlIlll == 32) {
                if (llllllllllllllIlIllllIIIIlIIIlIl == 0) {
                    llllllllllllllIlIllllIIIIlIIllll = true;
                }
                if (llllllllllllllIlIllllIIIIlIIIlIl == llllllllllllllIlIllllIIIIIllllll.length() - 1) {
                    llllllllllllllIlIllllIIIIlIIllIl = true;
                }
                if (llllllllllllllIlIllllIIIIlIIIllI) {
                    llllllllllllllIlIllllIIIIlIIlIll = true;
                }
                llllllllllllllIlIllllIIIIlIIIlll = true;
                llllllllllllllIlIllllIIIIlIIIllI = false;
            }
            else if (llllllllllllllIlIllllIIIIlIlIllI) {
                if (llllllllllllllIlIllllIIIIlIIIlIl == 0) {
                    llllllllllllllIlIllllIIIIlIIlllI = true;
                }
                if (llllllllllllllIlIllllIIIIlIIIlIl == llllllllllllllIlIllllIIIIIllllll.length() - 1) {
                    llllllllllllllIlIllllIIIIlIIllII = true;
                }
                if (llllllllllllllIlIllllIIIIlIIIlll) {
                    llllllllllllllIlIllllIIIIlIIlIlI = true;
                }
                llllllllllllllIlIllllIIIIlIIIlll = false;
                llllllllllllllIlIllllIIIIlIIIllI = true;
            }
            else {
                llllllllllllllIlIllllIIIIlIIIlll = false;
                llllllllllllllIlIllllIIIIlIIIllI = false;
            }
            llllllllllllllIlIllllIIIIlIIIlIl += Character.charCount(llllllllllllllIlIllllIIIIlIlIlll);
            llllllllllllllIlIllllIIIIlIIlIIl = (Constant.NULL_BL_T.has(llllllllllllllIlIllllIIIIlIlIlll) || llllllllllllllIlIllllIIIIlIlIllI);
            llllllllllllllIlIllllIIIIlIIlIII = true;
            if (llllllllllllllIlIllllIIIIlIIIlIl + 1 < llllllllllllllIlIllllIIIIIllllll.length()) {
                final int llllllllllllllIlIllllIIIIlIllIII = llllllllllllllIlIllllIIIIlIIIlIl + Character.charCount(llllllllllllllIlIllllIIIIIllllll.codePointAt(llllllllllllllIlIllllIIIIlIIIlIl));
                if (llllllllllllllIlIllllIIIIlIllIII >= llllllllllllllIlIllllIIIIIllllll.length()) {
                    continue;
                }
                llllllllllllllIlIllllIIIIlIIlIII = (Constant.NULL_BL_T.has(llllllllllllllIlIllllIIIIIllllll.codePointAt(llllllllllllllIlIllllIIIIlIllIII)) || llllllllllllllIlIllllIIIIlIlIllI);
            }
        }
        boolean llllllllllllllIlIllllIIIIlIIIlII = true;
        boolean llllllllllllllIlIllllIIIIlIIIIll = true;
        boolean llllllllllllllIlIllllIIIIlIIIIlI = true;
        boolean llllllllllllllIlIllllIIIIlIIIIIl = true;
        if (llllllllllllllIlIllllIIIIlIIllll || llllllllllllllIlIllllIIIIlIIlllI || llllllllllllllIlIllllIIIIlIIllIl || llllllllllllllIlIllllIIIIlIIllII) {
            llllllllllllllIlIllllIIIIlIIIIll = (llllllllllllllIlIllllIIIIlIIIlII = false);
        }
        if (llllllllllllllIlIllllIIIIlIIllIl) {
            llllllllllllllIlIllllIIIIlIIIIIl = false;
        }
        if (llllllllllllllIlIllllIIIIlIIlIll) {
            llllllllllllllIlIllllIIIIlIIIIll = (llllllllllllllIlIllllIIIIlIIIlII = (llllllllllllllIlIllllIIIIlIIIIlI = false));
        }
        if (llllllllllllllIlIllllIIIIlIIlIlI || llllllllllllllIlIllllIIIIlIlIIII) {
            llllllllllllllIlIllllIIIIlIIIIll = (llllllllllllllIlIllllIIIIlIIIlII = (llllllllllllllIlIllllIIIIlIIIIlI = (llllllllllllllIlIllllIIIIlIIIIIl = false)));
        }
        if (llllllllllllllIlIllllIIIIlIlIIIl) {
            llllllllllllllIlIllllIIIIlIIIlII = false;
        }
        if (llllllllllllllIlIllllIIIIlIlIIlI) {
            llllllllllllllIlIllllIIIIlIIIlII = false;
        }
        if (llllllllllllllIlIllllIIIIlIlIIll) {
            llllllllllllllIlIllllIIIIlIIIIll = false;
        }
        return new ScalarAnalysis(llllllllllllllIlIllllIIIIIllllll, false, llllllllllllllIlIllllIIIIlIlIIIl, llllllllllllllIlIllllIIIIlIIIlII, llllllllllllllIlIllllIIIIlIIIIll, llllllllllllllIlIllllIIIIlIIIIlI, llllllllllllllIlIllllIIIIlIIIIIl);
    }
    
    void writeTagDirective(final String llllllllllllllIlIlllIllllllIllll, final String llllllllllllllIlIlllIlllllllIIIl) throws IOException {
        this.stream.write("%TAG ");
        this.stream.write(llllllllllllllIlIlllIllllllIllll);
        this.stream.write(Emitter.SPACE);
        this.stream.write(llllllllllllllIlIlllIlllllllIIIl);
        this.writeLineBreak(null);
    }
    
    private void writeWhitespace(final int llllllllllllllIlIllllIIIIIIIlIII) throws IOException {
        if (llllllllllllllIlIllllIIIIIIIlIII <= 0) {
            return;
        }
        this.whitespace = true;
        final char[] llllllllllllllIlIllllIIIIIIIIlll = new char[llllllllllllllIlIllllIIIIIIIlIII];
        for (int llllllllllllllIlIllllIIIIIIIlIlI = 0; llllllllllllllIlIllllIIIIIIIlIlI < llllllllllllllIlIllllIIIIIIIIlll.length; ++llllllllllllllIlIllllIIIIIIIlIlI) {
            llllllllllllllIlIllllIIIIIIIIlll[llllllllllllllIlIllllIIIIIIIlIlI] = ' ';
        }
        this.column += llllllllllllllIlIllllIIIIIIIlIII;
        this.stream.write(llllllllllllllIlIllllIIIIIIIIlll);
    }
    
    private String prepareTagPrefix(final String llllllllllllllIlIllllIIIlIIlIIll) {
        if (llllllllllllllIlIllllIIIlIIlIIll.length() == 0) {
            throw new EmitterException("tag prefix must not be empty");
        }
        final StringBuilder llllllllllllllIlIllllIIIlIIlIIlI = new StringBuilder();
        final int llllllllllllllIlIllllIIIlIIlIIIl = 0;
        int llllllllllllllIlIllllIIIlIIlIIII = 0;
        if (llllllllllllllIlIllllIIIlIIlIIll.charAt(0) == '!') {
            llllllllllllllIlIllllIIIlIIlIIII = 1;
        }
        while (llllllllllllllIlIllllIIIlIIlIIII < llllllllllllllIlIllllIIIlIIlIIll.length()) {
            ++llllllllllllllIlIllllIIIlIIlIIII;
        }
        if (llllllllllllllIlIllllIIIlIIlIIIl < llllllllllllllIlIllllIIIlIIlIIII) {
            llllllllllllllIlIllllIIIlIIlIIlI.append(llllllllllllllIlIllllIIIlIIlIIll, llllllllllllllIlIllllIIIlIIlIIIl, llllllllllllllIlIllllIIIlIIlIIII);
        }
        return String.valueOf(llllllllllllllIlIllllIIIlIIlIIlI);
    }
    
    static String prepareAnchor(final String llllllllllllllIlIllllIIIIlllIIlI) {
        if (llllllllllllllIlIllllIIIIlllIIlI.length() == 0) {
            throw new EmitterException("anchor must not be empty");
        }
        for (final Character llllllllllllllIlIllllIIIIlllIlII : Emitter.INVALID_ANCHOR) {
            if (llllllllllllllIlIllllIIIIlllIIlI.indexOf(llllllllllllllIlIllllIIIIlllIlII) > -1) {
                throw new EmitterException(String.valueOf(new StringBuilder().append("Invalid character '").append(llllllllllllllIlIllllIIIIlllIlII).append("' in the anchor: ").append(llllllllllllllIlIllllIIIIlllIIlI)));
            }
        }
        final Matcher llllllllllllllIlIllllIIIIlllIIIl = Emitter.SPACES_PATTERN.matcher(llllllllllllllIlIllllIIIIlllIIlI);
        if (llllllllllllllIlIllllIIIIlllIIIl.find()) {
            throw new EmitterException(String.valueOf(new StringBuilder().append("Anchor may not contain spaces: ").append(llllllllllllllIlIllllIIIIlllIIlI)));
        }
        return llllllllllllllIlIllllIIIIlllIIlI;
    }
    
    void writeStreamStart() {
    }
    
    private void expectFlowSequence() throws IOException {
        this.writeIndicator("[", true, true, false);
        ++this.flowLevel;
        this.increaseIndent(true, false);
        if (this.prettyFlow) {
            this.writeIndent();
        }
        this.state = new ExpectFirstFlowSequenceItem();
    }
    
    private String prepareTagHandle(final String llllllllllllllIlIllllIIIlIIllIIl) {
        if (llllllllllllllIlIllllIIIlIIllIIl.length() == 0) {
            throw new EmitterException("tag handle must not be empty");
        }
        if (llllllllllllllIlIllllIIIlIIllIIl.charAt(0) != '!' || llllllllllllllIlIllllIIIlIIllIIl.charAt(llllllllllllllIlIllllIIIlIIllIIl.length() - 1) != '!') {
            throw new EmitterException(String.valueOf(new StringBuilder().append("tag handle must start and end with '!': ").append(llllllllllllllIlIllllIIIlIIllIIl)));
        }
        if (!"!".equals(llllllllllllllIlIllllIIIlIIllIIl) && !Emitter.HANDLE_FORMAT.matcher(llllllllllllllIlIllllIIIlIIllIIl).matches()) {
            throw new EmitterException(String.valueOf(new StringBuilder().append("invalid character in the tag handle: ").append(llllllllllllllIlIllllIIIlIIllIIl)));
        }
        return llllllllllllllIlIllllIIIlIIllIIl;
    }
    
    private boolean checkEmptySequence() {
        return this.event instanceof SequenceStartEvent && !this.events.isEmpty() && this.events.peek() instanceof SequenceEndEvent;
    }
    
    private void writeSingleQuoted(final String llllllllllllllIlIlllIlllllIlIllI, final boolean llllllllllllllIlIlllIlllllIIllII) throws IOException {
        this.writeIndicator("'", true, false, false);
        boolean llllllllllllllIlIlllIlllllIlIIlI = false;
        boolean llllllllllllllIlIlllIlllllIlIIIl = false;
        int llllllllllllllIlIlllIlllllIlIIII = 0;
        for (int llllllllllllllIlIlllIlllllIIllll = 0; llllllllllllllIlIlllIlllllIIllll <= llllllllllllllIlIlllIlllllIlIllI.length(); ++llllllllllllllIlIlllIlllllIIllll) {
            char llllllllllllllIlIlllIlllllIllIIl = '\0';
            if (llllllllllllllIlIlllIlllllIIllll < llllllllllllllIlIlllIlllllIlIllI.length()) {
                llllllllllllllIlIlllIlllllIllIIl = llllllllllllllIlIlllIlllllIlIllI.charAt(llllllllllllllIlIlllIlllllIIllll);
            }
            if (llllllllllllllIlIlllIlllllIlIIlI) {
                if (llllllllllllllIlIlllIlllllIllIIl == '\0' || llllllllllllllIlIlllIlllllIllIIl != ' ') {
                    if (llllllllllllllIlIlllIlllllIlIIII + 1 == llllllllllllllIlIlllIlllllIIllll && this.column > this.bestWidth && llllllllllllllIlIlllIlllllIIllII && llllllllllllllIlIlllIlllllIlIIII != 0 && llllllllllllllIlIlllIlllllIIllll != llllllllllllllIlIlllIlllllIlIllI.length()) {
                        this.writeIndent();
                    }
                    else {
                        final int llllllllllllllIlIlllIllllllIIIII = llllllllllllllIlIlllIlllllIIllll - llllllllllllllIlIlllIlllllIlIIII;
                        this.column += llllllllllllllIlIlllIllllllIIIII;
                        this.stream.write(llllllllllllllIlIlllIlllllIlIllI, llllllllllllllIlIlllIlllllIlIIII, llllllllllllllIlIlllIllllllIIIII);
                    }
                    llllllllllllllIlIlllIlllllIlIIII = llllllllllllllIlIlllIlllllIIllll;
                }
            }
            else if (llllllllllllllIlIlllIlllllIlIIIl) {
                if (llllllllllllllIlIlllIlllllIllIIl == '\0' || Constant.LINEBR.hasNo(llllllllllllllIlIlllIlllllIllIIl)) {
                    if (llllllllllllllIlIlllIlllllIlIllI.charAt(llllllllllllllIlIlllIlllllIlIIII) == '\n') {
                        this.writeLineBreak(null);
                    }
                    final String llllllllllllllIlIlllIlllllIllIll = llllllllllllllIlIlllIlllllIlIllI.substring(llllllllllllllIlIlllIlllllIlIIII, llllllllllllllIlIlllIlllllIIllll);
                    for (final char llllllllllllllIlIlllIlllllIlllll : llllllllllllllIlIlllIlllllIllIll.toCharArray()) {
                        if (llllllllllllllIlIlllIlllllIlllll == '\n') {
                            this.writeLineBreak(null);
                        }
                        else {
                            this.writeLineBreak(String.valueOf(llllllllllllllIlIlllIlllllIlllll));
                        }
                    }
                    this.writeIndent();
                    llllllllllllllIlIlllIlllllIlIIII = llllllllllllllIlIlllIlllllIIllll;
                }
            }
            else if (Constant.LINEBR.has(llllllllllllllIlIlllIlllllIllIIl, "\u0000 '") && llllllllllllllIlIlllIlllllIlIIII < llllllllllllllIlIlllIlllllIIllll) {
                final int llllllllllllllIlIlllIlllllIllIlI = llllllllllllllIlIlllIlllllIIllll - llllllllllllllIlIlllIlllllIlIIII;
                this.column += llllllllllllllIlIlllIlllllIllIlI;
                this.stream.write(llllllllllllllIlIlllIlllllIlIllI, llllllllllllllIlIlllIlllllIlIIII, llllllllllllllIlIlllIlllllIllIlI);
                llllllllllllllIlIlllIlllllIlIIII = llllllllllllllIlIlllIlllllIIllll;
            }
            if (llllllllllllllIlIlllIlllllIllIIl == '\'') {
                this.column += 2;
                this.stream.write("''");
                llllllllllllllIlIlllIlllllIlIIII = llllllllllllllIlIlllIlllllIIllll + 1;
            }
            if (llllllllllllllIlIlllIlllllIllIIl != '\0') {
                llllllllllllllIlIlllIlllllIlIIlI = (llllllllllllllIlIlllIlllllIllIIl == ' ');
                llllllllllllllIlIlllIlllllIlIIIl = Constant.LINEBR.has(llllllllllllllIlIlllIlllllIllIIl);
            }
        }
        this.writeIndicator("'", false, false, false);
    }
    
    private void processScalar() throws IOException {
        final ScalarEvent llllllllllllllIlIllllIIIlIlIIlIl = (ScalarEvent)this.event;
        if (this.analysis == null) {
            this.analysis = this.analyzeScalar(llllllllllllllIlIllllIIIlIlIIlIl.getValue());
        }
        if (this.style == null) {
            this.style = this.chooseScalarStyle();
        }
        final boolean llllllllllllllIlIllllIIIlIlIIlII = !this.simpleKeyContext && this.splitLines;
        if (this.style == null) {
            this.writePlain(this.analysis.getScalar(), llllllllllllllIlIllllIIIlIlIIlII);
        }
        else {
            switch (this.style) {
                case DOUBLE_QUOTED: {
                    this.writeDoubleQuoted(this.analysis.getScalar(), llllllllllllllIlIllllIIIlIlIIlII);
                    break;
                }
                case SINGLE_QUOTED: {
                    this.writeSingleQuoted(this.analysis.getScalar(), llllllllllllllIlIllllIIIlIlIIlII);
                    break;
                }
                case FOLDED: {
                    this.writeFolded(this.analysis.getScalar(), llllllllllllllIlIllllIIIlIlIIlII);
                    break;
                }
                case LITERAL: {
                    this.writeLiteral(this.analysis.getScalar());
                    break;
                }
                default: {
                    throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected style: ").append(this.style)));
                }
            }
        }
        this.analysis = null;
        this.style = null;
    }
    
    public Emitter(final Writer llllllllllllllIlIllllIIlIIllIIII, final DumperOptions llllllllllllllIlIllllIIlIIllIlII) {
        this.stream = llllllllllllllIlIllllIIlIIllIIII;
        this.states = new ArrayStack<EmitterState>(100);
        this.state = new ExpectStreamStart();
        this.events = new ArrayBlockingQueue<Event>(100);
        this.event = null;
        this.indents = new ArrayStack<Integer>(10);
        this.indent = null;
        this.flowLevel = 0;
        this.mappingContext = false;
        this.simpleKeyContext = false;
        this.column = 0;
        this.whitespace = true;
        this.indention = true;
        this.openEnded = false;
        this.canonical = llllllllllllllIlIllllIIlIIllIlII.isCanonical();
        this.prettyFlow = llllllllllllllIlIllllIIlIIllIlII.isPrettyFlow();
        this.allowUnicode = llllllllllllllIlIllllIIlIIllIlII.isAllowUnicode();
        this.bestIndent = 2;
        if (llllllllllllllIlIllllIIlIIllIlII.getIndent() > 1 && llllllllllllllIlIllllIIlIIllIlII.getIndent() < 10) {
            this.bestIndent = llllllllllllllIlIllllIIlIIllIlII.getIndent();
        }
        this.indicatorIndent = llllllllllllllIlIllllIIlIIllIlII.getIndicatorIndent();
        this.indentWithIndicator = llllllllllllllIlIllllIIlIIllIlII.getIndentWithIndicator();
        this.bestWidth = 80;
        if (llllllllllllllIlIllllIIlIIllIlII.getWidth() > this.bestIndent * 2) {
            this.bestWidth = llllllllllllllIlIllllIIlIIllIlII.getWidth();
        }
        this.bestLineBreak = llllllllllllllIlIllllIIlIIllIlII.getLineBreak().getString().toCharArray();
        this.splitLines = llllllllllllllIlIllllIIlIIllIlII.getSplitLines();
        this.maxSimpleKeyLength = llllllllllllllIlIllllIIlIIllIlII.getMaxSimpleKeyLength();
        this.tagPrefixes = new LinkedHashMap<String, String>();
        this.preparedAnchor = null;
        this.preparedTag = null;
        this.analysis = null;
        this.style = null;
    }
    
    private boolean checkEmptyMapping() {
        return this.event instanceof MappingStartEvent && !this.events.isEmpty() && this.events.peek() instanceof MappingEndEvent;
    }
    
    private void processTag() throws IOException {
        String llllllllllllllIlIllllIIIlIllIIll = null;
        if (this.event instanceof ScalarEvent) {
            final ScalarEvent llllllllllllllIlIllllIIIlIllIllI = (ScalarEvent)this.event;
            llllllllllllllIlIllllIIIlIllIIll = llllllllllllllIlIllllIIIlIllIllI.getTag();
            if (this.style == null) {
                this.style = this.chooseScalarStyle();
            }
            if ((!this.canonical || llllllllllllllIlIllllIIIlIllIIll == null) && ((this.style == null && llllllllllllllIlIllllIIIlIllIllI.getImplicit().canOmitTagInPlainScalar()) || (this.style != null && llllllllllllllIlIllllIIIlIllIllI.getImplicit().canOmitTagInNonPlainScalar()))) {
                this.preparedTag = null;
                return;
            }
            if (llllllllllllllIlIllllIIIlIllIllI.getImplicit().canOmitTagInPlainScalar() && llllllllllllllIlIllllIIIlIllIIll == null) {
                llllllllllllllIlIllllIIIlIllIIll = "!";
                this.preparedTag = null;
            }
        }
        else {
            final CollectionStartEvent llllllllllllllIlIllllIIIlIllIlIl = (CollectionStartEvent)this.event;
            llllllllllllllIlIllllIIIlIllIIll = llllllllllllllIlIllllIIIlIllIlIl.getTag();
            if ((!this.canonical || llllllllllllllIlIllllIIIlIllIIll == null) && llllllllllllllIlIllllIIIlIllIlIl.getImplicit()) {
                this.preparedTag = null;
                return;
            }
        }
        if (llllllllllllllIlIllllIIIlIllIIll == null) {
            throw new EmitterException("tag is not specified");
        }
        if (this.preparedTag == null) {
            this.preparedTag = this.prepareTag(llllllllllllllIlIllllIIIlIllIIll);
        }
        this.writeIndicator(this.preparedTag, true, false, false);
        this.preparedTag = null;
    }
    
    private String determineBlockHints(final String llllllllllllllIlIlllIlllIIllIIll) {
        final StringBuilder llllllllllllllIlIlllIlllIIlllIII = new StringBuilder();
        if (Constant.LINEBR.has(llllllllllllllIlIlllIlllIIllIIll.charAt(0), " ")) {
            llllllllllllllIlIlllIlllIIlllIII.append(this.bestIndent);
        }
        final char llllllllllllllIlIlllIlllIIllIllI = llllllllllllllIlIlllIlllIIllIIll.charAt(llllllllllllllIlIlllIlllIIllIIll.length() - 1);
        if (Constant.LINEBR.hasNo(llllllllllllllIlIlllIlllIIllIllI)) {
            llllllllllllllIlIlllIlllIIlllIII.append("-");
        }
        else if (llllllllllllllIlIlllIlllIIllIIll.length() == 1 || Constant.LINEBR.has(llllllllllllllIlIlllIlllIIllIIll.charAt(llllllllllllllIlIlllIlllIIllIIll.length() - 2))) {
            llllllllllllllIlIlllIlllIIlllIII.append("+");
        }
        return String.valueOf(llllllllllllllIlIlllIlllIIlllIII);
    }
    
    private boolean checkEmptyDocument() {
        if (!(this.event instanceof DocumentStartEvent) || this.events.isEmpty()) {
            return false;
        }
        final Event llllllllllllllIlIllllIIIllIIllll = this.events.peek();
        if (llllllllllllllIlIllllIIIllIIllll instanceof ScalarEvent) {
            final ScalarEvent llllllllllllllIlIllllIIIllIlIIIl = (ScalarEvent)llllllllllllllIlIllllIIIllIIllll;
            return llllllllllllllIlIllllIIIllIlIIIl.getAnchor() == null && llllllllllllllIlIllllIIIllIlIIIl.getTag() == null && llllllllllllllIlIllllIIIllIlIIIl.getImplicit() != null && llllllllllllllIlIllllIIIllIlIIIl.getValue().length() == 0;
        }
        return false;
    }
    
    private void expectAlias() throws IOException {
        if (!(this.event instanceof AliasEvent)) {
            throw new EmitterException("Alias must be provided");
        }
        this.processAnchor("*");
        this.state = this.states.pop();
    }
    
    void writeIndent() throws IOException {
        int llllllllllllllIlIllllIIIIIIlIIIl = 0;
        if (this.indent != null) {
            final int llllllllllllllIlIllllIIIIIIlIIll = this.indent;
        }
        else {
            llllllllllllllIlIllllIIIIIIlIIIl = 0;
        }
        if (!this.indention || this.column > llllllllllllllIlIllllIIIIIIlIIIl || (this.column == llllllllllllllIlIllllIIIIIIlIIIl && !this.whitespace)) {
            this.writeLineBreak(null);
        }
        this.writeWhitespace(llllllllllllllIlIllllIIIIIIlIIIl - this.column);
    }
    
    void writeVersionDirective(final String llllllllllllllIlIlllIllllllllIIl) throws IOException {
        this.stream.write("%YAML ");
        this.stream.write(llllllllllllllIlIlllIllllllllIIl);
        this.writeLineBreak(null);
    }
    
    void writePlain(final String llllllllllllllIlIlllIllIlIIllIIl, final boolean llllllllllllllIlIlllIllIlIIlllll) throws IOException {
        if (this.rootContext) {
            this.openEnded = true;
        }
        if (llllllllllllllIlIlllIllIlIIllIIl.length() == 0) {
            return;
        }
        if (!this.whitespace) {
            ++this.column;
            this.stream.write(Emitter.SPACE);
        }
        this.whitespace = false;
        this.indention = false;
        boolean llllllllllllllIlIlllIllIlIIllllI = false;
        boolean llllllllllllllIlIlllIllIlIIlllIl = false;
        int llllllllllllllIlIlllIllIlIIlllII = 0;
        for (int llllllllllllllIlIlllIllIlIIllIll = 0; llllllllllllllIlIlllIllIlIIllIll <= llllllllllllllIlIlllIllIlIIllIIl.length(); ++llllllllllllllIlIlllIllIlIIllIll) {
            char llllllllllllllIlIlllIllIlIlIIIlI = '\0';
            if (llllllllllllllIlIlllIllIlIIllIll < llllllllllllllIlIlllIllIlIIllIIl.length()) {
                llllllllllllllIlIlllIllIlIlIIIlI = llllllllllllllIlIlllIllIlIIllIIl.charAt(llllllllllllllIlIlllIllIlIIllIll);
            }
            if (llllllllllllllIlIlllIllIlIIllllI) {
                if (llllllllllllllIlIlllIllIlIlIIIlI != ' ') {
                    if (llllllllllllllIlIlllIllIlIIlllII + 1 == llllllllllllllIlIlllIllIlIIllIll && this.column > this.bestWidth && llllllllllllllIlIlllIllIlIIlllll) {
                        this.writeIndent();
                        this.whitespace = false;
                        this.indention = false;
                    }
                    else {
                        final int llllllllllllllIlIlllIllIlIlIlIIl = llllllllllllllIlIlllIllIlIIllIll - llllllllllllllIlIlllIllIlIIlllII;
                        this.column += llllllllllllllIlIlllIllIlIlIlIIl;
                        this.stream.write(llllllllllllllIlIlllIllIlIIllIIl, llllllllllllllIlIlllIllIlIIlllII, llllllllllllllIlIlllIllIlIlIlIIl);
                    }
                    llllllllllllllIlIlllIllIlIIlllII = llllllllllllllIlIlllIllIlIIllIll;
                }
            }
            else if (llllllllllllllIlIlllIllIlIIlllIl) {
                if (Constant.LINEBR.hasNo(llllllllllllllIlIlllIllIlIlIIIlI)) {
                    if (llllllllllllllIlIlllIllIlIIllIIl.charAt(llllllllllllllIlIlllIllIlIIlllII) == '\n') {
                        this.writeLineBreak(null);
                    }
                    final String llllllllllllllIlIlllIllIlIlIIlII = llllllllllllllIlIlllIllIlIIllIIl.substring(llllllllllllllIlIlllIllIlIIlllII, llllllllllllllIlIlllIllIlIIllIll);
                    for (final char llllllllllllllIlIlllIllIlIlIlIII : llllllllllllllIlIlllIllIlIlIIlII.toCharArray()) {
                        if (llllllllllllllIlIlllIllIlIlIlIII == '\n') {
                            this.writeLineBreak(null);
                        }
                        else {
                            this.writeLineBreak(String.valueOf(llllllllllllllIlIlllIllIlIlIlIII));
                        }
                    }
                    this.writeIndent();
                    this.whitespace = false;
                    this.indention = false;
                    llllllllllllllIlIlllIllIlIIlllII = llllllllllllllIlIlllIllIlIIllIll;
                }
            }
            else if (Constant.LINEBR.has(llllllllllllllIlIlllIllIlIlIIIlI, "\u0000 ")) {
                final int llllllllllllllIlIlllIllIlIlIIIll = llllllllllllllIlIlllIllIlIIllIll - llllllllllllllIlIlllIllIlIIlllII;
                this.column += llllllllllllllIlIlllIllIlIlIIIll;
                this.stream.write(llllllllllllllIlIlllIllIlIIllIIl, llllllllllllllIlIlllIllIlIIlllII, llllllllllllllIlIlllIllIlIlIIIll);
                llllllllllllllIlIlllIllIlIIlllII = llllllllllllllIlIlllIllIlIIllIll;
            }
            if (llllllllllllllIlIlllIllIlIlIIIlI != '\0') {
                llllllllllllllIlIlllIllIlIIllllI = (llllllllllllllIlIlllIllIlIlIIIlI == ' ');
                llllllllllllllIlIlllIllIlIIlllIl = Constant.LINEBR.has(llllllllllllllIlIlllIllIlIlIIIlI);
            }
        }
    }
    
    void writeFolded(final String llllllllllllllIlIlllIlllIIIIllIl, final boolean llllllllllllllIlIlllIlllIIIIIIll) throws IOException {
        final String llllllllllllllIlIlllIlllIIIIlIll = this.determineBlockHints(llllllllllllllIlIlllIlllIIIIllIl);
        this.writeIndicator(String.valueOf(new StringBuilder().append(">").append(llllllllllllllIlIlllIlllIIIIlIll)), true, false, false);
        if (llllllllllllllIlIlllIlllIIIIlIll.length() > 0 && llllllllllllllIlIlllIlllIIIIlIll.charAt(llllllllllllllIlIlllIlllIIIIlIll.length() - 1) == '+') {
            this.openEnded = true;
        }
        this.writeLineBreak(null);
        boolean llllllllllllllIlIlllIlllIIIIlIlI = true;
        boolean llllllllllllllIlIlllIlllIIIIlIIl = false;
        boolean llllllllllllllIlIlllIlllIIIIlIII = true;
        int llllllllllllllIlIlllIlllIIIIIlll = 0;
        for (int llllllllllllllIlIlllIlllIIIIIllI = 0; llllllllllllllIlIlllIlllIIIIIllI <= llllllllllllllIlIlllIlllIIIIllIl.length(); ++llllllllllllllIlIlllIlllIIIIIllI) {
            char llllllllllllllIlIlllIlllIIIIllll = '\0';
            if (llllllllllllllIlIlllIlllIIIIIllI < llllllllllllllIlIlllIlllIIIIllIl.length()) {
                llllllllllllllIlIlllIlllIIIIllll = llllllllllllllIlIlllIlllIIIIllIl.charAt(llllllllllllllIlIlllIlllIIIIIllI);
            }
            if (llllllllllllllIlIlllIlllIIIIlIII) {
                if (llllllllllllllIlIlllIlllIIIIllll == '\0' || Constant.LINEBR.hasNo(llllllllllllllIlIlllIlllIIIIllll)) {
                    if (!llllllllllllllIlIlllIlllIIIIlIlI && llllllllllllllIlIlllIlllIIIIllll != '\0' && llllllllllllllIlIlllIlllIIIIllll != ' ' && llllllllllllllIlIlllIlllIIIIllIl.charAt(llllllllllllllIlIlllIlllIIIIIlll) == '\n') {
                        this.writeLineBreak(null);
                    }
                    llllllllllllllIlIlllIlllIIIIlIlI = (llllllllllllllIlIlllIlllIIIIllll == ' ');
                    final String llllllllllllllIlIlllIlllIIIlIIlI = llllllllllllllIlIlllIlllIIIIllIl.substring(llllllllllllllIlIlllIlllIIIIIlll, llllllllllllllIlIlllIlllIIIIIllI);
                    for (final char llllllllllllllIlIlllIlllIIIlIllI : llllllllllllllIlIlllIlllIIIlIIlI.toCharArray()) {
                        if (llllllllllllllIlIlllIlllIIIlIllI == '\n') {
                            this.writeLineBreak(null);
                        }
                        else {
                            this.writeLineBreak(String.valueOf(llllllllllllllIlIlllIlllIIIlIllI));
                        }
                    }
                    if (llllllllllllllIlIlllIlllIIIIllll != '\0') {
                        this.writeIndent();
                    }
                    llllllllllllllIlIlllIlllIIIIIlll = llllllllllllllIlIlllIlllIIIIIllI;
                }
            }
            else if (llllllllllllllIlIlllIlllIIIIlIIl) {
                if (llllllllllllllIlIlllIlllIIIIllll != ' ') {
                    if (llllllllllllllIlIlllIlllIIIIIlll + 1 == llllllllllllllIlIlllIlllIIIIIllI && this.column > this.bestWidth && llllllllllllllIlIlllIlllIIIIIIll) {
                        this.writeIndent();
                    }
                    else {
                        final int llllllllllllllIlIlllIlllIIIlIIIl = llllllllllllllIlIlllIlllIIIIIllI - llllllllllllllIlIlllIlllIIIIIlll;
                        this.column += llllllllllllllIlIlllIlllIIIlIIIl;
                        this.stream.write(llllllllllllllIlIlllIlllIIIIllIl, llllllllllllllIlIlllIlllIIIIIlll, llllllllllllllIlIlllIlllIIIlIIIl);
                    }
                    llllllllllllllIlIlllIlllIIIIIlll = llllllllllllllIlIlllIlllIIIIIllI;
                }
            }
            else if (Constant.LINEBR.has(llllllllllllllIlIlllIlllIIIIllll, "\u0000 ")) {
                final int llllllllllllllIlIlllIlllIIIlIIII = llllllllllllllIlIlllIlllIIIIIllI - llllllllllllllIlIlllIlllIIIIIlll;
                this.column += llllllllllllllIlIlllIlllIIIlIIII;
                this.stream.write(llllllllllllllIlIlllIlllIIIIllIl, llllllllllllllIlIlllIlllIIIIIlll, llllllllllllllIlIlllIlllIIIlIIII);
                if (llllllllllllllIlIlllIlllIIIIllll == '\0') {
                    this.writeLineBreak(null);
                }
                llllllllllllllIlIlllIlllIIIIIlll = llllllllllllllIlIlllIlllIIIIIllI;
            }
            if (llllllllllllllIlIlllIlllIIIIllll != '\0') {
                llllllllllllllIlIlllIlllIIIIlIII = Constant.LINEBR.has(llllllllllllllIlIlllIlllIIIIllll);
                llllllllllllllIlIlllIlllIIIIlIIl = (llllllllllllllIlIlllIlllIIIIllll == ' ');
            }
        }
    }
    
    void flushStream() throws IOException {
        this.stream.flush();
    }
    
    private boolean needMoreEvents() {
        if (this.events.isEmpty()) {
            return true;
        }
        final Event llllllllllllllIlIllllIIlIIIllIII = this.events.peek();
        if (llllllllllllllIlIllllIIlIIIllIII instanceof DocumentStartEvent) {
            return this.needEvents(1);
        }
        if (llllllllllllllIlIllllIIlIIIllIII instanceof SequenceStartEvent) {
            return this.needEvents(2);
        }
        return llllllllllllllIlIllllIIlIIIllIII instanceof MappingStartEvent && this.needEvents(3);
    }
    
    private void expectFlowMapping() throws IOException {
        this.writeIndicator("{", true, true, false);
        ++this.flowLevel;
        this.increaseIndent(true, false);
        if (this.prettyFlow) {
            this.writeIndent();
        }
        this.state = new ExpectFirstFlowMappingKey();
    }
    
    private void processAnchor(final String llllllllllllllIlIllllIIIlIlllllI) throws IOException {
        final NodeEvent llllllllllllllIlIllllIIIlIllllIl = (NodeEvent)this.event;
        if (llllllllllllllIlIllllIIIlIllllIl.getAnchor() == null) {
            this.preparedAnchor = null;
            return;
        }
        if (this.preparedAnchor == null) {
            this.preparedAnchor = prepareAnchor(llllllllllllllIlIllllIIIlIllllIl.getAnchor());
        }
        this.writeIndicator(String.valueOf(new StringBuilder().append(llllllllllllllIlIllllIIIlIlllllI).append(this.preparedAnchor)), true, false, false);
        this.preparedAnchor = null;
    }
    
    private void writeDoubleQuoted(final String llllllllllllllIlIlllIlllIlIllIII, final boolean llllllllllllllIlIlllIlllIlIlIIlI) throws IOException {
        this.writeIndicator("\"", true, false, false);
        int llllllllllllllIlIlllIlllIlIlIllI = 0;
        for (int llllllllllllllIlIlllIlllIlIlIlIl = 0; llllllllllllllIlIlllIlllIlIlIlIl <= llllllllllllllIlIlllIlllIlIllIII.length(); ++llllllllllllllIlIlllIlllIlIlIlIl) {
            Character llllllllllllllIlIlllIlllIlIllIlI = null;
            if (llllllllllllllIlIlllIlllIlIlIlIl < llllllllllllllIlIlllIlllIlIllIII.length()) {
                llllllllllllllIlIlllIlllIlIllIlI = llllllllllllllIlIlllIlllIlIllIII.charAt(llllllllllllllIlIlllIlllIlIlIlIl);
            }
            if (llllllllllllllIlIlllIlllIlIllIlI == null || "\"\\\u0085\u2028\u2029\ufeff".indexOf(llllllllllllllIlIlllIlllIlIllIlI) != -1 || ' ' > llllllllllllllIlIlllIlllIlIllIlI || llllllllllllllIlIlllIlllIlIllIlI > '~') {
                if (llllllllllllllIlIlllIlllIlIlIllI < llllllllllllllIlIlllIlllIlIlIlIl) {
                    final int llllllllllllllIlIlllIlllIllIlIII = llllllllllllllIlIlllIlllIlIlIlIl - llllllllllllllIlIlllIlllIlIlIllI;
                    this.column += llllllllllllllIlIlllIlllIllIlIII;
                    this.stream.write(llllllllllllllIlIlllIlllIlIllIII, llllllllllllllIlIlllIlllIlIlIllI, llllllllllllllIlIlllIlllIllIlIII);
                    llllllllllllllIlIlllIlllIlIlIllI = llllllllllllllIlIlllIlllIlIlIlIl;
                }
                if (llllllllllllllIlIlllIlllIlIllIlI != null) {
                    String llllllllllllllIlIlllIlllIlIlllIl = null;
                    if (Emitter.ESCAPE_REPLACEMENTS.containsKey(llllllllllllllIlIlllIlllIlIllIlI)) {
                        final String llllllllllllllIlIlllIlllIllIIlll = String.valueOf(new StringBuilder().append("\\").append(Emitter.ESCAPE_REPLACEMENTS.get(llllllllllllllIlIlllIlllIlIllIlI)));
                    }
                    else if (!this.allowUnicode || !StreamReader.isPrintable(llllllllllllllIlIlllIlllIlIllIlI)) {
                        if (llllllllllllllIlIlllIlllIlIllIlI <= '\u00ff') {
                            final String llllllllllllllIlIlllIlllIllIIllI = String.valueOf(new StringBuilder().append("0").append(Integer.toString(llllllllllllllIlIlllIlllIlIllIlI, 16)));
                            final String llllllllllllllIlIlllIlllIllIIlIl = String.valueOf(new StringBuilder().append("\\x").append(llllllllllllllIlIlllIlllIllIIllI.substring(llllllllllllllIlIlllIlllIllIIllI.length() - 2)));
                        }
                        else if (llllllllllllllIlIlllIlllIlIllIlI >= '\ud800' && llllllllllllllIlIlllIlllIlIllIlI <= '\udbff') {
                            if (llllllllllllllIlIlllIlllIlIlIlIl + 1 < llllllllllllllIlIlllIlllIlIllIII.length()) {
                                final Character llllllllllllllIlIlllIlllIllIIlII = llllllllllllllIlIlllIlllIlIllIII.charAt(++llllllllllllllIlIlllIlllIlIlIlIl);
                                final String llllllllllllllIlIlllIlllIllIIIll = String.valueOf(new StringBuilder().append("000").append(Long.toHexString(Character.toCodePoint(llllllllllllllIlIlllIlllIlIllIlI, llllllllllllllIlIlllIlllIllIIlII))));
                                final String llllllllllllllIlIlllIlllIllIIIlI = String.valueOf(new StringBuilder().append("\\U").append(llllllllllllllIlIlllIlllIllIIIll.substring(llllllllllllllIlIlllIlllIllIIIll.length() - 8)));
                            }
                            else {
                                final String llllllllllllllIlIlllIlllIllIIIIl = String.valueOf(new StringBuilder().append("000").append(Integer.toString(llllllllllllllIlIlllIlllIlIllIlI, 16)));
                                final String llllllllllllllIlIlllIlllIllIIIII = String.valueOf(new StringBuilder().append("\\u").append(llllllllllllllIlIlllIlllIllIIIIl.substring(llllllllllllllIlIlllIlllIllIIIIl.length() - 4)));
                            }
                        }
                        else {
                            final String llllllllllllllIlIlllIlllIlIlllll = String.valueOf(new StringBuilder().append("000").append(Integer.toString(llllllllllllllIlIlllIlllIlIllIlI, 16)));
                            final String llllllllllllllIlIlllIlllIlIllllI = String.valueOf(new StringBuilder().append("\\u").append(llllllllllllllIlIlllIlllIlIlllll.substring(llllllllllllllIlIlllIlllIlIlllll.length() - 4)));
                        }
                    }
                    else {
                        llllllllllllllIlIlllIlllIlIlllIl = String.valueOf(llllllllllllllIlIlllIlllIlIllIlI);
                    }
                    this.column += llllllllllllllIlIlllIlllIlIlllIl.length();
                    this.stream.write(llllllllllllllIlIlllIlllIlIlllIl);
                    llllllllllllllIlIlllIlllIlIlIllI = llllllllllllllIlIlllIlllIlIlIlIl + 1;
                }
            }
            if (0 < llllllllllllllIlIlllIlllIlIlIlIl && llllllllllllllIlIlllIlllIlIlIlIl < llllllllllllllIlIlllIlllIlIllIII.length() - 1 && (llllllllllllllIlIlllIlllIlIllIlI == ' ' || llllllllllllllIlIlllIlllIlIlIllI >= llllllllllllllIlIlllIlllIlIlIlIl) && this.column + (llllllllllllllIlIlllIlllIlIlIlIl - llllllllllllllIlIlllIlllIlIlIllI) > this.bestWidth && llllllllllllllIlIlllIlllIlIlIIlI) {
                String llllllllllllllIlIlllIlllIlIllIll = null;
                if (llllllllllllllIlIlllIlllIlIlIllI >= llllllllllllllIlIlllIlllIlIlIlIl) {
                    final String llllllllllllllIlIlllIlllIlIlllII = "\\";
                }
                else {
                    llllllllllllllIlIlllIlllIlIllIll = String.valueOf(new StringBuilder().append(llllllllllllllIlIlllIlllIlIllIII.substring(llllllllllllllIlIlllIlllIlIlIllI, llllllllllllllIlIlllIlllIlIlIlIl)).append("\\"));
                }
                if (llllllllllllllIlIlllIlllIlIlIllI < llllllllllllllIlIlllIlllIlIlIlIl) {
                    llllllllllllllIlIlllIlllIlIlIllI = llllllllllllllIlIlllIlllIlIlIlIl;
                }
                this.column += llllllllllllllIlIlllIlllIlIllIll.length();
                this.stream.write(llllllllllllllIlIlllIlllIlIllIll);
                this.writeIndent();
                this.whitespace = false;
                this.indention = false;
                if (llllllllllllllIlIlllIlllIlIllIII.charAt(llllllllllllllIlIlllIlllIlIlIllI) == ' ') {
                    llllllllllllllIlIlllIlllIlIllIll = "\\";
                    this.column += llllllllllllllIlIlllIlllIlIllIll.length();
                    this.stream.write(llllllllllllllIlIlllIlllIlIllIll);
                }
            }
        }
        this.writeIndicator("\"", false, false, false);
    }
    
    private String prepareVersion(final DumperOptions.Version llllllllllllllIlIllllIIIlIIllllI) {
        if (llllllllllllllIlIllllIIIlIIllllI.major() != 1) {
            throw new EmitterException(String.valueOf(new StringBuilder().append("unsupported YAML version: ").append(llllllllllllllIlIllllIIIlIIllllI)));
        }
        return llllllllllllllIlIllllIIIlIIllllI.getRepresentation();
    }
    
    void writeStreamEnd() throws IOException {
        this.flushStream();
    }
    
    void writeIndicator(final String llllllllllllllIlIllllIIIIIIllllI, final boolean llllllllllllllIlIllllIIIIIIlllIl, final boolean llllllllllllllIlIllllIIIIIIlIlll, final boolean llllllllllllllIlIllllIIIIIIlIllI) throws IOException {
        if (!this.whitespace && llllllllllllllIlIllllIIIIIIlllIl) {
            ++this.column;
            this.stream.write(Emitter.SPACE);
        }
        this.whitespace = llllllllllllllIlIllllIIIIIIlIlll;
        this.indention = (this.indention && llllllllllllllIlIllllIIIIIIlIllI);
        this.column += llllllllllllllIlIllllIIIIIIllllI.length();
        this.openEnded = false;
        this.stream.write(llllllllllllllIlIllllIIIIIIllllI);
    }
    
    private void expectScalar() throws IOException {
        this.increaseIndent(true, false);
        this.processScalar();
        this.indent = this.indents.pop();
        this.state = this.states.pop();
    }
    
    @Override
    public void emit(final Event llllllllllllllIlIllllIIlIIlIIIII) throws IOException {
        this.events.add(llllllllllllllIlIllllIIlIIlIIIII);
        while (!this.needMoreEvents()) {
            this.event = this.events.poll();
            this.state.expect();
            this.event = null;
        }
    }
    
    private void expectBlockSequence() throws IOException {
        final boolean llllllllllllllIlIllllIIIlllIIIII = this.mappingContext && !this.indention;
        this.increaseIndent(false, llllllllllllllIlIllllIIIlllIIIII);
        this.state = new ExpectFirstBlockSequenceItem();
    }
    
    private void increaseIndent(final boolean llllllllllllllIlIllllIIIlllllllI, final boolean llllllllllllllIlIllllIIIllllllIl) {
        this.indents.push(this.indent);
        if (this.indent == null) {
            if (llllllllllllllIlIllllIIIlllllllI) {
                this.indent = this.bestIndent;
            }
            else {
                this.indent = 0;
            }
        }
        else if (!llllllllllllllIlIllllIIIllllllIl) {
            final char llllllllllllllIlIllllIIIllllllII = (char)this;
            ((Emitter)llllllllllllllIlIllllIIIllllllII).indent += this.bestIndent;
        }
    }
    
    private void expectNode(final boolean llllllllllllllIlIllllIIIllllIllI, final boolean llllllllllllllIlIllllIIIllllIlIl, final boolean llllllllllllllIlIllllIIIllllIIII) throws IOException {
        this.rootContext = llllllllllllllIlIllllIIIllllIllI;
        this.mappingContext = llllllllllllllIlIllllIIIllllIlIl;
        this.simpleKeyContext = llllllllllllllIlIllllIIIllllIIII;
        if (this.event instanceof AliasEvent) {
            this.expectAlias();
        }
        else {
            if (!(this.event instanceof ScalarEvent) && !(this.event instanceof CollectionStartEvent)) {
                throw new EmitterException(String.valueOf(new StringBuilder().append("expected NodeEvent, but got ").append(this.event)));
            }
            this.processAnchor("&");
            this.processTag();
            if (this.event instanceof ScalarEvent) {
                this.expectScalar();
            }
            else if (this.event instanceof SequenceStartEvent) {
                if (this.flowLevel != 0 || this.canonical || ((SequenceStartEvent)this.event).isFlow() || this.checkEmptySequence()) {
                    this.expectFlowSequence();
                }
                else {
                    this.expectBlockSequence();
                }
            }
            else if (this.flowLevel != 0 || this.canonical || ((MappingStartEvent)this.event).isFlow() || this.checkEmptyMapping()) {
                this.expectFlowMapping();
            }
            else {
                this.expectBlockMapping();
            }
        }
    }
    
    private boolean needEvents(final int llllllllllllllIlIllllIIlIIIIlIlI) {
        int llllllllllllllIlIllllIIlIIIIllIl = 0;
        final Iterator<Event> llllllllllllllIlIllllIIlIIIIllII = this.events.iterator();
        llllllllllllllIlIllllIIlIIIIllII.next();
        while (llllllllllllllIlIllllIIlIIIIllII.hasNext()) {
            final Event llllllllllllllIlIllllIIlIIIlIIII = llllllllllllllIlIllllIIlIIIIllII.next();
            if (llllllllllllllIlIllllIIlIIIlIIII instanceof DocumentStartEvent || llllllllllllllIlIllllIIlIIIlIIII instanceof CollectionStartEvent) {
                ++llllllllllllllIlIllllIIlIIIIllIl;
            }
            else if (llllllllllllllIlIllllIIlIIIlIIII instanceof DocumentEndEvent || llllllllllllllIlIllllIIlIIIlIIII instanceof CollectionEndEvent) {
                --llllllllllllllIlIllllIIlIIIIllIl;
            }
            else if (llllllllllllllIlIllllIIlIIIlIIII instanceof StreamEndEvent) {
                llllllllllllllIlIllllIIlIIIIllIl = -1;
            }
            if (llllllllllllllIlIllllIIlIIIIllIl < 0) {
                return false;
            }
        }
        return this.events.size() < llllllllllllllIlIllllIIlIIIIlIlI + 1;
    }
    
    private String prepareTag(final String llllllllllllllIlIllllIIIlIIIIIlI) {
        if (llllllllllllllIlIllllIIIlIIIIIlI.length() == 0) {
            throw new EmitterException("tag must not be empty");
        }
        if ("!".equals(llllllllllllllIlIllllIIIlIIIIIlI)) {
            return llllllllllllllIlIllllIIIlIIIIIlI;
        }
        String llllllllllllllIlIllllIIIlIIIIIIl = null;
        String llllllllllllllIlIllllIIIlIIIIIII = llllllllllllllIlIllllIIIlIIIIIlI;
        for (final String llllllllllllllIlIllllIIIlIIIIlIl : this.tagPrefixes.keySet()) {
            if (llllllllllllllIlIllllIIIlIIIIIlI.startsWith(llllllllllllllIlIllllIIIlIIIIlIl) && ("!".equals(llllllllllllllIlIllllIIIlIIIIlIl) || llllllllllllllIlIllllIIIlIIIIlIl.length() < llllllllllllllIlIllllIIIlIIIIIlI.length())) {
                llllllllllllllIlIllllIIIlIIIIIIl = llllllllllllllIlIllllIIIlIIIIlIl;
            }
        }
        if (llllllllllllllIlIllllIIIlIIIIIIl != null) {
            llllllllllllllIlIllllIIIlIIIIIII = llllllllllllllIlIllllIIIlIIIIIlI.substring(llllllllllllllIlIllllIIIlIIIIIIl.length());
            llllllllllllllIlIllllIIIlIIIIIIl = this.tagPrefixes.get(llllllllllllllIlIllllIIIlIIIIIIl);
        }
        final int llllllllllllllIlIllllIIIIlllllll = llllllllllllllIlIllllIIIlIIIIIII.length();
        final String llllllllllllllIlIllllIIIIllllllI = (llllllllllllllIlIllllIIIIlllllll > 0) ? llllllllllllllIlIllllIIIlIIIIIII.substring(0, llllllllllllllIlIllllIIIIlllllll) : "";
        if (llllllllllllllIlIllllIIIlIIIIIIl != null) {
            return String.valueOf(new StringBuilder().append(llllllllllllllIlIllllIIIlIIIIIIl).append(llllllllllllllIlIllllIIIIllllllI));
        }
        return String.valueOf(new StringBuilder().append("!<").append(llllllllllllllIlIllllIIIIllllllI).append(">"));
    }
    
    private boolean checkSimpleKey() {
        int llllllllllllllIlIllllIIIllIIIlll = 0;
        if (this.event instanceof NodeEvent && ((NodeEvent)this.event).getAnchor() != null) {
            if (this.preparedAnchor == null) {
                this.preparedAnchor = prepareAnchor(((NodeEvent)this.event).getAnchor());
            }
            llllllllllllllIlIllllIIIllIIIlll += this.preparedAnchor.length();
        }
        String llllllllllllllIlIllllIIIllIIIllI = null;
        if (this.event instanceof ScalarEvent) {
            llllllllllllllIlIllllIIIllIIIllI = ((ScalarEvent)this.event).getTag();
        }
        else if (this.event instanceof CollectionStartEvent) {
            llllllllllllllIlIllllIIIllIIIllI = ((CollectionStartEvent)this.event).getTag();
        }
        if (llllllllllllllIlIllllIIIllIIIllI != null) {
            if (this.preparedTag == null) {
                this.preparedTag = this.prepareTag(llllllllllllllIlIllllIIIllIIIllI);
            }
            llllllllllllllIlIllllIIIllIIIlll += this.preparedTag.length();
        }
        if (this.event instanceof ScalarEvent) {
            if (this.analysis == null) {
                this.analysis = this.analyzeScalar(((ScalarEvent)this.event).getValue());
            }
            llllllllllllllIlIllllIIIllIIIlll += this.analysis.getScalar().length();
        }
        return llllllllllllllIlIllllIIIllIIIlll < this.maxSimpleKeyLength && (this.event instanceof AliasEvent || (this.event instanceof ScalarEvent && !this.analysis.isEmpty() && !this.analysis.isMultiline()) || this.checkEmptySequence() || this.checkEmptyMapping());
    }
    
    private void expectBlockMapping() throws IOException {
        this.increaseIndent(false, false);
        this.state = new ExpectFirstBlockMappingKey();
    }
    
    void writeLiteral(final String llllllllllllllIlIlllIllIllIIllll) throws IOException {
        final String llllllllllllllIlIlllIllIllIIllIl = this.determineBlockHints(llllllllllllllIlIlllIllIllIIllll);
        this.writeIndicator(String.valueOf(new StringBuilder().append("|").append(llllllllllllllIlIlllIllIllIIllIl)), true, false, false);
        if (llllllllllllllIlIlllIllIllIIllIl.length() > 0 && llllllllllllllIlIlllIllIllIIllIl.charAt(llllllllllllllIlIlllIllIllIIllIl.length() - 1) == '+') {
            this.openEnded = true;
        }
        this.writeLineBreak(null);
        boolean llllllllllllllIlIlllIllIllIIllII = true;
        int llllllllllllllIlIlllIllIllIIlIlI = 0;
        for (int llllllllllllllIlIlllIllIllIIlIII = 0; llllllllllllllIlIlllIllIllIIlIII <= llllllllllllllIlIlllIllIllIIllll.length(); ++llllllllllllllIlIlllIllIllIIlIII) {
            char llllllllllllllIlIlllIllIllIlIIlI = '\0';
            if (llllllllllllllIlIlllIllIllIIlIII < llllllllllllllIlIlllIllIllIIllll.length()) {
                llllllllllllllIlIlllIllIllIlIIlI = llllllllllllllIlIlllIllIllIIllll.charAt(llllllllllllllIlIlllIllIllIIlIII);
            }
            if (llllllllllllllIlIlllIllIllIIllII) {
                if (llllllllllllllIlIlllIllIllIlIIlI == '\0' || Constant.LINEBR.hasNo(llllllllllllllIlIlllIllIllIlIIlI)) {
                    final String llllllllllllllIlIlllIllIllIlIlII = llllllllllllllIlIlllIllIllIIllll.substring(llllllllllllllIlIlllIllIllIIlIlI, llllllllllllllIlIlllIllIllIIlIII);
                    for (final char llllllllllllllIlIlllIllIllIllIll : llllllllllllllIlIlllIllIllIlIlII.toCharArray()) {
                        if (llllllllllllllIlIlllIllIllIllIll == '\n') {
                            this.writeLineBreak(null);
                        }
                        else {
                            this.writeLineBreak(String.valueOf(llllllllllllllIlIlllIllIllIllIll));
                        }
                    }
                    if (llllllllllllllIlIlllIllIllIlIIlI != '\0') {
                        this.writeIndent();
                    }
                    llllllllllllllIlIlllIllIllIIlIlI = llllllllllllllIlIlllIllIllIIlIII;
                }
            }
            else if (llllllllllllllIlIlllIllIllIlIIlI == '\0' || Constant.LINEBR.has(llllllllllllllIlIlllIllIllIlIIlI)) {
                this.stream.write(llllllllllllllIlIlllIllIllIIllll, llllllllllllllIlIlllIllIllIIlIlI, llllllllllllllIlIlllIllIllIIlIII - llllllllllllllIlIlllIllIllIIlIlI);
                if (llllllllllllllIlIlllIllIllIlIIlI == '\0') {
                    this.writeLineBreak(null);
                }
                llllllllllllllIlIlllIllIllIIlIlI = llllllllllllllIlIlllIllIllIIlIII;
            }
            if (llllllllllllllIlIlllIllIllIlIIlI != '\0') {
                llllllllllllllIlIlllIllIllIIllII = Constant.LINEBR.has(llllllllllllllIlIlllIllIllIlIIlI);
            }
        }
    }
    
    private DumperOptions.ScalarStyle chooseScalarStyle() {
        final ScalarEvent llllllllllllllIlIllllIIIlIlIllII = (ScalarEvent)this.event;
        if (this.analysis == null) {
            this.analysis = this.analyzeScalar(llllllllllllllIlIllllIIIlIlIllII.getValue());
        }
        if ((!llllllllllllllIlIllllIIIlIlIllII.isPlain() && llllllllllllllIlIllllIIIlIlIllII.getScalarStyle() == DumperOptions.ScalarStyle.DOUBLE_QUOTED) || this.canonical) {
            return DumperOptions.ScalarStyle.DOUBLE_QUOTED;
        }
        if (llllllllllllllIlIllllIIIlIlIllII.isPlain() && llllllllllllllIlIllllIIIlIlIllII.getImplicit().canOmitTagInPlainScalar() && (!this.simpleKeyContext || (!this.analysis.isEmpty() && !this.analysis.isMultiline())) && ((this.flowLevel != 0 && this.analysis.isAllowFlowPlain()) || (this.flowLevel == 0 && this.analysis.isAllowBlockPlain()))) {
            return null;
        }
        if (!llllllllllllllIlIllllIIIlIlIllII.isPlain() && (llllllllllllllIlIllllIIIlIlIllII.getScalarStyle() == DumperOptions.ScalarStyle.LITERAL || llllllllllllllIlIllllIIIlIlIllII.getScalarStyle() == DumperOptions.ScalarStyle.FOLDED) && this.flowLevel == 0 && !this.simpleKeyContext && this.analysis.isAllowBlock()) {
            return llllllllllllllIlIllllIIIlIlIllII.getScalarStyle();
        }
        if ((llllllllllllllIlIllllIIIlIlIllII.isPlain() || llllllllllllllIlIllllIIIlIlIllII.getScalarStyle() == DumperOptions.ScalarStyle.SINGLE_QUOTED) && this.analysis.isAllowSingleQuoted() && (!this.simpleKeyContext || !this.analysis.isMultiline())) {
            return DumperOptions.ScalarStyle.SINGLE_QUOTED;
        }
        return DumperOptions.ScalarStyle.DOUBLE_QUOTED;
    }
    
    private class ExpectFlowMappingKey implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter.this.indent = Emitter.this.indents.pop();
                Emitter.this.flowLevel--;
                if (Emitter.this.canonical) {
                    Emitter.this.writeIndicator(",", false, false, false);
                    Emitter.this.writeIndent();
                }
                if (Emitter.this.prettyFlow) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.state = Emitter.this.states.pop();
            }
            else {
                Emitter.this.writeIndicator(",", false, false, false);
                if (Emitter.this.canonical || (Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow) {
                    Emitter.this.writeIndent();
                }
                if (!Emitter.this.canonical && Emitter.this.checkSimpleKey()) {
                    Emitter.this.states.push(new ExpectFlowMappingSimpleValue());
                    Emitter.this.expectNode(false, true, true);
                }
                else {
                    Emitter.this.writeIndicator("?", true, false, false);
                    Emitter.this.states.push(new ExpectFlowMappingValue());
                    Emitter.this.expectNode(false, true, false);
                }
            }
        }
    }
    
    private class ExpectFlowMappingValue implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            if (Emitter.this.canonical || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow) {
                Emitter.this.writeIndent();
            }
            Emitter.this.writeIndicator(":", true, false, false);
            Emitter.this.states.push(new ExpectFlowMappingKey());
            Emitter.this.expectNode(false, true, false);
        }
    }
    
    private class ExpectFlowMappingSimpleValue implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter.this.states.push(new ExpectFlowMappingKey());
            Emitter.this.expectNode(false, true, false);
        }
    }
    
    private class ExpectFirstBlockMappingKey implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            new ExpectBlockMappingKey(true).expect();
        }
    }
    
    private class ExpectBlockMappingKey implements EmitterState
    {
        private final /* synthetic */ boolean first;
        
        public ExpectBlockMappingKey(final boolean lllllllllllllIIlIIIIlllIlIIlllll) {
            this.first = lllllllllllllIIlIIIIlllIlIIlllll;
        }
        
        @Override
        public void expect() throws IOException {
            if (!this.first && Emitter.this.event instanceof MappingEndEvent) {
                Emitter.this.indent = Emitter.this.indents.pop();
                Emitter.this.state = Emitter.this.states.pop();
            }
            else {
                Emitter.this.writeIndent();
                if (Emitter.this.checkSimpleKey()) {
                    Emitter.this.states.push(new ExpectBlockMappingSimpleValue());
                    Emitter.this.expectNode(false, true, true);
                }
                else {
                    Emitter.this.writeIndicator("?", true, false, true);
                    Emitter.this.states.push(new ExpectBlockMappingValue());
                    Emitter.this.expectNode(false, true, false);
                }
            }
        }
    }
    
    private class ExpectBlockMappingValue implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            Emitter.this.writeIndent();
            Emitter.this.writeIndicator(":", true, false, true);
            Emitter.this.states.push(new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
        }
    }
    
    private class ExpectBlockMappingSimpleValue implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter.this.states.push(new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
        }
    }
    
    private class ExpectNothing implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            throw new EmitterException(String.valueOf(new StringBuilder().append("expecting nothing, but got ").append(Emitter.this.event)));
        }
    }
    
    private class ExpectDocumentRoot implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            Emitter.this.states.push(new ExpectDocumentEnd());
            Emitter.this.expectNode(true, false, false);
        }
    }
    
    private class ExpectDocumentEnd implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            if (Emitter.this.event instanceof DocumentEndEvent) {
                Emitter.this.writeIndent();
                if (((DocumentEndEvent)Emitter.this.event).getExplicit()) {
                    Emitter.this.writeIndicator("...", true, false, false);
                    Emitter.this.writeIndent();
                }
                Emitter.this.flushStream();
                Emitter.this.state = new ExpectDocumentStart(false);
                return;
            }
            throw new EmitterException(String.valueOf(new StringBuilder().append("expected DocumentEndEvent, but got ").append(Emitter.this.event)));
        }
    }
    
    private class ExpectDocumentStart implements EmitterState
    {
        private final /* synthetic */ boolean first;
        
        @Override
        public void expect() throws IOException {
            if (Emitter.this.event instanceof DocumentStartEvent) {
                final DocumentStartEvent lllllllllllllIlIIIllIIlllIIIllII = (DocumentStartEvent)Emitter.this.event;
                if ((lllllllllllllIlIIIllIIlllIIIllII.getVersion() != null || lllllllllllllIlIIIllIIlllIIIllII.getTags() != null) && Emitter.this.openEnded) {
                    Emitter.this.writeIndicator("...", true, false, false);
                    Emitter.this.writeIndent();
                }
                if (lllllllllllllIlIIIllIIlllIIIllII.getVersion() != null) {
                    final String lllllllllllllIlIIIllIIlllIIlIllI = Emitter.this.prepareVersion(lllllllllllllIlIIIllIIlllIIIllII.getVersion());
                    Emitter.this.writeVersionDirective(lllllllllllllIlIIIllIIlllIIlIllI);
                }
                Emitter.this.tagPrefixes = (Map<String, String>)new LinkedHashMap(Emitter.DEFAULT_TAG_PREFIXES);
                if (lllllllllllllIlIIIllIIlllIIIllII.getTags() != null) {
                    final Set<String> lllllllllllllIlIIIllIIlllIIIllIl = new TreeSet<String>(lllllllllllllIlIIIllIIlllIIIllII.getTags().keySet());
                    for (final String lllllllllllllIlIIIllIIlllIIlIIIl : lllllllllllllIlIIIllIIlllIIIllIl) {
                        final String lllllllllllllIlIIIllIIlllIIlIlIl = lllllllllllllIlIIIllIIlllIIIllII.getTags().get(lllllllllllllIlIIIllIIlllIIlIIIl);
                        Emitter.this.tagPrefixes.put(lllllllllllllIlIIIllIIlllIIlIlIl, lllllllllllllIlIIIllIIlllIIlIIIl);
                        final String lllllllllllllIlIIIllIIlllIIlIlII = Emitter.this.prepareTagHandle(lllllllllllllIlIIIllIIlllIIlIIIl);
                        final String lllllllllllllIlIIIllIIlllIIlIIlI = Emitter.this.prepareTagPrefix(lllllllllllllIlIIIllIIlllIIlIlIl);
                        Emitter.this.writeTagDirective(lllllllllllllIlIIIllIIlllIIlIlII, lllllllllllllIlIIIllIIlllIIlIIlI);
                    }
                }
                final boolean lllllllllllllIlIIIllIIlllIIIlIlI = this.first && !lllllllllllllIlIIIllIIlllIIIllII.getExplicit() && !Emitter.this.canonical && lllllllllllllIlIIIllIIlllIIIllII.getVersion() == null && (lllllllllllllIlIIIllIIlllIIIllII.getTags() == null || lllllllllllllIlIIIllIIlllIIIllII.getTags().isEmpty()) && !Emitter.this.checkEmptyDocument();
                if (!lllllllllllllIlIIIllIIlllIIIlIlI) {
                    Emitter.this.writeIndent();
                    Emitter.this.writeIndicator("---", true, false, false);
                    if (Emitter.this.canonical) {
                        Emitter.this.writeIndent();
                    }
                }
                Emitter.this.state = new ExpectDocumentRoot();
            }
            else {
                if (!(Emitter.this.event instanceof StreamEndEvent)) {
                    throw new EmitterException(String.valueOf(new StringBuilder().append("expected DocumentStartEvent, but got ").append(Emitter.this.event)));
                }
                Emitter.this.writeStreamEnd();
                Emitter.this.state = new ExpectNothing();
            }
        }
        
        public ExpectDocumentStart(final boolean lllllllllllllIlIIIllIIlllIlIIIlI) {
            this.first = lllllllllllllIlIIIllIIlllIlIIIlI;
        }
    }
    
    private class ExpectStreamStart implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            if (Emitter.this.event instanceof StreamStartEvent) {
                Emitter.this.writeStreamStart();
                Emitter.this.state = new ExpectFirstDocumentStart();
                return;
            }
            throw new EmitterException(String.valueOf(new StringBuilder().append("expected StreamStartEvent, but got ").append(Emitter.this.event)));
        }
    }
    
    private class ExpectFirstDocumentStart implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            new ExpectDocumentStart(true).expect();
        }
    }
    
    private class ExpectBlockSequenceItem implements EmitterState
    {
        private final /* synthetic */ boolean first;
        
        public ExpectBlockSequenceItem(final boolean lllllllllllllIlIIIIlIIIIlIIlIIlI) {
            this.first = lllllllllllllIlIIIIlIIIIlIIlIIlI;
        }
        
        @Override
        public void expect() throws IOException {
            if (!this.first && Emitter.this.event instanceof SequenceEndEvent) {
                Emitter.this.indent = Emitter.this.indents.pop();
                Emitter.this.state = Emitter.this.states.pop();
            }
            else {
                Emitter.this.writeIndent();
                if (!Emitter.this.indentWithIndicator || this.first) {
                    Emitter.this.writeWhitespace(Emitter.this.indicatorIndent);
                }
                Emitter.this.writeIndicator("-", true, false, true);
                if (Emitter.this.indentWithIndicator && this.first) {
                    Emitter.this.indent += Emitter.this.indicatorIndent;
                }
                Emitter.this.states.push(new ExpectBlockSequenceItem(false));
                Emitter.this.expectNode(false, false, false);
            }
        }
    }
    
    private class ExpectFirstFlowSequenceItem implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            if (Emitter.this.event instanceof SequenceEndEvent) {
                Emitter.this.indent = Emitter.this.indents.pop();
                Emitter.this.flowLevel--;
                Emitter.this.writeIndicator("]", false, false, false);
                Emitter.this.state = Emitter.this.states.pop();
            }
            else {
                if (Emitter.this.canonical || (Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.states.push(new ExpectFlowSequenceItem());
                Emitter.this.expectNode(false, false, false);
            }
        }
    }
    
    private class ExpectFlowSequenceItem implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            if (Emitter.this.event instanceof SequenceEndEvent) {
                Emitter.this.indent = Emitter.this.indents.pop();
                Emitter.this.flowLevel--;
                if (Emitter.this.canonical) {
                    Emitter.this.writeIndicator(",", false, false, false);
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("]", false, false, false);
                if (Emitter.this.prettyFlow) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.state = Emitter.this.states.pop();
            }
            else {
                Emitter.this.writeIndicator(",", false, false, false);
                if (Emitter.this.canonical || (Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.states.push(new ExpectFlowSequenceItem());
                Emitter.this.expectNode(false, false, false);
            }
        }
    }
    
    private class ExpectFirstFlowMappingKey implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter.this.indent = Emitter.this.indents.pop();
                Emitter.this.flowLevel--;
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.state = Emitter.this.states.pop();
            }
            else {
                if (Emitter.this.canonical || (Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow) {
                    Emitter.this.writeIndent();
                }
                if (!Emitter.this.canonical && Emitter.this.checkSimpleKey()) {
                    Emitter.this.states.push(new ExpectFlowMappingSimpleValue());
                    Emitter.this.expectNode(false, true, true);
                }
                else {
                    Emitter.this.writeIndicator("?", true, false, false);
                    Emitter.this.states.push(new ExpectFlowMappingValue());
                    Emitter.this.expectNode(false, true, false);
                }
            }
        }
    }
    
    private class ExpectFirstBlockSequenceItem implements EmitterState
    {
        @Override
        public void expect() throws IOException {
            new ExpectBlockSequenceItem(true).expect();
        }
    }
}
