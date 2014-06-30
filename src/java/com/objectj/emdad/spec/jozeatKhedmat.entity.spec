"جزئیات خدمت"		"جزئیات کارهای انجام شده در امداد"		3
﻿noeKhedmat	java.lang.Integer		2	"نوع خدمت"		*		@list	@sort
khedmatId	java.lang.String		19	"شناسه خدمت"		* 		@list	@sort 	@details
hazineh		java.lang.Integer		2	"هزینه طبق ادعای سرویس دهنده"	*	#	@list	@sort	@desc:ريال
ojratId		java.lang.String		19	"اجرت"		  	@FK:ojrat:onvan
qateId		java.lang.String		19	"قطعه"			@FK:qate:name
tedadQate	java.lang.Integer		2	"تعداد مصر(f) قطعه"		#	@list	@sort
guarantee	java.lang.Integer		2	"مشمول گارانتی؟"	*		@list	@sort
manbaeTahiyeh	java.lang.Integer		2	"منبع تهیه"		*		@list	
nahveyePardakht	java.lang.Integer		2	"نحوه پرداخت"		*		@list	