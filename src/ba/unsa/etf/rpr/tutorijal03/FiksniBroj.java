package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj {
    private Grad gradZaPozivni;
    private String fiksniBroj;
    public enum Grad{TRAVNIK, ORASJE, ZENICA, SARAJEVO, LIVNO, TUZLA, MOSTAR, BIHAC, GORAZDE, SIROKI_BRIJEG, BRCKO};
    public FiksniBroj(Grad grad, String broj){
        gradZaPozivni = grad;
        fiksniBroj = broj;
    }

    @Override
    public int hashCode(){
        switch(gradZaPozivni){
            case TRAVNIK: return 30;
            case ORASJE: return 31;
            case ZENICA: return 32;
            case SARAJEVO: return 33;
            case LIVNO: return 34;
            case TUZLA: return 35;
            case MOSTAR: return 36;
            case BIHAC: return 37;
            case GORAZDE: return 38;
            case SIROKI_BRIJEG: return 39;
            case BRCKO: return 49;
        }
        return  0;
    }

    @Override
    public String ispisi(){
        String s = new String();
        s = "0" + hashCode() + "/" + fiksniBroj;
        return  s;
    }

}
