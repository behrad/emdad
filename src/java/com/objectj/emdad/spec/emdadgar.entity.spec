امدادگر 		"فهرست امدادگران شرکت"		6
﻿emdadgarId	java.lang.Integer		5	"شناسه"			* 	#	@list	@sort				@details
name		java.lang.String		40	"نام"			*		@list	@sort	@farsi
tel		java.lang.String		50	"تل(f)ن"			*		@list		@farsi
mobile		java.lang.String		50	"تل(f)ن همراه"						@farsi
address		java.lang.String		80	"آدرس"			*				@farsi
satheMaharat	java.lang.Integer		2	"سطح مهارت (f)ني"	*	#
saghfeMojoodi	java.lang.Integer		9	"سق(f) موجودي"		*	#				@desc:ريال
vazeat		java.lang.Integer		2	"وضعيت"			*
hadaksarKar	java.lang.Integer		2	"حداکثر تعداد امداد همزمان"	*	#
karDarDast	java.lang.Integer		2	"تعداد امداد در حال انجام"	*	#
noeEmdadgarId	java.lang.String		19	"نوع امدادگر"		*		@list	@sort				@FK:noeEmdadgar:onvan
daftarOstaniId	java.lang.String		19	"د(f)تر استاني"		  	 						@FK:daftarOstani:name
namayandegiId	java.lang.String		19	"نمايندگي"		*							@FK:namayandegi:name
