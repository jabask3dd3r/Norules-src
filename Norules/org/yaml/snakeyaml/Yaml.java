package org.yaml.snakeyaml;

import org.yaml.snakeyaml.resolver.*;
import org.yaml.snakeyaml.representer.*;
import org.yaml.snakeyaml.events.*;
import org.yaml.snakeyaml.parser.*;
import java.util.*;
import org.yaml.snakeyaml.constructor.*;
import org.yaml.snakeyaml.nodes.*;
import org.yaml.snakeyaml.serializer.*;
import org.yaml.snakeyaml.error.*;
import org.yaml.snakeyaml.emitter.*;
import java.util.regex.*;
import org.yaml.snakeyaml.reader.*;
import org.yaml.snakeyaml.introspector.*;
import org.yaml.snakeyaml.composer.*;
import java.io.*;

public class Yaml
{
    private /* synthetic */ String name;
    protected final /* synthetic */ Resolver resolver;
    protected /* synthetic */ DumperOptions dumperOptions;
    protected /* synthetic */ LoaderOptions loadingConfig;
    protected /* synthetic */ BaseConstructor constructor;
    protected /* synthetic */ Representer representer;
    
    public void dump(final Object lllllllllllllIIIIlIlIlIllIIlIlII, final Writer lllllllllllllIIIIlIlIlIllIIlIlll) {
        final List<Object> lllllllllllllIIIIlIlIlIllIIlIllI = new ArrayList<Object>(1);
        lllllllllllllIIIIlIlIlIllIIlIllI.add(lllllllllllllIIIIlIlIlIllIIlIlII);
        this.dumpAll(lllllllllllllIIIIlIlIlIllIIlIllI.iterator(), lllllllllllllIIIIlIlIlIllIIlIlll, null);
    }
    
    public String dump(final Object lllllllllllllIIIIlIlIlIllIllIIIl) {
        final List<Object> lllllllllllllIIIIlIlIlIllIllIIII = new ArrayList<Object>(1);
        lllllllllllllIIIIlIlIlIllIllIIII.add(lllllllllllllIIIIlIlIlIllIllIIIl);
        return this.dumpAll(lllllllllllllIIIIlIlIlIllIllIIII.iterator());
    }
    
    public Iterable<Event> parse(final Reader lllllllllllllIIIIlIlIlIIlIlllIIl) {
        final Parser lllllllllllllIIIIlIlIlIIlIlllIII = new ParserImpl(new StreamReader(lllllllllllllIIIIlIlIlIIlIlllIIl));
        final Iterator<Event> lllllllllllllIIIIlIlIlIIlIllIlll = new Iterator<Event>() {
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public Event next() {
                final Event llllllllllllllIlIlIIIllllllllIll = lllllllllllllIIIIlIlIlIIlIlllIII.getEvent();
                if (llllllllllllllIlIlIIIllllllllIll != null) {
                    return llllllllllllllIlIlIIIllllllllIll;
                }
                throw new NoSuchElementException("No Event is available.");
            }
            
            @Override
            public boolean hasNext() {
                return lllllllllllllIIIIlIlIlIIlIlllIII.peekEvent() != null;
            }
        };
        return new EventIterable(lllllllllllllIIIIlIlIlIIlIllIlll);
    }
    
    public Yaml() {
        this(new Constructor(), new Representer(), new DumperOptions(), new LoaderOptions(), new Resolver());
    }
    
    public List<Event> serialize(final Node lllllllllllllIIIIlIlIlIlIlIIIIII) {
        final SilentEmitter lllllllllllllIIIIlIlIlIlIlIIIIll = new SilentEmitter();
        final Serializer lllllllllllllIIIIlIlIlIlIlIIIIlI = new Serializer(lllllllllllllIIIIlIlIlIlIlIIIIll, this.resolver, this.dumperOptions, null);
        try {
            lllllllllllllIIIIlIlIlIlIlIIIIlI.open();
            lllllllllllllIIIIlIlIlIlIlIIIIlI.serialize(lllllllllllllIIIIlIlIlIlIlIIIIII);
            lllllllllllllIIIIlIlIlIlIlIIIIlI.close();
        }
        catch (IOException lllllllllllllIIIIlIlIlIlIlIIIllI) {
            throw new YAMLException(lllllllllllllIIIIlIlIlIlIlIIIllI);
        }
        return lllllllllllllIIIIlIlIlIlIlIIIIll.getEvents();
    }
    
