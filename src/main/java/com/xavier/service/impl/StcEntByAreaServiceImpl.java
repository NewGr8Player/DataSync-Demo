package com.xavier.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.stc.StcEntByArea;
import com.xavier.service.StcEntByAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EntByAreaService实现
 *
 * @author NewGr8Player
 */
@Service
public class StcEntByAreaServiceImpl implements StcEntByAreaService {

	private Logger logger = LoggerFactory.getLogger(StcEntByAreaService.class);

	@Override
	public void save(StcEntByArea stcEntByArea) {

	}

	@Override
	public StcEntByArea stcEntByAreaCollector(List<CanalEntry.Column> list) {
		return null;
	}
}
