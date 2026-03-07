//Desktop computer: adds GPU type

public final class Desktop implements ComputerDevice { // composition
    private final Computer hardware;
    private final String GPUType;

    public Desktop(Computer hardware, String GPUType) {
        this.hardware = hardware;
        this.GPUType = GPUType;
    }

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        this.hardware = new Computer(CPU,RAM,disk);
        this.GPUType = GPUType;
    }

    //Getter
    public String getGPUType() {
        return this.GPUType;
    }

    public String getCPU() { return this.hardware.getCPU(); }
    public String getRAM() { return this.hardware.getRAM(); }
    public String getDisk() { return this.hardware.getDisk(); }

    //Return formatted version of data
    @Override
    public String toString() {
        return "Type:Desktop\tCPU:" + this.getCPU() + "\tRAM:" + this.getRAM() + "\tDisk:" + this.getDisk() + "\tGPU:" + this.GPUType;
    }

}