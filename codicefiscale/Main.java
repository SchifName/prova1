package codicefiscale;

//git repo added
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        persona p;
        cf cod;
        String n, c, s, co;
        int m, a, g;
        boolean sesso = false;
        System.out.println("Inserisci i dati della persona");
        System.out.println("Inserisci il nome");
        n = sc.nextLine();
        System.out.println("Inserisci il cognome");
        c = sc.nextLine();
        do {
            System.out.println("Inserisci il sesso");
            s = sc.nextLine();
            if (s.equals("maschio") || s.equals("femmina"))
                sesso = true;
        } while (!sesso);
        System.out.println("Inserisci il comune di nascita");
        co = sc.nextLine();
        System.out.println("Inserisci l'anno di nascita");
        a = sc.nextInt();
        System.out.println("Inserisci il mese di nascita in formato numerale");
        m = sc.nextInt();
        System.out.println("Inserisci il giorno di nascita");
        g = sc.nextInt();
        p = new persona(n, c, m, a, g, s, co);

        // getto nome in list e converto in string
        List<Character> nome_cf_lista = p.nome_cf();
        String nome_cf_stringa = nome_cf_lista.toString()
                .substring(1, 3 * nome_cf_lista.size() - 1)
                .replaceAll(", ", "");

        System.out.println(p.cog());// STAMPA LETTERE DEL COGNOME
        System.out.println(p.nome_cf());// STAMPA LETTERE DEL NOME
        System.out.println(nome_cf_stringa.toUpperCase());// STAMPA LETTERE DEL NOME
        System.out.println(p.anno());
        System.out.println(p.giorno());
        // System.out.println(p.comune());

        //edit passo nome_cf
        cod = new cf(p.cog(), nome_cf_stringa.toUpperCase(), p.anno(), p.giorno(), p.comune());
        cod.controllo_cod();
        System.out.println(cod.cf);
        sc.close();
    }

}
