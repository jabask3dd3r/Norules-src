package com.viaversion.viaversion.api.minecraft.nbt;

final class Tokens
{
    static {
        COMPOUND_END = '}';
        TYPE_FLOAT = 'F';
        EOF = '\0';
        ARRAY_SIGNATURE_SEPARATOR = ';';
        TYPE_DOUBLE = 'D';
        ESCAPE_MARKER = '\\';
        ARRAY_BEGIN = '[';
        TYPE_LONG = 'L';
        TYPE_INT = 'I';
        ARRAY_END = ']';
        COMPOUND_BEGIN = '{';
        COMPOUND_KEY_TERMINATOR = ':';
        VALUE_SEPARATOR = ',';
        SINGLE_QUOTE = '\'';
        TYPE_BYTE = 'B';
        TYPE_SHORT = 'S';
        DOUBLE_QUOTE = '\"';
    }
    
    static boolean id(final char llllllllllllllIIIllIlIIIIlIllIII) {
        return (llllllllllllllIIIllIlIIIIlIllIII >= 'a' && llllllllllllllIIIllIlIIIIlIllIII <= 'z') || (llllllllllllllIIIllIlIIIIlIllIII >= 'A' && llllllllllllllIIIllIlIIIIlIllIII <= 'Z') || (llllllllllllllIIIllIlIIIIlIllIII >= '0' && llllllllllllllIIIllIlIIIIlIllIII <= '9') || llllllllllllllIIIllIlIIIIlIllIII == '-' || llllllllllllllIIIllIlIIIIlIllIII == '_' || llllllllllllllIIIllIlIIIIlIllIII == '.' || llllllllllllllIIIllIlIIIIlIllIII == '+';
    }
    
    private Tokens() {
    }
    
    static boolean numeric(final char llllllllllllllIIIllIlIIIIlIlIlIl) {
        return (llllllllllllllIIIllIlIIIIlIlIlIl >= '0' && llllllllllllllIIIllIlIIIIlIlIlIl <= '9') || llllllllllllllIIIllIlIIIIlIlIlIl == '+' || llllllllllllllIIIllIlIIIIlIlIlIl == '-' || llllllllllllllIIIllIlIIIIlIlIlIl == 'e' || llllllllllllllIIIllIlIIIIlIlIlIl == 'E' || llllllllllllllIIIllIlIIIIlIlIlIl == '.';
    }
}
