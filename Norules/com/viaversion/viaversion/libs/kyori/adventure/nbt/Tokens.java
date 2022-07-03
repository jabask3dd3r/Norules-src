package com.viaversion.viaversion.libs.kyori.adventure.nbt;

final class Tokens
{
    static boolean id(final char lllllllllllllIIIllIlIlIIlllIIIlI) {
        return (lllllllllllllIIIllIlIlIIlllIIIlI >= 'a' && lllllllllllllIIIllIlIlIIlllIIIlI <= 'z') || (lllllllllllllIIIllIlIlIIlllIIIlI >= 'A' && lllllllllllllIIIllIlIlIIlllIIIlI <= 'Z') || (lllllllllllllIIIllIlIlIIlllIIIlI >= '0' && lllllllllllllIIIllIlIlIIlllIIIlI <= '9') || lllllllllllllIIIllIlIlIIlllIIIlI == '-' || lllllllllllllIIIllIlIlIIlllIIIlI == '_' || lllllllllllllIIIllIlIlIIlllIIIlI == '.' || lllllllllllllIIIllIlIlIIlllIIIlI == '+';
    }
    
    private Tokens() {
    }
    
    static {
        TYPE_LONG = 'l';
        TYPE_DOUBLE = 'd';
        SINGLE_QUOTE = '\'';
        TYPE_BYTE = 'b';
        COMPOUND_KEY_TERMINATOR = ':';
        TYPE_FLOAT = 'f';
        ARRAY_SIGNATURE_SEPARATOR = ';';
        VALUE_SEPARATOR = ',';
        COMPOUND_BEGIN = '{';
        TYPE_SHORT = 's';
        TYPE_INT = 'i';
        DOUBLE_QUOTE = '\"';
        LITERAL_TRUE = "true";
        ARRAY_END = ']';
        ESCAPE_MARKER = '\\';
        LITERAL_FALSE = "false";
        COMPOUND_END = '}';
        ARRAY_BEGIN = '[';
        EOF = '\0';
        NEWLINE = System.getProperty("line.separator", "\n");
    }
    
    static boolean numeric(final char lllllllllllllIIIllIlIlIIllIllllI) {
        return (lllllllllllllIIIllIlIlIIllIllllI >= '0' && lllllllllllllIIIllIlIlIIllIllllI <= '9') || lllllllllllllIIIllIlIlIIllIllllI == '+' || lllllllllllllIIIllIlIlIIllIllllI == '-' || lllllllllllllIIIllIlIlIIllIllllI == 'e' || lllllllllllllIIIllIlIlIIllIllllI == 'E' || lllllllllllllIIIllIlIlIIllIllllI == '.';
    }
}
