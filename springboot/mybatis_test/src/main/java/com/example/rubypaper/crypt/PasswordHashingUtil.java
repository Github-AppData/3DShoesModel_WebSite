package com.example.rubypaper.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHashingUtil {

	// 사용자의 비밀번호를 해시화하는 메서드
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        // SHA-256 해시 함수를 사용하여 비밀번호를 해시화
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes()); // 솔트를 해시 함수에 업데이트
        byte[] hashedPassword = md.digest(password.getBytes()); // 비밀번호를 해시화
        return bytesToHex(hashedPassword);
    }
    
    

    // 바이트 배열을 16진수 문자열로 변환하는 메서드
    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    // 무작위 솔트를 생성하는 메서드
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return bytesToHex(salt);
    }

    // 사용자가 입력한 비밀번호와 저장된 해시화된 비밀번호를 비교하는 메서드
    public static boolean verifyPassword(String inputPassword, String storedHashedPassword)
            throws NoSuchAlgorithmException {
        return inputPassword.equals(storedHashedPassword);
    }
}
