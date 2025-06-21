public class Main {
    public static void main(String[] args) {

        // First Computer
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4080")
            .build();

        System.out.println("Gaming PC Configuration:");
        gamingPC.showConfig();

        System.out.println("\n----------------------------\n");

        // Second Computer
        Computer officePC = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();  // No graphics card

        System.out.println("Office PC Configuration:");
        officePC.showConfig();
    }
}
