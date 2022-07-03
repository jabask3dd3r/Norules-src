package com.viaversion.viaversion.libs.javassist.compiler;

public class Lex implements TokenId
{
    private /* synthetic */ StringBuffer textBuffer;
    private static final /* synthetic */ KeywordTable ktable;
    private /* synthetic */ Token lookAheadTokens;
    private /* synthetic */ int lineNumber;
    private /* synthetic */ int position;
    private /* synthetic */ Token currentToken;
    private /* synthetic */ int lastChar;
    private static final /* synthetic */ int[] equalOps;
    private /* synthetic */ int maxlen;
    private /* synthetic */ String input;
    
    private int readCharConst(final Token llllllllllllllllIIIIIlIIlIllIIII) {
        int llllllllllllllllIIIIIlIIlIlIlllI = 0;
        int llllllllllllllllIIIIIlIIlIlIllll;
        while ((llllllllllllllllIIIIIlIIlIlIllll = this.getc()) != 39) {
            if (llllllllllllllllIIIIIlIIlIlIllll == 92) {
                llllllllllllllllIIIIIlIIlIlIlllI = this.readEscapeChar();
            }
            else {
                if (llllllllllllllllIIIIIlIIlIlIllll < 32) {
                    if (llllllllllllllllIIIIIlIIlIlIllll == 10) {
                        ++this.lineNumber;
                    }
                    return 500;
                }
                llllllllllllllllIIIIIlIIlIlIlllI = llllllllllllllllIIIIIlIIlIlIllll;
            }
        }
        llllllllllllllllIIIIIlIIlIllIIII.longValue = llllllllllllllllIIIIIlIIlIlIlllI;
        return 401;
    }
    
    public long getLong() {
        return this.currentToken.longValue;
    }
    
    private int get(final Token llllllllllllllllIIIIIlIIllIIllII) {
        int llllllllllllllllIIIIIlIIllIIlIll;
        do {
            llllllllllllllllIIIIIlIIllIIlIll = this.readLine(llllllllllllllllIIIIIlIIllIIllII);
        } while (llllllllllllllllIIIIIlIIllIIlIll == 10);
        llllllllllllllllIIIIIlIIllIIllII.tokenId = llllllllllllllllIIIIIlIIllIIlIll;
        return llllllllllllllllIIIIIlIIllIIlIll;
    }
    
    public int get() {
        if (this.lookAheadTokens == null) {
            return this.get(this.currentToken);
        }
        final Token llllllllllllllllIIIIIlIIlllIlIll = this.currentToken = this.lookAheadTokens;
        this.lookAheadTokens = this.lookAheadTokens.next;
        return llllllllllllllllIIIIIlIIlllIlIll.tokenId;
    }
    
    private int readStringL(final Token llllllllllllllllIIIIIlIIlIIllllI) {
        final StringBuffer llllllllllllllllIIIIIlIIlIIlllII = this.textBuffer;
        llllllllllllllllIIIIIlIIlIIlllII.setLength(0);
        while (true) {
            int llllllllllllllllIIIIIlIIlIIlllIl;
            if ((llllllllllllllllIIIIIlIIlIIlllIl = this.getc()) != 34) {
                if (llllllllllllllllIIIIIlIIlIIlllIl == 92) {
                    llllllllllllllllIIIIIlIIlIIlllIl = this.readEscapeChar();
                }
                else if (llllllllllllllllIIIIIlIIlIIlllIl == 10 || llllllllllllllllIIIIIlIIlIIlllIl < 0) {
                    ++this.lineNumber;
                    return 500;
                }
                llllllllllllllllIIIIIlIIlIIlllII.append((char)llllllllllllllllIIIIIlIIlIIlllIl);
            }
            else {
                while (true) {
                    llllllllllllllllIIIIIlIIlIIlllIl = this.getc();
                    if (llllllllllllllllIIIIIlIIlIIlllIl == 10) {
                        ++this.lineNumber;
                    }
                    else {
                        if (!isBlank(llllllllllllllllIIIIIlIIlIIlllIl)) {
                            break;
                        }
                        continue;
                    }
                }
                if (llllllllllllllllIIIIIlIIlIIlllIl != 34) {
                    this.ungetc(llllllllllllllllIIIIIlIIlIIlllIl);
                    llllllllllllllllIIIIIlIIlIIllllI.textValue = llllllllllllllllIIIIIlIIlIIlllII.toString();
                    return 406;
                }
                continue;
            }
        }
    }
    
