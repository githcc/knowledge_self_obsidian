## AES使用

### /ECB/PKCS5Padding 

``` java

String content = "test中文";

// 随机生成密钥
byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

// 构建
AES aes = SecureUtil.aes("1234567812345678".getBytes());
//        AES aes = SecureUtil.aes(key);

// 加密
byte[] encrypt = aes.encrypt(content);
// 解密
byte[] decrypt = aes.decrypt(encrypt);

// 加密为16进制表示
String encryptHex = aes.encryptHex(content);
// 解密为字符串
String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

System.out.println(encryptHex);
System.out.println(decryptStr);
```
### /CBC/PKCS5Padding

``` java

String content = "test中文";

// 构建
AES aes = new AES(Mode.CTS, Padding.PKCS5Padding, "0CoJUm6Qyw8W8jud".getBytes(), "0102030405060708".getBytes());

// 加密
byte[] encrypt = aes.encrypt(content);
// 解密
byte[] decrypt = aes.decrypt(encrypt);

// 加密为16进制表示
String encryptHex = aes.encryptHex(content);
// 解密为字符串
String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

System.out.println(encryptHex);
System.out.println(decryptStr);
```
