package org.yaml.snakeyaml.reader;

import java.util.*;
import org.yaml.snakeyaml.error.*;
import java.io.*;
import org.yaml.snakeyaml.scanner.*;

public class StreamReader
{
    private /* synthetic */ int[] dataWindow;
    private /* synthetic */ int column;
    private /* synthetic */ int dataLength;
    private final /* synthetic */ Reader stream;
    private /* synthetic */ int pointer;
    private /* synthetic */ boolean eof;
    private /* synthetic */ int index;
    private /* synthetic */ int line;
    private /* synthetic */ char[] buffer;
    private /* synthetic */ String name;
    
    public static boolean isPrintable(final int lllllllllllllIIlllIlIlllIlIlllll) {
        return (lllllllllllllIIlllIlIlllIlIlllll >= 32 && lllllllllllllIIlllIlIlllIlIlllll <= 126) || lllllllllllllIIlllIlIlllIlIlllll == 9 || lllllllllllllIIlllIlIlllIlIlllll == 10 || lllllllllllllIIlllIlIlllIlIlllll == 13 || lllllllllllllIIlllIlIlllIlIlllll == 133 || (lllllllllllllIIlllIlIlllIlIlllll >= 160 && lllllllllllllIIlllIlIlllIlIlllll <= 55295) || (lllllllllllllIIlllIlIlllIlIlllll >= 57344 && lllllllllllllIIlllIlIlllIlIlllll <= 65533) || (lllllllllllllIIlllIlIlllIlIlllll >= 65536 && lllllllllllllIIlllIlIlllIlIlllll <= 1114111);
    }
    
    public StreamReader(final Reader lllllllllllllIIlllIlIlllIllIlllI) {
        this.pointer = 0;
        this.index = 0;
        this.line = 0;
        this.column = 0;
        this.name = "'reader'";
        this.dataWindow = new int[0];
        this.dataLength = 0;
        this.stream = lllllllllllllIIlllIlIlllIllIlllI;
        this.eof = false;
        this.buffer = new char[1025];
    }
    
    public String prefix(final int lllllllllllllIIlllIlIlllIlIIIIII) {
        if (lllllllllllllIIlllIlIlllIlIIIIII == 0) {
            return "";
        }
        if (this.ensureEnoughData(lllllllllllllIIlllIlIlllIlIIIIII)) {
            return new String(this.dataWindow, this.pointer, lllllllllllllIIlllIlIlllIlIIIIII);
        }
        return new String(this.dataWindow, this.pointer, Math.min(lllllllllllllIIlllIlIlllIlIIIIII, this.dataLength - this.pointer));
    }
    
    public String prefixForward(final int lllllllllllllIIlllIlIlllIIllIllI) {
        final String lllllllllllllIIlllIlIlllIIlllIII = this.prefix(lllllllllllllIIlllIlIlllIIllIllI);
        this.pointer += lllllllllllllIIlllIlIlllIIllIllI;
        this.index += lllllllllllllIIlllIlIlllIIllIllI;
        this.column += lllllllllllllIIlllIlIlllIIllIllI;
        return lllllllllllllIIlllIlIlllIIlllIII;
    }
    
    public Mark getMark() {
        return new Mark(this.name, this.index, this.line, this.column, this.dataWindow, this.pointer);
    }
    
    public int peek(final int lllllllllllllIIlllIlIlllIlIIIllI) {
        return this.ensureEnoughData(lllllllllllllIIlllIlIlllIlIIIllI) ? this.dataWindow[this.pointer + lllllllllllllIIlllIlIlllIlIIIllI] : 0;
    }
    
