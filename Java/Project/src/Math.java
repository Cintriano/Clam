package clam;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Math {
	public static String mathing(String msg, List<String> keys) {
		Integer code = Integer.parseInt(msg);
		Integer A = Integer.parseInt(keys.get(0));
		Integer B = Integer.parseInt(keys.get(1));
		Integer msg_encrypt = (code * B) + A;
		return Integer.toString(msg_encrypt);
	}
	
	public static String unmath(String msg, List<Integer> keys) {
		Integer msg_encrypt = Integer.parseInt(msg);
		Integer A = keys.get(0);
		Integer B = keys.get(1);
		Integer msg_desencrypt = (msg_encrypt - A) / B;
		return Integer.toString(msg_desencrypt);
	}
	
	public static List<String> keys() {
		Random random = new Random();
		
	    List<String> numeros = new ArrayList<>();

	    numeros.add(Integer.toString(random.nextInt(1, 100)));
	    numeros.add(Integer.toString(random.nextInt(1, 100)));

	    return numeros;
	    }
}
