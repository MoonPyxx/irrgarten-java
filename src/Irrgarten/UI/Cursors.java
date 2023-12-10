package Irrgarten.UI;
import Irrgarten.Directions;
public class Cursors extends javax.swing.JDialog {
    private Directions direction;
    public Cursors(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UP = new javax.swing.JButton();
        RIGHT = new javax.swing.JButton();
        LEFT = new javax.swing.JButton();
        DOWN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        UP.setText("UP");
        UP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPActionPerformed(evt);
            }
        });

        RIGHT.setText("RIGHT");
        RIGHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RIGHTActionPerformed(evt);
            }
        });

        LEFT.setText("LEFT");
        LEFT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LEFTActionPerformed(evt);
            }
        });

        DOWN.setText("DOWN");
        DOWN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOWNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(LEFT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(RIGHT)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(DOWN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(UP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(UP)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RIGHT)
                    .addComponent(LEFT))
                .addGap(18, 18, 18)
                .addComponent(DOWN)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPActionPerformed
        direction = Directions.UP;
        dispose();
    }//GEN-LAST:event_UPActionPerformed

    private void RIGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RIGHTActionPerformed
        direction = Directions.RIGHT;
        dispose();
    }//GEN-LAST:event_RIGHTActionPerformed

    private void LEFTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LEFTActionPerformed
        direction = Directions.LEFT;
        dispose();
    }//GEN-LAST:event_LEFTActionPerformed

    private void DOWNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOWNActionPerformed
        direction = Directions.DOWN;
        dispose();
    }//GEN-LAST:event_DOWNActionPerformed
    public Directions getDirection(){
        return direction;
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cursors dialog = new Cursors(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DOWN;
    private javax.swing.JButton LEFT;
    private javax.swing.JButton RIGHT;
    private javax.swing.JButton UP;
    // End of variables declaration//GEN-END:variables
}
