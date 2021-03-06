package com.xavier.service.impl;

import com.xavier.bean.EntButcher;
import com.xavier.dao.EntButcherDao;
import com.xavier.service.EntButcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EntButcherServiceImpl implements EntButcherService {

	@Autowired
	private EntButcherDao entButcherDao;

	@Override
	public Optional<EntButcher> findById(String id) {
		return this.entButcherDao.findById(id);
	}
}
