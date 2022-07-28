package codicefiscale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class persona {
    String nome;
    String cognome;
    int mese;
    int anno;
    int giorno;
    String sesso;
    String comune;

    public persona(String n, String c, int m, int a, int g, String s, String co) {
        nome = n;
        cognome = c;
        mese = m;
        anno = a;
        giorno = g;
        sesso = s;
        comune = co;
    }

    //CALCOLO LETTERE DEL COGNOME
    public String cog(){
        char[] vocali = new char[] {'a','e','i','o','u','A','E','I','O','U'}; //ARRAY DI VOCALI
        char [] cog = this.cognome.toCharArray(); //ARRAY CON OGNI LETTERA DEL COGNOME
        char [] cognome = new char[3]; //ARRAY CON IL RISULTATO FINALE
        boolean cons=false; //BOOLEANO CHE MI PERMETTE DI CAPIRE SE UNA DETERMINATA LETTERA è UNA CONSONANTE
        boolean voc=false; //BOOLEANO CHE MI PERMETTE DI CAPIRE SE UNA DETERMINATA LETTERA è UNA VOCALE
        int numconsonanti = 0; //CONTA LE LETTERE NEL RISULTATO FINALE
        int length=vocali.length; //LUNGHEZZA DELL'ARRAY DELLE VOCALI
        for(int i=0; i<this.cognome.length(); i++){
            if(numconsonanti  == 3)break;//SE NE HA GIA' TROVATE 3 ESCE DAL CICLO
            else{
                for(int j=0; j < length ; j++){ //CICLO CHE MI PERMETTE DI CONTROLLARE SE UNA LETTERE EQUIVALE AD UNA CONSONANTE
                    if(cog[i] != vocali[j]){
                        cons=true;
                    }else {
                        cons=false; //SE TROVA CHE EQUIVALE AD UNA VOCALE ESCE
                        break;     // ero insicuro sul posizionamento del break e questo ha comportato errori
                    }
                }
                if (cons){
                    cognome[numconsonanti] = cog[i]; //SE cons == TRUE ALLORA LO AGGIUNGE NELL'ARRAY FINALE
                    numconsonanti++;
                }
                cons=false;
            }
        }
        if(numconsonanti != 3) //SE DOPO TUTTI I CONTROLLI PRECEDENTI NON TROVA ABBASTANZA CONSONANTI SI AGGIUNGONO LE VOCALE
        {
            for(int i=0; i<this.cognome.length(); i++){
                if(numconsonanti  == 3)break;
                else{
                    for(int j=0; j < length ; j++){
                        if(cog[i] == vocali[j]){
                            voc=true;
                            break;
                        }else {
                            voc=false;
                        }
                    }
                    if (voc){
                        cognome[numconsonanti] = cog[i];
                        numconsonanti++;
                    }
                    voc=false;
                }
            }
        }
        if(numconsonanti == 2){ //SE CI SONO MENO DI 3 LETTERE NEL COGNOME SI AGGIUNGE UNA X ALLA FINE
            cognome[numconsonanti] = 'x';
            numconsonanti++;
        }
        return String.valueOf(cognome).toUpperCase();
    }


    //CALCOLO LETTERE DEL NOME
    //edit funzione nome by fra, ottimizzato (forse)
    public List<Character> nome_cf() {

        // dichiaro lista risultato
        List<Character> res_nome = new ArrayList<Character>();

        // dichiaro booleano, tentativi e secondo carattere
        boolean vocale = false;
        int tentativi = 1;
        boolean sec_char = true;

        // dichiaro gli array vocali
        char[] vocali = { 'a', 'e', 'i', 'o', 'u' };

        // scompongo il nome in array char
        char[] nome_scomposto = new char[this.nome.length()];
        // copia array in nome_scomposto
        for (int i = 0; i < this.nome.length(); i++) {
            nome_scomposto[i] = this.nome.charAt(i);
        }

        // conto le consonanti per verificare se saltare o meno la seconda consonant
        // (solo se minore di 4 consonanti)
        int count_consonanti = 0;
        for (int i = 0; i < this.nome.length(); i++) {
            char ch = this.nome.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.print("");
            } else if (ch != ' ') {
                count_consonanti += 1;
            }
        }
        // in caso di consonanti minori di 4, allora non salterò la seconda consonante
        if (count_consonanti < 4) {
            sec_char = false;
        }

        // ciclo per la lenght del nome, setto la booleana vocale a false come
        // semaforo, poi ciclo per quante sono le vocali e setto la booleana, se false
        // copio in array result
        while (res_nome.size() < 3) {
            if (tentativi == 1) {
                for (int i = 0; i < this.nome.length(); i++) {
                    // se il res è = 3 allora break
                    if (res_nome.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {
                        // comparo nome[i] e vocale[j]
                        if (nome_scomposto[i] == vocali[j]) {
                            vocale = true;
                            break;
                        }
                    }
                    // pusho il risultato
                    if (!vocale) {
                        if (res_nome.size() == 1 && sec_char == true) {
                            sec_char = false;
                            continue;
                        }
                        res_nome.add(nome_scomposto[i]);
                    }
                }
            } else if (tentativi == 2) {
                for (int i = 0; i < this.nome.length(); i++) {
                    // se il res è = 3 allora break
                    if (res_nome.size() == 3) {
                        break;
                    }
                    vocale = false;
                    for (int j = 0; j < vocali.length; j++) {
                        // comparo nome[i] e vocale[j]
                        if (nome_scomposto[i] == vocali[j]) {
                            vocale = true;
                        }
                    }
                    // pusho il risultato (stavolta solo se è vocale)
                    if (vocale) {
                        res_nome.add(nome_scomposto[i]);
                    }
                }
                // riempio di x fino a 3
            } else if (tentativi == 3) {
                while (res_nome.size() < 3) {
                    res_nome.add('x');
                }
            }
            tentativi += 1;
        }

        return res_nome;
    }

    //ANNO E MESE
    public char[] anno(){
        String cifre;
        char[] mese = {'A','B','C','D','E','H','L','M','P','R','S','T'};
        int length=mese.length;
        cifre= String.valueOf(this.anno);
        char[] cif = cifre.toCharArray();
        char [] totale = new char[3];
        int i = cif.length;
        totale[0]=cif[i-2];
        totale[1]=cif[i-1];
        for(int j=0; j<length+1; j++){
            if(this.mese==j+1){
                totale[2]=mese[j];
                break;
            }
        }
        return totale;
    }

    //GIORNO E SESSO
    public char[] giorno(){
        int totale;
        String cifre;
        char[] tot = new char[2];
        if(this.sesso.equals("maschio")){
            totale=this.giorno;
        }else totale=this.giorno+40;
        cifre=String.valueOf(totale);
        if(totale<10){
            tot[0]='0';
            tot[1]=cifre.charAt(0);
        }else tot=cifre.toCharArray();
        return tot;
    }


    public String comune() throws IOException {
        List<String> risultati_matchati = new ArrayList<String>();
        String linea_matchata = null;
        List<String> lines = Files.readAllLines(Paths.get("codicefiscale/comuni.txt"));
        for (String line : lines) {
            if (line.contains(this.comune.toUpperCase())) {
                risultati_matchati.add(line);
            }
        }

        for (int i = 0; i < risultati_matchati.size(); i++) {
            System.out.println((i + 1) + ")" + risultati_matchati.get(i));
        }

        

        Scanner sc = new Scanner(System.in);
        System.out.print("Quale di questi comuni intendi?: ");

        int scelta = sc.nextInt();
        linea_matchata = risultati_matchati.get(scelta - 1);

        int size = linea_matchata.length();
        String codice_comune = linea_matchata.substring(size - 4);
        sc.close();
        return codice_comune;
    }


}