    public void serialize(final Node lllllllllllllIIIIlIlIlIlIlIIllll, final Writer lllllllllllllIIIIlIlIlIlIlIlIIlI) {
        final Serializer lllllllllllllIIIIlIlIlIlIlIlIIIl = new Serializer(new Emitter(lllllllllllllIIIIlIlIlIlIlIlIIlI, this.dumperOptions), this.resolver, this.dumperOptions, null);
        try {
            lllllllllllllIIIIlIlIlIlIlIlIIIl.open();
            lllllllllllllIIIIlIlIlIlIlIlIIIl.serialize(lllllllllllllIIIIlIlIlIlIlIIllll);
            lllllllllllllIIIIlIlIlIlIlIlIIIl.close();
        }
        catch (IOException lllllllllllllIIIIlIlIlIlIlIlIlIl) {
            throw new YAMLException(lllllllllllllIIIIlIlIlIlIlIlIlIl);
        }
    }
    
    public Yaml(final Representer lllllllllllllIIIIlIlIlIlllllIIll, final DumperOptions lllllllllllllIIIIlIlIlIlllllIlIl) {
        this(new Constructor(), lllllllllllllIIIIlIlIlIlllllIIll, lllllllllllllIIIIlIlIlIlllllIlIl, new LoaderOptions(), new Resolver());
    }
    
    public Yaml(final BaseConstructor lllllllllllllIIIIlIlIllIIIIIlIlI) {
        this(lllllllllllllIIIIlIlIllIIIIIlIlI, new Representer());
    }
    
    public Yaml(final BaseConstructor lllllllllllllIIIIlIlIlIlllIlllll, final Representer lllllllllllllIIIIlIlIlIlllIllllI, final DumperOptions lllllllllllllIIIIlIlIlIlllIlllIl, final LoaderOptions lllllllllllllIIIIlIlIlIlllIlIlll) {
        this(lllllllllllllIIIIlIlIlIlllIlllll, lllllllllllllIIIIlIlIlIlllIllllI, lllllllllllllIIIIlIlIlIlllIlllIl, lllllllllllllIIIIlIlIlIlllIlIlll, new Resolver());
    }
    
    public Yaml(final Representer lllllllllllllIIIIlIlIllIIIIlIIII) {
        this(new Constructor(), lllllllllllllIIIIlIlIllIIIIlIIII);
    }
    
    public Yaml(final BaseConstructor lllllllllllllIIIIlIlIllIIIIIIlIl, final Representer lllllllllllllIIIIlIlIllIIIIIIIIl) {
        this(lllllllllllllIIIIlIlIllIIIIIIlIl, lllllllllllllIIIIlIlIllIIIIIIIIl, initDumperOptions(lllllllllllllIIIIlIlIllIIIIIIIIl));
    }
    
    public void addImplicitResolver(final Tag lllllllllllllIIIIlIlIlIIllIIllIl, final Pattern lllllllllllllIIIIlIlIlIIllIlIIII, final String lllllllllllllIIIIlIlIlIIllIIlIll) {
        this.resolver.addImplicitResolver(lllllllllllllIIIIlIlIlIIllIIllIl, lllllllllllllIIIIlIlIlIIllIlIIII, lllllllllllllIIIIlIlIlIIllIIlIll);
    }
    
    public <T> T loadAs(final Reader lllllllllllllIIIIlIlIlIlIIlIIIll, final Class<T> lllllllllllllIIIIlIlIlIlIIlIIlIl) {
        return (T)this.loadFromReader(new StreamReader(lllllllllllllIIIIlIlIlIlIIlIIIll), lllllllllllllIIIIlIlIlIlIIlIIlIl);
    }
    
    public Yaml(final BaseConstructor lllllllllllllIIIIlIlIlIllllIllII, final Representer lllllllllllllIIIIlIlIlIllllIlIll, final DumperOptions lllllllllllllIIIIlIlIlIllllIIllI) {
        this(lllllllllllllIIIIlIlIlIllllIllII, lllllllllllllIIIIlIlIlIllllIlIll, lllllllllllllIIIIlIlIlIllllIIllI, new LoaderOptions(), new Resolver());
    }
    