    private int readLine(final Token llllllllllllllllIIIIIlIIlIlllllI) {
        int llllllllllllllllIIIIIlIIllIIIIII = this.getNextNonWhiteChar();
        if (llllllllllllllllIIIIIlIIllIIIIII < 0) {
            return llllllllllllllllIIIIIlIIllIIIIII;
        }
        if (llllllllllllllllIIIIIlIIllIIIIII == 10) {
            ++this.lineNumber;
            return 10;
        }
        if (llllllllllllllllIIIIIlIIllIIIIII == 39) {
            return this.readCharConst(llllllllllllllllIIIIIlIIlIlllllI);
        }
        if (llllllllllllllllIIIIIlIIllIIIIII == 34) {
            return this.readStringL(llllllllllllllllIIIIIlIIlIlllllI);
        }
        if (48 <= llllllllllllllllIIIIIlIIllIIIIII && llllllllllllllllIIIIIlIIllIIIIII <= 57) {
            return this.readNumber(llllllllllllllllIIIIIlIIllIIIIII, llllllllllllllllIIIIIlIIlIlllllI);
        }
        if (llllllllllllllllIIIIIlIIllIIIIII == 46) {
            llllllllllllllllIIIIIlIIllIIIIII = this.getc();
            if (48 <= llllllllllllllllIIIIIlIIllIIIIII && llllllllllllllllIIIIIlIIllIIIIII <= 57) {
                final StringBuffer llllllllllllllllIIIIIlIIllIIIIll = this.textBuffer;
                llllllllllllllllIIIIIlIIllIIIIll.setLength(0);
                llllllllllllllllIIIIIlIIllIIIIll.append('.');
                return this.readDouble(llllllllllllllllIIIIIlIIllIIIIll, llllllllllllllllIIIIIlIIllIIIIII, llllllllllllllllIIIIIlIIlIlllllI);
            }
            this.ungetc(llllllllllllllllIIIIIlIIllIIIIII);
            return this.readSeparator(46);
        }
        else {
            if (Character.isJavaIdentifierStart((char)llllllllllllllllIIIIIlIIllIIIIII)) {
                return this.readIdentifier(llllllllllllllllIIIIIlIIllIIIIII, llllllllllllllllIIIIIlIIlIlllllI);
            }
            return this.readSeparator(llllllllllllllllIIIIIlIIllIIIIII);
        }
    }
    
    static {
        equalOps = new int[] { 350, 0, 0, 0, 351, 352, 0, 0, 0, 353, 354, 0, 355, 0, 356, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 357, 358, 359, 0 };
        (ktable = new KeywordTable()).append("abstract", 300);
        Lex.ktable.append("boolean", 301);
        Lex.ktable.append("break", 302);
        Lex.ktable.append("byte", 303);
        Lex.ktable.append("case", 304);
        Lex.ktable.append("catch", 305);
        Lex.ktable.append("char", 306);
        Lex.ktable.append("class", 307);
        Lex.ktable.append("const", 308);
        Lex.ktable.append("continue", 309);
        Lex.ktable.append("default", 310);
        Lex.ktable.append("do", 311);
        Lex.ktable.append("double", 312);
        Lex.ktable.append("else", 313);
        Lex.ktable.append("extends", 314);
        Lex.ktable.append("false", 411);
        Lex.ktable.append("final", 315);
        Lex.ktable.append("finally", 316);
        Lex.ktable.append("float", 317);
        Lex.ktable.append("for", 318);
        Lex.ktable.append("goto", 319);
        Lex.ktable.append("if", 320);
        Lex.ktable.append("implements", 321);
        Lex.ktable.append("import", 322);
        Lex.ktable.append("instanceof", 323);
        Lex.ktable.append("int", 324);
        Lex.ktable.append("interface", 325);
        Lex.ktable.append("long", 326);
        Lex.ktable.append("native", 327);
        Lex.ktable.append("new", 328);
        Lex.ktable.append("null", 412);
        Lex.ktable.append("package", 329);
        Lex.ktable.append("private", 330);
        Lex.ktable.append("protected", 331);
        Lex.ktable.append("public", 332);
        Lex.ktable.append("return", 333);
        Lex.ktable.append("short", 334);
        Lex.ktable.append("static", 335);
        Lex.ktable.append("strictfp", 347);
        Lex.ktable.append("super", 336);
        Lex.ktable.append("switch", 337);
        Lex.ktable.append("synchronized", 338);
        Lex.ktable.append("this", 339);
        Lex.ktable.append("throw", 340);
        Lex.ktable.append("throws", 341);
        Lex.ktable.append("transient", 342);
        Lex.ktable.append("true", 410);
        Lex.ktable.append("try", 343);
        Lex.ktable.append("void", 344);
        Lex.ktable.append("volatile", 345);
        Lex.ktable.append("while", 346);
    }
    
