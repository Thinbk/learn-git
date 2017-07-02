/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gheptranh;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author anhdiepmmk
 */
public class ImageButton extends JButton {

    private int value, curRow, curCol;

    /**
     * Tạo nút mới
     *
     * @param i Tọa độ dòng của nút trên ma trận
     * @param j Tọa độ cột của nút trên ma trận
     * @param value giá trị của nút trên ma trận
     */
    public ImageButton(int i, int j) {
        /*Tạo mới và thiết lập giao diện*/
        super();
        this.setFocusable(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBorder(BorderFactory.createLineBorder(Color.red));
        this.setBackground(Color.darkGray);

        /*Lưu thông tin cho nút*/
        value = 0;
        this.curRow = i;
        this.curCol = j;
    }

    /**
     * Truyền giá trị cho nút
     *
     * @param value giá trị truyền vào
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Lấy giá trị của nút
     *
     * @return giá trị trả về
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Lấy tọa độ dòng của nút
     *
     * @return trả về tọa độ dòng
     */
    public int getCurRow() {
        return this.curRow;
    }

    /**
     * Lấy tọa độ cột của nút
     *
     * @return trả về tọa độ cột
     */
    public int getCurCol() {
        return this.curCol;
    }

    /**
     * Thiết lập tọa độ dòng cho nút
     *
     * @param curRow dòng thứ...
     */
    public void setCurRow(int curRow) {
        this.curRow = curRow;
    }

    /**
     * Thiết lập tọa độ cột cho nút
     *
     * @param curCol cột thứ...
     */
    public void setCurCol(int curCol) {
        this.curCol = curCol;
    }
}
