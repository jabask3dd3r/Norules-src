package org.yaml.snakeyaml.constructor;

import java.math.*;
import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.nodes.*;
import java.util.regex.*;
import org.yaml.snakeyaml.external.biz.base64Coder.*;
import org.yaml.snakeyaml.error.*;
import java.util.*;

public class SafeConstructor extends BaseConstructor
{
    public static final /* synthetic */ ConstructUndefined undefinedConstructor;
    private static final /* synthetic */ Map<String, Boolean> BOOL_VALUES;
    private static final /* synthetic */ Pattern TIMESTAMP_REGEXP;
    private static final /* synthetic */ Pattern YMD_REGEXP;
    private static final /* synthetic */ int[][] RADIX_MAX;
    
    private static int maxLen(final long llllllllllllllIlIllIllIIIllIIIIl, final int llllllllllllllIlIllIllIIIlIllllI) {
        return Long.toString(llllllllllllllIlIllIllIIIllIIIIl, llllllllllllllIlIllIllIIIlIllllI).length();
    }
    
    private Number createNumber(final int llllllllllllllIlIllIllIIIlIIllIl, String llllllllllllllIlIllIllIIIlIIllII, final int llllllllllllllIlIllIllIIIlIlIIIl) {
        final int llllllllllllllIlIllIllIIIlIlIIII = (llllllllllllllIlIllIllIIIlIIllII != null) ? ((String)llllllllllllllIlIllIllIIIlIIllII).length() : 0;
        if (llllllllllllllIlIllIllIIIlIIllIl < 0) {
            llllllllllllllIlIllIllIIIlIIllII = String.valueOf(new StringBuilder().append("-").append((String)llllllllllllllIlIllIllIIIlIIllII));
        }
        final int[] llllllllllllllIlIllIllIIIlIIllll = (int[])((llllllllllllllIlIllIllIIIlIlIIIl < SafeConstructor.RADIX_MAX.length) ? SafeConstructor.RADIX_MAX[llllllllllllllIlIllIllIIIlIlIIIl] : null);
        if (llllllllllllllIlIllIllIIIlIIllll != null) {
            final boolean llllllllllllllIlIllIllIIIlIlIllI = llllllllllllllIlIllIllIIIlIlIIII > llllllllllllllIlIllIllIIIlIIllll[0];
            if (llllllllllllllIlIllIllIIIlIlIllI) {
                if (llllllllllllllIlIllIllIIIlIlIIII > llllllllllllllIlIllIllIIIlIIllll[1]) {
                    return new BigInteger((String)llllllllllllllIlIllIllIIIlIIllII, llllllllllllllIlIllIllIIIlIlIIIl);
                }
                return createLongOrBigInteger((String)llllllllllllllIlIllIllIIIlIIllII, llllllllllllllIlIllIllIIIlIlIIIl);
            }
        }
        Number llllllllllllllIlIllIllIIIlIIlllI;
        try {
            llllllllllllllIlIllIllIIIlIIlllI = Integer.valueOf((String)llllllllllllllIlIllIllIIIlIIllII, llllllllllllllIlIllIllIIIlIlIIIl);
        }
        catch (NumberFormatException llllllllllllllIlIllIllIIIlIlIlIl) {
            llllllllllllllIlIllIllIIIlIIlllI = createLongOrBigInteger((String)llllllllllllllIlIllIllIIIlIIllII, llllllllllllllIlIllIllIIIlIlIIIl);
        }
        return llllllllllllllIlIllIllIIIlIIlllI;
    }
    
    protected void flattenMapping(final MappingNode llllllllllllllIlIllIllIIllIIllIl) {
        this.processDuplicateKeys(llllllllllllllIlIllIllIIllIIllIl);
        if (llllllllllllllIlIllIllIIllIIllIl.isMerged()) {
            llllllllllllllIlIllIllIIllIIllIl.setValue(this.mergeNode(llllllllllllllIlIllIllIIllIIllIl, true, new HashMap<Object, Integer>(), new ArrayList<NodeTuple>()));
        }
    }
    
    protected static Number createLongOrBigInteger(final String llllllllllllllIlIllIllIIIlIIIIlI, final int llllllllllllllIlIllIllIIIIllllll) {
        try {
            return Long.valueOf(llllllllllllllIlIllIllIIIlIIIIlI, llllllllllllllIlIllIllIIIIllllll);
        }
        catch (NumberFormatException llllllllllllllIlIllIllIIIlIIIIll) {
            return new BigInteger(llllllllllllllIlIllIllIIIlIIIIlI, llllllllllllllIlIllIllIIIIllllll);
        }
    }
    