    public String getName() {
        return this.name;
    }
    
    public String dumpAll(final Iterator<?> lllllllllllllIIIIlIlIlIllIIlllll) {
        final StringWriter lllllllllllllIIIIlIlIlIllIlIIIIl = new StringWriter();
        this.dumpAll(lllllllllllllIIIIlIlIlIllIIlllll, lllllllllllllIIIIlIlIlIllIlIIIIl, null);
        return lllllllllllllIIIIlIlIlIllIlIIIIl.toString();
    }
    
    public <T> T load(final Reader lllllllllllllIIIIlIlIlIlIIlIllIl) {
        return (T)this.loadFromReader(new StreamReader(lllllllllllllIIIIlIlIlIlIIlIllIl), Object.class);
    }
    
    public <T> T load(final InputStream lllllllllllllIIIIlIlIlIlIIllIIll) {
        return (T)this.loadFromReader(new StreamReader(new UnicodeReader(lllllllllllllIIIIlIlIlIlIIllIIll)), Object.class);
    }
    
    public String dumpAs(final Object lllllllllllllIIIIlIlIlIlIllIllIl, final Tag lllllllllllllIIIIlIlIlIlIllIIlIl, final DumperOptions.FlowStyle lllllllllllllIIIIlIlIlIlIllIlIll) {
        final DumperOptions.FlowStyle lllllllllllllIIIIlIlIlIlIllIlIlI = this.representer.getDefaultFlowStyle();
        if (lllllllllllllIIIIlIlIlIlIllIlIll != null) {
            this.representer.setDefaultFlowStyle(lllllllllllllIIIIlIlIlIlIllIlIll);
        }
        final List<Object> lllllllllllllIIIIlIlIlIlIllIlIIl = new ArrayList<Object>(1);
        lllllllllllllIIIIlIlIlIlIllIlIIl.add(lllllllllllllIIIIlIlIlIlIllIllIl);
        final StringWriter lllllllllllllIIIIlIlIlIlIllIlIII = new StringWriter();
        this.dumpAll(lllllllllllllIIIIlIlIlIlIllIlIIl.iterator(), lllllllllllllIIIIlIlIlIlIllIlIII, lllllllllllllIIIIlIlIlIlIllIIlIl);
        this.representer.setDefaultFlowStyle(lllllllllllllIIIIlIlIlIlIllIlIlI);
        return lllllllllllllIIIIlIlIlIlIllIlIII.toString();
    }
    
    private static DumperOptions initDumperOptions(final Representer lllllllllllllIIIIlIlIlIlllllllII) {
        final DumperOptions lllllllllllllIIIIlIlIlIlllllllIl = new DumperOptions();
        lllllllllllllIIIIlIlIlIlllllllIl.setDefaultFlowStyle(lllllllllllllIIIIlIlIlIlllllllII.getDefaultFlowStyle());
        lllllllllllllIIIIlIlIlIlllllllIl.setDefaultScalarStyle(lllllllllllllIIIIlIlIlIlllllllII.getDefaultScalarStyle());
        lllllllllllllIIIIlIlIlIlllllllIl.setAllowReadOnlyProperties(lllllllllllllIIIIlIlIlIlllllllII.getPropertyUtils().isAllowReadOnlyProperties());
        lllllllllllllIIIIlIlIlIlllllllIl.setTimeZone(lllllllllllllIIIIlIlIlIlllllllII.getTimeZone());
        return lllllllllllllIIIIlIlIlIlllllllIl;
    }
    
    public <T> T loadAs(final String lllllllllllllIIIIlIlIlIlIIIlllIl, final Class<T> lllllllllllllIIIIlIlIlIlIIIlllII) {
        return (T)this.loadFromReader(new StreamReader(lllllllllllllIIIIlIlIlIlIIIlllIl), lllllllllllllIIIIlIlIlIlIIIlllII);
    }
    
    public String dumpAsMap(final Object lllllllllllllIIIIlIlIlIlIlIlllIl) {
        return this.dumpAs(lllllllllllllIIIIlIlIlIlIlIlllIl, Tag.MAP, DumperOptions.FlowStyle.BLOCK);
    }
    
