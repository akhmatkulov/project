package uz.pdp.service;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import uz.pdp.model.User;
import uz.pdp.model.Users;

import java.io.*;
import java.util.ArrayList;

public class UserService {
    private static final String PATH = "E:\\Java\\project\\project1\\src\\Users.xml";
    XmlMapper xmlMapper = new XmlMapper();
    Users users = new Users();


    public User register(User user) {
       read();
       for (User user1: users.getUsers()){
           if (user1.getUserName().equals(user.getUserName())){
               return null;
           }
       }
       users.getUsers().add(user);
       write();
       return user;
    }

    public User login(String username, String password) {
        read();
        for (User user1: users.getUsers()){
            if (user1.getUserName().equals(username) && user1.getPassword().equals(password)){
                return user1;
            }
        }
      return null;
    }

    public void write() {
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String str = xmlMapper.writeValueAsString(users);
            BufferedWriter bufferedWriter =  new BufferedWriter(new FileWriter(PATH));
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e + "write");
        }
    }

    public  void read() {
        File file = new File(PATH);
        try {
            users.setUsers(xmlMapper.readValue(file,xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class,User.class)));
        }catch (Exception e){
            System.out.println(e + "read");
        }
    }
}