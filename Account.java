public class Account {

    private String nomorRekening;
    private String namaPemilik;
    private int balance;

    public Account(String nomorRekening, String namaPemilik, int balance) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.balance = balance;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah setoran harus lebih dari 0.");
            return;
        }
        balance += jumlah;
    }

    public void withdraw(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah penarikan harus lebih dari 0.");
            return;
        }
        if (jumlah > balance) {
            System.out.println("Saldo tidak mencukupi.");
            return;
        }
        balance -= jumlah;
    }

    public void tampilkanInfo() {
        System.out.println("No. Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik : " + namaPemilik);
        System.out.println("Saldo        : Rp " + balance);
    }
}
