//Laptop computer: adds screen size to other Computer info

public final class Laptop implements ComputerDevice { //Laptop uses composition now
    private final Computer hardware;
    private final String screenSize;

    public Laptop(Computer hardware, String screenSize) {
        this.hardware = hardware;
        this.screenSize = screenSize;
    }

    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        this.hardware = new Computer(CPU,RAM,disk);
        this.screenSize = screenSize;
    }

    //Getter
    public String getScreenSize() {
        return this.screenSize;
    }

    public String getCPU() { return this.hardware.getCPU(); }
    public String getRAM() { return this.hardware.getRAM(); }
    public String getDisk() { return this.hardware.getDisk(); }

    //Return formatted version of data
    @Override
    public String toString() {
        return "Type:Laptop\tCPU:" + this.getCPU() + "\tRAM:" + this.getRAM() + "\tDisk:" + this.getDisk() + "\tScreen:" + this.screenSize;
    }
    
}