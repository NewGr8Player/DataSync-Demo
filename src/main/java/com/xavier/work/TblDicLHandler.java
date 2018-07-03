package com.xavier.work;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.service.StcEntByAreaService;
import com.xavier.service.StcEntByDictService;
import com.xavier.work.base.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * tblDic表内内容处理
 *
 * @author NewGr8Player
 */
@Component
public class TblDicLHandler extends AbstractHandler {

	//TODO 目前只完成了一侧业务处理
	@Autowired
	private StcEntByAreaService stcEntByAreaService;
	@Autowired
	private StcEntByDictService stcEntByDictService;

	@Override
	public void onInsert(List<CanalEntry.Column> afterList) {
		stcEntByDictService.save(stcEntByDictService.stcEntByDictCollector(afterList));
	}

	@Override
	public void onUpdate(List<CanalEntry.Column> beforeList, List<CanalEntry.Column> afterList) {
		stcEntByDictService.save(stcEntByDictService.stcEntByDictCollector(afterList));
	}

	@Override
	public void onDelete(List<CanalEntry.Column> beforeList) {
		//TODO 表被删除是否处理?
	}
}