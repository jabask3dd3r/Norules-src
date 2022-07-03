package net.minecraft.client.util;

import java.util.*;
import java.io.*;
import com.google.common.collect.*;
import org.apache.commons.lang3.*;

public class JsonException extends IOException
{
    private final /* synthetic */ String message;
    private final /* synthetic */ List<Entry> entries;
    
    @Override
    public String getMessage() {
        return String.valueOf(new StringBuilder("Invalid ").append(this.entries.get(this.entries.size() - 1)).append(": ").append(this.message));
    }
    
    public void prependJsonKey(final String llllllllllllllIlIlIIlIlIlllIIIlI) {
        this.entries.get(0).addJsonKey(llllllllllllllIlIlIIlIlIlllIIIlI);
    }
    
    public static JsonException forException(final Exception llllllllllllllIlIlIIlIlIllIlIllI) {
        if (llllllllllllllIlIlIIlIlIllIlIllI instanceof JsonException) {
            return (JsonException)llllllllllllllIlIlIIlIlIllIlIllI;
        }
        String llllllllllllllIlIlIIlIlIllIlIlIl = llllllllllllllIlIlIIlIlIllIlIllI.getMessage();
        if (llllllllllllllIlIlIIlIlIllIlIllI instanceof FileNotFoundException) {
            llllllllllllllIlIlIIlIlIllIlIlIl = "File not found";
        }
        return new JsonException(llllllllllllllIlIlIIlIlIllIlIlIl, llllllllllllllIlIlIIlIlIllIlIllI);
    }
    
    public void setFilenameAndFlush(final String llllllllllllllIlIlIIlIlIllIllllI) {
        Entry.access$2(this.entries.get(0), llllllllllllllIlIlIIlIlIllIllllI);
        this.entries.add(0, new Entry(null));
    }
    
    public JsonException(final String llllllllllllllIlIlIIlIlIllllIIIl) {
        this.entries = (List<Entry>)Lists.newArrayList();
        this.entries.add(new Entry(null));
        this.message = llllllllllllllIlIlIIlIlIllllIIIl;
    }
    
    public JsonException(final String llllllllllllllIlIlIIlIlIlllIllII, final Throwable llllllllllllllIlIlIIlIlIlllIlIll) {
        super(llllllllllllllIlIlIIlIlIlllIlIll);
        this.entries = (List<Entry>)Lists.newArrayList();
        this.entries.add(new Entry(null));
        this.message = llllllllllllllIlIlIIlIlIlllIllII;
    }
    
    public static class Entry
    {
        private /* synthetic */ String filename;
        private final /* synthetic */ List<String> jsonKeys;
        
        static /* synthetic */ void access$2(final Entry llllllllllllllllIllIlIlIlllIIlll, final String llllllllllllllllIllIlIlIlllIIllI) {
            llllllllllllllllIllIlIlIlllIIlll.filename = llllllllllllllllIllIlIlIlllIIllI;
        }
        
        public String getJsonKeys() {
            return StringUtils.join((Iterable)this.jsonKeys, "->");
        }
        
        private Entry() {
            this.jsonKeys = (List<String>)Lists.newArrayList();
        }
        
        @Override
        public String toString() {
            if (this.filename != null) {
                return this.jsonKeys.isEmpty() ? this.filename : String.valueOf(new StringBuilder(String.valueOf(this.filename)).append(" ").append(this.getJsonKeys()));
            }
            return this.jsonKeys.isEmpty() ? "(Unknown file)" : String.valueOf(new StringBuilder("(Unknown file) ").append(this.getJsonKeys()));
        }
        
        private void addJsonKey(final String llllllllllllllllIllIlIlIlllllIII) {
            this.jsonKeys.add(0, llllllllllllllllIllIlIlIlllllIII);
        }
    }
}
