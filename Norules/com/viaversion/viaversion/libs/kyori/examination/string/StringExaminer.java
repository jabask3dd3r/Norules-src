package com.viaversion.viaversion.libs.kyori.examination.string;

import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StringExaminer extends AbstractExaminer<String>
{
    private final /* synthetic */ Function<String, String> escaper;
    private static final /* synthetic */ Collector<CharSequence, ?, String> COMMA_CURLY;
    private static final /* synthetic */ Collector<CharSequence, ?, String> COMMA_SQUARE;
    private static final /* synthetic */ Function<String, String> DEFAULT_ESCAPER;
    
    @Override
    protected <K, V> String map(final Map<K, V> llllllllllllllIIIlllllllIIIIlIII, final Stream<Map.Entry<String, String>> llllllllllllllIIIlllllllIIIIIlll) {
        return llllllllllllllIIIlllllllIIIIIlll.map(llllllllllllllIIIlllllIlIllIllIl -> String.valueOf(new StringBuilder().append(llllllllllllllIIIlllllIlIllIllIl.getKey()).append('=').append((String)llllllllllllllIIIlllllIlIllIllIl.getValue()))).collect((Collector<? super Object, ?, String>)StringExaminer.COMMA_CURLY);
    }
    
    @Override
    protected <T> String stream(final Stream<T> llllllllllllllIIIllllllIlIIllIII) {
        return llllllllllllllIIIllllllIlIIllIII.map((Function<? super T, ?>)this::examine).collect((Collector<? super Object, ?, String>)StringExaminer.COMMA_SQUARE);
    }
    
    @Override
    protected <E> String collection(final Collection<E> llllllllllllllIIIlllllllIIIlIlll, final Stream<String> llllllllllllllIIIlllllllIIIllIII) {
        return llllllllllllllIIIlllllllIIIllIII.collect(StringExaminer.COMMA_SQUARE);
    }
    
    @Override
    protected String scalar(final Object llllllllllllllIIIlllllllIIIIIIII) {
        return String.valueOf(llllllllllllllIIIlllllllIIIIIIII);
    }
    
    @Override
    protected String examinable(final String llllllllllllllIIIlllllllIIIlIIII, final Stream<Map.Entry<String, String>> llllllllllllllIIIlllllllIIIIllll) {
        return String.valueOf(new StringBuilder().append(llllllllllllllIIIlllllllIIIlIIII).append(llllllllllllllIIIlllllllIIIIllll.map(llllllllllllllIIIlllllIlIllIlIlI -> String.valueOf(new StringBuilder().append(llllllllllllllIIIlllllIlIllIlIlI.getKey()).append('=').append((String)llllllllllllllIIIlllllIlIllIlIlI.getValue()))).collect((Collector<? super Object, ?, String>)StringExaminer.COMMA_CURLY)));
    }
    
    @Override
    public String examine(final long llllllllllllllIIIllllllIlIllIIIl) {
        return String.valueOf(llllllllllllllIIIllllllIlIllIIIl);
    }
    
    private static String array(final int llllllllllllllIIIllllllIIllIlIlI, final IntFunction<String> llllllllllllllIIIllllllIIllIlIll) {
        final StringBuilder llllllllllllllIIIllllllIIllIIllI = new StringBuilder();
        llllllllllllllIIIllllllIIllIIllI.append('[');
        for (int llllllllllllllIIIllllllIIllIlIIl = 0; llllllllllllllIIIllllllIIllIlIIl < llllllllllllllIIIllllllIIllIlIlI; ++llllllllllllllIIIllllllIIllIlIIl) {
            llllllllllllllIIIllllllIIllIIllI.append(llllllllllllllIIIllllllIIllIlIll.apply(llllllllllllllIIIllllllIIllIlIIl));
            if (llllllllllllllIIIllllllIIllIlIIl + 1 < llllllllllllllIIIllllllIIllIlIlI) {
                llllllllllllllIIIllllllIIllIIllI.append(", ");
            }
        }
        llllllllllllllIIIllllllIIllIIllI.append(']');
        return String.valueOf(llllllllllllllIIIllllllIIllIIllI);
    }
    
    @Override
    public String examine(final char llllllllllllllIIIllllllIlllIIIlI) {
        return String.valueOf(new StringBuilder().append('\'').append(this.escaper.apply(String.valueOf(llllllllllllllIIIllllllIlllIIIlI))).append('\''));
    }
    
    @Override
    protected String stream(final DoubleStream llllllllllllllIIIllllllIlIIlIIIl) {
        return llllllllllllllIIIllllllIlIIlIIIl.mapToObj((DoubleFunction<?>)this::examine).collect((Collector<? super Object, ?, String>)StringExaminer.COMMA_SQUARE);
    }
    
    @Override
    public String examine(final long[] llllllllllllllIIIllllllIlIlIlIll) {
        if (llllllllllllllIIIllllllIlIlIlIll == null) {
            return this.nil();
        }
        return array(llllllllllllllIIIllllllIlIlIlIll.length, llllllllllllllIIIlllllIllIlIIlIl -> this.examine(llllllllllllllIIIllllllIlIlIlIll[llllllllllllllIIIlllllIllIlIIlIl]));
    }
    
    @Override
    public String examine(final double[] llllllllllllllIIIllllllIllIIllll) {
        if (llllllllllllllIIIllllllIllIIllll == null) {
            return this.nil();
        }
        return array(llllllllllllllIIIllllllIllIIllll.length, llllllllllllllIIIlllllIllIIIlIlI -> this.examine(llllllllllllllIIIllllllIllIIllll[llllllllllllllIIIlllllIllIIIlIlI]));
    }
    
    @Override
    public String examine(final String llllllllllllllIIIllllllIIlllllII) {
        if (llllllllllllllIIIllllllIIlllllII == null) {
            return this.nil();
        }
        return String.valueOf(new StringBuilder().append('\"').append(this.escaper.apply(llllllllllllllIIIllllllIIlllllII)).append('\"'));
    }
    
    @Override
    public String examine(final byte llllllllllllllIIIllllllIlllIllll) {
        return String.valueOf(llllllllllllllIIIllllllIlllIllll);
    }
    
    public StringExaminer(final Function<String, String> llllllllllllllIIIlllllllIIlIIlIl) {
        this.escaper = llllllllllllllIIIlllllllIIlIIlIl;
    }
    
    @Override
    public String examine(final boolean llllllllllllllIIIllllllIlllllIll) {
        return String.valueOf(llllllllllllllIIIllllllIlllllIll);
    }
    
    @Override
    public String examine(final char[] llllllllllllllIIIllllllIllIllIll) {
        if (llllllllllllllIIIllllllIllIllIll == null) {
            return this.nil();
        }
        return array(llllllllllllllIIIllllllIllIllIll.length, llllllllllllllIIIlllllIllIIIIlII -> this.examine(llllllllllllllIIIllllllIllIllIll[llllllllllllllIIIlllllIllIIIIlII]));
    }
    
    @Override
    public String examine(final float[] llllllllllllllIIIllllllIllIIIIll) {
        if (llllllllllllllIIIllllllIllIIIIll == null) {
            return this.nil();
        }
        return array(llllllllllllllIIIllllllIllIIIIll.length, llllllllllllllIIIlllllIllIIlIllI -> this.examine(llllllllllllllIIIllllllIllIIIIll[llllllllllllllIIIlllllIllIIlIllI]));
    }
    
    @Override
    protected String stream(final IntStream llllllllllllllIIIllllllIlIIIlIlI) {
        return llllllllllllllIIIllllllIlIIIlIlI.mapToObj((IntFunction<?>)this::examine).collect((Collector<? super Object, ?, String>)StringExaminer.COMMA_SQUARE);
    }
    
    @Override
    public String examine(final boolean[] llllllllllllllIIIllllllIllllIlIl) {
        if (llllllllllllllIIIllllllIllllIlIl == null) {
            return this.nil();
        }
        return array(llllllllllllllIIIllllllIllllIlIl.length, llllllllllllllIIIlllllIlIllIllll -> this.examine(llllllllllllllIIIllllllIllllIlIl[llllllllllllllIIIlllllIlIllIllll]));
    }
    
    @Override
    protected String stream(final LongStream llllllllllllllIIIllllllIlIIIIIll) {
        return llllllllllllllIIIllllllIlIIIIIll.mapToObj((LongFunction<?>)this::examine).collect((Collector<? super Object, ?, String>)StringExaminer.COMMA_SQUARE);
    }
    
    @Override
    public String examine(final double llllllllllllllIIIllllllIllIlIlIl) {
        return withSuffix(String.valueOf(llllllllllllllIIIllllllIllIlIlIl), 'd');
    }
    
    @Override
    protected <E> String array(final E[] llllllllllllllIIIlllllllIIIlllll, final Stream<String> llllllllllllllIIIlllllllIIIllllI) {
        return llllllllllllllIIIlllllllIIIllllI.collect(StringExaminer.COMMA_SQUARE);
    }
    
    @Override
    public String examine(final float llllllllllllllIIIllllllIllIIlIIl) {
        return withSuffix(String.valueOf(llllllllllllllIIIllllllIllIIlIIl), 'f');
    }
    
    @Override
    public String examine(final int[] llllllllllllllIIIllllllIlIllIlll) {
        if (llllllllllllllIIIllllllIlIllIlll == null) {
            return this.nil();
        }
        return array(llllllllllllllIIIllllllIlIllIlll.length, llllllllllllllIIIlllllIllIIlllII -> this.examine(llllllllllllllIIIllllllIlIllIlll[llllllllllllllIIIlllllIllIIlllII]));
    }
    
    @Override
    protected String nil() {
        return "null";
    }
    
    public static StringExaminer simpleEscaping() {
        return Instances.SIMPLE_ESCAPING;
    }
    
    @Override
    public String examine(final short[] llllllllllllllIIIllllllIlIIlllll) {
        if (llllllllllllllIIIllllllIlIIlllll == null) {
            return this.nil();
        }
        return array(llllllllllllllIIIllllllIlIIlllll.length, llllllllllllllIIIlllllIllIlIlllI -> this.examine(llllllllllllllIIIllllllIlIIlllll[llllllllllllllIIIlllllIllIlIlllI]));
    }
    
    @Override
    public String examine(final short llllllllllllllIIIllllllIlIlIIlIl) {
        return String.valueOf(llllllllllllllIIIllllllIlIlIIlIl);
    }
    
    static {
        DEFAULT_ESCAPER = (llllllllllllllIIIlllllIlIllIIllI -> llllllllllllllIIIlllllIlIllIIllI.replace("\"", "\\\"").replace("\\", "\\\\").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t"));
        COMMA_CURLY = Collectors.joining(", ", "{", "}");
        COMMA_SQUARE = Collectors.joining(", ", "[", "]");
    }
    
    private static String withSuffix(final String llllllllllllllIIIllllllIIlllIlIl, final char llllllllllllllIIIllllllIIlllIlII) {
        return String.valueOf(new StringBuilder().append(llllllllllllllIIIllllllIIlllIlIl).append(llllllllllllllIIIllllllIIlllIlII));
    }
    
    @Override
    public String examine(final byte[] llllllllllllllIIIllllllIlllIlIIl) {
        if (llllllllllllllIIIllllllIlllIlIIl == null) {
            return this.nil();
        }
        return array(llllllllllllllIIIllllllIlllIlIIl.length, llllllllllllllIIIlllllIlIllllIll -> this.examine(llllllllllllllIIIllllllIlllIlIIl[llllllllllllllIIIlllllIlIllllIll]));
    }
    
    @Override
    public String examine(final int llllllllllllllIIIllllllIlIllllIl) {
        return String.valueOf(llllllllllllllIIIllllllIlIllllIl);
    }
    
    private static final class Instances
    {
        static final /* synthetic */ StringExaminer SIMPLE_ESCAPING;
        
        static {
            SIMPLE_ESCAPING = new StringExaminer(StringExaminer.DEFAULT_ESCAPER);
        }
    }
}
