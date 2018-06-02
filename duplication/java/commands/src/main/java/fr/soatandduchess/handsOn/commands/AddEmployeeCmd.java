package fr.soatandduchess.handsOn.commands;

import java.io.OutputStream;

class AddEmployeeCmd {
    String name;
    String address;
    String city;
    String state;
    String yearlySalary;

    static final byte[] header = {(byte) 0xde, (byte) 0xad};
    static final byte[] footer = {(byte) 0xbe, (byte) 0xef};
    private final byte[] commandChar = {0x02};
    static final int SIZE_LENGTH = 1;
    static final int CMD_BYTE_LENGTH = 1;

    AddEmployeeCmd(String name, String address,
                   String city, String state,
                   int yearlySalary) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.yearlySalary = Integer.toString(yearlySalary);
    }


    private int getSize() {
        return header.length +
                SIZE_LENGTH +
                CMD_BYTE_LENGTH +
                footer.length +
                getBodySize();
    }

    private int getBodySize() {
        return name.getBytes().length + 1 +
                address.getBytes().length + 1 +
                city.getBytes().length + 1 +
                state.getBytes().length + 1 +
                yearlySalary.getBytes().length + 1;
    }

    void write(OutputStream outputStream) throws Exception {
        outputStream.write(header);
        outputStream.write(getSize());
        outputStream.write(commandChar);
        outputStream.write(name.getBytes());
        outputStream.write(0x00);
        outputStream.write(address.getBytes());
        outputStream.write(0x00);
        outputStream.write(city.getBytes());
        outputStream.write(0x00);
        outputStream.write(state.getBytes());
        outputStream.write(0x00);
        outputStream.write(yearlySalary.getBytes());
        outputStream.write(0x00);
        outputStream.write(footer);
    }


}