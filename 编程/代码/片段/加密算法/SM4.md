## 基础使用
```
String content = "test中文";
SymmetricCrypto sm4 = SmUtil.sm4();

String encryptHex = sm4.encryptHex(content);
String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

System.out.println(encryptHex);
System.out.println(decryptStr);
```

## 自定义密钥
```
// 自定义密钥
String encryptKey = "11HDESAAHIHHUGDZ";
byte[] key = encryptKey.getBytes();

// 构建
SymmetricCrypto sm4 = new SymmetricCrypto("SM4", key);

// 加密
String content = "test中文";
byte[] encrypt = sm4.encrypt(content);

// 打印加密后的内容
System.out.println("加密后的数据转base64：" + Base64.encode(encrypt));

// 解密
byte[] decrypt = sm4.decrypt(encrypt);

// 打印解密后的内容
System.out.println("解密后的数据：" + new String(decrypt));
```