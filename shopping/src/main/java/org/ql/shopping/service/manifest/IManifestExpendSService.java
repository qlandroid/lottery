package org.ql.shopping.service.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.ManifestExpendSs;

public interface IManifestExpendSService {
	
	
	List<ManifestExpendSs>  selectListByParams(ManifestExpendSs params);
	Integer getListCountByParams(ManifestExpendSs params);
}
