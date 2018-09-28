package jp.xiaolongren.chinese.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.xiaolongren.chinese.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
