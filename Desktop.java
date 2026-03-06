//Desktop computer: adds GPU type

public class Desktop implements ComputerDevice { // composition
    private Computer hardware = null;
    String GPUType=null;

    //Constructors
    public Desktop() {} //No-arg constructor

    public Desktop(Computer hardware, String GPUType) {
        this.hardware = hardware;
        this.GPUType = GPUType;
    }

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        this.hardware = new Computer(CPU,RAM,disk);
        this.GPUType = GPUType;
    }

    //Setter
    public void setGPUType(String GPUType) {
        this.GPUType=GPUType;
    }

    //Getter
    public String getGPUType() {
        return this.GPUType;
    }

    //Delegate setters/getters
    public void setCPU(String CPU) { this.hardware.setCPU(CPU); }
    public void setRAM(String RAM) { this.hardware.setRAM(RAM); }
    public void setDisk(String disk) { this.hardware.setDisk(disk); }

    public String getCPU() { return this.hardware.getCPU(); }
    public String getRAM() { return this.hardware.getRAM(); }
    public String getDisk() { return this.hardware.getDisk(); }

    //Return formatted version of data
    public String toString() {
        return "Type:Desktop\tCPU:" + this.getCPU() + "\tRAM:" + this.getRAM() + "\tDisk:" + this.getDisk() + "\tGPU:" + this.GPUType;
    }

}