class ControlHub {
    private static ControlHub instance;

    private ControlHub() {
        System.out.println("Control Hub initialized.");
    }

    public static synchronized ControlHub getInstance() {
        if (instance == null) {
            instance = new ControlHub();
        }
        return instance;
    }

    public void controlDevice(String device) {
        System.out.println("[ControlHub] Managing: " + device);
    }
}

class SmartHome {
    private String lighting;
    private String security;
    private String climate;
    private String entertainment;

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setEntertainment(String entertainment) {
        this.entertainment = entertainment;
    }

    public void showConfiguration() {
        System.out.println("\n--- Smart Home Configuration ---");
        System.out.println("Lighting: " + lighting);
        System.out.println("Security: " + security);
        System.out.println("Climate: " + climate);
        System.out.println("Entertainment: " + entertainment);
    }
}

abstract class SmartHomeBuilder {
    protected SmartHome home;
    protected ControlHub hub = ControlHub.getInstance(); // Singleton used here

    public SmartHomeBuilder() {
        home = new SmartHome();
    }

    public abstract void buildLighting();
    public abstract void buildSecurity();
    public abstract void buildClimate();
    public abstract void buildEntertainment();

    public SmartHome getHome() {
        return home;
    }
}

class BasicHomeBuilder extends SmartHomeBuilder {

    @Override
    public void buildLighting() {
        home.setLighting("Basic LED Lights");
        hub.controlDevice("Basic Lighting");
    }

    @Override
    public void buildSecurity() {
        home.setSecurity("Standard Locks");
        hub.controlDevice("Basic Security");
    }

    @Override
    public void buildClimate() {
        home.setClimate("Ceiling Fans");
        hub.controlDevice("Basic Climate Control");
    }

    @Override
    public void buildEntertainment() {
        home.setEntertainment("Basic TV");
        hub.controlDevice("Basic Entertainment");
    }
}

class AdvancedHomeBuilder extends SmartHomeBuilder {

    @Override
    public void buildLighting() {
        home.setLighting("Smart Lighting System");
        hub.controlDevice("Smart Lighting");
    }

    @Override
    public void buildSecurity() {
        home.setSecurity("CCTV + Smart Locks");
        hub.controlDevice("Advanced Security");
    }

    @Override
    public void buildClimate() {
        home.setClimate("Smart Thermostat + AC");
        hub.controlDevice("Advanced Climate Control");
    }

    @Override
    public void buildEntertainment() {
        home.setEntertainment("Home Theater System");
        hub.controlDevice("Advanced Entertainment");
    }
}

class HomeDirector {
    public void constructHome(SmartHomeBuilder builder) {
        builder.buildLighting();
        builder.buildSecurity();
        builder.buildClimate();
        builder.buildEntertainment();
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {

        HomeDirector director = new HomeDirector();

        SmartHomeBuilder basicBuilder = new BasicHomeBuilder();
        director.constructHome(basicBuilder);
        SmartHome basicHome = basicBuilder.getHome();
        basicHome.showConfiguration();

        SmartHomeBuilder advancedBuilder = new AdvancedHomeBuilder();
        director.constructHome(advancedBuilder);
        SmartHome advancedHome = advancedBuilder.getHome();
        advancedHome.showConfiguration();
    }
}