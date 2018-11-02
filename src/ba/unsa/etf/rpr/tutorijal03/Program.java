package ba.unsa.etf.rpr.tutorijal03;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {

        Imenik imenik = new Imenik();
        for (; ; ) {
            System.out.println("\nIzaberite opciju: ");
            System.out.println("1: Za unos osobe u imenik,");
            System.out.println("2: Da pronadjete broj telefona neke osobe");
            System.out.println("3: Da pronadjete neku osobu u imeniku prema broju telefona,");
            System.out.println("4: Da pronadjete sve osobe cije ime pocinje nekim slovom,");
            System.out.println("5: Da pronadjete sve osobe koje zive u nekom gradu,");
            System.out.println("6: Da pronadjete brojeve telefona svih osoba koje zive u nekom gradu");
            System.out.println("7: Za kraj");
            Scanner ulaz = new Scanner(System.in);
            int unos = ulaz.nextInt();
            ulaz.nextLine();
            switch (unos) {
                case 1:
                    System.out.println("Koliko osoba zelite unijeti: ");
                    int brojOsoba = ulaz.nextInt();
                    ulaz.nextLine();
                    for (int i = 0; i < brojOsoba; i++) {
                        System.out.println("Unesite ime i prezime osobe: ");
                        String nazivOsobe = ulaz.nextLine();
                        System.out.println("Unesite: ");
                        System.out.println("1: Za unos fiksnog broja,");
                        System.out.println("2: Za unos mobilnog broja,");
                        System.out.println("3: Za unos medjunarodnog broja");
                        int vrstaBroja = ulaz.nextInt();
                        ulaz.nextLine();
                        String brTelefona = new String();
                        switch (vrstaBroja) {
                            case 1:
                                System.out.println("Unesite grad: ");
                                String g = ulaz.nextLine();
                                System.out.println("Unesite broj telefona: ");
                                brTelefona = ulaz.nextLine();
                                TelefonskiBroj brojTelefona = new FiksniBroj(FiksniBroj.Grad.valueOf(g.toUpperCase()), brTelefona);
                                imenik.dodaj(nazivOsobe, brojTelefona);
                                break;

                            case 2:
                                System.out.println("Unesite mobilnu mrezu: ");
                                int mobilnaMreza = ulaz.nextInt();
                                ulaz.nextLine();
                                System.out.println("Unesite broj telefona: ");
                                brTelefona = ulaz.nextLine();
                                TelefonskiBroj brojMobitela = new MobilniBroj(mobilnaMreza, brTelefona);
                                imenik.dodaj(nazivOsobe, brojMobitela);
                                break;

                            case 3:
                                System.out.println("Unesite drzavu: ");
                                String drzava = ulaz.nextLine();
                                System.out.println("Unesite broj telefona: ");
                                brTelefona = ulaz.nextLine();
                                ulaz.nextLine();
                                TelefonskiBroj medjunarodniBroj = new MedunarodniBroj(drzava, brTelefona);
                                imenik.dodaj(nazivOsobe, medjunarodniBroj);
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Unesite naziv osobe koju trazite: ");
                    String nazivOsobe = ulaz.nextLine();
                    System.out.print("Broj telefona osobe koju trazite je: " + imenik.dajBroj(nazivOsobe));
                    break;


                case 3:
                    System.out.println("Unesite broj telefona osobe koju trazite: ");
                    System.out.println("Unesite: ");
                    System.out.println("1: Za unos fiksnog broja,");
                    System.out.println("2: Za unos mobilnog broja,");
                    System.out.println("3: Za unos medjunarodnog broja");
                    int vrstaBroja = ulaz.nextInt();
                    ulaz.nextLine();
                    String brTelefona = new String();
                    switch (vrstaBroja) {
                        case 1:
                            System.out.println("Unesite grad: ");
                            String g = ulaz.nextLine();
                            System.out.println("Unesite broj telefona: ");
                            brTelefona = ulaz.nextLine();
                            TelefonskiBroj brojTelefona = new FiksniBroj(FiksniBroj.Grad.valueOf(g.toUpperCase()), brTelefona);
                            System.out.println("Osoba koju trazite je: "+ imenik.dajIme(brojTelefona));
                            break;
                        case 2:
                            System.out.println("Unesite mobilnu mrezu: ");
                            int mobilnaMreza = ulaz.nextInt();
                            ulaz.nextLine();
                            System.out.println("Unesite broj telefona: ");
                            brTelefona = ulaz.nextLine();
                            TelefonskiBroj brojTelefonaa = new MobilniBroj(mobilnaMreza, brTelefona);
                            System.out.println("Osoba koju trazite je: ");
                            System.out.println(imenik.dajIme(brojTelefonaa));
                            break;
                        case 3:
                            System.out.println("Unesite drzavu: ");
                            String drzava = ulaz.nextLine();
                            System.out.println("Unesite broj telefona: ");
                            brTelefona = ulaz.nextLine();
                            ulaz.nextLine();
                            TelefonskiBroj brojTelefonaaa = new MedunarodniBroj(drzava, brTelefona);
                            System.out.println("Osoba koju trazite je: ");
                            System.out.println(imenik.dajIme(brojTelefonaaa));
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Unesite slovo: ");
                    char slovo = ulaz.next().charAt(0);
                    String osobe = new String();
                    osobe = imenik.naSlovo(slovo);
                    if (osobe != null)
                        System.out.println(osobe);
                    else
                        System.out.println("U imeniku nema osoba cije ime pocinje slovom koje ste unijeli");
                    break;

                case 5:
                    System.out.println("Unesite grad: ");
                    String grad = ulaz.nextLine();
                    FiksniBroj.Grad g = FiksniBroj.Grad.valueOf(grad.toUpperCase());
                    Set<String> osobeIzGrada = new TreeSet<>();
                    osobeIzGrada.addAll(imenik.izGrada(g));
                    if (!osobeIzGrada.isEmpty()) {
                        System.out.println("Osobe koje zive u gradu koji ste unijeli su: ");
                        for (String ime : osobeIzGrada)
                            System.out.println(ime);
                    } else
                        System.out.println("U imeniku nema osoba koje zive u gradu koji ste unijeli!");
                    break;

                case 6:
                    System.out.println("Unesite grad: ");
                    String gradd = ulaz.nextLine();
                    FiksniBroj.Grad gg = FiksniBroj.Grad.valueOf(gradd.toUpperCase());
                    Set<TelefonskiBroj> brojeviOsobaIzGrada = new TreeSet<>();
                    brojeviOsobaIzGrada.addAll(imenik.izGradaBrojevi(gg));
                    if (!brojeviOsobaIzGrada.isEmpty()) {
                        System.out.println("Brojevi telefona osoba koje zive u gradu koji ste unijeli su: ");
                        for (TelefonskiBroj broj : brojeviOsobaIzGrada)
                            System.out.println(broj.ispisi());
                    } else
                        System.out.println("U imeniku nema osoba koje zive u gradu koji ste unijeli!");
                    break;
                case 7:
                    return;
            }
        }

    }

}