import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class CalcForm extends javax.swing.JFrame {

    /**
     * Creates new form CalcForm
     */
    public CalcForm() {
        initComponents();
    }

    private void initComponents() {
        //Calc button
        JPanel PanelLayar = new JPanel();
        JPanel MainPanel = new JPanel();
        ModeButton ModeButton = new ModeButton();
        JLabel Layar = new JLabel();
        NumButton DotButton = new NumButton(".");//TODO
        DelAllButton EvaluateButton = new DelAllButton("=");//TODO
        Del1Button DelButton = new Del1Button("del");
        //Memory Button
        MemoryButton ClearButton = new MemoryButton("AC");
        MemoryButton MCButton = new MemoryButton("MC");
        MemoryButton AnsButton = new MemoryButton("ans");
        MemoryButton MRButton = new MemoryButton("MR");
        //Num Button
        NumButton Num00 = new NumButton("00");
        NumButton Num0 = new NumButton("0");
        NumButton Num1 = new NumButton("1");
        NumButton Num2 = new NumButton("2");
        NumButton Num3 = new NumButton("3");
        NumButton Num4 = new NumButton("4");
        NumButton Num5 = new NumButton("5");
        NumButton Num6 = new NumButton("6");
        NumButton Num7 = new NumButton("7");
        NumButton Num8 = new NumButton("8");
        NumButton Num9 = new NumButton("9");
        //Operand Button
        BinaryOpsButton MulButton = new BinaryOpsButton("x");
        BinaryOpsButton DivButton = new BinaryOpsButton(":");
        BinaryOpsButton NegButton = new BinaryOpsButton("-");
        BinaryOpsButton PlusButton = new BinaryOpsButton("+");
        BinaryOpsButton ModButton = new BinaryOpsButton("%");
        UnaryOpsButton CosButton = new UnaryOpsButton("cos");
        UnaryOpsButton TanButton = new UnaryOpsButton("tan");
        UnaryOpsButton LBracketButton = new UnaryOpsButton("(");
        UnaryOpsButton RBracketButton = new UnaryOpsButton(")");
        UnaryOpsButton SqrtButton = new UnaryOpsButton("sqrt");
        UnaryOpsButton SquareButton = new UnaryOpsButton("<html>x<sup>2</sup></html>");        
        UnaryOpsButton PowerButton = new UnaryOpsButton("<html>x<sup>y</sup></html>");
        UnaryOpsButton Sin1Button = new UnaryOpsButton("<html>sin<sup>-1</sup></html>");
        UnaryOpsButton Cos1Button = new UnaryOpsButton("<html>cos<sup>-1</sup></html>");
        UnaryOpsButton Tan1Button = new UnaryOpsButton("<html>tan<sup>-1</sup></html>");
        UnaryOpsButton SinButton = new UnaryOpsButton("sin");
        UnaryOpsButton LogButton = new UnaryOpsButton("log");
        UnaryOpsButton LnButton = new UnaryOpsButton("ln");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        MainPanel.setBackground(new java.awt.Color(51, 51, 51));
        MainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MainPanel.setPreferredSize(new java.awt.Dimension(348, 452));
        
        ModeButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        ModeButton.setForeground(new java.awt.Color(255, 255, 255));
        ModeButton.setSelected(true);
        ModeButton.setText("Scientific");
        ModeButton.setToolTipText("");
        ModeButton.setContentAreaFilled(false);
        ModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ModeButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        ModeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Button[] B ={Num00, ModButton, RBracketButton, LBracketButton, LogButton, LnButton, SqrtButton, Sin1Button, Cos1Button, Tan1Button, SinButton, CosButton, TanButton, SquareButton, PowerButton};
                ModeButton.onClick(B, Layar, MainPanel);
            }
        });

        ClearButton.setBackground(new java.awt.Color(102, 102, 102));
        ClearButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        ClearButton.setForeground(new java.awt.Color(255, 255, 255));
        ClearButton.setBorderPainted(false);
        ClearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //TODO
            }
        });

        MCButton.setBackground(new java.awt.Color(0, 153, 255));
        MCButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        MCButton.setForeground(new java.awt.Color(255, 255, 255));
        MCButton.setToolTipText("");
        MCButton.setBorderPainted(false);
        MCButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MCButton.onClick(evt, Layar);
            }
        });

        MRButton.setBackground(new java.awt.Color(0, 153, 255));
        MRButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        MRButton.setForeground(new java.awt.Color(255, 255, 255));
        MRButton.setToolTipText("");
        MRButton.setBorderPainted(false);
        MRButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MRButton.onClick(evt, Layar);
            }
        });

        MulButton.setBackground(new java.awt.Color(0, 51, 153));
        MulButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        MulButton.setForeground(new java.awt.Color(255, 255, 255));
        MulButton.setToolTipText("");
        MulButton.setBorderPainted(false);
        MulButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MulButton.onClick(evt, Layar);
            }
        });

        Num7.setBackground(new java.awt.Color(51, 51, 51));
        Num7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num7.setForeground(new java.awt.Color(255, 255, 255));
        Num7.setToolTipText("");
        Num7.setBorderPainted(false);
        Num7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num7.onClick(evt, Layar);
            }
        });

        Num8.setBackground(new java.awt.Color(51, 51, 51));
        Num8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num8.setForeground(new java.awt.Color(255, 255, 255));
        Num8.setToolTipText("");
        Num8.setBorderPainted(false);
        Num8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num8.onClick(evt, Layar);
            }
        });

        Num9.setBackground(new java.awt.Color(51, 51, 51));
        Num9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num9.setForeground(new java.awt.Color(255, 255, 255));
        Num9.setToolTipText("");
        Num9.setBorderPainted(false);
        Num9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num9.onClick(evt, Layar);
            }
        });

        DivButton.setBackground(new java.awt.Color(0, 51, 153));
        DivButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        DivButton.setForeground(new java.awt.Color(255, 255, 255));
        DivButton.setToolTipText("");
        DivButton.setBorderPainted(false);
        DivButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DivButton.onClick(evt, Layar);
            }
        });

        Num4.setBackground(new java.awt.Color(51, 51, 51));
        Num4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num4.setForeground(new java.awt.Color(255, 255, 255));
        Num4.setBorderPainted(false);
        Num4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num4.onClick(evt, Layar);
            }
        });

        Num5.setBackground(new java.awt.Color(51, 51, 51));
        Num5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num5.setForeground(new java.awt.Color(255, 255, 255));
        Num5.setBorderPainted(false);
        Num5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num5.onClick(evt, Layar);
            }
        });

        Num6.setBackground(new java.awt.Color(51, 51, 51));
        Num6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num6.setForeground(new java.awt.Color(255, 255, 255));
        Num6.setBorderPainted(false);
        Num6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num6.onClick(evt, Layar);
            }
        });

        NegButton.setBackground(new java.awt.Color(0, 51, 153));
        NegButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        NegButton.setForeground(new java.awt.Color(255, 255, 255));
        NegButton.setToolTipText("");
        NegButton.setBorderPainted(false);
        NegButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NegButton.onClick(evt, Layar);
            }
        });

        Num1.setBackground(new java.awt.Color(51, 51, 51));
        Num1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num1.setForeground(new java.awt.Color(255, 255, 255));
        Num1.setBorderPainted(false);
        Num1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num1.onClick(evt, Layar);
            }
        });

        Num2.setBackground(new java.awt.Color(51, 51, 51));
        Num2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num2.setForeground(new java.awt.Color(255, 255, 255));
        Num2.setBorderPainted(false);
        Num2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num2.onClick(evt, Layar);
            }
        });

        Num3.setBackground(new java.awt.Color(51, 51, 51));
        Num3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        Num3.setForeground(new java.awt.Color(255, 255, 255));
        Num3.setBorderPainted(false);
        Num3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num3.onClick(evt, Layar);
            }
        });

        PlusButton.setBackground(new java.awt.Color(0, 51, 153));
        PlusButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        PlusButton.setForeground(new java.awt.Color(255, 255, 255));
        PlusButton.setText("+");
        PlusButton.setToolTipText("");
        PlusButton.setBorderPainted(false);
        PlusButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PlusButton.onClick(evt, Layar);
            }
        });

        DotButton.setBackground(new java.awt.Color(51, 51, 51));
        DotButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        DotButton.setForeground(new java.awt.Color(255, 255, 255));
        DotButton.setBorderPainted(false);
        DotButton.setPreferredSize(new java.awt.Dimension(39, 29));
        DotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DotButton.onClick(evt, Layar);
            }
        });

        Num0.setBackground(new java.awt.Color(51, 51, 51));
        Num0.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num0.setForeground(new java.awt.Color(255, 255, 255));
        Num0.setBorderPainted(false);
        Num0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num0.onClick(evt, Layar);
            }
        });

        EvaluateButton.setBackground(new java.awt.Color(255, 102, 0));
        EvaluateButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        EvaluateButton.setForeground(new java.awt.Color(255, 255, 255));
        EvaluateButton.setBorderPainted(false);
        EvaluateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EvaluateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EvaluateButton.onClick(evt, Layar);
            }
        });

        CosButton.setBackground(new java.awt.Color(0, 102, 51));
        CosButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        CosButton.setForeground(new java.awt.Color(255, 255, 255));
        CosButton.setToolTipText("");
        CosButton.setBorderPainted(false);
        CosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CosButton.onClick(evt, Layar);
            }
        });

        TanButton.setBackground(new java.awt.Color(0, 102, 51));
        TanButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        TanButton.setForeground(new java.awt.Color(255, 255, 255));
        TanButton.setToolTipText("");
        TanButton.setBorderPainted(false);
        TanButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TanButton.onClick(evt, Layar);
            }
        });

        ModButton.setBackground(new java.awt.Color(0, 51, 153));
        ModButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        ModButton.setForeground(new java.awt.Color(255, 255, 255));
        ModButton.setToolTipText("");
        ModButton.setBorderPainted(false);
        ModButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ModButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModButton.onClick(evt, Layar);
            }
        });

        LBracketButton.setBackground(new java.awt.Color(0, 153, 153));
        LBracketButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        LBracketButton.setForeground(new java.awt.Color(255, 255, 255));
        LBracketButton.setToolTipText("");
        LBracketButton.setBorderPainted(false);
        LBracketButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LBracketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LBracketButton.onClick(evt, Layar);
            }
        });

        RBracketButton.setBackground(new java.awt.Color(0, 153, 153));
        RBracketButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        RBracketButton.setForeground(new java.awt.Color(255, 255, 255));
        RBracketButton.setToolTipText("");
        RBracketButton.setBorderPainted(false);
        RBracketButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RBracketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RBracketButton.onClick(evt, Layar);
            }
        });

        SqrtButton.setBackground(new java.awt.Color(0, 153, 153));
        SqrtButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        SqrtButton.setForeground(new java.awt.Color(255, 255, 255));
        SqrtButton.setToolTipText("");
        SqrtButton.setBorderPainted(false);
        SqrtButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SqrtButton.setMaximumSize(new java.awt.Dimension(53, 33));
        SqrtButton.setMinimumSize(new java.awt.Dimension(53, 33));
        SqrtButton.setPreferredSize(new java.awt.Dimension(53, 33));
        SqrtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SqrtButton.onClick(evt, Layar);
            }
        });

        SquareButton.setBackground(new java.awt.Color(0, 102, 102));
        SquareButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        SquareButton.setForeground(new java.awt.Color(255, 255, 255));
        SquareButton.setToolTipText("");
        SquareButton.setBorderPainted(false);
        SquareButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SquareButton.setMaximumSize(new java.awt.Dimension(53, 33));
        SquareButton.setMinimumSize(new java.awt.Dimension(53, 33));
        SquareButton.setPreferredSize(new java.awt.Dimension(53, 33));
        SquareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SquareButton.onClick(evt, Layar);
            }
        });

        PowerButton.setBackground(new java.awt.Color(0, 102, 102));
        PowerButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        PowerButton.setForeground(new java.awt.Color(255, 255, 255));
        PowerButton.setToolTipText("");
        PowerButton.setBorderPainted(false);
        PowerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PowerButton.setMaximumSize(new java.awt.Dimension(53, 33));
        PowerButton.setMinimumSize(new java.awt.Dimension(53, 33));
        PowerButton.setPreferredSize(new java.awt.Dimension(53, 33));
        PowerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PowerButton.onClick(evt, Layar);
            }
        });

        AnsButton.setBackground(new java.awt.Color(102, 102, 102));
        AnsButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        AnsButton.setForeground(new java.awt.Color(255, 255, 255));
        AnsButton.setToolTipText("");
        AnsButton.setBorderPainted(false);
        AnsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AnsButton.onClick(evt, Layar);
            }
        });

        Sin1Button.setBackground(new java.awt.Color(0, 102, 51));
        Sin1Button.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Sin1Button.setForeground(new java.awt.Color(255, 255, 255));
        Sin1Button.setToolTipText("");
        Sin1Button.setBorderPainted(false);
        Sin1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Sin1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Sin1Button.onClick(evt, Layar);
            }
        });

        SinButton.setBackground(new java.awt.Color(0, 102, 51));
        SinButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        SinButton.setForeground(new java.awt.Color(255, 255, 255));
        SinButton.setToolTipText("");
        SinButton.setBorderPainted(false);
        SinButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SinButton.setMaximumSize(new java.awt.Dimension(53, 33));
        SinButton.setMinimumSize(new java.awt.Dimension(53, 33));
        SinButton.setPreferredSize(new java.awt.Dimension(53, 33));
        SinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SinButton.onClick(evt, Layar);
            }
        });

        Cos1Button.setBackground(new java.awt.Color(0, 102, 51));
        Cos1Button.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Cos1Button.setForeground(new java.awt.Color(255, 255, 255));
        Cos1Button.setToolTipText("");
        Cos1Button.setBorderPainted(false);
        Cos1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cos1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Cos1Button.onClick(evt, Layar);
            }
        });

        Tan1Button.setBackground(new java.awt.Color(0, 102, 51));
        Tan1Button.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Tan1Button.setForeground(new java.awt.Color(255, 255, 255));
        Tan1Button.setToolTipText("");
        Tan1Button.setBorderPainted(false);
        Tan1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tan1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Tan1Button.onClick(evt, Layar);
            }
        });

        DelButton.setBackground(new java.awt.Color(102, 102, 102));
        DelButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        DelButton.setForeground(new java.awt.Color(255, 255, 255));
        DelButton.setBorderPainted(false);
        DelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DelButton.onClick(evt, Layar);
            }
        });

        LogButton.setBackground(new java.awt.Color(0, 153, 153));
        LogButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        LogButton.setForeground(new java.awt.Color(255, 255, 255));
        LogButton.setToolTipText("");
        LogButton.setBorderPainted(false);
        LogButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LogButton.onClick(evt, Layar);
            }
        });

        Layar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        Layar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Layar.setToolTipText("");
        Layar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout PanelLayarLayout = new javax.swing.GroupLayout(PanelLayar);
        PanelLayar.setLayout(PanelLayarLayout);
        PanelLayarLayout.setHorizontalGroup(
            PanelLayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Layar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelLayarLayout.setVerticalGroup(
            PanelLayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Layar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Num00.setBackground(new java.awt.Color(51, 51, 51));
        Num00.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        Num00.setForeground(new java.awt.Color(255, 255, 255));
        
        Num00.setBorderPainted(false);
        Num00.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Num00.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num00.onClick(evt, Layar);
            }
        });

        LnButton.setBackground(new java.awt.Color(0, 153, 153));
        LnButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        LnButton.setForeground(new java.awt.Color(255, 255, 255));
        LnButton.setText("ln");
        LnButton.setToolTipText("");
        LnButton.setBorderPainted(false);
        LnButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LnButton.onClick(evt, Layar);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(DotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Num0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Num00, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SqrtButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EvaluateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(Num7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Num8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Num9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MulButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RBracketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addComponent(Num1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Num2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Num3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addComponent(Num4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Num5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Num6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(CosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cos1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(TanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tan1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(SquareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PowerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(PanelLayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AnsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(ModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(MCButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBracketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sin1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelLayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MCButton)
                    .addComponent(MRButton)
                    .addComponent(ModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AnsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LBracketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Sin1Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Num9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MulButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Num8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Num7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RBracketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Cos1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(Tan1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(PowerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Num4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Num5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Num6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Num3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Num2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Num1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SquareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EvaluateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num00, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SqrtButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        Num1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            java.util.logging.Logger.getLogger(CalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalcForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalcForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
}
