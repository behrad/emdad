
package com.objectj.emdad.ejb;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.ejbutils.uid.UIDDispenser;
import org.ejbutils.uid.UIDDispenserException;

import com.objectj.emdad.ejb.util.BaseEJB;
import com.objectj.emdad.proxy.QueryObject;
import com.objectj.jsa.proxy.ProxyReferenceException;

/**
 *
 * @author  Mehdi Amoui
 *
 * @ejb.bean
 *      name="Rokhdad"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Rokhdad"
 *      local-jndi-name="ejb/emdad/RokhdadLocal"
 *      schema="Rokhdad"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Rokhdad"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="RokhdadLight"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="light"
 *
 * @ejb.pk
 *      class="String"
 *
 * @ejb:finder signature="java.util.Collection findAll()"
 *
 *
 *  @jboss.load-group
 *    load-group-name="list"
 * 	    field-name="rokhdadId"
 *      field-name="name"
 *
 *
 *  @jboss.read-ahead
 * 		strategy = "on-find"
 * 		page-size = "20"
 *
 * @jboss.method-attributes
 * 		pattern = "get*"
 * 		read-only = "true"
 *
 * @ejb.finder
 *     signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 *     query = ""
 * @jboss.query
 *     signature = "java.util.Collection findGeneric(java.lang.String s, java.lang.Object[] arguments)"
 *     dynamic = "true"
 * 	   eager-load-group = "list"
 *
 *
 * @ejb.finder
 * signature="java.util.Collection findByEntityId(java.lang.Integer rokhdadId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Rokhdad AS o WHERE o.rokhdadId = ?1"
 *
 *
 */

public abstract class RokhdadEJB extends BaseEJB implements EntityBean {

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
    public String ejbCreate(RokhdadModel rokhdadModel) throws CreateException {
        try {
            if ((rokhdadModel.getId() == null) || (rokhdadModel.getId().length() == 0)) {
                rokhdadModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
            }
            setId(rokhdadModel.getId());

            // copy from model
            setSabetSayar(rokhdadModel.getSabetSayar());
            setMobile(rokhdadModel.getMobile());
            setIrad(rokhdadModel.getIrad());
            setZamaneVaghei(rokhdadModel.getZamaneVaghei());
            setTarikhFaalShodan(rokhdadModel.getTarikhFaalShodan());
            setMantagheh(rokhdadModel.getMantagheh());
            setSabtKonandeh(rokhdadModel.getSabtKonandeh());
            setTel(rokhdadModel.getTel());
            setEghdamShodeh(rokhdadModel.getEghdamShodeh());
            setDastorkarGhabli(rokhdadModel.getDastorkarGhabli());
            setAddress(rokhdadModel.getAddress());
            setAkharinTaghyirDahandeh(rokhdadModel.getAkharinTaghyirDahandeh());
            setKhadamateVijeh(rokhdadModel.getKhadamateVijeh());
            setNoeDarkhastKonandeh(rokhdadModel.getNoeDarkhastKonandeh());
            setKilometerKarkard(rokhdadModel.getKilometerKarkard());
            setKilometerKarkardGhabli(rokhdadModel.getKilometerKarkardGhabli());
            setGuarantee(rokhdadModel.getGuarantee());
            setNoeService(rokhdadModel.getNoeService());
            setMoshtarakYaNa(rokhdadModel.getMoshtarakYaNa());
            //String maxId = UserAccessEntity.stringQuery("select max(rokhdadId) as maxId from rokhdad","maxId");
            //if (maxId == null)
            //    maxId = "0";
            //setRokhdadId(new Integer(Integer.parseInt(maxId) + 1));

        } catch(Exception exception) {
        log.error(exception);
        throw new EJBException(exception.toString());
        }
        // EJB 2.0 spec says return null for CMP ejbCreate methods
        return null;
    }

    /** Holds value of property userId. */
    private String id;


