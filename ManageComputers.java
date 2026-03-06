//Manage Computers program: maintains an ArrayList of Computer objects, 
//can be either Laptop or Desktop, but never just Computer-type objects themselves

import java.util.ArrayList;
import java.util.Scanner;

public class ManageComputers {
    //whitelist of computer optionns for user input validation

    private static final String[] cpuTypes = {"i5", "i7"};
    private static final String[] ramTypes = {"16", "32"};
    private static final String[] storageTypes = {"512", "1024"};
    private static final String[] screenSizes = {"13", "14"};
    private static final String[] gpuTypes = {"Nvidia", "AMD"};

    public static void main(String args[]) {

        //This ArrayList will hold all the computers in the system. Note that the type of objects expected in this
        //ArrayList are Computer, not Laptop or Desktop, but since those are subclasses of Computer they can be
        //stored in an ArrayLiust<Computer> anyway.
        ArrayList<ComputerDevice> computers = new ArrayList<ComputerDevice>();

        Scanner s = new Scanner(System.in);
        String menuOption = "";
        do { //Start of main program loop

            //Show computer data in ArrayList<Computer>
            showComputers(computers);

            //Display menu and return menu option selected by the user
            menuOption = getMenuSelection(s);

            switch (menuOption) {
                //Add new computer
                case "a":

                    addComputer(computers, s);

                    break;

                //Delete a computer    
                case "d":

                    deleteComputer(computers, s);

                    break;

                //Edit a computer    
                case "e":

                    editComputer(computers, s);

                    break;

            }

        } while (!menuOption.equals("x")); //Stop when "x" is entered

        s.close(); //Close keyboard scanner

    } //End of main

    //-----------------------------
    private static boolean isValidInput(String input, String[] whitelist) {
        input = input.toLowerCase();
        for (String validOption : whitelist) {
            if (input.equals(validOption.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    //-----------------------------
    //Display menu and get user selection, return it
    private static String getMenuSelection(Scanner s) {
        String menuOption = "";

        //Display menu options on-screen
        System.out.println("----------");
        System.out.println("A) Add Computer");
        System.out.println("D) Delete Computer");
        System.out.println("E) Edit Computer");
        System.out.println("X) eXit");
        System.out.println("----------");

        //Get menu selection from keyboard
        System.out.print("Enter menu selection:");
        menuOption = s.nextLine();

        menuOption = menuOption.toLowerCase(); //Make lower case for comparison purposes

        return menuOption;
    } //End of getMenuSelection

    //-----------------------------
    //Show data for all laptops and desktops stored in ArrayList<Computer> create in main() method
    private static void showComputers(ArrayList<ComputerDevice> computers) {
        int computerListNumber = 0; //This variable is used to hold the "list number" for each computer, starting at 1.

        System.out.println("=========");

        System.out.println("LIST OF COMPUTERS:-");

        for (ComputerDevice c : computers) {

            computerListNumber++; //Increment list number for each computer

            //Call overridden toString() method for current object to get and display its data
            System.out.println(computerListNumber + ": " + c.toString());
        }

        System.out.println("=========");

    } //End of showComputers

    //-----------------------------
    //Add a new Laptop or Desktop computer to the ArrayList<Computer>
    private static void addComputer(ArrayList<ComputerDevice> computers, Scanner s) {
        String computerType = "";

        Computer tempComputer = null;

        System.out.println("ADDING COMPUTER:-");

        System.out.println("Enter type of computer to add ('L' for Laptop, 'D' for Desktop):");
        computerType = s.nextLine();
        computerType = computerType.toLowerCase(); //Convert to lower case for comparison purposes

        switch (computerType) {

            //Add a laptop
            case "l":

                //Get CPU, RAM and Disk info
                tempComputer = getComputerData(s);
                String screenSize;
                do {
                    System.out.print("Enter screen size:");
                    screenSize = s.nextLine();
                } while (!isValidInput(screenSize, screenSizes));
                //Add new Laptop (composition) to ArrayList in main() method
                computers.add(new Laptop(tempComputer, screenSize));

                break;

            //Add a desktop    
            case "d":

                //Get CPU, RAM and Disk info
                tempComputer = getComputerData(s);
                String GPUType;
                do {
                    System.out.print("Enter GPU:");
                    GPUType = s.nextLine();
                } while (!isValidInput(GPUType, gpuTypes));
                //Add new Desktop (composition) to ArrayList in main() method
                computers.add(new Desktop(tempComputer, GPUType));

                break;

            //Invalid computer type to add entered
            default:

                System.out.println("Invalid computer type entered!");

        }
    } //End of addComputer

    //-----------------------------
    //Delete a specified computer from the ArrayList
    private static void deleteComputer(ArrayList<ComputerDevice> computers, Scanner s) {
        int computerListNumberToDelete = 0;

        System.out.println("DELETE COMPUTER:-");

        System.out.print("Enter number of computer to delete:");
        computerListNumberToDelete = Integer.parseInt(s.nextLine());

        //Check if computer list number is valid before deleting computer from list
        if (computerListNumberToDelete >= 1 && computerListNumberToDelete <= computers.size()) {
            //Subtract 1 to get ArrayList index from on-screen list number to create correct index in ArrayList to delete
            computers.remove(computerListNumberToDelete - 1);
        } else {
            System.out.println("Invalid computer number entered!");
        }

    } //End of deleteComputer

    //-----------------------------
    //Edit a computer. Since Laptop and Desktop are mutable classes/object get new data values and replace old
    //attribute values in object being edited using object setter methods
    private static void editComputer(ArrayList<ComputerDevice> computers, Scanner s) {
        int computerListNumberToEdit = 0;

        System.out.println("EDIT COMPUTER:-");
        System.out.print("Enter number of computer to edit:");
        computerListNumberToEdit = Integer.parseInt(s.nextLine());

        if (computerListNumberToEdit >= 1 && computerListNumberToEdit <= computers.size()) {
            int index = computerListNumberToEdit - 1;
            ComputerDevice existingComputer = computers.get(index);

            if (existingComputer instanceof Laptop) {
                System.out.println("Editing a Laptop:");

                Computer tempComputer = getComputerData(s);

                String screenSize;
                do {
                    System.out.print("Enter screen size:");
                    screenSize = s.nextLine();
                } while (!isValidInput(screenSize, screenSizes));

                computers.set(index, new Laptop(tempComputer, screenSize));
            } else if (existingComputer instanceof Desktop) {
                System.out.println("Editing a Desktop:");

                Computer tempComputer = getComputerData(s);

                String GPUType;
                do {
                    System.out.print("Enter GPU:");
                    GPUType = s.nextLine();
                } while (!isValidInput(GPUType, gpuTypes));

                computers.set(index, new Desktop(tempComputer, GPUType));
            }
        } else {
            System.out.println("Invalid computer number entered!");
        }
    } //End of editComputer

    //-----------------------------
    //Helper method to get data common to Laptop and Desktop (CPU, RAM and disk) objects. Returns a Computer-type object
    //holding these values as attributes
    private static Computer getComputerData(Scanner s) {
        String CPU = "";
        String RAM = "";
        String disk = "";

        do {
            System.out.print("Enter CPU:");
            CPU = s.nextLine();
        } while (!isValidInput(CPU, cpuTypes));

        do {
            System.out.print("Enter RAM:");
            RAM = s.nextLine();
        } while (!isValidInput(RAM, ramTypes));

        do {
            System.out.print("Enter Disk:");
            disk = s.nextLine();
        } while (!isValidInput(disk, storageTypes));

        return new Computer(CPU, RAM, disk);

    } //End of getComputerData

} //End of ManageComputer class
