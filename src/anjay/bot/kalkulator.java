package anjay.bot;

public class kalkulator {
    static double hasil;
    static String[] tmp_kal;
    public static double exekusi(String temp_1){

        if (temp_1.contains("*")) {
            tmp_kal = temp_1.split("\\*");
            hasil = Double.parseDouble(tmp_kal[0])*Double.parseDouble(tmp_kal[1]);
        }
        if (temp_1.contains("/")) {
            tmp_kal = temp_1.split("/");
            hasil = Double.parseDouble(tmp_kal[0])/Double.parseDouble(tmp_kal[1]);
        }
        if (temp_1.contains("+")) {
            tmp_kal = temp_1.split("\\+");
            hasil = Double.parseDouble(tmp_kal[0])+Double.parseDouble(tmp_kal[1]);

        }
        if (temp_1.contains("-")) {
            tmp_kal = temp_1.split("-");
            hasil = Double.parseDouble(tmp_kal[0])-Double.parseDouble(tmp_kal[1]);
        }
        return hasil;
    }
}
