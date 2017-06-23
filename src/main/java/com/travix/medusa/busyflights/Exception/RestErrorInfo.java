package com.travix.medusa.busyflights.Exception;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * A sample class for adding error information in the response
 * 
 * @author Temitope Kuti
 */
@XmlRootElement
public class RestErrorInfo {
    public final String detail;
    public final String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }
}
