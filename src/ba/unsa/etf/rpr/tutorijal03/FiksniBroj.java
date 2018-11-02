package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj {
    private Grad gradZaPozivni;
    private String fiksniBroj;

    public enum Grad {
        TRAVNIK(30), ORASJE(31), ZENICA(32), SARAJEVO(33), LIVNO(34), TUZLA(35), MOSTAR(36), BIHAC(37), GORAZDE(38), SIROKI_BRIJEG(39), BRCKO(49);
        private int pozivni;
        Grad(int g){
            this.pozivni = g;
        }
        public int getPozivni() {
            return this.pozivni;
        }
    }

    public FiksniBroj(Grad grad, String broj){
        gradZaPozivni = grad;
        fiksniBroj = broj;
    }

    @Override
    public String ispisi(){
        String s = new String();
        s = "0" + gradZaPozivni.getPozivni() + "/" + fiksniBroj;
        return  s;
    }

}
