package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.nodes.*;
import org.yaml.snakeyaml.error.*;

public abstract class AbstractConstruct implements Construct
{
    @Override
    public void construct2ndStep(final Node lllllllllllllllIllIIlIIllIIIlIlI, final Object lllllllllllllllIllIIlIIllIIIllII) {
        if (lllllllllllllllIllIIlIIllIIIlIlI.isTwoStepsConstruction()) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Not Implemented in ").append(this.getClass().getName())));
        }
        throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected recursive structure for Node: ").append(lllllllllllllllIllIIlIIllIIIlIlI)));
    }
}
