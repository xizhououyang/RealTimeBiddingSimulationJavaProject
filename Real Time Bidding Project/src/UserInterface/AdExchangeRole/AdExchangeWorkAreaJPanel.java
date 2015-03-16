/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.AdExchangeRole;

import Business.Ecosystem;
import Business.Organization.AdExchangeOrganization;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author anirudhbedre
 */
public class AdExchangeWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdExchangeWorkAreaJPanel
     */
   private JPanel userProcessContainer;
    private AdExchangeOrganization organization;
    public AdExchangeWorkAreaJPanel(JPanel upc,AdExchangeOrganization organization) {
        initComponents();
        this.userProcessContainer=upc;
        this.organization=organization;
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
        auctionEventHistoryJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Ad Exchange Work Area ");

        auctionEventHistoryJButton.setText("Auction Event History");
        auctionEventHistoryJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auctionEventHistoryJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(auctionEventHistoryJButton)
                        .addGap(29, 29, 29)))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addComponent(auctionEventHistoryJButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void auctionEventHistoryJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auctionEventHistoryJButtonActionPerformed
        // TODO add your handling code here:
         AuctionEventHistoryJPanel vs = new AuctionEventHistoryJPanel(userProcessContainer,organization);
        userProcessContainer.add("AuctionEventHistoryJPanel", vs);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_auctionEventHistoryJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton auctionEventHistoryJButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
