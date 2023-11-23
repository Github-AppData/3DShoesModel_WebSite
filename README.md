# :star: 프로젝트 소개 :star: 
- 프로젝트 명 : <b>3D Model Shoes WebSite</b>
- 제작 기간 : 2023/03/17 ~ 2023/11/14 <br/>
- 개발 일정 : 하단 페이지 구성 상세 <br/>
- Team members : 김태욱(leader/BE), 강준성(FE), 노일환(FE), 박종현(BE), 박형근(BE) 



## 개발환경
| 기술스택 | 상세 |
| --- | --- |
| 웹 서버 |  <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"> |
| 웹 페이지 | <img src="https://img.shields.io/badge/Html5-E34F26?style=for-the-badge&logo=Html5&logoColor=white">                                                                     <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white">                                                                       <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">                                                            |
| 웹 애플리케이션 | <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=Thymeleaf&logoColor=white"> |
| 데이터베이스 | <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> |
| API List | <img src="https://img.shields.io/badge/Sketchfab-1CAAD9?style=for-the-badge&logo=Sketchfab&logoColor=white"> |

<br>

# Page 구성 및 기능 소개 
<br>

## 1. Login Page


<img width="850" alt="login" src="https://github.com/Github-AppData/Graduation_work/assets/77886661/bc90f961-54ef-4a40-b860-3339bfe11869">

<br>

### 기능 : 1. 해쉬 값을 이용한 비밀번호 암호화

PasswordHashingUtil 클래스는 사용자의 비밀번호를 해시화하고, 무작위 솔트를 생성하며, 사용자가 입력한 비밀번호를 저장된 해시화된 비밀번호와 비교하는 몇 가지 메서드를 제공합니다.

```java
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

```

<h3>1. <b>hashPassword</b></h3>
- 입력으로 사용자의 비밀번호와 솔트를 받아와서 SHA-256 해시 함수를 사용하여 비밀번호를 해시화합니다.
비밀번호와 솔트를 조합하여 해시 함수에 업데이트하고, 그 결과를 16진수 문자열로 변환하여 반환합니다.

<h3>2. <b>bytesToHex</b></h3> 
- 바이트 배열을 16진수 문자열로 변환하는 보조 메서드입니다. 
각 바이트를 16진수로 변환하고 두 자리로 맞춘 후 문자열에 연결하여 반환합니다.

<h3>3. <b>generateSalt</b></h3>
- SecureRandom을 사용하여 16바이트(128비트)의 무작위 솔트를 생성합니다.
    생성된 솔트를 16진수 문자열로 변환하여 반환합니다.

<h3>4. <b>verifyPassword</b></h3>
- 사용자가 입력한 비밀번호와 저장된 해시화된 비밀번호를 비교합니다.

## 2. Main Page
![main](https://github.com/Github-AppData/Graduation_work/assets/77886661/d3c284b2-e94e-41f9-a907-80aed9bbf1ac)


### 기능 1 : Three.js를 이용한 3D Model 자동 회전

- SketchFab API 뿐만 아니라, Three.js를 이용해서 3D Shoes Model을 띄웠습니다.



## 참고자료

## :grey_question: 트러블슈팅

## :heavy_check_mark: 본 프로젝트 제작을 통하여 배운점

