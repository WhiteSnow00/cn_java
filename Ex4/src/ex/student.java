package ex;

import java.sql.Date;

public class student {
    private int maSV;
    private String tenSV;
    private Date namSinh;
    private double diemCTDL;
    private double diemCSDL;
    private double diemMMT;
    
        public int getMaSV() {
        return maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public double getDiemCTDL() {
        return diemCTDL;
    }

    public double getDiemCSDL() {
        return diemCSDL;
    }

    public double getDiemMMT() {
        return diemMMT;
    }

    public student(int maSV, String tenSV, Date namSinh, float dienCTDL, float diemCSDL, float diemMMT) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.namSinh = namSinh;
        this.diemCTDL = dienCTDL;
        this.diemCSDL = diemCSDL;
        this.diemMMT = diemMMT;
    }

    // Getters và setters cho các thuộc tính
}
