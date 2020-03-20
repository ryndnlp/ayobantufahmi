using java.util;

abstract class memoryButton extends javax.swing.JButton{
    abstract public void storage();
}

abstract class numberButton extends javax.swing.JButton{
    abstract public void number();
}

abstract class operandButton extends javax.swing.JButton{
    abstract public void operand();
}

class oneButton extends numberButton{
    public void number(){
        stack.push("1");
    }
}

class twoButton extends numberButton{
    public void number(){
        stack.push("2");
    }
}

class threeButton extends numberButton{
    public void number(){
        stack.push("3");
    }
}

class fourButton extends numberButton{
    public void number(){
        stack.push("4");
    }
}

class fiveButton extends numberButton{
    public void number(){
        stack.push("5");
    }
}

class sixButton extends numberButton{
    public void number(){
        stack.push("6");
    }
}

class sevenButton extends numberButton{
    public void number(){
        stack.push("7");
    }
}

class eightButton extends numberButton{
    public void number(){
        stack.push("8");
    }
}

class nineButton extends numberButton{
    public void number(){
        stack.push("9");
    }
}

class zeroButton extends numberButton{
    public void number(){
        stack.push("0");
    }
}

class plusButton extends operandButton{
    public void operand(){
        stack.push("+");
    }
}

class minusButton extends operandButton{
    public void operand(){
        stack.push("-");
    }
}

class timesButton extends operandButton{
    public void operand(){
        stack.push("*");
    }
}

class divisionButton extends operandButton{
    public void operand(){  
        stack.push("/");
    }
}

class powerToButton extends operandButton{
    public void operand(){  
        stack.push("^");
    }
}

class sinButton extends operandButton{
    public void operand(){  
        stack.push("sin");
    }
}

class cosButton extends operandButton{
    public void operand(){  
        stack.push("cos");
    }
}

class tanButton extends operandButton{
    public void operand(){  
        stack.push("tan");
    }
}
class ACosButton extends operandButton{
    public void operand(){  
        stack.push("acos");
    }
}

class ASinButton extends operandButton{
    public void operand(){  
        stack.push("asin");
    }
}

class ATanButton extends operandButton{
    public void operand(){  
        stack.push("tan");
    }
}

class logButton extends operandButton{
    public void operand(){  
        stack.push("log");
    }
}
class rootButton extends operandButton{
    public void operand(){  
        stack.push("sqrt");
    }
}

class ansButton extends operandButton{
    public void store(string form){
        form.solve();
    }
}

class mrButton extends memoryButton{
    public void store(){
        queue1.add();
    }
}

class mcButton extends memoryButton{
    public void store(){
        int temp = queue1.remove();
        stack.push(temp);
    }
}







