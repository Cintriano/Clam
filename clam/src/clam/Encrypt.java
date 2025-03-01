package clam;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Encrypt {
	
	public static List<String> password_reader() throws IOException {
		List<String> passwords = new ArrayList<>();

        try {
            File file = new File("src/passwords");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String linha;
            while ((linha = reader.readLine()) != null) {
                passwords.add(linha);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return passwords;
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(password_reader());
		
		String msg2 [];
		String msg = "Mano se vc precisar de ajuda bora hj a noite na facul e eu te ajudo com o trabalho, nos programamos";
		//"OI MEU BEM"
		//24744:14046:24495:24078:23676:20415:24495:17040:23676:24078:
		String msg_encrypt = "";
		
		for (Integer i = 0; i < msg.length(); i++) {
			String code = Coding.coding(msg.substring(i, i + 1));
			//if (msg.substring(i, i + 1).equals(" ")) {
				//msg_encrypt = msg_encrypt + "\n";
			//}
			msg_encrypt = msg_encrypt + Math.mathing(code) + ":";
			}
		msg_encrypt = msg_encrypt.substring(0, msg_encrypt.length() - 1);
		System.out.println(msg_encrypt);
		
		//msg2 = msg.split(":");
		//for (Integer i = 0; i < msg.length(); i++) {
			//msg_encrypt = msg_encrypt + anmath(msg);
			//String code = coding(msg.substring(i, i + 1));
			//msg_encrypt = msg_encrypt + mathing(code) + ":";
			//}
		//System.out.print(msg_encrypt);
	}
}