package ru.shashy.orderrestapi.domain.usercontext;

public interface UserContext {
    String getAuthUser();
    boolean isAuthenticated();
}
