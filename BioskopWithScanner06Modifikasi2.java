import java.util.Scanner;

public class BioskopWithScanner06Modifikasi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int baris, kolom;
        String nama, next;
        String[][] penonton = new String[4][2];
        int menu;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Input data penonton");
            System.out.println("2. Tampilkan daftar penonton");
            System.out.println("3. Exit");
            System.out.print("Pilih opsi menu: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan nama: ");
                        nama = sc.nextLine();

                        do {
                            System.out.print("Masukkan baris: ");
                            baris = sc.nextInt();
                            System.out.print("Masukkan kolom: ");
                            kolom = sc.nextInt();
                            sc.nextLine();

                            if (baris < 1 || baris > 4 || kolom < 1 || kolom > 2) {
                                System.out.println("Nomor baris atau kolom tidak tersedia.");
                                continue;
                            } else if (penonton[baris - 1][kolom - 1] != null) {
                                System.out.println("Kursi tersebut sudah terisi oleh " + penonton[baris - 1][kolom - 1]
                                        + ". Silakan pilih kursi lain.");
                                continue;
                            } else {
                                penonton[baris - 1][kolom - 1] = nama;
                                System.out.println("Data penonton berhasil ditambahkan.");
                                break;
                            }
                        } while (true);

                        System.out.print("Input penonton lainnya? (y/n): ");
                        next = sc.nextLine();

                        if (next.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nDaftar Penonton:");
                    for (int i = 0; i < penonton.length; i++) {
                        for (int j = 0; j < penonton[i].length; j++) {
                            System.out.printf("Baris %d Kolom %d: %s%n", i + 1, j + 1, (penonton[i][j] != null ? penonton[i][j] : "***"));
                        }
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih! Program selesai.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi!!");
            }
        }
    }
}
