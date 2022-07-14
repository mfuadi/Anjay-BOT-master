package anjay.function;
import java.util.*;
import java.io.*;
public class fungsi {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> todoLists=new ArrayList<>();
    static boolean isEditing = false;
    static final String filePath = System.console() == null ? "/src/database.txt" : "/database.txt";
    static final String fileName = System.getProperty("user.dir") + filePath;
    static void membaca_file() {
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            // load isi file ke dalam array todoLists
            todoLists.clear();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                todoLists.add(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }

    public static void cetak_filekelayar() {

        membaca_file(); // ubah klo mau

        if (todoLists.size() > 0) {
            System.out.println("LIST DATA:");
            int index = 0;
            for (String data : todoLists) {
                System.out.printf("[%d] %s%n", index, data);
                index++;
            }
        } else {
            System.out.println("Tidak ada data!");

        }

//        if (!isEditing) {
//            backToMenu();
//        }
    }

    public static void menambah_datakefile(String text1) {
        input.nextLine();//menangkap enter
        System.out.println(text1);
        System.out.print("Jawab: ");
        String newTodoList = input.nextLine();

        try {
            // tulis file
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.append(String.format("%s%n", newTodoList));
            fileWriter.close();
            System.out.println("Berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }

    }
    static void editTodoList() {

        isEditing = true;
        cetak_filekelayar();

        try {
            System.out.println("-----------------");
            System.out.print("Pilih Indeks> ");
            int index = Integer.parseInt(input.nextLine());

            if (index > todoLists.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
            } else {

                System.out.print("Data baru: ");
                String newData = input.nextLine();

                // update data
                todoLists.set(index, newData);

                System.out.println(todoLists);

                try {
                    FileWriter fileWriter = new FileWriter(fileName, false);

                    // write new data
                    for (String data : todoLists) {
                        fileWriter.append(String.format("%s%n", data));
                    }
                    fileWriter.close();

                    System.out.println("Berhasil diubah!");
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        isEditing = false;
    }
    static void hapus_data() {
        input.nextLine();
        isEditing = true;
        cetak_filekelayar();

        System.out.println("-----------------");
        System.out.print("Pilih Indeks> ");
        int index = Integer.parseInt(input.nextLine());

        try {
            if (index > todoLists.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
            } else {

                System.out.println("Kamu akan menghapus:");
                System.out.printf("[%d] %s%n", index, todoLists.get(index));
                System.out.println("Apa kamu yakin?");
                System.out.print("Jawab (y/t): ");
                String jawab = input.nextLine();

                if (jawab.equalsIgnoreCase("y")) {
                    // hapus data
                    todoLists.remove(index);

                    // tulis ulang file
                    try {
                        FileWriter fileWriter = new FileWriter(fileName, false);

                        // write new data
                        for (String data : todoLists) {
                            fileWriter.append(String.format("%s%n", data));
                        }
                        fileWriter.close();

                        System.out.println("Berhasil dihapus!");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        isEditing = false;

    }



    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // clear screen untuk windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                // clear screen untuk Linux, Unix, Mac
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }
    public static void login() {
        while (true) {
                System.out.println("=======|| LOGIN KEDALAM  PROGRAM ||=======");
                System.out.println("``````");
                System.out.println("(|=========|Masukan Nama User Anda|=========|)");
                System.out.print("\t*| UserName |=> ");
                String user = input.next();
                System.out.println("(|=========|Masukan Pasword Anda|=========|)");
                System.out.print("\t*| Password |=> ");
                String pwd = input.next();


                if (user.equals("admin") && pwd.equals("root")) {
                    System.out.println(" ");
                    System.out.println("\t\t=======================");
                    System.out.println("\t\t||Anda Berhasil Login||");
                    System.out.println("\t\t=======================");
                    break;
                } else {
                    System.out.println("\t========================================");
                    System.out.println("\t||Maaf Pasword Yang Anda Masukan Salah||");
                    System.out.println("\t========================================");
                }
                System.out.println("Apakah Ingin Ulangi (y/n)?= ");

            }
    }
    public static void backToMenu() {
        input.nextLine();
        System.out.println();
        System.out.print("Tekan [Enter] untuk kembali..");
        input.nextLine();
        clearScreen();
    }

    public static int input1(String text){
        System.out.print(text);
        return input.nextInt();

    }
    public static String inputstring(String text){
        System.out.print(text);
        return input.next();

    }
}