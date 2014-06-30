"درخواست خدمت"		"درخواستهای خدمات از جانب مشتریان"		6
﻿rokhdadId		java.lang.Integer	5	"کد مورد"					#	@list	@sort		@details
moshtarakId		java.lang.String	19	"مشتري"				*		@list	@sort		@FK:moshtarak:name
tel			java.lang.String	50	"تل(f)ن "				*				@farsi
mobile			java.lang.String	50	"تل(f)ن همراه "							@farsi
irad			java.lang.String	60	"ايراد خودرو طبق نظر امداد خواه"	*				@farsi
shahrId			java.lang.String	19	"شهر"				*		@list	@sort		@FK:shahr:shahrName
mantagheh		java.lang.Integer	2	"کد منطقه"				#				"@desc:براي تهران"
address			java.lang.String	80	"آدرس"				*		@list	@sort	@farsi
sabetSayar		java.lang.Integer	2	"ثابت يا سيار"			*		@list	@sort				
khadamateVijeh		java.lang.Integer	2	"مشمول خدمات ويژه"		
eghdamShodeh		java.lang.Integer	2	"اقدام شده"			
namayandegiId		java.lang.String	19	"نمايندگي"								@FK:namayandegi:name
tarikhFaalShodan	java.sql.Date		10	"تاريخ فعال شدن"			*
sabtKonandeh		java.lang.String	40	"ثبت کننده رخداد"							@farsi
akharinTaghyirDahandeh	java.lang.String	40	"آخرين تغيير دهنده"							@farsi
daftarOstaniId		java.lang.String	19	"د(f)تر استاني"					@list	@sort		@FK:daftarOstani:name
zamaneVaghei		java.sql.Date		20	"زمان ثبت رخداد"
dastorkarGhabli		java.lang.Integer	9	"دستور کار قبلي"			
kilometerKarkard	java.lang.Integer	9	"کیلومترکارکرد"