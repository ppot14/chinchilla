/*
 * The MIT License
 *
 * Copyright 2013 Pepe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.chinchilla.controller;

import com.chinchilla.persistence.dao.CoordenadaDAO;
import com.chinchilla.persistence.dao.CultivoDAO;
import com.chinchilla.persistence.dao.ParcelaDAO;
import com.chinchilla.persistence.dao.ProduccionDAO;
import com.chinchilla.persistence.dao.TipoLaborDAO;
import java.beans.PropertyEditorSupport;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Pepe
 */
@SessionAttributes({"parcelas_json","coordenadas_json","parcelas","coordenadas","producciones","cultivos",
                    "tiposLabores"})
public abstract class AbstractController {
    
    @Autowired
    @Qualifier("produccionDAO")
    protected ProduccionDAO produccionDAO;   
    
    @Autowired
    @Qualifier("cultivoDAO")
    protected CultivoDAO cultivoDAO;  
    
    @Autowired
    @Qualifier("parcelaDAO")
    protected ParcelaDAO parcelaDAO; 
    
    @Autowired
    @Qualifier("coordenadaDAO")
    protected CoordenadaDAO coordenadaDAO;  
    
    @Autowired
    @Qualifier("tipoLaborDAO")
    protected TipoLaborDAO tipoLaborDAO;  
    
    @InitBinder
    public void binder(WebDataBinder binder) {
        binder.setIgnoreInvalidFields(true);
        binder.setIgnoreUnknownFields(true);
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
                } catch(ParseException e) {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                return new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
            }        

        });
        
        binder.registerCustomEditor(Double.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                try {
                    setValue( NumberFormat.getInstance(new Locale("es", "ES")).parse(value));
                } catch(ParseException e) {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                return NumberFormat.getInstance(new Locale("es", "ES")).format(getValue());
            }        

        });
        
        binder.registerCustomEditor(double.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String value) {
                try {
                    setValue( NumberFormat.getInstance(new Locale("es", "ES")).parse(value));
                } catch(ParseException e) {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                return NumberFormat.getInstance(new Locale("es", "ES")).format(getValue());
            }        

        });
    }
}