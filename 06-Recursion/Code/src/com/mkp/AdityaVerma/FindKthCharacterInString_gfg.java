package src.com.mkp.AdityaVerma;

public class FindKthCharacterInString_gfg {
    public static void main(String[] args) {
//        System.out.println(kthCharacter(5,2,5));
//        System.out.println(kthCharacter(0,4,3));
//        System.out.println(kthCharacter(0,0,1));
        System.out.println(kthCharacter1(0,3,4));
//        System.out.println(kthCharacter(0,1,2));
    }
    static char kthCharacter(int m, int n, int k) {
        // code here

        if(m == 0){
            return kthCharacterStartFromZero(n,k);
        }

//        convert the m into binary format
        String binary= "";
        while(m != 0){
            binary = (m % 2) + binary;
            m/=2;
        }
        System.out.println(binary);
//        generate grammar
        StringBuilder grammar=new StringBuilder(binary);
        while(n > 0){
            StringBuilder temp=new StringBuilder();
            for (int i = 0; i < grammar.length(); i++) {
                if(grammar.charAt(i) == '0' )
                    temp.append("01");
                else
                    temp.append("10");
            }
//            System.out.println(temp);
            grammar=temp;
            n--;
        }
        System.out.println(grammar);
        char ans = grammar.charAt(k-1);
        return ans;
    }

    static char kthCharacterStartFromZero(int n,int k){
        if(n == 0 && k == 1) return '0';
        if(n == 1 && k == 1) return '0';
        int l= (int) Math.pow(2,n-1);
        if( k > l) return '0';
        if(k < l/2){
            return kthCharacterStartFromZero(n-1,k);
        }else{
            return kthCharacterStartFromZero(n-1,k-(l/2)) == '0' ? '1' : '0' ;
        }
    }
    static char kthCharacter1(int m, int n, int k) {
        // code here

        int bin = 0, i = 1, rem;

        while(m != 0) {
            rem = m % 2;
            m = m/2;
            bin += rem * i;
            i  = i * 10;
        }

        String S = Integer.toString(bin);
        String ans = "";
        System.out.println(S);

        for(int j = 0; j < n; j++) {
            for(int l = 0; l < S.length(); l++) {

                char ch = S.charAt(l);

                if(ch == '1') {
                    ans += "10";

                }
                if(ch == '0') {
                    ans += "01";
                }
            }
            S = ans;
            ans = "";
        }
        char ch = S.charAt(k-1);
        return ch;

    }
}
