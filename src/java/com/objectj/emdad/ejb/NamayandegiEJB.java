package com.objectj.emdad.ejb;

import com.objectj.emdad.ejb.util.BaseEJB;
import com.objectj.emdad.proxy.QueryObject;

import java.rmi.RemoteException;
import javax.ejb.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import org.apache.log4j.Logger;
import org.ejbutils.uid.UIDDispenser;
import org.ejbutils.uid.UIDDispenserException;
import com.objectj.jsa.proxy.ProxyReferenceException;

/**
 *
 * @author  Ramtin Khosravi
 *
 * @ejb.bean
 *      name="Namayandegi"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Namayandegi"
 *      local-jndi-name="ejb/emdad/NamayandegiLocal"
 *      schema="Namayandegi"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Namayandegi"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="NamayandegiLight"
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
 * 	    field-name="namayandegiId"
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
 * signature="java.util.Collection findByEntityId(java.lang.Integer namayandegiId)"
 * query= "SELECT DISTINCT OBJECT(o) FROM Namayandegi AS o WHERE o.namayandegiId = ?1"
 *
 */

public abstract class NamayandegiEJB extends BaseEJB implements EntityBean, BazaryabTemplate {

	private final String tabel = "Namayandegi";

	protected static Logger log = Logger.getLogger(NamayandegiEJB.class.getName());

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate() throws CreateException {
		// here you should generate the primary key

		try {
			// JSA recommend you to have attribute String id as the primary key for code reuse
			this.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
		} catch (Exception exception) {
			log.error(exception);
			throw new EJBException(exception.toString());
		}

		// EJB 2.0 spec says return null for CMP ejbCreate methods
		return null;
	}

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate(NamayandegiModel namayandegiModel) throws CreateException {
		try {
			if ((namayandegiModel.getId() == null) || (namayandegiModel.getId().length() == 0)) {
				namayandegiModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			}
			setId(namayandegiModel.getId());

			// copy from model
			setNamayandegiTel(namayandegiModel.getNamayandegiTel());
			setOlaviat(namayandegiModel.getOlaviat());
            setSaghfeRiali(namayandegiModel.getSaghfeRiali());
            setHadaksarKar(namayandegiModel.getHadaksarKar());
            setKarDarDast(namayandegiModel.getKarDarDast());
			setShomarehGharardad(namayandegiModel.getShomarehGharardad());
			setVazGharardad(namayandegiModel.getVazGharardad());
			setNamayandegiAddress(namayandegiModel.getNamayandegiAddress());
			setName(namayandegiModel.getName());
			setNazarIsaco(namayandegiModel.getNazarIsaco());
			setSabegheNoroozi(namayandegiModel.getSabegheNoroozi());
			setNamayandegiMobile(namayandegiModel.getNamayandegiMobile());
			setNamayandegiId(namayandegiModel.getNamayandegiId());
			setTarikhGharardad(namayandegiModel.getTarikhGharardad());
			setNamayandegiFax(namayandegiModel.getNamayandegiFax());
			setSabegheFaaliat(namayandegiModel.getSabegheFaaliat());
			setTarikhTahvil(namayandegiModel.getTarikhTahvil());
			setEmdadgar(namayandegiModel.getEmdadgar());
			setTahtePooshesh(namayandegiModel.getTahtePooshesh());
            setTarikhAkharinEstelam(namayandegiModel.getTarikhAkharinEstelam());
            setDastgahEybyab(namayandegiModel.getDastgahEybyab());
            setTelZaroori(namayandegiModel.getTelZaroori());
            setEmail(namayandegiModel.getEmail());
            setNoeNamayandegi(namayandegiModel.getNoeNamayandegi());
            setCodeMantaghe(namayandegiModel.getCodeMantaghe());
            setHadaksarKar2(namayandegiModel.getHadaksarKar2());
            setKarDarDast2(namayandegiModel.getKarDarDast2());
		} catch (Exception exception) {
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

	protected String getTable() {
		return "Namayandegi";
	}

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Shahr-Namayandegi-Relation"
	 *    role-name="namayandegi-has-shahr"
		 *    target-ejb = "Shahr"	
	 *	  target-role-name="shahr-might-have-some-namayandegi"
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
	 * 	  strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */

	public abstract ShahrLocal getShahr();
	/**
	* @ejb.interface-method view-type="local"
	*
	*/
	public abstract void setShahr(ShahrLocal shahrLocal);

	// end of relationship declaration
	//////////////////////////////////

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="NoeKhodro-Namayandegi-Relation"
	 *    role-name="namayandegi-has-noeKhodro"
	 *    target-ejb = "NoeKhodro"	
	 *	  target-role-name="NoeKhodro-might-have-some-namayandegi"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="noeKhodroId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 * 		strategy = "on-find"
	     * 		page-size = "20"
	     * 		eager-load-group = "*"
	 */

	public abstract NoeKhodroLocal getNoeKhodro();
	/**
	* @ejb.interface-method view-type="local"
	*
	*/
	public abstract void setNoeKhodro(NoeKhodroLocal noeKhodroLocal);

	// end of relationship declaration
	//////////////////////////////////

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="DaftarOstani-Namayandegi-Relation"
	 *    role-name="namayandegi-has-daftarOstani"
	 *    target-ejb = "DaftarOstani"
	 *	  target-role-name="daftarOstani-might-have-some-namayandegi"
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
	 * 		strategy = "on-find"
	     * 		page-size = "20"
	     * 		eager-load-group = "*"
	 */

	public abstract DaftarOstaniLocal getDaftarOstani();
	/**
	* @ejb.interface-method view-type="local"
	*
	*/
	public abstract void setDaftarOstani(DaftarOstaniLocal daftarOstaniLocal);

	// end of relationship declaration
	//////////////////////////////////

	/** Holds value of property userId. */
	private java.lang.String namayandegiTel;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNamayandegiTel();
	public abstract void setNamayandegiTel(java.lang.String namayandegiTel);

	/** Holds value of property userId. */
	private java.lang.Integer olaviat;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getOlaviat();
	public abstract void setOlaviat(java.lang.Integer olaviat);

    /** Holds value of property userId. */
    private java.lang.Integer saghfeRiali;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getSaghfeRiali();
    public abstract void setSaghfeRiali(java.lang.Integer saghfeRiali);

    /** Holds value of property userId. */
    private java.lang.Integer hadaksarKar;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHadaksarKar();
    public abstract void setHadaksarKar(java.lang.Integer hadaksarKar);

    /** Holds value of property userId. hadaksarKar tamiri */
    private java.lang.Integer hadaksarKar2;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHadaksarKar2();
    public abstract void setHadaksarKar2(java.lang.Integer hadaksarKar2);

    /** Holds value of property userId. */
    private java.lang.Integer karDarDast;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getKarDarDast();
    public abstract void setKarDarDast(java.lang.Integer karDarDast);

    /** Holds value of property karDarDast2. karDarDast tamiri */
    private java.lang.Integer karDarDast2;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getKarDarDast2();
    public abstract void setKarDarDast2(java.lang.Integer karDarDast2);

	/** Holds value of property userId. */
	private java.lang.String shomarehGharardad;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomarehGharardad();
	public abstract void setShomarehGharardad(java.lang.String shomarehGharardad);

	/** Holds value of property userId. */
	private java.lang.Integer vazGharardad;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getVazGharardad();
	public abstract void setVazGharardad(java.lang.Integer vazGharardad);

	/** Holds value of property userId. */
	private java.lang.String namayandegiAddress;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNamayandegiAddress();
	public abstract void setNamayandegiAddress(java.lang.String namayandegiAddress);

	/** Holds value of property userId. */
	private java.lang.String name;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getName();
	public abstract void setName(java.lang.String name);

	/** Holds value of property userId. */
	private java.lang.Integer nazarIsaco;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNazarIsaco();
	public abstract void setNazarIsaco(java.lang.Integer nazarIsaco);

	/** Holds value of property userId. */
	private java.lang.Integer sabegheNoroozi;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getSabegheNoroozi();
	public abstract void setSabegheNoroozi(java.lang.Integer sabegheNoroozi);

	/** Holds value of property userId. */
	private java.lang.String namayandegiMobile;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNamayandegiMobile();
	public abstract void setNamayandegiMobile(java.lang.String namayandegiMobile);

	/** Holds value of property userId. */
	private java.lang.Integer namayandegiId;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNamayandegiId();
	public abstract void setNamayandegiId(java.lang.Integer namayandegiId);

	/** Holds value of property userId. */
	private java.sql.Date tarikhGharardad;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhGharardad();
	public abstract void setTarikhGharardad(java.sql.Date tarikhGharardad);

	/** Holds value of property userId. */
	private java.lang.String namayandegiFax;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNamayandegiFax();
	public abstract void setNamayandegiFax(java.lang.String namayandegiFax);

	/** Holds value of property userId. */
	private java.lang.Integer sabegheFaaliat;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getSabegheFaaliat();
	public abstract void setSabegheFaaliat(java.lang.Integer sabegheFaaliat);

	/** Holds value of property userId. */
	private java.sql.Date tarikhTahvil;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhTahvil();
	public abstract void setTarikhTahvil(java.sql.Date tarikhTahvil);

	/** Holds value of property userId. */
	private java.lang.String emdadgar;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getEmdadgar();
	public abstract void setEmdadgar(java.lang.String emdadgar);

	/** Holds value of property userId. */
	private java.lang.String tahtePooshesh;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getTahtePooshesh();
	public abstract void setTahtePooshesh(java.lang.String tahtePooshesh);


    /** Holds value of property userId. */
    private java.lang.String email;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getEmail();
    public abstract void setEmail(java.lang.String email);


    /** Holds value of property userId. */
    private java.lang.String telZaroori;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getTelZaroori();
    public abstract void setTelZaroori(java.lang.String telZaroori);

    /** Holds value of property userId. */
    private java.lang.String dastgahEybyab;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.String getDastgahEybyab();
    public abstract void setDastgahEybyab(java.lang.String dastgahEybyab);


    /** Holds value of property userId. */
    private java.sql.Date tarikhAkharinEstelam;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Date getTarikhAkharinEstelam();
    public abstract void setTarikhAkharinEstelam(java.sql.Date tarikhAkharinEstelam);


    /** Holds value of property userId. */
    private java.lang.Integer noeNamayandegi;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getNoeNamayandegi();
    public abstract void setNoeNamayandegi(java.lang.Integer noeNamayandegi);


    /** Holds value of property userId. */
    private java.lang.Integer codeMantaghe;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getCodeMantaghe();
    public abstract void setCodeMantaghe(java.lang.Integer codeMantaghe);


	/**
	 * @ejb.interface-method
	 */
	public abstract NamayandegiModel getNamayandegiModel();
	/**
	 * @ejb.interface-method
	 */

	public abstract void setNamayandegiModel(NamayandegiModel model);

	public void ejbActivate() throws EJBException, RemoteException {}

	public void ejbLoad() throws EJBException, RemoteException {}

	public void ejbPassivate() throws EJBException, RemoteException {}

	public void ejbRemove() throws RemoveException, EJBException, RemoteException {}

	public void ejbStore() throws EJBException, RemoteException {}

	protected EntityContext ctx;

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


//    protected String getJoinTables() {
//        return
//                "namayandegi LEFT OUTER JOIN noeKhodro ON namayandegi.noekhodroId = noeKhodro.Id " +
//                "INNER JOIN Shahr ON Namayandegi.shahrId = Shahr.id " +
//                "INNER JOIN DaftarOstani ON Namayandegi.daftarOstaniId = DaftarOstani.id" ;
//    }

}
