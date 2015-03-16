/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ConsumerRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PublisherOrganization;
import Business.Publisher.TagList;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NotifyPublisherWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author anirudhbedre
 */
public class IMDBJPanel extends javax.swing.JPanel {

    /**
     * Creates new form IMDBJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    //t clickCount=0;
    String image;
    private Network network;
    public IMDBJPanel(JPanel upc, Enterprise enterprise,UserAccount userAccount,Network network) {
        initComponents();
         this.userProcessContainer=upc;
        this.enterprise=enterprise;
        this.userAccount=userAccount;
        this.network=network;
        
        
         TagList tagList = new TagList();
        tagList.createTag("Movies");
        tagList.createTag("TVshows");
        
        
        image = adMagic(tagList);
//        clickCountJTextField.setText(String.valueOf(clickCount));
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        
        
        adSpace2JLabel.setBorder(border);
        if (image!=null)
        adSpace2JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(image)));
        
        
    }
    
        public String adMagic(TagList tagList){
       
     //------------- send notification & Conusmer details to publisher
     
       String message="Consumer details";
       NotifyPublisherWorkRequest request=new NotifyPublisherWorkRequest();
       request.setMessage(message);
       request.setSender(userAccount);
       request.setStatus("Sent");
       request.setTagList(tagList);
       
       PublisherOrganization publisherOrganization=null;
       Enterprise enterprise2=null;
       for(Enterprise enterprise1:network.getEnterpriseDirectory().getEnterPriseList())
           if(enterprise1.getEnterpriseType()==Enterprise.EnterpriseType.InternetAdvertisingPlatform)
           {
               enterprise2=enterprise1;
                for(Organization o:enterprise1.getOrganizationDirectory().getOrganizationList()){
                    if(o instanceof PublisherOrganization){
                    publisherOrganization=(PublisherOrganization) o;
                    break; 
                }
            }
           }
        
        if(publisherOrganization!=null){
            publisherOrganization.getWorkQueue().getWorkRequestList().add(request); // attach req to target wrkQ
            userAccount.getWorkQueue().getWorkRequestList().add(request); // attach req-sent to sender wrkQ
            System.out.println("Notifying publisher");
            
            String adImage=publisherOrganization.notifyAdExchange(enterprise2, publisherOrganization);
            return adImage;
        }
        
        else{
            System.out.println("Publisher org pointer was null");
            return null;
        }
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        adSpace2JLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("IMDB.com - The Internet Database of Movies, TV and Celebrities. ");

        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        adSpace2JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ConsumerRole/no_ad.png"))); // NOI18N
        adSpace2JLabel.setText("Ad");
        adSpace2JLabel.setToolTipText("");
        adSpace2JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adSpace2JLabelMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ConsumerRole/imdb_logo.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton1)
                                .addGap(669, 669, 669))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(242, 242, 242)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(76, 76, 76)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(adSpace2JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(adSpace2JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216)
                .addComponent(backJButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        ((CardLayout)userProcessContainer.getLayout()).previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void adSpace2JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adSpace2JLabelMouseClicked
        // TODO add your handling code here:
        //        updateClickCount();
    }//GEN-LAST:event_adSpace2JLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adSpace2JLabel;
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
