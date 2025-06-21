// Step 1: Command Interface
interface Command {
    void execute();
}

// Step 2: Receiver Class
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Step 3: Concrete Command - Turn On
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Step 3: Concrete Command - Turn Off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Step 4: Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }
}

// Step 6: Test Class
public class CommandPatternExample {
    public static void main(String[] args) {
        // Create Receiver
        Light livingRoomLight = new Light();

        // Create Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create Invoker
        RemoteControl remote = new RemoteControl();

        // Test turning light ON
        remote.setCommand(lightOn);
        remote.pressButton();

        // Test turning light OFF
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
