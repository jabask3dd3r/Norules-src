package org.yaml.snakeyaml.representer;

import java.util.regex.*;
import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.nodes.*;
import org.yaml.snakeyaml.external.biz.base64Coder.*;
import org.yaml.snakeyaml.error.*;
import java.math.*;
import org.yaml.snakeyaml.reader.*;
import java.io.*;
import java.util.*;

class SafeRepresenter extends BaseRepresenter
{
    private static final /* synthetic */ Pattern MULTILINE_PATTERN;
    protected /* synthetic */ TimeZone timeZone;
    protected /* synthetic */ Map<Class<?>, Tag> classTags;
    protected /* synthetic */ DumperOptions.NonPrintableStyle nonPrintableStyle;
    
    public SafeRepresenter(final DumperOptions lllllllllllllIIIIllIlIIllIIIIlII) {
        this.timeZone = null;
        this.nullRepresenter = new RepresentNull();
        this.representers.put(String.class, new RepresentString());
        this.representers.put(Boolean.class, new RepresentBoolean());
        this.representers.put(Character.class, new RepresentString());
        this.representers.put(UUID.class, new RepresentUuid());
        this.representers.put(byte[].class, new RepresentByteArray());
        final Represent lllllllllllllIIIIllIlIIllIIIIIll = new RepresentPrimitiveArray();
        this.representers.put(short[].class, lllllllllllllIIIIllIlIIllIIIIIll);
        this.representers.put(int[].class, lllllllllllllIIIIllIlIIllIIIIIll);
        this.representers.put(long[].class, lllllllllllllIIIIllIlIIllIIIIIll);
        this.representers.put(float[].class, lllllllllllllIIIIllIlIIllIIIIIll);
        this.representers.put(double[].class, lllllllllllllIIIIllIlIIllIIIIIll);
        this.representers.put(char[].class, lllllllllllllIIIIllIlIIllIIIIIll);
        this.representers.put(boolean[].class, lllllllllllllIIIIllIlIIllIIIIIll);
        this.multiRepresenters.put(Number.class, new RepresentNumber());
        this.multiRepresenters.put(List.class, new RepresentList());
        this.multiRepresenters.put(Map.class, new RepresentMap());
        this.multiRepresenters.put(Set.class, new RepresentSet());
        this.multiRepresenters.put(Iterator.class, new RepresentIterator());
        this.multiRepresenters.put(new Object[0].getClass(), new RepresentArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        this.multiRepresenters.put(Enum.class, new RepresentEnum());
        this.multiRepresenters.put(Calendar.class, new RepresentDate());
        this.classTags = new HashMap<Class<?>, Tag>();
        this.nonPrintableStyle = lllllllllllllIIIIllIlIIllIIIIlII.getNonPrintableStyle();
    }
    
    protected Tag getTag(final Class<?> lllllllllllllIIIIllIlIIlIllllIII, final Tag lllllllllllllIIIIllIlIIlIlllIlll) {
        if (this.classTags.containsKey(lllllllllllllIIIIllIlIIlIllllIII)) {
            return this.classTags.get(lllllllllllllIIIIllIlIIlIllllIII);
        }
        return lllllllllllllIIIIllIlIIlIlllIlll;
    }
    
    public SafeRepresenter() {
        this(new DumperOptions());
    }
    
    public Tag addClassTag(final Class<?> lllllllllllllIIIIllIlIIlIllIllll, final Tag lllllllllllllIIIIllIlIIlIlllIIIl) {
        if (lllllllllllllIIIIllIlIIlIlllIIIl == null) {
            throw new NullPointerException("Tag must be provided.");
        }
        return this.classTags.put(lllllllllllllIIIIllIlIIlIllIllll, lllllllllllllIIIIllIlIIlIlllIIIl);
    }
    
    static {
        MULTILINE_PATTERN = Pattern.compile("\n|\u0085|\u2028|\u2029");
    }
    
    public void setTimeZone(final TimeZone lllllllllllllIIIIllIlIIlIllIIlll) {
        this.timeZone = lllllllllllllIIIIllIlIIlIllIIlll;
    }
    
    public TimeZone getTimeZone() {
        return this.timeZone;
    }
    
    protected class RepresentArray implements Represent
    {
        @Override
        public Node representData(final Object lllllllllllllllIlIIIIIIIIIlIIlll) {
            final Object[] lllllllllllllllIlIIIIIIIIIlIlIlI = (Object[])lllllllllllllllIlIIIIIIIIIlIIlll;
            final List<Object> lllllllllllllllIlIIIIIIIIIlIlIIl = Arrays.asList(lllllllllllllllIlIIIIIIIIIlIlIlI);
            return SafeRepresenter.this.representSequence(Tag.SEQ, lllllllllllllllIlIIIIIIIIIlIlIIl, DumperOptions.FlowStyle.AUTO);
        }
    }
    
    protected class RepresentByteArray implements Represent
    {
        @Override
        public Node representData(final Object llllllllllllllIIlIIIIlllIllIlIII) {
            final char[] llllllllllllllIIlIIIIlllIllIIllI = Base64Coder.encode((byte[])llllllllllllllIIlIIIIlllIllIlIII);
            return SafeRepresenter.this.representScalar(Tag.BINARY, String.valueOf(llllllllllllllIIlIIIIlllIllIIllI), DumperOptions.ScalarStyle.LITERAL);
        }
    }
    
    protected class RepresentIterator implements Represent
    {
        @Override
        public Node representData(final Object lllllllllllllllIIIlIllIllllIIIlI) {
            final Iterator<Object> lllllllllllllllIIIlIllIllllIIIIl = (Iterator<Object>)lllllllllllllllIIIlIllIllllIIIlI;
            return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(lllllllllllllllIIIlIllIllllIIIlI.getClass(), Tag.SEQ), new IteratorWrapper(lllllllllllllllIIIlIllIllllIIIIl), DumperOptions.FlowStyle.AUTO);
        }
    }
    
