package com.viaversion.viaversion.protocols.base;

import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;
import com.viaversion.viaversion.api.type.*;

public class BaseProtocol1_16 extends BaseProtocol1_7
{
    @Override
    protected UUID passthroughLoginUUID(final PacketWrapper lllllllllllllIIIIlIIIIlIlIlIIIII) throws Exception {
        return lllllllllllllIIIIlIIIIlIlIlIIIII.passthrough(Type.UUID_INT_ARRAY);
    }
}