    public int lookAhead() {
        return this.lookAhead(0);
    }
    
    public Lex(final String llllllllllllllllIIIIIlIIlllIllll) {
        this.lastChar = -1;
        this.textBuffer = new StringBuffer();
        this.currentToken = new Token();
        this.lookAheadTokens = null;
        this.input = llllllllllllllllIIIIIlIIlllIllll;
        this.position = 0;
        this.maxlen = llllllllllllllllIIIIIlIIlllIllll.length();
        this.lineNumber = 0;
    }
    
    private int readEscapeChar() {
        int llllllllllllllllIIIIIlIIlIlIIllI = this.getc();
        if (llllllllllllllllIIIIIlIIlIlIIllI == 110) {
            llllllllllllllllIIIIIlIIlIlIIllI = 10;
        }
        else if (llllllllllllllllIIIIIlIIlIlIIllI == 116) {
            llllllllllllllllIIIIIlIIlIlIIllI = 9;
        }
        else if (llllllllllllllllIIIIIlIIlIlIIllI == 114) {
            llllllllllllllllIIIIIlIIlIlIIllI = 13;
        }
        else if (llllllllllllllllIIIIIlIIlIlIIllI == 102) {
            llllllllllllllllIIIIIlIIlIlIIllI = 12;
        }
        else if (llllllllllllllllIIIIIlIIlIlIIllI == 10) {
            ++this.lineNumber;
        }
        return llllllllllllllllIIIIIlIIlIlIIllI;
    }
    
    public String getTextAround() {
        int llllllllllllllllIIIIIlIIIlIIIIIl = this.position - 10;
        if (llllllllllllllllIIIIIlIIIlIIIIIl < 0) {
            llllllllllllllllIIIIIlIIIlIIIIIl = 0;
        }
        int llllllllllllllllIIIIIlIIIlIIIIII = this.position + 10;
        if (llllllllllllllllIIIIIlIIIlIIIIII > this.maxlen) {
            llllllllllllllllIIIIIlIIIlIIIIII = this.maxlen;
        }
        return this.input.substring(llllllllllllllllIIIIIlIIIlIIIIIl, llllllllllllllllIIIIIlIIIlIIIIII);
    }
    
    private int getNextNonWhiteChar() {
        int llllllllllllllllIIIIIlIIlIlllIII;
        do {
            llllllllllllllllIIIIIlIIlIlllIII = this.getc();
            if (llllllllllllllllIIIIIlIIlIlllIII == 47) {
                llllllllllllllllIIIIIlIIlIlllIII = this.getc();
                if (llllllllllllllllIIIIIlIIlIlllIII == 47) {
                    do {
                        llllllllllllllllIIIIIlIIlIlllIII = this.getc();
                        if (llllllllllllllllIIIIIlIIlIlllIII != 10 && llllllllllllllllIIIIIlIIlIlllIII != 13) {
                            continue;
                        }
                        break;
                    } while (llllllllllllllllIIIIIlIIlIlllIII != -1);
                }
                else if (llllllllllllllllIIIIIlIIlIlllIII == 42) {
                    while (true) {
                        llllllllllllllllIIIIIlIIlIlllIII = this.getc();
                        if (llllllllllllllllIIIIIlIIlIlllIII == -1) {
                            break;
                        }
                        if (llllllllllllllllIIIIIlIIlIlllIII != 42) {
                            continue;
                        }
                        if ((llllllllllllllllIIIIIlIIlIlllIII = this.getc()) == 47) {
                            llllllllllllllllIIIIIlIIlIlllIII = 32;
                            break;
                        }
                        this.ungetc(llllllllllllllllIIIIIlIIlIlllIII);
                    }
                }
                else {
                    this.ungetc(llllllllllllllllIIIIIlIIlIlllIII);
                    llllllllllllllllIIIIIlIIlIlllIII = 47;
                }
            }
        } while (isBlank(llllllllllllllllIIIIIlIIlIlllIII));
        return llllllllllllllllIIIIIlIIlIlllIII;
    }
    
