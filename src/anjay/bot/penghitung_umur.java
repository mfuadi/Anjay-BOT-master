package anjay.bot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class penghitung_umur {
        public static void main() {
            System.out.println("=======PENGHITUNG UMUR ANDA SEKARANG=======");
            Scanner input = new Scanner(System.in);
            Date currentDate = new Date();
            System.out.print("MASUKKAN TANGGAL LAHIR = ");
            var tanggal = input.nextLine();
            String birthDateInString = String.valueOf(tanggal);
            var format = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = null;
            try {
                birthDate = format.parse(tanggal);
                long diff = currentDate.getTime() - birthDate.getTime();
                long diffYears = ((diff / (24 * 60 * 60 * 1000)) / 30) / 12;
                System.out.println("UMUR ANDA SEKARANG ADALAH = " + diffYears + " TAHUN");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }


