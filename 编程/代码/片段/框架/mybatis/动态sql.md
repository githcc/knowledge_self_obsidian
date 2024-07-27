```
<!-- 定义 SQL 片段 -->
<sql id="baseColumns">
    id, username, email
</sql>

<!-- 定义查询方法 -->
<select id="selectUsers" resultType="User">
    SELECT
    <!-- 引用 SQL 片段 -->
    <include refid="baseColumns"/>
    FROM users
    <where>
        <!-- 使用 <if> 进行条件判断 -->
        <if test="username != null">
            AND username = #{username}
        </if>
        <if test="email != null">
            AND email = #{email}
        </if>
    </where>
</select>

<!-- 定义插入方法 -->
<insert id="insertUser" parameterType="User">
    INSERT INTO users(username, email)
    VALUES(#{username}, #{email})
</insert>

<!-- 定义更新方法 -->
<update id="updateUser" parameterType="User">
    UPDATE users
    SET
    <if test="username != null">
        username = #{username},
    </if>
    <if test="email != null">
        email = #{email},
    </if>
    WHERE id = #{id}
</update>

<!-- 定义删除方法 -->
<delete id="deleteUser" parameterType="User">
    DELETE FROM users
    WHERE id = #{id}
</delete>

<!-- 定义删除方法，使用map传参 -->
<delete id="deleteUser" parameterType="java.util.Map">
    DELETE FROM users
    WHERE id = #{id}
</delete>
```