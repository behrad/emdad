"﻿ درخواست قطعه"		"فهرست درخواست قطعات"		 6
darkhastQateId          java.lang.Integer  5   "شناسه"     *  @list  @sort
emdadgarId    java.lang.String   19  "آمدادگر"   *  @list  @sort	@FK:emdadgar:name
tarikhDarkhast	java.sql.Date   10  "تاریخ درخواست"    *  @list  @sort 
qateId  java.lang.String  19   "قطعه"  *  @list  @sort  @fk:qate:name
tedadDarkhasti	java.lang.Integer   5   	"تعداد درخواستی"	*	@list	@sort
tedadSarparast	java.lang.Integer   5	"تعداد تایید شده توسط سرپرست امدادگران"
taeedShodehSarparast	java.lang.Integer   5	"تایید شده توسط سرپرست امدادگران"
tedadAnbar	java.lang.Integer   5	"تعداد تایید شده توسط انبار"
taeedShodeAnbar	java.lang.Integer   5	"تایید شده توسط انبار"
manba	java.lang.Integer   5	"منبع تهیه قطعه"	*
sabtkonandeh	java.lang.String    19  	"ثبت کننده"
