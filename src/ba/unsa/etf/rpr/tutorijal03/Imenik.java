package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;

public class Imenik {
    private HashMap<String, TelefonskiBroj> mapa;
    void dodaj(String ime, TelefonskiBroj broj){
        mapa.put(ime,broj);
    }
    String dajBroj(String ime){
        return mapa.get(ime).ispisi();
    }
    String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String,TelefonskiBroj>  par : mapa.entrySet()) {
            if (par.getValue().equals(broj)) {
                return par.getKey();
            }
        }
        return "";
    }
    String naSlovo(char s){
        int brojac = 0;
        for(Map.Entry<String,TelefonskiBroj>  par : mapa.entrySet()){
            if( par.getKey().charAt(0) == s){
                brojac++;
                System.out.println(brojac + ". " + par.getKey()+ " - " + par.getValue());
            }
        }
        return "";
    }
    Set<String> izGrada(FiksniBroj.Grad g){
        HashSet<String> skup = new HashSet<>();
        for(Map.Entry<String,TelefonskiBroj>  par : mapa.entrySet()){
            if( par.getValue().equals(g)) skup.add(par.getKey());
        }
        return skup;
    }
    Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g){
        HashSet<TelefonskiBroj> skup = new HashSet<>();
        return skup;
    }


}
