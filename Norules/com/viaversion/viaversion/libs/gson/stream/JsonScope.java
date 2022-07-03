package com.viaversion.viaversion.libs.gson.stream;

final class JsonScope
{
    static {
        EMPTY_OBJECT = 3;
        EMPTY_ARRAY = 1;
        NONEMPTY_ARRAY = 2;
        NONEMPTY_DOCUMENT = 7;
        DANGLING_NAME = 4;
        CLOSED = 8;
        EMPTY_DOCUMENT = 6;
        NONEMPTY_OBJECT = 5;
    }
}
