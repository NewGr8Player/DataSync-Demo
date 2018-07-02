package com.xavier.service;


import com.xavier.bean.EntInfo;

/**
 * 企业信息Service
 *
 * @author NewGr8Player
 */
public interface EntInfoService {
	/**
	 * 保存
	 *
	 * @param entInfo
	 */
	void save(EntInfo entInfo);

	/**
	 * 根据id删除
	 *
	 * @param id
	 */
	void deleteById(String id);
}
