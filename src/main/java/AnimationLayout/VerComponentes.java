package AnimationLayout;

//==========================================================================
//Solo para ver en el JForm principal los componentes en un JList el orden de los componentes.
public class VerComponentes {

    public VerComponentes() {
    }

    private static verComponentes verComponentes;

    public static void setVerComponentesInterface(verComponentes veComponentes) {
        verComponentes = veComponentes;
    }

    public static interface verComponentes {

        public void verComponentes();
    }

    public static void verComponentes() {
        if (verComponentes != null) {
            verComponentes.verComponentes();
        }
    }

}
