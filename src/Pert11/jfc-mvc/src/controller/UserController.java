package controller;
import view.UserView;

import javax.swing.*;

import model.User;
import model.UserMapper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.apache.ibatis.session.*;

public class UserController {
    private UserView view;
    private UserMapper mapper;
    private SqlSession session;

    public UserController(UserView view, UserMapper mapper, SqlSession session){
        this.view = view;
        this.mapper = mapper;
        this.session = session;

        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshUserListener(new RefreshListener());
    }

    class AddUserListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String name = view.getNameInput();
            String email = view.getEmailInput();
            if(!name.isEmpty() && !email.isEmpty()){
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                mapper.insertUser(user);
                session.commit();
                JOptionPane.showMessageDialog(view,"User added successfully!");
            }else{
                JOptionPane.showMessageDialog(view,"Please fill in all fields");
            }
        }
    }

    class RefreshListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            List<User> users = mapper.getAllUsers();
            String[] userArray = users.stream()
                                .map(u -> u.getName() + " ("+u.getEmail()+")")
                                .toArray(String[]::new);
            view.setUserList(userArray);
        }
    }
}
