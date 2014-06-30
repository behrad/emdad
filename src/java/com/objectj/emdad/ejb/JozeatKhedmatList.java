package com.objectj.emdad.ejb;

public class JozeatKhedmatList extends JozeatKhedmatModel {

	private java.lang.String id;
	private java.lang.Integer noeKhedmat;
	private java.lang.Integer dastorkar;
	private java.lang.Integer hazineh;
	private java.lang.String ojratIdCode;
	private java.lang.String ojratId;
	private java.lang.String ojratOnvan;
	private java.lang.Integer qateIdCode;
	private java.lang.String qateId;
	private java.lang.String qateName;
	private java.lang.String iradId;
    private java.lang.String iradIdCode;
	private java.lang.String iradOnvan;
	private java.lang.Integer tedadQate;
	private java.lang.Integer guarantee;
	private java.lang.String guaranteeName;
	private java.lang.Integer hazinehDefault;
    private java.lang.String emdadId;
	private java.lang.String taeedHesabdarName;
	private java.lang.String taeedGuaranteeName;
	private java.lang.String taeedNamayandegiName;

	private java.lang.Integer fieldDeleteAccess;
	private java.lang.Integer fieldUpdateAccess;
    private java.lang.String sharhKhedmat;
    private java.lang.String ellateBargashteGuarantee;
    private java.lang.String shomarehFanni;
    //private java.lang.String ojratIdError;
    //private java.lang.String shomarehFanniError;
    //private java.lang.String tedadQateError;

	public JozeatKhedmatList() {}

    /*public java.lang.String getShomarehFanniError() {
            return shomarehFanniError;
    }

    public void setShomarehFanniError(java.lang.String shomarehFanniError) {
        this.shomarehFanniError = shomarehFanniError;
    }

    public java.lang.String getOjratIdError() {
            return ojratIdError;
    }

    public void setOjratIdError(java.lang.String ojratIdError) {
        this.ojratIdError = ojratIdError;
    }

    public java.lang.String getTedadQateError() {
            return tedadQateError;
    }

    public void setTedadQateError(java.lang.String tedadQateError) {
        this.tedadQateError = tedadQateError;
    }*/

    public java.lang.String getEmdadId() {
        return emdadId;
    }

    public void setEmdadId(java.lang.String emdadId) {
        this.emdadId = emdadId;
    }

    public java.lang.String getShomarehFanni() {
        return shomarehFanni;
    }

    public void setShomarehFanni(java.lang.String shomarehFanni) {
        this.shomarehFanni = shomarehFanni;
    }

