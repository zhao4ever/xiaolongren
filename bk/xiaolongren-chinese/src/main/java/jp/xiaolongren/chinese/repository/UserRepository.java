package jp.xiaolongren.chinese.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.xiaolongren.chinese.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
