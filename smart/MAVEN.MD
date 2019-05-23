<groupId>...</groupId> <!--指定组名,例如：org.apache.maven-->
<artifactId>...</artifactId> <!--指定工程名例如：appfuse-->
<version>...</version> <!--指定版本号 -->
<packaging>...</packaging> <!--当前的核心包装值是: pom, jar, maven-plugin, ejb, war, ear, rar, par-->
<classifier>...</classifier> <!--项目显示为GroupID:artifactId:packaging:classifier:version-->
<name>...</name> <!--一些无关太重要的东西，用户描述你的项目的名字,可选的-->
<url>...</url> <!--暂时不知何物，貌似无关重要，只是写明开发团队的网站，可选的-->

	<dependencies>...</dependencies> <!--例子：    <dependency>

      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.0</version>
      <type>jar</type>
      <scope>test</scope>
      <optional>true</optional>
    </dependency>
groupId，artifactId和version这个三组合标示依赖的具体工程，而且这个依赖工程必须是maven中心包管理范围内的。如果碰上非开源包，maven支持不了这个包，那么则有三种方法处理：1.本地安装这个插件install plugin例如：
mvn install:install-file -Dfile=non-maven-proj.jar -DgroupId=some.group -DartifactId=non-maven-proj -Dversion=1
2.创建自己的Repositories并且部署这个包，使用类似上面的deploy:deploy-file 命令3.设置scope为system，并且指定系统路径

dependency里面的classifier，用于区分从同一个pom编译出来的但是内容不同的同名包，例如同一个工程编译出两个artifact，一个支持jdk1.5一个支持jdk1.4，那么就可以使用这个来命名为jdk15和jdk14来区分，它如果出现在包名中，那么它必须跟在版本号后。还有一种情况是将一个工程的一些次要artifact附到主要artifact中，就可以使用这个来区分，例如一个工程产生source，javadoc，class三种东西，那么就可以使用不同的classifier来分别标识这些东西 
dependency里面的type，默认为jar，类型，常用如：jar，ejb-client，test-jar，可以设置plugins中的extensions值为true后在增加新类型
dependency里面的scope，指定classpath，可以为：compile（默认的，compile scope在所有classpaths内有效，这些dependencies将会传播到项目中。provided：指示jdk或者某个容器可以提供他，它只在compilation和test的classpaths有效，而且不会传播的。runtime：指示这个dependency在编译过程是不必要的，但是执行需要，在test和runtime的classpaths有效，在compile的classpaths无效。test：指示这个dependency在一般程序运行是无效的，但是在test的compilation和execution是有效的，system则跟provided类似，但是这种dependency必须人工明确地制定。这种依赖不会在repository中查找。
dependency里面的systemPath：只在dependency的scope声明为system的时候才有用除，否则，build的过程将会失败。路径必须是绝对的，所以最好使用property来声明机器的特定路径。
dependency里面的optional：如果工程本身是一个dependency那么就标记为optional，例如X需要A，A需要B，那么X只需要optional的B，则B在X中就是optional声明的了
dependency里面的exclusions：如果X需要A，A包含B依赖，那么X可以声明不要B依赖，只要在exclusions中声明exclusion。optional是不会install或者使用B，而exclusion是将B从依赖树中是删除。例如appfuse不想使用hibernate，但是appfuse是集成hibernate的，所以就排除掉：
            <exclusions>
                <exclusion>
                    <groupId>org.appfuse</groupId>
                    <artifactId>appfuse-hibernate</artifactId>
                </exclusion>
            </exclusions>-->

<!--Inheritance：如果一个工程是pareent或者aggregation（即mutil-module的）的，那么必须在packaging赋值pom。child工程从parent继承的包括：dependencies，developers and contributors，plugin lists，reports lists，plugin execution with matching ids，plugin configuration-->
<parent>...</parent> <!--参照下面例子：relativePath是可选的，maven会首先搜索这个地址，在搜索本地和远程repositories之前
  <parent>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>my-parent</artifactId>
    <version>2.0</version>
    <relativePath>../my-parent</relativePath>
  </parent>
-->
 <dependencyManagement>...</dependencyManagement>  <!--用于帮助管理children的dependencies。例如如果parent使用dependencyManagement定义一个dependencyon junit:junit:4.0，那么它的children就可以只引用groupId和artifactId，而version就可以通过parent来设置。好处就是集中管理依赖详情-->
