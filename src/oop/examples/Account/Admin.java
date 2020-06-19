package oop.examples.Account;

import oop.examples.Database.Database;
import oop.examples.System.MyDocuments;

import java.util.ArrayList;
import java.util.Date;

public class Admin extends User {
    private ArrayList<User> users;

    {
        users = Database.getAllUsers();
    }

    public Admin(String name, String surname, String patronymic, Date birthday, String username, String password, boolean gender, String email, MyDocuments documents) {
        super(name, surname, patronymic, birthday, username, password, gender, email, documents);
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean removeUser(String userId){
        for (User u:users){
            if (u.getId().equals(userId)) {
                users.remove(u);
                return true;
            }
        }
        return false;
    }

    public void setUserInfo(User user){
        for (User u:users){
            if (u.getId().equals(user.getId())){
                u.setBirthday(user.getBirthday());
                u.setDocuments(user.getDocuments());
                u.setEmail(user.getEmail());
                u.setGender(user.isGender());
                u.setName(user.getName());
                u.setSurname(user.getSurname());
                u.setPatronymic(user.getPatronymic());
            }
        }
    }

    public User getUser(String userId){
        for (User u:users){
            if (u.getId().equals(userId)) return u;
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