    private int readIdentifier(int llllllllllllllllIIIIIlIIIlIlIllI, final Token llllllllllllllllIIIIIlIIIlIllIll) {
        final StringBuffer llllllllllllllllIIIIIlIIIlIllIlI = this.textBuffer;
        llllllllllllllllIIIIIlIIIlIllIlI.setLength(0);
        do {
            llllllllllllllllIIIIIlIIIlIllIlI.append((char)llllllllllllllllIIIIIlIIIlIlIllI);
            llllllllllllllllIIIIIlIIIlIlIllI = this.getc();
        } while (Character.isJavaIdentifierPart((char)llllllllllllllllIIIIIlIIIlIlIllI));
        this.ungetc((int)llllllllllllllllIIIIIlIIIlIlIllI);
        final String llllllllllllllllIIIIIlIIIlIllIIl = llllllllllllllllIIIIIlIIIlIllIlI.toString();
        final int llllllllllllllllIIIIIlIIIlIllIII = Lex.ktable.lookup(llllllllllllllllIIIIIlIIIlIllIIl);
        if (llllllllllllllllIIIIIlIIIlIllIII >= 0) {
            return llllllllllllllllIIIIIlIIIlIllIII;
        }
        llllllllllllllllIIIIIlIIIlIllIll.textValue = llllllllllllllllIIIIIlIIIlIllIIl;
        return 400;
    }
    
    private int readSeparator(final int llllllllllllllllIIIIIlIIIllIlIlI) {
        if (33 <= llllllllllllllllIIIIIlIIIllIlIlI && llllllllllllllllIIIIIlIIIllIlIlI <= 63) {
            final int llllllllllllllllIIIIIlIIIllIllll = Lex.equalOps[llllllllllllllllIIIIIlIIIllIlIlI - 33];
            if (llllllllllllllllIIIIIlIIIllIllll == 0) {
                return llllllllllllllllIIIIIlIIIllIlIlI;
            }
            final int llllllllllllllllIIIIIlIIIllIlllI = this.getc();
            if (llllllllllllllllIIIIIlIIIllIlIlI == llllllllllllllllIIIIIlIIIllIlllI) {
                switch (llllllllllllllllIIIIIlIIIllIlIlI) {
                    case 61: {
                        return 358;
                    }
                    case 43: {
                        return 362;
                    }
                    case 45: {
                        return 363;
                    }
                    case 38: {
                        return 369;
                    }
                    case 60: {
                        final int llllllllllllllllIIIIIlIIIlllIIIl = this.getc();
                        if (llllllllllllllllIIIIIlIIIlllIIIl == 61) {
                            return 365;
                        }
                        this.ungetc(llllllllllllllllIIIIIlIIIlllIIIl);
                        return 364;
                    }
                    case 62: {
                        int llllllllllllllllIIIIIlIIIlllIIII = this.getc();
                        if (llllllllllllllllIIIIIlIIIlllIIII == 61) {
                            return 367;
                        }
                        if (llllllllllllllllIIIIIlIIIlllIIII != 62) {
                            this.ungetc(llllllllllllllllIIIIIlIIIlllIIII);
                            return 366;
                        }
                        llllllllllllllllIIIIIlIIIlllIIII = this.getc();
                        if (llllllllllllllllIIIIIlIIIlllIIII == 61) {
                            return 371;
                        }
                        this.ungetc(llllllllllllllllIIIIIlIIIlllIIII);
                        return 370;
                    }
                }
            }
            else if (llllllllllllllllIIIIIlIIIllIlllI == 61) {
                return llllllllllllllllIIIIIlIIIllIllll;
            }
        }
        else if (llllllllllllllllIIIIIlIIIllIlIlI == 94) {
            final int llllllllllllllllIIIIIlIIIllIllIl = this.getc();
            if (llllllllllllllllIIIIIlIIIllIllIl == 61) {
                return 360;
            }
        }
        else {
            if (llllllllllllllllIIIIIlIIIllIlIlI != 124) {
                return llllllllllllllllIIIIIlIIIllIlIlI;
            }
            final int llllllllllllllllIIIIIlIIIllIllII = this.getc();
            if (llllllllllllllllIIIIIlIIIllIllII == 61) {
                return 361;
            }
            if (llllllllllllllllIIIIIlIIIllIllII == 124) {
                return 368;
            }
        }
        final int llllllllllllllllIIIIIlIIIllIlIIl;
        this.ungetc(llllllllllllllllIIIIIlIIIllIlIIl);
        return llllllllllllllllIIIIIlIIIllIlIlI;
    }
    
