package anjay.function;
import anjay.bot.*;
public class menu {

    public static void main(){

        System.out.println("""
                1. Kalkulator (+,-,*,/)
                2. Waktu dan Jam Dunia
                3. Simpan Data
                4. penghitung umur
                5. Gpp ga ada :v
                """);

        switch (fungsi.input1("Masukan Pilihan: ")) {
            case 1 -> {
                fungsi.clearScreen(); // Untuk clear screen
                var kalkulator_output = kalkulator.exekusi(fungsi.inputstring("Masukan Nilai (Hanya support 2 Bilangan: "));
                // Arie
                System.out.printf("Hasil kalkulasinya adalah : %.1f", kalkulator_output);
            }
            case 2 ->
                //Waktu Sekarang dan Jam Dunia
                    jamdunia.main(fungsi.input1("Masukan Jam Sekarang: "));

            //Konversi mata uang
            // NPM to text
            case 3 ->{
                //penghitung umur
                penghitung_umur.main();
            }
            case 4, 5 -> {
                System.out.println("""
                        1. List data login
                        2. Tambah user
                        3. Delete user""");
                switch (fungsi.input1("Masukan pilihan: ")) {
                    case 1 -> fungsi.cetak_filekelayar();
                    case 2 -> fungsi.menambah_datakefile("Silahkan isi username");
                    case 3 -> fungsi.hapus_data();
                }
            }

            //Masih dipikirkan mungkin pake youtube download?
        }
    }

}
