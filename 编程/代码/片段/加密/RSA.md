## 生成密钥
```
KeyPair pair = SecureUtil.generateKeyPair("RSA");
System.out.println(Base64.encode(pair.getPrivate().getEncoded()));
System.out.println(Base64.encode(pair.getPublic().getEncoded()));
```

## 不指定密钥
```
RSA rsa = new RSA();

//获得私钥
rsa.getPrivateKey();
String privateKeyBase64 = rsa.getPrivateKeyBase64();
//获得公钥
rsa.getPublicKey();
String publicKeyBase64 = rsa.getPublicKeyBase64();

System.out.println(privateKeyBase64);
System.out.println(publicKeyBase64);

//公钥加密，私钥解密
byte[] encrypt = rsa.encrypt(StrUtil.bytes("test中文", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);

System.out.println(Base64.encode(encrypt));
System.out.println(new String(decrypt));

//私钥加密，公钥解密
encrypt = rsa.encrypt(StrUtil.bytes("test中文", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
decrypt = rsa.decrypt(encrypt, KeyType.PublicKey);

System.out.println(Base64.encode(encrypt));
System.out.println(new String(decrypt));
```


## 指定密钥
```
String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAidR+xqrPqSAq3cCdOMJPQPfG0thiaASyd0FjGoeb9Ehnf2WRbq9h9z/ritkxxwddSGY8wRomSTXLKS9rCEN8aty39XHCLrSRSqnyuQ3JRaatydr0olx1STuw9IvFuCeAwQPKKGi5Eq5Gmh5TFzviHIXg33odiTSGEsD683EI28QEHDNnW2egzTeuCBYekrQiPg1TOz/9EbVDtnwIjPt3Ve5bsmRrOgNEfPVO0wXHXAKqjwyVtIc4HT0uQgF+YIHT/DRFJa+hn/fzk7bMG8Lw6gsIw4APKcslWeoGHDbi+M9NGXHOG5vd2Q8DeJA/9QOgz+tSisG5iO90RHa7UUQU1wIDAQAB";
String privateKey = "MIIEowIBAAKCAQEAidR+xqrPqSAq3cCdOMJPQPfG0thiaASyd0FjGoeb9Ehnf2WRbq9h9z/ritkxxwddSGY8wRomSTXLKS9rCEN8aty39XHCLrSRSqnyuQ3JRaatydr0olx1STuw9IvFuCeAwQPKKGi5Eq5Gmh5TFzviHIXg33odiTSGEsD683EI28QEHDNnW2egzTeuCBYekrQiPg1TOz/9EbVDtnwIjPt3Ve5bsmRrOgNEfPVO0wXHXAKqjwyVtIc4HT0uQgF+YIHT/DRFJa+hn/fzk7bMG8Lw6gsIw4APKcslWeoGHDbi+M9NGXHOG5vd2Q8DeJA/9QOgz+tSisG5iO90RHa7UUQU1wIDAQABAoIBAAhhN337p5l4P7LwwX5QbgIcrmVmS4FYe8M9YfmcchJljolT0wZAOnwOUlNERj78ByNeN+ZjoR1FXH86B09ezwMuPS76hhxR1R2NfJjcqjaGXj2OBt6SMX1M2ELd9pzuJelWQiW3zDzDBL7dBh89AE/MofHkWkRbwaUFP5yqbCf0SZY9F/utlfuTF/G+SXsYEGxcBMlgkQcKWqxxpTnrUnGq29ikfjOMJasoYfJgOdW1Jq9zwst8imhCUru+GwJ9XSCd0q9i3BNBCkD5AoGhmHLpHXvYe7MRbL9o4q6dpwKXlxpdS+jC0VjxIArnTN3iMF2b6/fg1b1zix0W+xa3s20CgYEAvSXShMOlnrjC9MBxatgWlgZXKYaNE0Ykk6NW6TkJimPzZbJM+DYNSTubo4AYJ1KTTKo0k8zLy/tnSEVOX0vDEfHnsa/2MvIDlXnE8K9nA0QTKXoW0j2pIjZ3kEaktG4L4tWnMBGQTL70a5//IVNpxVjAqoHOYRaERcITuxRP9jMCgYEAuotsqRrKB2b6ldMtYJkz/E4KtIW+CNIP2thu3odXUbhtCLqVpO8voYtMK5SUXqr1NEk8ehlgAMC9lKTJC9UVIhf8wmmUEvTxOAhzvN0kQF5TmCppv8MaFt+fr4edk/F9sUNIsDfO2DV5x2ukkdmXJI/Joq7aoljUUiiwaNKaWs0CgYEAjIfxZVrHTqoPjzD8E1oBTe3gDKY/YraWrmqJRDZwdDXWvRRAQ5pFPMfg1xVw3KZpcmhzL+zU7fUXw4ZauErd4BNPBaGq1ichqokSXZC0hKSraAGhuwq9AwJcywDxlmy8wAflc71Y7OxjRSNWtzf2Of27B/PxlgjYtcuARVrOHikCgYASWFXGR5EoqzLnew4SWt6m6FHbMO/gVDAk+HXmwm6O5dErM5Y10yPfAiDqhEEXEj7s9mrRIx+y00GRlacD19+tK6i6wcFDH/184i/nmePPxLb51unxZtFxAGrmyzJu8yfGP/StB7/6uT+Rof9cLIbVnKJaslFj99JhhgjbNiLh3QKBgAbV6dFrhOVidtt3/BbbpuOg4kQxcGph3nqSCG1R6ILHmhX/ro+11v8T37NA9p2STLz8s9OlkZ7PD84bPZnTvHAat+47iRQL464SbNFigdcN5cQ9hE/lwXHQHrbxfErfjUmpmSAfyvEOfgDPT+GaKoPZYpIBJ/4p7Ee554BudFTK";

RSA rsa = new RSA(Base64.decode(privateKey),Base64.decode(publicKey));

//公钥加密，私钥解密
byte[] encrypt = rsa.encrypt(StrUtil.bytes("test中文", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);

System.out.println(Base64.encode(encrypt));
System.out.println(new String(decrypt));
```

## 签名
```
byte[] data = "我是一段测试字符串".getBytes();
Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
//签名
byte[] signed = sign.sign(data);
//验证签名
boolean verify = sign.verify(data, signed);
System.out.println(verify);
```