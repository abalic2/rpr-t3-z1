package ba.unsa.etf.rpr.tutorijal03;

public abstract class TelefonskiBroj implements Comparable<TelefonskiBroj> {
    public abstract String ispisi();

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public int compareTo(TelefonskiBroj brojTelefona) {
        return  this.ispisi().compareTo(brojTelefona.ispisi());
    }

    @Override
    public boolean equals(Object o){
        TelefonskiBroj a = (TelefonskiBroj) o;
        return this.ispisi().equals(a.ispisi());
    }
}
