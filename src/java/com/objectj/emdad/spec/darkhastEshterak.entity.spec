"درخواست اشتراک"		"درخواست های اشتراک از جانب مشتریان"		1
﻿noeService		java.lang.Integer	5	"نوع سرويس"		*	#	@list			@details
nameKhanevadegi		java.lang.String	20	"نام خانوادگی"		*		@list	@sort	@farsi
nameMoshtarak		java.lang.String	20	"نام "			*		@list	@sort	@farsi
tarikhTavalod		java.sql.Date	10	"تاریخ تولد"		*
addressMoshtarak		java.lang.String	80	"آدرس"			*				@farsi
codePost			java.lang.String	10	"کد پستی"						@farsi					
shahrId			java.lang.String	20	"نام شهر"		*					@fk:shahr:shahrName
emailMoshtarak		java.lang.String	50	"پست الکترونیکي"						@farsi
telMoshtarak		java.lang.String	50	"تل(f)ن"			*		@list		@farsi
mobileMoshtarak		java.lang.String	50	"تل(f)ن همراه"						@farsi
noeKhodroId		java.lang.String	20	"نوع خودرو"		*		@list			@fk:noekhodro:onvan
rangeKhodroId		java.lang.String	20	"رنگ خودرو"		*					@fk:rangekhodro:onvan
saleSakht			java.lang.Integer	5	"سال ساخت خودرو"	*	#	@list
shomarePelak		java.lang.String	20	"شماره پلاک"		*		@list	@sort	@farsi
shomareMotor		java.lang.String	20	"شماره موتور"		*				@farsi
shomareShasi		java.lang.String	20	"شماره شاسی"		*		@list	@sort	@farsi
garantee	 		java.lang.Integer	5	"ضمانت"			*
tarikhEnghezaGarantee	java.sql.Date	10	"تاریخ انقضای گارانتی"
nahvePardakht		java.lang.Integer	10	"نحوه پرداخت"		*
shomareFish		java.lang.String	15	"بانکی شماره (f)یش"					@farsi
tarikhFish		java.sql.Date	10	"تاریخ (f)یش"
nameShobe		java.lang.String	40	"نام شعبه"						@farsi
hazineh			java.lang.Integer	5	"هزینه پرداخت شده"	*	#