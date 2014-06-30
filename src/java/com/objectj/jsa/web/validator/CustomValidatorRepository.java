package com.objectj.jsa.web.validator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorUtil;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.validator.Resources;


public class CustomValidatorRepository {
    public final static String FIELD_TEST_NULL = "NULL";
    public final static String FIELD_TEST_NOTNULL = "NOTNULL";
    public final static String FIELD_TEST_EQUAL = "EQUAL";
    
    private static Log log = LogFactory.getLog(CustomValidatorRepository.class);
    
    public static String getObjectAsString(Object bean, String propertyName) {
        String strRetObj = null;
        try {
            Object retObj = PropertyUtils.getProperty(bean, propertyName);
            
            boolean foundString = isString(retObj);
            
            if (!foundString) {
                boolean minusOneFound =
                (retObj.toString().substring(0, 2).compareTo("-1") == 0);
                
                if (!minusOneFound) {
                    strRetObj =  retObj.toString();
                }
                
            } else {
                strRetObj = retObj.toString();
            }
            
        } catch (Exception ite) {
            
        } finally {
            return strRetObj;
        }
        
    }
    
    
    
    public static boolean isString(Object o) {
        if (o == null)
            return true;
        return (String.class.isInstance(o));
    }
    
    public static boolean validateIdentical(Object bean, ValidatorAction va, Field field, ActionErrors errors, HttpServletRequest request) {
        
        String value = ValidatorUtil.getValueAsString(bean, field.getProperty());
        String sProperty2 = field.getVarValue("secondField");
        String value2 = ValidatorUtil.getValueAsString(bean, sProperty2);
        
        if (!GenericValidator.isBlankOrNull(value)) {
            try {
                if (!value.equals(value2)) {
                    errors.add(field.getKey(), Resources.getActionError(request, va, field));
                    
                    return false;
                }
            } catch (Exception e) {
                errors.add(field.getKey(), Resources.getActionError(request, va, field));
                return false;
            }
        }
        
        return true;
    }
    
    
    