    public SafeConstructor(final LoaderOptions llllllllllllllIlIllIllIIllIlIIll) {
        super(llllllllllllllIlIllIllIIllIlIIll);
        this.yamlConstructors.put(Tag.NULL, new ConstructYamlNull());
        this.yamlConstructors.put(Tag.BOOL, new ConstructYamlBool());
        this.yamlConstructors.put(Tag.INT, new ConstructYamlInt());
        this.yamlConstructors.put(Tag.FLOAT, new ConstructYamlFloat());
        this.yamlConstructors.put(Tag.BINARY, new ConstructYamlBinary());
        this.yamlConstructors.put(Tag.TIMESTAMP, new ConstructYamlTimestamp());
        this.yamlConstructors.put(Tag.OMAP, new ConstructYamlOmap());
        this.yamlConstructors.put(Tag.PAIRS, new ConstructYamlPairs());
        this.yamlConstructors.put(Tag.SET, new ConstructYamlSet());
        this.yamlConstructors.put(Tag.STR, new ConstructYamlStr());
        this.yamlConstructors.put(Tag.SEQ, new ConstructYamlSeq());
        this.yamlConstructors.put(Tag.MAP, new ConstructYamlMap());
        this.yamlConstructors.put(null, SafeConstructor.undefinedConstructor);
        this.yamlClassConstructors.put(NodeId.scalar, SafeConstructor.undefinedConstructor);
        this.yamlClassConstructors.put(NodeId.sequence, SafeConstructor.undefinedConstructor);
        this.yamlClassConstructors.put(NodeId.mapping, SafeConstructor.undefinedConstructor);
    }
    
    private List<NodeTuple> mergeNode(final MappingNode llllllllllllllIlIllIllIIlIIIllll, final boolean llllllllllllllIlIllIllIIlIIIlllI, final Map<Object, Integer> llllllllllllllIlIllIllIIlIIIllIl, final List<NodeTuple> llllllllllllllIlIllIllIIlIIIllII) {
        final Iterator<NodeTuple> llllllllllllllIlIllIllIIlIIIlIll = llllllllllllllIlIllIllIIlIIIllll.getValue().iterator();
        while (llllllllllllllIlIllIllIIlIIIlIll.hasNext()) {
            final NodeTuple llllllllllllllIlIllIllIIlIIlIIll = llllllllllllllIlIllIllIIlIIIlIll.next();
            final Node llllllllllllllIlIllIllIIlIIlIIlI = llllllllllllllIlIllIllIIlIIlIIll.getKeyNode();
            final Node llllllllllllllIlIllIllIIlIIlIIIl = llllllllllllllIlIllIllIIlIIlIIll.getValueNode();
            if (llllllllllllllIlIllIllIIlIIlIIlI.getTag().equals(Tag.MERGE)) {
                llllllllllllllIlIllIllIIlIIIlIll.remove();
                switch (llllllllllllllIlIllIllIIlIIlIIIl.getNodeId()) {
                    case mapping: {
                        final MappingNode llllllllllllllIlIllIllIIlIIlIlll = (MappingNode)llllllllllllllIlIllIllIIlIIlIIIl;
                        this.mergeNode(llllllllllllllIlIllIllIIlIIlIlll, false, llllllllllllllIlIllIllIIlIIIllIl, llllllllllllllIlIllIllIIlIIIllII);
                        continue;
                    }
                    case sequence: {
                        final SequenceNode llllllllllllllIlIllIllIIlIIlIllI = (SequenceNode)llllllllllllllIlIllIllIIlIIlIIIl;
                        final List<Node> llllllllllllllIlIllIllIIlIIlIlIl = llllllllllllllIlIllIllIIlIIlIllI.getValue();
                        for (final Node llllllllllllllIlIllIllIIlIIllIIl : llllllllllllllIlIllIllIIlIIlIlIl) {
                            if (!(llllllllllllllIlIllIllIIlIIllIIl instanceof MappingNode)) {
                                throw new ConstructorException("while constructing a mapping", llllllllllllllIlIllIllIIlIIIllll.getStartMark(), String.valueOf(new StringBuilder().append("expected a mapping for merging, but found ").append(llllllllllllllIlIllIllIIlIIllIIl.getNodeId())), llllllllllllllIlIllIllIIlIIllIIl.getStartMark());
                            }
                            final MappingNode llllllllllllllIlIllIllIIlIIllIlI = (MappingNode)llllllllllllllIlIllIllIIlIIllIIl;
                            this.mergeNode(llllllllllllllIlIllIllIIlIIllIlI, false, llllllllllllllIlIllIllIIlIIIllIl, llllllllllllllIlIllIllIIlIIIllII);
                        }
                        continue;
                    }
                    default: {
                        throw new ConstructorException("while constructing a mapping", llllllllllllllIlIllIllIIlIIIllll.getStartMark(), String.valueOf(new StringBuilder().append("expected a mapping or list of mappings for merging, but found ").append(llllllllllllllIlIllIllIIlIIlIIIl.getNodeId())), llllllllllllllIlIllIllIIlIIlIIIl.getStartMark());
                    }
                }
            }
            else {
                final Object llllllllllllllIlIllIllIIlIIlIlII = this.constructObject(llllllllllllllIlIllIllIIlIIlIIlI);
                if (!llllllllllllllIlIllIllIIlIIIllIl.containsKey(llllllllllllllIlIllIllIIlIIlIlII)) {
                    llllllllllllllIlIllIllIIlIIIllII.add(llllllllllllllIlIllIllIIlIIlIIll);
                    llllllllllllllIlIllIllIIlIIIllIl.put(llllllllllllllIlIllIllIIlIIlIlII, llllllllllllllIlIllIllIIlIIIllII.size() - 1);
                }
                else {
                    if (!llllllllllllllIlIllIllIIlIIIlllI) {
                        continue;
                    }
                    llllllllllllllIlIllIllIIlIIIllII.set(llllllllllllllIlIllIllIIlIIIllIl.get(llllllllllllllIlIllIllIIlIIlIlII), llllllllllllllIlIllIllIIlIIlIIll);
                }
            }
        }
        return llllllllllllllIlIllIllIIlIIIllII;
    }
    
