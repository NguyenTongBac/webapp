package com.webnote.Model.Function.Wellcome;

import com.webnote.Interface.Wellcome.RegisterUserDao;
import com.webnote.Model.Database.Customer;
import com.webnote.Model.Service.DoUser;

public class Register implements RegisterUserDao {
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean register(String username, String password, String name, String password2) {
        if (username == "" || password == "" || name == "" || password2 == "") {
            setMessage("please, complete infomation");
            return false;
        }
        if (!username.endsWith("@gmail.com")) {
            setMessage("username's not right, please re-enter");
            return false;
        }
        DoUser doUser = new DoUser();
        doUser.insertCustomer(username, password, name, password2);
        Customer checkInsertCustomer = doUser.checkInsertCustomer(username, password, name, password2);
        if (checkInsertCustomer != null) {
            return true;
        }
        setMessage("failed to register");
        return false;
    }
}
