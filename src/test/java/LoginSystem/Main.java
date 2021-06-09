package LoginSystem;

public class Main {

    public static void main(String[] args) {

        IDAndPasswords idAndPasswords = new IDAndPasswords();
        idAndPasswords.getLoginInfo();
        LoginPage loginPage = new LoginPage(idAndPasswords.getLoginInfo());
    }
}