    public Iterable<Object> loadAll(final InputStream lllllllllllllIIIIlIlIlIIlllIllII) {
        return this.loadAll(new UnicodeReader(lllllllllllllIIIIlIlIlIIlllIllII));
    }
    
    public Yaml(final BaseConstructor lllllllllllllIIIIlIlIlIlllIlIIII, final Representer lllllllllllllIIIIlIlIlIlllIIllll, final DumperOptions lllllllllllllIIIIlIlIlIlllIIlIIl, final Resolver lllllllllllllIIIIlIlIlIlllIIlIII) {
        this(lllllllllllllIIIIlIlIlIlllIlIIII, lllllllllllllIIIIlIlIlIlllIIllll, lllllllllllllIIIIlIlIlIlllIIlIIl, new LoaderOptions(), lllllllllllllIIIIlIlIlIlllIIlIII);
    }
    
    public <T> T loadAs(final InputStream lllllllllllllIIIIlIlIlIlIIIlIIIl, final Class<T> lllllllllllllIIIIlIlIlIlIIIlIIII) {
        return (T)this.loadFromReader(new StreamReader(new UnicodeReader(lllllllllllllIIIIlIlIlIlIIIlIIIl)), lllllllllllllIIIIlIlIlIlIIIlIIII);
    }
    
    public void setName(final String lllllllllllllIIIIlIlIlIIlIllllll) {
        this.name = lllllllllllllIIIIlIlIlIIlIllllll;
    }
    
    public void setBeanAccess(final BeanAccess lllllllllllllIIIIlIlIlIIlIlIllll) {
        this.constructor.getPropertyUtils().setBeanAccess(lllllllllllllIIIIlIlIlIIlIlIllll);
        this.representer.getPropertyUtils().setBeanAccess(lllllllllllllIIIIlIlIlIIlIlIllll);
    }
    
    public <T> T load(final String lllllllllllllIIIIlIlIlIlIIlllIIl) {
        return (T)this.loadFromReader(new StreamReader(lllllllllllllIIIIlIlIlIlIIlllIIl), Object.class);
    }
    
    public Iterable<Node> composeAll(final Reader lllllllllllllIIIIlIlIlIIllIlllIl) {
        final Composer lllllllllllllIIIIlIlIlIIllIlllII = new Composer(new ParserImpl(new StreamReader(lllllllllllllIIIIlIlIlIIllIlllIl)), this.resolver, this.loadingConfig);
        final Iterator<Node> lllllllllllllIIIIlIlIlIIllIllIll = new Iterator<Node>() {
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public Node next() {
                final Node lllllllllllllllllIlIIlIlIllIllII = lllllllllllllIIIIlIlIlIIllIlllII.getNode();
                if (lllllllllllllllllIlIIlIlIllIllII != null) {
                    return lllllllllllllllllIlIIlIlIllIllII;
                }
                throw new NoSuchElementException("No Node is available.");
            }
            
            @Override
            public boolean hasNext() {
                return lllllllllllllIIIIlIlIlIIllIlllII.checkNode();
            }
        };
        return new NodeIterable(lllllllllllllIIIIlIlIlIIllIllIll);
    }
    
    public Yaml(final DumperOptions lllllllllllllIIIIlIlIllIIIIllllI) {
        this(new Constructor(), new Representer(lllllllllllllIIIIlIlIllIIIIllllI), lllllllllllllIIIIlIlIllIIIIllllI);
    }
    
    private Object loadFromReader(final StreamReader lllllllllllllIIIIlIlIlIlIIIIlIlI, final Class<?> lllllllllllllIIIIlIlIlIlIIIIlIIl) {
        final Composer lllllllllllllIIIIlIlIlIlIIIIlIII = new Composer(new ParserImpl(lllllllllllllIIIIlIlIlIlIIIIlIlI), this.resolver, this.loadingConfig);
        this.constructor.setComposer(lllllllllllllIIIIlIlIlIlIIIIlIII);
        return this.constructor.getSingleData(lllllllllllllIIIIlIlIlIlIIIIlIIl);
    }
    
