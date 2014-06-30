"نوع خودرو"	"انواع خودروهای شناخته شده"	6
﻿noeKhodroId		java.lang.Integer	5	"شناسه نوع خودرو"			*	#	@list	@sort				@details
onvan			java.lang.String	30	"عنوان"				*		@list	@sort	@farsi
guarantee		java.lang.Integer	5	"ضمانت"					#	@list	@sort		@desc:ماه
guaranteeDistance	java.lang.Integer	5	"مسا(f)ت ضمانت"			*	#	@list	@sort		@desc:کيلومتر
khodroCode		java.lang.String	5	"کد خودروي خودروساز"				@list	@sort	@farsi
noeKhodroCode		java.lang.String	5	"کد نوع خودرو"					@sort	@farsi
hazinehSaat		java.lang.Integer	9	"هزينه يک ساعت کار بر روي خودرو"		*	#				@desc:ريال
hazinehEshterakAdi	java.lang.Integer	9	"هزينه اشتراک عادي"			*	#				@desc:ريال
hazinehEshterakVijeh	java.lang.Integer	9	"هزينه اشتراک ويژه"			*	#				@desc:ريال
khodrosazId		java.lang.String	30	"خودروساز"				*		@list	@sort				@FK:khodrosaz:name
noeService		java.lang.Integer	5	"نوع سرویس هنگامimport"		*	#	@list	@sort
