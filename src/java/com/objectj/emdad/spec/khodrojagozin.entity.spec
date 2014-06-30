"خودرو جایگزین"		"فهرست خودروهای جایگزین"		6
khodrojagozinId		java.lang.Integer 	5	"شناسه خودروی جایگزین "	*	#	@list	@sort		@details
rangeKhodroId		java.lang.String	40	"رنگ خودرو"		*					@FK:rangeKhodro:onvan
noeKhodroId		java.lang.String	40	"نوع خودرو"		*		@list	@sort		@FK:noeKhodro:onvan
salesakht			java.lang.Integer	5	"سال ساخت "		*		@list	@sort
shomarehPelak		java.lang.String	20	"شماره پلاک "		*				@farsi
shomarehMotor		java.lang.String 	20	"شماره موتور "		*				@farsi
shomarehShasi		java.lang.String	20	"شماره شاسی "		*				@farsi
shomarehVIN		java.lang.String	20	"VINشماره "		*				@farsi
tozihat			java.lang.String	64	"توضیحات "						@farsi	
faal			java.lang.Integer	2	"عال(f) "			*		@list	@sort
daftarOstaniId		java.lang.String	19	"د(f)تر استاني"					@list	@sort	@FK:daftarOstani:name