/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osypkg;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.NORMAL;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.EventObject;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author another
 */
public class AutoTestingAdminNB extends javax.swing.JFrame {

   static void SetjTextArea(String str) {
       
       
    // new CheckBoxNode().setTexttextbox("testing");
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JTree jTree;
    private HashMap<Object, Object> HashMaplist;
    /*private String ips[] = {"10.23.110.26", "172.16.121.20", "172.16.121.3",
        "172.16.121.21", "172.16.121.22", "172.16.121.23", "172.16.121.24",
        "10.23.90.249"};*/

    private String ips[] = {"https://www.clickandgo.com/", "https://goand.click", "https://travelsmartsystems.com"};
    String CustomerName;
    boolean ChkLinuxVm = false;
    boolean ChkWindowsVm = false;
    int Linuxvms = 0;
    int Windowsvms = 0;

    CheckBoxNode PCDAdminVectorOptions[] = {
        new CheckBoxNode("travelsmartsystems", false),
        new CheckBoxNode("", false),
        new CheckBoxNode("", false)

    };
    CheckBoxNode PartnerPortalOptions[] = {
        new CheckBoxNode("Clickandgo.com home page", false),
        new CheckBoxNode("Special offers", false),
        new CheckBoxNode("Sun", false),
        new CheckBoxNode("City Breaks From Ireland", false),
        new CheckBoxNode("1-euro-deposit-holidays", false),
        new CheckBoxNode("Account login", false),
        new CheckBoxNode("Destinations", false)

    };
    private Component frame;

    /**
     * Creates new form NewApplication
     */
    public AutoTestingAdminNB() {
        super();
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
        setMinimumSize(new Dimension(500, 300));
        setBounds(400, 200, 518, 380);
        setTitle("Test Execuation Path Admin");
        Vector<?> PCDAdminVector = new NamedVector(" Travelsmartsystems Portal", PCDAdminVectorOptions);
        Vector<?> PartnerPortalVector = new NamedVector("Clickandgo.com", PartnerPortalOptions);
        Object rootNodes[] = {PCDAdminVector, PartnerPortalVector};
        Vector<?> rootVector = new NamedVector("PCD", rootNodes);
        CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
        HashMaplist = new HashMap<Object, Object>();

//        DefaultMutableTreeNode TreeNode=new DefaultMutableTreeNode(rootVector) ;
//        DefaultTreeModel    tree = new DefaultTreeModel(TreeNode);
        PartnerPortalOptions[0].setSelected(false);
        jTree = new JTree(rootVector);
        jTree.putClientProperty("JTree.lineStyle", "None");
        jTree.setCellRenderer(renderer);
        jTree.setCellEditor(new CheckBoxNodeEditor(jTree));
        jTree.setEditable(true);

        initComponents();

        jTree1.setCellRenderer(renderer);
        jTree1.setCellEditor(new CheckBoxNodeEditor(jTree1));
        jTree1.setEditable(true);
        jScrollPane1.setViewportView(jTree1);

        jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
        //jTree1.getModel().addTreeModelListener(new MyTreeModelListener());
        //jTree1.setShowsRootHandles(true);
        jComboBox1.setModel(new DefaultComboBoxModel(ips));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextArea1InputMethodTextChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 550, 310));

