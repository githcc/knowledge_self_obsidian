## 目录说明
1. 用于存放一些经常使用的提问语句，将来成为工作流的一部分

## 编程场景
1. 如果希望gpt进行造数
   1. 等会我输入一个表结构，你生成200w条数据，要求使用循环，使用存储过程
   2. 请修改sql语句，插入语句前开启事务，全部插入完毕后关闭事务
   ```
   DELIMITER //
   
   CREATE PROCEDURE GenerateUserData()
   BEGIN
       DECLARE i INT DEFAULT 0;
   
       START TRANSACTION; -- 开启事务
   
       WHILE i < 200000 DO
           -- 生成随机姓名
           SET @first_names = 'John,Mary,David,Sophia,Michael,Emma,James,Olivia,Benjamin,Isabella';
           SET @names_array = SUBSTRING_INDEX(@first_names, ',', FLOOR(1 + RAND() * 10));
           SET @name = TRIM(SUBSTRING_INDEX(@names_array, ',', -1));
   
           -- 生成随机年龄（18到60岁之间）
           SET @age = FLOOR(18 + RAND() * 43);
   
           -- 插入随机数据
           INSERT INTO `user` (name, age, insert_time, update_time) 
           VALUES (@name, @age, NOW(), NOW());
   
           SET i = i + 1;
       END WHILE;
   
       COMMIT; -- 关闭事务
   END //
   
   DELIMITER ;
   
   ```
2. 