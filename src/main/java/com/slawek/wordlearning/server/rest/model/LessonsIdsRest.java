package com.slawek.wordlearning.server.rest.model;

import com.slawek.wordlearning.server.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slawek on 2016-06-01.
 */
public class LessonsIdsRest {
	private final List<String> ids = new ArrayList<>();

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		CollectionUtils.replaceCollection(this.ids, ids);
	}
}
