import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank ABC");
        Scanner scanner = new Scanner(System.in);

        bank.tambahAccount(new Account("001", "Andi", 100000));
        bank.tambahAccount(new Account("002", "Budi", 250000));
        bank.tambahAccount(new Account("003", "Citra", 500000));

        System.out.println("Welcome to " + bank.getNamaBank());

        int pilihan;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tampilkan Semua Account");
            System.out.println("2. Tambah Account Baru");
            System.out.println("3. Setor (Deposit)");
            System.out.println("4. Tarik (Withdraw)");
            System.out.println("5. Cari Account berdasarkan Nomor");
            System.out.println("6. Hitung Total Saldo");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu (1-7): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println();
                    bank.tampilkanSemuaAccount();
                    break;

                case 2:
                    System.out.print("Nomor Rekening : ");
                    String nomorBaru = scanner.nextLine();
                    System.out.print("Nama Pemilik   : ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Saldo Awal     : ");
                    int saldoAwal = scanner.nextInt();
                    scanner.nextLine();
                    bank.tambahAccount(new Account(nomorBaru, namaBaru, saldoAwal));
                    System.out.println("Account baru berhasil dibuat!");
                    break;

                case 3:
                    System.out.print("Nomor rekening tujuan: ");
                    Account accountSetor = bank.cariAccount(scanner.nextLine());
                    if (accountSetor == null) {
                        System.out.println("Account tidak ditemukan.");
                    } else {
                        System.out.print("Jumlah setoran: ");
                        int jumlahSetor = scanner.nextInt();
                        scanner.nextLine();
                        accountSetor.deposit(jumlahSetor);
                        System.out.println("Saldo terbaru: Rp " + accountSetor.getBalance());
                    }
                    break;

                case 4:
                    System.out.print("Nomor rekening tujuan: ");
                    Account accountTarik = bank.cariAccount(scanner.nextLine());
                    if (accountTarik == null) {
                        System.out.println("Account tidak ditemukan.");
                    } else {
                        System.out.print("Jumlah penarikan: ");
                        int jumlahTarik = scanner.nextInt();
                        scanner.nextLine();
                        accountTarik.withdraw(jumlahTarik);
                        System.out.println("Saldo terbaru: Rp " + accountTarik.getBalance());
                    }
                    break;

                case 5:
                    System.out.print("Masukkan nomor rekening yang dicari: ");
                    Account hasil = bank.cariAccount(scanner.nextLine());
                    if (hasil == null) {
                        System.out.println("Account tidak ditemukan.");
                    } else {
                        hasil.tampilkanInfo();
                    }
                    break;

                case 6:
                    System.out.println("Total saldo seluruh account: Rp " + bank.hitungTotalSaldo());
                    break;

                case 7:
                    System.out.println("Program selesai. Terima kasih.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Masukkan angka 1-7.");
            }
        } while (pilihan != 7);

        scanner.close();
    }
}
