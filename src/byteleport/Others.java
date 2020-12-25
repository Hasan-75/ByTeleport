
package byteleport;

import java.text.DecimalFormat;

/**
 *
 * @author Hasan
 */
public class Others {
    public static String size(int size){
    String hrSize = "";
    int b = size;
    double k = (int)size/1024.0;
    double m = (int)size/1048576.0;
    double g = (int)size/1073741824.0;

    DecimalFormat dec = new DecimalFormat("0.00");
    if ((int)b>0)
    {

        hrSize = dec.format(b).concat("BYTES");
    }
    
    if ((int)k>0)
    {

        hrSize = dec.format(k).concat("KB");
        

    }
    if ((int)m>0)
    {

        hrSize = dec.format(m).concat("MB");
       
    }
    if ((int)g>0)
    {

        hrSize = dec.format(g).concat("GB");
        
    }
    

    return hrSize;
    }
    
}
