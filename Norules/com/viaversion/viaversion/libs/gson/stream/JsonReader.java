package com.viaversion.viaversion.libs.gson.stream;

import java.io.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import com.viaversion.viaversion.libs.gson.internal.bind.*;
import java.util.*;

public class JsonReader implements Closeable
{
    private /* synthetic */ String[] pathNames;
    private final /* synthetic */ Reader in;
    private /* synthetic */ String peekedString;
    private /* synthetic */ int lineStart;
    private /* synthetic */ int[] pathIndices;
    private /* synthetic */ int stackSize;
    private /* synthetic */ int limit;
    private /* synthetic */ int pos;
    private final /* synthetic */ char[] buffer;
    private /* synthetic */ boolean lenient;
    /* synthetic */ int peeked;
    private /* synthetic */ int[] stack;
    private /* synthetic */ int peekedNumberLength;
    private /* synthetic */ long peekedLong;
    private /* synthetic */ int lineNumber;
    
    private int peekKeyword() throws IOException {
        char lIlIIlIlIIlll = this.buffer[this.pos];
        if (lIlIIlIlIIlll == 't' || lIlIIlIlIIlll == 'T') {
            final String lIlIIlIllIIlI = "true";
            final String lIlIIlIllIIIl = "TRUE";
            final int lIlIIlIllIIII = 5;
        }
        else if (lIlIIlIlIIlll == 'f' || lIlIIlIlIIlll == 'F') {
            final String lIlIIlIlIllll = "false";
            final String lIlIIlIlIlllI = "FALSE";
            final int lIlIIlIlIllIl = 6;
        }
        else {
            if (lIlIIlIlIIlll != 'n' && lIlIIlIlIIlll != 'N') {
                return 0;
            }
            final String lIlIIlIlIllII = "null";
            final String lIlIIlIlIlIll = "NULL";
            final int lIlIIlIlIlIlI = 7;
        }
        final String lIlIIlIlIIllI;
        final int lIlIIlIlIIIll = lIlIIlIlIIllI.length();
        for (int lIlIIlIlIlIIl = 1; lIlIIlIlIlIIl < lIlIIlIlIIIll; ++lIlIIlIlIlIIl) {
            if (this.pos + lIlIIlIlIlIIl >= this.limit && !this.fillBuffer(lIlIIlIlIlIIl + 1)) {
                return 0;
            }
            lIlIIlIlIIlll = this.buffer[this.pos + lIlIIlIlIlIIl];
            final String lIlIIlIlIIlIl;
            if (lIlIIlIlIIlll != lIlIIlIlIIllI.charAt(lIlIIlIlIlIIl) && lIlIIlIlIIlll != lIlIIlIlIIlIl.charAt(lIlIIlIlIlIIl)) {
                return 0;
            }
        }
        if ((this.pos + lIlIIlIlIIIll < this.limit || this.fillBuffer(lIlIIlIlIIIll + 1)) && this.isLiteral(this.buffer[this.pos + lIlIIlIlIIIll])) {
            return 0;
        }
        this.pos += lIlIIlIlIIIll;
        final int lIlIIlIlIIlII;
        final int peeked = lIlIIlIlIIlII;
        this.peeked = peeked;
        return peeked;
    }
    
    private int nextNonWhitespace(final boolean lIIlllIllIlII) throws IOException {
        final char[] lIIlllIlllIII = this.buffer;
        int lIIlllIllIlll = this.pos;
        int lIIlllIllIllI = this.limit;
        while (true) {
            if (lIIlllIllIlll == lIIlllIllIllI) {
                this.pos = lIIlllIllIlll;
                if (!this.fillBuffer(1)) {
                    if (lIIlllIllIlII) {
                        throw new EOFException(String.valueOf(new StringBuilder().append("End of input").append(this.locationString())));
                    }
                    return -1;
                }
                else {
                    lIIlllIllIlll = this.pos;
                    lIIlllIllIllI = this.limit;
                }
            }
            final int lIIlllIlllIll = lIIlllIlllIII[lIIlllIllIlll++];
            if (lIIlllIlllIll == 10) {
                ++this.lineNumber;
                this.lineStart = lIIlllIllIlll;
            }
            else {
                if (lIIlllIlllIll == 32 || lIIlllIlllIll == 13) {
                    continue;
                }
                if (lIIlllIlllIll == 9) {
                    continue;
                }
                if (lIIlllIlllIll == 47) {
                    if ((this.pos = lIIlllIllIlll) == lIIlllIllIllI) {
                        --this.pos;
                        final boolean lIIlllIllllIl = this.fillBuffer(2);
                        ++this.pos;
                        if (!lIIlllIllllIl) {
                            return lIIlllIlllIll;
                        }
                    }
                    this.checkLenient();
                    final char lIIlllIllllII = lIIlllIlllIII[this.pos];
                    switch (lIIlllIllllII) {
                        case '*': {
                            ++this.pos;
                            if (!this.skipTo("*/")) {
                                throw this.syntaxError("Unterminated comment");
                            }
                            lIIlllIllIlll = this.pos + 2;
                            lIIlllIllIllI = this.limit;
                            continue;
                        }
                        case '/': {
                            ++this.pos;
                            this.skipToEndOfLine();
                            lIIlllIllIlll = this.pos;
                            lIIlllIllIllI = this.limit;
                            continue;
                        }
                        default: {
                            return lIIlllIlllIll;
                        }
                    }
                }
                else {
                    if (lIIlllIlllIll != 35) {
                        this.pos = lIIlllIllIlll;
                        return lIIlllIlllIll;
                    }
                    this.pos = lIIlllIllIlll;
                    this.checkLenient();
                    this.skipToEndOfLine();
                    lIIlllIllIlll = this.pos;
                    lIIlllIllIllI = this.limit;
                }
            }
        }
    }
    
