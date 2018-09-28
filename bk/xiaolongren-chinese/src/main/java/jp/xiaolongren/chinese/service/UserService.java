package jp.xiaolongren.chinese.service;

import jp.xiaolongren.chinese.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