    private static class IteratorWrapper implements Iterable<Object>
    {
        private /* synthetic */ Iterator<Object> iter;
        
        public IteratorWrapper(final Iterator<Object> llllllllllllllIIIlllllllIlIIIllI) {
            this.iter = llllllllllllllIIIlllllllIlIIIllI;
        }
        
        @Override
        public Iterator<Object> iterator() {
            return this.iter;
        }
    }
    
    protected class RepresentBoolean implements Represent
    {
        @Override
        public Node representData(final Object lllllllllllllIIIlIIllIIllIIllIlI) {
            String lllllllllllllIIIlIIllIIllIIlllII = null;
            if (Boolean.TRUE.equals(lllllllllllllIIIlIIllIIllIIllIlI)) {
                final String lllllllllllllIIIlIIllIIllIIlllll = "true";
            }
            else {
                lllllllllllllIIIlIIllIIllIIlllII = "false";
            }
            return SafeRepresenter.this.representScalar(Tag.BOOL, lllllllllllllIIIlIIllIIllIIlllII);
        }
    }
    
    protected class RepresentPrimitiveArray implements Represent
    {
        private List<Double> asDoubleList(final Object llllllllllllllIIlllIIIIlIlIlIIIl) {
            final double[] llllllllllllllIIlllIIIIlIlIlIIll = (double[])llllllllllllllIIlllIIIIlIlIlIIIl;
            final List<Double> llllllllllllllIIlllIIIIlIlIlIIlI = new ArrayList<Double>(llllllllllllllIIlllIIIIlIlIlIIll.length);
            for (int llllllllllllllIIlllIIIIlIlIlIllI = 0; llllllllllllllIIlllIIIIlIlIlIllI < llllllllllllllIIlllIIIIlIlIlIIll.length; ++llllllllllllllIIlllIIIIlIlIlIllI) {
                llllllllllllllIIlllIIIIlIlIlIIlI.add(llllllllllllllIIlllIIIIlIlIlIIll[llllllllllllllIIlllIIIIlIlIlIllI]);
            }
            return llllllllllllllIIlllIIIIlIlIlIIlI;
        }
        
