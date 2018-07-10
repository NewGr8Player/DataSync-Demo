package com.xavier.dao;

import com.xavier.bean.keys.StcTracePigMultiKeys;
import com.xavier.bean.stc.StcTracePig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * StcTracePig统计Dao
 *
 * @author NewGr8Player
 */
public interface StcTracePigDao extends CrudRepository<StcTracePig, StcTracePigMultiKeys> {

	@Query(value = "SELECT stp.* " +
			" FROM stc_trace_pig stp " +
			" WHERE province=:province " +
			" AND city=:city"+
			" AND county=:county"+
			" AND entId=:entId" +
			" AND `date` LIKE :aimDate"
			,nativeQuery = true)
	Optional<StcTracePig> findByProvinceAndCityAndCountyAndEntIdAndDate(
			@Param("province") String province,
			@Param("city") String city,
			@Param("county") String county,
			@Param("entId") String entId,
			@Param("aimDate") String date
	);

}

