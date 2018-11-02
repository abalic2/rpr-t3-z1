package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;

public class Imenik {
    private HashMap<String, TelefonskiBroj> mapa = new HashMap<>();
    public void dodaj(String ime, TelefonskiBroj broj){
        mapa.put(ime,broj);
    }
    public String dajBroj(String ime){
        return mapa.get(ime).ispisi();
    }
    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String,TelefonskiBroj>  par : mapa.entrySet()) {
            if (par.getValue().equals(broj)) {
                return par.getKey();
            }
        }
        return "";
    }
    public String naSlovo(char s){
        int brojac = 0;
        String rezultat = new String();
        for(Map.Entry<String,TelefonskiBroj>  par : mapa.entrySet()){
            if( par.getKey().charAt(0) == s){
                brojac++;
                rezultat += brojac + ". " + par.getKey()+ " - " + par.getValue().ispisi();
            }
        }
        return rezultat;
    }
    public Set<String> izGrada(FiksniBroj.Grad g){
        TreeSet<String> skup = new TreeSet<>();
        for(Map.Entry<String,TelefonskiBroj>  par : mapa.entrySet()){
            if(par.getValue() instanceof FiksniBroj && ((FiksniBroj) par.getValue()).getGradZaPozivni().equals(g)) skup.add(par.getKey());
        }
        return skup;
    }
    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g){
        HashSet<TelefonskiBroj> skup = new HashSet<>();
        return skup;
    }


}