    private void dumpAll(final Iterator<?> lllllllllllllIIIIlIlIlIlIllllIlI, final Writer lllllllllllllIIIIlIlIlIlIllllllI, final Tag lllllllllllllIIIIlIlIlIlIllllIII) {
        final Serializer lllllllllllllIIIIlIlIlIlIlllllII = new Serializer(new Emitter(lllllllllllllIIIIlIlIlIlIllllllI, this.dumperOptions), this.resolver, this.dumperOptions, lllllllllllllIIIIlIlIlIlIllllIII);
        try {
            lllllllllllllIIIIlIlIlIlIlllllII.open();
            while (lllllllllllllIIIIlIlIlIlIllllIlI.hasNext()) {
                final Node lllllllllllllIIIIlIlIlIllIIIIIlI = this.representer.represent(lllllllllllllIIIIlIlIlIlIllllIlI.next());
                lllllllllllllIIIIlIlIlIlIlllllII.serialize(lllllllllllllIIIIlIlIlIllIIIIIlI);
            }
            lllllllllllllIIIIlIlIlIlIlllllII.close();
        }
        catch (IOException lllllllllllllIIIIlIlIlIllIIIIIIl) {
            throw new YAMLException(lllllllllllllIIIIlIlIlIllIIIIIIl);
        }
    }
    
    public Node compose(final Reader lllllllllllllIIIIlIlIlIIlllIIlII) {
        final Composer lllllllllllllIIIIlIlIlIIlllIIllI = new Composer(new ParserImpl(new StreamReader(lllllllllllllIIIIlIlIlIIlllIIlII)), this.resolver, this.loadingConfig);
        return lllllllllllllIIIIlIlIlIIlllIIllI.getSingleNode();
    }
    
    public void dumpAll(final Iterator<?> lllllllllllllIIIIlIlIlIllIIIlIlI, final Writer lllllllllllllIIIIlIlIlIllIIIlIIl) {
        this.dumpAll(lllllllllllllIIIIlIlIlIllIIIlIlI, lllllllllllllIIIIlIlIlIllIIIlIIl, null);
    }
    
    public Iterable<Object> loadAll(final Reader lllllllllllllIIIIlIlIlIIlllllllI) {
        final Composer lllllllllllllIIIIlIlIlIIllllllIl = new Composer(new ParserImpl(new StreamReader(lllllllllllllIIIIlIlIlIIlllllllI)), this.resolver, this.loadingConfig);
        this.constructor.setComposer(lllllllllllllIIIIlIlIlIIllllllIl);
        final Iterator<Object> lllllllllllllIIIIlIlIlIIllllllII = new Iterator<Object>() {
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public Object next() {
                return Yaml.this.constructor.getData();
            }
            
            @Override
            public boolean hasNext() {
                return Yaml.this.constructor.checkData();
            }
        };
        return new YamlIterable(lllllllllllllIIIIlIlIlIIllllllII);
    }
    
    public Iterable<Object> loadAll(final String lllllllllllllIIIIlIlIlIIllllIlII) {
        return this.loadAll(new StringReader(lllllllllllllIIIIlIlIlIIllllIlII));
    }
    
    public Yaml(final LoaderOptions lllllllllllllIIIIlIlIllIIIIllIII) {
        this(new Constructor(lllllllllllllIIIIlIlIllIIIIllIII), new Representer(), new DumperOptions(), lllllllllllllIIIIlIlIllIIIIllIII);
    }
    
    public Node represent(final Object lllllllllllllIIIIlIlIlIllIlIIlll) {
        return this.representer.represent(lllllllllllllIIIIlIlIlIllIlIIlll);
    }
    
