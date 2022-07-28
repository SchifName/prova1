package codicefiscale;

import java.util.HashMap;

public class cf {
    String cog;
    String nome;
    char[] anno;
    char[] giorno;
    String comune;
    char controllo;
    String cf;

    public cf(String c, String n, char[] a, char[] g, String comune) {
        cog = c;
        nome = n;
        anno = a;
        giorno = g;
        this.comune = comune;
    }

    public char controllo_cod(){
        String tot = this.cog + this.nome + String.valueOf(this.anno).toUpperCase() + String.valueOf(this.giorno).toUpperCase() + this.comune;
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
        codiciPar.put('0', 0);
        codiciPar.put('1', 1);
        codiciPar.put('2', 2);
        codiciPar.put('3', 3);
        codiciPar.put('4', 4);
        codiciPar.put('5', 5);
        codiciPar.put('6', 6);
        codiciPar.put('7', 7);
        codiciPar.put('8', 8);
        codiciPar.put('9', 9);
        codiciPar.put('A', 0);
        codiciPar.put('B', 1);
        codiciPar.put('C', 2);
        codiciPar.put('D', 3);
        codiciPar.put('E', 4);
        codiciPar.put('F', 5);
        codiciPar.put('G', 6);
        codiciPar.put('H', 7);
        codiciPar.put('I', 8);
        codiciPar.put('J', 9);
        codiciPar.put('K', 10);
        codiciPar.put('L', 11);
        codiciPar.put('M', 12);
        codiciPar.put('N', 13);
        codiciPar.put('O', 14);
        codiciPar.put('P', 15);
        codiciPar.put('Q', 16);
        codiciPar.put('R', 17);
        codiciPar.put('S', 18);
        codiciPar.put('T', 19);
        codiciPar.put('U', 20);
        codiciPar.put('V', 21);
        codiciPar.put('W', 22);
        codiciPar.put('X', 23);
        codiciPar.put('Y', 24);
        codiciPar.put('Z', 25);

        char [] resto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int sommatore = 0;

        for (int i = 1; i <= totA.length; i++) {

            if (i % 2 == 0) {

                sommatore += codiciPar.get(totA[i - 1]);

            } else {

                sommatore += codiciDisp.get(totA[i - 1]);

            }

        }
        sommatore = sommatore % 26;
        this.controllo=resto[sommatore];
        this.cf=tot+String.valueOf(this.controllo);
        return this.controllo;
    };

}
