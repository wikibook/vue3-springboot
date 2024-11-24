package kr.co.wikibook.gallery.common.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Base64;

public class HashUtils {

    // 솔트 생성
    public static String generateSalt(int size) {
        char[] resultArr = new char[size];
        Random random = new Random();

        // 랜덤한 문자열을 만들기 위한 문자열
        String options = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "!@#$%^&*()";

        for (int i = 0; i < resultArr.length; i += 1) {
            resultArr[i] = options.charAt(random.nextInt(options.length()));
        }

        return new String(resultArr);
    }

    // 해시 데이터 생성
    public static String generateHash(String value, String salt) {
        try {
            // SHA-256 알고리즘 사용
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // 원본 값과 솔트 합치기
            String passwordSalted = value + salt;

            // 문자열 데이터 해싱
            byte[] hashBytes = md.digest(passwordSalted.getBytes(StandardCharsets.UTF_8));

            // 바이트 배열을 Base64로 인코딩해서 반환
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("해싱 중 오류가 발생했습니다.");
        }
    }
}