package com.xavier.service;

import com.xavier.bean.EntButcher;

import java.util.Optional;

/**
 * 屠宰企业Service
 *
 * @author NewGr8Player
 */
public interface EntButcherService {

	/**
	 * 根据Id查询
	 *
	 * @param id
	 * @return
	 */
	Optional<EntButcher> findById(String id);
}
