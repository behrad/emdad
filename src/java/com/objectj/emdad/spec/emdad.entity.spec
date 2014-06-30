امداد		   "فهرست امدادها"		6
﻿emdadId			java.lang.Integer	9	"دستورکار"			*	@list	@sort		@detail
rokhdadId		java.lang.String	19	"کد مورد"				*	@list	@sort		@FK:rokhdad:irad
noeEmdad		java.lang.Integer	2	"نوع امداد"			*	@list	@sort		
zamanEzam		java.sql.Date	10	"زمان اعزام"			*	@list	@sort
zamanVagheiEzam		java.sql.Date	10	"زمان واقعی اعزام امدادگر"
ezamgarId		java.lang.String	19	"اعزامگر"				*	@list	@sort		@FK:shakhs:naghshId
emdadgarId		java.lang.String	19	"امدادگر مربوطه"			*				@FK:shakhs:naghshId
vazeatKhedmatId		java.lang.String	19	"وضعيت خدمت"			*	@list	@sort		@FK:vazeatKhedmat:onvan
kilometerKarkard		java.lang.Integer	9	"کيلومتر کارکرد"			* 
faseleAzNamayandegi	java.lang.Integer	6	"اصله امدادخواه از نمايندگی(f)"	*				@desc:کيلومتر
tozihat			java.lang.String	256	"توضيحات"						@farsi
namayandegiId		java.lang.String	19	"نمايندگي"			*				@FK:namayandegi:name
modatTamir		java.lang.Integer	5	"پيش بيني مدت زمان تعمير/سرويس"					@desc:روز
zamanShoro		java.sql.Date	10	"زمان شروع به کار امدادگر"
zamanVagheiShoro		java.sql.Date	10	"زمان واقعی شروع به کار امداد"
zamanPayan		java.sql.Date	10	"زمان پايان کار"
zamanVagheiPayan		java.sql.Date	10	"زمان واقعی پايان کار امداد"
dalileToolKeshidaneEmdadId	java.lang.String	19	"دليل طول کشيدن امداد"						@FK:dalilToolKeshidanEmdad:onvan
vazeatKonuni		java.lang.Integer	2	"وضعيت کنوني"
hazinehAyyabZahab	java.lang.Integer	9	"هزينه اياب و ذهاب"							@desc:ريال
hazinehBoxel		java.lang.Integer	9	"هزينه بوکسل"							@desc:ريال
hazinehJarsaghil		java.lang.Integer	9	"هزينه جرثقيل"							@desc:ريال
hododeHazinehKol		java.lang.Integer	9	"حدود هزينه کل امداد"						@desc:ريال
mablaghPardakhtShodeh	java.lang.Integer	9	"مبلغ پرداخت شده"							@desc:ريال
akharinTagheerDahandeh	java.lang.String	40	"آخرين تغيير دهنده اين امداد"	
rahAndazi		java.lang.String	64	"راه اندازي"						
elateService		java.lang.String	64	"علت نياز به سرويس جديد"	
shomarehFactor		java.lang.String	10	"شماره فاکتور"	
noeKhedmateVije		java.lang.Integer	2	"نوع خدمت ويزه"		*	@list
koliyehMadarek		java.lang.Integer	2	"کلیه مدارک"			*@list
taeedHesabdar		java.lang.Integer	2	"تاييد حسابدار"		*	@list	
taeedGuarantee		java.lang.Integer	2	"تاييد گارانتي"		*	@list	
taeedNamayandegi	java.lang.Integer	2	"تاييد نمايندگي"		*	@list	