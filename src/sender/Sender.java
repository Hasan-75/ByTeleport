package sender;


import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;





public class Sender extends javax.swing.JFrame implements ItemListener{

    /**
     * Creates new form Sender
     */
    static FileInputStream fis;
    static BufferedInputStream bis;
    static OutputStream os;
    static ServerSocket servsock;
    static Socket sock;
    static File fileToSend;
    static String fName;
    static long fSizeB;
    public Sender() {
        this.setIconImage((new ImageIcon("icon.png")).getImage());
        setLook();
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        status = new javax.swing.JLabel();
        connectBtn = new javax.swing.JToggleButton();
        connectBtn.addItemListener(this);
        contPane = new javax.swing.JPanel();
        fc = new javax.swing.JFileChooser();
        fc.setVisible(false);
        cr = new javax.swing.JLabel();
        progress = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        ipShow = new javax.swing.JLabel();
        selectFile = new javax.swing.JButton();
        fileName = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        fSize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sender");
        setMinimumSize(new java.awt.Dimension(712, 0));

        status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        status.setText("Searching...");
        status.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        connectBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        connectBtn.setForeground(new java.awt.Color(27, 181, 0));
        connectBtn.setText("Connect");
        connectBtn.setBorderPainted(false);

        contPane.setBackground(new java.awt.Color(204, 204, 255));
        contPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        fc.setCurrentDirectory(new java.io.File("C:\\"));
            fc.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fcActionPerformed(evt);
                }
            });

            cr.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
            cr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            cr.setText(" ");

            progress.setForeground(new java.awt.Color(0, 141, 6));

            javax.swing.GroupLayout contPaneLayout = new javax.swing.GroupLayout(contPane);
            contPane.setLayout(contPaneLayout);
            contPaneLayout.setHorizontalGroup(
                contPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(fc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contPaneLayout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cr, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            contPaneLayout.setVerticalGroup(
                contPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(fc, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addGroup(contPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cr)
                        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Your IP");

            ipShow.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
            ipShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            selectFile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            selectFile.setText("Select file");
            selectFile.setFocusPainted(false);
            selectFile.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    selectFileActionPerformed(evt);
                }
            });

            fileName.setEditable(false);
            fileName.setBackground(new java.awt.Color(204, 204, 204));
            fileName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            fileName.setText("No file selected");

            send.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            send.setText("Send");
            send.setFocusPainted(false);
            send.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    sendActionPerformed(evt);
                }
            });

            fSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            fSize.setText("Size: ");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(contPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(93, 93, 93)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(95, 95, 95)
                                    .addComponent(connectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(selectFile, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(fileName))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(fSize, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(28, 28, 28)
                                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(17, 17, 17)))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGap(194, 194, 194)
                    .addComponent(ipShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(232, 232, 232))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(connectBtn)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ipShow)
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectFile, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(fSize)
                    .addGap(4, 4, 4)
                    .addComponent(contPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void setLook(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    private void selectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileActionPerformed
        // TODO add your handling code here:
        int h=this.getHeight(), w=this.getWidth();
        fc.setVisible(true);
        this.setSize(w, (h>713)?h:713);
    }//GEN-LAST:event_selectFileActionPerformed

    private void fcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcActionPerformed
        // TODO add your handling code here:
        int h=this.getHeight(), w=this.getWidth();
        if(evt.getActionCommand().equals("ApproveSelection")){
            System.out.println("a");
            fc.setVisible(false);
            this.setSize(w, (h>713)?h:270);
            fileToSend = fc.getSelectedFile();
            fName = fileToSend.getName();
            fSizeB = fileToSend.length();
            fileName.setText(fileToSend.getPath());
            String temp = byteleport.Others.size((int)fSizeB);
            fSize.setText("Size: " + temp);
            
        }
        if(evt.getActionCommand().equals("CancelSelection")){
            System.out.println("c");
            fc.setVisible(false);
            this.setSize(w, (h>713)?h:270);
        }
        
    }//GEN-LAST:event_fcActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        Runnable runner = new Runnable()
        {
            public void run() {
                try {
                    //Your original code with the loop here.
                    Connection.sendFile();
                } catch (IOException ex) {
                    
                }
            }
        };
        Thread t = new Thread(runner);
        t.start();
    }//GEN-LAST:event_sendActionPerformed

    
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Sender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Sender().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton connectBtn;
    static javax.swing.JPanel contPane;
    private javax.swing.JLabel cr;
    public static javax.swing.JLabel fSize;
    static javax.swing.JFileChooser fc;
    private javax.swing.JTextField fileName;
    public static javax.swing.JLabel ipShow;
    private javax.swing.JLabel jLabel1;
    static javax.swing.JProgressBar progress;
    private javax.swing.JButton selectFile;
    private javax.swing.JButton send;
    static javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(connectBtn.isSelected()){
            try {
                System.out.println("connect");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    
                }
                Connection conn = new Connection();
                connectBtn.setEnabled(false);
                
                
            } catch (IOException ex) {
                
            }
        }
        else{
            connectBtn.setForeground(new Color(27,181,0));
            connectBtn.setText("Connect");
            System.out.println("disconnect");
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
}

