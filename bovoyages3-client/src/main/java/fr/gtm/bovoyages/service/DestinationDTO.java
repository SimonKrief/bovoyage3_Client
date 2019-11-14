/**
 * DestinationDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.gtm.bovoyages.service;

public class DestinationDTO  implements java.io.Serializable {
    private fr.gtm.bovoyages.service.DatesVoyages[] dates;

    private int deleted;

    private java.lang.String description;

    private long id;

    private fr.gtm.bovoyages.service.Image[] image;

    private java.lang.String region;

    public DestinationDTO() {
    }

    public DestinationDTO(
           fr.gtm.bovoyages.service.DatesVoyages[] dates,
           int deleted,
           java.lang.String description,
           long id,
           fr.gtm.bovoyages.service.Image[] image,
           java.lang.String region) {
           this.dates = dates;
           this.deleted = deleted;
           this.description = description;
           this.id = id;
           this.image = image;
           this.region = region;
    }


    /**
     * Gets the dates value for this DestinationDTO.
     * 
     * @return dates
     */
    public fr.gtm.bovoyages.service.DatesVoyages[] getDates() {
        return dates;
    }


    /**
     * Sets the dates value for this DestinationDTO.
     * 
     * @param dates
     */
    public void setDates(fr.gtm.bovoyages.service.DatesVoyages[] dates) {
        this.dates = dates;
    }

    public fr.gtm.bovoyages.service.DatesVoyages getDates(int i) {
        return this.dates[i];
    }

    public void setDates(int i, fr.gtm.bovoyages.service.DatesVoyages _value) {
        this.dates[i] = _value;
    }


    /**
     * Gets the deleted value for this DestinationDTO.
     * 
     * @return deleted
     */
    public int getDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this DestinationDTO.
     * 
     * @param deleted
     */
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }


    /**
     * Gets the description value for this DestinationDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this DestinationDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the id value for this DestinationDTO.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this DestinationDTO.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the image value for this DestinationDTO.
     * 
     * @return image
     */
    public fr.gtm.bovoyages.service.Image[] getImage() {
        return image;
    }


    /**
     * Sets the image value for this DestinationDTO.
     * 
     * @param image
     */
    public void setImage(fr.gtm.bovoyages.service.Image[] image) {
        this.image = image;
    }

    public fr.gtm.bovoyages.service.Image getImage(int i) {
        return this.image[i];
    }

    public void setImage(int i, fr.gtm.bovoyages.service.Image _value) {
        this.image[i] = _value;
    }


    /**
     * Gets the region value for this DestinationDTO.
     * 
     * @return region
     */
    public java.lang.String getRegion() {
        return region;
    }


    /**
     * Sets the region value for this DestinationDTO.
     * 
     * @param region
     */
    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DestinationDTO)) return false;
        DestinationDTO other = (DestinationDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dates==null && other.getDates()==null) || 
             (this.dates!=null &&
              java.util.Arrays.equals(this.dates, other.getDates()))) &&
            this.deleted == other.getDeleted() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.id == other.getId() &&
            ((this.image==null && other.getImage()==null) || 
             (this.image!=null &&
              java.util.Arrays.equals(this.image, other.getImage()))) &&
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
        if (getDates() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDates());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDates(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getDeleted();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += new Long(getId()).hashCode();
        if (getImage() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImage());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImage(), i);
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
        new org.apache.axis.description.TypeDesc(DestinationDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.bovoyages.gtm.fr/", "destinationDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.bovoyages.gtm.fr/", "datesVoyages"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("image");
        elemField.setXmlName(new javax.xml.namespace.QName("", "image"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.bovoyages.gtm.fr/", "image"));
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
