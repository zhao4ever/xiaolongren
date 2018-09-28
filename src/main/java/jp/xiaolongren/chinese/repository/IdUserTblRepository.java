package jp.xiaolongren.chinese.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import jp.xiaolongren.chinese.model.IdUserTbl;

public interface IdUserTblRepository extends MongoRepository<IdUserTbl, String>{
	IdUserTbl findByUsername(String username);
}
