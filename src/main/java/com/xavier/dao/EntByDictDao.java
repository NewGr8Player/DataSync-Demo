package com.xavier.dao;

import com.xavier.bean.multi.EntByDictMultiKeys;
import com.xavier.bean.stc.EntByDict;
import org.springframework.data.repository.CrudRepository;

public interface EntByDictDao extends CrudRepository<EntByDict, EntByDictMultiKeys> {
}