    private int getc() {
        if (this.lastChar >= 0) {
            final int llllllllllllllllIIIIIlIIIIllIllI = this.lastChar;
            this.lastChar = -1;
            return llllllllllllllllIIIIIlIIIIllIllI;
        }
        if (this.position < this.maxlen) {
            return this.input.charAt(this.position++);
        }
        return -1;
    }
    
    private static boolean isDigit(final int llllllllllllllllIIIIIlIIIlIIllII) {
        return 48 <= llllllllllllllllIIIIIlIIIlIIllII && llllllllllllllllIIIIIlIIIlIIllII <= 57;
    }
    
    private int readNumber(int llllllllllllllllIIIIIlIIlIIIlIlI, final Token llllllllllllllllIIIIIlIIlIIIlIIl) {
        long llllllllllllllllIIIIIlIIlIIIllIl = 0L;
        int llllllllllllllllIIIIIlIIlIIIllII = this.getc();
        if (llllllllllllllllIIIIIlIIlIIIlIlI == 48) {
            if (llllllllllllllllIIIIIlIIlIIIllII == 88 || llllllllllllllllIIIIIlIIlIIIllII == 120) {
                while (true) {
                    llllllllllllllllIIIIIlIIlIIIlIlI = this.getc();
                    if (48 <= llllllllllllllllIIIIIlIIlIIIlIlI && llllllllllllllllIIIIIlIIlIIIlIlI <= 57) {
                        llllllllllllllllIIIIIlIIlIIIllIl = llllllllllllllllIIIIIlIIlIIIllIl * 16L + (llllllllllllllllIIIIIlIIlIIIlIlI - 48);
                    }
                    else if (65 <= llllllllllllllllIIIIIlIIlIIIlIlI && llllllllllllllllIIIIIlIIlIIIlIlI <= 70) {
                        llllllllllllllllIIIIIlIIlIIIllIl = llllllllllllllllIIIIIlIIlIIIllIl * 16L + (llllllllllllllllIIIIIlIIlIIIlIlI - 65 + 10);
                    }
                    else {
                        if (97 > llllllllllllllllIIIIIlIIlIIIlIlI || llllllllllllllllIIIIIlIIlIIIlIlI > 102) {
                            break;
                        }
                        llllllllllllllllIIIIIlIIlIIIllIl = llllllllllllllllIIIIIlIIlIIIllIl * 16L + (llllllllllllllllIIIIIlIIlIIIlIlI - 97 + 10);
                    }
                }
                llllllllllllllllIIIIIlIIlIIIlIIl.longValue = llllllllllllllllIIIIIlIIlIIIllIl;
                if (llllllllllllllllIIIIIlIIlIIIlIlI == 76 || llllllllllllllllIIIIIlIIlIIIlIlI == 108) {
                    return 403;
                }
                this.ungetc(llllllllllllllllIIIIIlIIlIIIlIlI);
                return 402;
            }
            else if (48 <= llllllllllllllllIIIIIlIIlIIIllII && llllllllllllllllIIIIIlIIlIIIllII <= 55) {
                llllllllllllllllIIIIIlIIlIIIllIl = llllllllllllllllIIIIIlIIlIIIllII - 48;
                while (true) {
                    llllllllllllllllIIIIIlIIlIIIlIlI = this.getc();
                    if (48 > llllllllllllllllIIIIIlIIlIIIlIlI || llllllllllllllllIIIIIlIIlIIIlIlI > 55) {
                        break;
                    }
                    llllllllllllllllIIIIIlIIlIIIllIl = llllllllllllllllIIIIIlIIlIIIllIl * 8L + (llllllllllllllllIIIIIlIIlIIIlIlI - 48);
                }
                llllllllllllllllIIIIIlIIlIIIlIIl.longValue = llllllllllllllllIIIIIlIIlIIIllIl;
                if (llllllllllllllllIIIIIlIIlIIIlIlI == 76 || llllllllllllllllIIIIIlIIlIIIlIlI == 108) {
                    return 403;
                }
                this.ungetc(llllllllllllllllIIIIIlIIlIIIlIlI);
                return 402;
            }
        }
        llllllllllllllllIIIIIlIIlIIIllIl = llllllllllllllllIIIIIlIIlIIIlIlI - 48;
        while (48 <= llllllllllllllllIIIIIlIIlIIIllII && llllllllllllllllIIIIIlIIlIIIllII <= 57) {
            llllllllllllllllIIIIIlIIlIIIllIl = llllllllllllllllIIIIIlIIlIIIllIl * 10L + llllllllllllllllIIIIIlIIlIIIllII - 48L;
            llllllllllllllllIIIIIlIIlIIIllII = this.getc();
        }
        llllllllllllllllIIIIIlIIlIIIlIIl.longValue = llllllllllllllllIIIIIlIIlIIIllIl;
        if (llllllllllllllllIIIIIlIIlIIIllII == 70 || llllllllllllllllIIIIIlIIlIIIllII == 102) {
            llllllllllllllllIIIIIlIIlIIIlIIl.doubleValue = (double)llllllllllllllllIIIIIlIIlIIIllIl;
            return 404;
        }
        if (llllllllllllllllIIIIIlIIlIIIllII == 69 || llllllllllllllllIIIIIlIIlIIIllII == 101 || llllllllllllllllIIIIIlIIlIIIllII == 68 || llllllllllllllllIIIIIlIIlIIIllII == 100 || llllllllllllllllIIIIIlIIlIIIllII == 46) {
            final StringBuffer llllllllllllllllIIIIIlIIlIIlIIIl = this.textBuffer;
            llllllllllllllllIIIIIlIIlIIlIIIl.setLength(0);
            llllllllllllllllIIIIIlIIlIIlIIIl.append(llllllllllllllllIIIIIlIIlIIIllIl);
            return this.readDouble(llllllllllllllllIIIIIlIIlIIlIIIl, llllllllllllllllIIIIIlIIlIIIllII, llllllllllllllllIIIIIlIIlIIIlIIl);
        }
        if (llllllllllllllllIIIIIlIIlIIIllII == 76 || llllllllllllllllIIIIIlIIlIIIllII == 108) {
            return 403;
        }
        this.ungetc(llllllllllllllllIIIIIlIIlIIIllII);
        return 402;
    }
    
