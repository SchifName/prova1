package codicefiscale;
import java.util.HashMap;

public class cf {
    String cog;
    String nome;
    char[] anno;
    char[] giorno;
    String comune;
    char controllo;

    public cf(String c, String n, char[] a, char[] g, String comune){
        cog=c;
        nome=n;
        anno=a;
        giorno=g;
        this.comune=comune;
    }

    public char controllo_cod(){
        String tot = this.cog + this.nome + this.anno.toString() + this.giorno.toString() + comune;
        char[] totA = tot.toCharArray();
        HashMap<Character, Integer> codiciDisp = new HashMap<Character, Integer>();
        codiciDisp.put('0', 1);
        codiciDisp.put('1', 0);
        codiciDisp.put('2', 5);
        codiciDisp.put('3', 7);
        codiciDisp.put('4', 9);
        codiciDisp.put('5', 13);
        codiciDisp.put('6', 15);
        codiciDisp.put('7', 17);
        codiciDisp.put('8', 19);
        codiciDisp.put('9', 21);
        codiciDisp.put('A', 1);
        codiciDisp.put('B', 0);
        codiciDisp.put('C', 5);
        codiciDisp.put('D', 7);
        codiciDisp.put('E', 9);
        codiciDisp.put('F', 13);
        codiciDisp.put('G', 15);
        codiciDisp.put('H', 17);
        codiciDisp.put('I', 19);
        codiciDisp.put('J', 21);
        codiciDisp.put('K', 2);
        codiciDisp.put('L', 4);
        codiciDisp.put('M', 18);
        codiciDisp.put('N', 20);
        codiciDisp.put('O', 11);
        codiciDisp.put('P', 3);
        codiciDisp.put('Q', 6);
        codiciDisp.put('R', 8);
        codiciDisp.put('S', 12);
        codiciDisp.put('T', 14);
        codiciDisp.put('U', 16);
        codiciDisp.put('V', 10);
        codiciDisp.put('W', 22);
        codiciDisp.put('X', 25);
        codiciDisp.put('Y', 24);
        codiciDisp.put('Z', 23);

        HashMap<Character, Integer> codiciPar = new HashMap<Character, Integer>();
        codiciPar.put('0', 1);
        codiciPar.put('1', 0);
        codiciPar.put('2', 5);
        codiciPar.put('3', 7);
        codiciPar.put('4', 9);
        codiciPar.put('5', 13);
        codiciPar.put('6', 15);
        codiciPar.put('7', 17);
        codiciPar.put('8', 19);
        codiciPar.put('9', 21);
        codiciPar.put('A', 1);
        codiciPar.put('B', 0);
        codiciPar.put('C', 5);
        codiciPar.put('D', 7);
        codiciPar.put('E', 9);
        codiciPar.put('F', 13);
        codiciPar.put('G', 15);
        codiciPar.put('H', 17);
        codiciPar.put('I', 19);
        codiciPar.put('J', 21);
        codiciPar.put('K', 2);
        codiciPar.put('L', 4);
        codiciPar.put('M', 18);
        codiciPar.put('N', 20);
        codiciPar.put('O', 11);
        codiciPar.put('P', 3);
        codiciPar.put('Q', 6);
        codiciPar.put('R', 8);
        codiciPar.put('S', 12);
        codiciPar.put('T', 14);
        codiciPar.put('U', 16);
        codiciPar.put('V', 10);
        codiciPar.put('W', 22);
        codiciPar.put('X', 25);
        codiciPar.put('Y', 24);
        codiciPar.put('Z', 23);
        
        int ind = 0;
        int [] numeri = new int [16];
        for (char i : codiciDisp.keySet()){
            if(totA[ind] == i){
                numeri[ind] = codiciDisp.get(i);
                ind = ind+2;
            }
        }

        ind = 1;
        for (char i : codiciDisp.keySet()){
            if(totA[ind] == i){
                numeri[ind] = codiciDisp.get(i);
                ind = ind+2;
            }
        }



        return this.controllo;
    };

}