    public SafeConstructor() {
        this(new LoaderOptions());
    }
    
    static {
        undefinedConstructor = new ConstructUndefined();
        (BOOL_VALUES = new HashMap<String, Boolean>()).put("yes", Boolean.TRUE);
        SafeConstructor.BOOL_VALUES.put("no", Boolean.FALSE);
        SafeConstructor.BOOL_VALUES.put("true", Boolean.TRUE);
        SafeConstructor.BOOL_VALUES.put("false", Boolean.FALSE);
        SafeConstructor.BOOL_VALUES.put("on", Boolean.TRUE);
        SafeConstructor.BOOL_VALUES.put("off", Boolean.FALSE);
        RADIX_MAX = new int[17][2];
        final int[] llllllllllllllIlIllIllIIIIlIlIll;
        final int[] llllllllllllllIlIllIllIIIIlIlIII = llllllllllllllIlIllIllIIIIlIlIll = new int[] { 2, 8, 10, 16 };
        for (final int llllllllllllllIlIllIllIIIIlIllII : llllllllllllllIlIllIllIIIIlIlIll) {
            SafeConstructor.RADIX_MAX[llllllllllllllIlIllIllIIIIlIllII] = new int[] { maxLen(Integer.MAX_VALUE, llllllllllllllIlIllIllIIIIlIllII), maxLen(Long.MAX_VALUE, llllllllllllllIlIllIllIIIIlIllII) };
        }
        TIMESTAMP_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:(?:[Tt]|[ \t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \t]*(?:Z|([-+][0-9][0-9]?)(?::([0-9][0-9])?)?))?)?$");
        YMD_REGEXP = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)$");
    }
    
    private static int maxLen(final int llllllllllllllIlIllIllIIIllIIlll, final int llllllllllllllIlIllIllIIIllIIlII) {
        return Integer.toString(llllllllllllllIlIllIllIIIllIIlll, llllllllllllllIlIllIllIIIllIIlII).length();
    }
    
    @Override
    protected void constructSet2ndStep(final MappingNode llllllllllllllIlIllIllIIIllIlIll, final Set<Object> llllllllllllllIlIllIllIIIllIlIlI) {
        this.flattenMapping(llllllllllllllIlIllIllIIIllIlIll);
        super.constructSet2ndStep(llllllllllllllIlIllIllIIIllIlIll, llllllllllllllIlIllIllIIIllIlIlI);
    }
    
    @Override
    protected void constructMapping2ndStep(final MappingNode llllllllllllllIlIllIllIIIlllIlll, final Map<Object, Object> llllllllllllllIlIllIllIIIlllIllI) {
        this.flattenMapping(llllllllllllllIlIllIllIIIlllIlll);
        super.constructMapping2ndStep(llllllllllllllIlIllIllIIIlllIlll, llllllllllllllIlIllIllIIIlllIllI);
    }
    
    protected void processDuplicateKeys(final MappingNode llllllllllllllIlIllIllIIlIlllIlI) {
        final List<NodeTuple> llllllllllllllIlIllIllIIlIlllIIl = llllllllllllllIlIllIllIIlIlllIlI.getValue();
        final Map<Object, Integer> llllllllllllllIlIllIllIIlIlllIII = new HashMap<Object, Integer>(llllllllllllllIlIllIllIIlIlllIIl.size());
        final TreeSet<Integer> llllllllllllllIlIllIllIIlIllIlll = new TreeSet<Integer>();
        int llllllllllllllIlIllIllIIlIllIllI = 0;
        for (final NodeTuple llllllllllllllIlIllIllIIlIllllIl : llllllllllllllIlIllIllIIlIlllIIl) {
            final Node llllllllllllllIlIllIllIIlIlllllI = llllllllllllllIlIllIllIIlIllllIl.getKeyNode();
            if (!llllllllllllllIlIllIllIIlIlllllI.getTag().equals(Tag.MERGE)) {
                final Object llllllllllllllIlIllIllIIllIIIIII = this.constructObject(llllllllllllllIlIllIllIIlIlllllI);
                if (llllllllllllllIlIllIllIIllIIIIII != null) {
                    try {
                        llllllllllllllIlIllIllIIllIIIIII.hashCode();
                    }
                    catch (Exception llllllllllllllIlIllIllIIllIIIIIl) {
                        throw new ConstructorException("while constructing a mapping", llllllllllllllIlIllIllIIlIlllIlI.getStartMark(), String.valueOf(new StringBuilder().append("found unacceptable key ").append(llllllllllllllIlIllIllIIllIIIIII)), llllllllllllllIlIllIllIIlIllllIl.getKeyNode().getStartMark(), llllllllllllllIlIllIllIIllIIIIIl);
                    }
                }
                final Integer llllllllllllllIlIllIllIIlIllllll = llllllllllllllIlIllIllIIlIlllIII.put(llllllllllllllIlIllIllIIllIIIIII, llllllllllllllIlIllIllIIlIllIllI);
                if (llllllllllllllIlIllIllIIlIllllll != null) {
                    if (!this.isAllowDuplicateKeys()) {
                        throw new DuplicateKeyException(llllllllllllllIlIllIllIIlIlllIlI.getStartMark(), llllllllllllllIlIllIllIIllIIIIII, llllllllllllllIlIllIllIIlIllllIl.getKeyNode().getStartMark());
                    }
                    llllllllllllllIlIllIllIIlIllIlll.add(llllllllllllllIlIllIllIIlIllllll);
                }
            }
            ++llllllllllllllIlIllIllIIlIllIllI;
        }
        final Iterator<Integer> llllllllllllllIlIllIllIIlIllIlIl = llllllllllllllIlIllIllIIlIllIlll.descendingIterator();
        while (llllllllllllllIlIllIllIIlIllIlIl.hasNext()) {
            llllllllllllllIlIllIllIIlIlllIIl.remove((int)llllllllllllllIlIllIllIIlIllIlIl.next());
        }
    }
    
    public static class ConstructYamlTimestamp extends AbstractConstruct
    {
        private /* synthetic */ Calendar calendar;
        
        public Calendar getCalendar() {
            return this.calendar;
        }
        
        @Override
        public Object construct(final Node llllllllllllllIIIIIlIllIllIllIll) {
            final ScalarNode llllllllllllllIIIIIlIllIllIllIIl = (ScalarNode)llllllllllllllIIIIIlIllIllIllIll;
            final String llllllllllllllIIIIIlIllIllIlIlll = llllllllllllllIIIIIlIllIllIllIIl.getValue();
            Matcher llllllllllllllIIIIIlIllIllIlIllI = SafeConstructor.YMD_REGEXP.matcher(llllllllllllllIIIIIlIllIllIlIlll);
            if (llllllllllllllIIIIIlIllIllIlIllI.matches()) {
                final String llllllllllllllIIIIIlIllIlllIllll = llllllllllllllIIIIIlIllIllIlIllI.group(1);
                final String llllllllllllllIIIIIlIllIlllIlllI = llllllllllllllIIIIIlIllIllIlIllI.group(2);
                final String llllllllllllllIIIIIlIllIlllIllIl = llllllllllllllIIIIIlIllIllIlIllI.group(3);
                this.calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                this.calendar.clear();
                this.calendar.set(1, Integer.parseInt(llllllllllllllIIIIIlIllIlllIllll));
                this.calendar.set(2, Integer.parseInt(llllllllllllllIIIIIlIllIlllIlllI) - 1);
                this.calendar.set(5, Integer.parseInt(llllllllllllllIIIIIlIllIlllIllIl));
                return this.calendar.getTime();
            }
            llllllllllllllIIIIIlIllIllIlIllI = SafeConstructor.TIMESTAMP_REGEXP.matcher(llllllllllllllIIIIIlIllIllIlIlll);
            if (!llllllllllllllIIIIIlIllIllIlIllI.matches()) {
                throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected timestamp: ").append(llllllllllllllIIIIIlIllIllIlIlll)));
            }
            final String llllllllllllllIIIIIlIllIlllIlIlI = llllllllllllllIIIIIlIllIllIlIllI.group(1);
            final String llllllllllllllIIIIIlIllIlllIlIIl = llllllllllllllIIIIIlIllIllIlIllI.group(2);
            final String llllllllllllllIIIIIlIllIlllIlIII = llllllllllllllIIIIIlIllIllIlIllI.group(3);
            final String llllllllllllllIIIIIlIllIlllIIlll = llllllllllllllIIIIIlIllIllIlIllI.group(4);
            final String llllllllllllllIIIIIlIllIlllIIllI = llllllllllllllIIIIIlIllIllIlIllI.group(5);
            String llllllllllllllIIIIIlIllIlllIIlIl = llllllllllllllIIIIIlIllIllIlIllI.group(6);
            final String llllllllllllllIIIIIlIllIlllIIlII = llllllllllllllIIIIIlIllIllIlIllI.group(7);
            if (llllllllllllllIIIIIlIllIlllIIlII != null) {
                llllllllllllllIIIIIlIllIlllIIlIl = String.valueOf(new StringBuilder().append(llllllllllllllIIIIIlIllIlllIIlIl).append(".").append(llllllllllllllIIIIIlIllIlllIIlII));
            }
            final double llllllllllllllIIIIIlIllIlllIIIll = Double.parseDouble(llllllllllllllIIIIIlIllIlllIIlIl);
            final int llllllllllllllIIIIIlIllIlllIIIlI = (int)Math.round(Math.floor(llllllllllllllIIIIIlIllIlllIIIll));
            final int llllllllllllllIIIIIlIllIlllIIIIl = (int)Math.round((llllllllllllllIIIIIlIllIlllIIIll - llllllllllllllIIIIIlIllIlllIIIlI) * 1000.0);
            final String llllllllllllllIIIIIlIllIlllIIIII = llllllllllllllIIIIIlIllIllIlIllI.group(8);
            final String llllllllllllllIIIIIlIllIllIlllll = llllllllllllllIIIIIlIllIllIlIllI.group(9);
            TimeZone llllllllllllllIIIIIlIllIllIllllI = null;
            if (llllllllllllllIIIIIlIllIlllIIIII != null) {
                final String llllllllllllllIIIIIlIllIlllIllII = (llllllllllllllIIIIIlIllIllIlllll != null) ? String.valueOf(new StringBuilder().append(":").append(llllllllllllllIIIIIlIllIllIlllll)) : "00";
                final TimeZone llllllllllllllIIIIIlIllIlllIlIll = TimeZone.getTimeZone(String.valueOf(new StringBuilder().append("GMT").append(llllllllllllllIIIIIlIllIlllIIIII).append(llllllllllllllIIIIIlIllIlllIllII)));
            }
            else {
                llllllllllllllIIIIIlIllIllIllllI = TimeZone.getTimeZone("UTC");
            }
            this.calendar = Calendar.getInstance(llllllllllllllIIIIIlIllIllIllllI);
            this.calendar.set(1, Integer.parseInt(llllllllllllllIIIIIlIllIlllIlIlI));
            this.calendar.set(2, Integer.parseInt(llllllllllllllIIIIIlIllIlllIlIIl) - 1);
            this.calendar.set(5, Integer.parseInt(llllllllllllllIIIIIlIllIlllIlIII));
            this.calendar.set(11, Integer.parseInt(llllllllllllllIIIIIlIllIlllIIlll));
            this.calendar.set(12, Integer.parseInt(llllllllllllllIIIIIlIllIlllIIllI));
            this.calendar.set(13, llllllllllllllIIIIIlIllIlllIIIlI);
            this.calendar.set(14, llllllllllllllIIIIIlIllIlllIIIIl);
            return this.calendar.getTime();
        }
    }
    
    public class ConstructYamlBinary extends AbstractConstruct
    {
        @Override
        public Object construct(final Node llllllllllllllllIlIlllIIlllllIIl) {
            final String llllllllllllllllIlIlllIIllllllII = SafeConstructor.this.constructScalar((ScalarNode)llllllllllllllllIlIlllIIlllllIIl).toString().replaceAll("\\s", "");
            final byte[] llllllllllllllllIlIlllIIlllllIll = Base64Coder.decode(llllllllllllllllIlIlllIIllllllII.toCharArray());
            return llllllllllllllllIlIlllIIlllllIll;
        }
    }
    
    public class ConstructYamlInt extends AbstractConstruct
    {
        @Override
        public Object construct(final Node lllllllllllllIlIIIlIIlIIlIIlIlIl) {
            String lllllllllllllIlIIIlIIlIIlIIlIlII = SafeConstructor.this.constructScalar((ScalarNode)lllllllllllllIlIIIlIIlIIlIIlIlIl).toString().replaceAll("_", "");
            int lllllllllllllIlIIIlIIlIIlIIlIIll = 1;
            final char lllllllllllllIlIIIlIIlIIlIIlIIlI = lllllllllllllIlIIIlIIlIIlIIlIlII.charAt(0);
            if (lllllllllllllIlIIIlIIlIIlIIlIIlI == '-') {
                lllllllllllllIlIIIlIIlIIlIIlIIll = -1;
                lllllllllllllIlIIIlIIlIIlIIlIlII = lllllllllllllIlIIIlIIlIIlIIlIlII.substring(1);
            }
            else if (lllllllllllllIlIIIlIIlIIlIIlIIlI == '+') {
                lllllllllllllIlIIIlIIlIIlIIlIlII = lllllllllllllIlIIIlIIlIIlIIlIlII.substring(1);
            }
            int lllllllllllllIlIIIlIIlIIlIIlIIIl = 10;
            if ("0".equals(lllllllllllllIlIIIlIIlIIlIIlIlII)) {
                return 0;
            }
            if (lllllllllllllIlIIIlIIlIIlIIlIlII.startsWith("0b")) {
                lllllllllllllIlIIIlIIlIIlIIlIlII = lllllllllllllIlIIIlIIlIIlIIlIlII.substring(2);
                lllllllllllllIlIIIlIIlIIlIIlIIIl = 2;
            }
            else if (lllllllllllllIlIIIlIIlIIlIIlIlII.startsWith("0x")) {
                lllllllllllllIlIIIlIIlIIlIIlIlII = lllllllllllllIlIIIlIIlIIlIIlIlII.substring(2);
                lllllllllllllIlIIIlIIlIIlIIlIIIl = 16;
            }
            else if (lllllllllllllIlIIIlIIlIIlIIlIlII.startsWith("0")) {
                lllllllllllllIlIIIlIIlIIlIIlIlII = lllllllllllllIlIIIlIIlIIlIIlIlII.substring(1);
                lllllllllllllIlIIIlIIlIIlIIlIIIl = 8;
            }
            else {
                if (lllllllllllllIlIIIlIIlIIlIIlIlII.indexOf(58) != -1) {
                    final String[] lllllllllllllIlIIIlIIlIIlIIllIIl = lllllllllllllIlIIIlIIlIIlIIlIlII.split(":");
                    int lllllllllllllIlIIIlIIlIIlIIllIII = 1;
                    int lllllllllllllIlIIIlIIlIIlIIlIlll = 0;
                    for (int lllllllllllllIlIIIlIIlIIlIIllIll = 0, lllllllllllllIlIIIlIIlIIlIIllIlI = lllllllllllllIlIIIlIIlIIlIIllIIl.length; lllllllllllllIlIIIlIIlIIlIIllIll < lllllllllllllIlIIIlIIlIIlIIllIlI; ++lllllllllllllIlIIIlIIlIIlIIllIll) {
                        lllllllllllllIlIIIlIIlIIlIIlIlll += (int)(Long.parseLong(lllllllllllllIlIIIlIIlIIlIIllIIl[lllllllllllllIlIIIlIIlIIlIIllIlI - lllllllllllllIlIIIlIIlIIlIIllIll - 1]) * lllllllllllllIlIIIlIIlIIlIIllIII);
                        lllllllllllllIlIIIlIIlIIlIIllIII *= 60;
                    }
                    return SafeConstructor.this.createNumber(lllllllllllllIlIIIlIIlIIlIIlIIll, String.valueOf(lllllllllllllIlIIIlIIlIIlIIlIlll), 10);
                }
                return SafeConstructor.this.createNumber(lllllllllllllIlIIIlIIlIIlIIlIIll, lllllllllllllIlIIIlIIlIIlIIlIlII, 10);
            }
            return SafeConstructor.this.createNumber(lllllllllllllIlIIIlIIlIIlIIlIIll, lllllllllllllIlIIIlIIlIIlIIlIlII, lllllllllllllIlIIIlIIlIIlIIlIIIl);
        }
    }
    
    public static final class ConstructUndefined extends AbstractConstruct
    {
        @Override
        public Object construct(final Node lllllllllllllIIlIlllllIIIIlIlIIl) {
            throw new ConstructorException(null, null, String.valueOf(new StringBuilder().append("could not determine a constructor for the tag ").append(lllllllllllllIIlIlllllIIIIlIlIIl.getTag())), lllllllllllllIIlIlllllIIIIlIlIIl.getStartMark());
        }
    }
    
    public class ConstructYamlSeq implements Construct
    {
        @Override
        public void construct2ndStep(final Node lllllllllllllIlIllIlIlIlIllllIlI, final Object lllllllllllllIlIllIlIlIlIlllllII) {
            if (lllllllllllllIlIllIlIlIlIllllIlI.isTwoStepsConstruction()) {
                SafeConstructor.this.constructSequenceStep2((SequenceNode)lllllllllllllIlIllIlIlIlIllllIlI, (Collection<Object>)lllllllllllllIlIllIlIlIlIlllllII);
                return;
            }
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected recursive sequence structure. Node: ").append(lllllllllllllIlIllIlIlIlIllllIlI)));
        }
        
        @Override
        public Object construct(final Node lllllllllllllIlIllIlIlIllIIIIIll) {
            final SequenceNode lllllllllllllIlIllIlIlIllIIIIlIl = (SequenceNode)lllllllllllllIlIllIlIlIllIIIIIll;
            if (lllllllllllllIlIllIlIlIllIIIIIll.isTwoStepsConstruction()) {
                return SafeConstructor.this.newList(lllllllllllllIlIllIlIlIllIIIIlIl);
            }
            return SafeConstructor.this.constructSequence(lllllllllllllIlIllIlIlIllIIIIlIl);
        }
    }
    
    public class ConstructYamlMap implements Construct
    {
        @Override
        public Object construct(final Node lllllllllllllIlIIIlIIllIIllIlIII) {
            final MappingNode lllllllllllllIlIIIlIIllIIllIlIlI = (MappingNode)lllllllllllllIlIIIlIIllIIllIlIII;
            if (lllllllllllllIlIIIlIIllIIllIlIII.isTwoStepsConstruction()) {
                return SafeConstructor.this.createDefaultMap(lllllllllllllIlIIIlIIllIIllIlIlI.getValue().size());
            }
            return SafeConstructor.this.constructMapping(lllllllllllllIlIIIlIIllIIllIlIlI);
        }
        
        @Override
        public void construct2ndStep(final Node lllllllllllllIlIIIlIIllIIlIlllll, final Object lllllllllllllIlIIIlIIllIIlIllllI) {
            if (lllllllllllllIlIIIlIIllIIlIlllll.isTwoStepsConstruction()) {
                SafeConstructor.this.constructMapping2ndStep((MappingNode)lllllllllllllIlIIIlIIllIIlIlllll, (Map<Object, Object>)lllllllllllllIlIIIlIIllIIlIllllI);
                return;
            }
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected recursive mapping structure. Node: ").append(lllllllllllllIlIIIlIIllIIlIlllll)));
        }
    }
    
    public class ConstructYamlBool extends AbstractConstruct
    {
        @Override
        public Object construct(final Node llllllllllllllIllIlllIlIIIllIlll) {
            final String llllllllllllllIllIlllIlIIIlllIIl = SafeConstructor.this.constructScalar((ScalarNode)llllllllllllllIllIlllIlIIIllIlll);
            return SafeConstructor.BOOL_VALUES.get(llllllllllllllIllIlllIlIIIlllIIl.toLowerCase());
        }
    }
    
    public class ConstructYamlFloat extends AbstractConstruct
    {
        @Override
        public Object construct(final Node lllllllllllllllllIIIIIIIIIlIlllI) {
            String lllllllllllllllllIIIIIIIIIllIIll = SafeConstructor.this.constructScalar((ScalarNode)lllllllllllllllllIIIIIIIIIlIlllI).toString().replaceAll("_", "");
            int lllllllllllllllllIIIIIIIIIllIIlI = 1;
            final char lllllllllllllllllIIIIIIIIIllIIIl = lllllllllllllllllIIIIIIIIIllIIll.charAt(0);
            if (lllllllllllllllllIIIIIIIIIllIIIl == '-') {
                lllllllllllllllllIIIIIIIIIllIIlI = -1;
                lllllllllllllllllIIIIIIIIIllIIll = lllllllllllllllllIIIIIIIIIllIIll.substring(1);
            }
            else if (lllllllllllllllllIIIIIIIIIllIIIl == '+') {
                lllllllllllllllllIIIIIIIIIllIIll = lllllllllllllllllIIIIIIIIIllIIll.substring(1);
            }
            final String lllllllllllllllllIIIIIIIIIllIIII = lllllllllllllllllIIIIIIIIIllIIll.toLowerCase();
            if (".inf".equals(lllllllllllllllllIIIIIIIIIllIIII)) {
                return (lllllllllllllllllIIIIIIIIIllIIlI == -1) ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            }
            if (".nan".equals(lllllllllllllllllIIIIIIIIIllIIII)) {
                return Double.NaN;
            }
            if (lllllllllllllllllIIIIIIIIIllIIll.indexOf(58) != -1) {
                final String[] lllllllllllllllllIIIIIIIIIlllIIl = lllllllllllllllllIIIIIIIIIllIIll.split(":");
                int lllllllllllllllllIIIIIIIIIlllIII = 1;
                double lllllllllllllllllIIIIIIIIIllIlll = 0.0;
                for (int lllllllllllllllllIIIIIIIIIlllIll = 0, lllllllllllllllllIIIIIIIIIlllIlI = lllllllllllllllllIIIIIIIIIlllIIl.length; lllllllllllllllllIIIIIIIIIlllIll < lllllllllllllllllIIIIIIIIIlllIlI; ++lllllllllllllllllIIIIIIIIIlllIll) {
                    lllllllllllllllllIIIIIIIIIllIlll += Double.parseDouble(lllllllllllllllllIIIIIIIIIlllIIl[lllllllllllllllllIIIIIIIIIlllIlI - lllllllllllllllllIIIIIIIIIlllIll - 1]) * lllllllllllllllllIIIIIIIIIlllIII;
                    lllllllllllllllllIIIIIIIIIlllIII *= 60;
                }
                return lllllllllllllllllIIIIIIIIIllIIlI * lllllllllllllllllIIIIIIIIIllIlll;
            }
            final Double lllllllllllllllllIIIIIIIIIllIllI = Double.valueOf(lllllllllllllllllIIIIIIIIIllIIll);
            return lllllllllllllllllIIIIIIIIIllIllI * lllllllllllllllllIIIIIIIIIllIIlI;
        }
    }
    
    public class ConstructYamlOmap extends AbstractConstruct
    {
        @Override
        public Object construct(final Node llllllllllllllllIlIlIIIllIlllIlI) {
            final Map<Object, Object> llllllllllllllllIlIlIIIllIlllIIl = new LinkedHashMap<Object, Object>();
            if (!(llllllllllllllllIlIlIIIllIlllIlI instanceof SequenceNode)) {
                throw new ConstructorException("while constructing an ordered map", llllllllllllllllIlIlIIIllIlllIlI.getStartMark(), String.valueOf(new StringBuilder().append("expected a sequence, but found ").append(llllllllllllllllIlIlIIIllIlllIlI.getNodeId())), llllllllllllllllIlIlIIIllIlllIlI.getStartMark());
            }
            final SequenceNode llllllllllllllllIlIlIIIllIlllIII = (SequenceNode)llllllllllllllllIlIlIIIllIlllIlI;
            for (final Node llllllllllllllllIlIlIIIllIllllIl : llllllllllllllllIlIlIIIllIlllIII.getValue()) {
                if (!(llllllllllllllllIlIlIIIllIllllIl instanceof MappingNode)) {
                    throw new ConstructorException("while constructing an ordered map", llllllllllllllllIlIlIIIllIlllIlI.getStartMark(), String.valueOf(new StringBuilder().append("expected a mapping of length 1, but found ").append(llllllllllllllllIlIlIIIllIllllIl.getNodeId())), llllllllllllllllIlIlIIIllIllllIl.getStartMark());
                }
                final MappingNode llllllllllllllllIlIlIIIlllIIIIlI = (MappingNode)llllllllllllllllIlIlIIIllIllllIl;
                if (llllllllllllllllIlIlIIIlllIIIIlI.getValue().size() != 1) {
                    throw new ConstructorException("while constructing an ordered map", llllllllllllllllIlIlIIIllIlllIlI.getStartMark(), String.valueOf(new StringBuilder().append("expected a single mapping item, but found ").append(llllllllllllllllIlIlIIIlllIIIIlI.getValue().size()).append(" items")), llllllllllllllllIlIlIIIlllIIIIlI.getStartMark());
                }
                final Node llllllllllllllllIlIlIIIlllIIIIIl = llllllllllllllllIlIlIIIlllIIIIlI.getValue().get(0).getKeyNode();
                final Node llllllllllllllllIlIlIIIlllIIIIII = llllllllllllllllIlIlIIIlllIIIIlI.getValue().get(0).getValueNode();
                final Object llllllllllllllllIlIlIIIllIllllll = SafeConstructor.this.constructObject(llllllllllllllllIlIlIIIlllIIIIIl);
                final Object llllllllllllllllIlIlIIIllIlllllI = SafeConstructor.this.constructObject(llllllllllllllllIlIlIIIlllIIIIII);
                llllllllllllllllIlIlIIIllIlllIIl.put(llllllllllllllllIlIlIIIllIllllll, llllllllllllllllIlIlIIIllIlllllI);
            }
            return llllllllllllllllIlIlIIIllIlllIIl;
        }
    }
    
    public class ConstructYamlSet implements Construct
    {
        @Override
        public void construct2ndStep(final Node llllllllllllllllIlIlllllIlIIlIll, final Object llllllllllllllllIlIlllllIlIIlIlI) {
            if (llllllllllllllllIlIlllllIlIIlIll.isTwoStepsConstruction()) {
                SafeConstructor.this.constructSet2ndStep((MappingNode)llllllllllllllllIlIlllllIlIIlIll, (Set<Object>)llllllllllllllllIlIlllllIlIIlIlI);
                return;
            }
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected recursive set structure. Node: ").append(llllllllllllllllIlIlllllIlIIlIll)));
        }
        
        @Override
        public Object construct(final Node llllllllllllllllIlIlllllIlIlIIll) {
            if (llllllllllllllllIlIlllllIlIlIIll.isTwoStepsConstruction()) {
                return SafeConstructor.this.constructedObjects.containsKey(llllllllllllllllIlIlllllIlIlIIll) ? SafeConstructor.this.constructedObjects.get(llllllllllllllllIlIlllllIlIlIIll) : SafeConstructor.this.createDefaultSet(((MappingNode)llllllllllllllllIlIlllllIlIlIIll).getValue().size());
            }
            return SafeConstructor.this.constructSet((MappingNode)llllllllllllllllIlIlllllIlIlIIll);
        }
    }
    
    public class ConstructYamlNull extends AbstractConstruct
    {
        @Override
        public Object construct(final Node lllIIlIlllIl) {
            if (lllIIlIlllIl != null) {
                SafeConstructor.this.constructScalar((ScalarNode)lllIIlIlllIl);
            }
            return null;
        }
    }
    
    public class ConstructYamlStr extends AbstractConstruct
    {
        @Override
        public Object construct(final Node llllllllllllllllIIlllIIllllIIlll) {
            return SafeConstructor.this.constructScalar((ScalarNode)llllllllllllllllIIlllIIllllIIlll);
        }
    }
    
    public class ConstructYamlPairs extends AbstractConstruct
    {
        @Override
        public Object construct(final Node llllllllllllllIIlIlIIlIIlIIIlIll) {
            if (!(llllllllllllllIIlIlIIlIIlIIIlIll instanceof SequenceNode)) {
                throw new ConstructorException("while constructing pairs", llllllllllllllIIlIlIIlIIlIIIlIll.getStartMark(), String.valueOf(new StringBuilder().append("expected a sequence, but found ").append(llllllllllllllIIlIlIIlIIlIIIlIll.getNodeId())), llllllllllllllIIlIlIIlIIlIIIlIll.getStartMark());
            }
            final SequenceNode llllllllllllllIIlIlIIlIIlIIIlIlI = (SequenceNode)llllllllllllllIIlIlIIlIIlIIIlIll;
            final List<Object[]> llllllllllllllIIlIlIIlIIlIIIlIIl = new ArrayList<Object[]>(llllllllllllllIIlIlIIlIIlIIIlIlI.getValue().size());
            for (final Node llllllllllllllIIlIlIIlIIlIIIlllI : llllllllllllllIIlIlIIlIIlIIIlIlI.getValue()) {
                if (!(llllllllllllllIIlIlIIlIIlIIIlllI instanceof MappingNode)) {
                    throw new ConstructorException("while constructingpairs", llllllllllllllIIlIlIIlIIlIIIlIll.getStartMark(), String.valueOf(new StringBuilder().append("expected a mapping of length 1, but found ").append(llllllllllllllIIlIlIIlIIlIIIlllI.getNodeId())), llllllllllllllIIlIlIIlIIlIIIlllI.getStartMark());
                }
                final MappingNode llllllllllllllIIlIlIIlIIlIIlIIll = (MappingNode)llllllllllllllIIlIlIIlIIlIIIlllI;
                if (llllllllllllllIIlIlIIlIIlIIlIIll.getValue().size() != 1) {
                    throw new ConstructorException("while constructing pairs", llllllllllllllIIlIlIIlIIlIIIlIll.getStartMark(), String.valueOf(new StringBuilder().append("expected a single mapping item, but found ").append(llllllllllllllIIlIlIIlIIlIIlIIll.getValue().size()).append(" items")), llllllllllllllIIlIlIIlIIlIIlIIll.getStartMark());
                }
                final Node llllllllllllllIIlIlIIlIIlIIlIIlI = llllllllllllllIIlIlIIlIIlIIlIIll.getValue().get(0).getKeyNode();
                final Node llllllllllllllIIlIlIIlIIlIIlIIIl = llllllllllllllIIlIlIIlIIlIIlIIll.getValue().get(0).getValueNode();
                final Object llllllllllllllIIlIlIIlIIlIIlIIII = SafeConstructor.this.constructObject(llllllllllllllIIlIlIIlIIlIIlIIlI);
                final Object llllllllllllllIIlIlIIlIIlIIIllll = SafeConstructor.this.constructObject(llllllllllllllIIlIlIIlIIlIIlIIIl);
                llllllllllllllIIlIlIIlIIlIIIlIIl.add(new Object[] { llllllllllllllIIlIlIIlIIlIIlIIII, llllllllllllllIIlIlIIlIIlIIIllll });
            }
            return llllllllllllllIIlIlIIlIIlIIIlIIl;
        }
    }
}