    /** Getter for property id.
     * @return Value of property id.
     *
     * @ejb.pk-field
     * @ejb.value-object match="light"
     * @ejb.persistence
     * @ejb.interface-method
     */
    public abstract String getId();
    public abstract void setId(String id);




    /*********************************   Moshtarak Relationships *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Moshtarak-Rokhdad-Relation"
     *    role-name="rokhdad-has-moshtarak"
     *    target-ejb = "Moshtarak"
     *	  target-role-name="moshtarak-might-have-some-rokhdad"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation-mapping style="foreign-key"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="moshtarakId"
     *    related-pk-field="id"
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract MoshtarakLocal getMoshtarak();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setMoshtarak(MoshtarakLocal moshtarakLocal);

    // end of relationship declaration
    //////////////////////////////////


    /*********************************   Namayandegi Relationships *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Namayandegi-Rokhdad-Relation"
     *    role-name="rokhdad-has-namayandegi"
     *    target-ejb = "Namayandegi"
     *	  target-role-name="namayandegi-might-have-some-rokhdad"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation-mapping style="foreign-key"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="namayandegiId"
     *    related-pk-field="id"
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract NamayandegiLocal getNamayandegi();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setNamayandegi(NamayandegiLocal namayandegiLocal);

    // end of relationship declaration
    //////////////////////////////////


    /*********************************   DaftarOstani  Relationships *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="DaftarOstani-Rokhdad-Relation"
     *    role-name="rokhdad-has-daftarOstani"
     *    target-ejb = "DaftarOstani"
     *	  target-role-name="daftarOstani-might-have-some-rokhdad"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation-mapping style="foreign-key"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="daftarOstaniId"
     *    related-pk-field="id"
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract DaftarOstaniLocal getDaftarOstani();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setDaftarOstani(DaftarOstaniLocal daftarOstaniLocal);

    // end of relationship declaration
    //////////////////////////////////



    /*********************************   Shahr Relationships  *************************************/
    /////////////////////////////
    // Relationships starts here

    /**
     *
     * @ejb.interface-method view-type="local"
     *
     * @ejb.relation
     *    name="Shahr-Rokhdad-Relation"
     *    role-name="rokhdad-has-shahr"
     *    target-ejb = "Shahr"
     *	  target-role-name="shahr-might-have-some-rokhdad"
     *    target-multiple = "yes"
     * 	  multiple = "no"
     *
     * @jboss.relation-mapping style="foreign-key"
     *
     * @jboss.relation
     *    fk-constraint="true"
     *    fk-column="shahrId"
     *    related-pk-field="id"
     *
     * @jboss.relation-read-ahead
     *    strategy = "on-find"
     * 	  page-size = "20"
     * 	  eager-load-group = "*"
     */
    public abstract ShahrLocal getShahr();

    /**
     * @ejb.interface-method view-type="local"
     */
    public abstract void setShahr(ShahrLocal shahrLocal);

    // end of relationship declaration
    //////////////////////////////////


    /** Holds value of property userId. */
    private java.lang.Integer sabetSayar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getSabetSayar();
    public abstract void setSabetSayar(java.lang.Integer sabetSayar);


    /** Holds value of property userId. */
    private java.lang.String mobile;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getMobile();
    public abstract void setMobile(java.lang.String mobile);



    /** Holds value of property userId. */
    private java.lang.String rokhdadId;

    /**
     * @ejb.persistent-field
     *
     * @jboss.persistence
     * read-only = "true"
     *
     */
    public abstract java.lang.Integer getRokhdadId();
    public abstract void setRokhdadId(java.lang.Integer rokhdadId);



    /** Holds value of property userId. */
    private java.lang.String irad;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getIrad();
    public abstract void setIrad(java.lang.String irad);



    /** Holds value of property userId. */
    private java.sql.Timestamp zamaneVaghei;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Timestamp getZamaneVaghei();
    public abstract void setZamaneVaghei(java.sql.Timestamp zamaneVaghei);