	/**
	 * @return
	 */
	public java.lang.Integer getDastorkar() {
		return dastorkar;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getGuarantee() {
		return guarantee;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getHazineh() {
		return hazineh;
	}

	/**
	 * @return
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getNoeKhedmat() {
		return noeKhedmat;
	}


	/**
	 * @return
	 */
	public java.lang.String getOjratOnvan() {
		return ojratOnvan;
	}



	/**
	 * @return
	 */
	public java.lang.String getQateName() {
		return qateName;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getTedadQate() {
		return tedadQate;
	}

    /**
     * @return
     */
    public java.lang.Integer getManbaeTahiyeh() {
        return noeKhedmat;
    }

    /**
     * @param integer
     */
    public void setManbaeTahiyeh(java.lang.Integer integer) {
        noeKhedmat = integer;
    }


    /**
     * @return
     */
    public java.lang.Integer getHazineyePardakht() {
        return noeKhedmat;
    }

    /**
     * @param integer
     */
    public void setHazineyePardakht(java.lang.Integer integer) {
        noeKhedmat = integer;
    }


    /**
     * @param integer
     */
	public void setDastorkar(java.lang.Integer integer) {
		dastorkar = integer;
	}

	/**
	 * @param integer
	 */
	public void setGuarantee(java.lang.Integer integer) {
		guarantee = integer;
	}

	/**
	 * @param integer
	 */
	public void setHazineh(java.lang.Integer integer) {
		hazineh = integer;
	}

	/**
	 * @param string
	 */
	public void setId(java.lang.String string) {
		id = string;
	}


	/**
	 * @param integer
	 */
	public void setNoeKhedmat(java.lang.Integer integer) {
		noeKhedmat = integer;
	}


	/**
	 * @param string
	 */
	public void setOjratOnvan(java.lang.String string) {
		ojratOnvan = string;
	}


	/**
	 * @param string
	 */
	public void setQateName(java.lang.String string) {
		qateName = string;
	}

	/**
	 * @param integer
	 */
	public void setTedadQate(java.lang.Integer integer) {
		tedadQate = integer;
	}

	/**
	 * @return
	 */
	public java.lang.String getGuaranteeName() {
		return guaranteeName;
	}

	/**
	 * @param string
	 */
	public void setGuaranteeName(java.lang.String string) {
		guaranteeName = string;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getHazinehDefault() {
		return hazinehDefault;
	}

	/**
	 * @param integer
	 */
	public void setHazinehDefault(java.lang.Integer integer) {
		hazinehDefault = integer;
	}

	/**
	 * @return
	 */
	public java.lang.String getIradId() {
		return iradId;
	}

	/**
	 * @return
	 */
	public java.lang.String getIradOnvan() {
		return iradOnvan;
	}

	/**
	 * @param string
	 */
	public void setIradId(java.lang.String string) {
		iradId = string;
	}

	/**
	 * @param string
	 */
	public void setIradOnvan(java.lang.String string) {
		iradOnvan = string;
	}



	/**
	 * @return
	 */
	public java.lang.String getOjratId() {
		return ojratId;
	}
    /**
	 * @return
	 */
	public java.lang.String getQateId() {
		return qateId;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getQateIdCode() {
		return qateIdCode;
	}

	/**
	 * @param string
	 */
	public void setOjratId(java.lang.String string) {
		ojratId = string;
	}

	/**
	 * @param string
	 */
	public void setQateId(java.lang.String string) {
		qateId = string;
	}

	/**
	 * @param integer
	 */
	public void setQateIdCode(java.lang.Integer integer) {
		qateIdCode = integer;
	}



	/**
	 * @return
	 */
	public java.lang.String getTaeedGuaranteeName() {
		return taeedGuaranteeName;
	}

	/**
	 * @return
	 */
	public java.lang.String getTaeedHesabdarName() {
		return taeedHesabdarName;
	}

	/**
	 * @return
	 */
	public java.lang.String getTaeedNamayandegiName() {
		return taeedNamayandegiName;
	}

	/**
	 * @param string
	 */
	public void setTaeedGuaranteeName(java.lang.String string) {
		taeedGuaranteeName = string;
	}

	/**
	 * @param string
	 */
	public void setTaeedHesabdarName(java.lang.String string) {
		taeedHesabdarName = string;
	}

	/**
	 * @param string
	 */
	public void setTaeedNamayandegiName(java.lang.String string) {
		taeedNamayandegiName = string;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getFieldDeleteAccess() {
		return fieldDeleteAccess;
	}

	/**
	 * @return
	 */
	public java.lang.Integer getFieldUpdateAccess() {
		return fieldUpdateAccess;
	}

	/**
	 * @param integer
	 */
	public void setFieldDeleteAccess(java.lang.Integer integer) {
		fieldDeleteAccess = integer;
	}

	/**
	 * @param integer
	 */
	public void setFieldUpdateAccess(java.lang.Integer integer) {
		fieldUpdateAccess = integer;
	}


    public String getOjratIdCode() {
        return ojratIdCode;
    }

    public void setOjratIdCode(String ojratIdCode) {
        this.ojratIdCode = ojratIdCode;
    }

    public String getIradIdCode() {
        return iradIdCode;
    }

    public void setIradIdCode(String iradIdCode) {
        this.iradIdCode = iradIdCode;
    }

    /**
     * @return
     */
    public java.lang.String getSharhKhedmat() {
        return sharhKhedmat;
    }

    public void setSharhKhedmat(java.lang.String sharhKhedmat) {
        this.sharhKhedmat = sharhKhedmat;
    }

    /**
     * @return
     */
    public java.lang.String getEllateBargashteGuarantee() {
        return ellateBargashteGuarantee;
    }

    public void setEllateBargashteGuarantee(java.lang.String ellateBargashteGuarantee) {
        this.ellateBargashteGuarantee = ellateBargashteGuarantee;
    }

}
