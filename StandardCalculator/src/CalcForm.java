import data.expression.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import java.util.*; 
import java.util.logging.*;

import data.exception.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class CalcForm extends JFrame {

    /**
     * Creates new form CalcForm
     */
    public CalcForm() {
        initComponents();
    }
    private String delqueue;
    // private Token token;
    // private Token ans;
    private Queue<String> MCqueue = new LinkedList<>();
    private void initComponents() {
        // Queue<String> MCqueue = new LinkedList<>();
        Token token = new Token();
        Token ans = new Token();
        //Calc button
        JPanel PanelLayar = new JPanel();
        JPanel MainPanel = new JPanel();
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
        BinaryOpsButton MulButton = new BinaryOpsButton("*");
        BinaryOpsButton DivButton = new BinaryOpsButton("/");
        BinaryOpsButton NegButton = new BinaryOpsButton("-");
        BinaryOpsButton PlusButton = new BinaryOpsButton("+");
        BinaryOpsButton ModButton = new BinaryOpsButton("%");
        UnaryOpsButton CosButton = new UnaryOpsButton("cos");
        UnaryOpsButton TanButton = new UnaryOpsButton("tan");
        UnaryOpsButton LBracketButton = new UnaryOpsButton("(");
        UnaryOpsButton RBracketButton = new UnaryOpsButton(")");
        UnaryOpsButton SqrtButton = new UnaryOpsButton("sqrt");
        SupButton SquareButton = new SupButton("<html>x<sup>2</sup></html>", "^2");        
        SupButton PowerButton = new SupButton("<html>x<sup>y</sup></html>", "^");
        SupButton Sin1Button = new SupButton("<html>sin<sup>-1</sup></html>", "arcsin");
        SupButton Cos1Button = new SupButton("<html>cos<sup>-1</sup></html>", "arccos");
        SupButton Tan1Button = new SupButton("<html>tan<sup>-1</sup></html>", "arctan");
        UnaryOpsButton SinButton = new UnaryOpsButton("sin");
        UnaryOpsButton LogButton = new UnaryOpsButton("log");
        UnaryOpsButton LnButton = new UnaryOpsButton("ln");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setLocation(new Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        MainPanel.setBackground(new Color(51, 51, 51));
        MainPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        MainPanel.setPreferredSize(new Dimension(348, 452));

        ClearButton.setBackground(new Color(102, 102, 102));
        ClearButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        ClearButton.setForeground(new Color(255, 255, 255));
        ClearButton.setBorderPainted(false);
        ClearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ClearButton.onClick(evt, Layar, token);
                token.deleteAll();
                while(!MCqueue.isEmpty()){
                    delqueue = MCqueue.poll();
                }
                Layar.setText("");
            }
        });

        MCButton.setBackground(new Color(0, 153, 255));
        MCButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        MCButton.setForeground(new Color(255, 255, 255));
        MCButton.setToolTipText("");
        MCButton.setBorderPainted(false);
        MCButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MCButton.onClick(evt, Layar,token);
                MCqueue.add(ans.convertToString());
            }
        });

        MRButton.setBackground(new Color(0, 153, 255));
        MRButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        MRButton.setForeground(new Color(255, 255, 255));
        MRButton.setToolTipText("");
        MRButton.setBorderPainted(false);
        MRButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MRButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MRButton.onClick(evt, Layar, token);
                if (!MCqueue.isEmpty()){
                    delqueue = MCqueue.poll();
                    token.addToToken(delqueue);
                    Layar.setText(token.convertToString());
                    MCqueue.add(delqueue);
                }
            }
        });

        MulButton.setBackground(new Color(0, 51, 153));
        MulButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        MulButton.setForeground(new Color(255, 255, 255));
        MulButton.setToolTipText("");
        MulButton.setBorderPainted(false);
        MulButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (token.isEmpty() && !ans.isEmpty()){
                    token.addToToken(ans.convertToString());
                }
                MulButton.onClick(evt, Layar,token);
            }
        });

        Num7.setBackground(new Color(51, 51, 51));
        Num7.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num7.setForeground(new Color(255, 255, 255));
        Num7.setToolTipText("");
        Num7.setBorderPainted(false);
        Num7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num7.onClick(evt, Layar, token);
            }
        });

        Num8.setBackground(new Color(51, 51, 51));
        Num8.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num8.setForeground(new Color(255, 255, 255));
        Num8.setToolTipText("");
        Num8.setBorderPainted(false);
        Num8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num8.onClick(evt, Layar, token);
            }
        });

        Num9.setBackground(new Color(51, 51, 51));
        Num9.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num9.setForeground(new Color(255, 255, 255));
        Num9.setToolTipText("");
        Num9.setBorderPainted(false);
        Num9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num9.onClick(evt, Layar, token);
            }
        });

        DivButton.setBackground(new Color(0, 51, 153));
        DivButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        DivButton.setForeground(new Color(255, 255, 255));
        DivButton.setToolTipText("");
        DivButton.setBorderPainted(false);
        DivButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (token.isEmpty() && !ans.isEmpty()){
                    token.addToToken(ans.convertToString());
                }
                DivButton.onClick(evt, Layar, token);
            }
        });

        Num4.setBackground(new Color(51, 51, 51));
        Num4.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num4.setForeground(new Color(255, 255, 255));
        Num4.setBorderPainted(false);
        Num4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num4.onClick(evt, Layar, token);
            }
        });

        Num5.setBackground(new Color(51, 51, 51));
        Num5.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num5.setForeground(new Color(255, 255, 255));
        Num5.setBorderPainted(false);
        Num5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num5.onClick(evt, Layar, token);
            }
        });

        Num6.setBackground(new Color(51, 51, 51));
        Num6.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num6.setForeground(new Color(255, 255, 255));
        Num6.setBorderPainted(false);
        Num6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num6.onClick(evt, Layar, token);
            }
        });

        NegButton.setBackground(new Color(0, 51, 153));
        NegButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        NegButton.setForeground(new Color(255, 255, 255));
        NegButton.setToolTipText("");
        NegButton.setBorderPainted(false);
        NegButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (token.isEmpty() && !ans.isEmpty()){
                    token.addToToken(ans.convertToString());
                }
                NegButton.onClick(evt, Layar, token);
            }
        });

        Num1.setBackground(new Color(51, 51, 51));
        Num1.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num1.setForeground(new Color(255, 255, 255));
        Num1.setBorderPainted(false);
        Num1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num1.onClick(evt, Layar, token);
            }
        });

        Num2.setBackground(new Color(51, 51, 51));
        Num2.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num2.setForeground(new Color(255, 255, 255));
        Num2.setBorderPainted(false);
        Num2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num2.onClick(evt, Layar, token);
            }
        });

        Num3.setBackground(new Color(51, 51, 51));
        Num3.setFont(new Font("Segoe UI Semilight", 0, 14));
        Num3.setForeground(new Color(255, 255, 255));
        Num3.setBorderPainted(false);
        Num3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num3.onClick(evt, Layar, token);
            }
        });

        PlusButton.setBackground(new Color(0, 51, 153));
        PlusButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        PlusButton.setForeground(new Color(255, 255, 255));
        PlusButton.setText("+");
        PlusButton.setToolTipText("");
        PlusButton.setBorderPainted(false);
        PlusButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PlusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (token.isEmpty() && !ans.isEmpty()){
                    token.addToToken(ans.convertToString());
                }
                PlusButton.onClick(evt, Layar, token);
            }
        });

        DotButton.setBackground(new Color(51, 51, 51));
        DotButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        DotButton.setForeground(new Color(255, 255, 255));
        DotButton.setBorderPainted(false);
        DotButton.setPreferredSize(new Dimension(39, 29));
        DotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DotButton.onClick(evt, Layar, token);
            }
        });

        Num0.setBackground(new Color(51, 51, 51));
        Num0.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num0.setForeground(new Color(255, 255, 255));
        Num0.setBorderPainted(false);
        Num0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num0.onClick(evt, Layar, token);
            }
        });

        EvaluateButton.setBackground(new Color(255, 102, 0));
        EvaluateButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        EvaluateButton.setForeground(new Color(255, 255, 255));
        EvaluateButton.setBorderPainted(false);
        EvaluateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        EvaluateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EvaluateButton.onClick(evt, Layar, token);
                Token T = new Token();
                String inString;
                inString = token.convertToString();
                Expression<Double> outExp = null;
                ExpressionParser ed = new ExpressionParser();
                try {
                    // outExp = parse("5+2*3/2-3.9");
                    outExp = ed.parse(inString);
                    if (outExp.solve() - (int)Math.round(outExp.solve()) == 0){
                        T.addToToken(Integer.toString((int)Math.round(outExp.solve())));
                    } else{
                        T.addToToken(Double.toString(outExp.solve()));
                    }
                    token.setToken(T);
                    
                    Layar.setText(token.convertToString());
                }catch(InvalidOperandException err){
                    String error = err.PrintMessage();
                    Layar.setText(error);
                }catch(NotANumberException err){
                    String error = err.PrintMessage();
                    Layar.setText(error);
                }catch (Exception err) {
                    // TODO Auto-generated catch block
                    // err.printStackTrace();
                }
                ans.deleteAll();
                String answer;
                answer = token.deleteFromBack();
                ans.addToToken(answer);
            }
        });

        CosButton.setBackground(new Color(0, 102, 51));
        CosButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        CosButton.setForeground(new Color(255, 255, 255));
        CosButton.setToolTipText("");
        CosButton.setBorderPainted(false);
        CosButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        CosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CosButton.onClick(evt, Layar, token);
            }
        });

        TanButton.setBackground(new Color(0, 102, 51));
        TanButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        TanButton.setForeground(new Color(255, 255, 255));
        TanButton.setToolTipText("");
        TanButton.setBorderPainted(false);
        TanButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        TanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TanButton.onClick(evt, Layar, token);
            }
        });

        ModButton.setBackground(new Color(0, 51, 153));
        ModButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        ModButton.setForeground(new Color(255, 255, 255));
        ModButton.setToolTipText("");
        ModButton.setBorderPainted(false);
        ModButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ModButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModButton.onClick(evt, Layar, token);
            }
        });

        LBracketButton.setBackground(new Color(0, 153, 153));
        LBracketButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        LBracketButton.setForeground(new Color(255, 255, 255));
        LBracketButton.setToolTipText("");
        LBracketButton.setBorderPainted(false);
        LBracketButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LBracketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LBracketButton.onClick(evt, Layar, token);
            }
        });

        RBracketButton.setBackground(new Color(0, 153, 153));
        RBracketButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        RBracketButton.setForeground(new Color(255, 255, 255));
        RBracketButton.setToolTipText("");
        RBracketButton.setBorderPainted(false);
        RBracketButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        RBracketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RBracketButton.onClick(evt, Layar, token);
            }
        });

        SqrtButton.setBackground(new Color(0, 153, 153));
        SqrtButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        SqrtButton.setForeground(new Color(255, 255, 255));
        SqrtButton.setToolTipText("");
        SqrtButton.setBorderPainted(false);
        SqrtButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SqrtButton.setMaximumSize(new Dimension(53, 33));
        SqrtButton.setMinimumSize(new Dimension(53, 33));
        SqrtButton.setPreferredSize(new Dimension(53, 33));
        SqrtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SqrtButton.onClick(evt, Layar, token);
            }
        });

        SquareButton.setBackground(new Color(0, 102, 102));
        SquareButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        SquareButton.setForeground(new Color(255, 255, 255));
        SquareButton.setToolTipText("");
        SquareButton.setBorderPainted(false);
        SquareButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SquareButton.setMaximumSize(new Dimension(53, 33));
        SquareButton.setMinimumSize(new Dimension(53, 33));
        SquareButton.setPreferredSize(new Dimension(53, 33));
        SquareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SquareButton.onClick(evt, Layar, token);
            }
        });

        PowerButton.setBackground(new Color(0, 102, 102));
        PowerButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        PowerButton.setForeground(new Color(255, 255, 255));
        PowerButton.setToolTipText("");
        PowerButton.setBorderPainted(false);
        PowerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PowerButton.setMaximumSize(new Dimension(53, 33));
        PowerButton.setMinimumSize(new Dimension(53, 33));
        PowerButton.setPreferredSize(new Dimension(53, 33));
        PowerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PowerButton.onClick(evt, Layar, token);
            }
        });

        AnsButton.setBackground(new Color(102, 102, 102));
        AnsButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        AnsButton.setForeground(new Color(255, 255, 255));
        AnsButton.setToolTipText("");
        AnsButton.setBorderPainted(false);
        AnsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        AnsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AnsButton.onClick(evt, Layar, token);
                Layar.setText(token.convertToString() + "Ans");
                token.addToToken(ans.convertToString());
            }
        });

        Sin1Button.setBackground(new Color(0, 102, 51));
        Sin1Button.setFont(new Font("Segoe UI Semilight", 0, 13));
        Sin1Button.setForeground(new Color(255, 255, 255));
        Sin1Button.setToolTipText("");
        Sin1Button.setBorderPainted(false);
        Sin1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Sin1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Sin1Button.onClick(evt, Layar, token);
            }
        });

        SinButton.setBackground(new Color(0, 102, 51));
        SinButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        SinButton.setForeground(new Color(255, 255, 255));
        SinButton.setToolTipText("");
        SinButton.setBorderPainted(false);
        SinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        SinButton.setMaximumSize(new Dimension(53, 33));
        SinButton.setMinimumSize(new Dimension(53, 33));
        SinButton.setPreferredSize(new Dimension(53, 33));
        SinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SinButton.onClick(evt, Layar, token);
            }
        });

        Cos1Button.setBackground(new Color(0, 102, 51));
        Cos1Button.setFont(new Font("Segoe UI Semilight", 0, 13));
        Cos1Button.setForeground(new Color(255, 255, 255));
        Cos1Button.setToolTipText("");
        Cos1Button.setBorderPainted(false);
        Cos1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Cos1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Cos1Button.onClick(evt, Layar, token);
            }
        });

        Tan1Button.setBackground(new Color(0, 102, 51));
        Tan1Button.setFont(new Font("Segoe UI Semilight", 0, 13));
        Tan1Button.setForeground(new Color(255, 255, 255));
        Tan1Button.setToolTipText("");
        Tan1Button.setBorderPainted(false);
        Tan1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Tan1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Tan1Button.onClick(evt, Layar, token);
            }
        });

        DelButton.setBackground(new Color(102, 102, 102));
        DelButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        DelButton.setForeground(new Color(255, 255, 255));
        DelButton.setBorderPainted(false);
        DelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DelButton.onClick(evt, Layar, token);
            }
        });

        LogButton.setBackground(new Color(0, 153, 153));
        LogButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        LogButton.setForeground(new Color(255, 255, 255));
        LogButton.setToolTipText("");
        LogButton.setBorderPainted(false);
        LogButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LogButton.onClick(evt, Layar, token);
            }
        });

        Num00.setBackground(new Color(51, 51, 51));
        Num00.setFont(new Font("Segoe UI Semilight", 0, 13));
        Num00.setForeground(new Color(255, 255, 255));
        Num00.setBorderPainted(false);
        Num00.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Num00.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Num00.onClick(evt, Layar, token);
            }
        });

        LnButton.setBackground(new Color(0, 153, 153));
        LnButton.setFont(new Font("Segoe UI Semilight", 0, 13));
        LnButton.setForeground(new Color(255, 255, 255));
        LnButton.setText("ln");
        LnButton.setToolTipText("");
        LnButton.setBorderPainted(false);
        LnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LnButton.onClick(evt, Layar, token);
            }
        });

        Layar.setFont(new Font("Segoe UI Semilight", 0, 36));
        Layar.setHorizontalAlignment(SwingConstants.RIGHT);
        Layar.setToolTipText("");
        Layar.setVerticalAlignment(SwingConstants.BOTTOM);

        GroupLayout PanelLayarLayout = new GroupLayout(PanelLayar);
        PanelLayar.setLayout(PanelLayarLayout);
        PanelLayarLayout.setHorizontalGroup(
            PanelLayarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(Layar, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelLayarLayout.setVerticalGroup(
            PanelLayarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Layar, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout MainPanelLayout = new GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(DotButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Num0, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Num00, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SqrtButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EvaluateButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(Num7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Num8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Num9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MulButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RBracketButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addComponent(Num1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Num2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Num3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PlusButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addComponent(Num4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Num5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Num6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NegButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(LogButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LnButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(CosButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cos1Button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(TanButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tan1Button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(SquareButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PowerButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
                    .addComponent(PanelLayar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(ClearButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AnsButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DelButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DivButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(MCButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MRButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBracketButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SinButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sin1Button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelLayar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(MCButton)
                    .addComponent(MRButton))
                .addGap(4, 4, 4)
                .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, MainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ClearButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(DivButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AnsButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(SinButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(DelButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(LBracketButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    .addComponent(Sin1Button, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Num9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(MulButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Num8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Num7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(CosButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(RBracketButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    .addComponent(Cos1Button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(Tan1Button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(PowerButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Num4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Num5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Num6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(NegButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TanButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(PlusButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Num3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Num2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Num1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addComponent(LnButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addComponent(SquareButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(DotButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num0, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    .addComponent(EvaluateButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Num00, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    .addComponent(SqrtButton, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        Num1.getAccessibleContext().setAccessibleDescription("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(MainPanel, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalcForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CalcForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CalcForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CalcForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalcForm().setVisible(true);
            }
        });
    }
}
