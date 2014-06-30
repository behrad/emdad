نمايندگي			"فهرست نمایندگی ها"	6
﻿namayandegiId		java.lang.Integer		5	"کد نمايندگي"		* 	# 	@list	@sort		@details
name			java.lang.String		50	"نام نمايندگي"		*		@list	@sort	@farsi
shahrId			java.lang.String		40	"نام شهر"		*		@list	@sort		@FK:shahr:shahrName
daftarOstaniId		java.lang.String		40	"د(f)تر استاني"		*   		@list	@sort		@FK:daftarOstani:name
namayandegiTel		java.lang.String		50	"تل(f)ن"					@list		@farsi
namayandegiMobile	java.lang.String		50	"موبايل"					@list		@farsi
namayandegiFax		java.lang.String		20 	"(f)اکس" 						@farsi
namayandegiAddress	java.lang.String		80	"آدرس"						@sort	@farsi
emdadgar		java.lang.String		30	"امدادگر"							@farsi
noeKhodroId		java.lang.String		40	"نوع خودرو امداد"					@sort		@FK:noeKhodro:onvan
tarikhTahvil		java.sql.Date		10	"تاريخ تحويل خودرو"					@sort
sabegheFaaliat		java.lang.Integer		5	"سابقه (f)عاليت"				
sabegheNoroozi		java.lang.Integer		5	"سابقه (f)عاليت نوروزي"			
tarikhGharardad		java.sql.Date		10	"تاريخ عقد قرارداد"	      				@sort
shomarehGharardad	java.lang.String		15	"شماره قرارداد"	     			@list	@sort	@farsi
tahtePooshesh		java.lang.String		80	"محدوده تحت پوشش"				@sort	@farsi
nazarIsaco		java.lang.Integer		5	"نظريه ايساکو"				
vazGharardad		java.lang.Integer		5	"وضعيت (f)علي قرارداد"			
olaviat			java.lang.Integer		5	"اولويت"				#
saghfeRiali		java.lang.Integer		9	"سق(f) ريالي"		*	#				@desc:ريال
hadaksarKar		java.lang.Integer		9	"حداکثر تعداد امداد همزمان"	*	#
karDarDast		java.lang.Integer		9	"تعداد امداد در حال انجام"		#
telZaroori		java.lang.String		20	"تلفن ضروري"
dastgahEybyab		java.lang.String		50	"دستگاه عيب ياب"				@farsi
email			java.lang.String		50	"آدرس پست الکترونيکي"
tarikhAkharinEstelam	java.sql.Date		10	"تاريخ آخرين استعلام"
noeNamayandegi      	java.lang.Integer	       	9	"نوع نمايندگي"				@list
codeMantaghe        	java.lang.Integer    	5	"کد منطقه"				@list