    /** Holds value of property userId. */
    private java.lang.Integer mantagheh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMantagheh();
    public abstract void setMantagheh(java.lang.Integer mantagheh);


    /** Holds value of property userId. */
    private java.sql.Date tarikhFaalShodan;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Date getTarikhFaalShodan();
    public abstract void setTarikhFaalShodan(java.sql.Date tarikhFaalShodan);


    /** Holds value of property userId. */
    private java.lang.String sabtKonandeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getSabtKonandeh();
    public abstract void setSabtKonandeh(java.lang.String sabtKonandeh);


    /** Holds value of property userId. */
       private java.lang.Integer kilometerKarkard;

       /**
        * @ejb.persistent-field
        */
       public abstract java.lang.Integer getKilometerKarkard();
       public abstract void setKilometerKarkard(java.lang.Integer kilometerKarkard);


    /** Holds value of property userId. */
       private java.lang.Integer kilometerKarkardGhabli;

       /**
        * @ejb.persistent-field
        */
       public abstract java.lang.Integer getKilometerKarkardGhabli();
       public abstract void setKilometerKarkardGhabli(java.lang.Integer kilometerKarkardGhabli);


    /** Holds value of property userId. */
    private java.lang.String tel;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getTel();
    public abstract void setTel(java.lang.String tel);



    /** Holds value of property userId. */
    private java.lang.Integer eghdamShodeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getEghdamShodeh();
    public abstract void setEghdamShodeh(java.lang.Integer eghdamShodeh);


    /** Holds value of property userId. */
    private java.lang.Integer dastorkarGhabli;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getDastorkarGhabli();
    public abstract void setDastorkarGhabli(java.lang.Integer DastorkarGhabli);


    /** Holds value of property userId. */
    private java.lang.String address;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getAddress();
    public abstract void setAddress(java.lang.String address);



    /** Holds value of property userId. */
    private java.lang.String akharinTaghyirDahandeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getAkharinTaghyirDahandeh();
    public abstract void setAkharinTaghyirDahandeh(java.lang.String akharinTaghyirDahandeh);



    /** Holds value of property userId. */
    private java.lang.Integer khadamateVijeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getKhadamateVijeh();
    public abstract void setKhadamateVijeh(java.lang.Integer khadamateVijeh);



    /** Holds value of property userId. */
    private java.lang.Integer noeDarkhastKonandeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getNoeDarkhastKonandeh();
    public abstract void setNoeDarkhastKonandeh(java.lang.Integer noeDarkhastKonandeh);

    /** Holds value of property userId. */
    private java.lang.Integer guarantee;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getGuarantee();
    public abstract void setGuarantee(java.lang.Integer guarantee);


    /** Holds value of property userId. */
    private java.lang.Integer noeService;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getNoeService();
    public abstract void setNoeService(java.lang.Integer noeService);


    /** Holds value of property userId. */
    private java.lang.Integer moshtarakYaNa;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMoshtarakYaNa();
    public abstract void setMoshtarakYaNa(java.lang.Integer moshtarakYaNa);


    protected String getTable(){
        return "Rokhdad";
    }

    protected EntityContext getEntityContext() {
        return ctx;
    }

    /**
     * @ejb.interface-method
     */
    public abstract RokhdadModel getRokhdadModel();
    /**
     * @ejb.interface-method
     */
    public abstract void setRokhdadModel(RokhdadModel model);

