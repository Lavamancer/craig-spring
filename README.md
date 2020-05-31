# Spring Boot despliegue en Centos7

1. Instalamos Centos7
```bash
sudo yum -y update
sudo yum -y install epel-release git nmap
curl -fsSL https://get.docker.com/ | sh
sudo systemctl start docker
sudo systemctl enable docker
sudo yum install -y java-1.8.0-openjdk java-1.8.0-openjdk-devel
```

2. Creamos los directorios
mkdir /root/craig
mkdir /root/craig/git
mkdir /root/craig/mysql
mkdir /root/craig/project

3. Creamos la network
```sh
docker network create craig 
```

4. Levantamos la base de datos
```bash
docker run --name craigdb -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=craigdb --restart always --network craig -v /root/craig/mysql:/var/lib/mysql mariadb --character-set-server=utf8 --collation-server=utf8_general_ci
```

5. Configuramos el hook de Git
```bash
touch /root/craig/git/hooks/post-receive
chmod a+x /root/craig/git/hooks/post-receive
vi /root/craig/git/hooks/post-receive
```

6. Añadimos el siguiente script al hook
```bash
#!/usr/bin/env bash
rm -rf /root/craig/project
git clone -b master /root/craig/git /root/craig/project
bash -x /root/craig/project/gradle/bash/deploy.sh
```

7. Añadir un remote de Git en tu proyecto local de Spring
```bash
git remote add prod ssh://root@11.11.11.11:/root/craig/git
```

8. Hacer commit y push del proyecto al nuevo remote prod para despliegue