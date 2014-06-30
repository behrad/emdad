/**
 * Created by IntelliJ IDEA.
 * User: raheleh
 * Date: May 31, 2003
 * Time: 11:04:52 AM
 * To change this template use Options | File Templates.
 */
package com.objectj.emdad.ejb;

public class DarkhastEshterakList extends com.objectj.emdad.ejb.DarkhastEshterakModel{

    private String id;
    private Integer noeService;
    private String nameKhanevadegi;
    private String  nameMoshtarak;
    private java.sql.Date tarikhTavalod;
    private String  addressMoshtarak;
    private  String codePost;
    private String emailMoshtarak;
    private String telMoshtarak;
    private String mobileMoshtarak;
    private Integer saleSakht;
    private String shomarePelak;
    private String shomareMotor;
    private String shomareShasi;
    private Integer garantee;
    private java.sql.Date tarikhEnghezaGarantee;
    private Integer nahvePardakht;
    private String shomareFish;
    private java.sql.Date tarikhFish;
    private String nameShobe;
    private Integer hazineh;
    private String noeServiceName;

    private String noeKhodroId;
    private String noeKhodroOnvan;
    private String rangeKhodroId;
    private String rangeKhodroOnvan;
    private String shahrId;
    private String shahrName;



    public String getNoeServiceName() {
        return noeServiceName;
    }

    public void setNoeServiceName(String noeServiceName) {
        this.noeServiceName = noeServiceName;
    }
    /*============================================================*/
    public Integer getNoeService(){
        return this.noeService;
    }
    public void setNoeService(Integer noeService){
        this.noeService = noeService;
    }
    /*============================================================*/
    public String getNameKhanevadegi(){
        return nameKhanevadegi;
    }
    public void setNameKhanevadegi(String nameKhanevadegi){
        this.nameKhanevadegi = nameKhanevadegi;
    }
    /*============================================================*/
    public String  getNameMoshtarak(){
        return this.nameMoshtarak;
    }
    public void setNameMoshtarak(String nameMoshtarak){
        this.nameMoshtarak = nameMoshtarak;
    }
    /*============================================================*/
    public java.sql.Date getTarikhTavalod(){
        return this.tarikhTavalod;
    }
    public void setTarikhTavalod(java.sql.Date tarikhTavalod){
        this.tarikhTavalod = tarikhTavalod;
    }
    /*============================================================*/
    public String  getAddressMoshtarak(){
        return this.addressMoshtarak;
    }
    public void setAddressMoshtarak(String addressMoshtarak){
        this.addressMoshtarak = addressMoshtarak;
    }
    /*============================================================*/
    public  String getCodePost(){
        return this.codePost;
    }
    public void setCodePost(String codePost){
        this.codePost = codePost;
    }
    /*============================================================*/
    public String getEmailMoshtarak(){
        return this.emailMoshtarak;
    }
    public void setEmailMoshtarak(String emailMoshtarak){
        this.emailMoshtarak = emailMoshtarak;
    }
    /*============================================================*/
    public String getTelMoshtarak(){
        return this.telMoshtarak;
    }
    public void setTelMoshtarak(String telMoshtarak){
        this.telMoshtarak = telMoshtarak;
    }
    /*============================================================*/
    public String getMobileMoshtarak(){
        return this.mobileMoshtarak;
    }
    public void setMobileMoshtarak(String mobileMoshtarak){
        this.mobileMoshtarak = mobileMoshtarak;
    }
    /*============================================================*/
    public Integer getSaleSakht(){
        return this.saleSakht;
    }
    public void setSaleSakht(Integer saleSakht){
        this.saleSakht = saleSakht;
    }
    /*============================================================*/
    public String getShomarePelak(){
        return this.shomarePelak;
    }
    public void setShomarePelak(String shomarePelak){
        this.shomarePelak = shomarePelak;
    }
    /*============================================================*/
    public String getShomareMotor(){
        return this.shomareMotor;
    }
    public void setShomareMotor(String shomareMotor){
        this.shomareMotor = shomareMotor;
    }
    /*============================================================*/
    public String getShomareShasi(){
        return this.shomareShasi;
    }
    public void setShomareShasi(String shomareShasi){
        this.shomareShasi = shomareShasi;
    }
    /*============================================================*/
    public Integer getGarantee(){
        return this.garantee;
    }
    public void setGarantee(Integer garantee){
        this.garantee = garantee;
    }
    /*============================================================*/
    public java.sql.Date getTarikhEnghezaGarantee(){
        return this.tarikhEnghezaGarantee;
    }
    public void setTarikhEnghezaGarantee(java.sql.Date tarikhEnghezaGarantee){
        this.tarikhEnghezaGarantee = tarikhEnghezaGarantee;
    }
    /*============================================================*/
    public Integer getNahvePardakht(){
        return this.nahvePardakht;
    }
    public void setNahvePardakht(Integer nahvePardakht){
        this.nahvePardakht = nahvePardakht;
    }
    /*============================================================*/
    public String getShomareFish(){
        return this.shomareFish;
    }
    public void setShomareFish(String shomareFish){
        this.shomareFish = shomareFish;
    }
    /*============================================================*/
    public java.sql.Date getTarikhFish(){
        return this.tarikhFish;
    }
    public void setTarikhFish(java.sql.Date tarikhFish){
        this.tarikhFish = tarikhFish;
    }
    /*============================================================*/
    public String getNameShobe(){
        return this.nameShobe;
    }
    public void setNameShobe(String nameShobe){
        this.nameShobe = nameShobe;
    }
    /*============================================================*/
    public Integer getHazineh(){
        return this.hazineh;
    }
    public void setHazineh(Integer hazineh){
        this.hazineh = hazineh;
    }
    /*============================================================*/


    public String getNoeKhodroOnvan() {
        return this.noeKhodroOnvan;
    }
    public void setNoeKhodroOnvan(String noeKhodroId) {
        this.noeKhodroOnvan = noeKhodroId;
    }
    /*============================================================*/
    public String getShahrName() {
        return this.shahrName;
    }
    public void setShahrName(String shahrId) {
        this.shahrName = shahrId;
    }
    /*============================================================*/
    public String getRangeKhodroOnvan() {
        return this.rangeKhodroOnvan;
    }
    public void setRangeKhodroOnvan(String rangeKhodroId) {
        this.rangeKhodroOnvan = rangeKhodroId;
    }

    /*============================================================*/
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    /*============================================================*/
    public String getNoeKhodroId() {
        return noeKhodroId;
    }
    public void setNoeKhodroId(String noeKhodroId) {
        this.noeKhodroId =  noeKhodroId;
    }
    /*============================================================*/
    public String getShahrId() {
        return shahrId;
    }
    public void setShahrId(String shahrId) {
        this.shahrId = shahrId;
    }
    /*============================================================*/
    public String getRangeKhodroId() {
        return rangeKhodroId;
    }
    public void setRangeKhodroId(String rangeKhodroId) {
        this.rangeKhodroId = rangeKhodroId;
    }
    /*============================================================*/
}
