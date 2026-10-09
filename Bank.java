import java.util.ArrayList;

public class Bank {

    private String namaBank;
    private ArrayList<Account> daftarAccount;

    public Bank(String namaBank) {
        this.namaBank = namaBank;
        this.daftarAccount = new ArrayList<>();
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void tambahAccount(Account account) {
        daftarAccount.add(account);
    }

    public Account cariAccount(String nomor) {
        for (Account a : daftarAccount) {
            if (a.getNomorRekening().equalsIgnoreCase(nomor)) {
                return a;
            }
        }
        return null;
    }

    public void tampilkanSemuaAccount() {
        if (daftarAccount.isEmpty()) {
            System.out.println("Belum ada data account.");
            return;
        }
        for (Account a : daftarAccount) {
            a.tampilkanInfo();
            System.out.println("-----------------------------------");
        }
    }

    public int hitungTotalSaldo() {
        int total = 0;
        for (Account a : daftarAccount) {
            total += a.getBalance();
        }
        return total;
    }
}