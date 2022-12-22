package service;

import model.History;
import model.HistoryType;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService extends BaseService{
    List<History>historyList=new ArrayList<>();
    @Override
    public boolean add(Object object) {
        User user=(User)object;
        for (User user1 : userList) {
            if (user.getFullName().equals(user1.getFullName())){
                System.out.printf("bunday user mavjud");
                return false;
            }
        }
        return true;
    }

    @Override
    public Object getById(UUID id) {
        for (User user : userList) {
            if (user!=null){
                if (user.getId().equals(id)){
                    return false;
                }
            }
        }
        return true;
    }

//    public List<History> getHistory(UUID cardId, final HistoryType historyType) {
//        List<History> getCreditHistoryList = new ArrayList<>();
//        List<History> getDebitHistoryList = new ArrayList<>();
//        for (History history : historyList) {
//            if ()
//        }
//    }
    public boolean login(String password,String phoneNUmber){
        for (User user : userList) {
            if (user.getPhoneNumber().equals(phoneNUmber)&&user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
