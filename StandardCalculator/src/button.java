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
        stack.push(1);
    }
}

class twoButton extends numberButton{
    public void number(){
        stack.push(2);
    }
}

class threeButton extends numberButton{
    public void number(){
        stack.push(3);
    }
}

class fourButton extends numberButton{
    public void number(){
        stack.push(4);
    }
}

class fiveButton extends numberButton{
    public void number(){
        stack.push(5);
    }
}

class sixButton extends numberButton{
    public void number(){
        stack.push(6);
    }
}

class sevenButton extends numberButton{
    public void number(){
        stack.push(7);
    }
}

class eightButton extends numberButton{
    public void number(){
        stack.push(8);
    }
}

class nineButton extends numberButton{
    public void number(){
        stack.push(9);
    }
}

class zeroButton extends numberButton{
    public void number(){
        stack.push(0);
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
        stack.push("x");
    }
}

class plusButton extends operandButton{
    public void operand(){  
        stack.push("+");
    }
}

class cosButton extends operandButton{
    public void operand(){  
        stack.push("+");
    }
}

class sineButton extends operandButton{
    public void operand(){  
        stack.push("+");
    }
}

class tanButton extends operandButton{
    public void operand(){  
        stack.push("+");
    }
}

class logButton extends operandButton{
    public void operand(){  
        stack.push();
    }
}
class rootButton extends operandButton{
    public void operand(){  
        stack.push();
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

class ansButton extends memoryButton{
    public void store(){
        solve();
    }
}





