//Computer class: immutable holder for CPU, RAM and disk information.

public final class Computer {
    private final String CPU;
    private final String RAM;
    private final String disk;

    public Computer(String CPU, String RAM, String disk) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.disk = disk;
    }

    public String getCPU() {
        return this.CPU;
    }

    public String getRAM() {
        return this.RAM;
    }

    public String getDisk() {
        return this.disk;
    }
}
