### DES使用

### /ECB/PKCS5Padding

``` java
String content = "test中文";

//随机生成密钥
byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();

//构建
//        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DES, key);
SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DES, "1234567812345678".getBytes());

//加密
byte[] encrypt = des.encrypt(content);
//解密
byte[] decrypt = des.decrypt(encrypt);

//加密为16进制表示
String encryptHex = des.encryptHex(content);
//解密为字符串
String decryptStr = des.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

System.out.println(encryptHex);
System.out.println(decryptStr);
```
### /CBC/PKCS5Padding

``` java
String content = "test中文";

//随机生成密钥
byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();

//构建
//        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DES, key);
DES des = new DES(Mode.CTS, Padding.PKCS5Padding, "0CoJUm6Qyw8W8jud".getBytes(), "01020304".getBytes());


//加密
byte[] encrypt = des.encrypt(content);
//解密
byte[] decrypt = des.decrypt(encrypt);

//加密为16进制表示
String encryptHex = des.encryptHex(content);
//解密为字符串
String decryptStr = des.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

System.out.println(encryptHex);
System.out.println(decryptStr);
``` 