    private void ungetc(final int llllllllllllllllIIIIIlIIIlIIIllI) {
        this.lastChar = llllllllllllllllIIIIIlIIIlIIIllI;
    }
    
    private static boolean isBlank(final int llllllllllllllllIIIIIlIIIlIIllll) {
        return llllllllllllllllIIIIIlIIIlIIllll == 32 || llllllllllllllllIIIIIlIIIlIIllll == 9 || llllllllllllllllIIIIIlIIIlIIllll == 12 || llllllllllllllllIIIIIlIIIlIIllll == 13 || llllllllllllllllIIIIIlIIIlIIllll == 10;
    }
    
    public double getDouble() {
        return this.currentToken.doubleValue;
    }
    
    public String getString() {
        return this.currentToken.textValue;
    }
    
    private int readDouble(final StringBuffer llllllllllllllllIIIIIlIIIllllllI, int llllllllllllllllIIIIIlIIIllllIIl, final Token llllllllllllllllIIIIIlIIIlllllII) {
        if (llllllllllllllllIIIIIlIIIllllIIl != 69 && llllllllllllllllIIIIIlIIIllllIIl != 101 && llllllllllllllllIIIIIlIIIllllIIl != 68 && llllllllllllllllIIIIIlIIIllllIIl != 100) {
            llllllllllllllllIIIIIlIIIllllllI.append((char)llllllllllllllllIIIIIlIIIllllIIl);
            while (true) {
                llllllllllllllllIIIIIlIIIllllIIl = this.getc();
                if (48 > llllllllllllllllIIIIIlIIIllllIIl || llllllllllllllllIIIIIlIIIllllIIl > 57) {
                    break;
                }
                llllllllllllllllIIIIIlIIIllllllI.append((char)llllllllllllllllIIIIIlIIIllllIIl);
            }
        }
        if (llllllllllllllllIIIIIlIIIllllIIl == 69 || llllllllllllllllIIIIIlIIIllllIIl == 101) {
            llllllllllllllllIIIIIlIIIllllllI.append((char)llllllllllllllllIIIIIlIIIllllIIl);
            llllllllllllllllIIIIIlIIIllllIIl = this.getc();
            if (llllllllllllllllIIIIIlIIIllllIIl == 43 || llllllllllllllllIIIIIlIIIllllIIl == 45) {
                llllllllllllllllIIIIIlIIIllllllI.append((char)llllllllllllllllIIIIIlIIIllllIIl);
                llllllllllllllllIIIIIlIIIllllIIl = this.getc();
            }
            while (48 <= llllllllllllllllIIIIIlIIIllllIIl && llllllllllllllllIIIIIlIIIllllIIl <= 57) {
                llllllllllllllllIIIIIlIIIllllllI.append((char)llllllllllllllllIIIIIlIIIllllIIl);
                llllllllllllllllIIIIIlIIIllllIIl = this.getc();
            }
        }
        try {
            llllllllllllllllIIIIIlIIIlllllII.doubleValue = Double.parseDouble(llllllllllllllllIIIIIlIIIllllllI.toString());
        }
        catch (NumberFormatException llllllllllllllllIIIIIlIIlIIIIIII) {
            return 500;
        }
        if (llllllllllllllllIIIIIlIIIllllIIl == 70 || llllllllllllllllIIIIIlIIIllllIIl == 102) {
            return 404;
        }
        if (llllllllllllllllIIIIIlIIIllllIIl != 68 && llllllllllllllllIIIIIlIIIllllIIl != 100) {
            this.ungetc(llllllllllllllllIIIIIlIIIllllIIl);
        }
        return 405;
    }
    
    public int lookAhead(int llllllllllllllllIIIIIlIIllIlllll) {
        Token llllllllllllllllIIIIIlIIllIllllI = this.lookAheadTokens;
        if (llllllllllllllllIIIIIlIIllIllllI == null) {
            llllllllllllllllIIIIIlIIllIllllI = (this.lookAheadTokens = this.currentToken);
            llllllllllllllllIIIIIlIIllIllllI.next = null;
            this.get(llllllllllllllllIIIIIlIIllIllllI);
        }
        while (llllllllllllllllIIIIIlIIllIlllll-- > 0) {
            if (llllllllllllllllIIIIIlIIllIllllI.next == null) {
                final Token llllllllllllllllIIIIIlIIlllIIIIl = llllllllllllllllIIIIIlIIllIllllI.next = new Token();
                this.get(llllllllllllllllIIIIIlIIlllIIIIl);
            }
            llllllllllllllllIIIIIlIIllIllllI = llllllllllllllllIIIIIlIIllIllllI.next;
        }
        this.currentToken = llllllllllllllllIIIIIlIIllIllllI;
        return llllllllllllllllIIIIIlIIllIllllI.tokenId;
    }
}
