if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Rokhdad_DaftarOstani]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Rokhdad] DROP CONSTRAINT FK_Rokhdad_DaftarOstani
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Shakhs_DaftarOstani]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Shakhs] DROP CONSTRAINT FK_Shakhs_DaftarOstani
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Emdad_DalileToolKeshidaneEmdad]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Emdad] DROP CONSTRAINT FK_Emdad_DalileToolKeshidaneEmdad
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_JozeatKhedmat_Irad]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[JozeatKhedmat] DROP CONSTRAINT FK_JozeatKhedmat_Irad
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_NoeKhodro_Khodrosaz]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[NoeKhodro] DROP CONSTRAINT FK_NoeKhodro_Khodrosaz
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Bazaryab_NoeBazaryab]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Bazaryab] DROP CONSTRAINT FK_Bazaryab_NoeBazaryab
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Emdad_NoeEmdadgar]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Emdad] DROP CONSTRAINT FK_Emdad_NoeEmdadgar
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Emdadgar_NoeEmdadgar]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Emdadgar] DROP CONSTRAINT FK_Emdadgar_NoeEmdadgar
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_JozeatKhedmat_Ojrat]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[JozeatKhedmat] DROP CONSTRAINT FK_JozeatKhedmat_Ojrat
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Shahr_Ostan]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Shahr] DROP CONSTRAINT FK_Shahr_Ostan
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_AnbarEmdadgar_Qate]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[AnbarEmdadgar] DROP CONSTRAINT FK_AnbarEmdadgar_Qate
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_DarkhastQate_Qate]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[DarkhastQate] DROP CONSTRAINT FK_DarkhastQate_Qate
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_JozeatKasri_Qate]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[JozeatKasri] DROP CONSTRAINT FK_JozeatKasri_Qate
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_JozeatKhedmat_Qate]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[JozeatKhedmat] DROP CONSTRAINT FK_JozeatKhedmat_Qate
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_MojoodiAnbar_Qate]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[MojoodiAnbar] DROP CONSTRAINT FK_MojoodiAnbar_Qate
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_DarkhastEshterak_RangeKhodro]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[DarkhastEshterak] DROP CONSTRAINT FK_DarkhastEshterak_RangeKhodro
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Khodrojagozin_RangeKhodro]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Khodrojagozin] DROP CONSTRAINT FK_Khodrojagozin_RangeKhodro
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Emdad_VazeatKhedmat]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Emdad] DROP CONSTRAINT FK_Emdad_VazeatKhedmat
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Moshtarak_Bazaryab1]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Moshtarak] DROP CONSTRAINT FK_Moshtarak_Bazaryab1
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_AnbarEmdadgar_Emdadgar]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[AnbarEmdadgar] DROP CONSTRAINT FK_AnbarEmdadgar_Emdadgar
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_DarkhastQate_Emdadgar]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[DarkhastQate] DROP CONSTRAINT FK_DarkhastQate_Emdadgar
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Emdad_Emdadgar]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Emdad] DROP CONSTRAINT FK_Emdad_Emdadgar
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_KasriEmdad_Emdadgar]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[KasriEmdad] DROP CONSTRAINT FK_KasriEmdad_Emdadgar
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_DarkhastEshterak_NoeKhodro]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[DarkhastEshterak] DROP CONSTRAINT FK_DarkhastEshterak_NoeKhodro
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Khodrojagozin_NoeKhodro]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Khodrojagozin] DROP CONSTRAINT FK_Khodrojagozin_NoeKhodro
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Namayandegi_NoeKhodro]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Namayandegi] DROP CONSTRAINT FK_Namayandegi_NoeKhodro
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_DarkhastEshterak_Shahr]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[DarkhastEshterak] DROP CONSTRAINT FK_DarkhastEshterak_Shahr
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Namayandegi_Shahr]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Namayandegi] DROP CONSTRAINT FK_Namayandegi_Shahr
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Rokhdad_Shahr]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Rokhdad] DROP CONSTRAINT FK_Rokhdad_Shahr
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Emdad_Shakhs]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Emdad] DROP CONSTRAINT FK_Emdad_Shakhs
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_JozeatKhedmat_Shakhs]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[JozeatKhedmat] DROP CONSTRAINT FK_JozeatKhedmat_Shakhs
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_JozeatKasri_KasriEmdad]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[JozeatKasri] DROP CONSTRAINT FK_JozeatKasri_KasriEmdad
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_KhodrojagozinMasraf_Khodrojagozin]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[KhodrojagozinMasraf] DROP CONSTRAINT FK_KhodrojagozinMasraf_Khodrojagozin
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Rokhdad_Moshtarak]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Rokhdad] DROP CONSTRAINT FK_Rokhdad_Moshtarak
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_TamdidEshterak_Moshtarak]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[TamdidEshterak] DROP CONSTRAINT FK_TamdidEshterak_Moshtarak
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Emdad_Namayandegi]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Emdad] DROP CONSTRAINT FK_Emdad_Namayandegi
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Rokhdad_Namayandegi]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Rokhdad] DROP CONSTRAINT FK_Rokhdad_Namayandegi
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_Emdad_Rokhdad]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[Emdad] DROP CONSTRAINT FK_Emdad_Rokhdad
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_MostanadatRokhdad_Rokhdad]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[MostanadatRokhdad] DROP CONSTRAINT FK_MostanadatRokhdad_Rokhdad
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_JozeatKhedmat_Emdad]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[JozeatKhedmat] DROP CONSTRAINT FK_JozeatKhedmat_Emdad
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_KhodrojagozinMasraf_Emdad]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[KhodrojagozinMasraf] DROP CONSTRAINT FK_KhodrojagozinMasraf_Emdad
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[FK_PeigiriEzamgar_Emdad]') and OBJECTPROPERTY(id, N'IsForeignKey') = 1)
ALTER TABLE [dbo].[PeigiriEzamgar] DROP CONSTRAINT FK_PeigiriEzamgar_Emdad
GO

