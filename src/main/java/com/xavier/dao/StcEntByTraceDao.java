package com.xavier.dao;

import com.xavier.bean.keys.StcEntByTraceMultiKeys;
import com.xavier.bean.stc.StcEntByTrace;
import org.springframework.data.repository.CrudRepository;

/**
 * StcEntByTrace统计Dao
 *
 * @author NewGr8Player
 */
public interface StcEntByTraceDao extends CrudRepository<StcEntByTrace, StcEntByTraceMultiKeys> {
}
