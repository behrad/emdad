package com.objectj.emdad.ejb;

import com.objectj.emdad.ejb.util.BaseEJB;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.jsa.proxy.ProxyReferenceException;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author Ramtin Khosravi
 * @ejb.bean name="Emdad"
 * type="CMP"
 * primkey-field="id"
 * view-type="both"
 * jndi-name="ejb/emdad/Emdad"
 * local-jndi-name="ejb/emdad/EmdadLocal"
 * schema="Emdad"
 * cmp-version="2.x"
 * reentrant="True"
 * @ejb.util generate="physical"
 * @ejb.value-object name="Emdad"
 * extends="com.objectj.jsa.model.BaseValueObject"
 * match="*"
 * @ejb.value-object name="EmdadLight"
 * extends="com.objectj.jsa.model.BaseValueObject"
 * match="light"
 * @ejb.pk class="String"
 * @ejb:finder signature="java.util.Collection findAll()"
 * @jboss.load-group load-group-name="list"
 * field-name="emdadId"
 * field-name="name"
 * @jboss.read-ahead strategy = "on-find"
 * page-size = "20"
 * @jboss.method-attributes pattern = "get*"
 * read-only = "true"
 * @ jboss.container-configuration
 * container-name = "Standard CMP 2.x EntityBean"
 * commit-option = "D"
 * @ejb.finder signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 * query = ""
 * @jboss.query signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 * dynamic = "true"
 * eager-load-group = "list"
 * @ejb.finder signature="java.util.Collection findByEntityId(java.lang.Integer emdadId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Emdad AS o WHERE o.emdadId = ?1"
 */

public abstract class EmdadEJB extends BaseEJB implements EntityBean {

    protected EntityContext ctx;

    /**
     * @ejb.create-method
     */
    public String ejbCreate() throws CreateException {
        return super.ejbCreate();
    }

