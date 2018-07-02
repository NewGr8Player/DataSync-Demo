package com.xavier.dao;

import com.xavier.bean.Dict;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * 字典项Dao
 *
 * @author NewGr8Player
 */
public interface DictDao extends CrudRepository<Dict, String> {

	/**
	 * 根据Type与Value查询字典项信息
	 *
	 * @param type
	 * @param value
	 * @return
	 */
	@Query(value = "SELECT sd.* FROM sys_dict sd WHERE `type` = :typ AND `value` = :val", nativeQuery = true)
	Dict searchByValueWithType(@Param("typ") String type, @Param("val") String value);
}