        jToggleButton1.setText("Always on Top");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setName(""); // NOI18N
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 200, -1));

        jButton1.setText("Start Testing");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jTree1.setModel(jTree.getModel());
        jTree1.setRootVisible(false);
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

       public String  methodOne(){
        System.out.println("we are in first methodOne");
        return "";
    }
    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (getExtendedState() != NORMAL) {
            int w = getWidth();
            int h = getHeight();
            setPreferredSize(new Dimension(w, h));
            jToggleButton1.setLocation(getContentPane().getWidth() - 120, 1);
            /*scrollPane.setBounds(198, 72,
								getContentPane().getWidth() - 200, getContentPane()
								.getHeight() - 75);*/
            // lblTestmachineIP.setBounds(161,
            // 14,getContentPane().getWidth() -
            // 300,getContentPane().getHeight() -250);
            // pack();
        } else {
            setExtendedState(NORMAL);
            int w = getWidth();
            int h = getHeight();
            setPreferredSize(new Dimension(w, h));
            jToggleButton1.setLocation(getContentPane().getWidth() - 120, 1);
            /*scrollPane.setBounds(198, 72,
								getContentPane().getWidth() - 200, getContentPane()
								.getHeight() - 75);*/
            // lblTestmachineIP.setBounds(161,
            // 14,getContentPane().getWidth() -
            // 300,getContentPane().getHeight() -250);
            // pack();
        }

    }//GEN-LAST:event_formComponentResized

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked

        if (jToggleButton1.isSelected()) {
            setAlwaysOnTop(true);
            jToggleButton1.setForeground(Color.red);
        } else {
            jToggleButton1.setForeground(Color.blue);
            setAlwaysOnTop(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked


    }//GEN-LAST:event_jTree1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        final LoginConfigegenpcd PCDlogin = new LoginConfigegenpcd();

        if (PCDlogin.getTestingStatus() == true) {

            //JOptionPane.showMessageDialog(frame,"Testing in progress");
        }

        JFrame myFrame = null;
        JCheckBox checkboxLinux = new JCheckBox("Linux vm");
        JCheckBox checkboxWindows = new JCheckBox("Windows vm");
            
        JSpinner spinnerLinux = new JSpinner();
        JSpinner spinnerWindows = new JSpinner();
        spinnerLinux.setValue(new Integer(0));
        spinnerWindows.setValue(new Integer(0));
        
        
        JSpinner spinnerNights = new JSpinner();
        spinnerNights.setValue(new Integer(7));
                
        JSpinner spinnerAdults = new JSpinner();
        spinnerAdults.setValue(new Integer(1));
        
        JSpinner spinnerChildren = new JSpinner();
        spinnerChildren.setValue(new Integer(0));
                
        JSpinner spinnerInfants = new JSpinner();
        spinnerInfants.setValue(new Integer(0));
                
        JPanel JPanel = new JPanel();
        JPanel.setLayout(new FlowLayout());
        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
                
        JPanel JPanel1 = new JPanel();
        JPanel1.setLayout(new FlowLayout());
        
        JPanel1.add(spinnerNights);
        JPanel.add(picker);
        JPanel.add(spinnerAdults);
        JPanel.add(spinnerChildren);
        JPanel.add(spinnerInfants);
                
        //JPanel1.add(spinnerWindows);
        JPanel JPanel2 = new JPanel();
        JPanel2.add(JPanel);
        JPanel2.add(JPanel1);
                        
        boolean Canceled = false;

        if ((HashMaplist.isEmpty()) && PCDlogin.getTestingStatus() == false && Canceled == false) {

            JOptionPane.showMessageDialog(frame,"Please select testing path(s).");

        }

        while ((!HashMaplist.isEmpty()) && PCDlogin.getTestingStatus() == false && Canceled == false) {

            int choice;

            final Object[] options = {"Yes, please", "No way!"};
            choice = JOptionPane.showOptionDialog(frame, "You've selected below testing path(s):\n" + HashMaplist.toString() + "\n                proceed now?",
                    "Question", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options,
                    options[0]);

            if (choice == 1) {
                int r = JOptionPane.showOptionDialog(
                        frame,
                        "Modify selected testing path(s)?\n"
                        + HashMaplist.toString(), "Question",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        options,
                        options[0]);
                if (r == 1) {

                    JOptionPane.showMessageDialog(frame,
                            "Canceled.");
                    break;
                }
            }

            if (choice == 0) {

                for (Map.Entry<Object, Object> e : HashMaplist.entrySet()) {
                    //Object value1 = e.getKey();
                    Object value2 = e.getValue();

                    if (value2.toString().contentEquals("5")) {
                        Object[] param = {"You've selected: Abu Dhabi, Arabian Gulf Destination", JPanel2, null};
                        choice = JOptionPane.showConfirmDialog(myFrame, param, "Select vm types to build",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE);

                        if (choice == 0) {

                            ChkLinuxVm = checkboxLinux.isSelected();
                            ChkWindowsVm = checkboxWindows.isSelected();

                            while (true) {

                                if ((!checkboxLinux.isSelected()) && (!checkboxWindows.isSelected())) {
                                    Object[] param1 = {"Select vm types to build", JPanel2, null};
                                    choice = JOptionPane.showConfirmDialog(myFrame, param1, "Select vm types to build",
                                            JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.INFORMATION_MESSAGE);

                                }

                                if (checkboxLinux.isSelected() || checkboxWindows.isSelected()) {
                                    Linuxvms = (Integer) spinnerLinux.getValue();
                                    Windowsvms = (Integer) spinnerWindows.getValue();
                                    if (((Integer) spinnerLinux.getValue() == 0 && (Integer) spinnerWindows.getValue() == 0)) {
                                        Object[] param1 = {"Select number of vm(s) to build", JPanel2, null};
                                        choice = JOptionPane.showConfirmDialog(myFrame, param1, "Select number of vm(s) to build",
                                                JOptionPane.OK_CANCEL_OPTION,
                                                JOptionPane.INFORMATION_MESSAGE);

                                    }

                                    if (checkboxLinux.isSelected() || checkboxWindows.isSelected()) {
                                        Linuxvms = (Integer) spinnerLinux.getValue();
                                        Windowsvms = (Integer) spinnerWindows.getValue();
                                        if (((Integer) spinnerLinux.getValue() != 0 || (Integer) spinnerWindows.getValue() != 0)) {
                                            ChkLinuxVm = checkboxLinux.isSelected();
                                            ChkWindowsVm = checkboxWindows.isSelected();
                                            Canceled = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        if (choice == 2) {

                            JOptionPane.showMessageDialog(frame,
                                    "Canceled");
                            Canceled = true;
                            break;

                        }
                    }

                    if (value2.toString().contentEquals("2")) {
                        Object[] param1 = {"You've selected: Clickandgo.com home page, select \n\n   "
                                + "     Departure Date         Nights   Adults  Children  & Infants", JPanel2, null};
                        int choice1 = JOptionPane.showConfirmDialog(myFrame, param1, "Select holiday data",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE);

                        if (choice1 == 0) {

                            ChkLinuxVm = checkboxLinux.isSelected();
                            ChkWindowsVm = checkboxWindows.isSelected();

                            if (!(checkboxLinux.isSelected()) && (checkboxWindows.isSelected())) {
                                choice1 = JOptionPane.showConfirmDialog(myFrame, param1, "Select vm types to build",
                                        JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE);

                            }

                            if (checkboxLinux.isSelected() || checkboxWindows.isSelected()) {
                                Linuxvms = (Integer) spinnerLinux.getValue();
                                Windowsvms = (Integer) spinnerWindows.getValue();
                            }

                            if (((Integer) spinnerLinux.getValue() == 0 && (Integer) spinnerWindows.getValue() == 0)) {
                                choice1 = JOptionPane.showConfirmDialog(myFrame, param1, "Select number of vm(s) to build",
                                        JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE);

                            }

                            if (choice1 == 2) {
                                choice1 = JOptionPane.showConfirmDialog(myFrame, param1, "Canceling",
                                        JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            } else {
                                ChkLinuxVm = checkboxLinux.isSelected();
                                ChkWindowsVm = checkboxWindows.isSelected();
                            }

                            int messageType = JOptionPane.INFORMATION_MESSAGE;
                            Component myFrame1 = null;
                            CustomerName = JOptionPane.showInputDialog(myFrame1,
                                    "You've selected: Building a new VmWare environment for an exsiting customer,please provide custmer name",
                                    "Input custmer name", messageType);

                            if (CustomerName != null || (!CustomerName.isEmpty())) {

                                //JCheckBox checkboxLinux = new JCheckBox("Linux vms");
                                //JCheckBox checkboxWindows = new JCheckBox("Windows vms");
                                Object[] params = {checkboxLinux, checkboxWindows};
                                int vmType = JOptionPane.showConfirmDialog(myFrame1, params, "Select vm types to build", JOptionPane.OK_CANCEL_OPTION);
                                if (vmType == 0) {
                                    ChkLinuxVm = checkboxLinux.isSelected();
                                    ChkWindowsVm = checkboxLinux.isSelected();
                                }

                                if (CustomerName == null) {

                                    CustomerName = JOptionPane.showInputDialog(myFrame1,
                                            "You've selected: Building a new VmWare environment for an exsiting customer,please provide custmer name",
                                            "Input custmer name", messageType);

                                    if (CustomerName != null || (!CustomerName.isEmpty())) {

                                        vmType = JOptionPane.showConfirmDialog(myFrame1, params, "Select vm types to build", JOptionPane.OK_CANCEL_OPTION);
                                        if (vmType == 0) {
                                            ChkLinuxVm = checkboxLinux.isSelected();
                                            ChkWindowsVm = checkboxLinux.isSelected();
                                        }
                                    }

                                }
                                //}
                            }
                        }
                    }

                    if (choice == 1) {
                        int r = JOptionPane.showOptionDialog(
                                frame,
                                "Modify selected testing path(s)?\n"
                                + HashMaplist.toString(), "Question",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, // do not
                                // use a
                                options, // the titles of buttons
                                options[0]); // default button title

                        if (r == 1) {
                            /*a = JOptionPane.showConfirmDialog(myFrame,param,"Canceling",
										 JOptionPane.OK_CANCEL_OPTION, 
									     JOptionPane.INFORMATION_MESSAGE);*/
                            JOptionPane.showMessageDialog(frame,
                                    "Testing Canceled.");
                            //HashMaplist.clear();
                            /*TreeNode selected;
										for (int i = 0; i < tree.getRowCount(); i++) {
											//if (tree.getSelectionPaths()[i].toString().contains("false")) {
											// selected = (TreeNode) tree.getSelectionPaths()[i].getLastPathComponent();
											//tree.clearSelection();
											tree.clearSelection();
                             */
                            //}
                            break;
                        } else if ((HashMaplist.size() == 0)) {
                            //tree.clearSelection();
                            JOptionPane.showMessageDialog(frame,
                                    "Please select testing path(s).");
                        }
                    }
                }

                if (HashMaplist.size() != 0 && Canceled == false) {

                    Thread SeleniumSikuliPCDThread = new Thread() {
                        @Override
                        public void run() {

                            //System.setProperty("netbeans.security.nocheck", "true");
                            //LoginConfig PCDlogin = new LoginConfig();
                            String list = null;

                            for (Map.Entry<Object, Object> e : HashMaplist.entrySet()) {
                                //Object value1 = e.getKey();
                                //Object value2 = e.getValue();
                                list = e.getValue().toString();

                            }

                            PCDlogin.setTestCase(list.toString());
                            String ip = jComboBox1.getSelectedItem().toString();
                            PCDlogin.setTestMachineIP(ip);
                            if (CustomerName == null) {
                                CustomerName = "";
                            }
                            PCDlogin.setCustmerName(CustomerName);
                            //PCDlogin.setVmType(ChkLinuxVm,ChkWindowsVm);
                            PCDlogin.setVmNumber(Linuxvms, Windowsvms);

                            try {
                                PCDlogin.start();
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    };

                    SeleniumSikuliPCDThread.start();

                    while (!SeleniumSikuliPCDThread.isAlive()) {
                        // Thread.sleep(100);
                        System.out.println("Thread is stopped.");
                    }
                    System.out.println("Thread is started.");
                    PCDlogin.setTestingStatus(true);
                    jTextArea1.append("Thread is started.");
                    //HashMaplist.clear();
                    //break;
                }
            }
        }


    }//GEN-LAST:event_jButton1MouseClicked


    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
//          TreePath parent = evt.getPath();
//           
//          DefaultMutableTreeNode node = (DefaultMutableTreeNode)parent.getLastPathComponent();
//           int cnt=   jTree1.getModel().getChildCount(node);
//          System.out.println("The user has finished editing the node.");
//        System.out.println("New value: " + node.getUserObject());
//        
//         Object nodeInfo = node.getUserObject();
//
//         
//           System.out.println(nodeInfo);
//           
//           
//        if (jTree1.getSelectionPaths() != null) {
//            
//            System.out.println("You selected "+jTree1.getSelectionPaths()[0].toString());
//            System.out.println("You selected "+ jTree1.getLeadSelectionRow());
//            TreePath[] paths = evt.getPaths();
//            		for (int i=0; i<paths.length; i++) {
//			if (evt.isAddedPath(i)) {
//				// This node has been selected
//				System.out.println(paths[i].getLastPathComponent().toString());
//				break;
//			} else {
//				// This node has been deselected
//				break;
//			}
//		}
        if (jTree1.getSelectionPaths()[0].toString().contains("false")) {

            String[] s = jTree1.getSelectionPaths()[0].toString().split(",");
            String[] s1 = s[2].split("osypkg.AutoTestingAdminNB$CheckBoxNode");
            String[] s0 = s1[0].split("osypkg.AutoTestingAdminNB$CheckBoxNode");
            String[] s3 = s1[0].split("/false]]");
            String s4 = s3[0].replace("[", ",");
            String[] s5 = s4.split(",");
            HashMaplist.put(s5[1], jTree1.getMinSelectionRow());

//         HashMaplist.put(jTree1.getSelectionPaths()[0].toString().split(",").toString().split("osypkg.AutoTestingAdminNB$CheckBoxNode")[2].split("/false]]")[0].trim()
//                .replace("[", ",").toString().split(",").toString(), jTree1.getLeadSelectionRow());
            System.out.println("HashMaplist-added: " + HashMaplist.toString());

        }

        if (jTree1.getSelectionPaths()[0].toString().contains("true")) {
            for (Map.Entry<Object, Object> e : HashMaplist.entrySet()) {
                Object value1 = e.getKey();
                //Object value2 = e.getValue();
                // Set<Entry<Object,Object>> Entry
                // =HashMaplist.entrySet();

                //System.out.println("HashMaplist value1 :" + value1);
                //System.out.println("HashMaplist value2 :" + value2);
                String str = jTree1.getSelectionPaths()[0].toString()
                        .split("osypkg.CheckBoxNode")[1]
                        .split("/true]]")[0].trim().toString()
                        .replace("[", "");
                System.out.println("str " + str);
                if ((value1.equals(str))) {
                    HashMaplist.remove(value1);
                }

            }
            //System.out.println("HashMaplist now" + HashMaplist);
        }

    }//GEN-LAST:event_jTree1ValueChanged

    private void jTextArea1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextArea1InputMethodTextChanged
    
        jTextArea1.append(CustomerName);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1InputMethodTextChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AutoTestingAdminNB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutoTestingAdminNB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutoTestingAdminNB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoTestingAdminNB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                new AutoTestingAdminNB().setVisible(true);
                AutoTestingAdminNB.setDefaultLookAndFeelDecorated(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

    class CheckBoxNodeRenderer implements TreeCellRenderer {

        private JCheckBox leafRenderer = new JCheckBox();
        private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();
        private Color selectionBorderColor, selectionForeground,
                selectionBackground, textForeground, textBackground;

        protected JCheckBox getLeafRenderer() {
            return leafRenderer;
        }

        public CheckBoxNodeRenderer() {
            Font fontValue;
            fontValue = UIManager.getFont("Tree.font");
            if (fontValue != null) {
                leafRenderer.setFont(fontValue);
            }
            Boolean booleanValue = (Boolean) UIManager.get("Tree.drawsFocusBorderAroundIcon");
            leafRenderer.setFocusPainted((booleanValue != null)
                    && (booleanValue.booleanValue()));
            selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
            selectionForeground = UIManager.getColor("Tree.selectionForeground");
            selectionBackground = UIManager.getColor("Tree.selectionBackground");
            textForeground = UIManager.getColor("Tree.textForeground");
            textBackground = UIManager.getColor("Tree.textBackground");
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value,
                boolean selected, boolean expanded, boolean leaf, int row,
                boolean hasFocus) {
            Component returnValue;
            if (leaf) {
                String stringValue = tree.convertValueToText(value, selected,
                        expanded, leaf, row, false);
                leafRenderer.setText(stringValue);
                leafRenderer.setSelected(false);
                leafRenderer.setEnabled(tree.isEnabled());
                if (selected) {
                    leafRenderer.setForeground(selectionForeground);
                    leafRenderer.setBackground(selectionBackground);
                } else {
                    leafRenderer.setForeground(textForeground);
                    leafRenderer.setBackground(textBackground);
                }
                if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
                    Object userObject = ((DefaultMutableTreeNode) value)
                            .getUserObject();
                    if (userObject instanceof CheckBoxNode) {
                        CheckBoxNode node = (CheckBoxNode) userObject;
                        leafRenderer.setText(node.getText());
                        leafRenderer.setSelected(node.isSelected());
                    }
                }
                returnValue = leafRenderer;
            } else {
                returnValue = nonLeafRenderer.getTreeCellRendererComponent(tree,
                        value, selected, expanded, leaf, row, hasFocus);
            }
            return returnValue;
        }
    }

    class CheckBoxNodeEditor extends AbstractCellEditor implements TreeCellEditor {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
        //private ChangeEvent changeEvent = null;
        private JTree tree;

        public CheckBoxNodeEditor(JTree tree) {
            this.tree = tree;
        }

        public Object getCellEditorValue() {
            JCheckBox checkbox = renderer.getLeafRenderer();
            CheckBoxNode checkBoxNode = new CheckBoxNode(checkbox.getText(),
                    checkbox.isSelected());
            return checkBoxNode;
        }

        @Override
        public boolean isCellEditable(EventObject event) {
            boolean returnValue = false;
            if (event instanceof MouseEvent) {
                MouseEvent mouseEvent = (MouseEvent) event;
                TreePath path = tree.getPathForLocation(mouseEvent.getX(),
                        mouseEvent.getY());
                if (path != null) {
                    Object node = path.getLastPathComponent();
                    if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
                        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
                        Object userObject = treeNode.getUserObject();
                        returnValue = ((treeNode.isLeaf()) && (userObject instanceof CheckBoxNode));
                    }
                }
            }
            return returnValue;
        }

        public Component getTreeCellEditorComponent(JTree tree, Object value,
                boolean selected, boolean expanded, boolean leaf, int row) {
            Component editor = renderer.getTreeCellRendererComponent(tree, value,
                    true, expanded, leaf, row, true);
            // editor always selected / focused
            ItemListener itemListener = new ItemListener() {

                public void itemStateChanged(ItemEvent itemEvent) {
                    if (stopCellEditing()) {
                        fireEditingStopped();
                    }
                }
            };
            if (editor instanceof JCheckBox) {
                ((JCheckBox) editor).addItemListener(itemListener);
            }
            return editor;
        }
    }

   static class CheckBoxNode {

        private String text;
        private boolean selected;
      
       public CheckBoxNode(String text, boolean selected) {
            this.text = text;
            this.selected = selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean newValue) {
            selected = newValue;
        }

        public String getText() {
            return text;
        }

        public void setText(String newValue) {
            text = newValue;
        }
                      
        @Override
        public String toString() {
            return getClass().getName() + "[" + text + "/" + selected + "]";
        }
    }

    class MyTreeModelListener implements TreeModelListener {

        public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

            /*
         * If the event lists children, then the changed
         * node is the child of the node we have already
         * gotten.  Otherwise, the changed node and the
         * specified node are the same.
             */
            try {
                int index = e.getChildIndices()[0];
                node = (DefaultMutableTreeNode) (node.getChildAt(index));
            } catch (NullPointerException exc) {
            }

            System.out.println("The user has finished editing the node.");
            System.out.println("New value: " + node.getUserObject());
        }

        @Override

        public void treeNodesInserted(TreeModelEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void treeNodesRemoved(TreeModelEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void treeStructureChanged(TreeModelEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    class NamedVector extends Vector {

        private String name;

        public NamedVector(String name) {
            this.name = name;
        }

        public NamedVector(String name, Object elements[]) {
            this.name = name;
            for (int i = 0, n = elements.length; i < n; i++) {
                add(elements[i]);
            }
        }

        public String toString() {
            return "[" + name + "]";
        }

     }
       public void setMessagesArea(String messagesArea) {

	      this.jTextArea1.setText(messagesArea);
       
       }
    
}
