public class EuroToUKPlugAdapter implements UKPlug {

    private EuroPlug plug;

    public EuroToUKPlugAdapter(EuroPlug plug) {
        this.plug = plug;
    }

    public void enableElectricity() {
        plug.enableElectricity();
    }
}