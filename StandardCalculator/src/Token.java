public class Token {
    private String[] text_set;
    private int idx;

    public Token(){
        text_set = new String[100];
        int idx = 0;
    }
    public void addToToken(String s){
        text_set[idx] = s;
        idx++;
    }
    public String deleteFromBack(){
        String T;
        T = text_set[idx];
        if (idx > 0){
            idx--;    
        }
        return T;
    }
    public String convertToString(){
        String text = "";
        for (int i = 0; i < idx; i++){
            text += text_set[i];
            // if (i != idx - 1){
            //     text += " ";
            // }
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
        for (int i = 0; i < text_set.length ; i++){
            this.text_set[i] = null;
        }
        idx = 0;
    }
}