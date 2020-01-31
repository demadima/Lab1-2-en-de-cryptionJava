package lab2;

/**
 *
 * @author Alex
 */
public class decryption {
	
    private static String alphabet = "אבגדהו¸זחטיךכלםמןנסעףפץצקרשתûü‎‏ÿ ";

    public static String Decrypt(String text, int a, int b) {
    	int m = alphabet.length();
        int x;
        int inv = Inverse(a, m);
        text = text.toLowerCase();
        String result = "";
       
        for (int i = 0; i < text.length(); i++) {
            int pos = alphabet.indexOf(text.charAt(i));
System.out.println(pos);
            if (pos < 0) {
                result += text.charAt(i);
            } else {
                x = (inv * (pos + m - b)) % m;
                result+=alphabet.charAt(x);
            }
        }
        return result;
    }

    private static int Inverse(int a, int m) {
        for (int i = 1; i < m; i++) {
            if ((a * i) % m == 1) {
                return i;
            }
        }

        return 1;
    }

}
