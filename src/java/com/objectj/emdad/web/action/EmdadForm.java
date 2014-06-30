package com.objectj.emdad.web.action;

import com.objectj.emdad.ejb.EmdadModel;
import com.objectj.emdad.ejb.UserAccessEntity;
import com.objectj.emdad.ejb.UserSession;
import com.objectj.emdad.ejb.util.HejriUtil;
import com.objectj.emdad.ejb.util.Util;
import com.objectj.emdad.proxy.EmdadSessionUtil;
import com.objectj.emdad.proxy.EntityProxy;
import com.objectj.emdad.web.util.Validators;
import com.objectj.jsa.proxy.ProxyException;
import com.objectj.jsa.web.Exchanger;
import com.objectj.jsa.web.action.BaseForm;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public final class EmdadForm extends BaseForm {

    private boolean zamanEzamValid;

    private boolean zamanVagheiEzamValid;

    private boolean zamanShoroValid;

    private boolean zamanVagheiShoroValid;

    private boolean zamanPayanValid;

    private boolean zamanVagheiPayanValid;

    protected EntityProxy getProxy() throws ProxyException {
        try {
            return EmdadSessionUtil.getLocalHome().create();
        } catch ( Exception e ) {
            throw new ProxyException( e );
        }
    }

    protected String getEntityIdName() {
        return "";
    }

    protected String getValueObjectClassName() {
        return "com.objectj.emdad.ejb.EmdadModel";
    }


    protected void prefixSpecificValidations( ActionMapping mapping, HttpServletRequest request ) {
        zamanEzamValid = HejriUtil.isValidDate( (String) ( get( "zamanEzam" ) ) );
        if ( zamanEzamValid ) {
            set( "zamanEzam", HejriUtil.hejriToChrisStr( (String) get( "zamanEzam" ) ) );
        }

        zamanVagheiEzamValid = HejriUtil.isValidDate( (String) ( get( "zamanVagheiEzam" ) ) );
        if ( zamanVagheiEzamValid ) {
            set( "zamanVagheiEzam", HejriUtil.hejriToChrisStr( (String) get( "zamanVagheiEzam" ) ) );
        }

        zamanShoroValid = HejriUtil.isValidDate( (String) ( get( "zamanShoro" ) ) );
        if ( zamanShoroValid ) {
            set( "zamanShoro", HejriUtil.hejriToChrisStr( (String) get( "zamanShoro" ) ) );
        }

        zamanVagheiShoroValid = HejriUtil.isValidDate( (String) ( get( "zamanVagheiShoro" ) ) );
        if ( zamanVagheiShoroValid ) {
            set( "zamanVagheiShoro", HejriUtil.hejriToChrisStr( (String) get( "zamanVagheiShoro" ) ) );
        }

        zamanPayanValid = HejriUtil.isValidDate( (String) ( get( "zamanPayan" ) ) );
        if ( zamanPayanValid ) {
            set( "zamanPayan", HejriUtil.hejriToChrisStr( (String) get( "zamanPayan" ) ) );
        }

        zamanVagheiPayanValid = HejriUtil.isValidDate( (String) ( get( "zamanVagheiPayan" ) ) );
        if ( zamanVagheiPayanValid ) {
            set( "zamanVagheiPayan", HejriUtil.hejriToChrisStr( (String) get( "zamanVagheiPayan" ) ) );
        }
    }

    protected void checkForSpecificValidations( Connection c, ActionErrors errors ) throws Exception {
        boolean isBalini = ( (Integer) get( "noeEmdad" ) ).intValue() == 1;
        String at = (String) get( "action_type" );
        if ( at == null ) {
            at = "";
        }

        if ( at.indexOf( "create" ) >= 0 ) {
            String taeedCreate = (String) get( "taeedCreate" );
            //log.info( "Taeed Create " + taeedCreate );
            if ( Util.isEmpty( taeedCreate ) || isBalini ) {
                String emdadIdAlaki = Validators.rokhdadAlreadyServiced( c, (String) get( "rokhdadId" ), errors );
            }

            set( "taeedCreate", "true" );

            java.sql.Timestamp ts = (java.sql.Timestamp) UserAccessEntity.objectQuery( "select zamaneVaghei from rokhdad where id='" + get( "rokhdadId" ) + "'", "zamaneVaghei", c );

            if ( zamanEzamValid ) {

                if ( HejriUtil.convertToTimesatmp( (String) get( "zamanEzam" ), (String) get( "zamanEzam2" ) ).compareTo( ts ) < 0 ) {

                    errors.add( "a", new ActionError( "emdad.ezamtime.before.rokhdad" ) );
                }
            } else {
                errors.add( "", new ActionError( "emdad.zamanEzam.invalid" ) );
            }
        }

        if ( at.indexOf( "Shoro" ) >= 0 ) {
            if ( zamanEzamValid ) {
                if ( zamanShoroValid ) {
                    if ( HejriUtil.convertToTimesatmp( (String) get( "zamanEzam" ), (String) get( "zamanEzam2" ) ).compareTo( HejriUtil.convertToTimesatmp( (String) get( "zamanShoro" ), (String) get( "zamanShoro2" ) ) ) > 0 ) {
                        errors.add( "a", new ActionError( "emdad.shoro.before.ezam" ) );
                    }
                } else {
                    errors.add( "", new ActionError( "emdad.zamanShoro.invalid" ) );
                }
            } else {
                errors.add( "", new ActionError( "emdad.zamanEzam.invalid" ) );
            }
        }

        if ( at.indexOf( "Payan" ) >= 0 ) {
            if ( zamanShoroValid ) {
                if ( zamanPayanValid ) {
                    if ( HejriUtil.convertToTimesatmp( (String) get( "zamanShoro" ), (String) get( "zamanShoro2" ) ).compareTo( HejriUtil.convertToTimesatmp( (String) get( "zamanPayan" ), (String) get( "zamanPayan2" ) ) ) > 0 ) {
                        errors.add( "a", new ActionError( "emdad.payan.before.shoro" ) );
                    }
                    if ( ( (Integer) get( "guarantee" ) ).intValue() == 1 &&
                            ( (Integer) get( "kilometerKarkard" ) ).intValue() < 1 ) {
                        errors.add( "a", new ActionError( "emdad.payan.kilometerKarkard.notZero" ) );
                    }
                } else {
                    errors.add( "", new ActionError( "emdad.zamanPayan.invalid" ) );
                }
            } else {
                errors.add( "", new ActionError( "emdad.zamanShoro.invalid" ) );
            }

            System.out.println( get( "kilometerKarkard" ).toString() + "***" + get( "kilometerKarkardGhabli" ).toString() );
            if ( Integer.parseInt( get( "kilometerKarkard" ).toString() ) < Integer.parseInt( get( "kilometerKarkardGhabli" ).toString() ) ) {
                errors.add( "a", new ActionError( "emdad.payan.kilometerKarkard.isless", get( "kilometerKarkardGhabli" ) ) );
            }
        }
        if ( !Validators.chackValidateZaman( (String) get( "zamanEzam2" ) ) ) {
            errors.add( "", new ActionError( "emdad.zamanEzam.invalid" ) );
        }

        if ( !Validators.chackValidateZaman( (String) get( "zamanShoro2" ) ) ) {
            errors.add( "", new ActionError( "emdad.zamanShoro.invalid" ) );
        }

        if ( !Validators.chackValidateZaman( (String) get( "zamanPayan2" ) ) ) {
            errors.add( "", new ActionError( "emdad.zamanPayan.invalid" ) );
        }


        String oldEmdadgarId = (String) get( "emdadgarIdGhabli" );
        String newEmdadgarId = (String) get( "emdadgarId" );

        String oldNamayandegiId = (String) get( "namayandegiIdGhabli" );
        String newNamayandegiId = (String) get( "namayandegiId" );

        if ( Util.isEmpty( newEmdadgarId ) && Util.isEmpty( newNamayandegiId ) ) {
            errors.add( "required", new ActionError( "emdad.exactlyOne.emdadgarOrNamayandegi" ) );
        }
        if ( Util.isNotEmpty( newEmdadgarId ) && Util.isNotEmpty( newNamayandegiId ) ) {
            errors.add( "atMostOne", new ActionError( "emdad.exactlyOne.emdadgarOrNamayandegi" ) );
        }

        if ( Util.isNotEmpty( newEmdadgarId ) ) {
            if ( Util.isEmpty( oldEmdadgarId ) || !oldEmdadgarId.equals( newEmdadgarId ) ) {
                String[] rls = UserAccessEntity.stringQuerys( "select HadaksarKar,KarDarDast from emdadgar where id='" + newEmdadgarId + "'", "HadaksarKar,KarDarDast" );
                if ( Util.isNotEmpty( rls[ 0 ] ) && Util.isNotEmpty( rls[ 1 ] ) ) {
                    int hk = Integer.parseInt( rls[ 0 ] );
                    int kd = Integer.parseInt( rls[ 1 ] );
                    if ( hk != -1 ) {
                        if ( kd >= hk ) {
                            errors.add( "busy", new ActionError( "emdad.emdadgar.busy" ) );
                        }
                    }
                }
            }
        } else if ( Util.isNotEmpty( newNamayandegiId ) ) {
            if ( Util.isEmpty( oldNamayandegiId ) || !oldNamayandegiId.equals( newNamayandegiId ) ) {
                String[] rls = UserAccessEntity.stringQuerys( "select HadaksarKar,KarDarDast from namayandegi where id='" + newEmdadgarId + "'", "HadaksarKar,KarDarDast" );
                if ( Util.isNotEmpty( rls[ 0 ] ) && Util.isNotEmpty( rls[ 1 ] ) ) {
                    int hk = Integer.parseInt( rls[ 0 ] );
                    int kd = Integer.parseInt( rls[ 1 ] );
                    if ( hk != -1 ) {
                        if ( kd >= hk ) {
                            errors.add( "busy", new ActionError( "emdad.namayandegi.busy" ) );
                        }
                    }
                }
            }
        }

        EmdadModel vo = new EmdadModel();
        Exchanger.exhangeFormToValueObject( this, vo );
        Validators.emdadValidator( c, vo, errors );

    }


    protected void postfixSpecificValidations( ActionErrors errors, HttpServletRequest request ) {
        //=-= System.out.println("ACTION_TYPE = " + get(com.objectj.jsa.web.action.BaseAction.ACTION_TYPE));
        if ( errors.size() == 0 ) {
            if ( ( (String) get( com.objectj.jsa.web.action.BaseAction.ACTION_TYPE ) ).indexOf( "specific,shoro" ) >= 0 ) {
                set( com.objectj.jsa.web.action.BaseAction.ACTION_TYPE, "specific,taeedShoro" );
            }
            if ( ( (String) get( com.objectj.jsa.web.action.BaseAction.ACTION_TYPE ) ).indexOf( "specific,payan" ) >= 0 ) {
                set( com.objectj.jsa.web.action.BaseAction.ACTION_TYPE, "specific,taeedPayan" );
            }
        }
    }

    public boolean isDatabaseSQL() {
        return UserSession.isISDatabaseSQL();
    }
}

