package org.ql.shopping.service.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.ManifestLBiChange;
import org.ql.shopping.pojo.manifest.ManifestLBiChangeSearch;

public interface ILBiManifestManagerService {

	public void addManifest(ManifestLBiChange manager);

	public void updateById(ManifestLBiChange manager);

	public void deleteById(ManifestLBiChange manager);

	public List<ManifestLBiChangeSearch> selectListPageByParams(ManifestLBiChangeSearch params);

	public Integer getListCountByParams(ManifestLBiChangeSearch params);
}
