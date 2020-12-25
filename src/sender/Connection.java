
package sender;

import java.awt.Color;
import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hasan
 */
public class Connection {
    
    public Connection() throws IOException{
        Integer port;
        Sender.ipShow.setText(Inet4Address.getLocalHost().getHostAddress());
        port = Integer.parseInt(JOptionPane.showInputDialog("Input port number"));
        Sender.servsock = new ServerSocket(port);

        try {
            Sender.sock = Sender.servsock.accept();
            Sender.status.setText("Connected!");
            Sender.status.setForeground(new Color(27, 181, 0));
            // send file
            //File myFile = new File (FILE_TO_SEND);
            
            //System.out.println("Done.");
        }catch(Exception e){

        }
    }
    
    static void sendFile() throws IOException{
        DataOutputStream dout = new DataOutputStream(Sender.sock.getOutputStream());
        DataInputStream din = new DataInputStream(Sender.sock.getInputStream());
        try{
            dout.writeUTF(Sender.fName);
            dout.flush();
            Thread.sleep(200);
            dout.writeInt((int)Sender.fSizeB);
            dout.flush();
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(din.readUTF().equals("confirm")){
            byte [] mybytearray  = new byte [6553600];
                Sender.fis = new FileInputStream(Sender.fileToSend);
                Sender.bis = new BufferedInputStream(Sender.fis);
                //Sender.bis.read(mybytearray,0,mybytearray.length);
                Sender.os = Sender.sock.getOutputStream();
                DataOutputStream dout2 = new DataOutputStream(Sender.os);
                long bytesToSend = Sender.fSizeB;
                long bytesSent = 0;
                Integer percnt;
                Sender.progress.setMinimum(0);
                Sender.progress.setMaximum(100);
                while(bytesSent < bytesToSend) {
                   long numThisTime = bytesToSend - bytesSent;
                   numThisTime = numThisTime < mybytearray.length ? numThisTime : mybytearray.length;
                   int numRead = Sender.fis.read(mybytearray, 0, (int) numThisTime);
                   if(numRead ==-1 ) break;
                   Sender.os.write(mybytearray,0,numRead);
                   //Sender.os.flush();
                   bytesSent += numRead;
                   percnt = (int)(bytesSent*(100)/(int)bytesToSend);
                   Sender.progress.setValue(percnt);
                   Sender.progress.setString(percnt.toString()+"%");
                   Sender.progress.setStringPainted(true);
                }
                Sender.progress.setValue(100);
                Sender.progress.setString("100%");
                Sender.progress.setStringPainted(true);
                Sender.os.flush();
                if (Sender.bis != null) Sender.bis.close();
                if (Sender.os != null) Sender.os.close();
                if (Sender.sock!=null) Sender.sock.close();
                JOptionPane.showMessageDialog(Sender.ipShow.getRootPane(),"File Sent!"); 
                System.exit(0);
        }        
    }
    
    
}
