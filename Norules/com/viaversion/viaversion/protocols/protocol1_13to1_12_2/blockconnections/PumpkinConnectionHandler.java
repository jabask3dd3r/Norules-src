package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

public class PumpkinConnectionHandler extends AbstractStempConnectionHandler
{
    public PumpkinConnectionHandler(final String llllllllllllllllllIlIllIIllIllII) {
        super(llllllllllllllllllIlIllIIllIllII);
    }
    
    static ConnectionData.ConnectorInitAction init() {
        return new PumpkinConnectionHandler("minecraft:pumpkin_stem[age=7]").getInitAction("minecraft:carved_pumpkin", "minecraft:attached_pumpkin_stem");
    }
}
