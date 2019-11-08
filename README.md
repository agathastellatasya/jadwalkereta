# **TUGAS BESAR IF 5021 ALGORITMA PEMROGRAMAN B**
```
Kelompok 3:
1. 23518034 - Muhamad Fiqri Ashidiqqi
2. 23519004 - Muhammad Husni Mubarak
3. 23519005 - Triana Dewi Salma
4. 23519015 - Muhammad Adrinta Abdurrazzaq
5. 23519017 - Tasya
```

## **INSTALL DAN SETUP JDK DAN MAVEN**

1. Download Maven di [sini](https://maven.apache.org/download.cgi).
2. Extract file Maven.
3. Tambahkan 'MAVEN_HOME' dan 'M2_HOME' variable di Environment Variable dengan variable value menunjuk ke folder hasil extract pada step nomor 2.
4. Install JDK dan tambahkan 'JAVA_HOME' di Environment Variable (variable value: path ke JDK install folder).
5. Masukkan 'maven/bin' di dalam variabel PATH.
6. Pastikan Maven sudah terinstall dengan mengetikkan `mvn --version` pada command prompt.

## **MENJALANKAN PROGRAM**

1. Masuk ke dalam folder **jadwalkereta**.
2. Buka command prompt pada folder tersebut, kemudian ketikkan `mvn clean compile package`.
3. Masuk ke folder **target**.
4. Ketikkan `jar -jar jadwalkereta-1.0.jar` untuk menjalankan program.