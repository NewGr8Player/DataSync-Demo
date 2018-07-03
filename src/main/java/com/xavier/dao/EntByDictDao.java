package com.xavier.dao;

import com.xavier.bean.multi.StcEntByDictMultiKeys;
import com.xavier.bean.stc.StcEntByDict;
import org.springframework.data.repository.CrudRepository;

public interface EntByDictDao extends CrudRepository<StcEntByDict, StcEntByDictMultiKeys> {
}