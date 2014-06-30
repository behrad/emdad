"تغییر اشتراک"		"درخواست های تغییر اشتراک از جانب مشتریان"		2	
﻿eshterakId		java.lang.String	10	"شماره اشتراک"		*		@list	@sort	@farsi	@details
ijadKonandeh		java.lang.String	20	"ایجادکننده"		*		@list	@sort	@farsi	
noeService		java.lang.Integer	2	"نوع سرويس"				@list	@sort
nameKhanevadegi		java.lang.String	20	"نام خانوادگي"				@list	@sort	@farsi
name			java.lang.String	20	"نام"				@list	@sort	@farsi
tarikhTavalod		java.lang.String		20	"تاريخ تولد"		
address			java.lang.String	80	"آدرس"						@farsi
postCode			java.lang.String	10	"کد پستي"						@farsi
shahrId			java.lang.String	40	"نام شهر"							@FK:shahr:shahrName
email			java.lang.String	50	"پست الکترونيکي"					@farsi
tel			java.lang.String	50	"تل(f)ن"				@list		@farsi
mobile			java.lang.String	50	"تل(f)ن همراه"			@list		@farsi
rangeKhodroId		java.lang.String	40	"رنگ خودرو"							@FK:rangeKhodro:onvan
shomarePelak		java.lang.String	20	"شماره پلاک"					@sort	@farsi
