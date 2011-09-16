package com.itap;

public class Constant {

//	public static final String SELECT_DETAIL = "SELECT imp_import_detail.quantity as quantity, imp_import_detail.item_id as item_id," +
//								 "      imp_import_detail.description_eng as description_eng, imp_import_detail.invoice_no as invoice_no,"+
//								 "      imp_import_detail.invoice_date as invoice_date, imp_permit_relation.ID as permit_relation_id,"+
//								 "      imp_permit_relation.permit_doc_id as permit_doc_id, imp_permit_doc.permit_number as permit_number"+
//								 " FROM imp_import_letter,"+
//								 "      imp_import_detail,"+
//								 "      imp_permit_relation,"+
//								 "      imp_permit_doc"+
//								 " WHERE ((imp_import_letter.ID = imp_import_detail.import_letter_id)"+
//								 "       AND (imp_import_letter.ID = imp_permit_relation.import_letter_id)"+
//								 "       AND (imp_permit_doc.ID = imp_permit_relation.permit_doc_id)) and imp_permit_doc.ID = ?";
	
	public static final String SELECT_DETAIL = "SELECT imp_import_detail.quantity as quantity, imp_import_detail.item_id as item_id, "+
	"imp_import_detail.description_eng as description_eng, imp_import_detail.invoice_no as invoice_no, "+
	"imp_import_detail.invoice_date as invoice_date, imp_permit_relation.ID as permit_relation_id, "+
	"imp_permit_relation.permit_doc_id as permit_doc_id, imp_permit_doc.permit_number as permit_number, "+
	"imp_import_letter.tariff_number as tariff_number, imp_import_letter.statics_number as statics_number, "+
	"imp_import_detail.load as load, imp_import_detail.MASS as mass, imp_permit_doc.type as per_type "+
	"FROM imp_import_letter, "+
	"imp_import_detail, "+
	"imp_permit_relation, "+
	"imp_permit_doc "+
	"WHERE ((imp_import_letter.ID = imp_import_detail.import_letter_id) "+
	"AND (imp_import_letter.ID = imp_permit_relation.import_letter_id) "+
	"AND (imp_permit_doc.ID = imp_permit_relation.permit_doc_id) and imp_permit_doc.ID = ?) ";

	
	public static final String SELECT_MAIN = "SELECT imp_permit_doc.permit_number as permit_number, imp_permit_doc.expire_date as expire_date, "+
	         "imp_permit_doc.permit_date as permit_date, imp_permit_doc.tax_no as tax_no, imp_reconsider_doc.subject as license_name, "+
	         "imp_reconsider_doc.SIGN_NAME||'/'||imp_reconsider_doc.POSITION as authority_name "+
	         "FROM imp_permit_doc, imp_permit_relation, imp_import_letter, imp_reconsider_doc "+
	         "where (imp_import_letter.ID = imp_permit_relation.import_letter_id) AND (imp_reconsider_doc.id = imp_permit_relation.reconsider_doc_id) "+
	         "AND (imp_permit_doc.ID = imp_permit_relation.permit_doc_id) and imp_permit_doc.ID = ? ";

}
