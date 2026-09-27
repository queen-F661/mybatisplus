# mybatisplus 项目长期备忘

## 项目概况
- 性质：狂神说 SpringBoot + MyBatis-Plus 教学 demo（跟随教程节奏推进）。
- 技术栈：Spring Boot 4.1.1 + mybatis-plus-spring-boot4-starter 3.5.17 + MySQL（本地 mybatisplus 库，账密见 application.yml）+ Lombok + JDK 21。
- 包结构：com.example.mybatisplus（主类带 @MapperScan("com.example.mybatisplus.mapper")，实体在 pojo 包）。
- 测试在 IDEA 里用 JUnit 跑（本机无独立 mvn，命令行跑 Maven 用 IDEA 自带：D:\idea\IntelliJ IDEA 2026.2.3\plugins\maven-plugin\lib\maven3\bin\mvn.cmd，JAVA_HOME=D:\java）。

## 已踩过的坑（讲课时注意复提）
1. JDBC URL characterEncoding 参数必须填 Java 字符集名（UTF-8），不能填 MySQL 的 utf8mb4。
2. `IdType.AUTO` 依赖表列声明 AUTO_INCREMENT，建表别漏；否则报 Field 'id' doesn't have a default value。
3. MetaObjectHandler 的 strictInsertFill/strictUpdateFill 要求声明的类型与实体字段类型**完全一致**（Date vs LocalDateTime 之类不匹配会静默跳过，不报错）。
4. 时间填充推荐两边统一用 LocalDateTime；ON UPDATE CURRENT_TIMESTAMP 别贴在 create_time 上。
5. 用户惯犯坑位（见 SOUL/USER）：反条件分支、Integer 用 == 比较——review 时主动检查。

## 本机调试技巧（复用）
- DB 直连验证：python venv（C:\Users\zhy\.workbuddy\binaries\python\envs\default）+ pymysql。
- 本机 bash shim 残废；PowerShell 工具吞 stdout，可靠做法是 Out-File 写文件再用 Read 读。
