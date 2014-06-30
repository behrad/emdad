package com.objectj.emdad.ejb;



public class MoshtarakList extends com.objectj.emdad.ejb.MoshtarakModel{

    private java.lang.String id;
    private java.lang.String eshterakId;
    private java.lang.Integer noeEshterak;
    private java.lang.String noeEshterakName;
    private java.lang.Integer noeService;
    private java.lang.String noeServiceName;
    private java.lang.Integer vazeat;
    private java.lang.String vazeatName;
    private java.lang.String nameKhanevadegi;
    private java.lang.String name;
    private java.sql.Date tarikhTavalod;
    private java.lang.String address;
    private java.lang.String postCode;
    private java.lang.String shahrId;
    private java.lang.String shahrName;
    private java.lang.String email;
    private java.lang.String tel;
    private java.lang.String mobile;
    private java.lang.String noeKhodroId;
    private java.lang.String noeKhodroOnvan;
    private java.lang.String rangeKhodroId;
    private java.lang.String rangeKhodroOnvan;
    private java.lang.Integer saleSakht;
    private java.lang.String shomarePelak;
    private java.lang.String shomarePelak2;
    private java.lang.String shomareMotor;
    private java.lang.String shomareShasi;
    private java.lang.String shomareVIN;
    private java.sql.Date tarikhShoro;
    private java.sql.Date tarikhAkharinTamdid;
    private java.sql.Date tarikhEngheza;
    private java.sql.Date tarikhTahvil;
    private java.lang.Integer guarantee;
    private java.lang.String guaranteeName;
    private java.sql.Date tarikhEnghezaGuarantee;
    private java.lang.String bazaryabId;
    private java.lang.String bazaryabName;
    private java.sql.Date tarikhServiceAvalieh;
    private java.lang.String mahaleServiceAvalieh;
    private java.sql.Date tarikhAkharinEmail;
    private java.lang.String tarikhEnghezaHejri;
    private java.lang.String tarikhShoroHejri;
    private java.lang.String tarikhAkharinEmailHejri;
	private java.lang.String tarikhTavalodHejri;
    private java.lang.String moshtarakYaNaName;
    private java.lang.String majaziYaNaName;
    private java.lang.Integer hazinehPardakhtShodeh;
    private java.lang.Integer namayandegi;
    private java.lang.Integer takhfif;
    private java.lang.Integer naghd;
    private java.lang.Integer taahodi;
    private java.lang.Integer aghsat;
    private java.lang.String cheque;


    public String getMoshtarakYaNaName() {
        return moshtarakYaNaName;
    }

    public void setMoshtarakYaNaName(String moshtarakYaNaName) {
        this.moshtarakYaNaName = moshtarakYaNaName;
    }

    public String getMajaziYaNaName() {
        return majaziYaNaName;
    }

    public void setMajaziYaNaName(String majaziYaNaName) {
        this.majaziYaNaName = majaziYaNaName;
    }

    public String getTarikhAkharinEmailHejri() {
        return this.tarikhAkharinEmailHejri;
    }

    public void setTarikhAkharinEmailHejri(String tarikhAkharinEmailHejri) {
        this.tarikhAkharinEmailHejri = tarikhAkharinEmailHejri;
    }

    public MoshtarakList() {
    }

    /*============================================================*/
    public void setTarikhEnghezaHejri(String tarikhEngheza){
        this.tarikhEnghezaHejri = tarikhEngheza;
    }

    public String getTarikhEnghezaHejri(){
        return this.tarikhEnghezaHejri;
    }

    /*============================================================*/
    public void setTarikhShoroHejri(String tarikhShoro){
        this.tarikhShoroHejri = tarikhShoro;
    }
    public String getTarikhShoroHejri(){
        return this.tarikhShoroHejri;
    }

    /*============================================================*/
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    /*============================================================*/
    public String getEshterakId() {
        return this.eshterakId;
    }

    public void setEshterakId(String eshterakId) {
        this.eshterakId = eshterakId;
    }

    /*============================================================*/
    public Integer getNoeEshterak() {
        return this.noeEshterak;
    }

    public void setNoeEshterak(Integer noeEshterak) {
        this.noeEshterak = noeEshterak;
    }

    /*============================================================*/
    public String getNoeEshterakName() {
        return this.noeEshterakName;
    }

