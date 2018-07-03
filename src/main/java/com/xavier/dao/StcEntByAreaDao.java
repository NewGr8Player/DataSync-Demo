package com.xavier.dao;

import com.xavier.bean.keys.StcEntByAreaMultiKeys;
import com.xavier.bean.stc.StcEntByArea;
import org.springframework.data.repository.CrudRepository;

/**
 * StcEntByArea统计信息Dao
 *
 * @author NewGr8Player
 */
public interface StcEntByAreaDao extends CrudRepository<StcEntByArea, StcEntByAreaMultiKeys> {
}
