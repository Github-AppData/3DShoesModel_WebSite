<h1 align="center">✨ 3D Model Shoes Website ✨</h1>


# 📗 **목차**
* 📝&nbsp; [개요](#📝-포트폴리오-개요)
* 🛠&nbsp; [기술 및 도구](#🛠-기술-및-도구)
* 🔗&nbsp; [링크](#🔗-링크)
* 👨🏻‍💻&nbsp; [기능 구현](#👨🏻‍💻-기능-구현)
	- 🔐&nbsp; [비밀번호 암호화 SHA-256](#🔐-비밀번호-암호화-sha-256)
	- ⚡️&nbsp; [3D Model Display](#⚡️-3d-model-display)
	- 💳&nbsp; [결제 시스템](#💳-결제-시스템)<br>
	- 💌&nbsp; [SMTP](#💌-smtp)<br>
* 💥&nbsp; [Trouble Shooting](#💥-trouble-shooting)<br><br>


# 📝 **포트폴리오 개요**
- 프로젝트 명 : <b>3D Model Shoes WebSite</b>
- 프로잭트 목적 : 사용자는 신발을 360도로 회전하고 확대하여 더 자세히 살펴볼 수 있어, 온라인 쇼핑의 편의성을 향상시키는 것
- 제작 기간 : 2023/03/17 ~ 2023/11/14 <br/>
- 개발 일정 : 하단 페이지 구성 상세 <br/>
- Team members : 김태욱(leader/BE), 강준성(FE), 노일환(FE), 박종현(BE), 박형근(BE) <br><br>

# 🛠 **기술 및 도구**
| 기술스택 | 상세 |
| --- | --- |
| 웹 서버 |  <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"> |
| 웹 페이지 | <img src="https://img.shields.io/badge/Html5-E34F26?style=for-the-badge&logo=Html5&logoColor=white">                                                                     <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white">                                                                       <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">                                                            |
| 웹 애플리케이션 | <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=Thymeleaf&logoColor=white"> |
| 데이터베이스 | <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> |
| API List | <img src="https://img.shields.io/badge/Sketchfab-1CAAD9?style=for-the-badge&logo=Sketchfab&logoColor=white"> |

<br>

# 🔗 **링크**
<b>호스팅 할 예정입니다.</b>
<br><br>

# 👨🏻‍💻 **기능 구현**

## 🔐 **비밀번호 암호화 SHA-256**

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

<img width="1161" alt="image" src="https://github.com/Github-AppData/3DShoesModel_WebSite/assets/77886661/6ef07c05-fa71-412a-8bb8-43f90aa94966">

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

<br>

## ⚡️ 3D Model Display

### 방법 1 : Three.js를 이용한 3D Model 자동 회전

- SketchFab API 뿐만 아니라, Three.js를 이용해서 3D Shoes Model을 띄웠습니다.

![main](https://github.com/Github-AppData/Graduation_work/assets/77886661/d3c284b2-e94e-41f9-a907-80aed9bbf1ac)

### 방법 2 : SketchFab API를 이용해서 id 값을 통해 <u>다운로드 없이</u> iframe에 3D Model Display 

<img width="850" alt="smain" src="https://github.com/Github-AppData/Graduation_work/assets/77886661/31d35548-75cf-454a-a1dd-2cd6b56e5cec"><br>


```javascript
// 신발의 정보를 담고 있는 imageToModelMapping_real 배열 
// iframeId로 SketchFab API를 이용
imageToModelMapping_real.push({uid: object[i].shoes_id, iframeId: 'api-frame-' + (i + 1), shoes_name: object[i].shoes_name, final_price: object[i].final_price, shoes_price: object[i].shoes_price, review_stars: object[i].review_stars});

// API 함수와 배열을 iframeId로 매핑
imageToModelMapping_real.forEach(function (mapping) {
	replaceWith3DModel(mapping.uid, mapping.iframeId);
});

// 3D Model로 대체한다. - iframe에 있는 정보를
function replaceWith3DModel(uid, iframeId) {
	return new Promise(function (resolve, reject) {
		var iframe = document.getElementById(iframeId);
		var client = new Sketchfab(iframe);

		client.init(uid, {
        	success: function onSuccess(api) {
			api.start();
			    api.addEventListener('viewerready', function () {
				    console.log(iframeId + ' 3D 모델이 준비되었습니다.');
				    resolve(); // Promise가 성공했음을 알립니다.
			    });
		    },
			error: function onError() {
				console.log(iframeId + ' 3D 모델 초기화 오류');
				reject(); // Promise가 실패했음을 알립니다.
			},
			// 초기화 매개변수 설정
			graph_optimizer: 1, //그래프
			merge_materials: 1, //재질 병합
			material_packing: 1 //재질 패킹
		});
	});
}

function loadModels() {

    // 모든 모델을 비동기식으로 로드합니다.                 
	Promise.all(imageToModelMapping_real.map(function (mapping) {
		return replaceWith3DModel(mapping.uid, mapping.iframeId);
	})).then(function () {
		// 모든 모델이 로드되었을 때 이 부분이 실행됩니다.
		console.log('모든 3D 모델이 로드되었습니다.');
	}).catch(function () {
		// 하나 이상의 모델 로딩에 실패한 경우 이 부분이 실행됩니다.
		console.log('모든 3D 모델을 로드하는 동안 오류가 발생했습니다.');
	});
}

// 모든 모델을 한꺼번에 로드합니다.
loadModels();
```
SketchFab 3D Open API와 3D Shoes Model의 id를 매핑하여 사용자에게 3D Model을 시각적으로 제공!


## 💳 **결제 시스템**

<img width="850" alt="sDetails" src="https://github.com/Github-AppData/Graduation_work/assets/77886661/6d2cac69-add1-4ded-a5b3-fff63132824c">


![sDetailWholescreen](https://github.com/Github-AppData/Graduation_work/assets/77886661/a5cb28e9-a89c-4014-b0b4-dcfb302ac45e)
<br>

### iamport
<img width="850" alt="sDetails-cardPay" src="https://github.com/Github-AppData/Graduation_work/assets/77886661/b0415ec2-c004-4a25-949c-3a4e4c1d54da">

<br>

### Kako Pay

<img width="850" alt="sDetails-kakaoPay" src="https://github.com/Github-AppData/Graduation_work/assets/77886661/89249fd9-fe1c-4bb8-bccf-46afcc001c83">

## 💌 **SMTP**
<br>

# 💥 **Trouble Shooting**
<img width="1162" alt="image" src="https://github.com/Github-AppData/3DShoesModel_WebSite/assets/77886661/2df7d6a3-2ae2-46f8-b662-eb57c9a3a7f1">

