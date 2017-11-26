package pl.zankowski.iextrading4j.hist.samples;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PacketListener;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;
import pl.zankowski.iextrading4j.hist.api.message.IEXSegment;
import pl.zankowski.iextrading4j.hist.deep.IEXDEEPMessageBlock;

public class DEEPSample {

    public static void main(String[] args) throws PcapNativeException, InterruptedException, NotOpenException {
        DEEPSample deepSample = new DEEPSample();
        deepSample.readDEEPsample();
    }

    private void readDEEPsample() throws PcapNativeException, InterruptedException, NotOpenException {
        PcapHandle handle = Pcaps.openOffline("path_to_pcap", PcapHandle.TimestampPrecision.NANO);

        handle.loop(-1, new PacketListener() {
            @Override
            public void gotPacket(Packet packet) {
                byte[] data = packet.getPayload().getPayload().getPayload().getRawData();
                IEXSegment block = IEXDEEPMessageBlock.createIEXSegment(data);
                System.out.println(block);
            }
        });

        handle.close();
    }
}
