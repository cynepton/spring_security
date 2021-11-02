package com.cynepton.spring_security.security;

/**
 * ApplicationUserPermission
 * <br>
 * <code>com.cynepton.spring_security.security.ApplicationUserPermission</code>
 * <br>
 *
 * @author Isaac Aderonmu
 * @since 31 October 2021
 */
public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