    private void update() {
        try {
            int lllllllllllllIIlllIlIlllIIlIIIIl = this.stream.read(this.buffer, 0, 1024);
            if (lllllllllllllIIlllIlIlllIIlIIIIl > 0) {
                int lllllllllllllIIlllIlIlllIIlIIIll = this.dataLength - this.pointer;
                this.dataWindow = Arrays.copyOfRange(this.dataWindow, this.pointer, this.dataLength + lllllllllllllIIlllIlIlllIIlIIIIl);
                if (Character.isHighSurrogate(this.buffer[lllllllllllllIIlllIlIlllIIlIIIIl - 1])) {
                    if (this.stream.read(this.buffer, lllllllllllllIIlllIlIlllIIlIIIIl, 1) == -1) {
                        this.eof = true;
                    }
                    else {
                        ++lllllllllllllIIlllIlIlllIIlIIIIl;
                    }
                }
                int lllllllllllllIIlllIlIlllIIlIIIlI = 32;
                int lllllllllllllIIlllIlIlllIIlIIlII = 0;
                while (lllllllllllllIIlllIlIlllIIlIIlII < lllllllllllllIIlllIlIlllIIlIIIIl) {
                    final int lllllllllllllIIlllIlIlllIIlIIlIl = Character.codePointAt(this.buffer, lllllllllllllIIlllIlIlllIIlIIlII);
                    this.dataWindow[lllllllllllllIIlllIlIlllIIlIIIll] = lllllllllllllIIlllIlIlllIIlIIlIl;
                    if (isPrintable(lllllllllllllIIlllIlIlllIIlIIlIl)) {
                        lllllllllllllIIlllIlIlllIIlIIlII += Character.charCount(lllllllllllllIIlllIlIlllIIlIIlIl);
                    }
                    else {
                        lllllllllllllIIlllIlIlllIIlIIIlI = lllllllllllllIIlllIlIlllIIlIIlIl;
                        lllllllllllllIIlllIlIlllIIlIIlII = lllllllllllllIIlllIlIlllIIlIIIIl;
                    }
                    ++lllllllllllllIIlllIlIlllIIlIIIll;
                }
                this.dataLength = lllllllllllllIIlllIlIlllIIlIIIll;
                this.pointer = 0;
                if (lllllllllllllIIlllIlIlllIIlIIIlI != 32) {
                    throw new ReaderException(this.name, lllllllllllllIIlllIlIlllIIlIIIll - 1, lllllllllllllIIlllIlIlllIIlIIIlI, "special characters are not allowed");
                }
            }
            else {
                this.eof = true;
            }
        }
        catch (IOException lllllllllllllIIlllIlIlllIIlIIIII) {
            throw new YAMLException(lllllllllllllIIlllIlIlllIIlIIIII);
        }
    }
    
    public int peek() {
        return this.ensureEnoughData() ? this.dataWindow[this.pointer] : 0;
    }
    
    public StreamReader(final String lllllllllllllIIlllIlIlllIlllIlII) {
        this(new StringReader(lllllllllllllIIlllIlIlllIlllIlII));
        this.name = "'string'";
    }
    
    public int getColumn() {
        return this.column;
    }
    
    private boolean ensureEnoughData(final int lllllllllllllIIlllIlIlllIIlIlllI) {
        if (!this.eof && this.pointer + lllllllllllllIIlllIlIlllIIlIlllI >= this.dataLength) {
            this.update();
        }
        return this.pointer + lllllllllllllIIlllIlIlllIIlIlllI < this.dataLength;
    }
    
    public void forward() {
        this.forward(1);
    }
    
    static {
        BUFFER_SIZE = 1025;
    }
    
    public void forward(final int lllllllllllllIIlllIlIlllIlIlIIIl) {
        for (int lllllllllllllIIlllIlIlllIlIlIIll = 0; lllllllllllllIIlllIlIlllIlIlIIll < lllllllllllllIIlllIlIlllIlIlIIIl && this.ensureEnoughData(); ++lllllllllllllIIlllIlIlllIlIlIIll) {
            final int lllllllllllllIIlllIlIlllIlIlIlII = this.dataWindow[this.pointer++];
            ++this.index;
            if (Constant.LINEBR.has(lllllllllllllIIlllIlIlllIlIlIlII) || (lllllllllllllIIlllIlIlllIlIlIlII == 13 && this.ensureEnoughData() && this.dataWindow[this.pointer] != 10)) {
                ++this.line;
                this.column = 0;
            }
            else if (lllllllllllllIIlllIlIlllIlIlIlII != 65279) {
                ++this.column;
            }
        }
    }
    
    public static boolean isPrintable(final String lllllllllllllIIlllIlIlllIllIIlll) {
        int lllllllllllllIIlllIlIlllIllIlIIl;
        for (int lllllllllllllIIlllIlIlllIllIIllI = lllllllllllllIIlllIlIlllIllIIlll.length(), lllllllllllllIIlllIlIlllIllIlIII = 0; lllllllllllllIIlllIlIlllIllIlIII < lllllllllllllIIlllIlIlllIllIIllI; lllllllllllllIIlllIlIlllIllIlIII += Character.charCount(lllllllllllllIIlllIlIlllIllIlIIl)) {
            lllllllllllllIIlllIlIlllIllIlIIl = lllllllllllllIIlllIlIlllIllIIlll.codePointAt(lllllllllllllIIlllIlIlllIllIlIII);
            if (!isPrintable(lllllllllllllIIlllIlIlllIllIlIIl)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean ensureEnoughData() {
        return this.ensureEnoughData(0);
    }
    
    public int getLine() {
        return this.line;
    }
    
    public int getIndex() {
        return this.index;
    }
}
