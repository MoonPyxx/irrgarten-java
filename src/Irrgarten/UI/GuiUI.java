package Irrgarten.UI;

import Irrgarten.Directions;
import Irrgarten.GameState;

public class GuiUI extends javax.swing.JFrame implements UI {
    private String labyrinth, players, monsters, log, currentPlayer, winner;
    private Cursors cursor;
    public GuiUI() {
        initComponents();
        cursor = new Cursors(this,true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        LaberintoLabel = new javax.swing.JLabel();
        turnoLabel = new javax.swing.JLabel();
        turno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        PlayersArea = new javax.swing.JTextArea();
        PlayersLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MonstersArea = new javax.swing.JTextArea();
        MonstersLabel = new javax.swing.JLabel();
        WinnerLabel = new javax.swing.JLabel();
        winnerField = new javax.swing.JTextField();
        Logs = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        LogsArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableroArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        panel.setBackground(new java.awt.Color(204, 204, 255));

        LaberintoLabel.setFont(new java.awt.Font("Lucida Console", 1, 36)); // NOI18N
        LaberintoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/irrgarten.png"))); // NOI18N
        LaberintoLabel.setText("Irrgarten");
        LaberintoLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        turnoLabel.setText("Turn:");
        turnoLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        turno.setBackground(new java.awt.Color(0, 0, 0));
        turno.setForeground(new java.awt.Color(255, 255, 255));
        turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnoActionPerformed(evt);
            }
        });

        PlayersArea.setBackground(new java.awt.Color(0, 0, 0));
        PlayersArea.setColumns(20);
        PlayersArea.setForeground(new java.awt.Color(255, 255, 255));
        PlayersArea.setRows(5);
        PlayersArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PlayersArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(PlayersArea);

        PlayersLabel.setText("Players");
        PlayersLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MonstersArea.setBackground(new java.awt.Color(0, 0, 0));
        MonstersArea.setColumns(20);
        MonstersArea.setForeground(new java.awt.Color(255, 255, 255));
        MonstersArea.setRows(5);
        MonstersArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(MonstersArea);

        MonstersLabel.setText("Monsters");
        MonstersLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        WinnerLabel.setText("Winner:");
        WinnerLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        winnerField.setBackground(new java.awt.Color(0, 0, 0));
        winnerField.setForeground(new java.awt.Color(255, 255, 255));
        winnerField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Logs.setText("Logs");
        Logs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LogsArea.setBackground(new java.awt.Color(0, 0, 0));
        LogsArea.setColumns(20);
        LogsArea.setForeground(new java.awt.Color(255, 255, 255));
        LogsArea.setRows(5);
        LogsArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(LogsArea);

        TableroArea.setBackground(new java.awt.Color(51, 51, 0));
        TableroArea.setColumns(20);
        TableroArea.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        TableroArea.setForeground(new java.awt.Color(255, 255, 255));
        TableroArea.setRows(5);
        TableroArea.setToolTipText("");
        TableroArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane4.setViewportView(TableroArea);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LaberintoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MonstersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(turnoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlayersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(WinnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(winnerField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 681, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(turnoLabel)
                            .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WinnerLabel)
                            .addComponent(winnerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(LaberintoLabel)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(365, 365, 365))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(PlayersLabel)
                        .addGap(193, 193, 193)
                        .addComponent(MonstersLabel)
                        .addGap(92, 92, 92)
                        .addComponent(Logs)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnoActionPerformed
       
    }//GEN-LAST:event_turnoActionPerformed

    @Override
    public Directions nextMove() {
       cursor.setVisible(true);
       return cursor.getDirection();
    }

    @Override
    public void showGame(GameState gameState) {
        
        labyrinth = gameState.getLabyrinth();
        TableroArea.setText(labyrinth);
        players = gameState.getPlayers();
        PlayersArea.setText(players);
        monsters = gameState.getMonsters();
        MonstersArea.setText(monsters);
        log = gameState.getLog();
        LogsArea.setText(log);
        currentPlayer = Integer.toString(gameState.getCurrentPlayer());
        turno.setText(currentPlayer);
        winner = Boolean.toString(gameState.getWinner()); 
        winnerField.setText(winner);
        repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LaberintoLabel;
    private javax.swing.JLabel Logs;
    private javax.swing.JTextArea LogsArea;
    private javax.swing.JTextArea MonstersArea;
    private javax.swing.JLabel MonstersLabel;
    private javax.swing.JTextArea PlayersArea;
    private javax.swing.JLabel PlayersLabel;
    private javax.swing.JTextArea TableroArea;
    private javax.swing.JLabel WinnerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField turno;
    private javax.swing.JLabel turnoLabel;
    private javax.swing.JTextField winnerField;
    // End of variables declaration//GEN-END:variables
}
