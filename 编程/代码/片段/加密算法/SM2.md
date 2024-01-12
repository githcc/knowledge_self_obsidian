## 生成密钥
```
KeyPair pair = SecureUtil.generateKeyPair("SM2");
System.out.println(Base64.encode(pair.getPrivate().getEncoded()));
System.out.println(Base64.encode(pair.getPublic().getEncoded()));
```

## 不指定密钥
```
// 创建SM2对象
SM2 sm2 = new SM2();

// 数据加密
String data = "Hello, SM2!";
String encryptData = sm2.encryptBase64(data, KeyType.PublicKey);
System.out.println("加密后的数据：" + encryptData);

// 数据解密
String decryptData = sm2.decryptStr(encryptData, KeyType.PrivateKey);
System.out.println("解密后的数据：" + decryptData);
```

## 指定密钥
```
String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEVVOMr5V07ERYdGH2NMngELUpaKb4s6klaiJtbKymrb/AeVNJXbCvC0cGErFa0YRI0xGfAg0/pvvLI4CYwJZ1lA==";
String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQg25OkJAhxSWh/8VNyiPyddRQcgXYGZ3PuEWwxQfCqkiigCgYIKoEcz1UBgi2hRANCAARVU4yvlXTsRFh0YfY0yeAQtSlopvizqSVqIm1srKatv8B5U0ldsK8LRwYSsVrRhEjTEZ8CDT+m+8sjgJjAlnWU";

SM2 sm2 = new SM2(Base64.decode(privateKey),Base64.decode(publicKey));

// 数据加密
String data = "Hello, SM2!";
String encryptData = sm2.encryptBase64(data, KeyType.PublicKey);
System.out.println("加密后的数据：" + encryptData);

// 数据解密
String decryptData = sm2.decryptStr(encryptData, KeyType.PrivateKey);
System.out.println("解密后的数据：" + decryptData);
```
