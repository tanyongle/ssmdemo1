package com.ssm.adapt;

import com.ssm.entity.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LoginListenner implements HttpSessionAttributeListener {

    private Map<String, HttpSession> map = new HashMap<String, HttpSession>();


    public Map<String, HttpSession> getMap() {
        return map;
    }

    public void setMap(Map<String, HttpSession> map) {
        this.map = map;
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (name.equals("_users")) {
            User user = (User) event.getValue();
            if (map.get(user.getUsername()) != null) {
                HttpSession session = map.get(user.getUsername());
                session.removeAttribute(user.getUsername());
                session.invalidate();
            }
            map.put(user.getUsername(), event.getSession());
        }

    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (name.equals("_users")) {
            User user = (User) event.getValue();
            map.remove(user.getUsername());
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
