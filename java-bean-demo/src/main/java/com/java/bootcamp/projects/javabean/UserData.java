package com.java.bootcamp.projects.javabean;

public interface UserData {

    /**
     * Get unique ID of this user;
     * @return
     */
    Long getId();

    /**
     * Get name of the user.
     * @return
     */
    String getUserName();

    /**
     * Get user's role.
     * @return
     */
    String getRole();

}
