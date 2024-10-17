import java.util.ArrayList;
import java.util.Scanner;

class Pengguna {
    String username;
    String password;

    Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class AkunGame {
    String namaGame;
    String deskripsi;
    boolean terjual;

    AkunGame(String namaGame, String deskripsi) {
        this.namaGame = namaGame;
        this.deskripsi = deskripsi;
        this.terjual = false;
    }
}

public class AplikasiJualBeliAkunGame {
    static ArrayList<Pengguna> daftarPengguna = new ArrayList<>();
    static ArrayList<AkunGame> daftarAkunGame = new ArrayList<>();
    static Pengguna penggunaAktif = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            if (penggunaAktif == null) {
                System.out.println("1. Registrasi");
                System.out.println("2. Login");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = input.nextInt();
                input.nextLine(); // Konsumsi newline

                switch (pilihan) {
                    case 1:
                        registrasi(input);
                        break;
                    case 2:
                        login(input);
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
