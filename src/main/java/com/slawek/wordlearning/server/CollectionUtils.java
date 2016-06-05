package com.slawek.wordlearning.server;

import java.util.Collection;

/**
 * Created by slawek on 2016-02-22.
 */
public class CollectionUtils {
	public static <T> void replaceCollection(Collection<T> purpose, Collection<T> from) {
		purpose.clear();
		purpose.addAll(from);
	}
}
