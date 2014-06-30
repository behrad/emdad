مشترک		"فهرست مشرکین موجود در سیستم"		1
﻿eshterakId		java.lang.String	10	"شماره اشتراک"				@list	@sort	@farsi	@details
noeEshterak		java.lang.Integer	2	"نوع اشتراک"		*		@list	@sort
noeService		java.lang.Integer	2	"نوع سرويس"		*		@list	@sort
vazeat			java.lang.Integer	2	"وضعيت اشتراک"		*		@list	@sort
nameKhanevadegi		java.lang.String	20	"نام خانوادگي"		*		@list	@sort	@farsi
name			java.lang.String	20	"نام"			*		@list	@sort	@farsi
tarikhTavalod		java.sql.Date	10	"تاريخ تولد"		*
address			java.lang.String	80	"آدرس"			*				@farsi
postCode		java.lang.String	10	"کد پستي"						@farsi
shahrId			java.lang.String	40	"نام شهر"		*					@FK:shahr:shahrName
email			java.lang.String	50	"پست الکترونيکي"						@farsi
tel			java.lang.String	50	"تل(f)ن"			*				@farsi
mobile			java.lang.String	50	"تل(f)ن همراه"						@farsi
noeKhodroId		java.lang.String	40	"نوع خودرو"		*		@list	@sort		@FK:noeKhodro:onvan
rangeKhodroId		java.lang.String	40	"رنگ خودرو"		*					@FK:rangeKhodro:onvan
saleSakht		java.lang.Integer	4	"سال ساخت خودرو"	*	#
shomarePelak		java.lang.String	20	"شماره پلاک"		*		@list	@sort	@farsi
shomareMotor		java.lang.String	20	"شماره موتور"		*				@farsi
shomareShasi		java.lang.String	20	"شماره شاسي"		*				@farsi
shomareVIN		java.lang.String	20	"VIN شماره"						@farsi
tarikhShoro		java.sql.Date	10	"تاريخ شروع اشتراک"			@list	@sort
tarikhAkharinTamdid	java.sql.Date	10	"تاريخ آخرين تمديد"			
tarikhEngheza		java.sql.Date	10	"تاريخ انقضاي اشتراک"			@list	@sort
tarikhTahvil		java.sql.Date	10	"تاريخ تحويل خودرو"			
guarantee		java.lang.Integer	2	"ضمانت"		*		@list	@sort
tarikhEnghezaGuarantee	java.sql.Date	10	"تاريخ انقضاي ضمانت"		
bazaryabId		java.lang.String	40	"بازارياب"								@FK:bazaryab:name
tarikhServiceAvalieh	java.sql.Date	10	"تاريخ سرويس اوليه"		
mahaleServiceAvalieh	java.lang.String	40	"محل سرويس اوليه"					@farsi
tarikhAkharinEmail	java.sql.Date	10	"تاريخ آخرين نامه الکترونيکي"	
hazinehPardakhtShodeh	java.lang.Integer	4	"هزينه پرداخت شده"		#
namayandegi		java.lang.Integer	4	"نمايندگي"			#
takhfif			java.lang.Integer	4	"تخفیف"		*	#
naghd			java.lang.Integer	4	"نقد"		*	#	
taahodi			java.lang.Integer	4	"تعهدی"		*	#	
aghsat			java.lang.Integer	4	"جمع اقساط"		*	#	
cheque			java.lang.string	80	"چکها"		@farsi		