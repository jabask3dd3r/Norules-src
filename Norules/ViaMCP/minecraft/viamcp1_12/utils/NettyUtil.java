package ViaMCP.minecraft.viamcp1_12.utils;

import io.netty.channel.*;

public class NettyUtil
{
    public static ChannelPipeline decodeEncodePlacement(final ChannelPipeline lllllllllllllIlIIIlIlIIIIIlIIlll, String lllllllllllllIlIIIlIlIIIIIlIIIlI, final String lllllllllllllIlIIIlIlIIIIIlIIlIl, final ChannelHandler lllllllllllllIlIIIlIlIIIIIlIIlII) {
        final byte lllllllllllllIlIIIlIlIIIIIIlllll;
        switch (((String)(lllllllllllllIlIIIlIlIIIIIIlllll = (byte)lllllllllllllIlIIIlIlIIIIIlIIIlI)).hashCode()) {
            case -1607367396: {
                if (!((String)lllllllllllllIlIIIlIlIIIIIIlllll).equals("encoder")) {
                    break;
                }
                if (lllllllllllllIlIIIlIlIIIIIlIIlll.get("via-encoder") != null) {
                    lllllllllllllIlIIIlIlIIIIIlIIIlI = "via-encoder";
                    break;
                }
                break;
            }
            case 1542433860: {
                if (!((String)lllllllllllllIlIIIlIlIIIIIIlllll).equals("decoder")) {
                    break;
                }
                if (lllllllllllllIlIIIlIlIIIIIlIIlll.get("via-decoder") != null) {
                    lllllllllllllIlIIIlIlIIIIIlIIIlI = "via-decoder";
                    break;
                }
                break;
            }
        }
        return lllllllllllllIlIIIlIlIIIIIlIIlll.addBefore(lllllllllllllIlIIIlIlIIIIIlIIIlI, lllllllllllllIlIIIlIlIIIIIlIIlIl, lllllllllllllIlIIIlIlIIIIIlIIlII);
    }
}
