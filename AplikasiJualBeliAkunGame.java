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
            } else {
                System.out.println("\n1. Tambah Akun Game");
                System.out.println("2. Hapus Akun Game");
                System.out.println("3. Edit Akun Game");
                System.out.println("4. Daftar Akun Game");
                System.out.println("5. Cari Akun Game");
                System.out.println("6. Beli Akun Game");
                System.out.println("7. Logout");
                System.out.print("Pilih menu: ");
                int pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {
                    case 1:
                        tambahAkunGame(input);
                        break;
                    case 2:
                        hapusAkunGame(input);
                        break;
                    case 3:
                        editAkunGame(input);
                        break;
                    case 4:
                        daftarAkunGame();
                        break;
                    case 5:
                        cariAkunGame(input);
                        break;
                    case 6:
                        beliAkunGame(input);
                        break;
                    case 7:
                        penggunaAktif = null;
                        System.out.println("Anda berhasil logout.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }
        input.close();
    }
    static void registrasi(Scanner input) {
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        daftarPengguna.add(new Pengguna(username, password));
        System.out.println("Registrasi berhasil!");
    }

    static void login(Scanner input) {
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        for (Pengguna pengguna : daftarPengguna) {
            if (pengguna.username.equals(username) && pengguna.password.equals(password)) {
                penggunaAktif = pengguna;
                System.out.println("Login berhasil!");
                return;
            }
        }
        System.out.println("Username atau password salah!");
    }
    static void daftarAkunGame() {
        if (daftarAkunGame.isEmpty()) {
            System.out.println("Tidak ada akun game yang tersedia.");
        } else {
            for (int i = 0; i < daftarAkunGame.size(); i++) {
                AkunGame akun = daftarAkunGame.get(i);
                if (!akun.terjual) {
                    System.out.println((i + 1) + ". Nama Game: " + akun.namaGame + " | Deskripsi: " + akun.deskripsi);
                }
            }
        }
    }




