/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Diabetes implements Serializable {
 

private String p01unidad;
private Integer p02jurisdiccion;
private String p03localidad;
private String p04entidadFederativa;
@Id
private Integer p05expediente;
private String p06nombre;
private String p06aPaterno;
private String p06aMaterno;
private String p07curp;
private Integer p08edad;
private String p09sexo;
private Double p10talla;
private Double p11peso;
private Double p12imc;
private String p13domicilio1;
private String p14domicilio2;
private Integer p15abuelos;
private Integer p15padres;
private Integer p15tios;
private Integer p15hermanos;
private Integer p15otros;
private Integer p15obesidad;
private Integer p15alcoholismo;
private Integer p15dislipidemias;
private Integer p15sedentarismo;
@Temporal(javax.persistence.TemporalType.DATE) 
private Date p16fecha;
private Integer p17deteccionConsulta;
private Integer p17deteccionIntegral;
private Integer p18tratamientoPrevio;
private Integer p19diabetesTipo1;
private Integer p20diabetesTipo2;
@Temporal(javax.persistence.TemporalType.DATE) 
private Date p21fecha;
@Temporal(javax.persistence.TemporalType.DATE) 
private Date p22reingreso;
private Double p23peso;
private Double p24imc;
private Integer p25sistolica;
private Integer p26diastolica;
private Integer p27colesterol;
private Integer p28trigliceridos;
private Integer p29glucemia;
private String p30nofarmacologico;
private String p31farmacologico;
private String p32grupoayuda;
private String p33complicaciones;
private Integer p34referencia;
private String p35baja;
private String p36observaciones;

    public Diabetes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public String getP01unidad() {
        return p01unidad;
    }

    public void setP01unidad(String p01unidad) {
        this.p01unidad = p01unidad;
    }

    public Integer getP02jurisdiccion() {
        return p02jurisdiccion;
    }

    public void setP02jurisdiccion(Integer p02jurisdiccion) {
        this.p02jurisdiccion = p02jurisdiccion;
    }

    public String getP03localidad() {
        return p03localidad;
    }

    public void setP03localidad(String p03localidad) {
        this.p03localidad = p03localidad;
    }

    public String getP04entidadFederativa() {
        return p04entidadFederativa;
    }

    public void setP04entidadFederativa(String p04entidadFederativa) {
        this.p04entidadFederativa = p04entidadFederativa;
    }

    public Integer getP05expediente() {
        return p05expediente;
    }

    public void setP05expediente(Integer p05expediente) {
        this.p05expediente = p05expediente;
    }

    public String getP06nombre() {
        return p06nombre;
    }

    public void setP06nombre(String p06nombre) {
        this.p06nombre = p06nombre;
    }

    public String getP06aPaterno() {
        return p06aPaterno;
    }

    public void setP06aPaterno(String p06aPaterno) {
        this.p06aPaterno = p06aPaterno;
    }

    public String getP06aMaterno() {
        return p06aMaterno;
    }

    public void setP06aMaterno(String p06aMaterno) {
        this.p06aMaterno = p06aMaterno;
    }

    public String getP07curp() {
        return p07curp;
    }

    public void setP07curp(String p07curp) {
        this.p07curp = p07curp;
    }

    public Integer getP08edad() {
        return p08edad;
    }

    public void setP08edad(Integer p08edad) {
        this.p08edad = p08edad;
    }

    public String getP09sexo() {
        return p09sexo;
    }

    public void setP09sexo(String p09sexo) {
        this.p09sexo = p09sexo;
    }

    public Double getP10talla() {
        return p10talla;
    }

    public void setP10talla(Double p10talla) {
        this.p10talla = p10talla;
    }

    public Double getP11peso() {
        return p11peso;
    }

    public void setP11peso(Double p11peso) {
        this.p11peso = p11peso;
    }

    public Double getP12imc() {
        return p12imc;
    }

    public void setP12imc(Double p12imc) {
        this.p12imc = p12imc;
    }

    public String getP13domicilio1() {
        return p13domicilio1;
    }

    public void setP13domicilio1(String p13domicilio1) {
        this.p13domicilio1 = p13domicilio1;
    }

    public String getP14domicilio2() {
        return p14domicilio2;
    }

    public void setP14domicilio2(String p14domicilio2) {
        this.p14domicilio2 = p14domicilio2;
    }

    public Integer getP15abuelos() {
        return p15abuelos;
    }

    public void setP15abuelos(Integer p15abuelos) {
        this.p15abuelos = p15abuelos;
    }

    public Integer getP15padres() {
        return p15padres;
    }

    public void setP15padres(Integer p15padres) {
        this.p15padres = p15padres;
    }

    public Integer getP15tios() {
        return p15tios;
    }

    public void setP15tios(Integer p15tios) {
        this.p15tios = p15tios;
    }

    public Integer getP15hermanos() {
        return p15hermanos;
    }

    public void setP15hermanos(Integer p15hermanos) {
        this.p15hermanos = p15hermanos;
    }

    public Integer getP15otros() {
        return p15otros;
    }

    public void setP15otros(Integer p15otros) {
        this.p15otros = p15otros;
    }

    public Integer getP15obesidad() {
        return p15obesidad;
    }

    public void setP15obesidad(Integer p15obesidad) {
        this.p15obesidad = p15obesidad;
    }

    public Integer getP15alcoholismo() {
        return p15alcoholismo;
    }

    public void setP15alcoholismo(Integer p15alcoholismo) {
        this.p15alcoholismo = p15alcoholismo;
    }

    public Integer getP15dislipidemias() {
        return p15dislipidemias;
    }

    public void setP15dislipidemias(Integer p15dislipidemias) {
        this.p15dislipidemias = p15dislipidemias;
    }

    public Integer getP15sedentarismo() {
        return p15sedentarismo;
    }

    public void setP15sedentarismo(Integer p15sedentarismo) {
        this.p15sedentarismo = p15sedentarismo;
    }

    public Date getP16fecha() {
        return p16fecha;
    }

    public void setP16fecha(Date p16fecha) {
        this.p16fecha = p16fecha;
    }

    public Integer getP17deteccionConsulta() {
        return p17deteccionConsulta;
    }

    public void setP17deteccionConsulta(Integer p17deteccionConsulta) {
        this.p17deteccionConsulta = p17deteccionConsulta;
    }

    public Integer getP17deteccionIntegral() {
        return p17deteccionIntegral;
    }

    public void setP17deteccionIntegral(Integer p17deteccionIntegral) {
        this.p17deteccionIntegral = p17deteccionIntegral;
    }

    public Integer getP18tratamientoPrevio() {
        return p18tratamientoPrevio;
    }

    public void setP18tratamientoPrevio(Integer p18tratamientoPrevio) {
        this.p18tratamientoPrevio = p18tratamientoPrevio;
    }

    public Integer getP19diabetesTipo1() {
        return p19diabetesTipo1;
    }

    public void setP19diabetesTipo1(Integer p19diabetesTipo1) {
        this.p19diabetesTipo1 = p19diabetesTipo1;
    }

    public Integer getP20diabetesTipo2() {
        return p20diabetesTipo2;
    }

    public void setP20diabetesTipo2(Integer p20diabetesTipo2) {
        this.p20diabetesTipo2 = p20diabetesTipo2;
    }

    public Date getP21fecha() {
        return p21fecha;
    }

    public void setP21fecha(Date p21fecha) {
        this.p21fecha = p21fecha;
    }

    public Date getP22reingreso() {
        return p22reingreso;
    }

    public void setP22reingreso(Date p22reingreso) {
        this.p22reingreso = p22reingreso;
    }

    public Double getP23peso() {
        return p23peso;
    }

    public void setP23peso(Double p23peso) {
        this.p23peso = p23peso;
    }

    public Double getP24imc() {
        return p24imc;
    }

    public void setP24imc(Double p24imc) {
        this.p24imc = p24imc;
    }

    public Integer getP25sistolica() {
        return p25sistolica;
    }

    public void setP25sistolica(Integer p25sistolica) {
        this.p25sistolica = p25sistolica;
    }

    public Integer getP26diastolica() {
        return p26diastolica;
    }

    public void setP26diastolica(Integer p26diastolica) {
        this.p26diastolica = p26diastolica;
    }

    public Integer getP27colesterol() {
        return p27colesterol;
    }

    public void setP27colesterol(Integer p27colesterol) {
        this.p27colesterol = p27colesterol;
    }

    public Integer getP28trigliceridos() {
        return p28trigliceridos;
    }

    public void setP28trigliceridos(Integer p28trigliceridos) {
        this.p28trigliceridos = p28trigliceridos;
    }

    public Integer getP29glucemia() {
        return p29glucemia;
    }

    public void setP29glucemia(Integer p29glucemia) {
        this.p29glucemia = p29glucemia;
    }

    public String getP30nofarmacologico() {
        return p30nofarmacologico;
    }

    public void setP30nofarmacologico(String p30nofarmacologico) {
        this.p30nofarmacologico = p30nofarmacologico;
    }

    public String getP31farmacologico() {
        return p31farmacologico;
    }

    public void setP31farmacologico(String p31farmacologico) {
        this.p31farmacologico = p31farmacologico;
    }

    public String getP32grupoayuda() {
        return p32grupoayuda;
    }

    public void setP32grupoayuda(String p32grupoayuda) {
        this.p32grupoayuda = p32grupoayuda;
    }

    public String getP33complicaciones() {
        return p33complicaciones;
    }

    public void setP33complicaciones(String p33complicaciones) {
        this.p33complicaciones = p33complicaciones;
    }

    public Integer getP34referencia() {
        return p34referencia;
    }

    public void setP34referencia(Integer p34referencia) {
        this.p34referencia = p34referencia;
    }

    public String getP35baja() {
        return p35baja;
    }

    public void setP35baja(String p35baja) {
        this.p35baja = p35baja;
    }

    public String getP36observaciones() {
        return p36observaciones;
    }

    public void setP36observaciones(String p36observaciones) {
        this.p36observaciones = p36observaciones;
    }
    
    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (p05expediente != null ? p05expediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diabetes)) {
            return false;
        }
        Diabetes other = (Diabetes) object;
        if ((this.p05expediente == null && other.p05expediente != null) || (this.p05expediente != null && !this.p05expediente.equals(other.p05expediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Diabetes[ id=" + p05expediente + " ]";
    }

  
    
}
