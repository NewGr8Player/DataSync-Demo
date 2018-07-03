package com.xavier.dao;

import com.xavier.bean.keys.StcEntByDictMultiKeys;
import com.xavier.bean.stc.StcEntByDict;
import org.springframework.data.repository.CrudRepository;

/**
 * StcEntByDict统计信息Dao
 *
 * @author NewGr8Player
 */
public interface StcEntByDictDao extends CrudRepository<StcEntByDict, StcEntByDictMultiKeys> {
}