<modules>...</modules><!--对于多模块project，outer-module没有必要考虑inner-module的dependencies，当列出modules的时候。modules的顺序是不重要的，因为maven会自动根据依赖关系来拓扑排序，modules例子：
    <module>my-project<module>
    <module>another-project<module>
-->
<properties>...</properties> <!--参照http://www.blogjava.net/jianyue/articles/maven2_setting.html，是一样的-->
<!-- Build Settings --><build>...</build> <!--
defaultGoal：默认的目标，必须跟命令行上的参数相同例如jar:jar，或者与时期（parse）相同，例如install
directory：指定build target目标的目录，默认为${basedir}/target，即项目根目录下的target
finalName：指定去掉后缀名后的工程名字，例如：默认为${artifactId}-${version}
filters：用于定义指定filter属性文件位置，例如filter元素赋值filters/filter1.properties，那么这个文件里面就可以定义name=value对，这个name=value对的值就可以在工程pom中通过${name}引用，默认的filter目录是${basedir}/src/main/filters/
resources：描述工程中资源的位置
      <resource>
        <targetPath>META-INF/plexus</targetPath>
        <filtering>false</filtering>
        <directory>${basedir}/src/main/plexus</directory>
        <includes>
          <include>configuration.xml</include>
        </includes>
        <excludes>
          <exclude>**/*.properties</exclude>
        </excludes>
      </resource>
targetPath：指定build资源到哪个目的目录，默认是base directory
filtering：指定是否将filter文件（即上面说的filters里定义的*.property文件）的变量值在这个resource文件有效，例如上面就指定那些变量值在configuration文件无效
directory：指定属性文件的目录，build的过程需要找到它，并且将其放到targetPath下。默认的directory是${basedir}/src/main/resources
includes：指定包含文件的patterns，符合样式并且在directory目录下的文件将会是包含进project的资源文件
excludes：指定不包含在内的patterns，如果includes与excludes有冲突，那么excludes胜利，那些符合冲突样式的文件还是不会包含进来的
testResources：这个模块包含测试资源元素，其内容定义与resources类似。不同的一点是默认的测试资源路径是${basefir}/src/test/resources，测试资源是不部署的。
-->
<plugins>...</plugins> <!--
<plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>2.0</version>
        <extensions>false</extensions>
        <inherited>true</inherited>
        <configuration>
          <classifier>test</classifier>
        </configuration>
        <dependencies>...</dependencies>
        <executions>...</executions>
      </plugin>

extensions：true or false，决定是否要load这个plugin的extensions
inherited：是否让子pom继承true or false
configuration：通常用于私有不开源的plugin，不能够详细了解plugin的内部工作原理，但使plugin满足需要满足的properties
dependencies：与pom基础的dependencies的结构和功能都相同，只是plugin的dependencies用于plugin，而pom的dependencies用于本身这个工程，在plugin的dependencies主要用于改变plugin原来的dependencies，例如排除一些用不到的dependency或者修改dependency的版本等，详细请看pom基础的dependencies
executions：plugin也有很多个目标，每个目标具有不同的配置，executions就是设定plugin的目标
          <execution>
            <id>echodir</id>
            <goals>
              <goal>run</goal>
            </goals>
            <phase>verify</phase>
            <inherited>false</inherited>
            <configuration>
              <tasks>
                <echo>Build Dir: ${project.build.directory}</echo>
              </tasks>
            </configuration>
          </execution>
id：标识符
goals：里面列出一系列的goal元素，例如上面的run goal
phase：声明goals执行的时期，例如：verify
inherited：是否传递execution到子pom
configuration：设置execution下列表的goals 的设置，而不是plugin所有goals的设置
plugin Management: 用于管理plugin，与pom build里的plugins区别是，这里的plugin是列出来，然后让子pom来决定是否引用的，例如后面的引用方法。
<pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-jar-plugin</artifactId>
          <version>2.2</version>
          <executions>
            <execution>
              <id>pre-process-classes</id>
              <phase>compile</phase>
              <goals>
                <goal>jar</goal>
              </goals>
              <configuration>
                <classifier>pre-process</classifier>
              </configuration>
            </execution>
          </executions>
        </plugin>
      </plugins>
    </pluginManagement>
子pom引用方法：
在pom的build里的plugins引用：
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
      </plugin>
    </plugins>
build 里面的Directories：
    <sourceDirectory>${basedir}/src/main/java</sourceDirectory>
    <scriptSourceDirectory>${basedir}/src/main/scripts</scriptSourceDirectory>
    <testSourceDirectory>${basedir}/src/test/java</testSourceDirectory>
    <outputDirectory>${basedir}/target/classes</outputDirectory>
    <testOutputDirectory>${basedir}/target/test-classes</testOutputDirectory>
这几个元素只在parent bulid element里面定义，他们设置多种路径结构，他们并不在profile里，所以不能通过profile来修改
build 里面的Extensions：
它们是一系列build过程中要使用的产品，他们会包含在running bulid‘s classpath里面。他们可以开启extensions，也可以通过提供条件来激活plugins。简单来讲，extensions是在build过程被激活的产品
    <extensions>
      <extension>
        <groupId>org.apache.maven.wagon</groupId>
        <artifactId>wagon-ftp</artifactId>
        <version>1.0-alpha-3</version>
      </extension>
    </extensions>
-->
 <reporting>...</reporting> <!--
reporting包含site生成阶段的一些元素，某些maven  plugin可以生成reports并且在repoting下配置。例如javadoc，maven site等，在reporting下配置reprot plugin的方法与build几乎一样，最不同的是：build的plug-in goals在executions下设置，而reporting的configures goals在reportset。更微妙的不同是reporting下的plugin configuration works as a build plugin configuration，但是相反是不对的（即build plugin configuration does not affect a reporting plugin）。
excludeDefaults：是否排除site generator默认产生的reports
outpoutDirectory，默认的dir变成：${basedir}/target/site 
Report sets：设置execution goals，相当于build里面的executions。不同的是不能够bind a report to another phase，只能够是site
<reporting>
    <plugins>
      <plugin>
        ...
        <reportSets>
          <reportSet>
            <id>sunlink</id>
            <reports>
              <report>javadoc</report>
            </reports>
            <inherited>true</inherited>
            <configuration>
              <links>
                <link>http://java.sun.com/j2se/1.5.0/docs/api/</link>
              </links>
            </configuration>
          </reportSet>
        </reportSets>
      </plugin>
    </plugins>
  </reporting>
reporting里面的厄reportSets和build里面的executions的作用都是控制pom的不同粒度去控制build的过程，我们不单要配置plugins，还要配置那些plugins单独的goals。
-->
<!-- More Project Information -->
<description>...</description> 
project的描述
<inceptionYear>...</inceptionYear> 
工程的初始时间
<licenses>...</licenses>
<licenses>
  <license>
    <name>Apache 2</name>
    <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    <distribution>repo</distribution>
    <comments>A business-friendly OSS license</comments>
  </license>
</licenses>
<!--列出本工程直接的licenses，而不要列出dependencies的licenses，

name, url and comments: are self explanatory, and have been encountered before in other capacities. The fourth license element is:
distribution: This describes how the project may be legally distributed. The two stated methods are repo (they may be downloaded from a Maven repository) or manual (they must be manually installed).
-->
<organization>...</organization>
<!--
   <organization>
    <name>Codehaus Mojo</name>
    <url>http://mojo.codehaus.org</url>
  </organization>
很多工程都受到某些组织运行，这里设置基本信息
-->
<developers>...</developers>
<!--例如：一个开发者可以有多个roles，properties是
  <developers>
    <developer>
      <id>eric</id>
      <name>Eric</name>
      <email>eredmond@codehaus.org</email>
      <url>http://eric.propellors.net</url>
      <organization>Codehaus</organization>
      <organizationUrl>http://mojo.codehaus.org</organizationUrl>
      <roles>
        <role>architect</role>
        <role>developer</role>
      </roles>
      <timezone>-6</timezone>
      <properties>
        <picUrl>http://tinyurl.com/prv4t</picUrl>
      </properties>
    </developer>
  </developers>
-->
<contributors>...</contributors>
<!--跟developer差不多，只是contributors是副的工作人员，不过良好工程应该需要更多的contributors而不是developer，例如：
  <contributors>
    <contributor>
      <name>Noelle</name>
      <email>some.name@gmail.com</email>
      <url>http://noellemarie.com</url>
      <organization>Noelle Marie</organization>
      <organizationUrl>http://noellemarie.com</organizationUrl>
      <roles>
        <role>tester</role>
      </roles>
      <timezone>-5</timezone>
      <properties>
        <gtalk>some.name@gmail.com</gtalk>
      </properties>
    </contributor>
  </contributors>
-->
<!-- Environment Settings --> <issueManagement>...</issueManagement>
 <!--定义defect tracking system缺陷跟踪系统，比如有（bugzilla,testtrack,clearquest等），例如：
  <issueManagement>
    <system>Bugzilla</system>
    <url>http://127.0.0.1/bugzilla/</url>
  </issueManagement>
-->
<ciManagement>...</ciManagement> 
<!--Continuous Integration Management：设置自动build系统，一些集成程序包括continuum,Cruise control等。例如：

<ciManagement>
    <system>continuum</system>
    <url>http://127.0.0.1:8080/continuum</url>
    <notifiers>
      <notifier>
        <type>mail</type>
        <sendOnError>true</sendOnError>
        <sendOnFailure>true</sendOnFailure>
        <sendOnSuccess>false</sendOnSuccess>
        <sendOnWarning>false</sendOnWarning>
        <configuration><address>continuum@127.0.0.1</address></configuration>
      </notifier>
    </notifiers>
  </ciManagement>

maven捕获一些经常重发生的配置，在notifier元素里配置。A notifier is the manner in which people are notified of certain build statuses. In the following example, this POM is setting a notifier of type mail (meaning email), and configuring the email address to use on the specified triggers sendOnError, sendOnFailure, and not sendOnSuccess or sendOnWarning.
-->
<mailingLists>...</mailingLists>
<!--例如：
  <mailingLists>
    <mailingList>
      <name>User List</name>
      <subscribe>user-subscribe@127.0.0.1</subscribe>
      <unsubscribe>user-unsubscribe@127.0.0.1</unsubscribe>
      <post>user@127.0.0.1</post>
      <archive>http://127.0.0.1/user/</archive>
      <otherArchives>
        <otherArchive>http://base.google.com/base/1/127.0.0.1</otherArchive>
      </otherArchives>
    </mailingList>
  </mailingLists>
看不懂解释啊，照搬吧：

subscribe, unsubscribe: There elements specify the email addresses which are used for performing the relative actions To subscribe to the user list above, a user would send an email to user-subscribe@127.0.0.1.
archive: This element specifies the url of the archive of old mailing list emails, if one exists. If there are mirrored archives, they can be specified under otherArchives.
post: The email address which one would use in order to post to the mailing list. Note that not all mailing lists have the ability to post to (such as a build failure list). 
-->
<scm>...</scm>
<!--例如：
  <scm>
    <connection>scm:svn:http://127.0.0.1/svn/my-project</connection>
    <developerConnection>scm:svn:https://127.0.0.1/svn/my-project</developerConnection>
    <tag>HEAD</tag>
    <url>http://127.0.0.1/websvn/my-project</url>
  </scm>
connection, developerConnection: 都是连接字符串，其中后者是具有write权限的scm连接，常用的scm工具包括cvs与subversion，还有其他scms，url的字符串格式是：scm:[provider]:[provider_specific]，例如cvs的是scm:cvs:pserver:127.0.0.1:/cvs/root:my-project
tag：说明project所在的目录tag，默认是HEAD，表示根目录
url：公开的可浏览repository
-->

<prerequisites>...</prerequisites>
 <!--首要条件，如果不满足，maven会在事件开始之前失败，在pom4.0，唯一的首要条件是maven元素-->
<repositories>...</repositories>
<!--要成为maven2的repository artifact，必须具有pom文件在$BASE_REPO/groupId/artifactId/version/artifactId-version.pom
BASE_REPO可以是本地，也可以是远程的。repository元素就是声明那些去查找的repositories
默认的central Maven repository在http://repo1.maven.org/maven2/；
<repositories>
    <repository>
      <releases>
        <enabled>false</enabled>
        <updatePolicy>always</updatePolicy>
        <checksumPolicy>warn</checksumPolicy>
      </releases>
      <snapshots>
        <enabled>true</enabled>
        <updatePolicy>never</updatePolicy>
        <checksumPolicy>fail</checksumPolicy>
      </snapshots>
      <id>codehausSnapshots</id>
      <name>Codehaus Snapshots</name>
      <url>http://snapshots.maven.codehaus.org/maven2</url>
      <layout>default</layout>
    </repository>
  </repositories>
release和snapshots：是artifact的两种policies，pom可以选择那种政策有效。
enable：本别指定两种类型是否可用，true or false
updatePolicy:说明更新发生的频率always 或者 never 或者 daily（默认的）或者 interval:X（X是分钟数）
checksumPolicy：When Maven deploys files to the repository, it also deploys corresponding checksum files. Your options are to ignore, fail, or warn on missing or incorrect checksums.
layout：maven1.x与maven2有不同的layout，所以可以声明为default或者是legacy（遗留方式maven1.x）。
-->
 <pluginRepositories>...</pluginRepositories>
<!--与Repositories具有类似的结构，只是Repositories是dependencies的home，而这个是plugins 的home。-->
<distributionManagement>...</distributionManagement>
<!--管理distribution和supporting files。
downloadUrl：是其他项目为了抓取本项目的pom’s artifact而指定的url，就是说告诉pom upload的地址也就是别人可以下载的地址。
status：这里的状态不要受到我们的设置，maven会自动设置project的状态，有效的值：none：没有声明状态，pom默认的；converted：本project是管理员从原先的maven版本convert到maven2的；partner：以前叫做synched，意思是与partner repository已经进行了同步；deployed：至今为止最经常的状态，意思是制品是从maven2 instance部署的，人工在命令行deploy的就会得到这个；verified：本制品已经经过验证，也就是已经定下来了最终版。
repository：声明deploy过程中current project会如何变成repository，说明部署到repository的信息。
    <repository>
      <uniqueVersion>false</uniqueVersion>
      <id>corp1</id>
      <name>Corporate Repository</name>
      <url>scp://repo1/maven2</url>
      <layout>default</layout>
    </repository>
    <snapshotRepository>
      <uniqueVersion>true</uniqueVersion>
      <id>propSnap</id>
      <name>Propellors Snapshots</name>
      <url>sftp://propellers.net/maven</url>
      <layout>legacy</layout>
    </snapshotRepository>
id, name:：唯一性的id，和可读性的name
uniqueVersion：指定是否产生一个唯一性的version number还是使用address里的其中version部分。true or false
url：说明location和transport protocol
layout：default或者legacy-->
<site><!---声明如何部署project‘s 的site和document->
<!--例如：
    <site>
      <id>mojo.website</id>
      <name>Mojo Website</name>
      <url>scp://beaver.codehaus.org/home/projects/mojo/public_html/</url>
    </site>
与上面repository的元素相同意思
-->
Relocation：
<!-- 说明工程的变更，在这里警告使用者当心工程被重命名了等信息。重新指定id和名称，并且写个message注明备注   <relocation>
      <groupId>org.apache</groupId>
      <artifactId>my-project</artifactId>
      <version>1.0</version>
      <message>We have moved the Project under Apache</message>
    </relocation>
-->
<profiles>...</profiles>
<!--pom4.0的一个新特性就是具有根据environment来修改设置的能力。

它包含可选的activation（profile的触发器）和一系列的changes。例如test过程可能会指向不同的数据库（相对最终的deployment）或者不同的dependencies或者不同的repositories，并且是根据不同的JDK来改变的。那么结构如下：

  <profiles>
    <profile>
      <id>test</id>
      <activation>...</activation>
      <build>...</build>
      <modules>...</modules>
      <repositories>...</repositories>
      <pluginRepositories>...</pluginRepositories>
      <dependencies>...</dependencies>
      <reporting>...</reporting>
      <dependencyManagement>...</dependencyManagement>
      <distributionManagement>...</distributionManagement>
    </profile>
  </profiles>
Activation：
触发这个profile的条件配置如下例：（只需要其中一个成立就可以激活profile，如果第一个条件满足了，那么后面就不会在进行匹配。
    <profile>
      <id>test</id>
      <activation>
        <activeByDefault>false</activeByDefault>
        <jdk>1.5</jdk>
        <os>
          <name>Windows XP</name>
          <family>Windows</family>
          <arch>x86</arch>
          <version>5.1.2600</version>
        </os>
        <property>
          <name>mavenVersion</name>
          <value>2.0.3</value>
        </property>
        <file>
          <exists>${basedir}/file2.properties</exists>
          <missing>${basedir}/file1.properties</missing>
        </file>
      </activation>

-->
激活profile的方法有多个：setting文件的activeProfile元素明确指定激活的profile的ID，在命令行上明确激活Profile用-P flag 参数
查看某个build会激活的profile列表可以用：mvn help:active-profiles
</project>