package com.viaversion.viaversion.libs.gson.stream;

import java.io.*;
import java.util.*;

public class JsonWriter implements Closeable, Flushable
{
    private /* synthetic */ boolean htmlSafe;
    private static final /* synthetic */ String[] HTML_SAFE_REPLACEMENT_CHARS;
    private final /* synthetic */ Writer out;
    private static final /* synthetic */ String[] REPLACEMENT_CHARS;
    private /* synthetic */ int[] stack;
    private /* synthetic */ String separator;
    private /* synthetic */ String indent;
    private /* synthetic */ int stackSize;
    private /* synthetic */ boolean serializeNulls;
    private /* synthetic */ boolean lenient;
    private /* synthetic */ String deferredName;
    
    private void beforeValue() throws IOException {
        switch (this.peek()) {
            case 7: {
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            case 6: {
                this.replaceTop(7);
                break;
            }
            case 1: {
                this.replaceTop(2);
                this.newline();
                break;
            }
            case 2: {
                this.out.append(',');
                this.newline();
                break;
            }
            case 4: {
                this.out.append((CharSequence)this.separator);
                this.replaceTop(5);
                break;
            }
            default: {
                throw new IllegalStateException("Nesting problem.");
            }
        }
    }
    
    public JsonWriter value(final boolean llllllllllllIlllllllIlllIIIlIIlI) throws IOException {
        this.writeDeferredName();
        this.beforeValue();
        this.out.write(llllllllllllIlllllllIlllIIIlIIlI ? "true" : "false");
        return this;
    }
    
    public JsonWriter beginArray() throws IOException {
        this.writeDeferredName();
        return this.open(1, '[');
    }
    
    public final void setHtmlSafe(final boolean llllllllllllIlllllllIlllIllIllIl) {
        this.htmlSafe = llllllllllllIlllllllIlllIllIllIl;
    }
    
    public final void setLenient(final boolean llllllllllllIlllllllIlllIlllIllI) {
        this.lenient = llllllllllllIlllllllIlllIlllIllI;
    }
    
    public boolean isLenient() {
        return this.lenient;
    }
    
    public JsonWriter endArray() throws IOException {
        return this.close(1, 2, ']');
    }
    
    public final void setIndent(final String llllllllllllIlllllllIlllIlllllII) {
        if (llllllllllllIlllllllIlllIlllllII.length() == 0) {
            this.indent = null;
            this.separator = ":";
        }
        else {
            this.indent = llllllllllllIlllllllIlllIlllllII;
            this.separator = ": ";
        }
    }
    
    public JsonWriter value(final double llllllllllllIlllllllIlllIIIIIllI) throws IOException {
        this.writeDeferredName();
        if (!this.lenient && (Double.isNaN(llllllllllllIlllllllIlllIIIIIllI) || Double.isInfinite(llllllllllllIlllllllIlllIIIIIllI))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Numeric values must be finite, but was ").append(llllllllllllIlllllllIlllIIIIIllI)));
        }
        this.beforeValue();
        this.out.append((CharSequence)Double.toString(llllllllllllIlllllllIlllIIIIIllI));
        return this;
    }
    
    private JsonWriter open(final int llllllllllllIlllllllIlllIlIIllIl, final char llllllllllllIlllllllIlllIlIIllll) throws IOException {
        this.beforeValue();
        this.push(llllllllllllIlllllllIlllIlIIllIl);
        this.out.write(llllllllllllIlllllllIlllIlIIllll);
        return this;
    }
    
    private void replaceTop(final int llllllllllllIlllllllIlllIIllIIII) {
        this.stack[this.stackSize - 1] = llllllllllllIlllllllIlllIIllIIII;
    }
    
    private void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.out.write(10);
        for (int llllllllllllIlllllllIllIllIIlllI = 1, llllllllllllIlllllllIllIllIIllIl = this.stackSize; llllllllllllIlllllllIllIllIIlllI < llllllllllllIlllllllIllIllIIllIl; ++llllllllllllIlllllllIllIllIIlllI) {
            this.out.write(this.indent);
        }
    }
    
    public JsonWriter beginObject() throws IOException {
        this.writeDeferredName();
        return this.open(3, '{');
    }
    
