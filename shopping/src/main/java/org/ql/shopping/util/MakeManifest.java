package org.ql.shopping.util;

public class MakeManifest {

	private static final String TypeIncome = "IN";
	private static final String TypeExpent = "OT";
	private static final String TypeFillSendLBI = "FS";//满n返m积分，发放奖励积分

	public static String makeIncomeManifestNo() {
		return TypeIncome + MakeManifestNo.makeId();
	}
	public static String makeExpendManifestNo() {
		return TypeExpent + MakeManifestNo.makeId();
	}
	public static String makeFillSendLBiManifestNo(){
		return TypeFillSendLBI + MakeManifestNo.makeId();
	}

	public static String makeManifestNo(String type) {
		return type + MakeManifestNo.makeId();
	}
}
