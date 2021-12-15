package com.vedat.database;

public interface Db {

    public String jdbc_name = "com.mysql.jdbc.Driver";
    // ?useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=Turkey
    public String DB_name = "travel";
    public String drive_ = "jdbc:mysql://localhost:3306/" + DB_name + "?useSSL=false&useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    public String root = "root";
    public String pwd = "10021918";

}