        private List<Boolean> asBooleanList(final Object llllllllllllllIIlllIIIIlIIllIlll) {
            final boolean[] llllllllllllllIIlllIIIIlIIlllIIl = (boolean[])llllllllllllllIIlllIIIIlIIllIlll;
            final List<Boolean> llllllllllllllIIlllIIIIlIIlllIII = new ArrayList<Boolean>(llllllllllllllIIlllIIIIlIIlllIIl.length);
            for (int llllllllllllllIIlllIIIIlIIllllII = 0; llllllllllllllIIlllIIIIlIIllllII < llllllllllllllIIlllIIIIlIIlllIIl.length; ++llllllllllllllIIlllIIIIlIIllllII) {
                llllllllllllllIIlllIIIIlIIlllIII.add(llllllllllllllIIlllIIIIlIIlllIIl[llllllllllllllIIlllIIIIlIIllllII]);
            }
            return llllllllllllllIIlllIIIIlIIlllIII;
        }
        
        private List<Character> asCharList(final Object llllllllllllllIIlllIIIIlIlIIIlll) {
            final char[] llllllllllllllIIlllIIIIlIlIIIllI = (char[])llllllllllllllIIlllIIIIlIlIIIlll;
            final List<Character> llllllllllllllIIlllIIIIlIlIIIlIl = new ArrayList<Character>(llllllllllllllIIlllIIIIlIlIIIllI.length);
            for (int llllllllllllllIIlllIIIIlIlIIlIIl = 0; llllllllllllllIIlllIIIIlIlIIlIIl < llllllllllllllIIlllIIIIlIlIIIllI.length; ++llllllllllllllIIlllIIIIlIlIIlIIl) {
                llllllllllllllIIlllIIIIlIlIIIlIl.add(llllllllllllllIIlllIIIIlIlIIIllI[llllllllllllllIIlllIIIIlIlIIlIIl]);
            }
            return llllllllllllllIIlllIIIIlIlIIIlIl;
        }
        
