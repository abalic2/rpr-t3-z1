package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj extends TelefonskiBroj{
    private String mobilniBroj;
    private int mreza;
    public MobilniBroj(int mobilnaMreza, String broj){
        mreza = mobilnaMreza;
        mobilniBroj = broj;
    }

    @Override
    public int hashCode(){
        return mobilniBroj.hashCode();
    }

    @Override
    public String ispisi(){
        String s = new String();
        s = "0" + mreza + "/" + mobilniBroj;
        return  s;
    }
}
