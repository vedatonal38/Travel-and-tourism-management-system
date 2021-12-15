# T.C. CUMHURİYET ÜNİVERSİTESİ MÜHENDİSLİK FAKÜLTESİ BİLGİSAYAR MÜHENDİSLİĞİ BÖLÜMÜ

## İNTERNET PROGRAMALAMA DERSİ 
## SEYAHAT ve TURİZM YÖNETİM SİSTEMİ FİNAL PROJESİ

[VERİ TABANI KISMI](https://github.com/vedatonal38/Travel-and-tourism-management-system-data-base)

### Gereksinimleri (Requirements)
* NetBeans 8.0
* Tomcat 8.0 (Not: NetBeans 8.0 versionun içerisindee mevcuttur.)

### Projenin Kurulumu 
> Yukarıda projenin ZIP halini indiriniz.

> NetBeans açınız. NetBeans navigation bardaki ***File*** menün altındaki ***Import Project*** seçeneğin yan açılınan kısmında ***from ZIP*** tıklanınız.

> Açılan pencereden indirdiniz ZIP dosyasını seçiniz ve projenin kururacağı klasöru belileniz.

### Projenin Veri Tabanı ayarlaması
> Kurludumuz ZIP dosyasından sonra projenin içerisindeki ***Source Packages*** kısmın altındaki ***com.vedat.database*** paketin içinde bulunana ***DB.java*** interface (arayüz) deki kendininiz MySQL ayarlamasını yapınız.

    public interface Db {

        public String jdbc_name = "com.mysql.jdbc.Driver";
        // ?useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=Turkey
        public String DB_name = "travel";
        public String drive_ = "jdbc:mysql://localhost:3306/" + DB_name + "?useSSL=false&useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        public String root = "root"; // KULLANICI ADI
        public String pwd = "PASSWORD"; // ŞİFRE

    }

> Projenin çalıştırın.
