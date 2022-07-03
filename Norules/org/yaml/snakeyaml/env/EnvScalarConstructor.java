package org.yaml.snakeyaml.env;

import org.yaml.snakeyaml.error.*;
import org.yaml.snakeyaml.constructor.*;
import org.yaml.snakeyaml.nodes.*;
import java.util.regex.*;

public class EnvScalarConstructor extends Constructor
{
    public static final /* synthetic */ Tag ENV_TAG;
    public static final /* synthetic */ Pattern ENV_FORMAT;
    
    public String getEnv(final String llllllllllllllIIIIIlIllIlIllllIl) {
        return System.getenv(llllllllllllllIIIIIlIllIlIllllIl);
    }
    
    static {
        ENV_TAG = new Tag("!ENV");
        ENV_FORMAT = Pattern.compile("^\\$\\{\\s*((?<name>\\w+)((?<separator>:?(-|\\?))(?<value>\\w+)?)?)\\s*\\}$");
    }
    
    public EnvScalarConstructor() {
        this.yamlConstructors.put(EnvScalarConstructor.ENV_TAG, new ConstructEnv());
    }
    
    public String apply(final String llllllllllllllIIIIIlIllIllIlIIll, final String llllllllllllllIIIIIlIllIllIIlIIl, final String llllllllllllllIIIIIlIllIllIIllll, final String llllllllllllllIIIIIlIllIllIIllIl) {
        if (llllllllllllllIIIIIlIllIllIIllIl != null && !llllllllllllllIIIIIlIllIllIIllIl.isEmpty()) {
            return llllllllllllllIIIIIlIllIllIIllIl;
        }
        if (llllllllllllllIIIIIlIllIllIIlIIl != null) {
            if (llllllllllllllIIIIIlIllIllIIlIIl.equals("?") && llllllllllllllIIIIIlIllIllIIllIl == null) {
                throw new MissingEnvironmentVariableException(String.valueOf(new StringBuilder().append("Missing mandatory variable ").append(llllllllllllllIIIIIlIllIllIlIIll).append(": ").append(llllllllllllllIIIIIlIllIllIIllll)));
            }
            if (llllllllllllllIIIIIlIllIllIIlIIl.equals(":?")) {
                if (llllllllllllllIIIIIlIllIllIIllIl == null) {
                    throw new MissingEnvironmentVariableException(String.valueOf(new StringBuilder().append("Missing mandatory variable ").append(llllllllllllllIIIIIlIllIllIlIIll).append(": ").append(llllllllllllllIIIIIlIllIllIIllll)));
                }
                if (llllllllllllllIIIIIlIllIllIIllIl.isEmpty()) {
                    throw new MissingEnvironmentVariableException(String.valueOf(new StringBuilder().append("Empty mandatory variable ").append(llllllllllllllIIIIIlIllIllIlIIll).append(": ").append(llllllllllllllIIIIIlIllIllIIllll)));
                }
            }
            if (llllllllllllllIIIIIlIllIllIIlIIl.startsWith(":")) {
                if (llllllllllllllIIIIIlIllIllIIllIl == null || llllllllllllllIIIIIlIllIllIIllIl.isEmpty()) {
                    return llllllllllllllIIIIIlIllIllIIllll;
                }
            }
            else if (llllllllllllllIIIIIlIllIllIIllIl == null) {
                return llllllllllllllIIIIIlIllIllIIllll;
            }
        }
        return "";
    }
    
    private class ConstructEnv extends AbstractConstruct
    {
        @Override
        public Object construct(final Node lllllllllllllIlIIIIlIIlIIlIIIllI) {
            final String lllllllllllllIlIIIIlIIlIIlIIllII = BaseConstructor.this.constructScalar((ScalarNode)lllllllllllllIlIIIIlIIlIIlIIIllI);
            final Matcher lllllllllllllIlIIIIlIIlIIlIIlIll = EnvScalarConstructor.ENV_FORMAT.matcher(lllllllllllllIlIIIIlIIlIIlIIllII);
            lllllllllllllIlIIIIlIIlIIlIIlIll.matches();
            final String lllllllllllllIlIIIIlIIlIIlIIlIlI = lllllllllllllIlIIIIlIIlIIlIIlIll.group("name");
            final String lllllllllllllIlIIIIlIIlIIlIIlIIl = lllllllllllllIlIIIIlIIlIIlIIlIll.group("value");
            final String lllllllllllllIlIIIIlIIlIIlIIlIII = lllllllllllllIlIIIIlIIlIIlIIlIll.group("separator");
            return EnvScalarConstructor.this.apply(lllllllllllllIlIIIIlIIlIIlIIlIlI, lllllllllllllIlIIIIlIIlIIlIIlIII, (lllllllllllllIlIIIIlIIlIIlIIlIIl != null) ? lllllllllllllIlIIIIlIIlIIlIIlIIl : "", EnvScalarConstructor.this.getEnv(lllllllllllllIlIIIIlIIlIIlIIlIlI));
        }
    }
}
