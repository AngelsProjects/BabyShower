/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babyshower;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author arcinima
 */
public class View extends javax.swing.JFrame {

    ImageIcon img;

    public View() {
        initComponents();
        img = new ImageIcon("src/resources/baby-png-22.png");
        setIconImage(img.getImage());
        //  box2.getDocument().addDocumentListener(new View.pathListener());
        // box2.getDocument().putProperty("name", "box");
        PromptSupport.setPrompt("Write something", box2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        box2 = new javax.swing.JTextPane();
        done = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(box2);

        done.setText("Okay");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(done)
                        .addGap(120, 120, 120)
                        .addComponent(clear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(done)
                    .addComponent(clear))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        box2.setEditable(false);
        update();
    }//GEN-LAST:event_doneActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        Style defaultStyle = StyleContext.
                getDefaultStyleContext().
                getStyle(StyleContext.DEFAULT_STYLE);
        StyledDocument doc = box2.getStyledDocument();
        doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, true);
        box2.setText("");
        box2.setEditable(true);
    }//GEN-LAST:event_clearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    class pathListener implements DocumentListener {

        final String newline = "\n";

        //metodo para escuchar cuando inserte un nuevo caracter
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateLog(e, "insertado en");
        }

        //Metodo para escuchar cuando elimine un caracter
        @Override
        public void removeUpdate(DocumentEvent e) {
            updateLog(e, "removido en");
        }

        //metodo para escuchar cuando cambie un caracter
        @Override
        public void changedUpdate(DocumentEvent e) {
            updateLog(e, "cambio en");
        }

        //metodo de actualizacion por cada uno de los metodos anteriores
        public void updateLog(DocumentEvent e, String action) {
            Document doc = (Document) e.getDocument();
            //recibe el archivo del directorio de PATH
            update();
        }
    }

    private void update() {
        try {
            String[] array = box2.getText().split("#");
            // Start with the current input attributes for the JTextPane. This
            // should ensure that we do not wipe out any existing attributes
            // (such as alignment or other paragraph attributes) currently
            // set on the text area.
            //     Style defaultStyle = StyleContext.
            //             getDefaultStyleContext().
            //           getStyle(StyleContext.DEFAULT_STYLE);
            StyledDocument doc = box2.getStyledDocument();
            //  doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, true);

            StyleContext sc = StyleContext.getDefaultStyleContext();

            // MutableAttributeSet attrs = jtp.getInputAttributes();
            AttributeSet attrs = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Background, Color.LIGHT_GRAY);
            // Set the font color
            //StyleConstants.setForeground(attrs, c);

            // Retrieve the pane's document object
            // System.out.println(doc.getLength());
            // Replace the style for the entire document. We exceed the length
            // of the document by 1 so that text entered at the end of the
            // document uses the attributes.
            if (array.length > 0) {

                for (int x = 0; x < array.length; x++) {

                    int startIndex = 0;
                    int endIndex = 0;
                    if (x > 0) {
                        int z=0;
                        for (z=0; z <= x; z++) {
                            startIndex = 1 + array[z].length();
                        }
                        endIndex = startIndex + array[x].length();
                    } else {
                        endIndex = array[x].length();//startIndex + currentSym.value.toString().length();
                    }
                    //escogemos un colo para pintarlo
                    // DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);

                    //Por ultimo agregamos esas 3 variables anterior a un nuevo estilo Highlight a nuestro TEXTAREA
                    doc.setCharacterAttributes(startIndex, endIndex, attrs, true);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane box2;
    private javax.swing.JButton clear;
    private javax.swing.JButton done;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
