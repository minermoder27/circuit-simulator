/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator.ui.projects;

import javax.swing.JOptionPane;

/**
 *
 * @author Campbell Suter
 */
public class ProjectProperty extends javax.swing.JFrame {

    private ProjectsWindow win;

    /**
     * Creates new form ProjectProperty
     */
    public ProjectProperty(String name, ProjectsWindow win) {
        initComponents();
        nameField.setText(name);
        this.win = win;
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
        nameField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        closeProjectButton = new javax.swing.JButton();
        newFileButton = new javax.swing.JButton();
        openWebFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Project Name");

        nameField.setEditable(false);
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        closeProjectButton.setText("Close Project");
        closeProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeProjectButtonActionPerformed(evt);
            }
        });

        newFileButton.setText("New File");
        newFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileButtonActionPerformed(evt);
            }
        });

        openWebFile.setText("Add Web File");
        openWebFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openWebFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeProjectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openWebFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameField)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(closeProjectButton)
                    .addComponent(newFileButton)
                    .addComponent(openWebFile))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void closeProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeProjectButtonActionPerformed
        int responce = JOptionPane.showConfirmDialog(this, "Are you sure you want to close this project?", "Close Project", JOptionPane.OK_CANCEL_OPTION);
        if (responce == JOptionPane.YES_OPTION) {
            ProjectList.getInstance().closeProject(nameField.getText());
            dispose();
            win.reload();
        }
    }//GEN-LAST:event_closeProjectButtonActionPerformed

    private void newFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileButtonActionPerformed
        Project p = ProjectList.getInstance().getProjects().get(nameField.getText());
        if (p.isWeb()) {
            JOptionPane.showMessageDialog(this,
                    "This is a web project!\nYou cannot make a new file on a web project",
                    "New File", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String in = JOptionPane.showInputDialog(this, "What do you want to call this new file?");
        if (!"".equals(in)) {
            p.getFiles().add(new ProjectFile(p, in));
            ProjectList.getInstance().save();
            win.reload();
        }
    }//GEN-LAST:event_newFileButtonActionPerformed

    private void openWebFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openWebFileActionPerformed
        Project p = ProjectList.getInstance().getProjects().get(nameField.getText());
        if (p.isWeb()) {
            JOptionPane.showMessageDialog(this,
                    "This is a web project!\nYou cannot make a new file on a web project",
                    "New File", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String in = JOptionPane.showInputDialog(this, "What is the name of the new file?");
        String url = JOptionPane.showInputDialog(this, "What is the URL of the new file?");
        if (!"".equals(in)) {
            p.getFiles().add(new ProjectFile(p, url, in));
            ProjectList.getInstance().save();
            win.reload();
        }
    }//GEN-LAST:event_openWebFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(final ProjectsWindow win, final String... args) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProjectProperty(args[0], win).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeProjectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton newFileButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton openWebFile;
    // End of variables declaration//GEN-END:variables
}
