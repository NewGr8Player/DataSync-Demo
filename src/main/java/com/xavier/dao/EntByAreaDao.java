package com.xavier.dao;

import com.xavier.bean.multi.StcEntByDictMultiKeys;
import com.xavier.bean.stc.StcEntByArea;
import org.springframework.data.repository.CrudRepository;

public interface EntByAreaDao extends CrudRepository<StcEntByArea, StcEntByDictMultiKeys> {
}
