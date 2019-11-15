/**
 * Voyage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.gtm.bovoyages.service;

public class Voyage  implements java.io.Serializable {
    private java.lang.String descriptif;

    private long fkClient;

    private long fk_dates_voyages;

    private long id;

    private fr.gtm.bovoyages.service.Voyageur[] participants;

    private java.lang.String region;

    public Voyage() {
    }

    public Voyage(
           java.lang.String descriptif,
           long fkClient,
           long fk_dates_voyages,
           long id,
           fr.gtm.bovoyages.service.Voyageur[] participants,
           java.lang.String region) {
           this.descriptif = descriptif;
           this.fkClient = fkClient;
           this.fk_dates_voyages = fk_dates_voyages;
           this.id = id;
           this.participants = participants;
           this.region = region;
    }


    /**
     * Gets the descriptif value for this Voyage.
     * 
     * @return descriptif
     */
    public java.lang.String getDescriptif() {
        return descriptif;
    }


    /**
     * Sets the descriptif value for this Voyage.
     * 
     * @param descriptif
     */
    public void setDescriptif(java.lang.String descriptif) {
        this.descriptif = descriptif;
    }


    /**
     * Gets the fkClient value for this Voyage.
     * 
     * @return fkClient
     */
    public long getFkClient() {
        return fkClient;
    }


    /**
     * Sets the fkClient value for this Voyage.
     * 
     * @param fkClient
     */
    public void setFkClient(long fkClient) {
        this.fkClient = fkClient;
    }


    /**
     * Gets the fk_dates_voyages value for this Voyage.
     * 
     * @return fk_dates_voyages
     */
    public long getFk_dates_voyages() {
        return fk_dates_voyages;
    }


    /**
     * Sets the fk_dates_voyages value for this Voyage.
     * 
     * @param fk_dates_voyages
     */
    public void setFk_dates_voyages(long fk_dates_voyages) {
        this.fk_dates_voyages = fk_dates_voyages;
    }


    /**
     * Gets the id value for this Voyage.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Voyage.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the participants value for this Voyage.
     * 
     * @return participants
     */
    public fr.gtm.bovoyages.service.Voyageur[] getParticipants() {
        return participants;
    }


    /**
     * Sets the participants value for this Voyage.
     * 
     * @param participants
     */
    public void setParticipants(fr.gtm.bovoyages.service.Voyageur[] participants) {
        this.participants = participants;
    }

    public fr.gtm.bovoyages.service.Voyageur getParticipants(int i) {
        return this.participants[i];
    }

    public void setParticipants(int i, fr.gtm.bovoyages.service.Voyageur _value) {
        this.participants[i] = _value;
    }


    /**
     * Gets the region value for this Voyage.
     * 
     * @return region
     */
    public java.lang.String getRegion() {
        return region;
    }


    /**
     * Sets the region value for this Voyage.
     * 
     * @param region
     */
    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Voyage)) return false;
        Voyage other = (Voyage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descriptif==null && other.getDescriptif()==null) || 
             (this.descriptif!=null &&
              this.descriptif.equals(other.getDescriptif()))) &&
            this.fkClient == other.getFkClient() &&
            this.fk_dates_voyages == other.getFk_dates_voyages() &&
            this.id == other.getId() &&
            ((this.participants==null && other.getParticipants()==null) || 
             (this.participants!=null &&
              java.util.Arrays.equals(this.participants, other.getParticipants()))) &&
            ((this.region==null && other.getRegion()==null) || 
             (this.region!=null &&
              this.region.equals(other.getRegion())));
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
        if (getDescriptif() != null) {
            _hashCode += getDescriptif().hashCode();
        }
        _hashCode += new Long(getFkClient()).hashCode();
        _hashCode += new Long(getFk_dates_voyages()).hashCode();
        _hashCode += new Long(getId()).hashCode();
        if (getParticipants() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParticipants());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParticipants(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRegion() != null) {
            _hashCode += getRegion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Voyage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.bovoyages.gtm.fr/", "voyage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descriptif");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descriptif"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fkClient");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fkClient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fk_dates_voyages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fk_dates_voyages"));
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
        elemField.setFieldName("participants");
        elemField.setXmlName(new javax.xml.namespace.QName("", "participants"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.bovoyages.gtm.fr/", "voyageur"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("region");
        elemField.setXmlName(new javax.xml.namespace.QName("", "region"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