        @Override
        public Node representData(final Object llllllllllllllIIlllIIIIllIlIIIII) {
            final Class<?> llllllllllllllIIlllIIIIllIIlllll = llllllllllllllIIlllIIIIllIlIIIII.getClass().getComponentType();
            if (Byte.TYPE == llllllllllllllIIlllIIIIllIIlllll) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asByteList(llllllllllllllIIlllIIIIllIlIIIII), DumperOptions.FlowStyle.AUTO);
            }
            if (Short.TYPE == llllllllllllllIIlllIIIIllIIlllll) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asShortList(llllllllllllllIIlllIIIIllIlIIIII), DumperOptions.FlowStyle.AUTO);
            }
            if (Integer.TYPE == llllllllllllllIIlllIIIIllIIlllll) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asIntList(llllllllllllllIIlllIIIIllIlIIIII), DumperOptions.FlowStyle.AUTO);
            }
            if (Long.TYPE == llllllllllllllIIlllIIIIllIIlllll) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asLongList(llllllllllllllIIlllIIIIllIlIIIII), DumperOptions.FlowStyle.AUTO);
            }
            if (Float.TYPE == llllllllllllllIIlllIIIIllIIlllll) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asFloatList(llllllllllllllIIlllIIIIllIlIIIII), DumperOptions.FlowStyle.AUTO);
            }
            if (Double.TYPE == llllllllllllllIIlllIIIIllIIlllll) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asDoubleList(llllllllllllllIIlllIIIIllIlIIIII), DumperOptions.FlowStyle.AUTO);
            }
            if (Character.TYPE == llllllllllllllIIlllIIIIllIIlllll) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asCharList(llllllllllllllIIlllIIIIllIlIIIII), DumperOptions.FlowStyle.AUTO);
            }
            if (Boolean.TYPE == llllllllllllllIIlllIIIIllIIlllll) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asBooleanList(llllllllllllllIIlllIIIIllIlIIIII), DumperOptions.FlowStyle.AUTO);
            }
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected primitive '").append(llllllllllllllIIlllIIIIllIIlllll.getCanonicalName()).append("'")));
        }
        
        private List<Short> asShortList(final Object llllllllllllllIIlllIIIIllIIIIlIl) {
            final short[] llllllllllllllIIlllIIIIllIIIIlll = (short[])llllllllllllllIIlllIIIIllIIIIlIl;
            final List<Short> llllllllllllllIIlllIIIIllIIIIllI = new ArrayList<Short>(llllllllllllllIIlllIIIIllIIIIlll.length);
            for (int llllllllllllllIIlllIIIIllIIIlIlI = 0; llllllllllllllIIlllIIIIllIIIlIlI < llllllllllllllIIlllIIIIllIIIIlll.length; ++llllllllllllllIIlllIIIIllIIIlIlI) {
                llllllllllllllIIlllIIIIllIIIIllI.add(llllllllllllllIIlllIIIIllIIIIlll[llllllllllllllIIlllIIIIllIIIlIlI]);
            }
            return llllllllllllllIIlllIIIIllIIIIllI;
        }
        
        private List<Integer> asIntList(final Object llllllllllllllIIlllIIIIlIllllIll) {
            final int[] llllllllllllllIIlllIIIIlIllllIlI = (int[])llllllllllllllIIlllIIIIlIllllIll;
            final List<Integer> llllllllllllllIIlllIIIIlIllllIIl = new ArrayList<Integer>(llllllllllllllIIlllIIIIlIllllIlI.length);
            for (int llllllllllllllIIlllIIIIlIlllllIl = 0; llllllllllllllIIlllIIIIlIlllllIl < llllllllllllllIIlllIIIIlIllllIlI.length; ++llllllllllllllIIlllIIIIlIlllllIl) {
                llllllllllllllIIlllIIIIlIllllIIl.add(llllllllllllllIIlllIIIIlIllllIlI[llllllllllllllIIlllIIIIlIlllllIl]);
            }
            return llllllllllllllIIlllIIIIlIllllIIl;
        }
        
        private List<Byte> asByteList(final Object llllllllllllllIIlllIIIIllIIlIlIl) {
            final byte[] llllllllllllllIIlllIIIIllIIlIlII = (byte[])llllllllllllllIIlllIIIIllIIlIlIl;
            final List<Byte> llllllllllllllIIlllIIIIllIIlIIll = new ArrayList<Byte>(llllllllllllllIIlllIIIIllIIlIlII.length);
            for (int llllllllllllllIIlllIIIIllIIlIlll = 0; llllllllllllllIIlllIIIIllIIlIlll < llllllllllllllIIlllIIIIllIIlIlII.length; ++llllllllllllllIIlllIIIIllIIlIlll) {
                llllllllllllllIIlllIIIIllIIlIIll.add(llllllllllllllIIlllIIIIllIIlIlII[llllllllllllllIIlllIIIIllIIlIlll]);
            }
            return llllllllllllllIIlllIIIIllIIlIIll;
        }
        
        private List<Long> asLongList(final Object llllllllllllllIIlllIIIIlIllIlllI) {
            final long[] llllllllllllllIIlllIIIIlIllIllIl = (long[])llllllllllllllIIlllIIIIlIllIlllI;
            final List<Long> llllllllllllllIIlllIIIIlIllIllII = new ArrayList<Long>(llllllllllllllIIlllIIIIlIllIllIl.length);
            for (int llllllllllllllIIlllIIIIlIlllIIII = 0; llllllllllllllIIlllIIIIlIlllIIII < llllllllllllllIIlllIIIIlIllIllIl.length; ++llllllllllllllIIlllIIIIlIlllIIII) {
                llllllllllllllIIlllIIIIlIllIllII.add(llllllllllllllIIlllIIIIlIllIllIl[llllllllllllllIIlllIIIIlIlllIIII]);
            }
            return llllllllllllllIIlllIIIIlIllIllII;
        }
        
        private List<Float> asFloatList(final Object llllllllllllllIIlllIIIIlIlIllllI) {
            final float[] llllllllllllllIIlllIIIIlIllIIIII = (float[])llllllllllllllIIlllIIIIlIlIllllI;
            final List<Float> llllllllllllllIIlllIIIIlIlIlllll = new ArrayList<Float>(llllllllllllllIIlllIIIIlIllIIIII.length);
            for (int llllllllllllllIIlllIIIIlIllIIIll = 0; llllllllllllllIIlllIIIIlIllIIIll < llllllllllllllIIlllIIIIlIllIIIII.length; ++llllllllllllllIIlllIIIIlIllIIIll) {
                llllllllllllllIIlllIIIIlIlIlllll.add(llllllllllllllIIlllIIIIlIllIIIII[llllllllllllllIIlllIIIIlIllIIIll]);
            }
            return llllllllllllllIIlllIIIIlIlIlllll;
        }
    }
    
    protected class RepresentDate implements Represent
    {
        @Override
        public Node representData(final Object llllllllllllIllllIllllIlllIIlIIl) {
            Calendar llllllllllllIllllIllllIlllIIlIII = null;
            if (llllllllllllIllllIllllIlllIIlIIl instanceof Calendar) {
                final Calendar llllllllllllIllllIllllIlllIIlllI = (Calendar)llllllllllllIllllIllllIlllIIlIIl;
            }
            else {
                llllllllllllIllllIllllIlllIIlIII = Calendar.getInstance((SafeRepresenter.this.getTimeZone() == null) ? TimeZone.getTimeZone("UTC") : SafeRepresenter.this.timeZone);
                llllllllllllIllllIllllIlllIIlIII.setTime((Date)llllllllllllIllllIllllIlllIIlIIl);
            }
            final int llllllllllllIllllIllllIlllIIIlll = llllllllllllIllllIllllIlllIIlIII.get(1);
            final int llllllllllllIllllIllllIlllIIIllI = llllllllllllIllllIllllIlllIIlIII.get(2) + 1;
            final int llllllllllllIllllIllllIlllIIIlIl = llllllllllllIllllIllllIlllIIlIII.get(5);
            final int llllllllllllIllllIllllIlllIIIlII = llllllllllllIllllIllllIlllIIlIII.get(11);
            final int llllllllllllIllllIllllIlllIIIIll = llllllllllllIllllIllllIlllIIlIII.get(12);
            final int llllllllllllIllllIllllIlllIIIIlI = llllllllllllIllllIllllIlllIIlIII.get(13);
            final int llllllllllllIllllIllllIlllIIIIIl = llllllllllllIllllIllllIlllIIlIII.get(14);
            final StringBuilder llllllllllllIllllIllllIlllIIIIII = new StringBuilder(String.valueOf(llllllllllllIllllIllllIlllIIIlll));
            while (llllllllllllIllllIllllIlllIIIIII.length() < 4) {
                llllllllllllIllllIllllIlllIIIIII.insert(0, "0");
            }
            llllllllllllIllllIllllIlllIIIIII.append("-");
            if (llllllllllllIllllIllllIlllIIIllI < 10) {
                llllllllllllIllllIllllIlllIIIIII.append("0");
            }
            llllllllllllIllllIllllIlllIIIIII.append(String.valueOf(llllllllllllIllllIllllIlllIIIllI));
            llllllllllllIllllIllllIlllIIIIII.append("-");
            if (llllllllllllIllllIllllIlllIIIlIl < 10) {
                llllllllllllIllllIllllIlllIIIIII.append("0");
            }
            llllllllllllIllllIllllIlllIIIIII.append(String.valueOf(llllllllllllIllllIllllIlllIIIlIl));
            llllllllllllIllllIllllIlllIIIIII.append("T");
            if (llllllllllllIllllIllllIlllIIIlII < 10) {
                llllllllllllIllllIllllIlllIIIIII.append("0");
            }
            llllllllllllIllllIllllIlllIIIIII.append(String.valueOf(llllllllllllIllllIllllIlllIIIlII));
            llllllllllllIllllIllllIlllIIIIII.append(":");
            if (llllllllllllIllllIllllIlllIIIIll < 10) {
                llllllllllllIllllIllllIlllIIIIII.append("0");
            }
            llllllllllllIllllIllllIlllIIIIII.append(String.valueOf(llllllllllllIllllIllllIlllIIIIll));
            llllllllllllIllllIllllIlllIIIIII.append(":");
            if (llllllllllllIllllIllllIlllIIIIlI < 10) {
                llllllllllllIllllIllllIlllIIIIII.append("0");
            }
            llllllllllllIllllIllllIlllIIIIII.append(String.valueOf(llllllllllllIllllIllllIlllIIIIlI));
            if (llllllllllllIllllIllllIlllIIIIIl > 0) {
                if (llllllllllllIllllIllllIlllIIIIIl < 10) {
                    llllllllllllIllllIllllIlllIIIIII.append(".00");
                }
                else if (llllllllllllIllllIllllIlllIIIIIl < 100) {
                    llllllllllllIllllIllllIlllIIIIII.append(".0");
                }
                else {
                    llllllllllllIllllIllllIlllIIIIII.append(".");
                }
                llllllllllllIllllIllllIlllIIIIII.append(String.valueOf(llllllllllllIllllIllllIlllIIIIIl));
            }
            int llllllllllllIllllIllllIllIllllll = llllllllllllIllllIllllIlllIIlIII.getTimeZone().getOffset(llllllllllllIllllIllllIlllIIlIII.getTime().getTime());
            if (llllllllllllIllllIllllIllIllllll == 0) {
                llllllllllllIllllIllllIlllIIIIII.append('Z');
            }
            else {
                if (llllllllllllIllllIllllIllIllllll < 0) {
                    llllllllllllIllllIllllIlllIIIIII.append('-');
                    llllllllllllIllllIllllIllIllllll *= -1;
                }
                else {
                    llllllllllllIllllIllllIlllIIIIII.append('+');
                }
                final int llllllllllllIllllIllllIlllIIllIl = llllllllllllIllllIllllIllIllllll / 60000;
                final int llllllllllllIllllIllllIlllIIllII = llllllllllllIllllIllllIlllIIllIl / 60;
                final int llllllllllllIllllIllllIlllIIlIll = llllllllllllIllllIllllIlllIIllIl % 60;
                if (llllllllllllIllllIllllIlllIIllII < 10) {
                    llllllllllllIllllIllllIlllIIIIII.append('0');
                }
                llllllllllllIllllIllllIlllIIIIII.append(llllllllllllIllllIllllIlllIIllII);
                llllllllllllIllllIllllIlllIIIIII.append(':');
                if (llllllllllllIllllIllllIlllIIlIll < 10) {
                    llllllllllllIllllIllllIlllIIIIII.append('0');
                }
                llllllllllllIllllIllllIlllIIIIII.append(llllllllllllIllllIllllIlllIIlIll);
            }
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(llllllllllllIllllIllllIlllIIlIIl.getClass(), Tag.TIMESTAMP), String.valueOf(llllllllllllIllllIllllIlllIIIIII), DumperOptions.ScalarStyle.PLAIN);
        }
    }
    
    protected class RepresentMap implements Represent
    {
        @Override
        public Node representData(final Object llllllllllllllIllllIIIllIIIIIllI) {
            return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(llllllllllllllIllllIIIllIIIIIllI.getClass(), Tag.MAP), (Map<?, ?>)llllllllllllllIllllIIIllIIIIIllI, DumperOptions.FlowStyle.AUTO);
        }
    }
    
    protected class RepresentEnum implements Represent
    {
        @Override
        public Node representData(final Object lllllllllllllIlllIlllIIlIIllIlIl) {
            final Tag lllllllllllllIlllIlllIIlIIllIlII = new Tag(lllllllllllllIlllIlllIIlIIllIlIl.getClass());
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(lllllllllllllIlllIlllIIlIIllIlIl.getClass(), lllllllllllllIlllIlllIIlIIllIlII), ((Enum)lllllllllllllIlllIlllIIlIIllIlIl).name());
        }
    }
    
    protected class RepresentNull implements Represent
    {
        @Override
        public Node representData(final Object llllllllllllllIIIIlIlllIlIllIlII) {
            return SafeRepresenter.this.representScalar(Tag.NULL, "null");
        }
    }
    
    protected class RepresentNumber implements Represent
    {
        @Override
        public Node representData(final Object llllllllllllllIlIIllIlllIlIlIllI) {
            Tag llllllllllllllIlIIllIlllIlIlIlIl = null;
            String llllllllllllllIlIIllIlllIlIlIlII = null;
            if (llllllllllllllIlIIllIlllIlIlIllI instanceof Byte || llllllllllllllIlIIllIlllIlIlIllI instanceof Short || llllllllllllllIlIIllIlllIlIlIllI instanceof Integer || llllllllllllllIlIIllIlllIlIlIllI instanceof Long || llllllllllllllIlIIllIlllIlIlIllI instanceof BigInteger) {
                final Tag llllllllllllllIlIIllIlllIllIIIII = Tag.INT;
                final String llllllllllllllIlIIllIlllIlIllllI = llllllllllllllIlIIllIlllIlIlIllI.toString();
            }
            else {
                final Number llllllllllllllIlIIllIlllIlIllIII = (Number)llllllllllllllIlIIllIlllIlIlIllI;
                llllllllllllllIlIIllIlllIlIlIlIl = Tag.FLOAT;
                if (llllllllllllllIlIIllIlllIlIllIII.equals(Double.NaN)) {
                    final String llllllllllllllIlIIllIlllIlIlllIl = ".NaN";
                }
                else if (llllllllllllllIlIIllIlllIlIllIII.equals(Double.POSITIVE_INFINITY)) {
                    final String llllllllllllllIlIIllIlllIlIllIll = ".inf";
                }
                else if (llllllllllllllIlIIllIlllIlIllIII.equals(Double.NEGATIVE_INFINITY)) {
                    final String llllllllllllllIlIIllIlllIlIllIIl = "-.inf";
                }
                else {
                    llllllllllllllIlIIllIlllIlIlIlII = llllllllllllllIlIIllIlllIlIllIII.toString();
                }
            }
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(llllllllllllllIlIIllIlllIlIlIllI.getClass(), llllllllllllllIlIIllIlllIlIlIlIl), llllllllllllllIlIIllIlllIlIlIlII);
        }
    }
    
    protected class RepresentList implements Represent
    {
        @Override
        public Node representData(final Object lllllllllllllIIIlIIIIlIIlIIlIIll) {
            return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(lllllllllllllIIIlIIIIlIIlIIlIIll.getClass(), Tag.SEQ), (Iterable<?>)lllllllllllllIIIlIIIIlIIlIIlIIll, DumperOptions.FlowStyle.AUTO);
        }
    }
    
    protected class RepresentString implements Represent
    {
        @Override
        public Node representData(final Object lllllllllllllIIIlIllIIIIllllllIl) {
            Tag lllllllllllllIIIlIllIIIlIIIIIIIl = Tag.STR;
            DumperOptions.ScalarStyle lllllllllllllIIIlIllIIIlIIIIIIII = null;
            String lllllllllllllIIIlIllIIIIllllllll = lllllllllllllIIIlIllIIIIllllllIl.toString();
            if (SafeRepresenter.this.nonPrintableStyle == DumperOptions.NonPrintableStyle.BINARY && !StreamReader.isPrintable(lllllllllllllIIIlIllIIIIllllllll)) {
                lllllllllllllIIIlIllIIIlIIIIIIIl = Tag.BINARY;
                char[] lllllllllllllIIIlIllIIIlIIIIIlII;
                try {
                    final byte[] lllllllllllllIIIlIllIIIlIIIIIlll = lllllllllllllIIIlIllIIIIllllllll.getBytes("UTF-8");
                    final String lllllllllllllIIIlIllIIIlIIIIIllI = new String(lllllllllllllIIIlIllIIIlIIIIIlll, "UTF-8");
                    if (!lllllllllllllIIIlIllIIIlIIIIIllI.equals(lllllllllllllIIIlIllIIIIllllllll)) {
                        throw new YAMLException("invalid string value has occurred");
                    }
                    lllllllllllllIIIlIllIIIlIIIIIlII = Base64Coder.encode(lllllllllllllIIIlIllIIIlIIIIIlll);
                }
                catch (UnsupportedEncodingException lllllllllllllIIIlIllIIIlIIIIIlIl) {
                    throw new YAMLException(lllllllllllllIIIlIllIIIlIIIIIlIl);
                }
                lllllllllllllIIIlIllIIIIllllllll = String.valueOf(lllllllllllllIIIlIllIIIlIIIIIlII);
                lllllllllllllIIIlIllIIIlIIIIIIII = DumperOptions.ScalarStyle.LITERAL;
            }
            if (SafeRepresenter.this.defaultScalarStyle == DumperOptions.ScalarStyle.PLAIN && SafeRepresenter.MULTILINE_PATTERN.matcher(lllllllllllllIIIlIllIIIIllllllll).find()) {
                lllllllllllllIIIlIllIIIlIIIIIIII = DumperOptions.ScalarStyle.LITERAL;
            }
            return SafeRepresenter.this.representScalar(lllllllllllllIIIlIllIIIlIIIIIIIl, lllllllllllllIIIlIllIIIIllllllll, lllllllllllllIIIlIllIIIlIIIIIIII);
        }
    }
    
    protected class RepresentSet implements Represent
    {
        @Override
        public Node representData(final Object lllllllllllllIllIIlIlllllllIIIII) {
            final Map<Object, Object> lllllllllllllIllIIlIllllllIlllll = new LinkedHashMap<Object, Object>();
            final Set<Object> lllllllllllllIllIIlIllllllIllllI = (Set<Object>)lllllllllllllIllIIlIlllllllIIIII;
            for (final Object lllllllllllllIllIIlIlllllllIIIll : lllllllllllllIllIIlIllllllIllllI) {
                lllllllllllllIllIIlIllllllIlllll.put(lllllllllllllIllIIlIlllllllIIIll, null);
            }
            return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(lllllllllllllIllIIlIlllllllIIIII.getClass(), Tag.SET), lllllllllllllIllIIlIllllllIlllll, DumperOptions.FlowStyle.AUTO);
        }
    }
    
    protected class RepresentUuid implements Represent
    {
        @Override
        public Node representData(final Object llllllllllllllIlIIIlllIlIllllIIl) {
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(llllllllllllllIlIIIlllIlIllllIIl.getClass(), new Tag(UUID.class)), llllllllllllllIlIIIlllIlIllllIIl.toString());
        }
    }
}
