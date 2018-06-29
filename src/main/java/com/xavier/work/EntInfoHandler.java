package com.xavier.work;


import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.xavier.bean.EntInfo;
import com.xavier.dao.EntInfoDao;
import com.xavier.work.base.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntInfoHandler extends AbstractHandler {

	@Autowired
	private EntInfoDao entInfoDao;

	@Override
	public void onInsert(List<Column> afterList) {
		this.entInfoDao.save(new EntInfo(afterList));
	}

	@Override
	public void onUpdate(List<Column> beforeList, List<Column> afterList) {
		this.entInfoDao.save(new EntInfo(afterList));
	}

	@Override
	public void onDelete(List<Column> beforeList) {
		//TODO 删除不应当删除主记录
		this.entInfoDao.deleteById(new EntInfo(beforeList).getId());
	}
}
