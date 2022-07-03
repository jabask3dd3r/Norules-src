package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;

final class LegacyFormattingDetected extends Nag
{
    LegacyFormattingDetected(final Component llllllllllllIlllllIlIIIIIIIlIIlI) {
        super(String.valueOf(new StringBuilder().append("Legacy formatting codes have been detected in a component - this is unsupported behaviour. Please refer to the Adventure documentation (https://docs.adventure.kyori.net) for more information. Component: ").append(llllllllllllIlllllIlIIIIIIIlIIlI)));
    }
}
