package com.xavier.dao;

import com.xavier.bean.keys.StcTracePigMultiKeys;
import com.xavier.bean.stc.StcTracePig;
import org.springframework.data.repository.CrudRepository;

/**
 * StcTracePig统计Dao
 *
 * @author NewGr8Player
 */
public interface StcTracePigDao extends CrudRepository<StcTracePig, StcTracePigMultiKeys> {
}