    public Yaml(final BaseConstructor lllllllllllllIIIIlIlIlIllIlllIlI, final Representer lllllllllllllIIIIlIlIlIllIlllIIl, final DumperOptions lllllllllllllIIIIlIlIlIllIlllllI, final LoaderOptions lllllllllllllIIIIlIlIlIllIllIlll, final Resolver lllllllllllllIIIIlIlIlIllIllIllI) {
        if (!lllllllllllllIIIIlIlIlIllIlllIlI.isExplicitPropertyUtils()) {
            lllllllllllllIIIIlIlIlIllIlllIlI.setPropertyUtils(lllllllllllllIIIIlIlIlIllIlllIIl.getPropertyUtils());
        }
        else if (!lllllllllllllIIIIlIlIlIllIlllIIl.isExplicitPropertyUtils()) {
            lllllllllllllIIIIlIlIlIllIlllIIl.setPropertyUtils(lllllllllllllIIIIlIlIlIllIlllIlI.getPropertyUtils());
        }
        this.constructor = lllllllllllllIIIIlIlIlIllIlllIlI;
        this.constructor.setAllowDuplicateKeys(lllllllllllllIIIIlIlIlIllIllIlll.isAllowDuplicateKeys());
        this.constructor.setWrappedToRootException(lllllllllllllIIIIlIlIlIllIllIlll.isWrappedToRootException());
        if (!lllllllllllllIIIIlIlIlIllIlllllI.getIndentWithIndicator() && lllllllllllllIIIIlIlIlIllIlllllI.getIndent() <= lllllllllllllIIIIlIlIlIllIlllllI.getIndicatorIndent()) {
            throw new YAMLException("Indicator indent must be smaller then indent.");
        }
        lllllllllllllIIIIlIlIlIllIlllIIl.setDefaultFlowStyle(lllllllllllllIIIIlIlIlIllIlllllI.getDefaultFlowStyle());
        lllllllllllllIIIIlIlIlIllIlllIIl.setDefaultScalarStyle(lllllllllllllIIIIlIlIlIllIlllllI.getDefaultScalarStyle());
        lllllllllllllIIIIlIlIlIllIlllIIl.getPropertyUtils().setAllowReadOnlyProperties(lllllllllllllIIIIlIlIlIllIlllllI.isAllowReadOnlyProperties());
        lllllllllllllIIIIlIlIlIllIlllIIl.setTimeZone(lllllllllllllIIIIlIlIlIllIlllllI.getTimeZone());
        this.representer = lllllllllllllIIIIlIlIlIllIlllIIl;
        this.dumperOptions = lllllllllllllIIIIlIlIlIllIlllllI;
        this.loadingConfig = lllllllllllllIIIIlIlIlIllIllIlll;
        this.resolver = lllllllllllllIIIIlIlIlIllIllIllI;
        this.name = String.valueOf(new StringBuilder().append("Yaml:").append(System.identityHashCode(this)));
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public void addTypeDescription(final TypeDescription lllllllllllllIIIIlIlIlIIlIlIIlll) {
        this.constructor.addTypeDescription(lllllllllllllIIIIlIlIlIIlIlIIlll);
        this.representer.addTypeDescription(lllllllllllllIIIIlIlIlIIlIlIIlll);
    }
    
    private static class EventIterable implements Iterable<Event>
    {
        private /* synthetic */ Iterator<Event> iterator;
        
        public EventIterable(final Iterator<Event> lllllllllllllIIllIlIlllIIIIlIllI) {
            this.iterator = lllllllllllllIIllIlIlllIIIIlIllI;
        }
        
        @Override
        public Iterator<Event> iterator() {
            return this.iterator;
        }
    }
    
    private static class YamlIterable implements Iterable<Object>
    {
        private /* synthetic */ Iterator<Object> iterator;
        
        @Override
        public Iterator<Object> iterator() {
            return this.iterator;
        }
        
        public YamlIterable(final Iterator<Object> lllllllllllllIllIIlIIlIIlIIIIIll) {
            this.iterator = lllllllllllllIllIIlIIlIIlIIIIIll;
        }
    }
    
    private static class NodeIterable implements Iterable<Node>
    {
        private /* synthetic */ Iterator<Node> iterator;
        
        @Override
        public Iterator<Node> iterator() {
            return this.iterator;
        }
        
        public NodeIterable(final Iterator<Node> lllllllllllllIIIlIllllIIlllIlIIl) {
            this.iterator = lllllllllllllIIIlIllllIIlllIlIIl;
        }
    }
    
    private static class SilentEmitter implements Emitable
    {
        private /* synthetic */ List<Event> events;
        
        public List<Event> getEvents() {
            return this.events;
        }
        
        private SilentEmitter() {
            this.events = new ArrayList<Event>(100);
        }
        
        @Override
        public void emit(final Event lllIIIIIIllIIIl) throws IOException {
            this.events.add(lllIIIIIIllIIIl);
        }
    }
}
