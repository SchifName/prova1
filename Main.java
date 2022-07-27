package codicefiscale;
//git repo added
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        persona p;
        cf cod;
        String n, c, s, co;
        int m, a , g;
        boolean sesso=false;
        System.out.println("Inserisci i dati della persona");
        System.out.println("Inserisci il nome");
        n= sc.nextLine();
        System.out.println("Inserisci il cognome");
        c= sc.nextLine();
        do{
            System.out.println("Inserisci il sesso");
            s= sc.nextLine();
            if(s.equals("maschio") || s.equals("femmina")) sesso=true;
        }while(!sesso);
        System.out.println("Inserisci il comune di nascita");
        co= sc.nextLine();
        System.out.println("Inserisci l'anno di nascita");
        a= sc.nextInt();
        System.out.println("Inserisci il mese di nascita in formato numerale");
        m= sc.nextInt();
        System.out.println("Inserisci il giorno di nascita");
        g= sc.nextInt();
        p= new persona(n, c, m, a, g, s, co);
        System.out.println(p.nom());//STAMPA LETTERE DEL NOME
        System.out.println(p.cog());//STAMPA LETTERE DEL COGNOME
        System.out.println(p.anno());
        System.out.println(p.giorno());
        System.out.println(p.comune());
        cod = new cf(p.nom(), p.cog(), p.anno(), p.giorno(), p.comune());
        sc.close();
    }

}