    public void setNoeEshterakName(String noeEshterakName) {
        this.noeEshterakName = noeEshterakName;
    }

   /*============================================================*/
    public Integer getNoeService() {
        return this.noeService;
    }

    public void setNoeService(Integer noeService) {
        this.noeService = noeService;
    }

    /*============================================================*/
    public String getNoeServiceName() {
        return this.noeServiceName;
    }

    public void setNoeServiceName(String noeServiceName) {
        this.noeServiceName = noeServiceName;
    }

    /*============================================================*/
        public Integer getVazeat() {
        return this.vazeat;
    }

    public void setVazeat(Integer vazeat) {
        this.vazeat = vazeat;
    }

    /*============================================================*/
    public String getVazeatName() {
        return this.vazeatName;
    }

    public void setVazeatName(String vazeatName) {
        this.vazeatName = vazeatName;
    }

    /*============================================================*/
    public String getNameKhanevadegi() {
        return this.nameKhanevadegi;
    }

    public void setNameKhanevadegi(String nameKhanevadegi) {
        this.nameKhanevadegi = nameKhanevadegi;
    }

    /*============================================================*/
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*============================================================*/
    public java.sql.Date getTarikhTavalod() {
        return this.tarikhTavalod;
    }

    public void setTarikhTavalod(java.sql.Date tarikhTavalod) {
        this.tarikhTavalod = tarikhTavalod;
    }

    /*============================================================*/
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    /*============================================================*/

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /*============================================================*/
    public String getShahrId() {
        return this.shahrId;
    }

    public void setShahrId(String shahrId) {
        this.shahrId = shahrId;
    }

    /*============================================================*/
    public String getShahrName() {
        return this.shahrName;
    }

    public void setShahrName(String shahrName) {
        this.shahrName = shahrName;
    }

    /*============================================================*/
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*============================================================*/
    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /*============================================================*/
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /*============================================================*/
    public String getNoeKhodroId() {
        return this.noeKhodroId;
    }

    public void setNoeKhodroId(String noeKhodroId) {
        this.noeKhodroId = noeKhodroId;
    }

    /*============================================================*/
    public String getNoeKhodroOnvan() {
        return this.noeKhodroOnvan;
    }

    public void setNoeKhodroOnvan(String noeKhodroOnvan) {
        this.noeKhodroOnvan = noeKhodroOnvan;
    }

    /*============================================================*/
    public String getRangeKhodroId() {
        return this.rangeKhodroId;
    }

    public void setRangeKhodroId(String rangeKhodroId) {
        this.rangeKhodroId = rangeKhodroId;
    }

    /*============================================================*/
    public String getRangeKhodroOnvan() {
        return this.rangeKhodroOnvan;
    }

    public void setRangeKhodroOnvan(String rangeKhodroOnvan) {
        this.rangeKhodroOnvan = rangeKhodroOnvan;
    }

    /*============================================================*/
    public Integer getSaleSakht() {
        return this.saleSakht;
    }

    public void setSaleSakht(Integer saleSakht) {
        this.saleSakht = saleSakht;
    }

    /*============================================================*/
    public String getShomarePelak() {
        return this.shomarePelak;
    }

    public void setShomarePelak(String shomarePelak) {
        this.shomarePelak = shomarePelak;
    }

    /*============================================================*/
    public String getShomarePelak2() {
        return shomarePelak2;
    }

    public void setShomarePelak2(String shomarePelak2) {
        this.shomarePelak2 = shomarePelak2;
    }

    /*============================================================*/
    public String getShomareMotor() {
        return this.shomareMotor;
    }

    public void setShomareMotor(String shomareMotor) {
        this.shomareMotor = shomareMotor;
    }

    /*============================================================*/
    public String getShomareShasi() {
        return this.shomareShasi;
    }

    public void setShomareShasi(String shomareShasi) {
        this.shomareShasi = shomareShasi;
    }

    /*============================================================*/
    public String getShomareVIN() {
        return this.shomareVIN;
    }

    public void setShomareVIN(String shomareVIN) {
        this.shomareVIN = shomareVIN;
    }

    /*============================================================*/
    public java.sql.Date getTarikhShoro() {
        return this.tarikhShoro;
    }

    public void setTarikhShoro(java.sql.Date tarikhShoro) {
        this.tarikhShoro = tarikhShoro;
    }

