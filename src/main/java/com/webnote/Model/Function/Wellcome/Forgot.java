package com.webnote.Model.Function.Wellcome;

import com.webnote.Model.Database.Customer;
import com.webnote.Interface.Wellcome.ForgotPassUserDao;
import com.webnote.Model.Service.DoUser;


public class Forgot implements ForgotPassUserDao {
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean forgotPass(String username, String password2, String password) {
        setMessage("password2 or username incorrect");
        if (username == "" || password == "" || password2 == "") {
            setMessage("please, complete information");
            return false;
        }
        DoUser doUser = new DoUser();
        Customer customer = doUser.checkUpdateCustomer(username, password2);
        if (customer != null) {
            doUser.updateCustomer(username, password, password2);
            customer = doUser.checkLoginCustomer(username, password);
            if (customer != null) {
                return true;
            }
        }
        return false;
    }
}
