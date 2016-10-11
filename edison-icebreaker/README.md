# EDISON Platform for Open Science

## ICE-Breaker (RESTful HPC Job Submission & Management Middleware)

![Architecture of IB](https://github.com/sp-edison/edison-2016/blob/master/edison-icebreaker/IB-arch.png)
*Architecture of IceBreaker*

## Installation (CentOS6.6)

### Prerequsite

* Some Utilities

```
yum install wget curl tar which java-1.7.0-openjdk-devel python-setuptools git zip
```

* ntp service (optional)

* MySQL
```
yum install mysql mysql-server
vi /etc/my.cnf
```

**add the following line
> character-set-server = utf8
```
[mysqld]
datadir=/var/lib/mysql
socket=/var/lib/mysql/mysql.sock
user=mysql
# Disabling symbolic-links is recommended to prevent assorted security risks
symbolic-links=0
character-set-server = utf8
```

```
service mysqld start
chkconfig mysqld on
```

**create IB_TEST DATABASE
```
/usr/bin/mysqladmin -u root password 'password'
mysql -u root -p'password'
```
> mysql\> create database IB_TEST DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

* tomcat
```
wget http://apache.tt.co.kr/tomcat/tomcat-8/v8.0.36/bin/apache-tomcat-8.0.36.tar.gz
tar xzvf apache-tomcat-8.0.36.tar.gz
cd apache-tomcat-8.0.36/webapps
rm -rf docs examples/
cd ..
cd conf
vi tomcat-users.xml
```

add the following line
> \<user username="tomcat" password="password" roles="manager-gui,manager-script" /\>
```
<!--
  <role rolename="tomcat"/>
  <role rolename="role1"/>
  <user username="tomcat" password="<must-be-changed>" roles="tomcat"/>
  <user username="both" password="<must-be-changed>" roles="tomcat,role1"/>
  <user username="role1" password="<must-be-changed>" roles="role1"/>
-->
  <user username="tomcat" password="password" roles="manager-gui,manager-script" />
```

```
cd ..
cd bin
./startup.sh
cd ../..
```

* maven 
```
wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
yum install apache-maven
mvn -version
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T01:41:47+09:00)
Maven home: /usr/share/apache-maven
Java version: 1.7.0_101, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-1.7.0-openjdk-1.7.0.101.x86_64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "2.6.32-573.22.1.el6.x86_64", arch: "amd64", family: "unix"
```

* IB (ICE-Breaker) checkout
```
git clone https://github.com/sp-edison/edison-2016.git
cd edison-2016/edison-icebreaker
# copy util file to cluster head node
scp pbs-cores localhost:/usr/local/bin/pbs-cores

# copy util file to cluster head node (for HTCondor)
scp condor-cores localhost:/usr/local/bin/condor-cores
```

* IB deploy
```
vi pom.xml
```

**add one jar dependencies to pom.xml
```
        <dependency>
            <groupId>org.kie.modules</groupId>
            <artifactId>org-apache-commons-exec</artifactId>
            <version>6.4.0.Final</version>
            <type>pom</type>
        </dependency>

        <!-- Copy from here -->
        <dependency>
              <groupId>org.opennebula.client</groupId>
              <artifactId>org.opennebula.client</artifactId>
              <version>1.0</version>
              <scope>system</scope>
              <systemPath>/root/edison-2016/edison-icebreaker/src/main/webapp/WEB-INF/lib/org.opennebula.client.jar</systemPath>
        </dependency>
```

```
mvn -Ptest tomcat7:redeploy
```


* IB configuration

** DB:

cat src/main/resources-test/WEB-INF/config/rest.properties
```
app.jdbc.driverClassName=com.mysql.jdbc.Driver
app.jdbc.url=jdbc:mysql://localhost:3306/IB_TEST
app.jdbc.username=root
app.jdbc.password=password
app.jdbc.maxActive=8192
app.jdbc.maxIdle=32
```

** LOG:

cat src/main/resources-test/WEB-INF/config/log4j.properties
```
log4j.rootLogger = INFO, ecloud
log4j.appender.ecloud = org.apache.log4j.rolling.RollingFileAppender
log4j.appender.ecloud.File = /root/LOG/logfile.log
log4j.appender.ecloud.RollingPolicy = org.apache.log4j.rolling.TimeBasedRollingPolicy
log4j.appender.ecloud.RollingPolicy.ActiveFileName = /root/LOG/logfile.log
log4j.appender.ecloud.RollingPolicy.FileNamePattern = /root/LOG/logfile.%d{yyyy-MM-dd}.gz
log4j.appender.ecloud.layout = org.apache.log4j.PatternLayout
log4j.appender.ecloud.layout.ConversionPattern = %d{ABSOLUTE} %5p %c{1}:%L - %m%n
```

** admin pw:

cat src/main/resources/config.common.ini
```
##################################################################
####### ADMIN. CONFIGURATION
##################################################################
user.admin.id=admin
user.admin.password=password
user.admin.email=root@gmail.com
```

** cluster setting:

cat src/main/resources-test/WEB-INF/classes/config.ini
```
####### TEST
resources=EDISON-TEST:localhost:22:OpenPBS:3.0.5:batch:2:/EDISON/:ko:true

####### HTCondor
resources=CONDOR-TEST:localhost:22:Condor:7.8.8:dev:48:/EDISON/:ko:true
```


* TEST
```
easy_install pip
pip install requests
python test_script/login.py
```


* Check LOG

```
tail -f /root/LOG/logfile.log
```



* torque installation (If needed)

```
yum install libxml2-devel openssl-devel gcc gcc-c++ libtool boost-devel
git clone https://github.com/adaptivecomputing/torque.git -b 5.0.0
cd torque
./autogen.sh
./configure
make -j4 2>&1 | tee make.log
make install

#Configure Torque on headnode
echo $HOSTNAME > /var/spool/torque/server_name
echo "/usr/local/lib" > /etc/ld.so.conf.d/torque.conf
ldconfig
ldconfig -v | grep torque

cp contrib/init.d/trqauthd /etc/init.d/
chkconfig trqauthd on
service trqauthd start

./torque.setup root
qterm

vi /var/spool/torque/server_priv/nodes
localhost np=4

cp contrib/init.d/pbs_server /etc/init.d/
chkconfig pbs_server on
service pbs_server start

#Install Torque MOMs on compute nodes
make packages
./torque-package-mom-linux-x86_64.sh --install
cp contrib/init.d/pbs_mom /etc/init.d/
chkconfig pbs_mom on
service pbs_mom start

#Configure the scheduler
cp contrib/init.d/pbs_sched /etc/init.d/
chkconfig pbs_sched on
service pbs_sched start
```

```
pbsnodes -a
v6a197
     state = free
     power_state = Running
     np = 4
     ntype = cluster
     status = rectime=1466470937,cpuclock=Fixed,varattr=,jobs=,state=free,netload=1338923997,gres=,loadave=0.13,ncpus=4,physmem=3973948kb,availmem=3214180kb,totmem=4809528kb,idletime=7,nusers=0,nsessions=0,uname=Linux v6a197 2.6.32-573.22.1.el6.x86_64 #1 SMP Wed Mar 23 03:35:39 UTC 2016 x86_64,opsys=linux
     mom_service_port = 15002
     mom_manager_port = 15003
```


* ssh key copy (for password-less connection: IB and cluster head node)
```
ssh-keygen -t rsa
ssh-copy-id localhost
```

* mount shared storage


* Reference
maven install: http://xxun.tistory.com/233

<p>
EDISON is free and open source and it always will be! It is licensed under the <a href="http://www.gnu.org/licenses/lgpl-2.1.html">GNU Lesser General Public License</a>.
</p>
