package bank;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BankClient {
    private DataOutputStream dataOut;
    private DataInputStream dataIn;
    private Socket socket;
    private BankServer bank;

    public BankClient(DataOutputStream dataOut, DataInputStream dataIn, Socket socket, BankServer bank) {
        this.dataOut = dataOut;
        this.dataIn = dataIn;
        this.socket = socket;
        this.bank = bank;
    }
}
