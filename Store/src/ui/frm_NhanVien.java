package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entity.Staff;
import entity.StaffList;

public class frm_NhanVien extends JFrame implements ActionListener, MouseListener {

    private JTextField txtID, txtName, txtYear, txtDiaChi, txtIDCard, txtPhoneNumber;
    private JButton btnAdd, btnClear, btnModify, btnDelete, btnSave;
    private JComboBox cboSearchByID;
    private JComboBox<String> cboGender;
    private JTable tblStaff;
    private DefaultTableModel tblModelStaff;
    DefaultComboBoxModel cboModel;
    private StaffList lstStaff = new StaffList();

    private JLabel lblNgaySinh, lblRole;
    private JTextField txtNgaySinh;
    private JLabel lblNgayDiLam;
    private JTextField txtNgayDiLam;
    private JTextField txtSoDienThoai;
    private JLabel lblDiaChi;
    private JLabel lblSoCCCD;
    private JTextField txtSoCCCD;
    String[] col = { "Mã nhân viên", "Họ và tên", "Chức vụ", "Giới tính", "Ngày sinh", "Ngày đi làm",
            "Sôs điện thoại", "Địa chỉ", "Số CCCD" };
    private JComboBox cboRole;

    public frm_NhanVien() {
        // TODO Auto-generated constructor stub
        setTitle("CỬA HÀNG TIỆN LỢI");
        setSize(1500, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addControl();

    }

    public void addControl() {
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        JPanel pnRecord = new JPanel();
        pnRecord.setLayout(new BoxLayout(pnRecord, BoxLayout.X_AXIS));
        pnRecord.setBorder(BorderFactory.createTitledBorder("Cửa hàng tiện lợi - Cập nhật nhân viên"));

        JPanel pnLeftOfNorth = new JPanel();
        pnLeftOfNorth.setLayout(new BoxLayout(pnLeftOfNorth, BoxLayout.Y_AXIS));

        JPanel pnID = new JPanel();
        JLabel lblMa, lblTuaStaff, lblNam, lblSoTrang, lblISB, lblTacGia, lblNXB, lblDonGia;
        JLabel lblChucVu;

        pnID.add(lblMa = new JLabel("Mã nhân viên:"));
        pnID.add(txtID = new JTextField());
        FlowLayout flowLayout = (FlowLayout) pnID.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        txtID.setText("NV001");
        txtID.setPreferredSize(new Dimension(380, 20));
        pnLeftOfNorth.add(pnID);

        JPanel pnStaffName = new JPanel();
        pnStaffName.add(lblTuaStaff = new JLabel("Họ và tên:"));
        FlowLayout flowLayout2 = (FlowLayout) pnStaffName.getLayout();
        flowLayout2.setAlignment(FlowLayout.LEFT);
        pnStaffName.add(txtName = new JTextField(40));
        txtName.setText("Harry Thurston");
        pnLeftOfNorth.add(pnStaffName);
        pnLeftOfNorth.add(Box.createVerticalStrut(5));

        JPanel pnRole = new JPanel();
        pnRole.add(lblTuaStaff = new JLabel("Chức vụ"));
        FlowLayout flowLayout3 = (FlowLayout) pnRole.getLayout();
        flowLayout3.setAlignment(FlowLayout.LEFT);
        // Tạo combobox giới tính
        cboRole = new JComboBox<>();
        cboRole.addItem("Quản lý");
        cboRole.addItem("Nhân viên");
        flowLayout3.setAlignment(FlowLayout.LEFT);
        pnRole.add(cboRole);
        pnLeftOfNorth.add(pnRole);
        pnRecord.add(pnLeftOfNorth);

        JPanel pnMiddleOfNorth = new JPanel();
        pnMiddleOfNorth.setLayout(new BoxLayout(pnMiddleOfNorth, BoxLayout.Y_AXIS));

        JPanel pnGioiTinh = new JPanel();
        JLabel lblGioiTinh;
        pnGioiTinh.add(lblGioiTinh = new JLabel("Giới Tính:"));
        FlowLayout fl1 = (FlowLayout) pnGioiTinh.getLayout();
        fl1.setAlignment(FlowLayout.LEFT);
        // Tạo combobox giới tính
        cboGender = new JComboBox<>();
        cboGender.addItem("Nam");
        cboGender.addItem("Nữ");
        cboGender.addItem("LGBT");
        cboGender.addItem("Khác");

        fl1.setAlignment(FlowLayout.LEFT);
        pnGioiTinh.add(cboGender);
        pnMiddleOfNorth.add(pnGioiTinh);

        // JPanel pnNgaySinh = new JPanel();
        // pnNgaySinh.add(lblNgaySinh = new JLabel("Ngày sinh:"));
        // FlowLayout fl2 = (FlowLayout) pnNgaySinh.getLayout();
        // fl2.setAlignment(FlowLayout.LEFT);
        // pnNgaySinh.add(txtNgaySinh = new JTextField(40));
        // pnMiddleOfNorth.add(pnNgaySinh);
        //
        // JPanel pnNgayDiLam = new JPanel();
        // pnNgayDiLam.add(lblNgayDiLam = new JLabel("Ngày đi làm:"));
        // FlowLayout fl3 = (FlowLayout) pnNgayDiLam.getLayout();
        // fl3.setAlignment(FlowLayout.LEFT);
        // pnNgayDiLam.add(txtNgayDiLam = new JTextField(40));
        // pnMiddleOfNorth.add(pnNgayDiLam);
        JPanel pnNgaySinh = new JPanel();
        pnNgaySinh.add(lblNgaySinh = new JLabel("Ngày sinh:"));
        FlowLayout fl2 = (FlowLayout) pnNgaySinh.getLayout();
        fl2.setAlignment(FlowLayout.LEFT);
        JDateChooser dateChooserNgaySinh = new JDateChooser();
        dateChooserNgaySinh.setPreferredSize(new Dimension(15 * 8, 20)); // Thiết lập độ rộng cho JDateChooser là 15 cột
        pnNgaySinh.add(dateChooserNgaySinh);
        pnMiddleOfNorth.add(pnNgaySinh);

        JPanel pnNgayDiLam = new JPanel();
        pnNgayDiLam.add(lblNgayDiLam = new JLabel("Ngày đi làm:"));
        FlowLayout fl3 = (FlowLayout) pnNgayDiLam.getLayout();
        fl3.setAlignment(FlowLayout.LEFT);
        JDateChooser dateChooserNgayDiLam = new JDateChooser();
        dateChooserNgayDiLam.setPreferredSize(new Dimension(15 * 8, 20)); // Set the preferred size of the JDateChooser
        pnNgayDiLam.add(dateChooserNgayDiLam);
        pnMiddleOfNorth.add(pnNgayDiLam);

        pnRecord.add(pnMiddleOfNorth);
        JPanel pnRightOfNorth = new JPanel();
        pnRightOfNorth.setLayout(new BoxLayout(pnRightOfNorth, BoxLayout.Y_AXIS));

        JPanel pnSoDienThoai = new JPanel();
        JLabel lblSoDienThoai;
        pnSoDienThoai.add(lblSoDienThoai = new JLabel("Số điện thoại:"));
        FlowLayout fl4 = (FlowLayout) pnSoDienThoai.getLayout();
        fl4.setAlignment(FlowLayout.LEFT);
        pnSoDienThoai.add(txtSoDienThoai = new JTextField(40));
        pnRightOfNorth.add(pnSoDienThoai);

        JPanel pnDiaChi = new JPanel();
        pnDiaChi.add(lblDiaChi = new JLabel("Địa chỉ:"));
        FlowLayout fl5 = (FlowLayout) pnDiaChi.getLayout();
        fl5.setAlignment(FlowLayout.LEFT);
        pnDiaChi.add(txtDiaChi = new JTextField(40));
        pnRightOfNorth.add(pnDiaChi);

        JPanel pnSoCCCD = new JPanel();
        pnSoCCCD.add(lblSoCCCD = new JLabel("Số CCCD:"));
        FlowLayout fl6 = (FlowLayout) pnSoCCCD.getLayout();
        fl6.setAlignment(FlowLayout.LEFT);
        pnSoCCCD.add(txtSoCCCD = new JTextField(40));
        pnRightOfNorth.add(pnSoCCCD);

        pnRecord.add(pnRightOfNorth);

        pnMain.add(pnRecord);
        pnMain.add(Box.createVerticalStrut(10));

        // ========= chức năng
        JPanel pnChucNang = new JPanel();
        pnChucNang.add(btnAdd = new JButton("Thêm"));
        pnChucNang.add(btnClear = new JButton("Xóa rỗng"));
        pnChucNang.add(btnModify = new JButton("Sửa"));
        pnChucNang.add(btnDelete = new JButton("Xóa"));
        pnChucNang.add(btnSave = new JButton("Lưu"));
        pnChucNang.add(new JLabel("                Tìm mã nhân viên:  "));
        // === khoi tao combobox
        pnChucNang.add(cboSearchByID = new JComboBox());
        pnMain.add(pnChucNang);
        pnMain.add(Box.createVerticalStrut(10));

        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
        pnSouth.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.Y_AXIS));
        tblModelStaff = new DefaultTableModel(col, 0);