    public JsonWriter value(final Boolean llllllllllllIlllllllIlllIIIIlIlI) throws IOException {
        if (llllllllllllIlllllllIlllIIIIlIlI == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        this.out.write(((boolean)llllllllllllIlllllllIlllIIIIlIlI) ? "true" : "false");
        return this;
    }
    
    public JsonWriter value(final String llllllllllllIlllllllIlllIIIlllll) throws IOException {
        if (llllllllllllIlllllllIlllIIIlllll == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        this.string(llllllllllllIlllllllIlllIIIlllll);
        return this;
    }
    
    public final void setSerializeNulls(final boolean llllllllllllIlllllllIlllIllIIlII) {
        this.serializeNulls = llllllllllllIlllllllIlllIllIIlII;
    }
    
    public JsonWriter jsonValue(final String llllllllllllIlllllllIlllIIIllIll) throws IOException {
        if (llllllllllllIlllllllIlllIIIllIll == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        this.out.append((CharSequence)llllllllllllIlllllllIlllIIIllIll);
        return this;
    }
    
    public JsonWriter(final Writer llllllllllllIlllllllIllllIIIIIlI) {
        this.stack = new int[32];
        this.stackSize = 0;
        this.push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (llllllllllllIlllllllIllllIIIIIlI == null) {
            throw new NullPointerException("out == null");
        }
        this.out = llllllllllllIlllllllIllllIIIIIlI;
    }
    
    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }
    
    @Override
    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }
    
    private JsonWriter close(final int llllllllllllIlllllllIlllIlIIIlIl, final int llllllllllllIlllllllIlllIlIIIlII, final char llllllllllllIlllllllIlllIlIIIIll) throws IOException {
        final int llllllllllllIlllllllIlllIlIIIIlI = this.peek();
        if (llllllllllllIlllllllIlllIlIIIIlI != llllllllllllIlllllllIlllIlIIIlII && llllllllllllIlllllllIlllIlIIIIlI != llllllllllllIlllllllIlllIlIIIlIl) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Dangling name: ").append(this.deferredName)));
        }
        --this.stackSize;
        if (llllllllllllIlllllllIlllIlIIIIlI == llllllllllllIlllllllIlllIlIIIlII) {
            this.newline();
        }
        this.out.write(llllllllllllIlllllllIlllIlIIIIll);
        return this;
    }
    