    /**
     * @ejb.create-method
     */
    public String ejbCreate(EmdadModel emdadModel) throws CreateException {
        try {
            if ((emdadModel.getId() == null) || (emdadModel.getId().length() == 0) || emdadModel.getId().equals("0")) {
                emdadModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(emdadModel.getId());
            setZamanVagheiEzam(emdadModel.getZamanVagheiEzam());
            setZamanShoro(emdadModel.getZamanShoro());
            setRahAndazi(emdadModel.getRahAndazi());
            setElateService(emdadModel.getElateService());
            setKilometerKarkard(emdadModel.getKilometerKarkard());
            setZamanVagheiShoro(emdadModel.getZamanVagheiShoro());
            setHododeHazinehKol(emdadModel.getHododeHazinehKol());
            setZamanPayan(emdadModel.getZamanPayan());
            setFaseleAzNamayandegi(emdadModel.getFaseleAzNamayandegi());
            setAkharinTagheerDahandeh(emdadModel.getAkharinTagheerDahandeh());
            setZamanVagheiPayan(emdadModel.getZamanVagheiPayan());
            setZamanEzam(emdadModel.getZamanEzam());
            setMablaghPardakhtShodeh(emdadModel.getMablaghPardakhtShodeh());
            setVazeatKonuni(emdadModel.getVazeatKonuni());
            setHazinehAyyabZahab(emdadModel.getHazinehAyyabZahab());
            setNoeEmdad(emdadModel.getNoeEmdad());
            setHazinehJarsaghil(emdadModel.getHazinehJarsaghil());
            setHazinehBoxel(emdadModel.getHazinehBoxel());
            setModatTamir(emdadModel.getModatTamir());
            setTozihat(emdadModel.getTozihat());
            setVazeatDakheli(emdadModel.getVazeatDakheli());
            setDastoorKarGhabli(emdadModel.getDastoorKarGhabli());
            setMaliDone(emdadModel.getMaliDone());
            setShomarehFactor(emdadModel.getShomarehFactor());
            setNoeKhedmateVije(emdadModel.getNoeKhedmateVije());
            setKoliyehMadarek(emdadModel.getKoliyehMadarek());
            setEllateBargashteGuarantee(emdadModel.getEllateBargashteGuarantee());
            setNoeEmdadgarId(emdadModel.getNoeEmdadgarId());
        } catch (Exception exception) {
            log.error(exception);
            throw new EJBException(exception.toString());
        }
        // EJB 2.0 spec says return null for CMP ejbCreate methods
        return null;
    }

    /**
     * Holds value of property userId.
     */
    private String id;


    /**
     * Getter for property id.
     *
     * @return Value of property id.
     * @ejb.pk-field
     * @ejb.value-object match="light"
     * @ejb.persistence
     * @ejb.interface-method
     */
    public abstract String getId();

    public abstract void setId(String id);



    /////////////////////////////
    // Relationships starts here

    /**
     * @ejb.interface-method view-type="local"
     * @ejb.relation name="Namayandegi-Emdad-Relation"
     * role-name="emdad-has-namayandegi"
     * target-ejb = "Namayandegi"
     * target-role-name = "namayandegi-might-have-some-emdad"
     * target-multiple = "yes"
     * multiple = "no"
     * @jboss.relation fk-constraint="true"
     * fk-column="namayandegiId"
     * related-pk-field="id"
     * @jboss.relation-read-ahead strategy = "on-find"
     * page-size = "20"
     * eager-load-group = "*"
     */
    public abstract NamayandegiLocal getNamayandegi();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setNamayandegi(NamayandegiLocal namayandegiLocal);

    // end of relationship declaration
    //////////////////////////////////




    /////////////////////////////
    // Relationships starts here

    /**
     * @ejb.interface-method view-type="local"
     * @ejb.relation name="Rokhdad-Emdad-Relation"
     * role-name="emdad-has-rokhdad"
     * target-ejb = "Rokhdad"
     * target-role-name = "rokhdad-might-have-some-emdad"
     * target-multiple = "yes"
     * multiple = "no"
     * @jboss.relation fk-constraint="true"
     * fk-column="rokhdadId"
     * related-pk-field="id"
     * @jboss.relation-read-ahead strategy = "on-find"
     * page-size = "20"
     * eager-load-group = "*"
     */
    public abstract RokhdadLocal getRokhdad();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setRokhdad(RokhdadLocal rokhdadLocal);

    // end of relationship declaration
    //////////////////////////////////


    /////////////////////////////
    // Relationships starts here

    /**
     * @ejb.interface-method view-type="local"
     * @ejb.relation name="VazeatKhedmat-Emdad-Relation"
     * role-name="emdad-has-vazeatKhedmat"
     * target-ejb = "VazeatKhedmat"
     * target-role-name = "vazeatKhedmat-might-have-some-emdad"
     * target-multiple = "yes"
     * multiple = "no"
     * @jboss.relation fk-constraint="true"
     * fk-column="vazeatKhedmatId"
     * related-pk-field="id"
     * @jboss.relation-read-ahead strategy = "on-find"
     * page-size = "20"
     * eager-load-group = "*"
     */
    public abstract VazeatKhedmatLocal getVazeatKhedmat();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setVazeatKhedmat(VazeatKhedmatLocal vazeatKhedmatLocal);

    // end of relationship declaration
    //////////////////////////////////

    /////////////////////////////
    // Relationships starts here

    /**
     * @ejb.interface-method view-type="local"
     * @ejb.relation name="Emdadgar-Emdad-Relation"
     * role-name="emdad-has-emdadgar"
     * target-ejb = "Emdadgar"
     * target-role-name = "emdadgar-might-have-some-emdad"
     * target-multiple = "yes"
     * multiple = "no"
     * @jboss.relation fk-constraint="true"
     * fk-column="emdadgarId"
     * related-pk-field="id"
     * @jboss.relation-read-ahead strategy = "on-find"
     * page-size = "20"
     * eager-load-group = "*"
     */
    public abstract EmdadgarLocal getEmdadgar();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setEmdadgar(EmdadgarLocal emdadgarLocal);

    // end of relationship declaration
    //////////////////////////////////


    /////////////////////////////
    // Relationships starts here

    /**
     * @ejb.interface-method view-type="local"
     * @ejb.relation name="Ezamger-Emdad-Relation"
     * role-name="emdad-has-ezamgar"
     * target-ejb = "Shakhs"
     * target-role-name = "ezamgar-might-have-some-emdad"
     * target-multiple = "yes"
     * multiple = "no"
     * @jboss.relation fk-constraint="true"
     * fk-column="ezamgarId"
     * related-pk-field="id"
     * @jboss.relation-read-ahead strategy = "on-find"
     * page-size = "20"
     * eager-load-group = "*"
     */
    public abstract ShakhsLocal getEzamgar();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setEzamgar(ShakhsLocal shakhsLocal);

    // end of relationship declaration
    //////////////////////////////////




    /////////////////////////////
    // Relationships starts here

    /**
     * @ejb.interface-method view-type="local"
     * @ejb.relation name="DalileToolKeshidaneEmdad-Emdad-Relation"
     * role-name="emdad-has-dalileToolKeshidaneEmdad"
     * target-ejb = "DalileToolKeshidaneEmdad"
     * target-role-name = "dalileToolKeshidaneEmdad-might-have-some-emdad"
     * target-multiple = "yes"
     * multiple = "no"
     * @jboss.relation fk-constraint="true"
     * fk-column="dalileToolKeshidaneEmdadId"
     * related-pk-field="id"
     * @jboss.relation-read-ahead strategy = "on-find"
     * page-size = "20"
     * eager-load-group = "*"
     */
    public abstract DalileToolKeshidaneEmdadLocal getDalileToolKeshidaneEmdad();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setDalileToolKeshidaneEmdad(DalileToolKeshidaneEmdadLocal dalileToolKeshidaneEmdadLocal);

    // end of relationship declaration
    //////////////////////////////////

    /**
     * Holds value of property userId.
     */
    private java.sql.Timestamp zamanVagheiEzam;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getZamanVagheiEzam();

    public abstract void setZamanVagheiEzam(java.sql.Timestamp zamanVagheiEzam);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer vazeatKonuni;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getVazeatKonuni();

    public abstract void setVazeatKonuni(java.lang.Integer vazeatKonuni);


    /**
     * Holds value of property userId.
     */
    private java.sql.Timestamp zamanShoro;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getZamanShoro();

    public abstract void setZamanShoro(java.sql.Timestamp zamanShoro);

    /**
     * Holds value of property userId.
     */
    private java.lang.String noeEmdadgarId;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getNoeEmdadgarId();

    public abstract void setNoeEmdadgarId(java.lang.String noeEmdadgarId);


    /**
     * Holds value of property userId.
     */
    private java.lang.String rahAndazi;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getRahAndazi();

    public abstract void setRahAndazi(java.lang.String rahAndazi);


    /**
     * Holds value of property userId.
     */
    private java.lang.String elateService;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getElateService();

    public abstract void setElateService(java.lang.String elateService);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer hazinehAyyabZahab;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHazinehAyyabZahab();

    public abstract void setHazinehAyyabZahab(java.lang.Integer hazinehAyyabZahab);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer emdadId;

    /**
     * @ejb.persistent-field
     * @jboss.persistence read-only = "true"
     */

    public abstract java.lang.Integer getEmdadId();

    public abstract void setEmdadId(java.lang.Integer emdadId);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer KilometerKarkard;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getKilometerKarkard();

    public abstract void setKilometerKarkard(java.lang.Integer kilometerKarkard);


    /**
     * Holds value of property userId.
     */
    private java.sql.Timestamp zamanVagheiShoro;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getZamanVagheiShoro();

    public abstract void setZamanVagheiShoro(java.sql.Timestamp zamanVagheiShoro);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer hododeHazinehKol;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHododeHazinehKol();

    public abstract void setHododeHazinehKol(java.lang.Integer hododeHazinehKol);


    /**
     * Holds value of property userId.
     */
    private java.sql.Timestamp zamanPayan;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getZamanPayan();

    public abstract void setZamanPayan(java.sql.Timestamp zamanPayan);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer faseleAzNamayandegi;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getFaseleAzNamayandegi();

    public abstract void setFaseleAzNamayandegi(java.lang.Integer faseleAzNamayandegi);


    /**
     * Holds value of property userId.
     */
    private java.lang.String akharinTagheerDahandeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getAkharinTagheerDahandeh();

    public abstract void setAkharinTagheerDahandeh(java.lang.String akharinTagheerDahandeh);


    /**
     * Holds value of property userId.
     */
    private java.sql.Timestamp zamanVagheiPayan;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getZamanVagheiPayan();

    public abstract void setZamanVagheiPayan(java.sql.Timestamp zamanVagheiPayan);


    /**
     * Holds value of property userId.
     */
    private java.sql.Timestamp zamanEzam;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getZamanEzam();

    public abstract void setZamanEzam(java.sql.Timestamp zamanEzam);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer mablaghPardakhtShodeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMablaghPardakhtShodeh();

    public abstract void setMablaghPardakhtShodeh(java.lang.Integer mablaghPardakhtShodeh);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer noeEmdad;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getNoeEmdad();

    public abstract void setNoeEmdad(java.lang.Integer noeEmdad);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer hazinehJarsaghil;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHazinehJarsaghil();

    public abstract void setHazinehJarsaghil(java.lang.Integer hazinehJarsaghil);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer hazinehBoxel;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHazinehBoxel();

    public abstract void setHazinehBoxel(java.lang.Integer hazinehBoxel);

    /**
     * Holds value of property userId.
     */
    private java.lang.Integer modatTamir;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getModatTamir();

    public abstract void setModatTamir(java.lang.Integer modatTamir);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer vazeatDakheli;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getVazeatDakheli();

    public abstract void setVazeatDakheli(java.lang.Integer vazeatDakheli);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer dastoorKarGhabli;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getDastoorKarGhabli();

    public abstract void setDastoorKarGhabli(java.lang.Integer dastoorKarGhabli);


    /**
     * Holds value of property userId.
     */
    private java.lang.Integer maliDone;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMaliDone();

    public abstract void setMaliDone(java.lang.Integer maliDone);


    /**
     * Holds value of property userId.
     */
    private java.lang.String tozihat;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getTozihat();

    public abstract void setTozihat(java.lang.String tozihat);

    /**
     * Holds value of property userId.
     */
    private java.lang.String shomarehFactor;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getShomarehFactor();

    public abstract void setShomarehFactor(java.lang.String shomarehFactor);

    /**
     * Holds value of property taeedNamayandegi.
     */
    private java.lang.Integer taeedNamayandegi;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedNamayandegi();

    public abstract void setTaeedNamayandegi(java.lang.Integer taeedNamayandegi);

    /**
     * Holds value of property taeedGuarantee.
     */
    private java.lang.Integer taeedGuarantee;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedGuarantee();

    public abstract void setTaeedGuarantee(java.lang.Integer taeedGuarantee);

    /**
     * Holds value of property taeedHesabdar.
     */
    private java.lang.Integer taeedHesabdar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getTaeedHesabdar();

    public abstract void setTaeedHesabdar(java.lang.Integer taeedHesabdar);

    /**
     * Holds value of property userId.
     */
    private java.lang.Integer noeKhedmateVije;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getNoeKhedmateVije();

    public abstract void setNoeKhedmateVije(java.lang.Integer noeKhedmateVije);

    /**
     * Holds value of property userId.
     */
    private java.lang.Integer koliyehMadarek;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getKoliyehMadarek();

    public abstract void setKoliyehMadarek(java.lang.Integer koliyehMadarek);

    /**
     * Holds value of property userId.
     */
    private java.lang.String ellateBargashteGuarantee;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getEllateBargashteGuarantee();

    public abstract void setEllateBargashteGuarantee(java.lang.String ellateBargashteGuarantee);

    protected String getTable() {
        return "Emdad";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }

    /**
     * @ejb.interface-method
     */
    public abstract EmdadModel getEmdadModel();

    /**
     * @ejb.interface-method
     */
    public abstract void setEmdadModel(EmdadModel model);

    /**
     * @ejb.interface-method
     */
    public void setEmdadModel1(com.objectj.emdad.ejb.EmdadModel valueHolder) {
        try {
            setAkharinTagheerDahandeh(valueHolder.getAkharinTagheerDahandeh());
            setFaseleAzNamayandegi(valueHolder.getFaseleAzNamayandegi());
            setHododeHazinehKol(valueHolder.getHododeHazinehKol());
            setKilometerKarkard(valueHolder.getKilometerKarkard());
            setMablaghPardakhtShodeh(valueHolder.getMablaghPardakhtShodeh());
            setVazeatKonuni(valueHolder.getVazeatKonuni());
            setZamanEzam(valueHolder.getZamanEzam());
            setZamanPayan(valueHolder.getZamanPayan());
            setZamanShoro(valueHolder.getZamanShoro());
            setRahAndazi(valueHolder.getRahAndazi());
            setElateService(valueHolder.getElateService());
            setZamanVagheiEzam(valueHolder.getZamanVagheiEzam());
            setZamanVagheiPayan(valueHolder.getZamanVagheiPayan());
            setZamanVagheiShoro(valueHolder.getZamanVagheiShoro());
            setHazinehAyyabZahab(valueHolder.getHazinehAyyabZahab());
            setNoeEmdad(valueHolder.getNoeEmdad());
            setHazinehJarsaghil(valueHolder.getHazinehJarsaghil());
            setHazinehBoxel(valueHolder.getHazinehBoxel());
            setModatTamir(valueHolder.getModatTamir());
            setTozihat(valueHolder.getTozihat());
            setVazeatDakheli(valueHolder.getVazeatDakheli());
            setMaliDone(valueHolder.getMaliDone());
            setDastoorKarGhabli(valueHolder.getDastoorKarGhabli());
            setShomarehFactor(valueHolder.getShomarehFactor());
            setNoeKhedmateVije(valueHolder.getNoeKhedmateVije());
            setKoliyehMadarek(valueHolder.getKoliyehMadarek());
            setTaeedGuarantee(valueHolder.getTaeedGuarantee());
            setTaeedHesabdar(valueHolder.getTaeedHesabdar());
            setTaeedNamayandegi(valueHolder.getTaeedNamayandegi());
            setEllateBargashteGuarantee(valueHolder.getEllateBargashteGuarantee());
        } catch (Exception e) {
            throw new javax.ejb.EJBException(e);
        }
    }

    public void ejbActivate() throws EJBException, RemoteException {
    }

    public void ejbLoad() throws EJBException, RemoteException {
    }

    public void ejbPassivate() throws EJBException, RemoteException {
    }

    public void ejbRemove() throws RemoveException, EJBException, RemoteException {
    }

    public void ejbStore() throws EJBException, RemoteException {
    }

    public void setEntityContext(EntityContext entityContext) throws EJBException, RemoteException {
        this.ctx = entityContext;
    }

    public void unsetEntityContext() throws EJBException, RemoteException {
        this.ctx = null;
    }


    /**
     * @ejb.interface-method
     */
    public void myRemove() throws SQLException, ProxyReferenceException {
        String Id = getId();
        super.myRemove(Id);
    }


    /**
     * @ejb.home-method
     */
    public ResultSet ejbHomeAdvanceRead(Connection connection, QueryObject queryObject) throws FinderException {
        return super.ejbHomeAdvanceRead(connection, queryObject);
    }


    protected java.util.Collection dynaQuery(String query) {
        Object[] args = {};
        Collection mycollection;

        try {
            EmdadLocalHome myHome = (EmdadLocalHome) ctx.getEJBLocalHome();
            mycollection = myHome.findGeneric(query, args);
            return mycollection;
        } catch (Exception exception) {
            log.error(exception);
        }
        return null;

    }

//    protected String getJoinStatement() {
    //      return "emdad.rokhdadId = rokhdad.Id AND emdad.ezamgarId = shakhs.Id AND emdad.emdadgarId = emdadgar.Id AND emdad.vazeatKhedmatId=vazeatKhedmat.id";
    //}

}