    /*============================================================*/
    public java.sql.Date getTarikhAkharinTamdid() {
        return this.tarikhAkharinTamdid;
    }

    public void setTarikhAkharinTamdid(java.sql.Date tarikhAkharinTamdid) {
        this.tarikhAkharinTamdid = tarikhAkharinTamdid;
    }

    /*============================================================*/
    public java.sql.Date getTarikhEngheza() {
        return this.tarikhEngheza;
    }

    public void setTarikhEngheza(java.sql.Date tarikhEngheza) {
        this.tarikhEngheza = tarikhEngheza;
    }

    /*============================================================*/
    public java.sql.Date getTarikhTahvil() {
        return this.tarikhTahvil;
    }

    public void setTarikhTahvil(java.sql.Date tarikhTahvil) {
        this.tarikhTahvil = tarikhTahvil;
    }

    /*============================================================*/
    public Integer getGuarantee() {
        return this.guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    /*============================================================*/
    public java.sql.Date getTarikhEnghezaGuarantee() {
        return this.tarikhEnghezaGuarantee;
    }

    public void setTarikhEnghezaGuarantee(java.sql.Date tarikhEnghezaGuarantee) {
        this.tarikhEnghezaGuarantee = tarikhEnghezaGuarantee;
    }

    /*============================================================*/
    public String getGuaranteeName() {
        return this.guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    /*============================================================*/
    public java.lang.String getBazaryabId() {
        return this.bazaryabId;
    }
    public void setBazaryabId(String bazaryabId) {
        this.bazaryabId = bazaryabId;
    }

    /*============================================================*/
    public String getBazaryabName() {
        return this.bazaryabName;
    }

    public void setBazaryabName(String bazaryabName) {
        this.bazaryabName = bazaryabName;
    }

    /*============================================================*/
    public java.sql.Date getTarikhServiceAvalieh() {
        return this.tarikhServiceAvalieh;
    }

    public void setTarikhServiceAvalieh(java.sql.Date tarikhServiceAvalieh) {
        this.tarikhServiceAvalieh = tarikhServiceAvalieh;
    }

    /*============================================================*/
    public String getMahaleServiceAvalieh() {
        return this.mahaleServiceAvalieh;
    }

    public void setMahaleServiceAvalieh(String mahaleServiceAvalieh) {
        this.mahaleServiceAvalieh = mahaleServiceAvalieh;
    }

    /*============================================================*/
    public java.sql.Date getTarikhAkharinEmail() {
        return this.tarikhAkharinEmail;
    }

    public void setTarikhAkharinEmail(java.sql.Date tarikhAkharinEmail) {
        this.tarikhAkharinEmail = tarikhAkharinEmail;
    }

    /*============================================================*/
	public java.lang.String getTarikhTavalodHejri() {
		return tarikhTavalodHejri;
	}

	public void setTarikhTavalodHejri(java.lang.String string) {
		tarikhTavalodHejri = string;
	}

    /*============================================================*/
    public Integer getHazinehPardakhtShodeh() {
        return this.hazinehPardakhtShodeh;
    }

    public void setHazinehPardakhtShodeh(Integer hazinehPardakhtShodeh) {
        this.hazinehPardakhtShodeh = hazinehPardakhtShodeh;
    }

    /*============================================================*/
    public Integer getNamayandegi() {
        return this.namayandegi;
    }

    public void setNamayandegi(Integer namayandegi) {
        this.namayandegi = namayandegi;
    }

    /*============================================================*/
    public Integer getTakhfif() {
        return this.takhfif;
    }

    public void setTakhfif(Integer takhfif) {
        this.takhfif = takhfif;
    }


    /*============================================================*/
    public Integer getNaghd() {
        return this.naghd;
    }

    public void setNaghd(Integer naghd) {
        this.naghd = naghd;
    }

    /*============================================================*/
    public Integer getTaahodi() {
        return this.taahodi;
    }

    public void setTaahodi(Integer taahodi) {
        this.taahodi = taahodi;
    }


    /*============================================================*/
    public Integer getAghsat() {
        return this.aghsat;
    }

    public void setAghsat(Integer aghsat) {
        this.aghsat = aghsat;
    }


    /*============================================================*/
    public String getCheque() {
        return this.cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }
}
