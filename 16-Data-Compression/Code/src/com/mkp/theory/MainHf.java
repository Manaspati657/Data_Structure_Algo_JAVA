package src.com.mkp.theory;

public class MainHf {
    public static void main(String[] args) {
        String str="abbccda";
        System.out.println(str);
        System.out.println(str.compareTo("aba"));
        HuffmanCoding hc=new HuffmanCoding(str);
        String encode=hc.genEncoder(str);
        System.out.println("Encode : "+encode);
        String decode=hc.genDecoder(encode);
        System.out.println(decode);
    }
}
