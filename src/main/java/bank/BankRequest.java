package bank;

import java.nio.channels.SocketChannel;
import java.time.LocalTime;

public class BankRequest {
    SocketChannel requestChannel;
    LocalTime requestTime;

    public BankRequest(SocketChannel socketChannel , LocalTime localTime){
        this.requestChannel = socketChannel;
        this.requestTime = localTime;
    }

    public SocketChannel getRequestChannel() {
        return requestChannel;
    }

    public LocalTime getRequestTime() {
        return requestTime;
    }
}
