package fun.happyhacker.springbootdemo.mybatis.sql;

public class UserInfoSql {
    public String queryAgeByName(String userName) {
        return "SELECT age from user where name = #{userName}";
    }
}
