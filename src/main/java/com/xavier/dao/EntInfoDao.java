package com.xavier.dao;

import com.xavier.bean.EntInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * 企业信息Dao
 *
 * @author NewGr8Player
 */
public interface EntInfoDao extends CrudRepository<EntInfo, String> {
}