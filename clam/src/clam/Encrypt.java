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
		
		List<String> password_list = new ArrayList<>();
		
		password_list = password_reader();
		Integer aux = 0;
		String msg_encrypt = "";
		
		for (String password : password_list) {
			//System.out.println(password_list.get(i));
			for (int i = 0; i < password.length(); i++) {
				String code = Coding.coding(password.substring(i, i + 1));
				if (aux == 15) {
					msg_encrypt = msg_encrypt + "\n";
					aux = 0;
				}
				aux++;
				msg_encrypt = msg_encrypt + Math.mathing(code) + "	";
			}
		}
		System.out.println(msg_encrypt);
	}
}
		
		/* 
		System.out.println(password_reader());
		String msg2 [];
		
		msg2 = msg.split(":");
		for (Integer i = 0; i < msg.length(); i++) {
			msg_encrypt = msg_encrypt + anmath(msg);
			String code = coding(msg.substring(i, i + 1));
			msg_encrypt = msg_encrypt + mathing(code) + ":";
			}
		*/