    private boolean skipTo(final String lIIlllIIlllII) throws IOException {
        final int lIIlllIIllllI = lIIlllIIlllII.length();
        while (this.pos + lIIlllIIllllI <= this.limit || this.fillBuffer(lIIlllIIllllI)) {
            Label_0100: {
                if (this.buffer[this.pos] != '\n') {
                    for (int lIIlllIlIIIIl = 0; lIIlllIlIIIIl < lIIlllIIllllI; ++lIIlllIlIIIIl) {
                        if (this.buffer[this.pos + lIIlllIlIIIIl] != lIIlllIIlllII.charAt(lIIlllIlIIIIl)) {
                            break Label_0100;
                        }
                    }
                    return true;
                }
                ++this.lineNumber;
                this.lineStart = this.pos + 1;
            }
            ++this.pos;
        }
        return false;
    }
    
    public String nextName() throws IOException {
        int lIlIIIllIllIl = this.peeked;
        if (lIlIIIllIllIl == 0) {
            lIlIIIllIllIl = this.doPeek();
        }
        if (lIlIIIllIllIl == 14) {
            final String lIlIIIlllIIIl = this.nextUnquotedValue();
        }
        else if (lIlIIIllIllIl == 12) {
            final String lIlIIIlllIIII = this.nextQuotedValue('\'');
        }
        else {
            if (lIlIIIllIllIl != 13) {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected a name but was ").append(this.peek()).append(this.locationString())));
            }
            final String lIlIIIllIllll = this.nextQuotedValue('\"');
        }
        this.peeked = 0;
        final String lIlIIIllIllII;
        return this.pathNames[this.stackSize - 1] = lIlIIIllIllII;
    }
    
    public JsonReader(final Reader lIlIIlllllIlI) {
        this.lenient = false;
        this.buffer = new char[1024];
        this.pos = 0;
        this.limit = 0;
        this.lineNumber = 0;
        this.lineStart = 0;
        this.peeked = 0;
        this.stack = new int[32];
        this.stackSize = 0;
        this.stack[this.stackSize++] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (lIlIIlllllIlI == null) {
            throw new NullPointerException("in == null");
        }
        this.in = lIlIIlllllIlI;
    }
    
    private void skipToEndOfLine() throws IOException {
        while (this.pos < this.limit || this.fillBuffer(1)) {
            final char lIIlllIlIlIIl = this.buffer[this.pos++];
            if (lIIlllIlIlIIl == '\n') {
                ++this.lineNumber;
                this.lineStart = this.pos;
                break;
            }
            if (lIIlllIlIlIIl == '\r') {
                break;
            }
        }
    }
    
    public void endArray() throws IOException {
        int lIlIIlllIIlIl = this.peeked;
        if (lIlIIlllIIlIl == 0) {
            lIlIIlllIIlIl = this.doPeek();
        }
        if (lIlIIlllIIlIl == 4) {
            --this.stackSize;
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected END_ARRAY but was ").append(this.peek()).append(this.locationString())));
    }
    
    public void nextNull() throws IOException {
        int lIlIIIlIlIIII = this.peeked;
        if (lIlIIIlIlIIII == 0) {
            lIlIIIlIlIIII = this.doPeek();
        }
        if (lIlIIIlIlIIII == 7) {
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
            return;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected null but was ").append(this.peek()).append(this.locationString())));
    }
    
    public double nextDouble() throws IOException {
        int lIlIIIlIIlIIl = this.peeked;
        if (lIlIIIlIIlIIl == 0) {
            lIlIIIlIIlIIl = this.doPeek();
        }
        if (lIlIIIlIIlIIl == 15) {
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
            return (double)this.peekedLong;
        }
        if (lIlIIIlIIlIIl == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        else if (lIlIIIlIIlIIl == 8 || lIlIIIlIIlIIl == 9) {
            this.peekedString = this.nextQuotedValue((lIlIIIlIIlIIl == 8) ? '\'' : '\"');
        }
        else if (lIlIIIlIIlIIl == 10) {
            this.peekedString = this.nextUnquotedValue();
        }
        else if (lIlIIIlIIlIIl != 11) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected a double but was ").append(this.peek()).append(this.locationString())));
        }
        this.peeked = 11;
        final double lIlIIIlIIlIII = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(lIlIIIlIIlIII) || Double.isInfinite(lIlIIIlIIlIII))) {
            throw new MalformedJsonException(String.valueOf(new StringBuilder().append("JSON forbids NaN and infinities: ").append(lIlIIIlIIlIII).append(this.locationString())));
        }
        this.peekedString = null;
        this.peeked = 0;
        final int[] pathIndices2 = this.pathIndices;
        final int n2 = this.stackSize - 1;
        ++pathIndices2[n2];
        return lIlIIIlIIlIII;
    }
    
    String locationString() {
        final int lIIlllIIlIIlI = this.lineNumber + 1;
        final int lIIlllIIlIIIl = this.pos - this.lineStart + 1;
        return String.valueOf(new StringBuilder().append(" at line ").append(lIIlllIIlIIlI).append(" column ").append(lIIlllIIlIIIl).append(" path ").append(this.getPath()));
    }
    
