/**
 * DatesVoyages.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.gtm.bovoyages.service;

public class DatesVoyages  implements java.io.Serializable {
    private java.util.Calendar dateDepart;

    private java.util.Calendar dateRetour;

    private int deleted;

    private long fkDestination;

    private long id;

    private int nbPlaces;

    private float prixHT;

    private int promotion;

    public DatesVoyages() {
    }

    public DatesVoyages(
           java.util.Calendar dateDepart,
           java.util.Calendar dateRetour,
           int deleted,
           long fkDestination,
           long id,
           int nbPlaces,
           float prixHT,
           int promotion) {
           this.dateDepart = dateDepart;
           this.dateRetour = dateRetour;
           this.deleted = deleted;
           this.fkDestination = fkDestination;
           this.id = id;
           this.nbPlaces = nbPlaces;
           this.prixHT = prixHT;
           this.promotion = promotion;
    }


    /**
     * Gets the dateDepart value for this DatesVoyages.
     * 
     * @return dateDepart
     */
    public java.util.Calendar getDateDepart() {
        return dateDepart;
    }


    /**
     * Sets the dateDepart value for this DatesVoyages.
     * 
     * @param dateDepart
     */
    public void setDateDepart(java.util.Calendar dateDepart) {
        this.dateDepart = dateDepart;
    }


    /**
     * Gets the dateRetour value for this DatesVoyages.
     * 
     * @return dateRetour
     */
    public java.util.Calendar getDateRetour() {
        return dateRetour;
    }


    /**
     * Sets the dateRetour value for this DatesVoyages.
     * 
     * @param dateRetour
     */
    public void setDateRetour(java.util.Calendar dateRetour) {
        this.dateRetour = dateRetour;
    }


    /**
     * Gets the deleted value for this DatesVoyages.
     * 
     * @return deleted
     */
    public int getDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this DatesVoyages.
     * 
     * @param deleted
     */
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }


    /**
     * Gets the fkDestination value for this DatesVoyages.
     * 
     * @return fkDestination
     */
    public long getFkDestination() {
        return fkDestination;
    }


    /**
     * Sets the fkDestination value for this DatesVoyages.
     * 
     * @param fkDestination
     */
    public void setFkDestination(long fkDestination) {
        this.fkDestination = fkDestination;
    }


    /**
     * Gets the id value for this DatesVoyages.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this DatesVoyages.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the nbPlaces value for this DatesVoyages.
     * 
     * @return nbPlaces
     */
    public int getNbPlaces() {
        return nbPlaces;
    }


    /**
     * Sets the nbPlaces value for this DatesVoyages.
     * 
     * @param nbPlaces
     */
    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }


    /**
     * Gets the prixHT value for this DatesVoyages.
     * 
     * @return prixHT
     */
    public float getPrixHT() {
        return prixHT;
    }


    /**
     * Sets the prixHT value for this DatesVoyages.
     * 
     * @param prixHT
     */
    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }


    /**
     * Gets the promotion value for this DatesVoyages.
     * 
     * @return promotion
     */
    public int getPromotion() {
        return promotion;
    }


    /**
     * Sets the promotion value for this DatesVoyages.
     * 
     * @param promotion
     */
    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatesVoyages)) return false;
        DatesVoyages other = (DatesVoyages) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dateDepart==null && other.getDateDepart()==null) || 
             (this.dateDepart!=null &&
              this.dateDepart.equals(other.getDateDepart()))) &&
            ((this.dateRetour==null && other.getDateRetour()==null) || 
             (this.dateRetour!=null &&
              this.dateRetour.equals(other.getDateRetour()))) &&
            this.deleted == other.getDeleted() &&
            this.fkDestination == other.getFkDestination() &&
            this.id == other.getId() &&
            this.nbPlaces == other.getNbPlaces() &&
            this.prixHT == other.getPrixHT() &&
            this.promotion == other.getPromotion();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDateDepart() != null) {
            _hashCode += getDateDepart().hashCode();
        }
        if (getDateRetour() != null) {
            _hashCode += getDateRetour().hashCode();
        }
        _hashCode += getDeleted();
        _hashCode += new Long(getFkDestination()).hashCode();
        _hashCode += new Long(getId()).hashCode();
        _hashCode += getNbPlaces();
        _hashCode += new Float(getPrixHT()).hashCode();
        _hashCode += getPromotion();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatesVoyages.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.bovoyages.gtm.fr/", "datesVoyages"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateDepart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateDepart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateRetour");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateRetour"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fkDestination");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fkDestination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nbPlaces");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nbPlaces"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prixHT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prixHT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promotion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "promotion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
