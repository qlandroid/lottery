package org.ql.shopping.util;

import org.ql.shopping.pojo.Model;

public class ModelUtils {

	public static <T extends Model> void initPageParams(T t) {
		Integer pageSize = t.getPageSize();
		Integer page = t.getPage();
		if (t.getLimit() != null) {
			t.setPageSize(t.getLimit());
		} else if (NumberUtils.isZero(pageSize)) {
			t.setPageSize(20);
		}

		if (NumberUtils.isZero(page)) {
			t.setPage(1);
		}
		int firstIndex = (t.getPage() - 1) * t.getPageSize();
		t.setFirstIndex(firstIndex);

	}

}