/****** Object:  User Defined Function dbo.BazaryabName    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[BazaryabName]') and xtype in (N'FN', N'IF', N'TF'))
drop function [dbo].[BazaryabName]
GO

/****** Object:  User Defined Function dbo.NewEshterakId    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[NewEshterakId]') and xtype in (N'FN', N'IF', N'TF'))
drop function [dbo].[NewEshterakId]
GO

/****** Object:  Stored Procedure dbo.UpdateRelationJozeatKhedmat    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateRelationJozeatKhedmat]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateRelationJozeatKhedmat]
GO

/****** Object:  Stored Procedure dbo.UpdateRelationJozeatKasri    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateRelationJozeatKasri]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateRelationJozeatKasri]
GO

/****** Object:  Stored Procedure dbo.PayanEmdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PayanEmdad]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[PayanEmdad]
GO

/****** Object:  Stored Procedure dbo.PayanEmdad2    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PayanEmdad2]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[PayanEmdad2]
GO

/****** Object:  Stored Procedure dbo.PayanEmdad3    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PayanEmdad3]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[PayanEmdad3]
GO

/****** Object:  Stored Procedure dbo.UpdateAnbarEmdadgar    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateAnbarEmdadgar]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateAnbarEmdadgar]
GO

/****** Object:  Stored Procedure dbo.UpdateRelationEmdad2    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateRelationEmdad2]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateRelationEmdad2]
GO

/****** Object:  Stored Procedure dbo.UpdateRelationMoshtarak    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateRelationMoshtarak]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateRelationMoshtarak]
GO

/****** Object:  Stored Procedure dbo.aaa    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[aaa]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[aaa]
GO

/****** Object:  Stored Procedure dbo.Add2Log    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Add2Log]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[Add2Log]
GO

/****** Object:  Stored Procedure dbo.UpdateDastoorKarGhabliRokhdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateDastoorKarGhabliRokhdad]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateDastoorKarGhabliRokhdad]
GO

/****** Object:  Stored Procedure dbo.UpdateRelationEmdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateRelationEmdad]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateRelationEmdad]
GO

/****** Object:  Stored Procedure dbo.UpdateRelationKasriEmdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateRelationKasriEmdad]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateRelationKasriEmdad]
GO

/****** Object:  Stored Procedure dbo.UpdateRelationRokhdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[UpdateRelationRokhdad]') and OBJECTPROPERTY(id, N'IsProcedure') = 1)
drop procedure [dbo].[UpdateRelationRokhdad]
GO

/****** Object:  View dbo.view_Mali    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_Mali]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_Mali]
GO

/****** Object:  View dbo.view_PeigiriEzamgar    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_PeigiriEzamgar]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_PeigiriEzamgar]
GO

/****** Object:  View dbo.view_khodrojagozinMasraf    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_khodrojagozinMasraf]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_khodrojagozinMasraf]
GO

/****** Object:  View dbo.emdadList    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[emdadList]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[emdadList]
GO

/****** Object:  View dbo.view_mostanadatRokhdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_mostanadatRokhdad]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_mostanadatRokhdad]
GO

/****** Object:  View dbo.view_report_moshtarak    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_report_moshtarak]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_report_moshtarak]
GO

/****** Object:  View dbo.rokhdadList    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[rokhdadList]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[rokhdadList]
GO

/****** Object:  View dbo.view_bazaryab    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_bazaryab]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_bazaryab]
GO

/****** Object:  View dbo.view_jozeatKasri    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_jozeatKasri]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_jozeatKasri]
GO

/****** Object:  View dbo.view_tamdidEshterak    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_tamdidEshterak]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_tamdidEshterak]
GO

/****** Object:  View dbo.AnbarEmdadgarList    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[AnbarEmdadgarList]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[AnbarEmdadgarList]
GO

/****** Object:  View dbo.MoshtarakList    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MoshtarakList]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[MoshtarakList]
GO

/****** Object:  View dbo.view_anbarEmdadgar    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_anbarEmdadgar]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_anbarEmdadgar]
GO

/****** Object:  View dbo.view_darkhastEshterak    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_darkhastEshterak]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_darkhastEshterak]
GO

/****** Object:  View dbo.view_darkhasttagheer    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_darkhasttagheer]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_darkhasttagheer]
GO

/****** Object:  View dbo.view_emdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_emdad]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_emdad]
GO

/****** Object:  View dbo.view_emdadRokhdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_emdadRokhdad]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_emdadRokhdad]
GO

/****** Object:  View dbo.view_emdadgar    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_emdadgar]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_emdadgar]
GO

/****** Object:  View dbo.view_joghraphy    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_joghraphy]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_joghraphy]
GO

/****** Object:  View dbo.view_kasriEmdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_kasriEmdad]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_kasriEmdad]
GO

/****** Object:  View dbo.view_khodrojagozin    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_khodrojagozin]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_khodrojagozin]
GO

/****** Object:  View dbo.view_namayandegi    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_namayandegi]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_namayandegi]
GO

/****** Object:  View dbo.view_report_Namayandegi    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_report_Namayandegi]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_report_Namayandegi]
GO

/****** Object:  View dbo.view_report_Rokhdad    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_report_Rokhdad]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_report_Rokhdad]
GO

/****** Object:  View dbo.view_rokhdadMoshtarak    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_rokhdadMoshtarak]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_rokhdadMoshtarak]
GO

/****** Object:  View dbo.view_savabegh    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_savabegh]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_savabegh]
GO

/****** Object:  View dbo.view_serviceDorei    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_serviceDorei]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_serviceDorei]
GO

/****** Object:  View dbo.MoshtarakReport    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MoshtarakReport]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[MoshtarakReport]
GO

/****** Object:  View dbo.view_mojoodiAnbar    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_mojoodiAnbar]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_mojoodiAnbar]
GO

/****** Object:  View dbo.view_noeKhodro    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_noeKhodro]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_noeKhodro]
GO

/****** Object:  View dbo.view_shahr    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_shahr]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_shahr]
GO

/****** Object:  View dbo.view_sub_cars    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_sub_cars]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_sub_cars]
GO

/****** Object:  View dbo.report_views_fields    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_views_fields]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[report_views_fields]
GO

/****** Object:  View dbo.report_views_fields1    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_views_fields1]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[report_views_fields1]
GO

/****** Object:  View dbo.report_views_fields2    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_views_fields2]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[report_views_fields2]
GO

/****** Object:  View dbo.view_adminMenu    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_adminMenu]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_adminMenu]
GO

/****** Object:  View dbo.view_jozeatKhedmat    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_jozeatKhedmat]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_jozeatKhedmat]
GO

/****** Object:  View dbo.view_jozeatKhedmatTH    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_jozeatKhedmatTH]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_jozeatKhedmatTH]
GO

/****** Object:  View dbo.view_mojoodiMojaz    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_mojoodiMojaz]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_mojoodiMojaz]
GO

/****** Object:  View dbo.view_shakhs    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[view_shakhs]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[view_shakhs]
GO

/****** Object:  View dbo.userRoles    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[userRoles]') and OBJECTPROPERTY(id, N'IsView') = 1)
drop view [dbo].[userRoles]
GO

/****** Object:  Table [dbo].[JozeatKhedmat]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[JozeatKhedmat]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[JozeatKhedmat]
GO

/****** Object:  Table [dbo].[KhodrojagozinMasraf]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[KhodrojagozinMasraf]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[KhodrojagozinMasraf]
GO

/****** Object:  Table [dbo].[PeigiriEzamgar]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[PeigiriEzamgar]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[PeigiriEzamgar]
GO

/****** Object:  Table [dbo].[Emdad]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Emdad]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Emdad]
GO

/****** Object:  Table [dbo].[MostanadatRokhdad]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MostanadatRokhdad]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MostanadatRokhdad]
GO

/****** Object:  Table [dbo].[JozeatKasri]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[JozeatKasri]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[JozeatKasri]
GO

/****** Object:  Table [dbo].[Rokhdad]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Rokhdad]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Rokhdad]
GO

/****** Object:  Table [dbo].[TamdidEshterak]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[TamdidEshterak]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[TamdidEshterak]
GO

/****** Object:  Table [dbo].[AnbarEmdadgar]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[AnbarEmdadgar]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[AnbarEmdadgar]
GO

/****** Object:  Table [dbo].[DarkhastEshterak]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DarkhastEshterak]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DarkhastEshterak]
GO

/****** Object:  Table [dbo].[DarkhastQate]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DarkhastQate]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DarkhastQate]
GO

/****** Object:  Table [dbo].[KasriEmdad]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[KasriEmdad]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[KasriEmdad]
GO

/****** Object:  Table [dbo].[Khodrojagozin]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Khodrojagozin]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Khodrojagozin]
GO

/****** Object:  Table [dbo].[Moshtarak]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Moshtarak]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Moshtarak]
GO

/****** Object:  Table [dbo].[Namayandegi]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Namayandegi]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Namayandegi]
GO

/****** Object:  Table [dbo].[Bazaryab]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Bazaryab]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Bazaryab]
GO

/****** Object:  Table [dbo].[Emdadgar]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Emdadgar]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Emdadgar]
GO

/****** Object:  Table [dbo].[MojoodiAnbar]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MojoodiAnbar]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MojoodiAnbar]
GO

/****** Object:  Table [dbo].[NoeKhodro]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[NoeKhodro]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[NoeKhodro]
GO

/****** Object:  Table [dbo].[Shahr]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Shahr]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Shahr]
GO

/****** Object:  Table [dbo].[Shakhs]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Shakhs]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Shakhs]
GO

/****** Object:  Table [dbo].[BazaryabMotefareghe]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[BazaryabMotefareghe]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[BazaryabMotefareghe]
GO

/****** Object:  Table [dbo].[DaftarOstani]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DaftarOstani]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DaftarOstani]
GO

/****** Object:  Table [dbo].[DalileToolKeshidaneEmdad]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DalileToolKeshidaneEmdad]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DalileToolKeshidaneEmdad]
GO

/****** Object:  Table [dbo].[DarkhastTagheer]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[DarkhastTagheer]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[DarkhastTagheer]
GO

/****** Object:  Table [dbo].[GheirMoshtarak]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[GheirMoshtarak]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[GheirMoshtarak]
GO

/****** Object:  Table [dbo].[HIGH_KEY]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[HIGH_KEY]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[HIGH_KEY]
GO

/****** Object:  Table [dbo].[Irad]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Irad]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Irad]
GO

/****** Object:  Table [dbo].[Khodrosaz]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Khodrosaz]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Khodrosaz]
GO

/****** Object:  Table [dbo].[LastSerial]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[LastSerial]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[LastSerial]
GO

/****** Object:  Table [dbo].[MojoodiMojaz]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[MojoodiMojaz]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[MojoodiMojaz]
GO

/****** Object:  Table [dbo].[NoeBazaryab]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[NoeBazaryab]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[NoeBazaryab]
GO

/****** Object:  Table [dbo].[NoeEmdadgar]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[NoeEmdadgar]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[NoeEmdadgar]
GO

/****** Object:  Table [dbo].[Ojrat]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Ojrat]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Ojrat]
GO

/****** Object:  Table [dbo].[Ostan]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Ostan]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Ostan]
GO

/****** Object:  Table [dbo].[Qate]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Qate]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Qate]
GO

/****** Object:  Table [dbo].[Qate4Import]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Qate4Import]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Qate4Import]
GO

/****** Object:  Table [dbo].[RangeKhodro]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[RangeKhodro]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[RangeKhodro]
GO

/****** Object:  Table [dbo].[Reports]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Reports]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Reports]
GO

/****** Object:  Table [dbo].[Results]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Results]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Results]
GO

/****** Object:  Table [dbo].[Role]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Role]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Role]
GO

/****** Object:  Table [dbo].[ServiceDorei]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ServiceDorei]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ServiceDorei]
GO

/****** Object:  Table [dbo].[VazeatKhedmat]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[VazeatKhedmat]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[VazeatKhedmat]
GO

/****** Object:  Table [dbo].[aa2]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[aa2]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[aa2]
GO

/****** Object:  Table [dbo].[aabb]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[aabb]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[aabb]
GO

/****** Object:  Table [dbo].[aacc]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[aacc]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[aacc]
GO

/****** Object:  Table [dbo].[admin_ACL]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[admin_ACL]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[admin_ACL]
GO

/****** Object:  Table [dbo].[admin_ACL_bak]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[admin_ACL_bak]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[admin_ACL_bak]
GO

/****** Object:  Table [dbo].[admin_BP]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[admin_BP]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[admin_BP]
GO

/****** Object:  Table [dbo].[admin_Captions]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[admin_Captions]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[admin_Captions]
GO

/****** Object:  Table [dbo].[admin_Entity]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[admin_Entity]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[admin_Entity]
GO

/****** Object:  Table [dbo].[admin_Roles]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[admin_Roles]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[admin_Roles]
GO

/****** Object:  Table [dbo].[admin_UC]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[admin_UC]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[admin_UC]
GO

/****** Object:  Table [dbo].[ch_su]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ch_su]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ch_su]
GO

/****** Object:  Table [dbo].[emdadtmp]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[emdadtmp]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[emdadtmp]
GO

/****** Object:  Table [dbo].[ev_su]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[ev_su]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[ev_su]
GO

/****** Object:  Table [dbo].[i2]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[i2]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[i2]
GO

/****** Object:  Table [dbo].[logs]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[logs]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[logs]
GO

/****** Object:  Table [dbo].[naghshe]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[naghshe]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[naghshe]
GO

/****** Object:  Table [dbo].[naghshe1]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[naghshe1]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[naghshe1]
GO

/****** Object:  Table [dbo].[new_subs]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[new_subs]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[new_subs]
GO

/****** Object:  Table [dbo].[noeServiceDorei]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[noeServiceDorei]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[noeServiceDorei]
GO

/****** Object:  Table [dbo].[o2]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[o2]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[o2]
GO

/****** Object:  Table [dbo].[op]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[op]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[op]
GO

/****** Object:  Table [dbo].[qate2]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[qate2]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[qate2]
GO

/****** Object:  Table [dbo].[rangeKhodroMapping]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[rangeKhodroMapping]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[rangeKhodroMapping]
GO

/****** Object:  Table [dbo].[report_affixes]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_affixes]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[report_affixes]
GO

/****** Object:  Table [dbo].[report_fields]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_fields]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[report_fields]
GO

/****** Object:  Table [dbo].[report_fonts]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_fonts]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[report_fonts]
GO

/****** Object:  Table [dbo].[report_main]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_main]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[report_main]
GO

/****** Object:  Table [dbo].[report_parameters]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_parameters]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[report_parameters]
GO

/****** Object:  Table [dbo].[report_views_fieldss]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_views_fieldss]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[report_views_fieldss]
GO

/****** Object:  Table [dbo].[report_views_main]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[report_views_main]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[report_views_main]
GO

/****** Object:  Table [dbo].[roles]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[roles]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[roles]
GO

/****** Object:  Table [dbo].[shomtran7]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[shomtran7]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[shomtran7]
GO

/****** Object:  Table [dbo].[sub_cars]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[sub_cars]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[sub_cars]
GO

/****** Object:  Table [dbo].[subs2]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[subs2]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[subs2]
GO

/****** Object:  Table [dbo].[tempfields]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[tempfields]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[tempfields]
GO

/****** Object:  Table [dbo].[temppd]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[temppd]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[temppd]
GO

/****** Object:  Table [dbo].[temppp]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[temppp]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[temppp]
GO

/****** Object:  Table [dbo].[views_fields]    Script Date: 2004/05/29 10:19:35 ق.ظ ******/
if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[views_fields]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[views_fields]
GO

