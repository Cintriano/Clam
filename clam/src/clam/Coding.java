package clam;

import java.util.HashMap;

public class Coding {
    public static String coding(String msg) {
        HashMap<String, String> chaves = new HashMap<>() {{
            put(" ", "8163");
            
            put("A", "1234");
            put("B", "5678");
            put("C", "9012");
            put("D", "3456");
            put("E", "7890");
            put("F", "1357");
            put("G", "2468");
            put("H", "3579");
            put("I", "4680");
            put("J", "5791");
            put("K", "6802");
            put("L", "7913");
            put("M", "8024");
            put("N", "9135");
            put("O", "8246");
            put("P", "1358");
            put("Q", "2469");
            put("R", "3590");
            put("S", "4681");
            put("T", "5792");
            put("U", "6803");
            put("V", "7914");
            put("Y", "8025");
            put("Z", "9136");
            
            put("a", "2577");
            put("b", "7615");
            put("c", "2900");
            put("d", "2883");
            put("e", "9535");
            put("f", "7225");
            put("g", "3584");
            put("h", "7208");
            put("i", "1366");
            put("j", "7550");
            put("k", "7199");
            put("l", "7759");
            put("m", "6328");
            put("n", "1764");
            put("o", "2066");
            put("p", "7380");
            put("q", "6130");
            put("r", "2010");
            put("s", "9691");
            put("t", "1052");
            put("u", "2143");
            put("v", "4774");
            put("y", "4332");
            put("z", "1453");
            
            put("0", "1230");
            put("1", "2341");
            put("2", "3452");
            put("3", "4563");
            put("4", "5674");
            put("5", "6785");
            put("6", "7896");
            put("7", "8907");
            put("8", "9018");
            put("9", "0129");
            
            put("!", "1111");
            put("@", "2222");
            put("#", "3333");
            put("$", "4444");
            put("%", "5555");
            put("&", "6666");
            put("*", "7777");
            put("+", "8888");
            put("=", "9999");
            put("<", "1010");
            put(">", "2020");
            put("?", "3030");
            put("/", "4040");
            put("\\", "5050");
            put("|", "6060");
            put(":", "7070");
            put(";", "8080");
            put("(", "9091");
            put(")", "9090");
            put(",", "9094");
            put(".", "9097");
            
            put("Á", "1112");
            put("À", "2223");
            put("Â", "3334");
            put("Ã", "4445");
            put("É", "5556");
            put("Ê", "6667");
            put("Í", "7778");
            put("Ó", "8889");
            put("Ò", "9991");
            put("Ô", "1012");
            put("Õ", "2023");
            put("Ú", "3034");
            put("Ü", "4045");
            put("Ç", "5056");

            put("á", "6161");
            put("à", "7272");
            put("â", "8383");
            put("ã", "9494");
            put("é", "1515");
            put("ê", "2626");
            put("í", "3737");
            put("ó", "4848");
            put("ò", "5959");
            put("ô", "6061");
            put("õ", "7172");
            put("ú", "8283");
            put("ü", "9394");
            put("ç", "1414");
        }};

        return chaves.get(msg);
    }
}
