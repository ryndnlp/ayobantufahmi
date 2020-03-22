package token;

public class Token {
    private String[] text_set;
    private int idx;

    public Token(){
        text_set = new String[100];
        idx = 0;
    }
    public boolean isEmpty(){
        return (idx==0);
    }
    public void addToToken(String s){
        //Text with <html> cannot be concat with another stirng
        if (s.equals("<html>x<sup>2</sup></html>")){
            text_set[idx] = "^";
            idx++;
            text_set[idx] = "2";
        } else if (s.equals("<html>x<sup>y</sup></html>")){
            text_set[idx] = "^";
        } else if (s.equals("<html>sin<sup>-1</sup></html>")){
            text_set[idx] = "arcsin";
        } else if (s.equals("<html>cos<sup>-1</sup></html>")){
            text_set[idx] = "arccos";
        } else if (s.equals("<html>tan<sup>-1</sup></html>")){
            text_set[idx] = "arctan";
        } else{
            text_set[idx] = s;
        }

        idx++;
    }
    public String deleteFromBack(){
        String T;
        if (!isEmpty()){
            T = text_set[idx-1];
            idx--;    
        } else {
            T = "";
        }
        return T;
    }
    public String convertToString(){
        String text = "";
        for (int i = 0; i < idx; i++){
            text += text_set[i];
        }
        return text;
    }
    public void setToken(Token T){
        idx = 0;
        for (int i = 0; i < text_set.length ; i++){
            this.text_set[i] = T.text_set[i];
            if (T.text_set[i] != null){
                idx++;
            }
        }
    }
    public void deleteAll(){
        String T;
        while (!this.isEmpty()){
            T = this.deleteFromBack();
        }
    }
}