    public static boolean validateNotIdentical(Object bean, ValidatorAction va, Field field, ActionErrors errors, HttpServletRequest request) {
        String value = ValidatorUtil.getValueAsString(bean, field.getProperty());
        String sProperty2 = field.getVarValue("secondField");
        String value2 = ValidatorUtil.getValueAsString(bean, sProperty2);
        
        if (!GenericValidator.isBlankOrNull(value)) {
            try {
                if (value.equals(value2)) {
                    errors.add(field.getKey(), Resources.getActionError(request, va, field));
                    
                    return false;
                }
            } catch (Exception e) {
                errors.add(field.getKey(), Resources.getActionError(request, va, field));
                return false;
            }
        }
        
        return true;
    }
    
/*
    public static boolean validateCannotIf(
    Object bean,
    Field field,
    ValidatorAction va,
    Validator validator,
    ValidateMessageAdder ae) {
 
        Object form =
        validator.getResource(Validator.BEAN_KEY);
        String value = null;
        // lets start with assuming that none of field[0 .. n] is allowed to have any value when field
        // is present
        boolean isAnded = false;
        boolean isValid = true;
        boolean blankValueSeen = false;
 
        List notAllowedFields = new ArrayList();
 
        if (isString(bean)) {
            value = (String) bean;
            if (!(value.length() > 0)) {
                return true;
            }
        } else {
            value = ValidatorUtil.getValueAsString(bean, field.getProperty());
 
            //if from vo
            if (value == null) {
                return true;
 
            }//if from form
            if (!((value != null) && (value.length() > 0))) {
                return true;
            }
 
        }
        //used to control whether the property is allowed to be present if all field-negate fields are null
        //helpful in defining primary and secondary criteria rules
        boolean cannotBeAlone = false;
 
        //check to see if value can be alone or not.
        if ((!GenericValidator.isBlankOrNull(field.getVarValue("field-cannotBeAlone"))) && (field.getVarValue("field-cannotBeAlone")).equalsIgnoreCase("TRUE")) {
            cannotBeAlone = true;
        }
 
        int i = 0;
        int j = 0;
 
        boolean fieldNegateEmpty = true;
 
        String fieldJoin = "AND";
        String fieldNegateProp = null;
        String fieldNegateVal = null;
 
        if (!GenericValidator.isBlankOrNull(field.getVarValue("field-join"))) {
            fieldJoin = field.getVarValue("field-join");
        }
        //check to see if any field negate is there, if so always return true
        //also keep track of whether all field negate values are empty/null (this matters if cannotBeAlone is true
        while (!GenericValidator
        .isBlankOrNull(field.getVarValue("field-negate[" + j + "]"))) {
            fieldNegateProp = field.getVarValue("field-negate[" + j + "]");
            fieldNegateVal = getObjectAsString(form, fieldNegateProp);
 
            //check to see if it is an empty string (it will be if it comes off a form)
            if (!((fieldNegateVal != null) && (fieldNegateVal.length() > 0))) {
 
                fieldNegateVal = null;
            }
 
            // if field-negate is present along with the field to be looked for, then make isValid true
            // by force
            if (value != null && fieldNegateVal != null) {
                return true;
            }
 
            boolean negateValNotSeen = ( (fieldNegateVal == null) || ( (fieldNegateVal !=null) && (fieldNegateVal.length() == 0) ) );
 
            //keep track of empty/null field negate values
            fieldNegateEmpty = fieldNegateEmpty && ((fieldNegateVal == null) || negateValNotSeen);
 
            j++;
        }
        //after exiting loop test to see if all the field negates were empty
        //this basically works like a "CannotIfNull" validation allowing us to restrict
        //what collection of null fields a property cannot go with if the field-cannotBeAlone property is true
        if (fieldNegateEmpty && cannotBeAlone)  {
            ae.addError(bean, va, field, null);
            return false;
        }
 
        if (fieldJoin.equalsIgnoreCase("AND")) {
            isAnded = true;
        }
        //this loop tests if prohibited fields are present
        while (!GenericValidator
        .isBlankOrNull(field.getVarValue("field[" + i + "]"))) {
 
            String dependProp = field.getVarValue("field[" + i + "]");
            String dependVal = null;
            dependVal = getObjectAsString(form, dependProp);
            //if field not allowed, add to array list
            if ((dependVal != null)
            && (dependVal.length() > 0)) {
                notAllowedFields.add(dependProp);
                isValid = true;
            } else {
                isValid = false;
                blankValueSeen = true;
            }
 
            if (isAnded) {
                isValid = isValid || isAnded;
            } else {
                isValid = isValid && isAnded;
            }
 
            i++;
        }
 
        //always return TRUE if there are no prohibited fields present
        if (notAllowedFields.size() == 0) {
            return true;
        }
 
        // if field cannot be VALID iif all the fields are present, then
        // return FALSE
        if (isValid && isAnded && !blankValueSeen) {
            isValid = false;
        }
 
        if (log.isDebugEnabled())
            log.debug("FINISH");
 
        if (!isValid) {
            ((ArrayList) notAllowedFields).trimToSize();
            Object[] notAllowedFieldsArray = new Object[notAllowedFields.size()];
            notAllowedFields.toArray(notAllowedFieldsArray);
 
            ae.addError(bean, va, field, notAllowedFieldsArray);
 
            return false;
        }
        return true;
    }
 
 
    public static boolean validateMaskIf(
    Object bean,
    Field field,
    ValidatorAction va,
    Validator validator,
    ValidateMessageAdder ae) {
 
        if (log.isDebugEnabled())
            log.debug("START");
 
        Object form =
        validator.getResource(Validator.BEAN_KEY);
 
        String value = null;
        //to determine whether the overall test passes -- default to false in case test is an OR
        boolean testPass = false;
        //to determiine whether mask test passed
        boolean maskPassed = false;
        //get the bean
        if (isString(bean)) {
            value = (String) bean;
        } else {
            value = ValidatorUtil.getValueAsString(bean, field.getProperty());
            if (value == null) {
                value = "";
            }
        }
 
        int i = 0;
        int j = 0;
        //Test to see if a field-join value is sent, default to AND
        String fieldJoin = "AND";
        if (!GenericValidator.isBlankOrNull(field.getVarValue("field-join"))) {
            fieldJoin = field.getVarValue("field-join");
        }
        if (fieldJoin.equalsIgnoreCase("AND")) {
            testPass = true;
        }
        while (!GenericValidator
        .isBlankOrNull(field.getVarValue("field[" + i + "]"))) {
 
            String dependProp = field.getVarValue("field[" + i + "]");
            String dependTest = field.getVarValue("field-test[" + i + "]");
            String dependTestValue = field.getVarValue("field-value[" + i + "]");
 
            String dependVal = null;
            //boolean to determine whether the mask test should be run
            boolean performMaskTest = false;
 
            dependVal = getObjectAsString(form, dependProp);
 
            //Determine what kind of test to perform
            if (dependTest.equals(FIELD_TEST_NULL)) {
                if ((dependVal != null) && (dependVal.length() > 0)) {
                    performMaskTest = false;
                } else {
                    performMaskTest = true;
                }
            }
            if (dependTest.equals(FIELD_TEST_NOTNULL)) {
                if ((dependVal != null) && (dependVal.length() > 0)) {
                    performMaskTest = true;
                } else {
                    performMaskTest = false;
                }
            }
            if (dependTest.equals(FIELD_TEST_EQUAL)) {
                performMaskTest = dependTestValue.equalsIgnoreCase(dependVal);
            }
 
            if (performMaskTest) {
                j ++;
                String mask = field.getVarValue("mask[" + i + "]");
                String maskvalue = field.getVarValue("mask[" + "]");
                if (maskvalue == null) {
                    maskvalue = "";
                }
                try {
                    if (!GenericValidator.matchRegexp(value, mask)) {
 
                        maskPassed = false;
 
                    } else {
 
                        maskPassed = true;
                    }
 
                    if (fieldJoin.equalsIgnoreCase("AND")) {
                        testPass = testPass && maskPassed;
                    } else {
                        testPass = testPass || maskPassed;
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
 
            }
            i++;
 
        }
 
        if (log.isDebugEnabled())
            log.debug("FINISH");
 
        //if no mask tests performed, no mask conditions were present and always return true
        if (j == 0) {
            return true;
        }
        // after the entire field has been looped through check to see whether the test has passed
        if (testPass) {
            return true;
        } else {
            ae.addError(bean, va, field, null);
            return false;
        }
    }
 
    public static boolean validateRequiredIf(
    Object bean,
    Field field,
    ValidatorAction va,
    Validator validator,
    ValidateMessageAdder ae) {
 
        Object form =
        validator.getResource(Validator.BEAN_KEY);
        String value = null;
        boolean required = false;
        if (CustomValidatorRepository.isString(bean)) {
            value = (String) bean;
        } else {
            value = ValidatorUtil.getValueAsString(bean, field.getProperty());
        }
        int i = 0;
        String fieldJoin = "AND";
        if (!GenericValidator.isBlankOrNull(field.getVarValue("field-join"))) {
            fieldJoin = field.getVarValue("field-join");
        }
        if (fieldJoin.equalsIgnoreCase("AND")) {
            required = true;
        }
        while (!GenericValidator
        .isBlankOrNull(field.getVarValue("field[" + i + "]"))) {
            String dependProp = field.getVarValue("field[" + i + "]");
            String dependTest = field.getVarValue("field-test[" + i + "]");
            String dependTestValue = field.getVarValue("field-value[" + i + "]");
            String dependIndexed = field.getVarValue("field-indexed[" + i + "]");
            if (dependIndexed == null)
                dependIndexed = "false";
            String dependVal = null;
            boolean this_required = false;
            if (field.isIndexed() && dependIndexed.equalsIgnoreCase("true")) {
                String key = field.getKey();
                if ((key.indexOf("[") > -1) && (key.indexOf("]") > -1)) {
                    String ind = key.substring(0, key.indexOf(".") + 1);
                    dependProp = ind + dependProp;
                }
            }
            dependVal = getObjectAsString(form, dependProp);
            if (dependTest.equals(CustomValidatorRepository.FIELD_TEST_NULL)) {
                if ((dependVal != null) && (dependVal.length() > 0)) {
                    this_required = false;
                } else {
                    this_required = true;
                }
            }
            if (dependTest.equals(CustomValidatorRepository.FIELD_TEST_NOTNULL)) {
                if ((dependVal != null) && (dependVal.length() > 0)) {
                    this_required = true;
                } else {
                    this_required = false;
                }
            }
            if (dependTest.equals(CustomValidatorRepository.FIELD_TEST_EQUAL)) {
                this_required = dependTestValue.equalsIgnoreCase(dependVal);
            }
            if (fieldJoin.equalsIgnoreCase("AND")) {
                required = required && this_required;
            } else {
                required = required || this_required;
            }
            i++;
        }
        if (required) {
            if ((value != null) && (value.length() > 0)) {
                return true;
            } else {
                //addError(field, va, null, lMsgs);
                ae.addError(bean, va, field, null);
                return false;
            }
        }
        return true;
 
    }
 
    private static ValidateMessageAdder getValidateMessageAdder(List lMsgs) {
        return new ValidateMessageAdderDefaultImpl(lMsgs);
    }
 */
}