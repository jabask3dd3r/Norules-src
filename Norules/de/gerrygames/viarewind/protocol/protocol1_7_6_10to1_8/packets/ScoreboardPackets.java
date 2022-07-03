package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.*;
import io.netty.buffer.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.util.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.*;

public class ScoreboardPackets
{
    public static void register(final Protocol1_7_6_10TO1_8 llllllllllllllIlIllIlIIIllIlIllI) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllIlIllIlIIIllIlIllI).registerClientbound(ClientboundPackets1_8.SCOREBOARD_OBJECTIVE, new PacketRemapper() {
            @Override
            public void registerMap() {
                String lllllllllllllllllllIlIllIlIIIlll;
                Type<String> string;
                final int n;
                final T t;
                final byte lllllllllllllllllllIlIllIlIIIllI;
                final Scoreboard lllllllllllllllllllIlIllIlIIIlIl;
                String lllllllllllllllllllIlIllIlIIlIll;
                Optional<Byte> lllllllllllllllllllIlIllIlIIlIlI;
                String lllllllllllllllllllIlIllIlIIllII;
                PacketWrapper lllllllllllllllllllIlIllIlIIllIl;
                String lllllllllllllllllllIlIllIlIIlIIl;
                this.handler(lllllllllllllllllllIlIllIlIIIlII -> {
                    lllllllllllllllllllIlIllIlIIIlll = lllllllllllllllllllIlIllIlIIIlII.passthrough(Type.STRING);
                    if (lllllllllllllllllllIlIllIlIIIlll.length() > 16) {
                        string = Type.STRING;
                        lllllllllllllllllllIlIllIlIIIlll = lllllllllllllllllllIlIllIlIIIlll.substring(0, 16);
                        lllllllllllllllllllIlIllIlIIIlII.set(string, n, (String)t);
                    }
                    lllllllllllllllllllIlIllIlIIIllI = lllllllllllllllllllIlIllIlIIIlII.read((Type<Byte>)Type.BYTE);
                    lllllllllllllllllllIlIllIlIIIlIl = lllllllllllllllllllIlIllIlIIIlII.user().get(Scoreboard.class);
                    if (lllllllllllllllllllIlIllIlIIIllI == 0) {
                        if (lllllllllllllllllllIlIllIlIIIlIl.objectiveExists(lllllllllllllllllllIlIllIlIIIlll)) {
                            lllllllllllllllllllIlIllIlIIIlII.cancel();
                            return;
                        }
                        else {
                            lllllllllllllllllllIlIllIlIIIlIl.addObjective(lllllllllllllllllllIlIllIlIIIlll);
                        }
                    }
                    else if (lllllllllllllllllllIlIllIlIIIllI == 1) {
                        if (!lllllllllllllllllllIlIllIlIIIlIl.objectiveExists(lllllllllllllllllllIlIllIlIIIlll)) {
                            lllllllllllllllllllIlIllIlIIIlII.cancel();
                            return;
                        }
                        else {
                            if (lllllllllllllllllllIlIllIlIIIlIl.getColorIndependentSidebar() != null) {
                                lllllllllllllllllllIlIllIlIIlIll = lllllllllllllllllllIlIllIlIIIlII.user().getProtocolInfo().getUsername();
                                lllllllllllllllllllIlIllIlIIlIlI = lllllllllllllllllllIlIllIlIIIlIl.getPlayerTeamColor(lllllllllllllllllllIlIllIlIIlIll);
                                if (lllllllllllllllllllIlIllIlIIlIlI.isPresent()) {
                                    lllllllllllllllllllIlIllIlIIllII = lllllllllllllllllllIlIllIlIIIlIl.getColorDependentSidebar().get(lllllllllllllllllllIlIllIlIIlIlI.get());
                                    if (lllllllllllllllllllIlIllIlIIIlll.equals(lllllllllllllllllllIlIllIlIIllII)) {
                                        lllllllllllllllllllIlIllIlIIllIl = PacketWrapper.create(61, null, lllllllllllllllllllIlIllIlIIIlII.user());
                                        lllllllllllllllllllIlIllIlIIllIl.write(Type.BYTE, (Byte)1);
                                        lllllllllllllllllllIlIllIlIIllIl.write(Type.STRING, lllllllllllllllllllIlIllIlIIIlIl.getColorIndependentSidebar());
                                        PacketUtil.sendPacket(lllllllllllllllllllIlIllIlIIllIl, Protocol1_7_6_10TO1_8.class);
                                    }
                                }
                            }
                            lllllllllllllllllllIlIllIlIIIlIl.removeObjective(lllllllllllllllllllIlIllIlIIIlll);
                        }
                    }
                    else if (lllllllllllllllllllIlIllIlIIIllI == 2 && !lllllllllllllllllllIlIllIlIIIlIl.objectiveExists(lllllllllllllllllllIlIllIlIIIlll)) {
                        lllllllllllllllllllIlIllIlIIIlII.cancel();
                        return;
                    }
                    if (lllllllllllllllllllIlIllIlIIIllI == 0 || lllllllllllllllllllIlIllIlIIIllI == 2) {
                        lllllllllllllllllllIlIllIlIIlIIl = lllllllllllllllllllIlIllIlIIIlII.passthrough(Type.STRING);
                        if (lllllllllllllllllllIlIllIlIIlIIl.length() > 32) {
                            lllllllllllllllllllIlIllIlIIIlII.set(Type.STRING, 1, lllllllllllllllllllIlIllIlIIlIIl.substring(0, 32));
                        }
                        lllllllllllllllllllIlIllIlIIIlII.read(Type.STRING);
                    }
                    else {
                        lllllllllllllllllllIlIllIlIIIlII.write(Type.STRING, "");
                    }
                    lllllllllllllllllllIlIllIlIIIlII.write(Type.BYTE, lllllllllllllllllllIlIllIlIIIllI);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllIlIllIlIIIllIlIllI).registerClientbound(ClientboundPackets1_8.UPDATE_SCORE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Scoreboard lllllllllllllIIIIllllllllllllIIl;
                final String lllllllllllllIIIIllllllllllllIII;
                final byte lllllllllllllIIIIlllllllllllIlll;
                String lllllllllllllIIIIllllllllllllIII2;
                String lllllllllllllIIIIlllllllllllIllI;
                int lllllllllllllIIIIllllllllllllIll;
                this.handler(lllllllllllllIIIIllllllllllllIlI -> {
                    lllllllllllllIIIIllllllllllllIIl = lllllllllllllIIIIllllllllllllIlI.user().get(Scoreboard.class);
                    lllllllllllllIIIIllllllllllllIII = lllllllllllllIIIIllllllllllllIlI.passthrough(Type.STRING);
                    lllllllllllllIIIIlllllllllllIlll = lllllllllllllIIIIllllllllllllIlI.passthrough((Type<Byte>)Type.BYTE);
                    if (lllllllllllllIIIIlllllllllllIlll == 1) {
                        lllllllllllllIIIIllllllllllllIII2 = lllllllllllllIIIIllllllllllllIIl.removeTeamForScore(lllllllllllllIIIIllllllllllllIII);
                    }
                    else {
                        lllllllllllllIIIIllllllllllllIII2 = lllllllllllllIIIIllllllllllllIIl.sendTeamForScore(lllllllllllllIIIIllllllllllllIII);
                    }
                    if (lllllllllllllIIIIllllllllllllIII2.length() > 16) {
                        lllllllllllllIIIIllllllllllllIII2 = ChatColorUtil.stripColor(lllllllllllllIIIIllllllllllllIII2);
                        if (lllllllllllllIIIIllllllllllllIII2.length() > 16) {
                            lllllllllllllIIIIllllllllllllIII2 = lllllllllllllIIIIllllllllllllIII2.substring(0, 16);
                        }
                    }
                    lllllllllllllIIIIllllllllllllIlI.set(Type.STRING, 0, lllllllllllllIIIIllllllllllllIII2);
                    lllllllllllllIIIIlllllllllllIllI = lllllllllllllIIIIllllllllllllIlI.read(Type.STRING);
                    if (lllllllllllllIIIIlllllllllllIllI.length() > 16) {
                        lllllllllllllIIIIlllllllllllIllI = lllllllllllllIIIIlllllllllllIllI.substring(0, 16);
                    }
                    if (lllllllllllllIIIIlllllllllllIlll != 1) {
                        lllllllllllllIIIIllllllllllllIll = lllllllllllllIIIIllllllllllllIlI.read((Type<Integer>)Type.VAR_INT);
                        lllllllllllllIIIIllllllllllllIlI.write(Type.STRING, lllllllllllllIIIIlllllllllllIllI);
                        lllllllllllllIIIIllllllllllllIlI.write(Type.INT, lllllllllllllIIIIllllllllllllIll);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllIlIllIlIIIllIlIllI).registerClientbound(ClientboundPackets1_8.DISPLAY_SCOREBOARD, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BYTE);
                this.map(Type.STRING);
                byte lllllllllllllIIllIIlIlllIlIllllI;
                final String lllllllllllllIIllIIlIlllIlIlllIl;
                final Scoreboard lllllllllllllIIllIIlIlllIlIlllII;
                byte lllllllllllllIIllIIlIlllIllIIlII;
                String lllllllllllllIIllIIlIlllIllIIIll;
                Optional<Byte> lllllllllllllIIllIIlIlllIllIIIlI;
                String lllllllllllllIIllIIlIlllIllIIIIl;
                Optional<Byte> lllllllllllllIIllIIlIlllIllIIIII;
                this.handler(lllllllllllllIIllIIlIlllIlIlllll -> {
                    lllllllllllllIIllIIlIlllIlIllllI = lllllllllllllIIllIIlIlllIlIlllll.get((Type<Byte>)Type.BYTE, 0);
                    lllllllllllllIIllIIlIlllIlIlllIl = lllllllllllllIIllIIlIlllIlIlllll.get(Type.STRING, 0);
                    lllllllllllllIIllIIlIlllIlIlllII = lllllllllllllIIllIIlIlllIlIlllll.user().get(Scoreboard.class);
                    if (lllllllllllllIIllIIlIlllIlIllllI > 2) {
                        lllllllllllllIIllIIlIlllIllIIlII = (byte)(lllllllllllllIIllIIlIlllIlIllllI - 3);
                        lllllllllllllIIllIIlIlllIlIlllII.getColorDependentSidebar().put(lllllllllllllIIllIIlIlllIllIIlII, lllllllllllllIIllIIlIlllIlIlllIl);
                        lllllllllllllIIllIIlIlllIllIIIll = lllllllllllllIIllIIlIlllIlIlllll.user().getProtocolInfo().getUsername();
                        lllllllllllllIIllIIlIlllIllIIIlI = lllllllllllllIIllIIlIlllIlIlllII.getPlayerTeamColor(lllllllllllllIIllIIlIlllIllIIIll);
                        if (lllllllllllllIIllIIlIlllIllIIIlI.isPresent() && lllllllllllllIIllIIlIlllIllIIIlI.get() == lllllllllllllIIllIIlIlllIllIIlII) {
                            lllllllllllllIIllIIlIlllIlIllllI = 1;
                        }
                        else {
                            lllllllllllllIIllIIlIlllIlIllllI = -1;
                        }
                    }
                    else if (lllllllllllllIIllIIlIlllIlIllllI == 1) {
                        lllllllllllllIIllIIlIlllIlIlllII.setColorIndependentSidebar(lllllllllllllIIllIIlIlllIlIlllIl);
                        lllllllllllllIIllIIlIlllIllIIIIl = lllllllllllllIIllIIlIlllIlIlllll.user().getProtocolInfo().getUsername();
                        lllllllllllllIIllIIlIlllIllIIIII = lllllllllllllIIllIIlIlllIlIlllII.getPlayerTeamColor(lllllllllllllIIllIIlIlllIllIIIIl);
                        if (lllllllllllllIIllIIlIlllIllIIIII.isPresent() && lllllllllllllIIllIIlIlllIlIlllII.getColorDependentSidebar().containsKey(lllllllllllllIIllIIlIlllIllIIIII.get())) {
                            lllllllllllllIIllIIlIlllIlIllllI = -1;
                        }
                    }
                    if (lllllllllllllIIllIIlIlllIlIllllI == -1) {
                        lllllllllllllIIllIIlIlllIlIlllll.cancel();
                    }
                    else {
                        lllllllllllllIIllIIlIlllIlIlllll.set(Type.BYTE, 0, lllllllllllllIIllIIlIlllIlIllllI);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllIlIllIlIIIllIlIllI).registerClientbound(ClientboundPackets1_8.TEAMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String llllllllllllllIIllIIIllIIlIIlIlI;
                byte llllllllllllllIIllIIIllIIlIIlIIl;
                Scoreboard llllllllllllllIIllIIIllIIlIIlIII;
                PacketWrapper llllllllllllllIIllIIIllIIlIllIIl;
                byte llllllllllllllIIllIIIllIIlIlIlIl;
                String llllllllllllllIIllIIIllIIlIllIII;
                String llllllllllllllIIllIIIllIIlIlIlll;
                PacketWrapper llllllllllllllIIllIIIllIIlIlIllI;
                byte llllllllllllllIIllIIIllIIlIIlllI;
                String[] llllllllllllllIIllIIIllIIlIIllIl;
                ArrayList<String> llllllllllllllIIllIIIllIIlIIllII;
                int llllllllllllllIIllIIIllIIlIlIIII;
                String llllllllllllllIIllIIIllIIlIlIIlI;
                String llllllllllllllIIllIIIllIIlIlIIIl;
                PacketWrapper llllllllllllllIIllIIIllIIlIlIlII;
                PacketWrapper llllllllllllllIIllIIIllIIlIlIIll;
                final Iterator<String> iterator;
                String llllllllllllllIIllIIIllIIlIIllll;
                this.handler(llllllllllllllIIllIIIllIIlIIIlll -> {
                    llllllllllllllIIllIIIllIIlIIlIlI = llllllllllllllIIllIIIllIIlIIIlll.get(Type.STRING, 0);
                    if (llllllllllllllIIllIIIllIIlIIlIlI == null) {
                        llllllllllllllIIllIIIllIIlIIIlll.cancel();
                    }
                    else {
                        llllllllllllllIIllIIIllIIlIIlIIl = llllllllllllllIIllIIIllIIlIIIlll.passthrough((Type<Byte>)Type.BYTE);
                        llllllllllllllIIllIIIllIIlIIlIII = llllllllllllllIIllIIIllIIlIIIlll.user().get(Scoreboard.class);
                        if (llllllllllllllIIllIIIllIIlIIlIIl != 0 && !llllllllllllllIIllIIIllIIlIIlIII.teamExists(llllllllllllllIIllIIIllIIlIIlIlI)) {
                            llllllllllllllIIllIIIllIIlIIIlll.cancel();
                        }
                        else {
                            if (llllllllllllllIIllIIIllIIlIIlIIl == 0 && llllllllllllllIIllIIIllIIlIIlIII.teamExists(llllllllllllllIIllIIIllIIlIIlIlI)) {
                                llllllllllllllIIllIIIllIIlIIlIII.removeTeam(llllllllllllllIIllIIIllIIlIIlIlI);
                                llllllllllllllIIllIIIllIIlIllIIl = PacketWrapper.create(62, null, llllllllllllllIIllIIIllIIlIIIlll.user());
                                llllllllllllllIIllIIIllIIlIllIIl.write(Type.STRING, llllllllllllllIIllIIIllIIlIIlIlI);
                                llllllllllllllIIllIIIllIIlIllIIl.write(Type.BYTE, (Byte)1);
                                PacketUtil.sendPacket(llllllllllllllIIllIIIllIIlIllIIl, Protocol1_7_6_10TO1_8.class, true, true);
                            }
                            if (llllllllllllllIIllIIIllIIlIIlIIl == 0) {
                                llllllllllllllIIllIIIllIIlIIlIII.addTeam(llllllllllllllIIllIIIllIIlIIlIlI);
                            }
                            else if (llllllllllllllIIllIIIllIIlIIlIIl == 1) {
                                llllllllllllllIIllIIIllIIlIIlIII.removeTeam(llllllllllllllIIllIIIllIIlIIlIlI);
                            }
                            if (llllllllllllllIIllIIIllIIlIIlIIl == 0 || llllllllllllllIIllIIIllIIlIIlIIl == 2) {
                                llllllllllllllIIllIIIllIIlIIIlll.passthrough(Type.STRING);
                                llllllllllllllIIllIIIllIIlIIIlll.passthrough(Type.STRING);
                                llllllllllllllIIllIIIllIIlIIIlll.passthrough(Type.STRING);
                                llllllllllllllIIllIIIllIIlIIIlll.passthrough((Type<Object>)Type.BYTE);
                                llllllllllllllIIllIIIllIIlIIIlll.read(Type.STRING);
                                llllllllllllllIIllIIIllIIlIlIlIl = llllllllllllllIIllIIIllIIlIIIlll.read((Type<Byte>)Type.BYTE);
                                if (llllllllllllllIIllIIIllIIlIIlIIl == 2 && llllllllllllllIIllIIIllIIlIIlIII.getTeamColor(llllllllllllllIIllIIIllIIlIIlIlI).get() != llllllllllllllIIllIIIllIIlIlIlIl) {
                                    llllllllllllllIIllIIIllIIlIllIII = llllllllllllllIIllIIIllIIlIIIlll.user().getProtocolInfo().getUsername();
                                    llllllllllllllIIllIIIllIIlIlIlll = llllllllllllllIIllIIIllIIlIIlIII.getColorDependentSidebar().get(llllllllllllllIIllIIIllIIlIlIlIl);
                                    llllllllllllllIIllIIIllIIlIlIllI = llllllllllllllIIllIIIllIIlIIIlll.create(61);
                                    llllllllllllllIIllIIIllIIlIlIllI.write(Type.BYTE, (Byte)1);
                                    llllllllllllllIIllIIIllIIlIlIllI.write(Type.STRING, (llllllllllllllIIllIIIllIIlIlIlll == null) ? "" : llllllllllllllIIllIIIllIIlIlIlll);
                                    PacketUtil.sendPacket(llllllllllllllIIllIIIllIIlIlIllI, Protocol1_7_6_10TO1_8.class);
                                }
                                llllllllllllllIIllIIIllIIlIIlIII.setTeamColor(llllllllllllllIIllIIIllIIlIIlIlI, llllllllllllllIIllIIIllIIlIlIlIl);
                            }
                            if (llllllllllllllIIllIIIllIIlIIlIIl == 0 || llllllllllllllIIllIIIllIIlIIlIIl == 3 || llllllllllllllIIllIIIllIIlIIlIIl == 4) {
                                llllllllllllllIIllIIIllIIlIIlllI = llllllllllllllIIllIIIllIIlIIlIII.getTeamColor(llllllllllllllIIllIIIllIIlIIlIlI).get();
                                llllllllllllllIIllIIIllIIlIIllIl = llllllllllllllIIllIIIllIIlIIIlll.read(Type.STRING_ARRAY);
                                llllllllllllllIIllIIIllIIlIIllII = new ArrayList<String>();
                                for (llllllllllllllIIllIIIllIIlIlIIII = 0; llllllllllllllIIllIIIllIIlIlIIII < llllllllllllllIIllIIIllIIlIIllIl.length; ++llllllllllllllIIllIIIllIIlIlIIII) {
                                    llllllllllllllIIllIIIllIIlIlIIlI = llllllllllllllIIllIIIllIIlIIllIl[llllllllllllllIIllIIIllIIlIlIIII];
                                    llllllllllllllIIllIIIllIIlIlIIIl = llllllllllllllIIllIIIllIIlIIIlll.user().getProtocolInfo().getUsername();
                                    if (llllllllllllllIIllIIIllIIlIIlIIl == 4) {
                                        if (!llllllllllllllIIllIIIllIIlIIlIII.isPlayerInTeam(llllllllllllllIIllIIIllIIlIlIIlI, llllllllllllllIIllIIIllIIlIIlIlI)) {
                                            continue;
                                        }
                                        else {
                                            llllllllllllllIIllIIIllIIlIIlIII.removePlayerFromTeam(llllllllllllllIIllIIIllIIlIlIIlI, llllllllllllllIIllIIIllIIlIIlIlI);
                                            if (llllllllllllllIIllIIIllIIlIlIIlI.equals(llllllllllllllIIllIIIllIIlIlIIIl)) {
                                                llllllllllllllIIllIIIllIIlIlIlII = llllllllllllllIIllIIIllIIlIIIlll.create(61);
                                                llllllllllllllIIllIIIllIIlIlIlII.write(Type.BYTE, (Byte)1);
                                                llllllllllllllIIllIIIllIIlIlIlII.write(Type.STRING, (llllllllllllllIIllIIIllIIlIIlIII.getColorIndependentSidebar() == null) ? "" : llllllllllllllIIllIIIllIIlIIlIII.getColorIndependentSidebar());
                                                PacketUtil.sendPacket(llllllllllllllIIllIIIllIIlIlIlII, Protocol1_7_6_10TO1_8.class);
                                            }
                                        }
                                    }
                                    else {
                                        llllllllllllllIIllIIIllIIlIIlIII.addPlayerToTeam(llllllllllllllIIllIIIllIIlIlIIlI, llllllllllllllIIllIIIllIIlIIlIlI);
                                        if (llllllllllllllIIllIIIllIIlIlIIlI.equals(llllllllllllllIIllIIIllIIlIlIIIl) && llllllllllllllIIllIIIllIIlIIlIII.getColorDependentSidebar().containsKey(llllllllllllllIIllIIIllIIlIIlllI)) {
                                            llllllllllllllIIllIIIllIIlIlIIll = llllllllllllllIIllIIIllIIlIIIlll.create(61);
                                            llllllllllllllIIllIIIllIIlIlIIll.write(Type.BYTE, (Byte)1);
                                            llllllllllllllIIllIIIllIIlIlIIll.write(Type.STRING, llllllllllllllIIllIIIllIIlIIlIII.getColorDependentSidebar().get(llllllllllllllIIllIIIllIIlIIlllI));
                                            PacketUtil.sendPacket(llllllllllllllIIllIIIllIIlIlIIll, Protocol1_7_6_10TO1_8.class);
                                        }
                                    }
                                    llllllllllllllIIllIIIllIIlIIllII.add(llllllllllllllIIllIIIllIIlIlIIlI);
                                }
                                llllllllllllllIIllIIIllIIlIIIlll.write(Type.SHORT, (short)llllllllllllllIIllIIIllIIlIIllII.size());
                                llllllllllllllIIllIIIllIIlIIllII.iterator();
                                while (iterator.hasNext()) {
                                    llllllllllllllIIllIIIllIIlIIllll = iterator.next();
                                    llllllllllllllIIllIIIllIIlIIIlll.write(Type.STRING, llllllllllllllIIllIIIllIIlIIllll);
                                }
                            }
                        }
                    }
                });
            }
        });
    }
}
