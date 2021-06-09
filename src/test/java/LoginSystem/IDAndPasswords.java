package LoginSystem;

import java.util.HashMap;

public class IDAndPasswords {
    // we will use hashmap to store id passwords

    HashMap<String, String> loginInfo = new HashMap<String , String >();

    IDAndPasswords(){
        loginInfo.put("Admin" ,"123");
        loginInfo.put("Admin1","1234");
        loginInfo.put("Admin2","12345");
    }

   protected HashMap<String, String> getLoginInfo(){
        return loginInfo;
    }
}