/****** Object:  Table [dbo].[BazaryabMotefareghe]    Script Date: 2004/05/29 10:19:38 ق.ظ ******/
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

/****** Object:  Table [dbo].[DaftarOstani]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
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

/****** Object:  Table [dbo].[DalileToolKeshidaneEmdad]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
CREATE TABLE [dbo].[DalileToolKeshidaneEmdad] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[dalileToolKeshidaneEmdadId] [int] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[DarkhastTagheer]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
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

/****** Object:  Table [dbo].[GheirMoshtarak]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
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

/****** Object:  Table [dbo].[HIGH_KEY]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
CREATE TABLE [dbo].[HIGH_KEY] (
	[NAME] [char] (25) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[VALUE] [varchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Irad]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
CREATE TABLE [dbo].[Irad] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[iradId] [varchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Khodrosaz]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
CREATE TABLE [dbo].[Khodrosaz] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[khodrosazId] [int] NOT NULL ,
	[name] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[LastSerial]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
CREATE TABLE [dbo].[LastSerial] (
	[name] [varchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[serial] [bigint] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[MojoodiMojaz]    Script Date: 2004/05/29 10:19:39 ق.ظ ******/
CREATE TABLE [dbo].[MojoodiMojaz] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tedad] [int] NOT NULL ,
	[noeEmdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[NoeBazaryab]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
CREATE TABLE [dbo].[NoeBazaryab] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[noeBazaryabId] [int] NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[entity] [int] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[NoeEmdadgar]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
CREATE TABLE [dbo].[NoeEmdadgar] (
	[noeEmdadgarId] [int] NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Ojrat]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
CREATE TABLE [dbo].[Ojrat] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ojratId] [varchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ojrat] [int] NOT NULL ,
	[modat] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Ostan]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
CREATE TABLE [dbo].[Ostan] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[ostanId] [int] NOT NULL ,
	[name] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[azArz] [int] NULL ,
	[taArz] [int] NULL ,
	[azTool] [int] NULL ,
	[taTool] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Qate]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
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

