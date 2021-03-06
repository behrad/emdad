CREATE TABLE [dbo].[AnbarEmdadgar] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mojoodi] [int] NOT NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[emdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Bazaryab] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[bazaryabKey] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeBazaryabId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[bazaryabId] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[BazaryabMotefareghe] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[address] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[mobile] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[name] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shShenasname] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namePedar] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DaftarOstani] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[daftarOstaniId] [int] NULL ,
	[name] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[masool] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[mobile] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[address] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[mahdodeh] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DalileToolKeshidaneEmdad] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[dalileToolKeshidaneEmdadId] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DarkhastEshterak] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shomareMotor] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[nameKhanevadegi] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tarikhEnghezaGarantee] [datetime] NULL ,
	[mobileMoshtarak] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[garantee] [int] NULL ,
	[codePost] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomarePelak] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[rangeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[addressMoshtarak] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tarikhFish] [datetime] NULL ,
	[hazineh] [int] NULL ,
	[nahvePardakht] [int] NULL ,
	[tarikhTavalod] [datetime] NULL ,
	[nameMoshtarak] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[telMoshtarak] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[emailMoshtarak] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomareShasi] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[noeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeService] [int] NULL ,
	[shomareFish] [nvarchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[saleSakht] [int] NULL ,
	[shahrId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[nameShobe] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DarkhastQate] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[darkhastQateId] [int] IDENTITY (1, 1) NOT NULL ,
	[tedadSarparast] [int] NULL ,
	[sabtkonandeh] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[manba] [int] NOT NULL ,
	[tedadAnbar] [int] NULL ,
	[taeedShodehSarparast] [int] NULL ,
	[tarikhDarkhast] [datetime] NOT NULL ,
	[taeedShodeAnbar] [int] NULL ,
	[tedadDarkhasti] [int] NOT NULL ,
	[emdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DarkhastTagheer] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mobile] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[name] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[nameKhanevadegi] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tarikhTavalod] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeService] [int] NULL ,
	[shomarePelak] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[email] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ijadKonandeh] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[eshterakId] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[address] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[postCode] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shahrId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[rangeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[moshtarakId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Emdad] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[emdadId] [int] IDENTITY (1, 1) NOT NULL ,
	[rokhdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeEmdad] [int] NOT NULL ,
	[zamanEzam] [datetime] NULL ,
	[zamanVagheiEzam] [datetime] NULL ,
	[ezamgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[emdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[vazeatKhedmatId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[kilometerKarkard] [int] NULL ,
	[faseleAzNamayandegi] [int] NULL ,
	[tozihat] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[modatTamir] [int] NULL ,
	[zamanShoro] [datetime] NULL ,
	[zamanVagheiShoro] [datetime] NULL ,
	[zamanPayan] [datetime] NULL ,
	[zamanVagheiPayan] [datetime] NULL ,
	[dalileToolKeshidaneEmdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[vazeatKonuni] [int] NULL ,
	[hazinehAyyabZahab] [int] NULL ,
	[hazinehBoxel] [int] NULL ,
	[hazinehJarsaghil] [int] NULL ,
	[hododeHazinehKol] [int] NULL ,
	[mablaghPardakhtShodeh] [int] NULL ,
	[akharinTagheerDahandeh] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[vazeatDakheli] [int] NULL ,
	[dastoorKarGhabli] [int] NULL ,
	[maliDone] [int] NULL ,
	[rahAndazi] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[elateService] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomarehFactor] [char] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeKhedmateVije] [int] NULL ,
	[koliyehMadarek] [int] NULL ,
	[ellateBargashteGuarantee] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[taeedHesabdar] [int] NULL ,
	[taeedGuarantee] [int] NULL ,
	[taeedNamayandegi] [int] NULL ,
	[iii] [int] NULL ,
	[noeEmdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Emdadgar] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[emdadgarId] [int] IDENTITY (1, 1) NOT NULL ,
	[name] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mobile] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[address] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[satheMaharat] [int] NOT NULL ,
	[saghfeMojoodi] [int] NOT NULL ,
	[vazeat] [int] NULL ,
	[noeEmdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[daftarOstaniId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[hadaksarKar] [int] NULL ,
	[karDarDast] [int] NULL ,
	[azArz] [int] NULL ,
	[taArz] [int] NULL ,
	[azTool] [int] NULL ,
	[taTool] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[GheirMoshtarak] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[name] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[saleSakht] [int] NOT NULL ,
	[nameKhanevadegi] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[moshtarakId] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shomarePelak] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[noeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[rangeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[HIGH_KEY] (
	[NAME] [char] (25) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[VALUE] [varchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Irad] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[iradId] [varchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[JozeatKasri] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tedadEmdadgar] [int] NULL ,
	[tedadKasri] [int] NOT NULL ,
	[tedadAnbar] [int] NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[kasriEmdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[JozeatKhedmat] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[guarantee] [int] NOT NULL ,
	[tedadQate] [int] NULL ,
	[khedmatId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[hazineh] [int] NOT NULL ,
	[noeKhedmat] [int] NOT NULL ,
	[ojratId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[hazinehDefault] [int] NULL ,
	[iradId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[taeedHesabdar] [int] NULL ,
	[taeedGuarantee] [int] NULL ,
	[taeedNamayandegi] [int] NULL ,
	[ijadKonandeh] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[manbaeTahiyeh] [int] NULL ,
	[nahveyePardakht] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[KasriEmdad] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tarikh] [datetime] NULL ,
	[kasriId] [int] IDENTITY (1, 1) NOT NULL ,
	[tahvilshod] [int] NULL ,
	[taeedAnbardar] [int] NULL ,
	[taeedEmdadgar] [int] NULL ,
	[emdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Khodrojagozin] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tozihat] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomarehVIN] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomarehPelak] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[khodrojagozinId] [int] NOT NULL ,
	[shomarehShasi] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[faal] [int] NOT NULL ,
	[salesakht] [int] NOT NULL ,
	[shomarehMotor] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[rangeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[daftarOstaniId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[KhodrojagozinMasraf] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tarikhTahvilAzMoshtari] [datetime] NULL ,
	[tarikhTahvilBeMoshtari] [datetime] NULL ,
	[emdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[khodrojagozinId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Khodrosaz] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[khodrosazId] [int] NOT NULL ,
	[name] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[LastSerial] (
	[name] [varchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[serial] [bigint] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Mojaz] (
	[Kind] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[شرح امداد] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tedad] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[شماره فني امداد] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[اختصاصي] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[تداركاتي] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomareFanni] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[name] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[gheimat] [float] NULL ,
	[وضعيت موجودي] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MojoodiAnbar] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[anbarId] [int] NOT NULL ,
	[mojoodi] [int] NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MojoodiMojaz] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tedad] [int] NOT NULL ,
	[noeEmdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Moshtarak] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shomareMotor] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[nameKhanevadegi] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mobile] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[address] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mahaleServiceAvalieh] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[postCode] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeEshterak] [int] NOT NULL ,
	[tarikhAkharinEmail] [datetime] NULL ,
	[guarantee] [int] NOT NULL ,
	[shomarePelak] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomareVIN] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tarikhShoro] [datetime] NOT NULL ,
	[tarikhTavalod] [datetime] NULL ,
	[tarikhServiceAvalieh] [datetime] NULL ,
	[eshterakId] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[email] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tarikhTahvil] [datetime] NULL ,
	[shomareShasi] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[noeService] [int] NOT NULL ,
	[tarikhEnghezaGuarantee] [datetime] NULL ,
	[tarikhEngheza] [datetime] NOT NULL ,
	[tarikhAkharinTamdid] [datetime] NULL ,
	[saleSakht] [int] NOT NULL ,
	[vazeat] [int] NOT NULL ,
	[name] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shahrId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[bazaryabId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[rangeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[moshtarakYaNa] [int] NULL ,
	[hazinehPardakhtShodeh] [int] NULL ,
	[namayandegi] [int] NULL ,
	[takhfif] [int] NULL ,
	[naghd] [int] NULL ,
	[taahodi] [int] NULL ,
	[aghsat] [int] NULL ,
	[cheque] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[iii] [int] NULL ,
	[tarikhIjad] [datetime] NULL ,
	[majaziYaNa] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MostanadatRokhdad] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tarikhSanad] [datetime] NULL ,
	[tarikhSabt] [datetime] NOT NULL ,
	[nameParvande] [nvarchar] (128) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[sharh] [nvarchar] (128) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mostanadatRokhdadId] [int] IDENTITY (1, 1) NOT NULL ,
	[shomarehSanad] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[rokhdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[nameSanad] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Naghshe] (
	[id] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[taArzeGoegraphy] [int] NULL ,
	[taTooleGoegraphy] [int] NULL ,
	[azArzeGoegraphy] [int] NULL ,
	[mantagheId] [int] NULL ,
	[azTooleGoegraphy] [int] NULL ,
	[mapLevel] [int] NULL ,
	[fileName] [char] (128) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Namayandegi] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[namayandegiId] [int] NOT NULL ,
	[name] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shahrId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiTel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiMobile] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiFax] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiAddress] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[emdadgar] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeKhodroId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tarikhTahvil] [datetime] NULL ,
	[sabegheFaaliat] [int] NULL ,
	[sabegheNoroozi] [int] NULL ,
	[tarikhGharardad] [datetime] NULL ,
	[shomarehGharardad] [nvarchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tahtePooshesh] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[nazarIsaco] [int] NULL ,
	[vazGharardad] [int] NULL ,
	[olaviat] [int] NULL ,
	[daftarOstaniId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[saghfeRiali] [int] NULL ,
	[hadaksarKar] [int] NULL ,
	[tarikhAkharinEstelam] [datetime] NULL ,
	[dastgahEybyab] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[telZaroori] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[email] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeNamayandegi] [int] NULL ,
	[codeMantaghe] [int] NULL ,
	[karDarDast] [int] NULL ,
	[hadaksarKar2] [int] NULL ,
	[karDarDast2] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[NoeBazaryab] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[noeBazaryabId] [int] NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[entity] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[NoeEmdadgar] (
	[noeEmdadgarId] [int] NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[NoeKhodro] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[noeKhodroId] [int] NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[guarantee] [int] NULL ,
	[khodrosazId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[khodroCode] [varchar] (5) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[guaranteeDistance] [int] NULL ,
	[noeKhodroCode] [varchar] (2) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[vijeh] [int] NULL ,
	[hazinehSaat] [int] NULL ,
	[hazinehEshterakAdi] [int] NULL ,
	[hazinehEshterakVijeh] [int] NULL ,
	[noeService] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Ojrat] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ojratId] [varchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ojrat] [int] NOT NULL ,
	[modat] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Ostan] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ostanId] [int] NOT NULL ,
	[name] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PeigiriEzamgar] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[zamanPeigiri] [datetime] NOT NULL ,
	[natije] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[emdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Qate] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shomareFanni] [nvarchar] (12) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[name] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[qateId] [int] NOT NULL ,
	[vahedShomaresh] [int] NOT NULL ,
	[gheimat] [int] NOT NULL ,
	[satheMaharat] [int] NOT NULL ,
	[saghfeTedadi] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Qate4Import] (
	[qateId] [int] NOT NULL ,
	[radif] [float] NULL ,
	[des] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomarehFanni] [nvarchar] (12) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[qheimat] [int] NULL ,
	[saghfeTedadi] [int] NULL ,
	[VahedShomaresh] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[qheimatKol] [float] NULL ,
	[noeKhodro] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[RangeKhodro] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[rangeKhodroId] [int] NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[codeRangeKhodrosaz] [nvarchar] (5) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[baseRange] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Reports] (
	[id] [bigint] IDENTITY (1, 1) NOT NULL ,
	[rand] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[pName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[pValue] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[isValid] [bit] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Results] (
	[entityId] [int] NULL ,
	[id] [int] NULL ,
	[isSecure] [int] NULL ,
	[showInMenu] [int] NULL ,
	[ucBP] [int] NULL ,
	[ucDescr] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ucExec] [int] NULL ,
	[ucName] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ucOperation] [nvarchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ucTitle] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ucURL] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[Rokhdad] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[rokhdadId] [int] IDENTITY (1, 1) NOT NULL ,
	[sabtKonandeh] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[akharinTaghyirDahandeh] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[irad] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[zamaneVaghei] [datetime] NOT NULL ,
	[tel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mobile] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[address] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mantagheh] [int] NULL ,
	[sabetSayar] [int] NOT NULL ,
	[khadamateVijeh] [int] NOT NULL ,
	[eghdamShodeh] [int] NOT NULL ,
	[moshtarakId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[daftarOstaniId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shahrId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tarikhFaalShodan] [datetime] NULL ,
	[noeDarkhastKonandeh] [int] NULL ,
	[dastorkarGhabli] [int] NULL ,
	[kilometerKarkard] [int] NULL ,
	[iii] [int] NULL ,
	[guarantee] [int] NULL ,
	[noeService] [int] NULL ,
	[moshtarakYaNa] [int] NULL ,
	[kilometerkarkardGhabli] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Role] (
	[id] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[access] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[entity] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[role] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[roleId] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ServiceDorei] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[kilometerKarkard] [int] NULL ,
	[tarikh] [datetime] NULL ,
	[noeServiceDorei] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[hazineh] [int] NULL ,
	[moshtarakId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[taeedHesabdar] [int] NULL ,
	[taeedNamayandeh] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Shahr] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shahrName] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[shahrId] [int] NOT NULL ,
	[ostanId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[codeShahrKhodrosaz] [char] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[azArz] [int] NULL ,
	[taArz] [int] NULL ,
	[azTool] [int] NULL ,
	[taTool] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Shakhs] (
	[shakhsId] [int] IDENTITY (1, 1) NOT NULL ,
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[name] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[naghshId] [int] NOT NULL ,
	[daftarOstaniId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[username] [varchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[password] [varchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[roleGroup] [varchar] (32) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[entityId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[TamdidEshterak] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tarikhAkharinTamdid] [datetime] NULL ,
	[moshtarakId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[isLast] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[VazeatKhedmat] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[vazeatKhedmatId] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[admin_ACL] (
	[roleId] [int] NOT NULL ,
	[ucId] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[admin_ACL_bak] (
	[roleId] [int] NOT NULL ,
	[ucId] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[admin_BP] (
	[id] [int] NOT NULL ,
	[bpName] [varchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[bpTitle] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[bpDescr] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[bpCode] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[admin_Captions] (
	[captionId] [int] NOT NULL ,
	[caption] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[admin_Entity] (
	[id] [int] IDENTITY (1, 1) NOT NULL ,
	[entityName] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[entityTitle] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[entityDescr] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[admin_Roles] (
	[id] [int] NOT NULL ,
	[role] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[roleTitle] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[faraOstani] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[admin_UC] (
	[id] [int] IDENTITY (1, 1) NOT NULL ,
	[entityId] [int] NOT NULL ,
	[ucName] [varchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ucTitle] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ucDescr] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ucURL] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ucOperation] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ucBP] [int] NULL ,
	[ucExec] [int] NULL ,
	[showInMenu] [int] NULL ,
	[isSecure] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[azar] (
	[F1] [float] NULL ,
	[F2] [float] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[logs] (
	[data] [varchar] (128) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[src] [varchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[id] [int] IDENTITY (1, 1) NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[mehr] (
	[eshterakId] [char] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shasi] [char] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[namayandegi2017] (
	[rokhdadid] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[noeKhedmatminusone] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[emdadId] [int] IDENTITY (1, 1) NOT NULL ,
	[rokhdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeEmdad] [int] NOT NULL ,
	[zamanEzam] [datetime] NULL ,
	[zamanVagheiEzam] [datetime] NULL ,
	[ezamgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[emdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[vazeatKhedmatId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[kilometerKarkard] [int] NULL ,
	[faseleAzNamayandegi] [int] NULL ,
	[tozihat] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[modatTamir] [int] NULL ,
	[zamanShoro] [datetime] NULL ,
	[zamanVagheiShoro] [datetime] NULL ,
	[zamanPayan] [datetime] NULL ,
	[zamanVagheiPayan] [datetime] NULL ,
	[dalileToolKeshidaneEmdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[vazeatKonuni] [int] NULL ,
	[hazinehAyyabZahab] [int] NULL ,
	[hazinehBoxel] [int] NULL ,
	[hazinehJarsaghil] [int] NULL ,
	[hododeHazinehKol] [int] NULL ,
	[mablaghPardakhtShodeh] [int] NULL ,
	[akharinTagheerDahandeh] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[vazeatDakheli] [int] NULL ,
	[dastoorKarGhabli] [int] NULL ,
	[maliDone] [int] NULL ,
	[rahAndazi] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[elateService] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomarehFactor] [char] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeKhedmateVije] [int] NULL ,
	[koliyehMadarek] [int] NULL ,
	[ellateBargashteGuarantee] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[taeedHesabdar] [int] NULL ,
	[taeedGuarantee] [int] NULL ,
	[taeedNamayandegi] [int] NULL ,
	[iii] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[noeServiceDorei] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[name] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[hazineh] [int] NOT NULL ,
	[azKilometer] [int] NOT NULL ,
	[taKilometer] [int] NOT NULL ,
	[noeServiceDorei] [int] NOT NULL ,
	[hazineh2] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[o2] (
	[time] [float] NULL ,
	[name] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[code] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[qate2] (
	[qateId] [int] NOT NULL ,
	[radif] [float] NULL ,
	[name] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shomareFanni] [nvarchar] (12) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[gheimat] [int] NULL ,
	[saghfeTedadi] [int] NULL ,
	[VahedShomaresh] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[qheimatKol] [float] NULL ,
	[noeKhodro] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[rangeKhodroMapping] (
	[codeRangeKhodrosaz] [float] NULL ,
	[RangCodeEmdad] [float] NOT NULL ,
	[name] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[RangCode] [float] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[report_affixes] (
	[id] [int] NOT NULL ,
	[report_id] [int] NULL ,
	[prequery] [nvarchar] (1000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[postquery] [nvarchar] (1000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[priority] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[report_fields] (
	[id] [int] IDENTITY (1, 1) NOT NULL ,
	[reportId] [int] NOT NULL ,
	[fieldName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[fieldStaticName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[fontId] [int] NOT NULL ,
	[fontColor] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ffontSize] [int] NOT NULL ,
	[ColNo] [int] NOT NULL ,
	[realSize] [int] NOT NULL ,
	[className] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[alignment] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[arraylist] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[colCount] [int] NULL ,
	[vName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[dateFormat] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[report_fonts] (
	[id] [int] NOT NULL ,
	[fontName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[address] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[report_main] (
	[id] [int] NOT NULL ,
	[report_name] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[orientation] [int] NOT NULL ,
	[whereStatement] [nvarchar] (1000) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[condStatement] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[groupByStatement] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[orderByStatement] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[colCounter] [int] NULL ,
	[groupCounter] [int] NULL ,
	[fontId] [int] NOT NULL ,
	[fontsize] [int] NULL ,
	[grpfontSize] [int] NULL ,
	[prequery] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[postquery] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tozihat] [nvarchar] (1000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[report_parameters] (
	[id] [int] NOT NULL ,
	[reportId] [int] NOT NULL ,
	[staticName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[name] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[type] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[query] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[hidden] [int] NULL ,
	[type2] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[report_views_fieldss] (
	[id] [int] IDENTITY (1, 1) NOT NULL ,
	[reportId] [int] NOT NULL ,
	[fieldName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[fieldStaticName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[fontId] [int] NOT NULL ,
	[fontColor] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ffontSize] [int] NOT NULL ,
	[ColNo] [int] NOT NULL ,
	[realSize] [int] NOT NULL ,
	[className] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[paramClass] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[alignment] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[arraylist] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[colCount] [int] NULL ,
	[vName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[selectable] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[report_views_main] (
	[id] [int] NOT NULL ,
	[report_name] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[orientation] [int] NOT NULL ,
	[whereStatement] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[condStatement] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[groupByStatement] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[orderByStatement] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[colCounter] [int] NULL ,
	[groupCounter] [int] NULL ,
	[fontId] [int] NOT NULL ,
	[fontsize] [int] NULL ,
	[grpfontSize] [int] NULL ,
	[prequery] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[postquery] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[rokhdadtemp] (
	[rokhdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[rokhtmp] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[rokhdadId] [int] IDENTITY (1, 1) NOT NULL ,
	[sabtKonandeh] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[akharinTaghyirDahandeh] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[irad] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[zamaneVaghei] [datetime] NOT NULL ,
	[tel] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mobile] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[address] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mantagheh] [int] NULL ,
	[sabetSayar] [int] NOT NULL ,
	[khadamateVijeh] [int] NOT NULL ,
	[eghdamShodeh] [int] NOT NULL ,
	[moshtarakId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[namayandegiId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[daftarOstaniId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[shahrId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[tarikhFaalShodan] [datetime] NULL ,
	[noeDarkhastKonandeh] [int] NULL ,
	[dastorkarGhabli] [int] NULL ,
	[kilometerKarkard] [int] NULL ,
	[iii] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[roles] (
	[id] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[access] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[entity] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[roleId] [int] NULL ,
	[role] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[shomtran] (
	[CMFAM] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMNAM] [nvarchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMFNM] [nvarchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMPLC] [nvarchar] (4) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMINO] [nvarchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMECO] [nvarchar] (11) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMADR] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMTEL] [nvarchar] (11) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMTELCD] [nvarchar] (6) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMCTY] [nvarchar] (4) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CACOD] [nvarchar] (3) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CAMOT] [nvarchar] (14) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CABODY] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHERKAT] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CASHA] [nvarchar] (14) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SANADDT] [nvarchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SANADNO] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[PELAC] [nvarchar] (6) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CSTMTYP] [nvarchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[COLOR] [nvarchar] (5) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[STAT] [nvarchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHOMAREH] [float] NULL ,
	[POST] [float] NULL ,
	[AVARZ] [float] NULL ,
	[KHAZ] [float] NULL ,
	[BPLAC] [float] NULL ,
	[METRO] [float] NULL ,
	[POSTI] [nvarchar] (7) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[MODEL] [nvarchar] (4) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[YEKDR] [float] NULL ,
	[S_ER1] [nvarchar] (2) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[DOU1] [smallint] NULL ,
	[HARF1] [nvarchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SEH1] [smallint] NULL ,
	[PL1] [nvarchar] (2) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[AGN] [nvarchar] (4) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[OSTAN] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHAHR] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CARDES] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[RANGDES] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[AMOUNT] [float] NULL ,
	[VAZ_DAT] [nvarchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[shomtrandiff] (
	[CMFAM] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMNAM] [nvarchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMFNM] [nvarchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMPLC] [nvarchar] (4) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMINO] [nvarchar] (15) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMECO] [nvarchar] (11) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMADR] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMTEL] [nvarchar] (11) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMTELCD] [nvarchar] (6) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMCTY] [nvarchar] (4) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CACOD] [nvarchar] (3) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CAMOT] [nvarchar] (14) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CABODY] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHERKAT] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CASHA] [nvarchar] (14) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SANADDT] [nvarchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SANADNO] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[PELAC] [nvarchar] (6) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CSTMTYP] [nvarchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[COLOR] [nvarchar] (5) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[STAT] [nvarchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHOMAREH] [float] NULL ,
	[POST] [float] NULL ,
	[AVARZ] [float] NULL ,
	[KHAZ] [float] NULL ,
	[BPLAC] [float] NULL ,
	[METRO] [float] NULL ,
	[POSTI] [nvarchar] (7) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[MODEL] [nvarchar] (4) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[YEKDR] [float] NULL ,
	[S_ER1] [nvarchar] (2) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[DOU1] [smallint] NULL ,
	[HARF1] [nvarchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SEH1] [smallint] NULL ,
	[PL1] [nvarchar] (2) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[AGN] [nvarchar] (4) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[OSTAN] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHAHR] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CARDES] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[RANGDES] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[AMOUNT] [float] NULL ,
	[VAZ_DAT] [nvarchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[sub_cars] (
	[chassisno] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[syncId] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[subs2] (
	[subscriptionId] [char] (18) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[chassisno] [char] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[subscriptionDate] [datetime] NOT NULL ,
	[expireDate] [datetime] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[tempfields] (
	[id] [int] IDENTITY (1, 1) NOT NULL ,
	[eid] [int] NULL ,
	[fieldName] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ClassName] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[length] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[StaticName] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[fontId] [int] NOT NULL ,
	[fontColor] [int] NOT NULL ,
	[fontSize] [int] NOT NULL ,
	[ColNo] [int] NOT NULL ,
	[RealSize] [int] NOT NULL ,
	[ParamClass] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[Alignment] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ArrayList] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ColCount] [int] NOT NULL ,
	[Vname] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[temppd] (
	[id] [int] NOT NULL ,
	[reportId] [int] NOT NULL ,
	[staticName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[name] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[type] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[query] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[hidden] [int] NULL 
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[temppp] (
	[id] [int] NOT NULL ,
	[reportId] [int] NOT NULL ,
	[fieldName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[fieldStaticName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[fontId] [int] NOT NULL ,
	[fontColor] [nvarchar] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ffontSize] [int] NOT NULL ,
	[ColNo] [int] NOT NULL ,
	[realSize] [int] NOT NULL ,
	[className] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[alignment] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[arraylist] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[colCount] [int] NULL ,
	[vName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[tempxx] (
	[shomareShasi] [nvarchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[zamaneVaghei] [datetime] NOT NULL ,
	[iradId] [varchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[rahAndazi] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[bazaryabId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[views_fields] (
	[id] [int] IDENTITY (1, 1) NOT NULL ,
	[reportId] [int] NOT NULL ,
	[fieldId] [int] NOT NULL ,
	[Alias] [nvarchar] (200) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[StaticName] [nvarchar] (200) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[ArrayList] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[selectable] [int] NULL 
) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.AnbarEmdadgarList AS SELECT TOP 100 PERCENT dbo.AnbarEmdadgar.id, dbo.Emdadgar.name AS nameEmdadgar, dbo.Qate.qateId, dbo.Qate.name AS nameQate, dbo.AnbarEmdadgar.mojoodi, dbo.DaftarOstani.name AS nameDaftarOstani, dbo.DaftarOstani.id AS idDaftarOstani, dbo.Emdadgar.id AS idEmdadgar, dbo.Qate.id AS idQate FROM dbo.Emdadgar INNER JOIN dbo.DaftarOstani ON dbo.Emdadgar.daftarOstaniId = dbo.DaftarOstani.id INNER JOIN dbo.AnbarEmdadgar ON dbo.Emdadgar.id = dbo.AnbarEmdadgar.emdadgarId INNER JOIN dbo.Qate ON dbo.AnbarEmdadgar.qateId = dbo.Qate.id ORDER BY dbo.Emdadgar.name 
GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.MoshtarakList
AS
SELECT     TOP 100 PERCENT dbo.Moshtarak.id, dbo.Moshtarak.eshterakId, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.noeService, dbo.Moshtarak.vazeat, 
                      dbo.Moshtarak.nameKhanevadegi, dbo.Moshtarak.name, dbo.Moshtarak.shomarePelak, dbo.Moshtarak.tarikhShoro, dbo.Moshtarak.tarikhEngheza, 
                      dbo.Moshtarak.guarantee, dbo.Moshtarak.moshtarakYaNa, dbo.Moshtarak.noeKhodroId, dbo.Moshtarak.shomareMotor, dbo.Moshtarak.mobile, 
                      dbo.Moshtarak.address, dbo.Moshtarak.tel, dbo.Moshtarak.postCode, dbo.Moshtarak.mahaleServiceAvalieh, dbo.Moshtarak.tarikhAkharinEmail, 
                      dbo.Moshtarak.shomareVIN, dbo.Moshtarak.tarikhTavalod, dbo.Moshtarak.tarikhServiceAvalieh, dbo.Moshtarak.tarikhEnghezaGuarantee, 
                      dbo.Moshtarak.shomareShasi, dbo.Moshtarak.tarikhTahvil, dbo.Moshtarak.email, dbo.Moshtarak.tarikhAkharinTamdid, dbo.Moshtarak.saleSakht, 
                      dbo.NoeKhodro.id AS idNoeKhodro, dbo.NoeKhodro.onvan, dbo.Moshtarak.rangeKhodroId, dbo.Moshtarak.shahrId, dbo.Moshtarak.bazaryabId, 
                      dbo.Moshtarak.hazinehPardakhtShodeh, dbo.Moshtarak.namayandegi, dbo.Moshtarak.majaziYaNa
FROM         dbo.Moshtarak INNER JOIN
                      dbo.NoeKhodro ON dbo.Moshtarak.noeKhodroId = dbo.NoeKhodro.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.MoshtarakReport
AS
SELECT     TOP 100 PERCENT dbo.Moshtarak.id, dbo.Moshtarak.eshterakId, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.noeService, dbo.Moshtarak.vazeat, 
                      dbo.Moshtarak.nameKhanevadegi, dbo.Moshtarak.name, dbo.Moshtarak.shomarePelak, dbo.Moshtarak.tarikhShoro, dbo.Moshtarak.tarikhEngheza, 
                      dbo.Moshtarak.guarantee, dbo.Moshtarak.moshtarakYaNa, dbo.Moshtarak.noeKhodroId, dbo.NoeKhodro.onvan
FROM         dbo.Moshtarak INNER JOIN
                      dbo.NoeKhodro ON dbo.Moshtarak.noeKhodroId = dbo.NoeKhodro.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.VIEW_joins
AS
SELECT     dbo.Emdad.noeEmdad, dbo.Emdad.emdadId, dbo.Emdadgar.name, dbo.Namayandegi.namayandegiId, dbo.NoeEmdadgar.onvan
FROM         dbo.Emdadgar INNER JOIN
                      dbo.NoeEmdadgar ON dbo.Emdadgar.noeEmdadgarId = dbo.NoeEmdadgar.id RIGHT OUTER JOIN
                      dbo.Moshtarak INNER JOIN
                      dbo.Rokhdad INNER JOIN
                      dbo.Emdad ON dbo.Rokhdad.id = dbo.Emdad.rokhdadId ON dbo.Moshtarak.id = dbo.Rokhdad.moshtarakId ON 
                      dbo.Emdadgar.id = dbo.Emdad.emdadgarId LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Emdad.namayandegiId = dbo.Namayandegi.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.emdadList
AS
SELECT     TOP 100 PERCENT dbo.Emdad.id, dbo.Emdad.emdadId, dbo.Emdad.dastoorKarGhabli, dbo.Emdad.vazeatDakheli, dbo.Rokhdad.rokhdadId, 
                      dbo.Moshtarak.eshterakId, dbo.DaftarOstani.name AS nameDaftarOstani, dbo.VazeatKhedmat.onvan, dbo.Emdadgar.name AS nameEmdadgar, 
                      dbo.Shakhs.name AS nameShakhs, dbo.Emdad.zamanEzam, dbo.Emdad.vazeatKonuni, dbo.Emdad.noeEmdad, dbo.Emdad.zamanVagheiEzam, 
                      dbo.Emdad.zamanShoro, dbo.Emdad.zamanVagheiShoro, dbo.Emdad.zamanPayan, dbo.Emdad.zamanVagheiPayan, 
                      dbo.Emdad.akharinTagheerDahandeh, dbo.Emdad.kilometerKarkard, dbo.Emdad.mablaghPardakhtShodeh, dbo.Emdad.hododeHazinehKol, 
                      dbo.Emdad.faseleAzNamayandegi, dbo.Emdad.emdadgarId, dbo.Rokhdad.daftarOstaniId, dbo.Emdad.rokhdadId AS rokhdadIdO, dbo.Emdad.maliDone, 
                      dbo.Rokhdad.moshtarakId, dbo.Emdad.rahAndazi, dbo.Emdad.elateService, dbo.Namayandegi.name AS nameNamayandegi, 
                      dbo.Emdad.namayandegiId AS namayandegiIdO, dbo.Emdad.ezamgarId, dbo.Emdad.vazeatKhedmatId, dbo.Namayandegi.namayandegiId, 
                      dbo.Emdad.taeedHesabdar, dbo.Emdad.taeedGuarantee, dbo.Emdad.taeedNamayandegi, dbo.Rokhdad.address, dbo.Moshtarak.shomarePelak, 
                      dbo.Emdad.shomarehFactor, dbo.Emdad.ellateBargashteGuarantee, dbo.Emdad.koliyehMadarek, dbo.Emdad.hazinehAyyabZahab, 
                      dbo.Emdad.hazinehBoxel, dbo.Rokhdad.irad, dbo.Emdadgar.mobile, dbo.Rokhdad.kilometerkarkardGhabli, dbo.Emdad.noeEmdadgarId
FROM         dbo.Moshtarak INNER JOIN
                      dbo.Rokhdad ON dbo.Moshtarak.id = dbo.Rokhdad.moshtarakId INNER JOIN
                      dbo.DaftarOstani ON dbo.Rokhdad.daftarOstaniId = dbo.DaftarOstani.id INNER JOIN
                      dbo.Emdad INNER JOIN
                      dbo.Shakhs ON dbo.Emdad.ezamgarId = dbo.Shakhs.id ON dbo.Rokhdad.id = dbo.Emdad.rokhdadId INNER JOIN
                      dbo.VazeatKhedmat ON dbo.Emdad.vazeatKhedmatId = dbo.VazeatKhedmat.id LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Emdad.namayandegiId = dbo.Namayandegi.id LEFT OUTER JOIN
                      dbo.Emdadgar ON dbo.Emdad.emdadgarId = dbo.Emdadgar.id
ORDER BY dbo.Emdad.emdadId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

create view report_views_fields as
SELECT     dbo.views_fields.fieldId, dbo.views_fields.reportId, dbo.admin_Entity.entityName, dbo.views_fields.id, dbo.tempfields.ClassName, dbo.tempfields.fontId, 
                      dbo.tempfields.fontColor, dbo.tempfields.fontSize, dbo.tempfields.ColNo, dbo.tempfields.RealSize, dbo.tempfields.ParamClass, 
                      dbo.tempfields.Alignment, dbo.tempfields.ColCount, dbo.tempfields.Vname, fieldName = CASE WHEN views_fields.Alias IS NULL 
                      THEN tempfields.fieldName ELSE views_fields.Alias END, fieldStaticName = CASE WHEN views_fields.staticName IS NULL 
                      THEN tempfields.staticName ELSE views_fields.staticName END, ArrayList = CASE WHEN views_fields.ArrayList IS NULL 
                      THEN tempfields.ArrayList ELSE views_fields.ArrayList END, dbo.views_fields.selectable
FROM         dbo.admin_Entity INNER JOIN
                      dbo.tempfields ON dbo.admin_Entity.id = dbo.tempfields.eid INNER JOIN
                      dbo.views_fields ON dbo.tempfields.id = dbo.views_fields.fieldId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.report_views_fields
AS
SELECT     dbo.views_fields.fieldId, dbo.admin_Entity.entityName, dbo.tempfields.id, dbo.tempfields.ClassName, dbo.tempfields.fontId, dbo.tempfields.fontColor, 
                      dbo.tempfields.fontSize, dbo.tempfields.ColNo, dbo.tempfields.RealSize, dbo.tempfields.ParamClass, dbo.tempfields.Alignment, 
                      dbo.tempfields.ColCount, dbo.tempfields.Vname, fieldName = CASE WHEN views_fields.Alias IS NULL 
                      THEN tempfields.fieldName ELSE views_fields.Alias END, StaticName = CASE WHEN views_fields.staticName IS NULL 
                      THEN tempfields.staticName ELSE views_fields.staticName END, ArrayList = CASE WHEN views_fields.ArrayList IS NULL 
                      THEN tempfields.ArrayList ELSE views_fields.ArrayList END
FROM         dbo.admin_Entity INNER JOIN
                      dbo.tempfields ON dbo.admin_Entity.id = dbo.tempfields.eid INNER JOIN
                      dbo.views_fields ON dbo.tempfields.id = dbo.views_fields.fieldId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

create view report_views_fields as
SELECT     dbo.views_fields.fieldId,dbo.views_fields.reportId, dbo.admin_Entity.entityName, dbo.tempfields.id, dbo.tempfields.ClassName, dbo.tempfields.fontId, dbo.tempfields.fontColor, 
                      dbo.tempfields.fontSize, dbo.tempfields.ColNo, dbo.tempfields.RealSize, dbo.tempfields.ParamClass, dbo.tempfields.Alignment, 
                      dbo.tempfields.ColCount, dbo.tempfields.Vname, fieldName = CASE WHEN views_fields.Alias IS NULL 
                      THEN tempfields.fieldName ELSE views_fields.Alias END, fieldStaticName = CASE WHEN views_fields.staticName IS NULL 
                      THEN tempfields.staticName ELSE views_fields.staticName END, ArrayList = CASE WHEN views_fields.ArrayList IS NULL 
                      THEN tempfields.ArrayList ELSE views_fields.ArrayList END,dbo.views_fields.selectable
FROM         dbo.admin_Entity INNER JOIN
                      dbo.tempfields ON dbo.admin_Entity.id = dbo.tempfields.eid INNER JOIN
                      dbo.views_fields ON dbo.tempfields.id = dbo.views_fields.fieldId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.rokhdadList
AS
SELECT     TOP 100 PERCENT dbo.Rokhdad.id, dbo.Rokhdad.rokhdadId, dbo.Rokhdad.address, dbo.Rokhdad.sabetSayar, dbo.Moshtarak.eshterakId, 
                      dbo.DaftarOstani.name AS nameDaftarOstani, dbo.Shahr.shahrName, dbo.Rokhdad.tarikhFaalShodan, dbo.Rokhdad.zamaneVaghei, 
                      dbo.Rokhdad.khadamateVijeh, dbo.Namayandegi.name AS nameNamayandegi, dbo.Rokhdad.tel, dbo.Rokhdad.mobile, dbo.Rokhdad.irad, 
                      dbo.Rokhdad.mantagheh, dbo.Rokhdad.daftarOstaniId, dbo.Rokhdad.noeDarkhastKonandeh, dbo.Rokhdad.shahrId, dbo.Rokhdad.dastorkarGhabli, 
                      dbo.NoeKhodro.onvan AS noeKhodroName, dbo.RangeKhodro.onvan AS rangOnvan, Shakhs_1.name AS sabtKonandeh, 
                      Shakhs_2.name AS akharinTaghyirDahandeh, dbo.Moshtarak.tarikhTahvil, dbo.Moshtarak.shomarePelak, dbo.Rokhdad.eghdamShodeh, 
                      dbo.Rokhdad.kilometerKarkard, dbo.Rokhdad.noeService, dbo.Rokhdad.moshtarakYaNa, dbo.Rokhdad.guarantee
FROM         dbo.DaftarOstani INNER JOIN
                      dbo.Rokhdad ON dbo.DaftarOstani.id = dbo.Rokhdad.daftarOstaniId INNER JOIN
                      dbo.Moshtarak ON dbo.Rokhdad.moshtarakId = dbo.Moshtarak.id INNER JOIN
                      dbo.Shahr ON dbo.Rokhdad.shahrId = dbo.Shahr.id INNER JOIN
                      dbo.NoeKhodro ON dbo.Moshtarak.noeKhodroId = dbo.NoeKhodro.id INNER JOIN
                      dbo.RangeKhodro ON dbo.Moshtarak.rangeKhodroId = dbo.RangeKhodro.id LEFT OUTER JOIN
                      dbo.Shakhs Shakhs_2 ON dbo.Rokhdad.akharinTaghyirDahandeh = Shakhs_2.id LEFT OUTER JOIN
                      dbo.Shakhs Shakhs_1 ON dbo.Rokhdad.sabtKonandeh = Shakhs_1.id LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Rokhdad.namayandegiId = dbo.Namayandegi.id
ORDER BY dbo.Rokhdad.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

create view test as select rokhdad.moshtarakyana as rm , moshtarak.moshtarakyana as mm
from rokhdad, moshtarak
where rokhdad.moshtarakid=moshtarak.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

create view test1 as select emdad.noeemdadgarid as mn, noeemdadgar.id as mm from 
emdad, noeemdadgar, emdadgar
where emdad.emdadgarid=emdadgar.id  and emdadgar.noeemdadgarid=noeemdadgar.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO


create view test3 as select emdad.emdadid as t	, rokhdad.id as r, emdad.rahandazi as s
from emdad, rokhdad
where emdad.rokhdadid=rokhdad.id and rokhdad.moshtarakid='BE8080808080808080o'


GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.tttttteeeeemmmppp
AS
SELECT     dbo.Emdad.emdadId, dbo.Emdad.emdadgarId, dbo.Emdadgar.noeEmdadgarId, dbo.Emdad.noeEmdadgarId AS asl
FROM         dbo.Emdad INNER JOIN
                      dbo.Emdadgar ON dbo.Emdad.emdadgarId = dbo.Emdadgar.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.userRoles
AS
SELECT DISTINCT dbo.Shakhs.username, dbo.Shakhs.roleGroup, dbo.admin_Roles.role
FROM         dbo.Shakhs INNER JOIN
                      dbo.admin_Roles ON dbo.Shakhs.naghshId = dbo.admin_Roles.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_Mali
AS
SELECT     TOP 100 PERCENT dbo.Emdad.id, dbo.Emdad.emdadId, dbo.Emdad.dastoorKarGhabli, dbo.Moshtarak.eshterakId, 
                      dbo.Emdadgar.name AS nameEmdadgar, dbo.Shakhs.name AS nameShakhs, dbo.Emdad.emdadgarId, dbo.Rokhdad.daftarOstaniId, 
                      dbo.Emdadgar.noeEmdadgarId, dbo.Rokhdad.moshtarakId, CAST(dbo.Namayandegi.namayandegiId AS nvarchar) 
                      + '-' + dbo.Namayandegi.name AS nameNamayandegi, dbo.Namayandegi.namayandegiId, dbo.Rokhdad.address, dbo.Moshtarak.shomarePelak, 
                      dbo.Emdad.shomarehFactor, dbo.Rokhdad.irad, dbo.Emdadgar.mobile, dbo.JozeatKhedmat.khedmatId, dbo.Emdad.ezamgarId, 
                      dbo.JozeatKhedmat.guarantee, dbo.JozeatKhedmat.nahveyePardakht, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.moshtarakYaNa, 
                      dbo.Emdad.zamanEzam, dbo.Emdad.noeEmdad, dbo.JozeatKhedmat.qateId, dbo.DaftarOstani.name, dbo.NoeEmdadgar.onvan AS noeEmdadgarName, 
                      dbo.Namayandegi.noeNamayandegi, dbo.Qate.name AS quateName, dbo.Ojrat.onvan AS sharhOjrat, dbo.JozeatKhedmat.hazineh, 
                      dbo.Emdad.namayandegiId AS Expr1, dbo.Emdad.maliDone
FROM         dbo.Moshtarak INNER JOIN
                      dbo.Rokhdad ON dbo.Moshtarak.id = dbo.Rokhdad.moshtarakId INNER JOIN
                      dbo.DaftarOstani ON dbo.Rokhdad.daftarOstaniId = dbo.DaftarOstani.id INNER JOIN
                      dbo.Emdad INNER JOIN
                      dbo.Shakhs ON dbo.Emdad.ezamgarId = dbo.Shakhs.id ON dbo.Rokhdad.id = dbo.Emdad.rokhdadId INNER JOIN
                      dbo.VazeatKhedmat ON dbo.Emdad.vazeatKhedmatId = dbo.VazeatKhedmat.id LEFT OUTER JOIN
                      dbo.Qate RIGHT OUTER JOIN
                      dbo.JozeatKhedmat ON dbo.Qate.id = dbo.JozeatKhedmat.qateId LEFT OUTER JOIN
                      dbo.Ojrat ON dbo.JozeatKhedmat.ojratId = dbo.Ojrat.id ON dbo.Emdad.id = dbo.JozeatKhedmat.khedmatId LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Emdad.namayandegiId = dbo.Namayandegi.id LEFT OUTER JOIN
                      dbo.NoeEmdadgar INNER JOIN
                      dbo.Emdadgar ON dbo.NoeEmdadgar.id = dbo.Emdadgar.noeEmdadgarId ON dbo.Emdad.emdadgarId = dbo.Emdadgar.id
ORDER BY dbo.Emdad.emdadId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_PeigiriEzamgar
AS
SELECT     dbo.PeigiriEzamgar.zamanPeigiri, dbo.PeigiriEzamgar.natije, dbo.Emdad.emdadId, dbo.PeigiriEzamgar.id, 
                      dbo.PeigiriEzamgar.emdadId AS emdadIdO
FROM         dbo.Emdad INNER JOIN
                      dbo.PeigiriEzamgar ON dbo.Emdad.id = dbo.PeigiriEzamgar.emdadId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_adminMenu
AS
SELECT     TOP 100 PERCENT dbo.admin_BP.bpTitle, dbo.admin_BP.bpDescr, dbo.admin_BP.bpName, dbo.admin_UC.ucName, dbo.admin_UC.ucTitle, 
                      dbo.admin_UC.ucDescr, dbo.admin_UC.ucURL, dbo.admin_Roles.role
FROM         dbo.admin_ACL INNER JOIN
                      dbo.admin_UC ON dbo.admin_ACL.ucId = dbo.admin_UC.id INNER JOIN
                      dbo.admin_Roles ON dbo.admin_ACL.roleId = dbo.admin_Roles.id INNER JOIN
                      dbo.admin_BP ON dbo.admin_UC.ucBP = dbo.admin_BP.id
WHERE     (dbo.admin_UC.showInMenu = 1)
ORDER BY dbo.admin_BP.bpCode, dbo.admin_UC.entityId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_anbarEmdadgar
AS
SELECT     dbo.AnbarEmdadgar.id, dbo.AnbarEmdadgar.mojoodi, dbo.AnbarEmdadgar.qateId AS qateIdO, dbo.AnbarEmdadgar.emdadgarId, dbo.Qate.qateId, 
                      dbo.Qate.name AS qateName, dbo.Qate.shomareFanni, dbo.Emdadgar.name AS emdadgarName, dbo.Emdadgar.daftarOstaniId, dbo.Qate.gheimat, 
                      dbo.DaftarOstani.name AS daftarOstaniName
FROM         dbo.AnbarEmdadgar INNER JOIN
                      dbo.Emdadgar ON dbo.AnbarEmdadgar.emdadgarId = dbo.Emdadgar.id INNER JOIN
                      dbo.Qate ON dbo.AnbarEmdadgar.qateId = dbo.Qate.id INNER JOIN
                      dbo.DaftarOstani ON dbo.Emdadgar.daftarOstaniId = dbo.DaftarOstani.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_bazaryab AS SELECT dbo.Bazaryab.id, dbo.Bazaryab.bazaryabKey, dbo.Bazaryab.noeBazaryabId, dbo.BazaryabName(dbo.Bazaryab.bazaryabKey, dbo.Bazaryab.noeBazaryabId) AS bazaryabName, dbo.Bazaryab.bazaryabId, dbo.NoeBazaryab.onvan, dbo.NoeBazaryab.entity FROM dbo.Bazaryab INNER JOIN dbo.NoeBazaryab ON dbo.Bazaryab.noeBazaryabId = dbo.NoeBazaryab.id 
GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_darkhastEshterak
AS
SELECT     dbo.DarkhastEshterak.*, dbo.Shahr.shahrName, dbo.NoeKhodro.onvan
FROM         dbo.DarkhastEshterak INNER JOIN
                      dbo.NoeKhodro ON dbo.DarkhastEshterak.noeKhodroId = dbo.NoeKhodro.id INNER JOIN
                      dbo.RangeKhodro ON dbo.DarkhastEshterak.rangeKhodroId = dbo.RangeKhodro.id INNER JOIN
                      dbo.Shahr ON dbo.DarkhastEshterak.shahrId = dbo.Shahr.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

Create View view_darkhasttagheer as 
Select  darkhasttagheer.id, darkhasttagheer.Noeservice, darkhasttagheer.NameKhanevadegi, moshtarak.Noeservice as oldNoeservice,
            moshtarak.NameKhanevadegi as oldNameKhanevadegi, darkhasttagheer.Mobile,moshtarak.Mobile as oldMobile,
            darkhasttagheer.Name,moshtarak.Name as oldName,darkhasttagheer.Tel,moshtarak.Tel as oldTel, moshtarak.eshterakId,
            darkhasttagheer.email,darkhasttagheer.PostCode,darkhasttagheer.ShomarePelak,darkhasttagheer.TarikhTavalod,
            darkhasttagheer.moshtarakid,darkhasttagheer.ijadkonandeh From darkhasttagheer INNER JOIN
            moshtarak ON darkhasttagheer.moshtarakid = moshtarak.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_emdad
AS
SELECT     TOP 100 PERCENT dbo.Emdad.id, dbo.Emdad.emdadId, dbo.Emdad.dastoorKarGhabli, dbo.Emdad.vazeatDakheli, dbo.Rokhdad.rokhdadId, 
                      dbo.Moshtarak.eshterakId, dbo.DaftarOstani.name AS nameDaftarOstani, dbo.VazeatKhedmat.onvan, dbo.Emdadgar.name AS nameEmdadgar, 
                      dbo.Shakhs.name AS nameShakhs, dbo.Emdad.zamanEzam, dbo.Emdad.vazeatKonuni, dbo.Emdad.noeEmdad, dbo.Emdad.zamanVagheiEzam, 
                      dbo.Emdad.zamanShoro, dbo.Emdad.zamanVagheiShoro, dbo.Emdad.zamanPayan, dbo.Emdad.zamanVagheiPayan, 
                      dbo.Emdad.akharinTagheerDahandeh, dbo.Emdad.kilometerKarkard, dbo.Emdad.mablaghPardakhtShodeh, dbo.Emdad.hododeHazinehKol, 
                      dbo.Emdad.faseleAzNamayandegi, dbo.Emdad.emdadgarId, dbo.Rokhdad.daftarOstaniId, dbo.Emdadgar.noeEmdadgarId, 
                      dbo.Emdad.rokhdadId AS rokhdadIdO, dbo.Emdad.maliDone, dbo.Rokhdad.moshtarakId, dbo.Emdad.rahAndazi, dbo.Emdad.elateService, 
                      dbo.Namayandegi.name AS nameNamayandegi, dbo.Emdad.namayandegiId AS namayandegiIdO, dbo.Emdad.ezamgarId, 
                      dbo.Emdad.vazeatKhedmatId, dbo.Namayandegi.namayandegiId, dbo.Emdad.taeedHesabdar, dbo.Emdad.taeedGuarantee, 
                      dbo.Emdad.taeedNamayandegi, dbo.Rokhdad.address, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.guarantee, dbo.Moshtarak.noeService, 
                      dbo.Moshtarak.tarikhEnghezaGuarantee, dbo.Moshtarak.tarikhEngheza, dbo.Moshtarak.vazeat, dbo.Moshtarak.moshtarakYaNa
FROM         dbo.Moshtarak INNER JOIN
                      dbo.Rokhdad ON dbo.Moshtarak.id = dbo.Rokhdad.moshtarakId INNER JOIN
                      dbo.DaftarOstani ON dbo.Rokhdad.daftarOstaniId = dbo.DaftarOstani.id INNER JOIN
                      dbo.Emdad INNER JOIN
                      dbo.Shakhs ON dbo.Emdad.ezamgarId = dbo.Shakhs.id ON dbo.Rokhdad.id = dbo.Emdad.rokhdadId INNER JOIN
                      dbo.VazeatKhedmat ON dbo.Emdad.vazeatKhedmatId = dbo.VazeatKhedmat.id LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Emdad.namayandegiId = dbo.Namayandegi.id LEFT OUTER JOIN
                      dbo.Emdadgar ON dbo.Emdad.emdadgarId = dbo.Emdadgar.id
ORDER BY dbo.Emdad.emdadId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_emdadRokhdad
AS
SELECT     DATEDIFF(mi, dbo.Rokhdad.zamaneVaghei, dbo.Emdad.zamanEzam) AS modatZamanEzam, DATEDIFF(mi, dbo.Emdad.zamanEzam, 
                      dbo.Emdad.zamanShoro) AS modatZamanResidan, DATEDIFF(mi, dbo.Emdad.zamanShoro, dbo.Emdad.zamanPayan) AS modatZamanAnjam, 
                      DATEDIFF(mi, dbo.Rokhdad.zamaneVaghei, dbo.Emdad.zamanShoro) AS modatZamanEntezar, dbo.Rokhdad.rokhdadId, dbo.Rokhdad.zamaneVaghei, 
                      dbo.Emdad.emdadId, dbo.Emdad.noeEmdad, dbo.Emdad.zamanEzam, dbo.Emdad.zamanVagheiEzam, dbo.Emdad.ezamgarId, 
                      dbo.Emdad.emdadgarId, dbo.Emdad.zamanShoro, dbo.Emdad.zamanVagheiShoro, dbo.Emdad.zamanVagheiPayan, dbo.Emdad.zamanPayan, 
                      dbo.Rokhdad.shahrId, dbo.Emdad.id, dbo.Emdad.namayandegiId, dbo.Rokhdad.sabtKonandeh, dbo.Rokhdad.moshtarakId, dbo.Rokhdad.irad, 
                      dbo.Emdad.rahAndazi, dbo.Rokhdad.sabetSayar, dbo.Rokhdad.address, dbo.Emdad.noeKhedmateVije, dbo.Emdad.kilometerKarkard, 
                      dbo.Rokhdad.mantagheh, dbo.Emdad.vazeatKonuni, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.eshterakId, dbo.Moshtarak.noeKhodroId, 
                      dbo.NoeKhodro.onvan, Shakhs_1.name AS ezamgar, CAST(dbo.Namayandegi.namayandegiId AS nvarchar) 
                      + '-' + dbo.Namayandegi.name AS namayandegi, dbo.Emdadgar.name AS emdadgar, dbo.Emdadgar.noeEmdadgarId, 
                      dbo.NoeEmdadgar.onvan AS noeEmdadgar, Shakhs_2.name AS akharinTagheerDahandeh, Shakhs_3.name AS pazireshgar, 
                      dbo.Rokhdad.daftarOstaniId, dbo.Rokhdad.moshtarakYaNa, dbo.Rokhdad.tel, dbo.Rokhdad.mobile, dbo.Moshtarak.shomarePelak, 
                      dbo.Moshtarak.shomareShasi, dbo.Emdad.vazeatKhedmatId
FROM         dbo.Shakhs Shakhs_2 INNER JOIN
                      dbo.Emdad INNER JOIN
                      dbo.Rokhdad ON dbo.Emdad.rokhdadId = dbo.Rokhdad.id INNER JOIN
                      dbo.Moshtarak ON dbo.Rokhdad.moshtarakId = dbo.Moshtarak.id INNER JOIN
                      dbo.NoeKhodro ON dbo.Moshtarak.noeKhodroId = dbo.NoeKhodro.id INNER JOIN
                      dbo.Shakhs Shakhs_3 ON dbo.Rokhdad.sabtKonandeh = Shakhs_3.id INNER JOIN
                      dbo.Shakhs Shakhs_1 ON dbo.Emdad.ezamgarId = Shakhs_1.id ON Shakhs_2.id = dbo.Emdad.akharinTagheerDahandeh LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Emdad.namayandegiId = dbo.Namayandegi.id LEFT OUTER JOIN
                      dbo.NoeEmdadgar INNER JOIN
                      dbo.Emdadgar ON dbo.NoeEmdadgar.id = dbo.Emdadgar.noeEmdadgarId ON dbo.Emdad.emdadgarId = dbo.Emdadgar.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_emdadgar
AS
SELECT     dbo.Emdadgar.id, dbo.Emdadgar.emdadgarId, dbo.Emdadgar.name, dbo.Emdadgar.tel, dbo.Emdadgar.mobile, dbo.Emdadgar.address, 
                      dbo.Emdadgar.satheMaharat, dbo.Emdadgar.saghfeMojoodi, dbo.Emdadgar.vazeat, dbo.Emdadgar.hadaksarKar, dbo.Emdadgar.karDarDast, 
                      dbo.Emdadgar.noeEmdadgarId, dbo.Emdadgar.daftarOstaniId, dbo.Emdadgar.namayandegiId, dbo.NoeEmdadgar.onvan, dbo.Emdadgar.azArz, 
                      dbo.Emdadgar.taArz, dbo.Emdadgar.azTool, dbo.Emdadgar.taTool
FROM         dbo.NoeEmdadgar INNER JOIN
                      dbo.Emdadgar ON dbo.NoeEmdadgar.id = dbo.Emdadgar.noeEmdadgarId INNER JOIN
                      dbo.DaftarOstani ON dbo.Emdadgar.daftarOstaniId = dbo.DaftarOstani.id LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Emdadgar.namayandegiId = dbo.Namayandegi.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_jozeatKasri
AS
SELECT     dbo.KasriEmdad.tarikh, dbo.KasriEmdad.kasriId, dbo.KasriEmdad.tahvilshod, dbo.KasriEmdad.taeedAnbardar, dbo.KasriEmdad.taeedEmdadgar, 
                      dbo.Emdadgar.name AS emdadgarName, dbo.KasriEmdad.emdadgarId, dbo.JozeatKasri.tedadEmdadgar, dbo.JozeatKasri.tedadKasri, 
                      dbo.JozeatKasri.tedadAnbar, dbo.JozeatKasri.id, dbo.JozeatKasri.kasriEmdadId, dbo.Qate.shomareFanni, dbo.Qate.name AS qateName
FROM         dbo.KasriEmdad INNER JOIN
                      dbo.Emdadgar ON dbo.KasriEmdad.emdadgarId = dbo.Emdadgar.id INNER JOIN
                      dbo.JozeatKasri ON dbo.KasriEmdad.id = dbo.JozeatKasri.kasriEmdadId INNER JOIN
                      dbo.Qate ON dbo.JozeatKasri.qateId = dbo.Qate.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_jozeatKhedmat
AS
SELECT     TOP 100 PERCENT dbo.Ojrat.onvan AS ojratName, dbo.Qate.shomareFanni, dbo.Irad.onvan AS iradName, dbo.Emdad.emdadId, dbo.Emdad.rokhdadId, 
                      dbo.Emdad.noeEmdad, dbo.Ojrat.ojratId, dbo.JozeatKhedmat.hazineh, dbo.JozeatKhedmat.tedadQate, dbo.JozeatKhedmat.guarantee, 
                      dbo.JozeatKhedmat.id, dbo.JozeatKhedmat.hazinehDefault, dbo.JozeatKhedmat.khedmatId, dbo.JozeatKhedmat.noeKhedmat, 
                      dbo.JozeatKhedmat.ijadKonandeh, dbo.JozeatKhedmat.manbaeTahiyeh, dbo.JozeatKhedmat.nahveyePardakht, dbo.Emdad.taeedHesabdar, 
                      dbo.Emdad.taeedGuarantee, dbo.Emdad.taeedNamayandegi, dbo.Qate.name AS qateName, dbo.Irad.iradId
FROM         dbo.JozeatKhedmat LEFT OUTER JOIN
                      dbo.Ojrat ON dbo.JozeatKhedmat.ojratId = dbo.Ojrat.id LEFT OUTER JOIN
                      dbo.Qate ON dbo.JozeatKhedmat.qateId = dbo.Qate.id LEFT OUTER JOIN
                      dbo.Irad ON dbo.JozeatKhedmat.iradId = dbo.Irad.id LEFT OUTER JOIN
                      dbo.Emdad ON dbo.JozeatKhedmat.khedmatId = dbo.Emdad.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_jozeatKhedmatTH
AS
SELECT     TOP 100 PERCENT dbo.JozeatKhedmat.*, dbo.Ojrat.onvan AS ojratName, dbo.Qate.shomareFanni, dbo.Irad.onvan AS iradName, dbo.Emdad.emdadId, 
                      dbo.Emdad.rokhdadId, dbo.Emdad.noeEmdad
FROM         dbo.JozeatKhedmat INNER JOIN
                      dbo.Emdad ON dbo.JozeatKhedmat.khedmatId = dbo.Emdad.id LEFT OUTER JOIN
                      dbo.Ojrat ON dbo.JozeatKhedmat.ojratId = dbo.Ojrat.id LEFT OUTER JOIN
                      dbo.Qate ON dbo.JozeatKhedmat.qateId = dbo.Qate.id LEFT OUTER JOIN
                      dbo.Irad ON dbo.JozeatKhedmat.iradId = dbo.Irad.id
ORDER BY dbo.JozeatKhedmat.khedmatId



GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_kasriEmdad
AS
SELECT     dbo.KasriEmdad.tarikh, dbo.KasriEmdad.kasriId, dbo.KasriEmdad.tahvilshod, dbo.KasriEmdad.taeedAnbardar, dbo.KasriEmdad.taeedEmdadgar, 
                      dbo.Emdadgar.name, dbo.KasriEmdad.id, dbo.KasriEmdad.emdadgarId, dbo.Emdadgar.daftarOstaniId
FROM         dbo.KasriEmdad INNER JOIN
                      dbo.Emdadgar ON dbo.KasriEmdad.emdadgarId = dbo.Emdadgar.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_khodrojagozin
AS
SELECT     dbo.Khodrojagozin.id, dbo.Khodrojagozin.khodrojagozinId, dbo.Khodrojagozin.rangeKhodroId, dbo.Khodrojagozin.noeKhodroId, 
                      dbo.Khodrojagozin.daftarOstaniId, dbo.Khodrojagozin.salesakht, dbo.Khodrojagozin.shomarehMotor, dbo.Khodrojagozin.faal, 
                      dbo.Khodrojagozin.shomarehShasi, dbo.Khodrojagozin.shomarehPelak, dbo.Khodrojagozin.shomarehVIN, dbo.Khodrojagozin.tozihat, 
                      dbo.NoeKhodro.onvan, dbo.DaftarOstani.name AS daftarOstaniName
FROM         dbo.Khodrojagozin INNER JOIN
                      dbo.RangeKhodro ON dbo.Khodrojagozin.rangeKhodroId = dbo.RangeKhodro.id INNER JOIN
                      dbo.DaftarOstani ON dbo.Khodrojagozin.daftarOstaniId = dbo.DaftarOstani.id INNER JOIN
                      dbo.NoeKhodro ON dbo.Khodrojagozin.noeKhodroId = dbo.NoeKhodro.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_khodrojagozinMasraf
AS
SELECT     dbo.KhodrojagozinMasraf.id, dbo.KhodrojagozinMasraf.tarikhTahvilAzMoshtari, dbo.KhodrojagozinMasraf.tarikhTahvilBeMoshtari, 
                      dbo.KhodrojagozinMasraf.khodrojagozinId, dbo.Khodrojagozin.faal, dbo.Khodrojagozin.shomarehPelak, dbo.Emdad.emdadId, 
                      dbo.KhodrojagozinMasraf.emdadId AS emdadIdO, dbo.Rokhdad.daftarOstaniId
FROM         dbo.Emdad INNER JOIN
                      dbo.KhodrojagozinMasraf ON dbo.Emdad.id = dbo.KhodrojagozinMasraf.emdadId INNER JOIN
                      dbo.Rokhdad ON dbo.Emdad.rokhdadId = dbo.Rokhdad.id LEFT OUTER JOIN
                      dbo.Khodrojagozin ON dbo.KhodrojagozinMasraf.khodrojagozinId = dbo.Khodrojagozin.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_mojoodiAnbar
AS
SELECT     dbo.MojoodiAnbar.*, dbo.Qate.shomareFanni, dbo.Qate.name AS qateName
FROM         dbo.MojoodiAnbar INNER JOIN
                      dbo.Qate ON dbo.MojoodiAnbar.qateId = dbo.Qate.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_mojoodiMojaz
AS
SELECT     dbo.MojoodiMojaz.id, dbo.MojoodiMojaz.tedad, dbo.MojoodiMojaz.qateId AS qateIdO, dbo.MojoodiMojaz.noeEmdadgarId, dbo.Qate.qateId, 
                      dbo.Qate.name AS qateName, dbo.Qate.shomareFanni AS shomarehFanni, dbo.NoeEmdadgar.onvan AS noeEmdadgarOnvan
FROM         dbo.MojoodiMojaz INNER JOIN
                      dbo.NoeEmdadgar ON dbo.MojoodiMojaz.noeEmdadgarId = dbo.NoeEmdadgar.id INNER JOIN
                      dbo.Qate ON dbo.MojoodiMojaz.qateId = dbo.Qate.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_mostanadatRokhdad
AS
SELECT     dbo.MostanadatRokhdad.id, dbo.MostanadatRokhdad.tarikhSanad, dbo.MostanadatRokhdad.nameParvande, dbo.MostanadatRokhdad.sharh, 
                      dbo.MostanadatRokhdad.mostanadatRokhdadId, dbo.MostanadatRokhdad.nameSanad, dbo.MostanadatRokhdad.rokhdadId AS rokhdadIdO, 
                      dbo.MostanadatRokhdad.shomarehSanad, dbo.Rokhdad.rokhdadId, dbo.Rokhdad.daftarOstaniId, dbo.DaftarOstani.name AS daftarOstaniName, 
                      dbo.MostanadatRokhdad.tarikhSabt
FROM         dbo.MostanadatRokhdad INNER JOIN
                      dbo.Rokhdad ON dbo.MostanadatRokhdad.rokhdadId = dbo.Rokhdad.id INNER JOIN
                      dbo.DaftarOstani ON dbo.Rokhdad.daftarOstaniId = dbo.DaftarOstani.id



GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_namayandegi
AS
SELECT     dbo.Namayandegi.namayandegiId, dbo.Namayandegi.name, dbo.Shahr.shahrName, dbo.Namayandegi.noeNamayandegi, dbo.Namayandegi.id, 
                      dbo.Namayandegi.emdadgar, dbo.Namayandegi.namayandegiAddress, dbo.Namayandegi.namayandegiFax, dbo.Namayandegi.namayandegiMobile, 
                      dbo.Namayandegi.namayandegiTel, dbo.Namayandegi.nazarIsaco, dbo.Namayandegi.olaviat, dbo.Namayandegi.saghfeRiali, 
                      dbo.Namayandegi.hadaksarKar, dbo.Namayandegi.karDarDast, dbo.Namayandegi.sabegheFaaliat, dbo.Namayandegi.sabegheNoroozi, 
                      dbo.Namayandegi.shomarehGharardad, dbo.Namayandegi.tahtePooshesh, dbo.Namayandegi.tarikhGharardad, dbo.Namayandegi.tarikhTahvil, 
                      dbo.Namayandegi.vazGharardad, dbo.Namayandegi.telZaroori, dbo.Namayandegi.dastgahEybyab, dbo.Namayandegi.email, 
                      dbo.Namayandegi.tarikhAkharinEstelam, dbo.Namayandegi.codeMantaghe, dbo.Namayandegi.daftarOstaniId, dbo.NoeKhodro.onvan, 
                      dbo.Namayandegi.hadaksarKar2, dbo.Namayandegi.karDarDast2, dbo.Namayandegi.shahrId, dbo.DaftarOstani.name AS daftarOstaniName
FROM         dbo.Namayandegi INNER JOIN
                      dbo.Shahr ON dbo.Namayandegi.shahrId = dbo.Shahr.id INNER JOIN
                      dbo.DaftarOstani ON dbo.Namayandegi.daftarOstaniId = dbo.DaftarOstani.id LEFT OUTER JOIN
                      dbo.NoeKhodro ON dbo.Namayandegi.noeKhodroId = dbo.NoeKhodro.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_noeKhodro
AS
SELECT     dbo.NoeKhodro.*, dbo.Khodrosaz.name AS name
FROM         dbo.NoeKhodro INNER JOIN
                      dbo.Khodrosaz ON dbo.NoeKhodro.khodrosazId = dbo.Khodrosaz.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_report_Namayandegi
AS
SELECT     dbo.Namayandegi.*, dbo.NoeKhodro.onvan AS onvanKhodro, dbo.DaftarOstani.name AS nameDaftarOstani, dbo.Shahr.shahrName AS nameShahr
FROM         dbo.Namayandegi INNER JOIN
                      dbo.NoeKhodro ON dbo.Namayandegi.noeKhodroId = dbo.NoeKhodro.id INNER JOIN
                      dbo.Shahr ON dbo.Namayandegi.shahrId = dbo.Shahr.id INNER JOIN
                      dbo.DaftarOstani ON dbo.Namayandegi.daftarOstaniId = dbo.DaftarOstani.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_report_Rokhdad
AS
SELECT     dbo.Rokhdad.*, Shakhs_1.name AS nameSabtKonandeh, Shakhs_1.name AS nameAkharinTagheerDahandeh, 
                      dbo.Moshtarak.eshterakId AS eshterakIdMoshtarak, dbo.NoeKhodro.onvan AS onvanNoeKhodro, dbo.Shahr.shahrName AS shahrName, 
                      dbo.Namayandegi.namayandegiId AS namayandegiIdNamayandegi, dbo.Namayandegi.name AS nameNamayandegi, 
                      dbo.DaftarOstani.name AS nameDaftarOstani, dbo.Moshtarak.noeService AS noeServiceMoshtarak
FROM         dbo.Shakhs Shakhs_1 INNER JOIN
                      dbo.Rokhdad INNER JOIN
                      dbo.Shakhs Shakhs_2 ON dbo.Rokhdad.sabtKonandeh = Shakhs_2.id ON Shakhs_1.id = dbo.Rokhdad.akharinTaghyirDahandeh INNER JOIN
                      dbo.Moshtarak ON dbo.Rokhdad.moshtarakId = dbo.Moshtarak.id INNER JOIN
                      dbo.NoeKhodro ON dbo.Moshtarak.noeKhodroId = dbo.NoeKhodro.id INNER JOIN
                      dbo.Shahr ON dbo.Rokhdad.shahrId = dbo.Shahr.id INNER JOIN
                      dbo.Namayandegi ON dbo.Rokhdad.namayandegiId = dbo.Namayandegi.id INNER JOIN
                      dbo.DaftarOstani ON dbo.Rokhdad.daftarOstaniId = dbo.DaftarOstani.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_report_moshtarak
AS
SELECT     dbo.Moshtarak.shomareMotor, dbo.Moshtarak.nameKhanevadegi, dbo.Moshtarak.mobile, dbo.Moshtarak.address, 
                      dbo.Moshtarak.mahaleServiceAvalieh, dbo.Moshtarak.postCode, dbo.Moshtarak.tel, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.tarikhAkharinEmail, 
                      dbo.Moshtarak.guarantee, dbo.Moshtarak.shomarePelak, dbo.Moshtarak.shomareVIN, dbo.Moshtarak.tarikhShoro, dbo.Moshtarak.tarikhTavalod, 
                      dbo.Moshtarak.tarikhServiceAvalieh, dbo.Moshtarak.eshterakId, dbo.Moshtarak.email, dbo.Moshtarak.tarikhTahvil, dbo.Moshtarak.shomareShasi, 
                      dbo.Moshtarak.noeService, dbo.Moshtarak.tarikhEnghezaGuarantee, dbo.Moshtarak.tarikhEngheza, dbo.Moshtarak.saleSakht, dbo.Moshtarak.vazeat, 
                      dbo.Moshtarak.name, dbo.Moshtarak.shahrId, dbo.Moshtarak.bazaryabId, dbo.Moshtarak.noeKhodroId, dbo.Moshtarak.rangeKhodroId, 
                      dbo.NoeKhodro.onvan, CAST(dbo.view_bazaryab.bazaryabName + '-' + dbo.view_bazaryab.onvan AS nvarchar) AS bname, 
                      dbo.RangeKhodro.onvan AS nameRang, dbo.Shahr.shahrName, dbo.Moshtarak.namayandegi, dbo.Moshtarak.tarikhIjad, 
                      dbo.Moshtarak.tarikhAkharinTamdid
FROM         dbo.Moshtarak INNER JOIN
                      dbo.NoeKhodro ON dbo.Moshtarak.noeKhodroId = dbo.NoeKhodro.id INNER JOIN
                      dbo.RangeKhodro ON dbo.Moshtarak.rangeKhodroId = dbo.RangeKhodro.id INNER JOIN
                      dbo.view_bazaryab ON dbo.Moshtarak.bazaryabId = dbo.view_bazaryab.id INNER JOIN
                      dbo.Shahr ON dbo.Moshtarak.shahrId = dbo.Shahr.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_rokhdadMoshtarak
AS
SELECT     dbo.Rokhdad.id, dbo.Rokhdad.rokhdadId, dbo.Moshtarak.eshterakId, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.guarantee, 
                      dbo.Moshtarak.noeService, dbo.Moshtarak.tarikhEnghezaGuarantee, dbo.Moshtarak.tarikhEngheza, dbo.Moshtarak.vazeat, 
                      dbo.Moshtarak.moshtarakYaNa
FROM         dbo.Rokhdad INNER JOIN
                      dbo.Moshtarak ON dbo.Rokhdad.moshtarakId = dbo.Moshtarak.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_savabegh
AS
SELECT     TOP 100 PERCENT dbo.Emdad.id, dbo.Emdad.emdadId, dbo.Emdad.zamanEzam, dbo.Shakhs.name AS ezamgarName, 
                      dbo.Emdadgar.name AS emdadgarName, dbo.Rokhdad.rokhdadId, dbo.Emdad.zamanShoro, dbo.Emdad.zamanPayan, dbo.Emdad.rahAndazi, 
                      dbo.Rokhdad.irad, dbo.Rokhdad.zamaneVaghei AS zamanTamas, Shakhs_1.name AS pazireshgarName, dbo.Rokhdad.moshtarakId, dbo.Rokhdad.tel, 
                      dbo.Rokhdad.mobile, dbo.Rokhdad.address, dbo.Namayandegi.namayandegiId, dbo.Emdad.kilometerKarkard
FROM         dbo.Emdad INNER JOIN
                      dbo.Shakhs ON dbo.Emdad.ezamgarId = dbo.Shakhs.id RIGHT OUTER JOIN
                      dbo.Rokhdad ON dbo.Emdad.rokhdadId = dbo.Rokhdad.id LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Emdad.namayandegiId = dbo.Namayandegi.id LEFT OUTER JOIN
                      dbo.Emdadgar ON dbo.Emdad.emdadgarId = dbo.Emdadgar.id LEFT OUTER JOIN
                      dbo.Shakhs Shakhs_1 ON dbo.Rokhdad.sabtKonandeh = Shakhs_1.id
ORDER BY dbo.Rokhdad.rokhdadId DESC, dbo.Emdad.emdadId DESC

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_serviceDorei
AS
SELECT     dbo.ServiceDorei.id, dbo.ServiceDorei.kilometerKarkard, dbo.ServiceDorei.tarikh, dbo.ServiceDorei.noeServiceDorei, dbo.ServiceDorei.hazineh, 
                      dbo.Moshtarak.eshterakId, dbo.Namayandegi.namayandegiId, dbo.Namayandegi.name AS namayandegiName, dbo.noeServiceDorei.name, 
                      dbo.noeServiceDorei.noeServiceDorei AS noeServiceDoreiId, dbo.ServiceDorei.taeedHesabdar, dbo.ServiceDorei.taeedNamayandeh, 
                      dbo.Moshtarak.shomareShasi
FROM         dbo.ServiceDorei INNER JOIN
                      dbo.Moshtarak ON dbo.ServiceDorei.moshtarakId = dbo.Moshtarak.id INNER JOIN
                      dbo.Namayandegi ON dbo.ServiceDorei.namayandegiId = dbo.Namayandegi.id INNER JOIN
                      dbo.noeServiceDorei ON dbo.ServiceDorei.noeServiceDorei = dbo.noeServiceDorei.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_shahr
AS
SELECT     dbo.Shahr.id, dbo.Shahr.shahrName, dbo.Ostan.name AS ostanName, dbo.Shahr.shahrId, dbo.Shahr.codeShahrKhodrosaz, dbo.Ostan.name, 
                      dbo.Shahr.ostanId, dbo.Shahr.azArz, dbo.Shahr.taArz, dbo.Shahr.azTool, dbo.Shahr.taTool
FROM         dbo.Ostan INNER JOIN
                      dbo.Shahr ON dbo.Ostan.id = dbo.Shahr.ostanId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_shakhs
AS
SELECT     dbo.Shakhs.id, dbo.Shakhs.name, dbo.Shakhs.shakhsId, dbo.Shakhs.naghshId, dbo.admin_Roles.roleTitle, dbo.Shakhs.username, 
                      dbo.Shakhs.password, dbo.Shakhs.daftarOstaniId, dbo.Shakhs.entityId
FROM         dbo.Shakhs INNER JOIN
                      dbo.DaftarOstani ON dbo.Shakhs.daftarOstaniId = dbo.DaftarOstani.id INNER JOIN
                      dbo.admin_Roles ON dbo.Shakhs.naghshId = dbo.admin_Roles.id

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_sub_cars
AS
SELECT     dbo.sub_cars.chassisno, dbo.NoeKhodro.id
FROM         dbo.sub_cars INNER JOIN
                      dbo.NoeKhodro ON dbo.sub_cars.syncId = dbo.NoeKhodro.noeKhodroId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

CREATE VIEW dbo.view_tamdidEshterak
AS
SELECT     dbo.TamdidEshterak.id, dbo.TamdidEshterak.tarikhAkharinTamdid, dbo.TamdidEshterak.isLast, dbo.Moshtarak.eshterakId, dbo.Moshtarak.name, 
                      dbo.Moshtarak.nameKhanevadegi, dbo.Moshtarak.noeService, dbo.Moshtarak.bazaryabId
FROM         dbo.Moshtarak INNER JOIN
                      dbo.TamdidEshterak ON dbo.Moshtarak.id = dbo.TamdidEshterak.moshtarakId

GO
SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

