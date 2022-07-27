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
    public String nom(){
        char[] vocali = new char[] {'a','e','i','o','u','A','E','I','O','U'}; //ARRAY DI VOCALI
        char [] nom = this.nome.toCharArray(); //ARRAY CON OGNI LETTERA DEL NOME
        char [] nome = new char[3]; //ARRAY PER IL RISULTATO FINALE
        char [] passaggio = new char[3]; //ARRAY DI PASSAGGIO CHE MI PERMETTE DI VERIFICARE QUANTE CONSONANTI CI SONO E CONTEMPORANEAMENTE SALVARLE QUI
        int c = 0; //INDICE DELL'ARRAY DI PASSAGGIO
        boolean cons=false; //BOOLEANO CHE MI PERMETTE DI CAPIRE SE UNA DETERMINATA LETTERA è UNA CONSONANTE
        boolean voc=false; //BOOLEANO CHE MI PERMETTE DI CAPIRE SE UNA DETERMINATA LETTERA è UNA VOCALE
        int numconsonanti = 0; //CONTA LE LETTERE NEL RISULTATO FINALE
        int length=vocali.length; //LUNGHEZZA DELL'ARRAY DELLE VOCALI
        for(int i=0; i<this.nome.length(); i++){
            if(numconsonanti  == 3)break;//SE NE HA GIA' TROVATE 3 ESCE DAL CICLO
            else{
                for(int j=0; j < length ; j++){ //CICLO CHE MI PERMETTE DI CONTROLLARE SE UNA LETTERE EQUIVALE AD UNA CONSONANTE
                    if(nom[i] != vocali[j]){
                        cons=true;
                    }else {
                        cons=false;
                        break; //SE TROVA CHE EQUIVALE AD UNA VOCALE ESCE
                    }
                }
                if (cons){ //SE cons == TRUE ALLORA LO AGGIUNGE NELL'ARRAY FINALE SE è LA PRIMA CONSONANTE TROVATA
                    if(numconsonanti==1){ //DALLA SECONDA CONSONANTE TROVATA LI AGGIUNGE NELL'ARRAY DI PASSAGGIO
                        if(c==3)break; //FINO AD AVERNE 3
                        else{
                            passaggio[c] = nom[i];
                            c++;
                        }
                    }else{
                        nome[numconsonanti] = nom[i]; 
                        numconsonanti++;
                    }
                }
                cons=false;
            }
        }
        if(c>2) //VERIFICA SE CI SONO O MENO 4 CONSONANTI
        {
            //CE NE SONO SOLO 4 IN TOTALE 3 nell'array di passaggio
            nome[numconsonanti] = passaggio[1];
            numconsonanti++;
            nome[numconsonanti] = passaggio[2];
            numconsonanti++;
        }else{
            if(c>1){
                //CE NE SONO 3 IN TOTALE 2 nel'array di passaggio
                nome[numconsonanti] = passaggio[0];
                numconsonanti++;
                nome[numconsonanti] = passaggio[1];
                numconsonanti++;
                //SE C>2 CI SARRANNO IN TOTALE ALMENO 4 CONSONANTI E QUINDI BISOGNA AGGIUNGERE ALL'ARRAY FINALE SOLAMENTE LA 3 E LA 4 CONSONANTE
            }else{
                if(c>0){
                    nome[numconsonanti] = passaggio[0];
                    numconsonanti++;
                }
            }
        }
        if(numconsonanti != 3) //SE DOPO TUTTI I CONTROLLI PRECEDENTI NON TROVA ABBASTANZA CONSONANTI SI AGGIUNGONO LE VOCALE
        {
            for(int i=0; i<this.nome.length(); i++){
                if(numconsonanti  == 3)break;
                else{
                    for(int j=0; j < length ; j++){
                        if(nom[i] == vocali[j]){
                            voc=true;
                            break;
                        }else {
                            voc=false;
                        }
                    }
                    if (voc){
                        nome[numconsonanti] = nom[i];
                        numconsonanti++;
                    }
                    voc=false;
                }
            }
        }
        if(numconsonanti == 2){ //SE CI SONO MENO DI 3 LETTERE NEL COGNOME SI AGGIUNGE UNA X ALLA FINE
            nome[numconsonanti] = 'x';
            numconsonanti++;
        }
        return String.valueOf(nome).toUpperCase();
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
