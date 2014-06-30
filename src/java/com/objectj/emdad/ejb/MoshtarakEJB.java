package com.objectj.emdad.ejb;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

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
 *      name="Moshtarak"
 *      type="CMP"
 *      primkey-field="id"
 *      view-type="both"
 *      jndi-name="ejb/emdad/Moshtarak"
 *      local-jndi-name="ejb/emdad/MoshtarakLocal"
 *      schema="Moshtarak"
 *      cmp-version="2.x"
 *
 * @ejb.util
 *  generate="physical"
 *
 * @ejb.value-object
 *      name="Moshtarak"
 *      extends="com.objectj.jsa.model.BaseValueObject"
 *      match="*"
 *
 * @ejb.value-object
 *      name="MoshtarakLight"
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
 * 	    field-name="moshtarakId"
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
 */

public abstract class MoshtarakEJB extends BaseEJB implements EntityBean {

	private final String tabel = "Moshtarak";
	protected EntityContext ctx;

	/**
	 * @ejb.create-method
	 */
	public String ejbCreate() throws CreateException {
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
	public String ejbCreate(MoshtarakModel moshtarakModel) throws CreateException {
		try {
			if ((moshtarakModel.getId() == null) || (moshtarakModel.getId().length() == 0))
				moshtarakModel.setId(com.objectj.emdad.ejb.util.Util.generateGUID(this));
			setId(moshtarakModel.getId());

			// copy from model
			setShomareMotor(moshtarakModel.getShomareMotor());
			setNameKhanevadegi(moshtarakModel.getNameKhanevadegi());
			setMobile(moshtarakModel.getMobile());
			setAddress(moshtarakModel.getAddress());
			setMahaleServiceAvalieh(moshtarakModel.getMahaleServiceAvalieh());
			setPostCode(moshtarakModel.getPostCode());
			setTel(moshtarakModel.getTel());
			setNoeEshterak(moshtarakModel.getNoeEshterak());
			setTarikhAkharinEmail(moshtarakModel.getTarikhAkharinEmail());
			setGuarantee(moshtarakModel.getGuarantee());
			setShomarePelak(moshtarakModel.getShomarePelak());
			setShomareVIN(moshtarakModel.getShomareVIN());
			setTarikhShoro(moshtarakModel.getTarikhShoro());
			setTarikhTavalod(moshtarakModel.getTarikhTavalod());
			setTarikhServiceAvalieh(moshtarakModel.getTarikhServiceAvalieh());
			setEshterakId(moshtarakModel.getEshterakId());
			setEmail(moshtarakModel.getEmail());
			setTarikhTahvil(moshtarakModel.getTarikhTahvil());
			setShomareShasi(moshtarakModel.getShomareShasi());
			setNoeService(moshtarakModel.getNoeService());
			setTarikhEnghezaGuarantee(moshtarakModel.getTarikhEnghezaGuarantee());
			setTarikhEngheza(moshtarakModel.getTarikhEngheza());
			setTarikhAkharinTamdid(moshtarakModel.getTarikhAkharinTamdid());
			setSaleSakht(moshtarakModel.getSaleSakht());
			setVazeat(moshtarakModel.getVazeat());
            setName(moshtarakModel.getName());
            setHazinehPardakhtShodeh(moshtarakModel.getHazinehPardakhtShodeh());
            setNamayandegi(moshtarakModel.getNamayandegi());
           // //=-= System.out.println("%%%%%%%%%%%%%%%%%%%%%% moshtarakYaNa = " + moshtarakModel.getMoshtarakYaNa());
            setMoshtarakYaNa(moshtarakModel.getMoshtarakYaNa());
            setTarikhIjad(com.objectj.emdad.ejb.util.HejriUtil.getCurrentDate());
            setMajaziYaNa(moshtarakModel.getMajaziYaNa());

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

	/*********************************   NoeKhodro Relationships *************************************/

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="NoeKhodro-Moshtarak-Relation"
	 *    role-name="moshtarak-has-noeKhodro"
	 *    target-ejb = "NoeKhodro"
	 *	  target-role-name="noeKhodro-might-have-some-moshtarak"
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
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract NoeKhodroLocal getNoeKhodro();

	/**
	 * @ejb.interface-method view-type="local"
	 */
	public abstract void setNoeKhodro(NoeKhodroLocal noeKhodroLocal);

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
	 *    name="Shahr-Moshtarak-Relation"
	 *    role-name="moshtarak-has-shahr"
	 *    target-ejb = "Shahr"
	 *	  target-role-name="shahr-might-have-some-moshtarak"
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

	/*********************************   RangeKhodro  Relationships *************************************/

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="RangeKhodro-Moshtarak-Relation"
	 *    role-name="moshtarak-has-rangeKhodro"
	 *    target-ejb = "RangeKhodro"
	 *	  target-role-name="rangeKhodro-might-have-some-moshtarak"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="rangeKhodroId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract RangeKhodroLocal getRangeKhodro();

	/**
	 * @ejb.interface-method view-type="local"
	 */
	public abstract void setRangeKhodro(RangeKhodroLocal rangeKhodroLocal);

	// end of relationship declaration
	//////////////////////////////////

	/*********************************   Bazaryab Relationships *************************************/

	/////////////////////////////
	// Relationships starts here

	/**
	 *
	 * @ejb.interface-method view-type="local"
	 *
	 * @ejb.relation
	 *    name="Bazaryab-Moshtarak-Relation"
	 *    role-name="moshtarak-has-bazaryab"
	 *    target-ejb = "Bazaryab"
	 *	  target-role-name="bazaryab-might-have-some-moshtarak"
	 *    target-multiple = "yes"
	 * 	  multiple = "no"
	 *
	 * @jboss.relation-mapping style="foreign-key"
	 *
	 * @jboss.relation
	 *    fk-constraint="true"
	 *    fk-column="bazaryabId"
	 *    related-pk-field="id"
	 *
	 * @jboss.relation-read-ahead
	 *    strategy = "on-find"
	 * 	  page-size = "20"
	 * 	  eager-load-group = "*"
	 */
	public abstract BazaryabLocal getBazaryab();

	/**
	 * @ejb.interface-method view-type="local"
	 */
	public abstract void setBazaryab(BazaryabLocal bazaryabLocal);

	// end of relationship declaration
	//////////////////////////////////

	/** Holds value of property userId. */
	private java.lang.String shomareMotor;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomareMotor();

	public abstract void setShomareMotor(java.lang.String shomareMotor);

	/** Holds value of property userId. */
	private java.lang.String nameKhanevadegi;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getNameKhanevadegi();

	public abstract void setNameKhanevadegi(java.lang.String nameKhanevadegi);

	/** Holds value of property userId. */
	private java.lang.String mobile;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getMobile();

	public abstract void setMobile(java.lang.String mobile);

	/** Holds value of property userId. */
	private java.lang.String address;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getAddress();

	public abstract void setAddress(java.lang.String address);

	/** Holds value of property userId. */
	private java.lang.String mahaleServiceAvalieh;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getMahaleServiceAvalieh();

	public abstract void setMahaleServiceAvalieh(java.lang.String mahaleServiceAvalieh);

	/** Holds value of property userId. */
	private java.lang.String postCode;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getPostCode();

	public abstract void setPostCode(java.lang.String postCode);


    /** Holds value of property userId. */
    private java.lang.Integer moshtarakYaNa;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMoshtarakYaNa();

    public abstract void setMoshtarakYaNa(java.lang.Integer moshtarakYaNa);


    /** Holds value of property userId. */
    private java.lang.Integer majaziYaNa;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getMajaziYaNa();

    public abstract void setMajaziYaNa(java.lang.Integer majaziYaNa);


	/** Holds value of property userId. */
	private java.lang.String tel;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getTel();

	public abstract void setTel(java.lang.String tel);

	/** Holds value of property userId. */
	private java.lang.Integer noeEshterak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNoeEshterak();

	public abstract void setNoeEshterak(java.lang.Integer noeEshterak);

	/** Holds value of property userId. */
	private java.sql.Date tarikhAkharinEmail;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhAkharinEmail();

	public abstract void setTarikhAkharinEmail(java.sql.Date tarikhAkharinEmail);

    /** Holds value of property userId. */
    private java.sql.Date tarikhIjad;

    /**
     * @ejb.persistent-field
     */
    public abstract java.sql.Date getTarikhIjad();

    public abstract void setTarikhIjad(java.sql.Date tarikhIjad);

	/** Holds value of property userId. */
	private java.lang.Integer guarantee;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getGuarantee();

	public abstract void setGuarantee(java.lang.Integer guarantee);

	/** Holds value of property userId. */
	private java.lang.String shomarePelak;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomarePelak();

	public abstract void setShomarePelak(java.lang.String shomarePelak);

	/** Holds value of property userId. */
	private java.lang.String shomareVIN;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomareVIN();

	public abstract void setShomareVIN(java.lang.String shomareVIN);

	/** Holds value of property userId. */
	private java.sql.Date tarikhShoro;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhShoro();

	public abstract void setTarikhShoro(java.sql.Date tarikhShoro);

	/** Holds value of property userId. */
	private java.sql.Date tarikhTavalod;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhTavalod();

	public abstract void setTarikhTavalod(java.sql.Date tarikhTavalod);

	/** Holds value of property userId. */
	private java.sql.Date tarikhServiceAvalieh;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhServiceAvalieh();

	public abstract void setTarikhServiceAvalieh(java.sql.Date tarikhServiceAvalieh);

	/** Holds value of property userId. */
	private java.lang.String eshterakId;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getEshterakId();

	public abstract void setEshterakId(java.lang.String eshterakId);

	/** Holds value of property userId. */
	private java.lang.String email;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getEmail();

	public abstract void setEmail(java.lang.String email);

	/** Holds value of property userId. */
	private java.sql.Date tarikhTahvil;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhTahvil();

	public abstract void setTarikhTahvil(java.sql.Date tarikhTahvil);

	/** Holds value of property userId. */
	private java.lang.String shomareShasi;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getShomareShasi();

	public abstract void setShomareShasi(java.lang.String shomareShasi);

	/** Holds value of property userId. */
	private java.lang.Integer noeService;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getNoeService();

	public abstract void setNoeService(java.lang.Integer noeService);

	/** Holds value of property userId. */
	private java.sql.Date tarikhEnghezaGuarantee;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhEnghezaGuarantee();

	public abstract void setTarikhEnghezaGuarantee(java.sql.Date tarikhEnghezaGuarantee);

	/** Holds value of property userId. */
	private java.sql.Date tarikhEngheza;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhEngheza();

	public abstract void setTarikhEngheza(java.sql.Date tarikhEngheza);

	/** Holds value of property userId. */
	private java.sql.Date tarikhAkharinTamdid;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.sql.Date getTarikhAkharinTamdid();

	public abstract void setTarikhAkharinTamdid(java.sql.Date tarikhAkharinTamdid);

	/** Holds value of property userId. */
	private java.lang.Integer saleSakht;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getSaleSakht();

	public abstract void setSaleSakht(java.lang.Integer saleSakht);

	/** Holds value of property userId. */
	private java.lang.Integer vazeat;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.Integer getVazeat();

	public abstract void setVazeat(java.lang.Integer vazeat);

	/** Holds value of property userId. */
	private java.lang.String name;

	/**
	 * @ejb.persistent-field
	 */
	public abstract java.lang.String getName();

	public abstract void setName(java.lang.String name);


    private java.lang.Integer hazinehPardakhtShodeh;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getHazinehPardakhtShodeh();

    public abstract void setHazinehPardakhtShodeh(java.lang.Integer hazinehPardakhtShodeh);

    private java.lang.Integer namayandegi;

    /**
     * @ejb.persistent-field
     */
    public abstract java.lang.Integer getNamayandegi();

    public abstract void setNamayandegi(java.lang.Integer namayandegi);

    /** Holds value of property userId. */
        private java.lang.Integer takhfif;

        /**
         * @ejb.persistent-field
         */
        public abstract java.lang.Integer getTakhfif();

        public abstract void setTakhfif(java.lang.Integer takhfif);


    /** Holds value of property userId. */
        private java.lang.Integer naghd;

        /**
         * @ejb.persistent-field
         */
        public abstract java.lang.Integer getNaghd();

        public abstract void setNaghd(java.lang.Integer naghd);

    /** Holds value of property userId. */
        private java.lang.Integer taahodi;

        /**
         * @ejb.persistent-field
         */
        public abstract java.lang.Integer getTaahodi();

        public abstract void setTaahodi(java.lang.Integer taahodi);

    /** Holds value of property userId. */
        private java.lang.Integer aghsat;

        /**
         * @ejb.persistent-field
         */
        public abstract java.lang.Integer getAghsat();

        public abstract void setAghsat(java.lang.Integer aghsat);

    /** Holds value of property userId. */
        private java.lang.String cheque;

        /**
         * @ejb.persistent-field
         */
        public abstract java.lang.String getCheque();

        public abstract void setCheque(java.lang.String cheque);



	protected String getTable() {
		return "Moshtarak";
	}

	protected EntityContext getEntityContext() {
		return ctx;
	}

	/**
	 * @ejb.interface-method
	 */
	public abstract MoshtarakModel getMoshtarakModel();

	/**
	 * @ejb.interface-method
	 */
	public abstract void setMoshtarakModel(MoshtarakModel model);

	public void ejbActivate() throws EJBException, RemoteException {}

	public void ejbLoad() throws EJBException, RemoteException {}

	public void ejbPassivate() throws EJBException, RemoteException {}

	public void ejbRemove() throws RemoveException, EJBException, RemoteException {}

	public void ejbStore() throws EJBException, RemoteException {}

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

	protected String getJoinStatement() {
		return "moshtarak.shahrId = shahr.Id AND moshtarak.noeKhodroId = noeKhodro.Id AND moshtarak.rangeKhodroId = rangeKhodro.Id AND moshtarak.bazaryabId = bazaryab.Id";
	}

}
