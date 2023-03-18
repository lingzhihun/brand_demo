import com.alibaba.fastjson2.JSON;
import coma.pojo.User;

public class FastJsonDemo {

    public static void main(String[] args) {
        User user = new User();
        user.setId(10);
        user.setUsername("郝耀婷");
        user.setPassword("tinger");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        User user2 = JSON.parseObject("{\"id\":9,\"name\":\"吴双\",\"password\":\"大胸\"}",User.class);
        System.out.println(user2);
    }
}