/****** Object:  Table [dbo].[Qate4Import]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
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

/****** Object:  Table [dbo].[RangeKhodro]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
CREATE TABLE [dbo].[RangeKhodro] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[rangeKhodroId] [int] NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[codeRangeKhodrosaz] [nvarchar] (5) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[baseRange] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Reports]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
CREATE TABLE [dbo].[Reports] (
	[id] [bigint] IDENTITY (1, 1) NOT NULL ,
	[rand] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[pName] [nvarchar] (500) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[pValue] [nvarchar] (500) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[isValid] [bit] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Results]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
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

/****** Object:  Table [dbo].[Role]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
CREATE TABLE [dbo].[Role] (
	[id] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[access] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[entity] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[role] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[roleId] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[ServiceDorei]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
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

/****** Object:  Table [dbo].[VazeatKhedmat]    Script Date: 2004/05/29 10:19:40 ق.ظ ******/
CREATE TABLE [dbo].[VazeatKhedmat] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[vazeatKhedmatId] [int] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[aa2]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[aa2] (
	[chassisno] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[eshterakId] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[subscriptionId] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[aabb]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[aabb] (
	[emdadId] [int] NULL ,
	[rokhdadId] [int] NOT NULL ,
	[zamanTamas] [datetime] NOT NULL ,
	[irad] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[aacc]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[aacc] (
	[emdadId] [int] NULL ,
	[rokhdadId] [int] NOT NULL ,
	[zamanTamas] [datetime] NOT NULL ,
	[irad] [nvarchar] (160) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[admin_ACL]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[admin_ACL] (
	[roleId] [int] NOT NULL ,
	[ucId] [int] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[admin_ACL_bak]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[admin_ACL_bak] (
	[roleId] [int] NOT NULL ,
	[ucId] [int] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[admin_BP]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[admin_BP] (
	[id] [int] NOT NULL ,
	[bpName] [varchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[bpTitle] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[bpDescr] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[bpCode] [int] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[admin_Captions]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[admin_Captions] (
	[captionId] [int] NOT NULL ,
	[caption] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[admin_Entity]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[admin_Entity] (
	[id] [int] IDENTITY (1, 1) NOT NULL ,
	[entityName] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[entityTitle] [nvarchar] (64) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[entityDescr] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[admin_Roles]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[admin_Roles] (
	[id] [int] NOT NULL ,
	[role] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[roleTitle] [nvarchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[faraOstani] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[admin_UC]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
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

/****** Object:  Table [dbo].[ch_su]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[ch_su] (
	[chassisno] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[subscriptionId] [char] (18) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[emdadtmp]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[emdadtmp] (
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

/****** Object:  Table [dbo].[ev_su]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[ev_su] (
	[eventId] [int] NOT NULL ,
	[subscriptionId] [char] (18) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[chassisno] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[i2]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[i2] (
	[iradId] [varchar] (8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[onvan] [nvarchar] (60) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[logs]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[logs] (
	[data] [varchar] (128) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[src] [varchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[id] [int] IDENTITY (1, 1) NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[naghshe]    Script Date: 2004/05/29 10:19:41 ق.ظ ******/
CREATE TABLE [dbo].[naghshe] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mapLevel] [int] NOT NULL ,
	[azTooleGoegraphy] [int] NOT NULL ,
	[taTooleGoegraphy] [int] NOT NULL ,
	[azArzeGoegraphy] [int] NOT NULL ,
	[taArzeGoegraphy] [int] NOT NULL ,
	[mantagheId] [int] NOT NULL ,
	[fileName] [varchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[naghshe1]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
CREATE TABLE [dbo].[naghshe1] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mapLevel] [int] NOT NULL ,
	[azTooleGoegraphy] [int] NOT NULL ,
	[taTooleGoegraphy] [int] NOT NULL ,
	[azArzeGoegraphy] [int] NOT NULL ,
	[taArzeGoegraphy] [int] NOT NULL ,
	[mantagheId] [int] NOT NULL ,
	[fileName] [varchar] (30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[new_subs]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
CREATE TABLE [dbo].[new_subs] (
	[Col001] [char] (10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[noeServiceDorei]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
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

/****** Object:  Table [dbo].[o2]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
CREATE TABLE [dbo].[o2] (
	[time] [float] NULL ,
	[name] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[code] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[op]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
CREATE TABLE [dbo].[op] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[name] [nvarchar] (40) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[qate2]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
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

/****** Object:  Table [dbo].[rangeKhodroMapping]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
CREATE TABLE [dbo].[rangeKhodroMapping] (
	[codeRangeKhodrosaz] [float] NULL ,
	[RangCodeEmdad] [float] NOT NULL ,
	[name] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[RangCode] [float] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[report_affixes]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
CREATE TABLE [dbo].[report_affixes] (
	[id] [int] NOT NULL ,
	[report_id] [int] NULL ,
	[prequery] [nvarchar] (1000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[postquery] [nvarchar] (1000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[priority] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[report_fields]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
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

/****** Object:  Table [dbo].[report_fonts]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
CREATE TABLE [dbo].[report_fonts] (
	[id] [int] NOT NULL ,
	[fontName] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[address] [nvarchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[report_main]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
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

/****** Object:  Table [dbo].[report_parameters]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
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

/****** Object:  Table [dbo].[report_views_fieldss]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
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

/****** Object:  Table [dbo].[report_views_main]    Script Date: 2004/05/29 10:19:42 ق.ظ ******/
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

/****** Object:  Table [dbo].[roles]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
CREATE TABLE [dbo].[roles] (
	[id] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[access] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[entity] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[roleId] [int] NULL ,
	[role] [varchar] (256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[shomtran7]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
CREATE TABLE [dbo].[shomtran7] (
	[CMFAM] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMNAM] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMFNM] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMPLC] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMINO] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMECO] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMADR] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMTEL] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMTELCD] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CMCTY] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CACOD] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CAMOT] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CABODY] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHERKAT] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CASHA] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SANADDT] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SANADNO] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[PELAC] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CSTMTYP] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[COLOR] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[STAT] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHOMAREH] [float] NULL ,
	[POST] [float] NULL ,
	[AVARZ] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[KHAZ] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[BPLAC] [float] NULL ,
	[METRO] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[POSTI] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[MODEL] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[YEKDR] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[S_ER1] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[DOU1] [float] NULL ,
	[HARF1] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SEH1] [float] NULL ,
	[PL1] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[AGN] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[OSTAN] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[SHAHR] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[CARDES] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[RANGDES] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[AMOUNT] [float] NULL ,
	[VAZ_DAT] [nvarchar] (255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[sub_cars]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
CREATE TABLE [dbo].[sub_cars] (
	[chassisno] [nvarchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[syncId] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[subs2]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
CREATE TABLE [dbo].[subs2] (
	[subscriptionId] [char] (18) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[chassisno] [char] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[subscriptionDate] [datetime] NOT NULL ,
	[expireDate] [datetime] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[tempfields]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
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

/****** Object:  Table [dbo].[temppd]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
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

/****** Object:  Table [dbo].[temppp]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
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

/****** Object:  Table [dbo].[views_fields]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
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

/****** Object:  Table [dbo].[Bazaryab]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
CREATE TABLE [dbo].[Bazaryab] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[bazaryabKey] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[noeBazaryabId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[bazaryabId] [int] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Emdadgar]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
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

/****** Object:  Table [dbo].[MojoodiAnbar]    Script Date: 2004/05/29 10:19:43 ق.ظ ******/
CREATE TABLE [dbo].[MojoodiAnbar] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[anbarId] [int] NOT NULL ,
	[mojoodi] [int] NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[NoeKhodro]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
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

/****** Object:  Table [dbo].[Shahr]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
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

/****** Object:  Table [dbo].[Shakhs]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
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

/****** Object:  Table [dbo].[AnbarEmdadgar]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
CREATE TABLE [dbo].[AnbarEmdadgar] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[mojoodi] [int] NOT NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[emdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[DarkhastEshterak]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
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

/****** Object:  Table [dbo].[DarkhastQate]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
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

/****** Object:  Table [dbo].[KasriEmdad]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
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

/****** Object:  Table [dbo].[Khodrojagozin]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
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

/****** Object:  Table [dbo].[Moshtarak]    Script Date: 2004/05/29 10:19:44 ق.ظ ******/
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

/****** Object:  Table [dbo].[Namayandegi]    Script Date: 2004/05/29 10:19:45 ق.ظ ******/
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

/****** Object:  Table [dbo].[JozeatKasri]    Script Date: 2004/05/29 10:19:45 ق.ظ ******/
CREATE TABLE [dbo].[JozeatKasri] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tedadEmdadgar] [int] NULL ,
	[tedadKasri] [int] NOT NULL ,
	[tedadAnbar] [int] NULL ,
	[qateId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[kasriEmdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Rokhdad]    Script Date: 2004/05/29 10:19:45 ق.ظ ******/
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
	[kilometerKarkardGhabli] [int] NULL ,
	[iii] [int] NULL ,
	[guarantee] [int] NOT NULL ,
	[noeService] [int] NOT NULL ,
	[moshtarakYaNa] [int] NOT NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[TamdidEshterak]    Script Date: 2004/05/29 10:19:45 ق.ظ ******/
CREATE TABLE [dbo].[TamdidEshterak] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tarikhAkharinTamdid] [datetime] NULL ,
	[moshtarakId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[isLast] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Emdad]    Script Date: 2004/05/29 10:19:45 ق.ظ ******/
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
	[noeEmdadgarId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[iii] [int] NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[MostanadatRokhdad]    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  Table [dbo].[JozeatKhedmat]    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  Table [dbo].[KhodrojagozinMasraf]    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
CREATE TABLE [dbo].[KhodrojagozinMasraf] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[tarikhTahvilAzMoshtari] [datetime] NULL ,
	[tarikhTahvilBeMoshtari] [datetime] NULL ,
	[emdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[khodrojagozinId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[PeigiriEzamgar]    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
CREATE TABLE [dbo].[PeigiriEzamgar] (
	[id] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[zamanPeigiri] [datetime] NOT NULL ,
	[natije] [nvarchar] (80) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL ,
	[emdadId] [char] (19) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[BazaryabMotefareghe] WITH NOCHECK ADD 
	CONSTRAINT [pk_BazaryabMotefareghe] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[DaftarOstani] WITH NOCHECK ADD 
	CONSTRAINT [pk_DaftarOstani] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[DalileToolKeshidaneEmdad] WITH NOCHECK ADD 
	CONSTRAINT [pk_DalileToolKeshidaneEmdad] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[DarkhastTagheer] WITH NOCHECK ADD 
	CONSTRAINT [pk_DarkhastTagheer] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[GheirMoshtarak] WITH NOCHECK ADD 
	CONSTRAINT [pk_GheirMoshtarak] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[HIGH_KEY] WITH NOCHECK ADD 
	CONSTRAINT [PK_HIGH_KEY] PRIMARY KEY  CLUSTERED 
	(
		[NAME]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Irad] WITH NOCHECK ADD 
	CONSTRAINT [pk_Irad] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Khodrosaz] WITH NOCHECK ADD 
	CONSTRAINT [pk_Khodrosaz] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[LastSerial] WITH NOCHECK ADD 
	CONSTRAINT [PK_LastSerial] PRIMARY KEY  CLUSTERED 
	(
		[name]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[MojoodiMojaz] WITH NOCHECK ADD 
	CONSTRAINT [pk_MojoodiMojaz] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[NoeBazaryab] WITH NOCHECK ADD 
	CONSTRAINT [pk_NoeBazaryab] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[NoeEmdadgar] WITH NOCHECK ADD 
	CONSTRAINT [PK_NoeEmdadgar] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Ojrat] WITH NOCHECK ADD 
	CONSTRAINT [pk_Ojrat] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Ostan] WITH NOCHECK ADD 
	CONSTRAINT [pk_Ostan] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Qate] WITH NOCHECK ADD 
	CONSTRAINT [pk_Qate] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[RangeKhodro] WITH NOCHECK ADD 
	CONSTRAINT [pk_RangeKhodro] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Role] WITH NOCHECK ADD 
	CONSTRAINT [pk_Role] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[ServiceDorei] WITH NOCHECK ADD 
	CONSTRAINT [pk_ServiceDorei] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[VazeatKhedmat] WITH NOCHECK ADD 
	CONSTRAINT [pk_VazeatKhedmat] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[admin_Entity] WITH NOCHECK ADD 
	CONSTRAINT [PK_admin_Entity] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[admin_UC] WITH NOCHECK ADD 
	CONSTRAINT [PK_admin_UC] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[naghshe] WITH NOCHECK ADD 
	CONSTRAINT [PK_naghshe] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[naghshe1] WITH NOCHECK ADD 
	CONSTRAINT [PK_naghshe1] PRIMARY KEY  CLUSTERED 
	(
		[id]
	)  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[noeServiceDorei] WITH NOCHECK ADD 
	CONSTRAINT [PK_noeServiceDorei] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[rangeKhodroMapping] WITH NOCHECK ADD 
	CONSTRAINT [PK_rangeKhodroMapping] PRIMARY KEY  CLUSTERED 
	(
		[RangCodeEmdad]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[report_parameters] WITH NOCHECK ADD 
	CONSTRAINT [PK_report_parameters] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[roles] WITH NOCHECK ADD 
	CONSTRAINT [pk_roles] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Bazaryab] WITH NOCHECK ADD 
	CONSTRAINT [pk_Bazaryab] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Emdadgar] WITH NOCHECK ADD 
	CONSTRAINT [pk_Emdadgar] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[MojoodiAnbar] WITH NOCHECK ADD 
	CONSTRAINT [pk_MojoodiAnbar] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[NoeKhodro] WITH NOCHECK ADD 
	CONSTRAINT [pk_NoeKhodro] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Shahr] WITH NOCHECK ADD 
	CONSTRAINT [pk_Shahr] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Shakhs] WITH NOCHECK ADD 
	CONSTRAINT [PK_Shakhs] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[AnbarEmdadgar] WITH NOCHECK ADD 
	CONSTRAINT [pk_AnbarEmdadgar] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[DarkhastEshterak] WITH NOCHECK ADD 
	CONSTRAINT [pk_DarkhastEshterak] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[DarkhastQate] WITH NOCHECK ADD 
	CONSTRAINT [pk_DarkhastQate] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[KasriEmdad] WITH NOCHECK ADD 
	CONSTRAINT [pk_KasriEmdad] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Khodrojagozin] WITH NOCHECK ADD 
	CONSTRAINT [pk_Khodrojagozin] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Moshtarak] WITH NOCHECK ADD 
	CONSTRAINT [pk_Moshtarak] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Namayandegi] WITH NOCHECK ADD 
	CONSTRAINT [pk_Namayandegi] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[JozeatKasri] WITH NOCHECK ADD 
	CONSTRAINT [pk_JozeatKasri] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Rokhdad] WITH NOCHECK ADD 
	CONSTRAINT [pk_Rokhdad] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[TamdidEshterak] WITH NOCHECK ADD 
	CONSTRAINT [pk_TamdidEshterak] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[Emdad] WITH NOCHECK ADD 
	CONSTRAINT [pk_Emdad] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[MostanadatRokhdad] WITH NOCHECK ADD 
	CONSTRAINT [pk_MostanadatRokhdad] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[JozeatKhedmat] WITH NOCHECK ADD 
	CONSTRAINT [pk_JozeatKhedmat] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[KhodrojagozinMasraf] WITH NOCHECK ADD 
	CONSTRAINT [pk_KhodrojagozinMasraf] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[PeigiriEzamgar] WITH NOCHECK ADD 
	CONSTRAINT [pk_PeigiriEzamgar] PRIMARY KEY  CLUSTERED 
	(
		[id]
	) WITH  FILLFACTOR = 90  ON [PRIMARY] 
GO

ALTER TABLE [dbo].[ServiceDorei] WITH NOCHECK ADD 
	CONSTRAINT [DF_ServiceDorei_taeedHesabdar] DEFAULT (2) FOR [taeedHesabdar],
	CONSTRAINT [DF_ServiceDorei_taeedNamayandeh] DEFAULT (2) FOR [taeedNamayandeh]
GO

ALTER TABLE [dbo].[report_fields] WITH NOCHECK ADD 
	CONSTRAINT [DF_report_fields_dateFormat] DEFAULT (4) FOR [dateFormat]
GO

ALTER TABLE [dbo].[report_views_fieldss] WITH NOCHECK ADD 
	CONSTRAINT [DF_report_views_fields_reportId] DEFAULT (0) FOR [reportId],
	CONSTRAINT [DF_report_views_fields_selectable] DEFAULT (1) FOR [selectable]
GO

ALTER TABLE [dbo].[tempfields] WITH NOCHECK ADD 
	CONSTRAINT [DF_tempfields_fontId] DEFAULT (1) FOR [fontId],
	CONSTRAINT [DF_tempfields_fontColor] DEFAULT (122) FOR [fontColor],
	CONSTRAINT [DF_tempfields_fontSize] DEFAULT (10) FOR [fontSize],
	CONSTRAINT [DF_tempfields_ColNo] DEFAULT (1) FOR [ColNo],
	CONSTRAINT [DF_tempfields_RealSize] DEFAULT (30) FOR [RealSize],
	CONSTRAINT [DF_tempfields_Alignment] DEFAULT (N'Center') FOR [Alignment],
	CONSTRAINT [DF_tempfields_ColCount] DEFAULT (0) FOR [ColCount]
GO

ALTER TABLE [dbo].[views_fields] WITH NOCHECK ADD 
	CONSTRAINT [DF_views_fields_selectable] DEFAULT (1) FOR [selectable]
GO

ALTER TABLE [dbo].[MojoodiAnbar] WITH NOCHECK ADD 
	CONSTRAINT [DF_MojoodiAnbar_anbarId] DEFAULT (1) FOR [anbarId]
GO

ALTER TABLE [dbo].[Shakhs] WITH NOCHECK ADD 
	CONSTRAINT [DF_Shakhs_roleGroup] DEFAULT ('Roles') FOR [roleGroup]
GO

ALTER TABLE [dbo].[AnbarEmdadgar] WITH NOCHECK ADD 
	CONSTRAINT [DF_AnbarEmdadgar_mojoodi] DEFAULT (0) FOR [mojoodi]
GO

 CREATE  INDEX [MojoodiMojazX1] ON [dbo].[MojoodiMojaz]([noeEmdadgarId]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  UNIQUE  INDEX [shomareShasi] ON [dbo].[Moshtarak]([shomareShasi]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  UNIQUE  INDEX [eshterakId] ON [dbo].[Moshtarak]([eshterakId]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  INDEX [nameKhanevadegi] ON [dbo].[Moshtarak]([nameKhanevadegi]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  INDEX [name] ON [dbo].[Moshtarak]([name]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  INDEX [tarikhShoro] ON [dbo].[Moshtarak]([tarikhShoro]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  INDEX [tarikhEngheza] ON [dbo].[Moshtarak]([tarikhEngheza]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  INDEX [shomarePelak] ON [dbo].[Moshtarak]([shomarePelak]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  INDEX [shomareMotor] ON [dbo].[Moshtarak]([shomareMotor]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  INDEX [rokhdadId] ON [dbo].[Rokhdad]([rokhdadId]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

 CREATE  INDEX [emdadId] ON [dbo].[Emdad]([emdadId]) WITH  FILLFACTOR = 90 ON [PRIMARY]
GO

ALTER TABLE [dbo].[Bazaryab] ADD 
	CONSTRAINT [FK_Bazaryab_NoeBazaryab] FOREIGN KEY 
	(
		[noeBazaryabId]
	) REFERENCES [dbo].[NoeBazaryab] (
		[id]
	)
GO

ALTER TABLE [dbo].[Emdadgar] ADD 
	CONSTRAINT [FK_Emdadgar_NoeEmdadgar] FOREIGN KEY 
	(
		[noeEmdadgarId]
	) REFERENCES [dbo].[NoeEmdadgar] (
		[id]
	)
GO

ALTER TABLE [dbo].[MojoodiAnbar] ADD 
	CONSTRAINT [FK_MojoodiAnbar_Qate] FOREIGN KEY 
	(
		[qateId]
	) REFERENCES [dbo].[Qate] (
		[id]
	)
GO

ALTER TABLE [dbo].[NoeKhodro] ADD 
	CONSTRAINT [FK_NoeKhodro_Khodrosaz] FOREIGN KEY 
	(
		[khodrosazId]
	) REFERENCES [dbo].[Khodrosaz] (
		[id]
	)
GO

ALTER TABLE [dbo].[Shahr] ADD 
	CONSTRAINT [FK_Shahr_Ostan] FOREIGN KEY 
	(
		[ostanId]
	) REFERENCES [dbo].[Ostan] (
		[id]
	)
GO

ALTER TABLE [dbo].[Shakhs] ADD 
	CONSTRAINT [FK_Shakhs_DaftarOstani] FOREIGN KEY 
	(
		[daftarOstaniId]
	) REFERENCES [dbo].[DaftarOstani] (
		[id]
	)
GO

ALTER TABLE [dbo].[AnbarEmdadgar] ADD 
	CONSTRAINT [FK_AnbarEmdadgar_Emdadgar] FOREIGN KEY 
	(
		[emdadgarId]
	) REFERENCES [dbo].[Emdadgar] (
		[id]
	),
	CONSTRAINT [FK_AnbarEmdadgar_Qate] FOREIGN KEY 
	(
		[qateId]
	) REFERENCES [dbo].[Qate] (
		[id]
	)
GO

ALTER TABLE [dbo].[DarkhastEshterak] ADD 
	CONSTRAINT [FK_DarkhastEshterak_NoeKhodro] FOREIGN KEY 
	(
		[noeKhodroId]
	) REFERENCES [dbo].[NoeKhodro] (
		[id]
	),
	CONSTRAINT [FK_DarkhastEshterak_RangeKhodro] FOREIGN KEY 
	(
		[rangeKhodroId]
	) REFERENCES [dbo].[RangeKhodro] (
		[id]
	),
	CONSTRAINT [FK_DarkhastEshterak_Shahr] FOREIGN KEY 
	(
		[shahrId]
	) REFERENCES [dbo].[Shahr] (
		[id]
	)
GO

ALTER TABLE [dbo].[DarkhastQate] ADD 
	CONSTRAINT [FK_DarkhastQate_Emdadgar] FOREIGN KEY 
	(
		[emdadgarId]
	) REFERENCES [dbo].[Emdadgar] (
		[id]
	),
	CONSTRAINT [FK_DarkhastQate_Qate] FOREIGN KEY 
	(
		[qateId]
	) REFERENCES [dbo].[Qate] (
		[id]
	)
GO

ALTER TABLE [dbo].[KasriEmdad] ADD 
	CONSTRAINT [FK_KasriEmdad_Emdadgar] FOREIGN KEY 
	(
		[emdadgarId]
	) REFERENCES [dbo].[Emdadgar] (
		[id]
	)
GO

ALTER TABLE [dbo].[Khodrojagozin] ADD 
	CONSTRAINT [FK_Khodrojagozin_NoeKhodro] FOREIGN KEY 
	(
		[noeKhodroId]
	) REFERENCES [dbo].[NoeKhodro] (
		[id]
	),
	CONSTRAINT [FK_Khodrojagozin_RangeKhodro] FOREIGN KEY 
	(
		[rangeKhodroId]
	) REFERENCES [dbo].[RangeKhodro] (
		[id]
	)
GO

ALTER TABLE [dbo].[Moshtarak] ADD 
	CONSTRAINT [FK_Moshtarak_Bazaryab1] FOREIGN KEY 
	(
		[bazaryabId]
	) REFERENCES [dbo].[Bazaryab] (
		[id]
	)
GO

ALTER TABLE [dbo].[Namayandegi] ADD 
	CONSTRAINT [FK_Namayandegi_NoeKhodro] FOREIGN KEY 
	(
		[noeKhodroId]
	) REFERENCES [dbo].[NoeKhodro] (
		[id]
	),
	CONSTRAINT [FK_Namayandegi_Shahr] FOREIGN KEY 
	(
		[shahrId]
	) REFERENCES [dbo].[Shahr] (
		[id]
	)
GO

ALTER TABLE [dbo].[JozeatKasri] ADD 
	CONSTRAINT [FK_JozeatKasri_KasriEmdad] FOREIGN KEY 
	(
		[kasriEmdadId]
	) REFERENCES [dbo].[KasriEmdad] (
		[id]
	),
	CONSTRAINT [FK_JozeatKasri_Qate] FOREIGN KEY 
	(
		[qateId]
	) REFERENCES [dbo].[Qate] (
		[id]
	)
GO

ALTER TABLE [dbo].[Rokhdad] ADD 
	CONSTRAINT [FK_Rokhdad_DaftarOstani] FOREIGN KEY 
	(
		[daftarOstaniId]
	) REFERENCES [dbo].[DaftarOstani] (
		[id]
	),
	CONSTRAINT [FK_Rokhdad_Moshtarak] FOREIGN KEY 
	(
		[moshtarakId]
	) REFERENCES [dbo].[Moshtarak] (
		[id]
	),
	CONSTRAINT [FK_Rokhdad_Namayandegi] FOREIGN KEY 
	(
		[namayandegiId]
	) REFERENCES [dbo].[Namayandegi] (
		[id]
	),
	CONSTRAINT [FK_Rokhdad_Shahr] FOREIGN KEY 
	(
		[shahrId]
	) REFERENCES [dbo].[Shahr] (
		[id]
	)
GO

ALTER TABLE [dbo].[TamdidEshterak] ADD 
	CONSTRAINT [FK_TamdidEshterak_Moshtarak] FOREIGN KEY 
	(
		[moshtarakId]
	) REFERENCES [dbo].[Moshtarak] (
		[id]
	)
GO

ALTER TABLE [dbo].[Emdad] ADD 
	CONSTRAINT [FK_Emdad_DalileToolKeshidaneEmdad] FOREIGN KEY 
	(
		[dalileToolKeshidaneEmdadId]
	) REFERENCES [dbo].[DalileToolKeshidaneEmdad] (
		[id]
	),
	CONSTRAINT [FK_Emdad_Emdadgar] FOREIGN KEY 
	(
		[emdadgarId]
	) REFERENCES [dbo].[Emdadgar] (
		[id]
	),
	CONSTRAINT [FK_Emdad_Namayandegi] FOREIGN KEY 
	(
		[namayandegiId]
	) REFERENCES [dbo].[Namayandegi] (
		[id]
	),
	CONSTRAINT [FK_Emdad_NoeEmdadgar] FOREIGN KEY 
	(
		[noeEmdadgarId]
	) REFERENCES [dbo].[NoeEmdadgar] (
		[id]
	),
	CONSTRAINT [FK_Emdad_Rokhdad] FOREIGN KEY 
	(
		[rokhdadId]
	) REFERENCES [dbo].[Rokhdad] (
		[id]
	),
	CONSTRAINT [FK_Emdad_Shakhs] FOREIGN KEY 
	(
		[ezamgarId]
	) REFERENCES [dbo].[Shakhs] (
		[id]
	),
	CONSTRAINT [FK_Emdad_VazeatKhedmat] FOREIGN KEY 
	(
		[vazeatKhedmatId]
	) REFERENCES [dbo].[VazeatKhedmat] (
		[id]
	)
GO

ALTER TABLE [dbo].[MostanadatRokhdad] ADD 
	CONSTRAINT [FK_MostanadatRokhdad_Rokhdad] FOREIGN KEY 
	(
		[rokhdadId]
	) REFERENCES [dbo].[Rokhdad] (
		[id]
	)
GO

ALTER TABLE [dbo].[JozeatKhedmat] ADD 
	CONSTRAINT [FK_JozeatKhedmat_Emdad] FOREIGN KEY 
	(
		[khedmatId]
	) REFERENCES [dbo].[Emdad] (
		[id]
	),
	CONSTRAINT [FK_JozeatKhedmat_Irad] FOREIGN KEY 
	(
		[iradId]
	) REFERENCES [dbo].[Irad] (
		[id]
	),
	CONSTRAINT [FK_JozeatKhedmat_Ojrat] FOREIGN KEY 
	(
		[ojratId]
	) REFERENCES [dbo].[Ojrat] (
		[id]
	),
	CONSTRAINT [FK_JozeatKhedmat_Qate] FOREIGN KEY 
	(
		[qateId]
	) REFERENCES [dbo].[Qate] (
		[id]
	),
	CONSTRAINT [FK_JozeatKhedmat_Shakhs] FOREIGN KEY 
	(
		[ijadKonandeh]
	) REFERENCES [dbo].[Shakhs] (
		[id]
	)
GO

ALTER TABLE [dbo].[KhodrojagozinMasraf] ADD 
	CONSTRAINT [FK_KhodrojagozinMasraf_Emdad] FOREIGN KEY 
	(
		[emdadId]
	) REFERENCES [dbo].[Emdad] (
		[id]
	),
	CONSTRAINT [FK_KhodrojagozinMasraf_Khodrojagozin] FOREIGN KEY 
	(
		[khodrojagozinId]
	) REFERENCES [dbo].[Khodrojagozin] (
		[id]
	)
GO

ALTER TABLE [dbo].[PeigiriEzamgar] ADD 
	CONSTRAINT [FK_PeigiriEzamgar_Emdad] FOREIGN KEY 
	(
		[emdadId]
	) REFERENCES [dbo].[Emdad] (
		[id]
	)
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

/****** Object:  View dbo.userRoles    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.report_views_fields    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.report_views_fields1    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.report_views_fields2    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_adminMenu    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_jozeatKhedmat    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_jozeatKhedmatTH    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_mojoodiMojaz    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

/****** Object:  View dbo.view_shakhs    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.MoshtarakReport    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_mojoodiAnbar    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_noeKhodro    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_shahr    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_sub_cars    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.AnbarEmdadgarList    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.MoshtarakList    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_anbarEmdadgar    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_darkhastEshterak    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_darkhasttagheer    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_emdad    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_emdadRokhdad    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
CREATE VIEW dbo.view_emdadRokhdad
AS
SELECT     DATEDIFF(mi, dbo.Rokhdad.zamaneVaghei, dbo.Emdad.zamanEzam) AS modatZamanEzam, DATEDIFF(mi, dbo.Emdad.zamanEzam, 
                      dbo.Emdad.zamanShoro) AS modatZamanResidan, DATEDIFF(mi, dbo.Emdad.zamanShoro, dbo.Emdad.zamanPayan) AS modatZamanAnjam, 
                      DATEDIFF(mi, dbo.Rokhdad.zamaneVaghei, dbo.Emdad.zamanShoro) AS modatZamanEntezar, dbo.Rokhdad.rokhdadId, dbo.Rokhdad.zamaneVaghei, 
                      dbo.Emdad.emdadId, dbo.Emdad.noeEmdad, dbo.Emdad.zamanEzam, dbo.Emdad.zamanVagheiEzam, dbo.Emdad.ezamgarId, 
                      dbo.Emdad.emdadgarId, dbo.Emdad.zamanShoro, dbo.Emdad.zamanVagheiShoro, dbo.Emdad.zamanVagheiPayan, dbo.Emdad.zamanPayan, 
                      dbo.Rokhdad.shahrId, dbo.Emdad.id, dbo.Emdad.namayandegiId, dbo.Rokhdad.sabtKonandeh, dbo.Rokhdad.moshtarakId, dbo.Rokhdad.irad, 
                      dbo.Emdad.rahAndazi, dbo.Rokhdad.sabetSayar, dbo.Rokhdad.address, dbo.Emdad.noeKhedmateVije, dbo.Emdad.kilometerKarkard, 
                      dbo.Rokhdad.mantagheh, dbo.Emdad.vazeatKonuni, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.moshtarakYaNa, dbo.Moshtarak.eshterakId, 
                      dbo.Moshtarak.noeKhodroId, dbo.NoeKhodro.onvan, Shakhs_1.name AS ezamgar, CAST(dbo.Namayandegi.namayandegiId AS nvarchar) 
                      + '-' + dbo.Namayandegi.name AS namayandegi, dbo.Emdadgar.name AS emdadgar, dbo.Emdadgar.noeEmdadgarId, 
                      dbo.NoeEmdadgar.onvan AS noeEmdadgar, Shakhs_2.name AS akharinTagheerDahandeh, Shakhs_3.name AS pazireshgar
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

/****** Object:  View dbo.view_emdadgar    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_joghraphy    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
CREATE VIEW dbo.view_joghraphy
AS
SELECT     dbo.Namayandegi.name AS namayandegiName, dbo.Shahr.shahrName, dbo.Ostan.name AS ostanName, dbo.Emdadgar.name AS emdadgarName, 
                      dbo.Emdadgar.vazeat, dbo.Emdadgar.hadaksarKar, dbo.Emdadgar.karDarDast, dbo.Shahr.azArz AS shahrAzArz, dbo.Shahr.taArz AS shahrTaArz, 
                      dbo.Shahr.azTool AS shahrAzTool, dbo.Shahr.taTool AS shahrTaTool, dbo.Emdadgar.azArz, dbo.Emdadgar.taArz, dbo.Emdadgar.azTool, 
                      dbo.Emdadgar.taTool
FROM         dbo.Emdadgar LEFT OUTER JOIN
                      dbo.Namayandegi ON dbo.Emdadgar.namayandegiId = dbo.Namayandegi.id INNER JOIN
                      dbo.Shahr ON dbo.Namayandegi.shahrId = dbo.Shahr.id INNER JOIN
                      dbo.Ostan ON dbo.Shahr.ostanId = dbo.Ostan.id

GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

/****** Object:  View dbo.view_kasriEmdad    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_khodrojagozin    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_namayandegi    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_report_Namayandegi    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_report_Rokhdad    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_rokhdadMoshtarak    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
CREATE VIEW dbo.view_rokhdadMoshtarak
AS
SELECT     dbo.Rokhdad.id, dbo.Rokhdad.rokhdadId, dbo.Moshtarak.eshterakId, dbo.Moshtarak.noeEshterak, dbo.Moshtarak.tarikhEnghezaGuarantee, 
                      dbo.Moshtarak.tarikhEngheza, dbo.Moshtarak.vazeat, dbo.Rokhdad.guarantee, dbo.Rokhdad.noeService, dbo.Rokhdad.moshtarakYaNa
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

/****** Object:  View dbo.view_savabegh    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_serviceDorei    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.rokhdadList    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
CREATE VIEW dbo.rokhdadList
AS
SELECT     TOP 100 PERCENT dbo.Rokhdad.id, dbo.Rokhdad.rokhdadId, dbo.Rokhdad.address, dbo.Rokhdad.sabetSayar, dbo.Moshtarak.eshterakId, 
                      dbo.DaftarOstani.name AS nameDaftarOstani, dbo.Shahr.shahrName, dbo.Rokhdad.tarikhFaalShodan, dbo.Rokhdad.zamaneVaghei, 
                      dbo.Rokhdad.khadamateVijeh, dbo.Namayandegi.name AS nameNamayandegi, dbo.Rokhdad.tel, dbo.Rokhdad.mobile, dbo.Rokhdad.irad, 
                      dbo.Rokhdad.mantagheh, dbo.Rokhdad.daftarOstaniId, dbo.Rokhdad.noeDarkhastKonandeh, dbo.Rokhdad.shahrId, dbo.Rokhdad.dastorkarGhabli, 
                      dbo.NoeKhodro.onvan AS noeKhodroName, dbo.RangeKhodro.onvan AS rangOnvan, Shakhs_1.name AS sabtKonandeh, 
                      Shakhs_2.name AS akharinTaghyirDahandeh, dbo.Moshtarak.tarikhTahvil, dbo.Moshtarak.shomarePelak, dbo.Rokhdad.eghdamShodeh, 
                      dbo.Rokhdad.kilometerKarkard, dbo.Rokhdad.noeService, dbo.Rokhdad.guarantee, dbo.Rokhdad.moshtarakYaNa, 
                      dbo.Rokhdad.kilometerKarkardGhabli
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

/****** Object:  View dbo.view_bazaryab    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_jozeatKasri    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_tamdidEshterak    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS ON 
GO

/****** Object:  View dbo.emdadList    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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
                      dbo.Emdad.hazinehBoxel, dbo.Rokhdad.irad, dbo.Emdadgar.mobile, dbo.Rokhdad.kilometerKarkardGhabli, dbo.Emdad.noeEmdadgarId
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

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

/****** Object:  View dbo.view_mostanadatRokhdad    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_report_moshtarak    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_Mali    Script Date: 2004/05/29 10:19:46 ق.ظ ******/
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

/****** Object:  View dbo.view_PeigiriEzamgar    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
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

/****** Object:  View dbo.view_khodrojagozinMasraf    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
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

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.Add2Log    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure Add2Log
	@src  varchar(30),
	@data varchar(128)

as
begin
	if (1=1)
	begin
		set xact_abort on
		begin tran
		
		insert into logs(src, data) values (@src, @data)
		
		commit tran
	end

end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateDastoorKarGhabliRokhdad    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateDastoorKarGhabliRokhdad
	@Id char(19),

	@dastoorKarGhabli int
as
begin
	set xact_abort on
	begin tran

	update rokhdad set dastorkarGhabli = @dastoorKarGhabli where id = @Id

	commit tran
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateRelationEmdad    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateRelationEmdad
	@Id char(19),

	@rokhdadId char(19),
	@vazeatKhedmatId char(19),
	@emdadgarId char(19),
	@ezamgarId char(19),
	@dalileToolKeshidaneEmdadId char(19),
	@namayandegiId char(19)

as
begin
	set xact_abort on
	--execute Add2Log 'UpdateRelationMoshtarak,0', @Id
	begin tran
	 IF (@namayandegiId = '' ) BEGIN
		set @namayandegiId = null
	END
	 IF (@emdadgarId = '' ) BEGIN
		set @emdadgarId = null
	END
	 IF (@dalileToolKeshidaneEmdadId = '' ) BEGIN
		set @dalileToolKeshidaneEmdadId = null
	END

	update Emdad  set  
		rokhdadId = @rokhdadId ,
		vazeatKhedmatId = @vazeatKhedmatId ,
		emdadgarId = @emdadgarId ,
		ezamgarId = @ezamgarId,
		dalileToolKeshidaneEmdadId = @dalileToolKeshidaneEmdadId ,
		namayandegiId = @namayandegiId
	where id=@Id
	commit tran
	--execute Add2Log 'UpdateRelationMoshtarak,1', @Id
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateRelationKasriEmdad    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateRelationKasriEmdad
	@Id char(19),

	@emdadgarId char(19)

as
begin
	set xact_abort on
	 IF (@emdadgarId = '' ) BEGIN
		set @emdadgarId = null
	END

	begin tran

	update KasriEmdad  set  
		emdadgarId = @emdadgarId 
	where id=@Id

	commit tran
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateRelationRokhdad    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateRelationRokhdad
	@Id char(19),

	@moshtarakId char(19),
	@namayandegiId char(19),
	@daftarOstaniId char(19),
	@shahrId char(19)

as
begin
	set xact_abort on
	--execute Add2Log 'UpdateRelationMoshtarak,0', @Id
	begin tran
	 IF (@namayandegiId = '' ) BEGIN
		set @namayandegiId = null
	END

	update Rokhdad  set  
		moshtarakId = @moshtarakId ,
		namayandegiId = @namayandegiId ,
		daftarOstaniId = @daftarOstaniId ,
		shahrId = @shahrId
	where id=@Id
	commit tran
	--execute Add2Log 'UpdateRelationMoshtarak,1', @Id
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.PayanEmdad    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure PayanEmdad
	@Id char(19),

	@AkharinTagheerDahandeh char(19),
	@FaseleAzNamayandegi int,
	@ZamanPayan datetime,
	@ZamanVagheiPayan datetime,
	@KilometerKarkard int,
	@MablaghPardakhtShodeh int,
	@RahAndazi nvarchar(120),
	@Tozihat nvarchar(160),
	@ElateService nvarchar(64),
	@DalileToolKeshidaneEmdadId char(19),
	@EmdadgarId char(19) ,
	@NamayandegiId char(19)

as
begin
	set xact_abort on
	--execute Add2Log 'PayanEmdad,0', @DalileToolKeshidaneEmdadId
	 IF (@DalileToolKeshidaneEmdadId = '' ) BEGIN
		set @DalileToolKeshidaneEmdadId = null
	END
	begin tran

	declare @RokhdadId char(19) ,
		@noeEmdad int

	set @RokhdadId = (select rokhdadId from emdad where id=@Id)
	set @noeEmdad = (select noeEmdad  from emdad where id=@Id)
	
	update Emdad  set  
		AkharinTagheerDahandeh=@AkharinTagheerDahandeh ,
		FaseleAzNamayandegi=@FaseleAzNamayandegi ,
		ZamanPayan=@ZamanPayan ,
		ZamanVagheiPayan=@ZamanVagheiPayan, 
		KilometerKarkard=@KilometerKarkard,
		MablaghPardakhtShodeh=@MablaghPardakhtShodeh ,
		RahAndazi=@RahAndazi ,
		Tozihat=@Tozihat ,
		ElateService=@ElateService ,
		vazeatKonuni = 2 ,
		DalileToolKeshidaneEmdadId=@DalileToolKeshidaneEmdadId
		where id=@Id

	if ( (@EmdadgarId is not null) and (len(@EmdadgarId)>0)) begin
		update emdadgar set karDarDast=karDarDast-1 where karDarDast>0 and id=@EmdadgarId
	end
/*
	if ( (@namayandegiId is not null) and (len(@namayandegiId)>0)) begin
		if (@noeEmdad = 1) begin
			update Namayandegi set karDarDast=karDarDast+1 where karDarDast<hadAksarKar and id=@namayandegiId
		end
		else
		begin
			update Namayandegi set karDarDast2=karDarDast2+1 where karDarDast2<hadAksarKar2 and id=@namayandegiId
		end
	end
*/
	if ( (@NamayandegiId is not null) and (len(@NamayandegiId)>0)) begin
		update Namayandegi set karDarDast=karDarDast-1 where karDarDast>0 and id=@NamayandegiId
	end

	update rokhdad set dastorkarGhabli = 0 where id = @RokhdadId

	commit tran
	--execute Add2Log 'PayanEmdad,1', @Id
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.PayanEmdad2    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure PayanEmdad2
	@Id char(19),

	@AkharinTagheerDahandeh char(19),
	@FaseleAzNamayandegi int,
	@ZamanPayan datetime,
	@ZamanVagheiPayan datetime,
	@KilometerKarkard int,
	@MablaghPardakhtShodeh int,
	@RahAndazi nvarchar(120),
	@Tozihat nvarchar(160),
	@ElateService nvarchar(64),
	@DalileToolKeshidaneEmdadId char(19),
	@EmdadgarId char(19) ,
	@NamayandegiId char(19)

as
begin
	set xact_abort on
	--execute Add2Log 'PayanEmdad,0', @DalileToolKeshidaneEmdadId
	 IF (@DalileToolKeshidaneEmdadId = '' ) BEGIN
		set @DalileToolKeshidaneEmdadId = null
	END
	begin tran

	declare @RokhdadId char(19) ,
		@noeEmdad int

	set @RokhdadId = (select rokhdadId from emdad where id=@Id)
	set @noeEmdad = (select noeEmdad  from emdad where id=@Id)
	
	update Emdad  set  
		AkharinTagheerDahandeh=@AkharinTagheerDahandeh ,
		FaseleAzNamayandegi=@FaseleAzNamayandegi ,
		ZamanPayan=@ZamanPayan ,
		ZamanVagheiPayan=@ZamanVagheiPayan, 
		KilometerKarkard=@KilometerKarkard,
		MablaghPardakhtShodeh=@MablaghPardakhtShodeh ,
		RahAndazi=@RahAndazi ,
		Tozihat=@Tozihat ,
		ElateService=@ElateService ,
		vazeatKonuni = 2 ,
		DalileToolKeshidaneEmdadId=@DalileToolKeshidaneEmdadId
		where id=@Id

	if ( (@EmdadgarId is not null) and (len(@EmdadgarId)>0)) begin
		update emdadgar set karDarDast=karDarDast-1 where karDarDast>0 and id=@EmdadgarId
	end

	if ( (@namayandegiId is not null) and (len(@namayandegiId)>0)) begin
		if (@noeEmdad = 1) begin
			update Namayandegi set karDarDast=karDarDast-1 where karDarDast>0 and id=@namayandegiId
		end
		else
		begin
			update Namayandegi set karDarDast2=karDarDast2-1 where karDarDast2>0 and id=@namayandegiId
		end
	end

	update rokhdad set dastorkarGhabli = 0 where id = @RokhdadId

	commit tran
	--execute Add2Log 'PayanEmdad,1', @Id
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER ON 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.PayanEmdad3    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure PayanEmdad3
	@Id char(19),

	@AkharinTagheerDahandeh char(19),
	@FaseleAzNamayandegi int,
	@ZamanPayan datetime,
	@ZamanVagheiPayan datetime,
	@KilometerKarkard int,
	@MablaghPardakhtShodeh int,
	@HazinehAyyabZahab int,
	@RahAndazi nvarchar(120),
	@Tozihat nvarchar(160),
	@ElateService nvarchar(64),
	@DalileToolKeshidaneEmdadId char(19),
	@EmdadgarId char(19) ,
	@NamayandegiId char(19)

as
begin
	set xact_abort on
	--execute Add2Log 'PayanEmdad,0', @DalileToolKeshidaneEmdadId
	 IF (@DalileToolKeshidaneEmdadId = '' ) BEGIN
		set @DalileToolKeshidaneEmdadId = null
	END
	begin tran

	declare @RokhdadId char(19) ,
		@noeEmdad int

	set @RokhdadId = (select rokhdadId from emdad where id=@Id)
	set @noeEmdad = (select noeEmdad  from emdad where id=@Id)
	
	update Emdad  set  
		AkharinTagheerDahandeh=@AkharinTagheerDahandeh ,
		FaseleAzNamayandegi=@FaseleAzNamayandegi ,
		ZamanPayan=@ZamanPayan ,
		ZamanVagheiPayan=@ZamanVagheiPayan, 
		KilometerKarkard=@KilometerKarkard,
		MablaghPardakhtShodeh=@MablaghPardakhtShodeh ,
		HazinehAyyabZahab = @HazinehAyyabZahab ,
		RahAndazi=@RahAndazi ,
		Tozihat=@Tozihat ,
		ElateService=@ElateService ,
		vazeatKonuni = 2 ,
		DalileToolKeshidaneEmdadId=@DalileToolKeshidaneEmdadId
		where id=@Id

	if ( (@EmdadgarId is not null) and (len(@EmdadgarId)>0)) begin
		update emdadgar set karDarDast=karDarDast-1 where karDarDast>0 and id=@EmdadgarId
	end

	if ( (@namayandegiId is not null) and (len(@namayandegiId)>0)) begin
		if (@noeEmdad = 1) begin
			update Namayandegi set karDarDast=karDarDast-1 where karDarDast>0 and id=@namayandegiId
		end
		else
		begin
			update Namayandegi set karDarDast2=karDarDast2-1 where karDarDast2>0 and id=@namayandegiId
		end
	end

	update rokhdad set dastorkarGhabli = 0 where id = @RokhdadId

	commit tran
	--execute Add2Log 'PayanEmdad,1', @Id
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateAnbarEmdadgar    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateAnbarEmdadgar
	@Id char(19),

	@emdadgarId char(19),
	@qateId char(19)

as
begin
	set xact_abort on

	begin tran

	update AnbarEmdadgar set  
		emdadgarId = @emdadgarId ,
		qateId = @qateId
	where id=@Id

	commit tran

end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateRelationEmdad2    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateRelationEmdad2
	@Id char(19),

	@rokhdadId char(19),
	@vazeatKhedmatId char(19),
	@emdadgarId char(19),
	@ezamgarId char(19),
	@dalileToolKeshidaneEmdadId char(19),
	@namayandegiId char(19)

as
begin
	set xact_abort on
	--execute Add2Log 'UpdateRelationMoshtarak,0', @Id
	 IF (@namayandegiId = '' ) BEGIN
		set @namayandegiId = null
	END
	 IF (@emdadgarId = '' ) BEGIN
		set @emdadgarId = null
	END
	 IF (@dalileToolKeshidaneEmdadId = '' ) BEGIN
		set @dalileToolKeshidaneEmdadId = null
	END

	declare @oldEmdadgarId char(19) ,
		@oldNamayandegiId char(19) ,
		@noeEmdad int ,
		@vazeatKonuni int

	set @oldEmdadgarId = (select emdadgarId  from emdad where id=@Id)
	set @noeEmdad = (select noeEmdad  from emdad where id=@Id)
	set @oldNamayandegiId = (select namayandegiId  from emdad where id=@Id)
	set @vazeatKonuni = (select vazeatKonuni  from emdad where id=@Id)

	begin tran

	if (@vazeatKonuni != 2) 
	begin
		if ( (@oldEmdadgarId is not null) and (len(@oldEmdadgarId)>0)) begin
			update Emdadgar set karDarDast=karDarDast-1 where karDarDast>0 and id=@oldEmdadgarId
		end
		if ( (@emdadgarId is not null) and (len(@emdadgarId)>0)) begin
			update Emdadgar set karDarDast=karDarDast+1 where karDarDast<hadAksarKar and id=@emdadgarId
		end
	
		if (@noeEmdad = 1) begin
			if ( (@oldNamayandegiId is not null) and (len(@oldNamayandegiId)>0)) begin
				update Namayandegi set karDarDast=karDarDast-1 where karDarDast>0 and id=@oldNamayandegiId
			end
			if ( (@namayandegiId is not null) and (len(@namayandegiId)>0)) begin
				update Namayandegi set karDarDast=karDarDast+1 where karDarDast<hadAksarKar and id=@namayandegiId
			end
		end
		else
		begin
			if ( (@oldNamayandegiId is not null) and (len(@oldNamayandegiId)>0)) begin
				update Namayandegi set karDarDast2=karDarDast2-1 where karDarDast2>0 and id=@oldNamayandegiId
			end
			if ( (@namayandegiId is not null) and (len(@namayandegiId)>0)) begin
				update Namayandegi set karDarDast2=karDarDast2+1 where karDarDast2<hadAksarKar2 and id=@namayandegiId
			end
		end
	end

	update Emdad  set  
		rokhdadId = @rokhdadId ,
		vazeatKhedmatId = @vazeatKhedmatId ,
		emdadgarId = @emdadgarId ,
		ezamgarId = @ezamgarId,
		dalileToolKeshidaneEmdadId = @dalileToolKeshidaneEmdadId ,
		namayandegiId = @namayandegiId
	where id=@Id

	commit tran
	--execute Add2Log 'UpdateRelationMoshtarak,1', @Id
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateRelationMoshtarak    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateRelationMoshtarak
	@Id char(19),

	@shahrId char(19),
	@noeKhodroId char(19),
	@rangeKhodroId char(19),
	@bazaryabId char(19)

as
begin
	set xact_abort on
	--execute Add2Log 'UpdateRelationMoshtarak,0', @Id
	begin tran

	update Moshtarak  set  
		shahrId = @shahrId ,
		noeKhodroId = @noeKhodroId ,
		rangeKhodroId = @rangeKhodroId ,
		bazaryabId = @bazaryabId
	where id=@Id
	commit tran
	--execute Add2Log 'UpdateRelationMoshtarak,1', @Id
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.aaa    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure aaa
	@noeKhodroId varchar(20),
	@ProdYear smallint

as
begin
	declare
		@khodrosazId varchar(20),
		@B varchar(20),
		@C varchar(20),
		@D varchar(20),
		@A bigint

	set @ProdYear = @ProdYear  % 100

	set @khodrosazId = (select khodrosazId from noeKhodro where id = @noeKhodroId)
	set @khodrosazId = (select khodrosazId from khodrosaz where id = @khodrosazId) % 100
	set @C = @khodrosazId --str(@khodrosazId)
	if (len(@C)<2)
		set @C = '0' + @C
execute Add2Log '@C,0', @C
	SET @D = str(@ProdYear,2)
	SET @D = replace(@D, ' ', '0')
execute Add2Log '@D,1', @D
	SET @B = ''+@D +''+ @C
	SET              @C =
		                          (SELECT     MAX(eshterakId) AS Expr1
		                             FROM         dbo.moshtarak
		                             WHERE     (eshterakId LIKE @B + '%') and ({ fn LENGTH(eshterakId) } = 10))
execute Add2Log '@C,1', @C
	 IF ((@C IS NULL) or  (len(@C) < 10)) BEGIN
		SET              @C = @B + '000000' 
	END
	SET              @A = @C
	SET              @B = str(@A) 
	SET              @A = @A + 1
	SET              @B = str(@A) 
execute Add2Log '@B,0', @B

end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateRelationJozeatKasri    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateRelationJozeatKasri
	@Id char(19),

	@kasriEmdadId char(19),
	@qateId char(19)

as
begin
	set xact_abort on
	 IF (@kasriEmdadId = '' ) BEGIN
		set @kasriEmdadId = null
	END
	 IF (@qateId = '' ) BEGIN
		set @qateId = null
	END

	begin tran

	update jozeatKasri  set  
		kasriEmdadId = @kasriEmdadId  ,
		qateId = @qateId
	where id=@Id

	commit tran
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  Stored Procedure dbo.UpdateRelationJozeatKhedmat    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE procedure UpdateRelationJozeatKhedmat
	@Id char(19),

	@emdadId char(19),
	@ojratId char(19),
	@qateId char(19),
	@iradId char(19)

as
begin
	set xact_abort on
	--execute Add2Log 'UpdateRelationMoshtarak,0', @Id
	begin tran
	 IF (@ojratId = '' ) BEGIN
		set @ojratId = null
	END
	 IF (@qateId = '' ) BEGIN
		set @qateId = null
	END
	 IF (@iradId = '' ) BEGIN
		set @iradId = null
	END

	update JozeatKhedmat  set  
		khedmatId = @emdadId ,
		ojratId = @ojratId ,
		qateId = @qateId ,
		iradId = @iradId
	where id=@Id
	commit tran
	--execute Add2Log 'UpdateRelationMoshtarak,1', @Id
end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  User Defined Function dbo.BazaryabName    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE FUNCTION  BazaryabName(
	@bazaryabKey varchar(20),
	@noeBazaryabId varchar(20))
RETURNS
	nvarchar(40)
	--@bazaryabName char(18) 
as
begin


	declare 	
		@bazaryabName nvarchar(40) ,
		@bazaryabKind int,
		@bazaryabTable	varchar(20)

SET @bazaryabKind = (select entity  from noeBazaryab where id=@noeBazaryabId)

--execute Add2Log 'NewSubscription,0', @bazaryabKind

set @bazaryabName = CASE @bazaryabKind
         WHEN 1 THEN  
		  (SELECT   name FROM emdadgar WHERE id=@bazaryabKey)
         WHEN 3 THEN 
		 (SELECT   name FROM khodrosaz WHERE id=@bazaryabKey)
         WHEN 4 THEN 
		 (SELECT   name FROM daftarOstani WHERE id=@bazaryabKey)
         WHEN 5 THEN 
		 (SELECT   name FROM namayandegi WHERE id=@bazaryabKey)
         WHEN 2 THEN 
		 (SELECT   name FROM bazaryabMotefareghe WHERE id=@bazaryabKey)
         WHEN 7 THEN 
		 (SELECT   name FROM bazaryabMotefareghe WHERE id=@bazaryabKey)
         WHEN 6 THEN 
		 (SELECT   name FROM bazaryabMotefareghe WHERE id=@bazaryabKey)
         ELSE 'Not yet categorized'
      END

RETURN @bazaryabName

end
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS OFF 
GO

/****** Object:  User Defined Function dbo.NewEshterakId    Script Date: 2004/05/29 10:19:47 ق.ظ ******/
CREATE FUNCTION  NewEshterakId(
	@noeKhodroId varchar(20),
	@ProdYear smallint)
RETURNS
	varchar(20)
as
begin
	
	declare
		@khodrosazId varchar(20),
		@B varchar(20),
		@C varchar(20),
		@A bigint

	set @ProdYear = @ProdYear  % 100

	set @khodrosazId = (select khodrosazId from noeKhodro where id = @noeKhodroId)
	set @khodrosazId = (select khodrosazId from khodrosaz where id = @khodrosazId)
	set @C = @khodrosazId --str(@khodrosazId)
--execute Add2Log 'NewSubscription,0', @C
	if (len(@C)<2)
		set @C = '0' + @C
	SET @B = str(@ProdYear, 2) + @C
	SET              @C =
		                          (SELECT     MAX(eshterakId) AS Expr1
		                             FROM         dbo.moshtarak
		                             WHERE     (eshterakId LIKE @B + '%') and ({ fn LENGTH(eshterakId) } = 10))
	 IF ((@C IS NULL) or  (len(@C) < 10)) BEGIN
		SET              @C = @B + '000000' 
	END
	SET              @A = @C
	SET              @B = str(@A) 
	SET              @A = @A + 1
	SET              @B = str(@A) 

RETURN @B

end






GO

SET QUOTED_IDENTIFIER OFF 
GO
SET ANSI_NULLS ON 
GO

