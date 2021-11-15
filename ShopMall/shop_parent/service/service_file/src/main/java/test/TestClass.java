package test;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class TestClass {
    public static void main(String[] args) {
        String gensalt = BCrypt.gensalt();
        System.out.println(gensalt);
        String saltPassword = BCrypt.hashpw("wu82293382", gensalt);
        System.out.println(saltPassword);
        boolean res = BCrypt.checkpw("wu82293382", saltPassword);
        System.out.println(res);
    }
}
