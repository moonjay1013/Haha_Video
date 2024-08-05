# Getting Started

### SpringBoot程序

技术栈：

SpringBoot、Maven项目管理、Swagger DOC、MySQL、JPA、Thymeleaf模板引擎、Druid

---

TODO:

- [X] Docker deployment
- [X] Build .jar

<details open>
  
<summary>Build JAR</summary>
  
Maven: `pom.xml` add `maven-jar-plugin` configuration：
```xml
<plugin>
   <groupId>org.apache.maven.plugins</groupId>
   <artifactId>maven-jar-plugin</artifactId>
   <version>VERSION</version>
   <configuration>
       <mainClass>com.moon.HahaVideoApplication</mainClass>
   </configuration>
</plugin>
```

![](Maven_JAR_CONF.png)

Test: `java -jar /path/to/moon-0.0.1-SNAPSHOT.jar`
  
</details>

<details open>
<summary>Docker Deployment</summary>


```bash
docker 
```

</details>
