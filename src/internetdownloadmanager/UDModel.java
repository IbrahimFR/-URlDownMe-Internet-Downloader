/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetdownloadmanager;

/**
 *
 * @author zamalek
 */
public class UDModel {
    public String URL;

    public String getURL() {
        System.out.println("get ="+ URL);
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
        System.out.println(URL);
    }
    
}