        loadCbo();
        loadDataToTable(StaffList.getAll(), tblModelStaff);
        tblStaff = new JTable(tblModelStaff);
        pnTable.add(new JScrollPane(tblStaff));
        pnSouth.add(pnTable);
        pnMain.add(pnSouth);
        this.add(pnMain);

        // ============= Action =============
        btnClear.addActionListener(this);
        btnModify.addActionListener(this);
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnSave.addActionListener(this);
        tblStaff.addMouseListener(this);
        cboSearchByID.addActionListener(this);
    }

    private JPanel createComboBoxPanel(String label, JComboBox<String> comboBox, String[] items) {
        for (String item : items) {
            comboBox.addItem(item);
        }
        return createSectionPanel(label, comboBox);
    }

    private JPanel createSectionPanel(String label, JComboBox<String> comboBox) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(comboBox);
        return panel;
    }

    public void cleadCbo() {
        for (Staff i : StaffList.getAll())
            cboSearchByID.removeItem(i);
    }

    @SuppressWarnings("unchecked")
    public void loadCbo() {
    	cboModel = new DefaultComboBoxModel();
        for (Staff i : StaffList.getAll())
            cboModel.addElement(i.getStaffID());
        
        // Check if cboSearchByID is not null before setting model
        if (cboSearchByID != null) {
            cboSearchByID.setModel(cboModel);
        } else {
            System.err.println("ComboBox cboSearchByID is null.");
        }
    }

    public void loadDataToTable(ArrayList<Staff> lst, DefaultTableModel tblModel) {
        for (Staff i : lst) {
            Object[] obj = { i.getStaffID(), i.getStaffName(), i.getStaffPhone(), i.getStaffEmail(),
                    i.getStaffAddress(), i.getStaffPosition(), i.getStaffStatus() };
            tblModel.addRow(obj);
        }
    }

    public void clearText() {

    }

    public Staff taoStaff() {
        // String ma, tua, tacgia, nxb, ibs;
        // double dongia;
        // int nam;
        // ma = txtMa.getText();
        // tua = txtTua.getText();
        // tacgia = txtTacGia.getText();
        // nxb = txtNhaXuatBan.getText();
        // ibs = txtISBN.getText();
        // dongia = Double.parseDouble(txtDonGia.getText());
        // nam = Integer.parseInt(txtNam.getText());
        // int soTrang = Integer.parseInt(txtSoTrang.getText());
        Staff a = new Staff();
        return a;
    }

    public void StaffToTextBox(Staff item) {
        // txtMa.setText(item.getMaS());
        // txtTua.setText(item.getTuaStaff());
        // txtTacGia.setText(item.getTacGia());
        // txtNhaXuatBan.setText(item.getNxb());
        // txtNam.setText(item.getNamXB() + "");
        // txtISBN.setText(item.getIsbn());
        // txtSoTrang.setText(item.getPage() + "");
        // txtDonGia.setText(item.getDonGia() + "");
    }

    public boolean kiemTraTextBox() {
        if (txtID.getText().isEmpty() || txtName.getText().isEmpty() || txtDiaChi.getText().isEmpty()
                || txtYear.getText().isEmpty() || txtIDCard.getText().isEmpty() || txtPhoneNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn phải nhập đầy đủ thông tin!");
            return false;
        } else {
            String thongBao = "";
            // Mã sách
            char ch = txtName.getText().charAt(0);
            String patternStrMa = "^" + ch + "[0-9]{3}$";
            Pattern patternMa = Pattern.compile(patternStrMa, Pattern.CASE_INSENSITIVE);
            Matcher matchMa = patternMa.matcher(txtID.getText());
            Boolean matchFoundMa = matchMa.matches();

            // Tựa sách & Tác giả
            // Java
            String patternStrTen = "^([A-Z][a-z]+\\s?)+";
            Pattern patternTen = Pattern.compile(patternStrTen);
            Matcher matchTen = patternTen.matcher(txtName.getText());
            Boolean matchFoundTua = matchTen.matches();
            Matcher matchTacGia = patternTen.matcher(txtDiaChi.getText());
            Boolean matchFoundTacGia = matchTacGia.matches();

            // ISBN
            // 16666-444-333-888
            String patternStrISBN = "^(\\d+-){3}\\d+(-\\d+)?$";
            Pattern patternISBN = Pattern.compile(patternStrISBN);
            Matcher matchISBN = patternISBN.matcher(txtPhoneNumber.getText());
            Boolean matchFoundISBN = matchISBN.matches();

            if (!matchFoundMa)
                thongBao += "Mã sách phải có ký tự đầu là ký tự đầu của tựa sách, theo sau là 3 ký số!";
            if (!matchFoundTua)
                thongBao += "\nTựa sách gồm nhiều từ ngăn cách bởi khoảng trắng. Không chứa ký số hoặc các ký tự đặc biệt khác, ngoại trừ ký tự '.'!";
            if (!matchFoundTacGia)
                thongBao += "\nTác giả gồm nhiều từ ngăn cách bởi khoảng trắng. Không chứa ký số hoặc các ký tự đặc biệt khác, ngoại trừ ký tự '.'!";
            if (!matchFoundISBN)
                thongBao += "\nISBN có mẫu dạng X-X-X-X (hoặc X-X-X-X-X). Trong đó, X gồm các ký số, ít nhất là 1 ký số!";
            if (thongBao.isEmpty())// không có lỗi
                return true;
            else {
                JOptionPane.showMessageDialog(null, thongBao);
                return false;
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object obj = e.getSource();
        if (obj.equals(btnAdd)) {
            if (kiemTraTextBox()) {
                Staff a = taoStaff();
                if (lstStaff.getAll().contains(a))
                    JOptionPane.showMessageDialog(null, "Mã sách không được trùng!!!");
                else {
                    lstStaff.addStaff(a);
                    Object[] ob = {};
                    tblModelStaff.addRow(ob);
                    loadCbo();
                }
            }

        } else if (obj.equals(btnClear)) {
            clearText();

        } else if (obj.equals(btnSave)) {
            if (lstStaff.getAll().size() < 0)
                JOptionPane.showMessageDialog(null, "Không có dữ liệu để lưu!!!!");
            try {
                // new FileData().luuDuLieuStaff("src/data/DuLieu.txt", lstStaff);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } else if (obj.equals(btnModify)) {
            int select = tblStaff.getSelectedRow();
            if (select > 0) {
                if (kiemTraTextBox()) {
                    int hoi = JOptionPane.showConfirmDialog(null, "Ban co muon sua khong? ", "ThongBao",
                            JOptionPane.YES_NO_OPTION);
                    if (hoi == JOptionPane.YES_OPTION) {
                        Staff a = taoStaff();
                        lstStaff.updateStaff(a);
                        tblStaff.setModel(tblModelStaff = new DefaultTableModel(col, 0));
                        loadDataToTable(lstStaff.getAll(), tblModelStaff);
                    }
                }

            }
        } else if (obj.equals(btnDelete)) {
            int select = tblStaff.getSelectedRow();
            if (select >= 0 && select < lstStaff.getAll().size()) {
                int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Thông Báo",
                        JOptionPane.YES_NO_OPTION);
                if (hoi == JOptionPane.YES_OPTION) {
                    Staff a = lstStaff.getAll().get(select);
                    lstStaff.deleteStaff(a);
                    tblModelStaff.removeRow(select);
                    loadCbo();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn cuốn sách để xóa");

            }
        } else if (e.getSource().equals(cboSearchByID)) {
            String chon = (String) cboSearchByID.getSelectedItem();
            Staff a = lstStaff.searchId(chon);
            tblStaff.setModel(tblModelStaff = new DefaultTableModel(col, 0));
            Object[] ob = {};
            tblModelStaff.addRow(ob);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        int select = tblStaff.getSelectedRow();
        if (select >= 0) {
            StaffToTextBox(lstStaff.getAll().get(select));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    // Test demo
    public static void main(String[] args) {
        new frm_NhanVien().setVisible(true);
    }

}