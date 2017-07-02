/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gheptranh;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author anhdiepmmk
 */
public class frmMain extends javax.swing.JFrame implements ActionListener {

    /*Số dòng, số cột, tọa độ dòng hiện tại của nút con trỏ, tọa độ cột hiện tại của nút con trỏ*/
    private int rows, cols, curRow, curCol;
    /*Độ rộng mặc định của jPanelBoard, độ cao mặc định của jPanelBoard,ma trận các nút,ảnh, khung chứa ảnh gốc*/
    private final int JPANELBOARD_WIDTH = 412, JPANELBOARD_Height = 381;
    private ImageButton[][] matrix;
    private ImageIcon imageIcon = new ImageIcon(getClass().getResource("no_photo.jpg"));
    private frmImage frameImage = null;

    /**
     * Vẽ bàn chơi
     *
     * @param rows Số dòng
     * @param cols Số cột
     */
    private void drawBoard(int rows, int cols) {
        /*Dưa jPanelBoard về trạng thái mặc định*/
        this.jPanelBoard.removeAll();
        this.jPanelBoard.revalidate();

        /*Cập nhật các thuộc tính*/
        this.rows = rows;
        this.cols = cols;

        /*Tạo ra ma trận và lưới tương ứng để chứa các phần tử trong ma trận*/
        this.matrix = new ImageButton[rows + 1][cols];
        this.jPanelBoard.setLayout(new GridLayout(rows + 1, cols));

        /*Đưa các phần tử trong ma trận vào lưới tương ứng*/
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                this.matrix[i][j] = new ImageButton(i, j);
                this.matrix[i][j].addActionListener(this);
                this.jPanelBoard.add(this.matrix[i][j]);
            }
        }
        /*Thêm vào ma trận một dòng nhưng chỉ có nút cuối cùng được Enabled đây là nút trắng dùng để đi trong ma trận*/
        for (int j = 0; j < cols; ++j) {
            this.matrix[rows][j] = new ImageButton(rows, j);
            this.matrix[rows][j].setVisible(false);
            this.jPanelBoard.add(this.matrix[rows][j]);
        }
        this.matrix[rows][cols - 1].addActionListener(this);
        this.matrix[rows][cols - 1].setVisible(true);

        fillRandomImages();
    }

    /**
     * Đưa ngẫu nhiên các tấm ảnh vào ma trận các nút
     */
    private void fillRandomImages() {
        /*Lấy hình ảnh từ đường dẫn url và chuẩn hóa kích thuớc của ảnh*/
        Image image = this.imageIcon
                .getImage()
                .getScaledInstance(this.JPANELBOARD_WIDTH,
                this.JPANELBOARD_Height,
                Image.SCALE_DEFAULT);

        /*Cắt ảnh + tạo value*/
        List<Image> list = new ArrayList<>();
        List<Integer> listValue = new ArrayList<>();

        int count = 1;
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                /*Cắt lấy bức hình nhỏ rồi đưa vào mảng*/
                Image imageTemp = createImage(new FilteredImageSource(image.getSource(),
                        new CropImageFilter(j * this.JPANELBOARD_WIDTH / this.cols,
                        i * this.JPANELBOARD_Height / this.rows,
                        this.JPANELBOARD_WIDTH / this.cols,
                        this.JPANELBOARD_Height / this.rows)));

                list.add(imageTemp);
                listValue.add(count++);

            }
        }

        /*Đưa những bức hình đã cắt vào ma trận các nút, ảnh nào dùng rồi ~> gỡ luôn ~> lần sau ko trùng :v*/
        Random rand = new Random();
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                /*Lấy vị trí ngẫu nhiên,và từ vị trí ngẫu nhiên gán giá trị cho nút*/
                int pos = rand.nextInt(list.size() - 1);
                this.matrix[i][j].setIcon(new ImageIcon(list.get(pos)));
                this.matrix[i][j].setValue(listValue.get(pos));

                /*Làm xong gỡ luôn cho không trùng*/
                list.remove(pos);
                listValue.remove(pos);

                /*Nếu là ô vuông cuối cùng thì gán là ảnh cuối cùng nếu không làm điều này ~> nước chết*/
                if (list.size() == 1) {
                    this.matrix[i][++j].setIcon(new ImageIcon(list.get(0)));
                    this.matrix[i][j].setValue(listValue.get(0));
                    break;
                }
            }
        }

        /*Reset tọa độ, đưa nút con trỏ về trạng thái mặc định*/
        this.curRow = this.rows;
        this.curCol = this.cols - 1;
        this.matrix[rows][cols - 1].setIcon(null);
    }

    /**
     * Chuyển hai vị trí trong ma trận cho nhau
     *
     * @param fromRow Từ dòng...
     * @param fromCol Từ cột...
     * @param toRow ...Tới dòng
     * @param toCol ...Tới cột
     */
    private void swapPosition(int fromRow, int fromCol, int toRow, int toCol) {
        /*Lấy dữ liệu của nút cần chuyển*/
        ImageIcon ico = (ImageIcon) this.matrix[fromRow][fromCol].getIcon();
        int value = this.matrix[fromRow][fromCol].getValue();

        /*Chuyển nút cần chuyển thành nút tới*/
        this.matrix[fromRow][fromCol].setIcon(this.matrix[toRow][toCol].getIcon());
        this.matrix[fromRow][fromCol].setValue(this.matrix[toRow][toCol].getValue());

        /*Biến nút tới thành nút cần chuyển*/
        this.matrix[toRow][toCol].setIcon(ico);
        this.matrix[toRow][toCol].setValue(value);

        /*Cập nhật lại tọa độ cho nút đen*/
        this.curRow = toRow;
        this.curCol = toCol;
    }

    /**
     * Kiểm tra xem người chơi đã hoàn thành màn chơi chưa
     * @return 
     */
    private boolean checkWin() {
        /*Nếu con trỏ không ở vị trí mặc định ~> ko cần kiểm tra giả về false luôn*/
        if (this.curRow != this.rows || this.curCol != this.cols - 1) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                /*Kiểm tra các value của các nút trong ma trận nếu value xáo trộn tức là chưa thắng ~> trả về false*/
                if (++count != this.matrix[i][j].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Creates new form frmMain
     */
    @SuppressWarnings("empty-statement")
    public frmMain() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("puzzle_green.png")).getImage());
        this.drawBoard(4, 4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBoard = new javax.swing.JPanel();
        jButtonRefresh = new javax.swing.JButton();
        jButtonBrowser = new javax.swing.JButton();
        jComboBoxLevel = new javax.swing.JComboBox();
        jComboBoxImage = new javax.swing.JComboBox();
        jButtonSrcImage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ghép Tranh");
        setResizable(false);

        javax.swing.GroupLayout jPanelBoardLayout = new javax.swing.GroupLayout(jPanelBoard);
        jPanelBoard.setLayout(jPanelBoardLayout);
        jPanelBoardLayout.setHorizontalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );
        jPanelBoardLayout.setVerticalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jButtonRefresh.setText("Trộn");
        jButtonRefresh.setFocusable(false);
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonBrowser.setText("Duyệt ảnh");
        jButtonBrowser.setFocusable(false);
        jButtonBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowserActionPerformed(evt);
            }
        });

        jComboBoxLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dễ", "Trung bình", "Khó", "Cực khó" }));
        jComboBoxLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLevelItemStateChanged(evt);
            }
        });

        jComboBoxImage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no_photo.jpg", "ma.jpg", "xiang.jpg", "chelsea.png", "stockcity.jpg", "halong.jpg" }));
        jComboBoxImage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxImageItemStateChanged(evt);
            }
        });

        jButtonSrcImage.setText("ảnh gốc");
        jButtonSrcImage.setFocusable(false);
        jButtonSrcImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSrcImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSrcImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBrowser))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addComponent(jPanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanelBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBrowser)
                    .addComponent(jButtonRefresh)
                    .addComponent(jComboBoxLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSrcImage))
                .addGap(133, 133, 133))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowserActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String extension = fc.getSelectedFile().getPath().substring(fc.getSelectedFile().getPath().indexOf(".") + 1);
            if (!"png".equals(extension.toLowerCase()) && !"jpg".equals(extension.toLowerCase())) {
                this.jButtonBrowserActionPerformed(null);
            } else {
                this.imageIcon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
                this.fillRandomImages();
            }
            if (this.frameImage != null) {
                this.frameImage.setImage(imageIcon);
            }
        }
    }//GEN-LAST:event_jButtonBrowserActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        this.fillRandomImages();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jComboBoxLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLevelItemStateChanged
        // TODO add your handling code here:
        this.drawBoard(4 + this.jComboBoxLevel.getSelectedIndex(), 4 + this.jComboBoxLevel.getSelectedIndex());
    }//GEN-LAST:event_jComboBoxLevelItemStateChanged

    private void jComboBoxImageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxImageItemStateChanged
        // TODO add your handling code here:
        this.imageIcon = new ImageIcon(getClass().getResource(this.jComboBoxImage.getSelectedItem().toString()));
        this.fillRandomImages();
        if (this.frameImage != null) {
            this.frameImage.setImage(this.imageIcon);
        }
    }//GEN-LAST:event_jComboBoxImageItemStateChanged

    private void jButtonSrcImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSrcImageActionPerformed
        // TODO add your handling code here:
        if (this.frameImage == null) {
            this.frameImage = new frmImage();
            this.frameImage.setImage(this.imageIcon);
            this.frameImage.show();
        } else {
            this.frameImage.show();
        }
    }//GEN-LAST:event_jButtonSrcImageActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowser;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSrcImage;
    private javax.swing.JComboBox jComboBoxImage;
    private javax.swing.JComboBox jComboBoxLevel;
    private javax.swing.JPanel jPanelBoard;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Get Data*/
        ImageButton btn = (ImageButton) e.getSource();
        int i = btn.getCurRow();
        int j = btn.getCurCol();

        /*Up-Down-Left-Right*/
        if ((i == curRow - 1 && j == curCol)
                || (i == curRow + 1 && j == curCol)
                || (j == curCol - 1 && i == curRow)
                || (j == curCol + 1 && i == curRow)) {
            this.swapPosition(curRow, curCol, i, j);
        }

        /*Nếu chiến thắng thì báo thắng và chơi lại*/
        if (this.checkWin()) {
            JOptionPane.showMessageDialog(null, "Qua màn!!!");
            this.fillRandomImages();
        }
    }
}
