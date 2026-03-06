//Laptop computer: adds screen size to other Computer info

public class Laptop implements ComputerDevice { //Laptop uses composition now
    private Computer hardware = null;
    String screenSize=null;

    //Constructors
    public Laptop() {} //No-arg constructor

    public Laptop(Computer hardware, String screenSize) {
        this.hardware = hardware;
        this.screenSize = screenSize;
    }

    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        this.hardware = new Computer(CPU,RAM,disk);
        this.screenSize = screenSize;
    }

    //Setter
    public void setScreenSize(String screenSize) {
        this.screenSize=screenSize;
    }

    //Getter
    public String getScreenSize() {
        return this.screenSize;
    }

    //Delegate setters/getters for hardware
    public void setCPU(String CPU) { this.hardware.setCPU(CPU); }
    public void setRAM(String RAM) { this.hardware.setRAM(RAM); }
    public void setDisk(String disk) { this.hardware.setDisk(disk); }

    public String getCPU() { return this.hardware.getCPU(); }
    public String getRAM() { return this.hardware.getRAM(); }
    public String getDisk() { return this.hardware.getDisk(); }

    //Return formatted version of data
    public String toString() {
        return "Type:Laptop\tCPU:" + this.getCPU() + "\tRAM:" + this.getRAM() + "\tDisk:" + this.getDisk() + "\tScreen:" + this.screenSize;
    }
    
}