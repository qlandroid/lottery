package org.ql.shopping.util;

public class MakeManifest {

	
	private static final String TypeIncome = "IN";
	private static final String TypeExpent = "OT";
	public static String makeIncomeManifestNo(){
		return TypeIncome + MakeManifestNo.makeId();
	}
	
	public static String makeManifestNo(String type){
		return type +MakeManifestNo.makeId();
	}
}