    public long nextLong() throws IOException {
        int lIlIIIIlllllI = this.peeked;
        if (lIlIIIIlllllI == 0) {
            lIlIIIIlllllI = this.doPeek();
        }
        if (lIlIIIIlllllI == 15) {
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
            return this.peekedLong;
        }
        Label_0218: {
            if (lIlIIIIlllllI != 16) {
                if (lIlIIIIlllllI == 8 || lIlIIIIlllllI == 9 || lIlIIIIlllllI == 10) {
                    if (lIlIIIIlllllI == 10) {
                        this.peekedString = this.nextUnquotedValue();
                    }
                    else {
                        this.peekedString = this.nextQuotedValue((lIlIIIIlllllI == 8) ? '\'' : '\"');
                    }
                    try {
                        final long lIlIIIlIIIIII = Long.parseLong(this.peekedString);
                        this.peeked = 0;
                        final int[] pathIndices2 = this.pathIndices;
                        final int n2 = this.stackSize - 1;
                        ++pathIndices2[n2];
                        return lIlIIIlIIIIII;
                    }
                    catch (NumberFormatException ex) {
                        break Label_0218;
                    }
                }
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected a long but was ").append(this.peek()).append(this.locationString())));
            }
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.peeked = 11;
        final double lIlIIIIllllIl = Double.parseDouble(this.peekedString);
        final long lIlIIIIllllII = (long)lIlIIIIllllIl;
        if (lIlIIIIllllII != lIlIIIIllllIl) {
            throw new NumberFormatException(String.valueOf(new StringBuilder().append("Expected a long but was ").append(this.peekedString).append(this.locationString())));
        }
        this.peekedString = null;
        this.peeked = 0;
        final int[] pathIndices3 = this.pathIndices;
        final int n3 = this.stackSize - 1;
        ++pathIndices3[n3];
        return lIlIIIIllllII;
    }
    
    private boolean isLiteral(final char lIlIIIlllIlll) throws IOException {
        switch (lIlIIIlllIlll) {
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\': {
                this.checkLenient();
            }
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}': {
                return false;
            }
            default: {
                return true;
            }
        }
    }
    
    @Override
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }
    
    private int peekNumber() throws IOException {
        final char[] lIlIIlIIIllIl = this.buffer;
        int lIlIIlIIIllII = this.pos;
        int lIlIIlIIIlIll = this.limit;
        long lIlIIlIIIlIlI = 0L;
        boolean lIlIIlIIIlIIl = false;
        boolean lIlIIlIIIlIII = true;
        int lIlIIlIIIIlll = 0;
        int lIlIIlIIIIllI = 0;
    Label_0372:
        while (true) {
            if (lIlIIlIIIllII + lIlIIlIIIIllI == lIlIIlIIIlIll) {
                if (lIlIIlIIIIllI == lIlIIlIIIllIl.length) {
                    return 0;
                }
                if (!this.fillBuffer(lIlIIlIIIIllI + 1)) {
                    break;
                }
                lIlIIlIIIllII = this.pos;
                lIlIIlIIIlIll = this.limit;
            }
            final char lIlIIlIIIllll = lIlIIlIIIllIl[lIlIIlIIIllII + lIlIIlIIIIllI];
            switch (lIlIIlIIIllll) {
                case '-': {
                    if (lIlIIlIIIIlll == 0) {
                        lIlIIlIIIlIIl = true;
                        lIlIIlIIIIlll = 1;
                        break;
                    }
                    if (lIlIIlIIIIlll == 5) {
                        lIlIIlIIIIlll = 6;
                        break;
                    }
                    return 0;
                }
                case '+': {
                    if (lIlIIlIIIIlll == 5) {
                        lIlIIlIIIIlll = 6;
                        break;
                    }
                    return 0;
                }
                case 'E':
                case 'e': {
                    if (lIlIIlIIIIlll == 2 || lIlIIlIIIIlll == 4) {
                        lIlIIlIIIIlll = 5;
                        break;
                    }
                    return 0;
                }
                case '.': {
                    if (lIlIIlIIIIlll == 2) {
                        lIlIIlIIIIlll = 3;
                        break;
                    }
                    return 0;
                }
                default: {
                    if (lIlIIlIIIllll < '0' || lIlIIlIIIllll > '9') {
                        if (!this.isLiteral(lIlIIlIIIllll)) {
                            break Label_0372;
                        }
                        return 0;
                    }
                    else {
                        if (lIlIIlIIIIlll == 1 || lIlIIlIIIIlll == 0) {
                            lIlIIlIIIlIlI = -(lIlIIlIIIllll - '0');
                            lIlIIlIIIIlll = 2;
                            break;
                        }
                        if (lIlIIlIIIIlll == 2) {
                            if (lIlIIlIIIlIlI == 0L) {
                                return 0;
                            }
                            final long lIlIIlIIlIIII = lIlIIlIIIlIlI * 10L - (lIlIIlIIIllll - '0');
                            lIlIIlIIIlIII &= (lIlIIlIIIlIlI > -922337203685477580L || (lIlIIlIIIlIlI == -922337203685477580L && lIlIIlIIlIIII < lIlIIlIIIlIlI));
                            lIlIIlIIIlIlI = lIlIIlIIlIIII;
                            break;
                        }
                        else {
                            if (lIlIIlIIIIlll == 3) {
                                lIlIIlIIIIlll = 4;
                                break;
                            }
                            if (lIlIIlIIIIlll == 5 || lIlIIlIIIIlll == 6) {
                                lIlIIlIIIIlll = 7;
                                break;
                            }
                            break;
                        }
                    }
                    break;
                }
            }
            ++lIlIIlIIIIllI;
        }
        if (lIlIIlIIIIlll == 2 && lIlIIlIIIlIII && (lIlIIlIIIlIlI != Long.MIN_VALUE || lIlIIlIIIlIIl) && (lIlIIlIIIlIlI != 0L || !lIlIIlIIIlIIl)) {
            this.peekedLong = (lIlIIlIIIlIIl ? lIlIIlIIIlIlI : (-lIlIIlIIIlIlI));
            this.pos += lIlIIlIIIIllI;
            final int peeked = 15;
            this.peeked = peeked;
            return peeked;
        }
        if (lIlIIlIIIIlll == 2 || lIlIIlIIIIlll == 4 || lIlIIlIIIIlll == 7) {
            this.peekedNumberLength = lIlIIlIIIIllI;
            final int peeked2 = 16;
            this.peeked = peeked2;
            return peeked2;
        }
        return 0;
    }
    
    public final void setLenient(final boolean lIlIIllllIlII) {
        this.lenient = lIlIIllllIlII;
    }
    
    public boolean hasNext() throws IOException {
        int lIlIIllIlIIll = this.peeked;
        if (lIlIIllIlIIll == 0) {
            lIlIIllIlIIll = this.doPeek();
        }
        return lIlIIllIlIIll != 2 && lIlIIllIlIIll != 4;
    }
    
    public final boolean isLenient() {
        return this.lenient;
    }
    
    int doPeek() throws IOException {
        final int lIlIIllIIIIII = this.stack[this.stackSize - 1];
        if (lIlIIllIIIIII == 1) {
            this.stack[this.stackSize - 1] = 2;
        }
        else if (lIlIIllIIIIII == 2) {
            final int lIlIIllIIIllI = this.nextNonWhitespace(true);
            switch (lIlIIllIIIllI) {
                case 93: {
                    final int peeked = 4;
                    this.peeked = peeked;
                    return peeked;
                }
                case 59: {
                    this.checkLenient();
                }
                case 44: {
                    break;
                }
                default: {
                    throw this.syntaxError("Unterminated array");
                }
            }
        }
        else if (lIlIIllIIIIII == 3 || lIlIIllIIIIII == 5) {
            this.stack[this.stackSize - 1] = 4;
            if (lIlIIllIIIIII == 5) {
                final int lIlIIllIIIlIl = this.nextNonWhitespace(true);
                switch (lIlIIllIIIlIl) {
                    case 125: {
                        final int peeked2 = 2;
                        this.peeked = peeked2;
                        return peeked2;
                    }
                    case 59: {
                        this.checkLenient();
                    }
                    case 44: {
                        break;
                    }
                    default: {
                        throw this.syntaxError("Unterminated object");
                    }
                }
            }
            final int lIlIIllIIIlII = this.nextNonWhitespace(true);
            switch (lIlIIllIIIlII) {
                case 34: {
                    final int peeked3 = 13;
                    this.peeked = peeked3;
                    return peeked3;
                }
                case 39: {
                    this.checkLenient();
                    final int peeked4 = 12;
                    this.peeked = peeked4;
                    return peeked4;
                }
                case 125: {
                    if (lIlIIllIIIIII != 5) {
                        final int peeked5 = 2;
                        this.peeked = peeked5;
                        return peeked5;
                    }
                    throw this.syntaxError("Expected name");
                }
                default: {
                    this.checkLenient();
                    --this.pos;
                    if (this.isLiteral((char)lIlIIllIIIlII)) {
                        final int peeked6 = 14;
                        this.peeked = peeked6;
                        return peeked6;
                    }
                    throw this.syntaxError("Expected name");
                }
            }
        }
        else if (lIlIIllIIIIII == 4) {
            this.stack[this.stackSize - 1] = 5;
            final int lIlIIllIIIIll = this.nextNonWhitespace(true);
            switch (lIlIIllIIIIll) {
                case 58: {
                    break;
                }
                case 61: {
                    this.checkLenient();
                    if ((this.pos < this.limit || this.fillBuffer(1)) && this.buffer[this.pos] == '>') {
                        ++this.pos;
                        break;
                    }
                    break;
                }
                default: {
                    throw this.syntaxError("Expected ':'");
                }
            }
        }
        else if (lIlIIllIIIIII == 6) {
            if (this.lenient) {
                this.consumeNonExecutePrefix();
            }
            this.stack[this.stackSize - 1] = 7;
        }
        else if (lIlIIllIIIIII == 7) {
            final int lIlIIllIIIIlI = this.nextNonWhitespace(false);
            if (lIlIIllIIIIlI == -1) {
                final int peeked7 = 17;
                this.peeked = peeked7;
                return peeked7;
            }
            this.checkLenient();
            --this.pos;
        }
        else if (lIlIIllIIIIII == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        final int lIlIIlIllllll = this.nextNonWhitespace(true);
        switch (lIlIIlIllllll) {
            case 93: {
                if (lIlIIllIIIIII == 1) {
                    final int peeked8 = 4;
                    this.peeked = peeked8;
                    return peeked8;
                }
            }
            case 44:
            case 59: {
                if (lIlIIllIIIIII == 1 || lIlIIllIIIIII == 2) {
                    this.checkLenient();
                    --this.pos;
                    final int peeked9 = 7;
                    this.peeked = peeked9;
                    return peeked9;
                }
                throw this.syntaxError("Unexpected value");
            }
            case 39: {
                this.checkLenient();
                final int peeked10 = 8;
                this.peeked = peeked10;
                return peeked10;
            }
            case 34: {
                final int peeked11 = 9;
                this.peeked = peeked11;
                return peeked11;
            }
            case 91: {
                final int peeked12 = 3;
                this.peeked = peeked12;
                return peeked12;
            }
            case 123: {
                final int peeked13 = 1;
                this.peeked = peeked13;
                return peeked13;
            }
            default: {
                --this.pos;
                int lIlIIlIlllllI = this.peekKeyword();
                if (lIlIIlIlllllI != 0) {
                    return lIlIIlIlllllI;
                }
                lIlIIlIlllllI = this.peekNumber();
                if (lIlIIlIlllllI != 0) {
                    return lIlIIlIlllllI;
                }
                if (!this.isLiteral(this.buffer[this.pos])) {
                    throw this.syntaxError("Expected value");
                }
                this.checkLenient();
                final int peeked14 = 10;
                this.peeked = peeked14;
                return peeked14;
            }
        }
    }
    
    public boolean nextBoolean() throws IOException {
        int lIlIIIlIlIllI = this.peeked;
        if (lIlIIIlIlIllI == 0) {
            lIlIIIlIlIllI = this.doPeek();
        }
        if (lIlIIIlIlIllI == 5) {
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
            return true;
        }
        if (lIlIIIlIlIllI == 6) {
            this.peeked = 0;
            final int[] pathIndices2 = this.pathIndices;
            final int n2 = this.stackSize - 1;
            ++pathIndices2[n2];
            return false;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected a boolean but was ").append(this.peek()).append(this.locationString())));
    }
    
    private void skipUnquotedValue() throws IOException {
        do {
            int lIIllllllIlll = 0;
            while (this.pos + lIIllllllIlll < this.limit) {
                switch (this.buffer[this.pos + lIIllllllIlll]) {
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\': {
                        this.checkLenient();
                    }
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}': {
                        this.pos += lIIllllllIlll;
                        return;
                    }
                    default: {
                        ++lIIllllllIlll;
                        continue;
                    }
                }
            }
            this.pos += lIIllllllIlll;
        } while (this.fillBuffer(1));
    }
    
    public JsonToken peek() throws IOException {
        int lIlIIllIIllIl = this.peeked;
        if (lIlIIllIIllIl == 0) {
            lIlIIllIIllIl = this.doPeek();
        }
        switch (lIlIIllIIllIl) {
            case 1: {
                return JsonToken.BEGIN_OBJECT;
            }
            case 2: {
                return JsonToken.END_OBJECT;
            }
            case 3: {
                return JsonToken.BEGIN_ARRAY;
            }
            case 4: {
                return JsonToken.END_ARRAY;
            }
            case 12:
            case 13:
            case 14: {
                return JsonToken.NAME;
            }
            case 5:
            case 6: {
                return JsonToken.BOOLEAN;
            }
            case 7: {
                return JsonToken.NULL;
            }
            case 8:
            case 9:
            case 10:
            case 11: {
                return JsonToken.STRING;
            }
            case 15:
            case 16: {
                return JsonToken.NUMBER;
            }
            case 17: {
                return JsonToken.END_DOCUMENT;
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    public void endObject() throws IOException {
        int lIlIIllIllIIl = this.peeked;
        if (lIlIIllIllIIl == 0) {
            lIlIIllIllIIl = this.doPeek();
        }
        if (lIlIIllIllIIl == 2) {
            --this.stackSize;
            this.pathNames[this.stackSize] = null;
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected END_OBJECT but was ").append(this.peek()).append(this.locationString())));
    }
    
    private char readEscapeCharacter() throws IOException {
        if (this.pos == this.limit && !this.fillBuffer(1)) {
            throw this.syntaxError("Unterminated escape sequence");
        }
        final char lIIllIlllIllI = this.buffer[this.pos++];
        switch (lIIllIlllIllI) {
            case 'u': {
                if (this.pos + 4 > this.limit && !this.fillBuffer(4)) {
                    throw this.syntaxError("Unterminated escape sequence");
                }
                char lIIllIllllIII = '\0';
                for (int lIIllIllllIlI = this.pos, lIIllIllllIIl = lIIllIllllIlI + 4; lIIllIllllIlI < lIIllIllllIIl; ++lIIllIllllIlI) {
                    final char lIIllIllllIll = this.buffer[lIIllIllllIlI];
                    lIIllIllllIII <<= 4;
                    if (lIIllIllllIll >= '0' && lIIllIllllIll <= '9') {
                        lIIllIllllIII += (char)(lIIllIllllIll - '0');
                    }
                    else if (lIIllIllllIll >= 'a' && lIIllIllllIll <= 'f') {
                        lIIllIllllIII += (char)(lIIllIllllIll - 'a' + 10);
                    }
                    else {
                        if (lIIllIllllIll < 'A' || lIIllIllllIll > 'F') {
                            throw new NumberFormatException(String.valueOf(new StringBuilder().append("\\u").append(new String(this.buffer, this.pos, 4))));
                        }
                        lIIllIllllIII += (char)(lIIllIllllIll - 'A' + 10);
                    }
                }
                this.pos += 4;
                return lIIllIllllIII;
            }
            case 't': {
                return '\t';
            }
            case 'b': {
                return '\b';
            }
            case 'n': {
                return '\n';
            }
            case 'r': {
                return '\r';
            }
            case 'f': {
                return '\f';
            }
            case '\n': {
                ++this.lineNumber;
                this.lineStart = this.pos;
            }
            case '\"':
            case '\'':
            case '/':
            case '\\': {
                return lIIllIlllIllI;
            }
            default: {
                throw this.syntaxError("Invalid escape sequence");
            }
        }
    }
    
    public void beginArray() throws IOException {
        int lIlIIlllIlIll = this.peeked;
        if (lIlIIlllIlIll == 0) {
            lIlIIlllIlIll = this.doPeek();
        }
        if (lIlIIlllIlIll == 3) {
            this.push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected BEGIN_ARRAY but was ").append(this.peek()).append(this.locationString())));
    }
    
    private void consumeNonExecutePrefix() throws IOException {
        this.nextNonWhitespace(true);
        --this.pos;
        final int lIIllIllIIlIl = this.pos;
        if (lIIllIllIIlIl + 5 > this.limit && !this.fillBuffer(5)) {
            return;
        }
        final char[] lIIllIllIIlII = this.buffer;
        if (lIIllIllIIlII[lIIllIllIIlIl] != ')' || lIIllIllIIlII[lIIllIllIIlIl + 1] != ']' || lIIllIllIIlII[lIIllIllIIlIl + 2] != '}' || lIIllIllIIlII[lIIllIllIIlIl + 3] != '\'' || lIIllIllIIlII[lIIllIllIIlIl + 4] != '\n') {
            return;
        }
        this.pos += 5;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.getClass().getSimpleName()).append(this.locationString()));
    }
    
    public void skipValue() throws IOException {
        int lIIllllIlllIl = 0;
        do {
            int lIIllllIlllll = this.peeked;
            if (lIIllllIlllll == 0) {
                lIIllllIlllll = this.doPeek();
            }
            if (lIIllllIlllll == 3) {
                this.push(1);
                ++lIIllllIlllIl;
            }
            else if (lIIllllIlllll == 1) {
                this.push(3);
                ++lIIllllIlllIl;
            }
            else if (lIIllllIlllll == 4) {
                --this.stackSize;
                --lIIllllIlllIl;
            }
            else if (lIIllllIlllll == 2) {
                --this.stackSize;
                --lIIllllIlllIl;
            }
            else if (lIIllllIlllll == 14 || lIIllllIlllll == 10) {
                this.skipUnquotedValue();
            }
            else if (lIIllllIlllll == 8 || lIIllllIlllll == 12) {
                this.skipQuotedValue('\'');
            }
            else if (lIIllllIlllll == 9 || lIIllllIlllll == 13) {
                this.skipQuotedValue('\"');
            }
            else if (lIIllllIlllll == 16) {
                this.pos += this.peekedNumberLength;
            }
            this.peeked = 0;
        } while (lIIllllIlllIl != 0);
        final int[] pathIndices = this.pathIndices;
        final int n = this.stackSize - 1;
        ++pathIndices[n];
        this.pathNames[this.stackSize - 1] = "null";
    }
    
    static {
        PEEKED_EOF = 17;
        NUMBER_CHAR_FRACTION_DIGIT = 4;
        PEEKED_TRUE = 5;
        PEEKED_NUMBER = 16;
        NUMBER_CHAR_EXP_DIGIT = 7;
        PEEKED_DOUBLE_QUOTED = 9;
        PEEKED_UNQUOTED = 10;
        NUMBER_CHAR_EXP_SIGN = 6;
        NUMBER_CHAR_DIGIT = 2;
        PEEKED_BEGIN_ARRAY = 3;
        PEEKED_SINGLE_QUOTED_NAME = 12;
        NUMBER_CHAR_NONE = 0;
        PEEKED_END_ARRAY = 4;
        NUMBER_CHAR_SIGN = 1;
        NUMBER_CHAR_EXP_E = 5;
        NUMBER_CHAR_DECIMAL = 3;
        PEEKED_BUFFERED = 11;
        PEEKED_LONG = 15;
        PEEKED_SINGLE_QUOTED = 8;
        PEEKED_FALSE = 6;
        PEEKED_NULL = 7;
        PEEKED_END_OBJECT = 2;
        PEEKED_DOUBLE_QUOTED_NAME = 13;
        PEEKED_NONE = 0;
        PEEKED_BEGIN_OBJECT = 1;
        PEEKED_UNQUOTED_NAME = 14;
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            @Override
            public void promoteNameToValue(final JsonReader lllllllllllllllIlIIllIllllllIlIl) throws IOException {
                if (lllllllllllllllIlIIllIllllllIlIl instanceof JsonTreeReader) {
                    ((JsonTreeReader)lllllllllllllllIlIIllIllllllIlIl).promoteNameToValue();
                    return;
                }
                int lllllllllllllllIlIIllIllllllIlII = lllllllllllllllIlIIllIllllllIlIl.peeked;
                if (lllllllllllllllIlIIllIllllllIlII == 0) {
                    lllllllllllllllIlIIllIllllllIlII = lllllllllllllllIlIIllIllllllIlIl.doPeek();
                }
                if (lllllllllllllllIlIIllIllllllIlII == 13) {
                    lllllllllllllllIlIIllIllllllIlIl.peeked = 9;
                }
                else if (lllllllllllllllIlIIllIllllllIlII == 12) {
                    lllllllllllllllIlIIllIllllllIlIl.peeked = 8;
                }
                else {
                    if (lllllllllllllllIlIIllIllllllIlII != 14) {
                        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected a name but was ").append(lllllllllllllllIlIIllIllllllIlIl.peek()).append(lllllllllllllllIlIIllIllllllIlIl.locationString())));
                    }
                    lllllllllllllllIlIIllIllllllIlIl.peeked = 10;
                }
            }
        };
    }
    
    public String getPath() {
        final StringBuilder lIIlllIIIIllI = new StringBuilder().append('$');
        for (int lIIlllIIIlIIl = 0, lIIlllIIIlIII = this.stackSize; lIIlllIIIlIIl < lIIlllIIIlIII; ++lIIlllIIIlIIl) {
            switch (this.stack[lIIlllIIIlIIl]) {
                case 1:
                case 2: {
                    lIIlllIIIIllI.append('[').append(this.pathIndices[lIIlllIIIlIIl]).append(']');
                    break;
                }
                case 3:
                case 4:
                case 5: {
                    lIIlllIIIIllI.append('.');
                    if (this.pathNames[lIIlllIIIlIIl] != null) {
                        lIIlllIIIIllI.append(this.pathNames[lIIlllIIIlIIl]);
                        break;
                    }
                    break;
                }
            }
        }
        return String.valueOf(lIIlllIIIIllI);
    }
    
    public int nextInt() throws IOException {
        int lIIlllllIllII = this.peeked;
        if (lIIlllllIllII == 0) {
            lIIlllllIllII = this.doPeek();
        }
        if (lIIlllllIllII == 15) {
            final int lIIlllllIllll = (int)this.peekedLong;
            if (this.peekedLong != lIIlllllIllll) {
                throw new NumberFormatException(String.valueOf(new StringBuilder().append("Expected an int but was ").append(this.peekedLong).append(this.locationString())));
            }
            this.peeked = 0;
            final int[] pathIndices = this.pathIndices;
            final int n = this.stackSize - 1;
            ++pathIndices[n];
            return lIIlllllIllll;
        }
        else {
            Label_0269: {
                if (lIIlllllIllII != 16) {
                    if (lIIlllllIllII == 8 || lIIlllllIllII == 9 || lIIlllllIllII == 10) {
                        if (lIIlllllIllII == 10) {
                            this.peekedString = this.nextUnquotedValue();
                        }
                        else {
                            this.peekedString = this.nextQuotedValue((lIIlllllIllII == 8) ? '\'' : '\"');
                        }
                        try {
                            final int lIIlllllIlllI = Integer.parseInt(this.peekedString);
                            this.peeked = 0;
                            final int[] pathIndices2 = this.pathIndices;
                            final int n2 = this.stackSize - 1;
                            ++pathIndices2[n2];
                            return lIIlllllIlllI;
                        }
                        catch (NumberFormatException ex) {
                            break Label_0269;
                        }
                    }
                    throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected an int but was ").append(this.peek()).append(this.locationString())));
                }
                this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            }
            this.peeked = 11;
            final double lIIlllllIlIlI = Double.parseDouble(this.peekedString);
            final int lIIlllllIlIll = (int)lIIlllllIlIlI;
            if (lIIlllllIlIll != lIIlllllIlIlI) {
                throw new NumberFormatException(String.valueOf(new StringBuilder().append("Expected an int but was ").append(this.peekedString).append(this.locationString())));
            }
            this.peekedString = null;
            this.peeked = 0;
            final int[] pathIndices3 = this.pathIndices;
            final int n3 = this.stackSize - 1;
            ++pathIndices3[n3];
            return lIIlllllIlIll;
        }
    }
    
    public String nextString() throws IOException {
        int lIlIIIlIllllI = this.peeked;
        if (lIlIIIlIllllI == 0) {
            lIlIIIlIllllI = this.doPeek();
        }
        if (lIlIIIlIllllI == 10) {
            final String lIlIIIllIIlIl = this.nextUnquotedValue();
        }
        else if (lIlIIIlIllllI == 8) {
            final String lIlIIIllIIlII = this.nextQuotedValue('\'');
        }
        else if (lIlIIIlIllllI == 9) {
            final String lIlIIIllIIIll = this.nextQuotedValue('\"');
        }
        else if (lIlIIIlIllllI == 11) {
            final String lIlIIIllIIIlI = this.peekedString;
            this.peekedString = null;
        }
        else if (lIlIIIlIllllI == 15) {
            final String lIlIIIllIIIIl = Long.toString(this.peekedLong);
        }
        else {
            if (lIlIIIlIllllI != 16) {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected a string but was ").append(this.peek()).append(this.locationString())));
            }
            final String lIlIIIllIIIII = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.peeked = 0;
        final int[] pathIndices = this.pathIndices;
        final int n = this.stackSize - 1;
        ++pathIndices[n];
        final String lIlIIIlIlllIl;
        return lIlIIIlIlllIl;
    }
    
    private String nextQuotedValue(final char lIlIIIIlIIlII) throws IOException {
        final char[] lIlIIIIlIIIll = this.buffer;
        StringBuilder lIlIIIIlIIIlI = null;
        while (true) {
            int lIlIIIIlIlIII = this.pos;
            int lIlIIIIlIIlll = this.limit;
            int lIlIIIIlIIllI = lIlIIIIlIlIII;
            while (lIlIIIIlIlIII < lIlIIIIlIIlll) {
                final int lIlIIIIlIlIlI = lIlIIIIlIIIll[lIlIIIIlIlIII++];
                if (lIlIIIIlIlIlI == lIlIIIIlIIlII) {
                    this.pos = lIlIIIIlIlIII;
                    final int lIlIIIIlIllIl = lIlIIIIlIlIII - lIlIIIIlIIllI - 1;
                    if (lIlIIIIlIIIlI == null) {
                        return new String(lIlIIIIlIIIll, lIlIIIIlIIllI, lIlIIIIlIllIl);
                    }
                    lIlIIIIlIIIlI.append(lIlIIIIlIIIll, lIlIIIIlIIllI, lIlIIIIlIllIl);
                    return String.valueOf(lIlIIIIlIIIlI);
                }
                else if (lIlIIIIlIlIlI == 92) {
                    this.pos = lIlIIIIlIlIII;
                    final int lIlIIIIlIlIll = lIlIIIIlIlIII - lIlIIIIlIIllI - 1;
                    if (lIlIIIIlIIIlI == null) {
                        final int lIlIIIIlIllII = (lIlIIIIlIlIll + 1) * 2;
                        lIlIIIIlIIIlI = new StringBuilder(Math.max(lIlIIIIlIllII, 16));
                    }
                    lIlIIIIlIIIlI.append(lIlIIIIlIIIll, lIlIIIIlIIllI, lIlIIIIlIlIll);
                    lIlIIIIlIIIlI.append(this.readEscapeCharacter());
                    lIlIIIIlIlIII = this.pos;
                    lIlIIIIlIIlll = this.limit;
                    lIlIIIIlIIllI = lIlIIIIlIlIII;
                }
                else {
                    if (lIlIIIIlIlIlI != 10) {
                        continue;
                    }
                    ++this.lineNumber;
                    this.lineStart = lIlIIIIlIlIII;
                }
            }
            if (lIlIIIIlIIIlI == null) {
                final int lIlIIIIlIlIIl = (lIlIIIIlIlIII - lIlIIIIlIIllI) * 2;
                lIlIIIIlIIIlI = new StringBuilder(Math.max(lIlIIIIlIlIIl, 16));
            }
            lIlIIIIlIIIlI.append(lIlIIIIlIIIll, lIlIIIIlIIllI, lIlIIIIlIlIII - lIlIIIIlIIllI);
            this.pos = lIlIIIIlIlIII;
            if (!this.fillBuffer(1)) {
                throw this.syntaxError("Unterminated string");
            }
        }
    }
    
    private void push(final int lIIllllIlIIlI) {
        if (this.stackSize == this.stack.length) {
            final int lIIllllIlIllI = this.stackSize * 2;
            this.stack = Arrays.copyOf(this.stack, lIIllllIlIllI);
            this.pathIndices = Arrays.copyOf(this.pathIndices, lIIllllIlIllI);
            this.pathNames = Arrays.copyOf(this.pathNames, lIIllllIlIllI);
        }
        this.stack[this.stackSize++] = lIIllllIlIIlI;
    }
    
    private String nextUnquotedValue() throws IOException {
        StringBuilder lIlIIIIIlIIlI = null;
        int lIlIIIIIlIIIl = 0;
        Label_0172: {
        Label_0168:
            while (true) {
                if (this.pos + lIlIIIIIlIIIl < this.limit) {
                    switch (this.buffer[this.pos + lIlIIIIIlIIIl]) {
                        case '#':
                        case '/':
                        case ';':
                        case '=':
                        case '\\': {
                            break Label_0168;
                        }
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                        case ',':
                        case ':':
                        case '[':
                        case ']':
                        case '{':
                        case '}': {
                            break Label_0172;
                        }
                        default: {
                            ++lIlIIIIIlIIIl;
                            continue;
                        }
                    }
                }
                else if (lIlIIIIIlIIIl < this.buffer.length) {
                    if (this.fillBuffer(lIlIIIIIlIIIl + 1)) {
                        continue;
                    }
                    break Label_0172;
                }
                else {
                    if (lIlIIIIIlIIlI == null) {
                        lIlIIIIIlIIlI = new StringBuilder(Math.max(lIlIIIIIlIIIl, 16));
                    }
                    lIlIIIIIlIIlI.append(this.buffer, this.pos, lIlIIIIIlIIIl);
                    this.pos += lIlIIIIIlIIIl;
                    lIlIIIIIlIIIl = 0;
                    if (!this.fillBuffer(1)) {
                        break Label_0172;
                    }
                    continue;
                }
            }
            this.checkLenient();
        }
        final String lIlIIIIIlIIII = (null == lIlIIIIIlIIlI) ? new String(this.buffer, this.pos, lIlIIIIIlIIIl) : String.valueOf(lIlIIIIIlIIlI.append(this.buffer, this.pos, lIlIIIIIlIIIl));
        this.pos += lIlIIIIIlIIIl;
        return lIlIIIIIlIIII;
    }
    
    private boolean fillBuffer(int lIIllllIIIlll) throws IOException {
        final char[] lIIllllIIlIlI = this.buffer;
        this.lineStart -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(lIIllllIIlIlI, this.pos, lIIllllIIlIlI, 0, this.limit);
        }
        else {
            this.limit = 0;
        }
        this.pos = 0;
        int lIIllllIIlIIl;
        while ((lIIllllIIlIIl = this.in.read(lIIllllIIlIlI, this.limit, lIIllllIIlIlI.length - this.limit)) != -1) {
            this.limit += lIIllllIIlIIl;
            if (this.lineNumber == 0 && this.lineStart == 0 && this.limit > 0 && lIIllllIIlIlI[0] == '\ufeff') {
                ++this.pos;
                ++this.lineStart;
                ++lIIllllIIIlll;
            }
            if (this.limit >= lIIllllIIIlll) {
                return true;
            }
        }
        return false;
    }
    
    private void skipQuotedValue(final char lIIlllllllllI) throws IOException {
        final char[] lIlIIIIIIIIII = this.buffer;
        do {
            int lIlIIIIIIIlII = this.pos;
            int lIlIIIIIIIIll = this.limit;
            while (lIlIIIIIIIlII < lIlIIIIIIIIll) {
                final int lIlIIIIIIIlIl = lIlIIIIIIIIII[lIlIIIIIIIlII++];
                if (lIlIIIIIIIlIl == lIIlllllllllI) {
                    this.pos = lIlIIIIIIIlII;
                    return;
                }
                if (lIlIIIIIIIlIl == 92) {
                    this.pos = lIlIIIIIIIlII;
                    this.readEscapeCharacter();
                    lIlIIIIIIIlII = this.pos;
                    lIlIIIIIIIIll = this.limit;
                }
                else {
                    if (lIlIIIIIIIlIl != 10) {
                        continue;
                    }
                    ++this.lineNumber;
                    this.lineStart = lIlIIIIIIIlII;
                }
            }
            this.pos = lIlIIIIIIIlII;
        } while (this.fillBuffer(1));
        throw this.syntaxError("Unterminated string");
    }
    
    private IOException syntaxError(final String lIIllIllIlIlI) throws IOException {
        throw new MalformedJsonException(String.valueOf(new StringBuilder().append(lIIllIllIlIlI).append(this.locationString())));
    }
    
    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }
    
    public void beginObject() throws IOException {
        int lIlIIllIlllll = this.peeked;
        if (lIlIIllIlllll == 0) {
            lIlIIllIlllll = this.doPeek();
        }
        if (lIlIIllIlllll == 1) {
            this.push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Expected BEGIN_OBJECT but was ").append(this.peek()).append(this.locationString())));
    }
}