    /**
     * @ejb.interface-method
     */
    public void setRokhdadModel1( com.objectj.emdad.ejb.RokhdadModel valueHolder )
    {

       try
       {
          setSabetSayar(valueHolder.getSabetSayar() );
          setMobile(valueHolder.getMobile() );
          setIrad(valueHolder.getIrad() );
          setZamaneVaghei(valueHolder.getZamaneVaghei() );
          setTarikhFaalShodan(valueHolder.getTarikhFaalShodan());
          setMantagheh(valueHolder.getMantagheh() );
          setSabtKonandeh(valueHolder.getSabtKonandeh() );
          setTel(valueHolder.getTel() );
          setEghdamShodeh(valueHolder.getEghdamShodeh() );
           setDastorkarGhabli(valueHolder.getDastorkarGhabli() );
          setAddress(valueHolder.getAddress() );
          setAkharinTaghyirDahandeh(valueHolder.getAkharinTaghyirDahandeh() );
          setKhadamateVijeh(valueHolder.getKhadamateVijeh() );
          setNoeDarkhastKonandeh(valueHolder.getNoeDarkhastKonandeh());
          setKilometerKarkard(valueHolder.getKilometerKarkard());
       }
       catch (Exception e)
       {
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
    public void myRemove() throws SQLException, ProxyReferenceException{
        String Id = getId();
        super.myRemove(Id);
    }


	protected java.util.Collection dynaQuery(String query) {
		Object[] args = {};
		Collection mycollection;

		try {
			RokhdadLocalHome myHome = (RokhdadLocalHome)ctx.getEJBLocalHome();
			mycollection = myHome.findGeneric(query, args);
			return mycollection;
		} catch (Exception exception) {
			log.error(exception);
		}
		return null;

	}

    protected String getJoinStatement() {
        return "rokhdad.moshtarakId = moshtarak.Id AND rokhdad.daftarOstaniId = daftarOstani.Id AND rokhdad.shahrId = shahr.Id";
    }


    /**
     * @ejb.home-method
     */
    public ResultSet ejbHomeAdvanceRead(Connection connection, QueryObject queryObject) throws FinderException {
        return super.ejbHomeAdvanceRead(connection, queryObject);
    }

/*
    public ResultSet ejbHomeAdvanceRead(QueryObject queryObject) throws FinderException {
        try {
            Connection connection = initConnection();

            //String selectStatement = "SELECT * " + "FROM " + queryObject.getTables() + " ";
            //log.info("Select Fields: " + queryObject.getSelectFields());
            //log.info("is joined: " + queryObject.isJoined());
            log.info ("Join Statement: " + getJoinStatement());
            queryObject.setTables("(rokhdad LEFT JOIN namayandegi on rokhdad.namayandegiId = namayandegi.Id), moshtarak, daftarOstani, shahr");
            String selectStatement = "SELECT " + queryObject.getSelectFields() + " FROM " + queryObject.getTables() + " ";

            if (queryObject.isJoined() && getJoinStatement() != null && getJoinStatement().length() != 0) {
                selectStatement += " WHERE " + "rokhdad.moshtarakId = moshtarak.Id AND rokhdad.daftarOstaniId = daftarOstani.Id AND rokhdad.shahrId = shahr.Id";
                if ((queryObject.getWhere() != null) && (queryObject.getWhere().length() != 0)) {
                    //selectStatement += " AND ";
                    //selectStatement += queryObject.getWhere();
                    //selectStatement += " ";
                }
            }

            if ((queryObject.getOrderField() != null) && (queryObject.getOrderField().length() != 0)) {
                selectStatement += " ORDER BY ";
                if (queryObject.getOrderTable() != null && queryObject.getOrderTable().length() != 0)
                    selectStatement += queryObject.getOrderTable() + ".";
                selectStatement += queryObject.getOrderField();
                selectStatement += " ";
                selectStatement += queryObject.getOrderType();
            }

            log.info (selectStatement);
            PreparedStatement prepStmt = connection.prepareStatement(selectStatement);

            setParameters(queryObject, prepStmt);

            ResultSet resultSet = prepStmt.executeQuery();
            return resultSet;

        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error loading driver: " + cnfe);
        } catch (SQLException sqle) {
            System.err.println("Error connecting: " + sqle);
        }
        return null;
    }
*/
}
