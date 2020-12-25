
package receiver;

import java.awt.Color;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Hasan
 */
public class Connection {
    //static int bytesRead;
   // static int current = 0;
    static FileOutputStream fos = null;
    static BufferedOutputStream bos = null;
    
    public Connection() throws IOException, InterruptedException{
        Integer port;
        String ip;
        ip = JOptionPane.showInputDialog("Input Sender's IP address:");
        port = Integer.parseInt(JOptionPane.showInputDialog("Input port number"));
        Receiver.sock = new Socket(ip, port);
        Receiver.ipAd.setText(ip);
        DataInputStream isd = new DataInputStream(Receiver.sock.getInputStream());
        Thread.sleep(500);
        try {
            Receiver.status.setText("Connected!");
            Receiver.status.setForeground(new Color(27, 181, 0));
            String temp = "";
            Receiver.fName  = isd.readUTF();
            Receiver.showFile.setText(Receiver.fName);
            Thread.sleep(200);
            Receiver.fSizeB = isd.readInt();
            Receiver.fSize.setText(byteleport.Others.size(Receiver.fSizeB));
            Thread.sleep(200);
            Receiver.acceptBtn.setEnabled(true);
            
            
        }catch(Exception e){

        }
    }

    static void receiveFile() throws IOException {
        DataOutputStream dout = new DataOutputStream(Receiver.sock.getOutputStream());
        dout.writeUTF("confirm");
        byte [] mybytearray  = new byte [6553600];
        try {
            File dir = new File("../Downloads");
            if(!dir.exists()){
                dir.mkdirs();
            }
            fos = new FileOutputStream("Downloads/"+Receiver.fName);
        } catch (FileNotFoundException ex) {
            System.out.println("not found");
        }
        InputStream is = Receiver.sock.getInputStream();
        bos = new BufferedOutputStream(fos);
        //bytesRead = is.read(mybytearray,0,mybytearray.length);
        //current = bytesRead;
        long bytesToRcv = Receiver.fSizeB;
        long bytesRcvd = 0;
        Integer percnt = (int)bytesRcvd;
        Receiver.progress.setMinimum(0);
        Receiver.progress.setMaximum(100);
        
        while(bytesRcvd < bytesToRcv) {
           long numThisTime = bytesToRcv - bytesRcvd;
           numThisTime = numThisTime < mybytearray.length ? numThisTime : mybytearray.length;
           int numRead = is.read(mybytearray, 0, (int) numThisTime);
           if(numRead ==-1 ) break;
           //dout.write(mybytearray,0,numRead);
           bos.write(mybytearray,0,numRead);
           bos.flush();
           bytesRcvd += numRead;
           percnt = (int)(bytesRcvd*(100)/(int)bytesToRcv);
           Receiver.progress.setValue(percnt);
           Receiver.progress.setString(percnt.toString()+"%");
           Receiver.progress.setStringPainted(true);
        }
        Receiver.progress.setValue(100);
        Receiver.progress.setString("100%");
        Receiver.progress.setStringPainted(true);
        bos.flush();
        if (fos != null) fos.close();
        if (bos != null) bos.close();
        if (Receiver.sock != null) Receiver.sock.close();
        JOptionPane.showMessageDialog(Receiver.acceptBtn.getRootPane(),"Received!");
        System.exit(0);
    }    
    
}