    @Override
    public void close() throws IOException {
        this.out.close();
        final int llllllllllllIlllllllIllIlllIlllI = this.stackSize;
        if (llllllllllllIlllllllIllIlllIlllI > 1 || (llllllllllllIlllllllIllIlllIlllI == 1 && this.stack[llllllllllllIlllllllIllIlllIlllI - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }
    
    public JsonWriter value(final long llllllllllllIlllllllIlllIIIIIIII) throws IOException {
        this.writeDeferredName();
        this.beforeValue();
        this.out.write(Long.toString(llllllllllllIlllllllIlllIIIIIIII));
        return this;
    }
    
    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            this.writeDeferredName();
        }
        this.beforeValue();
        this.out.write("null");
        return this;
    }
    
    private void string(final String llllllllllllIlllllllIllIllIllIII) throws IOException {
        final String[] llllllllllllIlllllllIllIllIlllII = this.htmlSafe ? JsonWriter.HTML_SAFE_REPLACEMENT_CHARS : JsonWriter.REPLACEMENT_CHARS;
        this.out.write(34);
        int llllllllllllIlllllllIllIllIllIll = 0;
        final int llllllllllllIlllllllIllIllIllIlI = llllllllllllIlllllllIllIllIllIII.length();
        for (int llllllllllllIlllllllIllIllIlllll = 0; llllllllllllIlllllllIllIllIlllll < llllllllllllIlllllllIllIllIllIlI; ++llllllllllllIlllllllIllIllIlllll) {
            final char llllllllllllIlllllllIllIlllIIIIl = llllllllllllIlllllllIllIllIllIII.charAt(llllllllllllIlllllllIllIllIlllll);
            String llllllllllllIlllllllIllIlllIIIII = null;
            if (llllllllllllIlllllllIllIlllIIIIl < '\u0080') {
                final String llllllllllllIlllllllIllIlllIIIll = llllllllllllIlllllllIllIllIlllII[llllllllllllIlllllllIllIlllIIIIl];
                if (llllllllllllIlllllllIllIlllIIIll == null) {
                    continue;
                }
            }
            else if (llllllllllllIlllllllIllIlllIIIIl == '\u2028') {
                final String llllllllllllIlllllllIllIlllIIIlI = "\\u2028";
            }
            else {
                if (llllllllllllIlllllllIllIlllIIIIl != '\u2029') {
                    continue;
                }
                llllllllllllIlllllllIllIlllIIIII = "\\u2029";
            }
            if (llllllllllllIlllllllIllIllIllIll < llllllllllllIlllllllIllIllIlllll) {
                this.out.write(llllllllllllIlllllllIllIllIllIII, llllllllllllIlllllllIllIllIllIll, llllllllllllIlllllllIllIllIlllll - llllllllllllIlllllllIllIllIllIll);
            }
            this.out.write(llllllllllllIlllllllIllIlllIIIII);
            llllllllllllIlllllllIllIllIllIll = llllllllllllIlllllllIllIllIlllll + 1;
        }
        if (llllllllllllIlllllllIllIllIllIll < llllllllllllIlllllllIllIllIllIlI) {
            this.out.write(llllllllllllIlllllllIllIllIllIII, llllllllllllIlllllllIllIllIllIll, llllllllllllIlllllllIllIllIllIlI - llllllllllllIlllllllIllIllIllIll);
        }
        this.out.write(34);
    }
    
    private void push(final int llllllllllllIlllllllIlllIIlllIIl) {
        if (this.stackSize == this.stack.length) {
            this.stack = Arrays.copyOf(this.stack, this.stackSize * 2);
        }
        this.stack[this.stackSize++] = llllllllllllIlllllllIlllIIlllIIl;
    }
    
    private void beforeName() throws IOException {
        final int llllllllllllIlllllllIllIllIIIlIl = this.peek();
        if (llllllllllllIlllllllIllIllIIIlIl == 5) {
            this.out.write(44);
        }
        else if (llllllllllllIlllllllIllIllIIIlIl != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.newline();
        this.replaceTop(4);
    }
    
    static {
        REPLACEMENT_CHARS = new String[128];
        for (int llllllllllllIlllllllIllIlIlllllI = 0; llllllllllllIlllllllIllIlIlllllI <= 31; ++llllllllllllIlllllllIllIlIlllllI) {
            JsonWriter.REPLACEMENT_CHARS[llllllllllllIlllllllIllIlIlllllI] = String.format("\\u%04x", llllllllllllIlllllllIllIlIlllllI);
        }
        JsonWriter.REPLACEMENT_CHARS[34] = "\\\"";
        JsonWriter.REPLACEMENT_CHARS[92] = "\\\\";
        JsonWriter.REPLACEMENT_CHARS[9] = "\\t";
        JsonWriter.REPLACEMENT_CHARS[8] = "\\b";
        JsonWriter.REPLACEMENT_CHARS[10] = "\\n";
        JsonWriter.REPLACEMENT_CHARS[13] = "\\r";
        JsonWriter.REPLACEMENT_CHARS[12] = "\\f";
        (HTML_SAFE_REPLACEMENT_CHARS = JsonWriter.REPLACEMENT_CHARS.clone())[60] = "\\u003c";
        JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
        JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
        JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
        JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
    }
    
    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }
    
    public JsonWriter name(final String llllllllllllIlllllllIlllIIlIlIlI) throws IOException {
        if (llllllllllllIlllllllIlllIIlIlIlI == null) {
            throw new NullPointerException("name == null");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException();
        }
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.deferredName = llllllllllllIlllllllIlllIIlIlIlI;
        return this;
    }
    
    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            this.beforeName();
            this.string(this.deferredName);
            this.deferredName = null;
        }
    }
    
    public JsonWriter value(final Number llllllllllllIlllllllIllIlllllIIl) throws IOException {
        if (llllllllllllIlllllllIllIlllllIIl == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        final String llllllllllllIlllllllIllIlllllIII = llllllllllllIlllllllIllIlllllIIl.toString();
        if (!this.lenient && (llllllllllllIlllllllIllIlllllIII.equals("-Infinity") || llllllllllllIlllllllIllIlllllIII.equals("Infinity") || llllllllllllIlllllllIllIlllllIII.equals("NaN"))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Numeric values must be finite, but was ").append(llllllllllllIlllllllIllIlllllIIl)));
        }
        this.beforeValue();
        this.out.append((CharSequence)llllllllllllIlllllllIllIlllllIII);
        return this;
    }
    
    private int peek() {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.stack[this.stackSize - 1];
    }
    
    public JsonWriter endObject() throws IOException {
        return this.close(3, 5, '}');
    }
}
